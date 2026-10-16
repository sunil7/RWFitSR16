package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzyb extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzyb> CREATOR = new b(15);
    private final int zza;
    private final String zzb;
    private final String zzc;
    private final byte[] zzd;
    private final Point[] zze;
    private final int zzf;
    private final zzxu zzg;
    private final zzxx zzh;
    private final zzxy zzi;
    private final zzya zzj;
    private final zzxz zzk;
    private final zzxv zzl;
    private final zzxr zzm;
    private final zzxs zzn;
    private final zzxt zzo;

    public zzyb(int i3, String str, String str2, byte[] bArr, Point[] pointArr, int i10, zzxu zzxuVar, zzxx zzxxVar, zzxy zzxyVar, zzya zzyaVar, zzxz zzxzVar, zzxv zzxvVar, zzxr zzxrVar, zzxs zzxsVar, zzxt zzxtVar) {
        this.zza = i3;
        this.zzb = str;
        this.zzc = str2;
        this.zzd = bArr;
        this.zze = pointArr;
        this.zzf = i10;
        this.zzg = zzxuVar;
        this.zzh = zzxxVar;
        this.zzi = zzxyVar;
        this.zzj = zzyaVar;
        this.zzk = zzxzVar;
        this.zzl = zzxvVar;
        this.zzm = zzxrVar;
        this.zzn = zzxsVar;
        this.zzo = zzxtVar;
    }

    public final int b() {
        return this.zza;
    }

    public final int h() {
        return this.zzf;
    }

    public final String i() {
        return this.zzb;
    }

    public final Point[] j() {
        return this.zze;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        int i11 = this.zza;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 1, 4);
        parcel.writeInt(i11);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 2, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 3, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.u.b(parcel, 4, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 5, this.zze, i3);
        int i12 = this.zzf;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 6, 4);
        parcel.writeInt(i12);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 7, this.zzg, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 8, this.zzh, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 9, this.zzi, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 10, this.zzj, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 11, this.zzk, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 12, this.zzl, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 13, this.zzm, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 14, this.zzn, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 15, this.zzo, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
