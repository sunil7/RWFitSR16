package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import i9.g;
import q9.o;
import r5.a;

/* loaded from: classes.dex */
public final class InternalFrame extends Id3Frame {
    public static final Parcelable.Creator<InternalFrame> CREATOR = new o(13);
    public static final String ID = "----";
    public final String description;
    public final String domain;
    public final String text;

    public InternalFrame(Parcel parcel) {
        super(ID);
        String readString = parcel.readString();
        int i3 = g.f14378a;
        this.domain = readString;
        this.description = parcel.readString();
        this.text = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && InternalFrame.class == obj.getClass()) {
            InternalFrame internalFrame = (InternalFrame) obj;
            if (g.a(this.description, internalFrame.description) && g.a(this.domain, internalFrame.domain) && g.a(this.text, internalFrame.text)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.domain;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        String str = this.f8889id;
        String str2 = this.domain;
        String str3 = this.description;
        StringBuilder g10 = a.g(a.a(a.a(a.a(23, str), str2), str3), str, ": domain=", str2, ", description=");
        g10.append(str3);
        return g10.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f8889id);
        parcel.writeString(this.domain);
        parcel.writeString(this.text);
    }
}
