package com.example.test.ui.mine.activity;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.example.network.api.UserApi;
import com.example.network.base.HttpModel;
import com.example.network.bean.SwitchBean;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.ActionItemView;
import com.example.test.ui.view.TitleView;
import com.example.test.utils.w0;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import f6.e1;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class PrivacySafeActivity extends XXBaseActivity<com.example.test.presenter.mine.p, e1> implements h7.i, View.OnClickListener {
    public static final /* synthetic */ int E = 0;

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.mine.p(this);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((e1) this.f7247z.getValue()).f12819a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_privacy_safe, (ViewGroup) null, false);
        int i3 = R$id.clearALLAv;
        ActionItemView actionItemView = (ActionItemView) he.a(i3, inflate);
        if (actionItemView != null) {
            i3 = R$id.healthSwitch;
            ActionItemView actionItemView2 = (ActionItemView) he.a(i3, inflate);
            if (actionItemView2 != null) {
                i3 = R$id.personSwitch;
                ActionItemView actionItemView3 = (ActionItemView) he.a(i3, inflate);
                if (actionItemView3 != null) {
                    i3 = R$id.sportSwitch;
                    ActionItemView actionItemView4 = (ActionItemView) he.a(i3, inflate);
                    if (actionItemView4 != null) {
                        i3 = R$id.titleView;
                        TitleView titleView = (TitleView) he.a(i3, inflate);
                        if (titleView != null) {
                            return new e1((LinearLayout) inflate, actionItemView, actionItemView2, actionItemView3, actionItemView4, titleView);
                        }
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        ((com.example.test.presenter.mine.p) I0()).k();
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        eh.b bVar = this.f7247z;
        ((e1) bVar.getValue()).f12823f.setOnTitleListener(new o(this, 6));
        ((e1) bVar.getValue()).f12820b.setOnClickListener(this);
    }

    public final void R0(List switchStatus) {
        kotlin.jvm.internal.e.f(switchStatus, "switchStatus");
        if (switchStatus.size() < 3) {
            return;
        }
        Iterator it = switchStatus.iterator();
        while (it.hasNext()) {
            SwitchBean switchBean = (SwitchBean) it.next();
            String paraName = switchBean.getParaName();
            if (paraName != null) {
                int hashCode = paraName.hashCode();
                eh.b bVar = this.f7247z;
                if (hashCode != -547228634) {
                    if (hashCode != -317682401) {
                        if (hashCode == 2071057514 && paraName.equals("isSport")) {
                            ((e1) bVar.getValue()).e.setItemOpen(kotlin.jvm.internal.e.a(switchBean.getParaValue(), "1"));
                        }
                    } else if (paraName.equals("isPerson")) {
                        ((e1) bVar.getValue()).f12822d.setItemOpen(kotlin.jvm.internal.e.a(switchBean.getParaValue(), "1"));
                    }
                } else if (paraName.equals("isHealth")) {
                    ((e1) bVar.getValue()).f12821c.setItemOpen(kotlin.jvm.internal.e.a(switchBean.getParaValue(), "1"));
                }
            }
        }
    }

    public final void S0(int i3, String str) {
        if (i3 == -1) {
            w0(R$string.str_network_error);
            return;
        }
        w0.d().getClass();
        int c9 = w0.c(i3);
        if (c9 != 0) {
            w0(c9);
        } else if (str.length() > 0) {
            com.example.baselibrary.utils.d.b(str);
        } else {
            w0(R$string.str_network_error);
        }
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.clearALLAv;
        if (valueOf != null && valueOf.intValue() == i3) {
            com.example.test.presenter.mine.p pVar = (com.example.test.presenter.mine.p) I0();
            Object obj = (h7.i) pVar.f7255a;
            ((XXBaseActivity) obj).V();
            rg.l<HttpModel<String>> clearData = ((UserApi) c6.d.f3392c.f113a).clearData();
            kotlin.jvm.internal.e.e(clearData, "clearData(...)");
            rg.l w8 = com.example.baselibrary.utils.b.w(clearData);
            PrivacySafeActivity privacySafeActivity = (PrivacySafeActivity) obj;
            privacySafeActivity.getClass();
            w8.subscribe(new com.example.test.presenter.mine.o(pVar, privacySafeActivity, w0.d(), 0));
        }
    }
}
