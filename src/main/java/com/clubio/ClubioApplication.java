package com.clubio;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
@EnableKnife4j
@MapperScan(value = "com.clubio.mapper")
public class ClubioApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClubioApplication.class, args);
    }

}
