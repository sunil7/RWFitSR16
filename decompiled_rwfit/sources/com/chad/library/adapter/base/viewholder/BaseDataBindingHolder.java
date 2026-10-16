package com.chad.library.adapter.base.viewholder;

import android.view.View;
import androidx.databinding.d;
import androidx.databinding.i;
import androidx.databinding.library.R$id;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public class BaseDataBindingHolder<BD extends i> extends BaseViewHolder {
    private final BD dataBinding;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BaseDataBindingHolder(View view) {
        super(view);
        e.g(view, "view");
        int i3 = d.f1985a;
        int i10 = i.f1992a;
        if (view.getTag(R$id.dataBinding) != null) {
            throw new ClassCastException();
        }
        if (!(view.getTag() instanceof String)) {
            throw new IllegalArgumentException("View is not a binding layout");
        }
        throw null;
    }

    public final BD getDataBinding() {
        return null;
    }
}
