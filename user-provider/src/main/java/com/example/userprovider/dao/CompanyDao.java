package com.example.userprovider.dao;

import com.qdc.domain.Company;
import com.qdc.domain.Position;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CompanyDao {

    @Select("select * from company")
    List<Company> findAllCompany();

    @Select("select * from company where cName=#{cName}")
    Company findCompanyBycName(@Param(value = "cName") String cName);

    @Select("select * from company where cId=#{cId}")
    Company findCompanyBycId(@Param(value = "cId") int cId);

    @Insert("insert into company (cName) values (#{cName})")
    int add(@Param(value = "cName") String cName);


}
