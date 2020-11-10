package com.demo.api;


import com.mars.cloud.config.MarsCloudConfig;
import com.mars.cloud.config.model.CloudConfig;
import com.mars.cloud.config.model.enums.Strategy;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DemoConfig extends MarsCloudConfig {

    @Override
    public int port() {
        return 8087;
    }

    public List<Properties> jdbcProperties() {
        List<Properties> propertiesList = new ArrayList<Properties>();
        Properties properties = new Properties();
        properties.setProperty("name","aa");
        propertiesList.add(properties);
        return propertiesList;
    }

    public CloudConfig getCloudConfig() {
        CloudConfig cloudConfig = new CloudConfig();
        cloudConfig.setName("api");
        cloudConfig.setContagions("http://127.0.0.1:8088");
        cloudConfig.setStrategy(Strategy.POLLING);
        cloudConfig.setTimeOut(2000L);
        cloudConfig.setGateWay(true);
        return cloudConfig;
    }
}
