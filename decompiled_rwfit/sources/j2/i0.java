package j2;

import android.view.ViewGroup;
import androidx.transition.R$id;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.z0;

/* loaded from: classes.dex */
public abstract class i0 {

    /* renamed from: a, reason: collision with root package name */
    public static final a f15230a = new a();

    /* renamed from: b, reason: collision with root package name */
    public static final ThreadLocal f15231b = new ThreadLocal();

    /* renamed from: c, reason: collision with root package name */
    public static final ArrayList f15232c = new ArrayList();

    public static void a(ViewGroup viewGroup, f0 f0Var) {
        ArrayList arrayList = f15232c;
        if (arrayList.contains(viewGroup)) {
            return;
        }
        WeakHashMap weakHashMap = z0.f15748a;
        if (l1.k0.c(viewGroup)) {
            arrayList.add(viewGroup);
            if (f0Var == null) {
                f0Var = f15230a;
            }
            f0 clone = f0Var.clone();
            ArrayList arrayList2 = (ArrayList) b().getOrDefault(viewGroup, null);
            if (arrayList2 != null && arrayList2.size() > 0) {
                int size = arrayList2.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList2.get(i3);
                    i3++;
                    ((f0) obj).v(viewGroup);
                }
            }
            if (clone != null) {
                clone.h(viewGroup, true);
            }
            if (viewGroup.getTag(R$id.transition_current_scene) != null) {
                throw new ClassCastException();
            }
            viewGroup.setTag(R$id.transition_current_scene, null);
            if (clone != null) {
                h0 h0Var = new h0();
                h0Var.f15225a = clone;
                h0Var.f15226b = viewGroup;
                viewGroup.addOnAttachStateChangeListener(h0Var);
                viewGroup.getViewTreeObserver().addOnPreDrawListener(h0Var);
            }
        }
    }

    public static m0.b b() {
        m0.b bVar;
        ThreadLocal threadLocal = f15231b;
        WeakReference weakReference = (WeakReference) threadLocal.get();
        if (weakReference != null && (bVar = (m0.b) weakReference.get()) != null) {
            return bVar;
        }
        m0.b bVar2 = new m0.b();
        threadLocal.set(new WeakReference(bVar2));
        return bVar2;
    }
}
