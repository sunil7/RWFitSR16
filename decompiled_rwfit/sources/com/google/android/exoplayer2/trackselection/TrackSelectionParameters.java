package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.databinding.g;
import com.google.common.collect.ImmutableList;
import f9.c;
import java.util.ArrayList;
import java.util.Collection;

/* loaded from: classes.dex */
public class TrackSelectionParameters implements Parcelable {
    public static final Parcelable.Creator<TrackSelectionParameters> CREATOR;

    @Deprecated
    public static final TrackSelectionParameters DEFAULT;
    public static final TrackSelectionParameters DEFAULT_WITHOUT_CONTEXT;
    public final boolean forceHighestSupportedBitrate;
    public final boolean forceLowestBitrate;
    public final int maxAudioBitrate;
    public final int maxAudioChannelCount;
    public final int maxVideoBitrate;
    public final int maxVideoFrameRate;
    public final int maxVideoHeight;
    public final int maxVideoWidth;
    public final int minVideoBitrate;
    public final int minVideoFrameRate;
    public final int minVideoHeight;
    public final int minVideoWidth;
    public final ImmutableList<String> preferredAudioLanguages;
    public final ImmutableList<String> preferredAudioMimeTypes;
    public final int preferredAudioRoleFlags;
    public final ImmutableList<String> preferredTextLanguages;
    public final int preferredTextRoleFlags;
    public final ImmutableList<String> preferredVideoMimeTypes;
    public final boolean selectUndeterminedTextLanguage;
    public final int viewportHeight;
    public final boolean viewportOrientationMayChange;
    public final int viewportWidth;

    static {
        TrackSelectionParameters trackSelectionParameters = new TrackSelectionParameters(new c());
        DEFAULT_WITHOUT_CONTEXT = trackSelectionParameters;
        DEFAULT = trackSelectionParameters;
        CREATOR = new g(26);
    }

