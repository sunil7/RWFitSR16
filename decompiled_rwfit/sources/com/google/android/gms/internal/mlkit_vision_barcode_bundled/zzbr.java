package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzbr extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbr> CREATOR = new f(11);
    private final boolean zza;
    private final byte[] zzb;
    private final boolean zzc;
    private final float zzd;
    private final boolean zze;

    public zzbr(boolean z5, byte[] bArr, boolean z6, float f2, boolean z8) {
        this.zza = z5;
        this.zzb = bArr;
        this.zzc = z6;
        this.zzd = f2;
        this.zze = z8;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        boolean z5 = this.zza;
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 1, 4);
        parcel.writeInt(z5 ? 1 : 0);
        com.google.android.gms.internal.mlkit_vision_common.u.b(parcel, 2, this.zzb);
        boolean z6 = this.zzc;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 3, 4);
        parcel.writeInt(z6 ? 1 : 0);
        float f2 = this.zzd;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 4, 4);
        parcel.writeFloat(f2);
        boolean z8 = this.zze;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 5, 4);
        parcel.writeInt(z8 ? 1 : 0);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
