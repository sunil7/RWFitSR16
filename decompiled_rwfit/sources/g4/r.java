package g4;

import android.content.Context;
import android.graphics.drawable.Drawable;
import java.security.MessageDigest;

/* loaded from: classes.dex */
public final class r implements x3.i {

    /* renamed from: b, reason: collision with root package name */
    public final x3.i f13846b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f13847c;

    public r(x3.i iVar, boolean z5) {
        this.f13846b = iVar;
        this.f13847c = z5;
    }

    @Override // x3.i
    public final z3.s a(Context context, z3.s sVar, int i3, int i10) {
        a4.b bVar = com.bumptech.glide.b.b(context).f6908a;
        Drawable drawable = (Drawable) sVar.get();
        c a3 = q.a(bVar, drawable, i3, i10);
        if (a3 != null) {
            z3.s a10 = this.f13846b.a(context, a3, i3, i10);
            if (!a10.equals(a3)) {
                return new c(context.getResources(), a10);
            }
            a10.recycle();
            return sVar;
        }
        if (!this.f13847c) {
            return sVar;
        }
        throw new IllegalArgumentException("Unable to convert " + drawable + " to a Bitmap");
    }

    @Override // x3.c
    public final void b(MessageDigest messageDigest) {
        this.f13846b.b(messageDigest);
    }

    @Override // x3.c
    public final boolean equals(Object obj) {
        if (obj instanceof r) {
            return this.f13846b.equals(((r) obj).f13846b);
        }
        return false;
    }

    @Override // x3.c
    public final int hashCode() {
        return this.f13846b.hashCode();
    }
}
