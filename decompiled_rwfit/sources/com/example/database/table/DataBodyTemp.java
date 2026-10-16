package com.example.database.table;

/* loaded from: classes.dex */
public class DataBodyTemp {
    private float avgTemp;
    private String date;

    /* renamed from: id, reason: collision with root package name */
    private Long f7366id;
    private boolean isUpdate;
    private String items;
    private String mac;
    private float maxTemp;
    private float minTemp;
    private String timestamp;
    private String userId;

    public DataBodyTemp(Long l3, String str, String str2, String str3, String str4, String str5, float f2, float f10, float f11, boolean z5) {
        this.f7366id = l3;
        this.mac = str;
        this.userId = str2;
        this.timestamp = str3;
        this.date = str4;
        this.items = str5;
        this.avgTemp = f2;
        this.maxTemp = f10;
        this.minTemp = f11;
        this.isUpdate = z5;
    }

    public float getAvgTemp() {
        return this.avgTemp;
    }

    public String getDate() {
        return this.date;
    }

    public Long getId() {
        return this.f7366id;
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

    public float getMaxTemp() {
        return this.maxTemp;
    }

    public float getMinTemp() {
        return this.minTemp;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAvgTemp(float f2) {
        this.avgTemp = f2;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(Long l3) {
        this.f7366id = l3;
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

    public void setMaxTemp(float f2) {
        this.maxTemp = f2;
    }

    public void setMinTemp(float f2) {
        this.minTemp = f2;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public DataBodyTemp() {
    }
}
