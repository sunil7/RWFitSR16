package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class b implements s0 {

    /* renamed from: a, reason: collision with root package name */
    public final Object f2516a;

    public /* synthetic */ b(Object obj) {
        this.f2516a = obj;
    }

    @Override // androidx.recyclerview.widget.s0
    public void onChanged(int i3, int i10, Object obj) {
        ((h5.a) this.f2516a).notifyItemRangeChanged(i3, i10, obj);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onInserted(int i3, int i10) {
        ((h5.a) this.f2516a).notifyItemRangeInserted(i3, i10);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onMoved(int i3, int i10) {
        ((h5.a) this.f2516a).notifyItemMoved(i3, i10);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onRemoved(int i3, int i10) {
        ((h5.a) this.f2516a).notifyItemRangeRemoved(i3, i10);
    }
}
