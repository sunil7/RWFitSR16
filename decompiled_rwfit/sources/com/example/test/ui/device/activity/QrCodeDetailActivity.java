package com.example.test.ui.device.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.dh.imagepick.ImagePickClient;
import com.example.blesdk.bean.function.QrCodeBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.presenter.device.a1;
import com.example.test.presenter.device.b1;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.f1;

/* loaded from: classes.dex */
public final class QrCodeDetailActivity extends XXBaseActivity<b1, f1> implements f7.v, View.OnClickListener {
    public static final /* synthetic */ int G = 0;
    public final eh.b E = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.QrCodeDetailActivity$qrCodeBean$2
        {
            super(0);
        }

        @Override // oh.a
        public final QrCodeBean invoke() {
            QrCodeBean qrCodeBean = new QrCodeBean();
            QrCodeDetailActivity qrCodeDetailActivity = QrCodeDetailActivity.this;
            int i3 = QrCodeDetailActivity.G;
            qrCodeBean.setAppType(((Number) qrCodeDetailActivity.F.getValue()).intValue());
            return qrCodeBean;
        }
    });
    public final eh.b F = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.device.activity.QrCodeDetailActivity$qrCodeType$2
        {
            super(0);
        }

        @Override // oh.a
        public final Integer invoke() {
            Intent intent = QrCodeDetailActivity.this.getIntent();
            return Integer.valueOf(intent != null ? intent.getIntExtra("QR_TYPE", 0) : 0);
        }
    });

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new b1(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f1) this.f7247z.getValue()).f12848a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_qr_code_detail, (ViewGroup) null, false);
        int i3 = R$id.changeBtn;
        Button button = (Button) he.a(i3, inflate);
        if (button != null) {
            i3 = R$id.clearBtn;
            Button button2 = (Button) he.a(i3, inflate);
            if (button2 != null) {
                i3 = R$id.editEt;
                EditText editText = (EditText) he.a(i3, inflate);
                if (editText != null) {
                    i3 = R$id.qrCodeIv;
                    ImageView imageView = (ImageView) he.a(i3, inflate);
                    if (imageView != null) {
                        i3 = R$id.saveBtn;
                        Button button3 = (Button) he.a(i3, inflate);
                        if (button3 != null) {
                            i3 = R$id.titleView;
                            TitleView titleView = (TitleView) he.a(i3, inflate);
                            if (titleView != null) {
                                return new f1((LinearLayout) inflate, button, button2, editText, imageView, button3, titleView);
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
        ((b1) I0()).n(((Number) this.F.getValue()).intValue());
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        int intValue = ((Number) this.F.getValue()).intValue();
        eh.b bVar = this.f7247z;
        switch (intValue) {
            case 0:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_qq);
                break;
            case 1:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_wechat);
                break;
            case 2:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_whatsapp);
                break;
            case 3:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_whatsapp);
                break;
            case 4:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_facebook);
                break;
            case 5:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_linkedin);
                break;
            case 6:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_instagram);
                break;
            case 7:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_other);
                break;
            case 8:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_line);
                break;
            case 9:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_e_wechat);
                break;
            case 10:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_dingding);
                break;
            case 11:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_viber);
                break;
            case 12:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_skype);
                break;
            case 13:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_tumblr);
                break;
            case 14:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_snapchat);
                break;
            case 15:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_youtube);
                break;
            case 16:
                ((f1) bVar.getValue()).f12853g.setTitle(R$string.str_pinterset);
                break;
        }
        ((f1) bVar.getValue()).f12853g.setOnTitleListener(new a2.d(this, 25));
        ((f1) bVar.getValue()).f12849b.setOnClickListener(this);
        ((f1) bVar.getValue()).f12850c.setOnClickListener(this);
        ((f1) bVar.getValue()).f12852f.setOnClickListener(this);
    }

    public final QrCodeBean R0() {
        return (QrCodeBean) this.E.getValue();
    }

    public final void S0() {
        R0().setName("");
        R0().setContent(getString(R$string.str_qrcode));
        b1 b1Var = (b1) I0();
        String content = R0().getContent();
        kotlin.jvm.internal.e.e(content, "getContent(...)");
        b1Var.m(content);
        ((f1) this.f7247z.getValue()).f12851d.setText(R0().getName());
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.changeBtn;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (Build.VERSION.SDK_INT < 30) {
                v2.h hVar = new v2.h(this);
                hVar.o("android.permission.WRITE_EXTERNAL_STORAGE");
                hVar.o("android.permission.READ_EXTERNAL_STORAGE");
                hVar.p(new y(this, 0));
                return;
            }
            oh.l lVar = new oh.l() { // from class: com.example.test.ui.device.activity.QrCodeDetailActivity$onClick$1
                {
                    super(1);
                }

                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String path) {
                    kotlin.jvm.internal.e.f(path, "path");
                    QrCodeDetailActivity qrCodeDetailActivity = QrCodeDetailActivity.this;
                    int i10 = QrCodeDetailActivity.G;
                    ((b1) qrCodeDetailActivity.I0()).o(path);
                }
            };
            QrCodeDetailActivity$onClick$2 errorBack = new oh.l() { // from class: com.example.test.ui.device.activity.QrCodeDetailActivity$onClick$2
                @Override // oh.l
                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                    invoke((String) obj);
                    return eh.g.f12633a;
                }

                public final void invoke(String error) {
                    kotlin.jvm.internal.e.f(error, "error");
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7264b, "error pick ".concat(error));
                }
            };
            kotlin.jvm.internal.e.f(errorBack, "errorBack");
            com.dh.imagepick.work.c with = ImagePickClient.with(this);
            with.getClass();
            new f5.b(with).h(new com.example.test.utils.o(errorBack, lVar, 0));
            return;
        }
        int i10 = R$id.clearBtn;
        if (valueOf != null && valueOf.intValue() == i10) {
            ((b1) I0()).l(((Number) this.F.getValue()).intValue());
            return;
        }
        int i11 = R$id.saveBtn;
        if (valueOf != null && valueOf.intValue() == i11) {
            QrCodeBean R0 = R0();
            eh.b bVar = this.f7247z;
            R0.setName((((f1) bVar.getValue()).f12851d.getText() == null || ((f1) bVar.getValue()).f12851d.getText().toString().length() == 0) ? "" : ((f1) bVar.getValue()).f12851d.getText().toString());
            b1 b1Var = (b1) I0();
            QrCodeBean qrCodeBean = R0();
            b1Var.getClass();
            kotlin.jvm.internal.e.f(qrCodeBean, "qrCodeBean");
            a1 customStatusCallback = (a1) b1Var.f7413c.getValue();
            kotlin.jvm.internal.e.f(customStatusCallback, "customStatusCallback");
            x5.b.I0().K0(new u5.f(47, customStatusCallback));
            ((XXBaseActivity) ((f7.v) b1Var.f7255a)).V();
            if (r5.b.k().f18054c) {
                String content = qrCodeBean.getContent();
                if (content == null || content.length() == 0 || y5.b.n(qrCodeBean.getName()).length > 256) {
                    x5.b.I0().G0((byte) 47);
                } else {
                    x5.d c9 = x5.d.c();
                    com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getQrCodeCmd " + qrCodeBean);
                    byte[] n4 = y5.b.n(qrCodeBean.getName());
                    byte[] n8 = y5.b.n(qrCodeBean.getContent());
                    byte[] bArr = new byte[n4.length + 4 + n8.length];
                    bArr[0] = (byte) (qrCodeBean.getAppType() & 255);
                    bArr[1] = (byte) (n4.length & 255);
                    System.arraycopy(n4, 0, bArr, 2, n4.length);
                    byte[] a3 = y5.b.a(n8.length, 2);
                    bArr[n4.length + 2] = a3[0];
                    bArr[n4.length + 3] = a3[1];
                    System.arraycopy(n8, 0, bArr, n4.length + 4, n8.length);
                    c9.j((byte) 47, bArr);
                }
            } else {
                x5.b.I0().F0((byte) 47);
            }
            ((b1) I0()).p(R0());
        }
    }
}
