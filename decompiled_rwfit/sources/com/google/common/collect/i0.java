package com.google.common.collect;

import java.util.Arrays;

/* loaded from: classes.dex */
public class i0 extends t {

    /* renamed from: d, reason: collision with root package name */
    public Object[] f11079d;
    public int e;

    public i0 t(Object obj) {
        obj.getClass();
        if (this.f11079d != null) {
            int chooseTableSize = ImmutableSet.chooseTableSize(this.f11119b);
            Object[] objArr = this.f11079d;
            if (chooseTableSize <= objArr.length) {
                int length = objArr.length - 1;
                int hashCode = obj.hashCode();
                int n4 = h.n(hashCode);
                while (true) {
                    int i3 = n4 & length;
                    Object[] objArr2 = this.f11079d;
                    Object obj2 = objArr2[i3];
                    if (obj2 == null) {
                        objArr2[i3] = obj;
                        this.e += hashCode;
                        r(obj);
                        return this;
                    }
                    if (obj2.equals(obj)) {
                        return this;
                    }
                    n4 = i3 + 1;
                }
            }
        }
        this.f11079d = null;
        r(obj);
        return this;
    }

    public ImmutableSet u() {
        ImmutableSet a3;
        int i3 = this.f11119b;
        if (i3 == 0) {
            return ImmutableSet.of();
        }
        if (i3 == 1) {
            return ImmutableSet.of(this.f11118a[0]);
        }
        if (this.f11079d == null || ImmutableSet.chooseTableSize(i3) != this.f11079d.length) {
            a3 = ImmutableSet.a(this.f11119b, this.f11118a);
            this.f11119b = a3.size();
        } else {
            Object[] copyOf = ImmutableSet.access$000(this.f11119b, this.f11118a.length) ? Arrays.copyOf(this.f11118a, this.f11119b) : this.f11118a;
            a3 = new RegularImmutableSet(copyOf, this.e, this.f11079d, r5.length - 1, this.f11119b);
        }
        this.f11120c = true;
        this.f11079d = null;
        return a3;
    }
}
