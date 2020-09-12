package com.demo.api.service;

import com.demo.api.vo.TestVo;
import com.demo.api.vo.TestVo2;
import com.mars.common.annotation.api.MarsApi;
import com.mars.common.annotation.api.RequestMethod;
import com.mars.common.annotation.enums.ReqMethod;

@MarsApi(refBean = "testService")
public interface ITestService {

    @RequestMethod(ReqMethod.POST)
    Object test(TestVo testVo, TestVo2 testVo2);
}
