package com.example.test.presenter.device;

import com.example.blesdk.bean.function.BreatheBean;
import com.example.test.R$string;
import com.example.test.ui.device.activity.BreatheSettingActivity;

/* loaded from: classes.dex */
public final class k implements w5.c {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f7442a;

    public k(l lVar) {
        this.f7442a = lVar;
    }

    @Override // w5.c
    public final void a(int i3) {
        ((BreatheSettingActivity) ((f7.c) this.f7442a.f7255a)).w0(R$string.str_save_fail);
    }

    @Override // w5.c
    public final void c() {
        l lVar = this.f7442a;
        BreatheBean breatheBean = lVar.f7455c;
        if (breatheBean != null) {
            com.example.baselibrary.preseneter.b.j(breatheBean, BreatheSettingPresenter$saveDB$1$1.INSTANCE, new BreatheSettingPresenter$saveDB$1$2(lVar, true));
        }
    }
}
