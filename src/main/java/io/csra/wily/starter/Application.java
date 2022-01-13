package io.csra.wily.starter;

import org.springframework.boot.Banner.Mode;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.WebApplicationInitializer;

@Configuration
@ComponentScan(basePackages = {Application.ALL_PACKAGES})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class Application extends SpringBootServletInitializer implements WebApplicationInitializer {

    public static final String NAME = "WilyStarterProject";
    public static final String ALL_PACKAGES = "io.csra";

    private static final Class<Application> applicationClass = Application.class;

    public static void main(String[] args) {
        new SpringApplicationBuilder().sources(applicationClass).bannerMode(Mode.OFF).run(args);
    }

    @Override
    protected SpringApplicationBuilder configure(final SpringApplicationBuilder application) {
        return application.sources(applicationClass).bannerMode(Mode.OFF);
    }

}
