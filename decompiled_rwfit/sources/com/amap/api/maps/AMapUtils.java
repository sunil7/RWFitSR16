package com.amap.api.maps;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.amap.api.col.p0003sl.a9;
import com.amap.api.col.p0003sl.b9;
import com.amap.api.col.p0003sl.c9;
import com.amap.api.col.p0003sl.m9;
import com.amap.api.col.p0003sl.v0;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.NaviPara;
import com.amap.api.maps.model.PoiPara;
import com.amap.api.maps.model.RoutePara;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/* loaded from: classes.dex */
public class AMapUtils {
    private static final String AMAPNAVIURL = "androidamap://navi?sourceApplication=%s&lat=%f&lon=%f&dev=0&style=%d";
    private static final String AMAPPOISEARCHURL = "androidamap://arroundpoi?sourceApplication=%s&keywords=%s&dev=0";
    private static final String AMAPROUTEURL = "androidamap://route?sourceApplication=%s&slat=%f&slon=%f&sname=%s&dlat=%f&dlon=%f&dname=%s&dev=0&t=%d";
    public static final int BUS_COMFORT = 4;
    public static final int BUS_MONEY_LITTLE = 1;
    public static final int BUS_NO_SUBWAY = 5;
    public static final int BUS_TIME_FIRST = 0;
    public static final int BUS_TRANSFER_LITTLE = 2;
    public static final int BUS_WALK_LITTLE = 3;
    private static final double DEG_TO_RAD = 0.017453292519943295d;
    private static final int DRING_ROUTE_MODEL = 2;
    public static final int DRIVING_AVOID_CONGESTION = 4;
    public static final int DRIVING_DEFAULT = 0;
    public static final int DRIVING_NO_HIGHWAY = 3;
    public static final int DRIVING_NO_HIGHWAY_AVOID_CONGESTION = 6;
    public static final int DRIVING_NO_HIGHWAY_AVOID_SHORT_MONEY = 5;
    public static final int DRIVING_NO_HIGHWAY_SAVE_MONEY_AVOID_CONGESTION = 8;
    public static final int DRIVING_SAVE_MONEY = 1;
    public static final int DRIVING_SAVE_MONEY_AVOID_CONGESTION = 7;
    public static final int DRIVING_SHORT_DISTANCE = 2;
    private static final double EARTHRADIUS = 6378137.0d;
    private static final double NF_PI = 0.01745329251994329d;
    private static final double R = 6378137.0d;
    private static final int TRANSIT_ROUTE_MODEL = 1;

    public static class a extends Thread {

        /* renamed from: a, reason: collision with root package name */
        String f5701a;

        /* renamed from: b, reason: collision with root package name */
        Context f5702b;

