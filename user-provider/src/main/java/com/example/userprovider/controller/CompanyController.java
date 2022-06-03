package com.example.userprovider.controller;

import com.example.userprovider.dao.CompanyDao;
import com.qdc.domain.Company;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CompanyController {

    @Autowired
    CompanyDao companyDao;

    @RequestMapping(value = "findAllCompany" , method = RequestMethod.GET)
    public List<Company> findAllCompany(){
        return companyDao.findAllCompany();
    }

    @RequestMapping(value = "findCompanyBycName" , method = RequestMethod.GET)
    public Company findCompanyBycName(@RequestParam(value = "cName") String cName){
        return companyDao.findCompanyBycName(cName);
    }

    @RequestMapping(value = "findCompanyBycId" , method = RequestMethod.GET)
    public Company findCompanyBycId(@RequestParam(value = "cId") int cId){
        return companyDao.findCompanyBycId(cId);
    }

    @RequestMapping(value = "add" , method = RequestMethod.GET)
    public int add(@RequestParam(value = "cName") String cName){
        return companyDao.add(cName);
    }


}
