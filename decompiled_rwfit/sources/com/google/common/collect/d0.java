package com.google.common.collect;

/* loaded from: classes.dex */
public final class d0 extends d2 {

    /* renamed from: a, reason: collision with root package name */
    public d2 f11056a;

    /* renamed from: b, reason: collision with root package name */
    public d2 f11057b;

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11057b.hasNext() || this.f11056a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f11057b.hasNext()) {
            this.f11057b = ((ImmutableCollection) this.f11056a.next()).iterator();
        }
        return this.f11057b.next();
    }
}
