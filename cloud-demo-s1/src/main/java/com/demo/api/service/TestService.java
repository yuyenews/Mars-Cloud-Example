package com.demo.api.service;

import com.demo.api.dao.TestDAO;
import com.demo.api.feign.TestFeign;
import com.demo.api.vo.TestVo;
import com.demo.api.vo.TestVo2;
import com.mars.common.annotation.bean.MarsBean;
import com.mars.common.annotation.bean.MarsWrite;

@MarsBean
public class TestService implements ITestService {

    @MarsWrite
    private TestFeign testFeign;

    @MarsWrite
    private TestDAO testDAO;

    public Object test(TestVo testVo, TestVo2 testVo2){
        System.out.println("testVo:");
        System.out.println(testVo.getAge());
        System.out.println(testVo.getName());
        System.out.println(testVo.getList());

        System.out.println("testVo2:");
        System.out.println(testVo2.getA());
        System.out.println(testVo2.getB());
        return testDAO.findList();
    }
}
