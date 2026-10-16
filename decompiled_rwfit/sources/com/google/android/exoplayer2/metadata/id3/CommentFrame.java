package com.google.android.exoplayer2.metadata.id3;

import android.os.Parcel;
import android.os.Parcelable;
import i9.g;
import q9.o;
import r5.a;

/* loaded from: classes.dex */
public final class CommentFrame extends Id3Frame {
    public static final Parcelable.Creator<CommentFrame> CREATOR = new o(11);
    public static final String ID = "COMM";
    public final String description;
    public final String language;
    public final String text;

    public CommentFrame(Parcel parcel) {
        super(ID);
        String readString = parcel.readString();
        int i3 = g.f14378a;
        this.language = readString;
        this.description = parcel.readString();
        this.text = parcel.readString();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && CommentFrame.class == obj.getClass()) {
            CommentFrame commentFrame = (CommentFrame) obj;
            if (g.a(this.description, commentFrame.description) && g.a(this.language, commentFrame.language) && g.a(this.text, commentFrame.text)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        String str = this.language;
        int hashCode = (527 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        int hashCode2 = (hashCode + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.text;
        return hashCode2 + (str3 != null ? str3.hashCode() : 0);
    }

    @Override // com.google.android.exoplayer2.metadata.id3.Id3Frame
    public final String toString() {
        String str = this.f8889id;
        String str2 = this.language;
        String str3 = this.description;
        StringBuilder g10 = a.g(a.a(a.a(a.a(25, str), str2), str3), str, ": language=", str2, ", description=");
        g10.append(str3);
        return g10.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.f8889id);
        parcel.writeString(this.language);
        parcel.writeString(this.text);
    }
}
