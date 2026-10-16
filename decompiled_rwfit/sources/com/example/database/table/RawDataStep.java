package com.example.database.table;

/* loaded from: classes.dex */
public class RawDataStep {
    private float calorie;
    private String date;
    private float distance;
    private String hour;

    /* renamed from: id, reason: collision with root package name */
    private Long f7379id;
    private boolean isUpdate;
    private String mac;
    private int step;
    private long timestamp;
    private String userId;

    public RawDataStep(Long l3, String str, String str2, long j4, String str3, String str4, int i3, float f2, float f10, boolean z5) {
        this.f7379id = l3;
        this.mac = str;
        this.userId = str2;
        this.timestamp = j4;
        this.date = str3;
        this.hour = str4;
        this.step = i3;
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

    public String getHour() {
        return this.hour;
    }

    public Long getId() {
        return this.f7379id;
    }

    public boolean getIsUpdate() {
        return this.isUpdate;
    }

    public String getMac() {
        return this.mac;
    }

    public int getStep() {
        return this.step;
    }

    public long getTimestamp() {
        return this.timestamp;
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

    public void setHour(String str) {
        this.hour = str;
    }

    public void setId(Long l3) {
        this.f7379id = l3;
    }

    public void setIsUpdate(boolean z5) {
        this.isUpdate = z5;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setStep(int i3) {
        this.step = i3;
    }

    public void setTimestamp(long j4) {
        this.timestamp = j4;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public RawDataStep() {
    }
}
