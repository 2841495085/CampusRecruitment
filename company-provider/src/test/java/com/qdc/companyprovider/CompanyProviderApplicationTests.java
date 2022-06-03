package com.qdc.companyprovider;

import com.alibaba.druid.wall.Violation;
import com.qdc.companyprovider.dao.CompanyDao;
import com.qdc.domain.Company;
import com.qdc.domain.Position;
import com.qdc.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import sun.reflect.generics.tree.VoidDescriptor;

import java.util.List;

@SpringBootTest
class CompanyProviderApplicationTests {

    @Autowired
    CompanyDao companyDao;

    @Test
    void testlogin() {
        User login = companyDao.login("@huawei.com");
        System.out.println(login);
    }

    @Test
    void testfindCompanyBycName(){
        List<Position> bycName = companyDao.findPositionBycName("华为技术有限公司");
        System.out.println(bycName);
    }

    @Test
    void testfindPositionBycId(){
        List<Position> positionBycId = companyDao.findPositionBycId(1002);
        System.out.println(positionBycId);
    }

    @Test
    void testgetPositionBycId(){
        Position positionBycId = companyDao.getPositionBypId(2);
        System.out.println(positionBycId);
    }

    @Test
    void testfindCompanyBycId(){
        Company companyBycId = companyDao.findCompanyBycId(1002);
        System.out.println(companyBycId);
    }

    @Test
    void testupdateCompanyInfoBycId(){
        companyDao.updateCompanyInfoBycId("dsdsd","ddddd","dddddd","ddddd","ddddddddd","dddddddddd","dddddddd","dddddddddd","dddddddddd","ddddddddddddddd",1007);
    }

    @Test
    void testpublishPosition(){
        companyDao.publishPosition("ccc","ccc",1,"ccc","ccc","ccc","ccc",1);
    }


    @Test
    void teupdatePosition(){
        companyDao.updatePosition("1111111111","1111",1,"1111","111","111",17);
    }

    @Test
    void testdeletePosition(){
        companyDao.deletePosition(17);
    }

    @Test
    void testmuhu(){
        System.out.println(companyDao.findPositionLikepNameAndbId("Java", 1001));
    }


}
