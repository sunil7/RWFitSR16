package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.s;
import androidx.customview.view.AbsSavedState;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.rb;
import com.google.android.material.R$style;
import com.google.android.material.internal.NavigationMenuView;
import com.google.android.material.internal.ScrimInsetsFrameLayout;
import com.google.android.material.internal.n;
import h.m;
import l1.x1;
import l1.z0;

/* loaded from: classes.dex */
public class NavigationView extends ScrimInsetsFrameLayout {

    /* renamed from: m, reason: collision with root package name */
    public static final int[] f10688m = {R.attr.state_checked};

    /* renamed from: n, reason: collision with root package name */
    public static final int[] f10689n = {-16842910};

    /* renamed from: o, reason: collision with root package name */
    public static final int f10690o = R$style.Widget_Design_NavigationView;

    /* renamed from: f, reason: collision with root package name */
    public final com.google.android.material.internal.d f10691f;

    /* renamed from: g, reason: collision with root package name */
    public final n f10692g;

    /* renamed from: h, reason: collision with root package name */
    public h f10693h;

    /* renamed from: i, reason: collision with root package name */
    public final int f10694i;

    /* renamed from: j, reason: collision with root package name */
    public final int[] f10695j;

    /* renamed from: k, reason: collision with root package name */
    public g.i f10696k;

