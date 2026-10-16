package com.google.android.material.textfield;

import android.widget.AutoCompleteTextView;

/* loaded from: classes.dex */
public final class k implements AutoCompleteTextView.OnDismissListener {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ l f10908a;

    public k(l lVar) {
        this.f10908a = lVar;
    }

    @Override // android.widget.AutoCompleteTextView.OnDismissListener
    public final void onDismiss() {
        l lVar = this.f10908a;
        lVar.f10913i = true;
        lVar.f10915k = System.currentTimeMillis();
        lVar.g(false);
    }
}
