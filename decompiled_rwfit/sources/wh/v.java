package wh;

/* loaded from: classes2.dex */
public final class v implements c0 {

    /* renamed from: a, reason: collision with root package name */
    public final j f19670a;

    /* renamed from: b, reason: collision with root package name */
    public y f19671b;

    /* renamed from: c, reason: collision with root package name */
    public int f19672c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f19673d;
    public long e;

    /* renamed from: f, reason: collision with root package name */
    public final l f19674f;

    public v(l lVar) {
        this.f19674f = lVar;
        j m10 = lVar.m();
        this.f19670a = m10;
        y yVar = m10.f19653a;
        this.f19671b = yVar;
        this.f19672c = yVar != null ? yVar.f19682b : -1;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() {
        this.f19673d = true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:10:0x0020, code lost:
    
        if (r3 == r5.f19682b) goto L15;
     */
    @Override // wh.c0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long read(wh.j r9, long r10) {
        /*
            r8 = this;
            java.lang.String r0 = "sink"
            kotlin.jvm.internal.e.f(r9, r0)
            r0 = 0
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 < 0) goto L6b
            boolean r3 = r8.f19673d
            if (r3 != 0) goto L63
            wh.y r3 = r8.f19671b
            wh.j r4 = r8.f19670a
            if (r3 == 0) goto L2b
            wh.y r5 = r4.f19653a
            if (r3 != r5) goto L23
            int r3 = r8.f19672c
            kotlin.jvm.internal.e.c(r5)
            int r5 = r5.f19682b
            if (r3 != r5) goto L23
            goto L2b
        L23:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "Peek source is invalid because upstream source was used"
            r9.<init>(r10)
            throw r9
        L2b:
            if (r2 != 0) goto L2e
            return r0
        L2e:
            long r0 = r8.e
            r2 = 1
            long r0 = r0 + r2
            wh.l r2 = r8.f19674f
            boolean r0 = r2.request(r0)
            if (r0 != 0) goto L3e
            r9 = -1
            return r9
        L3e:
            wh.y r0 = r8.f19671b
            if (r0 != 0) goto L4c
            wh.y r0 = r4.f19653a
            if (r0 == 0) goto L4c
            r8.f19671b = r0
            int r0 = r0.f19682b
            r8.f19672c = r0
        L4c:
            long r0 = r4.f19654b
            long r2 = r8.e
            long r0 = r0 - r2
            long r6 = java.lang.Math.min(r10, r0)
            wh.j r2 = r8.f19670a
            long r3 = r8.e
            r5 = r9
            r2.f(r3, r5, r6)
            long r9 = r8.e
            long r9 = r9 + r6
            r8.e = r9
            return r6
        L63:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r10 = "closed"
            r9.<init>(r10)
            throw r9
        L6b:
            java.lang.String r9 = "byteCount < 0: "
            java.lang.String r9 = com.google.android.gms.internal.mlkit_vision_barcode.l0.l(r10, r9)
            java.lang.IllegalArgumentException r10 = new java.lang.IllegalArgumentException
            java.lang.String r9 = r9.toString()
            r10.<init>(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: wh.v.read(wh.j, long):long");
    }

    @Override // wh.c0
    public final f0 timeout() {
        return this.f19674f.timeout();
    }
}
