package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_vision_barcode.ka;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzap extends zzaf {

    /* renamed from: c, reason: collision with root package name */
    public final transient Object[] f9196c;

    /* renamed from: d, reason: collision with root package name */
    public final transient int f9197d;
    public final transient int e;

    public zzap(Object[] objArr, int i3, int i10) {
        this.f9196c = objArr;
        this.f9197d = i3;
        this.e = i10;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        ka.a(i3, this.e);
        Object obj = this.f9196c[i3 + i3 + this.f9197d];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.e;
    }
}
