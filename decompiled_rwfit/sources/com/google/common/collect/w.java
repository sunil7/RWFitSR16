package com.google.common.collect;

/* loaded from: classes.dex */
public final class w extends e0 {
    @Override // com.google.common.collect.e0
    public final e0 b(Object obj, Object obj2) {
        super.b(obj, obj2);
        return this;
    }

    public final ImmutableListMultimap d() {
        return ImmutableListMultimap.fromMapEntries(this.f11061a.entrySet(), null);
    }

    public final void e(Object obj, Object obj2) {
        super.b(obj, obj2);
    }
}
