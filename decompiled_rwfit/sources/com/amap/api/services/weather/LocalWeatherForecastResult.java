package com.amap.api.services.weather;

/* loaded from: classes.dex */
public class LocalWeatherForecastResult {

    /* renamed from: a, reason: collision with root package name */
    private WeatherSearchQuery f6542a;

    /* renamed from: b, reason: collision with root package name */
    private LocalWeatherForecast f6543b;

    private LocalWeatherForecastResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        this.f6542a = weatherSearchQuery;
        this.f6543b = localWeatherForecast;
    }

    public static LocalWeatherForecastResult createPagedResult(WeatherSearchQuery weatherSearchQuery, LocalWeatherForecast localWeatherForecast) {
        return new LocalWeatherForecastResult(weatherSearchQuery, localWeatherForecast);
    }

    public LocalWeatherForecast getForecastResult() {
        return this.f6543b;
    }

    public WeatherSearchQuery getWeatherForecastQuery() {
        return this.f6542a;
    }
}
