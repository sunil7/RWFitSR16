package com.example.database.table;

/* loaded from: classes.dex */
public class DataBloodOxygen {
    private int avgBo;
    private String date;

    /* renamed from: id, reason: collision with root package name */
    private Long f7363id;
    private boolean isUpdate;
    private String items;
    private String mac;
    private int maxBo;
    private int minBo;
    private String timestamp;
    private String userId;

    public DataBloodOxygen(Long l3, String str, String str2, String str3, String str4, String str5, int i3, int i10, int i11, boolean z5) {
        this.f7363id = l3;
        this.mac = str;
        this.userId = str2;
        this.timestamp = str3;
        this.date = str4;
        this.items = str5;
        this.avgBo = i3;
        this.maxBo = i10;
        this.minBo = i11;
        this.isUpdate = z5;
    }

    public int getAvgBo() {
        return this.avgBo;
    }

    public String getDate() {
        return this.date;
    }

    public Long getId() {
        return this.f7363id;
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

    public int getMaxBo() {
        return this.maxBo;
    }

    public int getMinBo() {
        return this.minBo;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAvgBo(int i3) {
        this.avgBo = i3;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(Long l3) {
        this.f7363id = l3;
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

    public void setMaxBo(int i3) {
        this.maxBo = i3;
    }

    public void setMinBo(int i3) {
        this.minBo = i3;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public DataBloodOxygen() {
    }
}
