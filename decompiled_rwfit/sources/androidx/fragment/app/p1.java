package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: classes.dex */
public final class p1 {

    /* renamed from: a, reason: collision with root package name */
    public SpecialEffectsController$Operation$State f2251a;

    /* renamed from: b, reason: collision with root package name */
    public SpecialEffectsController$Operation$LifecycleImpact f2252b;

    /* renamed from: c, reason: collision with root package name */
    public final Fragment f2253c;

    /* renamed from: d, reason: collision with root package name */
    public final ArrayList f2254d = new ArrayList();
    public final HashSet e = new HashSet();

    /* renamed from: f, reason: collision with root package name */
    public boolean f2255f = false;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2256g = false;

    /* renamed from: h, reason: collision with root package name */
    public final a1 f2257h;

    public p1(SpecialEffectsController$Operation$State specialEffectsController$Operation$State, SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact, a1 a1Var, h1.d dVar) {
        this.f2251a = specialEffectsController$Operation$State;
        this.f2252b = specialEffectsController$Operation$LifecycleImpact;
        this.f2253c = a1Var.f2145c;
        dVar.setOnCancelListener(new s(this, 5));
        this.f2257h = a1Var;
    }

    public final void a() {
        if (this.f2255f) {
            return;
        }
        this.f2255f = true;
        HashSet hashSet = this.e;
        if (hashSet.isEmpty()) {
            b();
            return;
        }
        ArrayList arrayList = new ArrayList(hashSet);
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            h1.d dVar = (h1.d) obj;
            synchronized (dVar) {
                try {
                    if (!dVar.f14248a) {
                        dVar.f14248a = true;
                        dVar.f14250c = true;
                        h1.c cVar = dVar.f14249b;
                        if (cVar != null) {
                            try {
                                cVar.onCancel();
                            } catch (Throwable th2) {
                                synchronized (dVar) {
                                    dVar.f14250c = false;
                                    dVar.notifyAll();
                                    throw th2;
                                }
                            }
                        }
                        synchronized (dVar) {
                            dVar.f14250c = false;
                            dVar.notifyAll();
                        }
                    }
                } finally {
                }
            }
        }
    }

    public final void b() {
        if (!this.f2256g) {
            if (t0.B(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: " + this + " has called complete.");
            }
            this.f2256g = true;
            ArrayList arrayList = this.f2254d;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                ((Runnable) obj).run();
            }
        }
        this.f2257h.j();
    }

    public final void c(SpecialEffectsController$Operation$State specialEffectsController$Operation$State, SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact) {
        int i3 = o1.f2235b[specialEffectsController$Operation$LifecycleImpact.ordinal()];
        Fragment fragment = this.f2253c;
        if (i3 == 1) {
            if (this.f2251a == SpecialEffectsController$Operation$State.REMOVED) {
                if (t0.B(2)) {
                    Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = REMOVED -> VISIBLE. mLifecycleImpact = " + this.f2252b + " to ADDING.");
                }
                this.f2251a = SpecialEffectsController$Operation$State.VISIBLE;
                this.f2252b = SpecialEffectsController$Operation$LifecycleImpact.ADDING;
                return;
            }
            return;
        }
        if (i3 == 2) {
            if (t0.B(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + this.f2251a + " -> REMOVED. mLifecycleImpact  = " + this.f2252b + " to REMOVING.");
            }
            this.f2251a = SpecialEffectsController$Operation$State.REMOVED;
            this.f2252b = SpecialEffectsController$Operation$LifecycleImpact.REMOVING;
            return;
        }
        if (i3 == 3 && this.f2251a != SpecialEffectsController$Operation$State.REMOVED) {
            if (t0.B(2)) {
                Log.v("FragmentManager", "SpecialEffectsController: For fragment " + fragment + " mFinalState = " + this.f2251a + " -> " + specialEffectsController$Operation$State + ". ");
            }
            this.f2251a = specialEffectsController$Operation$State;
        }
    }

    public final void d() {
        if (this.f2252b == SpecialEffectsController$Operation$LifecycleImpact.ADDING) {
            a1 a1Var = this.f2257h;
            Fragment fragment = a1Var.f2145c;
            View findFocus = fragment.mView.findFocus();
            if (findFocus != null) {
                fragment.setFocusedView(findFocus);
                if (t0.B(2)) {
                    Log.v("FragmentManager", "requestFocus: Saved focused view " + findFocus + " for Fragment " + fragment);
                }
            }
            View requireView = this.f2253c.requireView();
            if (requireView.getParent() == null) {
                a1Var.a();
                requireView.setAlpha(0.0f);
            }
            if (requireView.getAlpha() == 0.0f && requireView.getVisibility() == 0) {
                requireView.setVisibility(4);
            }
            requireView.setAlpha(fragment.getPostOnViewCreatedAlpha());
        }
    }

    public final String toString() {
        return "Operation {" + Integer.toHexString(System.identityHashCode(this)) + "} {mFinalState = " + this.f2251a + "} {mLifecycleImpact = " + this.f2252b + "} {mFragment = " + this.f2253c + "}";
    }
}
