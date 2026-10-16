package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.internal.mlkit_vision_common.u;
import ha.d;
import q9.n;

/* loaded from: classes.dex */
public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new d(23);
    public final String packageName;
    public final int uid;

    public ClientIdentity(int i3, String str) {
        this.uid = i3;
        this.packageName = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.uid == this.uid && n.h(clientIdentity.packageName, this.packageName);
    }

    public final int hashCode() {
        return this.uid;
    }

    public final String toString() {
        return this.uid + ":" + this.packageName;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        int i10 = this.uid;
        int i11 = u.i(parcel, 20293);
        u.k(parcel, 1, 4);
        parcel.writeInt(i10);
        u.e(parcel, 2, this.packageName);
        u.j(parcel, i11);
    }
}
