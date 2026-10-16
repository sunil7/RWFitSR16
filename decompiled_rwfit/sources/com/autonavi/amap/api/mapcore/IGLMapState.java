package com.autonavi.amap.api.mapcore;

import android.graphics.Point;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;

/* loaded from: classes.dex */
public interface IGLMapState {
    float calculateMapZoomer(int i3, int i10, int i11, int i12, int i13);

    float getCameraDegree();

    float getMapAngle();

    DPoint getMapGeoCenter();

    void getMapGeoCenter(IPoint iPoint);

    float getMapZoomer();

    void recalculate();

    void recycle();

    void screenToP20Point(int i3, int i10, Point point);

    void setCameraDegree(float f2);

    void setMapAngle(float f2);

    void setMapGeoCenter(double d5, double d8);

    void setMapZoomer(float f2);
}
