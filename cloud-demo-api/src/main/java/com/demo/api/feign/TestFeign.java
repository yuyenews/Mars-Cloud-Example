package com.demo.api.feign;

import com.demo.api.vo.TestVo;
import com.demo.api.vo.TestVo2;
import com.mars.cloud.main.core.annotation.MarsFeign;

import java.util.List;
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
    List<Map> test(TestVo testVo, TestVo2 testVo2);
}
