package com.example.network.bean;

import r5.a;

/* loaded from: classes.dex */
public class MemberFriendBean {
    private Long createTime;
    private Integer friendId;
    private String friendName;
    private String friendPortraitUrl;

    /* renamed from: id, reason: collision with root package name */
    private Integer f7397id;
    private Integer memberId;

    public Long getCreateTime() {
        return this.createTime;
    }

    public Integer getFriendId() {
        return this.friendId;
    }

    public String getFriendName() {
        return this.friendName;
    }

    public String getFriendPortraitUrl() {
        return this.friendPortraitUrl;
    }

    public Integer getId() {
        return this.f7397id;
    }

    public Integer getMemberId() {
        return this.memberId;
    }

    public void setCreateTime(Long l3) {
        this.createTime = l3;
    }

    public void setFriendId(Integer num) {
        this.friendId = num;
    }

    public void setFriendName(String str) {
        this.friendName = str;
    }

    public void setFriendPortraitUrl(String str) {
        this.friendPortraitUrl = str;
    }

    public void setId(Integer num) {
        this.f7397id = num;
    }

    public void setMemberId(Integer num) {
        this.memberId = num;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("MemberFriendBean{id=");
        sb2.append(this.f7397id);
        sb2.append(", memberId=");
        sb2.append(this.memberId);
        sb2.append(", friendId=");
        sb2.append(this.friendId);
        sb2.append(", friendName='");
        sb2.append(this.friendName);
        sb2.append("', createTime=");
        sb2.append(this.createTime);
        sb2.append(", friendPortraitUrl='");
        return a.f(sb2, this.friendPortraitUrl, "'}");
    }
}
