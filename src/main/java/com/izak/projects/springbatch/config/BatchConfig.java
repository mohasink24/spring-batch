package com.izak.projects.springbatch.config;

import com.izak.projects.springbatch.entity.Student;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.json.JacksonJsonObjectReader;
import org.springframework.batch.item.json.builder.JsonItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class BatchConfig {

    /*@Bean
    public Job job(JobRepository jobRepository) {
        return new JobBuilder("job", jobRepository)
                .start(step1())
                .build();
    }*/


    /**
     * Note the JobRepository is typically autowired in and not needed to be explicitly
     * configured
     */
    @Bean
    public Job sampleJob(JobRepository jobRepository, Step sampleStep) {
        return new JobBuilder("sampleJob", jobRepository).start(sampleStep).build();
    }

    /**
     * Note the TransactionManager is typically autowired in and not needed to be explicitly
     * configured
     */
    @Bean
    public Step sampleStep(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("studentProcessor", jobRepository).<Student, Student>chunk(10, transactionManager).reader(jsonItemReader()).writer(itemWriter()).build();
    }

    @Bean
    public ItemReader<Student> jsonItemReader() {
        return new JsonItemReaderBuilder<Student>().jsonObjectReader(new JacksonJsonObjectReader<>(Student.class)).resource(new ClassPathResource("students.json")).name("studentJsonItemReader").build();
    }

    @Bean
    public ItemWriter<Student> itemWriter() {
        return new StudentWriter();
    }

}
