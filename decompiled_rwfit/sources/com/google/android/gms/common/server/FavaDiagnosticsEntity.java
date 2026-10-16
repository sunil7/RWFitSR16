package com.google.android.gms.common.server;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ReflectedParcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import u8.b;

/* loaded from: classes.dex */
public class FavaDiagnosticsEntity extends AbstractSafeParcelable implements ReflectedParcelable {
    public static final Parcelable.Creator<FavaDiagnosticsEntity> CREATOR = new b(5);

    /* renamed from: a, reason: collision with root package name */
    public final int f9143a;
    public final String zab;
    public final int zac;

    public FavaDiagnosticsEntity(int i3, String str, int i10) {
        this.f9143a = i3;
        this.zab = str;
        this.zac = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9143a);
        u.e(parcel, 2, this.zab);
        int i11 = this.zac;
        u.k(parcel, 3, 4);
        parcel.writeInt(i11);
        u.j(parcel, i10);
    }
}
