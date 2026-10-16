package com.google.android.exoplayer2.metadata.mp4;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.metadata.Metadata;
import q9.o;

/* loaded from: classes.dex */
public final class MotionPhotoMetadata implements Metadata.Entry {
    public static final Parcelable.Creator<MotionPhotoMetadata> CREATOR = new o(22);
    public final long photoPresentationTimestampUs;
    public final long photoSize;
    public final long photoStartPosition;
    public final long videoSize;
    public final long videoStartPosition;

    public MotionPhotoMetadata(Parcel parcel) {
        this.photoStartPosition = parcel.readLong();
        this.photoSize = parcel.readLong();
        this.photoPresentationTimestampUs = parcel.readLong();
        this.videoStartPosition = parcel.readLong();
        this.videoSize = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && MotionPhotoMetadata.class == obj.getClass()) {
            MotionPhotoMetadata motionPhotoMetadata = (MotionPhotoMetadata) obj;
            if (this.photoStartPosition == motionPhotoMetadata.photoStartPosition && this.photoSize == motionPhotoMetadata.photoSize && this.photoPresentationTimestampUs == motionPhotoMetadata.photoPresentationTimestampUs && this.videoStartPosition == motionPhotoMetadata.videoStartPosition && this.videoSize == motionPhotoMetadata.videoSize) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        long j4 = this.photoStartPosition;
        long j10 = this.photoSize;
        int i3 = (((int) (j10 ^ (j10 >>> 32))) + ((((int) (j4 ^ (j4 >>> 32))) + 527) * 31)) * 31;
        long j11 = this.photoPresentationTimestampUs;
        int i10 = (((int) (j11 ^ (j11 >>> 32))) + i3) * 31;
        long j12 = this.videoStartPosition;
        int i11 = (((int) (j12 ^ (j12 >>> 32))) + i10) * 31;
        long j13 = this.videoSize;
        return ((int) (j13 ^ (j13 >>> 32))) + i11;
    }

    public final String toString() {
        long j4 = this.photoStartPosition;
        long j10 = this.photoSize;
        long j11 = this.photoPresentationTimestampUs;
        long j12 = this.videoStartPosition;
        long j13 = this.videoSize;
        StringBuilder sb2 = new StringBuilder(218);
        sb2.append("Motion photo metadata: photoStartPosition=");
        sb2.append(j4);
        sb2.append(", photoSize=");
        sb2.append(j10);
        sb2.append(", photoPresentationTimestampUs=");
        sb2.append(j11);
        sb2.append(", videoStartPosition=");
        sb2.append(j12);
        sb2.append(", videoSize=");
        sb2.append(j13);
        return sb2.toString();
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeLong(this.photoStartPosition);
        parcel.writeLong(this.photoSize);
        parcel.writeLong(this.photoPresentationTimestampUs);
        parcel.writeLong(this.videoStartPosition);
        parcel.writeLong(this.videoSize);
    }
}
