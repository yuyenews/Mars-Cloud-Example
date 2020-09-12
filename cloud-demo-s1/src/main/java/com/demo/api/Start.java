package com.demo.api;

import com.mars.common.annotation.start.MarsImport;
import com.mars.start.StartMars;

@MarsImport(packageName = "com.mars.cloud")
public class Start {

    public static void main(String[] args) {
        StartMars.start(Start.class, new DemoConfig());
    }
}
