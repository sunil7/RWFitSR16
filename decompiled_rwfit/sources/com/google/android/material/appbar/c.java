package com.google.android.material.appbar;

import android.view.View;
import m1.o;

/* loaded from: classes.dex */
public final class c implements o {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ AppBarLayout f10222a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ boolean f10223b;

    public c(AppBarLayout appBarLayout, boolean z5) {
        this.f10222a = appBarLayout;
        this.f10223b = z5;
    }

    @Override // m1.o
    public final boolean g(View view) {
        this.f10222a.setExpanded(this.f10223b);
        return true;
    }
}
