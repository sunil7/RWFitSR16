package com.google.common.collect;

import java.util.Map;

/* loaded from: classes.dex */
public final class c0 extends d2 {

    /* renamed from: a, reason: collision with root package name */
    public final d2 f11051a;

    /* renamed from: b, reason: collision with root package name */
    public Object f11052b = null;

    /* renamed from: c, reason: collision with root package name */
    public d2 f11053c = n0.f11098d;

    public c0(ImmutableMultimap immutableMultimap) {
        this.f11051a = immutableMultimap.map.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11053c.hasNext() || this.f11051a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (!this.f11053c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.f11051a.next();
            this.f11052b = entry.getKey();
            this.f11053c = ((ImmutableCollection) entry.getValue()).iterator();
        }
        return new ImmutableEntry(this.f11052b, this.f11053c.next());
    }
}
