package com.wushe.springbootmybatisplus;

import com.wushe.springbootmybatisplus.LData;

public interface LDataLDataDao {
    int deleteByPrimaryKey(String id);

    int insert(LData record);

    int insertSelective(LData record);

    LData selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(LData record);

    int updateByPrimaryKey(LData record);
}