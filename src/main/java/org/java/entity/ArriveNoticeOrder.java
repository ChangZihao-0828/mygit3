package org.java.entity;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

public class ArriveNoticeOrder implements Serializable {
    private String arriveNoticeOrderId;

    private String inGoodsId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date inGoodsArrivedDate;

    private String arriveNoticeOrderDeliverGoodsMan;

    private String arriveNoticeOrderStatus;

    private String processinstanceId;

    private String arriveNoticeOrderTaskid;

    public String getArriveNoticeOrderId() {
        return arriveNoticeOrderId;
    }

    public void setArriveNoticeOrderId(String arriveNoticeOrderId) {
        this.arriveNoticeOrderId = arriveNoticeOrderId == null ? null : arriveNoticeOrderId.trim();
    }

    public String getInGoodsId() {
        return inGoodsId;
    }

    public void setInGoodsId(String inGoodsId) {
        this.inGoodsId = inGoodsId == null ? null : inGoodsId.trim();
    }

    public Date getInGoodsArrivedDate() {
        return inGoodsArrivedDate;
    }

    public void setInGoodsArrivedDate(Date inGoodsArrivedDate) {
        this.inGoodsArrivedDate = inGoodsArrivedDate;
    }

    public String getArriveNoticeOrderDeliverGoodsMan() {
        return arriveNoticeOrderDeliverGoodsMan;
    }

    public void setArriveNoticeOrderDeliverGoodsMan(String arriveNoticeOrderDeliverGoodsMan) {
        this.arriveNoticeOrderDeliverGoodsMan = arriveNoticeOrderDeliverGoodsMan == null ? null : arriveNoticeOrderDeliverGoodsMan.trim();
    }

    public String getArriveNoticeOrderStatus() {
        return arriveNoticeOrderStatus;
    }

    public void setArriveNoticeOrderStatus(String arriveNoticeOrderStatus) {
        this.arriveNoticeOrderStatus = arriveNoticeOrderStatus == null ? null : arriveNoticeOrderStatus.trim();
    }

    public String getProcessinstanceId() {
        return processinstanceId;
    }

    public void setProcessinstanceId(String processinstanceId) {
        this.processinstanceId = processinstanceId == null ? null : processinstanceId.trim();
    }

    public String getArriveNoticeOrderTaskid() {
        return arriveNoticeOrderTaskid;
    }

    public void setArriveNoticeOrderTaskid(String arriveNoticeOrderTaskid) {
        this.arriveNoticeOrderTaskid = arriveNoticeOrderTaskid == null ? null : arriveNoticeOrderTaskid.trim();
    }
}