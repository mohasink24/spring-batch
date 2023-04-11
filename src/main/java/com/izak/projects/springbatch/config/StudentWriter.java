package com.izak.projects.springbatch.config;

import com.izak.projects.springbatch.entity.Student;
import com.izak.projects.springbatch.repository.StudentRespository;
import org.springframework.batch.item.Chunk;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

public class StudentWriter implements ItemWriter<Student> {

    @Autowired
    private StudentRespository studentRespository;

    @Override
    public void write(Chunk<? extends Student> chunk) throws Exception {
        studentRespository.saveAll(chunk);
    }
}