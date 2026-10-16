package androidx.fragment.app;

import android.app.Application;
import android.content.Context;
import android.content.ContextWrapper;
import androidx.lifecycle.Lifecycle$Event;

/* loaded from: classes.dex */
public final class l1 implements androidx.lifecycle.j, e2.f, androidx.lifecycle.r0 {

    /* renamed from: a, reason: collision with root package name */
    public final Fragment f2217a;

    /* renamed from: b, reason: collision with root package name */
    public final androidx.lifecycle.q0 f2218b;

    /* renamed from: c, reason: collision with root package name */
    public androidx.lifecycle.p0 f2219c;

    /* renamed from: d, reason: collision with root package name */
    public androidx.lifecycle.u f2220d = null;
    public e2.e e = null;

    public l1(Fragment fragment, androidx.lifecycle.q0 q0Var) {
        this.f2217a = fragment;
        this.f2218b = q0Var;
    }

    public final void a(Lifecycle$Event lifecycle$Event) {
        this.f2220d.e(lifecycle$Event);
    }

    public final void b() {
        if (this.f2220d == null) {
            this.f2220d = new androidx.lifecycle.u(this);
            this.e = new e2.e(this);
        }
    }

    @Override // androidx.lifecycle.j
    public final androidx.lifecycle.p0 getDefaultViewModelProviderFactory() {
        Application application;
        Fragment fragment = this.f2217a;
        androidx.lifecycle.p0 defaultViewModelProviderFactory = fragment.getDefaultViewModelProviderFactory();
        if (!defaultViewModelProviderFactory.equals(fragment.mDefaultFactory)) {
            this.f2219c = defaultViewModelProviderFactory;
            return defaultViewModelProviderFactory;
        }
        if (this.f2219c == null) {
            Context applicationContext = fragment.requireContext().getApplicationContext();
            while (true) {
                if (!(applicationContext instanceof ContextWrapper)) {
                    application = null;
                    break;
                }
                if (applicationContext instanceof Application) {
                    application = (Application) applicationContext;
                    break;
                }
                applicationContext = ((ContextWrapper) applicationContext).getBaseContext();
            }
            this.f2219c = new androidx.lifecycle.k0(application, this, fragment.getArguments());
        }
        return this.f2219c;
    }

    @Override // androidx.lifecycle.s
    public final androidx.lifecycle.n getLifecycle() {
        b();
        return this.f2220d;
    }

    @Override // e2.f
    public final e2.d getSavedStateRegistry() {
        b();
        return this.e.f12443b;
    }

    @Override // androidx.lifecycle.r0
    public final androidx.lifecycle.q0 getViewModelStore() {
        b();
        return this.f2218b;
    }
}
