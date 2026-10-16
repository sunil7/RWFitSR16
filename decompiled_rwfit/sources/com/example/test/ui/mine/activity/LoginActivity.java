package com.example.test.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Message;
import android.text.SpannableStringBuilder;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.network.api.UserApi;
import com.example.network.api.WxAuthApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.LoginResultBean;
import com.example.network.bean.WxAuthInfoBean;
import com.example.test.MainActivity;
import com.example.test.R$color;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.mine.model.WxLoginInfoBean;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.testui.TMainRingActivity;
import com.example.test.ui.testui.TRingDeviceScanActivity;
import com.example.test.ui.view.InputView;
import com.example.test.ui.view.TitleViewMiddle;
import com.example.test.utils.r0;
import com.example.test.utils.s0;
import com.example.test.utils.t0;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.b2;
import com.google.android.gms.internal.mlkit_vision_barcode.f2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.y1;
import com.tencent.connect.UserInfo;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.tencent.tauth.Tencent;
import f6.p0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Pattern;
import org.greenrobot.eventbus.ThreadMode;

/* loaded from: classes.dex */
public final class LoginActivity extends XXBaseActivity<com.example.test.presenter.mine.k, p0> implements h7.f, View.OnClickListener, o5.a {
    public static final /* synthetic */ int P = 0;
    public WxLoginInfoBean H;
    public String I;
    public String J;
    public boolean K;
    public int M;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.LoginActivity$tencent$2
        {
            super(0);
        }

