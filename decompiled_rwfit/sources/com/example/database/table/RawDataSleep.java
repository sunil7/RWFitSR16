package com.example.database.table;

/* loaded from: classes.dex */
public class RawDataSleep {
    private String date;

    /* renamed from: id, reason: collision with root package name */
    private Long f7378id;
    private boolean isUpdate;
    private String mac;
    private int sleepModel;
    private long timestamp;
    private String userId;

    public RawDataSleep(Long l3, String str, String str2, long j4, String str3, int i3, boolean z5) {
        this.f7378id = l3;
        this.mac = str;
        this.userId = str2;
        this.timestamp = j4;
        this.date = str3;
        this.sleepModel = i3;
        this.isUpdate = z5;
    }

    public String getDate() {
        return this.date;
    }

    public Long getId() {
        return this.f7378id;
    }

    public boolean getIsUpdate() {
        return this.isUpdate;
    }

    public String getMac() {
        return this.mac;
    }

    public int getSleepModel() {
        return this.sleepModel;
    }

    public long getTimestamp() {
        return this.timestamp;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(Long l3) {
        this.f7378id = l3;
    }

    public void setIsUpdate(boolean z5) {
        this.isUpdate = z5;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setSleepModel(int i3) {
        this.sleepModel = i3;
    }

    public void setTimestamp(long j4) {
        this.timestamp = j4;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public RawDataSleep() {
    }
}
