package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class g extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedTreeMap f11185a;

    public g(LinkedTreeMap linkedTreeMap) {
        this.f11185a = linkedTreeMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f11185a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.f11185a.containsKey(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new e(this.f11185a, 1);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        return this.f11185a.removeInternalByKey(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f11185a.size;
    }
}
