package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import u8.b;

/* loaded from: classes.dex */
public final class zac extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zac> CREATOR = new b(12);

    /* renamed from: a, reason: collision with root package name */
    public final int f9146a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9147b;

    /* renamed from: c, reason: collision with root package name */
    public final int f9148c;

    public zac(int i3, String str, int i10) {
        this.f9146a = i3;
        this.f9147b = str;
        this.f9148c = i10;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9146a);
        u.e(parcel, 2, this.f9147b);
        u.k(parcel, 3, 4);
        parcel.writeInt(this.f9148c);
        u.j(parcel, i10);
    }

    public zac(String str, int i3) {
        this.f9146a = 1;
        this.f9147b = str;
        this.f9148c = i3;
    }
}
