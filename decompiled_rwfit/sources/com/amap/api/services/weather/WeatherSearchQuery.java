package com.amap.api.services.weather;

import com.amap.api.col.p0003sl.d6;

/* loaded from: classes.dex */
public class WeatherSearchQuery implements Cloneable {
    public static final int WEATHER_TYPE_FORECAST = 2;
    public static final int WEATHER_TYPE_LIVE = 1;

    /* renamed from: a, reason: collision with root package name */
    private String f6555a;

    /* renamed from: b, reason: collision with root package name */
    private int f6556b;

    public WeatherSearchQuery(String str, int i3) {
        this.f6555a = str;
        this.f6556b = i3;
    }

    public String getCity() {
        return this.f6555a;
    }

    public int getType() {
        return this.f6556b;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public WeatherSearchQuery m41clone() {
        try {
            super.clone();
        } catch (CloneNotSupportedException e) {
            d6.a(e, "WeatherSearchQuery", "clone");
        }
        return new WeatherSearchQuery(this.f6555a, this.f6556b);
    }

    public WeatherSearchQuery() {
        this.f6556b = 1;
    }
}
