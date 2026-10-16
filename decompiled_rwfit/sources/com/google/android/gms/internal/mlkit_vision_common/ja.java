package com.google.android.gms.internal.mlkit_vision_common;

import android.content.Context;
import java.util.HashMap;

/* loaded from: classes.dex */
public final class ja {

    /* renamed from: j, reason: collision with root package name */
    public static zzp f10010j;

    /* renamed from: k, reason: collision with root package name */
    public static final zzr f10011k = zzr.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");

    /* renamed from: a, reason: collision with root package name */
    public final String f10012a;

    /* renamed from: b, reason: collision with root package name */
    public final String f10013b;

    /* renamed from: c, reason: collision with root package name */
    public final ia f10014c;

    /* renamed from: d, reason: collision with root package name */
    public final gc.h f10015d;
    public final ia.m e;

    /* renamed from: f, reason: collision with root package name */
    public final ia.m f10016f;

    /* renamed from: g, reason: collision with root package name */
    public final String f10017g;

    /* renamed from: h, reason: collision with root package name */
    public final int f10018h;

    /* renamed from: i, reason: collision with root package name */
    public final HashMap f10019i = new HashMap();

    public ja(Context context, gc.h hVar, ia iaVar) {
        new HashMap();
        this.f10012a = context.getPackageName();
        this.f10013b = gc.c.a(context);
        this.f10015d = hVar;
        this.f10014c = iaVar;
        na.b();
        this.f10017g = "vision-common";
        com.google.mlkit.common.sdkinternal.a a3 = com.google.mlkit.common.sdkinternal.a.a();
        com.google.android.gms.internal.mlkit_common.i iVar = new com.google.android.gms.internal.mlkit_common.i(this, 2);
        a3.getClass();
        this.e = com.google.mlkit.common.sdkinternal.a.b(iVar);
        com.google.mlkit.common.sdkinternal.a a10 = com.google.mlkit.common.sdkinternal.a.a();
        hVar.getClass();
        com.google.android.gms.internal.mlkit_common.j jVar = new com.google.android.gms.internal.mlkit_common.j(hVar, 2);
        a10.getClass();
        this.f10016f = com.google.mlkit.common.sdkinternal.a.b(jVar);
        zzr zzrVar = f10011k;
        this.f10018h = zzrVar.containsKey("vision-common") ? ca.d.d(context, (String) zzrVar.get("vision-common"), false) : -1;
    }
}
