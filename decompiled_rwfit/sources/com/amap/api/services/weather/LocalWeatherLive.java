package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class LocalWeatherLive implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherLive> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6544a;

    /* renamed from: b, reason: collision with root package name */
    private String f6545b;

    /* renamed from: c, reason: collision with root package name */
    private String f6546c;

    /* renamed from: d, reason: collision with root package name */
    private String f6547d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f6548f;

    /* renamed from: g, reason: collision with root package name */
    private String f6549g;

    /* renamed from: h, reason: collision with root package name */
    private String f6550h;

    /* renamed from: i, reason: collision with root package name */
    private String f6551i;

    public static class a implements Parcelable.Creator<LocalWeatherLive> {
        @Override // android.os.Parcelable.Creator
        public LocalWeatherLive createFromParcel(Parcel parcel) {
            return new LocalWeatherLive(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LocalWeatherLive[] newArray(int i3) {
            return null;
        }
    }

    public LocalWeatherLive() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f6546c;
    }

    public String getCity() {
        return this.f6545b;
    }

    public String getHumidity() {
        return this.f6550h;
    }

    public String getProvince() {
        return this.f6544a;
    }

    public String getReportTime() {
        return this.f6551i;
    }

    public String getTemperature() {
        return this.e;
    }

    public String getWeather() {
        return this.f6547d;
    }

    public String getWindDirection() {
        return this.f6548f;
    }

    public String getWindPower() {
        return this.f6549g;
    }

    public void setAdCode(String str) {
        this.f6546c = str;
    }

    public void setCity(String str) {
        this.f6545b = str;
    }

    public void setHumidity(String str) {
        this.f6550h = str;
    }

    public void setProvince(String str) {
        this.f6544a = str;
    }

    public void setReportTime(String str) {
        this.f6551i = str;
    }

    public void setTemperature(String str) {
        this.e = str;
    }

    public void setWeather(String str) {
        this.f6547d = str;
    }

    public void setWindDirection(String str) {
        this.f6548f = str;
    }

    public void setWindPower(String str) {
        this.f6549g = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6544a);
        parcel.writeString(this.f6545b);
        parcel.writeString(this.f6546c);
        parcel.writeString(this.f6547d);
        parcel.writeString(this.e);
        parcel.writeString(this.f6548f);
        parcel.writeString(this.f6549g);
        parcel.writeString(this.f6550h);
        parcel.writeString(this.f6551i);
    }

    public LocalWeatherLive(Parcel parcel) {
        this.f6544a = parcel.readString();
        this.f6545b = parcel.readString();
        this.f6546c = parcel.readString();
        this.f6547d = parcel.readString();
        this.e = parcel.readString();
        this.f6548f = parcel.readString();
        this.f6549g = parcel.readString();
        this.f6550h = parcel.readString();
        this.f6551i = parcel.readString();
    }
}
