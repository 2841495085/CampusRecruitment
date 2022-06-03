package com.qdc.companyprovider.dao;

import com.qdc.domain.Company;
import com.qdc.domain.Position;
import com.qdc.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;


@Mapper
public interface CompanyDao {

    /**
     *  user
     */

    @Select("select * from user where uMail=#{uMail}")
    User login(@Param(value = "uMail") String uMail);

    /**
     *  position
     */

    @Select("select * from position where cName=#{cName}")
    List<Position> findPositionBycName(@Param(value = "cName") String cName);

    @Select("select * from position where cId=#{cId}")
    List<Position> findPositionBycId(@Param(value = "cId") int cId);

    @Select("select * from position where pId=#{pId}")
    Position getPositionBypId(@Param(value = "pId") int pId);

    @Insert("insert into position (pName,salary,num,pInfo,prequire,place,time,cName,cId) values (#{pName},#{salary},#{num},#{pInfo},#{prequire},#{place},now(),#{cName},#{cId})")
    int publishPosition(@Param(value = "pName") String pName, @Param(value = "salary") String salary,
                        @Param(value = "num") int num, @Param(value = "pInfo") String pInfo,
                        @Param(value = "prequire") String prequire, @Param(value = "place") String place,
                        @Param(value = "cName") String cName, @Param(value = "cId") int cId);

    @Update("update position set pName=#{pName},salary=#{salary},num=#{num},pInfo=#{pInfo},prequire=#{prequire},place=#{place},time=now() where pId=#{pId}")
    int updatePosition(@Param(value = "pName") String pName, @Param(value = "salary") String salary,
                        @Param(value = "num") int num, @Param(value = "pInfo") String pInfo,
                        @Param(value = "prequire") String prequire, @Param(value = "place") String place,
                       @Param(value = "pId") int pId);


    @Delete("delete from position where pId=#{pId}")
    int deletePosition(@Param(value = "pId") int pId);

    @Select("select * from position where pName like \"%${pName}%\" and cId=#{cId}")
    List<Position> findPositionLikepNameAndbId(@Param(value = "pName") String pName,@Param(value = "cId") int cId);




    /**
     * company
     */

    @Select("select * from company where cName=#{cName}")
    Company findCompanyBycName(@Param(value = "cName") String cName);

    @Select("select * from company where cId=#{cId}")
    Company findCompanyBycId(@Param(value = "cId") int cId);

    @Update("update company set chairman=#{chairman},industry=#{industry}," +
            "cNum=#{cNum},capital=#{capital},patents=#{patents},cAddress=#{cAddress}," +
            "cPhone=#{cPhone},cBlog=#{cBlog},cMail=#{cMail},cInfo=#{cInfo} " +
            "where cId=#{cId}")
    int updateCompanyInfoBycId(@Param(value = "chairman") String chairman,
                               @Param(value = "industry") String industry, @Param(value = "cNum") String cNum,
                               @Param(value = "capital") String capital, @Param(value = "patents") String patents,
                               @Param(value = "cAddress") String cAddress, @Param(value = "cPhone") String cPhone,
                               @Param(value = "cBlog") String cBlog, @Param(value = "cMail") String cMail,
                               @Param(value = "cInfo") String cInfo, @Param(value = "cId") int cId);


}
