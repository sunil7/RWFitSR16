package i4;

import a4.g;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import com.bumptech.glide.j;
import ef.i;
import k4.c;
import k4.e;
import k4.h;
import t4.f;
import w3.d;
import z3.p;
import z3.s;

/* loaded from: classes.dex */
public final class a implements s, p {

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f14350a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f14351b;

    public a(Drawable drawable, int i3) {
        this.f14351b = i3;
        f.c(drawable, "Argument must not be null");
        this.f14350a = drawable;
    }

    private final void b() {
    }

    @Override // z3.p
    public void a() {
        switch (this.f14351b) {
            case 1:
                ((h) ((c) this.f14350a).f15470a.f15469b).f15496l.prepareToDraw();
                break;
            default:
                Drawable drawable = this.f14350a;
                if (!(drawable instanceof BitmapDrawable)) {
                    if (drawable instanceof c) {
                        ((h) ((c) drawable).f15470a.f15469b).f15496l.prepareToDraw();
                        break;
                    }
                } else {
                    ((BitmapDrawable) drawable).getBitmap().prepareToDraw();
                    break;
                }
                break;
        }
    }

    @Override // z3.s
    public final int c() {
        switch (this.f14351b) {
            case 0:
                Drawable drawable = this.f14350a;
                return Math.max(1, drawable.getIntrinsicHeight() * drawable.getIntrinsicWidth() * 4);
            default:
                h hVar = (h) ((c) this.f14350a).f15470a.f15469b;
                d dVar = hVar.f15486a;
                return (dVar.f19508j.length * 4) + dVar.f19503d.limit() + dVar.f19507i.length + hVar.f15498n;
        }
    }

    @Override // z3.s
    public final Class d() {
        switch (this.f14351b) {
            case 0:
                return this.f14350a.getClass();
            default:
                return c.class;
        }
    }

    @Override // z3.s
    public final Object get() {
        Drawable drawable = this.f14350a;
        Drawable.ConstantState constantState = drawable.getConstantState();
        return constantState == null ? drawable : constantState.newDrawable();
    }

    @Override // z3.s
    public final void recycle() {
        switch (this.f14351b) {
            case 0:
                break;
            default:
                c cVar = (c) this.f14350a;
                cVar.stop();
                cVar.f15473d = true;
                h hVar = (h) cVar.f15470a.f15469b;
                hVar.f15488c.clear();
                Bitmap bitmap = hVar.f15496l;
                if (bitmap != null) {
                    hVar.e.j(bitmap);
                    hVar.f15496l = null;
                }
                hVar.f15490f = false;
                e eVar = hVar.f15493i;
                j jVar = hVar.f15489d;
                if (eVar != null) {
                    jVar.k(eVar);
                    hVar.f15493i = null;
                }
                e eVar2 = hVar.f15495k;
                if (eVar2 != null) {
                    jVar.k(eVar2);
                    hVar.f15495k = null;
                }
                e eVar3 = hVar.f15497m;
                if (eVar3 != null) {
                    jVar.k(eVar3);
                    hVar.f15497m = null;
                }
                d dVar = hVar.f15486a;
                dVar.f19510l = null;
                byte[] bArr = dVar.f19507i;
                i iVar = dVar.f19502c;
                if (bArr != null) {
                    ((g) iVar.f12630c).g(bArr);
                }
                int[] iArr = dVar.f19508j;
                if (iArr != null) {
                    ((g) iVar.f12630c).g(iArr);
                }
                Bitmap bitmap2 = dVar.f19511m;
                if (bitmap2 != null) {
                    ((a4.b) iVar.f12629b).j(bitmap2);
                }
                dVar.f19511m = null;
                dVar.f19503d = null;
                dVar.f19516s = null;
                byte[] bArr2 = dVar.e;
                if (bArr2 != null) {
                    ((g) iVar.f12630c).g(bArr2);
                }
                hVar.f15494j = true;
                break;
        }
    }
}
