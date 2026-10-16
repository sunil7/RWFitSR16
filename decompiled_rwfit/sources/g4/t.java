package g4;

import android.graphics.Bitmap;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class t extends d {

    /* renamed from: b, reason: collision with root package name */
    public static final byte[] f13848b = "com.bumptech.glide.load.resource.bitmap.FitCenter".getBytes(x3.c.f19771a);

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        messageDigest.update(f13848b);
    }

    @Override // g4.d
    public final Bitmap c(a4.b bVar, Bitmap bitmap, int i3, int i10) {
        return x.b(bVar, bitmap, i3, i10);
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        return obj instanceof t;
    }

    @Override // x3.c
    public final int hashCode() {
        return 1572326941;
    }
}
