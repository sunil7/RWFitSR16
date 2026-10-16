package com.google.android.material.internal;

import android.view.SubMenu;

/* loaded from: classes.dex */
public final class d extends h.k {
    @Override // h.k, android.view.Menu
    public final SubMenu addSubMenu(int i3, int i10, int i11, CharSequence charSequence) {
        h.m a3 = a(i3, i10, i11, charSequence);
        o oVar = new o(this.f14144a, this, a3);
        a3.f14182o = oVar;
        oVar.setHeaderTitle(a3.e);
        return oVar;
    }
}
