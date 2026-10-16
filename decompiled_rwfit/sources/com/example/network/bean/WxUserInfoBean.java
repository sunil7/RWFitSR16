package com.example.network.bean;

import r5.a;

/* loaded from: classes.dex */
public class WxUserInfoBean {
    private String headimgurl;
    private String nickname;
    private String openid;
    private int sex;

    public String getHeadimgurl() {
        return this.headimgurl;
    }

    public String getNickname() {
        return this.nickname;
    }

    public String getOpenid() {
        return this.openid;
    }

    public int getSex() {
        return this.sex;
    }

    public void setHeadimgurl(String str) {
        this.headimgurl = str;
    }

    public void setNickname(String str) {
        this.nickname = str;
    }

    public void setOpenid(String str) {
        this.openid = str;
    }

    public void setSex(int i3) {
        this.sex = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("WxUserInfoBean{openid='");
        sb2.append(this.openid);
        sb2.append("', nickname='");
        sb2.append(this.nickname);
        sb2.append("', sex=");
        sb2.append(this.sex);
        sb2.append(", headimgurl='");
        return a.f(sb2, this.headimgurl, "'}");
    }
}
