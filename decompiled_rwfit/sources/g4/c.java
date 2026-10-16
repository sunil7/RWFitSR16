package g4;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;

/* loaded from: classes.dex */
public final class c implements z3.s, z3.p {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f13815a = 0;

    /* renamed from: b, reason: collision with root package name */
    public final Object f13816b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f13817c;

    public c(a4.b bVar, Bitmap bitmap) {
        t4.f.c(bitmap, "Bitmap must not be null");
        this.f13816b = bitmap;
        t4.f.c(bVar, "BitmapPool must not be null");
        this.f13817c = bVar;
    }

    public static c b(a4.b bVar, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        return new c(bVar, bitmap);
    }

    @Override // z3.p
    public final void a() {
        switch (this.f13815a) {
            case 0:
                ((Bitmap) this.f13816b).prepareToDraw();
                break;
            default:
                z3.s sVar = (z3.s) this.f13817c;
                if (sVar instanceof z3.p) {
                    ((z3.p) sVar).a();
                    break;
                }
                break;
        }
    }

    @Override // z3.s
    public final int c() {
        switch (this.f13815a) {
            case 0:
                return t4.l.c((Bitmap) this.f13816b);
            default:
                return ((z3.s) this.f13817c).c();
        }
    }

    @Override // z3.s
    public final Class d() {
        switch (this.f13815a) {
            case 0:
                return Bitmap.class;
            default:
                return BitmapDrawable.class;
        }
    }

    @Override // z3.s
    public final Object get() {
        switch (this.f13815a) {
            case 0:
                return (Bitmap) this.f13816b;
            default:
                return new BitmapDrawable((Resources) this.f13816b, (Bitmap) ((z3.s) this.f13817c).get());
        }
    }

    @Override // z3.s
    public final void recycle() {
        switch (this.f13815a) {
            case 0:
                ((a4.b) this.f13817c).j((Bitmap) this.f13816b);
                break;
            default:
                ((z3.s) this.f13817c).recycle();
                break;
        }
    }

    public c(Resources resources, z3.s sVar) {
        t4.f.c(resources, "Argument must not be null");
        this.f13816b = resources;
        t4.f.c(sVar, "Argument must not be null");
        this.f13817c = sVar;
    }
}
