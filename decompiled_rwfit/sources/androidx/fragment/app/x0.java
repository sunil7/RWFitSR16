package androidx.fragment.app;

import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* loaded from: classes.dex */
public abstract class x0 extends n2.a {

    /* renamed from: c, reason: collision with root package name */
    public final t0 f2320c;

    /* renamed from: d, reason: collision with root package name */
    public a f2321d = null;
    public Fragment e = null;

    /* renamed from: f, reason: collision with root package name */
    public boolean f2322f;

    public x0(t0 t0Var) {
        this.f2320c = t0Var;
    }

    @Override // n2.a
    public final void a(ViewPager viewPager, int i3, Object obj) {
        Fragment fragment = (Fragment) obj;
        if (this.f2321d == null) {
            t0 t0Var = this.f2320c;
            t0Var.getClass();
            this.f2321d = new a(t0Var);
        }
        a aVar = this.f2321d;
        aVar.getClass();
        t0 t0Var2 = fragment.mFragmentManager;
        if (t0Var2 != null && t0Var2 != aVar.f2140p) {
            throw new IllegalStateException("Cannot detach Fragment attached to a different FragmentManager. Fragment " + fragment.toString() + " is already attached to a FragmentManager.");
        }
        aVar.b(new d1(fragment, 6));
        if (fragment.equals(this.e)) {
            this.e = null;
        }
    }

    @Override // n2.a
    public final void b() {
        a aVar = this.f2321d;
        if (aVar != null) {
            if (!this.f2322f) {
                try {
                    this.f2322f = true;
                    if (aVar.f2131g) {
                        throw new IllegalStateException("This transaction is already being added to the back stack");
                    }
                    aVar.f2140p.t(aVar, true);
                } finally {
                    this.f2322f = false;
                }
            }
            this.f2321d = null;
        }
    }

    @Override // n2.a
    public final Object f(ViewPager viewPager, int i3) {
        a aVar = this.f2321d;
        t0 t0Var = this.f2320c;
        if (aVar == null) {
            t0Var.getClass();
            this.f2321d = new a(t0Var);
        }
        long l3 = l(i3);
        Fragment w8 = t0Var.w("android:switcher:" + viewPager.getId() + ":" + l3);
        if (w8 != null) {
            a aVar2 = this.f2321d;
            aVar2.getClass();
            aVar2.b(new d1(w8, 7));
        } else {
            w8 = k(i3);
            this.f2321d.e(viewPager.getId(), w8, "android:switcher:" + viewPager.getId() + ":" + l3, 1);
        }
        if (w8 != this.e) {
            w8.setMenuVisibility(false);
            w8.setUserVisibleHint(false);
        }
        return w8;
    }

    @Override // n2.a
    public final boolean g(View view, Object obj) {
        return ((Fragment) obj).getView() == view;
    }

    @Override // n2.a
    public final void i(Object obj) {
        Fragment fragment = (Fragment) obj;
        Fragment fragment2 = this.e;
        if (fragment != fragment2) {
            if (fragment2 != null) {
                fragment2.setMenuVisibility(false);
                this.e.setUserVisibleHint(false);
            }
            fragment.setMenuVisibility(true);
            fragment.setUserVisibleHint(true);
            this.e = fragment;
        }
    }

    @Override // n2.a
    public final void j(ViewPager viewPager) {
        if (viewPager.getId() != -1) {
            return;
        }
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }

    public abstract Fragment k(int i3);

    public long l(int i3) {
        return i3;
    }
}
