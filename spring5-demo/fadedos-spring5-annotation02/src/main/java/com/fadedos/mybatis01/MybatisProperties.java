package com.fadedos.mybatis01;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @Description:TODO
 * @author: pengcheng
 * @date: 2021/1/29
 */
@Component
@PropertySource("classpath:/mybatis.properties")
public class MybatisProperties {
    @Value("${mybatis.driverClassName}")
    private String driverClassName;

    @Value("${mybatis.url}")
    private String url;

    @Value("${mybatis.username}")
    private String  name;

    @Value("${mybatis.password}")
    private String password;

    @Value("${mybatis.typeAliasesPackages}")
    private String  typeAliasesPackages;

    @Value("${mybatis.mapperLocations}")
    private String  mapperLocations;

    public String getDriverClassName() {
        return driverClassName;
    }

    public void setDriverClassName(String driverClassName) {
        this.driverClassName = driverClassName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTypeAliasesPackages() {
        return typeAliasesPackages;
    }

    public void setTypeAliasesPackages(String typeAliasesPackages) {
        this.typeAliasesPackages = typeAliasesPackages;
    }

    public String getMapperLocations() {
        return mapperLocations;
    }

    public void setMapperLocations(String mapperLocations) {
        this.mapperLocations = mapperLocations;
    }
}
