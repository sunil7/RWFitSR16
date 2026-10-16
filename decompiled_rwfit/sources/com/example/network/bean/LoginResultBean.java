package com.example.network.bean;

import r5.a;

/* loaded from: classes.dex */
public class LoginResultBean {
    private String accessToken;
    private String memberId;

    public String getAccessToken() {
        return this.accessToken;
    }

    public String getMemberId() {
        return this.memberId;
    }

    public void setAccessToken(String str) {
        this.accessToken = str;
    }

    public void setMemberId(String str) {
        this.memberId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("LoginResultBean{accessToken='");
        sb2.append(this.accessToken);
        sb2.append("', memberId='");
        return a.f(sb2, this.memberId, "'}");
    }
}
