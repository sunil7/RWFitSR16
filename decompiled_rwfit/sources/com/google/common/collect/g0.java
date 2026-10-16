package com.google.common.collect;

/* loaded from: classes.dex */
public final class g0 extends d2 {

    /* renamed from: a, reason: collision with root package name */
    public int f11070a;

    /* renamed from: b, reason: collision with root package name */
    public Object f11071b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ d2 f11072c;

    public g0(d2 d2Var) {
        this.f11072c = d2Var;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11070a > 0 || this.f11072c.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f11070a <= 0) {
            r1 r1Var = (r1) this.f11072c.next();
            this.f11071b = r1Var.getElement();
            this.f11070a = r1Var.getCount();
        }
        this.f11070a--;
        return this.f11071b;
    }
}
