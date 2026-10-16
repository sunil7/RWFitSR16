package io.reactivex.internal.operators.observable;

import java.util.Iterator;

/* loaded from: classes2.dex */
public final class k1 extends io.reactivex.internal.observers.b {

    /* renamed from: a, reason: collision with root package name */
    public final rg.s f14715a;

    /* renamed from: b, reason: collision with root package name */
    public final Iterator f14716b;

    /* renamed from: c, reason: collision with root package name */
    public volatile boolean f14717c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f14718d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f14719f;

    public k1(rg.s sVar, Iterator it) {
        this.f14715a = sVar;
        this.f14716b = it;
    }

    @Override // yg.f
    public final void clear() {
        this.e = true;
    }

    @Override // ug.b
    public final void dispose() {
        this.f14717c = true;
    }

    @Override // ug.b
    public final boolean isDisposed() {
        return this.f14717c;
    }

    @Override // yg.f
    public final boolean isEmpty() {
        return this.e;
    }

    @Override // yg.f
    public final Object poll() {
        if (this.e) {
            return null;
        }
        boolean z5 = this.f14719f;
        Iterator it = this.f14716b;
        if (!z5) {
            this.f14719f = true;
        } else if (!it.hasNext()) {
            this.e = true;
            return null;
        }
        Object next = it.next();
        xg.c.b(next, "The iterator returned a null value");
        return next;
    }

    @Override // yg.c
    public final int requestFusion(int i3) {
        if ((i3 & 1) == 0) {
            return 0;
        }
        this.f14718d = true;
        return 1;
    }
}
