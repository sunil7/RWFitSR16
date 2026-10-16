package com.example.test.ui.mine.activity;

import com.example.test.R$string;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.UiError;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class k implements IUiListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LoginActivity f8135a;

    public k(LoginActivity loginActivity) {
        this.f8135a = loginActivity;
    }

    @Override // com.tencent.tauth.IUiListener
    public final void onCancel() {
        LoginActivity loginActivity = this.f8135a;
        loginActivity.b0();
        loginActivity.w0(R$string.str_login_fail);
    }

    @Override // com.tencent.tauth.IUiListener
    public final void onComplete(Object obj) {
        new StringBuilder("onComplete ").append(com.example.baselibrary.utils.b.z(obj));
        LoginActivity loginActivity = this.f8135a;
        if (obj == null) {
            loginActivity.b0();
            loginActivity.w0(R$string.str_login_fail);
            return;
        }
        JSONObject jSONObject = (JSONObject) obj;
        if (jSONObject.length() == 0) {
            loginActivity.b0();
            loginActivity.w0(R$string.str_login_fail);
            return;
        }
        try {
            String string = jSONObject.getString(Constants.PARAM_ACCESS_TOKEN);
            String string2 = jSONObject.getString(Constants.PARAM_EXPIRES_IN);
            String string3 = jSONObject.getString("openid");
            if (string != null && string.length() != 0 && string2 != null && string2.length() != 0 && string3 != null && string3.length() != 0) {
                int i3 = LoginActivity.P;
                loginActivity.R0().setOpenId(string3);
                loginActivity.R0().setAccessToken(string, string2);
                ((com.example.baselibrary.utils.e) loginActivity.G.getValue()).sendEmptyMessage(0);
            }
        } catch (Exception e) {
            loginActivity.b0();
            loginActivity.w0(R$string.str_login_fail);
            new StringBuilder("Exception ").append(e.getMessage());
        }
    }

    @Override // com.tencent.tauth.IUiListener
    public final void onError(UiError uiError) {
        LoginActivity loginActivity = this.f8135a;
        loginActivity.b0();
        new StringBuilder("onError ").append(com.example.baselibrary.utils.b.z(uiError));
        loginActivity.w0(R$string.str_login_fail);
    }

    @Override // com.tencent.tauth.IUiListener
    public final void onWarning(int i3) {
        new StringBuilder("onWarning ").append(i3);
    }
}
