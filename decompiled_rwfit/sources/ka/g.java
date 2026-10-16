package ka;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;

/* loaded from: classes.dex */
public abstract class g extends x0.c {

    /* renamed from: a, reason: collision with root package name */
    public h f15585a;

    /* renamed from: b, reason: collision with root package name */
    public int f15586b = 0;

    public g() {
    }

    @Override // x0.c
    public boolean h(CoordinatorLayout coordinatorLayout, View view, int i3) {
        t(coordinatorLayout, view, i3);
        if (this.f15585a == null) {
            this.f15585a = new h(view);
        }
        h hVar = this.f15585a;
        View view2 = hVar.f15587a;
        hVar.f15588b = view2.getTop();
        hVar.f15589c = view2.getLeft();
        this.f15585a.a();
        int i10 = this.f15586b;
        if (i10 == 0) {
            return true;
        }
        this.f15585a.b(i10);
        this.f15586b = 0;
        return true;
    }

    public final int s() {
        h hVar = this.f15585a;
        if (hVar != null) {
            return hVar.f15590d;
        }
        return 0;
    }

    public void t(CoordinatorLayout coordinatorLayout, View view, int i3) {
        coordinatorLayout.v(i3, view);
    }

    public g(int i3) {
    }
}
