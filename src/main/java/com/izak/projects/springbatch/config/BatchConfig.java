package com.izak.projects.springbatch.config;

import com.izak.projects.springbatch.bean.StudentBean;
import com.izak.projects.springbatch.entity.Student;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
//@EnableBatchProcessing
public class BatchConfig {

    @Autowired
    private StudentProcessor studentProcessor;


    /**
     * Note the JobRepository is typically autowired in and not needed to be explicitly
     * configured
     */
    @Bean
    public Job sampleJob(JobRepository jobRepository, Step sampleJob) {
        return new JobBuilder("sampleJob", jobRepository)
                .start(sampleJob)
                .build();
    }

    /**
     * Note the TransactionManager is typically autowired in and not needed to be explicitly
     * configured
     */
    @Bean
    public Step sampleStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("studentProcessor", jobRepository)
                .<StudentBean, Student>chunk(10, transactionManager)
                .reader(jsonItemReader())
                .writer(itemWriter())
                .processor(studentProcessor)
                .build();
    }

    @Bean
    public ItemReader<StudentBean> jsonItemReader() {
        return new JsonItemReaderBuilder<StudentBean>()
                .jsonObjectReader(new JacksonJsonObjectReader<>(StudentBean.class))
                .resource(new ClassPathResource("Students.json"))
                .name("studentJsonItemReader")
//                .saveState(true)
                .build();
    }

    @Bean
    public ItemWriter<Student> itemWriter() {
        return new StudentWriter();
    }

}
