package com.google.android.material.internal;

import android.view.View;
import java.util.WeakHashMap;
import l1.l0;
import l1.z0;

/* loaded from: classes.dex */
public final class y implements View.OnAttachStateChangeListener {
    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewAttachedToWindow(View view) {
        view.removeOnAttachStateChangeListener(this);
        WeakHashMap weakHashMap = z0.f15748a;
        l0.c(view);
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public final void onViewDetachedFromWindow(View view) {
    }
}
