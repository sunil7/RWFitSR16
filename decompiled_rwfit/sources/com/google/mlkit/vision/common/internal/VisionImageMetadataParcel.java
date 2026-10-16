package com.google.mlkit.vision.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import oc.e;

/* loaded from: classes.dex */
public class VisionImageMetadataParcel extends AbstractSafeParcelable {
    public static final Parcelable.Creator<VisionImageMetadataParcel> CREATOR = new e();
    public final int height;
    public final int rotation;
    public final long timestampMillis;
    public final int width;
    public final int zza;

    public VisionImageMetadataParcel(long j4, int i3, int i10, int i11, int i12) {
        this.width = i3;
        this.height = i10;
        this.zza = i11;
        this.timestampMillis = j4;
        this.rotation = i12;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        int i11 = this.width;
        u.k(parcel, 1, 4);
        parcel.writeInt(i11);
        int i12 = this.height;
        u.k(parcel, 2, 4);
        parcel.writeInt(i12);
        int i13 = this.zza;
        u.k(parcel, 3, 4);
        parcel.writeInt(i13);
        long j4 = this.timestampMillis;
        u.k(parcel, 4, 8);
        parcel.writeLong(j4);
        int i14 = this.rotation;
        u.k(parcel, 5, 4);
        parcel.writeInt(i14);
        u.j(parcel, i10);
    }
}
