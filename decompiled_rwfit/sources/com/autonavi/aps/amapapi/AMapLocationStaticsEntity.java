package com.autonavi.aps.amapapi;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class AMapLocationStaticsEntity implements Parcelable {
    public static final String CONTINUE_LOCATE = "conitue";
    public static final Parcelable.Creator<AMapLocationStaticsEntity> CREATOR = new Parcelable.Creator<AMapLocationStaticsEntity>() { // from class: com.autonavi.aps.amapapi.AMapLocationStaticsEntity.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AMapLocationStaticsEntity createFromParcel(Parcel parcel) {
            AMapLocationStaticsEntity aMapLocationStaticsEntity = new AMapLocationStaticsEntity();
            aMapLocationStaticsEntity.setDNSStaus(parcel.readString());
            aMapLocationStaticsEntity.setDominStatus(parcel.readString());
            aMapLocationStaticsEntity.setLocationType(parcel.readString());
            aMapLocationStaticsEntity.setReason(parcel.readString());
            aMapLocationStaticsEntity.setIP(parcel.readString());
            aMapLocationStaticsEntity.setStartTime(parcel.readLong());
            aMapLocationStaticsEntity.setEndTime(parcel.readLong());
            aMapLocationStaticsEntity.setNetStartTime(parcel.readLong());
            aMapLocationStaticsEntity.setNetEndTime(parcel.readLong());
            aMapLocationStaticsEntity.setStackType(parcel.readString());
            return aMapLocationStaticsEntity;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AMapLocationStaticsEntity[] newArray(int i3) {
            return new AMapLocationStaticsEntity[i3];
        }
    };
    public static final String FAIL_STATUS = "FAIL";
    public static final String FIRST_LOCATE = "first";
    public static final String IPV4 = "v4";
    public static final String IPV6 = "v6";
    public static final String STATICS_LOCATE = "statics";
    public static final String SUCCESS_STATUS = "SUCCESS";
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f6578f;

    /* renamed from: a, reason: collision with root package name */
    private long f6574a = 0;

    /* renamed from: b, reason: collision with root package name */
    private long f6575b = 0;

    /* renamed from: c, reason: collision with root package name */
    private long f6576c = 0;

    /* renamed from: d, reason: collision with root package name */
    private long f6577d = 0;

    /* renamed from: g, reason: collision with root package name */
    private String f6579g = FIRST_LOCATE;

    /* renamed from: h, reason: collision with root package name */
    private String f6580h = "";

    /* renamed from: i, reason: collision with root package name */
    private String f6581i = "";

    /* renamed from: j, reason: collision with root package name */
    private String f6582j = null;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public long getContinueTime() {
        long j4 = this.f6575b;
        long j10 = this.f6574a;
        if (j4 <= j10) {
            return 0L;
        }
        return j4 - j10;
    }

    public String getDNSStaus() {
        return this.e;
    }

    public String getDominStatus() {
        return this.f6578f;
    }

    public long getEndTime() {
        return this.f6575b;
    }

    public String getIP() {
        return this.f6582j;
    }

    public String getLocationType() {
        return this.f6579g;
    }

    public long getNetEndTime() {
        return this.f6577d;
    }

    public long getNetStartTime() {
        return this.f6576c;
    }

    public long getNetUseTime() {
        long j4 = this.f6577d - this.f6576c;
        if (j4 <= 0) {
            return 0L;
        }
        return j4;
    }

    public String getReason() {
        return this.f6580h;
    }

    public String getStackType() {
        return this.f6581i;
    }

    public long getStartTime() {
        return this.f6574a;
    }

    public void setDNSStaus(String str) {
        this.e = str;
    }

    public void setDominStatus(String str) {
        this.f6578f = str;
    }

    public void setEndTime(long j4) {
        this.f6575b = j4;
    }

    public void setIP(String str) {
        this.f6582j = str;
    }

    public void setLocationType(String str) {
        this.f6579g = str;
    }

    public void setNetEndTime(long j4) {
        this.f6577d = j4;
    }

    public void setNetStartTime(long j4) {
        this.f6576c = j4;
    }

    public void setReason(String str) {
        this.f6580h = str;
    }

    public void setStackType(String str) {
        this.f6581i = str;
    }

    public void setStartTime(long j4) {
        this.f6574a = j4;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        try {
            parcel.writeString(this.e);
            parcel.writeString(this.f6578f);
            parcel.writeString(this.f6579g);
            parcel.writeString(this.f6580h);
            parcel.writeString(this.f6582j);
            parcel.writeLong(this.f6574a);
            parcel.writeLong(this.f6575b);
            parcel.writeLong(this.f6576c);
            parcel.writeLong(this.f6577d);
            parcel.writeString(this.f6581i);
        } catch (Throwable unused) {
        }
    }
}
