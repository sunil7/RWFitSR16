package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzxt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzxt> CREATOR = new b(20);
    private final String zza;
    private final String zzb;
    private final String zzc;
    private final String zzd;
    private final String zze;
    private final String zzf;
    private final String zzg;
    private final String zzh;
    private final String zzi;
    private final String zzj;
    private final String zzk;
    private final String zzl;
    private final String zzm;
    private final String zzn;

    public zzxt(String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, String str11, String str12, String str13, String str14) {
        this.zza = str;
        this.zzb = str2;
        this.zzc = str3;
        this.zzd = str4;
        this.zze = str5;
        this.zzf = str6;
        this.zzg = str7;
        this.zzh = str8;
        this.zzi = str9;
        this.zzj = str10;
        this.zzk = str11;
        this.zzl = str12;
        this.zzm = str13;
        this.zzn = str14;
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
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 6, this.zzf);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 7, this.zzg);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 8, this.zzh);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 9, this.zzi);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 10, this.zzj);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 11, this.zzk);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 12, this.zzl);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 13, this.zzm);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 14, this.zzn);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
