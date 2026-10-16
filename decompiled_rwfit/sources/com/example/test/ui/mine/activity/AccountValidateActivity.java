package com.example.test.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.database.table.User;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.UserInfoBean;
import com.example.test.MainActivity;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.testui.TMainRingActivity;
import com.example.test.ui.testui.TRingDeviceScanActivity;
import com.example.test.ui.view.InputView;
import com.example.test.ui.view.TitleViewMiddle;
import com.example.test.utils.r0;
import com.example.test.utils.s0;
import com.example.test.utils.t0;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.f2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.j1;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import java.util.Arrays;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public final class AccountValidateActivity extends XXBaseActivity<com.example.test.presenter.mine.f, f6.c> implements h7.c, View.OnClickListener {
    public static final /* synthetic */ int I = 0;
    public String E;
    public String F;
    public boolean G;
    public final eh.b H = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.AccountValidateActivity$validateType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = AccountValidateActivity.this.getIntent();
            if (intent != null) {
                return Integer.valueOf(intent.getIntExtra("select_type", 0));
            }
            return null;
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.mine.f(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.c) this.f7247z.getValue()).f12745a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_account_validate, (ViewGroup) null, false);
        int i3 = R$id.accountIv;
        InputView inputView = (InputView) he.a(i3, inflate);
        if (inputView != null) {
            i3 = R$id.btnRegister;
            Button button = (Button) he.a(i3, inflate);
            if (button != null) {
                i3 = R$id.pwAgainIv;
                InputView inputView2 = (InputView) he.a(i3, inflate);
                if (inputView2 != null) {
                    i3 = R$id.pwIv;
                    InputView inputView3 = (InputView) he.a(i3, inflate);
                    if (inputView3 != null) {
                        i3 = R$id.pwNewAgainIv;
                        InputView inputView4 = (InputView) he.a(i3, inflate);
                        if (inputView4 != null) {
                            i3 = R$id.titleView;
                            TitleViewMiddle titleViewMiddle = (TitleViewMiddle) he.a(i3, inflate);
                            if (titleViewMiddle != null) {
                                i3 = R$id.tvHasAccount;
                                TextView textView = (TextView) he.a(i3, inflate);
                                if (textView != null) {
                                    i3 = R$id.tvReadProtocol;
                                    TextView textView2 = (TextView) he.a(i3, inflate);
                                    if (textView2 != null) {
                                        i3 = R$id.verifyCodeIv;
                                        InputView inputView5 = (InputView) he.a(i3, inflate);
                                        if (inputView5 != null) {
                                            return new f6.c((LinearLayout) inflate, inputView, button, inputView2, inputView3, inputView4, titleViewMiddle, textView, textView2, inputView5);
                                        }
                                    }
                                }
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
        String account;
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        User d5 = kVar != null ? kVar.d() : null;
        String str = f2.c().equals("zh-cn") ? "zh" : "en";
        this.E = String.format("https://www.ruiwo168.com/userProtocol_%s.html", Arrays.copyOf(new Object[]{str}, 1));
        this.F = String.format("https://www.ruiwo168.com/privacyPolicy_%s.html", Arrays.copyOf(new Object[]{str}, 1));
        Integer R0 = R0();
        if (R0 != null && R0.intValue() == 1) {
            ((f6.c) this.f7247z.getValue()).f12750g.setTitle(R$string.str_account_bind);
            ((f6.c) this.f7247z.getValue()).f12747c.setText(R$string.str_sure);
            ((f6.c) this.f7247z.getValue()).f12752i.setVisibility(0);
            S0();
            return;
        }
        if (R0 != null && R0.intValue() == 2) {
            ((f6.c) this.f7247z.getValue()).f12750g.setTitle(R$string.str_account_cancel);
            InputView inputView = ((f6.c) this.f7247z.getValue()).f12746b;
            account = d5 != null ? d5.getAccount() : null;
            if (account == null) {
                account = "";
            }
            inputView.setText(account);
            ((f6.c) this.f7247z.getValue()).f12746b.setEditable(false);
            ((f6.c) this.f7247z.getValue()).f12747c.setText(R$string.str_sure);
            return;
        }
        if (R0 != null && R0.intValue() == 3) {
            ((f6.c) this.f7247z.getValue()).f12750g.setTitle(R$string.str_update_pw);
            InputView inputView2 = ((f6.c) this.f7247z.getValue()).f12746b;
            account = d5 != null ? d5.getAccount() : null;
            if (account == null) {
                account = "";
            }
            inputView2.setText(account);
            ((f6.c) this.f7247z.getValue()).f12746b.setEditable(false);
            ((f6.c) this.f7247z.getValue()).f12753j.setVisibility(8);
            ((f6.c) this.f7247z.getValue()).f12749f.setVisibility(0);
            ((f6.c) this.f7247z.getValue()).f12747c.setText(R$string.str_sure);
            ((f6.c) this.f7247z.getValue()).e.setHint(R$string.str_please_input_opw);
            ((f6.c) this.f7247z.getValue()).f12748d.setHint(R$string.str_please_input_npw);
            return;
        }
        if (R0 != null && R0.intValue() == 4) {
            ((f6.c) this.f7247z.getValue()).f12750g.setTitle(R$string.str_forget_pw);
            ((f6.c) this.f7247z.getValue()).f12747c.setText(R$string.str_sure);
        } else if (R0 != null && R0.intValue() == 0) {
            ((f6.c) this.f7247z.getValue()).f12750g.setTitle(R$string.str_register);
            ((f6.c) this.f7247z.getValue()).f12752i.setVisibility(0);
            ((f6.c) this.f7247z.getValue()).f12751h.setVisibility(0);
            S0();
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((f6.c) bVar.getValue()).f12750g.setOnTitleListener(new c(this, 1));
        ((f6.c) bVar.getValue()).f12747c.setOnClickListener(this);
        ((f6.c) bVar.getValue()).f12753j.setOnViewChildListener(new c(this, 2));
        ((f6.c) bVar.getValue()).f12753j.setActionEnable(false);
        ((f6.c) bVar.getValue()).f12746b.setOnInputResultListener(new c(this, 3));
        ((f6.c) bVar.getValue()).f12753j.setOnInputResultListener(new c(this, 4));
        ((f6.c) bVar.getValue()).e.setOnInputResultListener(new c(this, 5));
        ((f6.c) bVar.getValue()).f12748d.setOnInputResultListener(new c(this, 6));
        ((f6.c) bVar.getValue()).f12749f.setOnInputResultListener(new c(this, 7));
    }

    public final Integer R0() {
        return (Integer) this.H.getValue();
    }

    public final void S0() {
        SpannableStringBuilder spannableStringBuilder;
        String str = getString(R$string.str_read_agree) + "《" + getString(R$string.str_user_protocol) + "》、《" + getString(R$string.str_privacy_policy) + "》";
        s0 s0Var = new s0(0);
        s0Var.a(str, getResources().getColor(R$color.colorAccent), new b(this, 0), l0.o("《", getString(R$string.str_user_protocol), "》"), l0.o("《", getString(R$string.str_privacy_policy), "》"));
        eh.b bVar = this.f7247z;
        TextView textView = ((f6.c) bVar.getValue()).f12752i;
        c cVar = new c(this, 0);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) s0Var.f8757b;
        spannableStringBuilder2.setSpan(new t0(this, R$mipmap.ic_checkbox_unselect, 2), 0, 1, 33);
        spannableStringBuilder2.setSpan(new r0(s0Var, this, textView, cVar), 0, 1, 33);
        TextView textView2 = ((f6.c) bVar.getValue()).f12752i;
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(0);
        textView2.setText(spannableStringBuilder2);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getString(R$string.str_has_account));
        String string = getString(R$string.str_login);
        kotlin.jvm.internal.e.e(string, "getString(...)");
        int color = getResources().getColor(R$color.colorAccent);
        oh.a aVar = new oh.a() { // from class: com.example.test.ui.mine.activity.AccountValidateActivity$initProtocol$spannableRegister$1
            {
                super(0);
            }

            @Override // oh.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m59invoke();
                return eh.g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m59invoke() {
                AccountValidateActivity.this.startActivity(new Intent(AccountValidateActivity.this, (Class<?>) LoginActivity.class));
            }
        };
        if (string.length() == 0) {
            spannableStringBuilder = null;
        } else {
            SpannableStringBuilder spannableStringBuilder4 = new SpannableStringBuilder(string);
            spannableStringBuilder4.setSpan(new com.example.test.utils.u(this, color, aVar), 0, string.length(), 33);
            spannableStringBuilder = spannableStringBuilder4;
        }
        spannableStringBuilder3.append((CharSequence) spannableStringBuilder);
        ((f6.c) bVar.getValue()).f12751h.setMovementMethod(LinkMovementMethod.getInstance());
        ((f6.c) bVar.getValue()).f12751h.setText(spannableStringBuilder3);
    }

    public final void T0(int i3, int i10) {
        b0();
        w0.d().getClass();
        int c9 = w0.c(i3);
        if (c9 != 0) {
            w0(c9);
        } else if (i10 == 0) {
            w0(R$string.str_register_fail);
        } else {
            w0(R$string.str_bind_account_fail);
        }
    }

    public final void U0(int i3, Integer num) {
        b0();
        if (i3 == 1020) {
            w0.d().getClass();
            w0(w0.c(i3));
            return;
        }
        Log.d("tong", "----onRegisterResult-------");
        com.example.test.utils.k a3 = y1.a();
        if (a3 == null || a3.c() == null) {
            com.example.test.utils.k a10 = y1.a();
            if (a10 != null) {
                a10.b0();
            }
            Intent intent = new Intent(this, (Class<?>) TRingDeviceScanActivity.class);
            intent.putExtra("login_platform", 0);
            intent.putExtra("is_need_info", true);
            startActivity(intent);
        } else {
            com.example.test.utils.k a11 = y1.a();
            Integer valueOf = a11 != null ? Integer.valueOf(a11.x()) : null;
            if (num == null || num.intValue() != 1) {
                num = valueOf;
            } else {
                com.example.test.utils.k a12 = y1.a();
                if (a12 != null) {
                    a12.Y(num.intValue());
                }
            }
            Log.d("tong", "current device is = " + num);
            if (num != null && num.intValue() == 1) {
                com.example.test.utils.k a13 = y1.a();
                if (a13 != null) {
                    a13.c0();
                }
                Intent intent2 = new Intent(this, (Class<?>) TMainRingActivity.class);
                intent2.putExtra("login_platform", 0);
                intent2.putExtra("is_need_info", true);
                startActivity(intent2);
            } else {
                com.example.test.utils.k a14 = y1.a();
                if (a14 != null) {
                    a14.b0();
                }
                Intent intent3 = new Intent(this, (Class<?>) MainActivity.class);
                intent3.putExtra("login_platform", 0);
                intent3.putExtra("is_need_info", true);
                startActivity(intent3);
            }
        }
        finish();
    }

    public final void V0(int i3) {
        b0();
        if (i3 == 1010) {
            w0(R$string.str_account_not_exit);
            return;
        }
        w0(R$string.str_reset_pw_success);
        ((com.example.test.presenter.mine.f) I0()).k();
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
        w0.d().getClass();
        w0.i();
        w0.d().getClass();
        w0.i();
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        boolean z5;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.btnRegister;
        if (valueOf != null && valueOf.intValue() == i3) {
            ((InputMethodManager) this.B.getValue()).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
            Integer R0 = R0();
            eh.b bVar = this.f7247z;
            if (R0 != null && R0.intValue() == 1) {
                w0.d().getClass();
                if (w0.g()) {
                    com.example.test.presenter.mine.f fVar = (com.example.test.presenter.mine.f) I0();
                    String account = ((f6.c) bVar.getValue()).f12746b.getText();
                    String pw = ((f6.c) bVar.getValue()).e.getText();
                    String pwAgain = ((f6.c) bVar.getValue()).f12748d.getText();
                    String verifyCode = ((f6.c) bVar.getValue()).f12753j.getText();
                    fVar.getClass();
                    kotlin.jvm.internal.e.f(account, "account");
                    kotlin.jvm.internal.e.f(pw, "pw");
                    kotlin.jvm.internal.e.f(pwAgain, "pwAgain");
                    kotlin.jvm.internal.e.f(verifyCode, "verifyCode");
                    z5 = Pattern.compile("^[0-9]*$").matcher(account).matches() || Pattern.compile("^.*(@).*$").matcher(account).matches();
                    Object obj = fVar.f7255a;
                    if (!z5) {
                        ((AccountValidateActivity) ((h7.c) obj)).w0(R$string.str_please_input_legal_account);
                        return;
                    }
                    if (verifyCode.length() < 4) {
                        ((AccountValidateActivity) ((h7.c) obj)).w0(R$string.str_please_input_legal_verify);
                        return;
                    }
                    if (!Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$").matcher(pw).matches()) {
                        ((AccountValidateActivity) ((h7.c) obj)).w0(R$string.str_please_input_legal_pw);
                        return;
                    }
                    if (!pw.equals(pwAgain)) {
                        ((AccountValidateActivity) ((h7.c) obj)).w0(R$string.str_pw_diff);
                        return;
                    }
                    Object obj2 = (h7.c) obj;
                    ((XXBaseActivity) obj2).V();
                    rg.l d5 = c6.d.f3392c.d(account, pw, verifyCode);
                    AccountValidateActivity accountValidateActivity = (AccountValidateActivity) obj2;
                    accountValidateActivity.getClass();
                    d5.subscribe(new com.example.test.presenter.mine.d(fVar, accountValidateActivity, w0.d(), 0));
                    return;
                }
                com.example.test.presenter.mine.f fVar2 = (com.example.test.presenter.mine.f) I0();
                String account2 = ((f6.c) bVar.getValue()).f12746b.getText();
                String pw2 = ((f6.c) bVar.getValue()).e.getText();
                String pwAgain2 = ((f6.c) bVar.getValue()).f12748d.getText();
                String verifyCode2 = ((f6.c) bVar.getValue()).f12753j.getText();
                fVar2.getClass();
                kotlin.jvm.internal.e.f(account2, "account");
                kotlin.jvm.internal.e.f(pw2, "pw");
                kotlin.jvm.internal.e.f(pwAgain2, "pwAgain");
                kotlin.jvm.internal.e.f(verifyCode2, "verifyCode");
                z5 = Pattern.compile("^[0-9]*$").matcher(account2).matches() || Pattern.compile("^.*(@).*$").matcher(account2).matches();
                Object obj3 = fVar2.f7255a;
                if (!z5) {
                    ((AccountValidateActivity) ((h7.c) obj3)).w0(R$string.str_please_input_legal_account);
                    return;
                }
                if (verifyCode2.length() < 4) {
                    ((AccountValidateActivity) ((h7.c) obj3)).w0(R$string.str_please_input_legal_verify);
                    return;
                }
                if (!Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$").matcher(pw2).matches()) {
                    ((AccountValidateActivity) ((h7.c) obj3)).w0(R$string.str_please_input_legal_pw);
                    return;
                }
                if (!pw2.equals(pwAgain2)) {
                    ((AccountValidateActivity) ((h7.c) obj3)).w0(R$string.str_pw_diff);
                    return;
                }
                Object obj4 = (h7.c) obj3;
                ((XXBaseActivity) obj4).V();
                c6.d dVar = c6.d.f3392c;
                dVar.getClass();
                rg.l<HttpModel<UserInfoBean>> bindAccount = ((UserApi) dVar.f113a).bindAccount(account2, pw2, verifyCode2);
                kotlin.jvm.internal.e.e(bindAccount, "bindAccount(...)");
                rg.l w8 = com.example.baselibrary.utils.b.w(bindAccount);
                AccountValidateActivity accountValidateActivity2 = (AccountValidateActivity) obj4;
                accountValidateActivity2.getClass();
                w8.subscribe(new com.example.test.presenter.mine.d(fVar2, accountValidateActivity2, w0.d(), 1));
                return;
            }
            if (R0 != null && R0.intValue() == 2) {
                com.example.test.presenter.mine.f fVar3 = (com.example.test.presenter.mine.f) I0();
                String password = ((f6.c) bVar.getValue()).f12748d.getText();
                String verifyCode3 = ((f6.c) bVar.getValue()).f12753j.getText();
                fVar3.getClass();
                kotlin.jvm.internal.e.f(password, "password");
                kotlin.jvm.internal.e.f(verifyCode3, "verifyCode");
                c6.d dVar2 = c6.d.f3392c;
                dVar2.getClass();
                rg.l<HttpModel<String>> delAccount = ((UserApi) dVar2.f113a).delAccount(password, verifyCode3);
                kotlin.jvm.internal.e.e(delAccount, "delAccount(...)");
                rg.l w9 = com.example.baselibrary.utils.b.w(delAccount);
                AccountValidateActivity accountValidateActivity3 = (AccountValidateActivity) ((h7.c) fVar3.f7255a);
                accountValidateActivity3.getClass();
                w9.subscribe(new com.example.test.presenter.mine.d(fVar3, accountValidateActivity3, w0.d(), 2));
                return;
            }
            if (R0 != null && R0.intValue() == 3) {
                com.example.test.presenter.mine.f fVar4 = (com.example.test.presenter.mine.f) I0();
                String oldPw = ((f6.c) bVar.getValue()).e.getText();
                String newPw = ((f6.c) bVar.getValue()).f12748d.getText();
                String newAgain = ((f6.c) bVar.getValue()).f12749f.getText();
                fVar4.getClass();
                kotlin.jvm.internal.e.f(oldPw, "oldPw");
                kotlin.jvm.internal.e.f(newPw, "newPw");
                kotlin.jvm.internal.e.f(newAgain, "newAgain");
                boolean matches = Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$").matcher(newPw).matches();
                Object obj5 = fVar4.f7255a;
                if (!matches) {
                    ((AccountValidateActivity) ((h7.c) obj5)).w0(R$string.str_please_input_legal_pw);
                    return;
                }
                if (!newPw.equals(newAgain)) {
                    ((AccountValidateActivity) ((h7.c) obj5)).w0(R$string.str_pw_diff);
                    return;
                }
                Object obj6 = (h7.c) obj5;
                ((XXBaseActivity) obj6).V();
                c6.d dVar3 = c6.d.f3392c;
                dVar3.getClass();
                rg.l<HttpModel<String>> updatePassword = ((UserApi) dVar3.f113a).updatePassword(oldPw, newPw);
                kotlin.jvm.internal.e.e(updatePassword, "updatePassword(...)");
                rg.l w10 = com.example.baselibrary.utils.b.w(updatePassword);
                AccountValidateActivity accountValidateActivity4 = (AccountValidateActivity) obj6;
                accountValidateActivity4.getClass();
                w10.subscribe(new com.example.test.presenter.mine.d(fVar4, accountValidateActivity4, w0.d(), 6));
                return;
            }
            if (R0 != null && R0.intValue() == 4) {
                com.example.test.presenter.mine.f fVar5 = (com.example.test.presenter.mine.f) I0();
                String account3 = ((f6.c) bVar.getValue()).f12746b.getText();
                String password2 = ((f6.c) bVar.getValue()).e.getText();
                String pwAgain3 = ((f6.c) bVar.getValue()).f12748d.getText();
                String verifyCode4 = ((f6.c) bVar.getValue()).f12753j.getText();
                fVar5.getClass();
                kotlin.jvm.internal.e.f(account3, "account");
                kotlin.jvm.internal.e.f(password2, "password");
                kotlin.jvm.internal.e.f(pwAgain3, "pwAgain");
                kotlin.jvm.internal.e.f(verifyCode4, "verifyCode");
                z5 = Pattern.compile("^[0-9]*$").matcher(account3).matches() || Pattern.compile("^.*(@).*$").matcher(account3).matches();
                Object obj7 = fVar5.f7255a;
                if (!z5) {
                    ((AccountValidateActivity) ((h7.c) obj7)).w0(R$string.str_please_input_legal_account);
                    return;
                }
                if (verifyCode4.length() < 4) {
                    ((AccountValidateActivity) ((h7.c) obj7)).w0(R$string.str_please_input_legal_verify);
                    return;
                }
                if (!Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$").matcher(password2).matches()) {
                    ((AccountValidateActivity) ((h7.c) obj7)).w0(R$string.str_please_input_legal_pw);
                    return;
                }
                if (!password2.equals(pwAgain3)) {
                    ((AccountValidateActivity) ((h7.c) obj7)).w0(R$string.str_pw_diff);
                    return;
                }
                Object obj8 = (h7.c) obj7;
                ((XXBaseActivity) obj8).V();
                c6.d dVar4 = c6.d.f3392c;
                dVar4.getClass();
                rg.l<HttpModel<String>> resetPassword = ((UserApi) dVar4.f113a).resetPassword(account3, password2, verifyCode4);
                kotlin.jvm.internal.e.e(resetPassword, "resetPassword(...)");
                rg.l w11 = com.example.baselibrary.utils.b.w(resetPassword);
                AccountValidateActivity accountValidateActivity5 = (AccountValidateActivity) obj8;
                accountValidateActivity5.getClass();
                w11.subscribe(new com.example.test.presenter.mine.d(fVar5, accountValidateActivity5, w0.d(), 4));
                return;
            }
            if (R0 != null && R0.intValue() == 0) {
                if (!this.G) {
                    w0(R$string.str_protocol_tips);
                    return;
                }
                com.example.test.presenter.mine.f fVar6 = (com.example.test.presenter.mine.f) I0();
                String account4 = ((f6.c) bVar.getValue()).f12746b.getText();
                String pw3 = ((f6.c) bVar.getValue()).e.getText();
                String pwAgain4 = ((f6.c) bVar.getValue()).f12748d.getText();
                String verifyCode5 = ((f6.c) bVar.getValue()).f12753j.getText();
                fVar6.getClass();
                kotlin.jvm.internal.e.f(account4, "account");
                kotlin.jvm.internal.e.f(pw3, "pw");
                kotlin.jvm.internal.e.f(pwAgain4, "pwAgain");
                kotlin.jvm.internal.e.f(verifyCode5, "verifyCode");
                z5 = Pattern.compile("^[0-9]*$").matcher(account4).matches() || Pattern.compile("^.*(@).*$").matcher(account4).matches();
                Object obj9 = fVar6.f7255a;
                if (!z5) {
                    ((AccountValidateActivity) ((h7.c) obj9)).w0(R$string.str_please_input_legal_account);
                    return;
                }
                if (verifyCode5.length() < 4) {
                    ((AccountValidateActivity) ((h7.c) obj9)).w0(R$string.str_please_input_legal_verify);
                    return;
                }
                if (!Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$").matcher(pw3).matches()) {
                    ((AccountValidateActivity) ((h7.c) obj9)).w0(R$string.str_please_input_legal_pw);
                    return;
                }
                if (!pw3.equals(pwAgain4)) {
                    ((AccountValidateActivity) ((h7.c) obj9)).w0(R$string.str_pw_diff);
                    return;
                }
                Object obj10 = (h7.c) obj9;
                ((XXBaseActivity) obj10).V();
                rg.l d8 = c6.d.f3392c.d(account4, pw3, verifyCode5);
                AccountValidateActivity accountValidateActivity6 = (AccountValidateActivity) obj10;
                accountValidateActivity6.getClass();
                d8.subscribe(new com.example.test.presenter.mine.d(fVar6, accountValidateActivity6, w0.d(), 3));
            }
        }
    }
}
