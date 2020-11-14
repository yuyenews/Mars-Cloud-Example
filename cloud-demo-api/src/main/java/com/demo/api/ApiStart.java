package com.demo.api;

import com.mars.common.annotation.start.MarsImport;
import com.mars.start.StartMars;

@MarsImport(packageName = "com.mars.cloud.components")
public class ApiStart {

    public static void main(String[] args) {
        StartMars.start(ApiStart.class, new DemoConfig());
    }
}
