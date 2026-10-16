package com.google.android.gms.common;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;
import java.util.Arrays;
import org.joda.time.format.p;

/* loaded from: classes.dex */
public class Feature extends AbstractSafeParcelable {
    public static final Parcelable.Creator<Feature> CREATOR = new d(12);
    private final String zza;

    @Deprecated
    private final int zzb;
    private final long zzc;

    public Feature(int i3, long j4, String str) {
        this.zza = str;
        this.zzb = i3;
        this.zzc = j4;
    }

    public final String b() {
        return this.zza;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Feature) {
            Feature feature = (Feature) obj;
            String str = this.zza;
            if (((str != null && str.equals(feature.zza)) || (this.zza == null && feature.zza == null)) && h() == feature.h()) {
                return true;
            }
        }
        return false;
    }

    public final long h() {
        long j4 = this.zzc;
        return j4 == -1 ? this.zzb : j4;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza, Long.valueOf(h())});
    }

    public final String toString() {
        p pVar = new p(this);
        pVar.a(this.zza, "name");
        pVar.a(Long.valueOf(h()), "version");
        return pVar.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.e(parcel, 1, this.zza);
        int i11 = this.zzb;
        u.k(parcel, 2, 4);
        parcel.writeInt(i11);
        long h4 = h();
        u.k(parcel, 3, 8);
        parcel.writeLong(h4);
        u.j(parcel, i10);
    }

    public Feature(String str, long j4) {
        this.zza = str;
        this.zzc = j4;
        this.zzb = -1;
    }
}
