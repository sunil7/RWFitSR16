package com.example.test.presenter.device;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.network.bean.DialBean;
import com.example.test.R$drawable;
import com.example.test.R$string;
import com.example.test.XXApplication;
import com.example.test.ui.device.activity.DialDetailActivity;
import com.example.test.ui.device.model.DialModel;
import java.util.Arrays;

/* loaded from: classes.dex */
public final class x extends g {

    /* renamed from: d, reason: collision with root package name */
    public String f7490d;
    public String e;

    /* renamed from: f, reason: collision with root package name */
    public String f7491f;

    /* renamed from: g, reason: collision with root package name */
    public String f7492g;

    /* renamed from: h, reason: collision with root package name */
    public final eh.b f7493h;

    public x(DialDetailActivity dialDetailActivity) {
        super(dialDetailActivity);
        this.f7490d = "";
        this.e = "";
        this.f7493h = kotlin.a.b(new oh.a() { // from class: com.example.test.presenter.device.DialDetailPresenter$fileDownloadListener$2
            {
                super(0);
            }

            @Override // oh.a
            public final v invoke() {
                return new v(x.this);
            }
        });
    }

    @Override // com.example.test.presenter.device.g
    public final void o() {
        DialDetailActivity dialDetailActivity = (DialDetailActivity) ((f7.g) this.f7255a);
        dialDetailActivity.E = false;
        dialDetailActivity.b0();
        Toast.makeText(dialDetailActivity, R$string.str_download_fail, 0).show();
        eh.b bVar = dialDetailActivity.f7247z;
        ((f6.x) bVar.getValue()).f13433g.setEnable(true);
        ((f6.x) bVar.getValue()).f13433g.setText(dialDetailActivity.getString(R$string.str_reinstall));
    }

    @Override // com.example.test.presenter.device.g
    public final void p(float f2) {
    }

    @Override // com.example.test.presenter.device.g
    public final void q(String str) {
        if (str == null || str.length() == 0) {
            o();
            return;
        }
        this.e = str;
        if (y5.d.f20005b) {
            n(str);
            return;
        }
        if (this.f7490d.length() == 0) {
            o();
            return;
        }
        pe.b bVar = new pe.b(this.f7490d);
        XXApplication xXApplication = XXApplication.f7400h;
        bVar.c(com.google.android.gms.internal.mlkit_vision_barcode.j1.a().getCacheDir().getAbsolutePath(), true);
        bVar.f17550h = (v) this.f7493h.getValue();
        bVar.d();
    }

    @Override // com.example.test.presenter.device.g
    public final void r(int i3) {
        ((DialDetailActivity) ((f7.g) this.f7255a)).a0(i3);
    }

    @Override // com.example.test.presenter.device.g
    public final void s(float f2) {
        DialDetailActivity dialDetailActivity = (DialDetailActivity) ((f7.g) this.f7255a);
        String concat = String.format("%s: %d", Arrays.copyOf(new Object[]{dialDetailActivity.getString(R$string.str_installing), Integer.valueOf((int) f2)}, 2)).concat("%");
        eh.b bVar = dialDetailActivity.f7247z;
        ((f6.x) bVar.getValue()).f13433g.setProgress(f2);
        ((f6.x) bVar.getValue()).f13433g.setText(concat);
    }

    @Override // com.example.test.presenter.device.g
    public final void t() {
        ((DialDetailActivity) ((f7.g) this.f7255a)).s();
    }

    public final void w() {
        com.example.baselibrary.preseneter.b.j("", new oh.l() { // from class: com.example.test.presenter.device.DialDetailPresenter$getLocalDialInfo$1
            @Override // oh.l
            public final DialInfoBean invoke(String it) {
                kotlin.jvm.internal.e.f(it, "it");
                if (com.example.test.utils.k.f8731b == null) {
                    synchronized (com.example.test.utils.k.class) {
                        com.example.test.utils.k.f8731b = new com.example.test.utils.k();
                    }
                }
                com.example.test.utils.k kVar = com.example.test.utils.k.f8731b;
                if (kVar != null) {
                    return kVar.n();
                }
                return null;
            }
        }, new oh.l() { // from class: com.example.test.presenter.device.DialDetailPresenter$getLocalDialInfo$2
            {
                super(1);
            }

            @Override // oh.l
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((DialInfoBean) obj);
                return eh.g.f12633a;
            }

            public final void invoke(DialInfoBean dialInfoBean) {
                DialBean dialBean;
                DialBean dialBean2;
                if (dialInfoBean != null) {
                    DialDetailActivity dialDetailActivity = (DialDetailActivity) ((f7.g) x.this.f7255a);
                    dialDetailActivity.getClass();
                    eh.b bVar = dialDetailActivity.f7247z;
                    ViewGroup.LayoutParams layoutParams = ((f6.x) bVar.getValue()).f13429b.getLayoutParams();
                    kotlin.jvm.internal.e.d(layoutParams, "null cannot be cast to non-null type android.widget.LinearLayout.LayoutParams");
                    LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) layoutParams;
                    int dialType = dialInfoBean.getDialType();
                    z3.h hVar = z3.h.f20239b;
                    if (dialType == 0) {
                        layoutParams2.height = (int) ((dialInfoBean.getHeight() * layoutParams2.width) / dialInfoBean.getWidth());
                        ((f6.x) bVar.getValue()).f13429b.setLayoutParams(layoutParams2);
                        DialModel dialModel = dialDetailActivity.H;
                        if (dialModel == null || (dialBean2 = dialModel.getDialBean()) == null) {
                            return;
                        }
                        ImageView imageView = ((f6.x) bVar.getValue()).f13429b;
                        String previewUrl = dialBean2.getPreviewUrl();
                        kotlin.jvm.internal.e.e(previewUrl, "getPreviewUrl(...)");
                        ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(dialDetailActivity).n(previewUrl).o(true)).d(hVar)).i(R$drawable.bg_dial_item)).a(p4.e.t(new g4.v(com.example.baselibrary.utils.b.f(dialDetailActivity, 10.0f)))).e(R$drawable.bg_dial_item)).x(imageView);
                        return;
                    }
                    layoutParams2.height = layoutParams2.width;
                    ((f6.x) bVar.getValue()).f13429b.setLayoutParams(layoutParams2);
                    DialModel dialModel2 = dialDetailActivity.H;
                    if (dialModel2 == null || (dialBean = dialModel2.getDialBean()) == null) {
                        return;
                    }
                    ImageView imageView2 = ((f6.x) bVar.getValue()).f13429b;
                    String previewUrl2 = dialBean.getPreviewUrl();
                    kotlin.jvm.internal.e.e(previewUrl2, "getPreviewUrl(...)");
                    ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(dialDetailActivity).n(previewUrl2).o(true)).d(hVar)).i(R$drawable.bg_img)).a(p4.e.t(new g4.i())).e(R$drawable.bg_img)).x(imageView2);
                }
            }
        });
    }
}
