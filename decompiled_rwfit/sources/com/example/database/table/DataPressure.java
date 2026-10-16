package com.example.database.table;

/* loaded from: classes.dex */
public class DataPressure {
    private int avgPressure;
    private String date;

    /* renamed from: id, reason: collision with root package name */
    private Long f7371id;
    private boolean isUpdate;
    private String items;
    private String mac;
    private int maxPressure;
    private int minPressure;
    private String timestamp;
    private String userId;

    public DataPressure(Long l3, String str, String str2, String str3, String str4, String str5, int i3, int i10, int i11, boolean z5) {
        this.f7371id = l3;
        this.mac = str;
        this.userId = str2;
        this.timestamp = str3;
        this.date = str4;
        this.items = str5;
        this.avgPressure = i3;
        this.maxPressure = i10;
        this.minPressure = i11;
        this.isUpdate = z5;
    }

    public int getAvgPressure() {
        return this.avgPressure;
    }

    public String getDate() {
        return this.date;
    }

    public Long getId() {
        return this.f7371id;
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

    public int getMaxPressure() {
        return this.maxPressure;
    }

    public int getMinPressure() {
        return this.minPressure;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAvgPressure(int i3) {
        this.avgPressure = i3;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(Long l3) {
        this.f7371id = l3;
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

    public void setMaxPressure(int i3) {
        this.maxPressure = i3;
    }

    public void setMinPressure(int i3) {
        this.minPressure = i3;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public DataPressure() {
    }
}
