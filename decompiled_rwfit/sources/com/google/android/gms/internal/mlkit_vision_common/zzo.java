package com.google.android.gms.internal.mlkit_vision_common;

import com.google.android.gms.internal.mlkit_vision_barcode.ya;
import javax.annotation.CheckForNull;

/* loaded from: classes.dex */
final class zzo extends zzp {
    final transient int zza;
    final transient int zzb;
    final /* synthetic */ zzp zzc;

    public zzo(zzp zzpVar, int i3, int i10) {
        this.zzc = zzpVar;
        this.zza = i3;
        this.zzb = i10;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        ya.a(i3, this.zzb);
        return this.zzc.get(i3 + this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int zzb() {
        return this.zzc.zzc() + this.zza + this.zzb;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    public final int zzc() {
        return this.zzc.zzc() + this.zza;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzl
    @CheckForNull
    public final Object[] zze() {
        return this.zzc.zze();
    }

    @Override // com.google.android.gms.internal.mlkit_vision_common.zzp, java.util.List
    /* renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public final zzp subList(int i3, int i10) {
        ya.b(i3, i10, this.zzb);
        zzp zzpVar = this.zzc;
        int i11 = this.zza;
        return zzpVar.subList(i3 + i11, i10 + i11);
    }
}
