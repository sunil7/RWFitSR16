package androidx.recyclerview.widget;

import com.google.android.exoplayer2.Format;
import java.util.ArrayList;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public final class z implements Runnable {
    public static final ThreadLocal e = new ThreadLocal();

    /* renamed from: f, reason: collision with root package name */
    public static final m f2813f = new m(1);

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f2814a;

    /* renamed from: b, reason: collision with root package name */
    public long f2815b;

    /* renamed from: c, reason: collision with root package name */
    public long f2816c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f2817d;

    public static z1 c(RecyclerView recyclerView, int i3, long j4) {
        int F = recyclerView.e.F();
        for (int i10 = 0; i10 < F; i10++) {
            z1 L = RecyclerView.L(recyclerView.e.E(i10));
            if (L.mPosition == i3 && !L.isInvalid()) {
                return null;
            }
        }
        q1 q1Var = recyclerView.f2446b;
        try {
            recyclerView.S();
            z1 i11 = q1Var.i(i3, j4);
            if (i11 != null) {
                if (!i11.isBound() || i11.isInvalid()) {
                    q1Var.a(i11, false);
                } else {
                    q1Var.f(i11.itemView);
                }
            }
            recyclerView.T(false);
            return i11;
        } catch (Throwable th2) {
            recyclerView.T(false);
            throw th2;
        }
    }

    public final void a(RecyclerView recyclerView, int i3, int i10) {
        if (recyclerView.r && this.f2815b == 0) {
            this.f2815b = recyclerView.getNanoTime();
            recyclerView.post(this);
        }
        x xVar = recyclerView.f2458f0;
        xVar.f2798b = i3;
        xVar.f2799c = i10;
    }

    public final void b(long j4) {
        y yVar;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        y yVar2;
        ArrayList arrayList = this.f2814a;
        int size = arrayList.size();
        int i3 = 0;
        for (int i10 = 0; i10 < size; i10++) {
            RecyclerView recyclerView3 = (RecyclerView) arrayList.get(i10);
            if (recyclerView3.getWindowVisibility() == 0) {
                x xVar = recyclerView3.f2458f0;
                xVar.c(recyclerView3, false);
                i3 += xVar.f2800d;
            }
        }
        ArrayList arrayList2 = this.f2817d;
        arrayList2.ensureCapacity(i3);
        int i11 = 0;
        for (int i12 = 0; i12 < size; i12++) {
            RecyclerView recyclerView4 = (RecyclerView) arrayList.get(i12);
            if (recyclerView4.getWindowVisibility() == 0) {
                x xVar2 = recyclerView4.f2458f0;
                int abs = Math.abs(xVar2.f2799c) + Math.abs(xVar2.f2798b);
                for (int i13 = 0; i13 < xVar2.f2800d * 2; i13 += 2) {
                    if (i11 >= arrayList2.size()) {
                        yVar2 = new y();
                        arrayList2.add(yVar2);
                    } else {
                        yVar2 = (y) arrayList2.get(i11);
                    }
                    int[] iArr = (int[]) xVar2.e;
                    int i14 = iArr[i13 + 1];
                    yVar2.f2802a = i14 <= abs;
                    yVar2.f2803b = abs;
                    yVar2.f2804c = i14;
                    yVar2.f2805d = recyclerView4;
                    yVar2.e = iArr[i13];
                    i11++;
                }
            }
        }
        Collections.sort(arrayList2, f2813f);
        for (int i15 = 0; i15 < arrayList2.size() && (recyclerView = (yVar = (y) arrayList2.get(i15)).f2805d) != null; i15++) {
            z1 c9 = c(recyclerView, yVar.e, yVar.f2802a ? Format.OFFSET_SAMPLE_RELATIVE : j4);
            if (c9 != null && c9.mNestedRecyclerView != null && c9.isBound() && !c9.isInvalid() && (recyclerView2 = c9.mNestedRecyclerView.get()) != null) {
                if (recyclerView2.C && recyclerView2.e.F() != 0) {
                    f1 f1Var = recyclerView2.L;
                    if (f1Var != null) {
                        f1Var.e();
                    }
                    i1 i1Var = recyclerView2.f2471m;
                    q1 q1Var = recyclerView2.f2446b;
                    if (i1Var != null) {
                        i1Var.l0(q1Var);
                        recyclerView2.f2471m.m0(q1Var);
                    }
                    q1Var.f2710a.clear();
                    q1Var.d();
                }
                x xVar3 = recyclerView2.f2458f0;
                xVar3.c(recyclerView2, true);
                if (xVar3.f2800d != 0) {
                    try {
                        int i16 = h1.l.f14255a;
                        h1.k.a("RV Nested Prefetch");
                        w1 w1Var = recyclerView2.f2460g0;
                        z0 z0Var = recyclerView2.f2470l;
                        w1Var.f2787d = 1;
                        w1Var.e = z0Var.getItemCount();
                        w1Var.f2789g = false;
                        w1Var.f2790h = false;
                        w1Var.f2791i = false;
                        for (int i17 = 0; i17 < xVar3.f2800d * 2; i17 += 2) {
                            c(recyclerView2, ((int[]) xVar3.e)[i17], j4);
                        }
                        h1.k.b();
                        yVar.f2802a = false;
                        yVar.f2803b = 0;
                        yVar.f2804c = 0;
                        yVar.f2805d = null;
                        yVar.e = 0;
                    } catch (Throwable th2) {
                        int i18 = h1.l.f14255a;
                        h1.k.b();
                        throw th2;
                    }
                }
            }
            yVar.f2802a = false;
            yVar.f2803b = 0;
            yVar.f2804c = 0;
            yVar.f2805d = null;
            yVar.e = 0;
        }
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            int i3 = h1.l.f14255a;
            h1.k.a("RV Prefetch");
            ArrayList arrayList = this.f2814a;
            if (arrayList.isEmpty()) {
                this.f2815b = 0L;
                h1.k.b();
                return;
            }
            int size = arrayList.size();
            long j4 = 0;
            for (int i10 = 0; i10 < size; i10++) {
                RecyclerView recyclerView = (RecyclerView) arrayList.get(i10);
                if (recyclerView.getWindowVisibility() == 0) {
                    j4 = Math.max(recyclerView.getDrawingTime(), j4);
                }
            }
            if (j4 == 0) {
                this.f2815b = 0L;
                h1.k.b();
            } else {
                b(TimeUnit.MILLISECONDS.toNanos(j4) + this.f2816c);
                this.f2815b = 0L;
                h1.k.b();
            }
        } catch (Throwable th2) {
            this.f2815b = 0L;
            int i11 = h1.l.f14255a;
            h1.k.b();
            throw th2;
        }
    }
}
