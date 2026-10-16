package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;

/* loaded from: classes.dex */
public final class o0 extends ListPopupWindow implements q0 {
    public CharSequence C;
    public l0 D;
    public final Rect E;
    public int F;
    public final /* synthetic */ AppCompatSpinner G;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public o0(AppCompatSpinner appCompatSpinner, Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.G = appCompatSpinner;
        this.E = new Rect();
        this.f769o = appCompatSpinner;
        this.f778y = true;
        this.f779z.setFocusable(true);
        setOnItemClickListener(new m0(this, 0));
    }

    @Override // androidx.appcompat.widget.q0
    public final void e(CharSequence charSequence) {
        this.C = charSequence;
    }

    @Override // androidx.appcompat.widget.q0
    public final void i(int i3) {
        this.F = i3;
    }

    @Override // androidx.appcompat.widget.q0
    public final void k(int i3, int i10) {
        ViewTreeObserver viewTreeObserver;
        c0 c0Var = this.f779z;
        boolean isShowing = c0Var.isShowing();
        s();
        this.f779z.setInputMethodMode(2);
        d();
        t1 t1Var = this.f758c;
        t1Var.setChoiceMode(1);
        i0.d(t1Var, i3);
        i0.c(t1Var, i10);
        AppCompatSpinner appCompatSpinner = this.G;
        int selectedItemPosition = appCompatSpinner.getSelectedItemPosition();
        t1 t1Var2 = this.f758c;
        if (c0Var.isShowing() && t1Var2 != null) {
            t1Var2.setListSelectionHidden(false);
            t1Var2.setSelection(selectedItemPosition);
            if (t1Var2.getChoiceMode() != 0) {
                t1Var2.setItemChecked(selectedItemPosition, true);
            }
        }
        if (isShowing || (viewTreeObserver = appCompatSpinner.getViewTreeObserver()) == null) {
            return;
        }
        s sVar = new s(this, 2);
        viewTreeObserver.addOnGlobalLayoutListener(sVar);
        setOnDismissListener(new n0(this, sVar));
    }

    @Override // androidx.appcompat.widget.q0
    public final CharSequence o() {
        return this.C;
    }

    @Override // androidx.appcompat.widget.ListPopupWindow, androidx.appcompat.widget.q0
    public final void p(ListAdapter listAdapter) {
        super.p(listAdapter);
        this.D = (l0) listAdapter;
    }

    public final void s() {
        int i3;
        c0 c0Var = this.f779z;
        Drawable background = c0Var.getBackground();
        AppCompatSpinner appCompatSpinner = this.G;
        Rect rect = appCompatSpinner.f721h;
        if (background != null) {
            background.getPadding(rect);
            i3 = b4.a(appCompatSpinner) ? rect.right : -rect.left;
        } else {
            i3 = 0;
            rect.right = 0;
            rect.left = 0;
        }
        int paddingLeft = appCompatSpinner.getPaddingLeft();
        int paddingRight = appCompatSpinner.getPaddingRight();
        int width = appCompatSpinner.getWidth();
        int i10 = appCompatSpinner.f720g;
        if (i10 == -2) {
            int a3 = appCompatSpinner.a(this.D, c0Var.getBackground());
            int i11 = (appCompatSpinner.getContext().getResources().getDisplayMetrics().widthPixels - rect.left) - rect.right;
            if (a3 > i11) {
                a3 = i11;
            }
            r(Math.max(a3, (width - paddingLeft) - paddingRight));
        } else if (i10 == -1) {
            r((width - paddingLeft) - paddingRight);
        } else {
            r(i10);
        }
        this.f760f = b4.a(appCompatSpinner) ? (((width - paddingRight) - this.e) - this.F) + i3 : paddingLeft + this.F + i3;
    }
}
