package com.google.common.collect;

import java.util.Collection;

/* loaded from: classes.dex */
public final class j0 extends e0 {
    @Override // com.google.common.collect.e0
    public final Collection a() {
        return CompactHashSet.create();
    }

    @Override // com.google.common.collect.e0
    public final e0 b(Object obj, Object obj2) {
        super.b(obj, obj2);
        return this;
    }

    public final ImmutableSetMultimap d() {
        return ImmutableSetMultimap.fromMapEntries(this.f11061a.entrySet(), null);
    }

    public final void e(Object obj, Object obj2) {
        super.b(obj, obj2);
    }
}
