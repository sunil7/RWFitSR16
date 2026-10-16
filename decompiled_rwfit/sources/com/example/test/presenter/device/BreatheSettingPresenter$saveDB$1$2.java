package com.example.test.presenter.device;

import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.BreatheSettingActivity;
import kotlin.jvm.internal.Lambda;

/* loaded from: classes.dex */
final class BreatheSettingPresenter$saveDB$1$2 extends Lambda implements oh.l {
    final /* synthetic */ boolean $isCallback;
    final /* synthetic */ l this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BreatheSettingPresenter$saveDB$1$2(l lVar, boolean z5) {
        super(1);
        this.this$0 = lVar;
        this.$isCallback = z5;
    }

    @Override // oh.l
    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((Long) obj);
        return eh.g.f12633a;
    }

    public final void invoke(Long l3) {
        ((XXBaseActivity) ((f7.c) this.this$0.f7255a)).b0();
        if (this.$isCallback) {
            BreatheSettingActivity breatheSettingActivity = (BreatheSettingActivity) ((f7.c) this.this$0.f7255a);
            breatheSettingActivity.w0(R$string.str_save_success);
            breatheSettingActivity.finish();
        }
    }
}
