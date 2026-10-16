package androidx.recyclerview.widget;

import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class g2 {

    /* renamed from: a, reason: collision with root package name */
    public Object f2570a;

    /* renamed from: b, reason: collision with root package name */
    public Object f2571b;

    public g2(h1 h1Var) {
        this.f2570a = h1Var;
        j2 j2Var = new j2();
        j2Var.f2638b = 0;
        this.f2571b = j2Var;
    }

    public void a(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem) {
        if (((ArrayList) this.f2571b) == null) {
            this.f2571b = new ArrayList();
        }
        int size = ((ArrayList) this.f2571b).size();
        for (int i3 = 0; i3 < size; i3++) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2 = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) this.f2571b).get(i3);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f2496a == staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2496a) {
                ((ArrayList) this.f2571b).remove(i3);
            }
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem2.f2496a >= staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2496a) {
                ((ArrayList) this.f2571b).add(i3, staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
                return;
            }
        }
        ((ArrayList) this.f2571b).add(staggeredGridLayoutManager$LazySpanLookup$FullSpanItem);
    }

    public void b(z1 z1Var, e1 e1Var) {
        m0.k kVar = (m0.k) this.f2570a;
        k2 k2Var = (k2) kVar.getOrDefault(z1Var, null);
        if (k2Var == null) {
            k2Var = k2.a();
            kVar.put(z1Var, k2Var);
        }
        k2Var.f2649c = e1Var;
        k2Var.f2647a |= 8;
    }

    public void c() {
        int[] iArr = (int[]) this.f2570a;
        if (iArr != null) {
            Arrays.fill(iArr, -1);
        }
        this.f2571b = null;
    }

    public void d(int i3) {
        int[] iArr = (int[]) this.f2570a;
        if (iArr == null) {
            int[] iArr2 = new int[Math.max(i3, 10) + 1];
            this.f2570a = iArr2;
            Arrays.fill(iArr2, -1);
        } else if (i3 >= iArr.length) {
            int length = iArr.length;
            while (length <= i3) {
                length *= 2;
            }
            int[] iArr3 = new int[length];
            this.f2570a = iArr3;
            System.arraycopy(iArr, 0, iArr3, 0, iArr.length);
            int[] iArr4 = (int[]) this.f2570a;
            Arrays.fill(iArr4, iArr.length, iArr4.length, -1);
        }
    }

    public View e(int i3, int i10, int i11, int i12) {
        View u10;
        h1 h1Var = (h1) this.f2570a;
        int d5 = h1Var.d();
        int c9 = h1Var.c();
        int i13 = i10 > i3 ? 1 : -1;
        View view = null;
        while (i3 != i10) {
            switch (h1Var.f2579a) {
                case 0:
                    u10 = h1Var.f2580b.u(i3);
                    break;
                default:
                    u10 = h1Var.f2580b.u(i3);
                    break;
            }
            int b3 = h1Var.b(u10);
            int a3 = h1Var.a(u10);
            j2 j2Var = (j2) this.f2571b;
            j2Var.f2639c = d5;
            j2Var.f2640d = c9;
            j2Var.e = b3;
            j2Var.f2641f = a3;
            if (i11 != 0) {
                j2Var.f2638b = i11;
                if (j2Var.a()) {
                    return u10;
                }
            }
            if (i12 != 0) {
                j2Var.f2638b = i12;
                if (j2Var.a()) {
                    view = u10;
                }
            }
            i3 += i13;
        }
        return view;
    }

    public void f(int i3) {
        ArrayList arrayList = (ArrayList) this.f2571b;
        if (arrayList != null) {
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (((StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) this.f2571b).get(size)).f2496a >= i3) {
                    ((ArrayList) this.f2571b).remove(size);
                }
            }
        }
        i(i3);
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem g(int i3, int i10, int i11) {
        ArrayList arrayList = (ArrayList) this.f2571b;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        for (int i12 = 0; i12 < size; i12++) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) this.f2571b).get(i12);
            int i13 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2496a;
            if (i13 >= i10) {
                return null;
            }
            if (i13 >= i3 && (i11 == 0 || staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2497b == i11 || staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2499d)) {
                return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
            }
        }
        return null;
    }

    public StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem h(int i3) {
        ArrayList arrayList = (ArrayList) this.f2571b;
        if (arrayList == null) {
            return null;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) this.f2571b).get(size);
            if (staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2496a == i3) {
                return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
            }
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int i(int r5) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f2570a
            int[] r0 = (int[]) r0
            r1 = -1
            if (r0 != 0) goto L8
            goto Lb
        L8:
            int r0 = r0.length
            if (r5 < r0) goto Lc
        Lb:
            return r1
        Lc:
            java.lang.Object r0 = r4.f2571b
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            if (r0 != 0) goto L14
        L12:
            r0 = r1
            goto L54
        L14:
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r0 = r4.h(r5)
            if (r0 == 0) goto L21
            java.lang.Object r2 = r4.f2571b
            java.util.ArrayList r2 = (java.util.ArrayList) r2
            r2.remove(r0)
        L21:
            java.lang.Object r0 = r4.f2571b
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            int r0 = r0.size()
            r2 = 0
        L2a:
            if (r2 >= r0) goto L3e
            java.lang.Object r3 = r4.f2571b
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            java.lang.Object r3 = r3.get(r2)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r3 = (androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) r3
            int r3 = r3.f2496a
            if (r3 < r5) goto L3b
            goto L3f
        L3b:
            int r2 = r2 + 1
            goto L2a
        L3e:
            r2 = r1
        L3f:
            if (r2 == r1) goto L12
            java.lang.Object r0 = r4.f2571b
            java.util.ArrayList r0 = (java.util.ArrayList) r0
            java.lang.Object r0 = r0.get(r2)
            androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem r0 = (androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) r0
            java.lang.Object r3 = r4.f2571b
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            r3.remove(r2)
            int r0 = r0.f2496a
        L54:
            if (r0 != r1) goto L64
            java.lang.Object r0 = r4.f2570a
            int[] r0 = (int[]) r0
            int r2 = r0.length
            java.util.Arrays.fill(r0, r5, r2, r1)
            java.lang.Object r5 = r4.f2570a
            int[] r5 = (int[]) r5
            int r5 = r5.length
            return r5
        L64:
            int r0 = r0 + 1
            java.lang.Object r2 = r4.f2570a
            int[] r2 = (int[]) r2
            int r2 = r2.length
            int r0 = java.lang.Math.min(r0, r2)
            java.lang.Object r2 = r4.f2570a
            int[] r2 = (int[]) r2
            java.util.Arrays.fill(r2, r5, r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.g2.i(int):int");
    }

    public boolean j(View view) {
        h1 h1Var = (h1) this.f2570a;
        int d5 = h1Var.d();
        int c9 = h1Var.c();
        int b3 = h1Var.b(view);
        int a3 = h1Var.a(view);
        j2 j2Var = (j2) this.f2571b;
        j2Var.f2639c = d5;
        j2Var.f2640d = c9;
        j2Var.e = b3;
        j2Var.f2641f = a3;
        j2Var.f2638b = 24579;
        return j2Var.a();
    }

    public void k(int i3, int i10) {
        int[] iArr = (int[]) this.f2570a;
        if (iArr == null || i3 >= iArr.length) {
            return;
        }
        int i11 = i3 + i10;
        d(i11);
        int[] iArr2 = (int[]) this.f2570a;
        System.arraycopy(iArr2, i3, iArr2, i11, (iArr2.length - i3) - i10);
        Arrays.fill((int[]) this.f2570a, i3, i11, -1);
        ArrayList arrayList = (ArrayList) this.f2571b;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) this.f2571b).get(size);
            int i12 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2496a;
            if (i12 >= i3) {
                staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2496a = i12 + i10;
            }
        }
    }

    public void l(int i3, int i10) {
        int[] iArr = (int[]) this.f2570a;
        if (iArr == null || i3 >= iArr.length) {
            return;
        }
        int i11 = i3 + i10;
        d(i11);
        int[] iArr2 = (int[]) this.f2570a;
        System.arraycopy(iArr2, i11, iArr2, i3, (iArr2.length - i3) - i10);
        int[] iArr3 = (int[]) this.f2570a;
        Arrays.fill(iArr3, iArr3.length - i10, iArr3.length, -1);
        ArrayList arrayList = (ArrayList) this.f2571b;
        if (arrayList == null) {
            return;
        }
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = (StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem) ((ArrayList) this.f2571b).get(size);
            int i12 = staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2496a;
            if (i12 >= i3) {
                if (i12 < i11) {
                    ((ArrayList) this.f2571b).remove(size);
                } else {
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.f2496a = i12 - i10;
                }
            }
        }
    }

    public e1 m(z1 z1Var, int i3) {
        k2 k2Var;
        e1 e1Var;
        m0.k kVar = (m0.k) this.f2570a;
        int e = kVar.e(z1Var);
        if (e >= 0 && (k2Var = (k2) kVar.l(e)) != null) {
            int i10 = k2Var.f2647a;
            if ((i10 & i3) != 0) {
                int i11 = i10 & (~i3);
                k2Var.f2647a = i11;
                if (i3 == 4) {
                    e1Var = k2Var.f2648b;
                } else {
                    if (i3 != 8) {
                        throw new IllegalArgumentException("Must provide flag PRE or POST");
                    }
                    e1Var = k2Var.f2649c;
                }
                if ((i11 & 12) == 0) {
                    kVar.j(e);
                    k2Var.f2647a = 0;
                    k2Var.f2648b = null;
                    k2Var.f2649c = null;
                    k2.f2646d.c(k2Var);
                }
                return e1Var;
            }
        }
        return null;
    }

    public void n(z1 z1Var) {
        k2 k2Var = (k2) ((m0.k) this.f2570a).getOrDefault(z1Var, null);
        if (k2Var == null) {
            return;
        }
        k2Var.f2647a &= -2;
    }

    public void o(z1 z1Var) {
        m0.e eVar = (m0.e) this.f2571b;
        int e = eVar.e() - 1;
        while (true) {
            if (e < 0) {
                break;
            }
            if (z1Var == eVar.f(e)) {
                Object[] objArr = eVar.f15897c;
                Object obj = objArr[e];
                Object obj2 = m0.e.e;
                if (obj != obj2) {
                    objArr[e] = obj2;
                    eVar.f15895a = true;
                }
            } else {
                e--;
            }
        }
        k2 k2Var = (k2) ((m0.k) this.f2570a).remove(z1Var);
        if (k2Var != null) {
            k2Var.f2647a = 0;
            k2Var.f2648b = null;
            k2Var.f2649c = null;
            k2.f2646d.c(k2Var);
        }
    }
}
