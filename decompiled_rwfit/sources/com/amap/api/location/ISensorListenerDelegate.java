package com.amap.api.location;

/* loaded from: classes.dex */
public interface ISensorListenerDelegate {
    void onSetAccelerometer(long j4, int i3, float f2, float f10, float f11, float f12, float f13, float f14);

    void onSetGyroscope(long j4, int i3, float f2, float f10, float f11, float f12, float f13, float f14);

    void onSetHeading(long j4, int i3, float f2);

    void onSetMagnetic(long j4, int i3, float f2, float f10, float f11, float f12, float f13, float f14);

    void onSetOrientation(long j4, int i3, float f2, float f10, float f11);

    void onSetPressure(long j4, int i3, float f2);

    void onSetTemperature(long j4, int i3, float f2);
}
