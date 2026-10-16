package org.joda.time.format;

/* loaded from: classes2.dex */
public final class g implements x {

    /* renamed from: a, reason: collision with root package name */
    public final x[] f17178a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17179b;

    public g(x[] xVarArr) {
        int estimateParsedLength;
        this.f17178a = xVarArr;
        int length = xVarArr.length;
        int i3 = 0;
        while (true) {
            length--;
            if (length < 0) {
                this.f17179b = i3;
                return;
            }
            x xVar = xVarArr[length];
            if (xVar != null && (estimateParsedLength = xVar.estimateParsedLength()) > i3) {
                i3 = estimateParsedLength;
            }
        }
    }

    @Override // org.joda.time.format.x
    public final int estimateParsedLength() {
        return this.f17179b;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x0056, code lost:
    
        if (r6 > r12) goto L38;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x0058, code lost:
    
        if (r6 != r12) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x005a, code lost:
    
        if (r3 == false) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x005e, code lost:
    
        return ~r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x005f, code lost:
    
        if (r4 == null) goto L40;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x0061, code lost:
    
        r10.d(r4);
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x0064, code lost:
    
        return r6;
     */
    @Override // org.joda.time.format.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int parseInto(org.joda.time.format.s r10, java.lang.CharSequence r11, int r12) {
        /*
            r9 = this;
            org.joda.time.format.x[] r0 = r9.f17178a
            int r1 = r0.length
            org.joda.time.format.r r2 = r10.f17224i
            if (r2 != 0) goto Le
            org.joda.time.format.r r2 = new org.joda.time.format.r
            r2.<init>(r10)
            r10.f17224i = r2
        Le:
            org.joda.time.format.r r2 = r10.f17224i
            r3 = 0
            r4 = 0
            r6 = r12
            r7 = r6
            r5 = r3
        L15:
            if (r5 >= r1) goto L56
            r8 = r0[r5]
            if (r8 != 0) goto L20
            if (r6 > r12) goto L1e
            return r12
        L1e:
            r3 = 1
            goto L56
        L20:
            int r8 = r8.parseInto(r10, r11, r12)
            if (r8 < r12) goto L4a
            if (r8 <= r6) goto L50
            r4 = r11
            java.lang.String r4 = (java.lang.String) r4
            int r4 = r4.length()
            if (r8 >= r4) goto L49
            int r4 = r5 + 1
            if (r4 >= r1) goto L49
            r4 = r0[r4]
            if (r4 != 0) goto L3a
            goto L49
        L3a:
            org.joda.time.format.r r4 = r10.f17224i
            if (r4 != 0) goto L45
            org.joda.time.format.r r4 = new org.joda.time.format.r
            r4.<init>(r10)
            r10.f17224i = r4
        L45:
            org.joda.time.format.r r4 = r10.f17224i
            r6 = r8
            goto L50
        L49:
            return r8
        L4a:
            if (r8 >= 0) goto L50
            int r8 = ~r8
            if (r8 <= r7) goto L50
            r7 = r8
        L50:
            r10.d(r2)
            int r5 = r5 + 1
            goto L15
        L56:
            if (r6 > r12) goto L5f
            if (r6 != r12) goto L5d
            if (r3 == 0) goto L5d
            goto L5f
        L5d:
            int r10 = ~r7
            return r10
        L5f:
            if (r4 == 0) goto L64
            r10.d(r4)
        L64:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.g.parseInto(org.joda.time.format.s, java.lang.CharSequence, int):int");
    }
}
