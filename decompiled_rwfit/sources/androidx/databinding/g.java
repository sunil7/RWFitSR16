package androidx.databinding;

import android.app.PendingIntent;
import android.content.Intent;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v4.media.MediaBrowserCompat$MediaItem;
import android.support.v4.media.MediaDescriptionCompat;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.os.ResultReceiver;
import androidx.activity.result.ActivityResult;
import androidx.activity.result.IntentSenderRequest;
import com.autonavi.aps.amapapi.config.Const;
import com.dh.imagepick.crop.bean.ImageItem;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$SelectionOverride;
import com.google.android.exoplayer2.trackselection.TrackSelectionParameters;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.zat;
import com.google.android.gms.internal.mlkit_vision_common.t;
import com.google.android.gms.signin.internal.zaa;
import com.google.android.gms.signin.internal.zag;
import com.google.android.gms.signin.internal.zai;
import com.google.android.material.internal.ParcelableSparseBooleanArray;
import com.google.android.material.internal.ParcelableSparseIntArray;
import com.tencent.mm.opensdk.modelmsg.WXMediaMessage;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class g implements Parcelable.Creator {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1986a;

    public /* synthetic */ g(int i3) {
        this.f1986a = i3;
    }

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(final Parcel parcel) {
        b.b bVar = null;
        zat zatVar = null;
        Intent intent = null;
        Uri uri = null;
        String str = null;
        String str2 = null;
        int i3 = 0;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        switch (this.f1986a) {
            case 0:
                return new ObservableParcelable(parcel.readParcelable(g.class.getClassLoader()));
            case 1:
                return new HlsTrackMetadataEntry(parcel);
            case 2:
                return new Parcelable(parcel) { // from class: android.support.v4.media.MediaBrowserCompat$MediaItem
                    public static final Parcelable.Creator<MediaBrowserCompat$MediaItem> CREATOR = new androidx.databinding.g(2);
                    public static final int FLAG_BROWSABLE = 1;
                    public static final int FLAG_PLAYABLE = 2;
                    private final MediaDescriptionCompat mDescription;
                    private final int mFlags;

                    {
                        this.mFlags = parcel.readInt();
                        this.mDescription = MediaDescriptionCompat.CREATOR.createFromParcel(parcel);
                    }

                    @Override // android.os.Parcelable
                    public final int describeContents() {
                        return 0;
                    }

                    public final String toString() {
                        return "MediaItem{mFlags=" + this.mFlags + ", mDescription=" + this.mDescription + '}';
                    }

                    @Override // android.os.Parcelable
                    public final void writeToParcel(Parcel parcel2, int i13) {
                        parcel2.writeInt(this.mFlags);
                        this.mDescription.writeToParcel(parcel2, i13);
                    }
                };
            case 3:
                return MediaDescriptionCompat.a(MediaDescription.CREATOR.createFromParcel(parcel));
            case 4:
                return new MediaMetadataCompat(parcel);
            case 5:
                return new RatingCompat(parcel.readInt(), parcel.readFloat());
            case 6:
                return new ActivityResult(parcel);
            case 7:
                return new IntentSenderRequest(parcel);
            case 8:
                return new ObservableBoolean(parcel.readInt() == 1);
            case 9:
                return new ObservableByte(parcel.readByte());
            case 10:
                return new ObservableChar((char) parcel.readInt());
            case 11:
                return new ObservableDouble(parcel.readDouble());
            case 12:
                return new ObservableFloat(parcel.readFloat());
            case 13:
                return new ObservableInt(parcel.readInt());
            case 14:
                return new ObservableLong(parcel.readLong());
            case 15:
                return new ObservableShort((short) parcel.readInt());
            case 16:
                ResultReceiver resultReceiver = new ResultReceiver();
                IBinder readStrongBinder = parcel.readStrongBinder();
                int i13 = b.c.f3039b;
                if (readStrongBinder != null) {
                    IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("android.support.v4.os.IResultReceiver");
                    if (queryLocalInterface == null || !(queryLocalInterface instanceof b.b)) {
                        b.a aVar = new b.a();
                        aVar.f3038a = readStrongBinder;
                        bVar = aVar;
                    } else {
                        bVar = (b.b) queryLocalInterface;
                    }
                }
                resultReceiver.f330a = bVar;
                return resultReceiver;
            case 17:
                return new Format(parcel);
            case 18:
                int t8 = t.t(parcel);
                while (parcel.dataPosition() < t8) {
                    int readInt = parcel.readInt();
                    char c9 = (char) readInt;
                    if (c9 == 1) {
                        i12 = t.o(parcel, readInt);
                    } else if (c9 != 2) {
                        t.s(parcel, readInt);
                    } else {
                        str2 = t.g(parcel, readInt);
                    }
                }
                t.k(parcel, t8);
                return new Scope(i12, str2);
            case 19:
                int t10 = t.t(parcel);
                ConnectionResult connectionResult = null;
                int i14 = 0;
                PendingIntent pendingIntent = null;
                while (parcel.dataPosition() < t10) {
                    int readInt2 = parcel.readInt();
                    char c10 = (char) readInt2;
                    if (c10 == 1) {
                        i14 = t.o(parcel, readInt2);
                    } else if (c10 == 2) {
                        str = t.g(parcel, readInt2);
                    } else if (c10 == 3) {
                        pendingIntent = (PendingIntent) t.f(parcel, readInt2, PendingIntent.CREATOR);
                    } else if (c10 != 4) {
                        t.s(parcel, readInt2);
                    } else {
                        connectionResult = (ConnectionResult) t.f(parcel, readInt2, ConnectionResult.CREATOR);
                    }
                }
                t.k(parcel, t10);
                return new Status(i14, str, pendingIntent, connectionResult);
            case 20:
                int t11 = t.t(parcel);
                int i15 = 0;
                int i16 = 0;
                while (parcel.dataPosition() < t11) {
                    int readInt3 = parcel.readInt();
                    char c11 = (char) readInt3;
                    if (c11 == 1) {
                        i11 = t.o(parcel, readInt3);
                    } else if (c11 == 2) {
                        uri = (Uri) t.f(parcel, readInt3, Uri.CREATOR);
                    } else if (c11 == 3) {
                        i15 = t.o(parcel, readInt3);
                    } else if (c11 != 4) {
                        t.s(parcel, readInt3);
                    } else {
                        i16 = t.o(parcel, readInt3);
                    }
                }
                t.k(parcel, t11);
                return new WebImage(i11, uri, i15, i16);
            case 21:
                int readInt4 = parcel.readInt();
                ParcelableSparseBooleanArray parcelableSparseBooleanArray = new ParcelableSparseBooleanArray(readInt4);
                int[] iArr = new int[readInt4];
                boolean[] zArr = new boolean[readInt4];
                parcel.readIntArray(iArr);
                parcel.readBooleanArray(zArr);
                for (int i17 = 0; i17 < readInt4; i17++) {
                    parcelableSparseBooleanArray.put(iArr[i17], zArr[i17]);
                }
                return parcelableSparseBooleanArray;
            case 22:
                int readInt5 = parcel.readInt();
                ParcelableSparseIntArray parcelableSparseIntArray = new ParcelableSparseIntArray(readInt5);
                int[] iArr2 = new int[readInt5];
                int[] iArr3 = new int[readInt5];
                parcel.readIntArray(iArr2);
                parcel.readIntArray(iArr3);
                for (int i18 = 0; i18 < readInt5; i18++) {
                    parcelableSparseIntArray.put(iArr2[i18], iArr3[i18]);
                }
                return parcelableSparseIntArray;
            case 23:
                return new ImageItem(parcel);
            case 24:
                return new DefaultTrackSelector$Parameters(parcel);
            case 25:
                return new DefaultTrackSelector$SelectionOverride(parcel);
            case 26:
                return new TrackSelectionParameters(parcel);
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                int t12 = t.t(parcel);
                int i19 = 0;
                while (parcel.dataPosition() < t12) {
                    int readInt6 = parcel.readInt();
                    char c12 = (char) readInt6;
                    if (c12 == 1) {
                        i10 = t.o(parcel, readInt6);
                    } else if (c12 == 2) {
                        i19 = t.o(parcel, readInt6);
                    } else if (c12 != 3) {
                        t.s(parcel, readInt6);
                    } else {
                        intent = (Intent) t.f(parcel, readInt6, Intent.CREATOR);
                    }
                }
                t.k(parcel, t12);
                return new zaa(i10, i19, intent);
            case Const.ANDROID_VERSION_28 /* 28 */:
                int t13 = t.t(parcel);
                ArrayList<String> arrayList = null;
                String str3 = null;
                while (parcel.dataPosition() < t13) {
                    int readInt7 = parcel.readInt();
                    char c13 = (char) readInt7;
                    if (c13 == 1) {
                        int r = t.r(parcel, readInt7);
                        int dataPosition = parcel.dataPosition();
                        if (r == 0) {
                            arrayList = null;
                        } else {
                            ArrayList<String> createStringArrayList = parcel.createStringArrayList();
                            parcel.setDataPosition(dataPosition + r);
                            arrayList = createStringArrayList;
                        }
                    } else if (c13 != 2) {
                        t.s(parcel, readInt7);
                    } else {
                        str3 = t.g(parcel, readInt7);
                    }
                }
                t.k(parcel, t13);
                return new zag(arrayList, str3);
            default:
                int t14 = t.t(parcel);
                while (parcel.dataPosition() < t14) {
                    int readInt8 = parcel.readInt();
                    char c14 = (char) readInt8;
                    if (c14 == 1) {
                        i3 = t.o(parcel, readInt8);
                    } else if (c14 != 2) {
                        t.s(parcel, readInt8);
                    } else {
                        zatVar = (zat) t.f(parcel, readInt8, zat.CREATOR);
                    }
                }
                t.k(parcel, t14);
                return new zai(i3, zatVar);
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        switch (this.f1986a) {
            case 0:
                return new ObservableParcelable[i3];
            case 1:
                return new HlsTrackMetadataEntry[i3];
            case 2:
                return new MediaBrowserCompat$MediaItem[i3];
            case 3:
                return new MediaDescriptionCompat[i3];
            case 4:
                return new MediaMetadataCompat[i3];
            case 5:
                return new RatingCompat[i3];
            case 6:
                return new ActivityResult[i3];
            case 7:
                return new IntentSenderRequest[i3];
            case 8:
                return new ObservableBoolean[i3];
            case 9:
                return new ObservableByte[i3];
            case 10:
                return new ObservableChar[i3];
            case 11:
                return new ObservableDouble[i3];
            case 12:
                return new ObservableFloat[i3];
            case 13:
                return new ObservableInt[i3];
            case 14:
                return new ObservableLong[i3];
            case 15:
                return new ObservableShort[i3];
            case 16:
                return new ResultReceiver[i3];
            case 17:
                return new Format[i3];
            case 18:
                return new Scope[i3];
            case 19:
                return new Status[i3];
            case 20:
                return new WebImage[i3];
            case 21:
                return new ParcelableSparseBooleanArray[i3];
            case 22:
                return new ParcelableSparseIntArray[i3];
            case 23:
                return new ImageItem[i3];
            case 24:
                return new DefaultTrackSelector$Parameters[i3];
            case 25:
                return new DefaultTrackSelector$SelectionOverride[i3];
            case 26:
                return new TrackSelectionParameters[i3];
            case WXMediaMessage.IMediaObject.TYPE_EMOJILIST_SHARED /* 27 */:
                return new zaa[i3];
            case Const.ANDROID_VERSION_28 /* 28 */:
                return new zag[i3];
            default:
                return new zai[i3];
        }
    }
}
