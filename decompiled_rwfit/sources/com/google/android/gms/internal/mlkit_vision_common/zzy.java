package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_barcode.ya;

/* loaded from: classes.dex */
final class zzy extends zzp {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f10157c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f10158d;
    public final transient int e;

    public zzy(Object[] objArr, int i3, int i10) {
        this.f10157c = objArr;
        this.f10158d = i3;
        this.e = i10;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        ya.a(i3, this.e);
        Object obj = this.f10157c[i3 + i3 + this.f10158d];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
