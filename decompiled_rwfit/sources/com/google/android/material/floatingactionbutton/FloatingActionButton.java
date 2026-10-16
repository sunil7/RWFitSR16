package com.google.android.material.floatingactionbutton;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import androidx.appcompat.widget.b0;
import androidx.appcompat.widget.y;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.example.test.ui.device.activity.i0;
import com.google.android.gms.internal.mlkit_vision_barcode.rb;
import com.google.android.material.R$animator;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.internal.VisibilityAwareImageButton;
import com.google.android.material.stateful.ExtendableSavedState;
import eb.m;
import eb.x;
import java.util.ArrayList;
import java.util.WeakHashMap;
import l1.k0;
import l1.z0;
import m0.k;
import o4.e;
import va.a;
import wa.g;
import wa.h;
import wa.i;
import wa.n;
import wa.p;
import x0.b;
import x0.c;
import x0.f;

/* loaded from: classes.dex */
public class FloatingActionButton extends VisibilityAwareImageButton implements a, x, b {

    /* renamed from: q, reason: collision with root package name */
    public static final int f10495q = R$style.Widget_Design_FloatingActionButton;

    /* renamed from: b, reason: collision with root package name */
    public ColorStateList f10496b;

    /* renamed from: c, reason: collision with root package name */
    public PorterDuff.Mode f10497c;

    /* renamed from: d, reason: collision with root package name */
    public ColorStateList f10498d;
    public PorterDuff.Mode e;

    /* renamed from: f, reason: collision with root package name */
    public ColorStateList f10499f;

    /* renamed from: g, reason: collision with root package name */
    public int f10500g;

    /* renamed from: h, reason: collision with root package name */
    public int f10501h;

    /* renamed from: i, reason: collision with root package name */
    public int f10502i;

    /* renamed from: j, reason: collision with root package name */
    public final int f10503j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f10504k;

    /* renamed from: l, reason: collision with root package name */
    public final Rect f10505l;

    /* renamed from: m, reason: collision with root package name */
    public final Rect f10506m;

    /* renamed from: n, reason: collision with root package name */
    public final b0 f10507n;

    /* renamed from: o, reason: collision with root package name */
    public final androidx.appcompat.widget.a f10508o;

    /* renamed from: p, reason: collision with root package name */
    public p f10509p;

    public static class Behavior extends BaseBehavior<FloatingActionButton> {
        public Behavior() {
        }

        @Override // com.google.android.material.floatingactionbutton.FloatingActionButton.BaseBehavior
        public /* bridge */ /* synthetic */ void setInternalAutoHideListener(g gVar) {
            super.setInternalAutoHideListener(gVar);
        }

        public Behavior(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }
    }

    public FloatingActionButton(Context context) {
        this(context, null);
    }

    private n getImpl() {
        if (this.f10509p == null) {
            this.f10509p = new p(this, new mc.g(this, 21));
        }
        return this.f10509p;
    }

    public final void c(AnimatorListenerAdapter animatorListenerAdapter) {
        n impl = getImpl();
        if (impl.f19584v == null) {
            impl.f19584v = new ArrayList();
        }
        impl.f19584v.add(animatorListenerAdapter);
    }

