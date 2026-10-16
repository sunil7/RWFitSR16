package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import i9.g;
import java.util.Arrays;
import q9.o;
import r5.a;

/* loaded from: classes.dex */
public final class ApicFrame extends Id3Frame {
    public static final Parcelable.Creator<ApicFrame> CREATOR = new o(7);
    public static final String ID = "APIC";
    public final String description;
    public final String mimeType;
    public final byte[] pictureData;
    public final int pictureType;

    public ApicFrame(Parcel parcel) {
        super(ID);
        String readString = parcel.readString();
        int i3 = g.f14378a;
        this.mimeType = readString;
        this.description = parcel.readString();
        this.pictureType = parcel.readInt();
        this.pictureData = parcel.createByteArray();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && ApicFrame.class == obj.getClass()) {
            ApicFrame apicFrame = (ApicFrame) obj;
            if (this.pictureType == apicFrame.pictureType && g.a(this.mimeType, apicFrame.mimeType) && g.a(this.description, apicFrame.description) && Arrays.equals(this.pictureData, apicFrame.pictureData)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = (527 + this.pictureType) * 31;
        String str = this.mimeType;
        int hashCode = (i3 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        return Arrays.hashCode(this.pictureData) + ((hashCode + (str2 != null ? str2.hashCode() : 0)) * 31);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        String str = this.f8889id;
        String str2 = this.mimeType;
        String str3 = this.description;
        StringBuilder g10 = a.g(a.a(a.a(a.a(25, str), str2), str3), str, ": mimeType=", str2, ", description=");
        g10.append(str3);
        return g10.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.pictureType);
        parcel.writeByteArray(this.pictureData);
    }
}
