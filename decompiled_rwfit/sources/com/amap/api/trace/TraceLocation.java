package com.amap.api.trace;

/* loaded from: classes.dex */
public class TraceLocation {

    /* renamed from: a, reason: collision with root package name */
    private double f6559a;

    /* renamed from: b, reason: collision with root package name */
    private double f6560b;

    /* renamed from: c, reason: collision with root package name */
    private float f6561c;

    /* renamed from: d, reason: collision with root package name */
    private float f6562d;
    private long e;

    public TraceLocation(double d5, double d8, float f2, float f10, long j4) {
        this.f6559a = a(d5);
        this.f6560b = a(d8);
        this.f6561c = (int) ((f2 * 3600.0f) / 1000.0f);
        this.f6562d = (int) f10;
        this.e = j4;
    }

    private static double a(double d5) {
        return Math.round(d5 * 1000000.0d) / 1000000.0d;
    }

    public TraceLocation copy() {
        TraceLocation traceLocation = new TraceLocation();
        traceLocation.f6562d = this.f6562d;
        traceLocation.f6559a = this.f6559a;
        traceLocation.f6560b = this.f6560b;
        traceLocation.f6561c = this.f6561c;
        traceLocation.e = this.e;
        return traceLocation;
    }

    public float getBearing() {
        return this.f6562d;
    }

    public double getLatitude() {
        return this.f6559a;
    }

    public double getLongitude() {
        return this.f6560b;
    }

    public float getSpeed() {
        return this.f6561c;
    }

    public long getTime() {
        return this.e;
    }

    public void setBearing(float f2) {
        this.f6562d = (int) f2;
    }

    public void setLatitude(double d5) {
        this.f6559a = a(d5);
    }

    public void setLongitude(double d5) {
        this.f6560b = a(d5);
    }

    public void setSpeed(float f2) {
        this.f6561c = (int) ((f2 * 3600.0f) / 1000.0f);
    }

    public void setTime(long j4) {
        this.e = j4;
    }

    public String toString() {
        return this.f6559a + ",longitude " + this.f6560b + ",speed " + this.f6561c + ",bearing " + this.f6562d + ",time " + this.e;
    }

    public TraceLocation() {
    }
}
