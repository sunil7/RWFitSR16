package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;

/* loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new g(27);

    /* renamed from: a, reason: collision with root package name */
    public final int f10160a;
    private int zab;
    private Intent zac;

    public zaa(int i3, int i10, Intent intent) {
        this.f10160a = i3;
        this.zab = i10;
        this.zac = intent;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f10160a);
        int i11 = this.zab;
        u.k(parcel, 2, 4);
        parcel.writeInt(i11);
        u.d(parcel, 3, this.zac, i3);
        u.j(parcel, i10);
    }
}
