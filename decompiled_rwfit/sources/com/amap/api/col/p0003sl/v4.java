package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.amap.api.col.p0003sl.m9;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.BaseHoleOptions;
import com.amap.api.maps.model.CircleHoleOptions;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.PolygonHoleOptions;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.VirtualEarthProjection;
import com.autonavi.amap.mapcore.interfaces.IMapConfig;
import com.autonavi.aps.amapapi.config.Const;
import com.autonavi.base.amap.mapcore.AeUtil;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.FileUtil;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.File;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/* loaded from: classes.dex */
public class v4 {

    /* renamed from: a, reason: collision with root package name */
    private static int f5180a;

    /* renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f5181b = 0;

    static {
        FPoint.obtain();
        FPoint.obtain();
        FPoint.obtain();
        FPoint.obtain();
        new ArrayList(4);
        new ArrayList(4);
        f5180a = 0;
    }

    public static void a(Bitmap bitmap) {
    }

    public static String b(Context context) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(FileUtil.getMapBaseStorage(context));
        String str = File.separator;
        sb2.append(str);
        sb2.append(AeUtil.ROOT_DATA_PATH_OLD_NAME);
        sb2.append(str);
        return sb2.toString();
    }

    public static String c(Context context) {
        File file = new File(FileUtil.getMapBaseStorage(context), AeUtil.ROOT_DATA_PATH_NAME);
        if (!file.exists()) {
            file.mkdir();
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(file.toString());
        String str = File.separator;
        sb2.append(str);
        File file2 = new File(sb2.toString());
        if (!file2.exists()) {
            file2.mkdir();
        }
        return file.toString() + str;
    }

    public static boolean d(Context context) {
        ConnectivityManager connectivityManager;
        NetworkInfo activeNetworkInfo;
        NetworkInfo.State state;
        return (context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null || (activeNetworkInfo = connectivityManager.getActiveNetworkInfo()) == null || (state = activeNetworkInfo.getState()) == null || state == NetworkInfo.State.DISCONNECTED || state == NetworkInfo.State.DISCONNECTING) ? false : true;
    }

    public static boolean a(double d5, double d8, double d10, double d11, double d12, double d13, double d14, double d15) {
        double d16 = d10 - d5;
        double d17 = d15 - d13;
        double d18 = d11 - d8;
        double d19 = d14 - d12;
        double d20 = (d16 * d17) - (d18 * d19);
        if (d20 == 0.0d) {
            return false;
        }
        double d21 = d8 - d13;
        double d22 = d5 - d12;
        double d23 = ((d19 * d21) - (d17 * d22)) / d20;
        double d24 = ((d21 * d16) - (d22 * d18)) / d20;
        return d23 >= 0.0d && d23 <= 1.0d && d24 >= 0.0d && d24 <= 1.0d;
    }

    public static m9 b() {
        try {
            if (v0.f5169d == null) {
                v0.f5169d = new m9.a("3dmap", "11.1.063", v0.f5168c).a(new String[]{"com.amap.api.maps", "com.amap.api.mapcore", "com.autonavi.amap.mapcore", "com.autonavi.amap", "com.autonavi.ae", "com.autonavi.base", "com.autonavi.patch", "com.amap.api.3dmap.admic", "com.amap.api.trace", "com.amap.api.trace.core"}).a("11.1.063").a();
            }
            return v0.f5169d;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Bitmap a(Context context, String str) {
        try {
            InputStream open = s4.a(context).open(str);
            Bitmap decodeStream = BitmapFactory.decodeStream(open);
            open.close();
            return decodeStream;
        } catch (Throwable th2) {
            ka.a(th2, "Util", "fromAsset");
            a(th2);
            return null;
        }
    }

    public static boolean b(List<BaseHoleOptions> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z5 = false;
        for (int i3 = 0; i3 < list.size(); i3++) {
            BaseHoleOptions baseHoleOptions = list.get(i3);
            if (baseHoleOptions instanceof PolygonHoleOptions) {
                List<LatLng> points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
                List<LatLng> points2 = polygonHoleOptions.getPoints();
                int i10 = 0;
                while (true) {
                    try {
                        if (i10 < points2.size()) {
                            if (a(points2.get(i10), points)) {
                                break;
                            }
                            i10++;
                        } else {
                            for (int i11 = 0; i11 < points.size(); i11++) {
                                if (!a(points.get(i11), points2)) {
                                }
                            }
                            z5 = a(points, points2);
                        }
                    } catch (Throwable th2) {
                        ka.a(th2, "Util", "isPolygon2PolygonIntersect");
                        th2.printStackTrace();
                        z5 = false;
                    }
                }
                z5 = true;
                if (z5) {
                    return true;
                }
            } else if (baseHoleOptions instanceof CircleHoleOptions) {
                z5 = b(polygonHoleOptions.getPoints(), (CircleHoleOptions) baseHoleOptions);
                if (z5) {
                    return true;
                }
            } else {
                continue;
            }
        }
        return z5;
    }

    public static void a(Drawable drawable) {
        if (drawable != null) {
            drawable.setCallback(null);
        }
    }

    private static void c(View view) {
        int i3 = 0;
        if (!(view instanceof ViewGroup)) {
            if (view instanceof TextView) {
                ((TextView) view).setHorizontallyScrolling(false);
            }
        } else {
            while (true) {
                ViewGroup viewGroup = (ViewGroup) view;
                if (i3 >= viewGroup.getChildCount()) {
                    return;
                }
                c(viewGroup.getChildAt(i3));
                i3++;
            }
        }
    }

    public static String a(String str, Object obj) {
        StringBuilder u10 = l0.u(str, "=");
        u10.append(String.valueOf(obj));
        return u10.toString();
    }

    public static float a(IMapConfig iMapConfig, float f2, float f10) {
        boolean z5;
        boolean z6 = false;
        if (iMapConfig != null) {
            boolean isAbroadEnable = iMapConfig.isAbroadEnable();
            z5 = iMapConfig.getAbroadState() != 1;
            z6 = isAbroadEnable;
        } else {
            z5 = false;
        }
        float f11 = f2 >= 0.0f ? f2 : 0.0f;
        if (z6 && z5) {
            float f12 = 40;
            if (f11 > f12) {
                return f12;
            }
        } else if (iMapConfig != null && iMapConfig.isTerrainEnable()) {
            float f13 = 80;
            if (f11 > f13) {
                return f13;
            }
        } else if (f2 > 40.0f) {
            float f14 = f10 > 15.0f ? f10 <= 16.0f ? 56 : f10 <= 17.0f ? 66 : f10 <= 18.0f ? 74 : f10 <= 18.0f ? 78 : 80 : 40;
            if (f11 > f14) {
                return f14;
            }
        }
        return f11;
    }

    public static float a(IMapConfig iMapConfig, float f2) {
        if (iMapConfig != null) {
            if (f2 > iMapConfig.getMaxZoomLevel()) {
                return iMapConfig.getMaxZoomLevel();
            }
            if (f2 < iMapConfig.getMinZoomLevel()) {
                return iMapConfig.getMinZoomLevel();
            }
        } else {
            if (f2 > 20.0f) {
                return 20.0f;
            }
            if (f2 < 3.0f) {
                return 3.0f;
            }
        }
        return f2;
    }

    public static boolean b(List<LatLng> list, CircleHoleOptions circleHoleOptions) {
        int i3;
        try {
            ArrayList arrayList = new ArrayList();
            for (int i10 = 0; i10 < list.size(); i10++) {
                arrayList.add(list.get(i10));
            }
            arrayList.add(list.get(0));
            ArrayList arrayList2 = new ArrayList();
            int i11 = 0;
            while (i11 < arrayList.size() && (i3 = i11 + 1) < arrayList.size()) {
                if (circleHoleOptions.getRadius() < AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i11)) && circleHoleOptions.getRadius() < AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) arrayList.get(i3))) {
                    arrayList2.clear();
                    arrayList2.add(arrayList.get(i11));
                    arrayList2.add(arrayList.get(i3));
                    if (circleHoleOptions.getRadius() >= AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), (LatLng) SpatialRelationUtil.calShortestDistancePoint(arrayList2, circleHoleOptions.getCenter()).second)) {
                        return true;
                    }
                    i11 = i3;
                }
                return true;
            }
        } catch (Throwable th2) {
            ka.a(th2, "Util", "isPolygon2CircleIntersect");
            th2.printStackTrace();
        }
        return false;
    }

    public static String a(String... strArr) {
        StringBuilder sb2 = new StringBuilder();
        int i3 = 0;
        for (String str : strArr) {
            sb2.append(str);
            if (i3 != strArr.length - 1) {
                sb2.append(Const.STR_MART_COMMA);
            }
            i3++;
        }
        return sb2.toString();
    }

    public static Bitmap a(Bitmap bitmap, float f2) {
        if (bitmap == null) {
            return null;
        }
        return Bitmap.createScaledBitmap(bitmap, (int) (bitmap.getWidth() * f2), (int) (bitmap.getHeight() * f2), true);
    }

    public static String a(Context context) {
        String c9 = c(context);
        if (c9 == null) {
            return null;
        }
        File file = new File(c9, "VMAP2");
        if (!file.exists()) {
            file.mkdir();
        }
        return file.toString() + File.separator;
    }

    public static boolean a(LatLng latLng, List<LatLng> list) {
        boolean z5;
        if (latLng == null || list == null) {
            return false;
        }
        double d5 = latLng.longitude;
        double d8 = latLng.latitude;
        if (list.size() < 3) {
            return false;
        }
        if (list.get(0).equals(list.get(list.size() - 1))) {
            z5 = false;
        } else {
            list.add(list.get(0));
            z5 = true;
        }
        int i3 = 0;
        int i10 = 0;
        while (i3 < list.size() - 1) {
            try {
                double d10 = list.get(i3).longitude;
                double d11 = list.get(i3).latitude;
                i3++;
                double d12 = list.get(i3).longitude;
                double d13 = list.get(i3).latitude;
                double d14 = d5;
                double d15 = d8;
                d5 = d14;
                d8 = d15;
                if (a(d14, d15, d10, d11, d12, d13)) {
                    if (z5) {
                        list.remove(list.size() - 1);
                    }
                    return true;
                }
                if (Math.abs(d13 - d11) >= 1.0E-9d) {
                    if (a(d10, d11, d5, d8, 180.0d, d8)) {
                        if (d11 > d13) {
                            i10++;
                        }
                    } else if (!a(d12, d13, d5, d8, 180.0d, d8)) {
                        boolean a3 = a(d10, d11, d12, d13, d5, d8, 180.0d, d8);
                        d5 = d5;
                        d8 = d8;
                        if (a3) {
                            i10++;
                        }
                    } else if (d13 > d11) {
                        i10++;
                    }
                }
            } catch (Throwable th2) {
                if (z5) {
                    list.remove(list.size() - 1);
                }
                throw th2;
            }
        }
        boolean z6 = i10 % 2 != 0;
        if (z5) {
            list.remove(list.size() - 1);
        }
        return z6;
    }

    public static String b(View view) {
        StringBuilder sb2 = new StringBuilder();
        if (view != null) {
            try {
                if (view instanceof TextView) {
                    sb2 = new StringBuilder(((TextView) view).getText().toString());
                }
                if (view instanceof ViewGroup) {
                    int childCount = ((ViewGroup) view).getChildCount();
                    for (int i3 = 0; i3 < childCount; i3++) {
                        String b3 = b(((ViewGroup) view).getChildAt(i3));
                        if (!TextUtils.isEmpty(b3)) {
                            sb2.append("--");
                            sb2.append(b3);
                        }
                    }
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
        return sb2.toString();
    }

    public static boolean a(double d5, double d8, double d10, double d11, double d12, double d13) {
        if (Math.abs(((d13 - d8) * (d10 - d5)) - ((d11 - d8) * (d12 - d5))) >= 1.0E-9d) {
            return false;
        }
        if ((d5 - d12) * (d5 - d10) <= 0.0d) {
            return (d8 - d13) * (d8 - d11) <= 0.0d;
        }
        return false;
    }

    public static boolean a(BaseHoleOptions baseHoleOptions, LatLng latLng) {
        if (baseHoleOptions instanceof CircleHoleOptions) {
            CircleHoleOptions circleHoleOptions = (CircleHoleOptions) baseHoleOptions;
            LatLng center = circleHoleOptions.getCenter();
            return center != null && ((double) AMapUtils.calculateLineDistance(center, latLng)) <= circleHoleOptions.getRadius();
        }
        List<LatLng> points = ((PolygonHoleOptions) baseHoleOptions).getPoints();
        if (points == null || points.size() == 0) {
            return false;
        }
        return a(latLng, points);
    }

    public static Bitmap a(View view) {
        try {
            c(view);
            view.destroyDrawingCache();
            view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
            view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            Bitmap drawingCache = view.getDrawingCache();
            if (drawingCache != null) {
                return drawingCache.copy(Bitmap.Config.ARGB_8888, false);
            }
            return null;
        } catch (Throwable th2) {
            ka.a(th2, "Utils", "getBitmapFromView");
            th2.printStackTrace();
            return null;
        }
    }

    public static DPoint a(LatLng latLng) {
        double d5 = (latLng.longitude / 360.0d) + 0.5d;
        double sin = Math.sin(Math.toRadians(latLng.latitude));
        return DPoint.obtain(d5 * 1.0d, (((Math.log((sin + 1.0d) / (1.0d - sin)) * 0.5d) / (-6.283185307179586d)) + 0.5d) * 1.0d);
    }

    public static Pair<Float, IPoint> a(IMapConfig iMapConfig, int i3, int i10, int i11, int i12, LatLngBounds latLngBounds, int i13, int i14) {
        LatLng latLng;
        boolean z5;
        float min;
        int i15;
        float f2;
        float f10;
        int i16;
        if (latLngBounds == null || (latLng = latLngBounds.northeast) == null || latLngBounds.southwest == null || iMapConfig == null) {
            return null;
        }
        Point latLongToPixels = VirtualEarthProjection.latLongToPixels(latLng.latitude, latLng.longitude, 20);
        LatLng latLng2 = latLngBounds.southwest;
        Point latLongToPixels2 = VirtualEarthProjection.latLongToPixels(latLng2.latitude, latLng2.longitude, 20);
        int i17 = latLongToPixels.x;
        int i18 = latLongToPixels2.x;
        int i19 = i17 - i18;
        int i20 = latLongToPixels2.y;
        int i21 = latLongToPixels.y;
        int i22 = i20 - i21;
        int i23 = i13 - (i3 + i10);
        int i24 = i14 - (i11 + i12);
        if (i19 < 0 && i22 < 0) {
            return null;
        }
        if (i19 <= 0) {
            i19 = 1;
        }
        int i25 = i22 <= 0 ? 1 : i22;
        if (i23 <= 0) {
            i23 = 1;
        }
        if (i24 <= 0) {
            i24 = 1;
        }
        iMapConfig.getSZ();
        if (i17 == i18 && i21 == i20) {
            min = iMapConfig.getMaxZoomLevel();
            z5 = true;
        } else {
            float a3 = (float) a(iMapConfig.getMapZoomScale(), i24, Math.abs(i22));
            float a10 = (float) a(iMapConfig.getMapZoomScale(), i23, Math.abs(i18 - i17));
            float min2 = Math.min(a10, a3);
            z5 = min2 == a10;
            min = Math.min(iMapConfig.getMaxZoomLevel(), Math.max(iMapConfig.getMinZoomLevel(), min2));
        }
        Pair pair = new Pair(Float.valueOf(min), Boolean.valueOf(z5));
        Float f11 = (Float) pair.first;
        float floatValue = f11.floatValue();
        boolean booleanValue = ((Boolean) pair.second).booleanValue();
        double d5 = 20.0f - floatValue;
        float pow = (float) (i19 / (Math.pow(2.0d, d5) * iMapConfig.getMapZoomScale()));
        float pow2 = (float) (i25 / (Math.pow(2.0d, d5) * iMapConfig.getMapZoomScale()));
        if (floatValue >= iMapConfig.getMaxZoomLevel()) {
            i15 = (int) (((((i10 - i3) + pow) * i19) / (pow * 2.0f)) + latLongToPixels2.x);
            i16 = latLongToPixels.y;
        } else if (booleanValue) {
            i15 = (int) (((((i13 / 2) - i3) / pow) * i19) + latLongToPixels2.x);
            i16 = latLongToPixels.y;
        } else {
            i15 = (int) (((((i10 - i3) + pow) * i19) / (pow * 2.0f)) + latLongToPixels2.x);
            f2 = latLongToPixels.y;
            f10 = (((i14 / 2) - i11) / pow2) * i25;
            return new Pair<>(f11, IPoint.obtain((int) (i15 + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f10 + f2)) + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
        }
        f2 = i16;
        f10 = (((i12 - i11) + pow2) * i25) / (pow2 * 2.0f);
        return new Pair<>(f11, IPoint.obtain((int) (i15 + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorX() - (iMapConfig.getMapWidth() >> 1))), (int) (((int) (f10 + f2)) + a(iMapConfig.getMapZoomScale(), floatValue, iMapConfig.getAnchorY() - (iMapConfig.getMapHeight() >> 1)))));
    }

    public static double a(float f2, double d5, double d8) {
        return 20.0d - (Math.log(d8 / (d5 * f2)) / Math.log(2.0d));
    }

    private static float a(float f2, float f10, float f11) {
        return (float) (Math.pow(2.0d, 20.0f - f10) * f11 * f2);
    }

    public static synchronized int[] a(int i3, int i10, int i11, int i12, IMapConfig iMapConfig, IGLMapState iGLMapState, int i13, int i14) {
        int[] iArr;
        synchronized (v4.class) {
            int mapWidth = iMapConfig.getMapWidth();
            int mapHeight = iMapConfig.getMapHeight();
            int anchorX = iMapConfig.getAnchorX();
            int anchorY = iMapConfig.getAnchorY();
            iArr = new int[]{(int) Math.max(i11 + a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), anchorX), Math.min(i13, i3 - a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapWidth - anchorX))), (int) Math.max(i10 + a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), anchorY), Math.min(i14, i12 - a(iMapConfig.getMapZoomScale(), iGLMapState.getMapZoomer(), mapHeight - anchorY)))};
        }
        return iArr;
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x002a, code lost:
    
        r2.setPixel(r5, r6, r9);
     */
    /* JADX WARN: Removed duplicated region for block: B:28:0x005a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static byte[] a(byte[] r7, int r8, int r9, boolean r10) {
        /*
            int r0 = r7.length     // Catch: java.lang.Throwable -> L26
            r1 = 0
            android.graphics.Bitmap r0 = android.graphics.BitmapFactory.decodeByteArray(r7, r1, r0)     // Catch: java.lang.Throwable -> L26
            android.graphics.Bitmap$Config r2 = r0.getConfig()     // Catch: java.lang.Throwable -> L26
            r3 = 1
            android.graphics.Bitmap r2 = r0.copy(r2, r3)     // Catch: java.lang.Throwable -> L26
            int r3 = r0.getWidth()     // Catch: java.lang.Throwable -> L26
            int r4 = r0.getHeight()     // Catch: java.lang.Throwable -> L26
            r5 = r1
        L18:
            if (r5 >= r3) goto L33
            r6 = r1
        L1b:
            if (r6 >= r4) goto L30
            if (r5 == 0) goto L28
            if (r6 != 0) goto L22
            goto L28
        L22:
            r2.setPixel(r5, r6, r8)     // Catch: java.lang.Throwable -> L26
            goto L2d
        L26:
            r8 = move-exception
            goto L63
        L28:
            if (r10 != 0) goto L2d
            r2.setPixel(r5, r6, r9)     // Catch: java.lang.Throwable -> L26
        L2d:
            int r6 = r6 + 1
            goto L1b
        L30:
            int r5 = r5 + 1
            goto L18
        L33:
            r8 = 0
            java.io.ByteArrayOutputStream r9 = new java.io.ByteArrayOutputStream     // Catch: java.lang.Throwable -> L4d
            r9.<init>()     // Catch: java.lang.Throwable -> L4d
            android.graphics.Bitmap$CompressFormat r10 = android.graphics.Bitmap.CompressFormat.PNG     // Catch: java.lang.Throwable -> L4e
            r1 = 100
            r2.compress(r10, r1, r9)     // Catch: java.lang.Throwable -> L4e
            byte[] r8 = r9.toByteArray()     // Catch: java.lang.Throwable -> L4e
            r9.close()     // Catch: java.lang.Throwable -> L48
            goto L58
        L48:
            r9 = move-exception
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L26
            goto L58
        L4d:
            r9 = r8
        L4e:
            if (r9 == 0) goto L58
            r9.close()     // Catch: java.lang.Throwable -> L54
            goto L58
        L54:
            r9 = move-exception
            r9.printStackTrace()     // Catch: java.lang.Throwable -> L26
        L58:
            if (r8 != 0) goto L5b
            r8 = r7
        L5b:
            a(r2)     // Catch: java.lang.Throwable -> L26
            a(r0)     // Catch: java.lang.Throwable -> L26
            r7 = r8
            goto L66
        L63:
            r8.printStackTrace()
        L66:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.v4.a(byte[], int, int, boolean):byte[]");
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0054 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(java.util.List<com.amap.api.maps.model.BaseHoleOptions> r10, com.amap.api.maps.model.CircleHoleOptions r11) {
        /*
            r0 = 0
            r1 = r0
            r2 = r1
        L3:
            int r3 = r10.size()
            if (r1 >= r3) goto L57
            java.lang.Object r3 = r10.get(r1)
            com.amap.api.maps.model.BaseHoleOptions r3 = (com.amap.api.maps.model.BaseHoleOptions) r3
            boolean r4 = r3 instanceof com.amap.api.maps.model.PolygonHoleOptions
            r5 = 1
            if (r4 == 0) goto L21
            com.amap.api.maps.model.PolygonHoleOptions r3 = (com.amap.api.maps.model.PolygonHoleOptions) r3
            java.util.List r2 = r3.getPoints()
            boolean r2 = b(r2, r11)
            if (r2 == 0) goto L54
            return r5
        L21:
            boolean r4 = r3 instanceof com.amap.api.maps.model.CircleHoleOptions
            if (r4 == 0) goto L54
            com.amap.api.maps.model.CircleHoleOptions r3 = (com.amap.api.maps.model.CircleHoleOptions) r3
            com.amap.api.maps.model.LatLng r2 = r3.getCenter()     // Catch: java.lang.Throwable -> L45
            com.amap.api.maps.model.LatLng r4 = r11.getCenter()     // Catch: java.lang.Throwable -> L45
            float r2 = com.amap.api.maps.AMapUtils.calculateLineDistance(r2, r4)     // Catch: java.lang.Throwable -> L45
            double r6 = (double) r2     // Catch: java.lang.Throwable -> L45
            double r8 = r11.getRadius()     // Catch: java.lang.Throwable -> L45
            double r2 = r3.getRadius()     // Catch: java.lang.Throwable -> L45
            double r8 = r8 + r2
            int r2 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r2 >= 0) goto L43
            r2 = r5
            goto L51
        L43:
            r2 = r0
            goto L51
        L45:
            r2 = move-exception
            java.lang.String r3 = "Util"
            java.lang.String r4 = "isPolygon2CircleIntersect"
            com.amap.api.col.p0003sl.ka.a(r2, r3, r4)
            r2.printStackTrace()
            goto L43
        L51:
            if (r2 == 0) goto L54
            return r5
        L54:
            int r1 = r1 + 1
            goto L3
        L57:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.v4.a(java.util.List, com.amap.api.maps.model.CircleHoleOptions):boolean");
    }

    private static boolean a(List<LatLng> list, List<LatLng> list2) {
        int i3;
        int i10;
        int i11 = 0;
        while (i11 < list.size() && (i3 = i11 + 1) < list.size()) {
            try {
                int i12 = 0;
                while (i12 < list2.size() && (i10 = i12 + 1) < list2.size()) {
                    boolean a3 = o4.a(list.get(i11), list.get(i3), list2.get(i12), list2.get(i10));
                    if (a3) {
                        return a3;
                    }
                    i12 = i10;
                }
                i11 = i3;
            } catch (Throwable th2) {
                ka.a(th2, "Util", "isSegmentsIntersect");
                th2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean a(List<LatLng> list, PolygonHoleOptions polygonHoleOptions) {
        boolean z5 = false;
        z5 = false;
        z5 = false;
        if (list != null && polygonHoleOptions != null) {
            try {
                List<LatLng> points = polygonHoleOptions.getPoints();
                boolean z6 = false;
                for (int i3 = 0; i3 < points.size(); i3++) {
                    try {
                        z6 = a(points.get(i3), list);
                        if (!z6) {
                            return z6;
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        z5 = z6;
                        ka.a(th, "PolygonDelegateImp", "isPolygonInPolygon");
                        th.printStackTrace();
                        return z5;
                    }
                }
                return z6;
            } catch (Throwable th3) {
                th = th3;
            }
        }
        return z5;
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0043 A[LOOP:0: B:5:0x0008->B:19:0x0043, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0042 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static boolean a(double r7, com.amap.api.maps.model.LatLng r9, java.util.List<com.amap.api.maps.model.BaseHoleOptions> r10, com.amap.api.maps.model.PolygonHoleOptions r11) {
        /*
            r0 = 1
            java.util.List r11 = r11.getPoints()     // Catch: java.lang.Throwable -> L47
            r1 = 0
            r3 = r0
            r2 = r1
        L8:
            int r4 = r11.size()     // Catch: java.lang.Throwable -> L31
            if (r2 >= r4) goto L46
            java.lang.Object r4 = r11.get(r2)     // Catch: java.lang.Throwable -> L31
            com.amap.api.maps.model.LatLng r4 = (com.amap.api.maps.model.LatLng) r4     // Catch: java.lang.Throwable -> L31
            int r5 = r10.size()     // Catch: java.lang.Throwable -> L31
            if (r5 <= 0) goto L34
            java.util.Iterator r5 = r10.iterator()     // Catch: java.lang.Throwable -> L31
        L1e:
            boolean r6 = r5.hasNext()     // Catch: java.lang.Throwable -> L31
            if (r6 == 0) goto L34
            java.lang.Object r6 = r5.next()     // Catch: java.lang.Throwable -> L31
            com.amap.api.maps.model.BaseHoleOptions r6 = (com.amap.api.maps.model.BaseHoleOptions) r6     // Catch: java.lang.Throwable -> L31
            boolean r6 = a(r6, r4)     // Catch: java.lang.Throwable -> L31
            if (r6 == 0) goto L1e
            goto L3f
        L31:
            r7 = move-exception
            r0 = r3
            goto L48
        L34:
            float r3 = com.amap.api.maps.AMapUtils.calculateLineDistance(r9, r4)     // Catch: java.lang.Throwable -> L31
            double r3 = (double) r3
            int r3 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r3 < 0) goto L3f
            r3 = r0
            goto L40
        L3f:
            r3 = r1
        L40:
            if (r3 != 0) goto L43
            return r3
        L43:
            int r2 = r2 + 1
            goto L8
        L46:
            return r3
        L47:
            r7 = move-exception
        L48:
            java.lang.String r8 = "CircleDelegateImp"
            java.lang.String r9 = "isPolygonInCircle"
            com.amap.api.col.p0003sl.ka.a(r7, r8, r9)
            r7.printStackTrace()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.v4.a(double, com.amap.api.maps.model.LatLng, java.util.List, com.amap.api.maps.model.PolygonHoleOptions):boolean");
    }

    public static boolean a(double d5, LatLng latLng, CircleHoleOptions circleHoleOptions) {
        try {
            return ((double) AMapUtils.calculateLineDistance(circleHoleOptions.getCenter(), latLng)) <= d5 - circleHoleOptions.getRadius();
        } catch (Throwable th2) {
            ka.a(th2, "CircleDelegateImp", "isCircleInCircle");
            th2.printStackTrace();
            return true;
        }
    }

    public static void a(Throwable th2) {
        try {
            if (MapsInitializer.getExceptionLogger() != null) {
                MapsInitializer.getExceptionLogger().onException(th2);
            }
        } catch (Throwable unused) {
        }
    }

    public static String a(String str, Context context) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse.getAuthority() != null && parse.getAuthority().startsWith("dualstack-")) {
                return str;
            }
            g9 b3 = g9.b(context);
            String a3 = b3.a(41);
            String a10 = b3.a(26);
            if (parse.getAuthority() != null && parse.getAuthority().startsWith(a3)) {
                return parse.buildUpon().authority("dualstack-" + a10).build().toString();
            }
            return parse.buildUpon().authority("dualstack-" + parse.getAuthority()).build().toString();
        } catch (Throwable unused) {
            return str;
        }
    }

    public static Bitmap a(int[] iArr, int i3, int i10, boolean z5) {
        try {
            int[] iArr2 = new int[iArr.length];
            for (int i11 = 0; i11 < i10; i11++) {
                for (int i12 = 0; i12 < i3; i12++) {
                    int i13 = (i11 * i3) + i12;
                    int i14 = iArr[i13];
                    int i15 = (i14 & (-16711936)) | ((i14 << 16) & 16711680) | ((i14 >> 16) & 255);
                    if (z5) {
                        iArr2[(((i10 - i11) - 1) * i3) + i12] = i15;
                    } else {
                        iArr2[i13] = i15;
                    }
                }
            }
            Bitmap createBitmap = Bitmap.createBitmap(i3, i10, Bitmap.Config.ARGB_8888);
            createBitmap.setPixels(iArr2, 0, i3, 0, 0, i3, i10);
            return createBitmap;
        } catch (Throwable th2) {
            ka.a(th2, "Util", "rgbaToArgb");
            th2.printStackTrace();
            return null;
        }
    }

    public static synchronized int a() {
        int i3;
        synchronized (v4.class) {
            try {
                int i10 = f5180a + 1;
                f5180a = i10;
                if (i10 == Integer.MAX_VALUE) {
                    f5180a = 0;
                }
                i3 = f5180a;
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return i3;
    }

    public static LinkedHashMap<String, String> a(String str, String str2) {
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        for (String str3 : str.split(Const.STR_MART_ADD)) {
            if (!TextUtils.isEmpty(str3)) {
                String[] split = str3.split(str2);
                if (split.length == 2) {
                    linkedHashMap.put(split[0], split[1]);
                }
            }
        }
        return linkedHashMap;
    }
}
