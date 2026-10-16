package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzao extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzao> CREATOR = new f(6);
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final zzan zzf;
    private final zzan zzg;

    public zzao(String str, String str2, String str3, String str4, String str5, zzan zzanVar, zzan zzanVar2) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = zzanVar;
        this.zzg = zzanVar2;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        String str = this.zza;
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 1, str);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 3, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 4, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 5, this.zze);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 6, this.zzf, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 7, this.zzg, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
