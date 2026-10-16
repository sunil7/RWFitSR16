package com.example.test.ui.mine.activity;

import android.os.Build;
import android.widget.Button;
import com.example.test.utils.v0;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import f6.p0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class j implements v0, a7.e, a7.c, t6.b {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8133a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ LoginActivity f8134b;

    public /* synthetic */ j(LoginActivity loginActivity, int i3) {
        this.f8133a = i3;
        this.f8134b = loginActivity;
    }

    @Override // a7.e
    public void B() {
    }

    @Override // com.example.test.utils.v0
    public void a() {
        this.f8134b.K = true;
    }

    @Override // com.example.test.utils.v0
    public void b() {
        this.f8134b.K = false;
    }

    @Override // a7.c
    public void c(String str, boolean z5) {
        boolean z6 = false;
        LoginActivity loginActivity = this.f8134b;
        switch (this.f8133a) {
            case 2:
                int i3 = LoginActivity.P;
                Button button = ((p0) loginActivity.f7247z.getValue()).f13214d;
                if (z5 && ((p0) loginActivity.f7247z.getValue()).e.getText().length() > 0) {
                    z6 = true;
                }
                button.setEnabled(z6);
                break;
            default:
                int i10 = LoginActivity.P;
                Button button2 = ((p0) loginActivity.f7247z.getValue()).f13214d;
                if (z5 && ((p0) loginActivity.f7247z.getValue()).f13212b.getText().length() > 0) {
                    z6 = true;
                }
                button2.setEnabled(z6);
                break;
        }
    }

    @Override // t6.b
    public void onCancel() {
    }

    @Override // t6.b
    public void s() {
        LoginActivity loginActivity = this.f8134b;
        int i3 = loginActivity.M;
        if (i3 == 1) {
            com.example.baselibrary.utils.b.z(loginActivity.L);
            v2.h hVar = new v2.h(loginActivity);
            hVar.n(loginActivity.L);
            hVar.p(new i(loginActivity, 0));
            return;
        }
        if (i3 == 2) {
            if (Build.VERSION.SDK_INT >= 30) {
                loginActivity.U0();
                return;
            }
            v2.h hVar2 = new v2.h(loginActivity);
            hVar2.o("android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.READ_EXTERNAL_STORAGE");
            hVar2.p(new i(loginActivity, 1));
            return;
        }
        if (i3 != 3) {
            return;
        }
        if (Build.VERSION.SDK_INT >= 30) {
            loginActivity.V();
            ((IWXAPI) loginActivity.F.getValue()).registerApp("wx1273e8f71f60b697");
            loginActivity.V0();
        } else {
            v2.h hVar3 = new v2.h(loginActivity);
            ArrayList arrayList = new ArrayList();
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            hVar3.n(arrayList);
            hVar3.p(new i(loginActivity, 2));
        }
    }

    @Override // a7.e
    public void u0() {
        this.f8134b.onBackPressed();
    }
}
