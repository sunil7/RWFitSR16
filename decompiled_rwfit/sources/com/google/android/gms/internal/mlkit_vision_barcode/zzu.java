package com.google.android.gms.internal.mlkit_vision_barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzu extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzu> CREATOR = new b(10);
    public int zza;
    public String zzb;
    public String zzc;
    public int zzd;
    public Point[] zze;
    public zzn zzf;
    public zzq zzg;
    public zzr zzh;
    public zzt zzi;
    public zzs zzj;
    public zzo zzk;
    public zzk zzl;
    public zzl zzm;
    public zzm zzn;
    public byte[] zzo;
    public boolean zzp;
    public double zzq;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        int i11 = this.zza;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 2, 4);
        parcel.writeInt(i11);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 3, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 4, this.zzc);
        int i12 = this.zzd;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 5, 4);
        parcel.writeInt(i12);
        com.google.android.gms.internal.mlkit_vision_common.u.g(parcel, 6, this.zze, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 7, this.zzf, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 8, this.zzg, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 9, this.zzh, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 10, this.zzi, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 11, this.zzj, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 12, this.zzk, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 13, this.zzl, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 14, this.zzm, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.d(parcel, 15, this.zzn, i3);
        com.google.android.gms.internal.mlkit_vision_common.u.b(parcel, 16, this.zzo);
        boolean z5 = this.zzp;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 17, 4);
        parcel.writeInt(z5 ? 1 : 0);
        double d5 = this.zzq;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 18, 8);
        parcel.writeDouble(d5);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
