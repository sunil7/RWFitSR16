package com.google.android.gms.common.moduleinstall;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import q9.o;
import t9.a;

/* loaded from: classes.dex */
public class ModuleInstallStatusUpdate extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ModuleInstallStatusUpdate> CREATOR = new o(27);
    private final int zaa;
    private final int zab;
    private final Long zac;
    private final Long zad;
    private final int zae;
    private final a zaf;

    public ModuleInstallStatusUpdate(int i3, int i10, Long l3, Long l5, int i11) {
        this.zaa = i3;
        this.zab = i10;
        this.zac = l3;
        this.zad = l5;
        this.zae = i11;
        if (l3 == null || l5 == null || l5.longValue() == 0) {
            this.zaf = null;
            return;
        }
        long longValue = l5.longValue();
        a aVar = new a();
        if (longValue == 0) {
            throw new IllegalArgumentException("Given Long is zero");
        }
        this.zaf = aVar;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        int i11 = this.zaa;
        u.k(parcel, 1, 4);
        parcel.writeInt(i11);
        int i12 = this.zab;
        u.k(parcel, 2, 4);
        parcel.writeInt(i12);
        Long l3 = this.zac;
        if (l3 != null) {
            u.k(parcel, 3, 8);
            parcel.writeLong(l3.longValue());
        }
        Long l5 = this.zad;
        if (l5 != null) {
            u.k(parcel, 4, 8);
            parcel.writeLong(l5.longValue());
        }
        int i13 = this.zae;
        u.k(parcel, 5, 4);
        parcel.writeInt(i13);
        u.j(parcel, i10);
    }
}
