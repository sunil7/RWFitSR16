package androidx.savedstate;

import android.os.Bundle;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.l;
import androidx.lifecycle.m0;
import androidx.lifecycle.q;
import androidx.lifecycle.q0;
import androidx.lifecycle.r0;
import androidx.lifecycle.s;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import e2.b;
import e2.d;
import e2.f;
import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class Recreator implements q {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2823a;

    public Recreator(f fVar) {
        this.f2823a = fVar;
    }

    /* JADX WARN: Type inference failed for: r9v3, types: [androidx.lifecycle.s, e2.f, java.lang.Object] */
    @Override // androidx.lifecycle.q
    public final void c(s sVar, Lifecycle$Event lifecycle$Event) {
        if (lifecycle$Event != Lifecycle$Event.ON_CREATE) {
            throw new AssertionError("Next event must be ON_CREATE");
        }
        sVar.getLifecycle().b(this);
        ?? r9 = this.f2823a;
        Bundle a3 = r9.getSavedStateRegistry().a("androidx.savedstate.Restarter");
        if (a3 == null) {
            return;
        }
        ArrayList<String> stringArrayList = a3.getStringArrayList("classes_to_restore");
        if (stringArrayList == null) {
            throw new IllegalStateException("Bundle with restored state for the component \"androidx.savedstate.Restarter\" must contain list of strings by the key \"classes_to_restore\"");
        }
        int size = stringArrayList.size();
        int i3 = 0;
        while (i3 < size) {
            String str = stringArrayList.get(i3);
            i3++;
            String str2 = str;
            try {
                Class<? extends U> asSubclass = Class.forName(str2, false, Recreator.class.getClassLoader()).asSubclass(b.class);
                e.e(asSubclass, "{\n                Class.…class.java)\n            }");
                try {
                    Constructor declaredConstructor = asSubclass.getDeclaredConstructor(null);
                    declaredConstructor.setAccessible(true);
                    try {
                        Object newInstance = declaredConstructor.newInstance(null);
                        e.e(newInstance, "{\n                constr…wInstance()\n            }");
                        q0 viewModelStore = ((r0) r9).getViewModelStore();
                        d savedStateRegistry = r9.getSavedStateRegistry();
                        viewModelStore.getClass();
                        HashMap hashMap = viewModelStore.f2386a;
                        Iterator it = new HashSet(hashMap.keySet()).iterator();
                        while (it.hasNext()) {
                            l.a((m0) hashMap.get((String) it.next()), savedStateRegistry, r9.getLifecycle());
                        }
                        if (!new HashSet(hashMap.keySet()).isEmpty()) {
                            savedStateRegistry.d();
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(l0.n("Failed to instantiate ", str2), e);
                    }
                } catch (NoSuchMethodException e10) {
                    throw new IllegalStateException("Class " + asSubclass.getSimpleName() + " must have default constructor in order to be automatically recreated", e10);
                }
            } catch (ClassNotFoundException e11) {
                throw new RuntimeException(l0.o("Class ", str2, " wasn't found"), e11);
            }
        }
    }
}
