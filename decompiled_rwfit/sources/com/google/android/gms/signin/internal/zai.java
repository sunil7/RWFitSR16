package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.internal.mlkit_vision_common.u;

/* loaded from: classes.dex */
public final class zai extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zai> CREATOR = new g(29);

    /* renamed from: a, reason: collision with root package name */
    public final int f10161a;

    /* renamed from: b, reason: collision with root package name */
    public final zat f10162b;

    public zai(int i3, zat zatVar) {
        this.f10161a = i3;
        this.f10162b = zatVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f10161a);
        u.d(parcel, 2, this.f10162b, i3);
        u.j(parcel, i10);
    }
}
