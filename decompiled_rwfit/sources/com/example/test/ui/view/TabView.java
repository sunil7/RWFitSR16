package com.example.test.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.R$color;
import com.example.test.R$id;
import com.example.test.R$layout;

/* loaded from: classes.dex */
public final class TabView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public Integer f8637a;

    /* renamed from: b, reason: collision with root package name */
    public Integer f8638b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f8639c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f8640d;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final void a(int i3, int i10) {
        this.f8637a = Integer.valueOf(i3);
        this.f8638b = Integer.valueOf(i10);
        ImageView imageView = this.f8639c;
        if (imageView != null) {
            imageView.setImageResource(i3);
        } else {
            kotlin.jvm.internal.e.m("tabImgIv");
            throw null;
        }
    }

    public final void setTabName(int i3) {
        TextView textView = this.f8640d;
        if (textView != null) {
            textView.setText(i3);
        } else {
            kotlin.jvm.internal.e.m("tabNameTv");
            throw null;
        }
    }

    public final void setTabSelected(boolean z5) {
        TextView textView = this.f8640d;
        if (textView == null) {
            kotlin.jvm.internal.e.m("tabNameTv");
            throw null;
        }
        textView.setTextColor(getResources().getColor(z5 ? R$color.ring_bottomtext_sel : R$color.ring_bottomtext_nor));
        ImageView imageView = this.f8639c;
        if (imageView == null) {
            kotlin.jvm.internal.e.m("tabImgIv");
            throw null;
        }
        Integer num = z5 ? this.f8637a : this.f8638b;
        kotlin.jvm.internal.e.c(num);
        imageView.setImageResource(num.intValue());
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TabView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final void setTabName(String name) {
        kotlin.jvm.internal.e.f(name, "name");
        TextView textView = this.f8640d;
        if (textView != null) {
            textView.setText(name);
        } else {
            kotlin.jvm.internal.e.m("tabNameTv");
            throw null;
        }
    }

    public /* synthetic */ TabView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TabView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_tab, this);
        View findViewById = findViewById(R$id.tabImg);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8639c = (ImageView) findViewById;
        View findViewById2 = findViewById(R$id.tabName);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8640d = (TextView) findViewById2;
        this.f8637a = 0;
        this.f8638b = 0;
    }
}
