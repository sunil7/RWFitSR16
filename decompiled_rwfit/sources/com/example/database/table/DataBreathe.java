package com.example.database.table;

/* loaded from: classes.dex */
public class DataBreathe {
    private String date;

    /* renamed from: id, reason: collision with root package name */
    private Long f7367id;
    private boolean isUpdate;
    private String items;
    private String mac;
    private String timestamp;
    private Integer totalTime;
    private String userId;

    public DataBreathe(Long l3, String str, String str2, String str3, String str4, String str5, Integer num, boolean z5) {
        this.f7367id = l3;
        this.mac = str;
        this.userId = str2;
        this.timestamp = str3;
        this.date = str4;
        this.items = str5;
        this.totalTime = num;
        this.isUpdate = z5;
    }

    public String getDate() {
        return this.date;
    }

    public Long getId() {
        return this.f7367id;
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

    public Integer getTotalTime() {
        return this.totalTime;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(Long l3) {
        this.f7367id = l3;
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

    public void setTotalTime(Integer num) {
        this.totalTime = num;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public DataBreathe() {
    }
}
