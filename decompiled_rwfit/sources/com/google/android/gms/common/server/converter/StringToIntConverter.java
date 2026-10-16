package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import java.util.ArrayList;
import java.util.HashMap;
import u8.b;
import x9.a;

/* loaded from: classes.dex */
public final class StringToIntConverter extends AbstractSafeParcelable implements a {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new b(11);

    /* renamed from: a, reason: collision with root package name */
    public final int f9144a;
    private final HashMap zab = new HashMap();
    private final SparseArray zac = new SparseArray();

    public StringToIntConverter(int i3, ArrayList arrayList) {
        this.f9144a = i3;
        int size = arrayList.size();
        for (int i10 = 0; i10 < size; i10++) {
            zac zacVar = (zac) arrayList.get(i10);
            String str = zacVar.f9147b;
            int i11 = zacVar.f9148c;
            this.zab.put(str, Integer.valueOf(i11));
            this.zac.put(i11, str);
        }
    }

    public final /* bridge */ /* synthetic */ String b(Object obj) {
        String str = (String) this.zac.get(((Integer) obj).intValue());
        return (str == null && this.zab.containsKey("gms_unknown")) ? "gms_unknown" : str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(this.f9144a);
        ArrayList arrayList = new ArrayList();
        for (String str : this.zab.keySet()) {
            arrayList.add(new zac(str, ((Integer) this.zab.get(str)).intValue()));
        }
        u.h(parcel, 2, arrayList);
        u.j(parcel, i10);
    }
}
