package krevsky.coursera.videoservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;
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
@ComponentScan("krevsky.coursera.videoservice.repositories")
//helps to search Repository Interface and create its implementation automatically
//also it let's not to create method with @Bean annotation that returns the implementation of the Repository
@EnableJpaRepositories
//or @EnableJpaRepositories(basePackageClasses = VideoRepository.class)  //It lets us not to create @Bean method in Application class to return particular implementation
@Import({RepositoryRestMvcConfiguration.class})
public class VideoServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(VideoServiceApplication.class, args);
    }
}
