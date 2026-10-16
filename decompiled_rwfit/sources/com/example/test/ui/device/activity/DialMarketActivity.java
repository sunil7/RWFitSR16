package com.example.test.ui.device.activity;

import android.os.Build;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.u0;
import androidx.viewpager.widget.ViewPager;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.XXBaseActivity;
import com.example.test.ui.view.TitleView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class DialMarketActivity extends XXBaseActivity<com.example.test.presenter.device.n, f6.z> implements p5.a {
    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final com.example.baselibrary.preseneter.b G0() {
        return new com.example.test.presenter.device.n(this, 1);
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final View H0() {
        LinearLayout linearLayout = ((f6.z) this.f7247z.getValue()).f13473a;
        kotlin.jvm.internal.e.e(linearLayout, "getRoot(...)");
        return linearLayout;
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final Object J0() {
        View inflate = getLayoutInflater().inflate(R$layout.activity_dial_market, (ViewGroup) null, false);
        int i3 = R$id.dialMarket;
        ViewPager viewPager = (ViewPager) he.a(i3, inflate);
        if (viewPager != null) {
            i3 = R$id.tabs;
            TabLayout tabLayout = (TabLayout) he.a(i3, inflate);
            if (tabLayout != null) {
                i3 = R$id.titleView;
                TitleView titleView = (TitleView) he.a(i3, inflate);
                if (titleView != null) {
                    return new f6.z((LinearLayout) inflate, viewPager, tabLayout, titleView);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.activity.BaseActivity
    public final void K0() {
        u0 C0 = C0();
        kotlin.jvm.internal.e.e(C0, "getSupportFragmentManager(...)");
        r6.f fVar = new r6.f(this, C0, 0);
        eh.b bVar = this.f7247z;
        ((f6.z) bVar.getValue()).f13474b.setAdapter(fVar);
        ((f6.z) bVar.getValue()).f13475c.setupWithViewPager(((f6.z) bVar.getValue()).f13474b);
        int tabCount = ((f6.z) bVar.getValue()).f13475c.getTabCount();
        for (int i3 = 0; i3 < tabCount; i3++) {
            com.google.android.material.tabs.b g10 = ((f6.z) bVar.getValue()).f13475c.g(i3);
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
        ((f6.z) this.f7247z.getValue()).f13476d.setOnTitleListener(new androidx.appcompat.app.t(this, 17));
    }
}
