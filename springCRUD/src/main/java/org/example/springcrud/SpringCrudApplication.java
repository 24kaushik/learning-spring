package org.example.springcrud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.jdbc.autoconfigure.DataSourceAutoConfiguration;

@SpringBootApplication
public class SpringCrudApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCrudApplication.class, args);
    }

}
