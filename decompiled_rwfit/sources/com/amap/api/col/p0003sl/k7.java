package com.amap.api.col.p0003sl;

/* loaded from: classes.dex */
class k7 {

    /* renamed from: a, reason: collision with root package name */
    private static volatile boolean f4369a = false;

    public static synchronized void a() {
        synchronized (k7.class) {
            if (!f4369a) {
                l7.a().a("regeo", new n7("/geocode/regeo"));
                l7.a().a("placeAround", new n7("/place/around"));
                l7.a().a("placeText", new m7("/place/text"));
                l7.a().a("geo", new m7("/geocode/geo"));
                f4369a = true;
            }
        }
    }
}
