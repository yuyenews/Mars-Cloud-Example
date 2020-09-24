package com.demo.api.service;

import com.demo.api.vo.TestFileVO;
import com.demo.api.vo.TestVo;
import com.demo.api.vo.TestVo2;
import com.mars.common.annotation.api.MarsApi;
import com.mars.common.annotation.api.RequestMethod;
import com.mars.common.annotation.enums.ReqMethod;

@MarsApi(refBean = "testService")
public interface ITestService {

    /**
     * POST表单
     * @param testVo
     * @param testVo2
     * @return
     */
    @RequestMethod(ReqMethod.POST)
    Object test(TestVo testVo, TestVo2 testVo2);

    /**
     * PUT, FORM_DATA
     * @return
     */
    @RequestMethod(ReqMethod.PUT)
    Object test1(TestFileVO testFileVO);

    /**
     * JSON
     * @param testVo
     * @param testVo2
     * @return
     */
    @RequestMethod(ReqMethod.POST)
    Object test2(TestVo testVo, TestVo2 testVo2);

    /**
     * GET
     * @param testVo
     * @param testVo2
     * @return
     */
    Object test3(TestVo testVo, TestVo2 testVo2);
}
