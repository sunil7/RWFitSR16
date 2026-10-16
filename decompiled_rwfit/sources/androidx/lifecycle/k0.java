package androidx.lifecycle;

import android.app.Application;
import android.os.Bundle;
import java.lang.reflect.Constructor;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public final class k0 implements p0 {

    /* renamed from: a, reason: collision with root package name */
    public final Application f2370a;

    /* renamed from: b, reason: collision with root package name */
    public final o0 f2371b;

    /* renamed from: c, reason: collision with root package name */
    public final Bundle f2372c;

    /* renamed from: d, reason: collision with root package name */
    public final n f2373d;
    public final e2.d e;

    public k0(Application application, e2.f fVar, Bundle bundle) {
        o0 o0Var;
        this.e = fVar.getSavedStateRegistry();
        this.f2373d = fVar.getLifecycle();
        this.f2372c = bundle;
        this.f2370a = application;
        if (application != null) {
            if (o0.e == null) {
                o0.e = new o0(application);
            }
            o0Var = o0.e;
            kotlin.jvm.internal.e.c(o0Var);
        } else {
            o0Var = new o0(null);
        }
        this.f2371b = o0Var;
    }

    public final m0 a(String str, Class cls) {
        n nVar = this.f2373d;
        if (nVar == null) {
            throw new UnsupportedOperationException("SavedStateViewModelFactory constructed with empty constructor supports only calls to create(modelClass: Class<T>, extras: CreationExtras).");
        }
        boolean isAssignableFrom = a.class.isAssignableFrom(cls);
        Application application = this.f2370a;
        Constructor a3 = (!isAssignableFrom || application == null) ? l0.a(cls, l0.f2378b) : l0.a(cls, l0.f2377a);
        if (a3 == null) {
            if (application != null) {
                return this.f2371b.d(cls);
            }
            if (n0.f2383c == null) {
                n0.f2383c = new n0();
            }
            n0 n0Var = n0.f2383c;
            kotlin.jvm.internal.e.c(n0Var);
            return n0Var.d(cls);
        }
        e2.d dVar = this.e;
        Bundle a10 = dVar.a(str);
        Class[] clsArr = h0.f2360f;
        h0 b3 = l.b(a10, this.f2372c);
        SavedStateHandleController savedStateHandleController = new SavedStateHandleController(str, b3);
        savedStateHandleController.f2338b = true;
        nVar.a(savedStateHandleController);
        dVar.c(str, b3.e);
        l.e(nVar, dVar);
        m0 b10 = (!isAssignableFrom || application == null) ? l0.b(cls, a3, b3) : l0.b(cls, a3, application, b3);
        b10.setTagIfAbsent("androidx.lifecycle.savedstate.vm.tag", savedStateHandleController);
        return b10;
    }

    @Override // androidx.lifecycle.p0
    public final m0 d(Class cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName != null) {
            return a(canonicalName, cls);
        }
        throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
    }

    @Override // androidx.lifecycle.p0
    public final m0 v(Class cls, w1.c cVar) {
        n0 n0Var = n0.f2382b;
        LinkedHashMap linkedHashMap = cVar.f19464a;
        String str = (String) linkedHashMap.get(n0Var);
        if (str == null) {
            throw new IllegalStateException("VIEW_MODEL_KEY must always be provided by ViewModelProvider");
        }
        if (linkedHashMap.get(l.f2374a) == null || linkedHashMap.get(l.f2375b) == null) {
            if (this.f2373d != null) {
                return a(str, cls);
            }
            throw new IllegalStateException("SAVED_STATE_REGISTRY_OWNER_KEY andVIEW_MODEL_STORE_OWNER_KEY must be provided in the creation extras tosuccessfully create a ViewModel.");
        }
        Application application = (Application) linkedHashMap.get(n0.f2381a);
        boolean isAssignableFrom = a.class.isAssignableFrom(cls);
        Constructor a3 = (!isAssignableFrom || application == null) ? l0.a(cls, l0.f2378b) : l0.a(cls, l0.f2377a);
        return a3 == null ? this.f2371b.v(cls, cVar) : (!isAssignableFrom || application == null) ? l0.b(cls, a3, l.c(cVar)) : l0.b(cls, a3, application, l.c(cVar));
    }
}
