package com.google.gson.internal;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class e implements Iterator {

    /* renamed from: a, reason: collision with root package name */
    public h f11180a;

    /* renamed from: b, reason: collision with root package name */
    public h f11181b = null;

    /* renamed from: c, reason: collision with root package name */
    public int f11182c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LinkedTreeMap f11183d;
    public final /* synthetic */ int e;

    public e(LinkedTreeMap linkedTreeMap, int i3) {
        this.e = i3;
        this.f11183d = linkedTreeMap;
        this.f11180a = linkedTreeMap.header.f11189d;
        this.f11182c = linkedTreeMap.modCount;
    }

    public final Object a() {
        return b();
    }

    public final h b() {
        h hVar = this.f11180a;
        LinkedTreeMap linkedTreeMap = this.f11183d;
        if (hVar == linkedTreeMap.header) {
            throw new NoSuchElementException();
        }
        if (linkedTreeMap.modCount != this.f11182c) {
            throw new ConcurrentModificationException();
        }
        this.f11180a = hVar.f11189d;
        this.f11181b = hVar;
        return hVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.f11180a != this.f11183d.header;
    }

    @Override // java.util.Iterator
    public Object next() {
        switch (this.e) {
            case 1:
                return b().f11190f;
            default:
                return a();
        }
    }

    @Override // java.util.Iterator
    public final void remove() {
        h hVar = this.f11181b;
        if (hVar == null) {
            throw new IllegalStateException();
        }
        LinkedTreeMap linkedTreeMap = this.f11183d;
        linkedTreeMap.removeInternal(hVar, true);
        this.f11181b = null;
        this.f11182c = linkedTreeMap.modCount;
    }
}
