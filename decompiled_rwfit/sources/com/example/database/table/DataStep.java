package com.example.database.table;

/* loaded from: classes.dex */
public class DataStep {
    private float calorie;
    private String date;
    private float distance;

    /* renamed from: id, reason: collision with root package name */
    private Long f7376id;
    private boolean isUpdate;
    private String items;
    private String mac;
    private String timestamp;
    private int totalStep;
    private String userId;

    public DataStep(Long l3, String str, String str2, String str3, String str4, String str5, int i3, float f2, float f10, boolean z5) {
        this.f7376id = l3;
        this.mac = str;
        this.userId = str2;
        this.timestamp = str3;
        this.date = str4;
        this.items = str5;
        this.totalStep = i3;
        this.calorie = f2;
        this.distance = f10;
        this.isUpdate = z5;
    }

    public float getCalorie() {
        return this.calorie;
    }

    public String getDate() {
        return this.date;
    }

    public float getDistance() {
        return this.distance;
    }

    public Long getId() {
        return this.f7376id;
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

    public String getTimestamp() {
        return this.timestamp;
    }

    public int getTotalStep() {
        return this.totalStep;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setCalorie(float f2) {
        this.calorie = f2;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setDistance(float f2) {
        this.distance = f2;
    }

    public void setId(Long l3) {
        this.f7376id = l3;
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

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setTotalStep(int i3) {
        this.totalStep = i3;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public DataStep() {
    }
}
