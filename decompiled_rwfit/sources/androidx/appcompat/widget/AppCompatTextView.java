package androidx.appcompat.widget;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.InputFilter;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

/* loaded from: classes.dex */
public class AppCompatTextView extends TextView {

    /* renamed from: a, reason: collision with root package name */
    public final w f723a;

    /* renamed from: b, reason: collision with root package name */
    public final x0 f724b;

    /* renamed from: c, reason: collision with root package name */
    public final d0 f725c;

    /* renamed from: d, reason: collision with root package name */
    public a0 f726d;
    public boolean e;

    /* renamed from: f, reason: collision with root package name */
    public y2.f f727f;

    /* renamed from: g, reason: collision with root package name */
    public Future f728g;

    public AppCompatTextView(Context context) {
        this(context, null);
    }

    private a0 getEmojiTextViewHelper() {
        if (this.f726d == null) {
            this.f726d = new a0(this);
        }
        return this.f726d;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f723a;
        if (wVar != null) {
            wVar.a();
        }
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    public final void f() {
        Future future = this.f728g;
        if (future == null) {
            return;
        }
        try {
            this.f728g = null;
            if (future.get() != null) {
                throw new ClassCastException();
            }
            if (Build.VERSION.SDK_INT >= 29) {
                throw null;
            }
            com.google.android.gms.internal.mlkit_common.m.a(this);
            throw null;
        } catch (InterruptedException | ExecutionException unused) {
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b4.f876b) {
            return super.getAutoSizeMaxTextSize();
        }
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            return Math.round(x0Var.f1095i.e);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeMinTextSize() {
        if (b4.f876b) {
            return super.getAutoSizeMinTextSize();
        }
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            return Math.round(x0Var.f1095i.f917d);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int getAutoSizeStepGranularity() {
        if (b4.f876b) {
            return super.getAutoSizeStepGranularity();
        }
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            return Math.round(x0Var.f1095i.f916c);
        }
        return -1;
    }

    @Override // android.widget.TextView
    public int[] getAutoSizeTextAvailableSizes() {
        if (b4.f876b) {
            return super.getAutoSizeTextAvailableSizes();
        }
        x0 x0Var = this.f724b;
        return x0Var != null ? x0Var.f1095i.f918f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b4.f876b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            return x0Var.f1095i.f914a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return com.google.android.gms.internal.mlkit_common.m.d(super.getCustomSelectionActionModeCallback());
    }

    @Override // android.widget.TextView
    public int getFirstBaselineToTopHeight() {
        return getPaddingTop() - getPaint().getFontMetricsInt().top;
    }

    @Override // android.widget.TextView
    public int getLastBaselineToBottomHeight() {
        return getPaddingBottom() + getPaint().getFontMetricsInt().bottom;
    }

    public y0 getSuperCaller() {
        if (this.f727f == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                this.f727f = new z0(this);
            } else {
                this.f727f = new y2.f(this, 3);
            }
        }
        return this.f727f;
    }

    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f723a;
        if (wVar != null) {
            return wVar.i();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f723a;
        if (wVar != null) {
            return wVar.j();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f724b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f724b.e();
    }

    @Override // android.widget.TextView
    public CharSequence getText() {
        f();
        return super.getText();
    }

    @Override // android.widget.TextView
    public TextClassifier getTextClassifier() {
        d0 d0Var;
        if (Build.VERSION.SDK_INT >= 28 || (d0Var = this.f725c) == null) {
            return super.getTextClassifier();
        }
        TextClassifier textClassifier = (TextClassifier) d0Var.f884c;
        return textClassifier == null ? r0.a((TextView) d0Var.f883b) : textClassifier;
    }

    public j1.d getTextMetricsParamsCompat() {
        return com.google.android.gms.internal.mlkit_common.m.a(this);
    }

    @Override // android.widget.TextView, android.view.View
    public final InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        this.f724b.getClass();
        x0.h(editorInfo, onCreateInputConnection, this);
        ca.f.a(editorInfo, onCreateInputConnection, this);
        return onCreateInputConnection;
    }

    @Override // android.widget.TextView, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        x0 x0Var = this.f724b;
        if (x0Var == null || b4.f876b) {
            return;
        }
        x0Var.f1095i.a();
    }

