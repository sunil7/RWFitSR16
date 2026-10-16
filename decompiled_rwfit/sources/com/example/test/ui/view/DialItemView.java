package com.example.test.ui.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.blesdk.bean.function.DialInfoBean;
import com.example.test.R$drawable;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.device.activity.DialDetailActivity;
import com.example.test.ui.device.model.DialModel;

/* loaded from: classes.dex */
public final class DialItemView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public DialModel f8401a;

    /* renamed from: b, reason: collision with root package name */
    public int f8402b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f8403c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f8404d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DialItemView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final void a(DialInfoBean dialInfoBean) {
        kotlin.jvm.internal.e.f(dialInfoBean, "dialInfoBean");
        if (dialInfoBean.getWidth() > 0 || dialInfoBean.getHeight() > 0) {
            this.f8402b = dialInfoBean.getDialType();
            int f2 = com.example.baselibrary.utils.b.f(getContext(), 80.0f);
            ImageView imageView = this.f8403c;
            if (imageView == null) {
                kotlin.jvm.internal.e.m("dialViewIv");
                throw null;
            }
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.width = f2;
            if (this.f8402b == 0) {
                int height = (int) ((dialInfoBean.getHeight() * f2) / dialInfoBean.getWidth());
                StringBuilder sb2 = new StringBuilder("measureWidth:");
                sb2.append(f2);
                sb2.append(",measureHeight");
                sb2.append(height);
                layoutParams.height = height;
                ImageView imageView2 = this.f8403c;
                if (imageView2 == null) {
                    kotlin.jvm.internal.e.m("dialViewIv");
                    throw null;
                }
                imageView2.setImageResource(R$drawable.bg_dial_item);
            } else {
                layoutParams.height = f2;
                ImageView imageView3 = this.f8403c;
                if (imageView3 == null) {
                    kotlin.jvm.internal.e.m("dialViewIv");
                    throw null;
                }
                imageView3.setImageResource(R$drawable.bg_img);
            }
            ImageView imageView4 = this.f8403c;
            if (imageView4 != null) {
                imageView4.setLayoutParams(layoutParams);
            } else {
                kotlin.jvm.internal.e.m("dialViewIv");
                throw null;
            }
        }
    }

    public final void b(String dialRes, String dialName) {
        kotlin.jvm.internal.e.f(dialRes, "dialRes");
        kotlin.jvm.internal.e.f(dialName, "dialName");
        int i3 = this.f8402b;
        z3.h hVar = z3.h.f20239b;
        if (i3 == 1) {
            Context context = getContext();
            kotlin.jvm.internal.e.e(context, "getContext(...)");
            ImageView imageView = this.f8403c;
            if (imageView == null) {
                kotlin.jvm.internal.e.m("dialViewIv");
                throw null;
            }
            ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(context).n(dialRes).o(true)).d(hVar)).i(R$drawable.bg_img)).a(p4.e.t(new g4.i())).e(R$drawable.bg_img)).x(imageView);
        } else {
            Context context2 = getContext();
            kotlin.jvm.internal.e.e(context2, "getContext(...)");
            ImageView imageView2 = this.f8403c;
            if (imageView2 == null) {
                kotlin.jvm.internal.e.m("dialViewIv");
                throw null;
            }
            ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) ((com.bumptech.glide.i) com.bumptech.glide.b.c(context2).n(dialRes).o(true)).d(hVar)).i(R$drawable.bg_dial_item)).e(R$drawable.bg_dial_item)).x(imageView2);
        }
        TextView textView = this.f8404d;
        if (textView != null) {
            textView.setText(dialName);
        } else {
            kotlin.jvm.internal.e.m("dialNameTv");
            throw null;
        }
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.dialView;
        if (valueOf != null && valueOf.intValue() == i3) {
            if (!com.example.test.service.e.h().i()) {
                com.example.baselibrary.utils.d.a(R$string.str_device_disconnected);
                return;
            }
            DialModel dialModel = this.f8401a;
            if (dialModel != null) {
                int i10 = DialDetailActivity.K;
                Context context = getContext();
                kotlin.jvm.internal.e.e(context, "getContext(...)");
                Intent intent = new Intent(context, (Class<?>) DialDetailActivity.class);
                intent.putExtra("dial_data", dialModel);
                context.startActivity(intent);
            }
        }
    }

    public final void setData(DialModel dialModel) {
        this.f8401a = dialModel;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DialItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ DialItemView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_dial, this);
        View findViewById = findViewById(R$id.dialView);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8403c = (ImageView) findViewById;
        View findViewById2 = findViewById(R$id.dialNameTv);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8404d = (TextView) findViewById2;
        ImageView imageView = this.f8403c;
        if (imageView != null) {
            imageView.setOnClickListener(this);
        } else {
            kotlin.jvm.internal.e.m("dialViewIv");
            throw null;
        }
    }
}
