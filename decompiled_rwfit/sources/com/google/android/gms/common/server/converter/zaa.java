package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import u8.b;

/* loaded from: classes.dex */
public final class zaa extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaa> CREATOR = new b(10);

    /* renamed from: a, reason: collision with root package name */
    public final int f9145a;
    private final StringToIntConverter zab;

    public zaa(int i3, StringToIntConverter stringToIntConverter) {
        this.f9145a = i3;
        this.zab = stringToIntConverter;
    }

    public final StringToIntConverter b() {
        StringToIntConverter stringToIntConverter = this.zab;
        if (stringToIntConverter != null) {
            return stringToIntConverter;
        }
        throw new IllegalStateException("There was no converter wrapped in this ConverterWrapper.");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9145a);
        u.d(parcel, 2, this.zab, i3);
        u.j(parcel, i10);
    }

    public zaa(StringToIntConverter stringToIntConverter) {
        this.f9145a = 1;
        this.zab = stringToIntConverter;
    }
}
