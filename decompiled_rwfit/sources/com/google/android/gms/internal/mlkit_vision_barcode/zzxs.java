package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzxs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxs> CREATOR = new b(19);
    private final zzxw zza;
    private final String zzb;
    private final String zzc;
    private final zzxx[] zzd;
    private final zzxu[] zze;
    private final String[] zzf;
    private final zzxp[] zzg;

    public zzxs(zzxw zzxwVar, String str, String str2, zzxx[] zzxxVarArr, zzxu[] zzxuVarArr, String[] strArr, zzxp[] zzxpVarArr) {
        this.zza = zzxwVar;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = zzxxVarArr;
        this.zze = zzxuVarArr;
        this.zzf = strArr;
        this.zzg = zzxpVarArr;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 1, this.zza, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 3, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 4, this.zzd, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 5, this.zze, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.f(parcel, 6, this.zzf);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 7, this.zzg, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
