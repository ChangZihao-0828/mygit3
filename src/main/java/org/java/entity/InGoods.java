package org.java.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class InGoods implements Serializable {
    private String inGoodsId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inGoodsIntime;

    private String warehouseId;

    private String prepareGoodsId;

    private String processinstanceId;

    private String inGoodsStatus;

    private String inGoodsTaskid;

    public String getInGoodsId() {
        return inGoodsId;
    }

    public void setInGoodsId(String inGoodsId) {
        this.inGoodsId = inGoodsId == null ? null : inGoodsId.trim();
    }

    public Date getInGoodsIntime() {
        return inGoodsIntime;
    }

    public void setInGoodsIntime(Date inGoodsIntime) {
        this.inGoodsIntime = inGoodsIntime;
    }

    public String getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(String warehouseId) {
        this.warehouseId = warehouseId == null ? null : warehouseId.trim();
    }

    public String getPrepareGoodsId() {
        return prepareGoodsId;
    }

    public void setPrepareGoodsId(String prepareGoodsId) {
        this.prepareGoodsId = prepareGoodsId == null ? null : prepareGoodsId.trim();
    }

    public String getProcessinstanceId() {
        return processinstanceId;
    }

    public void setProcessinstanceId(String processinstanceId) {
        this.processinstanceId = processinstanceId == null ? null : processinstanceId.trim();
    }

    public String getInGoodsStatus() {
        return inGoodsStatus;
    }

    public void setInGoodsStatus(String inGoodsStatus) {
        this.inGoodsStatus = inGoodsStatus == null ? null : inGoodsStatus.trim();
    }

    public String getInGoodsTaskid() {
        return inGoodsTaskid;
    }

    public void setInGoodsTaskid(String inGoodsTaskid) {
        this.inGoodsTaskid = inGoodsTaskid == null ? null : inGoodsTaskid.trim();
    }
}