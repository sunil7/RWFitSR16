package com.chad.library.adapter.base;

import android.view.ViewGroup;
import com.chad.library.adapter.base.delegate.BaseMultiTypeDelegate;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import java.util.List;
import kotlin.jvm.internal.c;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public abstract class BaseDelegateMultiAdapter<T, VH extends BaseViewHolder> extends BaseQuickAdapter<T, VH> {
    private BaseMultiTypeDelegate<T> mMultiTypeDelegate;

    /* JADX WARN: Multi-variable type inference failed */
    public BaseDelegateMultiAdapter() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public int getDefItemViewType(int i3) {
        BaseMultiTypeDelegate<T> multiTypeDelegate = getMultiTypeDelegate();
        if (multiTypeDelegate != null) {
            return multiTypeDelegate.getItemType(getData(), i3);
        }
        throw new IllegalStateException("Please use setMultiTypeDelegate first!");
    }

    public final BaseMultiTypeDelegate<T> getMultiTypeDelegate() {
        return this.mMultiTypeDelegate;
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public VH onCreateDefViewHolder(ViewGroup parent, int i3) {
        e.g(parent, "parent");
        BaseMultiTypeDelegate<T> multiTypeDelegate = getMultiTypeDelegate();
        if (multiTypeDelegate != null) {
            return createBaseViewHolder(parent, multiTypeDelegate.getLayoutId(i3));
        }
        throw new IllegalStateException("Please use setMultiTypeDelegate first!");
    }

    public final void setMultiTypeDelegate(BaseMultiTypeDelegate<T> multiTypeDelegate) {
        e.g(multiTypeDelegate, "multiTypeDelegate");
        this.mMultiTypeDelegate = multiTypeDelegate;
    }

    public /* synthetic */ BaseDelegateMultiAdapter(List list, int i3, c cVar) {
        this((i3 & 1) != 0 ? null : list);
    }

    public BaseDelegateMultiAdapter(List<T> list) {
        super(0, list);
    }
}
