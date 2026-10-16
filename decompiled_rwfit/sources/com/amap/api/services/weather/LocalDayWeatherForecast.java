package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes.dex */
public class LocalDayWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalDayWeatherForecast> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6529a;

    /* renamed from: b, reason: collision with root package name */
    private String f6530b;

    /* renamed from: c, reason: collision with root package name */
    private String f6531c;

    /* renamed from: d, reason: collision with root package name */
    private String f6532d;
    private String e;

    /* renamed from: f, reason: collision with root package name */
    private String f6533f;

    /* renamed from: g, reason: collision with root package name */
    private String f6534g;

    /* renamed from: h, reason: collision with root package name */
    private String f6535h;

    /* renamed from: i, reason: collision with root package name */
    private String f6536i;

    /* renamed from: j, reason: collision with root package name */
    private String f6537j;

    public static class a implements Parcelable.Creator<LocalDayWeatherForecast> {
        @Override // android.os.Parcelable.Creator
        public LocalDayWeatherForecast createFromParcel(Parcel parcel) {
            return new LocalDayWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LocalDayWeatherForecast[] newArray(int i3) {
            return null;
        }
    }

    public LocalDayWeatherForecast() {
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getDate() {
        return this.f6529a;
    }

    public String getDayTemp() {
        return this.e;
    }

    public String getDayWeather() {
        return this.f6531c;
    }

    public String getDayWindDirection() {
        return this.f6534g;
    }

    public String getDayWindPower() {
        return this.f6536i;
    }

    public String getNightTemp() {
        return this.f6533f;
    }

    public String getNightWeather() {
        return this.f6532d;
    }

    public String getNightWindDirection() {
        return this.f6535h;
    }

    public String getNightWindPower() {
        return this.f6537j;
    }

    public String getWeek() {
        return this.f6530b;
    }

    public void setDate(String str) {
        this.f6529a = str;
    }

    public void setDayTemp(String str) {
        this.e = str;
    }

    public void setDayWeather(String str) {
        this.f6531c = str;
    }

    public void setDayWindDirection(String str) {
        this.f6534g = str;
    }

    public void setDayWindPower(String str) {
        this.f6536i = str;
    }

    public void setNightTemp(String str) {
        this.f6533f = str;
    }

    public void setNightWeather(String str) {
        this.f6532d = str;
    }

    public void setNightWindDirection(String str) {
        this.f6535h = str;
    }

    public void setNightWindPower(String str) {
        this.f6537j = str;
    }

    public void setWeek(String str) {
        this.f6530b = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6529a);
        parcel.writeString(this.f6530b);
        parcel.writeString(this.f6531c);
        parcel.writeString(this.f6532d);
        parcel.writeString(this.e);
        parcel.writeString(this.f6533f);
        parcel.writeString(this.f6534g);
        parcel.writeString(this.f6535h);
        parcel.writeString(this.f6536i);
        parcel.writeString(this.f6537j);
    }

    public LocalDayWeatherForecast(Parcel parcel) {
        this.f6529a = parcel.readString();
        this.f6530b = parcel.readString();
        this.f6531c = parcel.readString();
        this.f6532d = parcel.readString();
        this.e = parcel.readString();
        this.f6533f = parcel.readString();
        this.f6534g = parcel.readString();
        this.f6535h = parcel.readString();
        this.f6536i = parcel.readString();
        this.f6537j = parcel.readString();
    }
}
