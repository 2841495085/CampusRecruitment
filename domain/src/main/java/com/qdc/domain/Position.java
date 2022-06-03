package com.qdc.domain;

/**
 * 职位信息
 */
public class Position {
    private Integer pId; // 职位信息id
    private String pName; // 职位名称
    private String salary; // 薪资
    private String pInfo; // 职位工作内容
    private Integer num;  // 招聘人数
    private String prequire;  // 职位要求
    private String place; // 工作地点
    private String time;  // 发表时间
    private String cName;  // 公司名称
    private Integer cId; // 公司id


    public Position() {
    }

    public Position(Integer pId, String pName, String salary, String pInfo, Integer num, String prequire, String place, String time, String cName, Integer cId) {
        this.pId = pId;
        this.pName = pName;
        this.salary = salary;
        this.pInfo = pInfo;
        this.num = num;
        this.prequire = prequire;
        this.place = place;
        this.time = time;
        this.cName = cName;
        this.cId = cId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public String getpName() {
        return pName;
    }

    public void setpName(String pName) {
        this.pName = pName;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getpInfo() {
        return pInfo;
    }

    public void setpInfo(String pInfo) {
        this.pInfo = pInfo;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }


    public String getPrequire() {
        return prequire;
    }

    public void setPrequire(String prequire) {
        this.prequire = prequire;
    }

    @Override
    public String toString() {
        return "Position{" +
                "pId=" + pId +
                ", pName='" + pName + '\'' +
                ", salary='" + salary + '\'' +
                ", pInfo='" + pInfo + '\'' +
                ", num=" + num +
                ", prequire='" + prequire + '\'' +
                ", place='" + place + '\'' +
                ", time='" + time + '\'' +
                ", cName='" + cName + '\'' +
                ", cId=" + cId +
                '}';
    }
}
