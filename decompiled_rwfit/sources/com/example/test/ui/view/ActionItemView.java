package com.example.test.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.SwitchCompat;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$styleable;
import com.example.test.ui.testui.q0;

/* loaded from: classes.dex */
public final class ActionItemView extends LinearLayout {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f8334h = 0;

    /* renamed from: a, reason: collision with root package name */
    public a7.d f8335a;

    /* renamed from: b, reason: collision with root package name */
    public final SwitchCompat f8336b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f8337c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f8338d;
    public final ImageView e;

    /* renamed from: f, reason: collision with root package name */
    public final PointView f8339f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f8340g;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionItemView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final void a(int i3) {
        if (i3 == 0) {
            SwitchCompat switchCompat = this.f8336b;
            if (switchCompat == null) {
                kotlin.jvm.internal.e.m("btScBtn");
                throw null;
            }
            switchCompat.setVisibility(8);
            TextView textView = this.f8338d;
            if (textView == null) {
                kotlin.jvm.internal.e.m("tvTipsTv");
                throw null;
            }
            textView.setVisibility(8);
            ImageView imageView = this.f8340g;
            if (imageView != null) {
                imageView.setVisibility(0);
                return;
            } else {
                kotlin.jvm.internal.e.m("ivNextIv");
                throw null;
            }
        }
        if (i3 == 1) {
            SwitchCompat switchCompat2 = this.f8336b;
            if (switchCompat2 == null) {
                kotlin.jvm.internal.e.m("btScBtn");
                throw null;
            }
            switchCompat2.setVisibility(0);
            TextView textView2 = this.f8338d;
            if (textView2 == null) {
                kotlin.jvm.internal.e.m("tvTipsTv");
                throw null;
            }
            textView2.setVisibility(8);
            ImageView imageView2 = this.f8340g;
            if (imageView2 != null) {
                imageView2.setVisibility(8);
                return;
            } else {
                kotlin.jvm.internal.e.m("ivNextIv");
                throw null;
            }
        }
        if (i3 != 2) {
            return;
        }
        SwitchCompat switchCompat3 = this.f8336b;
        if (switchCompat3 == null) {
            kotlin.jvm.internal.e.m("btScBtn");
            throw null;
        }
        switchCompat3.setVisibility(8);
        TextView textView3 = this.f8338d;
        if (textView3 == null) {
            kotlin.jvm.internal.e.m("tvTipsTv");
            throw null;
        }
        textView3.setVisibility(0);
        ImageView imageView3 = this.f8340g;
        if (imageView3 != null) {
            imageView3.setVisibility(0);
        } else {
            kotlin.jvm.internal.e.m("ivNextIv");
            throw null;
        }
    }

    public final boolean getItemOpen() {
        SwitchCompat switchCompat = this.f8336b;
        if (switchCompat != null) {
            return switchCompat.isChecked();
        }
        kotlin.jvm.internal.e.m("btScBtn");
        throw null;
    }

    public final void setHighTips(boolean z5) {
        PointView pointView = this.f8339f;
        if (pointView != null) {
            pointView.setVisibility(z5 ? 0 : 8);
        } else {
            kotlin.jvm.internal.e.m("pointView");
            throw null;
        }
    }

    public final void setHintStr(String hint) {
        kotlin.jvm.internal.e.f(hint, "hint");
        TextView textView = this.f8338d;
        if (textView != null) {
            textView.setText(hint);
        } else {
            kotlin.jvm.internal.e.m("tvTipsTv");
            throw null;
        }
    }

    public final void setItemName(int i3) {
        TextView textView = this.f8337c;
        if (textView != null) {
            textView.setText(i3);
        } else {
            kotlin.jvm.internal.e.m("itemNameTv");
            throw null;
        }
    }

    public final void setItemOpen(boolean z5) {
        SwitchCompat switchCompat = this.f8336b;
        if (switchCompat != null) {
            switchCompat.setChecked(z5);
        } else {
            kotlin.jvm.internal.e.m("btScBtn");
            throw null;
        }
    }

