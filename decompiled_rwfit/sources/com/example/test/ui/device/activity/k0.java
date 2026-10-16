package com.example.test.ui.device.activity;

import com.example.test.ui.device.model.RemindModel;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class k0 implements a7.d, t6.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WashHandActivity f7872a;

    @Override // t6.e
    public void a(int i3, int i10) {
        WashHandActivity this$0 = this.f7872a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        int i11 = WashHandActivity.J;
        this$0.S0().setAdvanceIndex(i10);
        this$0.S0().setRemindDuration(((RemindModel) ((List) this$0.F.getValue()).get(i10)).getTimeInMinutes());
        this$0.R0();
    }

    @Override // a7.d
    public void j(boolean z5) {
        int i3 = WashHandActivity.J;
        WashHandActivity this$0 = this.f7872a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        this$0.S0().setOpen(z5);
    }
}
