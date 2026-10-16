package com.example.database.table;

/* loaded from: classes.dex */
public class DataQrCode {

    /* renamed from: id, reason: collision with root package name */
    private Long f7372id;
    private String mac;
    private String qrCodeContent;
    private String qrCodeTitle;
    private Integer qrCodeType;
    private String userId;

    public DataQrCode(Long l3, String str, String str2, Integer num, String str3, String str4) {
        this.f7372id = l3;
        this.mac = str;
        this.userId = str2;
        this.qrCodeType = num;
        this.qrCodeContent = str3;
        this.qrCodeTitle = str4;
    }

    public Long getId() {
        return this.f7372id;
    }

    public String getMac() {
        return this.mac;
    }

    public String getQrCodeContent() {
        return this.qrCodeContent;
    }

    public String getQrCodeTitle() {
        return this.qrCodeTitle;
    }

    public Integer getQrCodeType() {
        return this.qrCodeType;
    }

    public String getUserId() {
        return this.userId;
    }

    public void setId(Long l3) {
        this.f7372id = l3;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setQrCodeContent(String str) {
        this.qrCodeContent = str;
    }

    public void setQrCodeTitle(String str) {
        this.qrCodeTitle = str;
    }

    public void setQrCodeType(Integer num) {
        this.qrCodeType = num;
    }

    public void setUserId(String str) {
        this.userId = str;
    }

    public DataQrCode() {
    }
}
