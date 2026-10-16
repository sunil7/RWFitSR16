package com.google.android.material.appbar;

import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import m1.o;

/* loaded from: classes.dex */
public final class b implements o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CoordinatorLayout f10218a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f10219b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ View f10220c;

    /* renamed from: d, reason: collision with root package name */
    public final /* synthetic */ int f10221d;
    public final /* synthetic */ AppBarLayout.BaseBehavior e;

    public b(AppBarLayout.BaseBehavior baseBehavior, CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, View view, int i3) {
        this.e = baseBehavior;
        this.f10218a = coordinatorLayout;
        this.f10219b = appBarLayout;
        this.f10220c = view;
        this.f10221d = i3;
    }

    @Override // m1.o
    public final boolean g(View view) {
        View view2 = this.f10220c;
        int i3 = this.f10221d;
        this.e.y(this.f10218a, this.f10219b, view2, i3, new int[]{0, 0});
        return true;
    }
}
