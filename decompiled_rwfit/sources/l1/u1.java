package l1;

import android.graphics.Insets;
import android.view.View;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public final class u1 extends t1 {

    /* renamed from: q, reason: collision with root package name */
    public static final x1 f15733q;

    static {
        WindowInsets windowInsets;
        windowInsets = WindowInsets.CONSUMED;
        f15733q = x1.h(windowInsets, null);
    }

    public u1(x1 x1Var, WindowInsets windowInsets) {
        super(x1Var, windowInsets);
    }

    @Override // l1.p1, l1.v1
    public final void d(View view) {
    }

    @Override // l1.p1, l1.v1
    public c1.c f(int i3) {
        Insets insets;
        insets = this.f15721c.getInsets(w1.a(i3));
        return c1.c.b(insets);
    }
}
