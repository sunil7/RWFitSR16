package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.util.AttributeSet;
import android.widget.RadioButton;
import androidx.appcompat.R$attr;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;

/* loaded from: classes.dex */
public class AppCompatRadioButton extends RadioButton {

    /* renamed from: a, reason: collision with root package name */
    public final x f708a;

    /* renamed from: b, reason: collision with root package name */
    public final w f709b;

    /* renamed from: c, reason: collision with root package name */
    public final x0 f710c;

    /* renamed from: d, reason: collision with root package name */
    public a0 f711d;

    public AppCompatRadioButton(Context context) {
        this(context, null);
    }

    private a0 getEmojiTextViewHelper() {
        if (this.f711d == null) {
            this.f711d = new a0(this);
        }
        return this.f711d;
    }

    @Override // android.widget.CompoundButton, android.widget.TextView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f709b;
        if (wVar != null) {
            wVar.a();
        }
        x0 x0Var = this.f710c;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    @Override // android.widget.CompoundButton, android.widget.TextView
    public int getCompoundPaddingLeft() {
        int compoundPaddingLeft = super.getCompoundPaddingLeft();
        x xVar = this.f708a;
        if (xVar != null) {
            xVar.getClass();
        }
        return compoundPaddingLeft;
    }

    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f709b;
        if (wVar != null) {
            return wVar.i();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f709b;
        if (wVar != null) {
            return wVar.j();
        }
        return null;
    }

    public ColorStateList getSupportButtonTintList() {
        x xVar = this.f708a;
        if (xVar != null) {
            return xVar.f1083a;
        }
        return null;
    }

    public PorterDuff.Mode getSupportButtonTintMode() {
        x xVar = this.f708a;
        if (xVar != null) {
            return xVar.f1084b;
        }
        return null;
    }

    public ColorStateList getSupportCompoundDrawablesTintList() {
        return this.f710c.d();
    }

    public PorterDuff.Mode getSupportCompoundDrawablesTintMode() {
        return this.f710c.e();
    }

    @Override // android.widget.TextView
    public void setAllCaps(boolean z5) {
        super.setAllCaps(z5);
        getEmojiTextViewHelper().c(z5);
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f709b;
        if (wVar != null) {
            wVar.n();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        w wVar = this.f709b;
        if (wVar != null) {
            wVar.o(i3);
        }
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(Drawable drawable) {
        super.setButtonDrawable(drawable);
        x xVar = this.f708a;
        if (xVar != null) {
            if (xVar.e) {
                xVar.e = false;
            } else {
                xVar.e = true;
                xVar.a();
            }
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawables(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawables(drawable, drawable2, drawable3, drawable4);
        x0 x0Var = this.f710c;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    @Override // android.widget.TextView
    public final void setCompoundDrawablesRelative(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4) {
        super.setCompoundDrawablesRelative(drawable, drawable2, drawable3, drawable4);
        x0 x0Var = this.f710c;
        if (x0Var != null) {
            x0Var.b();
        }
    }

    public void setEmojiCompatEnabled(boolean z5) {
        getEmojiTextViewHelper().d(z5);
    }

    @Override // android.widget.TextView
    public void setFilters(InputFilter[] inputFilterArr) {
        super.setFilters(getEmojiTextViewHelper().a(inputFilterArr));
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        w wVar = this.f709b;
        if (wVar != null) {
            wVar.t(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        w wVar = this.f709b;
        if (wVar != null) {
            wVar.u(mode);
        }
    }

    public void setSupportButtonTintList(ColorStateList colorStateList) {
        x xVar = this.f708a;
        if (xVar != null) {
            xVar.f1083a = colorStateList;
            xVar.f1085c = true;
            xVar.a();
        }
    }

    public void setSupportButtonTintMode(PorterDuff.Mode mode) {
        x xVar = this.f708a;
        if (xVar != null) {
            xVar.f1084b = mode;
            xVar.f1086d = true;
            xVar.a();
        }
    }

    public void setSupportCompoundDrawablesTintList(ColorStateList colorStateList) {
        x0 x0Var = this.f710c;
        x0Var.l(colorStateList);
        x0Var.b();
    }

    public void setSupportCompoundDrawablesTintMode(PorterDuff.Mode mode) {
        x0 x0Var = this.f710c;
        x0Var.m(mode);
        x0Var.b();
    }

    public AppCompatRadioButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.radioButtonStyle);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public AppCompatRadioButton(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        m3.a(context);
        l3.a(getContext(), this);
        x xVar = new x(this);
        this.f708a = xVar;
        xVar.c(attributeSet, i3);
        w wVar = new w(this);
        this.f709b = wVar;
        wVar.l(attributeSet, i3);
        x0 x0Var = new x0(this);
        this.f710c = x0Var;
        x0Var.f(attributeSet, i3);
        getEmojiTextViewHelper().b(attributeSet, i3);
    }

    @Override // android.widget.CompoundButton
    public void setButtonDrawable(int i3) {
        setButtonDrawable(pb.b(getContext(), i3));
    }
}
