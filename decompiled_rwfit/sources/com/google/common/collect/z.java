package com.google.common.collect;

import java.util.Map;

/* loaded from: classes.dex */
public final class z extends d {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Map.Entry f11154a;

    public z(Map.Entry entry) {
        this.f11154a = entry;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.f11154a.getKey();
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return ImmutableSet.of(this.f11154a.getValue());
    }
}
