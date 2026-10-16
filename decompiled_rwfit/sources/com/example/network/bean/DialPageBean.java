package com.example.network.bean;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public class DialPageBean {
    private List<DialBean> rows;
    private int total;

    public List<DialBean> getRows() {
        return this.rows;
    }

    public int getTotal() {
        return this.total;
    }

    public void setRows(List<DialBean> list) {
        this.rows = list;
    }

    public void setTotal(int i3) {
        this.total = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DialPageBean{total=");
        sb2.append(this.total);
        sb2.append(", rows=");
        return l0.r(sb2, this.rows, '}');
    }
}
