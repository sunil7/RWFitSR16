package com.google.common.collect;

import java.util.Map;

/* loaded from: classes.dex */
public final class b0 extends d2 {

    /* renamed from: a, reason: collision with root package name */
    public final d2 f11045a;

    public b0(ImmutableMapValues immutableMapValues) {
        ImmutableMap immutableMap;
        immutableMap = immutableMapValues.map;
        this.f11045a = immutableMap.entrySet().iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11045a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return ((Map.Entry) this.f11045a.next()).getValue();
    }
}
