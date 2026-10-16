package com.google.android.material.navigation;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.FrameLayout;
import androidx.customview.view.AbsSavedState;
import com.example.test.ui.device.activity.e0;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import com.google.android.gms.internal.mlkit_vision_barcode.rb;
import com.google.android.gms.internal.mlkit_vision_barcode.t0;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.w;
import de.o;
import h.z;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;

/* loaded from: classes.dex */
public abstract class NavigationBarView extends FrameLayout {

    /* renamed from: f, reason: collision with root package name */
    public static final /* synthetic */ int f10682f = 0;

    /* renamed from: a, reason: collision with root package name */
    public final a f10683a;

    /* renamed from: b, reason: collision with root package name */
    public final NavigationBarMenuView f10684b;

    /* renamed from: c, reason: collision with root package name */
    public final c f10685c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f10686d;
    public g.i e;

    public static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new g();

        /* renamed from: a, reason: collision with root package name */
        public Bundle f10687a;

        public SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f10687a = parcel.readBundle(classLoader == null ? getClass().getClassLoader() : classLoader);
        }

        @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i3) {
            super.writeToParcel(parcel, i3);
            parcel.writeBundle(this.f10687a);
        }
    }

    public NavigationBarView(Context context, AttributeSet attributeSet, int i3, int i10) {
        super(ib.a.a(context, attributeSet, i3, i10), attributeSet, i3);
        c cVar = new c();
        cVar.f10700b = false;
        this.f10685c = cVar;
        Context context2 = getContext();
        o e = w.e(context2, attributeSet, R$styleable.NavigationBarView, i3, i10, R$styleable.NavigationBarView_itemTextAppearanceInactive, R$styleable.NavigationBarView_itemTextAppearanceActive);
        a aVar = new a(context2, getClass(), getMaxItemCount());
        this.f10683a = aVar;
        NavigationBarMenuView a3 = a(context2);
        this.f10684b = a3;
        cVar.f10699a = a3;
        cVar.f10701c = 1;
        a3.setPresenter(cVar);
        aVar.b(cVar, aVar.f14144a);
        getContext();
        cVar.f10699a.f10679s = aVar;
        int i11 = R$styleable.NavigationBarView_itemIconTint;
        TypedArray typedArray = (TypedArray) e.f12378c;
        if (typedArray.hasValue(i11)) {
            a3.setIconTintList(e.v(R$styleable.NavigationBarView_itemIconTint));
        } else {
            a3.setIconTintList(a3.c());
        }
        setItemIconSize(typedArray.getDimensionPixelSize(R$styleable.NavigationBarView_itemIconSize, getResources().getDimensionPixelSize(R$dimen.mtrl_navigation_bar_item_default_icon_size)));
        if (typedArray.hasValue(R$styleable.NavigationBarView_itemTextAppearanceInactive)) {
            setItemTextAppearanceInactive(typedArray.getResourceId(R$styleable.NavigationBarView_itemTextAppearanceInactive, 0));
        }
        if (typedArray.hasValue(R$styleable.NavigationBarView_itemTextAppearanceActive)) {
            setItemTextAppearanceActive(typedArray.getResourceId(R$styleable.NavigationBarView_itemTextAppearanceActive, 0));
        }
        if (typedArray.hasValue(R$styleable.NavigationBarView_itemTextColor)) {
            setItemTextColor(e.v(R$styleable.NavigationBarView_itemTextColor));
        }
        if (getBackground() == null || (getBackground() instanceof ColorDrawable)) {
            eb.h hVar = new eb.h();
            Drawable background = getBackground();
            if (background instanceof ColorDrawable) {
                hVar.l(ColorStateList.valueOf(((ColorDrawable) background).getColor()));
            }
            hVar.j(context2);
            WeakHashMap weakHashMap = z0.f15748a;
            h0.q(this, hVar);
        }
        if (typedArray.hasValue(R$styleable.NavigationBarView_elevation)) {
            setElevation(typedArray.getDimensionPixelSize(R$styleable.NavigationBarView_elevation, 0));
        }
        d1.b.h(getBackground().mutate(), t0.b(context2, e, R$styleable.NavigationBarView_backgroundTint));
        setLabelVisibilityMode(typedArray.getInteger(R$styleable.NavigationBarView_labelVisibilityMode, -1));
        int resourceId = typedArray.getResourceId(R$styleable.NavigationBarView_itemBackground, 0);
        if (resourceId != 0) {
            a3.setItemBackgroundRes(resourceId);
        } else {
            setItemRippleColor(t0.b(context2, e, R$styleable.NavigationBarView_itemRippleColor));
        }
        if (typedArray.hasValue(R$styleable.NavigationBarView_menu)) {
            int resourceId2 = typedArray.getResourceId(R$styleable.NavigationBarView_menu, 0);
            cVar.f10700b = true;
            getMenuInflater().inflate(resourceId2, aVar);
            cVar.f10700b = false;
            cVar.g(true);
        }
        e.K();
        addView(a3);
        aVar.e = new e0(this, 11);
        gb.a(this, new d());
    }

    private MenuInflater getMenuInflater() {
        if (this.e == null) {
            this.e = new g.i(getContext());
        }
        return this.e;
    }

    public abstract NavigationBarMenuView a(Context context);

    public Drawable getItemBackground() {
        return this.f10684b.getItemBackground();
    }

    @Deprecated
    public int getItemBackgroundResource() {
        return this.f10684b.getItemBackgroundRes();
    }

    public int getItemIconSize() {
        return this.f10684b.getItemIconSize();
    }

    public ColorStateList getItemIconTintList() {
        return this.f10684b.getIconTintList();
    }

    public ColorStateList getItemRippleColor() {
        return this.f10686d;
    }

    public int getItemTextAppearanceActive() {
        return this.f10684b.getItemTextAppearanceActive();
    }

    public int getItemTextAppearanceInactive() {
        return this.f10684b.getItemTextAppearanceInactive();
    }

    public ColorStateList getItemTextColor() {
        return this.f10684b.getItemTextColor();
    }

    public int getLabelVisibilityMode() {
        return this.f10684b.getLabelVisibilityMode();
    }

    public abstract int getMaxItemCount();

    public Menu getMenu() {
        return this.f10683a;
    }

    public z getMenuView() {
        return this.f10684b;
    }

    public c getPresenter() {
        return this.f10685c;
    }

    public int getSelectedItemId() {
        return this.f10684b.getSelectedItemId();
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        rb.d(this);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        this.f10683a.t(savedState.f10687a);
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        Bundle bundle = new Bundle();
        savedState.f10687a = bundle;
        this.f10683a.v(bundle);
        return savedState;
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        rb.b(this, f2);
    }

    public void setItemBackground(Drawable drawable) {
        this.f10684b.setItemBackground(drawable);
        this.f10686d = null;
    }

    public void setItemBackgroundResource(int i3) {
        this.f10684b.setItemBackgroundRes(i3);
        this.f10686d = null;
    }

    public void setItemIconSize(int i3) {
        this.f10684b.setItemIconSize(i3);
    }

    public void setItemIconSizeRes(int i3) {
        setItemIconSize(getResources().getDimensionPixelSize(i3));
    }

    public void setItemIconTintList(ColorStateList colorStateList) {
        this.f10684b.setIconTintList(colorStateList);
    }

    public void setItemRippleColor(ColorStateList colorStateList) {
        ColorStateList colorStateList2 = this.f10686d;
        NavigationBarMenuView navigationBarMenuView = this.f10684b;
        if (colorStateList2 == colorStateList) {
            if (colorStateList != null || navigationBarMenuView.getItemBackground() == null) {
                return;
            }
            navigationBarMenuView.setItemBackground(null);
            return;
        }
        this.f10686d = colorStateList;
        if (colorStateList == null) {
            navigationBarMenuView.setItemBackground(null);
        } else {
            navigationBarMenuView.setItemBackground(new RippleDrawable(cb.a.a(colorStateList), null, null));
        }
    }

    public void setItemTextAppearanceActive(int i3) {
        this.f10684b.setItemTextAppearanceActive(i3);
    }

    public void setItemTextAppearanceInactive(int i3) {
        this.f10684b.setItemTextAppearanceInactive(i3);
    }

    public void setItemTextColor(ColorStateList colorStateList) {
        this.f10684b.setItemTextColor(colorStateList);
    }

    public void setLabelVisibilityMode(int i3) {
        NavigationBarMenuView navigationBarMenuView = this.f10684b;
        if (navigationBarMenuView.getLabelVisibilityMode() != i3) {
            navigationBarMenuView.setLabelVisibilityMode(i3);
            this.f10685c.g(false);
        }
    }

    public void setOnItemReselectedListener(e eVar) {
    }

    public void setOnItemSelectedListener(f fVar) {
    }

    public void setSelectedItemId(int i3) {
        a aVar = this.f10683a;
        MenuItem findItem = aVar.findItem(i3);
        if (findItem == null || aVar.q(findItem, this.f10685c, 0)) {
            return;
        }
        findItem.setChecked(true);
    }
}
