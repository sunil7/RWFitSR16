package com.example.blesdk.bean.sync;

import java.util.List;

/* loaded from: classes.dex */
public class BloodSugarSyncBean {
    private int itemCount;
    private List<BloodSugarItemBean> items;
    private long time;

    public int getItemCount() {
        return this.itemCount;
    }

    public List<BloodSugarItemBean> getItems() {
        return this.items;
    }

    public long getTime() {
        return this.time;
    }

    public void setItemCount(int i3) {
        this.itemCount = i3;
    }

    public void setItems(List<BloodSugarItemBean> list) {
        this.items = list;
    }

    public void setTime(long j4) {
        this.time = j4;
    }
}
