package org.java.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class PurchaseAppllyOrder implements Serializable {
    private String purchaseAppllyOrderId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseAppllyOrderBegintime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseAppllyOrderEndtime;

    private String purchaseAppllyUserName;

    private String purchaseAppllyRemark;

    private String processinstanceId;

    private String purchaseAppllyPrice;

    private String purchaseAppllyTaskid;

    public String getPurchaseAppllyOrderId() {
        return purchaseAppllyOrderId;
    }

    public void setPurchaseAppllyOrderId(String purchaseAppllyOrderId) {
        this.purchaseAppllyOrderId = purchaseAppllyOrderId == null ? null : purchaseAppllyOrderId.trim();
    }

    public Date getPurchaseAppllyOrderBegintime() {
        return purchaseAppllyOrderBegintime;
    }

    public void setPurchaseAppllyOrderBegintime(Date purchaseAppllyOrderBegintime) {
        this.purchaseAppllyOrderBegintime = purchaseAppllyOrderBegintime;
    }

    public Date getPurchaseAppllyOrderEndtime() {
        return purchaseAppllyOrderEndtime;
    }

    public void setPurchaseAppllyOrderEndtime(Date purchaseAppllyOrderEndtime) {
        this.purchaseAppllyOrderEndtime = purchaseAppllyOrderEndtime;
    }

    public String getPurchaseAppllyUserName() {
        return purchaseAppllyUserName;
    }

    public void setPurchaseAppllyUserName(String purchaseAppllyUserName) {
        this.purchaseAppllyUserName = purchaseAppllyUserName == null ? null : purchaseAppllyUserName.trim();
    }

    public String getPurchaseAppllyRemark() {
        return purchaseAppllyRemark;
    }

    public void setPurchaseAppllyRemark(String purchaseAppllyRemark) {
        this.purchaseAppllyRemark = purchaseAppllyRemark == null ? null : purchaseAppllyRemark.trim();
    }

    public String getProcessinstanceId() {
        return processinstanceId;
    }

    public void setProcessinstanceId(String processinstanceId) {
        this.processinstanceId = processinstanceId == null ? null : processinstanceId.trim();
    }

    public String getPurchaseAppllyPrice() {
        return purchaseAppllyPrice;
    }

    public void setPurchaseAppllyPrice(String purchaseAppllyPrice) {
        this.purchaseAppllyPrice = purchaseAppllyPrice == null ? null : purchaseAppllyPrice.trim();
    }

    public String getPurchaseAppllyTaskid() {
        return purchaseAppllyTaskid;
    }

    public void setPurchaseAppllyTaskid(String purchaseAppllyTaskid) {
        this.purchaseAppllyTaskid = purchaseAppllyTaskid == null ? null : purchaseAppllyTaskid.trim();
    }
}