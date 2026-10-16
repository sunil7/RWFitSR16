package com.google.common.collect;

import java.util.Comparator;

/* loaded from: classes.dex */
public final class l0 extends i0 {

    /* renamed from: f, reason: collision with root package name */
    public final Comparator f11090f;

    public l0(Comparator comparator) {
        super(4);
        comparator.getClass();
        this.f11090f = comparator;
    }

    @Override // com.google.common.collect.i0
    public final i0 t(Object obj) {
        super.t(obj);
        return this;
    }

    @Override // com.google.common.collect.i0
    /* renamed from: v, reason: merged with bridge method [inline-methods] */
    public final ImmutableSortedSet u() {
        ImmutableSortedSet construct = ImmutableSortedSet.construct(this.f11090f, this.f11119b, this.f11118a);
        this.f11119b = construct.size();
        this.f11120c = true;
        return construct;
    }
}
