package com.yanzhenjie.recyclerview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.i1;
import androidx.recyclerview.widget.z0;
import com.example.baselibrary.R$string;
import com.yanzhenjie.recyclerview.widget.DefaultLoadMoreView;
import java.util.ArrayList;
import m0.l;
import o4.c;
import o4.e;
import og.i;
import og.j;
import og.k;
import og.n;
import og.p;
import og.q;
import og.r;
import pg.a;
import pg.b;
import pg.d;

/* loaded from: classes2.dex */
public class SwipeRecyclerView extends RecyclerView {
    public final ArrayList A1;
    public final ArrayList B1;
    public int C1;
    public boolean D1;
    public r E1;

    /* renamed from: l1, reason: collision with root package name */
    public final int f12160l1;

    /* renamed from: m1, reason: collision with root package name */
    public SwipeMenuLayout f12161m1;

    /* renamed from: n1, reason: collision with root package name */
    public int f12162n1;

    /* renamed from: o1, reason: collision with root package name */
    public int f12163o1;

    /* renamed from: p1, reason: collision with root package name */
    public int f12164p1;

    /* renamed from: q1, reason: collision with root package name */
    public boolean f12165q1;

    /* renamed from: r1, reason: collision with root package name */
    public a f12166r1;

    /* renamed from: s1, reason: collision with root package name */
    public n f12167s1;

    /* renamed from: t1, reason: collision with root package name */
    public c f12168t1;

    /* renamed from: u1, reason: collision with root package name */
    public c f12169u1;

    /* renamed from: v1, reason: collision with root package name */
    public e f12170v1;

    /* renamed from: w1, reason: collision with root package name */
    public og.e f12171w1;

    /* renamed from: x1, reason: collision with root package name */
    public boolean f12172x1;

    /* renamed from: y1, reason: collision with root package name */
    public final ArrayList f12173y1;
    public final p z1;

