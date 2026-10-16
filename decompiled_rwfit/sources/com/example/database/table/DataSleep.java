package com.example.database.table;

/* loaded from: classes.dex */
public class DataSleep {
    private long asleepTime;
    private String date;

    /* renamed from: id, reason: collision with root package name */
    private Long f7374id;
    private boolean isUpdate;
    private String items;
    private String mac;
    private long sleepDeepTime;
    private long sleepLightTime;
    private long sleepRapidTime;
    private String timestamp;
    private long totalSleepTime;
    private String userId;
    private int wakeupCount;
    private long wakeupTime;

    public DataSleep(Long l3, String str, String str2, String str3, String str4, String str5, long j4, long j10, long j11, long j12, int i3, long j13, long j14, boolean z5) {
        this.f7374id = l3;
        this.mac = str;
        this.userId = str2;
        this.timestamp = str3;
        this.date = str4;
        this.items = str5;
        this.totalSleepTime = j4;
        this.sleepDeepTime = j10;
        this.sleepLightTime = j11;
        this.sleepRapidTime = j12;
        this.wakeupCount = i3;
        this.asleepTime = j13;
        this.wakeupTime = j14;
        this.isUpdate = z5;
    }

    public long getAsleepTime() {
        return this.asleepTime;
    }

    public String getDate() {
        return this.date;
    }

    public Long getId() {
        return this.f7374id;
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

    public long getSleepDeepTime() {
        return this.sleepDeepTime;
    }

    public long getSleepLightTime() {
        return this.sleepLightTime;
    }

    public long getSleepRapidTime() {
        return this.sleepRapidTime;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public long getTotalSleepTime() {
        return this.totalSleepTime;
    }

    public String getUserId() {
        return this.userId;
    }

    public int getWakeupCount() {
        return this.wakeupCount;
    }

    public long getWakeupTime() {
        return this.wakeupTime;
    }

    public void setAsleepTime(long j4) {
        this.asleepTime = j4;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(Long l3) {
        this.f7374id = l3;
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

    public void setSleepDeepTime(long j4) {
        this.sleepDeepTime = j4;
    }

    public void setSleepLightTime(long j4) {
        this.sleepLightTime = j4;
    }

    public void setSleepRapidTime(long j4) {
        this.sleepRapidTime = j4;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setTotalSleepTime(long j4) {
        this.totalSleepTime = j4;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public void setWakeupCount(int i3) {
        this.wakeupCount = i3;
    }

    public void setWakeupTime(long j4) {
        this.wakeupTime = j4;
    }

    public DataSleep() {
    }
}
