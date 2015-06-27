package pl.com.bms;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;
import org.h2.server.web.WebServlet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.embedded.ServletRegistrationBean;
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

    @Bean
    public ServletRegistrationBean h2servletRegistration() {
        ServletRegistrationBean registration = new ServletRegistrationBean(new WebServlet());
        registration.addUrlMappings("/h2/*");
        return registration;
    }
}
