package org.java.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

import java.util.Date;

public class PurchaseOrder implements Serializable {
    private String purchaseOrderId;

    private Integer purchaseSupplierId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseOrderBegintime;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date purchaseOrderEndtime;

    private String purchaseAppllyOrderId;

    private String customerId;

    private String purchaseType;

    private String processinstanceId;

    private String purchaseUserId;

    public String getPurchaseOrderId() {
        return purchaseOrderId;
    }

    public void setPurchaseOrderId(String purchaseOrderId) {
        this.purchaseOrderId = purchaseOrderId == null ? null : purchaseOrderId.trim();
    }

    public Integer getPurchaseSupplierId() {
        return purchaseSupplierId;
    }

    public void setPurchaseSupplierId(Integer purchaseSupplierId) {
        this.purchaseSupplierId = purchaseSupplierId;
    }

    public Date getPurchaseOrderBegintime() {
        return purchaseOrderBegintime;
    }

    public void setPurchaseOrderBegintime(Date purchaseOrderBegintime) {
        this.purchaseOrderBegintime = purchaseOrderBegintime;
    }

    public Date getPurchaseOrderEndtime() {
        return purchaseOrderEndtime;
    }

    public void setPurchaseOrderEndtime(Date purchaseOrderEndtime) {
        this.purchaseOrderEndtime = purchaseOrderEndtime;
    }

    public String getPurchaseAppllyOrderId() {
        return purchaseAppllyOrderId;
    }

    public void setPurchaseAppllyOrderId(String purchaseAppllyOrderId) {
        this.purchaseAppllyOrderId = purchaseAppllyOrderId == null ? null : purchaseAppllyOrderId.trim();
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId == null ? null : customerId.trim();
    }

    public String getPurchaseType() {
        return purchaseType;
    }

    public void setPurchaseType(String purchaseType) {
        this.purchaseType = purchaseType == null ? null : purchaseType.trim();
    }

    public String getProcessinstanceId() {
        return processinstanceId;
    }

    public void setProcessinstanceId(String processinstanceId) {
        this.processinstanceId = processinstanceId == null ? null : processinstanceId.trim();
    }

    public String getPurchaseUserId() {
        return purchaseUserId;
    }

    public void setPurchaseUserId(String purchaseUserId) {
        this.purchaseUserId = purchaseUserId == null ? null : purchaseUserId.trim();
    }
}