package com.demo.api;


import com.mars.cloud.balanced.BalancedCalc;
import com.mars.cloud.config.MarsCloudConfig;
import com.mars.cloud.config.model.CloudConfig;
import com.mars.cloud.config.model.FuseConfig;
import com.mars.cloud.fuse.FuseDefault;
import com.mars.cloud.request.balanced.impl.BalancedCalcPolling;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DemoConfig extends MarsCloudConfig {

    @Override
    public int port() {
        return 8089;
    }

    public List<Properties> jdbcProperties() {
        List<Properties> propertiesList = new ArrayList<Properties>();
        Properties properties = new Properties();
        properties.setProperty("name","aa");

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
        cloudConfig.setContagions("http://127.0.01:8088");
        cloudConfig.setTimeOut(2000L);

        return cloudConfig;
    }

    /**
     * 配置负载均衡策略为轮询
     * 默认普通轮询，如果采用默认的话，可以不重写此方法
     * @return
     */
    @Override
    public BalancedCalc getBalancedCalc() {
        /* 这个策略可以自定义，自己实现BalancedCalc接口，然后在这返回即可 */
        return new BalancedCalcPolling();
    }

    /**
     * 配置熔断器
     * 目前还没有熔断器，所以这个配置用不到
     * 如果需要的话，可以自己实现熔断器，在这返回即可
     * @return
     */
    @Override
    public FuseConfig getFuseConfig() {
        FuseConfig fuseConfig = new FuseConfig();
        /* 失败多少次就熔断 */
        fuseConfig.setFailNum(10L);
        /* 熔断后，被请求多少次后就进入半熔断 */
        fuseConfig.setFuseNum(5L);
        /*
            熔断器，暂时没有官方实现，如果需要的话，可以自己实现熔断器
            实现熔断器的方式就是 实现FuseManager接口，然后把实例set到这里面即可
        */
        fuseConfig.setFuseManager(new FuseDefault());
        return fuseConfig;
    }
}

