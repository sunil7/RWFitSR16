package f9;

import android.util.SparseArray;
import android.util.SparseBooleanArray;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector$Parameters;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes.dex */
public final class a extends c {
    public final boolean A;
    public final boolean B;
    public final boolean C;
    public final int D;
    public final boolean E;
    public final boolean F;
    public final boolean G;
    public final SparseArray H;
    public final SparseBooleanArray I;

    /* renamed from: w, reason: collision with root package name */
    public final boolean f13530w;

    /* renamed from: x, reason: collision with root package name */
    public final boolean f13531x;

    /* renamed from: y, reason: collision with root package name */
    public final boolean f13532y;

    /* renamed from: z, reason: collision with root package name */
    public final boolean f13533z;

    public a(DefaultTrackSelector$Parameters defaultTrackSelector$Parameters) {
        SparseArray sparseArray;
        SparseBooleanArray sparseBooleanArray;
        this.f13534a = defaultTrackSelector$Parameters.maxVideoWidth;
        this.f13535b = defaultTrackSelector$Parameters.maxVideoHeight;
        this.f13536c = defaultTrackSelector$Parameters.maxVideoFrameRate;
        this.f13537d = defaultTrackSelector$Parameters.maxVideoBitrate;
        this.e = defaultTrackSelector$Parameters.minVideoWidth;
        this.f13538f = defaultTrackSelector$Parameters.minVideoHeight;
        this.f13539g = defaultTrackSelector$Parameters.minVideoFrameRate;
        this.f13540h = defaultTrackSelector$Parameters.minVideoBitrate;
        this.f13541i = defaultTrackSelector$Parameters.viewportWidth;
        this.f13542j = defaultTrackSelector$Parameters.viewportHeight;
        this.f13543k = defaultTrackSelector$Parameters.viewportOrientationMayChange;
        this.f13544l = defaultTrackSelector$Parameters.preferredVideoMimeTypes;
        this.f13545m = defaultTrackSelector$Parameters.preferredAudioLanguages;
        this.f13546n = defaultTrackSelector$Parameters.preferredAudioRoleFlags;
        this.f13547o = defaultTrackSelector$Parameters.maxAudioChannelCount;
        this.f13548p = defaultTrackSelector$Parameters.maxAudioBitrate;
        this.f13549q = defaultTrackSelector$Parameters.preferredAudioMimeTypes;
        this.r = defaultTrackSelector$Parameters.preferredTextLanguages;
        this.f13550s = defaultTrackSelector$Parameters.preferredTextRoleFlags;
        this.f13551t = defaultTrackSelector$Parameters.selectUndeterminedTextLanguage;
        this.f13552u = defaultTrackSelector$Parameters.forceLowestBitrate;
        this.f13553v = defaultTrackSelector$Parameters.forceHighestSupportedBitrate;
        this.D = defaultTrackSelector$Parameters.disabledTextTrackSelectionFlags;
        this.f13530w = defaultTrackSelector$Parameters.exceedVideoConstraintsIfNecessary;
        this.f13531x = defaultTrackSelector$Parameters.allowVideoMixedMimeTypeAdaptiveness;
        this.f13532y = defaultTrackSelector$Parameters.allowVideoNonSeamlessAdaptiveness;
        this.f13533z = defaultTrackSelector$Parameters.exceedAudioConstraintsIfNecessary;
        this.A = defaultTrackSelector$Parameters.allowAudioMixedMimeTypeAdaptiveness;
        this.B = defaultTrackSelector$Parameters.allowAudioMixedSampleRateAdaptiveness;
        this.C = defaultTrackSelector$Parameters.allowAudioMixedChannelCountAdaptiveness;
        this.E = defaultTrackSelector$Parameters.exceedRendererCapabilitiesIfNecessary;
        this.F = defaultTrackSelector$Parameters.tunnelingEnabled;
        this.G = defaultTrackSelector$Parameters.allowMultipleAdaptiveSelections;
        sparseArray = defaultTrackSelector$Parameters.selectionOverrides;
        SparseArray sparseArray2 = new SparseArray();
        for (int i3 = 0; i3 < sparseArray.size(); i3++) {
            sparseArray2.put(sparseArray.keyAt(i3), new HashMap((Map) sparseArray.valueAt(i3)));
        }
        this.H = sparseArray2;
        sparseBooleanArray = defaultTrackSelector$Parameters.rendererDisabledFlags;
        this.I = sparseBooleanArray.clone();
    }

    public final void a(int i3) {
        SparseArray sparseArray = this.H;
        Map map = (Map) sparseArray.get(i3);
        if (map == null || map.isEmpty()) {
            return;
        }
        sparseArray.remove(i3);
    }

    public final void b(int i3, boolean z5) {
        SparseBooleanArray sparseBooleanArray = this.I;
        if (sparseBooleanArray.get(i3) == z5) {
            return;
        }
        if (z5) {
            sparseBooleanArray.put(i3, true);
        } else {
            sparseBooleanArray.delete(i3);
        }
    }

    public a() {
        this.H = new SparseArray();
        this.I = new SparseBooleanArray();
        this.f13530w = true;
        this.f13531x = false;
        this.f13532y = true;
        this.f13533z = true;
        this.A = false;
        this.B = false;
        this.C = false;
        this.D = 0;
        this.E = true;
        this.F = false;
        this.G = true;
    }
}
