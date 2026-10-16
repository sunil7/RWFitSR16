package com.google.android.exoplayer2.metadata.flac;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import ha.d;
import i9.g;
import r5.a;

/* loaded from: classes.dex */
public final class VorbisComment implements Metadata.Entry {
    public static final Parcelable.Creator<VorbisComment> CREATOR = new d(22);
    public final String key;
    public final String value;

    public VorbisComment(Parcel parcel) {
        String readString = parcel.readString();
        int i3 = g.f14378a;
        this.key = readString;
        this.value = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && VorbisComment.class == obj.getClass()) {
            VorbisComment vorbisComment = (VorbisComment) obj;
            if (this.key.equals(vorbisComment.key) && this.value.equals(vorbisComment.value)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.value.hashCode() + l0.d(527, 31, this.key);
    }

    public final String toString() {
        String str = this.key;
        String str2 = this.value;
        StringBuilder sb2 = new StringBuilder(a.a(a.a(5, str), str2));
        sb2.append("VC: ");
        sb2.append(str);
        sb2.append("=");
        sb2.append(str2);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeString(this.key);
        parcel.writeString(this.value);
    }
}
