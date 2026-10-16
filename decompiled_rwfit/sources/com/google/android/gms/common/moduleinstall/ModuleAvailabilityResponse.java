package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import q9.o;

/* loaded from: classes.dex */
public class ModuleAvailabilityResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleAvailabilityResponse> CREATOR = new o(24);
    private final boolean zaa;
    private final int zab;

    public ModuleAvailabilityResponse(boolean z5, int i3) {
        this.zaa = z5;
        this.zab = i3;
    }

    public final boolean b() {
        return this.zaa;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        boolean z5 = this.zaa;
        u.k(parcel, 1, 4);
        parcel.writeInt(z5 ? 1 : 0);
        int i11 = this.zab;
        u.k(parcel, 2, 4);
        parcel.writeInt(i11);
        u.j(parcel, i10);
    }
}
