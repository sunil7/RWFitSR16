package com.example.database.table;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class DataMuslimCount {
    private int avgCount;
    private String date;

    /* renamed from: id, reason: collision with root package name */
    private Long f7370id;
    private boolean isUpdate;
    private String items;
    private String mac;
    private int maxCount;
    private int minCount;
    private String timestamp;
    private int totalCount;
    private String userId;

    public DataMuslimCount(Long l3, String str, String str2, String str3, String str4, String str5, int i3, int i10, int i11, int i12, boolean z5) {
        this.f7370id = l3;
        this.mac = str;
        this.userId = str2;
        this.timestamp = str3;
        this.date = str4;
        this.items = str5;
        this.avgCount = i3;
        this.maxCount = i10;
        this.minCount = i11;
        this.totalCount = i12;
        this.isUpdate = z5;
    }

    public int getAvgCount() {
        return this.avgCount;
    }

    public String getDate() {
        return this.date;
    }

    public Long getId() {
        return this.f7370id;
    }

    public boolean getIsUpdate() {
        return this.isUpdate;
    }

    public String getItems() {
        return this.items;
    }

    public String getMac() {
        return this.mac;
    }

    public int getMaxCount() {
        return this.maxCount;
    }

    public int getMinCount() {
        return this.minCount;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAvgCount(int i3) {
        this.avgCount = i3;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(Long l3) {
        this.f7370id = l3;
    }

    public void setIsUpdate(boolean z5) {
        this.isUpdate = z5;
    }

    public void setItems(String str) {
        this.items = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setMaxCount(int i3) {
        this.maxCount = i3;
    }

    public void setMinCount(int i3) {
        this.minCount = i3;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setTotalCount(int i3) {
        this.totalCount = i3;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("DataMuslimCount{id='");
        sb2.append(this.f7370id);
        sb2.append("', mac='");
        sb2.append(this.mac);
        sb2.append("', userId='");
        sb2.append(this.userId);
        sb2.append("', timestamp=");
        sb2.append(this.timestamp);
        sb2.append(", date='");
        sb2.append(this.date);
        sb2.append("', items=");
        sb2.append(this.items);
        sb2.append(", avgCount=");
        sb2.append(this.avgCount);
        sb2.append(", maxCount=");
        sb2.append(this.maxCount);
        sb2.append(", minCount=");
        sb2.append(this.minCount);
        sb2.append(", totalCount=");
        sb2.append(this.totalCount);
        sb2.append(", isUpdate=");
        return e.o(sb2, this.isUpdate, '}');
    }

    public DataMuslimCount() {
    }
}
