package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import java.util.ArrayList;
import java.util.Map;
import u8.b;

/* loaded from: classes.dex */
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new b(17);

    /* renamed from: a, reason: collision with root package name */
    public final int f9156a;

    /* renamed from: b, reason: collision with root package name */
    public final String f9157b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f9158c;

    public zal(int i3, String str, ArrayList arrayList) {
        this.f9156a = i3;
        this.f9157b = str;
        this.f9158c = arrayList;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9156a);
        u.e(parcel, 2, this.f9157b);
        u.h(parcel, 3, this.f9158c);
        u.j(parcel, i10);
    }

    public zal(String str, Map map) {
        ArrayList arrayList;
        this.f9156a = 1;
        this.f9157b = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList();
            for (String str2 : map.keySet()) {
                arrayList.add(new zam(str2, (FastJsonResponse$Field) map.get(str2)));
            }
        }
        this.f9158c = arrayList;
    }
}
