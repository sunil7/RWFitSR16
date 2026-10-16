package com.example.test.ui.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.example.test.R$id;
import com.example.test.R$layout;
import com.example.test.R$mipmap;
import com.example.test.R$string;
import com.example.test.R$styleable;

/* loaded from: classes.dex */
public final class InputView extends LinearLayout implements View.OnClickListener {

    /* renamed from: n, reason: collision with root package name */
    public static final /* synthetic */ int f8441n = 0;

    /* renamed from: a, reason: collision with root package name */
    public final Drawable f8442a;

    /* renamed from: b, reason: collision with root package name */
    public final Drawable f8443b;

    /* renamed from: c, reason: collision with root package name */
    public final String f8444c;

    /* renamed from: d, reason: collision with root package name */
    public final String f8445d;
    public final String e;

    /* renamed from: f, reason: collision with root package name */
    public final boolean f8446f;

    /* renamed from: g, reason: collision with root package name */
    public a7.f f8447g;

    /* renamed from: h, reason: collision with root package name */
    public a7.c f8448h;

    /* renamed from: i, reason: collision with root package name */
    public int f8449i;

    /* renamed from: j, reason: collision with root package name */
    public final ImageView f8450j;

    /* renamed from: k, reason: collision with root package name */
    public final ImageView f8451k;

    /* renamed from: l, reason: collision with root package name */
    public final TextView f8452l;

