package com.demo.api.vo;

import com.mars.server.server.request.model.MarsFileUpLoad;

public class TestFileVO {

    private String name;

    private Integer age;

    private MarsFileUpLoad file;

    private MarsFileUpLoad[] files;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public MarsFileUpLoad getFile() {
        return file;
    }

    public void setFile(MarsFileUpLoad file) {
        this.file = file;
    }

    public MarsFileUpLoad[] getFiles() {
        return files;
    }

    public void setFiles(MarsFileUpLoad[] files) {
        this.files = files;
    }
}
