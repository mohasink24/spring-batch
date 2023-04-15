package com.izak.projects.springbatch.repository;

import com.izak.projects.springbatch.entity.Student;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Student Repository
 *
 * @author Mohasin Kazi
 */
@Repository
public interface StudentRepository extends CrudRepository<Student, Long> {

}
