package g4;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.Paint;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class g extends d {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f13822b = "com.bumptech.glide.load.resource.bitmap.CenterCrop".getBytes(x3.c.f19771a);

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f13822b);
    }

    @Override // g4.d
    public final Bitmap c(a4.b bVar, Bitmap bitmap, int i3, int i10) {
        float width;
        float height;
        Paint paint = x.f13861a;
        if (bitmap.getWidth() == i3 && bitmap.getHeight() == i10) {
            return bitmap;
        }
        Matrix matrix = new Matrix();
        float f2 = 0.0f;
        if (bitmap.getWidth() * i10 > bitmap.getHeight() * i3) {
            width = i10 / bitmap.getHeight();
            f2 = (i3 - (bitmap.getWidth() * width)) * 0.5f;
            height = 0.0f;
        } else {
            width = i3 / bitmap.getWidth();
            height = (i10 - (bitmap.getHeight() * width)) * 0.5f;
        }
        matrix.setScale(width, width);
        matrix.postTranslate((int) (f2 + 0.5f), (int) (height + 0.5f));
        Bitmap f10 = bVar.f(i3, i10, bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        f10.setHasAlpha(bitmap.hasAlpha());
        x.a(bitmap, f10, matrix);
        return f10;
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        return obj instanceof g;
    }

    @Override // x3.c
    public final int hashCode() {
        return -599754482;
    }
}
