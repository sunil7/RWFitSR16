package com.tencent.open.apireq;

import r5.a;

/* loaded from: classes2.dex */
public class BaseResp {
    public static final int CODE_ERROR_PARAMS = -2000;
    public static final int CODE_NOT_LOGIN = -2001;
    public static final int CODE_PERMISSION_NOT_GRANTED = -1003;
    public static final int CODE_QQ_LOW_VERSION = -1001;
    public static final int CODE_QQ_NOT_INSTALLED = -1000;
    public static final int CODE_SUCCESS = 0;
    public static final int CODE_UNSUPPORTED_BRANCH = -1002;

    /* renamed from: a, reason: collision with root package name */
    private int f11961a = 0;

    /* renamed from: b, reason: collision with root package name */
    private String f11962b = "";

    public String a(int i3) {
        return "Api call failed.";
    }

    public int getCode() {
        return this.f11961a;
    }

    public String getErrorMsg() {
        return this.f11962b;
    }

    public boolean isSuccess() {
        return this.f11961a == 0;
    }

    public void setCode(int i3) {
        String str;
        this.f11961a = i3;
        if (i3 == -2001) {
            str = "Not login.";
        } else if (i3 == -2000) {
            str = "The given params check failed.";
        } else if (i3 != 0) {
            switch (i3) {
                case CODE_UNSUPPORTED_BRANCH /* -1002 */:
                    str = "The QQ branch (e.g. TIM) is not supported";
                    break;
                case CODE_QQ_LOW_VERSION /* -1001 */:
                    str = "QQ version is too low.";
                    break;
                case CODE_QQ_NOT_INSTALLED /* -1000 */:
                    str = "QQ is not installed.";
                    break;
                default:
                    str = a(i3);
                    break;
            }
        } else {
            str = "";
        }
        setErrorMsg(str);
    }

    public void setErrorMsg(String str) {
        this.f11962b = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BaseResp{mCode=");
        sb2.append(this.f11961a);
        sb2.append(", mErrorMsg='");
        return a.f(sb2, this.f11962b, "'}");
    }
}
