package com.google.common.collect;

import java.util.Iterator;

/* loaded from: classes.dex */
public abstract class c2 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f11055a;

    public c2(Iterator it) {
        it.getClass();
        this.f11055a = it;
    }

    public abstract Object a(Object obj);

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11055a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return a(this.f11055a.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f11055a.remove();
    }
}
