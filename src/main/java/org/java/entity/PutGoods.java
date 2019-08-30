package org.java.entity;

import java.io.Serializable;

public class PutGoods implements Serializable {
    private String putGoodsId;

    private String inGoodsId;

    private String warehousePositionId;

    private String putGoodsRemark;

    private String processinstanceid;

    private String putGoodsStatus;

    public String getPutGoodsId() {
        return putGoodsId;
    }

    public void setPutGoodsId(String putGoodsId) {
        this.putGoodsId = putGoodsId == null ? null : putGoodsId.trim();
    }

    public String getInGoodsId() {
        return inGoodsId;
    }

    public void setInGoodsId(String inGoodsId) {
        this.inGoodsId = inGoodsId == null ? null : inGoodsId.trim();
    }

    public String getWarehousePositionId() {
        return warehousePositionId;
    }

    public void setWarehousePositionId(String warehousePositionId) {
        this.warehousePositionId = warehousePositionId == null ? null : warehousePositionId.trim();
    }

    public String getPutGoodsRemark() {
        return putGoodsRemark;
    }

    public void setPutGoodsRemark(String putGoodsRemark) {
        this.putGoodsRemark = putGoodsRemark == null ? null : putGoodsRemark.trim();
    }

    public String getProcessinstanceid() {
        return processinstanceid;
    }

    public void setProcessinstanceid(String processinstanceid) {
        this.processinstanceid = processinstanceid == null ? null : processinstanceid.trim();
    }

    public String getPutGoodsStatus() {
        return putGoodsStatus;
    }

    public void setPutGoodsStatus(String putGoodsStatus) {
        this.putGoodsStatus = putGoodsStatus == null ? null : putGoodsStatus.trim();
    }
}