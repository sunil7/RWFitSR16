package com.chad.library.adapter.base.binder;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.e;
import m2.a;

/* loaded from: classes.dex */
public abstract class QuickViewBindingItemBinder<T, VB extends a> extends BaseItemBinder<T, BinderVBHolder<VB>> {

    public static final class BinderVBHolder<VB extends a> extends BaseViewHolder {
        private final VB viewBinding;

        /* JADX WARN: Illegal instructions before constructor call */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public BinderVBHolder(VB r3) {
            /*
                r2 = this;
                java.lang.String r0 = "viewBinding"
                kotlin.jvm.internal.e.g(r3, r0)
                android.view.View r0 = r3.b()
                java.lang.String r1 = "viewBinding.root"
                kotlin.jvm.internal.e.b(r0, r1)
                r2.<init>(r0)
                r2.viewBinding = r3
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.chad.library.adapter.base.binder.QuickViewBindingItemBinder.BinderVBHolder.<init>(m2.a):void");
        }

        public final VB getViewBinding() {
            return this.viewBinding;
        }
    }

    public abstract VB onCreateViewBinding(LayoutInflater layoutInflater, ViewGroup viewGroup, int i3);

    @Override // com.chad.library.adapter.base.binder.BaseItemBinder
    public BinderVBHolder<VB> onCreateViewHolder(ViewGroup parent, int i3) {
        e.g(parent, "parent");
        LayoutInflater from = LayoutInflater.from(parent.getContext());
        e.b(from, "LayoutInflater.from(parent.context)");
        return new BinderVBHolder<>(onCreateViewBinding(from, parent, i3));
    }
}
