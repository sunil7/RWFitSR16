package com.chad.library.adapter.base.binder;

import android.view.ViewGroup;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public abstract class QuickItemBinder<T> extends BaseItemBinder<T, BaseViewHolder> {
    public abstract int getLayoutId();

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int i3) {
        e.g(parent, "parent");
        return new BaseViewHolder(AdapterUtilsKt.getItemView(parent, getLayoutId()));
    }
}