    public final void d(com.google.android.material.bottomappbar.a aVar) {
        n impl = getImpl();
        if (impl.f19583u == null) {
            impl.f19583u = new ArrayList();
        }
        impl.f19583u.add(aVar);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void drawableStateChanged() {
        super.drawableStateChanged();
        getImpl().i(getDrawableState());
    }

    public final void e(i0 i0Var) {
        n impl = getImpl();
        h hVar = new h(this, i0Var);
        if (impl.f19585w == null) {
            impl.f19585w = new ArrayList();
        }
        impl.f19585w.add(hVar);
    }

    public final int f(int i3) {
        int i10 = this.f10501h;
        if (i10 != 0) {
            return i10;
        }
        Resources resources = getResources();
        return i3 != -1 ? i3 != 1 ? resources.getDimensionPixelSize(R$dimen.design_fab_size_normal) : resources.getDimensionPixelSize(R$dimen.design_fab_size_mini) : Math.max(resources.getConfiguration().screenWidthDp, resources.getConfiguration().screenHeightDp) < 470 ? f(1) : f(0);
    }

    public final void g(g gVar, boolean z5) {
        n impl = getImpl();
        e eVar = gVar == null ? null : new e(this, gVar);
        if (impl.f19586x.getVisibility() == 0) {
            if (impl.f19582t == 1) {
                return;
            }
        } else if (impl.f19582t != 2) {
            return;
        }
        Animator animator = impl.f19577n;
        if (animator != null) {
            animator.cancel();
        }
        WeakHashMap weakHashMap = z0.f15748a;
        FloatingActionButton floatingActionButton = impl.f19586x;
        int i3 = 0;
        if (!(k0.c(floatingActionButton) && !floatingActionButton.isInEditMode())) {
            floatingActionButton.a(z5 ? 8 : 4, z5);
            if (eVar != null) {
                ((g) eVar.f16737a).a((FloatingActionButton) eVar.f16738b);
                return;
            }
            return;
        }
        ja.e eVar2 = impl.f19579p;
        if (eVar2 == null) {
            if (impl.f19576m == null) {
                impl.f19576m = ja.e.b(floatingActionButton.getContext(), R$animator.design_fab_hide_motion_spec);
            }
            eVar2 = impl.f19576m;
            eVar2.getClass();
        }
        AnimatorSet b3 = impl.b(eVar2, 0.0f, 0.0f, 0.0f);
        b3.addListener(new i(impl, z5, eVar));
        ArrayList arrayList = impl.f19584v;
        if (arrayList != null) {
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                b3.addListener((Animator.AnimatorListener) obj);
            }
        }
        b3.start();
    }

    @Override // android.view.View
    public ColorStateList getBackgroundTintList() {
        return this.f10496b;
    }

    @Override // android.view.View
    public PorterDuff.Mode getBackgroundTintMode() {
        return this.f10497c;
    }

    @Override // x0.b
    public c getBehavior() {
        return new Behavior();
    }

    public float getCompatElevation() {
        return getImpl().d();
    }

    public float getCompatHoveredFocusedTranslationZ() {
        return getImpl().f19572i;
    }

    public float getCompatPressedTranslationZ() {
        return getImpl().f19573j;
    }

    public Drawable getContentBackground() {
        return getImpl().e;
    }

    public int getCustomSize() {
        return this.f10501h;
    }

    public int getExpandedComponentIdHint() {
        return this.f10508o.f866a;
    }

    public ja.e getHideMotionSpec() {
        return getImpl().f19579p;
    }

    @Deprecated
    public int getRippleColor() {
        ColorStateList colorStateList = this.f10499f;
        if (colorStateList != null) {
            return colorStateList.getDefaultColor();
        }
        return 0;
    }

    public ColorStateList getRippleColorStateList() {
        return this.f10499f;
    }

    public m getShapeAppearanceModel() {
        m mVar = getImpl().f19565a;
        mVar.getClass();
        return mVar;
    }

    public ja.e getShowMotionSpec() {
        return getImpl().f19578o;
    }

    public int getSize() {
        return this.f10500g;
    }

    public int getSizeDimension() {
        return f(this.f10500g);
    }

    public ColorStateList getSupportBackgroundTintList() {
        return getBackgroundTintList();
    }

    public PorterDuff.Mode getSupportBackgroundTintMode() {
        return getBackgroundTintMode();
    }

    public ColorStateList getSupportImageTintList() {
        return this.f10498d;
    }

    public PorterDuff.Mode getSupportImageTintMode() {
        return this.e;
    }

    public boolean getUseCompatPadding() {
        return this.f10504k;
    }

