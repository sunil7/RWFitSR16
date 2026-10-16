package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public final class zzq extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzq> CREATOR = new d(14);
    private final boolean zza;

    @Nullable
    private final String zzb;
    private final int zzc;
    private final int zzd;

    public zzq(String str, int i3, int i10, boolean z5) {
        int i11;
        int i12 = 1;
        this.zza = z5;
        this.zzb = str;
        int[] iArr = {1, 2, 3, 4, 5, 6};
        int i13 = 0;
        int i14 = 0;
        while (true) {
            if (i14 >= 6) {
                i11 = 1;
                break;
            }
            i11 = iArr[i14];
            int i15 = i11 - 1;
            if (i11 == 0) {
                throw null;
            }
            if (i15 == i3) {
                break;
            } else {
                i14++;
            }
        }
        this.zzc = i11 - 1;
        int[] iArr2 = {1, 2, 3};
        while (true) {
            if (i13 >= 3) {
                break;
            }
            int i16 = iArr2[i13];
            int i17 = i16 - 1;
            if (i16 == 0) {
                throw null;
            }
            if (i17 == i10) {
                i12 = i16;
                break;
            }
            i13++;
        }
        this.zzd = i12 - 1;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        boolean z5 = this.zza;
        u.k(parcel, 1, 4);
        parcel.writeInt(z5 ? 1 : 0);
        u.e(parcel, 2, this.zzb);
        int i11 = this.zzc;
        u.k(parcel, 3, 4);
        parcel.writeInt(i11);
        int i12 = this.zzd;
        u.k(parcel, 4, 4);
        parcel.writeInt(i12);
        u.j(parcel, i10);
    }
}
