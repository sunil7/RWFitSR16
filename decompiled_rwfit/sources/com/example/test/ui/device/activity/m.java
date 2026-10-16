package com.example.test.ui.device.activity;

import com.scwang.smart.refresh.layout.constant.RefreshState;

/* loaded from: classes.dex */
public final /* synthetic */ class m {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DialListActivity f7876a;

    public /* synthetic */ m(DialListActivity dialListActivity) {
        this.f7876a = dialListActivity;
    }

    public void a(eg.d it) {
        int i3 = DialListActivity.L;
        DialListActivity this$0 = this.f7876a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        kotlin.jvm.internal.e.f(it, "it");
        if (((f6.y) this$0.f7247z.getValue()).f13453c.f11654g1 == RefreshState.Refreshing) {
            return;
        }
        int size = this$0.R0().size();
        int i10 = this$0.G;
        if (size % i10 == 0) {
            this$0.F++;
            ((com.example.test.presenter.device.z) this$0.I0()).k(((Number) this$0.I.getValue()).intValue(), this$0.F, i10);
        }
    }
}
