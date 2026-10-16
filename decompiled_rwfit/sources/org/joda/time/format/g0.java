package org.joda.time.format;

/* loaded from: classes2.dex */
public final class g0 implements k0, j0 {

    /* renamed from: a, reason: collision with root package name */
    public final String[] f17180a = {"T"};

    /* renamed from: b, reason: collision with root package name */
    public final boolean f17181b = true;

    /* renamed from: c, reason: collision with root package name */
    public final k0 f17182c;

    /* renamed from: d, reason: collision with root package name */
    public volatile k0 f17183d;
    public final j0 e;

    /* renamed from: f, reason: collision with root package name */
    public volatile j0 f17184f;

    public g0(k0 k0Var, j0 j0Var) {
        this.f17182c = k0Var;
        this.e = j0Var;
    }

    @Override // org.joda.time.format.k0
    public final int a(ai.f fVar, int i3) {
        int a3 = this.f17182c.a(fVar, i3);
        return a3 < i3 ? this.f17183d.a(fVar, i3) + a3 : a3;
    }

    @Override // org.joda.time.format.k0
    public final int b(ai.f fVar) {
        k0 k0Var = this.f17182c;
        k0 k0Var2 = this.f17183d;
        int b3 = k0Var2.b(fVar) + k0Var.b(fVar);
        return (!this.f17181b || k0Var2.a(fVar, 1) <= 0) ? b3 : 1 + b3;
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:33:? A[RETURN, SYNTHETIC] */
    @Override // org.joda.time.format.j0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(org.joda.time.MutablePeriod r11, java.lang.String r12, int r13) {
        /*
            r10 = this;
            org.joda.time.format.j0 r0 = r10.e
            int r3 = r0.c(r11, r12, r13)
            if (r3 >= 0) goto L9
            return r3
        L9:
            r0 = 0
            if (r3 <= r13) goto L3c
            java.lang.String[] r13 = r10.f17180a
            int r7 = r13.length
            r8 = r0
        L10:
            if (r8 >= r7) goto L3c
            r4 = r13[r8]
            if (r4 == 0) goto L2e
            int r1 = r4.length()
            if (r1 == 0) goto L2e
            int r6 = r4.length()
            r2 = 1
            r5 = 0
            r1 = r12
            boolean r12 = r1.regionMatches(r2, r3, r4, r5, r6)
            if (r12 == 0) goto L2a
            goto L2f
        L2a:
            int r8 = r8 + 1
            r12 = r1
            goto L10
        L2e:
            r1 = r12
        L2f:
            if (r4 != 0) goto L32
            goto L36
        L32:
            int r0 = r4.length()
        L36:
            int r3 = r3 + r0
            r12 = 1
            r9 = r0
            r0 = r12
            r12 = r9
            goto L3e
        L3c:
            r1 = r12
            r12 = -1
        L3e:
            org.joda.time.format.j0 r13 = r10.f17184f
            int r11 = r13.c(r11, r1, r3)
            if (r11 >= 0) goto L47
            goto L54
        L47:
            if (r0 == 0) goto L4f
            if (r11 != r3) goto L4f
            if (r12 <= 0) goto L4f
            int r11 = ~r3
            return r11
        L4f:
            if (r11 <= r3) goto L54
            if (r0 != 0) goto L54
            int r11 = ~r3
        L54:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.g0.c(org.joda.time.MutablePeriod, java.lang.String, int):int");
    }

    @Override // org.joda.time.format.k0
    public final void d(StringBuffer stringBuffer, ai.f fVar) {
        k0 k0Var = this.f17182c;
        k0 k0Var2 = this.f17183d;
        k0Var.d(stringBuffer, fVar);
        if (this.f17181b && k0Var2.a(fVar, 1) > 0) {
            stringBuffer.append("T");
        }
        k0Var2.d(stringBuffer, fVar);
    }
}
