package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import u8.b;

/* loaded from: classes.dex */
public final class zam extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zam> CREATOR = new b(15);

    /* renamed from: a, reason: collision with root package name */
    public final int f9159a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9160b;

    /* renamed from: c, reason: collision with root package name */
    public final FastJsonResponse$Field f9161c;

    public zam(int i3, String str, FastJsonResponse$Field fastJsonResponse$Field) {
        this.f9159a = i3;
        this.f9160b = str;
        this.f9161c = fastJsonResponse$Field;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9159a);
        u.e(parcel, 2, this.f9160b);
        u.d(parcel, 3, this.f9161c, i3);
        u.j(parcel, i10);
    }

    public zam(String str, FastJsonResponse$Field fastJsonResponse$Field) {
        this.f9159a = 1;
        this.f9160b = str;
        this.f9161c = fastJsonResponse$Field;
    }
}
