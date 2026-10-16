package com.example.test.ui.device.activity;

import android.content.Context;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.database.table.Devices;
import com.example.network.api.DeviceApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.DeviceModelInfoBean;
import com.example.network.bean.DialBean;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.model.DialModel;
import com.example.test.ui.model.EventBusBeans;
import com.example.test.ui.view.ProgressButtonView;
import com.example.test.ui.view.TitleView;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import java.io.File;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class DialDetailActivity extends XXBaseActivity<com.example.test.presenter.device.x, f6.x> implements f7.g, View.OnClickListener, o5.a {
    public static final /* synthetic */ int K = 0;
    public boolean E;
    public boolean F;
    public boolean G;
    public DialModel H;
    public final eh.b I = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.DialDetailActivity$weakHandler$2
        {
            super(0);
        }

        @Override // oh.a
        public final com.example.baselibrary.utils.e invoke() {
            return new com.example.baselibrary.utils.e(DialDetailActivity.this);
        }
    });
    public int J;

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.x(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.x) this.f7247z.getValue()).f13428a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_dial_detail, (ViewGroup) null, false);
        int i3 = R$id.dial_face;
        ImageView imageView = (ImageView) he.a(i3, inflate);
        if (imageView != null) {
            i3 = R$id.dial_name;
            TextView textView = (TextView) he.a(i3, inflate);
            if (textView != null) {
                i3 = R$id.dial_size;
                TextView textView2 = (TextView) he.a(i3, inflate);
                if (textView2 != null) {
                    i3 = R$id.free;
                    TextView textView3 = (TextView) he.a(i3, inflate);
                    if (textView3 != null) {
                        i3 = R$id.install;
                        TextView textView4 = (TextView) he.a(i3, inflate);
                        if (textView4 != null) {
                            i3 = R$id.progressBtn;
                            ProgressButtonView progressButtonView = (ProgressButtonView) he.a(i3, inflate);
                            if (progressButtonView != null) {
                                i3 = R$id.titleView;
                                TitleView titleView = (TitleView) he.a(i3, inflate);
                                if (titleView != null) {
                                    return new f6.x((LinearLayout) inflate, imageView, textView, textView2, textView3, textView4, progressButtonView, titleView);
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
        DialBean dialBean;
        DialBean dialBean2;
        ((com.example.test.presenter.device.x) I0()).w();
        com.example.test.presenter.device.x xVar = (com.example.test.presenter.device.x) I0();
        xVar.getClass();
        if (com.example.test.utils.k.f8731b == null) {
            synchronized (com.example.test.utils.k.class) {
                com.example.test.utils.k.f8731b = new com.example.test.utils.k();
            }
        }
        com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
        DeviceModelInfoBean j4 = kVar != null ? kVar.j() : null;
        if (j4 != null) {
            xVar.f7491f = j4.getThumbWidth();
            xVar.f7492g = j4.getThumbHeight();
        }
        DialModel dialModel = this.H;
        if (dialModel != null && (dialBean2 = dialModel.getDialBean()) != null) {
            ImageView imageView = ((f6.x) this.f7247z.getValue()).f13429b;
            String previewUrl = dialBean2.getPreviewUrl();
            kotlin.jvm.internal.e.e(previewUrl, "getPreviewUrl(...)");
            ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(this).n(previewUrl).o(true)).d(z3.h.f20239b)).i(R$drawable.bg_dial_item)).e(R$drawable.bg_dial_item)).x(imageView);
        }
        DialModel dialModel2 = this.H;
        if (dialModel2 == null || (dialBean = dialModel2.getDialBean()) == null) {
            return;
        }
        eh.b bVar = this.f7247z;
        ((f6.x) bVar.getValue()).f13430c.setText(dialBean.getName());
        ((f6.x) bVar.getValue()).e.setVisibility(dialBean.getFree() == 1 ? 0 : 8);
        TextView textView = ((f6.x) bVar.getValue()).f13431d;
        int free = dialBean.getFree();
        long size = dialBean.getSize() / 1024;
        StringBuilder sb2 = free == 1 ? new StringBuilder("| ") : new StringBuilder();
        sb2.append(size);
        sb2.append("KB");
        textView.setText(sb2.toString());
        ((f6.x) bVar.getValue()).f13432f.setText(dialBean.getUseCount() + getString(R$string.str_p_install));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        if (getIntent() == null || getIntent().getParcelableExtra("dial_data") == null) {
            w0(R$string.str_data_error);
            finish();
            return;
        }
        this.H = (DialModel) getIntent().getParcelableExtra("dial_data");
        eh.b bVar = this.f7247z;
        ((f6.x) bVar.getValue()).f13434h.setOnTitleListener(new a2.d(this, 15));
        ((f6.x) bVar.getValue()).f13433g.setText(getString(R$string.str_install));
        ((f6.x) bVar.getValue()).f13433g.setEnable(true);
        ((f6.x) bVar.getValue()).f13433g.setOnClickListener(this);
    }

    public final void a0(int i3) {
        this.E = false;
        com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.device.activity.DialDetailActivity$onInstallFail$1
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return eh.g.f12633a;
            }

            public final void invoke(String it) {
                File[] listFiles;
                kotlin.jvm.internal.e.f(it, "it");
                File file = new File(android.support.v4.media.session.e.j(DialDetailActivity.this.getFilesDir(), "/dial"));
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        kotlin.jvm.internal.e.c(file2);
                        com.example.baselibrary.utils.b.e(file2);
                    }
                }
            }
        }, new oh.l() { // from class: com.example.test.ui.device.activity.DialDetailActivity$onInstallFail$2
            public final void invoke(eh.g it) {
                kotlin.jvm.internal.e.f(it, "it");
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((eh.g) obj);
                return eh.g.f12633a;
            }
        });
        b0();
        if (!this.G) {
            this.G = true;
            Toast.makeText(this, R$string.str_save_fail, 0).show();
        }
        com.example.test.utils.y.u().G();
        eh.b bVar = this.f7247z;
        ((f6.x) bVar.getValue()).f13433g.setEnable(true);
        ((f6.x) bVar.getValue()).f13433g.setText(getString(R$string.str_reinstall));
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public final void onBackPressed() {
        if (this.E) {
            Toast.makeText(this, R$string.str_installing, 0).show();
        } else {
            super.onBackPressed();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        DialBean dialBean;
        Devices c9;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.progressBtn;
        if (valueOf != null && valueOf.intValue() == i3) {
            this.G = false;
            this.E = true;
            String concat = String.format("%s: %d", Arrays.copyOf(new Object[]{getString(R$string.str_installing), 0}, 2)).concat("%");
            ((f6.x) this.f7247z.getValue()).f13433g.setProgress(0.0f);
            ((f6.x) this.f7247z.getValue()).f13433g.setText(concat);
            DialModel dialModel = this.H;
            if (dialModel == null || (dialBean = dialModel.getDialBean()) == null) {
                return;
            }
            com.example.test.utils.y.u().y(true);
            com.example.test.utils.y.u().A();
            com.example.test.presenter.device.x xVar = (com.example.test.presenter.device.x) I0();
            String downloadUrl = dialBean.getDownloadUrl();
            kotlin.jvm.internal.e.e(downloadUrl, "getDownloadUrl(...)");
            String thumbnailUrl = dialBean.getThumbnailUrl();
            String previewUrl = (thumbnailUrl == null || thumbnailUrl.length() == 0) ? dialBean.getPreviewUrl() : dialBean.getThumbnailUrl();
            kotlin.jvm.internal.e.c(previewUrl);
            xVar.getClass();
            xVar.v(downloadUrl);
            xVar.f7490d = previewUrl;
            com.example.test.presenter.device.x xVar2 = (com.example.test.presenter.device.x) I0();
            String dialId = String.valueOf(dialBean.getId());
            xVar2.getClass();
            kotlin.jvm.internal.e.f(dialId, "dialId");
            if (com.example.test.utils.k.f8731b == null) {
                synchronized (com.example.test.utils.k.class) {
                    com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                }
            }
            com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
            if (kVar == null || (c9 = kVar.c()) == null) {
                return;
            }
            c6.b bVar = c6.b.f3390c;
            String macAddress = c9.getMacAddress();
            kotlin.jvm.internal.e.e(macAddress, "getMacAddress(...)");
            bVar.getClass();
            rg.l<HttpModel<String>> installDial = ((DeviceApi) bVar.f113a).installDial(macAddress, dialId);
            kotlin.jvm.internal.e.e(installDial, "installDial(...)");
            rg.l w8 = com.example.baselibrary.utils.b.w(installDial);
            DialDetailActivity dialDetailActivity = (DialDetailActivity) ((f7.g) xVar2.f7255a);
            dialDetailActivity.getClass();
            w8.subscribe(new com.example.test.presenter.device.w(dialDetailActivity, w0.d(), 0));
        }
    }

    @Override // com.example.test.ui.XXBaseActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        DialBean dialBean;
        DialModel dialModel = this.H;
        if (dialModel != null && (dialBean = dialModel.getDialBean()) != null && this.F) {
            yh.d.b().e(new EventBusBeans.HomeDialEvent(dialBean.getId()));
        }
        super.onDestroy();
    }

    @Override // o5.a
    public final void r0(Message message) {
        kotlin.jvm.internal.e.f(message, "message");
        Object obj = message.obj;
        kotlin.jvm.internal.e.d(obj, "null cannot be cast to non-null type kotlin.Int");
        int intValue = ((Integer) obj).intValue();
        int i3 = this.J;
        eh.b bVar = this.f7247z;
        if (i3 >= 100) {
            ((f6.x) bVar.getValue()).f13433g.setEnable(false);
            ((f6.x) bVar.getValue()).f13433g.setText(getString(R$string.str_installed));
            return;
        }
        this.J = i3 + intValue;
        String concat = String.format("%s%d", Arrays.copyOf(new Object[]{getString(R$string.str_installing), Integer.valueOf(this.J)}, 2)).concat("%");
        ((f6.x) bVar.getValue()).f13433g.setProgress(this.J);
        ((f6.x) bVar.getValue()).f13433g.setText(concat);
        Message obtain = Message.obtain();
        obtain.what = 1;
        obtain.obj = Integer.valueOf(rh.c.Default.nextInt(3));
        eh.b bVar2 = this.I;
        ((com.example.baselibrary.utils.e) bVar2.getValue()).removeMessages(1);
        ((com.example.baselibrary.utils.e) bVar2.getValue()).sendMessageDelayed(obtain, 200L);
    }

    public final void s() {
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "CustomDialActivity", "-----表盘安装成功----");
        this.F = true;
        this.E = false;
        eh.b bVar = this.f7247z;
        ((f6.x) bVar.getValue()).f13433g.setProgress(100.0f);
        ((f6.x) bVar.getValue()).f13433g.setText("100%");
        com.example.baselibrary.utils.b.x("", new oh.l() { // from class: com.example.test.ui.device.activity.DialDetailActivity$onInstallSuccess$1
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((String) obj);
                return eh.g.f12633a;
            }

            public final void invoke(String it) {
                File[] listFiles;
                kotlin.jvm.internal.e.f(it, "it");
                File file = new File(android.support.v4.media.session.e.j(DialDetailActivity.this.getFilesDir(), "/dial"));
                if (file.exists() && file.isDirectory() && (listFiles = file.listFiles()) != null) {
                    for (File file2 : listFiles) {
                        kotlin.jvm.internal.e.c(file2);
                        com.example.baselibrary.utils.b.e(file2);
                    }
                }
            }
        }, new oh.l() { // from class: com.example.test.ui.device.activity.DialDetailActivity$onInstallSuccess$2
            public final void invoke(eh.g it) {
                kotlin.jvm.internal.e.f(it, "it");
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((eh.g) obj);
                return eh.g.f12633a;
            }
        });
        com.example.test.utils.y.u().G();
        b0();
        w0(R$string.str_save_success);
        onBackPressed();
    }
}
