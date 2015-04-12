package nl.jasperhuzen.exampleapp.generator;

import lombok.extern.slf4j.Slf4j;
import nl.jasperhuzen.exampleapp.Config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Slf4j
@Component
@SuppressWarnings("unused")
public class HelloLogGenerator {

    @Autowired
    private Config config;

    @PostConstruct
    private void initialized() {
        log.info(this.getClass().getName() + " created.");
    }

    @Scheduled(initialDelay = 3000, fixedRate = 5000)
    public void generateHelloLogs() {
        log.info("Hello {}, how are you doing?", config.getSystemUser());
    }

}
