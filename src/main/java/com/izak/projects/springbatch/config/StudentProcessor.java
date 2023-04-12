package com.izak.projects.springbatch.config;

import com.izak.projects.springbatch.entity.Student;
import lombok.extern.log4j.Log4j2;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class StudentProcessor implements ItemProcessor<Student, Student> {

    @Override
    public Student process(final Student student) {
        /*String brand = student.getBrand().toUpperCase();
        String origin = student.getOrigin().toUpperCase();
        String chracteristics = student.getCharacteristics().toUpperCase();

        Student transformedStudent = new Student(brand, origin, chracteristics);
        log.info("Converting ( {} ) into ( {} )", student, transformedStudent);*/
        return new Student();
    }
}