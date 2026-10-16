package com.example.test.ui.mine.activity;

import com.example.test.R$string;
import com.example.test.ui.mine.model.WxLoginInfoBean;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class l implements IUiListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoginActivity f8136a;

    public l(LoginActivity loginActivity) {
        this.f8136a = loginActivity;
    }

    @Override // com.tencent.tauth.IUiListener
    public final void onCancel() {
        LoginActivity loginActivity = this.f8136a;
        loginActivity.b0();
        loginActivity.w0(R$string.str_login_fail);
    }

    @Override // com.tencent.tauth.IUiListener
    public final void onComplete(Object obj) {
        LoginActivity loginActivity = this.f8136a;
        if (obj == null) {
            loginActivity.b0();
            loginActivity.w0(R$string.str_login_fail);
            return;
        }
        new StringBuilder("userInfo onComplete ").append(com.example.baselibrary.utils.b.z(obj));
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.length() == 0) {
            loginActivity.b0();
            loginActivity.w0(R$string.str_login_fail);
            return;
        }
        String string = jSONObject.getString("nickname");
        int i3 = jSONObject.getInt("gender_type");
        String string2 = jSONObject.getString("figureurl_qq");
        String string3 = jSONObject.getString("year");
        loginActivity.H = new WxLoginInfoBean();
        WxLoginInfoBean wxLoginInfoBean = loginActivity.H;
        if (wxLoginInfoBean != null) {
            wxLoginInfoBean.setUserNickName(string);
            wxLoginInfoBean.setUserAvatar(string2);
            wxLoginInfoBean.setGenderType(i3);
            wxLoginInfoBean.setYear(string3);
        }
        com.example.test.presenter.mine.k kVar = (com.example.test.presenter.mine.k) loginActivity.I0();
        String openId = loginActivity.R0().getOpenId();
        kotlin.jvm.internal.e.e(openId, "getOpenId(...)");
        kVar.k(openId, "5");
    }

    @Override // com.tencent.tauth.IUiListener
    public final void onError(UiError uiError) {
        new StringBuilder("userInfo onError ").append(com.example.baselibrary.utils.b.z(uiError));
        LoginActivity loginActivity = this.f8136a;
        loginActivity.b0();
        loginActivity.w0(R$string.str_login_fail);
    }

    @Override // com.tencent.tauth.IUiListener
    public final void onWarning(int i3) {
        new StringBuilder("userInfo onWarning ").append(com.example.baselibrary.utils.b.z(Integer.valueOf(i3)));
    }
}
