package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class e0 {

    /* renamed from: c, reason: collision with root package name */
    public static final e0 f9773c = new e0(0);

    /* renamed from: a, reason: collision with root package name */
    public final o1 f9774a = new o1();

    /* renamed from: b, reason: collision with root package name */
    public boolean f9775b;

    public e0() {
    }

    public static int a(j0 j0Var, Object obj) {
        j0Var.getClass();
        z.a(0 << 3);
        if (zzhf.zzj == null) {
            Charset charset = s0.f9827a;
        }
        zzhg zzhgVar = zzhg.zza;
        throw null;
    }

    public static boolean h(Map.Entry entry) {
        ((j0) entry.getKey()).getClass();
        throw null;
    }

    public static final int i(Map.Entry entry) {
        j0 j0Var = (j0) entry.getKey();
        entry.getValue();
        j0Var.getClass();
        throw null;
    }

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public final e0 clone() {
        e0 e0Var = new e0();
        o1 o1Var = this.f9774a;
        int i3 = o1Var.f9809b;
        for (int i10 = 0; i10 < i3; i10++) {
            p1 c9 = o1Var.c(i10);
            e0Var.e((j0) c9.f9813a, c9.f9814b);
        }
        for (Map.Entry entry : o1Var.a()) {
            e0Var.e((j0) entry.getKey(), entry.getValue());
        }
        return e0Var;
    }

    public final Iterator c() {
        o1 o1Var = this.f9774a;
        return o1Var.isEmpty() ? Collections.emptyIterator() : ((r1) o1Var.entrySet()).iterator();
    }

    public final void d() {
        if (this.f9775b) {
            return;
        }
        o1 o1Var = this.f9774a;
        int i3 = o1Var.f9809b;
        for (int i10 = 0; i10 < i3; i10++) {
            Object obj = o1Var.c(i10).f9814b;
            if (obj instanceof l0) {
                l0 l0Var = (l0) obj;
                l0Var.getClass();
                g1.f9786c.a(l0Var.getClass()).a(l0Var);
                l0Var.g();
            }
        }
        if (!o1Var.f9811d) {
            for (int i11 = 0; i11 < o1Var.f9809b; i11++) {
                ((j0) o1Var.c(i11).f9813a).getClass();
            }
            Iterator it = o1Var.a().iterator();
            while (it.hasNext()) {
                ((j0) ((Map.Entry) it.next()).getKey()).getClass();
            }
        }
        if (!o1Var.f9811d) {
            o1Var.f9810c = o1Var.f9810c.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(o1Var.f9810c);
            o1Var.f9812f = o1Var.f9812f.isEmpty() ? Collections.EMPTY_MAP : Collections.unmodifiableMap(o1Var.f9812f);
            o1Var.f9811d = true;
        }
        this.f9775b = true;
    }

    public final void e(j0 j0Var, Object obj) {
        j0Var.getClass();
        Charset charset = s0.f9827a;
        obj.getClass();
        zzhf zzhfVar = zzhf.zza;
        zzhg zzhgVar = zzhg.zza;
        throw null;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof e0) {
            return this.f9774a.equals(((e0) obj).f9774a);
        }
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0030, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean f() {
        /*
            r5 = this;
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.o1 r0 = r5.f9774a
            int r1 = r0.f9809b
            r2 = 0
            r3 = r2
        L6:
            if (r3 >= r1) goto L16
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.p1 r4 = r0.c(r3)
            boolean r4 = h(r4)
            if (r4 != 0) goto L13
            goto L30
        L13:
            int r3 = r3 + 1
            goto L6
        L16:
            java.util.Set r0 = r0.a()
            java.util.Iterator r0 = r0.iterator()
        L1e:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L31
            java.lang.Object r1 = r0.next()
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1
            boolean r1 = h(r1)
            if (r1 != 0) goto L1e
        L30:
            return r2
        L31:
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.e0.f():boolean");
    }

    public final void g(Map.Entry entry) {
        j0 j0Var = (j0) entry.getKey();
        entry.getValue();
        j0Var.getClass();
        throw null;
    }

    public final int hashCode() {
        return this.f9774a.hashCode();
    }

    public e0(int i3) {
        d();
        d();
    }
}
