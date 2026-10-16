package com.example.blesdk.bean.sync;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;

/* loaded from: classes.dex */
public class StepSyncBean {
    private String date;
    private String hour;
    private int itemCount;
    private List<StepItemBean> items;
    private long time;
    private int totalCalorie;
    private int totalDistance;
    private int totalSteps;

    public String getDate() {
        return this.date;
    }

    public String getHour() {
        return this.hour;
    }

    public int getItemCount() {
        return this.itemCount;
    }

    public List<StepItemBean> getItems() {
        return this.items;
    }

    public long getTime() {
        return this.time;
    }

    public int getTotalCalorie() {
        return this.totalCalorie;
    }

    public int getTotalDistance() {
        return this.totalDistance;
    }

    public int getTotalSteps() {
        return this.totalSteps;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setHour(String str) {
        this.hour = str;
    }

    public void setItemCount(int i3) {
        this.itemCount = i3;
    }

    public void setItems(List<StepItemBean> list) {
        this.items = list;
    }

    public void setTime(long j4) {
        this.time = j4;
    }

    public void setTotalCalorie(int i3) {
        this.totalCalorie = i3;
    }

    public void setTotalDistance(int i3) {
        this.totalDistance = i3;
    }

    public void setTotalSteps(int i3) {
        this.totalSteps = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("StepSyncBean{time=");
        sb2.append(this.time);
        sb2.append(", totalSteps=");
        sb2.append(this.totalSteps);
        sb2.append(", totalCalorie=");
        sb2.append(this.totalCalorie);
        sb2.append(", totalDistance=");
        sb2.append(this.totalDistance);
        sb2.append(", itemCount=");
        sb2.append(this.itemCount);
        sb2.append(", items=");
        return l0.r(sb2, this.items, '}');
    }
}
