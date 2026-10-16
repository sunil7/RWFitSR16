package com.example.test.ui.mine.adapter;

import android.content.Context;
import android.widget.ImageView;
import com.bumptech.glide.b;
import com.bumptech.glide.i;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import java.util.List;
import kotlin.jvm.internal.e;
import z3.h;

/* loaded from: classes.dex */
public final class ImagePickAdapter extends BaseQuickAdapter<String, BaseViewHolder> {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ImagePickAdapter(List data) {
        super(R$layout.item_img_select, data);
        e.f(data, "data");
    }

    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder holder, String str) {
        String item = str;
        e.f(holder, "holder");
        e.f(item, "item");
        ImageView imageView = (ImageView) holder.getView(R$id.imgIv);
        ImageView imageView2 = (ImageView) holder.getView(R$id.clearIv);
        if (item.length() == 0) {
            imageView.setImageResource(R$mipmap.ic_add);
            imageView2.setVisibility(8);
            return;
        }
        Context context = getContext();
        e.f(context, "context");
        e.f(imageView, "imageView");
        ((i) ((i) ((i) ((i) b.c(context).n(item).o(true)).d(h.f20239b)).i(R$drawable.bg_dial_item)).e(R$drawable.bg_dial_item)).x(imageView);
        imageView2.setVisibility(0);
    }
}
