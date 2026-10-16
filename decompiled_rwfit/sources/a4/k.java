package a4;

import android.graphics.Bitmap;

/* loaded from: classes.dex */
public final class k implements i {

    /* renamed from: a, reason: collision with root package name */
    public final f f103a;

    /* renamed from: b, reason: collision with root package name */
    public int f104b;

    /* renamed from: c, reason: collision with root package name */
    public Bitmap.Config f105c;

    public k(f fVar) {
        this.f103a = fVar;
    }

    @Override // a4.i
    public final void a() {
        this.f103a.g(this);
    }

    public final boolean equals(Object obj) {
        if (obj instanceof k) {
            k kVar = (k) obj;
            if (this.f104b == kVar.f104b && t4.l.a(this.f105c, kVar.f105c)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i3 = this.f104b * 31;
        Bitmap.Config config = this.f105c;
        return i3 + (config != null ? config.hashCode() : 0);
    }

    public final String toString() {
        return l.c(this.f104b, this.f105c);
    }
}
