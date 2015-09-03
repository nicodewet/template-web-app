package hello;

import java.util.Locale;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class Application extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public LocaleResolver localeResolver() {
        SessionLocaleResolver slr = new SessionLocaleResolver();
        slr.setDefaultLocale(Locale.US);
        return slr;
    }
 
    @Bean
    public LocaleChangeInterceptor localeChangeInterceptor() {
        LocaleChangeInterceptor lci = new LocaleChangeInterceptor();
        lci.setParamName("language");
        return lci;
    }
 
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(localeChangeInterceptor());
    }
    
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//            registry.addInterceptor(localeChangeInterceptor());
//    }
//
//    @Bean
//    public LocaleChangeInterceptor localeChangeInterceptor() {
//            LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
//            localeChangeInterceptor.setParamName("language");
//            return localeChangeInterceptor;
//    }
//
//    @Bean(name = "localeResolver")
//    public CookieLocaleResolver localeResolver() {
//            CookieLocaleResolver localeResolver = new CookieLocaleResolver();
//            Locale defaultLocale = new Locale("en");
//            localeResolver.setDefaultLocale(defaultLocale);
//            return localeResolver;
//    }
//
//    @Bean
//    public ReloadableResourceBundleMessageSource messageSource() {
//            ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
//            messageSource.setBasename("classpath:lang/messages");
//            messageSource.setCacheSeconds(10); //reload messages every 10 seconds
//            return messageSource;
//    }
}
