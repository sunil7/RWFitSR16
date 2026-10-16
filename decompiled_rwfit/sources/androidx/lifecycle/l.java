package androidx.lifecycle;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;

/* loaded from: classes.dex */
public abstract class l {

    /* renamed from: a, reason: collision with root package name */
    public static final n0 f2374a = new n0();

    /* renamed from: b, reason: collision with root package name */
    public static final n0 f2375b = new n0();

    /* renamed from: c, reason: collision with root package name */
    public static final n0 f2376c = new n0();

    public static void a(m0 m0Var, e2.d dVar, n nVar) {
        boolean z5;
        SavedStateHandleController savedStateHandleController = (SavedStateHandleController) m0Var.getTag("androidx.lifecycle.savedstate.vm.tag");
        if (savedStateHandleController == null || (z5 = savedStateHandleController.f2338b)) {
            return;
        }
        if (z5) {
            throw new IllegalStateException("Already attached to lifecycleOwner");
        }
        savedStateHandleController.f2338b = true;
        nVar.a(savedStateHandleController);
        dVar.c(savedStateHandleController.f2337a, savedStateHandleController.f2339c.e);
        e(nVar, dVar);
    }

    public static h0 b(Bundle bundle, Bundle bundle2) {
        if (bundle == null) {
            if (bundle2 == null) {
                return new h0();
            }
            HashMap hashMap = new HashMap();
            for (String key : bundle2.keySet()) {
                kotlin.jvm.internal.e.e(key, "key");
                hashMap.put(key, bundle2.get(key));
            }
            return new h0(hashMap);
        }
        ArrayList parcelableArrayList = bundle.getParcelableArrayList("keys");
        ArrayList parcelableArrayList2 = bundle.getParcelableArrayList("values");
        if (parcelableArrayList == null || parcelableArrayList2 == null || parcelableArrayList.size() != parcelableArrayList2.size()) {
            throw new IllegalStateException("Invalid bundle passed as restored state");
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int size = parcelableArrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            Object obj = parcelableArrayList.get(i3);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            linkedHashMap.put((String) obj, parcelableArrayList2.get(i3));
        }
        return new h0(linkedHashMap);
    }

    public static final h0 c(w1.c cVar) {
        n0 n0Var = f2374a;
        LinkedHashMap linkedHashMap = cVar.f19464a;
        e2.f fVar = (e2.f) linkedHashMap.get(n0Var);
        if (fVar == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `SAVED_STATE_REGISTRY_OWNER_KEY`");
        }
        r0 r0Var = (r0) linkedHashMap.get(f2375b);
        if (r0Var == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_STORE_OWNER_KEY`");
        }
        Bundle bundle = (Bundle) linkedHashMap.get(f2376c);
        String str = (String) linkedHashMap.get(n0.f2382b);
        if (str == null) {
            throw new IllegalArgumentException("CreationExtras must have a value by `VIEW_MODEL_KEY`");
        }
        e2.c b3 = fVar.getSavedStateRegistry().b();
        i0 i0Var = b3 instanceof i0 ? (i0) b3 : null;
        if (i0Var == null) {
            throw new IllegalStateException("enableSavedStateHandles() wasn't called prior to createSavedStateHandle() call");
        }
        j0 d5 = d(r0Var);
        h0 h0Var = (h0) d5.f2369a.get(str);
        if (h0Var != null) {
            return h0Var;
        }
        Class[] clsArr = h0.f2360f;
        if (!i0Var.f2366b) {
            i0Var.f2367c = i0Var.f2365a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
            i0Var.f2366b = true;
        }
        Bundle bundle2 = i0Var.f2367c;
        Bundle bundle3 = bundle2 != null ? bundle2.getBundle(str) : null;
        Bundle bundle4 = i0Var.f2367c;
        if (bundle4 != null) {
            bundle4.remove(str);
        }
        Bundle bundle5 = i0Var.f2367c;
        if (bundle5 != null && bundle5.isEmpty()) {
            i0Var.f2367c = null;
        }
        h0 b10 = b(bundle3, bundle);
        d5.f2369a.put(str, b10);
        return b10;
    }

    public static final j0 d(r0 r0Var) {
        w1.b bVar;
        kotlin.jvm.internal.e.f(r0Var, "<this>");
        ArrayList arrayList = new ArrayList();
        SavedStateHandleSupport$savedStateHandlesVM$1$1 initializer = new oh.l() { // from class: androidx.lifecycle.SavedStateHandleSupport$savedStateHandlesVM$1$1
            @Override // oh.l
            public final j0 invoke(w1.b initializer2) {
                kotlin.jvm.internal.e.f(initializer2, "$this$initializer");
                return new j0();
            }
        };
        kotlin.jvm.internal.b a3 = kotlin.jvm.internal.g.a(j0.class);
        kotlin.jvm.internal.e.f(initializer, "initializer");
        Class a10 = a3.a();
        kotlin.jvm.internal.e.d(a10, "null cannot be cast to non-null type java.lang.Class<T of kotlin.jvm.JvmClassMappingKt.<get-java>>");
        arrayList.add(new w1.d(a10, initializer));
        Object[] array = arrayList.toArray(new w1.d[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        w1.d[] dVarArr = (w1.d[]) array;
        n.m0 m0Var = new n.m0((w1.d[]) Arrays.copyOf(dVarArr, dVarArr.length));
        q0 viewModelStore = r0Var.getViewModelStore();
        kotlin.jvm.internal.e.e(viewModelStore, "owner.viewModelStore");
        if (r0Var instanceof j) {
            bVar = ((j) r0Var).getDefaultViewModelCreationExtras();
            kotlin.jvm.internal.e.e(bVar, "{\n        owner.defaultV…ModelCreationExtras\n    }");
        } else {
            bVar = w1.a.f19463b;
        }
        return (j0) new de.o(viewModelStore, m0Var, bVar).r("androidx.lifecycle.internal.SavedStateHandlesVM", j0.class);
    }

    public static void e(final n nVar, final e2.d dVar) {
        Lifecycle$State lifecycle$State = ((u) nVar).f2390b;
        if (lifecycle$State == Lifecycle$State.INITIALIZED || lifecycle$State.isAtLeast(Lifecycle$State.STARTED)) {
            dVar.d();
        } else {
            nVar.a(new q() { // from class: androidx.lifecycle.LegacySavedStateHandleController$1
                @Override // androidx.lifecycle.q
                public final void c(s sVar, Lifecycle$Event lifecycle$Event) {
                    if (lifecycle$Event == Lifecycle$Event.ON_START) {
                        n.this.b(this);
                        dVar.d();
                    }
                }
            });
        }
    }
}
