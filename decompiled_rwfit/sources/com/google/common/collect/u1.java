package com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class u1 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final s1 f11130a;

    /* renamed from: b, reason: collision with root package name */
    public final Iterator f11131b;

    /* renamed from: c, reason: collision with root package name */
    public r1 f11132c;

    /* renamed from: d, reason: collision with root package name */
    public int f11133d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f11134f;

    public u1(s1 s1Var, Iterator it) {
        this.f11130a = s1Var;
        this.f11131b = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11133d > 0 || this.f11131b.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (this.f11133d == 0) {
            r1 r1Var = (r1) this.f11131b.next();
            this.f11132c = r1Var;
            int count = r1Var.getCount();
            this.f11133d = count;
            this.e = count;
        }
        this.f11133d--;
        this.f11134f = true;
        return this.f11132c.getElement();
    }

    @Override // java.util.Iterator
    public final void remove() {
        h.e(this.f11134f);
        if (this.e == 1) {
            this.f11131b.remove();
        } else {
            this.f11130a.remove(this.f11132c.getElement());
        }
        this.e--;
        this.f11134f = false;
    }
}
