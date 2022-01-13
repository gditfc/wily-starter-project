package io.csra.wily.starter.config;

import io.csra.wily.components.config.MasterApplicationConfig;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.PropertySource;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableTransactionManagement
@EnableAspectJAutoProxy
@EnableWebMvc
@PropertySource(value = {ApplicationConfig.PROPERTY_SOURCE_1})
public class ApplicationConfig extends MasterApplicationConfig {

    public static final String PROPERTY_SOURCE_1 = "classpath:environment.properties";

    private static final String DOZER_MAPPING_FILE = "dozerBeanMapping.xml";

    protected List<String> getMappingFiles() {
        final List<String> files = new ArrayList<>();
        files.add(DOZER_MAPPING_FILE);
        return files;
    }

}
