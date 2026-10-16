package com.chad.library.adapter.base.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class AdapterUtilsKt {
    public static final View getItemView(ViewGroup getItemView, int i3) {
        e.g(getItemView, "$this$getItemView");
        View inflate = LayoutInflater.from(getItemView.getContext()).inflate(i3, getItemView, false);
        e.b(inflate, "LayoutInflater.from(this…layoutResId, this, false)");
        return inflate;
    }
}
