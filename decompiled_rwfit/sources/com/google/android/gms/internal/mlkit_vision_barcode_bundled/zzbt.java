package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzbt extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbt> CREATOR = new f(12);
    private final float[] zza;
    private final int zzb;
    private final boolean zzc;

    public zzbt(float[] fArr, int i3, boolean z5) {
        this.zza = fArr;
        this.zzb = i3;
        this.zzc = z5;
    }

    public final int b() {
        return this.zzb;
    }

    public final boolean h() {
        return this.zzc;
    }

    public final float[] i() {
        return this.zza;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        float[] fArr = this.zza;
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        if (fArr != null) {
            int i11 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 1);
            parcel.writeFloatArray(fArr);
            com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i11);
        }
        int i12 = this.zzb;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 2, 4);
        parcel.writeInt(i12);
        boolean z5 = this.zzc;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 3, 4);
        parcel.writeInt(z5 ? 1 : 0);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
