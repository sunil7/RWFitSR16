package com.google.common.collect;

import java.util.Arrays;

/* loaded from: classes.dex */
public final class y {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f11150a;

    /* renamed from: b, reason: collision with root package name */
    public int f11151b = 0;

    public y(int i3) {
        this.f11150a = new Object[i3 * 2];
    }

    public final ImmutableMap a() {
        return RegularImmutableMap.create(this.f11151b, this.f11150a);
    }

    public final void b(Object obj, Object obj2) {
        int i3 = (this.f11151b + 1) * 2;
        Object[] objArr = this.f11150a;
        if (i3 > objArr.length) {
            this.f11150a = Arrays.copyOf(objArr, h.i(objArr.length, i3));
        }
        h.c(obj, obj2);
        Object[] objArr2 = this.f11150a;
        int i10 = this.f11151b;
        int i11 = i10 * 2;
        objArr2[i11] = obj;
        objArr2[i11 + 1] = obj2;
        this.f11151b = i10 + 1;
    }
}
