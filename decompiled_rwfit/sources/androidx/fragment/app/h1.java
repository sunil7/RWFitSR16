package androidx.fragment.app;

import android.transition.Transition;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class h1 implements Transition.TransitionListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Object f2193a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2194b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ Object f2195c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2196d;
    public final /* synthetic */ Object e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2197f;

    /* renamed from: g, reason: collision with root package name */
    public final /* synthetic */ j1 f2198g;

    public h1(j1 j1Var, Object obj, ArrayList arrayList, Object obj2, ArrayList arrayList2, Object obj3, ArrayList arrayList3) {
        this.f2198g = j1Var;
        this.f2193a = obj;
        this.f2194b = arrayList;
        this.f2195c = obj2;
        this.f2196d = arrayList2;
        this.e = obj3;
        this.f2197f = arrayList3;
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionCancel(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionEnd(Transition transition) {
        transition.removeListener(this);
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionPause(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionResume(Transition transition) {
    }

    @Override // android.transition.Transition.TransitionListener
    public final void onTransitionStart(Transition transition) {
        j1 j1Var = this.f2198g;
        Object obj = this.f2193a;
        if (obj != null) {
            j1Var.t(obj, this.f2194b, null);
        }
        Object obj2 = this.f2195c;
        if (obj2 != null) {
            j1Var.t(obj2, this.f2196d, null);
        }
        Object obj3 = this.e;
        if (obj3 != null) {
            j1Var.t(obj3, this.f2197f, null);
        }
    }
}
