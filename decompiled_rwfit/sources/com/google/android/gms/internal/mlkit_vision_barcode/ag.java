package com.google.android.gms.internal.mlkit_vision_barcode;

import android.content.Context;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class ag {

    /* renamed from: k, reason: collision with root package name */
    public static zzcs f9219k;

    /* renamed from: l, reason: collision with root package name */
    public static final zzcu f9220l = zzcu.zzc("optional-module-barcode", "com.google.android.gms.vision.barcode");

    /* renamed from: a, reason: collision with root package name */
    public final String f9221a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9222b;

    /* renamed from: c, reason: collision with root package name */
    public final vf f9223c;

    /* renamed from: d, reason: collision with root package name */
    public final gc.h f9224d;
    public final ia.m e;

    /* renamed from: f, reason: collision with root package name */
    public final ia.m f9225f;

    /* renamed from: g, reason: collision with root package name */
    public final String f9226g;

    /* renamed from: h, reason: collision with root package name */
    public final int f9227h;

    /* renamed from: i, reason: collision with root package name */
    public final HashMap f9228i = new HashMap();

    /* renamed from: j, reason: collision with root package name */
    public final HashMap f9229j = new HashMap();

    public ag(Context context, gc.h hVar, vf vfVar, String str) {
        this.f9221a = context.getPackageName();
        this.f9222b = gc.c.a(context);
        this.f9224d = hVar;
        this.f9223c = vfVar;
        eg.b();
        this.f9226g = str;
        com.google.mlkit.common.sdkinternal.a a3 = com.google.mlkit.common.sdkinternal.a.a();
        com.google.android.gms.internal.mlkit_common.i iVar = new com.google.android.gms.internal.mlkit_common.i(this, 1);
        a3.getClass();
        this.e = com.google.mlkit.common.sdkinternal.a.b(iVar);
        com.google.mlkit.common.sdkinternal.a a10 = com.google.mlkit.common.sdkinternal.a.a();
        Objects.requireNonNull(hVar);
        com.google.android.gms.internal.mlkit_common.j jVar = new com.google.android.gms.internal.mlkit_common.j(hVar, 1);
        a10.getClass();
        this.f9225f = com.google.mlkit.common.sdkinternal.a.b(jVar);
        zzcu zzcuVar = f9220l;
        this.f9227h = zzcuVar.containsKey(str) ? ca.d.d(context, (String) zzcuVar.get(str), false) : -1;
    }

    public static long a(ArrayList arrayList, double d5) {
        return ((Long) arrayList.get(Math.max(((int) Math.ceil((d5 / 100.0d) * arrayList.size())) - 1, 0))).longValue();
    }

    public final void b(zf zfVar, zzrc zzrcVar) {
        long elapsedRealtime = SystemClock.elapsedRealtime();
        if (d(zzrcVar, elapsedRealtime)) {
            this.f9228i.put(zzrcVar, Long.valueOf(elapsedRealtime));
            com.google.mlkit.common.sdkinternal.a.c().execute(new wf((Object) this, (Object) zfVar.zza(), (Enum) zzrcVar, c(), 0));
        }
    }

    public final String c() {
        ia.m mVar = this.e;
        return mVar.f() ? (String) mVar.d() : q9.d.f17809c.a(this.f9226g);
    }

    public final boolean d(zzrc zzrcVar, long j4) {
        HashMap hashMap = this.f9228i;
        return hashMap.get(zzrcVar) == null || j4 - ((Long) hashMap.get(zzrcVar)).longValue() > TimeUnit.SECONDS.toMillis(30L);
    }
}
