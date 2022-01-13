package io.csra.wily.starter.config;

import io.csra.wily.security.config.impl.CognitoSecurityConfiguration;
import io.csra.wily.security.service.SecurityService;
import io.csra.wily.security.service.impl.SecurityServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;


@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
@PropertySource(value = {SecurityConfig.PROPERTY_SOURCE_1})
public class SecurityConfig extends CognitoSecurityConfiguration {

    public static final String PROPERTY_SOURCE_1 = "classpath:cognito.properties";

    @Bean
    public SecurityService securityService() {
        return new SecurityServiceImpl();
    }

}
