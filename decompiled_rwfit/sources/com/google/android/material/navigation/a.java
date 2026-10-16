package com.google.android.material.navigation;

import android.content.Context;
import android.view.SubMenu;
import h.k;
import h.m;

/* loaded from: classes.dex */
public final class a extends k {
    public final int A;

    /* renamed from: z, reason: collision with root package name */
    public final Class f10698z;

    public a(Context context, Class cls, int i3) {
        super(context);
        this.f10698z = cls;
        this.A = i3;
    }

    @Override // h.k
    public final m a(int i3, int i10, int i11, CharSequence charSequence) {
        int size = this.f14148f.size() + 1;
        int i12 = this.A;
        if (size <= i12) {
            y();
            m a3 = super.a(i3, i10, i11, charSequence);
            a3.d(true);
            x();
            return a3;
        }
        String simpleName = this.f10698z.getSimpleName();
        StringBuilder sb2 = new StringBuilder("Maximum number of items supported by ");
        sb2.append(simpleName);
        sb2.append(" is ");
        sb2.append(i12);
        sb2.append(". Limit can be checked with ");
        throw new IllegalArgumentException(r5.a.f(sb2, simpleName, "#getMaxItemCount()"));
    }

    @Override // h.k, android.view.Menu
    public final SubMenu addSubMenu(int i3, int i10, int i11, CharSequence charSequence) {
        throw new UnsupportedOperationException(this.f10698z.getSimpleName().concat(" does not support submenus"));
    }
}
