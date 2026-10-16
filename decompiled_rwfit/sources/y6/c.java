package y6;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.c0;
import androidx.recyclerview.widget.e2;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.i1;
import androidx.recyclerview.widget.i2;
import androidx.recyclerview.widget.w1;
import androidx.recyclerview.widget.z1;

/* loaded from: classes.dex */
public final class c extends g1 {

    /* renamed from: a, reason: collision with root package name */
    public int f20010a;

    /* renamed from: b, reason: collision with root package name */
    public final int f20011b;

    /* renamed from: c, reason: collision with root package name */
    public int f20012c;

    /* renamed from: d, reason: collision with root package name */
    public int f20013d;

    public c(int i3) {
        this.f20012c = 1;
        this.f20013d = -1;
        this.f20011b = i3;
    }

    @Override // androidx.recyclerview.widget.g1
    public final void e(Rect rect, View view, RecyclerView recyclerView, w1 w1Var) {
        int i3;
        boolean z5;
        int i10;
        int b3 = w1Var.b() - 1;
        recyclerView.getClass();
        z1 L = RecyclerView.L(view);
        int absoluteAdapterPosition = L != null ? L.getAbsoluteAdapterPosition() : -1;
        if (absoluteAdapterPosition < 0 || absoluteAdapterPosition > b3 - this.f20012c) {
            return;
        }
        i1 layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) layoutManager;
            c0 c0Var = gridLayoutManager.K;
            int i11 = gridLayoutManager.F;
            int spanSize = c0Var.getSpanSize(absoluteAdapterPosition);
            this.f20010a = i11 / spanSize;
            i10 = c0Var.getSpanIndex(absoluteAdapterPosition, i11) / spanSize;
            i3 = c0Var.getSpanGroupIndex(absoluteAdapterPosition, i11);
            z5 = false;
        } else if (layoutManager instanceof StaggeredGridLayoutManager) {
            e2 e2Var = (e2) view.getLayoutParams();
            i2 i2Var = e2Var.e;
            i10 = i2Var == null ? -1 : i2Var.e;
            z5 = e2Var.f2556f;
            this.f20010a = ((StaggeredGridLayoutManager) layoutManager).f2486p;
            i3 = -1;
        } else {
            i3 = -1;
            z5 = false;
            i10 = 0;
        }
        int i12 = this.f20011b;
        if (z5) {
            rect.left = 0;
            rect.right = 0;
        } else {
            int i13 = this.f20010a;
            rect.left = i12 - ((i10 * i12) / i13);
            rect.right = ((i10 + 1) * i12) / i13;
        }
        if (i3 <= -1) {
            if (this.f20013d == -1 && absoluteAdapterPosition < this.f20010a && z5) {
                this.f20013d = absoluteAdapterPosition;
            }
            int i14 = this.f20013d;
            if ((i14 == -1 || absoluteAdapterPosition < i14) && absoluteAdapterPosition < this.f20010a) {
                rect.top = i12;
            }
        } else if (i3 < 1 && absoluteAdapterPosition < this.f20010a) {
            rect.top = i12;
        }
        rect.bottom = i12;
    }

    public c(int i3, int i10) {
        this.f20012c = 1;
        this.f20013d = -1;
        this.f20010a = 2;
        this.f20011b = i3;
    }
}
