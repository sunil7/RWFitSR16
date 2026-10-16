package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class f implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2557a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ArrayList f2558b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ l f2559c;

    public /* synthetic */ f(l lVar, ArrayList arrayList, int i3) {
        this.f2557a = i3;
        this.f2559c = lVar;
        this.f2558b = arrayList;
    }

    @Override // java.lang.Runnable
    public final void run() {
        switch (this.f2557a) {
            case 0:
                ArrayList arrayList = this.f2558b;
                int size = arrayList.size();
                int i3 = 0;
                while (true) {
                    l lVar = this.f2559c;
                    if (i3 >= size) {
                        arrayList.clear();
                        lVar.f2657m.remove(arrayList);
                        break;
                    } else {
                        Object obj = arrayList.get(i3);
                        i3++;
                        k kVar = (k) obj;
                        z1 z1Var = kVar.f2642a;
                        lVar.getClass();
                        View view = z1Var.itemView;
                        int i10 = kVar.f2645d - kVar.f2643b;
                        int i11 = kVar.e - kVar.f2644c;
                        if (i10 != 0) {
                            view.animate().translationX(0.0f);
                        }
                        if (i11 != 0) {
                            view.animate().translationY(0.0f);
                        }
                        ViewPropertyAnimator animate = view.animate();
                        lVar.f2660p.add(z1Var);
                        animate.setDuration(lVar.e).setListener(new h(lVar, z1Var, i10, view, i11, animate)).start();
                    }
                }
            case 1:
                ArrayList arrayList2 = this.f2558b;
                int size2 = arrayList2.size();
                int i12 = 0;
                while (true) {
                    l lVar2 = this.f2559c;
                    if (i12 >= size2) {
                        arrayList2.clear();
                        lVar2.f2658n.remove(arrayList2);
                        break;
                    } else {
                        Object obj2 = arrayList2.get(i12);
                        i12++;
                        j jVar = (j) obj2;
                        lVar2.getClass();
                        z1 z1Var2 = jVar.f2604a;
                        View view2 = z1Var2 == null ? null : z1Var2.itemView;
                        z1 z1Var3 = jVar.f2605b;
                        View view3 = z1Var3 != null ? z1Var3.itemView : null;
                        ArrayList arrayList3 = lVar2.r;
                        if (view2 != null) {
                            ViewPropertyAnimator duration = view2.animate().setDuration(lVar2.f2565f);
                            arrayList3.add(jVar.f2604a);
                            duration.translationX(jVar.e - jVar.f2606c);
                            duration.translationY(jVar.f2608f - jVar.f2607d);
                            duration.alpha(0.0f).setListener(new i(lVar2, jVar, duration, view2, 0)).start();
                        }
                        if (view3 != null) {
                            ViewPropertyAnimator animate2 = view3.animate();
                            arrayList3.add(jVar.f2605b);
                            animate2.translationX(0.0f).translationY(0.0f).setDuration(lVar2.f2565f).alpha(1.0f).setListener(new i(lVar2, jVar, animate2, view3, 1)).start();
                        }
                    }
                }
            default:
                ArrayList arrayList4 = this.f2558b;
                int size3 = arrayList4.size();
                int i13 = 0;
                while (true) {
                    l lVar3 = this.f2559c;
                    if (i13 >= size3) {
                        arrayList4.clear();
                        lVar3.f2656l.remove(arrayList4);
                        break;
                    } else {
                        Object obj3 = arrayList4.get(i13);
                        i13++;
                        z1 z1Var4 = (z1) obj3;
                        lVar3.getClass();
                        View view4 = z1Var4.itemView;
                        ViewPropertyAnimator animate3 = view4.animate();
                        lVar3.f2659o.add(z1Var4);
                        animate3.alpha(1.0f).setDuration(lVar3.f2563c).setListener(new g(lVar3, z1Var4, view4, animate3)).start();
                    }
                }
        }
    }
}
