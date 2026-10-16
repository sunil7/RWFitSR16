package com.autonavi.amap.api.mapcore;

import com.amap.api.maps.AMap;

/* loaded from: classes.dex */
public interface IGLMapEngine {
    void addGroupAnimation(int i3, int i10, float f2, int i11, int i12, int i13, int i14, AMap.CancelableCallback cancelableCallback);

    IGLMapState getNewMapState(int i3);
}
