package g4;

import com.bumptech.glide.load.resource.bitmap.DownsampleStrategy$SampleSizeRounding;

/* loaded from: classes.dex */
public final class m {

    /* renamed from: b, reason: collision with root package name */
    public static final m f13828b = new m(2);

    /* renamed from: c, reason: collision with root package name */
    public static final m f13829c = new m(0);

    /* renamed from: d, reason: collision with root package name */
    public static final m f13830d;
    public static final m e;

    /* renamed from: f, reason: collision with root package name */
    public static final m f13831f;

    /* renamed from: g, reason: collision with root package name */
    public static final x3.e f13832g;

    /* renamed from: h, reason: collision with root package name */
    public static final boolean f13833h;

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13834a;

    static {
        m mVar = new m(1);
        f13830d = mVar;
        e = new m(3);
        f13831f = mVar;
        f13832g = x3.e.a(mVar, "com.bumptech.glide.load.resource.bitmap.Downsampler.DownsampleStrategy");
        f13833h = true;
    }

    public /* synthetic */ m(int i3) {
        this.f13834a = i3;
    }

    public final DownsampleStrategy$SampleSizeRounding a(int i3, int i10, int i11, int i12) {
        switch (this.f13834a) {
            case 0:
                return b(i3, i10, i11, i12) == 1.0f ? DownsampleStrategy$SampleSizeRounding.QUALITY : f13828b.a(i3, i10, i11, i12);
            case 1:
                return DownsampleStrategy$SampleSizeRounding.QUALITY;
            case 2:
                return f13833h ? DownsampleStrategy$SampleSizeRounding.QUALITY : DownsampleStrategy$SampleSizeRounding.MEMORY;
            default:
                return DownsampleStrategy$SampleSizeRounding.QUALITY;
        }
    }

    public final float b(int i3, int i10, int i11, int i12) {
        switch (this.f13834a) {
            case 0:
                return Math.min(1.0f, f13828b.b(i3, i10, i11, i12));
            case 1:
                return Math.max(i11 / i3, i12 / i10);
            case 2:
                if (f13833h) {
                    return Math.min(i11 / i3, i12 / i10);
                }
                if (Math.max(i10 / i12, i3 / i11) == 0) {
                    return 1.0f;
                }
                return 1.0f / Integer.highestOneBit(r2);
            default:
                return 1.0f;
        }
    }
}
