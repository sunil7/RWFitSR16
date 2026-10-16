package com.google.android.material.textfield;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.Property;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import com.google.android.gms.internal.mlkit_vision_barcode.nd;
import com.google.android.gms.internal.mlkit_vision_barcode.t0;
import com.google.android.material.R$dimen;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.i0;
import l1.k0;
import l1.z0;

/* loaded from: classes.dex */
public final class o {

    /* renamed from: a, reason: collision with root package name */
    public final Context f10928a;

    /* renamed from: b, reason: collision with root package name */
    public final TextInputLayout f10929b;

    /* renamed from: c, reason: collision with root package name */
    public LinearLayout f10930c;

    /* renamed from: d, reason: collision with root package name */
    public int f10931d;
    public FrameLayout e;

    /* renamed from: f, reason: collision with root package name */
    public AnimatorSet f10932f;

    /* renamed from: g, reason: collision with root package name */
    public final float f10933g;

    /* renamed from: h, reason: collision with root package name */
    public int f10934h;

    /* renamed from: i, reason: collision with root package name */
    public int f10935i;

    /* renamed from: j, reason: collision with root package name */
    public CharSequence f10936j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10937k;

    /* renamed from: l, reason: collision with root package name */
    public AppCompatTextView f10938l;

    /* renamed from: m, reason: collision with root package name */
    public CharSequence f10939m;

    /* renamed from: n, reason: collision with root package name */
    public int f10940n;

    /* renamed from: o, reason: collision with root package name */
    public ColorStateList f10941o;

    /* renamed from: p, reason: collision with root package name */
    public CharSequence f10942p;

    /* renamed from: q, reason: collision with root package name */
    public boolean f10943q;
    public AppCompatTextView r;

    /* renamed from: s, reason: collision with root package name */
    public int f10944s;

    /* renamed from: t, reason: collision with root package name */
    public ColorStateList f10945t;

    /* renamed from: u, reason: collision with root package name */
    public Typeface f10946u;

    public o(TextInputLayout textInputLayout) {
        this.f10928a = textInputLayout.getContext();
        this.f10929b = textInputLayout;
        this.f10933g = r0.getResources().getDimensionPixelSize(R$dimen.design_textinput_caption_translate_y);
    }

    public final void a(AppCompatTextView appCompatTextView, int i3) {
        if (this.f10930c == null && this.e == null) {
            Context context = this.f10928a;
            LinearLayout linearLayout = new LinearLayout(context);
            this.f10930c = linearLayout;
            linearLayout.setOrientation(0);
            LinearLayout linearLayout2 = this.f10930c;
            TextInputLayout textInputLayout = this.f10929b;
            textInputLayout.addView(linearLayout2, -1, -2);
            this.e = new FrameLayout(context);
            this.f10930c.addView(this.e, new LinearLayout.LayoutParams(0, -2, 1.0f));
            if (textInputLayout.getEditText() != null) {
                b();
            }
        }
        if (i3 == 0 || i3 == 1) {
            this.e.setVisibility(0);
            this.e.addView(appCompatTextView);
        } else {
            this.f10930c.addView(appCompatTextView, new LinearLayout.LayoutParams(-2, -2));
        }
        this.f10930c.setVisibility(0);
        this.f10931d++;
    }

