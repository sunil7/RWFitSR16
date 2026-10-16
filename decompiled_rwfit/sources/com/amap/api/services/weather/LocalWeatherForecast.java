package com.amap.api.services.weather;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class LocalWeatherForecast implements Parcelable {
    public static final Parcelable.Creator<LocalWeatherForecast> CREATOR = new a();

    /* renamed from: a, reason: collision with root package name */
    private String f6538a;

    /* renamed from: b, reason: collision with root package name */
    private String f6539b;

    /* renamed from: c, reason: collision with root package name */
    private String f6540c;

    /* renamed from: d, reason: collision with root package name */
    private String f6541d;
    private List<LocalDayWeatherForecast> e;

    public static class a implements Parcelable.Creator<LocalWeatherForecast> {
        @Override // android.os.Parcelable.Creator
        public LocalWeatherForecast createFromParcel(Parcel parcel) {
            return new LocalWeatherForecast(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public /* bridge */ /* synthetic */ LocalWeatherForecast[] newArray(int i3) {
            return null;
        }
    }

    public LocalWeatherForecast() {
        this.e = new ArrayList();
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public String getAdCode() {
        return this.f6540c;
    }

    public String getCity() {
        return this.f6539b;
    }

    public String getProvince() {
        return this.f6538a;
    }

    public String getReportTime() {
        return this.f6541d;
    }

    public List<LocalDayWeatherForecast> getWeatherForecast() {
        return this.e;
    }

    public void setAdCode(String str) {
        this.f6540c = str;
    }

    public void setCity(String str) {
        this.f6539b = str;
    }

    public void setProvince(String str) {
        this.f6538a = str;
    }

    public void setReportTime(String str) {
        this.f6541d = str;
    }

    public void setWeatherForecast(List<LocalDayWeatherForecast> list) {
        this.e = list;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f6538a);
        parcel.writeString(this.f6539b);
        parcel.writeString(this.f6540c);
        parcel.writeString(this.f6541d);
        parcel.writeList(this.e);
    }

    public LocalWeatherForecast(Parcel parcel) {
        this.e = new ArrayList();
        this.f6538a = parcel.readString();
        this.f6539b = parcel.readString();
        this.f6540c = parcel.readString();
        this.f6541d = parcel.readString();
        this.e = parcel.readArrayList(LocalWeatherForecast.class.getClassLoader());
    }
}
