package com.example.test.ui.adapter;

import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.ui.model.dial.FontSelectModel;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;

/* loaded from: classes.dex */
public class TextFontAdapter extends BaseQuickAdapter<FontSelectModel, BaseViewHolder> {

    /* renamed from: a, reason: collision with root package name */
    public Typeface f7841a;

    /* renamed from: b, reason: collision with root package name */
    public Typeface f7842b;

    /* renamed from: c, reason: collision with root package name */
    public Typeface f7843c;

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, FontSelectModel fontSelectModel) {
        FontSelectModel fontSelectModel2 = fontSelectModel;
        View view = baseViewHolder.getView(R$id.background_content);
        if (fontSelectModel2.isSelected()) {
            view.setBackground(pb.b(getContext(), R$drawable.bg_select_rectangle));
        } else {
            view.setBackground(null);
        }
        TextView textView = (TextView) baseViewHolder.getView(R$id.font_view);
        int font = fontSelectModel2.getFont();
        if (font == 109) {
            textView.setTypeface(this.f7841a);
        } else if (font == 110) {
            textView.setTypeface(this.f7843c);
        } else if (font == 111) {
            textView.setTypeface(this.f7842b);
        }
        textView.setTextColor(Color.parseColor(fontSelectModel2.getColor()));
    }
}
