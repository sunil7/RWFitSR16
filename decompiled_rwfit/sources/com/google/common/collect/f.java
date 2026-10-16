package com.google.common.collect;

import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes.dex */
public abstract class f extends AbstractCollection implements s1 {

    /* renamed from: a, reason: collision with root package name */
    public transient Set f11063a;

    /* renamed from: b, reason: collision with root package name */
    public transient Set f11064b;

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean add(@NullableDecl Object obj) {
        add(obj, 1);
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean addAll(Collection<Object> collection) {
        collection.getClass();
        if (!(collection instanceof s1)) {
            if (collection.isEmpty()) {
                return false;
            }
            return h.a(this, collection.iterator());
        }
        s1 s1Var = (s1) collection;
        if (s1Var instanceof AbstractMapBasedMultiset) {
            AbstractMapBasedMultiset abstractMapBasedMultiset = (AbstractMapBasedMultiset) s1Var;
            if (abstractMapBasedMultiset.isEmpty()) {
                return false;
            }
            abstractMapBasedMultiset.addTo(this);
            return true;
        }
        if (s1Var.isEmpty()) {
            return false;
        }
        for (r1 r1Var : s1Var.entrySet()) {
            add(r1Var.getElement(), r1Var.getCount());
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(@NullableDecl Object obj) {
        return count(obj) > 0;
    }

    public Set<Object> createElementSet() {
        return new e(this, 0);
    }

    public Set<r1> createEntrySet() {
        return new e(this, 1);
    }

    public abstract int distinctElements();

    public abstract Iterator elementIterator();

    @Override // com.google.common.collect.s1
    public Set<Object> elementSet() {
        Set<Object> set = this.f11063a;
        if (set != null) {
            return set;
        }
        Set<Object> createElementSet = createElementSet();
        this.f11063a = createElementSet;
        return createElementSet;
    }

    public abstract Iterator entryIterator();

    @Override // com.google.common.collect.s1
    public Set<r1> entrySet() {
        Set<r1> set = this.f11064b;
        if (set != null) {
            return set;
        }
        Set<r1> createEntrySet = createEntrySet();
        this.f11064b = createEntrySet;
        return createEntrySet;
    }

    @Override // java.util.Collection
    public final boolean equals(@NullableDecl Object obj) {
        return h.h(this, obj);
    }

    @Override // java.util.Collection
    public final int hashCode() {
        return entrySet().hashCode();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return entrySet().isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean remove(@NullableDecl Object obj) {
        return remove(obj, 1) > 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean removeAll(Collection<?> collection) {
        if (collection instanceof s1) {
            collection = ((s1) collection).elementSet();
        }
        return elementSet().removeAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    @CanIgnoreReturnValue
    public final boolean retainAll(Collection<?> collection) {
        collection.getClass();
        if (collection instanceof s1) {
            collection = ((s1) collection).elementSet();
        }
        return elementSet().retainAll(collection);
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        return entrySet().toString();
    }
}
