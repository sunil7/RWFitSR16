package og;

import androidx.recyclerview.widget.b1;
import com.yanzhenjie.recyclerview.SwipeRecyclerView;

/* loaded from: classes2.dex */
public final class p extends b1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ SwipeRecyclerView f16950a;

    public p(SwipeRecyclerView swipeRecyclerView) {
        this.f16950a = swipeRecyclerView;
    }

    @Override // androidx.recyclerview.widget.b1
    public final void a() {
        this.f16950a.f12171w1.notifyDataSetChanged();
    }

    @Override // androidx.recyclerview.widget.b1
    public final void b(int i3, int i10, Object obj) {
        SwipeRecyclerView swipeRecyclerView = this.f16950a;
        swipeRecyclerView.f12171w1.notifyItemRangeChanged(swipeRecyclerView.getHeaderCount() + i3, i10, obj);
    }

    @Override // androidx.recyclerview.widget.b1
    public final void c(int i3, int i10) {
        SwipeRecyclerView swipeRecyclerView = this.f16950a;
        swipeRecyclerView.f12171w1.notifyItemRangeInserted(swipeRecyclerView.getHeaderCount() + i3, i10);
    }

    @Override // androidx.recyclerview.widget.b1
    public final void d(int i3, int i10) {
        SwipeRecyclerView swipeRecyclerView = this.f16950a;
        swipeRecyclerView.f12171w1.notifyItemMoved(swipeRecyclerView.getHeaderCount() + i3, swipeRecyclerView.getHeaderCount() + i10);
    }

    @Override // androidx.recyclerview.widget.b1
    public final void e(int i3, int i10) {
        SwipeRecyclerView swipeRecyclerView = this.f16950a;
        swipeRecyclerView.f12171w1.notifyItemRangeRemoved(swipeRecyclerView.getHeaderCount() + i3, i10);
    }
}
