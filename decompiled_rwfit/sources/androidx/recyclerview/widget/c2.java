package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class c2 extends n1 {

    /* renamed from: a, reason: collision with root package name */
    public boolean f2522a = false;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ v0 f2523b;

    public c2(v0 v0Var) {
        this.f2523b = v0Var;
    }

    @Override // androidx.recyclerview.widget.n1
    public final void a(int i3, RecyclerView recyclerView) {
        if (i3 == 0 && this.f2522a) {
            this.f2522a = false;
            this.f2523b.h();
        }
    }

    @Override // androidx.recyclerview.widget.n1
    public final void b(RecyclerView recyclerView, int i3, int i10) {
        if (i3 == 0 && i10 == 0) {
            return;
        }
        this.f2522a = true;
    }
}
