package com.google.common.collect;

/* loaded from: classes.dex */
public final class h0 extends h {

    /* renamed from: a, reason: collision with root package name */
    public w1 f11074a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11075b = false;

    public h0(int i3) {
        w1 w1Var = new w1();
        w1Var.e(i3);
        this.f11074a = w1Var;
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x001d  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:11:0x0031 -> B:8:0x0018). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void r(int r7, java.lang.Object r8) {
        /*
            r6 = this;
            if (r7 != 0) goto L3
            return
        L3:
            boolean r0 = r6.f11075b
            if (r0 == 0) goto L36
            com.google.common.collect.w1 r0 = new com.google.common.collect.w1
            com.google.common.collect.w1 r1 = r6.f11074a
            r0.<init>()
            int r2 = r1.f11141c
            r0.e(r2)
            int r2 = r1.f11141c
            r3 = -1
            if (r2 != 0) goto L1a
        L18:
            r2 = r3
            goto L1b
        L1a:
            r2 = 0
        L1b:
            if (r2 == r3) goto L34
            int r4 = r1.f11141c
            com.google.android.gms.internal.mlkit_vision_barcode.kb.d(r2, r4)
            java.lang.Object[] r4 = r1.f11139a
            r4 = r4[r2]
            int r5 = r1.c(r2)
            r0.f(r5, r4)
            int r2 = r2 + 1
            int r4 = r1.f11141c
            if (r2 >= r4) goto L18
            goto L1b
        L34:
            r6.f11074a = r0
        L36:
            r0 = 0
            r6.f11075b = r0
            r8.getClass()
            com.google.common.collect.w1 r0 = r6.f11074a
            int r1 = r0.b(r8)
            int r1 = r1 + r7
            r0.f(r1, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.h0.r(int, java.lang.Object):void");
    }

    public final ImmutableMultiset s() {
        if (this.f11074a.f11141c == 0) {
            return ImmutableMultiset.of();
        }
        this.f11075b = true;
        return new RegularImmutableMultiset(this.f11074a);
    }
}
