package pg;

import android.graphics.Canvas;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.g0;
import androidx.recyclerview.widget.i1;
import androidx.recyclerview.widget.z1;

/* loaded from: classes2.dex */
public final class b extends g0 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f17602a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f17603b;

    @Override // androidx.recyclerview.widget.g0
    public final int getMovementFlags(RecyclerView recyclerView, z1 z1Var) {
        i1 layoutManager = recyclerView.getLayoutManager();
        return layoutManager instanceof GridLayoutManager ? ((LinearLayoutManager) layoutManager).f2427p == 0 ? g0.makeMovementFlags(15, 3) : g0.makeMovementFlags(15, 12) : layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).f2427p == 0 ? g0.makeMovementFlags(12, 3) : g0.makeMovementFlags(3, 12) : g0.makeMovementFlags(0, 0);
    }

    @Override // androidx.recyclerview.widget.g0
    public final boolean isItemViewSwipeEnabled() {
        return this.f17602a;
    }

    @Override // androidx.recyclerview.widget.g0
    public final boolean isLongPressDragEnabled() {
        return this.f17603b;
    }

    @Override // androidx.recyclerview.widget.g0
    public final void onChildDraw(Canvas canvas, RecyclerView recyclerView, z1 z1Var, float f2, float f10, int i3, boolean z5) {
        float abs;
        int width;
        if (i3 == 1) {
            i1 layoutManager = recyclerView.getLayoutManager();
            float f11 = 1.0f;
            if (layoutManager instanceof LinearLayoutManager) {
                int i10 = ((LinearLayoutManager) layoutManager).f2427p;
                if (i10 == 0) {
                    abs = Math.abs(f10);
                    width = z1Var.itemView.getHeight();
                } else if (i10 == 1) {
                    abs = Math.abs(f2);
                    width = z1Var.itemView.getWidth();
                }
                f11 = 1.0f - (abs / width);
            }
            z1Var.itemView.setAlpha(f11);
        }
        super.onChildDraw(canvas, recyclerView, z1Var, f2, f10, i3, z5);
    }

    @Override // androidx.recyclerview.widget.g0
    public final boolean onMove(RecyclerView recyclerView, z1 z1Var, z1 z1Var2) {
        return false;
    }

    @Override // androidx.recyclerview.widget.g0
    public final void onSelectedChanged(z1 z1Var, int i3) {
    }

    @Override // androidx.recyclerview.widget.g0
    public final void onSwiped(z1 z1Var, int i3) {
    }

    public void setOnItemMoveListener(c cVar) {
    }

    public void setOnItemMovementListener(d dVar) {
    }

    public void setOnItemStateChangedListener(e eVar) {
    }
}
