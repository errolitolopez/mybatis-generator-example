package com.example.demo;

import com.example.demo.service.UserService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import javax.annotation.Resource;

@ComponentScan("com.example.*")
@MapperScan("com.example.demo.dao")
@SpringBootApplication
public class BootApplication implements CommandLineRunner {

    @Resource
    private UserService userService;

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        userService.save("Maria Jones");
        userService.save("James Bond");
        userService.list().forEach(u -> System.out.println(u.getName()));
    }
}
