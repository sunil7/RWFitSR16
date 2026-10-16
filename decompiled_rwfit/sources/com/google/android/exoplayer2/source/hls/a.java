package com.google.android.exoplayer2.source.hls;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.exoplayer2.source.hls.HlsTrackMetadataEntry;

/* loaded from: classes.dex */
public final class a implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        return new HlsTrackMetadataEntry.VariantInfo(parcel);
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i3) {
        return new HlsTrackMetadataEntry.VariantInfo[i3];
    }
}
