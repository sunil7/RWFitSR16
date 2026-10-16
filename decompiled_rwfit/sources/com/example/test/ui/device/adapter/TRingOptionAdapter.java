package com.example.test.ui.device.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$id;
import com.example.test.ui.device.model.OptionModel;

/* loaded from: classes.dex */
public class TRingOptionAdapter extends BaseQuickAdapter<OptionModel, BaseViewHolder> {
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, OptionModel optionModel) {
        OptionModel optionModel2 = optionModel;
        baseViewHolder.setText(R$id.tv_option, optionModel2.getOptionStr());
        baseViewHolder.setVisible(R$id.iv_check, optionModel2.isCheck());
    }
}
