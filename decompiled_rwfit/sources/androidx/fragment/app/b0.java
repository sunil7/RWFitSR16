package androidx.fragment.app;

import android.view.View;
import android.view.Window;

/* loaded from: classes.dex */
public final class b0 extends g0 implements androidx.lifecycle.r0, androidx.activity.p, androidx.activity.result.g, w0 {
    public final /* synthetic */ FragmentActivity e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b0(FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.e = fragmentActivity;
    }

    @Override // androidx.activity.result.g
    public final androidx.activity.result.f Z() {
        return this.e.f338j;
    }

    @Override // androidx.fragment.app.w0
    public final void a(Fragment fragment) {
    }

    @Override // androidx.fragment.app.f0
    public final View b(int i3) {
        return this.e.findViewById(i3);
    }

    @Override // androidx.fragment.app.f0
    public final boolean c() {
        Window window = this.e.getWindow();
        return (window == null || window.peekDecorView() == null) ? false : true;
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.n getLifecycle() {
        return this.e.f2091t;
    }

    @Override // androidx.lifecycle.r0
    public final androidx.lifecycle.q0 getViewModelStore() {
        return this.e.getViewModelStore();
    }

    @Override // androidx.activity.p
    public final androidx.activity.o l() {
        return this.e.f336h;
    }
}
