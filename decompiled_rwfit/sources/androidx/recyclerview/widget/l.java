package androidx.recyclerview.widget;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class l extends f1 {

    /* renamed from: s, reason: collision with root package name */
    public static TimeInterpolator f2650s;

    /* renamed from: g, reason: collision with root package name */
    public boolean f2651g;

    /* renamed from: h, reason: collision with root package name */
    public ArrayList f2652h;

    /* renamed from: i, reason: collision with root package name */
    public ArrayList f2653i;

    /* renamed from: j, reason: collision with root package name */
    public ArrayList f2654j;

    /* renamed from: k, reason: collision with root package name */
    public ArrayList f2655k;

    /* renamed from: l, reason: collision with root package name */
    public ArrayList f2656l;

    /* renamed from: m, reason: collision with root package name */
    public ArrayList f2657m;

    /* renamed from: n, reason: collision with root package name */
    public ArrayList f2658n;

    /* renamed from: o, reason: collision with root package name */
    public ArrayList f2659o;

    /* renamed from: p, reason: collision with root package name */
    public ArrayList f2660p;

    /* renamed from: q, reason: collision with root package name */
    public ArrayList f2661q;
    public ArrayList r;

    public static void h(ArrayList arrayList) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            ((z1) arrayList.get(size)).itemView.animate().cancel();
        }
    }

    @Override // androidx.recyclerview.widget.f1
    public final boolean a(z1 z1Var, z1 z1Var2, e1 e1Var, e1 e1Var2) {
        int i3;
        int i10;
        int i11 = e1Var.f2554b;
        int i12 = e1Var.f2555c;
        if (z1Var2.shouldIgnore()) {
            int i13 = e1Var.f2554b;
            i10 = e1Var.f2555c;
            i3 = i13;
        } else {
            i3 = e1Var2.f2554b;
            i10 = e1Var2.f2555c;
        }
        if (z1Var == z1Var2) {
            return g(z1Var, i11, i12, i3, i10);
        }
        float translationX = z1Var.itemView.getTranslationX();
        float translationY = z1Var.itemView.getTranslationY();
        float alpha = z1Var.itemView.getAlpha();
        l(z1Var);
        z1Var.itemView.setTranslationX(translationX);
        z1Var.itemView.setTranslationY(translationY);
        z1Var.itemView.setAlpha(alpha);
        l(z1Var2);
        z1Var2.itemView.setTranslationX(-((int) ((i3 - i11) - translationX)));
        z1Var2.itemView.setTranslationY(-((int) ((i10 - i12) - translationY)));
        z1Var2.itemView.setAlpha(0.0f);
        ArrayList arrayList = this.f2655k;
        j jVar = new j();
        jVar.f2604a = z1Var;
        jVar.f2605b = z1Var2;
        jVar.f2606c = i11;
        jVar.f2607d = i12;
        jVar.e = i3;
        jVar.f2608f = i10;
        arrayList.add(jVar);
        return true;
    }

    @Override // androidx.recyclerview.widget.f1
    public final void d(z1 z1Var) {
        View view = z1Var.itemView;
        view.animate().cancel();
        ArrayList arrayList = this.f2654j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            if (((k) arrayList.get(size)).f2642a == z1Var) {
                view.setTranslationY(0.0f);
                view.setTranslationX(0.0f);
                c(z1Var);
                arrayList.remove(size);
            }
        }
        j(this.f2655k, z1Var);
        if (this.f2652h.remove(z1Var)) {
            view.setAlpha(1.0f);
            c(z1Var);
        }
        if (this.f2653i.remove(z1Var)) {
            view.setAlpha(1.0f);
            c(z1Var);
        }
        ArrayList arrayList2 = this.f2658n;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            ArrayList arrayList3 = (ArrayList) arrayList2.get(size2);
            j(arrayList3, z1Var);
            if (arrayList3.isEmpty()) {
                arrayList2.remove(size2);
            }
        }
        ArrayList arrayList4 = this.f2657m;
        for (int size3 = arrayList4.size() - 1; size3 >= 0; size3--) {
            ArrayList arrayList5 = (ArrayList) arrayList4.get(size3);
            int size4 = arrayList5.size() - 1;
            while (true) {
                if (size4 < 0) {
                    break;
                }
                if (((k) arrayList5.get(size4)).f2642a == z1Var) {
                    view.setTranslationY(0.0f);
                    view.setTranslationX(0.0f);
                    c(z1Var);
                    arrayList5.remove(size4);
                    if (arrayList5.isEmpty()) {
                        arrayList4.remove(size3);
                    }
                } else {
                    size4--;
                }
            }
        }
        ArrayList arrayList6 = this.f2656l;
        for (int size5 = arrayList6.size() - 1; size5 >= 0; size5--) {
            ArrayList arrayList7 = (ArrayList) arrayList6.get(size5);
            if (arrayList7.remove(z1Var)) {
                view.setAlpha(1.0f);
                c(z1Var);
                if (arrayList7.isEmpty()) {
                    arrayList6.remove(size5);
                }
            }
        }
        this.f2661q.remove(z1Var);
        this.f2659o.remove(z1Var);
        this.r.remove(z1Var);
        this.f2660p.remove(z1Var);
        i();
    }

    @Override // androidx.recyclerview.widget.f1
    public final void e() {
        ArrayList arrayList = this.f2654j;
        int size = arrayList.size();
        while (true) {
            size--;
            if (size < 0) {
                break;
            }
            k kVar = (k) arrayList.get(size);
            View view = kVar.f2642a.itemView;
            view.setTranslationY(0.0f);
            view.setTranslationX(0.0f);
            c(kVar.f2642a);
            arrayList.remove(size);
        }
        ArrayList arrayList2 = this.f2652h;
        for (int size2 = arrayList2.size() - 1; size2 >= 0; size2--) {
            c((z1) arrayList2.get(size2));
            arrayList2.remove(size2);
        }
        ArrayList arrayList3 = this.f2653i;
        int size3 = arrayList3.size();
        while (true) {
            size3--;
            if (size3 < 0) {
                break;
            }
            z1 z1Var = (z1) arrayList3.get(size3);
            z1Var.itemView.setAlpha(1.0f);
            c(z1Var);
            arrayList3.remove(size3);
        }
        ArrayList arrayList4 = this.f2655k;
        for (int size4 = arrayList4.size() - 1; size4 >= 0; size4--) {
            j jVar = (j) arrayList4.get(size4);
            z1 z1Var2 = jVar.f2604a;
            if (z1Var2 != null) {
                k(jVar, z1Var2);
            }
            z1 z1Var3 = jVar.f2605b;
            if (z1Var3 != null) {
                k(jVar, z1Var3);
            }
        }
        arrayList4.clear();
        if (f()) {
            ArrayList arrayList5 = this.f2657m;
            for (int size5 = arrayList5.size() - 1; size5 >= 0; size5--) {
                ArrayList arrayList6 = (ArrayList) arrayList5.get(size5);
                for (int size6 = arrayList6.size() - 1; size6 >= 0; size6--) {
                    k kVar2 = (k) arrayList6.get(size6);
                    View view2 = kVar2.f2642a.itemView;
                    view2.setTranslationY(0.0f);
                    view2.setTranslationX(0.0f);
                    c(kVar2.f2642a);
                    arrayList6.remove(size6);
                    if (arrayList6.isEmpty()) {
                        arrayList5.remove(arrayList6);
                    }
                }
            }
            ArrayList arrayList7 = this.f2656l;
            for (int size7 = arrayList7.size() - 1; size7 >= 0; size7--) {
                ArrayList arrayList8 = (ArrayList) arrayList7.get(size7);
                for (int size8 = arrayList8.size() - 1; size8 >= 0; size8--) {
                    z1 z1Var4 = (z1) arrayList8.get(size8);
                    z1Var4.itemView.setAlpha(1.0f);
                    c(z1Var4);
                    arrayList8.remove(size8);
                    if (arrayList8.isEmpty()) {
                        arrayList7.remove(arrayList8);
                    }
                }
            }
            ArrayList arrayList9 = this.f2658n;
            for (int size9 = arrayList9.size() - 1; size9 >= 0; size9--) {
                ArrayList arrayList10 = (ArrayList) arrayList9.get(size9);
                for (int size10 = arrayList10.size() - 1; size10 >= 0; size10--) {
                    j jVar2 = (j) arrayList10.get(size10);
                    z1 z1Var5 = jVar2.f2604a;
                    if (z1Var5 != null) {
                        k(jVar2, z1Var5);
                    }
                    z1 z1Var6 = jVar2.f2605b;
                    if (z1Var6 != null) {
                        k(jVar2, z1Var6);
                    }
                    if (arrayList10.isEmpty()) {
                        arrayList9.remove(arrayList10);
                    }
                }
            }
            h(this.f2661q);
            h(this.f2660p);
            h(this.f2659o);
            h(this.r);
            ArrayList arrayList11 = this.f2562b;
            if (arrayList11.size() > 0) {
                throw android.support.v4.media.session.e.c(0, arrayList11);
            }
            arrayList11.clear();
        }
    }

    @Override // androidx.recyclerview.widget.f1
    public final boolean f() {
        return (this.f2653i.isEmpty() && this.f2655k.isEmpty() && this.f2654j.isEmpty() && this.f2652h.isEmpty() && this.f2660p.isEmpty() && this.f2661q.isEmpty() && this.f2659o.isEmpty() && this.r.isEmpty() && this.f2657m.isEmpty() && this.f2656l.isEmpty() && this.f2658n.isEmpty()) ? false : true;
    }

    public final boolean g(z1 z1Var, int i3, int i10, int i11, int i12) {
        View view = z1Var.itemView;
        int translationX = i3 + ((int) view.getTranslationX());
        int translationY = i10 + ((int) z1Var.itemView.getTranslationY());
        l(z1Var);
        int i13 = i11 - translationX;
        int i14 = i12 - translationY;
        if (i13 == 0 && i14 == 0) {
            c(z1Var);
            return false;
        }
        if (i13 != 0) {
            view.setTranslationX(-i13);
        }
        if (i14 != 0) {
            view.setTranslationY(-i14);
        }
        ArrayList arrayList = this.f2654j;
        k kVar = new k();
        kVar.f2642a = z1Var;
        kVar.f2643b = translationX;
        kVar.f2644c = translationY;
        kVar.f2645d = i11;
        kVar.e = i12;
        arrayList.add(kVar);
        return true;
    }

    public final void i() {
        if (f()) {
            return;
        }
        ArrayList arrayList = this.f2562b;
        if (arrayList.size() > 0) {
            throw android.support.v4.media.session.e.c(0, arrayList);
        }
        arrayList.clear();
    }

    public final void j(ArrayList arrayList, z1 z1Var) {
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            j jVar = (j) arrayList.get(size);
            if (k(jVar, z1Var) && jVar.f2604a == null && jVar.f2605b == null) {
                arrayList.remove(jVar);
            }
        }
    }

    public final boolean k(j jVar, z1 z1Var) {
        if (jVar.f2605b == z1Var) {
            jVar.f2605b = null;
        } else {
            if (jVar.f2604a != z1Var) {
                return false;
            }
            jVar.f2604a = null;
        }
        z1Var.itemView.setAlpha(1.0f);
        z1Var.itemView.setTranslationX(0.0f);
        z1Var.itemView.setTranslationY(0.0f);
        c(z1Var);
        return true;
    }

    public final void l(z1 z1Var) {
        if (f2650s == null) {
            f2650s = new ValueAnimator().getInterpolator();
        }
        z1Var.itemView.animate().setInterpolator(f2650s);
        d(z1Var);
    }
}
