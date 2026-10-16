package androidx.recyclerview.widget;

import android.view.View;
import android.view.ViewPropertyAnimator;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class w0 implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f2782a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2783b;

    public /* synthetic */ w0(int i3, RecyclerView recyclerView) {
        this.f2782a = i3;
        this.f2783b = recyclerView;
    }

    @Override // java.lang.Runnable
    public final void run() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3 = this.f2783b;
        int i3 = 1;
        switch (this.f2782a) {
            case 0:
                if (recyclerView3.f2477t && !recyclerView3.isLayoutRequested()) {
                    if (!recyclerView3.r) {
                        recyclerView3.requestLayout();
                        break;
                    } else if (!recyclerView3.f2480w) {
                        recyclerView3.l();
                        break;
                    } else {
                        recyclerView3.f2479v = true;
                        break;
                    }
                }
                break;
            default:
                f1 f1Var = recyclerView3.L;
                if (f1Var != null) {
                    l lVar = (l) f1Var;
                    ArrayList arrayList = lVar.f2652h;
                    boolean isEmpty = arrayList.isEmpty();
                    ArrayList arrayList2 = lVar.f2654j;
                    boolean isEmpty2 = arrayList2.isEmpty();
                    ArrayList arrayList3 = lVar.f2655k;
                    boolean isEmpty3 = arrayList3.isEmpty();
                    ArrayList arrayList4 = lVar.f2653i;
                    boolean isEmpty4 = arrayList4.isEmpty();
                    if (isEmpty && isEmpty2 && isEmpty4 && isEmpty3) {
                        recyclerView2 = recyclerView3;
                    } else {
                        int size = arrayList.size();
                        recyclerView2 = recyclerView3;
                        int i10 = 0;
                        while (true) {
                            long j4 = lVar.f2564d;
                            if (i10 < size) {
                                Object obj = arrayList.get(i10);
                                i10 += i3;
                                z1 z1Var = (z1) obj;
                                View view = z1Var.itemView;
                                ViewPropertyAnimator animate = view.animate();
                                lVar.f2661q.add(z1Var);
                                animate.setDuration(j4).alpha(0.0f).setListener(new g(lVar, z1Var, animate, view)).start();
                                arrayList = arrayList;
                                i3 = 1;
                            } else {
                                arrayList.clear();
                                if (!isEmpty2) {
                                    ArrayList arrayList5 = new ArrayList();
                                    arrayList5.addAll(arrayList2);
                                    lVar.f2657m.add(arrayList5);
                                    arrayList2.clear();
                                    f fVar = new f(lVar, arrayList5, 0);
                                    if (isEmpty) {
                                        fVar.run();
                                    } else {
                                        View view2 = ((k) arrayList5.get(0)).f2642a.itemView;
                                        WeakHashMap weakHashMap = l1.z0.f15748a;
                                        l1.h0.n(view2, fVar, j4);
                                    }
                                }
                                if (!isEmpty3) {
                                    ArrayList arrayList6 = new ArrayList();
                                    arrayList6.addAll(arrayList3);
                                    lVar.f2658n.add(arrayList6);
                                    arrayList3.clear();
                                    f fVar2 = new f(lVar, arrayList6, 1);
                                    if (isEmpty) {
                                        fVar2.run();
                                    } else {
                                        View view3 = ((j) arrayList6.get(0)).f2604a.itemView;
                                        WeakHashMap weakHashMap2 = l1.z0.f15748a;
                                        l1.h0.n(view3, fVar2, j4);
                                    }
                                }
                                if (!isEmpty4) {
                                    ArrayList arrayList7 = new ArrayList();
                                    arrayList7.addAll(arrayList4);
                                    lVar.f2656l.add(arrayList7);
                                    arrayList4.clear();
                                    f fVar3 = new f(lVar, arrayList7, 2);
                                    if (isEmpty && isEmpty2 && isEmpty3) {
                                        fVar3.run();
                                    } else {
                                        if (isEmpty) {
                                            j4 = 0;
                                        }
                                        long max = Math.max(!isEmpty2 ? lVar.e : 0L, isEmpty3 ? 0L : lVar.f2565f) + j4;
                                        View view4 = ((z1) arrayList7.get(0)).itemView;
                                        WeakHashMap weakHashMap3 = l1.z0.f15748a;
                                        l1.h0.n(view4, fVar3, max);
                                    }
                                }
                            }
                        }
                    }
                    recyclerView = recyclerView2;
                } else {
                    recyclerView = recyclerView3;
                }
                recyclerView.V0 = false;
                break;
        }
    }
}
