package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzn extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzn> CREATOR = new b(0);
    public int zza;
    public String zzb;
    public String zzc;
    public String zzd;

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        int i11 = this.zza;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 2, 4);
        parcel.writeInt(i11);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 3, this.zzb);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 4, this.zzc);
        com.google.android.gms.internal.mlkit_vision_common.u.e(parcel, 5, this.zzd);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
