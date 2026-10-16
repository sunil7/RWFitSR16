package androidx.fragment.app;

import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public final class h0 implements View.OnAttachStateChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a1 f2191a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ i0 f2192b;

    public h0(i0 i0Var, a1 a1Var) {
        this.f2192b = i0Var;
        this.f2191a = a1Var;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        a1 a1Var = this.f2191a;
        Fragment fragment = a1Var.f2145c;
        a1Var.j();
        l.i((ViewGroup) fragment.mView.getParent(), this.f2192b.f2201a).g();
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
