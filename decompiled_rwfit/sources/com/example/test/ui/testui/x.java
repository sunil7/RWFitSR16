package com.example.test.ui.testui;

import com.example.test.R$id;

/* loaded from: classes.dex */
public final class x implements a7.b, a7.f {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ TRingFamilySportsActivity f8326a;

    public /* synthetic */ x(TRingFamilySportsActivity tRingFamilySportsActivity) {
        this.f8326a = tRingFamilySportsActivity;
    }

    @Override // a7.b
    public void a(String year) {
        kotlin.jvm.internal.e.f(year, "year");
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0041  */
    @Override // a7.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void b(java.lang.String r6) {
        /*
            r5 = this;
            java.lang.String r0 = "date"
            kotlin.jvm.internal.e.f(r6, r0)
            com.example.test.ui.testui.TRingFamilySportsActivity r0 = r5.f8326a
            java.text.SimpleDateFormat r1 = new java.text.SimpleDateFormat
            java.lang.String r2 = "yyyy/MM/dd"
            java.util.Locale r3 = java.util.Locale.ENGLISH
            r1.<init>(r2, r3)
            java.util.Date r1 = r1.parse(r6)     // Catch: java.lang.Exception -> L1f
            if (r1 == 0) goto L33
            long r1 = r1.getTime()     // Catch: java.lang.Exception -> L1f
            r3 = 1000(0x3e8, float:1.401E-42)
            long r3 = (long) r3     // Catch: java.lang.Exception -> L1f
            long r1 = r1 / r3
            goto L35
        L1f:
            r1 = move-exception
            java.lang.String r1 = r1.getMessage()
            java.lang.String r2 = " date translate error "
            java.lang.String r6 = r5.a.c(r6, r2, r1)
            java.lang.Object[] r6 = new java.lang.Object[]{r6}
            java.lang.String r1 = com.example.baselibrary.utils.b.f7264b
            com.example.baselibrary.utils.b.o(r1, r6)
        L33:
            r1 = 0
        L35:
            com.example.baselibrary.preseneter.b r6 = r0.I0()
            com.example.test.presenter.main.n0 r6 = (com.example.test.presenter.main.n0) r6
            int r0 = r0.H
            p5.a r3 = r6.f7255a
            if (r0 > 0) goto L47
            g7.m r3 = (g7.m) r3
            r3.getClass()
            goto L7c
        L47:
            g7.m r3 = (g7.m) r3
            r4 = r3
            com.example.test.ui.XXBaseActivity r4 = (com.example.test.ui.XXBaseActivity) r4
            r4.V()
            c6.d r4 = c6.d.f3392c
            java.lang.Object r4 = r4.f113a
            com.example.network.api.UserApi r4 = (com.example.network.api.UserApi) r4
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Long r1 = java.lang.Long.valueOf(r1)
            rg.l r0 = r4.memberFriendData(r0, r1)
            java.lang.String r1 = "memberFriendData(...)"
            kotlin.jvm.internal.e.e(r0, r1)
            rg.l r0 = com.example.baselibrary.utils.b.w(r0)
            com.example.test.ui.testui.TRingFamilySportsActivity r3 = (com.example.test.ui.testui.TRingFamilySportsActivity) r3
            r3.getClass()
            com.example.test.utils.w0 r1 = com.example.test.utils.w0.d()
            com.example.test.presenter.main.m0 r2 = new com.example.test.presenter.main.m0
            r4 = 1
            r2.<init>(r6, r3, r1, r4)
            r0.subscribe(r2)
        L7c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.example.test.ui.testui.x.b(java.lang.String):void");
    }

    @Override // a7.b
    public void c(String month) {
        kotlin.jvm.internal.e.f(month, "month");
    }

    @Override // a7.b
    public void d(String str, String str2) {
    }

    @Override // a7.f
    public void j(int i3) {
        int i10 = R$id.barStatusIv;
        TRingFamilySportsActivity tRingFamilySportsActivity = this.f8326a;
        if (i3 == i10) {
            tRingFamilySportsActivity.finish();
        }
        if (i3 == R$id.option2) {
            tRingFamilySportsActivity.K0();
        }
    }
}
