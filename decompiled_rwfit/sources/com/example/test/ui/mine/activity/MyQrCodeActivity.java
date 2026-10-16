package com.example.test.ui.mine.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.widget.NestedScrollView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.x0;

/* loaded from: classes.dex */
public final class MyQrCodeActivity extends XXBaseActivity<com.example.test.presenter.mine.l, x0> implements h7.g {
    public static final /* synthetic */ int E = 0;

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.mine.l(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((x0) this.f7247z.getValue()).f13435a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_my_qr_code, (ViewGroup) null, false);
        int i3 = R$id.avatarIv;
        ImageView imageView = (ImageView) he.a(i3, inflate);
        if (imageView != null) {
            i3 = R$id.calorieTv;
            TextView textView = (TextView) he.a(i3, inflate);
            if (textView != null) {
                i3 = R$id.content;
                NestedScrollView nestedScrollView = (NestedScrollView) he.a(i3, inflate);
                if (nestedScrollView != null) {
                    i3 = R$id.distanceTv;
                    TextView textView2 = (TextView) he.a(i3, inflate);
                    if (textView2 != null) {
                        i3 = R$id.qrCodeIv;
                        ImageView imageView2 = (ImageView) he.a(i3, inflate);
                        if (imageView2 != null) {
                            i3 = R$id.titleView;
                            TitleView titleView = (TitleView) he.a(i3, inflate);
                            if (titleView != null) {
                                i3 = R$id.totalStepTv;
                                TextView textView3 = (TextView) he.a(i3, inflate);
                                if (textView3 != null) {
                                    i3 = R$id.tv_user_id;
                                    TextView textView4 = (TextView) he.a(i3, inflate);
                                    if (textView4 != null) {
                                        i3 = R$id.userNameTv;
                                        TextView textView5 = (TextView) he.a(i3, inflate);
                                        if (textView5 != null) {
                                            return new x0((LinearLayout) inflate, imageView, textView, nestedScrollView, textView2, imageView2, titleView, textView3, textView4, textView5);
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
        ((com.example.test.presenter.mine.l) I0()).l();
        ((com.example.test.presenter.mine.l) I0()).k();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        ((x0) this.f7247z.getValue()).f13440g.setOnTitleListener(new o(this, 0));
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }
}
