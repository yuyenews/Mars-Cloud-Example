package com.demo.api.service;

import com.alibaba.fastjson.JSON;
import com.demo.api.feign.TestFeign;
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
        List<String> list = new ArrayList<String>();

        list.add("aaa");
        list.add("bbb");

        testVo.setList(list);

        System.out.println(JSON.toJSONString(list));

        return testFeign.test(testVo,testVo2);

        //return new ArrayList<Map>();
    }
}