    @Override // android.widget.TextView, android.view.View
    public void onMeasure(int i3, int i10) {
        f();
        super.onMeasure(i3, i10);
    }

    @Override // android.widget.TextView
    public final void onTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        super.onTextChanged(charSequence, i3, i10, i11);
        x0 x0Var = this.f724b;
        if (x0Var == null || b4.f876b) {
            return;
        }
        h1 h1Var = x0Var.f1095i;
        if (h1Var.f()) {
            h1Var.a();
        }
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z5) {
        super.setAllCaps(z5);
        getEmojiTextViewHelper().c(z5);
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithConfiguration(int i3, int i10, int i11, int i12) {
        if (b4.f876b) {
            super.setAutoSizeTextTypeUniformWithConfiguration(i3, i10, i11, i12);
            return;
        }
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            x0Var.i(i3, i10, i11, i12);
        }
    }

    @Override // android.widget.TextView
    public final void setAutoSizeTextTypeUniformWithPresetSizes(int[] iArr, int i3) {
        if (b4.f876b) {
            super.setAutoSizeTextTypeUniformWithPresetSizes(iArr, i3);
            return;
        }
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            x0Var.j(iArr, i3);
        }
    }

    @Override // android.widget.TextView
    public void setAutoSizeTextTypeWithDefaults(int i3) {
        if (b4.f876b) {
            super.setAutoSizeTextTypeWithDefaults(i3);
            return;
        }
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            x0Var.k(i3);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f723a;
        if (wVar != null) {
            wVar.n();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        w wVar = this.f723a;
        if (wVar != null) {
            wVar.o(i3);
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    @Override // android.widget.TextView
    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {
        super.setCustomSelectionActionModeCallback(com.google.android.gms.internal.mlkit_common.m.e(callback, this));
    }

    public void setEmojiCompatEnabled(boolean z5) {
        getEmojiTextViewHelper().d(z5);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    @Override // android.widget.TextView
    public void setFirstBaselineToTopHeight(int i3) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().b(i3);
        } else {
            com.google.android.gms.internal.mlkit_common.m.b(this, i3);
        }
    }

    @Override // android.widget.TextView
    public void setLastBaselineToBottomHeight(int i3) {
        if (Build.VERSION.SDK_INT >= 28) {
            getSuperCaller().a(i3);
        } else {
            com.google.android.gms.internal.mlkit_common.m.c(this, i3);
        }
    }

    @Override // android.widget.TextView
    public void setLineHeight(int i3) {
        pd.d(i3);
        if (i3 != getPaint().getFontMetricsInt(null)) {
            setLineSpacing(i3 - r0, 1.0f);
        }
    }

    public void setPrecomputedText(j1.e eVar) {
        if (Build.VERSION.SDK_INT >= 29) {
            throw null;
        }
        com.google.android.gms.internal.mlkit_common.m.a(this);
        throw null;
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        w wVar = this.f723a;
        if (wVar != null) {
            wVar.t(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        w wVar = this.f723a;
        if (wVar != null) {
            wVar.u(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        x0 x0Var = this.f724b;
        x0Var.l(colorStateList);
        x0Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        x0 x0Var = this.f724b;
        x0Var.m(mode);
        x0Var.b();
    }

    @Override // android.widget.TextView
    public void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            x0Var.g(context, i3);
        }
    }

    @Override // android.widget.TextView
    public void setTextClassifier(TextClassifier textClassifier) {
        d0 d0Var;
        if (Build.VERSION.SDK_INT >= 28 || (d0Var = this.f725c) == null) {
            super.setTextClassifier(textClassifier);
        } else {
            d0Var.f884c = textClassifier;
        }
    }

    public void setTextFuture(Future<j1.e> future) {
        this.f728g = future;
        if (future != null) {
            requestLayout();
        }
    }

    public void setTextMetricsParamsCompat(j1.d dVar) {
        TextDirectionHeuristic textDirectionHeuristic;
        TextDirectionHeuristic textDirectionHeuristic2 = dVar.f15173b;
        TextDirectionHeuristic textDirectionHeuristic3 = TextDirectionHeuristics.FIRSTSTRONG_RTL;
        int i3 = 1;
        if (textDirectionHeuristic2 != textDirectionHeuristic3 && textDirectionHeuristic2 != (textDirectionHeuristic = TextDirectionHeuristics.FIRSTSTRONG_LTR)) {
            if (textDirectionHeuristic2 == TextDirectionHeuristics.ANYRTL_LTR) {
                i3 = 2;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LTR) {
                i3 = 3;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.RTL) {
                i3 = 4;
            } else if (textDirectionHeuristic2 == TextDirectionHeuristics.LOCALE) {
                i3 = 5;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic) {
                i3 = 6;
            } else if (textDirectionHeuristic2 == textDirectionHeuristic3) {
                i3 = 7;
            }
        }
        androidx.core.widget.q.h(this, i3);
        getPaint().set(dVar.f15172a);
        androidx.core.widget.r.e(this, dVar.f15174c);
        androidx.core.widget.r.h(this, dVar.f15175d);
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i3, float f2) {
        boolean z5 = b4.f876b;
        if (z5) {
            super.setTextSize(i3, f2);
            return;
        }
        x0 x0Var = this.f724b;
        if (x0Var == null || z5) {
            return;
        }
        h1 h1Var = x0Var.f1095i;
        if (h1Var.f()) {
            return;
        }
        h1Var.g(f2, i3);
    }

    @Override // android.widget.TextView
    public final void setTypeface(Typeface typeface, int i3) {
        Typeface typeface2;
        if (this.e) {
            return;
        }
        if (typeface == null || i3 <= 0) {
            typeface2 = null;
        } else {
            Context context = getContext();
            com.google.android.gms.internal.mlkit_vision_barcode.d1 d1Var = c1.f.f3359a;
            if (context == null) {
                throw new IllegalArgumentException("Context cannot be null");
            }
            typeface2 = Typeface.create(typeface, i3);
        }
        this.e = true;
        if (typeface2 != null) {
            typeface = typeface2;
        }
        try {
            super.setTypeface(typeface, i3);
        } finally {
            this.e = false;
        }
    }

    public AppCompatTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textViewStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatTextView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        m3.a(context);
        this.e = false;
        this.f727f = null;
        l3.a(getContext(), this);
        w wVar = new w(this);
        this.f723a = wVar;
        wVar.l(attributeSet, i3);
        x0 x0Var = new x0(this);
        this.f724b = x0Var;
        x0Var.f(attributeSet, i3);
        x0Var.b();
        d0 d0Var = new d0();
        d0Var.f883b = this;
        this.f725c = d0Var;
        getEmojiTextViewHelper().b(attributeSet, i3);
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelativeWithIntrinsicBounds(int i3, int i10, int i11, int i12) {
        Context context = getContext();
        setCompoundDrawablesRelativeWithIntrinsicBounds(i3 != 0 ? pb.b(context, i3) : null, i10 != 0 ? pb.b(context, i10) : null, i11 != 0 ? pb.b(context, i11) : null, i12 != 0 ? pb.b(context, i12) : null);
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesWithIntrinsicBounds(int i3, int i10, int i11, int i12) {
        Context context = getContext();
        setCompoundDrawablesWithIntrinsicBounds(i3 != 0 ? pb.b(context, i3) : null, i10 != 0 ? pb.b(context, i10) : null, i11 != 0 ? pb.b(context, i11) : null, i12 != 0 ? pb.b(context, i12) : null);
        x0 x0Var = this.f724b;
        if (x0Var != null) {
            x0Var.b();
        }
    }
}
