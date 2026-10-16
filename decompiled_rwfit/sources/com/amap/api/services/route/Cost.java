package com.amap.api.services.route;

/* loaded from: classes.dex */
public class Cost {

    /* renamed from: a, reason: collision with root package name */
    private float f6217a;

    /* renamed from: b, reason: collision with root package name */
    private float f6218b;

    /* renamed from: c, reason: collision with root package name */
    private String f6219c;

    /* renamed from: d, reason: collision with root package name */
    private float f6220d;
    private int e;

    public float getDuration() {
        return this.f6217a;
    }

    public float getTollDistance() {
        return this.f6218b;
    }

    public String getTollRoad() {
        return this.f6219c;
    }

    public float getTolls() {
        return this.f6220d;
    }

    public int getTrafficLights() {
        return this.e;
    }

    public void setDuration(float f2) {
        this.f6217a = f2;
    }

    public void setTollDistance(float f2) {
        this.f6218b = f2;
    }

    public void setTollRoad(String str) {
        this.f6219c = str;
    }

    public void setTolls(float f2) {
        this.f6220d = f2;
    }

    public void setTrafficLights(int i3) {
        this.e = i3;
    }
}
