package com.example.test.presenter.device;

import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.BoReminderActivity;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
final class BoReminderPresenter$saveDB$1$2 extends Lambda implements oh.l {
    final /* synthetic */ i this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoReminderPresenter$saveDB$1$2(i iVar) {
        super(1);
        this.this$0 = iVar;
    }

    @Override // oh.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).longValue());
        return eh.g.f12633a;
    }

    public final void invoke(long j4) {
        ((XXBaseActivity) ((f7.b) this.this$0.f7255a)).b0();
        if (j4 > 0) {
            ((BoReminderActivity) ((f7.b) this.this$0.f7255a)).getClass();
            com.example.baselibrary.utils.d.a(R$string.str_save_success);
        } else {
            ((BoReminderActivity) ((f7.b) this.this$0.f7255a)).getClass();
            com.example.baselibrary.utils.d.a(R$string.str_save_fail);
        }
    }
}
