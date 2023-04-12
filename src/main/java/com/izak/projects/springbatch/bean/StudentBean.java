package com.izak.projects.springbatch.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Student sample bean
 *
 * @author Mohasin Kazi
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentBean {

    private String firstName;

    private String lastName;

    private String address;

}
