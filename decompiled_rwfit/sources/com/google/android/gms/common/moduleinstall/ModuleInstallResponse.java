package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import q9.o;

/* loaded from: classes.dex */
public class ModuleInstallResponse extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallResponse> CREATOR = new o(26);
    private final int zaa;
    private final boolean zab;

    public ModuleInstallResponse(int i3, boolean z5) {
        this.zaa = i3;
        this.zab = z5;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        int i11 = this.zaa;
        u.k(parcel, 1, 4);
        parcel.writeInt(i11);
        boolean z5 = this.zab;
        u.k(parcel, 2, 4);
        parcel.writeInt(z5 ? 1 : 0);
        u.j(parcel, i10);
    }
}
