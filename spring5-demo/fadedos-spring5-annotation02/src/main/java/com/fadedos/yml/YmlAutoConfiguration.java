package com.fadedos.yml;

import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

import java.util.Properties;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/30
 */
@Configuration
@ComponentScan(basePackages = "com.fadedos.yml")
public class YmlAutoConfiguration {
    @Bean
    public PropertySourcesPlaceholderConfigurer configurer(){
        YamlPropertiesFactoryBean yamlPropertiesFactoryBean = new YamlPropertiesFactoryBean();
        yamlPropertiesFactoryBean.setResources(new ClassPathResource("init.yml"));
        Properties properties = yamlPropertiesFactoryBean.getObject();

        PropertySourcesPlaceholderConfigurer configurer = new PropertySourcesPlaceholderConfigurer();
        configurer.setProperties(properties);
        return configurer;
    }

}
