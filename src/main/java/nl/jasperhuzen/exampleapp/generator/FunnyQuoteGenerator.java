package nl.jasperhuzen.exampleapp.generator;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Random;

@Slf4j
@Component
@SuppressWarnings("unused")
public class FunnyQuoteGenerator {
    private Random random = new Random();

    @PostConstruct
    private void initialized() {
        log.info(this.getClass().getName() + " created.");
    }

    @Scheduled(initialDelay = 3000, fixedRate = 2000)
    public void generateFunnyMessages() {
        int randomNumber = random.nextInt(FUNNY_MESSAGES.values().length);
        log.debug(FUNNY_MESSAGES.values()[randomNumber].getMessage());
    }

    @Getter
    private enum FUNNY_MESSAGES {
        MSG1 ("Always borrow money from a pessimist. He won’t expect it back."),
        MSG2 ("Don't worry if plan A fails, there are 25 more letters in the alphabet."),
        MSG3 ("I don't need a hair stylist, my pillow gives me a new hairstyle every morning."),
        MSG4 ("Dear Math, please grow up and solve your own problems, I'm tired of solving them for you.");

        private String message;
        FUNNY_MESSAGES(String val) {
            this.message = val;
        }
    }
}
