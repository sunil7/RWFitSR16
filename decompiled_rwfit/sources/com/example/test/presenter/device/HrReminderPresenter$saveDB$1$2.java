package com.example.test.presenter.device;

import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.HrReminderActivity;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
final class HrReminderPresenter$saveDB$1$2 extends Lambda implements oh.l {
    final /* synthetic */ m0 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HrReminderPresenter$saveDB$1$2(m0 m0Var) {
        super(1);
        this.this$0 = m0Var;
    }

    @Override // oh.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return eh.g.f12633a;
    }

    public final void invoke(long j4) {
        ((XXBaseActivity) ((f7.n) this.this$0.f7255a)).b0();
        if (j4 > 0) {
            ((HrReminderActivity) ((f7.n) this.this$0.f7255a)).getClass();
            com.example.baselibrary.utils.d.a(R$string.str_save_success);
        } else {
            ((HrReminderActivity) ((f7.n) this.this$0.f7255a)).getClass();
            com.example.baselibrary.utils.d.a(R$string.str_save_fail);
        }
    }
}
