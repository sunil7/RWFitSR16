package com.google.android.gms.internal.mlkit_vision_barcode;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class zzah extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzah> CREATOR = new b(7);
    public int zza;
    public boolean zzb;

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzah)) {
            return false;
        }
        zzah zzahVar = (zzah) obj;
        return this.zza == zzahVar.zza && q9.n.h(Boolean.valueOf(this.zzb), Boolean.valueOf(zzahVar.zzb));
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.zza), Boolean.valueOf(this.zzb)});
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = com.google.android.gms.internal.mlkit_vision_common.u.i(parcel, 20293);
        int i11 = this.zza;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 2, 4);
        parcel.writeInt(i11);
        boolean z5 = this.zzb;
        com.google.android.gms.internal.mlkit_vision_common.u.k(parcel, 3, 4);
        parcel.writeInt(z5 ? 1 : 0);
        com.google.android.gms.internal.mlkit_vision_common.u.j(parcel, i10);
    }
}
