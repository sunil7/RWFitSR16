package kotlin.collections;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/* loaded from: classes2.dex */
public final class r extends AbstractList implements List, ph.b {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f15640a;

    public r(ArrayList arrayList) {
        this.f15640a = arrayList;
    }

    @Override // java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        this.f15640a.add(h.k(i3, this), obj);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        this.f15640a.clear();
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        return this.f15640a.get(h.j(i3, this));
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new q(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator() {
        return new q(this, 0);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object remove(int i3) {
        return this.f15640a.remove(h.j(i3, this));
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object set(int i3, Object obj) {
        return this.f15640a.set(h.j(i3, this), obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f15640a.size();
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i3) {
        return new q(this, i3);
    }
}
