package androidx.fragment.app;

import android.view.View;

/* loaded from: classes.dex */
public final class r extends f0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Fragment f2260a;

    public r(Fragment fragment) {
        this.f2260a = fragment;
    }

    @Override // androidx.fragment.app.f0
    public final View b(int i3) {
        Fragment fragment = this.f2260a;
        View view = fragment.mView;
        if (view != null) {
            return view.findViewById(i3);
        }
        throw new IllegalStateException("Fragment " + fragment + " does not have a view");
    }

    @Override // androidx.fragment.app.f0
    public final boolean c() {
        return this.f2260a.mView != null;
    }
}
