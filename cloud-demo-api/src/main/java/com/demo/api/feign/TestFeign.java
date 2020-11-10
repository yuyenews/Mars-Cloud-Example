package com.demo.api.feign;

import com.demo.api.vo.TestFileVO;
import com.demo.api.vo.TestVo;
import com.demo.api.vo.TestVo2;
import com.mars.cloud.annotation.MarsContentType;
import com.mars.cloud.annotation.MarsFeign;
import com.mars.cloud.annotation.enums.ContentType;

import java.util.ArrayList;
import java.util.Map;

/**
 * 支持Feign调用
 */
@MarsFeign(serverName = "ser",beanName = "testFeign")
public interface TestFeign {

    /**
     * 这个方法名和参数必须和要调用的接口一模一样
     * @param testVo
     * @param testVo2
     * @return
     */
    ArrayList<Map> test(TestVo testVo, TestVo2 testVo2);

    @MarsContentType(ContentType = ContentType.FORM_DATA)
    ArrayList<Map> test1(TestFileVO testFileVO);

    /**
     * 这个方法名和参数必须和要调用的接口一模一样
     * @param testVo
     * @param testVo2
     * @return
     */
    @MarsContentType(ContentType = ContentType.JSON)
    ArrayList<Map> test2(TestVo testVo, TestVo2 testVo2);

    /**
     * 这个方法名和参数必须和要调用的接口一模一样
     * @param testVo
     * @param testVo2
     * @return
     */
    ArrayList<Map> test3(TestVo testVo, TestVo2 testVo2);

}
