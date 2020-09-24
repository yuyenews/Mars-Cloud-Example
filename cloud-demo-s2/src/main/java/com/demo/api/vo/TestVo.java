package com.demo.api.vo;

import java.io.Serializable;
import java.util.List;

public class TestVo implements Serializable {


    private static final long serialVersionUID = 7928641204225676807L;
    private int age;

    private String name;

    private String[] list;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String[] getList() {
        return list;
    }

    public void setList(String[] list) {
        this.list = list;
    }
}
