package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class x0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2801a;

    public /* synthetic */ x0(RecyclerView recyclerView) {
        this.f2801a = recyclerView;
    }

    public void a(a aVar) {
        int i3 = aVar.f2509a;
        RecyclerView recyclerView = this.f2801a;
        if (i3 == 1) {
            recyclerView.f2471m.a0(aVar.f2510b, aVar.f2512d);
            return;
        }
        if (i3 == 2) {
            recyclerView.f2471m.d0(aVar.f2510b, aVar.f2512d);
        } else if (i3 == 4) {
            recyclerView.f2471m.e0(aVar.f2510b, aVar.f2512d);
        } else {
            if (i3 != 8) {
                return;
            }
            recyclerView.f2471m.c0(aVar.f2510b, aVar.f2512d);
        }
    }

    public void b(int i3, int i10, Object obj) {
        int i11;
        int i12;
        RecyclerView recyclerView = this.f2801a;
        int F = recyclerView.e.F();
        int i13 = i10 + i3;
        for (int i14 = 0; i14 < F; i14++) {
            View E = recyclerView.e.E(i14);
            z1 L = RecyclerView.L(E);
            if (L != null && !L.shouldIgnore() && (i12 = L.mPosition) >= i3 && i12 < i13) {
                L.addFlags(2);
                L.addChangePayload(obj);
                ((j1) E.getLayoutParams()).f2635c = true;
            }
        }
        q1 q1Var = recyclerView.f2446b;
        ArrayList arrayList = q1Var.f2712c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            z1 z1Var = (z1) arrayList.get(size);
            if (z1Var != null && (i11 = z1Var.mPosition) >= i3 && i11 < i13) {
                z1Var.addFlags(2);
                q1Var.e(size);
            }
        }
        recyclerView.f2469k0 = true;
    }

    public void c(int i3, int i10) {
        RecyclerView recyclerView = this.f2801a;
        int F = recyclerView.e.F();
        for (int i11 = 0; i11 < F; i11++) {
            z1 L = RecyclerView.L(recyclerView.e.E(i11));
            if (L != null && !L.shouldIgnore() && L.mPosition >= i3) {
                L.offsetPosition(i10, false);
                recyclerView.f2460g0.f2788f = true;
            }
        }
        ArrayList arrayList = recyclerView.f2446b.f2712c;
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            z1 z1Var = (z1) arrayList.get(i12);
            if (z1Var != null && z1Var.mPosition >= i3) {
                z1Var.offsetPosition(i10, false);
            }
        }
        recyclerView.requestLayout();
        recyclerView.f2467j0 = true;
    }

    public void d(int i3, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        RecyclerView recyclerView = this.f2801a;
        int F = recyclerView.e.F();
        int i18 = -1;
        if (i3 < i10) {
            i12 = i3;
            i11 = i10;
            i13 = -1;
        } else {
            i11 = i3;
            i12 = i10;
            i13 = 1;
        }
        for (int i19 = 0; i19 < F; i19++) {
            z1 L = RecyclerView.L(recyclerView.e.E(i19));
            if (L != null && (i17 = L.mPosition) >= i12 && i17 <= i11) {
                if (i17 == i3) {
                    L.offsetPosition(i10 - i3, false);
                } else {
                    L.offsetPosition(i13, false);
                }
                recyclerView.f2460g0.f2788f = true;
            }
        }
        q1 q1Var = recyclerView.f2446b;
        q1Var.getClass();
        if (i3 < i10) {
            i15 = i3;
            i14 = i10;
        } else {
            i14 = i3;
            i15 = i10;
            i18 = 1;
        }
        ArrayList arrayList = q1Var.f2712c;
        int size = arrayList.size();
        for (int i20 = 0; i20 < size; i20++) {
            z1 z1Var = (z1) arrayList.get(i20);
            if (z1Var != null && (i16 = z1Var.mPosition) >= i15 && i16 <= i14) {
                if (i16 == i3) {
                    z1Var.offsetPosition(i10 - i3, false);
                } else {
                    z1Var.offsetPosition(i18, false);
                }
            }
        }
        recyclerView.requestLayout();
        recyclerView.f2467j0 = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:9:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void e(androidx.recyclerview.widget.z1 r9, androidx.recyclerview.widget.e1 r10, androidx.recyclerview.widget.e1 r11) {
        /*
            r8 = this;
            androidx.recyclerview.widget.RecyclerView r0 = r8.f2801a
            r0.getClass()
            r1 = 0
            r9.setIsRecyclable(r1)
            androidx.recyclerview.widget.f1 r1 = r0.L
            r2 = r1
            androidx.recyclerview.widget.l r2 = (androidx.recyclerview.widget.l) r2
            if (r10 == 0) goto L20
            r2.getClass()
            int r4 = r10.f2554b
            int r6 = r11.f2554b
            if (r4 != r6) goto L22
            int r1 = r10.f2555c
            int r3 = r11.f2555c
            if (r1 == r3) goto L20
            goto L22
        L20:
            r3 = r9
            goto L2c
        L22:
            int r5 = r10.f2555c
            int r7 = r11.f2555c
            r3 = r9
            boolean r9 = r2.g(r3, r4, r5, r6, r7)
            goto L3b
        L2c:
            r2.l(r3)
            android.view.View r9 = r3.itemView
            r10 = 0
            r9.setAlpha(r10)
            java.util.ArrayList r9 = r2.f2653i
            r9.add(r3)
            r9 = 1
        L3b:
            if (r9 == 0) goto L40
            r0.X()
        L40:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.x0.e(androidx.recyclerview.widget.z1, androidx.recyclerview.widget.e1, androidx.recyclerview.widget.e1):void");
    }

    public void f(z1 z1Var, e1 e1Var, e1 e1Var2) {
        boolean z5;
        RecyclerView recyclerView = this.f2801a;
        recyclerView.f2446b.j(z1Var);
        recyclerView.f(z1Var);
        z1Var.setIsRecyclable(false);
        l lVar = (l) recyclerView.L;
        lVar.getClass();
        int i3 = e1Var.f2554b;
        int i10 = e1Var.f2555c;
        View view = z1Var.itemView;
        int left = e1Var2 == null ? view.getLeft() : e1Var2.f2554b;
        int top = e1Var2 == null ? view.getTop() : e1Var2.f2555c;
        if (z1Var.isRemoved() || (i3 == left && i10 == top)) {
            lVar.l(z1Var);
            lVar.f2652h.add(z1Var);
            z5 = true;
        } else {
            view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
            z5 = lVar.g(z1Var, i3, i10, left, top);
        }
        if (z5) {
            recyclerView.X();
        }
    }

    public void g(int i3) {
        RecyclerView recyclerView = this.f2801a;
        View childAt = recyclerView.getChildAt(i3);
        if (childAt != null) {
            recyclerView.n(childAt);
            childAt.clearAnimation();
        }
        recyclerView.removeViewAt(i3);
    }
}
