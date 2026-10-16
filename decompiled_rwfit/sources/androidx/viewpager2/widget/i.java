package androidx.viewpager2.widget;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.q1;
import androidx.recyclerview.widget.w1;

/* loaded from: classes.dex */
public final class i extends LinearLayoutManager {
    public final /* synthetic */ ViewPager2 E;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i(ViewPager2 viewPager2) {
        super(1);
        this.E = viewPager2;
    }

    @Override // androidx.recyclerview.widget.LinearLayoutManager
    public final void F0(w1 w1Var, int[] iArr) {
        ViewPager2 viewPager2 = this.E;
        int offscreenPageLimit = viewPager2.getOffscreenPageLimit();
        if (offscreenPageLimit == -1) {
            super.F0(w1Var, iArr);
            return;
        }
        int pageSize = viewPager2.getPageSize() * offscreenPageLimit;
        iArr[0] = pageSize;
        iArr[1] = pageSize;
    }

    @Override // androidx.recyclerview.widget.i1
    public final void X(q1 q1Var, w1 w1Var, m1.d dVar) {
        super.X(q1Var, w1Var, dVar);
        this.E.f2964t.getClass();
    }

    @Override // androidx.recyclerview.widget.i1
    public final boolean k0(q1 q1Var, w1 w1Var, int i3, Bundle bundle) {
        this.E.f2964t.getClass();
        return super.k0(q1Var, w1Var, i3, bundle);
    }

    @Override // androidx.recyclerview.widget.i1
    public final boolean p0(RecyclerView recyclerView, View view, Rect rect, boolean z5, boolean z6) {
        return false;
    }
}
