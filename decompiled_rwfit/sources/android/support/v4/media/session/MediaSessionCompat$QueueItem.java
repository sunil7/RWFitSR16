package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.MediaSession;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaDescriptionCompat;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaSessionCompat$QueueItem implements Parcelable {
    public static final Parcelable.Creator<MediaSessionCompat$QueueItem> CREATOR = new f(1);
    public static final int UNKNOWN_ID = -1;
    private final MediaDescriptionCompat mDescription;
    private final long mId;
    private MediaSession.QueueItem mItemFwk;

    public MediaSessionCompat$QueueItem(Parcel parcel) {
        this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
        this.mId = parcel.readLong();
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("MediaSession.QueueItem {Description=");
        sb2.append(this.mDescription);
        sb2.append(", Id=");
        return e.n(sb2, this.mId, " }");
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        this.mDescription.writeToParcel(parcel, i3);
        parcel.writeLong(this.mId);
    }
}
