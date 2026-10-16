package com.example.database.table;

/* loaded from: classes.dex */
public class DataHeartRate {
    private int avgHr;
    private String date;

    /* renamed from: id, reason: collision with root package name */
    private Long f7369id;
    private boolean isUpdate;
    private String items;
    private String mac;
    private int maxHr;
    private int minHr;
    private String timestamp;
    private String userId;

    public DataHeartRate(Long l3, String str, String str2, String str3, String str4, String str5, int i3, int i10, int i11, boolean z5) {
        this.f7369id = l3;
        this.mac = str;
        this.userId = str2;
        this.timestamp = str3;
        this.date = str4;
        this.items = str5;
        this.avgHr = i3;
        this.maxHr = i10;
        this.minHr = i11;
        this.isUpdate = z5;
    }

    public int getAvgHr() {
        return this.avgHr;
    }

    public String getDate() {
        return this.date;
    }

    public Long getId() {
        return this.f7369id;
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

    public int getMaxHr() {
        return this.maxHr;
    }

    public int getMinHr() {
        return this.minHr;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAvgHr(int i3) {
        this.avgHr = i3;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(Long l3) {
        this.f7369id = l3;
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

    public void setMaxHr(int i3) {
        this.maxHr = i3;
    }

    public void setMinHr(int i3) {
        this.minHr = i3;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public DataHeartRate() {
    }
}
