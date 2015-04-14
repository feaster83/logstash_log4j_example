package nl.jasperhuzen.exampleapp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@EnableScheduling
@SpringBootApplication
public class ExampleApp {

    static {
        System.setProperty("logging.config", "log4j.properties");
    }

    public static void main(String[] args) {
        SpringApplication.run(ExampleApp.class, args);
    }

    protected ExampleApp() {
        log.info("Example app started");
    }
}
