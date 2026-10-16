package com.example.blesdk.bean.function;

import android.support.v4.media.session.e;

/* loaded from: classes.dex */
public class WeatherBean {
    private int UVIntensity;
    private int currentTemp;
    private int day;
    private int hour;
    private int humidity;
    private int jlSunriseHour;
    private int jlSunriseMin;
    private int jlSunriseSec;
    private int jlSunsetHour;
    private int jlSunsetMin;
    private int jlSunsetSec;
    private int maxTemp;
    private int minTemp;
    private int minute;
    private int month;
    private int rainfall;
    private int second;
    private int visibility;
    private int weatherType;
    private int windSpeed;
    private int year;

    public int getCurrentTemp() {
        return this.currentTemp;
    }

    public int getDay() {
        return this.day;
    }

    public int getHour() {
        return this.hour;
    }

    public int getHumidity() {
        return this.humidity;
    }

    public int getJlSunriseHour() {
        return this.jlSunriseHour;
    }

    public int getJlSunriseMin() {
        return this.jlSunriseMin;
    }

    public int getJlSunriseSec() {
        return this.jlSunriseSec;
    }

    public int getJlSunsetHour() {
        return this.jlSunsetHour;
    }

    public int getJlSunsetMin() {
        return this.jlSunsetMin;
    }

    public int getJlSunsetSec() {
        return this.jlSunsetSec;
    }

    public int getMaxTemp() {
        return this.maxTemp;
    }

    public int getMinTemp() {
        return this.minTemp;
    }

    public int getMinute() {
        return this.minute;
    }

    public int getMonth() {
        return this.month;
    }

    public int getRainfall() {
        return this.rainfall;
    }

    public int getSecond() {
        return this.second;
    }

    public int getUVIntensity() {
        return this.UVIntensity;
    }

    public int getVisibility() {
        return this.visibility;
    }

    public int getWeatherType() {
        return this.weatherType;
    }

    public int getWindSpeed() {
        return this.windSpeed;
    }

    public int getYear() {
        return this.year;
    }

    public void setCurrentTemp(int i3) {
        this.currentTemp = i3;
    }

    public void setDay(int i3) {
        this.day = i3;
    }

    public void setHour(int i3) {
        this.hour = i3;
    }

    public void setHumidity(int i3) {
        this.humidity = i3;
    }

    public void setJlSunriseHour(int i3) {
        this.jlSunriseHour = i3;
    }

    public void setJlSunriseMin(int i3) {
        this.jlSunriseMin = i3;
    }

    public void setJlSunriseSec(int i3) {
        this.jlSunriseSec = i3;
    }

    public void setJlSunsetHour(int i3) {
        this.jlSunsetHour = i3;
    }

    public void setJlSunsetMin(int i3) {
        this.jlSunsetMin = i3;
    }

    public void setJlSunsetSec(int i3) {
        this.jlSunsetSec = i3;
    }

    public void setMaxTemp(int i3) {
        this.maxTemp = i3;
    }

    public void setMinTemp(int i3) {
        this.minTemp = i3;
    }

    public void setMinute(int i3) {
        this.minute = i3;
    }

    public void setMonth(int i3) {
        this.month = i3;
    }

    public void setRainfall(int i3) {
        this.rainfall = i3;
    }

    public void setSecond(int i3) {
        this.second = i3;
    }

    public void setUVIntensity(int i3) {
        this.UVIntensity = i3;
    }

    public void setVisibility(int i3) {
        this.visibility = i3;
    }

    public void setWeatherType(int i3) {
        this.weatherType = i3;
    }

    public void setWindSpeed(int i3) {
        this.windSpeed = i3;
    }

    public void setYear(int i3) {
        this.year = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("WeatherBean{weatherType=");
        sb2.append(this.weatherType);
        sb2.append(", maxTemp=");
        sb2.append(this.maxTemp);
        sb2.append(", minTemp=");
        sb2.append(this.minTemp);
        sb2.append(", currentTemp=");
        sb2.append(this.currentTemp);
        sb2.append(", windSpeed=");
        sb2.append(this.windSpeed);
        sb2.append(", humidity=");
        sb2.append(this.humidity);
        sb2.append(", visibility=");
        sb2.append(this.visibility);
        sb2.append(", UVIntensity=");
        sb2.append(this.UVIntensity);
        sb2.append(", rainfall=");
        return e.m(sb2, this.rainfall, '}');
    }
}
