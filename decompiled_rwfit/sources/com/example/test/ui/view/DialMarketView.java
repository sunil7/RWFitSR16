package com.example.test.ui.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$string;
import com.example.test.ui.device.activity.DialMarketActivity;

/* loaded from: classes.dex */
public final class DialMarketView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f8406a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f8407b;

    /* renamed from: c, reason: collision with root package name */
    public final LinearLayout f8408c;

    /* renamed from: d, reason: collision with root package name */
    public final DialItemView f8409d;
    public final DialItemView e;

    /* renamed from: f, reason: collision with root package name */
    public final DialItemView f8410f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DialMarketView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        if (view != null) {
            view.getId();
            if (com.example.test.service.e.h().i()) {
                getContext().startActivity(new Intent(getContext(), (Class<?>) DialMarketActivity.class));
            } else {
                com.example.baselibrary.utils.d.a(R$string.str_device_disconnected);
            }
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DialMarketView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ DialMarketView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DialMarketView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_dial_market, this);
        View findViewById = findViewById(R$id.dialMarketTv);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8406a = (TextView) findViewById;
        View findViewById2 = findViewById(R$id.moreTv);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8407b = (TextView) findViewById2;
        View findViewById3 = findViewById(R$id.dialMarketTitle);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8408c = (LinearLayout) findViewById3;
        View findViewById4 = findViewById(R$id.dialFirst);
        kotlin.jvm.internal.e.e(findViewById4, "findViewById(...)");
        this.f8409d = (DialItemView) findViewById4;
        View findViewById5 = findViewById(R$id.dialSec);
        kotlin.jvm.internal.e.e(findViewById5, "findViewById(...)");
        this.e = (DialItemView) findViewById5;
        View findViewById6 = findViewById(R$id.dialTh);
        kotlin.jvm.internal.e.e(findViewById6, "findViewById(...)");
        this.f8410f = (DialItemView) findViewById6;
        TextView textView = this.f8406a;
        if (textView != null) {
            textView.setOnClickListener(this);
            TextView textView2 = this.f8407b;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
                LinearLayout linearLayout = this.f8408c;
                if (linearLayout != null) {
                    linearLayout.setOnClickListener(this);
                    return;
                } else {
                    kotlin.jvm.internal.e.m("dialMarketTitleLL");
                    throw null;
                }
            }
            kotlin.jvm.internal.e.m("moreTv");
            throw null;
        }
        kotlin.jvm.internal.e.m("dialMarketTv");
        throw null;
    }
}
