package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public final class l2 implements rb.c {

    /* renamed from: a, reason: collision with root package name */
    public static final l2 f9387a = new l2();

    /* renamed from: b, reason: collision with root package name */
    public static final rb.b f9388b = new rb.b("logEventKey", l0.y(l0.w(j0.class, new g0(1, zzfd.zza))));

    /* renamed from: c, reason: collision with root package name */
    public static final rb.b f9389c = new rb.b("eventCount", l0.y(l0.w(j0.class, new g0(2, zzfd.zza))));

    /* renamed from: d, reason: collision with root package name */
    public static final rb.b f9390d = new rb.b("inferenceDurationStats", l0.y(l0.w(j0.class, new g0(3, zzfd.zza))));

    @Override // rb.a
    public final void a(Object obj, Object obj2) {
        w0 w0Var = (w0) obj;
        rb.d dVar = (rb.d) obj2;
        dVar.a(f9388b, w0Var.f9568a);
        dVar.a(f9389c, w0Var.f9569b);
        dVar.a(f9390d, w0Var.f9570c);
    }
}
