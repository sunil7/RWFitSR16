package androidx.appcompat.app;

/* loaded from: classes.dex */
public final class q implements Runnable {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f562a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ c0 f563b;

    public /* synthetic */ q(c0 c0Var, int i3) {
        this.f562a = i3;
        this.f563b = c0Var;
    }

    /* JADX WARN: Code restructure failed: missing block: B:11:0x0027, code lost:
    
        if (l1.k0.c(r3) != false) goto L15;
     */
    @Override // java.lang.Runnable
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void run() {
        /*
            r6 = this;
            r0 = 1
            androidx.appcompat.app.c0 r1 = r6.f563b
            r2 = 0
            int r3 = r6.f562a
            switch(r3) {
                case 0: goto L54;
                default: goto L9;
            }
        L9:
            android.widget.PopupWindow r3 = r1.f443w
            androidx.appcompat.widget.ActionBarContextView r4 = r1.f442v
            r5 = 55
            r3.showAtLocation(r4, r5, r2, r2)
            l1.g1 r3 = r1.f445y
            if (r3 == 0) goto L19
            r3.b()
        L19:
            boolean r3 = r1.f446z
            if (r3 == 0) goto L2a
            android.view.ViewGroup r3 = r1.A
            if (r3 == 0) goto L2a
            java.util.WeakHashMap r4 = l1.z0.f15748a
            boolean r3 = l1.k0.c(r3)
            if (r3 == 0) goto L2a
            goto L2b
        L2a:
            r0 = r2
        L2b:
            r3 = 1065353216(0x3f800000, float:1.0)
            if (r0 == 0) goto L49
            androidx.appcompat.widget.ActionBarContextView r0 = r1.f442v
            r4 = 0
            r0.setAlpha(r4)
            androidx.appcompat.widget.ActionBarContextView r0 = r1.f442v
            l1.g1 r0 = l1.z0.a(r0)
            r0.a(r3)
            r1.f445y = r0
            androidx.appcompat.app.s r1 = new androidx.appcompat.app.s
            r1.<init>(r6, r2)
            r0.d(r1)
            goto L53
        L49:
            androidx.appcompat.widget.ActionBarContextView r0 = r1.f442v
            r0.setAlpha(r3)
            androidx.appcompat.widget.ActionBarContextView r0 = r1.f442v
            r0.setVisibility(r2)
        L53:
            return
        L54:
            int r3 = r1.Z
            r0 = r0 & r3
            if (r0 == 0) goto L5c
            r1.v(r2)
        L5c:
            int r0 = r1.Z
            r0 = r0 & 4096(0x1000, float:5.74E-42)
            if (r0 == 0) goto L67
            r0 = 108(0x6c, float:1.51E-43)
            r1.v(r0)
        L67:
            r1.Y = r2
            r1.Z = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.q.run():void");
    }
}
