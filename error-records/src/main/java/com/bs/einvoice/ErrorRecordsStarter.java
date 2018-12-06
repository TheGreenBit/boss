package com.bs.einvoice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication(scanBasePackages = {"com.bs.einvoice"})
public class ErrorRecordsStarter {

    Logger logger = LoggerFactory.getLogger(getClass());

    public static void main(String[] args) {
        SpringApplication.run(ErrorRecordsStarter.class, args);
    }


    @Bean
    public CommandLineRunner commandLineRunner(final ApplicationContext applicationContext) {
        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                String[] beanDefinitionNames = applicationContext.getBeanDefinitionNames();
                for (String name : beanDefinitionNames) {
                    logger.info("注入的bean 名称为：{}", name);
                }
            }
        };

    }
}
