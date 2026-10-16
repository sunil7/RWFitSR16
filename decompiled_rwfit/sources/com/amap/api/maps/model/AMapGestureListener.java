package com.amap.api.maps.model;

/* loaded from: classes.dex */
public interface AMapGestureListener {
    void onDoubleTap(float f2, float f10);

    void onDown(float f2, float f10);

    void onFling(float f2, float f10);

    void onLongPress(float f2, float f10);

    void onMapStable();

    void onScroll(float f2, float f10);

    void onSingleTap(float f2, float f10);

    void onUp(float f2, float f10);
}
