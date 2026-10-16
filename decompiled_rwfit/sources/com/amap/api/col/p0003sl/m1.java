package com.amap.api.col.p0003sl;

import android.content.Context;
import com.amap.api.maps.model.LatLng;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.util.a;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: classes.dex */
public class m1 {

    /* renamed from: a, reason: collision with root package name */
    private static final List<LatLng> f4528a = new ArrayList(Arrays.asList(new LatLng(23.379947d, 119.757001d), new LatLng(24.983296d, 120.474496d), new LatLng(25.518722d, 121.359866d), new LatLng(25.41329d, 122.443582d), new LatLng(24.862708d, 122.288354d), new LatLng(24.461292d, 122.188319d), new LatLng(21.584761d, 120.968923d), new LatLng(21.830837d, 120.654445d)));

    /* renamed from: b, reason: collision with root package name */
    public static double f4529b = 6378245.0d;

    /* renamed from: c, reason: collision with root package name */
    public static double f4530c = 0.006693421622965943d;

    public static LatLng a(Context context, LatLng latLng) {
        try {
            if (!r4.b(latLng.latitude, latLng.longitude)) {
                return latLng;
            }
            double d5 = ((long) (latLng.longitude * 100000.0d)) % 36000000;
            double d8 = ((long) (latLng.latitude * 100000.0d)) % 36000000;
            DPoint obtain = DPoint.obtain(((int) (((-b((int) ((-b(d5, d8)) + d5), (int) ((-c(d5, d8)) + d8))) + d5) + (d5 > 0.0d ? 1 : -1))) / 100000.0d, ((int) (((-c(r2, r11)) + d8) + (d8 > 0.0d ? 1 : -1))) / 100000.0d);
            LatLng b3 = b(context, new LatLng(obtain.f6571y, obtain.f6570x, false));
            obtain.recycle();
            return b3;
        } catch (Throwable th2) {
            th2.printStackTrace();
            return latLng;
        }
    }

    public static LatLng b(Context context, LatLng latLng) {
        if (context == null) {
            return null;
        }
        if (!r4.b(latLng.latitude, latLng.longitude)) {
            return latLng;
        }
        DPoint obtain = DPoint.obtain(latLng.longitude, latLng.latitude);
        try {
            if (r4.b(obtain.f6571y, obtain.f6570x)) {
                double[] a3 = a.a(obtain.f6570x, obtain.f6571y);
                obtain.recycle();
                obtain = DPoint.obtain(a3[0], a3[1]);
            }
        } catch (Throwable unused) {
        }
        LatLng latLng2 = new LatLng(obtain.f6571y, obtain.f6570x, false);
        obtain.recycle();
        return latLng2;
    }

    public static double c(double d5, double d8) {
        return ((d8 / 9000.0d) * Math.cos(d5 / 100000.0d)) + ((d5 / 18000.0d) * Math.sin(d8 / 100000.0d));
    }

    public static double b(double d5, double d8) {
        return ((d8 / 9000.0d) * Math.sin(d5 / 100000.0d)) + ((d5 / 18000.0d) * Math.cos(d8 / 100000.0d));
    }

