package com.qdc.domain;

public class Company {
    private Integer cId;
    private String cName;
    private String chairman; // 现任董事长
    private String industry; // 所属行业
//    private String cPassword; // 后台登陆密码
    private String cNum;     // 员工数
    private String capital;  // 注册资本
    private String patents;  // 公司专利数量
    private String cAddress; // 公司地址
    private String cPhone;   // 公司电话
    private String cBlog;    // 官方微博
    private String cMail;    // 公司邮箱
    private String cInfo;    // 公司详细介绍

    public Company() {
    }

    public Company(Integer cId, String cName, String chairman, String industry, String cNum, String capital, String patents, String cAddress, String cPhone, String cBlog, String cMail, String cInfo) {
        this.cId = cId;
        this.cName = cName;
        this.chairman = chairman;
        this.industry = industry;
        this.cNum = cNum;
        this.capital = capital;
        this.patents = patents;
        this.cAddress = cAddress;
        this.cPhone = cPhone;
        this.cBlog = cBlog;
        this.cMail = cMail;
        this.cInfo = cInfo;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getChairman() {
        return chairman;
    }

    public void setChairman(String chairman) {
        this.chairman = chairman;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getcNum() {
        return cNum;
    }

    public void setcNum(String cNum) {
        this.cNum = cNum;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getPatents() {
        return patents;
    }

    public void setPatents(String patents) {
        this.patents = patents;
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone;
    }

    public String getcBlog() {
        return cBlog;
    }

    public void setcBlog(String cBlog) {
        this.cBlog = cBlog;
    }

    public String getcMail() {
        return cMail;
    }

    public void setcMail(String cMail) {
        this.cMail = cMail;
    }

    public String getcInfo() {
        return cInfo;
    }

    public void setcInfo(String cInfo) {
        this.cInfo = cInfo;
    }


    @Override
    public String toString() {
        return "Company{" +
                "cId=" + cId +
                ", cName='" + cName + '\'' +
                ", chairman='" + chairman + '\'' +
                ", industry='" + industry + '\'' +
                ", cNum='" + cNum + '\'' +
                ", capital='" + capital + '\'' +
                ", patents='" + patents + '\'' +
                ", cAddress='" + cAddress + '\'' +
                ", cPhone='" + cPhone + '\'' +
                ", cBlog='" + cBlog + '\'' +
                ", cMail='" + cMail + '\'' +
                ", cInfo='" + cInfo + '\'' +
                '}';
    }
}
