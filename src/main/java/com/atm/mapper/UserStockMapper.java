package com.atm.mapper;

import com.atm.pojo.UserStock;
import com.atm.pojo.UserStockExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface UserStockMapper {
    int countByExample(UserStockExample example);

    int deleteByExample(UserStockExample example);

    int insert(UserStock record);

    int insertSelective(UserStock record);

    List<UserStock> selectByExample(UserStockExample example);

    int updateByExampleSelective(@Param("record") UserStock record, @Param("example") UserStockExample example);

    int updateByExample(@Param("record") UserStock record, @Param("example") UserStockExample example);

    List<Map> selectStocksByUId(@Param("uid") int uid, @Param("scode") String scode);
}