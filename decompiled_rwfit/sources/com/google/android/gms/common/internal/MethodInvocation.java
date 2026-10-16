package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;

/* loaded from: classes.dex */
public class MethodInvocation extends AbstractSafeParcelable {
    public static final Parcelable.Creator<MethodInvocation> CREATOR = new d(25);
    private final int zaa;
    private final int zab;
    private final int zac;
    private final long zad;
    private final long zae;
    private final String zaf;
    private final String zag;
    private final int zah;
    private final int zai;

    public MethodInvocation(int i3, int i10, int i11, long j4, long j10, String str, String str2, int i12, int i13) {
        this.zaa = i3;
        this.zab = i10;
        this.zac = i11;
        this.zad = j4;
        this.zae = j10;
        this.zaf = str;
        this.zag = str2;
        this.zah = i12;
        this.zai = i13;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = this.zaa;
        int i11 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(i10);
        int i12 = this.zab;
        u.k(parcel, 2, 4);
        parcel.writeInt(i12);
        int i13 = this.zac;
        u.k(parcel, 3, 4);
        parcel.writeInt(i13);
        long j4 = this.zad;
        u.k(parcel, 4, 8);
        parcel.writeLong(j4);
        long j10 = this.zae;
        u.k(parcel, 5, 8);
        parcel.writeLong(j10);
        u.e(parcel, 6, this.zaf);
        u.e(parcel, 7, this.zag);
        int i14 = this.zah;
        u.k(parcel, 8, 4);
        parcel.writeInt(i14);
        int i15 = this.zai;
        u.k(parcel, 9, 4);
        parcel.writeInt(i15);
        u.j(parcel, i11);
    }
}
