package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzdo extends zzcs {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f9723c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f9724d;
    public final transient int e = 1;

    public zzdo(Object[] objArr, int i3, int i10) {
        this.f9723c = objArr;
        this.f9724d = i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        oa.a(i3, this.e);
        Object obj = this.f9723c[i3 + i3 + this.f9724d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
