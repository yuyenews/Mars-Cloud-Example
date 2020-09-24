package com.demo.api.service;

import com.alibaba.fastjson.JSON;
import com.demo.api.feign.TestFeign;
import com.demo.api.vo.TestFileVO;
import com.demo.api.vo.TestVo;
import com.demo.api.vo.TestVo2;
import com.mars.common.annotation.bean.MarsBean;
import com.mars.common.annotation.bean.MarsWrite;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@MarsBean
public class TestService implements ITestService {

    @MarsWrite
    private TestFeign testFeign;

    public List<Map> test(TestVo testVo, TestVo2 testVo2){

        System.out.println(JSON.toJSONString(testVo.getList()));

        return testFeign.test(testVo,testVo2);

        //return new ArrayList<Map>();
    }

    public List<Map> test1(TestFileVO testFileVO) {
        System.out.println(JSON.toJSONString(testFileVO));

        return testFeign.test1(testFileVO);
    }

    public List<Map> test2(TestVo testVo, TestVo2 testVo2) {
        System.out.println(JSON.toJSONString(testVo.getList()));

        return testFeign.test2(testVo,testVo2);
    }

    public List<Map> test3(TestVo testVo, TestVo2 testVo2) {
        System.out.println(JSON.toJSONString(testVo.getList()));

        return testFeign.test3(testVo,testVo2);
    }
}
