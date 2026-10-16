package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public abstract class n extends AbstractCollection {

    /* renamed from: a, reason: collision with root package name */
    public final Object f9436a;

    /* renamed from: b, reason: collision with root package name */
    public Collection f9437b;

    /* renamed from: c, reason: collision with root package name */
    public final n f9438c;

    /* renamed from: d, reason: collision with root package name */
    public final Collection f9439d;
    public final /* synthetic */ zzbr e;

    public n(zzbr zzbrVar, Object obj, List list, n nVar) {
        this.e = zzbrVar;
        this.f9436a = obj;
        this.f9437b = list;
        this.f9438c = nVar;
        this.f9439d = nVar == null ? null : nVar.f9437b;
    }

    public final void a() {
        Map map;
        n nVar = this.f9438c;
        if (nVar != null) {
            nVar.a();
            return;
        }
        map = this.e.f9704d;
        map.put(this.f9436a, this.f9437b);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean add(Object obj) {
        int i3;
        c();
        boolean isEmpty = this.f9437b.isEmpty();
        boolean add = this.f9437b.add(obj);
        if (add) {
            zzbr zzbrVar = this.e;
            i3 = zzbrVar.e;
            zzbrVar.e = i3 + 1;
            if (isEmpty) {
                a();
                return true;
            }
        }
        return add;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean addAll(Collection collection) {
        int i3;
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean addAll = this.f9437b.addAll(collection);
        if (!addAll) {
            return addAll;
        }
        int size2 = this.f9437b.size() - size;
        zzbr zzbrVar = this.e;
        i3 = zzbrVar.e;
        zzbrVar.e = i3 + size2;
        if (size != 0) {
            return addAll;
        }
        a();
        return true;
    }

    public final void c() {
        Map map;
        n nVar = this.f9438c;
        if (nVar != null) {
            nVar.c();
            if (nVar.f9437b != this.f9439d) {
                throw new ConcurrentModificationException();
            }
            return;
        }
        if (this.f9437b.isEmpty()) {
            Object obj = this.f9436a;
            map = this.e.f9704d;
            Collection collection = (Collection) map.get(obj);
            if (collection != null) {
                this.f9437b = collection;
            }
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        int i3;
        int size = size();
        if (size == 0) {
            return;
        }
        this.f9437b.clear();
        zzbr zzbrVar = this.e;
        i3 = zzbrVar.e;
        zzbrVar.e = i3 - size;
        d();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        c();
        return this.f9437b.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean containsAll(Collection collection) {
        c();
        return this.f9437b.containsAll(collection);
    }

    public final void d() {
        Map map;
        n nVar = this.f9438c;
        if (nVar != null) {
            nVar.d();
        } else if (this.f9437b.isEmpty()) {
            Object obj = this.f9436a;
            map = this.e.f9704d;
            map.remove(obj);
        }
    }

    @Override // java.util.Collection
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        c();
        return this.f9437b.equals(obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        c();
        return this.f9437b.hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        c();
        return new j(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean remove(Object obj) {
        int i3;
        c();
        boolean remove = this.f9437b.remove(obj);
        if (remove) {
            zzbr zzbrVar = this.e;
            i3 = zzbrVar.e;
            zzbrVar.e = i3 - 1;
            d();
        }
        return remove;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean removeAll(Collection collection) {
        int i3;
        if (collection.isEmpty()) {
            return false;
        }
        int size = size();
        boolean removeAll = this.f9437b.removeAll(collection);
        if (removeAll) {
            int size2 = this.f9437b.size() - size;
            zzbr zzbrVar = this.e;
            i3 = zzbrVar.e;
            zzbrVar.e = i3 + size2;
            d();
        }
        return removeAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final boolean retainAll(Collection collection) {
        int i3;
        collection.getClass();
        int size = size();
        boolean retainAll = this.f9437b.retainAll(collection);
        if (retainAll) {
            int size2 = this.f9437b.size() - size;
            zzbr zzbrVar = this.e;
            i3 = zzbrVar.e;
            zzbrVar.e = i3 + size2;
            d();
        }
        return retainAll;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        c();
        return this.f9437b.size();
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        c();
        return this.f9437b.toString();
    }
}