        public a(String str, Context context) {
            this.f5701a = str;
            if (context != null) {
                this.f5702b = context.getApplicationContext();
            }
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            if (this.f5702b != null) {
                try {
                    c9.a(this.f5702b, new m9.a(this.f5701a, "11.1.063", v0.f5168c).a(new String[]{"com.amap.api.maps"}).a(), "", (Map<String, String>) null);
                    interrupt();
                } catch (a9 e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void a(RoutePara routePara, Context context, int i3) throws AMapException {
        if (routePara.getStartPoint() == null || routePara.getEndPoint() == null || routePara.getStartName() == null || routePara.getStartName().trim().length() <= 0 || routePara.getEndName() == null || routePara.getEndName().trim().length() <= 0) {
            throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(276824064);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse(b(routePara, context, i3)));
        intent.setPackage("com.autonavi.minimap");
        new a("oan", context).start();
        context.startActivity(intent);
    }

    private static String b(RoutePara routePara, Context context, int i3) {
        String format = String.format(Locale.US, AMAPROUTEURL, b9.b(context), Double.valueOf(routePara.getStartPoint().latitude), Double.valueOf(routePara.getStartPoint().longitude), routePara.getStartName(), Double.valueOf(routePara.getEndPoint().latitude), Double.valueOf(routePara.getEndPoint().longitude), routePara.getEndName(), Integer.valueOf(i3));
        if (i3 == 1) {
            StringBuilder u10 = l0.u(format, "&m=");
            u10.append(routePara.getTransitRouteStyle());
            return u10.toString();
        }
        if (i3 != 2) {
            return format;
        }
        StringBuilder u11 = l0.u(format, "&m=");
        u11.append(routePara.getDrivingRouteStyle());
        return u11.toString();
    }

    public static float calculateArea(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e) {
                e.printStackTrace();
                return 0.0f;
            }
        }
        try {
            double sin = Math.sin((latLng.latitude * 3.141592653589793d) / 180.0d) - Math.sin((latLng2.latitude * 3.141592653589793d) / 180.0d);
            double d5 = (latLng2.longitude - latLng.longitude) / 360.0d;
            if (d5 < 0.0d) {
                d5 += 1.0d;
            }
            return (float) (sin * 2.5560394669790553E14d * d5);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public static float calculateLineDistance(LatLng latLng, LatLng latLng2) {
        if (latLng == null || latLng2 == null) {
            try {
                throw new AMapException(AMapException.ERROR_ILLEGAL_VALUE);
            } catch (AMapException e) {
                e.printStackTrace();
                return 0.0f;
            }
        }
        try {
            double d5 = latLng.longitude;
            double d8 = latLng.latitude;
            double d10 = latLng2.longitude;
            double d11 = latLng2.latitude;
            double d12 = d5 * NF_PI;
            double d13 = d8 * NF_PI;
            double d14 = d10 * NF_PI;
            double d15 = d11 * NF_PI;
            double sin = Math.sin(d12);
            double sin2 = Math.sin(d13);
            double cos = Math.cos(d12);
            double cos2 = Math.cos(d13);
            double sin3 = Math.sin(d14);
            double sin4 = Math.sin(d15);
            double cos3 = Math.cos(d14);
            double cos4 = Math.cos(d15);
            double[] dArr = {cos * cos2, cos2 * sin, sin2};
            double[] dArr2 = {cos3 * cos4, cos4 * sin3, sin4};
            double d16 = dArr[0];
            double d17 = dArr2[0];
            double d18 = (d16 - d17) * (d16 - d17);
            double d19 = dArr[1];
            double d20 = dArr2[1];
            double d21 = ((d19 - d20) * (d19 - d20)) + d18;
            double d22 = dArr[2];
            double d23 = dArr2[2];
            return (float) (Math.asin(Math.sqrt(((d22 - d23) * (d22 - d23)) + d21) / 2.0d) * 1.27420015798544E7d);
        } catch (Throwable th2) {
            th2.printStackTrace();
            return 0.0f;
        }
    }

    public static void getLatestAMapApp(Context context) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addFlags(276824064);
            intent.addCategory("android.intent.category.DEFAULT");
            intent.setData(Uri.parse("http://wap.amap.com/"));
            new a("glaa", context).start();
            context.startActivity(intent);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public static void openAMapDrivingRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 2);
    }

    public static void openAMapNavi(NaviPara naviPara, Context context) throws AMapException {
        if (naviPara.getTargetPoint() == null) {
            throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(276824064);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse(a(naviPara, context)));
        intent.setPackage("com.autonavi.minimap");
        new a("oan", context).start();
        context.startActivity(intent);
    }

    public static void openAMapPoiNearbySearch(PoiPara poiPara, Context context) throws AMapException {
        if (poiPara.getKeywords() == null || poiPara.getKeywords().trim().length() <= 0) {
            throw new AMapException(AMapException.ILLEGAL_AMAP_ARGUMENT);
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.addFlags(276824064);
        intent.addCategory("android.intent.category.DEFAULT");
        intent.setData(Uri.parse(a(poiPara, context)));
        intent.setPackage("com.autonavi.minimap");
        new a("oan", context).start();
        context.startActivity(intent);
    }

    public static void openAMapTransitRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 1);
    }

    public static void openAMapWalkingRoute(RoutePara routePara, Context context) throws AMapException {
        a(routePara, context, 4);
    }

    public static float calculateArea(List<LatLng> list) {
        if (list == null || list.size() < 3) {
            return 0.0f;
        }
        int size = list.size();
        double d5 = 0.0d;
        int i3 = 0;
        while (i3 < size) {
            LatLng latLng = list.get(i3);
            i3++;
            LatLng latLng2 = list.get(i3 % size);
            double cos = Math.cos(latLng.latitude * DEG_TO_RAD) * latLng.longitude * 111319.49079327357d;
            double d8 = latLng.latitude * 111319.49079327357d;
            d5 += ((latLng2.latitude * 111319.49079327357d) * cos) - ((Math.cos(latLng2.latitude * DEG_TO_RAD) * (latLng2.longitude * 111319.49079327357d)) * d8);
        }
        return (float) Math.abs(d5 / 2.0d);
    }

    private static String a(NaviPara naviPara, Context context) {
        return String.format(Locale.US, AMAPNAVIURL, b9.b(context), Double.valueOf(naviPara.getTargetPoint().latitude), Double.valueOf(naviPara.getTargetPoint().longitude), Integer.valueOf(naviPara.getNaviStyle()));
    }

    private static String a(PoiPara poiPara, Context context) {
        Locale locale = Locale.US;
        String q5 = l0.q("androidamap://arroundpoi?sourceApplication=", b9.b(context), "&keywords=", poiPara.getKeywords(), "&dev=0");
        if (poiPara.getCenter() == null) {
            return q5;
        }
        StringBuilder u10 = l0.u(q5, "&lat=");
        u10.append(poiPara.getCenter().latitude);
        u10.append("&lon=");
        u10.append(poiPara.getCenter().longitude);
        return u10.toString();
    }
}
