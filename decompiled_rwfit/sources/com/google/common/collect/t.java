package com.google.common.collect;

import java.util.Arrays;

/* loaded from: classes.dex */
public abstract class t extends h {

    /* renamed from: a, reason: collision with root package name */
    public Object[] f11118a;

    /* renamed from: b, reason: collision with root package name */
    public int f11119b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11120c;

    public t(int i3) {
        h.d(i3, "initialCapacity");
        this.f11118a = new Object[i3];
        this.f11119b = 0;
    }

    public final void r(Object obj) {
        obj.getClass();
        s(this.f11119b + 1);
        Object[] objArr = this.f11118a;
        int i3 = this.f11119b;
        this.f11119b = i3 + 1;
        objArr[i3] = obj;
    }

    public final void s(int i3) {
        Object[] objArr = this.f11118a;
        if (objArr.length < i3) {
            this.f11118a = Arrays.copyOf(objArr, h.i(objArr.length, i3));
            this.f11120c = false;
        } else if (this.f11120c) {
            this.f11118a = (Object[]) objArr.clone();
            this.f11120c = false;
        }
    }
}
