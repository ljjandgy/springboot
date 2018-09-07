package com.gy.myproject.company.model;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * @Author: GY
 * @Date: 2018/8/30 14:14
 */
@TableName("company")
public class Company {
    @TableId
    private String compid;
    @TableField
    private String compname;
    @TableField
    private String adress;
    @TableField
    private String tel;
    @TableField
    private String email;
    @TableField
    private String boss;
    @TableField
    private String bandnumber;

    public String getCompid() {
        return compid;
    }

    public void setCompid(String compid) {
        this.compid = compid;
    }

    public String getCompname() {
        return compname;
    }

    public void setCompname(String compname) {
        this.compname = compname;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getBoss() {
        return boss;
    }

    public void setBoss(String boss) {
        this.boss = boss;
    }

    public String getBandnumber() {
        return bandnumber;
    }

    public void setBandnumber(String bandnumber) {
        this.bandnumber = bandnumber;
    }
}
