package com.example.test.ui.mine.activity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.j1;

/* loaded from: classes.dex */
public final class RingContactActivity extends XXBaseActivity<com.example.test.presenter.mine.h, j1> implements h7.d, View.OnClickListener {
    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.mine.h(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((j1) this.f7247z.getValue()).f13016a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_ring_contact, (ViewGroup) null, false);
        int i3 = R$id.commit;
        Button button = (Button) he.a(i3, inflate);
        if (button != null) {
            i3 = R$id.deviceModelEt;
            if (((TextView) he.a(i3, inflate)) != null) {
                i3 = R$id.titleView;
                TitleView titleView = (TitleView) he.a(i3, inflate);
                if (titleView != null) {
                    return new j1((LinearLayout) inflate, button, titleView);
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
        ((j1) bVar.getValue()).f13018c.setOnTitleListener(new o(this, 7));
        ((j1) bVar.getValue()).f13017b.setOnClickListener(this);
    }

    @Override // h7.d
    public final void S(String str) {
        com.example.baselibrary.utils.d.b(str);
    }

    @Override // p5.a
    public final Context f0() {
        return this;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.commit;
        if (valueOf != null && valueOf.intValue() == i3) {
            Intent intent = new Intent("android.intent.action.SENDTO");
            intent.setData(Uri.parse("mailto:BrenRing@163.com"));
            intent.putExtra("android.intent.extra.SUBJECT", "Support Request");
            intent.putExtra("android.intent.extra.TEXT", "Please describe your issue here.");
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
            } else {
                Toast.makeText(this, "未找到可用的邮箱应用", 0).show();
            }
        }
    }
}
