package com.demo.api.dao;

import com.mars.common.annotation.jdbc.MarsDao;
import com.mars.jdbc.core.annotation.MarsSelect;

import java.util.List;
import java.util.Map;

@MarsDao
public abstract class TestDAO {

    @MarsSelect(sql = "select * from userinfo")
    public abstract List<Map> findList();
}
