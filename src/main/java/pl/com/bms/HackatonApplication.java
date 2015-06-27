package pl.com.bms;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class HackatonApplication {

    public static void main(String[] args) {
        SpringApplication.run(HackatonApplication.class, args);
    }

    @Bean
    public EventBus eventBus() {
        return new EventBus();
    }
}
