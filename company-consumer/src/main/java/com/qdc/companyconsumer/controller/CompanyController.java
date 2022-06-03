package com.qdc.companyconsumer.controller;

import com.qdc.companyconsumer.service.CompanyService;
import com.qdc.domain.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;


@Controller
@RequestMapping(value = "/company")
public class CompanyController {

    @Autowired
    CompanyService companyService;



    /**
     * 处理登录请求
     * @param uMail
     * @param uPassword
     * @param uType
     * @return
     */
    @GetMapping(value = "/login")
    public String login(String uMail, String uPassword, String uType,HttpSession session) {
        if (uMail != null && uPassword != null && uType != null){
            if (uType.equals("个人")){
                if(companyService.login(uMail).getuPassword().equals(uPassword) && companyService.login(uMail).getuType().equals("个人")){
                    System.out.println("登录成功");
                    return "redirect:http://localhost:7004/user/findAllPosition?uName="+companyService.login(uMail).getuName();
                }
            }

            if (uType.equals("公司")){
                if(companyService.login(uMail).getuPassword().equals(uPassword) && companyService.login(uMail).getuType().equals("公司")){
                    System.out.println("登录成功");
                    session.setAttribute("uName",companyService.login(uMail).getuName());
                    Integer cId = companyService.findCompanyBycName(companyService.login(uMail).getuName()).getcId();
                    session.setAttribute("cId",cId);
                    return "redirect:/company/findPositionBycId?cId="+cId;
                }
            }
        }else{
            String msg = "Have null!";
            return "redirect:http://localhost:7004/user/toLogin?msg="+msg;
        }

        String msg = "Login failed!";
        return "redirect:http://localhost:7004/user/toLogin?msg="+msg;
    }


    /**
     * 通过cId查询职位信息，并返回到后台首页面
     * @param cId
     * @param request
     * @return
     */
    @GetMapping(value = "/findPositionBycId")
    public String findPositionBycId(String cId, HttpServletRequest request,HttpSession session){
        request.setAttribute("position",companyService.findPositionBycId(Integer.parseInt(cId)));
        int size = companyService.findPositionBycId(Integer.parseInt(cId)).size();
        session.setAttribute("size",size);
        return "backIndex";
    }


    /**
     * 更新公司信息，并返回此页面
     * @param chairman
     * @param industry
     * @param cNum
     * @param capital
     * @param patents
     * @param cAddress
     * @param cPhone
     * @param cBlog
     * @param cMail
     * @param cInfo
     * @param session
     * @return
     */


    @GetMapping(value = "/updateCompanyInfoBycId")
    public String updateCompanyInfoBycId(String chairman,String industry,
                                         String cNum, String capital,String patents,String cAddress,
                                         String cPhone,String cBlog,String cMail,String cInfo,
                                         HttpSession session){

        int cId = (int) session.getAttribute("cId");
        companyService.updateCompanyInfoBycId(chairman,industry,cNum,capital,patents,cAddress,cPhone,cBlog,cMail,cInfo,cId);
        return "redirect:/company/toCompanyInfo?cId="+cId;
    }

    /**
     * 跳转公司信息页面,展示公司详细信息
     */
    @GetMapping(value = "/toCompanyInfo")
    public String toCompanyInfo(String cId,HttpServletRequest request,HttpSession session){
        request.setAttribute("company",companyService.findCompanyBycId(Integer.parseInt(cId)));
        session.setAttribute("cId",Integer.parseInt(cId));
        return "companyinfo";
    }


    /**
     * 发布职位信息
     * @param session
     * @param cId
     * @return
     */
    @GetMapping(value = "/toPublishPosition")
    public String toPublishPosition(HttpSession session,String cId){
        session.setAttribute("cName",companyService.findCompanyBycId(Integer.parseInt(cId)).getcName());
        session.setAttribute("cId",Integer.parseInt(cId));
        return "publishposition";
    }


    @GetMapping(value = "/publishPosition")
    public String publishPosition(HttpSession session,String pName, String salary,String num,
                                  String pInfo, String prequire, String place){
        int cId = (int) session.getAttribute("cId");
        companyService.publishPosition(pName,salary,Integer.parseInt(num),pInfo,prequire,place,
                companyService.findCompanyBycId(cId).getcName(),cId);
        session.setAttribute("cName",companyService.findCompanyBycId(cId).getcName());
        session.setAttribute("cId",String.valueOf(cId));
        return "redirect:/company/findPositionBycId?cId="+cId;
    }


    /**
     * 修改职位信息
     * @param request
     * @param session
     * @param pId
     * @param cId
     * @return
     */
    @GetMapping(value = "/toUpdatePosition")
    public String toUpdatePosition(HttpServletRequest request,HttpSession session,String pId,String cId){
        session.setAttribute("cName",companyService.findCompanyBycId(Integer.parseInt(cId)).getcName());
        session.setAttribute("cId",Integer.parseInt(cId));
        Position position = companyService.getPositionBypId(Integer.parseInt(pId));
        request.setAttribute("position",position);
        return "updateposition";
    }

    @GetMapping(value = "/updatePosition")
    public String updatePosition(HttpSession session,String pName, String salary,String num,
                                  String pInfo, String prequire, String place,String cId,String pId){
        companyService.updatePosition(pName,salary,Integer.parseInt(num),pInfo,prequire,place,Integer.parseInt(pId));
        session.setAttribute("cName",companyService.findCompanyBycId(Integer.parseInt(cId)).getcName());
        session.setAttribute("cId",cId);
        return "redirect:/company/findPositionBycId?cId="+String.valueOf(cId);
    }

    /**
     * 删除职位信息
     * @param pId
     * @param cId
     * @return
     */
    @GetMapping(value = "deletePosition")
    public String deletePosition(String pId,String cId){
        companyService.deletePosition(Integer.parseInt(pId));
        return "redirect:/company/findPositionBycId?cId="+cId;
    }


    @GetMapping(value = "/findPositionLikepNameAndbId")
    public String findPositionLikepNameAndbId(String pName,HttpServletRequest request,HttpSession session){
        int cId = (int) session.getAttribute("cId");
        request.setAttribute("position",companyService.findPositionLikepNameAndbId(pName, cId));
        session.setAttribute("cId",String.valueOf(cId));
        session.setAttribute("size",companyService.findPositionLikepNameAndbId(pName,cId).size());
        return "backIndex";
    }






}
