package com.example.test.ui.main.activity;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.u0;
import androidx.viewpager.widget.ViewPager;
import com.example.baselibrary.preseneter.b;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.presenter.device.n;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.device.activity.i0;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.material.tabs.TabLayout;
import f6.q;
import kotlin.jvm.internal.e;
import p5.a;
import r6.f;

/* loaded from: classes.dex */
public final class BTDetailActivity extends XXBaseActivity<n, q> implements a {
    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final b G0() {
        return new n(this, 12);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((q) this.f7247z.getValue()).f13245a;
        e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_bt_detail, (ViewGroup) null, false);
        int i3 = R$id.statisticsPager;
        ViewPager viewPager = (ViewPager) he.a(i3, inflate);
        if (viewPager != null) {
            i3 = R$id.tabs;
            TabLayout tabLayout = (TabLayout) he.a(i3, inflate);
            if (tabLayout != null) {
                i3 = R$id.titleView;
                TitleView titleView = (TitleView) he.a(i3, inflate);
                if (titleView != null) {
                    return new q((LinearLayout) inflate, viewPager, tabLayout, titleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        u0 C0 = C0();
        e.e(C0, "getSupportFragmentManager(...)");
        f fVar = new f(this, C0, 4);
        eh.b bVar = this.f7247z;
        ((q) bVar.getValue()).f13246b.setAdapter(fVar);
        ((q) bVar.getValue()).f13246b.setOffscreenPageLimit(4);
        ((q) bVar.getValue()).f13247c.setupWithViewPager(((q) bVar.getValue()).f13246b);
        int tabCount = ((q) bVar.getValue()).f13247c.getTabCount();
        for (int i3 = 0; i3 < tabCount; i3++) {
            com.google.android.material.tabs.b g10 = ((q) bVar.getValue()).f13247c.g(i3);
            TabLayout.TabView tabView = g10 != null ? g10.f10821g : null;
            if (tabView != null) {
                tabView.setLongClickable(false);
            }
            if (Build.VERSION.SDK_INT > 26) {
                TabLayout.TabView tabView2 = g10 != null ? g10.f10821g : null;
                if (tabView2 != null) {
                    tabView2.setTooltipText("");
                }
            }
        }
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void M0() {
        ((q) this.f7247z.getValue()).f13248d.setOnTitleListener(new i0(this, 4));
    }
}
