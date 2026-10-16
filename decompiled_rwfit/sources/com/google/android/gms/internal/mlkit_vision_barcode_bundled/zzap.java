package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzap extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzap> CREATOR = new f(7);
    private final zzat zza;
    private final String zzb;
    private final String zzc;
    private final zzau[] zzd;
    private final zzar[] zze;
    private final String[] zzf;
    private final zzam[] zzg;

    public zzap(zzat zzatVar, String str, String str2, zzau[] zzauVarArr, zzar[] zzarVarArr, String[] strArr, zzam[] zzamVarArr) {
        this.zza = zzatVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzauVarArr;
        this.zze = zzarVarArr;
        this.zzf = strArr;
        this.zzg = zzamVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        zzat zzatVar = this.zza;
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 1, zzatVar, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 3, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 4, this.zzd, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 5, this.zze, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.f(parcel, 6, this.zzf);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 7, this.zzg, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
