package android.support.v4.media;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.os.ResultReceiver;

/* loaded from: classes.dex */
class MediaBrowserCompat$ItemReceiver extends ResultReceiver {
    private final d mCallback;
    private final String mMediaId;

    @Override // android.support.v4.os.ResultReceiver
    public final void a(int i3, Bundle bundle) {
        if (bundle != null) {
            bundle = android.support.v4.media.session.g.b(bundle);
        }
        if (i3 != 0) {
            throw null;
        }
        if (bundle == null) {
            throw null;
        }
        if (!bundle.containsKey("media_item")) {
            throw null;
        }
        Parcelable parcelable = bundle.getParcelable("media_item");
        if (parcelable != null && !(parcelable instanceof MediaBrowserCompat$MediaItem)) {
            throw null;
        }
        throw null;
    }
}
