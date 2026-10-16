package com.chad.library.adapter.base.loadmore;

import android.view.View;
import android.view.ViewGroup;
import com.chad.library.R$id;
import com.chad.library.R$layout;
import com.chad.library.adapter.base.util.AdapterUtilsKt;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class SimpleLoadMoreView extends BaseLoadMoreView {
    @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
    public View getLoadComplete(BaseViewHolder holder) {
        e.g(holder, "holder");
        return holder.getView(R$id.load_more_load_complete_view);
    }

    @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
    public View getLoadEndView(BaseViewHolder holder) {
        e.g(holder, "holder");
        return holder.getView(R$id.load_more_load_end_view);
    }

    @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
    public View getLoadFailView(BaseViewHolder holder) {
        e.g(holder, "holder");
        return holder.getView(R$id.load_more_load_fail_view);
    }

    @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
    public View getLoadingView(BaseViewHolder holder) {
        e.g(holder, "holder");
        return holder.getView(R$id.load_more_loading_view);
    }

    @Override // com.chad.library.adapter.base.loadmore.BaseLoadMoreView
    public View getRootView(ViewGroup parent) {
        e.g(parent, "parent");
        return AdapterUtilsKt.getItemView(parent, R$layout.brvah_quick_view_load_more);
    }
}
