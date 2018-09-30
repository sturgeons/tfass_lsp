package com.fxtech.ldplatform.os.models;

import javax.persistence.Id;

import com.fxtech.utils.StringHelper;
import com.fxtech.utils.UUIDGenerator;

/**
 * 菜单项
 * 
 * @author FXStudio.Ajaxfan
 */
public class SystemMenuItem {
    @Id
    private String sysid;
    private String itemname;
    private String itemlink;
    private String islock = "0";

    public String getItemlink() {
        return itemlink;
    }

    public void setItemlink(String itemlink) {
        this.itemlink = itemlink;
    }

    public String getSysid() {
        if (StringHelper.isNullOrEmpty(sysid)) {
            return sysid = UUIDGenerator.random();
        }
        return sysid;
    }

    public void setSysid(String sysid) {
        this.sysid = sysid;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public String getIslock() {
        return islock;
    }

    public void setIslock(String islock) {
        this.islock = "on".equals(islock) ? "1" : islock;
    }
}
