package com.sw.dao;


import org.apache.ibatis.annotations.Param;

public interface HisXxlyDao {

	boolean insertHisXxly(@Param("num")String num,@Param("ts1")String ts1,@Param("ts2")String ts2,@Param("ts3")String ts3,@Param("yw1")String yw1,@Param("yw2")String yw2,@Param("yw3")String yw3);
}
