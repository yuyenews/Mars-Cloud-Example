package com.demo.api.service;

import com.demo.api.dao.TestDAO;
import com.demo.api.feign.TestFeign;
import com.demo.api.vo.TestFileVO;
import com.demo.api.vo.TestVo;
import com.demo.api.vo.TestVo2;
import com.mars.aio.server.impl.MarsHttpExchange;
import com.mars.aio.server.model.HttpHeaders;
import com.mars.common.annotation.bean.MarsBean;
import com.mars.common.annotation.bean.MarsWrite;
import com.mars.common.util.JSONUtil;
import com.mars.server.server.request.HttpMarsRequest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@MarsBean
public class TestService implements ITestService {

    @MarsWrite
    private TestFeign testFeign;

    @MarsWrite
    private TestDAO testDAO;

    public Object test(TestVo testVo, TestVo2 testVo2, HttpMarsRequest request){
        System.out.println("test----------------");
        HttpHeaders headers = request.getNativeRequest(MarsHttpExchange.class).getRequestHeaders();
        for(String name : headers.keySet()){
            System.out.println("header:"+name+"="+ JSONUtil.toJSONString(headers.get(name)));
        }
        return test3(testVo, testVo2);
    }

    public Object test1(TestFileVO testFileVO) {
        System.out.println(testFileVO.getAge());
        System.out.println(testFileVO.getName());
        System.out.println(testFileVO.getFile());
        System.out.println(testFileVO.getFiles().length);
        return getResult();
    }

    public Object test2(TestVo testVo, TestVo2 testVo2) {
        System.out.println("test2----------------");
        return test3(testVo, testVo2);
    }

    public Object test3(TestVo testVo, TestVo2 testVo2) {
        System.out.println("testVo:");
        System.out.println(testVo.getAge());
        System.out.println(testVo.getName());
        System.out.println(JSONUtil.toJSONString(testVo.getList()));

        System.out.println("testVo2:");
        System.out.println(testVo2.getA());
        System.out.println(testVo2.getB());



        return getResult();
//        return testDAO.findList();
    }

    private List<Map> getResult(){
        List<Map> list = new ArrayList<Map>();
        Map map = new HashMap();
        map.put("name","sss");
        map.put("age",12);
        list.add(map);

        map = new HashMap();
        map.put("name","sss2");
        map.put("age",18);
        list.add(map);

        return list;
    }
}
