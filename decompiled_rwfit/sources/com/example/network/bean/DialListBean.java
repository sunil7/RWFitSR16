package com.example.network.bean;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public class DialListBean {
    private int classifyId;
    private String classifyName;
    private List<DialBean> dials;

    public int getClassifyId() {
        return this.classifyId;
    }

    public String getClassifyName() {
        return this.classifyName;
    }

    public List<DialBean> getDials() {
        return this.dials;
    }

    public void setClassifyId(int i3) {
        this.classifyId = i3;
    }

    public void setClassifyName(String str) {
        this.classifyName = str;
    }

    public void setDials(List<DialBean> list) {
        this.dials = list;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DialListBean{classifyId=");
        sb2.append(this.classifyId);
        sb2.append(", classifyName='");
        sb2.append(this.classifyName);
        sb2.append("', dials=");
        return l0.r(sb2, this.dials, '}');
    }
}
