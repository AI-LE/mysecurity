package com.aile.mysecurity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MysecurityApplication {

    public static void main(String[] args) {
//        String md5Password = DigestUtils.md5DigestAsHex("admin".getBytes());
        SpringApplication.run(MysecurityApplication.class, args);
    }

}
