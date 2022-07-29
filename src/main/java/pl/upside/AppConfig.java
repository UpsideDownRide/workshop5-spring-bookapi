package pl.upside;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import pl.upside.repositories.BookRepository;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.upside",
        includeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, value = ControllerAdvice.class))

public class AppConfig implements WebMvcConfigurer {
    BookRepository repository;

    @Bean
    BookRepository mockBookRepository(){
        return new MockBookRepo().getRepository();
    }
}
