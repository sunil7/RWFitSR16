package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public final class g6 implements rb.c {

    /* renamed from: a, reason: collision with root package name */
    public static final g6 f9308a = new g6();

    /* renamed from: b, reason: collision with root package name */
    public static final rb.b f9309b = new rb.b("inferenceCommonLogEvent", l0.y(l0.w(j0.class, new g0(1, zzfd.zza))));

    /* renamed from: c, reason: collision with root package name */
    public static final rb.b f9310c = new rb.b("options", l0.y(l0.w(j0.class, new g0(2, zzfd.zza))));

    /* renamed from: d, reason: collision with root package name */
    public static final rb.b f9311d = new rb.b("detectedBarcodeFormats", l0.y(l0.w(j0.class, new g0(3, zzfd.zza))));
    public static final rb.b e = new rb.b("detectedBarcodeValueTypes", l0.y(l0.w(j0.class, new g0(4, zzfd.zza))));

    /* renamed from: f, reason: collision with root package name */
    public static final rb.b f9312f = new rb.b("imageInfo", l0.y(l0.w(j0.class, new g0(5, zzfd.zza))));

    @Override // rb.a
    public final void a(Object obj, Object obj2) {
        ac acVar = (ac) obj;
        rb.d dVar = (rb.d) obj2;
        dVar.a(f9309b, acVar.f9215a);
        dVar.a(f9310c, acVar.f9216b);
        dVar.a(f9311d, acVar.f9217c);
        dVar.a(e, acVar.f9218d);
        dVar.a(f9312f, acVar.e);
    }
}
