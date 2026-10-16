package com.autonavi.amap.mapcore;

import android.graphics.Point;

/* loaded from: classes.dex */
public class VirtualEarthProjection {
    public static final double EARTH_CIRCUMFERENCE_IN_METERS = 4.007501668557849E7d;
    public static final int EARTH_RADIUS_IN_METERS = 6378137;
    private static final int KMA_MAX_MAP_SIZE = 268435456;
    private static final double K_EARTH_CIRCLE = 4.0075016E7d;
    private static final double K_EARTH_CIRCLE_2 = 2.0037508E7d;
    public static final int MAXZOOMLEVEL = 20;
    public static final double MAX_LATITUDE = 85.0511287798d;
    public static final double MAX_LONGITUDE = 360.0d;
    public static final double MIN_LATITUDE = -85.0511287798d;
    public static final double MIN_LONGITUDE = -360.0d;
    public static final int PIXELS_PER_TILE = 256;
    public static final int TILE_SPLIT_LEVEL = 0;

    public static double clip(double d5, double d8, double d10) {
        return Math.min(Math.max(d5, d8), d10);
    }

    private static double degToRad(double d5) {
        return d5 * 0.017453292519943295d;
    }

    public static Point latLongToPixels(int i3, int i10, int i11) {
        return latLongToPixels(i10 / 3600000.0d, i3 / 3600000.0d, i11);
    }

    public static DPoint latLongToPixelsDouble(double d5, double d8, int i3) {
        DPoint dPoint = new DPoint();
        double clip = clip(d5, -85.0511287798d, 85.0511287798d);
        double degToRad = degToRad(clip(d8, -360.0d, 360.0d)) * 6378137.0d;
        double sin = Math.sin(degToRad(clip));
        double log = (Math.log((sin + 1.0d) / (1.0d - sin)) * 6378137.0d) / 2.0d;
        double d10 = (degToRad + K_EARTH_CIRCLE_2) / 0.14929106831550598d;
        double d11 = (K_EARTH_CIRCLE_2 - log) / 0.14929106831550598d;
        dPoint.f6570x = d10;
        dPoint.f6571y = d11;
        return dPoint;
    }

    public static DPoint pixelsToLatLong(long j4, long j10, int i3) {
        DPoint obtain = DPoint.obtain();
        double d5 = (j4 * 0.14929106831550598d) - K_EARTH_CIRCLE_2;
        double d8 = K_EARTH_CIRCLE_2 - (j10 * 0.14929106831550598d);
        obtain.f6570x = radToDeg(d5 / 6378137.0d);
        double exp = Math.exp((d8 / 6378137.0d) * 2.0d);
        obtain.f6571y = radToDeg(Math.asin((exp - 1.0d) / (exp + 1.0d)));
        return obtain;
    }

    private static double radToDeg(double d5) {
        return d5 * 57.29577951308232d;
    }

    public static void latLongToPixels(double d5, double d8, int i3, Point point) {
        double clip = clip(d5, -85.0511287798d, 85.0511287798d);
        double degToRad = degToRad(clip(d8, -360.0d, 360.0d)) * 6378137.0d;
        double sin = Math.sin(degToRad(clip));
        double log = (Math.log((sin + 1.0d) / (1.0d - sin)) * 6378137.0d) / 2.0d;
        double d10 = (degToRad + K_EARTH_CIRCLE_2) / 0.14929106831550598d;
        double d11 = (K_EARTH_CIRCLE_2 - log) / 0.14929106831550598d;
        point.x = (int) d10;
        point.y = (int) d11;
    }

    public static DPoint pixelsToLatLong(double d5, double d8, int i3) {
        DPoint obtain = DPoint.obtain();
        double d10 = (d5 * 0.14929106831550598d) - K_EARTH_CIRCLE_2;
        double d11 = K_EARTH_CIRCLE_2 - (d8 * 0.14929106831550598d);
        obtain.f6570x = radToDeg(d10 / 6378137.0d);
        double exp = Math.exp((d11 / 6378137.0d) * 2.0d);
        obtain.f6571y = radToDeg(Math.asin((exp - 1.0d) / (exp + 1.0d)));
        return obtain;
    }

    public static Point latLongToPixels(double d5, double d8, int i3) {
        Point point = new Point();
        latLongToPixels(d5, d8, i3, point);
        return point;
    }
}
