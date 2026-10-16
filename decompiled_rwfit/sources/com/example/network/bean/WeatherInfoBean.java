package com.example.network.bean;

import r5.a;

/* loaded from: classes.dex */
public class WeatherInfoBean {
    private int current;
    private String date;
    private int high;
    private int humidity;
    private int low;
    private int precip;
    private String sunrise;
    private String sunset;
    private int type;
    private int uvIndex;
    private int vis;
    private String weather;
    private int windSpeed;

    public int getCurrent() {
        return this.current;
    }

    public String getDate() {
        return this.date;
    }

    public int getHigh() {
        return this.high;
    }

    public int getHumidity() {
        return this.humidity;
    }

    public int getLow() {
        return this.low;
    }

    public int getPrecip() {
        return this.precip;
    }

    public String getSunrise() {
        return this.sunrise;
    }

    public String getSunset() {
        return this.sunset;
    }

    public int getType() {
        return this.type;
    }

    public int getUvIndex() {
        return this.uvIndex;
    }

    public int getVis() {
        return this.vis;
    }

    public int getVisibility() {
        return this.vis;
    }

    public String getWeather() {
        return this.weather;
    }

    public int getWindSpeed() {
        return this.windSpeed;
    }

    public void setCurrent(int i3) {
        this.current = i3;
    }

    public void setDate(String str) {
        this.date = str;
    }

    public void setHigh(int i3) {
        this.high = i3;
    }

    public void setHumidity(int i3) {
        this.humidity = i3;
    }

    public void setLow(int i3) {
        this.low = i3;
    }

    public void setPrecip(int i3) {
        this.precip = i3;
    }

    public void setSunrise(String str) {
        this.sunrise = str;
    }

    public void setSunset(String str) {
        this.sunset = str;
    }

    public void setType(int i3) {
        this.type = i3;
    }

    public void setUvIndex(int i3) {
        this.uvIndex = i3;
    }

    public void setVis(int i3) {
        this.vis = i3;
    }

    public void setVisibility(int i3) {
        this.vis = i3;
    }

    public void setWeather(String str) {
        this.weather = str;
    }

    public void setWindSpeed(int i3) {
        this.windSpeed = i3;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("WeatherInfoBean{weacher='");
        sb2.append(this.weather);
        sb2.append("', high=");
        sb2.append(this.high);
        sb2.append(", low=");
        sb2.append(this.low);
        sb2.append(", type=");
        sb2.append(this.type);
        sb2.append(", current=");
        sb2.append(this.current);
        sb2.append(", date='");
        return a.f(sb2, this.date, "'}");
    }
}
