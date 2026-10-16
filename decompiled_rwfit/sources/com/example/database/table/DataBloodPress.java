package com.example.database.table;

/* loaded from: classes.dex */
public class DataBloodPress {
    private int avgDp;
    private int avgSp;
    private String date;

    /* renamed from: id, reason: collision with root package name */
    private Long f7364id;
    private boolean isUpdate;
    private String items;
    private String mac;
    private int maxDp;
    private int maxSp;
    private int minDp;
    private int minSp;
    private String timestamp;
    private String userId;

    public DataBloodPress(Long l3, String str, String str2, String str3, String str4, String str5, int i3, int i10, int i11, int i12, int i13, int i14, boolean z5) {
        this.f7364id = l3;
        this.mac = str;
        this.userId = str2;
        this.timestamp = str3;
        this.date = str4;
        this.items = str5;
        this.avgSp = i3;
        this.avgDp = i10;
        this.maxSp = i11;
        this.minSp = i12;
        this.maxDp = i13;
        this.minDp = i14;
        this.isUpdate = z5;
    }

    public int getAvgDp() {
        return this.avgDp;
    }

    public int getAvgSp() {
        return this.avgSp;
    }

    public String getDate() {
        return this.date;
    }

    public Long getId() {
        return this.f7364id;
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

    public int getMaxDp() {
        return this.maxDp;
    }

    public int getMaxSp() {
        return this.maxSp;
    }

    public int getMinDp() {
        return this.minDp;
    }

    public int getMinSp() {
        return this.minSp;
    }

    public String getTimestamp() {
        return this.timestamp;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setAvgDp(int i3) {
        this.avgDp = i3;
    }

    public void setAvgSp(int i3) {
        this.avgSp = i3;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setId(Long l3) {
        this.f7364id = l3;
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

    public void setMaxDp(int i3) {
        this.maxDp = i3;
    }

    public void setMaxSp(int i3) {
        this.maxSp = i3;
    }

    public void setMinDp(int i3) {
        this.minDp = i3;
    }

    public void setMinSp(int i3) {
        this.minSp = i3;
    }

    public void setTimestamp(String str) {
        this.timestamp = str;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public DataBloodPress() {
    }
}
