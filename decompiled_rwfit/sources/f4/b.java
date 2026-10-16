package f4;

import android.graphics.ColorSpace;
import android.graphics.ImageDecoder;
import android.graphics.ImageDecoder$OnHeaderDecodedListener;
import android.os.Build;
import android.util.Log;
import android.util.Size;
import com.bumptech.glide.load.DecodeFormat;
import com.bumptech.glide.load.PreferredColorSpace;
import g4.m;
import g4.u;

/* loaded from: classes.dex */
public final class b implements ImageDecoder$OnHeaderDecodedListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f12657a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f12658b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ boolean f12659c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ DecodeFormat f12660d;
    public final /* synthetic */ m e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ PreferredColorSpace f12661f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ g4.a f12662g;

    public b(g4.a aVar, int i3, int i10, boolean z5, DecodeFormat decodeFormat, m mVar, PreferredColorSpace preferredColorSpace) {
        this.f12662g = aVar;
        this.f12657a = i3;
        this.f12658b = i10;
        this.f12659c = z5;
        this.f12660d = decodeFormat;
        this.e = mVar;
        this.f12661f = preferredColorSpace;
    }

    public final void onHeaderDecoded(ImageDecoder imageDecoder, ImageDecoder.ImageInfo imageInfo, ImageDecoder.Source source) {
        Size size;
        ColorSpace.Named named;
        ColorSpace colorSpace;
        ColorSpace colorSpace2;
        if (((u) this.f12662g.f13809b).b(this.f12657a, this.f12658b, this.f12659c, false)) {
            imageDecoder.setAllocator(3);
        } else {
            imageDecoder.setAllocator(1);
        }
        if (this.f12660d == DecodeFormat.PREFER_RGB_565) {
            imageDecoder.setMemorySizePolicy(0);
        }
        imageDecoder.setOnPartialImageListener(new a());
        size = imageInfo.getSize();
        int i3 = this.f12657a;
        if (i3 == Integer.MIN_VALUE) {
            i3 = size.getWidth();
        }
        int i10 = this.f12658b;
        if (i10 == Integer.MIN_VALUE) {
            i10 = size.getHeight();
        }
        float b3 = this.e.b(size.getWidth(), size.getHeight(), i3, i10);
        int round = Math.round(size.getWidth() * b3);
        int round2 = Math.round(size.getHeight() * b3);
        if (Log.isLoggable("ImageDecoder", 2)) {
            Log.v("ImageDecoder", "Resizing from [" + size.getWidth() + "x" + size.getHeight() + "] to [" + round + "x" + round2 + "] scaleFactor: " + b3);
        }
        imageDecoder.setTargetSize(round, round2);
        if (Build.VERSION.SDK_INT < 28) {
            imageDecoder.setTargetColorSpace(ColorSpace.get(ColorSpace.Named.SRGB));
            return;
        }
        if (this.f12661f == PreferredColorSpace.DISPLAY_P3) {
            colorSpace = imageInfo.getColorSpace();
            if (colorSpace != null) {
                colorSpace2 = imageInfo.getColorSpace();
                if (colorSpace2.isWideGamut()) {
                    named = ColorSpace.Named.DISPLAY_P3;
                    imageDecoder.setTargetColorSpace(ColorSpace.get(named));
                }
            }
        }
        named = ColorSpace.Named.SRGB;
        imageDecoder.setTargetColorSpace(ColorSpace.get(named));
    }
}
