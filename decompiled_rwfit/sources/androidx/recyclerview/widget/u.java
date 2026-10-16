package androidx.recyclerview.widget;

/* loaded from: classes.dex */
public final class u extends n1 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ w f2744a;

    public u(w wVar) {
        this.f2744a = wVar;
    }

    @Override // androidx.recyclerview.widget.n1
    public final void b(RecyclerView recyclerView, int i3, int i10) {
        int computeHorizontalScrollOffset = recyclerView.computeHorizontalScrollOffset();
        int computeVerticalScrollOffset = recyclerView.computeVerticalScrollOffset();
        w wVar = this.f2744a;
        int computeVerticalScrollRange = wVar.f2774s.computeVerticalScrollRange();
        int i11 = wVar.r;
        int i12 = computeVerticalScrollRange - i11;
        int i13 = wVar.f2758a;
        wVar.f2775t = i12 > 0 && i11 >= i13;
        int computeHorizontalScrollRange = wVar.f2774s.computeHorizontalScrollRange();
        int i14 = wVar.f2773q;
        boolean z5 = computeHorizontalScrollRange - i14 > 0 && i14 >= i13;
        wVar.f2776u = z5;
        boolean z6 = wVar.f2775t;
        if (!z6 && !z5) {
            if (wVar.f2777v != 0) {
                wVar.k(0);
                return;
            }
            return;
        }
        if (z6) {
            float f2 = i11;
            wVar.f2768l = (int) ((((f2 / 2.0f) + computeVerticalScrollOffset) * f2) / computeVerticalScrollRange);
            wVar.f2767k = Math.min(i11, (i11 * i11) / computeVerticalScrollRange);
        }
        if (wVar.f2776u) {
            float f10 = computeHorizontalScrollOffset;
            float f11 = i14;
            wVar.f2771o = (int) ((((f11 / 2.0f) + f10) * f11) / computeHorizontalScrollRange);
            wVar.f2770n = Math.min(i14, (i14 * i14) / computeHorizontalScrollRange);
        }
        int i15 = wVar.f2777v;
        if (i15 == 0 || i15 == 1) {
            wVar.k(1);
        }
    }
}
