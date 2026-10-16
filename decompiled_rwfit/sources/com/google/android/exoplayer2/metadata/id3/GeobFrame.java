package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import i9.g;
import java.util.Arrays;
import q9.o;
import r5.a;

/* loaded from: classes.dex */
public final class GeobFrame extends Id3Frame {
    public static final Parcelable.Creator<GeobFrame> CREATOR = new o(12);
    public static final String ID = "GEOB";
    public final byte[] data;
    public final String description;
    public final String filename;
    public final String mimeType;

    public GeobFrame(Parcel parcel) {
        super(ID);
        String readString = parcel.readString();
        int i3 = g.f14378a;
        this.mimeType = readString;
        this.filename = parcel.readString();
        this.description = parcel.readString();
        this.data = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && GeobFrame.class == obj.getClass()) {
            GeobFrame geobFrame = (GeobFrame) obj;
            if (g.a(this.mimeType, geobFrame.mimeType) && g.a(this.filename, geobFrame.filename) && g.a(this.description, geobFrame.description) && Arrays.equals(this.data, geobFrame.data)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.mimeType;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.filename;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.description;
        return Arrays.hashCode(this.data) + ((hashCode2 + (str3 != null ? str3.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        String str = this.f8889id;
        String str2 = this.mimeType;
        String str3 = this.filename;
        String str4 = this.description;
        StringBuilder g10 = a.g(a.a(a.a(a.a(a.a(36, str), str2), str3), str4), str, ": mimeType=", str2, ", filename=");
        g10.append(str3);
        g10.append(", description=");
        g10.append(str4);
        return g10.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.filename);
        parcel.writeString(this.description);
        parcel.writeByteArray(this.data);
    }
}
