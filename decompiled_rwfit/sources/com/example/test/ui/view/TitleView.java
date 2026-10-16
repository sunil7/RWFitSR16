package com.example.test.ui.view;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$styleable;

/* loaded from: classes.dex */
public final class TitleView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public final ImageView f8652a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f8653b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f8654c;

    /* renamed from: d, reason: collision with root package name */
    public final eh.b f8655d;
    public a7.e e;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TitleView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    private final ObjectAnimator getRotationYAnimator() {
        return (ObjectAnimator) this.f8655d.getValue();
    }

    public final void a() {
        getRotationYAnimator().start();
    }

    public final void b() {
        getRotationYAnimator().cancel();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a7.e eVar;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.back;
        if (valueOf != null && valueOf.intValue() == i3) {
            a7.e eVar2 = this.e;
            if (eVar2 != null) {
                eVar2.u0();
                return;
            }
            return;
        }
        int i10 = R$id.icRight;
        if (valueOf == null || valueOf.intValue() != i10 || (eVar = this.e) == null) {
            return;
        }
        view.getId();
        eVar.B();
    }

    public final void setOnTitleListener(a7.e onTitleListener) {
        kotlin.jvm.internal.e.f(onTitleListener, "onTitleListener");
        this.e = onTitleListener;
    }

    public final void setTitle(int i3) {
        TextView textView = this.f8653b;
        if (textView != null) {
            textView.setText(i3);
        } else {
            kotlin.jvm.internal.e.m("titleTv");
            throw null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TitleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final void setTitle(String titleStr) {
        kotlin.jvm.internal.e.f(titleStr, "titleStr");
        TextView textView = this.f8653b;
        if (textView != null) {
            textView.setText(titleStr);
        } else {
            kotlin.jvm.internal.e.m("titleTv");
            throw null;
        }
    }

    public /* synthetic */ TitleView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TitleView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        String str;
        Drawable drawable;
        Drawable drawable2;
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_title, this);
        View findViewById = findViewById(R$id.icRight);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8652a = (ImageView) findViewById;
        View findViewById2 = findViewById(R$id.title);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8653b = (TextView) findViewById2;
        View findViewById3 = findViewById(R$id.back);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8654c = (ImageView) findViewById3;
        str = "";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.TitleView);
            kotlin.jvm.internal.e.e(obtainStyledAttributes, "obtainStyledAttributes(...)");
            String string = obtainStyledAttributes.getString(R$styleable.TitleView_title_text);
            str = string != null ? string : "";
            drawable = obtainStyledAttributes.getDrawable(R$styleable.TitleView_title_right);
            drawable2 = obtainStyledAttributes.getDrawable(R$styleable.TitleView_title_back);
            obtainStyledAttributes.getColor(R$styleable.TitleView_title_text_color, -1);
            obtainStyledAttributes.recycle();
        } else {
            drawable = null;
            drawable2 = null;
        }
        TextView textView = this.f8653b;
        if (textView != null) {
            textView.setText(str);
            if (drawable != null) {
                ImageView imageView = this.f8652a;
                if (imageView != null) {
                    imageView.setImageDrawable(drawable);
                    ImageView imageView2 = this.f8652a;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                        ImageView imageView3 = this.f8652a;
                        if (imageView3 == null) {
                            kotlin.jvm.internal.e.m("icRightIv");
                            throw null;
                        }
                        imageView3.setOnClickListener(this);
                    } else {
                        kotlin.jvm.internal.e.m("icRightIv");
                        throw null;
                    }
                } else {
                    kotlin.jvm.internal.e.m("icRightIv");
                    throw null;
                }
            }
            if (drawable2 != null) {
                ImageView imageView4 = this.f8654c;
                if (imageView4 == null) {
                    kotlin.jvm.internal.e.m("backIv");
                    throw null;
                }
                imageView4.setImageDrawable(drawable2);
            }
            ImageView imageView5 = this.f8654c;
            if (imageView5 != null) {
                imageView5.setOnClickListener(this);
                this.f8655d = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.view.TitleView$rotationYAnimator$2
                    {
                        super(0);
                    }

                    @Override // oh.a
                    public final ObjectAnimator invoke() {
                        ImageView imageView6 = TitleView.this.f8652a;
                        if (imageView6 == null) {
                            kotlin.jvm.internal.e.m("icRightIv");
                            throw null;
                        }
                        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView6, "rotation", 0.0f, 359.0f);
                        ofFloat.setDuration(1000L);
                        ofFloat.setRepeatMode(1);
                        ofFloat.setRepeatCount(-1);
                        return ofFloat;
                    }
                });
                return;
            } else {
                kotlin.jvm.internal.e.m("backIv");
                throw null;
            }
        }
        kotlin.jvm.internal.e.m("titleTv");
        throw null;
    }
}
