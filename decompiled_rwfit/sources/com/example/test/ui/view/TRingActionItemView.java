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
public final class TRingActionItemView extends LinearLayout {

    /* renamed from: i, reason: collision with root package name */
    public static final /* synthetic */ int f8594i = 0;

    /* renamed from: a, reason: collision with root package name */
    public a7.d f8595a;

    /* renamed from: b, reason: collision with root package name */
    public final SwitchCompat f8596b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f8597c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f8598d;
    public final ImageView e;

    /* renamed from: f, reason: collision with root package name */
    public final PointView f8599f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f8600g;

    /* renamed from: h, reason: collision with root package name */
    public final View f8601h;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TRingActionItemView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final void a(int i3) {
        if (i3 == 0) {
            SwitchCompat switchCompat = this.f8596b;
            if (switchCompat == null) {
                kotlin.jvm.internal.e.m("btScBtn");
                throw null;
            }
            switchCompat.setVisibility(8);
            TextView textView = this.f8598d;
            if (textView == null) {
                kotlin.jvm.internal.e.m("tvTipsTv");
                throw null;
            }
            textView.setVisibility(0);
            ImageView imageView = this.f8600g;
            if (imageView == null) {
                kotlin.jvm.internal.e.m("ivNextIv");
                throw null;
            }
            imageView.setVisibility(0);
            View view = this.f8601h;
            if (view != null) {
                view.setVisibility(0);
                return;
            } else {
                kotlin.jvm.internal.e.m("line");
                throw null;
            }
        }
        if (i3 == 1) {
            SwitchCompat switchCompat2 = this.f8596b;
            if (switchCompat2 == null) {
                kotlin.jvm.internal.e.m("btScBtn");
                throw null;
            }
            switchCompat2.setVisibility(0);
            TextView textView2 = this.f8598d;
            if (textView2 == null) {
                kotlin.jvm.internal.e.m("tvTipsTv");
                throw null;
            }
            textView2.setVisibility(0);
            ImageView imageView2 = this.f8600g;
            if (imageView2 == null) {
                kotlin.jvm.internal.e.m("ivNextIv");
                throw null;
            }
            imageView2.setVisibility(8);
            View view2 = this.f8601h;
            if (view2 != null) {
                view2.setVisibility(0);
                return;
            } else {
                kotlin.jvm.internal.e.m("line");
                throw null;
            }
        }
        if (i3 == 2) {
            SwitchCompat switchCompat3 = this.f8596b;
            if (switchCompat3 == null) {
                kotlin.jvm.internal.e.m("btScBtn");
                throw null;
            }
            switchCompat3.setVisibility(8);
            TextView textView3 = this.f8598d;
            if (textView3 == null) {
                kotlin.jvm.internal.e.m("tvTipsTv");
                throw null;
            }
            textView3.setVisibility(0);
            ImageView imageView3 = this.f8600g;
            if (imageView3 == null) {
                kotlin.jvm.internal.e.m("ivNextIv");
                throw null;
            }
            imageView3.setVisibility(0);
            View view3 = this.f8601h;
            if (view3 != null) {
                view3.setVisibility(0);
                return;
            } else {
                kotlin.jvm.internal.e.m("line");
                throw null;
            }
        }
        if (i3 != 3) {
            return;
        }
        SwitchCompat switchCompat4 = this.f8596b;
        if (switchCompat4 == null) {
            kotlin.jvm.internal.e.m("btScBtn");
            throw null;
        }
        switchCompat4.setVisibility(8);
        TextView textView4 = this.f8598d;
        if (textView4 == null) {
            kotlin.jvm.internal.e.m("tvTipsTv");
            throw null;
        }
        textView4.setVisibility(0);
        ImageView imageView4 = this.f8600g;
        if (imageView4 == null) {
            kotlin.jvm.internal.e.m("ivNextIv");
            throw null;
        }
        imageView4.setVisibility(0);
        View view4 = this.f8601h;
        if (view4 != null) {
            view4.setVisibility(8);
        } else {
            kotlin.jvm.internal.e.m("line");
            throw null;
        }
    }

    public final boolean getItemOpen() {
        SwitchCompat switchCompat = this.f8596b;
        if (switchCompat != null) {
            return switchCompat.isChecked();
        }
        kotlin.jvm.internal.e.m("btScBtn");
        throw null;
    }

    public final void setFontColor(int i3) {
        TextView textView = this.f8597c;
        if (textView == null) {
            kotlin.jvm.internal.e.m("itemNameTv");
            throw null;
        }
        textView.setTextColor(i3);
        TextView textView2 = this.f8598d;
        if (textView2 != null) {
            textView2.setTextColor(i3);
        } else {
            kotlin.jvm.internal.e.m("tvTipsTv");
            throw null;
        }
    }

    public final void setHighTips(boolean z5) {
        PointView pointView = this.f8599f;
        if (pointView != null) {
            pointView.setVisibility(z5 ? 0 : 8);
        } else {
            kotlin.jvm.internal.e.m("pointView");
            throw null;
        }
    }

    public final void setHintStr(String hint) {
        kotlin.jvm.internal.e.f(hint, "hint");
        TextView textView = this.f8598d;
        if (textView != null) {
            textView.setText(hint);
        } else {
            kotlin.jvm.internal.e.m("tvTipsTv");
            throw null;
        }
    }

    public final void setItemName(int i3) {
        TextView textView = this.f8597c;
        if (textView != null) {
            textView.setText(i3);
        } else {
            kotlin.jvm.internal.e.m("itemNameTv");
            throw null;
        }
    }

    public final void setItemOpen(boolean z5) {
        SwitchCompat switchCompat = this.f8596b;
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
        this.f8595a = onSwitchStatusChangListener;
    }

    public final void setSetting(boolean z5) {
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TRingActionItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public /* synthetic */ TRingActionItemView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TRingActionItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        String str;
        Drawable drawable;
        String str2;
        int i10;
        boolean z5;
        kotlin.jvm.internal.e.f(context, "context");
        LayoutInflater.from(context).inflate(R$layout.view_ring_action_item, this);
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
        this.f8596b = (SwitchCompat) findViewById;
        View findViewById2 = findViewById(R$id.itemName);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8597c = (TextView) findViewById2;
        View findViewById3 = findViewById(R$id.tvTips);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8598d = (TextView) findViewById3;
        View findViewById4 = findViewById(R$id.ivIcon);
        kotlin.jvm.internal.e.e(findViewById4, "findViewById(...)");
        this.e = (ImageView) findViewById4;
        View findViewById5 = findViewById(R$id.pointView);
        kotlin.jvm.internal.e.e(findViewById5, "findViewById(...)");
        this.f8599f = (PointView) findViewById5;
        View findViewById6 = findViewById(R$id.ivNext);
        kotlin.jvm.internal.e.e(findViewById6, "findViewById(...)");
        this.f8600g = (ImageView) findViewById6;
        View findViewById7 = findViewById(R$id.line);
        kotlin.jvm.internal.e.e(findViewById7, "findViewById(...)");
        this.f8601h = findViewById7;
        SwitchCompat switchCompat = this.f8596b;
        if (switchCompat != null) {
            switchCompat.setOnCheckedChangeListener(new q0(this, 2));
            TextView textView = this.f8597c;
            if (textView != null) {
                textView.setText(str);
                TextView textView2 = this.f8598d;
                if (textView2 != null) {
                    textView2.setText(str2);
                    ImageView imageView = this.e;
                    if (imageView != null) {
                        imageView.setVisibility(z6 ? 0 : 8);
                        PointView pointView = this.f8599f;
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
