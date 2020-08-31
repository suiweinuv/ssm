package com.sw.service;

import com.sw.dao.HisXxlyDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class HisXxlyService {
    @Autowired
    private HisXxlyDao hisXxlyDao;
    public  boolean insertXxlyHis(String num,String ts1,String ts2,String ts3,String yw1,String yw2,String yw3) {
        return hisXxlyDao.insertHisXxly(num, ts1, ts2, ts3, yw1, yw2, yw3);
    }
}