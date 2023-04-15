package com.izak.projects.springbatch.config;

import com.izak.projects.springbatch.entity.Student;
import com.izak.projects.springbatch.repository.StudentRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Student sample bean
 *
 * @author Mohasin Kazi
 */

@Log4j2
public class StudentWriter implements ItemWriter<Student> {

    @Autowired
    private StudentRepository studentRespository;

    @Override
    public void write(Chunk<? extends Student> chunk) {
        log.info("Writing students batch size: {}", chunk.size());
        studentRespository.saveAll(chunk);
    }
}