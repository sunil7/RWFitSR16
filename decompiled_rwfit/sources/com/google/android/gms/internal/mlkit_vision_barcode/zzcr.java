package com.google.android.gms.internal.mlkit_vision_barcode;

import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzcr extends zzcs {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzcs zzc;

    public zzcr(zzcs zzcsVar, int i3, int i10) {
        this.zzc = zzcsVar;
        this.zza = i3;
        this.zzb = i10;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        oa.a(i3, this.zzb);
        return this.zzc.get(i3 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcn
    @CheckForNull
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.zzcs, java.util.List
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzcs subList(int i3, int i10) {
        oa.b(i3, i10, this.zzb);
        int i11 = this.zza;
        return this.zzc.subList(i3 + i11, i10 + i11);
    }
}
