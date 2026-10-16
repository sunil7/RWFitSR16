package com.google.android.exoplayer2.source;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.Format;
import java.util.Arrays;
import u8.b;

/* loaded from: classes.dex */
public final class TrackGroup implements Parcelable {
    public static final Parcelable.Creator<TrackGroup> CREATOR = new b(13);
    private static final String TAG = "TrackGroup";
    private final Format[] formats;
    private int hashCode;
    public final int length;

    public TrackGroup(Parcel parcel) {
        int readInt = parcel.readInt();
        this.length = readInt;
        this.formats = new Format[readInt];
        for (int i3 = 0; i3 < this.length; i3++) {
            this.formats[i3] = (Format) parcel.readParcelable(Format.class.getClassLoader());
        }
    }

    public final Format a(int i3) {
        return this.formats[i3];
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && TrackGroup.class == obj.getClass()) {
            TrackGroup trackGroup = (TrackGroup) obj;
            if (this.length == trackGroup.length && Arrays.equals(this.formats, trackGroup.formats)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = 527 + Arrays.hashCode(this.formats);
        }
        return this.hashCode;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.length);
        for (int i10 = 0; i10 < this.length; i10++) {
            parcel.writeParcelable(this.formats[i10], 0);
        }
    }
}
