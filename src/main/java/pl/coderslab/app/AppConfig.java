package pl.coderslab.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.format.FormatterRegistry;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.servlet.LocaleContextResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import java.nio.charset.StandardCharsets;
import java.util.List;
import java.util.Locale;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "pl.coderslab")
public class AppConfig implements WebMvcConfigurer {


}

//@SpringBootApplication
//@ComponentScan(basePackages = "pl.coderslab")
//public class Application {
//    public static void main(String[] args) {
//        SpringApplication.run(Application.class, args);
//    }
//}


//@Configuration
//@EnableWebMvc
//@ComponentScan(basePackages = "pl.coderslab")
//@EnableJpaRepositories(basePackages = "pl.coderslab.repository")
//@EnableTransactionManagement
//public class AppConfig implements WebMvcConfigurer {
//    @Bean
//    public LocalEntityManagerFactoryBean entityManagerFactory() {
//        LocalEntityManagerFactoryBean entityManagerFactoryBean = new LocalEntityManagerFactoryBean();
//        entityManagerFactoryBean.setPersistenceUnitName("bookstorePersistenceUnit");
//        return entityManagerFactoryBean;
//    }
//
//    @Bean
//    public JpaTransactionManager transactionManager(EntityManagerFactory entityManagerFactory) {
//        JpaTransactionManager jpaTransactionManager = new JpaTransactionManager(entityManagerFactory);
//        return jpaTransactionManager;
//    }
//
//    @Bean
//    public ViewResolver viewResolver() {
//        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
//        viewResolver.setPrefix("/WEB-INF/");
//        viewResolver.setSuffix(".jsp");
//        return viewResolver;
//    }
//
//    @Override
//    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
//        converters.add(responseBodyConverter());
//    }
//
//    @Bean
//    public HttpMessageConverter<String> responseBodyConverter() {
//        StringHttpMessageConverter converter = new StringHttpMessageConverter();
//        converter.setSupportedMediaTypes(List.of(new MediaType("text", "html", StandardCharsets.UTF_8)));
//        return converter;
//    }
//
////    @Bean
////    public PublisherConverter publisherConverter() {
////        return new PublisherConverter();
////    }
////
////    @Bean
////    public AuthorConverter authorConverter() {
////        return new AuthorConverter();
////    }
////
////    @Override
////    public void addFormatters(FormatterRegistry registry) {
////        registry.addConverter(publisherConverter());
////        registry.addConverter(authorConverter());
////    }
//
//    @Bean
//    public Validator validator() {
//        return new LocalValidatorFactoryBean();
//    }
//
//    @Bean(name = "localeResolver")
//    public LocaleContextResolver getLocaleContextResolver() {
//        SessionLocaleResolver localeResolver = new SessionLocaleResolver();
//        localeResolver.setDefaultLocale(new Locale("pl", "PL"));
//        return localeResolver;
//    }
//}