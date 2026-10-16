package com.google.android.gms.internal.mlkit_vision_barcode_bundled;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;

/* loaded from: classes.dex */
public final class zzbv extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzbv> CREATOR = new f(13);
    private final float[] zza;

    public zzbv(float[] fArr) {
        this.zza = fArr;
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
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
