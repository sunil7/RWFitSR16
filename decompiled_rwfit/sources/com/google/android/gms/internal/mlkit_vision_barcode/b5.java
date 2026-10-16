package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public final class b5 implements rb.c {

    /* renamed from: a, reason: collision with root package name */
    public static final b5 f9234a = new b5();

    /* renamed from: b, reason: collision with root package name */
    public static final rb.b f9235b = new rb.b("maxMs", l0.y(l0.w(j0.class, new g0(1, zzfd.zza))));

    /* renamed from: c, reason: collision with root package name */
    public static final rb.b f9236c = new rb.b("minMs", l0.y(l0.w(j0.class, new g0(2, zzfd.zza))));

    /* renamed from: d, reason: collision with root package name */
    public static final rb.b f9237d = new rb.b("avgMs", l0.y(l0.w(j0.class, new g0(3, zzfd.zza))));
    public static final rb.b e = new rb.b("firstQuartileMs", l0.y(l0.w(j0.class, new g0(4, zzfd.zza))));

    /* renamed from: f, reason: collision with root package name */
    public static final rb.b f9238f = new rb.b("medianMs", l0.y(l0.w(j0.class, new g0(5, zzfd.zza))));

    /* renamed from: g, reason: collision with root package name */
    public static final rb.b f9239g = new rb.b("thirdQuartileMs", l0.y(l0.w(j0.class, new g0(6, zzfd.zza))));

    @Override // rb.a
    public final void a(Object obj, Object obj2) {
        ab abVar = (ab) obj;
        rb.d dVar = (rb.d) obj2;
        dVar.a(f9235b, abVar.f9210a);
        dVar.a(f9236c, abVar.f9211b);
        dVar.a(f9237d, abVar.f9212c);
        dVar.a(e, abVar.f9213d);
        dVar.a(f9238f, abVar.e);
        dVar.a(f9239g, abVar.f9214f);
    }
}
