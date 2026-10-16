package androidx.fragment.app;

import android.animation.Animator;
import android.util.Log;
import android.view.View;

/* loaded from: classes.dex */
public final class s implements k.a, h1.c, androidx.lifecycle.c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2263a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f2264b;

    public /* synthetic */ s(Object obj, int i3) {
        this.f2263a = i3;
        this.f2264b = obj;
    }

    public void a() {
        ((b0) this.f2264b).f2184d.F();
    }

    @Override // k.a
    public Object apply(Object obj) {
        switch (this.f2263a) {
            case 0:
                Fragment fragment = (Fragment) this.f2264b;
                Object obj2 = fragment.mHost;
                return obj2 instanceof androidx.activity.result.g ? ((androidx.activity.result.g) obj2).Z() : fragment.requireActivity().f338j;
            default:
                return (androidx.activity.result.f) this.f2264b;
        }
    }

    @Override // androidx.lifecycle.c0
    public void i(Object obj) {
        if (((androidx.lifecycle.s) obj) != null) {
            p pVar = (p) this.f2264b;
            if (pVar.f2242h) {
                View requireView = pVar.requireView();
                if (requireView.getParent() != null) {
                    throw new IllegalStateException("DialogFragment can not be attached to a container view");
                }
                if (pVar.f2246l != null) {
                    if (t0.B(3)) {
                        Log.d("FragmentManager", "DialogFragment " + this + " setting the content view on " + pVar.f2246l);
                    }
                    pVar.f2246l.setContentView(requireView);
                }
            }
        }
    }

    @Override // h1.c
    public void onCancel() {
        switch (this.f2263a) {
            case 1:
                ((Animator) this.f2264b).end();
                break;
            default:
                ((p1) this.f2264b).a();
                break;
        }
    }
}
