package u1;

import android.media.MediaDataSource;
import android.media.MediaMetadataRetriever;

/* loaded from: classes.dex */
public abstract class i {
    public static void a(MediaMetadataRetriever mediaMetadataRetriever, MediaDataSource mediaDataSource) {
        mediaMetadataRetriever.setDataSource(mediaDataSource);
    }
}
