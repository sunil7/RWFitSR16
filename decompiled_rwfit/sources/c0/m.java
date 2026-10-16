package c0;

import android.util.Size;
import androidx.camera.core.impl.g0;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.google.android.gms.internal.mlkit_vision_common.y5;

/* loaded from: classes.dex */
public final class m extends g0 {

    /* renamed from: o, reason: collision with root package name */
    public final n0.i f3326o;

    /* renamed from: p, reason: collision with root package name */
    public androidx.concurrent.futures.b f3327p;

    /* renamed from: q, reason: collision with root package name */
    public g0 f3328q;
    public o r;

    public m(Size size, int i3) {
        super(size, i3);
        this.f3326o = ve.a(new af.a(this, 1));
    }

    @Override // androidx.camera.core.impl.g0
    public final void a() {
        super.a();
        y5.c(new j(this, 2));
    }

    @Override // androidx.camera.core.impl.g0
    public final ob.a f() {
        return this.f3326o;
    }

    public final boolean g(g0 g0Var, Runnable runnable) {
        boolean z5;
        y5.a();
        g0Var.getClass();
        g0 g0Var2 = this.f3328q;
        if (g0Var2 == g0Var) {
            return false;
        }
        pd.f("A different provider has been set. To change the provider, call SurfaceEdge#invalidate before calling SurfaceEdge#setProvider", g0Var2 == null);
        Size size = this.f1398h;
        Size size2 = g0Var.f1398h;
        pd.a("The provider's size(" + size + ") must match the parent(" + size2 + ")", size.equals(size2));
        int i3 = g0Var.f1399i;
        int i10 = this.f1399i;
        pd.a(android.support.v4.media.session.e.g(i10, "The provider's format(", i3, ") must match the parent(", ")"), i10 == i3);
        synchronized (this.f1392a) {
            z5 = this.f1394c;
        }
        pd.f("The parent is closed. Call SurfaceEdge#invalidate() before setting a new provider.", !z5);
        this.f3328q = g0Var;
        x.i.e(true, g0Var.c(), this.f3327p, a6.a());
        g0Var.d();
        x.i.d(this.e).a(new androidx.activity.b(g0Var, 12), a6.a());
        x.i.d(g0Var.f1397g).a(runnable, a6.d());
        return true;
    }
}