    public static LatLng a(LatLng latLng) {
        if (latLng != null) {
            try {
                if (r4.b(latLng.latitude, latLng.longitude)) {
                    DPoint a3 = a(latLng.longitude, latLng.latitude, 2);
                    LatLng latLng2 = new LatLng(a3.f6571y, a3.f6570x, false);
                    a3.recycle();
                    return latLng2;
                }
                if (!v4.a(new LatLng(latLng.latitude, latLng.longitude), f4528a)) {
                    return latLng;
                }
                DPoint a10 = a(latLng.longitude, latLng.latitude, 2);
                return a(a10.f6571y, a10.f6570x);
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return latLng;
    }

    private static double a(double d5, int i3) {
        return new BigDecimal(d5).setScale(i3, 4).doubleValue();
    }

    private static DPoint a(double d5, double d8, int i3) {
        double d10 = 0.006401062d;
        double d11 = 0.0060424805d;
        DPoint dPoint = null;
        int i10 = 0;
        while (i10 < i3) {
            dPoint = DPoint.obtain();
            double d12 = d5 - d10;
            double d13 = d8 - d11;
            DPoint obtain = DPoint.obtain();
            double d14 = d12 * 3000.0d * 0.017453292519943295d;
            double d15 = 3000.0d * d13 * 0.017453292519943295d;
            double d16 = (d13 * d13) + (d12 * d12);
            double sqrt = ((Math.sqrt(d16) + (Math.sin(d15) * 2.0E-5d)) * Math.cos(Math.atan2(d13, d12) + (Math.cos(d14) * 3.0E-6d))) + 0.0065d;
            double sqrt2 = ((Math.sqrt(d16) + (Math.sin(d15) * 2.0E-5d)) * Math.sin(Math.atan2(d13, d12) + (Math.cos(d14) * 3.0E-6d))) + 0.006d;
            obtain.f6570x = a(sqrt, 8);
            obtain.f6571y = a(sqrt2, 8);
            dPoint.f6570x = a((d5 + d12) - obtain.f6570x, 8);
            double a3 = a((d8 + d13) - obtain.f6571y, 8);
            dPoint.f6571y = a3;
            i10++;
            d11 = d8 - a3;
            d10 = d5 - dPoint.f6570x;
        }
        return dPoint;
    }

    private static LatLng a(double d5, double d8) {
        double d10 = d8 - 105.0d;
        double d11 = d5 - 35.0d;
        double d12 = d10 * 2.0d;
        double d13 = d11 * 0.2d * d11;
        double d14 = d10 * 0.1d;
        double d15 = d14 * d11;
        double sqrt = Math.sqrt(Math.abs(d10)) * 0.2d;
        double d16 = 6.0d * d10 * 3.141592653589793d;
        double d17 = d12 * 3.141592653589793d;
        double sin = ((((Math.sin(d17) * 20.0d) + (Math.sin(d16) * 20.0d)) * 2.0d) / 3.0d) + sqrt + d13 + (d11 * 3.0d) + (-100.0d) + d12 + d15;
        double d18 = d11 * 3.141592653589793d;
        double sin2 = ((((Math.sin(d18 / 30.0d) * 320.0d) + (Math.sin((d11 / 12.0d) * 3.141592653589793d) * 160.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d11 / 3.0d) * 3.141592653589793d) * 40.0d) + (Math.sin(d18) * 20.0d)) * 2.0d) / 3.0d) + sin;
        double d19 = d14 * d10;
        double sin3 = ((((Math.sin((d10 / 30.0d) * 3.141592653589793d) * 300.0d) + (Math.sin((d10 / 12.0d) * 3.141592653589793d) * 150.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d10 / 3.0d) * 3.141592653589793d) * 40.0d) + (Math.sin(d10 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d17) * 20.0d) + (Math.sin(d16) * 20.0d)) * 2.0d) / 3.0d) + (Math.sqrt(Math.abs(d10)) * 0.1d) + d19 + (d11 * 2.0d) + d10 + 300.0d + d15;
        double d20 = (d5 / 180.0d) * 3.141592653589793d;
        double sin4 = Math.sin(d20);
        double d21 = 1.0d - ((f4530c * sin4) * sin4);
        double sqrt2 = Math.sqrt(d21);
        double d22 = f4529b;
        LatLng latLng = new LatLng(d5 + ((sin2 * 180.0d) / ((((1.0d - f4530c) * d22) / (d21 * sqrt2)) * 3.141592653589793d)), d8 + ((sin3 * 180.0d) / ((Math.cos(d20) * (d22 / sqrt2)) * 3.141592653589793d)));
        return new LatLng((d5 * 2.0d) - latLng.latitude, (d8 * 2.0d) - latLng.longitude);
    }
}
