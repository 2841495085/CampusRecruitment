package com.example.userprovider;

import com.alibaba.druid.wall.Violation;
import com.example.userprovider.dao.CompanyDao;
import com.example.userprovider.dao.UserDao;
import com.qdc.domain.Company;
import com.qdc.domain.Position;
import com.qdc.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class UserProviderApplicationTests {

    @Autowired
    UserDao userDao;

    @Autowired
    CompanyDao companyDao;

    @Test
    void testFindAllPosition() {
        List<Position> allPosition = userDao.findAllPosition();
        System.out.println(allPosition);
    }

    @Test
    void testFindPositionBypName() {
        Position position = userDao.findPositionBypName("Java开发工程师");
        System.out.println(position);
    }

    @Test
    void testFindPositionLikepName() {
        List<Position> java = userDao.findPositionLikepName("java");
        System.out.println(java);
    }

    @Test
    void testFindPositionByOrder() {
        List<Position> java = userDao.findAllPositionByOrder();
        System.out.println(java);
    }


    @Test
    void testFindAllCompany(){
        List<Company> allCompany = companyDao.findAllCompany();
        System.out.println(allCompany);
    }

    @Test
    void testfindCompanyBycName(){
        Company name = companyDao.findCompanyBycName("腾讯计算机系统有限公司");
        System.out.println(name);
    }

    @Test
    void testfindCompanyBycId(){
        Company companyBycId = companyDao.findCompanyBycId(1002);
        System.out.println(companyBycId);
    }


    @Test
    void testfindByplace(){
        List<Position>  place = userDao.findPositionByPlace("深圳");
        System.out.println(place);
    }

    @Test
    void testRegister(){
        userDao.register("111","111.com","111","个人");
    }

    @Test
    void  testadd(){
        companyDao.add("ssssssssssss");
    }

}
