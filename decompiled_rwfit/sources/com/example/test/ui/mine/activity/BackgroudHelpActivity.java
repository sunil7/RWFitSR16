package com.example.test.ui.mine.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;

/* loaded from: classes.dex */
public final class BackgroudHelpActivity extends XXBaseActivity<com.example.test.presenter.device.n, f6.f> implements h7.j {
    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.n(this, 14);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.f) this.f7247z.getValue()).f12839a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_backgroud_help, (ViewGroup) null, false);
        int i3 = R$id.titleView;
        TitleView titleView = (TitleView) he.a(i3, inflate);
        if (titleView != null) {
            return new f6.f((LinearLayout) inflate, titleView);
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        ((f6.f) this.f7247z.getValue()).f12840b.setOnTitleListener(new o(this, 3));
    }

    @Override // p5.a
    public final Context f0() {
        return this;
    }
}
