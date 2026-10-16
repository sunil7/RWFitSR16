package com.example.network.base;

import java.io.Serializable;

/* loaded from: classes.dex */
public class HttpModel<T> implements Serializable {
    private int code;
    private T data;
    private String msg;

    public int getCode() {
        return this.code;
    }

    public String getMsg() {
        return this.msg;
    }

    public T getResults() {
        return this.data;
    }

    public Boolean isSuccess() {
        return Boolean.valueOf(this.code == 0);
    }

    public void setCode(int i3) {
        this.code = i3;
    }
}
