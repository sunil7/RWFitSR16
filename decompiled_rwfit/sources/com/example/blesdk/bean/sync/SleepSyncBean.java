package com.example.blesdk.bean.sync;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public class SleepSyncBean {
    private long asleepTime;
    private long awakeTime;
    private int itemCount;
    private List<SleepItemBean> items;
    private long time;
    private long totalSleepTime;

    public long getAsleepTime() {
        return this.asleepTime;
    }

    public long getAwakeTime() {
        return this.awakeTime;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public List<SleepItemBean> getItems() {
        return this.items;
    }

    public long getTime() {
        return this.time;
    }

    public long getTotalSleepTime() {
        return this.totalSleepTime;
    }

    public void setAsleepTime(long j4) {
        this.asleepTime = j4;
    }

    public void setAwakeTime(long j4) {
        this.awakeTime = j4;
    }

    public void setItemCount(int i3) {
        this.itemCount = i3;
    }

    public void setItems(List<SleepItemBean> list) {
        this.items = list;
    }

    public void setTime(long j4) {
        this.time = j4;
    }

    public void setTotalSleepTime(long j4) {
        this.totalSleepTime = j4;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("SleepBean{time=");
        sb2.append(this.time);
        sb2.append(", totalSleepTime=");
        sb2.append(this.totalSleepTime);
        sb2.append(", asleepTime=");
        sb2.append(this.asleepTime);
        sb2.append(", awakeTime=");
        sb2.append(this.awakeTime);
        sb2.append(", itemCount=");
        sb2.append(this.itemCount);
        sb2.append(", items=");
        return l0.r(sb2, this.items, '}');
    }
}
