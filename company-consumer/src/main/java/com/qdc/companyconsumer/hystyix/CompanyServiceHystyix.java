package com.qdc.companyconsumer.hystyix;

import com.qdc.companyconsumer.service.CompanyService;
import com.qdc.domain.Company;
import com.qdc.domain.Position;
import com.qdc.domain.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CompanyServiceHystyix implements CompanyService {


    @Override
    public User login(String uMail) {
        return null;
    }

    @Override
    public List<Position> findPositionBycName(String cName) {
        return null;
    }

    @Override
    public List<Position> findPositionBycId(int cId) {
        return null;
    }

    @Override
    public Position getPositionBypId(int pId) {
        return null;
    }

    @Override
    public Company findCompanyBycName(String cName) {
        return null;
    }

    @Override
    public Company findCompanyBycId(int cId) {
        return null;
    }

    @Override
    public int updateCompanyInfoBycId(String chairman, String industry, String cNum, String capital, String patents, String cAddress, String cPhone, String cBlog, String cMail, String cInfo, int cId) {
        return 0;
    }

    @Override
    public int publishPosition(String pName, String salary, int num, String pInfo, String prequire, String place, String cName, int cId) {
        return 0;
    }

    @Override
    public int updatePosition(String pName, String salary, int num, String pInfo, String prequire, String place, int pId) {
        return 0;
    }

    @Override
    public int deletePosition(int pId) {
        return 0;
    }

    @Override
    public List<Position> findPositionLikepNameAndbId(String pName, int cId) {
        return null;
    }


}
