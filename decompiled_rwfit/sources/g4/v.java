package g4;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.RectF;
import android.graphics.Shader;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public final class v extends d {

    /* renamed from: c, reason: collision with root package name */
    public static final byte[] f13859c = "com.bumptech.glide.load.resource.bitmap.RoundedCorners".getBytes(x3.c.f19771a);

    /* renamed from: b, reason: collision with root package name */
    public final int f13860b;

    public v(int i3) {
        t4.f.a("roundingRadius must be greater than 0.", i3 > 0);
        this.f13860b = i3;
    }

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f13859c);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f13860b).array());
    }

    @Override // g4.d
    public final Bitmap c(a4.b bVar, Bitmap bitmap, int i3, int i10) {
        Paint paint = x.f13861a;
        int i11 = this.f13860b;
        t4.f.a("roundingRadius must be greater than 0.", i11 > 0);
        Bitmap.Config config = Bitmap.Config.RGBA_F16;
        if (!config.equals(bitmap.getConfig())) {
            config = Bitmap.Config.ARGB_8888;
        }
        Bitmap c9 = x.c(bVar, bitmap);
        Bitmap f2 = bVar.f(c9.getWidth(), c9.getHeight(), config);
        f2.setHasAlpha(true);
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(c9, tileMode, tileMode);
        Paint paint2 = new Paint();
        paint2.setAntiAlias(true);
        paint2.setShader(bitmapShader);
        RectF rectF = new RectF(0.0f, 0.0f, f2.getWidth(), f2.getHeight());
        Lock lock = x.f13864d;
        lock.lock();
        try {
            Canvas canvas = new Canvas(f2);
            canvas.drawColor(0, PorterDuff.Mode.CLEAR);
            float f10 = i11;
            canvas.drawRoundRect(rectF, f10, f10, paint2);
            canvas.setBitmap(null);
            lock.unlock();
            if (!c9.equals(bitmap)) {
                bVar.j(c9);
            }
            return f2;
        } catch (Throwable th2) {
            lock.unlock();
            throw th2;
        }
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        return (obj instanceof v) && this.f13860b == ((v) obj).f13860b;
    }

    @Override // x3.c
    public final int hashCode() {
        return t4.l.f(-569625254, t4.l.f(this.f13860b, 17));
    }
}
