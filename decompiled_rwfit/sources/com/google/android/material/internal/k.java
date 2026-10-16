package com.google.android.material.internal;

import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import androidx.recyclerview.widget.b2;

/* loaded from: classes.dex */
public final class k extends b2 {

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ n f10599f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k(n nVar, NavigationMenuView navigationMenuView) {
        super(navigationMenuView);
        this.f10599f = nVar;
    }

    @Override // androidx.recyclerview.widget.b2, l1.c
    public final void d(View view, m1.d dVar) {
        super.d(view, dVar);
        n nVar = this.f10599f.e.f10594d;
        int i3 = nVar.f10601b.getChildCount() == 0 ? 0 : 1;
        for (int i10 = 0; i10 < nVar.e.f10591a.size(); i10++) {
            if (nVar.e.getItemViewType(i10) == 0) {
                i3++;
            }
        }
        dVar.f15938a.setCollectionInfo(AccessibilityNodeInfo.CollectionInfo.obtain(i3, 0, false));
    }
}
