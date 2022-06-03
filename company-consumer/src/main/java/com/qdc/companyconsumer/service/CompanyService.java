package com.qdc.companyconsumer.service;

import com.qdc.companyconsumer.hystyix.CompanyServiceHystyix;
import com.qdc.domain.Company;
import com.qdc.domain.Position;
import com.qdc.domain.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Component
@FeignClient(value = "cr-company-provider",fallback = CompanyServiceHystyix.class)
public interface CompanyService {

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public User login(@RequestParam(value = "uMail") String uMail);

    @RequestMapping(value = "findPositionBycName" ,method = RequestMethod.GET)
    public List<Position> findPositionBycName(@RequestParam(value = "cName") String cName);

    @RequestMapping(value = "findPositionBycId" ,method = RequestMethod.GET)
    public List<Position> findPositionBycId(@RequestParam(value = "cId") int cId);

    @RequestMapping(value = "getPositionBypId" ,method = RequestMethod.GET)
    public Position getPositionBypId(@RequestParam(value = "pId") int pId);

    @RequestMapping(value = "findCompanyBycName" , method = RequestMethod.GET)
    public Company findCompanyBycName(@RequestParam(value = "cName") String cName);

    @RequestMapping(value = "findCompanyBycId" ,method = RequestMethod.GET)
    public Company findCompanyBycId(@RequestParam(value = "cId") int cId);

    @RequestMapping(value = "updateCompanyInfoBycId" ,method = RequestMethod.GET)
    public int updateCompanyInfoBycId(@RequestParam(value = "chairman") String chairman,
                                      @RequestParam(value = "industry") String industry, @RequestParam(value = "cNum") String cNum,
                                      @RequestParam(value = "capital") String capital, @RequestParam(value = "patents") String patents,
                                      @RequestParam(value = "cAddress") String cAddress, @RequestParam(value = "cPhone") String cPhone,
                                      @RequestParam(value = "cBlog") String cBlog, @RequestParam(value = "cMail") String cMail,
                                      @RequestParam(value = "cInfo") String cInfo, @RequestParam(value = "cId") int cId);

    @RequestMapping(value = "publishPosition" ,method = RequestMethod.GET)
    public int publishPosition(@RequestParam(value = "pName") String pName, @RequestParam(value = "salary") String salary,
                               @RequestParam(value = "num") int num, @RequestParam(value = "pInfo") String pInfo,
                               @RequestParam(value = "prequire") String prequire, @RequestParam(value = "place") String place,
                               @RequestParam(value = "cName") String cName, @RequestParam(value = "cId") int cId);

    @RequestMapping(value = "updatePosition" ,method = RequestMethod.GET)
    public int updatePosition(@RequestParam(value = "pName") String pName, @RequestParam(value = "salary") String salary,
                              @RequestParam(value = "num") int num, @RequestParam(value = "pInfo") String pInfo,
                              @RequestParam(value = "prequire") String prequire, @RequestParam(value = "place") String place,
                              @RequestParam(value = "pId") int pId);

    @RequestMapping(value = "deletePosition",method = RequestMethod.GET)
    public int deletePosition(@RequestParam(value = "pId") int pId);

    @RequestMapping(value = "findPositionLikepNameAndbId",method = RequestMethod.GET)
    public List<Position> findPositionLikepNameAndbId(@RequestParam(value = "pName") String pName,@RequestParam(value = "cId") int cId);
}
