package com.amap.api.services.weather;

/* loaded from: classes.dex */
public class LocalWeatherLiveResult {

    /* renamed from: a, reason: collision with root package name */
    private WeatherSearchQuery f6552a;

    /* renamed from: b, reason: collision with root package name */
    private LocalWeatherLive f6553b;

    private LocalWeatherLiveResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        this.f6552a = weatherSearchQuery;
        this.f6553b = localWeatherLive;
    }

    public static LocalWeatherLiveResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherLive localWeatherLive) {
        return new LocalWeatherLiveResult(weatherSearchQuery, localWeatherLive);
    }

    public LocalWeatherLive getLiveResult() {
        return this.f6553b;
    }

    public WeatherSearchQuery getWeatherLiveQuery() {
        return this.f6552a;
    }
}
