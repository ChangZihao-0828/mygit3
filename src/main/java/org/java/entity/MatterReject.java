package org.java.entity;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class MatterReject {
    private String matterRejectId;

    private String matterId;

    private String matterUserId;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date matterRejectDate;

    private String matterRejectReason;

    private Integer matterRejectCount;

    public String getMatterRejectId() {
        return matterRejectId;
    }

    public void setMatterRejectId(String matterRejectId) {
        this.matterRejectId = matterRejectId == null ? null : matterRejectId.trim();
    }

    public String getMatterId() {
        return matterId;
    }

    public void setMatterId(String matterId) {
        this.matterId = matterId == null ? null : matterId.trim();
    }

    public String getMatterUserId() {
        return matterUserId;
    }

    public void setMatterUserId(String matterUserId) {
        this.matterUserId = matterUserId == null ? null : matterUserId.trim();
    }

    public Date getMatterRejectDate() {
        return matterRejectDate;
    }

    public void setMatterRejectDate(Date matterRejectDate) {
        this.matterRejectDate = matterRejectDate;
    }

    public String getMatterRejectReason() {
        return matterRejectReason;
    }

    public void setMatterRejectReason(String matterRejectReason) {
        this.matterRejectReason = matterRejectReason == null ? null : matterRejectReason.trim();
    }

    public Integer getMatterRejectCount() {
        return matterRejectCount;
    }

    public void setMatterRejectCount(Integer matterRejectCount) {
        this.matterRejectCount = matterRejectCount;
    }
}