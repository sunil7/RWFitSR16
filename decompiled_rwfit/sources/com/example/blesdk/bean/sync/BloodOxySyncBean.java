package com.example.blesdk.bean.sync;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public class BloodOxySyncBean {
    private int itemCount;
    private List<BloodOxyItemBean> items;
    private long time;

    public int getItemCount() {
        return this.itemCount;
    }

    public List<BloodOxyItemBean> getItems() {
        return this.items;
    }

    public long getTime() {
        return this.time;
    }

    public void setItemCount(int i3) {
        this.itemCount = i3;
    }

    public void setItems(List<BloodOxyItemBean> list) {
        this.items = list;
    }

    public void setTime(long j4) {
        this.time = j4;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("BloodOxySyncBean{time=");
        sb2.append(this.time);
        sb2.append(", itemCount=");
        sb2.append(this.itemCount);
        sb2.append(", items=");
        return l0.r(sb2, this.items, '}');
    }
}
