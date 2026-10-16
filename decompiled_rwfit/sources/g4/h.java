package g4;

import android.graphics.Bitmap;
import android.graphics.Paint;
import android.util.Log;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class h extends d {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f13823b = "com.bumptech.glide.load.resource.bitmap.CenterInside".getBytes(x3.c.f19771a);

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f13823b);
    }

    @Override // g4.d
    public final Bitmap c(a4.b bVar, Bitmap bitmap, int i3, int i10) {
        Paint paint = x.f13861a;
        if (bitmap.getWidth() > i3 || bitmap.getHeight() > i10) {
            if (Log.isLoggable("TransformationUtils", 2)) {
                Log.v("TransformationUtils", "requested target size too big for input, fit centering instead");
            }
            return x.b(bVar, bitmap, i3, i10);
        }
        if (Log.isLoggable("TransformationUtils", 2)) {
            Log.v("TransformationUtils", "requested target size larger or equal to input, returning input");
        }
        return bitmap;
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        return obj instanceof h;
    }

    @Override // x3.c
    public final int hashCode() {
        return -670243078;
    }
}
