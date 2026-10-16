package com.google.android.gms.common;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.base.R$color;
import com.google.android.gms.base.R$drawable;
import com.google.android.gms.base.R$styleable;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.zaaa;
import com.google.android.gms.dynamic.RemoteCreator$RemoteCreatorException;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.q6;
import d1.b;
import q9.e;
import q9.n;

/* loaded from: classes.dex */
public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: a, reason: collision with root package name */
    public int f9071a;

    /* renamed from: b, reason: collision with root package name */
    public int f9072b;

    /* renamed from: c, reason: collision with root package name */
    public View f9073c;

    /* renamed from: d, reason: collision with root package name */
    public View.OnClickListener f9074d;

    public SignInButton(Context context) {
        this(context, null);
    }

    public final void a(int i3, int i10) {
        this.f9071a = i3;
        this.f9072b = i10;
        Context context = getContext();
        View view = this.f9073c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f9073c = e.e(context, this.f9071a, this.f9072b);
        } catch (RemoteCreator$RemoteCreatorException unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i11 = this.f9071a;
            int i12 = this.f9072b;
            zaaa zaaaVar = new zaaa(context, null);
            Resources resources = context.getResources();
            zaaaVar.setTypeface(Typeface.DEFAULT_BOLD);
            zaaaVar.setTextSize(14.0f);
            int i13 = (int) ((resources.getDisplayMetrics().density * 48.0f) + 0.5f);
            zaaaVar.setMinHeight(i13);
            zaaaVar.setMinWidth(i13);
            int i14 = R$drawable.common_google_signin_btn_icon_dark;
            int i15 = R$drawable.common_google_signin_btn_icon_light;
            int a3 = zaaa.a(i12, i14, i15, i15);
            int i16 = R$drawable.common_google_signin_btn_text_dark;
            int i17 = R$drawable.common_google_signin_btn_text_light;
            int a10 = zaaa.a(i12, i16, i17, i17);
            if (i11 == 0 || i11 == 1) {
                a3 = a10;
            } else if (i11 != 2) {
                throw new IllegalStateException(l0.j(i11, "Unknown button size: "));
            }
            Drawable drawable = resources.getDrawable(a3);
            b.h(drawable, resources.getColorStateList(R$color.common_google_signin_btn_tint));
            b.i(drawable, PorterDuff.Mode.SRC_ATOP);
            zaaaVar.setBackgroundDrawable(drawable);
            int i18 = R$color.common_google_signin_btn_text_dark;
            int i19 = R$color.common_google_signin_btn_text_light;
            ColorStateList colorStateList = resources.getColorStateList(zaaa.a(i12, i18, i19, i19));
            n.e(colorStateList);
            zaaaVar.setTextColor(colorStateList);
            if (i11 == 0) {
                zaaaVar.setText(resources.getString(com.google.android.gms.base.R$string.common_signin_button_text));
            } else if (i11 == 1) {
                zaaaVar.setText(resources.getString(com.google.android.gms.base.R$string.common_signin_button_text_long));
            } else {
                if (i11 != 2) {
                    throw new IllegalStateException(l0.j(i11, "Unknown button size: "));
                }
                zaaaVar.setText((CharSequence) null);
            }
            zaaaVar.setTransformationMethod(null);
            if (q6.a(zaaaVar.getContext())) {
                zaaaVar.setGravity(19);
            }
            this.f9073c = zaaaVar;
        }
        addView(this.f9073c);
        this.f9073c.setEnabled(isEnabled());
        this.f9073c.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        View.OnClickListener onClickListener = this.f9074d;
        if (onClickListener == null || view != this.f9073c) {
            return;
        }
        onClickListener.onClick(this);
    }

    public void setColorScheme(int i3) {
        a(this.f9071a, i3);
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        this.f9073c.setEnabled(z5);
    }

    @Override // android.view.View
    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f9074d = onClickListener;
        View view = this.f9073c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public void setScopes(Scope[] scopeArr) {
        a(this.f9071a, this.f9072b);
    }

    public void setSize(int i3) {
        a(i3, this.f9072b);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SignInButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f9074d = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.SignInButton, 0, 0);
        try {
            this.f9071a = obtainStyledAttributes.getInt(R$styleable.SignInButton_buttonSize, 0);
            this.f9072b = obtainStyledAttributes.getInt(R$styleable.SignInButton_colorScheme, 2);
            obtainStyledAttributes.recycle();
            a(this.f9071a, this.f9072b);
        } catch (Throwable th2) {
            obtainStyledAttributes.recycle();
            throw th2;
        }
    }
}
