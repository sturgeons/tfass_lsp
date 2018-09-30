package com.fxtech.ldplatform.os.models;

import javax.persistence.Id;

import com.fxtech.utils.StringHelper;
import com.fxtech.utils.UUIDGenerator;

/**
 * 菜单
 * 
 * @author FXStudio.Ajaxfan
 */
public class SystemMenu {
    @Id
    private String sysid;
    private String menuname;
    private String remark;
    private char islock = '0';

    public String getSysid() {
        if (StringHelper.isNullOrEmpty(sysid)) {
            return sysid = UUIDGenerator.random();
        }
        return sysid;
    }

    public void setSysid(String sysid) {
        this.sysid = sysid;
    }

    public String getMenuname() {
        return menuname;
    }

    public void setMenuname(String menuname) {
        this.menuname = menuname;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public char getIslock() {
        return islock;
    }

    public void setIslock(char islock) {
        this.islock = islock;
    }
}