    /* renamed from: l, reason: collision with root package name */
    public final s f10697l;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new i();
        public Bundle menuState;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.menuState = parcel.readBundle(classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeBundle(this.menuState);
        }
    }

    public NavigationView(Context context) {
        this(context, null);
    }

    private MenuInflater getMenuInflater() {
        if (this.f10696k == null) {
            this.f10696k = new g.i(getContext());
        }
        return this.f10696k;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout
    public final void a(x1 x1Var) {
        n nVar = this.f10692g;
        nVar.getClass();
        int d5 = x1Var.d();
        if (nVar.r != d5) {
            nVar.r = d5;
            int i3 = (nVar.f10601b.getChildCount() == 0 && nVar.f10614p) ? nVar.r : 0;
            NavigationMenuView navigationMenuView = nVar.f10600a;
            navigationMenuView.setPadding(0, i3, 0, navigationMenuView.getPaddingBottom());
        }
        NavigationMenuView navigationMenuView2 = nVar.f10600a;
        navigationMenuView2.setPadding(0, navigationMenuView2.getPaddingTop(), 0, x1Var.a());
        z0.b(nVar.f10601b, x1Var);
    }

    public final ColorStateList b(int i3) {
        TypedValue typedValue = new TypedValue();
        if (!getContext().getTheme().resolveAttribute(i3, typedValue, true)) {
            return null;
        }
        ColorStateList a3 = pb.a(getContext(), typedValue.resourceId);
        if (!getContext().getTheme().resolveAttribute(R$attr.colorPrimary, typedValue, true)) {
            return null;
        }
        int i10 = typedValue.data;
        int defaultColor = a3.getDefaultColor();
        int[] iArr = f10689n;
        return new ColorStateList(new int[][]{iArr, f10688m, FrameLayout.EMPTY_STATE_SET}, new int[]{a3.getColorForState(iArr, defaultColor), i10, defaultColor});
    }

    public final View c() {
        return this.f10692g.f10601b.getChildAt(0);
    }

    public MenuItem getCheckedItem() {
        return this.f10692g.e.f10592b;
    }

    public int getHeaderCount() {
        return this.f10692g.f10601b.getChildCount();
    }

    public Drawable getItemBackground() {
        return this.f10692g.f10609k;
    }

    public int getItemHorizontalPadding() {
        return this.f10692g.f10610l;
    }

    public int getItemIconPadding() {
        return this.f10692g.f10611m;
    }

    public ColorStateList getItemIconTintList() {
        return this.f10692g.f10608j;
    }

    public int getItemMaxLines() {
        return this.f10692g.f10615q;
    }

    public ColorStateList getItemTextColor() {
        return this.f10692g.f10607i;
    }

    public Menu getMenu() {
        return this.f10691f;
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        rb.d(this);
    }

    @Override // com.google.android.material.internal.ScrimInsetsFrameLayout, android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getViewTreeObserver().removeOnGlobalLayoutListener(this.f10697l);
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        int mode = View.MeasureSpec.getMode(i3);
        int i11 = this.f10694i;
        if (mode == Integer.MIN_VALUE) {
            i3 = View.MeasureSpec.makeMeasureSpec(Math.min(View.MeasureSpec.getSize(i3), i11), 1073741824);
        } else if (mode == 0) {
            i3 = View.MeasureSpec.makeMeasureSpec(i11, 1073741824);
        }
        super.onMeasure(i3, i10);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f10691f.t(savedState.menuState);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.menuState = bundle;
        this.f10691f.v(bundle);
        return savedState;
    }

    public void setCheckedItem(int i3) {
        MenuItem findItem = this.f10691f.findItem(i3);
        if (findItem != null) {
            this.f10692g.e.b((m) findItem);
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        rb.b(this, f2);
    }

    public void setItemBackground(Drawable drawable) {
        n nVar = this.f10692g;
        nVar.f10609k = drawable;
        nVar.g(false);
    }

    public void setItemBackgroundResource(int i3) {
        setItemBackground(a1.c.b(getContext(), i3));
    }

    public void setItemHorizontalPadding(int i3) {
        n nVar = this.f10692g;
        nVar.f10610l = i3;
        nVar.g(false);
    }

    public void setItemHorizontalPaddingResource(int i3) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i3);
        n nVar = this.f10692g;
        nVar.f10610l = dimensionPixelSize;
        nVar.g(false);
    }

    public void setItemIconPadding(int i3) {
        n nVar = this.f10692g;
        nVar.f10611m = i3;
        nVar.g(false);
    }

    public void setItemIconPaddingResource(int i3) {
        int dimensionPixelSize = getResources().getDimensionPixelSize(i3);
        n nVar = this.f10692g;
        nVar.f10611m = dimensionPixelSize;
        nVar.g(false);
    }

    public void setItemIconSize(int i3) {
        n nVar = this.f10692g;
        if (nVar.f10612n != i3) {
            nVar.f10612n = i3;
            nVar.f10613o = true;
            nVar.g(false);
        }
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        n nVar = this.f10692g;
        nVar.f10608j = colorStateList;
        nVar.g(false);
    }

    public void setItemMaxLines(int i3) {
        n nVar = this.f10692g;
        nVar.f10615q = i3;
        nVar.g(false);
    }

    public void setItemTextAppearance(int i3) {
        n nVar = this.f10692g;
        nVar.f10605g = i3;
        nVar.f10606h = true;
        nVar.g(false);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        n nVar = this.f10692g;
        nVar.f10607i = colorStateList;
        nVar.g(false);
    }

    public void setNavigationItemSelectedListener(h hVar) {
        this.f10693h = hVar;
    }

    @Override // android.view.View
    public void setOverScrollMode(int i3) {
        super.setOverScrollMode(i3);
        n nVar = this.f10692g;
        if (nVar != null) {
            nVar.f10617t = i3;
            NavigationMenuView navigationMenuView = nVar.f10600a;
            if (navigationMenuView != null) {
                navigationMenuView.setOverScrollMode(i3);
            }
        }
    }

    public NavigationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, com.google.android.material.R$attr.navigationViewStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public NavigationView(android.content.Context r21, android.util.AttributeSet r22, int r23) {
        /*
            Method dump skipped, instructions count: 619
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.navigation.NavigationView.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setCheckedItem(MenuItem menuItem) {
        MenuItem findItem = this.f10691f.findItem(menuItem.getItemId());
        if (findItem != null) {
            this.f10692g.e.b((m) findItem);
            return;
        }
        throw new IllegalArgumentException("Called setCheckedItem(MenuItem) with an item that is not in the current menu.");
    }
}
