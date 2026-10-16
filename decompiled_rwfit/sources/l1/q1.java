package l1;

import android.view.WindowInsets;

/* loaded from: classes.dex */
public class q1 extends p1 {

    /* renamed from: m, reason: collision with root package name */
    public c1.c f15725m;

    public q1(x1 x1Var, WindowInsets windowInsets) {
        super(x1Var, windowInsets);
        this.f15725m = null;
    }

    @Override // l1.v1
    public x1 b() {
        return x1.h(this.f15721c.consumeStableInsets(), null);
    }

    @Override // l1.v1
    public x1 c() {
        return x1.h(this.f15721c.consumeSystemWindowInsets(), null);
    }

    @Override // l1.v1
    public final c1.c h() {
        if (this.f15725m == null) {
            WindowInsets windowInsets = this.f15721c;
            this.f15725m = c1.c.a(windowInsets.getStableInsetLeft(), windowInsets.getStableInsetTop(), windowInsets.getStableInsetRight(), windowInsets.getStableInsetBottom());
        }
        return this.f15725m;
    }

    @Override // l1.v1
    public boolean m() {
        return this.f15721c.isConsumed();
    }

    @Override // l1.v1
    public void q(c1.c cVar) {
        this.f15725m = cVar;
    }
}
