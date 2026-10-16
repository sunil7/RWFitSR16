package com.google.common.collect;

import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class l extends AbstractCollection {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f11088a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AbstractMap f11089b;

    public /* synthetic */ l(AbstractMap abstractMap, int i3) {
        this.f11088a = i3;
        this.f11089b = abstractMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final void clear() {
        switch (this.f11088a) {
            case 0:
                ((CompactHashMap) this.f11089b).clear();
                break;
            default:
                ((MapMakerInternalMap) this.f11089b).clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean contains(Object obj) {
        switch (this.f11088a) {
            case 1:
                return ((MapMakerInternalMap) this.f11089b).containsValue(obj);
            default:
                return super.contains(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        switch (this.f11088a) {
            case 1:
                return ((MapMakerInternalMap) this.f11089b).isEmpty();
            default:
                return super.isEmpty();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final Iterator iterator() {
        switch (this.f11088a) {
            case 0:
                return ((CompactHashMap) this.f11089b).valuesIterator();
            default:
                return new s0((MapMakerInternalMap) this.f11089b, 2);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        int i3;
        switch (this.f11088a) {
            case 0:
                i3 = ((CompactHashMap) this.f11089b).f10999c;
                return i3;
            default:
                return ((MapMakerInternalMap) this.f11089b).size();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray() {
        switch (this.f11088a) {
            case 1:
                return MapMakerInternalMap.access$900(this).toArray();
            default:
                return super.toArray();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        switch (this.f11088a) {
            case 1:
                return MapMakerInternalMap.access$900(this).toArray(objArr);
            default:
                return super.toArray(objArr);
        }
    }
}
