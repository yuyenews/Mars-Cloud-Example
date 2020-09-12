package com.demo.api;

import com.mars.cloud.starter.StartMarsCloud;
import com.mars.common.annotation.start.MarsImport;

@MarsImport(packageName = "com.mars.cloud")
public class Start {

    public static void main(String[] args) {
        StartMarsCloud.start(Start.class, new DemoConfig());
    }
}
