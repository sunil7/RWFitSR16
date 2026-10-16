package com.example.test.ui.device.adapter;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.ui.device.model.DialModel;
import com.example.test.ui.view.DialItemView;
import java.util.List;

/* loaded from: classes.dex */
public class DialListAdapter extends BaseQuickAdapter<DialModel, BaseViewHolder> {
    public DialListAdapter(List list) {
        super(R$layout.item_dial, list);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, DialModel dialModel) {
        String previewUrl;
        String name;
        DialModel dialModel2 = dialModel;
        DialItemView dialItemView = (DialItemView) baseViewHolder.getView(R$id.dial);
        if (dialModel2 == null || dialModel2.getDialInfoBean() == null) {
            return;
        }
        dialItemView.setData(dialModel2);
        dialItemView.a(dialModel2.getDialInfoBean());
        if (dialModel2.getDialBean() == null || (previewUrl = dialModel2.getDialBean().getPreviewUrl()) == null || previewUrl.length() == 0 || "null".equalsIgnoreCase(previewUrl) || (name = dialModel2.getDialBean().getName()) == null || name.length() == 0 || "null".equalsIgnoreCase(name)) {
            return;
        }
        dialItemView.b(dialModel2.getDialBean().getPreviewUrl(), dialModel2.getDialBean().getName());
    }
}
