package y;

import android.util.Rational;
import android.util.Size;
import androidx.camera.core.impl.p0;
import androidx.camera.core.impl.u;
import com.google.android.gms.internal.mlkit_vision_common.j0;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final int f19859a;

    /* renamed from: b, reason: collision with root package name */
    public final int f19860b;

    /* renamed from: c, reason: collision with root package name */
    public final Rational f19861c;

    /* renamed from: d, reason: collision with root package name */
    public final boolean f19862d;

    public h(u uVar, Rational rational) {
        this.f19859a = uVar.a();
        this.f19860b = uVar.b();
        this.f19861c = rational;
        boolean z5 = true;
        if (rational != null && rational.getNumerator() < rational.getDenominator()) {
            z5 = false;
        }
        this.f19862d = z5;
    }

    public final Size a(p0 p0Var) {
        int n4 = p0Var.n();
        Size size = (Size) p0Var.k(p0.f1470w0, null);
        if (size != null) {
            int a3 = j0.a(j0.b(n4), this.f19859a, 1 == this.f19860b);
            if (a3 == 90 || a3 == 270) {
                return new Size(size.getHeight(), size.getWidth());
            }
        }
        return size;
    }
}
