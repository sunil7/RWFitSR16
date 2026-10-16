package com.example.test.ui.adapter;

import android.support.v4.media.session.e;
import android.widget.ImageView;
import android.widget.TextView;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.baselibrary.utils.b;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.ui.model.TRingBpModel;
import com.example.test.ui.model.TRingHealthItemModel;
import com.google.android.gms.internal.mlkit_vision_barcode.ca;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

/* loaded from: classes.dex */
public class TRingHealthDetailAdapter extends BaseQuickAdapter<TRingHealthItemModel, BaseViewHolder> {
    public TRingHealthDetailAdapter(ArrayList arrayList) {
        super(R$layout.item_ring_healthdetail, arrayList);
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, TRingHealthItemModel tRingHealthItemModel) {
        String str;
        TRingHealthItemModel tRingHealthItemModel2 = tRingHealthItemModel;
        ImageView imageView = (ImageView) baseViewHolder.getView(R$id.iv_item_healthtype);
        TextView textView = (TextView) baseViewHolder.getView(R$id.tv_item_healthvalue);
        TextView textView2 = (TextView) baseViewHolder.getView(R$id.tv_item_healthtime);
        if (tRingHealthItemModel2.getHealthType() == 0) {
            imageView.setImageDrawable(getContext().getDrawable(R$mipmap.ring_detail_hr_icon));
            textView.setText(tRingHealthItemModel2.getHealthValue() + " BPM");
        } else if (tRingHealthItemModel2.getHealthType() == 2) {
            imageView.setImageDrawable(getContext().getDrawable(R$mipmap.ring_detail_hr_icon));
            textView.setText(tRingHealthItemModel2.getHealthValue() + " ms");
        } else if (tRingHealthItemModel2.getHealthType() == 3) {
            imageView.setImageDrawable(getContext().getDrawable(R$mipmap.ring_real_stress));
            textView.setText(tRingHealthItemModel2.getHealthValue() + " " + ca.k(getContext(), tRingHealthItemModel2.getHealthValue()));
        } else if (tRingHealthItemModel2.getHealthType() == 4) {
            imageView.setImageDrawable(getContext().getDrawable(R$mipmap.ic_bloodsugar));
            textView.setText(String.format("%.1f", Double.valueOf(tRingHealthItemModel2.getHealthValue() / 10.0d)).concat(" mmol/L"));
        } else if (tRingHealthItemModel2.getHealthType() == 5) {
            imageView.setImageDrawable(getContext().getDrawable(R$mipmap.ic_bloodpressure));
            TRingBpModel tRingBpModel = (TRingBpModel) tRingHealthItemModel2;
            textView.setText(tRingBpModel.getSp() + "/" + tRingBpModel.getDp() + "mmHg");
        } else {
            imageView.setImageDrawable(getContext().getDrawable(R$mipmap.ring_detail_spo2_icon));
            textView.setText(tRingHealthItemModel2.getHealthValue() + " %");
        }
        long healthTime = tRingHealthItemModel2.getHealthTime() * 1000;
        try {
            str = new SimpleDateFormat("HH:mm", Locale.ENGLISH).format(Long.valueOf(healthTime));
        } catch (Exception e) {
            b.o(b.f7264b, e.h(healthTime, " getTimeStr translate error ", e.getMessage()));
            str = null;
        }
        textView2.setText(str);
    }
}
