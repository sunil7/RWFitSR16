package com.google.common.collect;

/* loaded from: classes.dex */
public final class v extends a {

    /* renamed from: c, reason: collision with root package name */
    public final ImmutableList f11135c;

    public v(ImmutableList immutableList, int i3) {
        super(immutableList.size(), i3);
        this.f11135c = immutableList;
    }

    @Override // com.google.common.collect.a
    public final Object a(int i3) {
        return this.f11135c.get(i3);
    }
}
