package androidx.recyclerview.widget;

import android.os.Bundle;
import android.view.View;
import android.view.accessibility.AccessibilityEvent;

/* loaded from: classes.dex */
public class b2 extends l1.c {

    /* renamed from: d, reason: collision with root package name */
    public final RecyclerView f2518d;
    public final a2 e;

    public b2(RecyclerView recyclerView) {
        this.f2518d = recyclerView;
        a2 a2Var = this.e;
        if (a2Var != null) {
            this.e = a2Var;
        } else {
            this.e = new a2(this);
        }
    }

    @Override // l1.c
    public final void c(View view, AccessibilityEvent accessibilityEvent) {
        super.c(view, accessibilityEvent);
        if (!(view instanceof RecyclerView) || this.f2518d.N()) {
            return;
        }
        RecyclerView recyclerView = (RecyclerView) view;
        if (recyclerView.getLayoutManager() != null) {
            recyclerView.getLayoutManager().W(accessibilityEvent);
        }
    }

    @Override // l1.c
    public void d(View view, m1.d dVar) {
        this.f15682a.onInitializeAccessibilityNodeInfo(view, dVar.f15938a);
        RecyclerView recyclerView = this.f2518d;
        if (recyclerView.N() || recyclerView.getLayoutManager() == null) {
            return;
        }
        i1 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f2586b;
        layoutManager.X(recyclerView2.f2446b, recyclerView2.f2460g0, dVar);
    }

    @Override // l1.c
    public final boolean g(View view, int i3, Bundle bundle) {
        if (super.g(view, i3, bundle)) {
            return true;
        }
        RecyclerView recyclerView = this.f2518d;
        if (recyclerView.N() || recyclerView.getLayoutManager() == null) {
            return false;
        }
        i1 layoutManager = recyclerView.getLayoutManager();
        RecyclerView recyclerView2 = layoutManager.f2586b;
        return layoutManager.k0(recyclerView2.f2446b, recyclerView2.f2460g0, i3, bundle);
    }
}