    public final void setItemResource(int i3) {
        ImageView imageView = this.e;
        if (imageView != null) {
            imageView.setImageResource(i3);
        } else {
            kotlin.jvm.internal.e.m("ivIconIv");
            throw null;
        }
    }

    public final void setItemType(int i3) {
        a(i3);
    }

    public final void setOnSwitchStatusChangListener(a7.d onSwitchStatusChangListener) {
        kotlin.jvm.internal.e.f(onSwitchStatusChangListener, "onSwitchStatusChangListener");
        this.f8335a = onSwitchStatusChangListener;
    }

    public final void setSetting(boolean z5) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActionItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ ActionItemView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ActionItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        String str;
        Drawable drawable;
        String str2;
        int i10;
        boolean z5;
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_action_item, this);
        str = "";
        boolean z6 = true;
        if (attributeSet == null) {
            drawable = null;
            str2 = "";
            i10 = 0;
            z5 = false;
        } else {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ActionItemView);
            kotlin.jvm.internal.e.e(obtainStyledAttributes, "obtainStyledAttributes(...)");
            String string = obtainStyledAttributes.getString(R$styleable.ActionItemView_item_name);
            string = string == null ? "" : string;
            String string2 = obtainStyledAttributes.getString(R$styleable.ActionItemView_item_hint);
            str = string2 != null ? string2 : "";
            i10 = obtainStyledAttributes.getInt(R$styleable.ActionItemView_item_type, 0);
            drawable = obtainStyledAttributes.getDrawable(R$styleable.ActionItemView_item_resource);
            z6 = obtainStyledAttributes.getBoolean(R$styleable.ActionItemView_is_show_icon, true);
            z5 = obtainStyledAttributes.getBoolean(R$styleable.ActionItemView_is_show_point, false);
            obtainStyledAttributes.recycle();
            str2 = str;
            str = string;
        }
        View findViewById = findViewById(R$id.scBtn);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8336b = (SwitchCompat) findViewById;
        View findViewById2 = findViewById(R$id.itemName);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8337c = (TextView) findViewById2;
        View findViewById3 = findViewById(R$id.tvTips);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8338d = (TextView) findViewById3;
        View findViewById4 = findViewById(R$id.ivIcon);
        kotlin.jvm.internal.e.e(findViewById4, "findViewById(...)");
        this.e = (ImageView) findViewById4;
        View findViewById5 = findViewById(R$id.pointView);
        kotlin.jvm.internal.e.e(findViewById5, "findViewById(...)");
        this.f8339f = (PointView) findViewById5;
        View findViewById6 = findViewById(R$id.ivNext);
        kotlin.jvm.internal.e.e(findViewById6, "findViewById(...)");
        this.f8340g = (ImageView) findViewById6;
        SwitchCompat switchCompat = this.f8336b;
        if (switchCompat != null) {
            switchCompat.setOnCheckedChangeListener(new q0(this, 1));
            TextView textView = this.f8337c;
            if (textView != null) {
                textView.setText(str);
                TextView textView2 = this.f8338d;
                if (textView2 != null) {
                    textView2.setText(str2);
                    ImageView imageView = this.e;
                    if (imageView != null) {
                        imageView.setVisibility(z6 ? 0 : 8);
                        PointView pointView = this.f8339f;
                        if (pointView != null) {
                            pointView.setVisibility(z5 ? 0 : 8);
                            a(i10);
                            if (drawable != null) {
                                ImageView imageView2 = this.e;
                                if (imageView2 != null) {
                                    imageView2.setImageDrawable(drawable);
                                    return;
                                } else {
                                    kotlin.jvm.internal.e.m("ivIconIv");
                                    throw null;
                                }
                            }
                            return;
                        }
                        kotlin.jvm.internal.e.m("pointView");
                        throw null;
                    }
                    kotlin.jvm.internal.e.m("ivIconIv");
                    throw null;
                }
                kotlin.jvm.internal.e.m("tvTipsTv");
                throw null;
            }
            kotlin.jvm.internal.e.m("itemNameTv");
            throw null;
        }
        kotlin.jvm.internal.e.m("btScBtn");
        throw null;
    }
}
