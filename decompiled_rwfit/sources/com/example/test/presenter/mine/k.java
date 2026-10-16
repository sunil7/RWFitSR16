package com.example.test.presenter.mine;

import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.LoginResultBean;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.mine.activity.LoginActivity;
import com.example.test.utils.w0;

/* loaded from: classes.dex */
public final class k extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(String str, String str2) {
        Object obj = (h7.f) this.f7255a;
        ((XXBaseActivity) obj).V();
        c6.d dVar = c6.d.f3392c;
        dVar.getClass();
        rg.l<HttpModel<LoginResultBean>> otherLogin = ((UserApi) dVar.f113a).otherLogin(str, str2);
        kotlin.jvm.internal.e.e(otherLogin, "otherLogin(...)");
        rg.l w8 = com.example.baselibrary.utils.b.w(otherLogin);
        LoginActivity loginActivity = (LoginActivity) obj;
        loginActivity.getClass();
        w8.subscribe(new j(this, loginActivity, w0.d(), 1));
    }
}
