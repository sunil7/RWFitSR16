package com.google.android.material.bottomappbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

/* loaded from: classes.dex */
public final class c extends wa.g {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f10251a;

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ BottomAppBar f10252b;

    public c(BottomAppBar bottomAppBar, int i3) {
        this.f10252b = bottomAppBar;
        this.f10251a = i3;
    }

    @Override // wa.g
    public final void a(FloatingActionButton floatingActionButton) {
        int i3 = BottomAppBar.V0;
        floatingActionButton.setTranslationX(this.f10252b.B(this.f10251a));
        floatingActionButton.show(new b(this));
    }
}
