package com.sw.dao;


import org.apache.ibatis.annotations.Param;

public interface DictDao {

	boolean insertDict(@Param("name") String name, @Param("pname") String pname, @Param("grade") String grade);
	String getIdByName(@Param("name") String name);
}
