package com.google.android.material.tabs;

import android.view.View;
import com.google.android.material.tabs.TabLayout;

/* loaded from: classes.dex */
public final class c implements View.OnLayoutChangeListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f10822a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ TabLayout.TabView f10823b;

    public c(TabLayout.TabView tabView, View view) {
        this.f10823b = tabView;
        this.f10822a = view;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        View view2 = this.f10822a;
        if (view2.getVisibility() == 0) {
            int i17 = TabLayout.TabView.f10805l;
            this.f10823b.c(view2);
        }
    }
}
