package com.chad.library.adapter.base.diff;

import androidx.recyclerview.widget.s0;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.module.BaseLoadMoreModule;
import kotlin.jvm.internal.e;

/* loaded from: classes.dex */
public final class BrvahListUpdateCallback implements s0 {
    private final BaseQuickAdapter<?, ?> mAdapter;

    public BrvahListUpdateCallback(BaseQuickAdapter<?, ?> mAdapter) {
        e.g(mAdapter, "mAdapter");
        this.mAdapter = mAdapter;
    }

    @Override // androidx.recyclerview.widget.s0
    public void onChanged(int i3, int i10, Object obj) {
        BaseQuickAdapter<?, ?> baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemRangeChanged(baseQuickAdapter.getHeaderLayoutCount() + i3, i10, obj);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onInserted(int i3, int i10) {
        BaseQuickAdapter<?, ?> baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemRangeInserted(baseQuickAdapter.getHeaderLayoutCount() + i3, i10);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onMoved(int i3, int i10) {
        BaseQuickAdapter<?, ?> baseQuickAdapter = this.mAdapter;
        baseQuickAdapter.notifyItemMoved(baseQuickAdapter.getHeaderLayoutCount() + i3, this.mAdapter.getHeaderLayoutCount() + i10);
    }

    @Override // androidx.recyclerview.widget.s0
    public void onRemoved(int i3, int i10) {
        BaseLoadMoreModule mLoadMoreModule$com_github_CymChad_brvah = this.mAdapter.getMLoadMoreModule$com_github_CymChad_brvah();
        if (mLoadMoreModule$com_github_CymChad_brvah != null && mLoadMoreModule$com_github_CymChad_brvah.hasLoadMoreView() && this.mAdapter.getItemCount() == 0) {
            BaseQuickAdapter<?, ?> baseQuickAdapter = this.mAdapter;
            baseQuickAdapter.notifyItemRangeRemoved(baseQuickAdapter.getHeaderLayoutCount() + i3, i10 + 1);
        } else {
            BaseQuickAdapter<?, ?> baseQuickAdapter2 = this.mAdapter;
            baseQuickAdapter2.notifyItemRangeRemoved(baseQuickAdapter2.getHeaderLayoutCount() + i3, i10);
        }
    }
}
