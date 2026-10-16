package com.google.android.gms.common.api;

import android.content.Context;
import android.os.Build;
import com.example.test.utils.y;
import java.util.Collections;
import java.util.Set;
import n.l;
import q9.n;

/* loaded from: classes.dex */
public abstract class f {

    /* renamed from: a, reason: collision with root package name */
    public final Context f9080a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9081b;

    /* renamed from: c, reason: collision with root package name */
    public final y f9082c;

    /* renamed from: d, reason: collision with root package name */
    public final b f9083d;
    public final o9.a e;

    /* renamed from: f, reason: collision with root package name */
    public final int f9084f;

    /* renamed from: g, reason: collision with root package name */
    public final ec.a f9085g;

    /* renamed from: h, reason: collision with root package name */
    public final o9.c f9086h;

    public f(Context context, y yVar, b bVar, e eVar) {
        n.f(context, "Null context is not permitted.");
        n.f(yVar, "Api must not be null.");
        n.f(eVar, "Settings must not be null; use Settings.DEFAULT_SETTINGS instead.");
        Context applicationContext = context.getApplicationContext();
        n.f(applicationContext, "The provided context did not have an application context.");
        this.f9080a = applicationContext;
        String attributionTag = Build.VERSION.SDK_INT >= 30 ? context.getAttributionTag() : null;
        this.f9081b = attributionTag;
        this.f9082c = yVar;
        this.f9083d = bVar;
        this.e = new o9.a(yVar, bVar, attributionTag);
        o9.c e = o9.c.e(applicationContext);
        this.f9086h = e;
        this.f9084f = e.f16857h.getAndIncrement();
        this.f9085g = eVar.f9079a;
        c5.b bVar2 = e.f16862m;
        bVar2.sendMessage(bVar2.obtainMessage(7, this));
    }

    public final l a() {
        l lVar = new l(3);
        Set set = Collections.EMPTY_SET;
        if (((m0.c) lVar.f16245b) == null) {
            lVar.f16245b = new m0.c(0);
        }
        ((m0.c) lVar.f16245b).addAll(set);
        Context context = this.f9080a;
        lVar.f16247d = context.getClass().getName();
        lVar.f16246c = context.getPackageName();
        return lVar;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0076  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final ia.m b(int r13, o9.j r14) {
        /*
            r12 = this;
            ia.g r0 = new ia.g
            r0.<init>()
            o9.c r2 = r12.f9086h
            r2.getClass()
            int r3 = r14.f16866c
            if (r3 == 0) goto L93
            o9.a r4 = r12.e
            boolean r1 = r2.a()
            if (r1 != 0) goto L17
            goto L5a
        L17:
            q9.e r1 = q9.e.b()
            java.lang.Object r1 = r1.f17814a
            com.google.android.gms.common.internal.RootTelemetryConfiguration r1 = (com.google.android.gms.common.internal.RootTelemetryConfiguration) r1
            r5 = 1
            if (r1 == 0) goto L5c
            boolean r6 = r1.i()
            if (r6 == 0) goto L5a
            boolean r1 = r1.j()
            java.util.concurrent.ConcurrentHashMap r6 = r2.f16859j
            java.lang.Object r6 = r6.get(r4)
            o9.n r6 = (o9.n) r6
            if (r6 == 0) goto L58
            com.google.android.gms.common.api.c r7 = r6.f16870b
            boolean r8 = r7 instanceof com.google.android.gms.common.internal.a
            if (r8 == 0) goto L5a
            com.google.android.gms.common.internal.a r7 = (com.google.android.gms.common.internal.a) r7
            com.google.android.gms.common.internal.zzk r8 = r7.f9131u
            if (r8 == 0) goto L58
            boolean r8 = r7.h()
            if (r8 != 0) goto L58
            com.google.android.gms.common.internal.ConnectionTelemetryConfiguration r1 = o9.r.a(r6, r7, r3)
            if (r1 == 0) goto L5a
            int r7 = r6.f16879l
            int r7 = r7 + r5
            r6.f16879l = r7
            boolean r5 = r1.k()
            goto L5c
        L58:
            r5 = r1
            goto L5c
        L5a:
            r1 = 0
            goto L74
        L5c:
            o9.r r1 = new o9.r
            r6 = 0
            if (r5 == 0) goto L67
            long r8 = java.lang.System.currentTimeMillis()
            goto L68
        L67:
            r8 = r6
        L68:
            if (r5 == 0) goto L6e
            long r6 = android.os.SystemClock.elapsedRealtime()
        L6e:
            r10 = r8
            r7 = r6
            r5 = r10
            r1.<init>(r2, r3, r4, r5, r7)
        L74:
            if (r1 == 0) goto L93
            ia.m r3 = r0.f14382a
            c5.b r4 = r2.f16862m
            r4.getClass()
            w.d r5 = new w.d
            r6 = 3
            r5.<init>(r4, r6)
            r3.getClass()
            ia.i r4 = new ia.i
            r4.<init>(r5, r1)
            ia.k r1 = r3.f14399b
            r1.f(r4)
            r3.k()
        L93:
            o9.w r1 = new o9.w
            ec.a r3 = r12.f9085g
            r1.<init>(r13, r14, r0, r3)
            java.util.concurrent.atomic.AtomicInteger r13 = r2.f16858i
            o9.t r14 = new o9.t
            int r13 = r13.get()
            r14.<init>(r1, r13, r12)
            c5.b r13 = r2.f16862m
            r1 = 4
            android.os.Message r14 = r13.obtainMessage(r1, r14)
            r13.sendMessage(r14)
            ia.m r13 = r0.f14382a
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.common.api.f.b(int, o9.j):ia.m");
    }
}
