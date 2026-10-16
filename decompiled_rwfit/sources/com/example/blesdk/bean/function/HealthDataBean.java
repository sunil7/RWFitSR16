package com.example.blesdk.bean.function;

/* loaded from: classes.dex */
public class HealthDataBean<T> {
    private T data;
    private int dataType;

    public T getData() {
        return this.data;
    }

    public int getDataType() {
        return this.dataType;
    }

    public void setData(T t8) {
        this.data = t8;
    }

    public void setDataType(int i3) {
        this.dataType = i3;
    }
}
