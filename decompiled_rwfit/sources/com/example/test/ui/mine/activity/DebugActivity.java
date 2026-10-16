package com.example.test.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.core.content.FileProvider;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.example.network.bean.DocUrlBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.gms.internal.mlkit_vision_barcode.x1;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;

/* loaded from: classes.dex */
public final class DebugActivity extends XXBaseActivity<com.example.test.presenter.mine.a, f6.v> implements h7.a, View.OnClickListener {
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.mine.activity.DebugActivity$tLogCallback$2
        {
            super(0);
        }

        @Override // oh.a
        public final d invoke() {
            return new d(DebugActivity.this);
        }
    });

    public static final void R0(DebugActivity debugActivity, Context context, String str) {
        debugActivity.getClass();
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
        LinearLayout linearLayout = ((f6.v) this.f7247z.getValue()).f13383a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_debug, (ViewGroup) null, false);
        int i3 = R$id.av_share_device_db;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.av_share_device_log;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.av_share_device_synclog;
                ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView3 != null) {
                    i3 = R$id.ll_factory;
                    if (((LinearLayout) he.a(i3, inflate)) != null) {
                        i3 = R$id.titleView;
                        TitleView titleView = (TitleView) he.a(i3, inflate);
                        if (titleView != null) {
                            i3 = R$id.tv_factory_close;
                            TextView textView = (TextView) he.a(i3, inflate);
                            if (textView != null) {
                                i3 = R$id.tv_factory_open;
                                TextView textView2 = (TextView) he.a(i3, inflate);
                                if (textView2 != null) {
                                    return new f6.v((LinearLayout) inflate, actionItemView, actionItemView2, actionItemView3, titleView, textView, textView2);
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
    }

    @Override // h7.a
    public final void L(DocUrlBean docUrlBean) {
    }

    @Override // h7.a
    public final void M(com.example.test.utils.a aVar) {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((f6.v) bVar.getValue()).e.setOnTitleListener(new o(this, 4));
        ((f6.v) bVar.getValue()).f13385c.setOnClickListener(this);
        ((f6.v) bVar.getValue()).f13384b.setOnClickListener(this);
        ((f6.v) bVar.getValue()).f13386d.setOnClickListener(this);
        ((f6.v) bVar.getValue()).f13388g.setOnClickListener(this);
        ((f6.v) bVar.getValue()).f13387f.setOnClickListener(this);
        d bleDataCallback = (d) this.E.getValue();
        kotlin.jvm.internal.e.f(bleDataCallback, "bleDataCallback");
        x5.b I0 = x5.b.I0();
        u5.e eVar = new u5.e();
        eVar.f18883a = new com.example.baselibrary.utils.e(eVar);
        eVar.f18884b = bleDataCallback;
        I0.K0(eVar);
    }

    @Override // p5.a
    public final Context f0() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (System.currentTimeMillis() - x1.f9659a >= 1200 || System.currentTimeMillis() < x1.f9659a) {
            x1.f9659a = System.currentTimeMillis();
            final String str = null;
            Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
            int i3 = R$id.av_share_device_log;
            if (valueOf != null && valueOf.intValue() == i3) {
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
                        com.example.baselibrary.utils.b.x(str, new oh.l() { // from class: com.example.test.ui.mine.activity.DebugActivity$onClick$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // oh.l
                            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                invoke((String) obj);
                                return eh.g.f12633a;
                            }

                            public final void invoke(String str2) {
                                com.example.baselibrary.utils.b.A(android.support.v4.media.session.e.j(DebugActivity.this.getFilesDir(), "/logger/"), DebugActivity.this.getFilesDir() + "/log_" + str + ".zip");
                            }
                        }, new oh.l() { // from class: com.example.test.ui.mine.activity.DebugActivity$onClick$2
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
                                DebugActivity.this.b0();
                                DebugActivity debugActivity = DebugActivity.this;
                                DebugActivity.R0(debugActivity, debugActivity, debugActivity.getFilesDir() + "/log_" + str + ".zip");
                            }
                        });
                        return;
                    }
                }
                Toast.makeText(this, "暂无设备日志", 0).show();
                return;
            }
            int i10 = R$id.av_share_device_db;
            if (valueOf != null && valueOf.intValue() == i10) {
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
                com.example.baselibrary.utils.b.x(str, new oh.l() { // from class: com.example.test.ui.mine.activity.DebugActivity$onClick$3
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // oh.l
                    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                        invoke((String) obj);
                        return eh.g.f12633a;
                    }

                    public final void invoke(String str2) {
                        com.example.baselibrary.utils.b.A(DebugActivity.this.getDatabasePath("DHouseFit.db").getPath(), DebugActivity.this.getFilesDir() + "/db_" + str + ".zip");
                    }
                }, new oh.l() { // from class: com.example.test.ui.mine.activity.DebugActivity$onClick$4
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
                        DebugActivity.this.b0();
                        DebugActivity debugActivity = DebugActivity.this;
                        DebugActivity.R0(debugActivity, debugActivity, debugActivity.getFilesDir() + "/db_" + str + ".zip");
                    }
                });
                return;
            }
            int i11 = R$id.av_share_device_synclog;
            if (valueOf != null && valueOf.intValue() == i11) {
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "===============睡眠日志同步开始===============");
                V();
                if (r5.b.k().f18054c) {
                    x5.c.b().g((byte) -106, new byte[]{5, 11, 16}, new boolean[0]);
                    return;
                } else {
                    x5.b.I0().F0((byte) -106);
                    return;
                }
            }
            int i12 = R$id.tv_factory_open;
            if (valueOf != null && valueOf.intValue() == i12) {
                if (!r5.b.k().f18054c) {
                    x5.b.I0().F0((byte) 26);
                    return;
                }
                x5.c b3 = x5.c.b();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getRingFactoryWCmdJL 1");
                b3.g((byte) 26, new byte[]{2, 103, 0, (byte) 1}, new boolean[0]);
                return;
            }
            int i13 = R$id.tv_factory_close;
            if (valueOf != null && valueOf.intValue() == i13) {
                if (!r5.b.k().f18054c) {
                    x5.b.I0().F0((byte) 26);
                    return;
                }
                x5.c b10 = x5.c.b();
                com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getRingFactoryWCmdJL 0");
                b10.g((byte) 26, new byte[]{2, 103, 0, (byte) 0}, new boolean[0]);
            }
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        u5.c cVar;
        super.onDestroy();
        d dVar = (d) this.E.getValue();
        if (dVar == null) {
            return;
        }
        x5.b I0 = x5.b.I0();
        if (I0.J0(dVar)) {
            LinkedList linkedList = I0.f19795a;
            Iterator it = linkedList.iterator();
            while (true) {
                if (!it.hasNext()) {
                    cVar = null;
                    break;
                }
                cVar = (u5.c) it.next();
                if (cVar != null && cVar.g() == dVar) {
                    break;
                }
            }
            if (cVar == null) {
                return;
            }
            linkedList.remove(cVar);
        }
    }
}
