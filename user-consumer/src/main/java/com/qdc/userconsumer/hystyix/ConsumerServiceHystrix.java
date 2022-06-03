package com.qdc.userconsumer.hystyix;

import com.qdc.domain.Company;
import com.qdc.domain.Position;
import com.qdc.domain.User;
import com.qdc.userconsumer.service.ConsumerService;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class ConsumerServiceHystrix implements ConsumerService {

    /**
     * user
     * @return
     */
    @Override
    public List<Position> findAllPosition() {
        return null;
    }

    @Override
    public Position detail(String pName) {
        return null;
    }

    @Override
    public List<Position> findPositionLikepName(String pName) {
        return null;
    }

    @Override
    public List<Position> findAllPositionByOrder() {
        return null;
    }

    @Override
    public List<Position> findPositionByPlace(String place) {
        return null;
    }

    @Override
    public int register(String uName, String uMail, String uPassword, String uType) {
        return 0;
    }


    /**
     * company
     * @return
     */

    @Override
    public List<Company> findAllCompany() {
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
    public int add(String cName) {
        return 0;
    }


}
