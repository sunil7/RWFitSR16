package com.example.test.ui.mine.activity;

import com.example.network.bean.WxAuthInfoBean;
import com.example.network.bean.WxUserInfoBean;
import com.example.test.R$string;
import com.example.test.ui.mine.model.WxLoginInfoBean;
import com.example.test.utils.w0;

/* loaded from: classes.dex */
public final class m extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LoginActivity f8137d;
    public final /* synthetic */ WxAuthInfoBean.AuthInfo e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public m(LoginActivity loginActivity, WxAuthInfoBean.AuthInfo authInfo, w0 w0Var) {
        super(loginActivity, w0Var);
        this.f8137d = loginActivity;
        this.e = authInfo;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        LoginActivity loginActivity = this.f8137d;
        loginActivity.b0();
        loginActivity.w0(R$string.str_login_fail);
    }

    @Override // d6.b
    public final void b(Object obj) {
        WxUserInfoBean wxUserInfoBean = (WxUserInfoBean) obj;
        LoginActivity loginActivity = this.f8137d;
        loginActivity.b0();
        if (wxUserInfoBean != null) {
            WxLoginInfoBean wxLoginInfoBean = new WxLoginInfoBean();
            loginActivity.H = wxLoginInfoBean;
            wxLoginInfoBean.setUserNickName(wxUserInfoBean.getNickname());
            wxLoginInfoBean.setUserAvatar(wxUserInfoBean.getHeadimgurl());
            wxLoginInfoBean.setGenderType(wxUserInfoBean.getSex() == 0 ? 2 : 1);
            wxLoginInfoBean.setYear("1990");
            com.example.test.presenter.mine.k kVar = (com.example.test.presenter.mine.k) loginActivity.I0();
            String openid = this.e.getOpenid();
            kotlin.jvm.internal.e.e(openid, "getOpenid(...)");
            kVar.k(openid, "1");
        }
    }
}