    /* renamed from: m, reason: collision with root package name */
    public final EditText f8453m;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputView(Context context) {
        this(context, null, 6, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final void a() {
        TextView textView = this.f8452l;
        if (textView == null) {
            kotlin.jvm.internal.e.m("itemTxtActionTv");
            throw null;
        }
        textView.setText(getContext().getString(R$string.str_rev_code) + "(" + this.f8449i + ")");
        TextView textView2 = this.f8452l;
        if (textView2 == null) {
            kotlin.jvm.internal.e.m("itemTxtActionTv");
            throw null;
        }
        textView2.setEnabled(false);
        TextView textView3 = this.f8452l;
        if (textView3 == null) {
            kotlin.jvm.internal.e.m("itemTxtActionTv");
            throw null;
        }
        textView3.setAlpha(0.5f);
        TextView textView4 = this.f8452l;
        if (textView4 != null) {
            textView4.postDelayed(new androidx.activity.b(this, 22), 1000L);
        } else {
            kotlin.jvm.internal.e.m("itemTxtActionTv");
            throw null;
        }
    }

    public final EditText getEdit() {
        EditText editText = this.f8453m;
        if (editText != null) {
            return editText;
        }
        kotlin.jvm.internal.e.m("etInputET");
        throw null;
    }

    public final String getText() {
        EditText editText = this.f8453m;
        if (editText == null) {
            kotlin.jvm.internal.e.m("etInputET");
            throw null;
        }
        Editable text = editText.getText();
        if (text == null || text.length() == 0) {
            return "";
        }
        EditText editText2 = this.f8453m;
        if (editText2 != null) {
            return editText2.getText().toString();
        }
        kotlin.jvm.internal.e.m("etInputET");
        throw null;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i3 = R$id.itemImgAction;
        if (valueOf == null || valueOf.intValue() != i3) {
            a7.f fVar = this.f8447g;
            if (fVar != null) {
                fVar.j(view != null ? view.getId() : 0);
                return;
            }
            return;
        }
        ImageView imageView = this.f8451k;
        if (imageView == null) {
            kotlin.jvm.internal.e.m("itemImgActionIv");
            throw null;
        }
        if (imageView == null) {
            kotlin.jvm.internal.e.m("itemImgActionIv");
            throw null;
        }
        imageView.setSelected(!imageView.isSelected());
        ImageView imageView2 = this.f8451k;
        if (imageView2 == null) {
            kotlin.jvm.internal.e.m("itemImgActionIv");
            throw null;
        }
        if (imageView2.isSelected()) {
            EditText editText = this.f8453m;
            if (editText == null) {
                kotlin.jvm.internal.e.m("etInputET");
                throw null;
            }
            editText.setInputType(145);
            ImageView imageView3 = this.f8451k;
            if (imageView3 == null) {
                kotlin.jvm.internal.e.m("itemImgActionIv");
                throw null;
            }
            imageView3.setImageResource(R$mipmap.ic_pw_visiable);
        } else {
            EditText editText2 = this.f8453m;
            if (editText2 == null) {
                kotlin.jvm.internal.e.m("etInputET");
                throw null;
            }
            editText2.setInputType(129);
            ImageView imageView4 = this.f8451k;
            if (imageView4 == null) {
                kotlin.jvm.internal.e.m("itemImgActionIv");
                throw null;
            }
            imageView4.setImageResource(R$mipmap.ic_disvisiable);
        }
        EditText editText3 = this.f8453m;
        if (editText3 == null) {
            kotlin.jvm.internal.e.m("etInputET");
            throw null;
        }
        if (editText3 == null) {
            kotlin.jvm.internal.e.m("etInputET");
            throw null;
        }
        Editable text = editText3.getText();
        if (text != null && text.length() != 0) {
            EditText editText4 = this.f8453m;
            if (editText4 == null) {
                kotlin.jvm.internal.e.m("etInputET");
                throw null;
            }
            r3 = editText4.getText().length();
        }
        editText3.setSelection(r3);
    }

    public final void setActionEnable(boolean z5) {
        TextView textView = this.f8452l;
        if (textView == null) {
            kotlin.jvm.internal.e.m("itemTxtActionTv");
            throw null;
        }
        textView.setEnabled(z5);
        if (z5) {
            TextView textView2 = this.f8452l;
            if (textView2 != null) {
                textView2.setAlpha(1.0f);
                return;
            } else {
                kotlin.jvm.internal.e.m("itemTxtActionTv");
                throw null;
            }
        }
        TextView textView3 = this.f8452l;
        if (textView3 != null) {
            textView3.setAlpha(0.5f);
        } else {
            kotlin.jvm.internal.e.m("itemTxtActionTv");
            throw null;
        }
    }

    public final void setEditable(boolean z5) {
        EditText editText = this.f8453m;
        if (editText == null) {
            kotlin.jvm.internal.e.m("etInputET");
            throw null;
        }
        editText.setFocusable(z5);
        EditText editText2 = this.f8453m;
        if (editText2 == null) {
            kotlin.jvm.internal.e.m("etInputET");
            throw null;
        }
        editText2.setFocusableInTouchMode(z5);
        if (z5) {
            EditText editText3 = this.f8453m;
            if (editText3 != null) {
                editText3.requestFocus();
            } else {
                kotlin.jvm.internal.e.m("etInputET");
                throw null;
            }
        }
    }

    public final void setHint(String str) {
        kotlin.jvm.internal.e.f(str, "str");
        EditText editText = this.f8453m;
        if (editText != null) {
            editText.setHint(str);
        } else {
            kotlin.jvm.internal.e.m("etInputET");
            throw null;
        }
    }

    public final void setLimit(int i3) {
        EditText editText = this.f8453m;
        if (editText != null) {
            editText.addTextChangedListener(new f(editText, i3));
        } else {
            kotlin.jvm.internal.e.m("etInputET");
            throw null;
        }
    }

    public final void setOnInputResultListener(a7.c onInputResultListener) {
        kotlin.jvm.internal.e.f(onInputResultListener, "onInputResultListener");
        this.f8448h = onInputResultListener;
        EditText editText = this.f8453m;
        if (editText != null) {
            editText.addTextChangedListener(new g(this, 1));
        } else {
            kotlin.jvm.internal.e.m("etInputET");
            throw null;
        }
    }

    public final void setOnViewChildListener(a7.f onViewChildListener) {
        kotlin.jvm.internal.e.f(onViewChildListener, "onViewChildListener");
        this.f8447g = onViewChildListener;
        TextView textView = this.f8452l;
        if (textView != null) {
            textView.setOnClickListener(this);
        } else {
            kotlin.jvm.internal.e.m("itemTxtActionTv");
            throw null;
        }
    }

    public final void setSelection(int i3) {
        EditText editText = this.f8453m;
        if (editText != null) {
            editText.setSelection(i3);
        } else {
            kotlin.jvm.internal.e.m("etInputET");
            throw null;
        }
    }

    public final void setText(String str) {
        kotlin.jvm.internal.e.f(str, "str");
        EditText editText = this.f8453m;
        if (editText != null) {
            editText.setText(str);
        } else {
            kotlin.jvm.internal.e.m("etInputET");
            throw null;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public InputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 4, 0);
        kotlin.jvm.internal.e.f(context, "context");
    }

    public final void setHint(int i3) {
        EditText editText = this.f8453m;
        if (editText != null) {
            editText.setHint(i3);
        } else {
            kotlin.jvm.internal.e.m("etInputET");
            throw null;
        }
    }

    public /* synthetic */ InputView(Context context, AttributeSet attributeSet, int i3, int i10) {
        this(context, (i3 & 2) != 0 ? null : attributeSet, 0);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        kotlin.jvm.internal.e.f(context, "context");
        this.f8445d = "";
        this.e = "";
        this.f8449i = 120;
        LayoutInflater.from(context).inflate(R$layout.view_input, this);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.InputView);
            kotlin.jvm.internal.e.e(obtainStyledAttributes, "obtainStyledAttributes(...)");
            this.f8442a = obtainStyledAttributes.getDrawable(R$styleable.InputView_input_icon);
            this.f8443b = obtainStyledAttributes.getDrawable(R$styleable.InputView_input_action_img_show);
            obtainStyledAttributes.getDrawable(R$styleable.InputView_input_action_img_hint);
            this.f8444c = obtainStyledAttributes.getString(R$styleable.InputView_input_action_txt);
            this.f8445d = obtainStyledAttributes.getString(R$styleable.InputView_input_content);
            this.e = obtainStyledAttributes.getString(R$styleable.InputView_input_hint);
            this.f8446f = obtainStyledAttributes.getBoolean(R$styleable.InputView_input_is_pw, false);
            obtainStyledAttributes.recycle();
        }
        View findViewById = findViewById(R$id.itemIcon);
        kotlin.jvm.internal.e.e(findViewById, "findViewById(...)");
        this.f8450j = (ImageView) findViewById;
        View findViewById2 = findViewById(R$id.itemImgAction);
        kotlin.jvm.internal.e.e(findViewById2, "findViewById(...)");
        this.f8451k = (ImageView) findViewById2;
        View findViewById3 = findViewById(R$id.itemTxtAction);
        kotlin.jvm.internal.e.e(findViewById3, "findViewById(...)");
        this.f8452l = (TextView) findViewById3;
        View findViewById4 = findViewById(R$id.etInput);
        kotlin.jvm.internal.e.e(findViewById4, "findViewById(...)");
        this.f8453m = (EditText) findViewById4;
        Drawable drawable = this.f8442a;
        if (drawable != null) {
            ImageView imageView = this.f8450j;
            if (imageView != null) {
                imageView.setVisibility(0);
                ImageView imageView2 = this.f8450j;
                if (imageView2 == null) {
                    kotlin.jvm.internal.e.m("itemIconIv");
                    throw null;
                }
                imageView2.setImageDrawable(drawable);
            } else {
                kotlin.jvm.internal.e.m("itemIconIv");
                throw null;
            }
        }
        Drawable drawable2 = this.f8443b;
        if (drawable2 != null) {
            ImageView imageView3 = this.f8451k;
            if (imageView3 != null) {
                imageView3.setVisibility(0);
                ImageView imageView4 = this.f8451k;
                if (imageView4 == null) {
                    kotlin.jvm.internal.e.m("itemImgActionIv");
                    throw null;
                }
                imageView4.setImageDrawable(drawable2);
            } else {
                kotlin.jvm.internal.e.m("itemImgActionIv");
                throw null;
            }
        }
        String str = this.f8444c;
        if (str != null) {
            TextView textView = this.f8452l;
            if (textView != null) {
                textView.setVisibility(0);
                TextView textView2 = this.f8452l;
                if (textView2 == null) {
                    kotlin.jvm.internal.e.m("itemTxtActionTv");
                    throw null;
                }
                textView2.setText(str);
            } else {
                kotlin.jvm.internal.e.m("itemTxtActionTv");
                throw null;
            }
        }
        String str2 = this.e;
        if (str2 != null && str2.length() != 0) {
            EditText editText = this.f8453m;
            if (editText == null) {
                kotlin.jvm.internal.e.m("etInputET");
                throw null;
            }
            editText.setHint(this.e);
        }
        String str3 = this.f8445d;
        if (str3 != null && str3.length() != 0) {
            EditText editText2 = this.f8453m;
            if (editText2 == null) {
                kotlin.jvm.internal.e.m("etInputET");
                throw null;
            }
            editText2.setHint(this.f8445d);
        }
        if (this.f8446f) {
            EditText editText3 = this.f8453m;
            if (editText3 != null) {
                editText3.setInputType(129);
                EditText editText4 = this.f8453m;
                if (editText4 != null) {
                    editText4.addTextChangedListener(new g(this, 0));
                    ImageView imageView5 = this.f8451k;
                    if (imageView5 != null) {
                        imageView5.setOnClickListener(this);
                        return;
                    } else {
                        kotlin.jvm.internal.e.m("itemImgActionIv");
                        throw null;
                    }
                }
                kotlin.jvm.internal.e.m("etInputET");
                throw null;
            }
            kotlin.jvm.internal.e.m("etInputET");
            throw null;
        }
    }
}
