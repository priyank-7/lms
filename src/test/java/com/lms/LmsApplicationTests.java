package com.lms;

import com.lms.Repositories.StudentRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LmsApplicationTests {

    @Autowired
    private StudentRepository studentRepository;
    @Test
    void contextLoads() {
        System.out.println(studentRepository.findAll());

    }

}
