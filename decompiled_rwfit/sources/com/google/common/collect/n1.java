package com.google.common.collect;

import java.util.Map;

/* loaded from: classes.dex */
public final class n1 extends d {

    /* renamed from: a, reason: collision with root package name */
    public final Object f11100a;

    /* renamed from: b, reason: collision with root package name */
    public Object f11101b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ MapMakerInternalMap f11102c;

    public n1(MapMakerInternalMap mapMakerInternalMap, Object obj, Object obj2) {
        this.f11102c = mapMakerInternalMap;
        this.f11100a = obj;
        this.f11101b = obj2;
    }

    @Override // com.google.common.collect.d, java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (this.f11100a.equals(entry.getKey()) && this.f11101b.equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f11100a;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.f11101b;
    }

    @Override // com.google.common.collect.d, java.util.Map.Entry
    public final int hashCode() {
        return this.f11100a.hashCode() ^ this.f11101b.hashCode();
    }

    @Override // com.google.common.collect.d, java.util.Map.Entry
    public final Object setValue(Object obj) {
        Object put = this.f11102c.put(this.f11100a, obj);
        this.f11101b = obj;
        return put;
    }
}
