package com.tsingyun.hpvm.collect.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Created by zhangzl on 2017/2/7.
 */
@SpringBootApplication
@EnableCaching
@EntityScan("com.tsingyun.hpvm")
@EnableJpaRepositories("com.tsingyun.hpvm")
@ComponentScan("com.tsingyun.hpvm")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