    public final boolean h() {
        n impl = getImpl();
        if (impl.f19586x.getVisibility() == 0) {
            if (impl.f19582t != 1) {
                return false;
            }
        } else if (impl.f19582t == 2) {
            return false;
        }
        return true;
    }

    public void hide(g gVar) {
        g(gVar, true);
    }

    public final boolean i() {
        n impl = getImpl();
        if (impl.f19586x.getVisibility() != 0) {
            if (impl.f19582t != 2) {
                return false;
            }
        } else if (impl.f19582t == 1) {
            return false;
        }
        return true;
    }

    public final void j(Rect rect) {
        int i3 = rect.left;
        Rect rect2 = this.f10505l;
        rect.left = i3 + rect2.left;
        rect.top += rect2.top;
        rect.right -= rect2.right;
        rect.bottom -= rect2.bottom;
    }

    @Override // android.widget.ImageView, android.view.View
    public final void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        getImpl().g();
    }

    public final void k() {
        Drawable drawable = getDrawable();
        if (drawable == null) {
            return;
        }
        ColorStateList colorStateList = this.f10498d;
        if (colorStateList == null) {
            drawable.clearColorFilter();
            return;
        }
        int colorForState = colorStateList.getColorForState(getDrawableState(), 0);
        PorterDuff.Mode mode = this.e;
        if (mode == null) {
            mode = PorterDuff.Mode.SRC_IN;
        }
        drawable.mutate().setColorFilter(y.c(colorForState, mode));
    }

    public final void l(g gVar, boolean z5) {
        n impl = getImpl();
        e eVar = gVar == null ? null : new e(this, gVar);
        if (impl.f19586x.getVisibility() != 0) {
            if (impl.f19582t == 2) {
                return;
            }
        } else if (impl.f19582t != 1) {
            return;
        }
        Animator animator = impl.f19577n;
        if (animator != null) {
            animator.cancel();
        }
        WeakHashMap weakHashMap = z0.f15748a;
        FloatingActionButton floatingActionButton = impl.f19586x;
        int i3 = 0;
        boolean z6 = k0.c(floatingActionButton) && !floatingActionButton.isInEditMode();
        Matrix matrix = impl.C;
        if (!z6) {
            floatingActionButton.a(0, z5);
            floatingActionButton.setAlpha(1.0f);
            floatingActionButton.setScaleY(1.0f);
            floatingActionButton.setScaleX(1.0f);
            impl.r = 1.0f;
            impl.a(1.0f, matrix);
            floatingActionButton.setImageMatrix(matrix);
            if (eVar != null) {
                ((g) eVar.f16737a).b();
                return;
            }
            return;
        }
        if (floatingActionButton.getVisibility() != 0) {
            floatingActionButton.setAlpha(0.0f);
            floatingActionButton.setScaleY(0.0f);
            floatingActionButton.setScaleX(0.0f);
            impl.r = 0.0f;
            impl.a(0.0f, matrix);
            floatingActionButton.setImageMatrix(matrix);
        }
        ja.e eVar2 = impl.f19578o;
        if (eVar2 == null) {
            if (impl.f19575l == null) {
                impl.f19575l = ja.e.b(floatingActionButton.getContext(), R$animator.design_fab_show_motion_spec);
            }
            eVar2 = impl.f19575l;
            eVar2.getClass();
        }
        AnimatorSet b3 = impl.b(eVar2, 1.0f, 1.0f, 1.0f);
        b3.addListener(new kb.b(impl, z5, eVar));
        ArrayList arrayList = impl.f19583u;
        if (arrayList != null) {
            int size = arrayList.size();
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                b3.addListener((Animator.AnimatorListener) obj);
            }
        }
        b3.start();
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        n impl = getImpl();
        eb.h hVar = impl.f19566b;
        FloatingActionButton floatingActionButton = impl.f19586x;
        if (hVar != null) {
            rb.c(floatingActionButton, hVar);
        }
        if (impl instanceof p) {
            return;
        }
        ViewTreeObserver viewTreeObserver = floatingActionButton.getViewTreeObserver();
        if (impl.D == null) {
            impl.D = new j2.y(impl, 1);
        }
        viewTreeObserver.addOnPreDrawListener(impl.D);
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        n impl = getImpl();
        ViewTreeObserver viewTreeObserver = impl.f19586x.getViewTreeObserver();
        j2.y yVar = impl.D;
        if (yVar != null) {
            viewTreeObserver.removeOnPreDrawListener(yVar);
            impl.D = null;
        }
    }

    @Override // android.widget.ImageView, android.view.View
    public final void onMeasure(int i3, int i10) {
        int sizeDimension = getSizeDimension();
        this.f10502i = (sizeDimension - this.f10503j) / 2;
        getImpl().q();
        int mode = View.MeasureSpec.getMode(i3);
        int size = View.MeasureSpec.getSize(i3);
        if (mode == Integer.MIN_VALUE) {
            size = Math.min(sizeDimension, size);
        } else if (mode == 0) {
            size = sizeDimension;
        } else if (mode != 1073741824) {
            throw new IllegalArgumentException();
        }
        int mode2 = View.MeasureSpec.getMode(i10);
        int size2 = View.MeasureSpec.getSize(i10);
        if (mode2 == Integer.MIN_VALUE) {
            sizeDimension = Math.min(sizeDimension, size2);
        } else if (mode2 != 0) {
            if (mode2 != 1073741824) {
                throw new IllegalArgumentException();
            }
            sizeDimension = size2;
        }
        int min = Math.min(size, sizeDimension);
        Rect rect = this.f10505l;
        setMeasuredDimension(rect.left + min + rect.right, min + rect.top + rect.bottom);
    }

    @Override // android.view.View
    public final void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof ExtendableSavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        ExtendableSavedState extendableSavedState = (ExtendableSavedState) parcelable;
        super.onRestoreInstanceState(extendableSavedState.a());
        Object orDefault = extendableSavedState.extendableStates.getOrDefault("expandableWidgetHelper", null);
        orDefault.getClass();
        Bundle bundle = (Bundle) orDefault;
        androidx.appcompat.widget.a aVar = this.f10508o;
        aVar.getClass();
        aVar.f867b = bundle.getBoolean("expanded", false);
        aVar.f866a = bundle.getInt("expandedComponentIdHint", 0);
        if (aVar.f867b) {
            View view = (View) aVar.f868c;
            ViewParent parent = view.getParent();
            if (parent instanceof CoordinatorLayout) {
                ((CoordinatorLayout) parent).m(view);
            }
        }
    }

    @Override // android.view.View
    public final Parcelable onSaveInstanceState() {
        Parcelable onSaveInstanceState = super.onSaveInstanceState();
        if (onSaveInstanceState == null) {
            onSaveInstanceState = new Bundle();
        }
        ExtendableSavedState extendableSavedState = new ExtendableSavedState(onSaveInstanceState);
        k kVar = extendableSavedState.extendableStates;
        androidx.appcompat.widget.a aVar = this.f10508o;
        aVar.getClass();
        Bundle bundle = new Bundle();
        bundle.putBoolean("expanded", aVar.f867b);
        bundle.putInt("expandedComponentIdHint", aVar.f866a);
        kVar.put("expandableWidgetHelper", bundle);
        return extendableSavedState;
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            WeakHashMap weakHashMap = z0.f15748a;
            if (k0.c(this)) {
                int width = getWidth();
                int height = getHeight();
                Rect rect = this.f10506m;
                rect.set(0, 0, width, height);
                j(rect);
                if (!rect.contains((int) motionEvent.getX(), (int) motionEvent.getY())) {
                    return false;
                }
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setBackgroundColor(int i3) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundDrawable(Drawable drawable) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundResource(int i3) {
        Log.i("FloatingActionButton", "Setting a custom background is not supported.");
    }

    @Override // android.view.View
    public void setBackgroundTintList(ColorStateList colorStateList) {
        if (this.f10496b != colorStateList) {
            this.f10496b = colorStateList;
            n impl = getImpl();
            eb.h hVar = impl.f19566b;
            if (hVar != null) {
                hVar.setTintList(colorStateList);
            }
            wa.b bVar = impl.f19568d;
            if (bVar != null) {
                if (colorStateList != null) {
                    bVar.f19540m = colorStateList.getColorForState(bVar.getState(), bVar.f19540m);
                }
                bVar.f19543p = colorStateList;
                bVar.f19541n = true;
                bVar.invalidateSelf();
            }
        }
    }

    @Override // android.view.View
    public void setBackgroundTintMode(PorterDuff.Mode mode) {
        if (this.f10497c != mode) {
            this.f10497c = mode;
            eb.h hVar = getImpl().f19566b;
            if (hVar != null) {
                hVar.setTintMode(mode);
            }
        }
    }

    public void setCompatElevation(float f2) {
        n impl = getImpl();
        if (impl.f19571h != f2) {
            impl.f19571h = f2;
            impl.j(f2, impl.f19572i, impl.f19573j);
        }
    }

    public void setCompatElevationResource(int i3) {
        setCompatElevation(getResources().getDimension(i3));
    }

    public void setCompatHoveredFocusedTranslationZ(float f2) {
        n impl = getImpl();
        if (impl.f19572i != f2) {
            impl.f19572i = f2;
            impl.j(impl.f19571h, f2, impl.f19573j);
        }
    }

    public void setCompatHoveredFocusedTranslationZResource(int i3) {
        setCompatHoveredFocusedTranslationZ(getResources().getDimension(i3));
    }

    public void setCompatPressedTranslationZ(float f2) {
        n impl = getImpl();
        if (impl.f19573j != f2) {
            impl.f19573j = f2;
            impl.j(impl.f19571h, impl.f19572i, f2);
        }
    }

    public void setCompatPressedTranslationZResource(int i3) {
        setCompatPressedTranslationZ(getResources().getDimension(i3));
    }

    public void setCustomSize(int i3) {
        if (i3 < 0) {
            throw new IllegalArgumentException("Custom size must be non-negative");
        }
        if (i3 != this.f10501h) {
            this.f10501h = i3;
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        eb.h hVar = getImpl().f19566b;
        if (hVar != null) {
            hVar.k(f2);
        }
    }

    public void setEnsureMinTouchTargetSize(boolean z5) {
        if (z5 != getImpl().f19569f) {
            getImpl().f19569f = z5;
            requestLayout();
        }
    }

    public void setExpandedComponentIdHint(int i3) {
        this.f10508o.f866a = i3;
    }

    public void setHideMotionSpec(ja.e eVar) {
        getImpl().f19579p = eVar;
    }

    public void setHideMotionSpecResource(int i3) {
        setHideMotionSpec(ja.e.b(getContext(), i3));
    }

    @Override // android.widget.ImageView
    public void setImageDrawable(Drawable drawable) {
        if (getDrawable() != drawable) {
            super.setImageDrawable(drawable);
            n impl = getImpl();
            float f2 = impl.r;
            impl.r = f2;
            Matrix matrix = impl.C;
            impl.a(f2, matrix);
            impl.f19586x.setImageMatrix(matrix);
            if (this.f10498d != null) {
                k();
            }
        }
    }

    @Override // android.widget.ImageView
    public void setImageResource(int i3) {
        this.f10507n.f(i3);
        k();
    }

    public void setRippleColor(int i3) {
        setRippleColor(ColorStateList.valueOf(i3));
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        super.setScaleX(f2);
        getImpl().k();
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        super.setScaleY(f2);
        getImpl().k();
    }

    public void setShadowPaddingEnabled(boolean z5) {
        n impl = getImpl();
        impl.f19570g = z5;
        impl.q();
    }

    @Override // eb.x
    public void setShapeAppearanceModel(m mVar) {
        getImpl().n(mVar);
    }

    public void setShowMotionSpec(ja.e eVar) {
        getImpl().f19578o = eVar;
    }

    public void setShowMotionSpecResource(int i3) {
        setShowMotionSpec(ja.e.b(getContext(), i3));
    }

    public void setSize(int i3) {
        this.f10501h = 0;
        if (i3 != this.f10500g) {
            this.f10500g = i3;
            requestLayout();
        }
    }

    public void setSupportBackgroundTintList(ColorStateList colorStateList) {
        setBackgroundTintList(colorStateList);
    }

    public void setSupportBackgroundTintMode(PorterDuff.Mode mode) {
        setBackgroundTintMode(mode);
    }

    public void setSupportImageTintList(ColorStateList colorStateList) {
        if (this.f10498d != colorStateList) {
            this.f10498d = colorStateList;
            k();
        }
    }

    public void setSupportImageTintMode(PorterDuff.Mode mode) {
        if (this.e != mode) {
            this.e = mode;
            k();
        }
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        super.setTranslationX(f2);
        getImpl().l();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        super.setTranslationY(f2);
        getImpl().l();
    }

    @Override // android.view.View
    public void setTranslationZ(float f2) {
        super.setTranslationZ(f2);
        getImpl().l();
    }

    public void setUseCompatPadding(boolean z5) {
        if (this.f10504k != z5) {
            this.f10504k = z5;
            getImpl().h();
        }
    }

    @Override // com.google.android.material.internal.VisibilityAwareImageButton, android.widget.ImageView, android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
    }

    public void show(g gVar) {
        l(gVar, true);
    }

    public static class BaseBehavior<T extends FloatingActionButton> extends c {

        /* renamed from: a, reason: collision with root package name */
        public Rect f10510a;

        /* renamed from: b, reason: collision with root package name */
        public g f10511b;

        /* renamed from: c, reason: collision with root package name */
        public final boolean f10512c;

        public BaseBehavior() {
            this.f10512c = true;
        }

        @Override // x0.c
        public final boolean a(View view, Rect rect) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            int left = floatingActionButton.getLeft();
            Rect rect2 = floatingActionButton.f10505l;
            rect.set(left + rect2.left, floatingActionButton.getTop() + rect2.top, floatingActionButton.getRight() - rect2.right, floatingActionButton.getBottom() - rect2.bottom);
            return true;
        }

        @Override // x0.c
        public final void c(f fVar) {
            if (fVar.f19722h == 0) {
                fVar.f19722h = 80;
            }
        }

        @Override // x0.c
        public final boolean d(CoordinatorLayout coordinatorLayout, View view, View view2) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            if (view2 instanceof AppBarLayout) {
                s(coordinatorLayout, (AppBarLayout) view2, floatingActionButton);
            } else {
                ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                if (layoutParams instanceof f ? ((f) layoutParams).f19716a instanceof BottomSheetBehavior : false) {
                    t(view2, floatingActionButton);
                }
            }
            return false;
        }

        @Override // x0.c
        public final boolean h(CoordinatorLayout coordinatorLayout, View view, int i3) {
            FloatingActionButton floatingActionButton = (FloatingActionButton) view;
            ArrayList o3 = coordinatorLayout.o(floatingActionButton);
            int size = o3.size();
            int i10 = 0;
            for (int i11 = 0; i11 < size; i11++) {
                View view2 = (View) o3.get(i11);
                if (!(view2 instanceof AppBarLayout)) {
                    ViewGroup.LayoutParams layoutParams = view2.getLayoutParams();
                    if ((layoutParams instanceof f ? ((f) layoutParams).f19716a instanceof BottomSheetBehavior : false) && t(view2, floatingActionButton)) {
                        break;
                    }
                } else {
                    if (s(coordinatorLayout, (AppBarLayout) view2, floatingActionButton)) {
                        break;
                    }
                }
            }
            coordinatorLayout.v(i3, floatingActionButton);
            Rect rect = floatingActionButton.f10505l;
            if (rect != null && rect.centerX() > 0 && rect.centerY() > 0) {
                f fVar = (f) floatingActionButton.getLayoutParams();
                int i12 = floatingActionButton.getRight() >= coordinatorLayout.getWidth() - ((ViewGroup.MarginLayoutParams) fVar).rightMargin ? rect.right : floatingActionButton.getLeft() <= ((ViewGroup.MarginLayoutParams) fVar).leftMargin ? -rect.left : 0;
                if (floatingActionButton.getBottom() >= coordinatorLayout.getHeight() - ((ViewGroup.MarginLayoutParams) fVar).bottomMargin) {
                    i10 = rect.bottom;
                } else if (floatingActionButton.getTop() <= ((ViewGroup.MarginLayoutParams) fVar).topMargin) {
                    i10 = -rect.top;
                }
                if (i10 != 0) {
                    WeakHashMap weakHashMap = z0.f15748a;
                    floatingActionButton.offsetTopAndBottom(i10);
                }
                if (i12 != 0) {
                    WeakHashMap weakHashMap2 = z0.f15748a;
                    floatingActionButton.offsetLeftAndRight(i12);
                }
            }
            return true;
        }

        public final boolean s(CoordinatorLayout coordinatorLayout, AppBarLayout appBarLayout, FloatingActionButton floatingActionButton) {
            if (!(this.f10512c && ((f) floatingActionButton.getLayoutParams()).f19720f == appBarLayout.getId() && floatingActionButton.getUserSetVisibility() == 0)) {
                return false;
            }
            if (this.f10510a == null) {
                this.f10510a = new Rect();
            }
            Rect rect = this.f10510a;
            com.google.android.material.internal.c.a(coordinatorLayout, appBarLayout, rect);
            if (rect.bottom <= appBarLayout.getMinimumHeightForVisibleOverlappingContent()) {
                floatingActionButton.g(this.f10511b, false);
            } else {
                floatingActionButton.l(this.f10511b, false);
            }
            return true;
        }

        public void setInternalAutoHideListener(g gVar) {
            this.f10511b = gVar;
        }

        public final boolean t(View view, FloatingActionButton floatingActionButton) {
            if (!(this.f10512c && ((f) floatingActionButton.getLayoutParams()).f19720f == view.getId() && floatingActionButton.getUserSetVisibility() == 0)) {
                return false;
            }
            if (view.getTop() < (floatingActionButton.getHeight() / 2) + ((ViewGroup.MarginLayoutParams) ((f) floatingActionButton.getLayoutParams())).topMargin) {
                floatingActionButton.g(this.f10511b, false);
            } else {
                floatingActionButton.l(this.f10511b, false);
            }
            return true;
        }

        public BaseBehavior(Context context, AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.FloatingActionButton_Behavior_Layout);
            this.f10512c = obtainStyledAttributes.getBoolean(R$styleable.FloatingActionButton_Behavior_Layout_behavior_autoHide, true);
            obtainStyledAttributes.recycle();
        }
    }

    public FloatingActionButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.floatingActionButtonStyle);
    }

    public void setRippleColor(ColorStateList colorStateList) {
        if (this.f10499f != colorStateList) {
            this.f10499f = colorStateList;
            getImpl().m(this.f10499f);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public FloatingActionButton(android.content.Context r13, android.util.AttributeSet r14, int r15) {
        /*
            Method dump skipped, instructions count: 331
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.floatingactionbutton.FloatingActionButton.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }
}
