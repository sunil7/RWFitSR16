package com.example.test.ui.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.i;
import com.bumptech.glide.j;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.viewholder.BaseViewHolder;
import com.example.baselibrary.utils.b;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.ui.model.dial.BackgroundSelectModel;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import g4.m;
import g4.v;
import kotlin.jvm.internal.e;
import z3.h;

/* loaded from: classes.dex */
public class BackgroundAdapter extends BaseQuickAdapter<BackgroundSelectModel, BaseViewHolder> {
    @Override // com.chad.library.adapter.base.BaseQuickAdapter
    public final void convert(BaseViewHolder baseViewHolder, BackgroundSelectModel backgroundSelectModel) {
        BackgroundSelectModel backgroundSelectModel2 = backgroundSelectModel;
        ImageView imageView = (ImageView) baseViewHolder.getView(R$id.background_view);
        LinearLayout linearLayout = (LinearLayout) baseViewHolder.getView(R$id.default_add);
        ImageView imageView2 = (ImageView) baseViewHolder.getView(R$id.round_background_view);
        LinearLayout linearLayout2 = (LinearLayout) baseViewHolder.getView(R$id.default_add_round);
        int resId = backgroundSelectModel2.getResId();
        h hVar = h.f20239b;
        if (resId != 0) {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
            if (backgroundSelectModel2.getDialType() == 0) {
                imageView.setVisibility(0);
                imageView2.setVisibility(8);
                Context context = getContext();
                int resId2 = backgroundSelectModel2.getResId();
                int f2 = b.f(getContext(), 8.0f);
                e.f(context, "context");
                ((i) ((i) ((i) ((i) com.bumptech.glide.b.c(context).m(Integer.valueOf(resId2)).o(true)).d(hVar)).i(R$drawable.bg_dial_item)).a(p4.e.t(new v(f2))).e(R$drawable.bg_dial_item)).x(imageView);
            } else {
                imageView.setVisibility(8);
                imageView2.setVisibility(0);
                Context context2 = getContext();
                int resId3 = backgroundSelectModel2.getResId();
                e.f(context2, "context");
                ((i) ((i) ((i) ((i) com.bumptech.glide.b.c(context2).m(Integer.valueOf(resId3)).o(true)).d(hVar)).i(R$drawable.bg_img)).a(p4.e.t(new g4.i())).e(R$drawable.bg_img)).x(imageView2);
            }
        } else if (TextUtils.isEmpty(backgroundSelectModel2.getUrl())) {
            imageView.setVisibility(8);
            imageView2.setVisibility(8);
            if (backgroundSelectModel2.getDialType() == 0) {
                linearLayout.setVisibility(0);
                linearLayout2.setVisibility(8);
            } else {
                linearLayout.setVisibility(8);
                linearLayout2.setVisibility(0);
            }
            j c9 = com.bumptech.glide.b.c(getContext());
            i a3 = c9.j(Drawable.class).z(pb.b(getContext(), R$drawable.baseline_add)).a((p4.e) new p4.e().d(hVar));
            a3.getClass();
            ((i) a3.k(m.f13829c, new g4.h(), true)).x(imageView);
        } else {
            linearLayout.setVisibility(8);
            linearLayout2.setVisibility(8);
            if (backgroundSelectModel2.getDialType() == 0) {
                imageView.setVisibility(0);
                imageView2.setVisibility(8);
                Context context3 = getContext();
                String url = backgroundSelectModel2.getUrl();
                int f10 = b.f(getContext(), 8.0f);
                e.f(context3, "context");
                e.f(url, "url");
                ((i) ((i) ((i) ((i) com.bumptech.glide.b.c(context3).n(url).o(true)).d(hVar)).i(R$drawable.bg_dial_item)).a(p4.e.t(new v(f10))).e(R$drawable.bg_dial_item)).x(imageView);
            } else {
                imageView.setVisibility(8);
                imageView2.setVisibility(0);
                Context context4 = getContext();
                String url2 = backgroundSelectModel2.getUrl();
                e.f(context4, "context");
                e.f(url2, "url");
                ((i) ((i) ((i) ((i) com.bumptech.glide.b.c(context4).n(url2).o(true)).d(hVar)).i(R$drawable.bg_img)).a(p4.e.t(new g4.i())).e(R$drawable.bg_img)).x(imageView2);
            }
        }
        View view = baseViewHolder.getView(R$id.background_content);
        if (!backgroundSelectModel2.isSelected()) {
            view.setBackground(null);
        } else if (backgroundSelectModel2.getDialType() == 0) {
            view.setBackground(pb.b(getContext(), R$drawable.bg_select_rectangle));
        } else {
            view.setBackground(pb.b(getContext(), R$drawable.bg_select_circle));
        }
    }
}
