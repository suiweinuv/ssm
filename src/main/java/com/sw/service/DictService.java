package com.sw.service;

import com.sw.dao.DictDao;
import com.sw.dao.HisXxlyDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class DictService {
    @Autowired
    private DictDao dictDao;
    public  boolean insertDict(String name,String pname,String grade) {
        return dictDao.insertDict(name,pname,grade);
    }
    public  String getIdByName(String name) {
        return dictDao.getIdByName(name);
    }
}