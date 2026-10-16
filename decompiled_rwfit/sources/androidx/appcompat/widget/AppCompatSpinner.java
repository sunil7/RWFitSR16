package androidx.appcompat.widget;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ListAdapter;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.ThemedSpinnerAdapter;
import androidx.appcompat.R$attr;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;

/* loaded from: classes.dex */
public class AppCompatSpinner extends Spinner {

    /* renamed from: i, reason: collision with root package name */
    public static final int[] f714i = {R.attr.spinnerMode};

    /* renamed from: a, reason: collision with root package name */
    public final w f715a;

    /* renamed from: b, reason: collision with root package name */
    public final Context f716b;

    /* renamed from: c, reason: collision with root package name */
    public final g0 f717c;

    /* renamed from: d, reason: collision with root package name */
    public SpinnerAdapter f718d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final q0 f719f;

    /* renamed from: g, reason: collision with root package name */
    public int f720g;

    /* renamed from: h, reason: collision with root package name */
    public final Rect f721h;

    public static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new p0();

        /* renamed from: a, reason: collision with root package name */
        public boolean f722a;

        @Override // android.view.View.BaseSavedState, android.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeByte(this.f722a ? (byte) 1 : (byte) 0);
        }
    }

    public AppCompatSpinner(Context context) {
        this(context, null);
    }

    public final int a(SpinnerAdapter spinnerAdapter, Drawable drawable) {
        int i3 = 0;
        if (spinnerAdapter == null) {
            return 0;
        }
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
        int max = Math.max(0, getSelectedItemPosition());
        int min = Math.min(spinnerAdapter.getCount(), max + 15);
        View view = null;
        int i10 = 0;
        for (int max2 = Math.max(0, max - (15 - (min - max))); max2 < min; max2++) {
            int itemViewType = spinnerAdapter.getItemViewType(max2);
            if (itemViewType != i3) {
                view = null;
                i3 = itemViewType;
            }
            view = spinnerAdapter.getView(max2, view, this);
            if (view.getLayoutParams() == null) {
                view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            }
            view.measure(makeMeasureSpec, makeMeasureSpec2);
            i10 = Math.max(i10, view.getMeasuredWidth());
        }
        if (drawable == null) {
            return i10;
        }
        Rect rect = this.f721h;
        drawable.getPadding(rect);
        return rect.left + rect.right + i10;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        w wVar = this.f715a;
        if (wVar != null) {
            wVar.a();
        }
    }

    @Override // android.widget.Spinner
    public int getDropDownHorizontalOffset() {
        q0 q0Var = this.f719f;
        return q0Var != null ? q0Var.b() : super.getDropDownHorizontalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownVerticalOffset() {
        q0 q0Var = this.f719f;
        return q0Var != null ? q0Var.l() : super.getDropDownVerticalOffset();
    }

    @Override // android.widget.Spinner
    public int getDropDownWidth() {
        return this.f719f != null ? this.f720g : super.getDropDownWidth();
    }

    public final q0 getInternalPopup() {
        return this.f719f;
    }

    @Override // android.widget.Spinner
    public Drawable getPopupBackground() {
        q0 q0Var = this.f719f;
        return q0Var != null ? q0Var.c() : super.getPopupBackground();
    }

    @Override // android.widget.Spinner
    public Context getPopupContext() {
        return this.f716b;
    }

    @Override // android.widget.Spinner
    public CharSequence getPrompt() {
        q0 q0Var = this.f719f;
        return q0Var != null ? q0Var.o() : super.getPrompt();
    }

    public ColorStateList getSupportBackgroundTintList() {
        w wVar = this.f715a;
        if (wVar != null) {
            return wVar.i();
        }
        return null;
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        w wVar = this.f715a;
        if (wVar != null) {
            return wVar.j();
        }
        return null;
    }

    @Override // android.widget.Spinner, android.widget.AdapterView, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        q0 q0Var = this.f719f;
        if (q0Var == null || !q0Var.a()) {
            return;
        }
        q0Var.dismiss();
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        if (this.f719f == null || View.MeasureSpec.getMode(i3) != Integer.MIN_VALUE) {
            return;
        }
        setMeasuredDimension(Math.min(Math.max(getMeasuredWidth(), a(getAdapter(), getBackground())), View.MeasureSpec.getSize(i3)), getMeasuredHeight());
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        ViewTreeObserver viewTreeObserver;
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        if (!savedState.f722a || (viewTreeObserver = getViewTreeObserver()) == null) {
            return;
        }
        viewTreeObserver.addOnGlobalLayoutListener(new s(this, 1));
    }

    @Override // android.widget.Spinner, android.widget.AbsSpinner, android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        q0 q0Var = this.f719f;
        savedState.f722a = q0Var != null && q0Var.a();
        return savedState;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        g0 g0Var = this.f717c;
        if (g0Var == null || !g0Var.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    @Override // android.widget.Spinner, android.view.View
    public final boolean performClick() {
        q0 q0Var = this.f719f;
        if (q0Var == null) {
            return super.performClick();
        }
        if (q0Var.a()) {
            return true;
        }
        this.f719f.k(i0.b(this), i0.a(this));
        return true;
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        super.setBackgroundDrawable(drawable);
        w wVar = this.f715a;
        if (wVar != null) {
            wVar.n();
        }
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        super.setBackgroundResource(i3);
        w wVar = this.f715a;
        if (wVar != null) {
            wVar.o(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownHorizontalOffset(int i3) {
        q0 q0Var = this.f719f;
        if (q0Var == null) {
            super.setDropDownHorizontalOffset(i3);
        } else {
            q0Var.i(i3);
            q0Var.j(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownVerticalOffset(int i3) {
        q0 q0Var = this.f719f;
        if (q0Var != null) {
            q0Var.h(i3);
        } else {
            super.setDropDownVerticalOffset(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setDropDownWidth(int i3) {
        if (this.f719f != null) {
            this.f720g = i3;
        } else {
            super.setDropDownWidth(i3);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundDrawable(Drawable drawable) {
        q0 q0Var = this.f719f;
        if (q0Var != null) {
            q0Var.g(drawable);
        } else {
            super.setPopupBackgroundDrawable(drawable);
        }
    }

    @Override // android.widget.Spinner
    public void setPopupBackgroundResource(int i3) {
        setPopupBackgroundDrawable(pb.b(getPopupContext(), i3));
    }

    @Override // android.widget.Spinner
    public void setPrompt(CharSequence charSequence) {
        q0 q0Var = this.f719f;
        if (q0Var != null) {
            q0Var.e(charSequence);
        } else {
            super.setPrompt(charSequence);
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        w wVar = this.f715a;
        if (wVar != null) {
            wVar.t(colorStateList);
        }
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        w wVar = this.f715a;
        if (wVar != null) {
            wVar.u(mode);
        }
    }

    public AppCompatSpinner(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.spinnerStyle);
    }

    @Override // android.widget.AdapterView
    public void setAdapter(SpinnerAdapter spinnerAdapter) {
        if (!this.e) {
            this.f718d = spinnerAdapter;
            return;
        }
        super.setAdapter(spinnerAdapter);
        q0 q0Var = this.f719f;
        if (q0Var != null) {
            Context context = this.f716b;
            if (context == null) {
                context = getContext();
            }
            Resources.Theme theme = context.getTheme();
            l0 l0Var = new l0();
            l0Var.f976a = spinnerAdapter;
            if (spinnerAdapter instanceof ListAdapter) {
                l0Var.f977b = (ListAdapter) spinnerAdapter;
            }
            if (theme != null && (spinnerAdapter instanceof ThemedSpinnerAdapter)) {
                j0.a((ThemedSpinnerAdapter) spinnerAdapter, theme);
            }
            q0Var.p(l0Var);
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x005e, code lost:
    
        if (r5 == null) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00de  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public AppCompatSpinner(android.content.Context r10, android.util.AttributeSet r11, int r12) {
        /*
            Method dump skipped, instructions count: 226
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.AppCompatSpinner.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
