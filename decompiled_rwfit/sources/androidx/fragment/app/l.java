package androidx.fragment.app;

import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.R$id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class l {

    /* renamed from: a, reason: collision with root package name */
    public final ViewGroup f2213a;

    /* renamed from: b, reason: collision with root package name */
    public final ArrayList f2214b = new ArrayList();

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2215c = new ArrayList();

    /* renamed from: d, reason: collision with root package name */
    public boolean f2216d = false;
    public boolean e = false;

    public l(ViewGroup viewGroup) {
        this.f2213a = viewGroup;
    }

    public static void a(View view, ArrayList arrayList) {
        if (!(view instanceof ViewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(view);
            return;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        if (l1.c1.b(viewGroup)) {
            if (arrayList.contains(view)) {
                return;
            }
            arrayList.add(viewGroup);
            return;
        }
        int childCount = viewGroup.getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = viewGroup.getChildAt(i3);
            if (childAt.getVisibility() == 0) {
                a(childAt, arrayList);
            }
        }
    }

    public static void e(m0.b bVar, View view) {
        WeakHashMap weakHashMap = l1.z0.f15748a;
        String k10 = l1.n0.k(view);
        if (k10 != null) {
            bVar.put(k10, view);
        }
        if (view instanceof ViewGroup) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = viewGroup.getChildAt(i3);
                if (childAt.getVisibility() == 0) {
                    e(bVar, childAt);
                }
            }
        }
    }

    public static l h(ViewGroup viewGroup, l0 l0Var) {
        Object tag = viewGroup.getTag(R$id.special_effects_controller_view_tag);
        if (tag instanceof l) {
            return (l) tag;
        }
        l0Var.getClass();
        l lVar = new l(viewGroup);
        viewGroup.setTag(R$id.special_effects_controller_view_tag, lVar);
        return lVar;
    }

    public static l i(ViewGroup viewGroup, t0 t0Var) {
        return h(viewGroup, t0Var.z());
    }

    public static void k(m0.b bVar, Collection collection) {
        Iterator it = ((m0.h) bVar.entrySet()).iterator();
        while (true) {
            m0.i iVar = (m0.i) it;
            if (!iVar.hasNext()) {
                return;
            }
            iVar.next();
            View view = (View) iVar.getValue();
            WeakHashMap weakHashMap = l1.z0.f15748a;
            if (!collection.contains(l1.n0.k(view))) {
                iVar.remove();
            }
        }
    }

    public final void b(SpecialEffectsController$Operation$State specialEffectsController$Operation$State, SpecialEffectsController$Operation$LifecycleImpact specialEffectsController$Operation$LifecycleImpact, a1 a1Var) {
        synchronized (this.f2214b) {
            try {
                h1.d dVar = new h1.d();
                p1 f2 = f(a1Var.f2145c);
                if (f2 != null) {
                    f2.c(specialEffectsController$Operation$State, specialEffectsController$Operation$LifecycleImpact);
                    return;
                }
                p1 p1Var = new p1(specialEffectsController$Operation$State, specialEffectsController$Operation$LifecycleImpact, a1Var, dVar);
                this.f2214b.add(p1Var);
                p1Var.f2254d.add(new n1(this, p1Var, 0));
                p1Var.f2254d.add(new n1(this, p1Var, 1));
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0632  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x06c8 A[LOOP:6: B:139:0x06c6->B:140:0x06c8, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0589  */
    /* JADX WARN: Type inference failed for: r10v5, types: [m0.k] */
    /* JADX WARN: Type inference failed for: r10v6 */
    /* JADX WARN: Type inference failed for: r10v7 */
    /* JADX WARN: Type inference failed for: r12v41 */
    /* JADX WARN: Type inference failed for: r12v42, types: [boolean] */
    /* JADX WARN: Type inference failed for: r12v44 */
    /* JADX WARN: Type inference failed for: r22v3 */
    /* JADX WARN: Type inference failed for: r22v4, types: [boolean] */
    /* JADX WARN: Type inference failed for: r22v5 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void c(java.util.ArrayList r38, boolean r39) {
        /*
            Method dump skipped, instructions count: 1760
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.fragment.app.l.c(java.util.ArrayList, boolean):void");
    }

    public final void d() {
        if (this.e) {
            return;
        }
        ViewGroup viewGroup = this.f2213a;
        WeakHashMap weakHashMap = l1.z0.f15748a;
        if (!l1.k0.b(viewGroup)) {
            g();
            this.f2216d = false;
            return;
        }
        synchronized (this.f2214b) {
            try {
                if (!this.f2214b.isEmpty()) {
                    ArrayList arrayList = new ArrayList(this.f2215c);
                    this.f2215c.clear();
                    int size = arrayList.size();
                    int i3 = 0;
                    while (i3 < size) {
                        Object obj = arrayList.get(i3);
                        i3++;
                        p1 p1Var = (p1) obj;
                        if (t0.B(2)) {
                            Log.v("FragmentManager", "SpecialEffectsController: Cancelling operation " + p1Var);
                        }
                        p1Var.a();
                        if (!p1Var.f2256g) {
                            this.f2215c.add(p1Var);
                        }
                    }
                    l();
                    ArrayList arrayList2 = new ArrayList(this.f2214b);
                    this.f2214b.clear();
                    this.f2215c.addAll(arrayList2);
                    int size2 = arrayList2.size();
                    int i10 = 0;
                    while (i10 < size2) {
                        Object obj2 = arrayList2.get(i10);
                        i10++;
                        ((p1) obj2).d();
                    }
                    c(arrayList2, this.f2216d);
                    this.f2216d = false;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final p1 f(Fragment fragment) {
        ArrayList arrayList = this.f2214b;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            p1 p1Var = (p1) obj;
            if (p1Var.f2253c.equals(fragment) && !p1Var.f2255f) {
                return p1Var;
            }
        }
        return null;
    }

    public final void g() {
        String str;
        String str2;
        ViewGroup viewGroup = this.f2213a;
        WeakHashMap weakHashMap = l1.z0.f15748a;
        boolean b3 = l1.k0.b(viewGroup);
        synchronized (this.f2214b) {
            try {
                l();
                ArrayList arrayList = this.f2214b;
                int size = arrayList.size();
                int i3 = 0;
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((p1) obj).d();
                }
                ArrayList arrayList2 = new ArrayList(this.f2215c);
                int size2 = arrayList2.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj2 = arrayList2.get(i11);
                    i11++;
                    p1 p1Var = (p1) obj2;
                    if (t0.B(2)) {
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append("SpecialEffectsController: ");
                        if (b3) {
                            str2 = "";
                        } else {
                            str2 = "Container " + this.f2213a + " is not attached to window. ";
                        }
                        sb2.append(str2);
                        sb2.append("Cancelling running operation ");
                        sb2.append(p1Var);
                        Log.v("FragmentManager", sb2.toString());
                    }
                    p1Var.a();
                }
                ArrayList arrayList3 = new ArrayList(this.f2214b);
                int size3 = arrayList3.size();
                while (i3 < size3) {
                    Object obj3 = arrayList3.get(i3);
                    i3++;
                    p1 p1Var2 = (p1) obj3;
                    if (t0.B(2)) {
                        StringBuilder sb3 = new StringBuilder();
                        sb3.append("SpecialEffectsController: ");
                        if (b3) {
                            str = "";
                        } else {
                            str = "Container " + this.f2213a + " is not attached to window. ";
                        }
                        sb3.append(str);
                        sb3.append("Cancelling pending operation ");
                        sb3.append(p1Var2);
                        Log.v("FragmentManager", sb3.toString());
                    }
                    p1Var2.a();
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void j() {
        synchronized (this.f2214b) {
            try {
                l();
                this.e = false;
                int size = this.f2214b.size() - 1;
                while (true) {
                    if (size < 0) {
                        break;
                    }
                    p1 p1Var = (p1) this.f2214b.get(size);
                    SpecialEffectsController$Operation$State from = SpecialEffectsController$Operation$State.from(p1Var.f2253c.mView);
                    SpecialEffectsController$Operation$State specialEffectsController$Operation$State = p1Var.f2251a;
                    SpecialEffectsController$Operation$State specialEffectsController$Operation$State2 = SpecialEffectsController$Operation$State.VISIBLE;
                    if (specialEffectsController$Operation$State == specialEffectsController$Operation$State2 && from != specialEffectsController$Operation$State2) {
                        this.e = p1Var.f2253c.isPostponed();
                        break;
                    }
                    size--;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final void l() {
        ArrayList arrayList = this.f2214b;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            p1 p1Var = (p1) obj;
            if (p1Var.f2252b == SpecialEffectsController$Operation$LifecycleImpact.ADDING) {
                p1Var.c(SpecialEffectsController$Operation$State.from(p1Var.f2253c.requireView().getVisibility()), SpecialEffectsController$Operation$LifecycleImpact.NONE);
            }
        }
    }
}
