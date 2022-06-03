package com.qdc.userconsumer.service;

import com.qdc.domain.Company;
import com.qdc.domain.Position;
import com.qdc.domain.User;
import com.qdc.userconsumer.hystyix.ConsumerServiceHystrix;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "cr-user-provider",fallback = ConsumerServiceHystrix.class)
public interface ConsumerService {

    /**
     * UserController
     * @return
     */

    @RequestMapping(value = "findAllPosition" ,method = RequestMethod.GET)
    public List<Position> findAllPosition();

    @RequestMapping(value = "detail" ,method = RequestMethod.GET)
    public Position detail(@RequestParam(value = "pName") String pName);

    @RequestMapping(value = "findPositionLikepName" ,method = RequestMethod.GET)
    public List<Position> findPositionLikepName(@RequestParam(value = "pName") String pName);

    @RequestMapping(value = "findAllPositionByOrder" ,method = RequestMethod.GET)
    public List<Position> findAllPositionByOrder();

    @RequestMapping(value = "findPositionByPlace" , method = RequestMethod.GET)
    public List<Position> findPositionByPlace(@RequestParam(value = "place") String place);

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public int register(@RequestParam(value = "uName") String uName, @RequestParam(value = "uMail") String uMail,
                        @RequestParam(value = "uPassword") String uPassword, @RequestParam(value = "uType") String uType);



    /**
     * CompanyController
     */

    @RequestMapping(value = "findAllCompany" , method = RequestMethod.GET)
    public List<Company> findAllCompany();

    @RequestMapping(value = "findCompanyBycName" , method = RequestMethod.GET)
    public Company findCompanyBycName(@RequestParam(value = "cName") String cName);

    @RequestMapping(value = "findCompanyBycId" , method = RequestMethod.GET)
    public Company findCompanyBycId(@RequestParam(value = "cId") int cId);

    @RequestMapping(value = "add" , method = RequestMethod.GET)
    public int add(@RequestParam(value = "cName") String cName);

}
