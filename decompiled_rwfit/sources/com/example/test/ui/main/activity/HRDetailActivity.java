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
import com.example.test.ui.device.activity.f0;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.material.tabs.TabLayout;
import f6.l0;
import kotlin.jvm.internal.e;
import p5.a;
import r6.f;

/* loaded from: classes.dex */
public final class HRDetailActivity extends XXBaseActivity<n, l0> implements a {
    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final b G0() {
        return new n(this, 12);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((l0) this.f7247z.getValue()).f13082a;
        e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_hr_detail, (ViewGroup) null, false);
        int i3 = R$id.statisticsPager;
        ViewPager viewPager = (ViewPager) he.a(i3, inflate);
        if (viewPager != null) {
            i3 = R$id.tabs;
            TabLayout tabLayout = (TabLayout) he.a(i3, inflate);
            if (tabLayout != null) {
                i3 = R$id.titleView;
                TitleView titleView = (TitleView) he.a(i3, inflate);
                if (titleView != null) {
                    return new l0((LinearLayout) inflate, viewPager, tabLayout, titleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        u0 C0 = C0();
        e.e(C0, "getSupportFragmentManager(...)");
        f fVar = new f(this, C0, 6);
        eh.b bVar = this.f7247z;
        ((l0) bVar.getValue()).f13083b.setAdapter(fVar);
        ((l0) bVar.getValue()).f13083b.setOffscreenPageLimit(4);
        ((l0) bVar.getValue()).f13084c.setupWithViewPager(((l0) bVar.getValue()).f13083b);
        int tabCount = ((l0) bVar.getValue()).f13084c.getTabCount();
        for (int i3 = 0; i3 < tabCount; i3++) {
            com.google.android.material.tabs.b g10 = ((l0) bVar.getValue()).f13084c.g(i3);
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
        ((l0) this.f7247z.getValue()).f13085d.setOnTitleListener(new f0(this, 3));
    }
}
