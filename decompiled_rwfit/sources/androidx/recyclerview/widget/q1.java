package androidx.recyclerview.widget;

import android.util.SparseArray;
import android.view.View;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.WeakHashMap;

/* loaded from: classes.dex */
public final class q1 {

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f2710a;

    /* renamed from: b, reason: collision with root package name */
    public ArrayList f2711b;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f2712c;

    /* renamed from: d, reason: collision with root package name */
    public final List f2713d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f2714f;

    /* renamed from: g, reason: collision with root package name */
    public p1 f2715g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ RecyclerView f2716h;

    public q1(RecyclerView recyclerView) {
        this.f2716h = recyclerView;
        ArrayList arrayList = new ArrayList();
        this.f2710a = arrayList;
        this.f2711b = null;
        this.f2712c = new ArrayList();
        this.f2713d = Collections.unmodifiableList(arrayList);
        this.e = 2;
        this.f2714f = 2;
    }

    public final void a(z1 z1Var, boolean z5) {
        RecyclerView.i(z1Var);
        View view = z1Var.itemView;
        RecyclerView recyclerView = this.f2716h;
        b2 b2Var = recyclerView.W0;
        if (b2Var != null) {
            a2 a2Var = b2Var.e;
            l1.z0.n(view, a2Var != null ? (l1.c) ((WeakHashMap) a2Var.f2515f).remove(view) : null);
        }
        if (z5) {
            ArrayList arrayList = recyclerView.f2472n;
            if (arrayList.size() > 0) {
                throw android.support.v4.media.session.e.c(0, arrayList);
            }
            z0 z0Var = recyclerView.f2470l;
            if (z0Var != null) {
                z0Var.onViewRecycled(z1Var);
            }
            if (recyclerView.f2460g0 != null) {
                recyclerView.f2457f.o(z1Var);
            }
        }
        z1Var.mBindingAdapter = null;
        z1Var.mOwnerRecyclerView = null;
        p1 c9 = c();
        c9.getClass();
        int itemViewType = z1Var.getItemViewType();
        ArrayList arrayList2 = c9.a(itemViewType).f2690a;
        if (((o1) c9.f2705a.get(itemViewType)).f2691b <= arrayList2.size()) {
            return;
        }
        z1Var.resetInternal();
        arrayList2.add(z1Var);
    }

    public final int b(int i3) {
        RecyclerView recyclerView = this.f2716h;
        if (i3 >= 0 && i3 < recyclerView.f2460g0.b()) {
            return !recyclerView.f2460g0.f2789g ? i3 : recyclerView.f2452d.h(i3, 0);
        }
        StringBuilder q5 = android.support.v4.media.session.e.q(i3, "invalid position ", ". State item count is ");
        q5.append(recyclerView.f2460g0.b());
        q5.append(recyclerView.y());
        throw new IndexOutOfBoundsException(q5.toString());
    }

    public final p1 c() {
        if (this.f2715g == null) {
            p1 p1Var = new p1();
            p1Var.f2705a = new SparseArray();
            p1Var.f2706b = 0;
            this.f2715g = p1Var;
        }
        return this.f2715g;
    }

    public final void d() {
        ArrayList arrayList = this.f2712c;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            e(size);
        }
        arrayList.clear();
        int[] iArr = RecyclerView.f2440i1;
        x xVar = this.f2716h.f2458f0;
        int[] iArr2 = (int[]) xVar.e;
        if (iArr2 != null) {
            Arrays.fill(iArr2, -1);
        }
        xVar.f2800d = 0;
    }

    public final void e(int i3) {
        ArrayList arrayList = this.f2712c;
        a((z1) arrayList.get(i3), true);
        arrayList.remove(i3);
    }

    public final void f(View view) {
        z1 L = RecyclerView.L(view);
        boolean isTmpDetached = L.isTmpDetached();
        RecyclerView recyclerView = this.f2716h;
        if (isTmpDetached) {
            recyclerView.removeDetachedView(view, false);
        }
        if (L.isScrap()) {
            L.unScrap();
        } else if (L.wasReturnedFromScrap()) {
            L.clearReturnedFromScrapFlag();
        }
        g(L);
        if (recyclerView.L == null || L.isRecyclable()) {
            return;
        }
        recyclerView.L.d(L);
    }

    /* JADX WARN: Code restructure failed: missing block: B:43:0x0097, code lost:
    
        r5 = r5 - 1;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(androidx.recyclerview.widget.z1 r12) {
        /*
            Method dump skipped, instructions count: 290
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.q1.g(androidx.recyclerview.widget.z1):void");
    }

    public final void h(View view) {
        f1 f1Var;
        z1 L = RecyclerView.L(view);
        boolean hasAnyOfTheFlags = L.hasAnyOfTheFlags(12);
        RecyclerView recyclerView = this.f2716h;
        if (!hasAnyOfTheFlags && L.isUpdated() && (f1Var = recyclerView.L) != null) {
            l lVar = (l) f1Var;
            if (L.getUnmodifiedPayloads().isEmpty() && lVar.f2651g && !L.isInvalid()) {
                if (this.f2711b == null) {
                    this.f2711b = new ArrayList();
                }
                L.setScrapContainer(this, true);
                this.f2711b.add(L);
                return;
            }
        }
        if (!L.isInvalid() || L.isRemoved() || recyclerView.f2470l.hasStableIds()) {
            L.setScrapContainer(this, false);
            this.f2710a.add(L);
        } else {
            throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + recyclerView.y());
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:168:0x0432, code lost:
    
        if ((r12 + r8) >= r32) goto L226;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:146:0x04ba  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x04c6  */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x014a  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0084  */
    /* JADX WARN: Type inference failed for: r10v4, types: [l1.c] */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1 */
    /* JADX WARN: Type inference failed for: r17v2 */
    /* JADX WARN: Type inference failed for: r17v3 */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARN: Type inference failed for: r17v5 */
    /* JADX WARN: Type inference failed for: r17v6 */
    /* JADX WARN: Type inference failed for: r1v3 */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v5 */
    /* JADX WARN: Type inference failed for: r4v10, types: [int] */
    /* JADX WARN: Type inference failed for: r9v6, types: [l1.c] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.recyclerview.widget.z1 i(int r31, long r32) {
        /*
            Method dump skipped, instructions count: 1286
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.q1.i(int, long):androidx.recyclerview.widget.z1");
    }

    public final void j(z1 z1Var) {
        if (z1Var.mInChangeScrap) {
            this.f2711b.remove(z1Var);
        } else {
            this.f2710a.remove(z1Var);
        }
        z1Var.mScrapContainer = null;
        z1Var.mInChangeScrap = false;
        z1Var.clearReturnedFromScrapFlag();
    }

    public final void k() {
        i1 i1Var = this.f2716h.f2471m;
        this.f2714f = this.e + (i1Var != null ? i1Var.f2593j : 0);
        ArrayList arrayList = this.f2712c;
        for (int size = arrayList.size() - 1; size >= 0 && arrayList.size() > this.f2714f; size--) {
            e(size);
        }
    }
}
