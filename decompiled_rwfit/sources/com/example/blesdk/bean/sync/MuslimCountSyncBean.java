package com.example.blesdk.bean.sync;

import java.util.List;

/* loaded from: classes.dex */
public class MuslimCountSyncBean {
    private int itemCount;
    private List<MuslimCountItemBean> items;
    private long time;
    private int totalCount;

    public int getItemCount() {
        return this.itemCount;
    }

    public List<MuslimCountItemBean> getItems() {
        return this.items;
    }

    public long getTime() {
        return this.time;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public void setItemCount(int i3) {
        this.itemCount = i3;
    }

    public void setItems(List<MuslimCountItemBean> list) {
        this.items = list;
    }

    public void setTime(long j4) {
        this.time = j4;
    }

    public void setTotalCount(int i3) {
        this.totalCount = i3;
    }
}