    public final void b() {
        if (this.f10930c != null) {
            TextInputLayout textInputLayout = this.f10929b;
            if (textInputLayout.getEditText() != null) {
                EditText editText = textInputLayout.getEditText();
                Context context = this.f10928a;
                boolean e = t0.e(context);
                LinearLayout linearLayout = this.f10930c;
                int i3 = R$dimen.material_helper_text_font_1_3_padding_horizontal;
                WeakHashMap weakHashMap = z0.f15748a;
                int f2 = i0.f(editText);
                if (e) {
                    f2 = context.getResources().getDimensionPixelSize(i3);
                }
                int i10 = R$dimen.material_helper_text_font_1_3_padding_top;
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.material_helper_text_default_padding_top);
                if (e) {
                    dimensionPixelSize = context.getResources().getDimensionPixelSize(i10);
                }
                int i11 = R$dimen.material_helper_text_font_1_3_padding_horizontal;
                int e10 = i0.e(editText);
                if (e) {
                    e10 = context.getResources().getDimensionPixelSize(i11);
                }
                i0.k(linearLayout, f2, dimensionPixelSize, e10, 0);
            }
        }
    }

    public final void c() {
        AnimatorSet animatorSet = this.f10932f;
        if (animatorSet != null) {
            animatorSet.cancel();
        }
    }

    public final void d(ArrayList arrayList, boolean z5, AppCompatTextView appCompatTextView, int i3, int i10, int i11) {
        if (appCompatTextView == null || !z5) {
            return;
        }
        if (i3 == i11 || i3 == i10) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.ALPHA, i11 == i3 ? 1.0f : 0.0f);
            ofFloat.setDuration(167L);
            ofFloat.setInterpolator(ja.a.f15383a);
            arrayList.add(ofFloat);
            if (i11 == i3) {
                ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(appCompatTextView, (Property<AppCompatTextView, Float>) View.TRANSLATION_Y, -this.f10933g, 0.0f);
                ofFloat2.setDuration(217L);
                ofFloat2.setInterpolator(ja.a.f15386d);
                arrayList.add(ofFloat2);
            }
        }
    }

    public final boolean e() {
        return (this.f10935i != 1 || this.f10938l == null || TextUtils.isEmpty(this.f10936j)) ? false : true;
    }

    public final TextView f(int i3) {
        if (i3 == 1) {
            return this.f10938l;
        }
        if (i3 != 2) {
            return null;
        }
        return this.r;
    }

    public final void g() {
        this.f10936j = null;
        c();
        if (this.f10934h == 1) {
            if (!this.f10943q || TextUtils.isEmpty(this.f10942p)) {
                this.f10935i = 0;
            } else {
                this.f10935i = 2;
            }
        }
        j(this.f10934h, this.f10935i, i(this.f10938l, null));
    }

    public final void h(AppCompatTextView appCompatTextView, int i3) {
        FrameLayout frameLayout;
        LinearLayout linearLayout = this.f10930c;
        if (linearLayout == null) {
            return;
        }
        if ((i3 == 0 || i3 == 1) && (frameLayout = this.e) != null) {
            frameLayout.removeView(appCompatTextView);
        } else {
            linearLayout.removeView(appCompatTextView);
        }
        int i10 = this.f10931d - 1;
        this.f10931d = i10;
        LinearLayout linearLayout2 = this.f10930c;
        if (i10 == 0) {
            linearLayout2.setVisibility(8);
        }
    }

    public final boolean i(AppCompatTextView appCompatTextView, CharSequence charSequence) {
        WeakHashMap weakHashMap = z0.f15748a;
        TextInputLayout textInputLayout = this.f10929b;
        if (k0.c(textInputLayout) && textInputLayout.isEnabled()) {
            return (this.f10935i == this.f10934h && appCompatTextView != null && TextUtils.equals(appCompatTextView.getText(), charSequence)) ? false : true;
        }
        return false;
    }

    public final void j(int i3, int i10, boolean z5) {
        TextView f2;
        TextView f10;
        if (i3 == i10) {
            return;
        }
        if (z5) {
            AnimatorSet animatorSet = new AnimatorSet();
            this.f10932f = animatorSet;
            ArrayList arrayList = new ArrayList();
            d(arrayList, this.f10943q, this.r, 2, i3, i10);
            d(arrayList, this.f10937k, this.f10938l, 1, i3, i10);
            nd.a(animatorSet, arrayList);
            animatorSet.addListener(new n(this, i10, f(i3), i3, f(i10)));
            animatorSet.start();
        } else if (i3 != i10) {
            if (i10 != 0 && (f10 = f(i10)) != null) {
                f10.setVisibility(0);
                f10.setAlpha(1.0f);
            }
            if (i3 != 0 && (f2 = f(i3)) != null) {
                f2.setVisibility(4);
                if (i3 == 1) {
                    f2.setText((CharSequence) null);
                }
            }
            this.f10934h = i10;
        }
        TextInputLayout textInputLayout = this.f10929b;
        textInputLayout.q();
        textInputLayout.s(z5, false);
        textInputLayout.z();
    }
}
