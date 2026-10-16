package com.google.android.gms.internal.mlkit_common;

import com.google.android.gms.internal.mlkit_vision_barcode.ka;
import java.util.Objects;

/* loaded from: classes.dex */
final class zzal extends zzaf {
    static final zzaf zza = new zzal(new Object[0], 0);

    /* renamed from: c, reason: collision with root package name */
    public final transient int f9191c;
    final transient Object[] zzb;

    public zzal(Object[] objArr, int i3) {
        this.zzb = objArr;
        this.f9191c = i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        ka.a(i3, this.f9191c);
        Object obj = this.zzb[i3];
        Objects.requireNonNull(obj);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f9191c;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzaf, com.google.android.gms.internal.mlkit_common.zzab
    public final int zza(Object[] objArr, int i3) {
        Object[] objArr2 = this.zzb;
        int i10 = this.f9191c;
        System.arraycopy(objArr2, 0, objArr, 0, i10);
        return i10;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    public final int zzb() {
        return this.f9191c;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    public final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.mlkit_common.zzab
    public final Object[] zze() {
        return this.zzb;
    }
}
