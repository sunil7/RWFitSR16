package og;

import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.c0;

/* loaded from: classes2.dex */
public final class c extends c0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f16931a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ GridLayoutManager f16932b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ c0 f16933c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ Object f16934d;

    public /* synthetic */ c(Object obj, GridLayoutManager gridLayoutManager, c0 c0Var, int i3) {
        this.f16931a = i3;
        this.f16934d = obj;
        this.f16932b = gridLayoutManager;
        this.f16933c = c0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:6:0x0011, code lost:
    
        if (r3 < r1.f16935a.f15923c) goto L12;
     */
    @Override // androidx.recyclerview.widget.c0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int getSpanSize(int r3) {
        /*
            r2 = this;
            int r0 = r2.f16931a
            switch(r0) {
                case 0: goto L34;
                default: goto L5;
            }
        L5:
            java.lang.Object r0 = r2.f16934d
            com.yanzhenjie.recyclerview.SwipeRecyclerView r0 = (com.yanzhenjie.recyclerview.SwipeRecyclerView) r0
            og.e r1 = r0.f12171w1
            if (r3 < 0) goto L14
            m0.l r1 = r1.f16935a
            int r1 = r1.f15923c
            if (r3 >= r1) goto L17
            goto L1f
        L14:
            r1.getClass()
        L17:
            og.e r1 = r0.f12171w1
            boolean r1 = r1.b(r3)
            if (r1 == 0) goto L24
        L1f:
            androidx.recyclerview.widget.GridLayoutManager r3 = r2.f16932b
            int r3 = r3.F
            goto L33
        L24:
            androidx.recyclerview.widget.c0 r1 = r2.f16933c
            if (r1 == 0) goto L32
            int r0 = r0.getHeaderCount()
            int r3 = r3 - r0
            int r3 = r1.getSpanSize(r3)
            goto L33
        L32:
            r3 = 1
        L33:
            return r3
        L34:
            java.lang.Object r0 = r2.f16934d
            og.e r0 = (og.e) r0
            if (r3 < 0) goto L41
            m0.l r1 = r0.f16935a
            int r1 = r1.f15923c
            if (r3 >= r1) goto L41
            goto L47
        L41:
            boolean r0 = r0.b(r3)
            if (r0 == 0) goto L4c
        L47:
            androidx.recyclerview.widget.GridLayoutManager r3 = r2.f16932b
            int r3 = r3.F
            goto L56
        L4c:
            androidx.recyclerview.widget.c0 r0 = r2.f16933c
            if (r0 == 0) goto L55
            int r3 = r0.getSpanSize(r3)
            goto L56
        L55:
            r3 = 1
        L56:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: og.c.getSpanSize(int):int");
    }
}
