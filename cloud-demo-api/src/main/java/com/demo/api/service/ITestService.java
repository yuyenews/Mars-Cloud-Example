package com.demo.api.service;

import com.demo.api.vo.TestFileVO;
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

    @RequestMethod(ReqMethod.POST)
    List<Map> test1(TestFileVO testFileVO);

    @RequestMethod(ReqMethod.POST)
    List<Map> test2(TestVo testVo, TestVo2 testVo2);

    List<Map> test3(TestVo testVo, TestVo2 testVo2);


}
