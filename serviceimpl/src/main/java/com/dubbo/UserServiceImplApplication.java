package com.dubbo;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@EnableDubbo
@SpringBootApplication
@MapperScan("com.dubbo.mapper")
public class UserServiceImplApplication {
    public static void main(String[] args) {
        SpringApplication.run(UserServiceImplApplication.class,args);
    }
}
