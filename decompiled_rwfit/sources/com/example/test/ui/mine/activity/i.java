package com.example.test.ui.mine.activity;

import android.content.Intent;
import com.example.test.R$string;
import com.example.test.utils.u0;
import com.tencent.mm.opensdk.openapi.IWXAPI;

/* loaded from: classes.dex */
public final /* synthetic */ class i implements nd.b, u0 {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8131a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoginActivity f8132b;

    public /* synthetic */ i(LoginActivity loginActivity, int i3) {
        this.f8131a = i3;
        this.f8132b = loginActivity;
    }

    @Override // com.example.test.utils.u0
    public void a(int i3) {
        int i10 = LoginActivity.P;
        LoginActivity this$0 = this.f8132b;
        kotlin.jvm.internal.e.f(this$0, "this$0");
        if (i3 == 0) {
            String string = this$0.getString(R$string.str_user_protocol);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            String str = this$0.I;
            if (str == null) {
                kotlin.jvm.internal.e.m("userPro");
                throw null;
            }
            Intent intent = new Intent(this$0, (Class<?>) WebContentActivity.class);
            intent.putExtra("title", string);
            intent.putExtra("url", str);
            this$0.startActivity(intent);
            return;
        }
        if (i3 != 1) {
            return;
        }
        String string2 = this$0.getString(R$string.str_privacy_policy);
        kotlin.jvm.internal.e.e(string2, "getString(...)");
        String str2 = this$0.J;
        if (str2 == null) {
            kotlin.jvm.internal.e.m("priPro");
            throw null;
        }
        Intent intent2 = new Intent(this$0, (Class<?>) WebContentActivity.class);
        intent2.putExtra("title", string2);
        intent2.putExtra("url", str2);
        this$0.startActivity(intent2);
    }

    @Override // nd.b
    public void h(boolean z5) {
        LoginActivity this$0 = this.f8132b;
        switch (this.f8131a) {
            case 0:
                int i3 = LoginActivity.P;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (z5) {
                    this$0.U0();
                    break;
                }
                break;
            case 1:
                int i10 = LoginActivity.P;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (z5) {
                    this$0.U0();
                    break;
                }
                break;
            default:
                int i11 = LoginActivity.P;
                kotlin.jvm.internal.e.f(this$0, "this$0");
                if (z5) {
                    this$0.V();
                    ((IWXAPI) this$0.F.getValue()).registerApp("wx1273e8f71f60b697");
                    this$0.V0();
                    break;
                }
                break;
        }
    }
}
