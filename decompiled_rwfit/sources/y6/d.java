package y6;

import android.R;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.View;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.c0;
import androidx.recyclerview.widget.g1;
import androidx.recyclerview.widget.i1;
import androidx.recyclerview.widget.w1;
import androidx.recyclerview.widget.z1;
import com.example.test.ui.view.divider.FlexibleDividerDecoration$DividerType;
import eb.e;
import o2.m;

/* loaded from: classes.dex */
public final class d extends g1 {

    /* renamed from: h, reason: collision with root package name */
    public static final int[] f20014h = {R.attr.listDivider};

    /* renamed from: a, reason: collision with root package name */
    public FlexibleDividerDecoration$DividerType f20015a;

    /* renamed from: b, reason: collision with root package name */
    public e f20016b;

    /* renamed from: c, reason: collision with root package name */
    public m f20017c;

    /* renamed from: d, reason: collision with root package name */
    public xg.b f20018d;
    public b e;

    /* renamed from: f, reason: collision with root package name */
    public Paint f20019f;

    /* renamed from: g, reason: collision with root package name */
    public ec.a f20020g;

    public static int i(RecyclerView recyclerView) {
        if (!(recyclerView.getLayoutManager() instanceof GridLayoutManager)) {
            return 1;
        }
        GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
        c0 c0Var = gridLayoutManager.K;
        int i3 = gridLayoutManager.F;
        int itemCount = recyclerView.getAdapter().getItemCount();
        for (int i10 = itemCount - 1; i10 >= 0; i10--) {
            if (c0Var.getSpanIndex(i10, i3) == 0) {
                return itemCount - i10;
            }
        }
        return 1;
    }

    @Override // androidx.recyclerview.widget.g1
    public final void e(Rect rect, View view, RecyclerView recyclerView, w1 w1Var) {
        recyclerView.getClass();
        z1 L = RecyclerView.L(view);
        int absoluteAdapterPosition = L != null ? L.getAbsoluteAdapterPosition() : -1;
        if (absoluteAdapterPosition >= recyclerView.getAdapter().getItemCount() - i(recyclerView)) {
            return;
        }
        if (recyclerView.getLayoutManager() instanceof GridLayoutManager) {
            GridLayoutManager gridLayoutManager = (GridLayoutManager) recyclerView.getLayoutManager();
            absoluteAdapterPosition = gridLayoutManager.K.getSpanGroupIndex(absoluteAdapterPosition, gridLayoutManager.F);
        }
        this.f20016b.getClass();
        i1 layoutManager = recyclerView.getLayoutManager();
        if (layoutManager instanceof LinearLayoutManager ? ((LinearLayoutManager) layoutManager).f2430t : false) {
            rect.set(0, h(absoluteAdapterPosition, recyclerView), 0, 0);
        } else {
            rect.set(0, 0, 0, h(absoluteAdapterPosition, recyclerView));
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0054, code lost:
    
        if (r10.K.getSpanIndex(r12, r10.F) > 0) goto L15;
     */
    @Override // androidx.recyclerview.widget.g1
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void f(android.graphics.Canvas r24, androidx.recyclerview.widget.RecyclerView r25) {
        /*
            Method dump skipped, instructions count: 349
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: y6.d.f(android.graphics.Canvas, androidx.recyclerview.widget.RecyclerView):void");
    }

    public final int h(int i3, RecyclerView recyclerView) {
        b bVar = this.e;
        if (bVar != null) {
            return bVar.b();
        }
        xg.b bVar2 = this.f20018d;
        if (bVar2 != null) {
            return ((Drawable) bVar2.f19825a).getIntrinsicHeight();
        }
        throw new RuntimeException("failed to get size");
    }
}
