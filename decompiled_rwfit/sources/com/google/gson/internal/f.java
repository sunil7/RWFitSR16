package com.google.gson.internal;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class f extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LinkedTreeMap f11184a;

    public f(LinkedTreeMap linkedTreeMap) {
        this.f11184a = linkedTreeMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.f11184a.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return (obj instanceof Map.Entry) && this.f11184a.findByEntry((Map.Entry) obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        return new e(this.f11184a, 0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        LinkedTreeMap linkedTreeMap;
        h findByEntry;
        if (!(obj instanceof Map.Entry) || (findByEntry = (linkedTreeMap = this.f11184a).findByEntry((Map.Entry) obj)) == null) {
            return false;
        }
        linkedTreeMap.removeInternal(findByEntry, true);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.f11184a.size;
    }
}
