package com.atm.mapper;

import com.atm.pojo.Welfare;
import com.atm.pojo.WelfareExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WelfareMapper {
    int countByExample(WelfareExample example);

    int deleteByExample(WelfareExample example);

    int deleteByPrimaryKey(Integer wId);

    int insert(Welfare record);

    int insertSelective(Welfare record);

    List<Welfare> selectByExample(WelfareExample example);

    Welfare selectByPrimaryKey(Integer wId);

    int updateByExampleSelective(@Param("record") Welfare record, @Param("example") WelfareExample example);

    int updateByExample(@Param("record") Welfare record, @Param("example") WelfareExample example);

    int updateByPrimaryKeySelective(Welfare record);

    int updateByPrimaryKey(Welfare record);
}