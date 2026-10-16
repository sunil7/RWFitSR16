package com.google.android.gms.internal.mlkit_vision_barcode;

import java.util.Objects;

/* loaded from: classes.dex */
final class zzdk extends zzcs {
    static final zzcs zza = new zzdk(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient int f9718c;
    final transient Object[] zzb;

    public zzdk(Object[] objArr, int i3) {
        this.zzb = objArr;
        this.f9718c = i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        oa.a(i3, this.f9718c);
        Object obj = this.zzb[i3];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9718c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcs, com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int zza(Object[] objArr, int i3) {
        Object[] objArr2 = this.zzb;
        int i10 = this.f9718c;
        System.arraycopy(objArr2, 0, objArr, i3, i10);
        return i3 + i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int zzb() {
        return this.f9718c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final Object[] zze() {
        return this.zzb;
    }
}
