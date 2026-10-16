package com.example.test.ui.main.fragment;

import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.t0;
import androidx.viewpager.widget.ViewPager;
import com.amap.api.maps.MapsInitializer;
import com.example.baselibrary.base.fragment.BaseFragment;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.view.ToolBarView;
import com.google.android.gms.internal.mlkit_vision_barcode.he;
import com.google.android.material.tabs.TabLayout;
import f6.q3;
import u6.p;

/* loaded from: classes.dex */
public final class o extends BaseFragment<com.example.test.presenter.device.n, q3> implements p5.a {
    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final com.example.baselibrary.preseneter.b I() {
        return new com.example.test.presenter.device.n(this, 9);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final View W() {
        q3 q3Var = (q3) this.f7251b;
        if (q3Var != null) {
            return q3Var.f13263a;
        }
        return null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final Object Z(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R$layout.fragment_sport, viewGroup, false);
        int i3 = R$id.tabs;
        TabLayout tabLayout = (TabLayout) he.a(i3, inflate);
        if (tabLayout != null) {
            i3 = R$id.toolbar;
            ToolBarView toolBarView = (ToolBarView) he.a(i3, inflate);
            if (toolBarView != null) {
                i3 = R$id.vpSport;
                ViewPager viewPager = (ViewPager) he.a(i3, inflate);
                if (viewPager != null) {
                    return new q3((ConstraintLayout) inflate, tabLayout, toolBarView, viewPager);
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(inflate.getResources().getResourceName(i3)));
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void e0() {
    }

    @Override // p5.a
    public final Context f0() {
        throw null;
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void h0() {
        Log.e("qob", "SportFragment initData");
        MapsInitializer.updatePrivacyShow(getContext(), true, true);
        MapsInitializer.updatePrivacyAgree(getContext(), true);
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment
    public final void m0() {
        Log.e("qob", "SportFragment initView");
        Context context = getContext();
        t0 childFragmentManager = getChildFragmentManager();
        kotlin.jvm.internal.e.e(childFragmentManager, "getChildFragmentManager(...)");
        p pVar = new p(context, childFragmentManager);
        q3 q3Var = (q3) this.f7251b;
        ViewPager viewPager = q3Var != null ? q3Var.f13266d : null;
        if (viewPager != null) {
            viewPager.setAdapter(pVar);
        }
        q3 q3Var2 = (q3) this.f7251b;
        if (q3Var2 != null) {
            q3Var2.f13264b.setupWithViewPager(q3Var2 != null ? q3Var2.f13266d : null);
        }
        q3 q3Var3 = (q3) this.f7251b;
        int tabCount = q3Var3 != null ? q3Var3.f13264b.getTabCount() : 0;
        for (int i3 = 0; i3 < tabCount; i3++) {
            q3 q3Var4 = (q3) this.f7251b;
            com.google.android.material.tabs.b g10 = q3Var4 != null ? q3Var4.f13264b.g(i3) : null;
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
        q3 q3Var5 = (q3) this.f7251b;
        if (q3Var5 != null) {
            q3Var5.f13265c.setOnViewChildListener(new n(this, 9));
        }
    }

    @Override // com.example.baselibrary.base.fragment.BaseFragment, androidx.fragment.app.Fragment
    public final void onDestroy() {
        super.onDestroy();
        Log.e("qob", "SportFragment onDestroy");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        super.onDestroyView();
        Log.e("qob", "SportFragment onDestroyView");
    }

    @Override // androidx.fragment.app.Fragment
    public final void onSaveInstanceState(Bundle outState) {
        kotlin.jvm.internal.e.f(outState, "outState");
        super.onSaveInstanceState(outState);
    }
}
