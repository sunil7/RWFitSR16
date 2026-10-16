package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_barcode.ya;

/* loaded from: classes.dex */
final class zzu extends zzp {
    static final zzp zza = new zzu(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient int f10152c;
    final transient Object[] zzb;

    public zzu(Object[] objArr, int i3) {
        this.zzb = objArr;
        this.f10152c = i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        ya.a(i3, this.f10152c);
        Object obj = this.zzb[i3];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f10152c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzp, com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int zza(Object[] objArr, int i3) {
        Object[] objArr2 = this.zzb;
        int i10 = this.f10152c;
        System.arraycopy(objArr2, 0, objArr, 0, i10);
        return i10;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int zzb() {
        return this.f10152c;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final Object[] zze() {
        return this.zzb;
    }
}
