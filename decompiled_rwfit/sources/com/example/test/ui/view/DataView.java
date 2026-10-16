package com.example.test.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$styleable;

/* loaded from: classes.dex */
public final class DataView extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    public final TextView f8372a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f8373b;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final void setTitle(String title) {
        kotlin.jvm.internal.e.f(title, "title");
        TextView textView = this.f8372a;
        if (textView != null) {
            textView.setText(title);
        } else {
            kotlin.jvm.internal.e.m("tvNameTv");
            throw null;
        }
    }

    public final void setValue(String value) {
        kotlin.jvm.internal.e.f(value, "value");
        TextView textView = this.f8373b;
        if (textView != null) {
            textView.setText(value);
        } else {
            kotlin.jvm.internal.e.m("tvValueTv");
            throw null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public DataView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ DataView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DataView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        String str;
        String str2;
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_data, this);
        str = "";
        if (attributeSet == null) {
            str2 = "";
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.DataView);
            kotlin.jvm.internal.e.e(obtainStyledAttributes, "obtainStyledAttributes(...)");
            String string = obtainStyledAttributes.getString(R$styleable.DataView_data_name);
            string = string == null ? "" : string;
            String string2 = obtainStyledAttributes.getString(R$styleable.DataView_data_value);
            str = string2 != null ? string2 : "";
            obtainStyledAttributes.recycle();
            str2 = str;
            str = string;
        }
        View findViewById = findViewById(R$id.tvName);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8372a = (TextView) findViewById;
        View findViewById2 = findViewById(R$id.tvValue);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8373b = (TextView) findViewById2;
        TextView textView = this.f8372a;
        if (textView != null) {
            textView.setText(str);
            TextView textView2 = this.f8373b;
            if (textView2 != null) {
                textView2.setText(str2);
                return;
            } else {
                kotlin.jvm.internal.e.m("tvValueTv");
                throw null;
            }
        }
        kotlin.jvm.internal.e.m("tvNameTv");
        throw null;
    }
}
