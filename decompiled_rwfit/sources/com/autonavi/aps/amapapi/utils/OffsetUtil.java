package com.autonavi.aps.amapapi.utils;

import android.content.Context;
import com.amap.api.location.DPoint;
import com.autonavi.util.a;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class OffsetUtil {

    /* renamed from: a, reason: collision with root package name */
    public static final double f6819a = 6378245.0d;

    /* renamed from: b, reason: collision with root package name */
    private static final List<DPoint> f6820b = new ArrayList(Arrays.asList(new DPoint(23.379947d, 119.757001d), new DPoint(24.983296d, 120.474496d), new DPoint(25.518722d, 121.359866d), new DPoint(25.41329d, 122.443582d), new DPoint(24.862708d, 122.288354d), new DPoint(24.461292d, 122.188319d), new DPoint(21.584761d, 120.968923d), new DPoint(21.830837d, 120.654445d)));

    /* renamed from: ee, reason: collision with root package name */
    public static final double f6821ee = 0.006693421622965943d;

    private static double a(double d5, int i3) {
        return new BigDecimal(d5).setScale(i3, 4).doubleValue();
    }

    public static DPoint b2G(DPoint dPoint) {
        if (dPoint != null) {
            try {
                if (CoreUtil.isChina(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return a(dPoint, 2);
                }
                if (!isInTaiWan(dPoint.getLatitude(), dPoint.getLongitude())) {
                    return dPoint;
                }
                DPoint a3 = a(dPoint, 2);
                double latitude = a3.getLatitude();
                double longitude = a3.getLongitude();
                double d5 = longitude - 105.0d;
                double d8 = latitude - 35.0d;
                double transformLat = transformLat(d5, d8);
                double transformLon = transformLon(d5, d8);
                double d10 = (latitude / 180.0d) * 3.141592653589793d;
                double sin = Math.sin(d10);
                double d11 = 1.0d - ((0.006693421622965943d * sin) * sin);
                double sqrt = Math.sqrt(d11);
                DPoint dPoint2 = new DPoint(((transformLat * 180.0d) / ((6335552.717000426d / (d11 * sqrt)) * 3.141592653589793d)) + latitude, ((transformLon * 180.0d) / (((6378245.0d / sqrt) * Math.cos(d10)) * 3.141592653589793d)) + longitude);
                return new DPoint((latitude * 2.0d) - dPoint2.getLatitude(), (longitude * 2.0d) - dPoint2.getLongitude());
            } catch (Throwable th2) {
                CoreUtil.reportError(th2, "OffsetUtil", "b2G");
            }
        }
        return dPoint;
    }

    public static boolean isInTaiWan(double d5, double d8) {
        return CoreUtil.isInPolygon(new DPoint(d5, d8), f6820b);
    }

    public static DPoint marbar2G(Context context, DPoint dPoint) {
        try {
            if (!CoreUtil.isChina(dPoint.getLatitude(), dPoint.getLongitude())) {
                return dPoint;
            }
            double longitude = ((long) (dPoint.getLongitude() * 100000.0d)) % 36000000;
            double latitude = ((long) (dPoint.getLatitude() * 100000.0d)) % 36000000;
            return offset(context, new DPoint(((int) (((-yConvert(r8, r6)) + latitude) + (latitude > 0.0d ? 1 : -1))) / 100000.0d, ((int) (((-xConvert((int) ((-xConvert(longitude, latitude)) + longitude), (int) ((-yConvert(longitude, latitude)) + latitude))) + longitude) + (longitude > 0.0d ? 1 : -1))) / 100000.0d));
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "OffsetUtil", "marbar2G");
            return dPoint;
        }
    }

    public static DPoint offset(Context context, double d5, double d8) {
        if (context == null) {
            return null;
        }
        return offset(context, new DPoint(d8, d5));
    }

    public static double transformLat(double d5, double d8) {
        double d10 = d5 * 2.0d;
        double d11 = d8 * 0.2d * d8;
        double sin = ((((Math.sin(d10 * 3.141592653589793d) * 20.0d) + (Math.sin((6.0d * d5) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + (Math.sqrt(Math.abs(d5)) * 0.2d) + (0.1d * d5 * d8) + d11 + (d8 * 3.0d) + (-100.0d) + d10;
        double d12 = d8 * 3.141592653589793d;
        return ((((Math.sin(d12 / 30.0d) * 320.0d) + (Math.sin((d8 / 12.0d) * 3.141592653589793d) * 160.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d8 / 3.0d) * 3.141592653589793d) * 40.0d) + (Math.sin(d12) * 20.0d)) * 2.0d) / 3.0d) + sin;
    }

    public static double transformLon(double d5, double d8) {
        double d10 = d5 * 0.1d;
        double d11 = d10 * d5;
        double d12 = d10 * d8;
        return ((((Math.sin((d5 / 30.0d) * 3.141592653589793d) * 300.0d) + (Math.sin((d5 / 12.0d) * 3.141592653589793d) * 150.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d5 / 3.0d) * 3.141592653589793d) * 40.0d) + (Math.sin(d5 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d5 * 2.0d) * 3.141592653589793d) * 20.0d) + (Math.sin((6.0d * d5) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + (Math.sqrt(Math.abs(d5)) * 0.1d) + d12 + d11 + (d8 * 2.0d) + d5 + 300.0d;
    }

    public static double xConvert(double d5, double d8) {
        return ((d8 / 9000.0d) * Math.sin(d5 / 100000.0d)) + ((d5 / 18000.0d) * Math.cos(d8 / 100000.0d));
    }

    public static double yConvert(double d5, double d8) {
        return ((d8 / 9000.0d) * Math.cos(d5 / 100000.0d)) + ((d5 / 18000.0d) * Math.sin(d8 / 100000.0d));
    }

    private static DPoint a(DPoint dPoint, int i3) {
        double d5 = 0.006401062d;
        double d8 = 0.0060424805d;
        DPoint dPoint2 = null;
        for (int i10 = 0; i10 < i3; i10++) {
            double longitude = dPoint.getLongitude();
            double latitude = dPoint.getLatitude();
            dPoint2 = new DPoint();
            double d10 = longitude - d5;
            double d11 = latitude - d8;
            DPoint dPoint3 = new DPoint();
            double d12 = d10 * 3000.0d * 0.017453292519943295d;
            double d13 = 3000.0d * d11 * 0.017453292519943295d;
            double d14 = (d11 * d11) + (d10 * d10);
            double sqrt = (Math.sqrt(d14) + (Math.sin(d13) * 2.0E-5d)) * Math.cos(Math.atan2(d11, d10) + (Math.cos(d12) * 3.0E-6d));
            double sqrt2 = ((Math.sqrt(d14) + (Math.sin(d13) * 2.0E-5d)) * Math.sin(Math.atan2(d11, d10) + (Math.cos(d12) * 3.0E-6d))) + 0.006d;
            dPoint3.setLongitude(a(sqrt + 0.0065d, 8));
            dPoint3.setLatitude(a(sqrt2, 8));
            dPoint2.setLongitude(a((longitude + d10) - dPoint3.getLongitude(), 8));
            dPoint2.setLatitude(a((latitude + d11) - dPoint3.getLatitude(), 8));
            d5 = dPoint.getLongitude() - dPoint2.getLongitude();
            d8 = dPoint.getLatitude() - dPoint2.getLatitude();
        }
        return dPoint2;
    }

    public static DPoint offset(Context context, DPoint dPoint) {
        if (context == null) {
            return null;
        }
        try {
            if (CoreUtil.isChina(dPoint.getLatitude(), dPoint.getLongitude())) {
                double[] a3 = a.a(dPoint.getLongitude(), dPoint.getLatitude());
                return new DPoint(a3[1], a3[0]);
            }
        } catch (Throwable th2) {
            CoreUtil.reportError(th2, "OffsetUtil", "cover part2");
        }
        return dPoint;
    }
}
