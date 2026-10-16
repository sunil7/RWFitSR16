package com.example.test.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.example.network.bean.DocUrlBean;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.f2;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.tencent.mmkv.MMKV;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Locale;

/* loaded from: classes.dex */
public final class AboutActivity extends XXBaseActivity<com.example.test.presenter.mine.a, f6.a> implements h7.a, View.OnClickListener {
    public static final /* synthetic */ int K = 0;
    public String E;
    public String F;
    public String G;
    public int H;
    public final long I = 2000;
    public final a J = new Runnable() { // from class: com.example.test.ui.mine.activity.a
        @Override // java.lang.Runnable
        public final void run() {
            int i3 = AboutActivity.K;
            AboutActivity this$0 = AboutActivity.this;
            kotlin.jvm.internal.e.f(this$0, "this$0");
            this$0.H = 0;
        }
    };

    public static final void R0(AboutActivity aboutActivity, Context context, String str) {
        aboutActivity.getClass();
        Intent intent = new Intent("android.intent.action.SEND");
        File file = new File(str);
        intent.setType("*/*");
        if (!file.exists()) {
            file.mkdir();
        }
        intent.putExtra("android.intent.extra.STREAM", FileProvider.getUriForFile(context, context.getApplicationInfo().packageName + ".provider", file));
        intent.putExtra("android.intent.extra.SUBJECT", context.getResources().getString(R$string.app_name));
        intent.putExtra("android.intent.extra.TITLE", context.getResources().getString(R$string.app_name));
        intent.setFlags(AMapEngineUtils.MAX_P20_WIDTH);
        context.startActivity(Intent.createChooser(intent, context.getResources().getString(R$string.app_name)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.mine.a(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.a) this.f7247z.getValue()).f12668a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_about, (ViewGroup) null, false);
        int i3 = R$id.appLogo;
        ImageView imageView = (ImageView) he.a(i3, inflate);
        if (imageView != null) {
            i3 = R$id.appName;
            if (((TextView) he.a(i3, inflate)) != null) {
                i3 = R$id.av_help;
                ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
                if (actionItemView != null) {
                    i3 = R$id.avPrivacyPol;
                    ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView2 != null) {
                        i3 = R$id.avUserPro;
                        ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                        if (actionItemView3 != null) {
                            i3 = R$id.titleView;
                            TitleView titleView = (TitleView) he.a(i3, inflate);
                            if (titleView != null) {
                                i3 = R$id.version;
                                TextView textView = (TextView) he.a(i3, inflate);
                                if (textView != null) {
                                    return new f6.a((LinearLayout) inflate, imageView, actionItemView, actionItemView2, actionItemView3, titleView, textView);
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
        MMKV mmkv;
        ((com.example.test.presenter.mine.a) I0()).k();
        com.example.test.presenter.mine.a aVar = (com.example.test.presenter.mine.a) I0();
        aVar.getClass();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        DocUrlBean docUrlBean = null;
        if (kVar != null && (mmkv = kVar.f8732a) != null) {
            docUrlBean = (DocUrlBean) mmkv.f("doc_url_info", DocUrlBean.class);
        }
        ((h7.a) aVar.f7255a).L(docUrlBean);
    }

    @Override // h7.a
    public final void L(DocUrlBean docUrlBean) {
        if (docUrlBean == null) {
            String str = f2.d(this).equals("zh-cn") ? "zh" : "en";
            this.E = String.format("https://www.ruiwo168.com/userProtocol_%s.html", Arrays.copyOf(new Object[]{str}, 1));
            this.F = String.format("https://www.ruiwo168.com/privacyPolicy_%s.html", Arrays.copyOf(new Object[]{str}, 1));
            this.G = String.format("https://www.ruiwo168.com/help/help_%s.html", Arrays.copyOf(new Object[]{str}, 1));
        } else {
            String userProtocolUrl = docUrlBean.getUserProtocolUrl();
            kotlin.jvm.internal.e.e(userProtocolUrl, "getUserProtocolUrl(...)");
            this.E = userProtocolUrl;
            String privacyPolicyUrl = docUrlBean.getPrivacyPolicyUrl();
            kotlin.jvm.internal.e.e(privacyPolicyUrl, "getPrivacyPolicyUrl(...)");
            this.F = privacyPolicyUrl;
            String helpUrl = docUrlBean.getHelpUrl();
            kotlin.jvm.internal.e.e(helpUrl, "getHelpUrl(...)");
            this.G = helpUrl;
        }
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        Integer valueOf = kVar != null ? Integer.valueOf(kVar.x()) : null;
        kotlin.jvm.internal.e.c(valueOf);
        if (valueOf.intValue() > 0) {
            this.G = String.format("https://www.ruiwo168.com/help_ring/help_%s.html", Arrays.copyOf(new Object[]{f2.d(this).equals("zh-cn") ? "zh" : "en"}, 1));
        }
    }

    @Override // h7.a
    public final void M(com.example.test.utils.a aVar) {
        ((f6.a) this.f7247z.getValue()).f12673g.setText("v " + aVar.f8718a);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((f6.a) bVar.getValue()).f12672f.setOnTitleListener(new o(this, 1));
        ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(this).m(Integer.valueOf(R$mipmap.ic_launcher)).o(true)).d(z3.h.f20239b)).i(R$drawable.bg_dial_item)).a(p4.e.t(new g4.v(20))).e(R$drawable.bg_dial_item)).x(((f6.a) bVar.getValue()).f12669b);
        ((f6.a) bVar.getValue()).f12669b.setOnClickListener(this);
        ((f6.a) bVar.getValue()).e.setOnClickListener(this);
        ((f6.a) bVar.getValue()).f12671d.setOnClickListener(this);
        ((f6.a) bVar.getValue()).f12670c.setOnClickListener(this);
    }

    @Override // p5.a
    public final Context f0() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        final String str = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.appLogo;
        if (valueOf != null && valueOf.intValue() == i3) {
            int i10 = this.H + 1;
            this.H = i10;
            if (i10 == 6) {
                this.H = 0;
                startActivity(new Intent(this, (Class<?>) DebugActivity.class));
            }
            a aVar = this.J;
            view.removeCallbacks(aVar);
            view.postDelayed(aVar, this.I);
            return;
        }
        int i11 = R$id.avUserPro;
        if (valueOf != null && valueOf.intValue() == i11) {
            com.example.test.service.e.h().getClass();
            com.example.test.service.e.d();
            String string = getString(R$string.str_user_protocol);
            kotlin.jvm.internal.e.e(string, "getString(...)");
            String str2 = this.E;
            if (str2 == null) {
                kotlin.jvm.internal.e.m("userPro");
                throw null;
            }
            Intent intent = new Intent(this, (Class<?>) WebContentActivity.class);
            intent.putExtra("title", string);
            intent.putExtra("url", str2);
            startActivity(intent);
            return;
        }
        int i12 = R$id.avPrivacyPol;
        if (valueOf != null && valueOf.intValue() == i12) {
            String string2 = getString(R$string.str_privacy_policy);
            kotlin.jvm.internal.e.e(string2, "getString(...)");
            String str3 = this.F;
            if (str3 == null) {
                kotlin.jvm.internal.e.m("priPro");
                throw null;
            }
            Intent intent2 = new Intent(this, (Class<?>) WebContentActivity.class);
            intent2.putExtra("title", string2);
            intent2.putExtra("url", str3);
            startActivity(intent2);
            return;
        }
        int i13 = R$id.av_share_device_log;
        if (valueOf != null && valueOf.intValue() == i13) {
            File file = new File(android.support.v4.media.session.e.j(getFilesDir(), "/logger/"));
            if (file.exists()) {
                String[] list = file.list();
                kotlin.jvm.internal.e.e(list, "list(...)");
                if (list.length != 0) {
                    V();
                    long currentTimeMillis = System.currentTimeMillis();
                    try {
                        str = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(Long.valueOf(currentTimeMillis));
                    } catch (Exception e) {
                        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(currentTimeMillis, " date translate error ", e.getMessage()));
                    }
                    com.example.baselibrary.utils.b.x(str, new oh.l() { // from class: com.example.test.ui.mine.activity.AboutActivity$onClick$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((String) obj);
                            return eh.g.f12633a;
                        }

                        public final void invoke(String str4) {
                            com.example.baselibrary.utils.b.A(android.support.v4.media.session.e.j(AboutActivity.this.getFilesDir(), "/logger/"), AboutActivity.this.getFilesDir() + "/log_" + str + ".zip");
                        }
                    }, new oh.l() { // from class: com.example.test.ui.mine.activity.AboutActivity$onClick$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // oh.l
                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((eh.g) obj);
                            return eh.g.f12633a;
                        }

                        public final void invoke(eh.g it) {
                            kotlin.jvm.internal.e.f(it, "it");
                            AboutActivity.this.b0();
                            AboutActivity aboutActivity = AboutActivity.this;
                            AboutActivity.R0(aboutActivity, aboutActivity, aboutActivity.getFilesDir() + "/log_" + str + ".zip");
                        }
                    });
                    return;
                }
            }
            Toast.makeText(this, "暂无设备日志", 0).show();
            return;
        }
        int i14 = R$id.av_share_device_db;
        if (valueOf != null && valueOf.intValue() == i14) {
            if (!new File(getDatabasePath("DHouseFit.db").getPath()).exists()) {
                Toast.makeText(this, "暂无设备日志", 0).show();
                return;
            }
            V();
            long currentTimeMillis2 = System.currentTimeMillis();
            try {
                str = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH).format(Long.valueOf(currentTimeMillis2));
            } catch (Exception e10) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, android.support.v4.media.session.e.h(currentTimeMillis2, " date translate error ", e10.getMessage()));
            }
            com.example.baselibrary.utils.b.x(str, new oh.l() { // from class: com.example.test.ui.mine.activity.AboutActivity$onClick$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String str4) {
                    com.example.baselibrary.utils.b.A(AboutActivity.this.getDatabasePath("DHouseFit.db").getPath(), AboutActivity.this.getFilesDir() + "/db_" + str + ".zip");
                }
            }, new oh.l() { // from class: com.example.test.ui.mine.activity.AboutActivity$onClick$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((eh.g) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(eh.g it) {
                    kotlin.jvm.internal.e.f(it, "it");
                    AboutActivity.this.b0();
                    AboutActivity aboutActivity = AboutActivity.this;
                    AboutActivity.R0(aboutActivity, aboutActivity, aboutActivity.getFilesDir() + "/db_" + str + ".zip");
                }
            });
            return;
        }
        int i15 = R$id.av_help;
        if (valueOf == null || valueOf.intValue() != i15) {
            int i16 = R$id.av_share_device_synclog;
            if (valueOf != null && valueOf.intValue() == i16) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "===============睡眠日志同步开始===============");
                if (r5.b.k().f18054c) {
                    x5.c.b().g((byte) -106, new byte[]{5, 11, 16}, new boolean[0]);
                    return;
                } else {
                    x5.b.I0().F0((byte) -106);
                    return;
                }
            }
            return;
        }
        String string3 = getString(R$string.str_help);
        kotlin.jvm.internal.e.e(string3, "getString(...)");
        String str4 = this.G;
        if (str4 == null) {
            kotlin.jvm.internal.e.m("help");
            throw null;
        }
        Intent intent3 = new Intent(this, (Class<?>) WebContentActivity.class);
        intent3.putExtra("title", string3);
        intent3.putExtra("url", str4);
        startActivity(intent3);
    }
}
