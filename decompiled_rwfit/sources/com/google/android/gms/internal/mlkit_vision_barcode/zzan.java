package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzan> CREATOR = new b(8);
    public int zza;
    public int zzb;
    public int zzc;
    public long zzd;
    public int zze;

    public zzan(long j4, int i3, int i10, int i11, int i12) {
        this.zza = i3;
        this.zzb = i10;
        this.zzc = i11;
        this.zzd = j4;
        this.zze = i12;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        int i11 = this.zza;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 2, 4);
        parcel.writeInt(i11);
        int i12 = this.zzb;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 3, 4);
        parcel.writeInt(i12);
        int i13 = this.zzc;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 4, 4);
        parcel.writeInt(i13);
        long j4 = this.zzd;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 5, 8);
        parcel.writeLong(j4);
        int i14 = this.zze;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 6, 4);
        parcel.writeInt(i14);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
