package j2;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.k1;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class v extends k1 {
    @Override // androidx.fragment.app.k1
    public final void a(View view, Object obj) {
        if (obj != null) {
            ((f0) obj).b(view);
        }
    }

    @Override // androidx.fragment.app.k1
    public final void b(Object obj, ArrayList arrayList) {
        f0 f0Var = (f0) obj;
        if (f0Var == null) {
            return;
        }
        int i3 = 0;
        if (f0Var instanceof j0) {
            j0 j0Var = (j0) f0Var;
            int size = j0Var.f15240x.size();
            while (i3 < size) {
                b((i3 < 0 || i3 >= j0Var.f15240x.size()) ? null : (f0) j0Var.f15240x.get(i3), arrayList);
                i3++;
            }
            return;
        }
        if (k1.h(f0Var.e) && k1.h(f0Var.f15210f)) {
            int size2 = arrayList.size();
            while (i3 < size2) {
                f0Var.b((View) arrayList.get(i3));
                i3++;
            }
        }
    }

    @Override // androidx.fragment.app.k1
    public final void c(ViewGroup viewGroup, Object obj) {
        i0.a(viewGroup, (f0) obj);
    }

    @Override // androidx.fragment.app.k1
    public final boolean e(Object obj) {
        return obj instanceof f0;
    }

    @Override // androidx.fragment.app.k1
    public final Object f(Object obj) {
        if (obj != null) {
            return ((f0) obj).clone();
        }
        return null;
    }

    @Override // androidx.fragment.app.k1
    public final Object i(Object obj, Object obj2, Object obj3) {
        f0 f0Var = (f0) obj;
        f0 f0Var2 = (f0) obj2;
        f0 f0Var3 = (f0) obj3;
        if (f0Var != null && f0Var2 != null) {
            j0 j0Var = new j0();
            j0Var.I(f0Var);
            j0Var.I(f0Var2);
            j0Var.L(1);
            f0Var = j0Var;
        } else if (f0Var == null) {
            f0Var = f0Var2 != null ? f0Var2 : null;
        }
        if (f0Var3 == null) {
            return f0Var;
        }
        j0 j0Var2 = new j0();
        if (f0Var != null) {
            j0Var2.I(f0Var);
        }
        j0Var2.I(f0Var3);
        return j0Var2;
    }

    @Override // androidx.fragment.app.k1
    public final Object j(Object obj, Object obj2, Object obj3) {
        j0 j0Var = new j0();
        if (obj != null) {
            j0Var.I((f0) obj);
        }
        if (obj2 != null) {
            j0Var.I((f0) obj2);
        }
        if (obj3 != null) {
            j0Var.I((f0) obj3);
        }
        return j0Var;
    }

    @Override // androidx.fragment.app.k1
    public final void k(Object obj, View view, ArrayList arrayList) {
        ((f0) obj).a(new s(view, arrayList));
    }

    @Override // androidx.fragment.app.k1
    public final void l(Object obj, Object obj2, ArrayList arrayList, Object obj3, ArrayList arrayList2, Object obj4, ArrayList arrayList3) {
        ((f0) obj).a(new t(this, obj2, arrayList, obj3, arrayList2, obj4, arrayList3));
    }

    @Override // androidx.fragment.app.k1
    public final void m(View view, Object obj) {
        if (view != null) {
            k1.g(view, new Rect());
            ((f0) obj).B(new r());
        }
    }

    @Override // androidx.fragment.app.k1
    public final void n(Object obj, Rect rect) {
        if (obj != null) {
            ((f0) obj).B(new r());
        }
    }

    @Override // androidx.fragment.app.k1
    public final void o(Object obj, h1.d dVar, Runnable runnable) {
        f0 f0Var = (f0) obj;
        dVar.setOnCancelListener(new com.example.test.ui.device.activity.e0(f0Var, 21));
        f0Var.a(new u(runnable));
    }

    @Override // androidx.fragment.app.k1
    public final void p(Object obj, View view, ArrayList arrayList) {
        j0 j0Var = (j0) obj;
        ArrayList arrayList2 = j0Var.f15210f;
        arrayList2.clear();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            k1.d((View) arrayList.get(i3), arrayList2);
        }
        arrayList2.add(view);
        arrayList.add(view);
        b(j0Var, arrayList);
    }

    @Override // androidx.fragment.app.k1
    public final void q(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        j0 j0Var = (j0) obj;
        if (j0Var != null) {
            ArrayList arrayList3 = j0Var.f15210f;
            arrayList3.clear();
            arrayList3.addAll(arrayList2);
            s(j0Var, arrayList, arrayList2);
        }
    }

    @Override // androidx.fragment.app.k1
    public final Object r(Object obj) {
        if (obj == null) {
            return null;
        }
        j0 j0Var = new j0();
        j0Var.I((f0) obj);
        return j0Var;
    }

    public final void s(Object obj, ArrayList arrayList, ArrayList arrayList2) {
        f0 f0Var = (f0) obj;
        int i3 = 0;
        if (f0Var instanceof j0) {
            j0 j0Var = (j0) f0Var;
            int size = j0Var.f15240x.size();
            while (i3 < size) {
                s((i3 < 0 || i3 >= j0Var.f15240x.size()) ? null : (f0) j0Var.f15240x.get(i3), arrayList, arrayList2);
                i3++;
            }
            return;
        }
        if (k1.h(f0Var.e)) {
            ArrayList arrayList3 = f0Var.f15210f;
            if (arrayList3.size() == arrayList.size() && arrayList3.containsAll(arrayList)) {
                int size2 = arrayList2 == null ? 0 : arrayList2.size();
                while (i3 < size2) {
                    f0Var.b((View) arrayList2.get(i3));
                    i3++;
                }
                for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                    f0Var.x((View) arrayList.get(size3));
                }
            }
        }
    }
}
