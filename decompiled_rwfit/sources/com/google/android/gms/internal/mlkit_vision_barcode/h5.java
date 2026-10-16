package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public final class h5 implements rb.c {

    /* renamed from: a, reason: collision with root package name */
    public static final h5 f9329a = new h5();

    /* renamed from: b, reason: collision with root package name */
    public static final rb.b f9330b = new rb.b("imageFormat", l0.y(l0.w(j0.class, new g0(1, zzfd.zza))));

    /* renamed from: c, reason: collision with root package name */
    public static final rb.b f9331c = new rb.b("originalImageSize", l0.y(l0.w(j0.class, new g0(2, zzfd.zza))));

    /* renamed from: d, reason: collision with root package name */
    public static final rb.b f9332d = new rb.b("compressedImageSize", l0.y(l0.w(j0.class, new g0(3, zzfd.zza))));
    public static final rb.b e = new rb.b("isOdmlImage", l0.y(l0.w(j0.class, new g0(4, zzfd.zza))));

    @Override // rb.a
    public final void a(Object obj, Object obj2) {
        eb ebVar = (eb) obj;
        rb.d dVar = (rb.d) obj2;
        dVar.a(f9330b, ebVar.f9284a);
        dVar.a(f9331c, ebVar.f9285b);
        dVar.a(f9332d, null);
        dVar.a(e, null);
    }
}
