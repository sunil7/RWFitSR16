package com.example.database.table;

/* loaded from: classes.dex */
public class DataBloodSugar {
    private float avgSugar;
    private String date;

    /* renamed from: id, reason: collision with root package name */
    private Long f7365id;
    private boolean isUpdate;
    private String items;
    private String mac;
    private float maxSugar;
    private float minSugar;
    private String timestamp;
    private String userId;

    public DataBloodSugar(Long l3, String str, String str2, String str3, String str4, String str5, float f2, float f10, float f11, boolean z5) {
        this.f7365id = l3;
        this.mac = str;
        this.userId = str2;
        this.timestamp = str3;
        this.date = str4;
        this.items = str5;
        this.avgSugar = f2;
        this.maxSugar = f10;
        this.minSugar = f11;
        this.isUpdate = z5;
    }

    public float getAvgSugar() {
        return this.avgSugar;
    }

    public String getDate() {
        return this.date;
    }

    public Long getId() {
        return this.f7365id;
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

    public float getMaxSugar() {
        return this.maxSugar;
    }

    public float getMinSugar() {
        return this.minSugar;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAvgSugar(float f2) {
        this.avgSugar = f2;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(Long l3) {
        this.f7365id = l3;
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

    public void setMaxSugar(float f2) {
        this.maxSugar = f2;
    }

    public void setMinSugar(float f2) {
        this.minSugar = f2;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public DataBloodSugar() {
    }
}
