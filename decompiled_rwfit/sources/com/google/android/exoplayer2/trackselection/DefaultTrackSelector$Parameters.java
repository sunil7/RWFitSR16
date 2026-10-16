package com.google.android.exoplayer2.trackselection;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import android.util.SparseBooleanArray;
import androidx.databinding.g;
import com.google.android.exoplayer2.source.TrackGroupArray;
import f9.a;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class DefaultTrackSelector$Parameters extends TrackSelectionParameters implements Parcelable {
    public static final Parcelable.Creator<DefaultTrackSelector$Parameters> CREATOR;

    @Deprecated
    public static final DefaultTrackSelector$Parameters DEFAULT;
    public static final DefaultTrackSelector$Parameters DEFAULT_WITHOUT_CONTEXT;
    public final boolean allowAudioMixedChannelCountAdaptiveness;
    public final boolean allowAudioMixedMimeTypeAdaptiveness;
    public final boolean allowAudioMixedSampleRateAdaptiveness;
    public final boolean allowMultipleAdaptiveSelections;
    public final boolean allowVideoMixedMimeTypeAdaptiveness;
    public final boolean allowVideoNonSeamlessAdaptiveness;
    public final int disabledTextTrackSelectionFlags;
    public final boolean exceedAudioConstraintsIfNecessary;
    public final boolean exceedRendererCapabilitiesIfNecessary;
    public final boolean exceedVideoConstraintsIfNecessary;
    private final SparseBooleanArray rendererDisabledFlags;
    private final SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> selectionOverrides;
    public final boolean tunnelingEnabled;

    static {
        DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = new DefaultTrackSelector$Parameters(new a());
        DEFAULT_WITHOUT_CONTEXT = defaultTrackSelector$Parameters;
        DEFAULT = defaultTrackSelector$Parameters;
        CREATOR = new g(24);
    }

    public DefaultTrackSelector$Parameters(a aVar) {
        super(aVar);
        this.exceedVideoConstraintsIfNecessary = aVar.f13530w;
        this.allowVideoMixedMimeTypeAdaptiveness = aVar.f13531x;
        this.allowVideoNonSeamlessAdaptiveness = aVar.f13532y;
        this.exceedAudioConstraintsIfNecessary = aVar.f13533z;
        this.allowAudioMixedMimeTypeAdaptiveness = aVar.A;
        this.allowAudioMixedSampleRateAdaptiveness = aVar.B;
        this.allowAudioMixedChannelCountAdaptiveness = aVar.C;
        this.disabledTextTrackSelectionFlags = aVar.D;
        this.exceedRendererCapabilitiesIfNecessary = aVar.E;
        this.tunnelingEnabled = aVar.F;
        this.allowMultipleAdaptiveSelections = aVar.G;
        this.selectionOverrides = aVar.H;
        this.rendererDisabledFlags = aVar.I;
    }

    public final boolean d(int i3, TrackGroupArray trackGroupArray) {
        Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride> map = this.selectionOverrides.get(i3);
        return map != null && map.containsKey(trackGroupArray);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && DefaultTrackSelector$Parameters.class == obj.getClass()) {
            DefaultTrackSelector$Parameters defaultTrackSelector$Parameters = (DefaultTrackSelector$Parameters) obj;
            if (super.equals(defaultTrackSelector$Parameters) && this.exceedVideoConstraintsIfNecessary == defaultTrackSelector$Parameters.exceedVideoConstraintsIfNecessary && this.allowVideoMixedMimeTypeAdaptiveness == defaultTrackSelector$Parameters.allowVideoMixedMimeTypeAdaptiveness && this.allowVideoNonSeamlessAdaptiveness == defaultTrackSelector$Parameters.allowVideoNonSeamlessAdaptiveness && this.exceedAudioConstraintsIfNecessary == defaultTrackSelector$Parameters.exceedAudioConstraintsIfNecessary && this.allowAudioMixedMimeTypeAdaptiveness == defaultTrackSelector$Parameters.allowAudioMixedMimeTypeAdaptiveness && this.allowAudioMixedSampleRateAdaptiveness == defaultTrackSelector$Parameters.allowAudioMixedSampleRateAdaptiveness && this.allowAudioMixedChannelCountAdaptiveness == defaultTrackSelector$Parameters.allowAudioMixedChannelCountAdaptiveness && this.disabledTextTrackSelectionFlags == defaultTrackSelector$Parameters.disabledTextTrackSelectionFlags && this.exceedRendererCapabilitiesIfNecessary == defaultTrackSelector$Parameters.exceedRendererCapabilitiesIfNecessary && this.tunnelingEnabled == defaultTrackSelector$Parameters.tunnelingEnabled && this.allowMultipleAdaptiveSelections == defaultTrackSelector$Parameters.allowMultipleAdaptiveSelections) {
                SparseBooleanArray sparseBooleanArray = this.rendererDisabledFlags;
                SparseBooleanArray sparseBooleanArray2 = defaultTrackSelector$Parameters.rendererDisabledFlags;
                int size = sparseBooleanArray.size();
                if (sparseBooleanArray2.size() == size) {
                    int i3 = 0;
                    while (true) {
                        if (i3 >= size) {
                            SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> sparseArray = this.selectionOverrides;
                            SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> sparseArray2 = defaultTrackSelector$Parameters.selectionOverrides;
                            int size2 = sparseArray.size();
                            if (sparseArray2.size() == size2) {
                                for (int i10 = 0; i10 < size2; i10++) {
                                    int indexOfKey = sparseArray2.indexOfKey(sparseArray.keyAt(i10));
                                    if (indexOfKey >= 0) {
                                        Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride> valueAt = sparseArray.valueAt(i10);
                                        Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride> valueAt2 = sparseArray2.valueAt(indexOfKey);
                                        if (valueAt2.size() == valueAt.size()) {
                                            for (Map.Entry<TrackGroupArray, DefaultTrackSelector$SelectionOverride> entry : valueAt.entrySet()) {
                                                TrackGroupArray key = entry.getKey();
                                                if (valueAt2.containsKey(key) && i9.g.a(entry.getValue(), valueAt2.get(key))) {
                                                }
                                            }
                                        }
                                    }
                                }
                                return true;
                            }
                        } else {
                            if (sparseBooleanArray2.indexOfKey(sparseBooleanArray.keyAt(i3)) < 0) {
                                break;
                            }
                            i3++;
                        }
                    }
                }
            }
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters
    public final int hashCode() {
        return ((((((((((((((((((((((super.hashCode() + 31) * 31) + (this.exceedVideoConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowVideoNonSeamlessAdaptiveness ? 1 : 0)) * 31) + (this.exceedAudioConstraintsIfNecessary ? 1 : 0)) * 31) + (this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0)) * 31) + (this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0)) * 31) + this.disabledTextTrackSelectionFlags) * 31) + (this.exceedRendererCapabilitiesIfNecessary ? 1 : 0)) * 31) + (this.tunnelingEnabled ? 1 : 0)) * 31) + (this.allowMultipleAdaptiveSelections ? 1 : 0);
    }

    @Override // com.google.android.exoplayer2.trackselection.TrackSelectionParameters, android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i3) {
        super.writeToParcel(parcel, i3);
        boolean z5 = this.exceedVideoConstraintsIfNecessary;
        int i10 = i9.g.f14378a;
        parcel.writeInt(z5 ? 1 : 0);
        parcel.writeInt(this.allowVideoMixedMimeTypeAdaptiveness ? 1 : 0);
        parcel.writeInt(this.allowVideoNonSeamlessAdaptiveness ? 1 : 0);
        parcel.writeInt(this.exceedAudioConstraintsIfNecessary ? 1 : 0);
        parcel.writeInt(this.allowAudioMixedMimeTypeAdaptiveness ? 1 : 0);
        parcel.writeInt(this.allowAudioMixedSampleRateAdaptiveness ? 1 : 0);
        parcel.writeInt(this.allowAudioMixedChannelCountAdaptiveness ? 1 : 0);
        parcel.writeInt(this.disabledTextTrackSelectionFlags);
        parcel.writeInt(this.exceedRendererCapabilitiesIfNecessary ? 1 : 0);
        parcel.writeInt(this.tunnelingEnabled ? 1 : 0);
        parcel.writeInt(this.allowMultipleAdaptiveSelections ? 1 : 0);
        SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> sparseArray = this.selectionOverrides;
        int size = sparseArray.size();
        parcel.writeInt(size);
        for (int i11 = 0; i11 < size; i11++) {
            int keyAt = sparseArray.keyAt(i11);
            Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride> valueAt = sparseArray.valueAt(i11);
            int size2 = valueAt.size();
            parcel.writeInt(keyAt);
            parcel.writeInt(size2);
            for (Map.Entry<TrackGroupArray, DefaultTrackSelector$SelectionOverride> entry : valueAt.entrySet()) {
                parcel.writeParcelable(entry.getKey(), 0);
                parcel.writeParcelable(entry.getValue(), 0);
            }
        }
        parcel.writeSparseBooleanArray(this.rendererDisabledFlags);
    }

    public DefaultTrackSelector$Parameters(Parcel parcel) {
        super(parcel);
        int i3 = i9.g.f14378a;
        this.exceedVideoConstraintsIfNecessary = parcel.readInt() != 0;
        this.allowVideoMixedMimeTypeAdaptiveness = parcel.readInt() != 0;
        this.allowVideoNonSeamlessAdaptiveness = parcel.readInt() != 0;
        this.exceedAudioConstraintsIfNecessary = parcel.readInt() != 0;
        this.allowAudioMixedMimeTypeAdaptiveness = parcel.readInt() != 0;
        this.allowAudioMixedSampleRateAdaptiveness = parcel.readInt() != 0;
        this.allowAudioMixedChannelCountAdaptiveness = parcel.readInt() != 0;
        this.disabledTextTrackSelectionFlags = parcel.readInt();
        this.exceedRendererCapabilitiesIfNecessary = parcel.readInt() != 0;
        this.tunnelingEnabled = parcel.readInt() != 0;
        this.allowMultipleAdaptiveSelections = parcel.readInt() != 0;
        int readInt = parcel.readInt();
        SparseArray<Map<TrackGroupArray, DefaultTrackSelector$SelectionOverride>> sparseArray = new SparseArray<>(readInt);
        for (int i10 = 0; i10 < readInt; i10++) {
            int readInt2 = parcel.readInt();
            int readInt3 = parcel.readInt();
            HashMap hashMap = new HashMap(readInt3);
            for (int i11 = 0; i11 < readInt3; i11++) {
                TrackGroupArray trackGroupArray = (TrackGroupArray) parcel.readParcelable(TrackGroupArray.class.getClassLoader());
                trackGroupArray.getClass();
                hashMap.put(trackGroupArray, (DefaultTrackSelector$SelectionOverride) parcel.readParcelable(DefaultTrackSelector$SelectionOverride.class.getClassLoader()));
            }
            sparseArray.put(readInt2, hashMap);
        }
        this.selectionOverrides = sparseArray;
        this.rendererDisabledFlags = parcel.readSparseBooleanArray();
    }
}
