package android.support.v4.media;

import android.annotation.SuppressLint;
import android.media.MediaMetadata;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

@SuppressLint({"BanParcelableUsage"})
/* loaded from: classes.dex */
public final class MediaMetadataCompat implements Parcelable {
    public static final Parcelable.Creator<MediaMetadataCompat> CREATOR;
    public static final String METADATA_KEY_ADVERTISEMENT = "android.media.metadata.ADVERTISEMENT";
    public static final String METADATA_KEY_ALBUM = "android.media.metadata.ALBUM";
    public static final String METADATA_KEY_ALBUM_ART = "android.media.metadata.ALBUM_ART";
    public static final String METADATA_KEY_ALBUM_ARTIST = "android.media.metadata.ALBUM_ARTIST";
    public static final String METADATA_KEY_ALBUM_ART_URI = "android.media.metadata.ALBUM_ART_URI";
    public static final String METADATA_KEY_ART = "android.media.metadata.ART";
    public static final String METADATA_KEY_ARTIST = "android.media.metadata.ARTIST";
    public static final String METADATA_KEY_ART_URI = "android.media.metadata.ART_URI";
    public static final String METADATA_KEY_AUTHOR = "android.media.metadata.AUTHOR";
    public static final String METADATA_KEY_BT_FOLDER_TYPE = "android.media.metadata.BT_FOLDER_TYPE";
    public static final String METADATA_KEY_COMPILATION = "android.media.metadata.COMPILATION";
    public static final String METADATA_KEY_COMPOSER = "android.media.metadata.COMPOSER";
    public static final String METADATA_KEY_DATE = "android.media.metadata.DATE";
    public static final String METADATA_KEY_DISC_NUMBER = "android.media.metadata.DISC_NUMBER";
    public static final String METADATA_KEY_DISPLAY_DESCRIPTION = "android.media.metadata.DISPLAY_DESCRIPTION";
    public static final String METADATA_KEY_DISPLAY_ICON = "android.media.metadata.DISPLAY_ICON";
    public static final String METADATA_KEY_DISPLAY_ICON_URI = "android.media.metadata.DISPLAY_ICON_URI";
    public static final String METADATA_KEY_DISPLAY_SUBTITLE = "android.media.metadata.DISPLAY_SUBTITLE";
    public static final String METADATA_KEY_DISPLAY_TITLE = "android.media.metadata.DISPLAY_TITLE";
    public static final String METADATA_KEY_DOWNLOAD_STATUS = "android.media.metadata.DOWNLOAD_STATUS";
    public static final String METADATA_KEY_DURATION = "android.media.metadata.DURATION";
    public static final String METADATA_KEY_GENRE = "android.media.metadata.GENRE";
    public static final String METADATA_KEY_MEDIA_ID = "android.media.metadata.MEDIA_ID";
    public static final String METADATA_KEY_MEDIA_URI = "android.media.metadata.MEDIA_URI";
    public static final String METADATA_KEY_NUM_TRACKS = "android.media.metadata.NUM_TRACKS";
    public static final String METADATA_KEY_RATING = "android.media.metadata.RATING";
    public static final String METADATA_KEY_TITLE = "android.media.metadata.TITLE";
    public static final String METADATA_KEY_TRACK_NUMBER = "android.media.metadata.TRACK_NUMBER";
    public static final String METADATA_KEY_USER_RATING = "android.media.metadata.USER_RATING";
    public static final String METADATA_KEY_WRITER = "android.media.metadata.WRITER";
    public static final String METADATA_KEY_YEAR = "android.media.metadata.YEAR";
    private static final String[] PREFERRED_BITMAP_ORDER;
    private static final String[] PREFERRED_DESCRIPTION_ORDER;
    private static final String[] PREFERRED_URI_ORDER;
    private static final String TAG = "MediaMetadata";

    /* renamed from: a, reason: collision with root package name */
    public final Bundle f299a;
    private MediaDescriptionCompat mDescription;
    private MediaMetadata mMetadataFwk;

    static {
        m0.b bVar = new m0.b();
        bVar.put(METADATA_KEY_TITLE, 1);
        bVar.put(METADATA_KEY_ARTIST, 1);
        bVar.put(METADATA_KEY_DURATION, 0);
        bVar.put(METADATA_KEY_ALBUM, 1);
        bVar.put(METADATA_KEY_AUTHOR, 1);
        bVar.put(METADATA_KEY_WRITER, 1);
        bVar.put(METADATA_KEY_COMPOSER, 1);
        bVar.put(METADATA_KEY_COMPILATION, 1);
        bVar.put(METADATA_KEY_DATE, 1);
        bVar.put(METADATA_KEY_YEAR, 0);
        bVar.put(METADATA_KEY_GENRE, 1);
        bVar.put(METADATA_KEY_TRACK_NUMBER, 0);
        bVar.put(METADATA_KEY_NUM_TRACKS, 0);
        bVar.put(METADATA_KEY_DISC_NUMBER, 0);
        bVar.put(METADATA_KEY_ALBUM_ARTIST, 1);
        bVar.put(METADATA_KEY_ART, 2);
        bVar.put(METADATA_KEY_ART_URI, 1);
        bVar.put(METADATA_KEY_ALBUM_ART, 2);
        bVar.put(METADATA_KEY_ALBUM_ART_URI, 1);
        bVar.put(METADATA_KEY_USER_RATING, 3);
        bVar.put(METADATA_KEY_RATING, 3);
        bVar.put(METADATA_KEY_DISPLAY_TITLE, 1);
        bVar.put(METADATA_KEY_DISPLAY_SUBTITLE, 1);
        bVar.put(METADATA_KEY_DISPLAY_DESCRIPTION, 1);
        bVar.put(METADATA_KEY_DISPLAY_ICON, 2);
        bVar.put(METADATA_KEY_DISPLAY_ICON_URI, 1);
        bVar.put(METADATA_KEY_MEDIA_ID, 1);
        bVar.put(METADATA_KEY_BT_FOLDER_TYPE, 0);
        bVar.put(METADATA_KEY_MEDIA_URI, 1);
        bVar.put(METADATA_KEY_ADVERTISEMENT, 0);
        bVar.put(METADATA_KEY_DOWNLOAD_STATUS, 0);
        PREFERRED_DESCRIPTION_ORDER = new String[]{METADATA_KEY_TITLE, METADATA_KEY_ARTIST, METADATA_KEY_ALBUM, METADATA_KEY_ALBUM_ARTIST, METADATA_KEY_WRITER, METADATA_KEY_AUTHOR, METADATA_KEY_COMPOSER};
        PREFERRED_BITMAP_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON, METADATA_KEY_ART, METADATA_KEY_ALBUM_ART};
        PREFERRED_URI_ORDER = new String[]{METADATA_KEY_DISPLAY_ICON_URI, METADATA_KEY_ART_URI, METADATA_KEY_ALBUM_ART_URI};
        CREATOR = new androidx.databinding.g(4);
    }

    public MediaMetadataCompat(Parcel parcel) {
        this.f299a = parcel.readBundle(android.support.v4.media.session.g.class.getClassLoader());
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        parcel.writeBundle(this.f299a);
    }
}
