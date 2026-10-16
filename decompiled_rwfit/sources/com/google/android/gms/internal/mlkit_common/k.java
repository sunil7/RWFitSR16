package com.google.android.gms.internal.mlkit_common;

import android.content.Context;
import java.util.HashMap;
import java.util.Objects;

/* loaded from: classes.dex */
public final class k {

    /* renamed from: b, reason: collision with root package name */
    public static final zzai f9178b = zzai.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");

    /* renamed from: a, reason: collision with root package name */
    public final String f9179a;

    public k(Context context, gc.h hVar) {
        new HashMap();
        new HashMap();
        context.getPackageName();
        gc.c.a(context);
        synchronized (o.class) {
            if (o.f9183b == null) {
                o.f9183b = new o(0);
            }
        }
        this.f9179a = "common";
        com.google.mlkit.common.sdkinternal.a a3 = com.google.mlkit.common.sdkinternal.a.a();
        i iVar = new i(this, 0);
        a3.getClass();
        com.google.mlkit.common.sdkinternal.a.b(iVar);
        com.google.mlkit.common.sdkinternal.a a10 = com.google.mlkit.common.sdkinternal.a.a();
        Objects.requireNonNull(hVar);
        j jVar = new j(hVar, 0);
        a10.getClass();
        com.google.mlkit.common.sdkinternal.a.b(jVar);
        zzai zzaiVar = f9178b;
        if (zzaiVar.containsKey("common")) {
            ca.d.d(context, (String) zzaiVar.get("common"), false);
        }
    }
}
