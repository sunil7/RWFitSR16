package com.google.common.collect;

import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes.dex */
public abstract class x0 extends AbstractSet {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11147a;

    @Override // java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean removeAll(Collection collection) {
        switch (this.f11147a) {
            case 1:
                collection.getClass();
                if (collection instanceof s1) {
                    collection = ((s1) collection).elementSet();
                }
                boolean z5 = false;
                if (!(collection instanceof Set) || collection.size() <= size()) {
                    Iterator it = collection.iterator();
                    while (it.hasNext()) {
                        z5 |= remove(it.next());
                    }
                } else {
                    Iterator<E> it2 = iterator();
                    collection.getClass();
                    while (it2.hasNext()) {
                        if (collection.contains(it2.next())) {
                            it2.remove();
                            z5 = true;
                        }
                    }
                }
                return z5;
            default:
                return super.removeAll(collection);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public boolean retainAll(Collection collection) {
        switch (this.f11147a) {
            case 1:
                collection.getClass();
                break;
        }
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray() {
        switch (this.f11147a) {
            case 0:
                return MapMakerInternalMap.access$900(this).toArray();
            default:
                return super.toArray();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public Object[] toArray(Object[] objArr) {
        switch (this.f11147a) {
            case 0:
                return MapMakerInternalMap.access$900(this).toArray(objArr);
            default:
                return super.toArray(objArr);
        }
    }
}
