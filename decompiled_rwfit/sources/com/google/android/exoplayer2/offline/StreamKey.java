package com.google.android.exoplayer2.offline;

import android.os.Parcel;
import android.os.Parcelable;
import u8.b;

/* loaded from: classes.dex */
public final class StreamKey implements Comparable<StreamKey>, Parcelable {
    public static final Parcelable.Creator<StreamKey> CREATOR = new b(4);
    public final int groupIndex;
    public final int periodIndex;
    public final int streamIndex;

    @Deprecated
    public final int trackIndex;

    public StreamKey(Parcel parcel) {
        this.periodIndex = parcel.readInt();
        this.groupIndex = parcel.readInt();
        int readInt = parcel.readInt();
        this.streamIndex = readInt;
        this.trackIndex = readInt;
    }

    @Override // java.lang.Comparable
    public final int compareTo(StreamKey streamKey) {
        StreamKey streamKey2 = streamKey;
        int i3 = this.periodIndex - streamKey2.periodIndex;
        if (i3 != 0) {
            return i3;
        }
        int i10 = this.groupIndex - streamKey2.groupIndex;
        return i10 == 0 ? this.streamIndex - streamKey2.streamIndex : i10;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && StreamKey.class == obj.getClass()) {
            StreamKey streamKey = (StreamKey) obj;
            if (this.periodIndex == streamKey.periodIndex && this.groupIndex == streamKey.groupIndex && this.streamIndex == streamKey.streamIndex) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return (((this.periodIndex * 31) + this.groupIndex) * 31) + this.streamIndex;
    }

    public final String toString() {
        int i3 = this.periodIndex;
        int i10 = this.groupIndex;
        int i11 = this.streamIndex;
        StringBuilder sb2 = new StringBuilder(35);
        sb2.append(i3);
        sb2.append(".");
        sb2.append(i10);
        sb2.append(".");
        sb2.append(i11);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.periodIndex);
        parcel.writeInt(this.groupIndex);
        parcel.writeInt(this.streamIndex);
    }
}
