package com.example.test.ui.device.activity;

import com.example.test.ui.device.model.RemindModel;
import java.util.List;

/* loaded from: classes.dex */
public final /* synthetic */ class p implements a7.d, t6.e {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LongSitJLActivity f7884a;

    @Override // t6.e
    public void a(int i3, int i10) {
        LongSitJLActivity this$0 = this.f7884a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        int i11 = LongSitJLActivity.J;
        this$0.S0().setAdvanceIndex(i10);
        this$0.S0().setRemindDuration(((RemindModel) ((List) this$0.G.getValue()).get(i10)).getTimeInMinutes());
        this$0.R0();
    }

    @Override // a7.d
    public void j(boolean z5) {
        int i3 = LongSitJLActivity.J;
        LongSitJLActivity this$0 = this.f7884a;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        this$0.S0().setOpen(z5);
    }
}
