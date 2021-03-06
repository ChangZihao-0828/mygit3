package org.java.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class InEquipGoods implements Serializable {
    private String inEquipGoodsId;

    private String inGoodsId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inEquipGoodsBegintime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inEquipGoodsEndtime;

    private String inEquipGoodsPeople;

    private String inEquipGoodsStatus;

    private String processinstanceId;

    private String inEquipGoodsTaskid;

    public String getInEquipGoodsId() {
        return inEquipGoodsId;
    }

    public void setInEquipGoodsId(String inEquipGoodsId) {
        this.inEquipGoodsId = inEquipGoodsId == null ? null : inEquipGoodsId.trim();
    }

    public String getInGoodsId() {
        return inGoodsId;
    }

    public void setInGoodsId(String inGoodsId) {
        this.inGoodsId = inGoodsId == null ? null : inGoodsId.trim();
    }

    public Date getInEquipGoodsBegintime() {
        return inEquipGoodsBegintime;
    }

    public void setInEquipGoodsBegintime(Date inEquipGoodsBegintime) {
        this.inEquipGoodsBegintime = inEquipGoodsBegintime;
    }

    public Date getInEquipGoodsEndtime() {
        return inEquipGoodsEndtime;
    }

    public void setInEquipGoodsEndtime(Date inEquipGoodsEndtime) {
        this.inEquipGoodsEndtime = inEquipGoodsEndtime;
    }

    public String getInEquipGoodsPeople() {
        return inEquipGoodsPeople;
    }

    public void setInEquipGoodsPeople(String inEquipGoodsPeople) {
        this.inEquipGoodsPeople = inEquipGoodsPeople == null ? null : inEquipGoodsPeople.trim();
    }

    public String getInEquipGoodsStatus() {
        return inEquipGoodsStatus;
    }

    public void setInEquipGoodsStatus(String inEquipGoodsStatus) {
        this.inEquipGoodsStatus = inEquipGoodsStatus == null ? null : inEquipGoodsStatus.trim();
    }

    public String getProcessinstanceId() {
        return processinstanceId;
    }

    public void setProcessinstanceId(String processinstanceId) {
        this.processinstanceId = processinstanceId == null ? null : processinstanceId.trim();
    }

    public String getInEquipGoodsTaskid() {
        return inEquipGoodsTaskid;
    }

    public void setInEquipGoodsTaskid(String inEquipGoodsTaskid) {
        this.inEquipGoodsTaskid = inEquipGoodsTaskid == null ? null : inEquipGoodsTaskid.trim();
    }
}