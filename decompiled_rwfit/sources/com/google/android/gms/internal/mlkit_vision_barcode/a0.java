package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class a0 implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public final Iterator f9202a;

    public a0(Iterator it) {
        it.getClass();
        this.f9202a = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f9202a.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        return ((Map.Entry) this.f9202a.next()).getValue();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.f9202a.remove();
    }
}
