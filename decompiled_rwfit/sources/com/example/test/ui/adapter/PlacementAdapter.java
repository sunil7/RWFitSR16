package com.example.test.ui.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.i;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.baselibrary.utils.b;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.ui.model.dial.PlacementSelectModel;
import com.google.android.gms.internal.mlkit_vision_barcode.e2;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import g4.v;
import kotlin.jvm.internal.e;
import z3.h;

/* loaded from: classes.dex */
public class PlacementAdapter extends BaseQuickAdapter<PlacementSelectModel, BaseViewHolder> {
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, PlacementSelectModel placementSelectModel) {
        PlacementSelectModel placementSelectModel2 = placementSelectModel;
        ImageView imageView = (ImageView) baseViewHolder.getView(R$id.content_view);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R$id.round_content_view);
        Bitmap a3 = e2.a(getContext(), placementSelectModel2);
        if (a3 != null) {
            int dialType = placementSelectModel2.getDialType();
            h hVar = h.f20239b;
            if (dialType == 0) {
                imageView.setVisibility(0);
                imageView2.setVisibility(8);
                Context context = getContext();
                int f2 = b.f(getContext(), 8.0f);
                e.f(context, "context");
                ((i) ((i) ((i) ((i) com.bumptech.glide.b.c(context).l(a3).o(true)).d(hVar)).i(R$drawable.bg_dial_item)).a(p4.e.t(new v(f2))).e(R$drawable.bg_dial_item)).x(imageView);
            } else {
                imageView.setVisibility(8);
                imageView2.setVisibility(0);
                Context context2 = getContext();
                e.f(context2, "context");
                ((i) ((i) ((i) ((i) com.bumptech.glide.b.c(context2).l(a3).o(true)).d(hVar)).i(R$drawable.bg_img)).a(p4.e.t(new g4.i())).e(R$drawable.bg_img)).x(imageView2);
            }
        }
        ConstraintLayout constraintLayout = (ConstraintLayout) baseViewHolder.getView(R$id.background_content);
        if (!placementSelectModel2.isSelected()) {
            constraintLayout.setBackground(null);
        } else if (placementSelectModel2.getDialType() == 0) {
            constraintLayout.setBackground(pb.b(getContext(), R$drawable.bg_select_rectangle));
        } else {
            constraintLayout.setBackground(pb.b(getContext(), R$drawable.bg_select_circle));
        }
    }
}
