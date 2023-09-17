package krevsky.coursera.videoservice;

import krevsky.coursera.videoservice.repositories.VideoRepository;
import krevsky.coursera.videoservice.repositories.VideoRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// Tell Spring that this object represents a Configuration for the application
@Configuration
// Tell Spring to turn on WebMVC (e.g., it should enable the DispatcherServlet
// so that requests can be routed to our Controllers)
// NOTE: it requires spring-boot-starter-web dependency
@EnableWebMvc
// Tell Spring to automatically inject any dependencies that are marked in
// our classes with @Autowired
@EnableAutoConfiguration
// Tell Spring to go and scan our controller package (and all sub packages) to
// find any Controllers or other components that are part of our application.
// Any class in this package that is annotated with @Controller is going to be
// automatically discovered and connected to the DispatcherServlet.
//@ComponentScan
@ComponentScan("krevsky.coursera.videoservice.controllers")
public class VideoServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }

    // We need to tell Spring which implementation of the VideoRepository
    // that it should use. Spring is going to automatically inject whatever
    // we return into the VideoController's videos member variable that is annotated
    // with @Autowired.
    @Bean
    public VideoRepository getVideoRepository() {
        return new VideoRepositoryImpl();
    }
}
