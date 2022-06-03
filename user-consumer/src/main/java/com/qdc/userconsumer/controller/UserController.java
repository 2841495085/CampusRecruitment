package com.qdc.userconsumer.controller;


import com.qdc.domain.Company;
import com.qdc.domain.Position;
import com.qdc.userconsumer.service.ConsumerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    ConsumerService consumerService;


    @GetMapping(value = "/toIndex")
    public String toIndex(){
        return "index";
    }

    /**
     * 注册页面
     * @return
     */
    @GetMapping(value = "/toRegister")
    public String toRegister(HttpSession session,String msg){
        session.setAttribute("msg",msg);
        return "register";
    }

    @GetMapping(value = "/register")
    public String register(String uName,String uMail,String uPassword,String uType,HttpSession session){
        if (uType.equals("公司")){
            consumerService.register(uName,uMail,uPassword,uType);
            consumerService.add(uName);
            String msg = "Success!";
            session.setAttribute("msg",msg);
            return "redirect:/user/toRegister?msg="+msg;
        }
        consumerService.register(uName,uMail,uPassword,uType);
        String msg = "Success!";
        session.setAttribute("msg",msg);
        return "redirect:/user/toRegister?msg="+msg;

    }


    /**
     * 跳转登录页面
     * @param msg
     * @param session
     * @return
     */
    @GetMapping(value = "/toLogin")
    public String toLogin(String msg,HttpSession session){
        session.setAttribute("msg",msg);
        return "login";
    }


    /**
     * 退出登录
     * @param msg
     * @param session
     * @return
     */
    @GetMapping(value = "/quit")
    public String quit(String msg,HttpSession session){
        session.removeAttribute("cId");
        session.removeAttribute("cName");
        session.removeAttribute("uName");
        session.setAttribute("msg",msg);
        return "index";
    }


    /**
     * 进入主页面的响应
     * @param session
     * @param request
     * @return
     */
    @GetMapping(value = "/findAllPosition")
    public String findAllPosition(HttpSession session, HttpServletRequest request,String uName){
        session.setAttribute("i",consumerService.findAllPosition().size());
        request.setAttribute("position",consumerService.findAllPosition());
        session.setAttribute("uName",uName);

        // 招聘动态显示最后5条招聘信息
        List<Position> positionList = new ArrayList<>();
        for (int i=0;i<5;i++){
            positionList.add(consumerService.findAllPositionByOrder().get(i));
//            Collections.reverse(positionList);
            request.setAttribute("positionList",positionList);
        }

        // 热门公司显示前3条
        List<Company> companyList = new ArrayList<>();
        for (int i=0;i<3;i++){
            companyList.add(consumerService.findAllCompany().get(i));
            request.setAttribute("companyList",companyList);
        }
        return "index";
    }

    /**
     * 主页面、招聘信息详情页 搜索框
     * @param request
     * @param pName
     * @return
     */
    @GetMapping(value = "/findPositionLikepName")
    public String findPositionLikepName(HttpServletRequest request,String pName,HttpSession session){
        request.setAttribute("position",consumerService.findPositionLikepName(pName));
        session.setAttribute("i",consumerService.findPositionLikepName(pName).size());

        // 招聘动态显示最后5条招聘信息
        List<Position> positionList = new ArrayList<>();
        for (int i=0;i<5;i++){
            positionList.add(consumerService.findAllPositionByOrder().get(i));
//            Collections.reverse(positionList);
            request.setAttribute("positionList",positionList);
        }

        // 热门公司显示前3条
        List<Company> companyList = new ArrayList<>();
        for (int i=0;i<3;i++){
            companyList.add(consumerService.findAllCompany().get(i));
            request.setAttribute("companyList",companyList);
        }

        return "index";
    }


    /**
     * 招聘信息详情
     * @param pName
     * @param request
     * @return
     */
    @GetMapping(value = "/positionDetail")
    public String positionDetail(String pName,HttpServletRequest request,String uName,HttpSession session){
        session.setAttribute("uName",uName);
        request.setAttribute("position",consumerService.detail(pName));
        Integer cid = consumerService.detail(pName).getcId();
        request.setAttribute("company",consumerService.findCompanyBycId(cid));

        // 招聘动态显示最后5条招聘信息
        List<Position> positionList = new ArrayList<>();
        for (int i=0;i<5;i++){
            positionList.add(consumerService.findAllPositionByOrder().get(i));
            request.setAttribute("positionList",positionList);
        }
        return "detail";
    }

    /**
     * 公司信息详情
     * @param cName
     * @param request
     * @return
     */
    @GetMapping(value = "/companyDetail")
    public String companyDetail(String cName,HttpServletRequest request){
        request.setAttribute("company",consumerService.findCompanyBycName(cName));

        // 招聘动态显示最后5条招聘信息
        List<Position> positionList = new ArrayList<>();
        for (int i=0;i<5;i++){
            positionList.add(consumerService.findAllPositionByOrder().get(i));
            request.setAttribute("positionList",positionList);
        }
        return "company";
    }


    /**
     * 搜索框上方 按钮触发
     * 通过工作地点查询
     */

    @GetMapping(value = "/findPositionByPlace")
    public String findPositionByPlace(String place,HttpServletRequest request,HttpSession session){

        session.setAttribute("i",consumerService.findPositionByPlace(place).size());
        request.setAttribute("position",consumerService.findPositionByPlace(place));

        // 招聘动态显示最后5条招聘信息
        List<Position> positionList = new ArrayList<>();
        for (int i=0;i<5;i++){
            positionList.add(consumerService.findAllPositionByOrder().get(i));
//            Collections.reverse(positionList);
            request.setAttribute("positionList",positionList);
        }

        // 热门公司显示前3条
        List<Company> companyList = new ArrayList<>();
        for (int i=0;i<3;i++){
            companyList.add(consumerService.findAllCompany().get(i));
            request.setAttribute("companyList",companyList);
        }
        return "index";
    }


}
