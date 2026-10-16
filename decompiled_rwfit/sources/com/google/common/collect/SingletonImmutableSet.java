package com.google.common.collect;

/* loaded from: classes.dex */
final class SingletonImmutableSet<E> extends ImmutableSet<E> {

    /* renamed from: c, reason: collision with root package name */
    public transient int f11038c;
    final transient E element;

    public SingletonImmutableSet(E e) {
        e.getClass();
        this.element = e;
    }

    @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        return this.element.equals(obj);
    }

    @Override // com.google.common.collect.ImmutableCollection
    public int copyIntoArray(Object[] objArr, int i3) {
        objArr[i3] = this.element;
        return i3 + 1;
    }

    @Override // com.google.common.collect.ImmutableSet
    public ImmutableList<E> createAsList() {
        return ImmutableList.of((Object) this.element);
    }

    @Override // com.google.common.collect.ImmutableSet, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i3 = this.f11038c;
        if (i3 != 0) {
            return i3;
        }
        int hashCode = this.element.hashCode();
        this.f11038c = hashCode;
        return hashCode;
    }

    @Override // com.google.common.collect.ImmutableSet
    public boolean isHashCodeFast() {
        return this.f11038c != 0;
    }

    @Override // com.google.common.collect.ImmutableCollection
    public boolean isPartialView() {
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        return "[" + this.element.toString() + ']';
    }

    @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public d2 iterator() {
        return new m0(this.element);
    }

    public SingletonImmutableSet(E e, int i3) {
        this.element = e;
        this.f11038c = i3;
    }
}
