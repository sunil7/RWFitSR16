package com.example.test.ui.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$id;

/* loaded from: classes.dex */
public class SelectListAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, String str) {
        baseViewHolder.setText(R$id.selectTv, str);
    }
}
