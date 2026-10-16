package com.example.test.ui.device.adapter;

import android.graphics.Color;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.ui.device.model.ColorSelectModel;
import com.example.test.ui.view.PointView;

/* loaded from: classes.dex */
public class ColorAdapter extends BaseQuickAdapter<ColorSelectModel, BaseViewHolder> {
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, ColorSelectModel colorSelectModel) {
        ColorSelectModel colorSelectModel2 = colorSelectModel;
        ((PointView) baseViewHolder.getView(R$id.color_view)).setPointColor(Color.parseColor(colorSelectModel2.getColor()));
        View view = baseViewHolder.getView(R$id.content);
        if (colorSelectModel2.isSelected()) {
            view.setBackground(getContext().getDrawable(R$drawable.bg_select_circle));
        } else {
            view.setBackground(null);
        }
    }
}
