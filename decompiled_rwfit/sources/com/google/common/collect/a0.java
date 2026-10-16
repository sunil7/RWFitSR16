package com.google.common.collect;

import java.util.Map;

/* loaded from: classes.dex */
public final class a0 extends d2 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ d2 f11041a;

    public a0(d2 d2Var) {
        this.f11041a = d2Var;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11041a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return new z((Map.Entry) this.f11041a.next());
    }
}