    public SwipeRecyclerView(Context context) {
        this(context, null);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void V(int i3) {
        this.C1 = i3;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public final void W() {
        i1 layoutManager = getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager) {
            LinearLayoutManager linearLayoutManager = (LinearLayoutManager) layoutManager;
            int E = layoutManager.E();
            if (E > 0 && E == linearLayoutManager.Q0() + 1) {
                int i3 = this.C1;
                if (i3 == 1 || i3 == 2) {
                    m0();
                    return;
                }
                return;
            }
            return;
        }
        if (layoutManager instanceof StaggeredGridLayoutManager) {
            StaggeredGridLayoutManager staggeredGridLayoutManager = (StaggeredGridLayoutManager) layoutManager;
            int E2 = layoutManager.E();
            if (E2 <= 0) {
                return;
            }
            int[] M0 = staggeredGridLayoutManager.M0(null);
            if (E2 == M0[M0.length - 1] + 1) {
                int i10 = this.C1;
                if (i10 == 1 || i10 == 2) {
                    m0();
                }
            }
        }
    }

    public int getFooterCount() {
        og.e eVar = this.f12171w1;
        if (eVar == null) {
            return 0;
        }
        return eVar.f16936b.f15923c;
    }

    public int getHeaderCount() {
        og.e eVar = this.f12171w1;
        if (eVar == null) {
            return 0;
        }
        return eVar.f16935a.f15923c;
    }

    public z0 getOriginAdapter() {
        og.e eVar = this.f12171w1;
        if (eVar == null) {
            return null;
        }
        return eVar.f16937c;
    }

    public final void m0() {
        r rVar;
        if (this.D1 || (rVar = this.E1) == null) {
            return;
        }
        DefaultLoadMoreView defaultLoadMoreView = (DefaultLoadMoreView) rVar;
        defaultLoadMoreView.setVisibility(0);
        defaultLoadMoreView.f12174a.setVisibility(8);
        TextView textView = defaultLoadMoreView.f12175b;
        textView.setVisibility(0);
        textView.setText(R$string.x_recycler_click_load_more);
    }

    public final boolean n0(int i3, int i10, boolean z5) {
        int i11 = this.f12163o1 - i3;
        int i12 = this.f12164p1 - i10;
        int abs = Math.abs(i11);
        int i13 = this.f12160l1;
        if (abs > i13 && Math.abs(i11) > Math.abs(i12)) {
            return false;
        }
        if (Math.abs(i12) >= i13 || Math.abs(i11) >= i13) {
            return z5;
        }
        return false;
    }

    public final void o0() {
        if (this.f12166r1 == null) {
            b bVar = new b();
            a aVar = new a(bVar);
            aVar.C = bVar;
            this.f12166r1 = aVar;
            aVar.h(this);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00a4, code lost:
    
        if (r1 != 3) goto L112;
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x00d1, code lost:
    
        if (((android.view.ViewGroup) r5).getChildCount() > 0) goto L73;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x0108, code lost:
    
        if (((android.view.ViewGroup) r4).getChildCount() > 0) goto L89;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0123, code lost:
    
        if (r7 != 0) goto L90;
     */
    /* JADX WARN: Code restructure failed: missing block: B:85:0x00ec, code lost:
    
        if (r7 != 0) goto L74;
     */
    /* JADX WARN: Removed duplicated region for block: B:42:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x009c  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x012b A[ADDED_TO_REGION] */
    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean onInterceptTouchEvent(android.view.MotionEvent r15) {
        /*
            Method dump skipped, instructions count: 351
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.yanzhenjie.recyclerview.SwipeRecyclerView.onInterceptTouchEvent(android.view.MotionEvent):boolean");
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        SwipeMenuLayout swipeMenuLayout;
        if (motionEvent.getAction() == 2 && (swipeMenuLayout = this.f12161m1) != null && swipeMenuLayout.a()) {
            this.f12161m1.c();
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setAdapter(z0 z0Var) {
        og.e eVar = this.f12171w1;
        p pVar = this.z1;
        if (eVar != null) {
            eVar.f16937c.unregisterAdapterDataObserver(pVar);
        }
        if (z0Var == null) {
            this.f12171w1 = null;
        } else {
            z0Var.registerAdapterDataObserver(pVar);
            Context context = getContext();
            og.e eVar2 = new og.e();
            eVar2.f16935a = new l();
            eVar2.f16936b = new l();
            eVar2.f16938d = LayoutInflater.from(context);
            eVar2.f16937c = z0Var;
            this.f12171w1 = eVar2;
            eVar2.setOnItemClickListener(this.f12169u1);
            this.f12171w1.setOnItemLongClickListener(this.f12170v1);
            og.e eVar3 = this.f12171w1;
            eVar3.e = this.f12167s1;
            eVar3.setOnItemMenuClickListener(this.f12168t1);
            ArrayList arrayList = this.A1;
            int i3 = 0;
            if (arrayList.size() > 0) {
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    l lVar = this.f12171w1.f16935a;
                    lVar.c(lVar.f15923c + 100000, (View) obj);
                }
            }
            ArrayList arrayList2 = this.B1;
            if (arrayList2.size() > 0) {
                int size2 = arrayList2.size();
                while (i3 < size2) {
                    Object obj2 = arrayList2.get(i3);
                    i3++;
                    l lVar2 = this.f12171w1.f16936b;
                    lVar2.c(lVar2.f15923c + 200000, (View) obj2);
                }
            }
        }
        super.setAdapter(this.f12171w1);
    }

    public void setAutoLoadMore(boolean z5) {
        this.D1 = z5;
    }

    public void setItemViewSwipeEnabled(boolean z5) {
        o0();
        this.f12165q1 = z5;
        this.f12166r1.C.f17602a = z5;
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void setLayoutManager(i1 i1Var) {
        if (i1Var instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) i1Var;
            gridLayoutManager.K = new og.c(this, gridLayoutManager, gridLayoutManager.K, 1);
        }
        super.setLayoutManager(i1Var);
    }

    public void setLoadMoreListener(q qVar) {
    }

    public void setLoadMoreView(r rVar) {
        this.E1 = rVar;
    }

    public void setLongPressDragEnabled(boolean z5) {
        o0();
        this.f12166r1.C.f17603b = z5;
    }

    public void setOnItemClickListener(i iVar) {
        if (iVar == null) {
            return;
        }
        if (this.f12171w1 != null) {
            throw new IllegalStateException("Cannot set item click listener, setAdapter has already been called.");
        }
        c cVar = new c();
        cVar.f16732a = this;
        cVar.f16733b = iVar;
        this.f12169u1 = cVar;
    }

    public void setOnItemLongClickListener(j jVar) {
        if (jVar == null) {
            return;
        }
        if (this.f12171w1 != null) {
            throw new IllegalStateException("Cannot set item long click listener, setAdapter has already been called.");
        }
        e eVar = new e();
        eVar.f16737a = this;
        eVar.f16738b = jVar;
        this.f12170v1 = eVar;
    }

    public void setOnItemMenuClickListener(k kVar) {
        if (kVar == null) {
            return;
        }
        if (this.f12171w1 != null) {
            throw new IllegalStateException("Cannot set menu item click listener, setAdapter has already been called.");
        }
        c cVar = new c();
        cVar.f16732a = this;
        cVar.f16733b = kVar;
        this.f12168t1 = cVar;
    }

    public void setOnItemMoveListener(pg.c cVar) {
        o0();
        this.f12166r1.setOnItemMoveListener(cVar);
    }

    public void setOnItemMovementListener(d dVar) {
        o0();
        this.f12166r1.setOnItemMovementListener(dVar);
    }

    public void setOnItemStateChangedListener(pg.e eVar) {
        o0();
        this.f12166r1.setOnItemStateChangedListener(eVar);
    }

    public void setSwipeItemMenuEnabled(boolean z5) {
        this.f12172x1 = z5;
    }

    public void setSwipeMenuCreator(n nVar) {
        if (nVar == null) {
            return;
        }
        if (this.f12171w1 != null) {
            throw new IllegalStateException("Cannot set menu creator, setAdapter has already been called.");
        }
        this.f12167s1 = nVar;
    }

    public SwipeRecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeRecyclerView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f12162n1 = -1;
        this.f12172x1 = true;
        this.f12173y1 = new ArrayList();
        this.z1 = new p(this);
        this.A1 = new ArrayList();
        this.B1 = new ArrayList();
        this.C1 = -1;
        this.D1 = true;
        this.f12160l1 = ViewConfiguration.get(getContext()).getScaledTouchSlop();
    }
}