        @Override // oh.a
        public final Tencent invoke() {
            return Tencent.createInstance("102022650", LoginActivity.this, "com.rw.revivalfit.fileprovider");
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.LoginActivity$wxApi$2
        {
            super(0);
        }

        @Override // oh.a
        public final IWXAPI invoke() {
            return WXAPIFactory.createWXAPI(LoginActivity.this, "wx1273e8f71f60b697", false);
        }
    });
    public final eh.b G = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.LoginActivity$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.baselibrary.utils.e invoke() {
            return new com.example.baselibrary.utils.e(LoginActivity.this);
        }
    });
    public ArrayList L = new ArrayList();
    public final eh.b N = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.LoginActivity$permissionTipDialog$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.test.ui.dialog.i invoke() {
            com.example.test.ui.dialog.i iVar = new com.example.test.ui.dialog.i(LoginActivity.this, 1);
            iVar.setOnDialogListener(new j(LoginActivity.this, 4));
            iVar.setCancelable(false);
            return iVar;
        }
    });
    public final eh.b O = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.LoginActivity$qqListener$2
        {
            super(0);
        }

        @Override // oh.a
        public final k invoke() {
            return new k(LoginActivity.this);
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.mine.k(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((p0) this.f7247z.getValue()).f13211a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_login, (ViewGroup) null, false);
        int i3 = R$id.accountInput;
        InputView inputView = (InputView) he.a(i3, inflate);
        if (inputView != null) {
            i3 = R$id.appLogo;
            ImageView imageView = (ImageView) he.a(i3, inflate);
            if (imageView != null) {
                i3 = R$id.btnLogin;
                Button button = (Button) he.a(i3, inflate);
                if (button != null) {
                    i3 = R$id.pwInput;
                    InputView inputView2 = (InputView) he.a(i3, inflate);
                    if (inputView2 != null) {
                        i3 = R$id.qqIv;
                        ImageView imageView2 = (ImageView) he.a(i3, inflate);
                        if (imageView2 != null) {
                            i3 = R$id.titleView;
                            TitleViewMiddle titleViewMiddle = (TitleViewMiddle) he.a(i3, inflate);
                            if (titleViewMiddle != null) {
                                i3 = R$id.tvForgetPw;
                                TextView textView = (TextView) he.a(i3, inflate);
                                if (textView != null) {
                                    i3 = R$id.tvHasNotAccount;
                                    TextView textView2 = (TextView) he.a(i3, inflate);
                                    if (textView2 != null) {
                                        i3 = R$id.tvReadProtocol;
                                        TextView textView3 = (TextView) he.a(i3, inflate);
                                        if (textView3 != null) {
                                            i3 = R$id.wxIv;
                                            ImageView imageView3 = (ImageView) he.a(i3, inflate);
                                            if (imageView3 != null) {
                                                return new p0((LinearLayout) inflate, inputView, imageView, button, inputView2, imageView2, titleViewMiddle, textView, textView2, textView3, imageView3);
                                            }
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
        SpannableStringBuilder spannableStringBuilder;
        String str = f2.c().equals("zh-cn") ? "zh" : "en";
        this.I = String.format("https://www.ruiwo168.com/userProtocol_%s.html", Arrays.copyOf(new Object[]{str}, 1));
        this.J = String.format("https://www.ruiwo168.com/privacyPolicy_%s.html", Arrays.copyOf(new Object[]{str}, 1));
        String str2 = getString(R$string.str_read_agree) + "《" + getString(R$string.str_user_protocol) + "》、《" + getString(R$string.str_privacy_policy) + "》";
        s0 s0Var = new s0(0);
        s0Var.a(str2, getResources().getColor(R$color.colorAccent), new i(this, 3), l0.o("《", getString(R$string.str_user_protocol), "》"), l0.o("《", getString(R$string.str_privacy_policy), "》"));
        eh.b bVar = this.f7247z;
        TextView textView = ((p0) bVar.getValue()).f13219j;
        j jVar = new j(this, 0);
        SpannableStringBuilder spannableStringBuilder2 = (SpannableStringBuilder) s0Var.f8757b;
        spannableStringBuilder2.setSpan(new t0(this, R$mipmap.ic_checkbox_unselect, 2), 0, 1, 33);
        spannableStringBuilder2.setSpan(new r0(s0Var, this, textView, jVar), 0, 1, 33);
        TextView textView2 = ((p0) bVar.getValue()).f13219j;
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        textView2.setHighlightColor(0);
        textView2.setText(spannableStringBuilder2);
        SpannableStringBuilder spannableStringBuilder3 = new SpannableStringBuilder(getString(R$string.str_has_not_account));
        String string = getString(R$string.str_register);
        kotlin.jvm.internal.e.e(string, "getString(...)");
        int color = getResources().getColor(R$color.colorAccent);
        oh.a aVar = new oh.a() { // from class: com.example.test.ui.mine.activity.LoginActivity$initProtocol$spannableRegister$1
            {
                super(0);
            }

            @Override // oh.a
            public /* bridge */ /* synthetic */ Object invoke() {
                m60invoke();
                return eh.g.f12633a;
            }

            /* renamed from: invoke, reason: collision with other method in class */
            public final void m60invoke() {
                int i3 = AccountValidateActivity.I;
                LoginActivity context = LoginActivity.this;
                kotlin.jvm.internal.e.f(context, "context");
                Intent intent = new Intent(context, (Class<?>) AccountValidateActivity.class);
                intent.putExtra("select_type", 0);
                context.startActivity(intent);
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
        ((p0) bVar.getValue()).f13218i.setMovementMethod(LinkMovementMethod.getInstance());
        ((p0) bVar.getValue()).f13218i.setText(spannableStringBuilder3);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        com.example.baselibrary.utils.d.f7269b = this;
        com.example.baselibrary.utils.d.f7271d = Toast.makeText(this, "", 0);
        b2.a(this);
        eh.b bVar = this.f7247z;
        ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(this).m(Integer.valueOf(R$mipmap.ic_launcher)).o(true)).d(z3.h.f20239b)).i(R$drawable.bg_dial_item)).a(p4.e.t(new g4.v(20))).e(R$drawable.bg_dial_item)).x(((p0) bVar.getValue()).f13213c);
        ((p0) bVar.getValue()).f13216g.setOnTitleListener(new j(this, 1));
        ((p0) bVar.getValue()).f13214d.setOnClickListener(this);
        ((p0) bVar.getValue()).f13217h.setOnClickListener(this);
        ((p0) bVar.getValue()).f13220k.setOnClickListener(this);
        ((p0) bVar.getValue()).f13215f.setOnClickListener(this);
        ((p0) bVar.getValue()).f13212b.setOnInputResultListener(new j(this, 2));
        ((p0) bVar.getValue()).e.setOnInputResultListener(new j(this, 3));
    }

    public final Tencent R0() {
        return (Tencent) this.E.getValue();
    }

    public final void S0(int i3) {
        com.example.test.utils.k a3 = y1.a();
        if (a3 == null || a3.c() == null) {
            com.example.test.utils.k a10 = y1.a();
            if (a10 != null) {
                a10.b0();
            }
            startActivity(new Intent(this, (Class<?>) TRingDeviceScanActivity.class));
            return;
        }
        com.example.test.utils.k a11 = y1.a();
        Integer valueOf = a11 != null ? Integer.valueOf(a11.x()) : null;
        Log.d("tong", "current device is = " + valueOf);
        if (valueOf != null && valueOf.intValue() == 1) {
            com.example.test.utils.k a12 = y1.a();
            if (a12 != null) {
                a12.c0();
            }
            Intent intent = new Intent(this, (Class<?>) TMainRingActivity.class);
            intent.putExtra("login_platform", i3);
            intent.putExtra("is_need_info", true);
            startActivity(intent);
            return;
        }
        com.example.test.utils.k a13 = y1.a();
        if (a13 != null) {
            a13.b0();
        }
        Intent intent2 = new Intent(this, (Class<?>) MainActivity.class);
        intent2.putExtra("login_platform", i3);
        intent2.putExtra("is_need_info", true);
        startActivity(intent2);
    }

    public final void T0(int i3) {
        b0();
        w0.d().getClass();
        int c9 = w0.c(i3);
        if (c9 != 0) {
            w0(c9);
        } else {
            w0(R$string.str_login_fail);
        }
    }

    public final void U0() {
        Tencent.setIsPermissionGranted(true);
        R0().logout(this);
        R0().isSessionValid();
        if (R0().isSessionValid()) {
            return;
        }
        V();
        R0().login(this, "all", (k) this.O.getValue());
    }

    public final void V0() {
        SendAuth.Req req = new SendAuth.Req();
        req.scope = "snsapi_userinfo,snsapi_friend,snsapi_message,snsapi_contact";
        req.state = "none";
        ((IWXAPI) this.F.getValue()).sendReq(req);
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onActivityResult(int i3, int i10, Intent intent) {
        if (i3 == 11101) {
            Tencent.onActivityResultData(i3, i10, intent, (k) this.O.getValue());
        }
        super.onActivityResult(i3, i10, intent);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.btnLogin;
        boolean z5 = true;
        if (valueOf != null && valueOf.intValue() == i3) {
            ((InputMethodManager) this.B.getValue()).hideSoftInputFromWindow(getWindow().getDecorView().getWindowToken(), 0);
            if (!this.K) {
                w0(R$string.str_protocol_tips);
                return;
            }
            com.example.test.presenter.mine.k kVar = (com.example.test.presenter.mine.k) I0();
            eh.b bVar = this.f7247z;
            String account = ((p0) bVar.getValue()).f13212b.getText();
            String pw = ((p0) bVar.getValue()).e.getText();
            kVar.getClass();
            kotlin.jvm.internal.e.f(account, "account");
            kotlin.jvm.internal.e.f(pw, "pw");
            Pattern compile = Pattern.compile("^[0-9]*$");
            Pattern compile2 = Pattern.compile("^.*(@).*$");
            if (!compile.matcher(account).matches() && !compile2.matcher(account).matches()) {
                z5 = false;
            }
            Object obj = kVar.f7255a;
            if (!z5) {
                ((LoginActivity) ((h7.f) obj)).b0();
                com.example.baselibrary.utils.d.a(R$string.str_please_input_legal_account);
                return;
            }
            if (!Pattern.compile("^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,16}$").matcher(pw).matches()) {
                ((LoginActivity) ((h7.f) obj)).b0();
                com.example.baselibrary.utils.d.a(R$string.str_please_input_legal_pw);
                return;
            }
            Object obj2 = (h7.f) obj;
            ((XXBaseActivity) obj2).V();
            c6.d dVar = c6.d.f3392c;
            dVar.getClass();
            rg.l<HttpModel<LoginResultBean>> login = ((UserApi) dVar.f113a).login(account, pw);
            kotlin.jvm.internal.e.e(login, "login(...)");
            rg.l w8 = com.example.baselibrary.utils.b.w(login);
            LoginActivity loginActivity = (LoginActivity) obj2;
            loginActivity.getClass();
            w8.subscribe(new com.example.test.presenter.mine.j(kVar, loginActivity, w0.d(), 0));
            return;
        }
        int i10 = R$id.wxIv;
        eh.b bVar2 = this.N;
        if (valueOf != null && valueOf.intValue() == i10) {
            int i11 = Build.VERSION.SDK_INT;
            eh.b bVar3 = this.F;
            if (i11 >= 30) {
                V();
                ((IWXAPI) bVar3.getValue()).registerApp("wx1273e8f71f60b697");
                V0();
                return;
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
            arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
            if (!nd.c.j(this, arrayList)) {
                this.M = 3;
                ((com.example.test.ui.dialog.i) bVar2.getValue()).show();
                return;
            } else {
                V();
                ((IWXAPI) bVar3.getValue()).registerApp("wx1273e8f71f60b697");
                V0();
                return;
            }
        }
        int i12 = R$id.qqIv;
        if (valueOf == null || valueOf.intValue() != i12) {
            int i13 = R$id.tvForgetPw;
            if (valueOf != null && valueOf.intValue() == i13) {
                Intent intent = new Intent(this, (Class<?>) AccountValidateActivity.class);
                intent.putExtra("select_type", 4);
                startActivity(intent);
                return;
            }
            return;
        }
        R0();
        Map<String, String> parseMiniParameters = Tencent.parseMiniParameters(getIntent());
        if (parseMiniParameters == null || parseMiniParameters.isEmpty()) {
            this.L.clear();
            this.L.add("android.permission.WRITE_EXTERNAL_STORAGE");
            if (Build.VERSION.SDK_INT >= 30) {
                U0();
                return;
            } else if (nd.c.j(this, this.L)) {
                U0();
                return;
            } else {
                this.M = 2;
                ((com.example.test.ui.dialog.i) bVar2.getValue()).show();
                return;
            }
        }
        Iterator<Map.Entry<String, String>> it = parseMiniParameters.entrySet().iterator();
        ArrayList arrayList2 = new ArrayList();
        while (it.hasNext()) {
            arrayList2.add(it.next().getValue());
        }
        this.L = arrayList2;
        Log.e("qob", "tipPermissions " + arrayList2);
        if (nd.c.j(this, arrayList2)) {
            U0();
        } else {
            this.M = 1;
            ((com.example.test.ui.dialog.i) bVar2.getValue()).show();
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        super.onDestroy();
        b2.b(this);
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        if (message.what == 0) {
            new UserInfo(this, R0().getQQToken()).getUserInfo(new l(this));
        }
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void wxCodeEvent(EventBusBeans.WxCode wxCode) {
        kotlin.jvm.internal.e.f(wxCode, "wxCode");
        com.example.baselibrary.utils.b.z(wxCode);
        c6.e eVar = c6.e.f3393c;
        String code = wxCode.getCode();
        kotlin.jvm.internal.e.e(code, "getCode(...)");
        eVar.getClass();
        rg.l<WxAuthInfoBean.AuthInfo> authWx = ((WxAuthApi) eVar.f113a).authWx("wx1273e8f71f60b697", "56410da4d160489118619348e68b0091", code, "authorization_code");
        kotlin.jvm.internal.e.e(authWx, "authWx(...)");
        com.example.baselibrary.utils.b.w(authWx).subscribe(new n(this, w0.d()));
    }

    @yh.k(threadMode = ThreadMode.MAIN)
    public final void wxLoginInfo(EventBusBeans.WXLoginInfo wxLoginInfo) {
        kotlin.jvm.internal.e.f(wxLoginInfo, "wxLoginInfo");
        new StringBuilder("wxLoginInfo ").append(com.example.baselibrary.utils.b.z(wxLoginInfo));
        String openId = wxLoginInfo.getOpenId();
        if (openId == null || openId.length() == 0) {
            return;
        }
        com.example.test.presenter.mine.k kVar = (com.example.test.presenter.mine.k) I0();
        String openId2 = wxLoginInfo.getOpenId();
        kotlin.jvm.internal.e.e(openId2, "getOpenId(...)");
        kVar.k(openId2, "1");
    }
}
