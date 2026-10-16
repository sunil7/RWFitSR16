package com.example.test.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.database.table.User;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.XXApplication;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.main.activity.SplashSelectActivity;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import com.tencent.tauth.Tencent;

/* loaded from: classes.dex */
public final class AccountSafeActivity extends XXBaseActivity<com.example.test.presenter.mine.b, f6.b> implements h7.b, View.OnClickListener, o5.a {
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.AccountSafeActivity$loadingDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.h invoke() {
            com.example.test.ui.dialog.h hVar = new com.example.test.ui.dialog.h(AccountSafeActivity.this);
            hVar.c(8);
            return hVar;
        }
    });

    public AccountSafeActivity() {
        kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.AccountSafeActivity$weakHandler$2
            {
                super(0);
            }

            @Override // oh.a
            public final com.example.baselibrary.utils.e invoke() {
                return new com.example.baselibrary.utils.e(AccountSafeActivity.this);
            }
        });
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.mine.b(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.b) this.f7247z.getValue()).f12703a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_account_safe, (ViewGroup) null, false);
        int i3 = R$id.accountBindAv;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.accountCancelAv;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.accountTv;
                TextView textView = (TextView) he.a(i3, inflate);
                if (textView != null) {
                    i3 = R$id.loginOutBtn;
                    Button button = (Button) he.a(i3, inflate);
                    if (button != null) {
                        i3 = R$id.titleView;
                        TitleView titleView = (TitleView) he.a(i3, inflate);
                        if (titleView != null) {
                            i3 = R$id.updatePwAv;
                            ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                            if (actionItemView3 != null) {
                                return new f6.b((LinearLayout) inflate, actionItemView, actionItemView2, textView, button, titleView, actionItemView3);
                            }
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((f6.b) bVar.getValue()).f12707f.setOnTitleListener(new o(this, 2));
        ((f6.b) bVar.getValue()).e.setOnClickListener(this);
        ((f6.b) bVar.getValue()).f12704b.setOnClickListener(this);
        ((f6.b) bVar.getValue()).f12705c.setOnClickListener(this);
        ((f6.b) bVar.getValue()).f12708g.setOnClickListener(this);
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.loginOutBtn;
        if (valueOf == null || valueOf.intValue() != i3) {
            int i10 = R$id.accountBindAv;
            if (valueOf != null && valueOf.intValue() == i10) {
                Intent intent = new Intent(this, (Class<?>) AccountValidateActivity.class);
                intent.putExtra("select_type", 1);
                startActivity(intent);
                return;
            }
            int i11 = R$id.accountCancelAv;
            if (valueOf != null && valueOf.intValue() == i11) {
                Intent intent2 = new Intent(this, (Class<?>) AccountValidateActivity.class);
                intent2.putExtra("select_type", 2);
                startActivity(intent2);
                return;
            }
            int i12 = R$id.updatePwAv;
            if (valueOf != null && valueOf.intValue() == i12) {
                Intent intent3 = new Intent(this, (Class<?>) AccountValidateActivity.class);
                intent3.putExtra("select_type", 3);
                startActivity(intent3);
                return;
            }
            return;
        }
        Log.d("tong", "click logout button");
        com.example.test.presenter.mine.b bVar = (com.example.test.presenter.mine.b) I0();
        ((XXBaseActivity) ((h7.b) bVar.f7255a)).b0();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        if (kVar != null) {
            kVar.f0();
        }
        com.example.test.service.e.h().q();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar2 = com.example.test.utils.k.f8731b;
        User d5 = kVar2 != null ? kVar2.d() : null;
        if (d5 != null && d5.getPlatform() != 2) {
            rg.l<HttpModel<String>> logout = ((UserApi) c6.d.f3392c.f113a).logout("");
            kotlin.jvm.internal.e.e(logout, "logout(...)");
            rg.l w8 = com.example.baselibrary.utils.b.w(logout);
            AccountSafeActivity accountSafeActivity = (AccountSafeActivity) ((h7.b) bVar.f7255a);
            accountSafeActivity.getClass();
            w8.subscribe(new com.example.test.presenter.device.w(accountSafeActivity, w0.d(), 1));
        }
        com.example.test.service.e.h().e();
        com.example.test.service.e.h().l();
        XXApplication xXApplication = XXApplication.f7400h;
        j1.a().a();
        com.example.test.utils.k a3 = y1.a();
        if (a3 != null) {
            a3.L();
        }
        com.example.test.utils.k a10 = y1.a();
        if (a10 != null) {
            a10.Y(0);
        }
        com.example.test.utils.k a11 = y1.a();
        if (a11 != null) {
            a11.b0();
        }
        Tencent.createInstance("102022650", this, "com.rw.revivalfit.fileprovider").logout(this);
        w0.d().getClass();
        w0.i();
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        ((com.example.test.ui.dialog.h) this.E.getValue()).dismiss();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onResume() {
        super.onResume();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d5 = kVar != null ? kVar.d() : null;
        if (d5 != null) {
            ((f6.b) this.f7247z.getValue()).f12706d.setText(d5.getAccount());
            if (d5.getPlatform() == 0) {
                ((f6.b) this.f7247z.getValue()).f12704b.setVisibility(8);
                return;
            }
            ((f6.b) this.f7247z.getValue()).f12704b.setVisibility(0);
            ((f6.b) this.f7247z.getValue()).f12708g.setVisibility(8);
            ((f6.b) this.f7247z.getValue()).f12705c.setVisibility(8);
        }
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        ((com.example.test.ui.dialog.h) this.E.getValue()).dismiss();
        startActivity(new Intent(this, (Class<?>) SplashSelectActivity.class));
        finish();
    }
}
