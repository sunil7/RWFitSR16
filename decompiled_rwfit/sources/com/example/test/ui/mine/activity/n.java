package com.example.test.ui.mine.activity;

import com.example.network.api.WxAuthApi;
import com.example.network.bean.WxAuthInfoBean;
import com.example.network.bean.WxUserInfoBean;
import com.example.test.R$string;
import com.example.test.utils.w0;

/* loaded from: classes.dex */
public final class n extends d6.b {

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ LoginActivity f8138d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(LoginActivity loginActivity, w0 w0Var) {
        super(loginActivity, w0Var);
        this.f8138d = loginActivity;
    }

    @Override // d6.b
    public final void a(int i3, Throwable th2) {
        LoginActivity loginActivity = this.f8138d;
        loginActivity.b0();
        loginActivity.w0(R$string.str_login_fail);
    }

    @Override // d6.b
    public final void b(Object obj) {
        WxAuthInfoBean.AuthInfo authInfo = (WxAuthInfoBean.AuthInfo) obj;
        if (authInfo != null) {
            c6.e eVar = c6.e.f3393c;
            String access_token = authInfo.getAccess_token();
            kotlin.jvm.internal.e.e(access_token, "getAccess_token(...)");
            String openid = authInfo.getOpenid();
            kotlin.jvm.internal.e.e(openid, "getOpenid(...)");
            eVar.getClass();
            rg.l<WxUserInfoBean> wxUserInfo = ((WxAuthApi) eVar.f113a).getWxUserInfo(access_token, openid);
            kotlin.jvm.internal.e.e(wxUserInfo, "getWxUserInfo(...)");
            com.example.baselibrary.utils.b.w(wxUserInfo).subscribe(new m(this.f8138d, authInfo, w0.d()));
        }
    }
}
