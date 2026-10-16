package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class e1 implements m1 {

    /* renamed from: a, reason: collision with root package name */
    public final a1 f9776a;

    /* renamed from: b, reason: collision with root package name */
    public final g0 f9777b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f9778c;

    public e1(g0 g0Var, a1 a1Var) {
        g0 g0Var2 = d0.f9760a;
        this.f9777b = g0Var;
        this.f9778c = a1Var instanceof i0;
        this.f9776a = a1Var;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final void a(Object obj) {
        this.f9777b.getClass();
        s1 s1Var = ((l0) obj).zzc;
        if (s1Var.e) {
            s1Var.e = false;
        }
        g0 g0Var = d0.f9760a;
        ((i0) obj).zzb.d();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x009c A[EDGE_INSN: B:37:0x009c->B:38:0x009c BREAK  A[LOOP:1: B:23:0x005c->B:31:0x005c], SYNTHETIC] */
    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void b(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s r15) {
        /*
            r10 = this;
            r0 = r11
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0 r0 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.l0) r0
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.s1 r1 = r0.zzc
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.s1 r2 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.s1.f9829f
            if (r1 != r2) goto Lf
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.s1 r1 = com.google.android.gms.internal.mlkit_vision_barcode_bundled.s1.b()
            r0.zzc = r1
        Lf:
            r6 = r1
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.i0 r11 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.i0) r11
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.e0 r0 = r11.zzb
            boolean r1 = r0.f9775b
            if (r1 == 0) goto L1e
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.e0 r0 = r0.clone()
            r11.zzb = r0
        L1e:
            r11 = 0
        L1f:
            if (r13 >= r14) goto La6
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode.ua.f(r12, r13, r15)
            int r2 = r15.f9823a
            r13 = 11
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.a1 r0 = r10.f9776a
            r1 = 2
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.c0 r3 = r15.f9826d
            if (r2 == r13) goto L58
            r13 = r2 & 7
            if (r13 != r1) goto L51
            int r13 = r2 >>> 3
            r3.getClass()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.b0 r1 = new com.google.android.gms.internal.mlkit_vision_barcode_bundled.b0
            r1.<init>(r0, r13)
            java.util.Map r13 = r3.f9758a
            java.lang.Object r13 = r13.get(r1)
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.k0 r13 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.k0) r13
            r3 = r12
            r5 = r14
            r7 = r15
            int r13 = com.google.android.gms.internal.mlkit_vision_barcode.ua.e(r2, r3, r4, r5, r6, r7)
            r12 = r3
        L4e:
            r14 = r5
            r15 = r7
            goto L1f
        L51:
            r5 = r14
            r7 = r15
            int r13 = com.google.android.gms.internal.mlkit_vision_barcode.ua.l(r2, r12, r4, r5, r7)
            goto L1f
        L58:
            r5 = r14
            r7 = r15
            r13 = 0
            r14 = r11
        L5c:
            if (r4 >= r5) goto L9b
            int r15 = com.google.android.gms.internal.mlkit_vision_barcode.ua.f(r12, r4, r7)
            int r2 = r7.f9823a
            int r4 = r2 >>> 3
            r8 = r2 & 7
            if (r4 == r1) goto L79
            r9 = 3
            if (r4 == r9) goto L6e
            goto L92
        L6e:
            if (r8 != r1) goto L92
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode.ua.a(r12, r15, r7)
            java.lang.Object r14 = r7.f9825c
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf r14 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzdf) r14
            goto L5c
        L79:
            if (r8 != 0) goto L92
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode.ua.f(r12, r15, r7)
            int r13 = r7.f9823a
            r3.getClass()
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.b0 r15 = new com.google.android.gms.internal.mlkit_vision_barcode_bundled.b0
            r15.<init>(r0, r13)
            java.util.Map r2 = r3.f9758a
            java.lang.Object r15 = r2.get(r15)
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.k0 r15 = (com.google.android.gms.internal.mlkit_vision_barcode_bundled.k0) r15
            goto L5c
        L92:
            r4 = 12
            if (r2 == r4) goto L9c
            int r4 = com.google.android.gms.internal.mlkit_vision_barcode.ua.l(r2, r12, r15, r5, r7)
            goto L5c
        L9b:
            r15 = r4
        L9c:
            if (r14 == 0) goto La4
            int r13 = r13 << 3
            r13 = r13 | r1
            r6.c(r13, r14)
        La4:
            r13 = r15
            goto L4e
        La6:
            r5 = r14
            if (r13 != r5) goto Laa
            return
        Laa:
            com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer r11 = new com.google.android.gms.internal.mlkit_vision_barcode_bundled.zzer
            java.lang.String r12 = "Failed to parse the message."
            r11.<init>(r12)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.mlkit_vision_barcode_bundled.e1.b(java.lang.Object, byte[], int, int, com.google.android.gms.internal.mlkit_vision_barcode_bundled.s):void");
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final void c(Object obj, Object obj2) {
        n1.q(obj, obj2);
        if (this.f9778c) {
            g0 g0Var = d0.f9760a;
            n1.p(obj, obj2);
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final int d(l0 l0Var) {
        s1 s1Var = l0Var.zzc;
        int i3 = s1Var.f9833d;
        if (i3 == -1) {
            i3 = 0;
            for (int i10 = 0; i10 < s1Var.f9830a; i10++) {
                int i11 = s1Var.f9831b[i10] >>> 3;
                zzdf zzdfVar = (zzdf) s1Var.f9832c[i10];
                int a3 = z.a(8);
                int a10 = z.a(i11) + z.a(16);
                int a11 = z.a(24);
                int zzd = zzdfVar.zzd();
                i3 += a3 + a3 + a10 + com.google.android.gms.internal.mlkit_vision_barcode.l0.b(zzd, zzd, a11);
            }
            s1Var.f9833d = i3;
        }
        if (!this.f9778c) {
            return i3;
        }
        o1 o1Var = ((i0) l0Var).zzb.f9774a;
        int i12 = o1Var.f9809b;
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            i13 += e0.i(o1Var.c(i14));
        }
        Iterator it = o1Var.a().iterator();
        while (it.hasNext()) {
            i13 += e0.i((Map.Entry) it.next());
        }
        return i3 + i13;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final Object e() {
        a1 a1Var = this.f9776a;
        return a1Var instanceof l0 ? (l0) ((l0) a1Var).m(4, null) : ((h0) ((l0) a1Var).m(5, null)).d();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final boolean f(l0 l0Var, l0 l0Var2) {
        if (!l0Var.zzc.equals(l0Var2.zzc)) {
            return false;
        }
        if (this.f9778c) {
            return ((i0) l0Var).zzb.equals(((i0) l0Var2).zzb);
        }
        return true;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final int g(l0 l0Var) {
        int hashCode = l0Var.zzc.hashCode();
        if (!this.f9778c) {
            return hashCode;
        }
        return ((i0) l0Var).zzb.f9774a.hashCode() + (hashCode * 53);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final boolean h(Object obj) {
        return ((i0) obj).zzb.f();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode_bundled.m1
    public final void i(Object obj, x0 x0Var) {
        Iterator c9 = ((i0) obj).zzb.c();
        if (c9.hasNext()) {
            ((j0) ((Map.Entry) c9.next()).getKey()).getClass();
            throw null;
        }
        s1 s1Var = ((l0) obj).zzc;
        for (int i3 = 0; i3 < s1Var.f9830a; i3++) {
            int i10 = s1Var.f9831b[i3] >>> 3;
            Object obj2 = s1Var.f9832c[i3];
            x0Var.getClass();
            boolean z5 = obj2 instanceof zzdf;
            z zVar = (z) x0Var.f9840a;
            if (z5) {
                zVar.o(11);
                zVar.n(2, i10);
                zVar.e(3, (zzdf) obj2);
                zVar.o(12);
            } else {
                zVar.o(11);
                zVar.n(2, i10);
                zVar.o(26);
                l0 l0Var = (l0) ((a1) obj2);
                zVar.o(l0Var.c());
                l0Var.l(zVar);
                zVar.o(12);
            }
        }
    }
}
