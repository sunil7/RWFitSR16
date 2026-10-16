package com.example.test.ui.testui;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$styleable;
import com.google.android.material.R$attr;

/* loaded from: classes.dex */
public final class TRingToolBarView extends LinearLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public a7.f f8237a;

    /* renamed from: b, reason: collision with root package name */
    public final ImageView f8238b;

    /* renamed from: c, reason: collision with root package name */
    public final ImageView f8239c;

    /* renamed from: d, reason: collision with root package name */
    public final ImageView f8240d;
    public final TextView e;

    /* renamed from: f, reason: collision with root package name */
    public final eh.b f8241f;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TRingToolBarView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    private final ObjectAnimator getRotationYAnimator() {
        return (ObjectAnimator) this.f8241f.getValue();
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        a7.f fVar;
        if (view == null || (fVar = this.f8237a) == null) {
            return;
        }
        fVar.j(view.getId());
    }

    public final void setBarOption1Iv(VectorDrawable drawable) {
        kotlin.jvm.internal.e.f(drawable, "drawable");
        ImageView imageView = this.f8239c;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        } else {
            kotlin.jvm.internal.e.m("option1Iv");
            throw null;
        }
    }

    public final void setBarOption2Iv(VectorDrawable drawable) {
        kotlin.jvm.internal.e.f(drawable, "drawable");
        ImageView imageView = this.f8240d;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        } else {
            kotlin.jvm.internal.e.m("option2Iv");
            throw null;
        }
    }

    public final void setBarStatusDrawable(int i3) {
        ImageView imageView = this.f8238b;
        if (imageView != null) {
            imageView.setImageResource(i3);
        } else {
            kotlin.jvm.internal.e.m("barStatusIv");
            throw null;
        }
    }

    public final void setBarStatusIv(VectorDrawable drawable) {
        kotlin.jvm.internal.e.f(drawable, "drawable");
        ImageView imageView = this.f8238b;
        if (imageView != null) {
            imageView.setImageDrawable(drawable);
        } else {
            kotlin.jvm.internal.e.m("barStatusIv");
            throw null;
        }
    }

    public final void setBarTitle(String title) {
        kotlin.jvm.internal.e.f(title, "title");
        TextView textView = this.e;
        if (textView != null) {
            textView.setText(title);
        } else {
            kotlin.jvm.internal.e.m("barTitleTv");
            throw null;
        }
    }

    public final void setBarTitleColor(int i3) {
        TextView textView = this.e;
        if (textView != null) {
            textView.setTextColor(i3);
        } else {
            kotlin.jvm.internal.e.m("barTitleTv");
            throw null;
        }
    }

    public final void setOnViewChildListener(a7.f fVar) {
        this.f8237a = fVar;
    }

    public final void setbarStatusIvVisiable(int i3) {
        ImageView imageView = this.f8238b;
        if (imageView != null) {
            imageView.setVisibility(i3);
        } else {
            kotlin.jvm.internal.e.m("barStatusIv");
            throw null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TRingToolBarView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ TRingToolBarView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TRingToolBarView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        String str;
        Drawable drawable;
        Drawable drawable2;
        Drawable drawable3;
        kotlin.jvm.internal.e.f(context, "context");
        this.f8241f = kotlin.a.b(new oh.a() { // from class: com.example.test.ui.testui.TRingToolBarView$rotationYAnimator$2
            {
                super(0);
            }

            @Override // oh.a
            public final ObjectAnimator invoke() {
                ImageView imageView = TRingToolBarView.this.f8239c;
                if (imageView == null) {
                    kotlin.jvm.internal.e.m("option1Iv");
                    throw null;
                }
                ObjectAnimator ofFloat = ObjectAnimator.ofFloat(imageView, "rotation", 0.0f, 359.0f);
                ofFloat.setDuration(500L);
                ofFloat.setRepeatMode(1);
                ofFloat.setRepeatCount(-1);
                return ofFloat;
            }
        });
        LayoutInflater.from(context).inflate(R$layout.view_ring_toolbar, this);
        View findViewById = findViewById(R$id.barStatusIv);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8238b = (ImageView) findViewById;
        View findViewById2 = findViewById(R$id.option1);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8239c = (ImageView) findViewById2;
        View findViewById3 = findViewById(R$id.option2);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8240d = (ImageView) findViewById3;
        View findViewById4 = findViewById(R$id.barTitle);
        kotlin.jvm.internal.e.e(findViewById4, "findViewById(...)");
        this.e = (TextView) findViewById4;
        str = "";
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ToolBarView);
            kotlin.jvm.internal.e.e(obtainStyledAttributes, "obtainStyledAttributes(...)");
            drawable = obtainStyledAttributes.getDrawable(R$styleable.ToolBarView_bar_status_res);
            drawable2 = obtainStyledAttributes.getDrawable(R$styleable.ToolBarView_bar_option1);
            drawable3 = obtainStyledAttributes.getDrawable(R$styleable.ToolBarView_bar_option2);
            String string = obtainStyledAttributes.getString(R$styleable.ToolBarView_bar_title);
            str = string != null ? string : "";
            TypedValue typedValue = new TypedValue();
            int i10 = context.getTheme().resolveAttribute(R$attr.colorOnPrimary, typedValue, true) ? typedValue.data : -16777216;
            TextView textView = this.e;
            if (textView != null) {
                textView.setTextColor(i10);
                obtainStyledAttributes.recycle();
            } else {
                kotlin.jvm.internal.e.m("barTitleTv");
                throw null;
            }
        } else {
            drawable = null;
            drawable2 = null;
            drawable3 = null;
        }
        if (drawable != null) {
            ImageView imageView = this.f8238b;
            if (imageView == null) {
                kotlin.jvm.internal.e.m("barStatusIv");
                throw null;
            }
            imageView.setImageDrawable(drawable);
        }
        if (drawable2 != null) {
            ImageView imageView2 = this.f8239c;
            if (imageView2 != null) {
                imageView2.setImageDrawable(drawable2);
                ImageView imageView3 = this.f8239c;
                if (imageView3 == null) {
                    kotlin.jvm.internal.e.m("option1Iv");
                    throw null;
                }
                imageView3.setVisibility(0);
            } else {
                kotlin.jvm.internal.e.m("option1Iv");
                throw null;
            }
        }
        if (drawable3 != null) {
            ImageView imageView4 = this.f8240d;
            if (imageView4 != null) {
                imageView4.setImageDrawable(drawable3);
                ImageView imageView5 = this.f8240d;
                if (imageView5 == null) {
                    kotlin.jvm.internal.e.m("option2Iv");
                    throw null;
                }
                imageView5.setVisibility(0);
            } else {
                kotlin.jvm.internal.e.m("option2Iv");
                throw null;
            }
        }
        TextView textView2 = this.e;
        if (textView2 != null) {
            textView2.setText(str);
            ImageView imageView6 = this.f8239c;
            if (imageView6 != null) {
                imageView6.setOnClickListener(this);
                ImageView imageView7 = this.f8240d;
                if (imageView7 != null) {
                    imageView7.setOnClickListener(this);
                    ImageView imageView8 = this.f8238b;
                    if (imageView8 != null) {
                        imageView8.setOnClickListener(this);
                        return;
                    } else {
                        kotlin.jvm.internal.e.m("barStatusIv");
                        throw null;
                    }
                }
                kotlin.jvm.internal.e.m("option2Iv");
                throw null;
            }
            kotlin.jvm.internal.e.m("option1Iv");
            throw null;
        }
        kotlin.jvm.internal.e.m("barTitleTv");
        throw null;
    }
}
