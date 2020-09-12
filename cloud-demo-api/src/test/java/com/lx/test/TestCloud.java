package com.lx.test;

import com.alibaba.fastjson.JSON;
import com.demo.api.DemoConfig;
import com.demo.api.Start;
import com.demo.api.service.ITestService;
import com.demo.api.vo.TestVo;
import com.demo.api.vo.TestVo2;
import com.mars.cloud.main.core.config.MarsCloudConfig;
import com.mars.common.annotation.bean.MarsWrite;
import com.mars.common.annotation.junit.MarsTest;
import com.mars.junit.MarsJunit;
import org.junit.Test;

import java.util.List;
import java.util.Map;

@MarsTest(startClass = Start.class)
public class TestCloud extends MarsJunit {

    @MarsWrite("testService")
    private ITestService iTestService;

    public MarsCloudConfig getMarsConfig() {
        return new DemoConfig();
    }

    @Test
    public void test(){
        TestVo testVo = new TestVo();
        testVo.setAge(12);
        testVo.setName("王五");

        TestVo2 testVo2 = new TestVo2();
        testVo2.setA(15);
        testVo2.setB("呵呵呵");

        List<Map> list = iTestService.test(testVo,testVo2);
        for(Map map : list){
            System.out.println(JSON.toJSONString(map));
        }

        List<Map> list2 = iTestService.test(testVo,testVo2);
        for(Map map : list2){
            System.out.println(JSON.toJSONString(map));
        }

        List<Map> list3 = iTestService.test(testVo,testVo2);
        for(Map map : list3){
            System.out.println(JSON.toJSONString(map));
        }

        List<Map> list5 = iTestService.test(testVo,testVo2);
        for(Map map : list5){
            System.out.println(JSON.toJSONString(map));
        }
    }
}
