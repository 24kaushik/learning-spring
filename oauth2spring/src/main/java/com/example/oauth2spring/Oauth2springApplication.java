package com.example.oauth2spring;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Oauth2springApplication {

    public static void main(String[] args) {
        Dotenv dotenv = Dotenv.configure().ignoreIfMissing().load();

        dotenv.entries().forEach((dotenvEntry -> System.setProperty(dotenvEntry.getKey(), dotenvEntry.getValue())));

        SpringApplication.run(Oauth2springApplication.class, args);
    }

}
