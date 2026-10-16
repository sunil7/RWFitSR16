package androidx.fragment.app;

import java.util.ArrayList;

/* loaded from: classes.dex */
public final class r0 implements q0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f2261a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ t0 f2262b;

    public r0(t0 t0Var, int i3) {
        this.f2262b = t0Var;
        this.f2261a = i3;
    }

    @Override // androidx.fragment.app.q0
    public final boolean a(ArrayList arrayList, ArrayList arrayList2) {
        t0 t0Var = this.f2262b;
        Fragment fragment = t0Var.r;
        int i3 = this.f2261a;
        if (fragment == null || i3 >= 0 || !fragment.getChildFragmentManager().G()) {
            return t0Var.H(arrayList, arrayList2, i3, 1);
        }
        return false;
    }
}
