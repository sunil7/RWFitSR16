package com.google.android.exoplayer2.metadata.icy;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.Arrays;
import q9.o;
import r5.a;

/* loaded from: classes.dex */
public final class IcyInfo implements Metadata.Entry {
    public static final Parcelable.Creator<IcyInfo> CREATOR = new o(6);
    public final byte[] rawMetadata;
    public final String title;
    public final String url;

    public IcyInfo(Parcel parcel) {
        byte[] createByteArray = parcel.createByteArray();
        createByteArray.getClass();
        this.rawMetadata = createByteArray;
        this.title = parcel.readString();
        this.url = parcel.readString();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || IcyInfo.class != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.rawMetadata, ((IcyInfo) obj).rawMetadata);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.rawMetadata);
    }

    public final String toString() {
        String str = this.title;
        String str2 = this.url;
        return a.e(l0.v("ICY: title=\"", str, "\", url=\"", str2, "\", rawMetadata.length=\""), this.rawMetadata.length, "\"");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeByteArray(this.rawMetadata);
        parcel.writeString(this.title);
        parcel.writeString(this.url);
    }
}
