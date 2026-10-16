package com.example.network.bean;

import r5.a;

/* loaded from: classes.dex */
public class MemberFriendApplyBean {
    private String account;
    private Long applyTime;
    private Integer friendId;
    private String friendPortraitUrl;

    /* renamed from: id, reason: collision with root package name */
    private Integer f7396id;
    private Integer memberId;
    private Integer status;

    public String getAccount() {
        return this.account;
    }

    public Long getApplyTime() {
        return this.applyTime;
    }

    public Integer getFriendId() {
        return this.friendId;
    }

    public String getFriendPortraitUrl() {
        return this.friendPortraitUrl;
    }

    public Integer getId() {
        return this.f7396id;
    }

    public Integer getMemberId() {
        return this.memberId;
    }

    public Integer getStatus() {
        return this.status;
    }

    public void setAccount(String str) {
        this.account = str;
    }

    public void setApplyTime(Long l3) {
        this.applyTime = l3;
    }

    public void setFriendId(Integer num) {
        this.friendId = num;
    }

    public void setFriendPortraitUrl(String str) {
        this.friendPortraitUrl = str;
    }

    public void setId(Integer num) {
        this.f7396id = num;
    }

    public void setMemberId(Integer num) {
        this.memberId = num;
    }

    public void setStatus(Integer num) {
        this.status = num;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("MemberFriendApplyBean{id=");
        sb2.append(this.f7396id);
        sb2.append(", memberId=");
        sb2.append(this.memberId);
        sb2.append(", friendId=");
        sb2.append(this.friendId);
        sb2.append(", status=");
        sb2.append(this.status);
        sb2.append(", applyTime=");
        sb2.append(this.applyTime);
        sb2.append(", account='");
        sb2.append(this.account);
        sb2.append("', friendPortraitUrl='");
        return a.f(sb2, this.friendPortraitUrl, "'}");
    }
}
