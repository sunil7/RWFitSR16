package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import q9.o;

/* loaded from: classes.dex */
public final class SmtaMetadataEntry implements Metadata.Entry {
    public static final Parcelable.Creator<SmtaMetadataEntry> CREATOR = new o(23);
    public final float captureFrameRate;
    public final int svcTemporalLayerCount;

    public SmtaMetadataEntry(Parcel parcel) {
        this.captureFrameRate = parcel.readFloat();
        this.svcTemporalLayerCount = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && SmtaMetadataEntry.class == obj.getClass()) {
            SmtaMetadataEntry smtaMetadataEntry = (SmtaMetadataEntry) obj;
            if (this.captureFrameRate == smtaMetadataEntry.captureFrameRate && this.svcTemporalLayerCount == smtaMetadataEntry.svcTemporalLayerCount) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((Float.valueOf(this.captureFrameRate).hashCode() + 527) * 31) + this.svcTemporalLayerCount;
    }

    public final String toString() {
        float f2 = this.captureFrameRate;
        int i3 = this.svcTemporalLayerCount;
        StringBuilder sb2 = new StringBuilder(73);
        sb2.append("smta: captureFrameRate=");
        sb2.append(f2);
        sb2.append(", svcTemporalLayerCount=");
        sb2.append(i3);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeFloat(this.captureFrameRate);
        parcel.writeInt(this.svcTemporalLayerCount);
    }
}
