package com.example.test.ui.adapter;

import android.graphics.Color;
import android.view.View;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.ui.model.dial.ColorSelectModel;
import com.example.test.ui.view.PointView;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;

/* loaded from: classes.dex */
public class TextColourAdapter extends BaseQuickAdapter<ColorSelectModel, BaseViewHolder> {
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, ColorSelectModel colorSelectModel) {
        ColorSelectModel colorSelectModel2 = colorSelectModel;
        ((PointView) baseViewHolder.getView(R$id.color_view)).setPointColor(Color.parseColor(colorSelectModel2.getColor()));
        View view = baseViewHolder.getView(R$id.content);
        if (colorSelectModel2.isSelected()) {
            view.setBackground(pb.b(getContext(), R$drawable.bg_select_circle));
        } else {
            view.setBackground(null);
        }
    }
}
