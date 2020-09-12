package com.demo.api;

import com.mars.cloud.main.core.config.MarsCloudConfig;
import com.mars.cloud.main.core.config.model.CloudConfig;
import com.mars.cloud.main.core.config.model.enums.Strategy;

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
        cloudConfig.setGateWay(true);
        cloudConfig.setName("api");
        cloudConfig.setRegister("47.75.242.49:2181");
        cloudConfig.setSessionTimeout(1000000000L);
        cloudConfig.setStrategy(Strategy.POLLING);
        cloudConfig.setTimeOut(2000L);

        return cloudConfig;
    }
}