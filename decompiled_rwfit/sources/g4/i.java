package g4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import java.security.MessageDigest;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class i extends d {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f13824b = "com.bumptech.glide.load.resource.bitmap.CircleCrop.1".getBytes(x3.c.f19771a);

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f13824b);
    }

    @Override // g4.d
    public final Bitmap c(a4.b bVar, Bitmap bitmap, int i3, int i10) {
        Paint paint = x.f13861a;
        int min = Math.min(i3, i10);
        float f2 = min;
        float f10 = f2 / 2.0f;
        float width = bitmap.getWidth();
        float height = bitmap.getHeight();
        float max = Math.max(f2 / width, f2 / height);
        float f11 = width * max;
        float f12 = max * height;
        float f13 = (f2 - f11) / 2.0f;
        float f14 = (f2 - f12) / 2.0f;
        RectF rectF = new RectF(f13, f14, f11 + f13, f12 + f14);
        Bitmap c9 = x.c(bVar, bitmap);
        Bitmap.Config config = Bitmap.Config.RGBA_F16;
        if (!config.equals(bitmap.getConfig())) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap f15 = bVar.f(min, min, config);
        f15.setHasAlpha(true);
        Lock lock = x.f13864d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(f15);
            canvas.drawCircle(f10, f10, f10, x.f13862b);
            canvas.drawBitmap(c9, (Rect) null, rectF, x.f13863c);
            canvas.setBitmap(null);
            lock.unlock();
            if (!c9.equals(bitmap)) {
                bVar.j(c9);
            }
            return f15;
        } catch (Throwable th2) {
            lock.unlock();
            throw th2;
        }
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        return obj instanceof i;
    }

    @Override // x3.c
    public final int hashCode() {
        return 1101716364;
    }
}
