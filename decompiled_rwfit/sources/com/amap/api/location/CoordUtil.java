package com.amap.api.location;

/* loaded from: classes.dex */
public class CoordUtil {

    /* renamed from: a, reason: collision with root package name */
    private static boolean f5674a = false;

    public static native int convertToGcj(double[] dArr, double[] dArr2);

    public static boolean isLoadedSo() {
        return f5674a;
    }

    public static void setLoadedSo(boolean z5) {
        f5674a = z5;
    }
}
