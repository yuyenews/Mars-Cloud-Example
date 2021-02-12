package com.demo.api;


import com.mars.cloud.balanced.BalancedCalc;
import com.mars.cloud.config.MarsCloudConfig;
import com.mars.cloud.config.model.CloudConfig;
import com.mars.cloud.request.balanced.impl.BalancedCalcPolling;
import com.mars.common.base.config.model.FileUploadConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DemoConfig extends MarsCloudConfig {

    @Override
    public int port() {
        return 8087;
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
        properties.setProperty("name","aa");
        propertiesList.add(properties);
        return propertiesList;
    }

    public CloudConfig getCloudConfig() {
        CloudConfig cloudConfig = new CloudConfig();
        cloudConfig.setName("api");
        cloudConfig.setContagions("http://127.0.0.1:8088");
        cloudConfig.setTimeOut(2000L);
        cloudConfig.setGateWay(true);
        cloudConfig.setOfflineVote(2);
        return cloudConfig;
    }

    /**
     * 配置负载均衡策略为轮询
     * @return
     */
    @Override
    public BalancedCalc getBalancedCalc() {
        /* 这个策略可以自定义，自己实现BalancedCalc接口，然后在这返回即可 */
        return new BalancedCalcPolling();
    }
}
