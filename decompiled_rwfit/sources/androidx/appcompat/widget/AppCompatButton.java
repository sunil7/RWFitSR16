package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.Button;
import androidx.appcompat.R$attr;

/* loaded from: classes.dex */
public class AppCompatButton extends Button {

    /* renamed from: a, reason: collision with root package name */
    public final w f682a;

    /* renamed from: b, reason: collision with root package name */
    public final x0 f683b;

    /* renamed from: c, reason: collision with root package name */
    public a0 f684c;

    public AppCompatButton(Context context) {
        this(context, null);
    }

    private a0 getEmojiTextViewHelper() {
        if (this.f684c == null) {
            this.f684c = new a0(this);
        }
        return this.f684c;
    }

    @Override // android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f682a;
        if (wVar != null) {
            wVar.a();
        }
        x0 x0Var = this.f683b;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    @Override // android.widget.TextView
    public int getAutoSizeMaxTextSize() {
        if (b4.f876b) {
            return super.getAutoSizeMaxTextSize();
        }
        x0 x0Var = this.f683b;
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
        x0 x0Var = this.f683b;
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
        x0 x0Var = this.f683b;
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
        x0 x0Var = this.f683b;
        return x0Var != null ? x0Var.f1095i.f918f : new int[0];
    }

    @Override // android.widget.TextView
    @SuppressLint({"WrongConstant"})
    public int getAutoSizeTextType() {
        if (b4.f876b) {
            return super.getAutoSizeTextType() == 1 ? 1 : 0;
        }
        x0 x0Var = this.f683b;
        if (x0Var != null) {
            return x0Var.f1095i.f914a;
        }
        return 0;
    }

    @Override // android.widget.TextView
    public ActionMode.Callback getCustomSelectionActionModeCallback() {
        return com.google.android.gms.internal.mlkit_common.m.d(super.getCustomSelectionActionModeCallback());
    }

    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f682a;
        if (wVar != null) {
            return wVar.i();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f682a;
        if (wVar != null) {
            return wVar.j();
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f683b.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f683b.e();
    }

    @Override // android.view.View
    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(Button.class.getName());
    }

    @Override // android.view.View
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(Button.class.getName());
    }

    @Override // android.widget.TextView, android.view.View
    public void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        x0 x0Var = this.f683b;
        if (x0Var == null || b4.f876b) {
            return;
        }
        x0Var.f1095i.a();
    }

    @Override // android.widget.TextView
    public void onTextChanged(CharSequence charSequence, int i3, int i10, int i11) {
        super.onTextChanged(charSequence, i3, i10, i11);
        x0 x0Var = this.f683b;
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
        x0 x0Var = this.f683b;
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
        x0 x0Var = this.f683b;
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
        x0 x0Var = this.f683b;
        if (x0Var != null) {
            x0Var.k(i3);
        }
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f682a;
        if (wVar != null) {
            wVar.n();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        w wVar = this.f682a;
        if (wVar != null) {
            wVar.o(i3);
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

    public void setSupportAllCaps(boolean z5) {
        x0 x0Var = this.f683b;
        if (x0Var != null) {
            x0Var.f1088a.setAllCaps(z5);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        w wVar = this.f682a;
        if (wVar != null) {
            wVar.t(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        w wVar = this.f682a;
        if (wVar != null) {
            wVar.u(mode);
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        x0 x0Var = this.f683b;
        x0Var.l(colorStateList);
        x0Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        x0 x0Var = this.f683b;
        x0Var.m(mode);
        x0Var.b();
    }

    @Override // android.widget.TextView
    public final void setTextAppearance(Context context, int i3) {
        super.setTextAppearance(context, i3);
        x0 x0Var = this.f683b;
        if (x0Var != null) {
            x0Var.g(context, i3);
        }
    }

    @Override // android.widget.TextView
    public final void setTextSize(int i3, float f2) {
        boolean z5 = b4.f876b;
        if (z5) {
            super.setTextSize(i3, f2);
            return;
        }
        x0 x0Var = this.f683b;
        if (x0Var == null || z5) {
            return;
        }
        h1 h1Var = x0Var.f1095i;
        if (h1Var.f()) {
            return;
        }
        h1Var.g(f2, i3);
    }

    public AppCompatButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.buttonStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        m3.a(context);
        l3.a(getContext(), this);
        w wVar = new w(this);
        this.f682a = wVar;
        wVar.l(attributeSet, i3);
        x0 x0Var = new x0(this);
        this.f683b = x0Var;
        x0Var.f(attributeSet, i3);
        x0Var.b();
        getEmojiTextViewHelper().b(attributeSet, i3);
    }
}
