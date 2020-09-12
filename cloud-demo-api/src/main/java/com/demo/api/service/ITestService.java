package com.demo.api.service;

import com.demo.api.vo.TestVo;
import com.demo.api.vo.TestVo2;
import com.mars.common.annotation.api.MarsApi;
import com.mars.common.annotation.api.RequestMethod;
import com.mars.common.annotation.enums.ReqMethod;

import java.util.List;
import java.util.Map;

@MarsApi(refBean = "testService")
public interface ITestService {

    @RequestMethod(ReqMethod.POST)
    List<Map> test(TestVo testVo, TestVo2 testVo2);
}
