package com.demo.api;


import com.mars.cloud.config.MarsCloudConfig;
import com.mars.cloud.config.model.CloudConfig;
import com.mars.cloud.config.model.enums.Strategy;
import com.mars.common.base.config.model.FileUploadConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DemoConfig extends MarsCloudConfig {

    @Override
    public int port() {
        return 8088;
    }

    @Override
    public FileUploadConfig fileUploadConfig() {
        FileUploadConfig fileUploadConfig = new FileUploadConfig();
        fileUploadConfig.setSizeMax(fileUploadConfig.getSizeMax()*1000);
        fileUploadConfig.setFileSizeMax(fileUploadConfig.getFileSizeMax()*1000);
        return fileUploadConfig;
    }

    public List<Properties> jdbcProperties() {
        List<Properties> propertiesList = new ArrayList<Properties>();
        Properties properties = new Properties();
        properties.setProperty("name", "aa");

        properties.setProperty("name", "dataSource");
        properties.setProperty("url", "jdbc:mysql://47.75.242.49:3306/mars?useUnicode=true&characterEncoding=utf8&serverTimezone=GMT%2B8");
        properties.setProperty("username", "root");
        properties.setProperty("password", "root");
        properties.setProperty("driverClassName", "com.mysql.jdbc.Driver");

        propertiesList.add(properties);
        return propertiesList;
    }

    public CloudConfig getCloudConfig() {
        CloudConfig cloudConfig = new CloudConfig();
        cloudConfig.setName("ser");
        cloudConfig.setContagions("http://127.0.01:8089");
        cloudConfig.setStrategy(Strategy.POLLING);
        cloudConfig.setTimeOut(2000L);

        return cloudConfig;
    }
}

