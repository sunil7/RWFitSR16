package l1;

import android.graphics.Insets;
import android.view.WindowInsets;

/* loaded from: classes.dex */
public class t1 extends s1 {

    /* renamed from: n, reason: collision with root package name */
    public c1.c f15730n;

    /* renamed from: o, reason: collision with root package name */
    public c1.c f15731o;

    /* renamed from: p, reason: collision with root package name */
    public c1.c f15732p;

    public t1(x1 x1Var, WindowInsets windowInsets) {
        super(x1Var, windowInsets);
        this.f15730n = null;
        this.f15731o = null;
        this.f15732p = null;
    }

    @Override // l1.v1
    public c1.c g() {
        Insets mandatorySystemGestureInsets;
        if (this.f15731o == null) {
            mandatorySystemGestureInsets = this.f15721c.getMandatorySystemGestureInsets();
            this.f15731o = c1.c.b(mandatorySystemGestureInsets);
        }
        return this.f15731o;
    }

    @Override // l1.v1
    public c1.c i() {
        Insets systemGestureInsets;
        if (this.f15730n == null) {
            systemGestureInsets = this.f15721c.getSystemGestureInsets();
            this.f15730n = c1.c.b(systemGestureInsets);
        }
        return this.f15730n;
    }

    @Override // l1.v1
    public c1.c k() {
        Insets tappableElementInsets;
        if (this.f15732p == null) {
            tappableElementInsets = this.f15721c.getTappableElementInsets();
            this.f15732p = c1.c.b(tappableElementInsets);
        }
        return this.f15732p;
    }

    @Override // l1.p1, l1.v1
    public x1 l(int i3, int i10, int i11, int i12) {
        WindowInsets inset;
        inset = this.f15721c.inset(i3, i10, i11, i12);
        return x1.h(inset, null);
    }

    @Override // l1.q1, l1.v1
    public void q(c1.c cVar) {
    }
}
