package com.google.common.collect;

import java.util.Map;

/* loaded from: classes.dex */
public final class x extends d2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d2 f11146a;

    public x(d2 d2Var) {
        this.f11146a = d2Var;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11146a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return ((Map.Entry) this.f11146a.next()).getKey();
    }
}
