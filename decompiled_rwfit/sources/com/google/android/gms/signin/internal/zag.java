package com.google.android.gms.signin.internal;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.g;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public final class zag extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zag> CREATOR = new g(28);
    private final List zaa;
    private final String zab;

    public zag(ArrayList arrayList, String str) {
        this.zaa = arrayList;
        this.zab = str;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        List<String> list = this.zaa;
        int i10 = u.i(parcel, 20293);
        if (list != null) {
            int i11 = u.i(parcel, 1);
            parcel.writeStringList(list);
            u.j(parcel, i11);
        }
        u.e(parcel, 2, this.zab);
        u.j(parcel, i10);
    }
}
