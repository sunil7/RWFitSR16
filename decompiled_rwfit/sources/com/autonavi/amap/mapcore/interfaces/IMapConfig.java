package com.autonavi.amap.mapcore.interfaces;

/* loaded from: classes.dex */
public interface IMapConfig {
    int getAbroadState();

    int getAnchorX();

    int getAnchorY();

    int getMapHeight();

    int getMapWidth();

    float getMapZoomScale();

    float getMaxZoomLevel();

    float getMinZoomLevel();

    double getSX();

    double getSY();

    float getSZ();

    boolean isAbroadEnable();

    boolean isTerrainEnable();

    void setAbroadEnable(boolean z5);

    void setAbroadState(int i3);

    void setTerrainEnable(boolean z5);
}
