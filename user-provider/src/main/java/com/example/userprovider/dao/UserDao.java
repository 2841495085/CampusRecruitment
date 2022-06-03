package com.example.userprovider.dao;

import com.qdc.domain.Company;
import com.qdc.domain.Position;
import com.qdc.domain.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import javax.xml.bind.ValidationEvent;
import java.util.List;

@Mapper
public interface UserDao {

    @Select("select * from position")
    List<Position> findAllPosition();

    // 倒叙查询所有
    @Select("select * from position order by pId desc")
    List<Position> findAllPositionByOrder();

    @Select("select * from position where pName=#{pName} ")
    Position findPositionBypName(@Param(value = "pName") String pName);

    @Select("select * from position where pName like \"%${pName}%\"")
    List<Position> findPositionLikepName(@Param(value = "pName") String pName);


    @Select("select * from position where place like \"%${place}%\"")
    List<Position> findPositionByPlace(@Param(value = "place") String place);

    @Insert("insert into user (uName,uMail,uPassword,uType) values (#{uName},#{uMail},#{uPassword},#{uType})")
    int register(@Param(value = "uName") String uName,@Param(value = "uMail") String uMail,
                 @Param(value = "uPassword") String uPassword,@Param(value = "uType") String uType);

}
