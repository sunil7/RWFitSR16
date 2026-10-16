package com.google.common.collect;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class t0 extends x0 {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f11121b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MapMakerInternalMap f11122c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t0(MapMakerInternalMap mapMakerInternalMap, int i3) {
        super(0);
        this.f11121b = i3;
        this.f11122c = mapMakerInternalMap;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        switch (this.f11121b) {
            case 0:
                this.f11122c.clear();
                break;
            default:
                this.f11122c.clear();
                break;
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        Map.Entry entry;
        Object key;
        MapMakerInternalMap mapMakerInternalMap;
        Object obj2;
        switch (this.f11121b) {
            case 0:
                return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = (mapMakerInternalMap = this.f11122c).get(key)) != null && mapMakerInternalMap.valueEquivalence().equivalent(entry.getValue(), obj2);
            default:
                return this.f11122c.containsKey(obj);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        switch (this.f11121b) {
        }
        return this.f11122c.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        switch (this.f11121b) {
            case 0:
                return new s0(this.f11122c, 0);
            default:
                return new s0(this.f11122c, 1);
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        Map.Entry entry;
        Object key;
        switch (this.f11121b) {
            case 0:
                if ((obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && this.f11122c.remove(key, entry.getValue())) {
                }
                break;
            default:
                if (this.f11122c.remove(obj) != null) {
                }
                break;
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        switch (this.f11121b) {
        }
        return this.f11122c.size();
    }
}
