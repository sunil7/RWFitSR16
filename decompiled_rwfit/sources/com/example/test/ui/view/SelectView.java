package com.example.test.ui.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.R$layout;

/* loaded from: classes.dex */
public final class SelectView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public a7.f f8562a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f8563b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f8564c;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final int getSelectedType() {
        TextView textView = this.f8563b;
        if (textView != null) {
            return textView.isSelected() ? 4 : 5;
        }
        kotlin.jvm.internal.e.m("indoorTv");
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.indoorTv;
        if (valueOf != null && valueOf.intValue() == i3) {
            TextView textView = this.f8563b;
            if (textView == null) {
                kotlin.jvm.internal.e.m("indoorTv");
                throw null;
            }
            textView.setSelected(true);
            TextView textView2 = this.f8564c;
            if (textView2 == null) {
                kotlin.jvm.internal.e.m("outdoorTv");
                throw null;
            }
            textView2.setSelected(false);
            a7.f fVar = this.f8562a;
            if (fVar != null) {
                fVar.j(4);
                return;
            }
            return;
        }
        int i10 = R$id.outdoorTv;
        if (valueOf != null && valueOf.intValue() == i10) {
            TextView textView3 = this.f8563b;
            if (textView3 == null) {
                kotlin.jvm.internal.e.m("indoorTv");
                throw null;
            }
            textView3.setSelected(false);
            TextView textView4 = this.f8564c;
            if (textView4 == null) {
                kotlin.jvm.internal.e.m("outdoorTv");
                throw null;
            }
            textView4.setSelected(true);
            a7.f fVar2 = this.f8562a;
            if (fVar2 != null) {
                fVar2.j(5);
            }
        }
    }

    public final void setViewChildListener(a7.f onViewChildListener) {
        kotlin.jvm.internal.e.f(onViewChildListener, "onViewChildListener");
        this.f8562a = onViewChildListener;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SelectView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ SelectView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public SelectView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_select, this);
        View findViewById = findViewById(R$id.indoorTv);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8563b = (TextView) findViewById;
        View findViewById2 = findViewById(R$id.outdoorTv);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8564c = (TextView) findViewById2;
        TextView textView = this.f8563b;
        if (textView != null) {
            textView.setSelected(true);
            TextView textView2 = this.f8563b;
            if (textView2 != null) {
                textView2.setOnClickListener(this);
                TextView textView3 = this.f8564c;
                if (textView3 != null) {
                    textView3.setOnClickListener(this);
                    return;
                } else {
                    kotlin.jvm.internal.e.m("outdoorTv");
                    throw null;
                }
            }
            kotlin.jvm.internal.e.m("indoorTv");
            throw null;
        }
        kotlin.jvm.internal.e.m("indoorTv");
        throw null;
    }
}
