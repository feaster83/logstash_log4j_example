package nl.jasperhuzen.exampleapp.generator;

import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Slf4j
@Component
@SuppressWarnings("unused")
public class ExceptionGenerator {
    private Random random = new Random();

    @PostConstruct
    private void initialized() {
        log.info(this.getClass().getName() + " created.");
    }

    @Scheduled(initialDelay = 3000, fixedRate = 250)
    public void generateExceptions() {
        int randomNumber1 = random.nextInt(10);
        int randomNumber2 = random.nextInt(10);
        int randomNumber3 = random.nextInt(10);
        if (randomNumber1 == randomNumber2 && randomNumber2 == randomNumber3) {
            String msg = String.format("Numbers are equal with a value of %s", randomNumber1);
            log.error(msg, new NumbersEqualException(msg));
        }
    }

    private class NumbersEqualException extends RuntimeException {
        private NumbersEqualException(String message) {
            super(message);
        }
    }
}
