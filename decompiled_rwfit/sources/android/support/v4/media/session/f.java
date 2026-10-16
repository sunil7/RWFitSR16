package android.support.v4.media.session;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.ResultReceiver;

/* loaded from: classes.dex */
public final class f implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f329a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.f329a) {
            case 0:
                MediaSessionCompat$ResultReceiverWrapper mediaSessionCompat$ResultReceiverWrapper = new MediaSessionCompat$ResultReceiverWrapper();
                mediaSessionCompat$ResultReceiverWrapper.f312a = (ResultReceiver) ResultReceiver.CREATOR.createFromParcel(parcel);
                return mediaSessionCompat$ResultReceiverWrapper;
            case 1:
                return new MediaSessionCompat$QueueItem(parcel);
            case 2:
                return new MediaSessionCompat$Token(parcel.readParcelable(null), null);
            case 3:
                ParcelableVolumeInfo parcelableVolumeInfo = new ParcelableVolumeInfo();
                parcelableVolumeInfo.volumeType = parcel.readInt();
                parcelableVolumeInfo.controlType = parcel.readInt();
                parcelableVolumeInfo.maxVolume = parcel.readInt();
                parcelableVolumeInfo.currentVolume = parcel.readInt();
                parcelableVolumeInfo.audioStream = parcel.readInt();
                return parcelableVolumeInfo;
            default:
                return new PlaybackStateCompat(parcel);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f329a) {
            case 0:
                return new MediaSessionCompat$ResultReceiverWrapper[i3];
            case 1:
                return new MediaSessionCompat$QueueItem[i3];
            case 2:
                return new MediaSessionCompat$Token[i3];
            case 3:
                return new ParcelableVolumeInfo[i3];
            default:
                return new PlaybackStateCompat[i3];
        }
    }
}
