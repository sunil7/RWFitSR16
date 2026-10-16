package com.autonavi.amap.mapcore;

import android.graphics.Point;

/* loaded from: classes.dex */
public class MapProjection {
    public static void geo2LonLat(int i3, int i10, DPoint dPoint) {
        DPoint pixelsToLatLong = VirtualEarthProjection.pixelsToLatLong(i3, i10, 20);
        dPoint.f6570x = pixelsToLatLong.f6570x;
        dPoint.f6571y = pixelsToLatLong.f6571y;
        pixelsToLatLong.recycle();
    }

    public static void lonlat2Geo(double d5, double d8, IPoint iPoint) {
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(d8, d5, 20);
        ((Point) iPoint).x = latLongToPixels.x;
        ((Point) iPoint).y = latLongToPixels.y;
    }
}
