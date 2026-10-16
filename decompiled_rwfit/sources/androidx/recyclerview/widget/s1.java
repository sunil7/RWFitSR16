package androidx.recyclerview.widget;

import java.util.ArrayList;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class s1 extends b1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2740a;

    public s1(RecyclerView recyclerView) {
        this.f2740a = recyclerView;
    }

    @Override // androidx.recyclerview.widget.b1
    public final void a() {
        RecyclerView recyclerView = this.f2740a;
        recyclerView.h(null);
        recyclerView.f2460g0.f2788f = true;
        recyclerView.Z(true);
        if (recyclerView.f2452d.k()) {
            return;
        }
        recyclerView.requestLayout();
    }

    @Override // androidx.recyclerview.widget.b1
    public final void b(int i3, int i10, Object obj) {
        RecyclerView recyclerView = this.f2740a;
        recyclerView.h(null);
        androidx.appcompat.widget.w wVar = recyclerView.f2452d;
        if (i10 < 1) {
            wVar.getClass();
            return;
        }
        ArrayList arrayList = (ArrayList) wVar.f1073c;
        arrayList.add(wVar.m(obj, 4, i3, i10));
        wVar.f1071a |= 4;
        if (arrayList.size() == 1) {
            g();
        }
    }

    @Override // androidx.recyclerview.widget.b1
    public final void c(int i3, int i10) {
        RecyclerView recyclerView = this.f2740a;
        recyclerView.h(null);
        androidx.appcompat.widget.w wVar = recyclerView.f2452d;
        if (i10 < 1) {
            wVar.getClass();
            return;
        }
        ArrayList arrayList = (ArrayList) wVar.f1073c;
        arrayList.add(wVar.m(null, 1, i3, i10));
        wVar.f1071a |= 1;
        if (arrayList.size() == 1) {
            g();
        }
    }

    @Override // androidx.recyclerview.widget.b1
    public final void d(int i3, int i10) {
        RecyclerView recyclerView = this.f2740a;
        recyclerView.h(null);
        androidx.appcompat.widget.w wVar = recyclerView.f2452d;
        wVar.getClass();
        if (i3 == i10) {
            return;
        }
        ArrayList arrayList = (ArrayList) wVar.f1073c;
        arrayList.add(wVar.m(null, 8, i3, i10));
        wVar.f1071a |= 8;
        if (arrayList.size() == 1) {
            g();
        }
    }

    @Override // androidx.recyclerview.widget.b1
    public final void e(int i3, int i10) {
        RecyclerView recyclerView = this.f2740a;
        recyclerView.h(null);
        androidx.appcompat.widget.w wVar = recyclerView.f2452d;
        if (i10 < 1) {
            wVar.getClass();
            return;
        }
        ArrayList arrayList = (ArrayList) wVar.f1073c;
        arrayList.add(wVar.m(null, 2, i3, i10));
        wVar.f1071a |= 2;
        if (arrayList.size() == 1) {
            g();
        }
    }

    @Override // androidx.recyclerview.widget.b1
    public final void f() {
        z0 z0Var;
        RecyclerView recyclerView = this.f2740a;
        if (recyclerView.f2449c == null || (z0Var = recyclerView.f2470l) == null || !z0Var.canRestoreState()) {
            return;
        }
        recyclerView.requestLayout();
    }

    public final void g() {
        int[] iArr = RecyclerView.f2440i1;
        RecyclerView recyclerView = this.f2740a;
        if (recyclerView.f2476s && recyclerView.r) {
            WeakHashMap weakHashMap = l1.z0.f15748a;
            l1.h0.m(recyclerView, recyclerView.f2462h);
        } else {
            recyclerView.f2483z = true;
            recyclerView.requestLayout();
        }
    }
}
