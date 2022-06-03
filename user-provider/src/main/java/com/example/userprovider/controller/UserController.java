package com.example.userprovider.controller;

import com.example.userprovider.dao.UserDao;
import com.qdc.domain.Position;
import com.qdc.domain.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserDao userDao;

    @RequestMapping(value = "findAllPosition" ,method = RequestMethod.GET)
    public List<Position> findAllPosition(){
        return userDao.findAllPosition();
    }

    @RequestMapping(value = "detail" ,method = RequestMethod.GET)
    public Position detail(@RequestParam(value = "pName") String pName){
        return userDao.findPositionBypName(pName);
    }

    @RequestMapping(value = "findPositionLikepName" ,method = RequestMethod.GET)
    public List<Position> findPositionLikepName(@RequestParam(value = "pName") String pName){
        return userDao.findPositionLikepName(pName);
    }

    @RequestMapping(value = "findAllPositionByOrder" ,method = RequestMethod.GET)
    public List<Position> findAllPositionByOrder(){
        return userDao.findAllPositionByOrder();
    }

    @RequestMapping(value = "findPositionByPlace" , method = RequestMethod.GET)
    public List<Position> findPositionByPlace(@RequestParam(value = "place") String place){
        return userDao.findPositionByPlace(place);
    }

    @RequestMapping(value = "register",method = RequestMethod.GET)
    public int register(@RequestParam(value = "uName") String uName, @RequestParam(value = "uMail") String uMail,
                        @RequestParam(value = "uPassword") String uPassword, @RequestParam(value = "uType") String uType){
        return userDao.register(uName,uMail,uPassword,uType);
    }




}
