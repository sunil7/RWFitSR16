package g4;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.Log;
import java.util.concurrent.locks.Lock;

/* loaded from: classes.dex */
public abstract class q {

    /* renamed from: a, reason: collision with root package name */
    public static final p f13845a = new p(1);

    public static c a(a4.b bVar, Drawable drawable, int i3, int i10) {
        Bitmap bitmap;
        Drawable current = drawable.getCurrent();
        boolean z5 = false;
        if (current instanceof BitmapDrawable) {
            bitmap = ((BitmapDrawable) current).getBitmap();
        } else if (current instanceof Animatable) {
            bitmap = null;
        } else {
            if (i3 != Integer.MIN_VALUE || current.getIntrinsicWidth() > 0) {
                if (i10 != Integer.MIN_VALUE || current.getIntrinsicHeight() > 0) {
                    if (current.getIntrinsicWidth() > 0) {
                        i3 = current.getIntrinsicWidth();
                    }
                    if (current.getIntrinsicHeight() > 0) {
                        i10 = current.getIntrinsicHeight();
                    }
                    Lock lock = x.f13864d;
                    lock.lock();
                    Bitmap f2 = bVar.f(i3, i10, Bitmap.Config.ARGB_8888);
                    try {
                        Canvas canvas = new Canvas(f2);
                        current.setBounds(0, 0, i3, i10);
                        current.draw(canvas);
                        canvas.setBitmap(null);
                        lock.unlock();
                        bitmap = f2;
                        z5 = true;
                    } catch (Throwable th2) {
                        lock.unlock();
                        throw th2;
                    }
                } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                    Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic height");
                }
            } else if (Log.isLoggable("DrawableToBitmap", 5)) {
                Log.w("DrawableToBitmap", "Unable to draw " + current + " to Bitmap with Target.SIZE_ORIGINAL because the Drawable has no intrinsic width");
            }
            bitmap = null;
            z5 = true;
        }
        if (!z5) {
            bVar = f13845a;
        }
        return c.b(bVar, bitmap);
    }
}
