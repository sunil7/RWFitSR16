package io.reactivex.internal.operators.observable;

/* loaded from: classes2.dex */
public final class i1 extends io.reactivex.internal.observers.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f14689a;

    /* renamed from: b, reason: collision with root package name */
    public final Object[] f14690b;

    /* renamed from: c, reason: collision with root package name */
    public int f14691c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14692d;
    public volatile boolean e;

    public i1(rg.s sVar, Object[] objArr) {
        this.f14689a = sVar;
        this.f14690b = objArr;
    }

    @Override // yg.f
    public final void clear() {
        this.f14691c = this.f14690b.length;
    }

    @Override // ug.b
    public final void dispose() {
        this.e = true;
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.e;
    }

    @Override // yg.f
    public final boolean isEmpty() {
        return this.f14691c == this.f14690b.length;
    }

    @Override // yg.f
    public final Object poll() {
        int i3 = this.f14691c;
        Object[] objArr = this.f14690b;
        if (i3 == objArr.length) {
            return null;
        }
        this.f14691c = i3 + 1;
        Object obj = objArr[i3];
        xg.c.b(obj, "The array element is null");
        return obj;
    }

    @Override // yg.c
    public final int requestFusion(int i3) {
        if ((i3 & 1) == 0) {
            return 0;
        }
        this.f14692d = true;
        return 1;
    }
}
