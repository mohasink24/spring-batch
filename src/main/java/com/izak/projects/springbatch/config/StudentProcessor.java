package com.izak.projects.springbatch.config;

import com.izak.projects.springbatch.bean.StudentBean;
import com.izak.projects.springbatch.entity.Student;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.BeanUtils;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Log4j2
@Component
public class StudentProcessor implements ItemProcessor<StudentBean, Student> {


    @Override
    public Student process(@Nullable final StudentBean studentBean) {
        if (Objects.isNull(studentBean)) {
            return null;
        }
        Student student = new Student();
        BeanUtils.copyProperties(studentBean, student);
        return student;
    }
}