package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.g;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class DefaultTrackSelector$SelectionOverride implements Parcelable {
    public static final Parcelable.Creator<DefaultTrackSelector$SelectionOverride> CREATOR = new g(25);
    public final int groupIndex;
    public final int length;
    public final int[] tracks;
    public final int type;

    public DefaultTrackSelector$SelectionOverride(int i3, int... iArr) {
        this.groupIndex = i3;
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.tracks = copyOf;
        this.length = iArr.length;
        this.type = 0;
        Arrays.sort(copyOf);
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DefaultTrackSelector$SelectionOverride.class == obj.getClass()) {
            DefaultTrackSelector$SelectionOverride defaultTrackSelector$SelectionOverride = (DefaultTrackSelector$SelectionOverride) obj;
            if (this.groupIndex == defaultTrackSelector$SelectionOverride.groupIndex && Arrays.equals(this.tracks, defaultTrackSelector$SelectionOverride.tracks) && this.type == defaultTrackSelector$SelectionOverride.type) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Arrays.hashCode(this.tracks) + (this.groupIndex * 31)) * 31) + this.type;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeInt(this.groupIndex);
        parcel.writeInt(this.tracks.length);
        parcel.writeIntArray(this.tracks);
        parcel.writeInt(this.type);
    }

    public DefaultTrackSelector$SelectionOverride(Parcel parcel) {
        this.groupIndex = parcel.readInt();
        int readByte = parcel.readByte();
        this.length = readByte;
        int[] iArr = new int[readByte];
        this.tracks = iArr;
        parcel.readIntArray(iArr);
        this.type = parcel.readInt();
    }
}
