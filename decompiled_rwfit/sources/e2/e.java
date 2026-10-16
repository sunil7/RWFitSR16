package e2;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.Lifecycle$State;
import androidx.lifecycle.n;
import androidx.lifecycle.q;
import androidx.lifecycle.s;
import androidx.lifecycle.u;
import androidx.savedstate.Recreator;
import java.util.Map;

/* loaded from: classes.dex */
public final class e {

    /* renamed from: a, reason: collision with root package name */
    public final Object f12442a;

    /* renamed from: b, reason: collision with root package name */
    public final d f12443b = new d();

    /* renamed from: c, reason: collision with root package name */
    public boolean f12444c;

    public e(f fVar) {
        this.f12442a = fVar;
    }

    /* JADX WARN: Type inference failed for: r0v0, types: [androidx.lifecycle.s, e2.f, java.lang.Object] */
    public final void a() {
        ?? r02 = this.f12442a;
        n lifecycle = r02.getLifecycle();
        kotlin.jvm.internal.e.e(lifecycle, "owner.lifecycle");
        if (((u) lifecycle).f2390b != Lifecycle$State.INITIALIZED) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Recreator(r02));
        final d dVar = this.f12443b;
        dVar.getClass();
        if (dVar.f12438b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.a(new q() { // from class: e2.a
            @Override // androidx.lifecycle.q
            public final void c(s sVar, Lifecycle$Event lifecycle$Event) {
                d this$0 = d.this;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (lifecycle$Event == Lifecycle$Event.ON_START) {
                    this$0.f12441f = true;
                } else if (lifecycle$Event == Lifecycle$Event.ON_STOP) {
                    this$0.f12441f = false;
                }
            }
        });
        dVar.f12438b = true;
        this.f12444c = true;
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [androidx.lifecycle.s, java.lang.Object] */
    public final void b(Bundle bundle) {
        if (!this.f12444c) {
            a();
        }
        n lifecycle = this.f12442a.getLifecycle();
        kotlin.jvm.internal.e.e(lifecycle, "owner.lifecycle");
        u uVar = (u) lifecycle;
        if (uVar.f2390b.isAtLeast(Lifecycle$State.STARTED)) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + uVar.f2390b).toString());
        }
        d dVar = this.f12443b;
        if (!dVar.f12438b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (dVar.f12440d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        dVar.f12439c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        dVar.f12440d = true;
    }

    public final void c(Bundle outBundle) {
        kotlin.jvm.internal.e.f(outBundle, "outBundle");
        d dVar = this.f12443b;
        dVar.getClass();
        Bundle bundle = new Bundle();
        Bundle bundle2 = dVar.f12439c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        j.f fVar = dVar.f12437a;
        fVar.getClass();
        j.d dVar2 = new j.d(fVar);
        fVar.f15160c.put(dVar2, Boolean.FALSE);
        while (dVar2.hasNext()) {
            Map.Entry entry = (Map.Entry) dVar2.next();
            bundle.putBundle((String) entry.getKey(), ((c) entry.getValue()).a());
        }
        if (bundle.isEmpty()) {
            return;
        }
        outBundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle);
    }
}
