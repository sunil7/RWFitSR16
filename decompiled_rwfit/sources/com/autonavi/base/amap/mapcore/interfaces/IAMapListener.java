package com.autonavi.base.amap.mapcore.interfaces;

import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.MapPoi;

/* loaded from: classes.dex */
public interface IAMapListener {
    void afterAnimation();

    void afterDrawFrame(int i3, GLMapState gLMapState);

    void afterDrawLabel(int i3, GLMapState gLMapState);

    void afterRendererOver(int i3, GLMapState gLMapState);

    void beforeDrawLabel(int i3, GLMapState gLMapState);

    void onMapBlankClick(double d5, double d8);

    void onMapPOIClick(MapPoi mapPoi);
}
