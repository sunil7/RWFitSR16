package com.google.common.collect;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class m0 extends d2 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f11095a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Object f11096b;

    public m0(Object obj) {
        this.f11096b = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.f11095a;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.f11095a) {
            throw new NoSuchElementException();
        }
        this.f11095a = true;
        return this.f11096b;
    }
}
