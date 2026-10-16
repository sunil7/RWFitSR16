package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Nullable;

/* loaded from: classes.dex */
public class TelemetryData extends AbstractSafeParcelable {
    public static final Parcelable.Creator<TelemetryData> CREATOR = new d(24);
    private final int zaa;

    @Nullable
    private List zab;

    public TelemetryData(int i3, List list) {
        this.zaa = i3;
        this.zab = list;
    }

    public final int b() {
        return this.zaa;
    }

    public final List h() {
        return this.zab;
    }

    public final void i(MethodInvocation methodInvocation) {
        if (this.zab == null) {
            this.zab = new ArrayList();
        }
        this.zab.add(methodInvocation);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = u.i(parcel, 20293);
        int i11 = this.zaa;
        u.k(parcel, 1, 4);
        parcel.writeInt(i11);
        u.h(parcel, 2, this.zab);
        u.j(parcel, i10);
    }
}
