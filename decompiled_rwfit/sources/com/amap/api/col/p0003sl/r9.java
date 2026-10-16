package com.amap.api.col.p0003sl;

/* loaded from: classes.dex */
public final class r9 extends nc {

    /* renamed from: b, reason: collision with root package name */
    protected long f4955b;

    /* renamed from: c, reason: collision with root package name */
    private boolean f4956c;

    /* renamed from: d, reason: collision with root package name */
    private boolean f4957d;
    private int e;

    /* renamed from: f, reason: collision with root package name */
    private long f4958f;

    public r9(boolean z5, nc ncVar, long j4, int i3) {
        super(ncVar);
        this.f4957d = false;
        this.f4956c = z5;
        this.f4958f = j4;
        this.e = i3;
    }

    @Override // com.amap.api.col.p0003sl.nc
    public final int a() {
        return 320000;
    }

    public final void b(boolean z5) {
        this.f4957d = z5;
    }

    @Override // com.amap.api.col.p0003sl.nc
    public final boolean c() {
        if (this.f4957d && this.f4958f <= this.e) {
            return true;
        }
        if (!this.f4956c || this.f4958f >= this.e) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.f4955b < 600000) {
            return false;
        }
        this.f4955b = currentTimeMillis;
        return true;
    }

    public final long d() {
        return this.f4958f;
    }

    public final void b(int i3) {
        if (i3 <= 0) {
            return;
        }
        this.f4958f += i3;
    }
}
