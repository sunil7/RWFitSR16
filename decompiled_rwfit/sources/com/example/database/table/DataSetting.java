package com.example.database.table;

/* loaded from: classes.dex */
public class DataSetting {
    private String dataKey;
    private String dataValue;

    /* renamed from: id, reason: collision with root package name */
    private Long f7373id;
    private String mac;
    private String userId;

    public DataSetting(Long l3, String str, String str2, String str3, String str4) {
        this.f7373id = l3;
        this.mac = str;
        this.userId = str2;
        this.dataKey = str3;
        this.dataValue = str4;
    }

    public String getDataKey() {
        return this.dataKey;
    }

    public String getDataValue() {
        return this.dataValue;
    }

    public Long getId() {
        return this.f7373id;
    }

    public String getMac() {
        return this.mac;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setDataKey(String str) {
        this.dataKey = str;
    }

    public void setDataValue(String str) {
        this.dataValue = str;
    }

    public void setId(Long l3) {
        this.f7373id = l3;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public DataSetting() {
    }
}
