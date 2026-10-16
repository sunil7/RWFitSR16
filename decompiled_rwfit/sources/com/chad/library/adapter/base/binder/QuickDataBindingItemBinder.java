package com.chad.library.adapter.base.binder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.databinding.i;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public abstract class QuickDataBindingItemBinder<T, DB extends i> extends BaseItemBinder<T, BinderDataBindingHolder<DB>> {

    public static final class BinderDataBindingHolder<DB extends i> extends BaseViewHolder {
        private final DB dataBinding;

        public BinderDataBindingHolder(DB dataBinding) {
            e.g(dataBinding, "dataBinding");
            throw null;
        }

        public final DB getDataBinding() {
            return null;
        }
    }

    public abstract DB onCreateDataBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, int i3);

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    public BinderDataBindingHolder<DB> onCreateViewHolder(ViewGroup parent, int i3) {
        e.g(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        e.b(from, "LayoutInflater.from(parent.context)");
        onCreateDataBinding(from, parent, i3);
        return new BinderDataBindingHolder<>(null);
    }
}
