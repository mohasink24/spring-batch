package com.izak.projects.springbatch.repository;

import com.izak.projects.springbatch.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRespository extends CrudRepository<Student, Long> {
}
