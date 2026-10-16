package g4;

import android.content.Context;
import android.graphics.Bitmap;

/* loaded from: classes.dex */
public abstract class d implements x3.i {
    @Override // x3.i
    public final z3.s a(Context context, z3.s sVar, int i3, int i10) {
        if (!t4.l.h(i3, i10)) {
            throw new IllegalArgumentException(android.support.v4.media.session.e.g(i3, "Cannot apply transformation on width: ", i10, " or height: ", " less than or equal to zero and not Target.SIZE_ORIGINAL"));
        }
        a4.b bVar = com.bumptech.glide.b.b(context).f6908a;
        Bitmap bitmap = (Bitmap) sVar.get();
        if (i3 == Integer.MIN_VALUE) {
            i3 = bitmap.getWidth();
        }
        if (i10 == Integer.MIN_VALUE) {
            i10 = bitmap.getHeight();
        }
        Bitmap c9 = c(bVar, bitmap, i3, i10);
        return bitmap.equals(c9) ? sVar : c.b(bVar, c9);
    }

    public abstract Bitmap c(a4.b bVar, Bitmap bitmap, int i3, int i10);
}
