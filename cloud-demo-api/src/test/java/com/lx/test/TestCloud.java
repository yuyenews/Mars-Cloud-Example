package com.lx.test;

import com.alibaba.fastjson.JSON;
import com.demo.api.DemoConfig;
import com.demo.api.Start;
import com.demo.api.service.ITestService;
import com.demo.api.vo.TestFileVO;
import com.demo.api.vo.TestVo;
import com.demo.api.vo.TestVo2;
import com.mars.cloud.config.MarsCloudConfig;
import com.mars.common.annotation.bean.MarsWrite;
import com.mars.common.annotation.junit.MarsTest;
import com.mars.junit.MarsJunit;
import com.mars.server.server.request.model.MarsFileUpLoad;
import org.junit.Test;

import java.io.FileInputStream;
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
        try {
            TestVo testVo = new TestVo();
            testVo.setAge(12);
//            testVo.setName("王五");
            testVo.setList(new String[]{"哈哈哈","我是天才"});

            TestVo2 testVo2 = new TestVo2();
            testVo2.setA(15);
            testVo2.setB("呵呵呵");

            List<Map> list = iTestService.test(testVo,testVo2);
            for(Map map : list){
                System.out.println(JSON.toJSONString(map));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }

    @Test
    public void testFormData(){
        try{
            TestFileVO testFileVO = new TestFileVO();
            testFileVO.setAge(12);
            testFileVO.setName("hahahah");

            MarsFileUpLoad marsFileUpLoad = new MarsFileUpLoad();
            marsFileUpLoad.setName("file");
            marsFileUpLoad.setFileName("fileName.jps");
            marsFileUpLoad.setInputStream(new FileInputStream("/Users/yuye/Downloads/a.pdf"));
            testFileVO.setFile(marsFileUpLoad);

            MarsFileUpLoad[] marsFileUpLoads = new MarsFileUpLoad[2];
            marsFileUpLoads[0] = marsFileUpLoad;
            marsFileUpLoads[1] = marsFileUpLoad;
            testFileVO.setFiles(marsFileUpLoads);

            List<Map> list2 = iTestService.test1(testFileVO);
            for(Map map : list2){
                System.out.println(JSON.toJSONString(map));
            }

        } catch (Exception e){
            e.printStackTrace();
        }

    }
}