    public TrackSelectionParameters(c cVar) {
        this.maxVideoWidth = cVar.f13534a;
        this.maxVideoHeight = cVar.f13535b;
        this.maxVideoFrameRate = cVar.f13536c;
        this.maxVideoBitrate = cVar.f13537d;
        this.minVideoWidth = cVar.e;
        this.minVideoHeight = cVar.f13538f;
        this.minVideoFrameRate = cVar.f13539g;
        this.minVideoBitrate = cVar.f13540h;
        this.viewportWidth = cVar.f13541i;
        this.viewportHeight = cVar.f13542j;
        this.viewportOrientationMayChange = cVar.f13543k;
        this.preferredVideoMimeTypes = cVar.f13544l;
        this.preferredAudioLanguages = cVar.f13545m;
        this.preferredAudioRoleFlags = cVar.f13546n;
        this.maxAudioChannelCount = cVar.f13547o;
        this.maxAudioBitrate = cVar.f13548p;
        this.preferredAudioMimeTypes = cVar.f13549q;
        this.preferredTextLanguages = cVar.r;
        this.preferredTextRoleFlags = cVar.f13550s;
        this.selectUndeterminedTextLanguage = cVar.f13551t;
        this.forceLowestBitrate = cVar.f13552u;
        this.forceHighestSupportedBitrate = cVar.f13553v;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            TrackSelectionParameters trackSelectionParameters = (TrackSelectionParameters) obj;
            if (this.maxVideoWidth == trackSelectionParameters.maxVideoWidth && this.maxVideoHeight == trackSelectionParameters.maxVideoHeight && this.maxVideoFrameRate == trackSelectionParameters.maxVideoFrameRate && this.maxVideoBitrate == trackSelectionParameters.maxVideoBitrate && this.minVideoWidth == trackSelectionParameters.minVideoWidth && this.minVideoHeight == trackSelectionParameters.minVideoHeight && this.minVideoFrameRate == trackSelectionParameters.minVideoFrameRate && this.minVideoBitrate == trackSelectionParameters.minVideoBitrate && this.viewportOrientationMayChange == trackSelectionParameters.viewportOrientationMayChange && this.viewportWidth == trackSelectionParameters.viewportWidth && this.viewportHeight == trackSelectionParameters.viewportHeight && this.preferredVideoMimeTypes.equals(trackSelectionParameters.preferredVideoMimeTypes) && this.preferredAudioLanguages.equals(trackSelectionParameters.preferredAudioLanguages) && this.preferredAudioRoleFlags == trackSelectionParameters.preferredAudioRoleFlags && this.maxAudioChannelCount == trackSelectionParameters.maxAudioChannelCount && this.maxAudioBitrate == trackSelectionParameters.maxAudioBitrate && this.preferredAudioMimeTypes.equals(trackSelectionParameters.preferredAudioMimeTypes) && this.preferredTextLanguages.equals(trackSelectionParameters.preferredTextLanguages) && this.preferredTextRoleFlags == trackSelectionParameters.preferredTextRoleFlags && this.selectUndeterminedTextLanguage == trackSelectionParameters.selectUndeterminedTextLanguage && this.forceLowestBitrate == trackSelectionParameters.forceLowestBitrate && this.forceHighestSupportedBitrate == trackSelectionParameters.forceHighestSupportedBitrate) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return ((((((((this.preferredTextLanguages.hashCode() + ((this.preferredAudioMimeTypes.hashCode() + ((((((((this.preferredAudioLanguages.hashCode() + ((this.preferredVideoMimeTypes.hashCode() + ((((((((((((((((((((((this.maxVideoWidth + 31) * 31) + this.maxVideoHeight) * 31) + this.maxVideoFrameRate) * 31) + this.maxVideoBitrate) * 31) + this.minVideoWidth) * 31) + this.minVideoHeight) * 31) + this.minVideoFrameRate) * 31) + this.minVideoBitrate) * 31) + (this.viewportOrientationMayChange ? 1 : 0)) * 31) + this.viewportWidth) * 31) + this.viewportHeight) * 31)) * 31)) * 31) + this.preferredAudioRoleFlags) * 31) + this.maxAudioChannelCount) * 31) + this.maxAudioBitrate) * 31)) * 31)) * 31) + this.preferredTextRoleFlags) * 31) + (this.selectUndeterminedTextLanguage ? 1 : 0)) * 31) + (this.forceLowestBitrate ? 1 : 0)) * 31) + (this.forceHighestSupportedBitrate ? 1 : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i3) {
        parcel.writeList(this.preferredAudioLanguages);
        parcel.writeInt(this.preferredAudioRoleFlags);
        parcel.writeList(this.preferredTextLanguages);
        parcel.writeInt(this.preferredTextRoleFlags);
        boolean z5 = this.selectUndeterminedTextLanguage;
        int i10 = i9.g.f14378a;
        parcel.writeInt(z5 ? 1 : 0);
        parcel.writeInt(this.maxVideoWidth);
        parcel.writeInt(this.maxVideoHeight);
        parcel.writeInt(this.maxVideoFrameRate);
        parcel.writeInt(this.maxVideoBitrate);
        parcel.writeInt(this.minVideoWidth);
        parcel.writeInt(this.minVideoHeight);
        parcel.writeInt(this.minVideoFrameRate);
        parcel.writeInt(this.minVideoBitrate);
        parcel.writeInt(this.viewportWidth);
        parcel.writeInt(this.viewportHeight);
        parcel.writeInt(this.viewportOrientationMayChange ? 1 : 0);
        parcel.writeList(this.preferredVideoMimeTypes);
        parcel.writeInt(this.maxAudioChannelCount);
        parcel.writeInt(this.maxAudioBitrate);
        parcel.writeList(this.preferredAudioMimeTypes);
        parcel.writeInt(this.forceLowestBitrate ? 1 : 0);
        parcel.writeInt(this.forceHighestSupportedBitrate ? 1 : 0);
    }

    public TrackSelectionParameters(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        parcel.readList(arrayList, null);
        this.preferredAudioLanguages = ImmutableList.copyOf((Collection) arrayList);
        this.preferredAudioRoleFlags = parcel.readInt();
        ArrayList arrayList2 = new ArrayList();
        parcel.readList(arrayList2, null);
        this.preferredTextLanguages = ImmutableList.copyOf((Collection) arrayList2);
        this.preferredTextRoleFlags = parcel.readInt();
        int i3 = i9.g.f14378a;
        this.selectUndeterminedTextLanguage = parcel.readInt() != 0;
        this.maxVideoWidth = parcel.readInt();
        this.maxVideoHeight = parcel.readInt();
        this.maxVideoFrameRate = parcel.readInt();
        this.maxVideoBitrate = parcel.readInt();
        this.minVideoWidth = parcel.readInt();
        this.minVideoHeight = parcel.readInt();
        this.minVideoFrameRate = parcel.readInt();
        this.minVideoBitrate = parcel.readInt();
        this.viewportWidth = parcel.readInt();
        this.viewportHeight = parcel.readInt();
        this.viewportOrientationMayChange = parcel.readInt() != 0;
        ArrayList arrayList3 = new ArrayList();
        parcel.readList(arrayList3, null);
        this.preferredVideoMimeTypes = ImmutableList.copyOf((Collection) arrayList3);
        this.maxAudioChannelCount = parcel.readInt();
        this.maxAudioBitrate = parcel.readInt();
        ArrayList arrayList4 = new ArrayList();
        parcel.readList(arrayList4, null);
        this.preferredAudioMimeTypes = ImmutableList.copyOf((Collection) arrayList4);
        this.forceLowestBitrate = parcel.readInt() != 0;
        this.forceHighestSupportedBitrate = parcel.readInt() != 0;
    }
}
