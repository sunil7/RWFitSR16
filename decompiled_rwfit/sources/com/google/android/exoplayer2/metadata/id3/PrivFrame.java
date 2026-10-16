package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import i9.g;
import java.util.Arrays;
import q9.o;
import r5.a;

/* loaded from: classes.dex */
public final class PrivFrame extends Id3Frame {
    public static final Parcelable.Creator<PrivFrame> CREATOR = new o(15);
    public static final String ID = "PRIV";
    public final String owner;
    public final byte[] privateData;

    public PrivFrame(Parcel parcel) {
        super(ID);
        String readString = parcel.readString();
        int i3 = g.f14378a;
        this.owner = readString;
        this.privateData = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && PrivFrame.class == obj.getClass()) {
            PrivFrame privFrame = (PrivFrame) obj;
            if (g.a(this.owner, privFrame.owner) && Arrays.equals(this.privateData, privFrame.privateData)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.owner;
        return Arrays.hashCode(this.privateData) + ((527 + (str != null ? str.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        String str = this.f8889id;
        String str2 = this.owner;
        return a.b(a.a(a.a(8, str), str2), str, ": owner=", str2);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.owner);
        parcel.writeByteArray(this.privateData);
    }
}
