package com.google.android.material.appbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.text.StaticLayout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import androidx.appcompat.widget.Toolbar;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.t;
import java.util.WeakHashMap;
import ka.h;
import l1.h0;
import l1.i0;
import l1.k0;
import l1.l0;
import l1.x1;
import l1.z0;

/* loaded from: classes.dex */
public class CollapsingToolbarLayout extends FrameLayout {
    public static final int D = R$style.Widget_Design_CollapsingToolbar;
    public boolean A;
    public int B;
    public boolean C;

    /* renamed from: a, reason: collision with root package name */
    public boolean f10191a;

    /* renamed from: b, reason: collision with root package name */
    public final int f10192b;

    /* renamed from: c, reason: collision with root package name */
    public ViewGroup f10193c;

    /* renamed from: d, reason: collision with root package name */
    public View f10194d;
    public View e;

    /* renamed from: f, reason: collision with root package name */
    public int f10195f;

    /* renamed from: g, reason: collision with root package name */
    public int f10196g;

    /* renamed from: h, reason: collision with root package name */
    public int f10197h;

    /* renamed from: i, reason: collision with root package name */
    public int f10198i;

    /* renamed from: j, reason: collision with root package name */
    public final Rect f10199j;

    /* renamed from: k, reason: collision with root package name */
    public final com.google.android.material.internal.b f10200k;

    /* renamed from: l, reason: collision with root package name */
    public final ua.a f10201l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f10202m;

    /* renamed from: n, reason: collision with root package name */
    public boolean f10203n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f10204o;

    /* renamed from: p, reason: collision with root package name */
    public Drawable f10205p;

    /* renamed from: q, reason: collision with root package name */
    public int f10206q;
    public boolean r;

    /* renamed from: s, reason: collision with root package name */
    public ValueAnimator f10207s;

    /* renamed from: t, reason: collision with root package name */
    public long f10208t;

    /* renamed from: u, reason: collision with root package name */
    public int f10209u;

    /* renamed from: v, reason: collision with root package name */
    public ig.a f10210v;

    /* renamed from: w, reason: collision with root package name */
    public int f10211w;

    /* renamed from: x, reason: collision with root package name */
    public int f10212x;

    /* renamed from: y, reason: collision with root package name */
    public x1 f10213y;

    /* renamed from: z, reason: collision with root package name */
    public int f10214z;

    public CollapsingToolbarLayout(Context context) {
        this(context, null);
    }

    public static h b(View view) {
        h hVar = (h) view.getTag(R$id.view_offset_helper);
        if (hVar != null) {
            return hVar;
        }
        h hVar2 = new h(view);
        view.setTag(R$id.view_offset_helper, hVar2);
        return hVar2;
    }

    public final void a() {
        if (this.f10191a) {
            ViewGroup viewGroup = null;
            this.f10193c = null;
            this.f10194d = null;
            int i3 = this.f10192b;
            if (i3 != -1) {
                ViewGroup viewGroup2 = (ViewGroup) findViewById(i3);
                this.f10193c = viewGroup2;
                if (viewGroup2 != null) {
                    ViewParent parent = viewGroup2.getParent();
                    View view = viewGroup2;
                    while (parent != this && parent != null) {
                        if (parent instanceof View) {
                            view = (View) parent;
                        }
                        parent = parent.getParent();
                        view = view;
                    }
                    this.f10194d = view;
                }
            }
            if (this.f10193c == null) {
                int childCount = getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    View childAt = getChildAt(i10);
                    if ((childAt instanceof Toolbar) || (childAt instanceof android.widget.Toolbar)) {
                        viewGroup = (ViewGroup) childAt;
                        break;
                    }
                }
                this.f10193c = viewGroup;
            }
            c();
            this.f10191a = false;
        }
    }

    public final void c() {
        View view;
        if (!this.f10202m && (view = this.e) != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.e);
            }
        }
        if (!this.f10202m || this.f10193c == null) {
            return;
        }
        if (this.e == null) {
            this.e = new View(getContext());
        }
        if (this.e.getParent() == null) {
            this.f10193c.addView(this.e, -1, -1);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ka.d;
    }

    public final void d() {
        if (this.f10204o == null && this.f10205p == null) {
            return;
        }
        setScrimsShown(getHeight() + this.f10211w < getScrimVisibleHeightTrigger());
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        Drawable drawable;
        super.draw(canvas);
        a();
        if (this.f10193c == null && (drawable = this.f10204o) != null && this.f10206q > 0) {
            drawable.mutate().setAlpha(this.f10206q);
            this.f10204o.draw(canvas);
        }
        if (this.f10202m && this.f10203n) {
            ViewGroup viewGroup = this.f10193c;
            com.google.android.material.internal.b bVar = this.f10200k;
            if (viewGroup == null || this.f10204o == null || this.f10206q <= 0 || this.f10212x != 1 || bVar.f10562c >= bVar.f10567f) {
                bVar.e(canvas);
            } else {
                int save = canvas.save();
                canvas.clipRect(this.f10204o.getBounds(), Region.Op.DIFFERENCE);
                bVar.e(canvas);
                canvas.restoreToCount(save);
            }
        }
        if (this.f10205p == null || this.f10206q <= 0) {
            return;
        }
        x1 x1Var = this.f10213y;
        int d5 = x1Var != null ? x1Var.d() : 0;
        if (d5 > 0) {
            this.f10205p.setBounds(0, -this.f10211w, getWidth(), d5 - this.f10211w);
            this.f10205p.mutate().setAlpha(this.f10206q);
            this.f10205p.draw(canvas);
        }
    }

    @Override // android.view.ViewGroup
    public final boolean drawChild(Canvas canvas, View view, long j4) {
        boolean z5;
        View view2;
        Drawable drawable = this.f10204o;
        if (drawable == null || this.f10206q <= 0 || ((view2 = this.f10194d) == null || view2 == this ? view != this.f10193c : view != view2)) {
            z5 = false;
        } else {
            int width = getWidth();
            int height = getHeight();
            if (this.f10212x == 1 && view != null && this.f10202m) {
                height = view.getBottom();
            }
            drawable.setBounds(0, 0, width, height);
            this.f10204o.mutate().setAlpha(this.f10206q);
            this.f10204o.draw(canvas);
            z5 = true;
        }
        return super.drawChild(canvas, view, j4) || z5;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void drawableStateChanged() {
        ColorStateList colorStateList;
        super.drawableStateChanged();
        int[] drawableState = getDrawableState();
        Drawable drawable = this.f10205p;
        boolean z5 = false;
        boolean state = (drawable == null || !drawable.isStateful()) ? false : drawable.setState(drawableState);
        Drawable drawable2 = this.f10204o;
        if (drawable2 != null && drawable2.isStateful()) {
            state |= drawable2.setState(drawableState);
        }
        com.google.android.material.internal.b bVar = this.f10200k;
        if (bVar != null) {
            bVar.I = drawableState;
            ColorStateList colorStateList2 = bVar.f10579p;
            if ((colorStateList2 != null && colorStateList2.isStateful()) || ((colorStateList = bVar.f10578o) != null && colorStateList.isStateful())) {
                bVar.i(false);
                z5 = true;
            }
            state |= z5;
        }
        if (state) {
            invalidate();
        }
    }

    public final void e(int i3, int i10, int i11, int i12, boolean z5) {
        View view;
        int i13;
        int i14;
        int i15;
        if (!this.f10202m || (view = this.e) == null) {
            return;
        }
        WeakHashMap weakHashMap = z0.f15748a;
        int i16 = 0;
        boolean z6 = k0.b(view) && this.e.getVisibility() == 0;
        this.f10203n = z6;
        if (z6 || z5) {
            boolean z8 = i0.d(this) == 1;
            View view2 = this.f10194d;
            if (view2 == null) {
                view2 = this.f10193c;
            }
            int height = ((getHeight() - b(view2).f15588b) - view2.getHeight()) - ((FrameLayout.LayoutParams) ((ka.d) view2.getLayoutParams())).bottomMargin;
            View view3 = this.e;
            Rect rect = this.f10199j;
            com.google.android.material.internal.c.a(this, view3, rect);
            ViewGroup viewGroup = this.f10193c;
            if (viewGroup instanceof Toolbar) {
                Toolbar toolbar = (Toolbar) viewGroup;
                i16 = toolbar.getTitleMarginStart();
                i14 = toolbar.getTitleMarginEnd();
                i15 = toolbar.getTitleMarginTop();
                i13 = toolbar.getTitleMarginBottom();
            } else if (viewGroup instanceof android.widget.Toolbar) {
                android.widget.Toolbar toolbar2 = (android.widget.Toolbar) viewGroup;
                i16 = toolbar2.getTitleMarginStart();
                i14 = toolbar2.getTitleMarginEnd();
                i15 = toolbar2.getTitleMarginTop();
                i13 = toolbar2.getTitleMarginBottom();
            } else {
                i13 = 0;
                i14 = 0;
                i15 = 0;
            }
            int i17 = rect.left + (z8 ? i14 : i16);
            int i18 = rect.top + height + i15;
            int i19 = rect.right;
            if (!z8) {
                i16 = i14;
            }
            int i20 = i19 - i16;
            int i21 = (rect.bottom + height) - i13;
            com.google.android.material.internal.b bVar = this.f10200k;
            Rect rect2 = bVar.f10572i;
            if (rect2.left != i17 || rect2.top != i18 || rect2.right != i20 || rect2.bottom != i21) {
                rect2.set(i17, i18, i20, i21);
                bVar.J = true;
                bVar.h();
            }
            int i22 = z8 ? this.f10197h : this.f10195f;
            int i23 = rect.top + this.f10196g;
            int i24 = (i11 - i3) - (z8 ? this.f10195f : this.f10197h);
            int i25 = (i12 - i10) - this.f10198i;
            Rect rect3 = bVar.f10571h;
            if (rect3.left != i22 || rect3.top != i23 || rect3.right != i24 || rect3.bottom != i25) {
                rect3.set(i22, i23, i24, i25);
                bVar.J = true;
                bVar.h();
            }
            bVar.i(z5);
        }
    }

    public final void f() {
        if (this.f10193c != null && this.f10202m && TextUtils.isEmpty(this.f10200k.B)) {
            ViewGroup viewGroup = this.f10193c;
            setTitle(viewGroup instanceof Toolbar ? ((Toolbar) viewGroup).getTitle() : viewGroup instanceof android.widget.Toolbar ? ((android.widget.Toolbar) viewGroup).getTitle() : null);
        }
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        ka.d dVar = new ka.d(-1, -1);
        dVar.f15574a = 0;
        dVar.f15575b = 0.5f;
        return dVar;
    }

    public int getCollapsedTitleGravity() {
        return this.f10200k.f10575l;
    }

    public Typeface getCollapsedTitleTypeface() {
        Typeface typeface = this.f10200k.f10585w;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public Drawable getContentScrim() {
        return this.f10204o;
    }

    public int getExpandedTitleGravity() {
        return this.f10200k.f10574k;
    }

    public int getExpandedTitleMarginBottom() {
        return this.f10198i;
    }

    public int getExpandedTitleMarginEnd() {
        return this.f10197h;
    }

    public int getExpandedTitleMarginStart() {
        return this.f10195f;
    }

    public int getExpandedTitleMarginTop() {
        return this.f10196g;
    }

    public Typeface getExpandedTitleTypeface() {
        Typeface typeface = this.f10200k.f10586x;
        return typeface != null ? typeface : Typeface.DEFAULT;
    }

    public int getHyphenationFrequency() {
        return this.f10200k.f10570g0;
    }

    public int getLineCount() {
        StaticLayout staticLayout = this.f10200k.Y;
        if (staticLayout != null) {
            return staticLayout.getLineCount();
        }
        return 0;
    }

    public float getLineSpacingAdd() {
        return this.f10200k.Y.getSpacingAdd();
    }

    public float getLineSpacingMultiplier() {
        return this.f10200k.Y.getSpacingMultiplier();
    }

    public int getMaxLines() {
        return this.f10200k.f10565d0;
    }

    public int getScrimAlpha() {
        return this.f10206q;
    }

    public long getScrimAnimationDuration() {
        return this.f10208t;
    }

    public int getScrimVisibleHeightTrigger() {
        int i3 = this.f10209u;
        if (i3 >= 0) {
            return i3 + this.f10214z + this.B;
        }
        x1 x1Var = this.f10213y;
        int d5 = x1Var != null ? x1Var.d() : 0;
        WeakHashMap weakHashMap = z0.f15748a;
        int d8 = h0.d(this);
        return d8 > 0 ? Math.min((d8 * 2) + d5, getHeight()) : getHeight() / 3;
    }

    public Drawable getStatusBarScrim() {
        return this.f10205p;
    }

    public CharSequence getTitle() {
        if (this.f10202m) {
            return this.f10200k.B;
        }
        return null;
    }

    public int getTitleCollapseMode() {
        return this.f10212x;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.f10212x == 1) {
                appBarLayout.setLiftOnScroll(false);
            }
            WeakHashMap weakHashMap = z0.f15748a;
            setFitsSystemWindows(h0.b(appBarLayout));
            if (this.f10210v == null) {
                this.f10210v = new ig.a(this, 1);
            }
            appBarLayout.addOnOffsetChangedListener((ka.c) this.f10210v);
            l0.c(this);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        ViewParent parent = getParent();
        ig.a aVar = this.f10210v;
        if (aVar != null && (parent instanceof AppBarLayout)) {
            ((AppBarLayout) parent).removeOnOffsetChangedListener((ka.c) aVar);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        x1 x1Var = this.f10213y;
        if (x1Var != null) {
            int d5 = x1Var.d();
            int childCount = getChildCount();
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt = getChildAt(i13);
                WeakHashMap weakHashMap = z0.f15748a;
                if (!h0.b(childAt) && childAt.getTop() < d5) {
                    childAt.offsetTopAndBottom(d5);
                }
            }
        }
        int childCount2 = getChildCount();
        for (int i14 = 0; i14 < childCount2; i14++) {
            h b3 = b(getChildAt(i14));
            View view = b3.f15587a;
            b3.f15588b = view.getTop();
            b3.f15589c = view.getLeft();
        }
        e(i3, i10, i11, i12, false);
        f();
        d();
        int childCount3 = getChildCount();
        for (int i15 = 0; i15 < childCount3; i15++) {
            b(getChildAt(i15)).a();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:35:? A[RETURN, SYNTHETIC] */
    @Override // android.widget.FrameLayout, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void onMeasure(int r11, int r12) {
        /*
            r10 = this;
            r10.a()
            super.onMeasure(r11, r12)
            int r12 = android.view.View.MeasureSpec.getMode(r12)
            l1.x1 r0 = r10.f10213y
            r1 = 0
            if (r0 == 0) goto L14
            int r0 = r0.d()
            goto L15
        L14:
            r0 = r1
        L15:
            r2 = 1073741824(0x40000000, float:2.0)
            if (r12 == 0) goto L1d
            boolean r12 = r10.A
            if (r12 == 0) goto L2d
        L1d:
            if (r0 <= 0) goto L2d
            r10.f10214z = r0
            int r12 = r10.getMeasuredHeight()
            int r12 = r12 + r0
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r2)
            super.onMeasure(r11, r12)
        L2d:
            boolean r12 = r10.C
            if (r12 == 0) goto L86
            com.google.android.material.internal.b r12 = r10.f10200k
            int r0 = r12.f10565d0
            r3 = 1
            if (r0 <= r3) goto L86
            r10.f()
            int r7 = r10.getMeasuredWidth()
            int r8 = r10.getMeasuredHeight()
            r5 = 0
            r6 = 0
            r9 = 1
            r4 = r10
            r4.e(r5, r6, r7, r8, r9)
            android.text.StaticLayout r0 = r12.Y
            if (r0 == 0) goto L52
            int r1 = r0.getLineCount()
        L52:
            if (r1 <= r3) goto L87
            android.text.TextPaint r0 = r12.L
            float r5 = r12.f10576m
            r0.setTextSize(r5)
            android.graphics.Typeface r5 = r12.f10586x
            r0.setTypeface(r5)
            float r12 = r12.X
            r0.setLetterSpacing(r12)
            float r12 = r0.ascent()
            float r12 = -r12
            float r0 = r0.descent()
            float r0 = r0 + r12
            int r12 = java.lang.Math.round(r0)
            int r1 = r1 - r3
            int r1 = r1 * r12
            r4.B = r1
            int r12 = r10.getMeasuredHeight()
            int r0 = r4.B
            int r12 = r12 + r0
            int r12 = android.view.View.MeasureSpec.makeMeasureSpec(r12, r2)
            super.onMeasure(r11, r12)
            goto L87
        L86:
            r4 = r10
        L87:
            android.view.ViewGroup r11 = r4.f10193c
            if (r11 == 0) goto Lcb
            android.view.View r12 = r4.f10194d
            if (r12 == 0) goto Laf
            if (r12 != r4) goto L92
            goto Laf
        L92:
            android.view.ViewGroup$LayoutParams r11 = r12.getLayoutParams()
            boolean r0 = r11 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r0 == 0) goto La7
            android.view.ViewGroup$MarginLayoutParams r11 = (android.view.ViewGroup.MarginLayoutParams) r11
            int r12 = r12.getMeasuredHeight()
            int r0 = r11.topMargin
            int r12 = r12 + r0
            int r11 = r11.bottomMargin
            int r12 = r12 + r11
            goto Lab
        La7:
            int r12 = r12.getMeasuredHeight()
        Lab:
            r10.setMinimumHeight(r12)
            return
        Laf:
            android.view.ViewGroup$LayoutParams r12 = r11.getLayoutParams()
            boolean r0 = r12 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r0 == 0) goto Lc4
            android.view.ViewGroup$MarginLayoutParams r12 = (android.view.ViewGroup.MarginLayoutParams) r12
            int r11 = r11.getMeasuredHeight()
            int r0 = r12.topMargin
            int r11 = r11 + r0
            int r12 = r12.bottomMargin
            int r11 = r11 + r12
            goto Lc8
        Lc4:
            int r11 = r11.getMeasuredHeight()
        Lc8:
            r10.setMinimumHeight(r11)
        Lcb:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.onMeasure(int, int):void");
    }

    @Override // android.view.View
    public final void onSizeChanged(int i3, int i10, int i11, int i12) {
        super.onSizeChanged(i3, i10, i11, i12);
        Drawable drawable = this.f10204o;
        if (drawable != null) {
            ViewGroup viewGroup = this.f10193c;
            if (this.f10212x == 1 && viewGroup != null && this.f10202m) {
                i10 = viewGroup.getBottom();
            }
            drawable.setBounds(0, 0, i3, i10);
        }
    }

    public void setCollapsedTitleGravity(int i3) {
        this.f10200k.l(i3);
    }

    public void setCollapsedTitleTextAppearance(int i3) {
        this.f10200k.j(i3);
    }

    public void setCollapsedTitleTextColor(int i3) {
        setCollapsedTitleTextColor(ColorStateList.valueOf(i3));
    }

    public void setCollapsedTitleTypeface(Typeface typeface) {
        com.google.android.material.internal.b bVar = this.f10200k;
        bb.b bVar2 = bVar.A;
        if (bVar2 != null) {
            bVar2.f3184c = true;
        }
        if (bVar.f10585w != typeface) {
            bVar.f10585w = typeface;
            bVar.i(false);
        }
    }

    public void setContentScrim(Drawable drawable) {
        Drawable drawable2 = this.f10204o;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f10204o = mutate;
            if (mutate != null) {
                int width = getWidth();
                int height = getHeight();
                ViewGroup viewGroup = this.f10193c;
                if (this.f10212x == 1 && viewGroup != null && this.f10202m) {
                    height = viewGroup.getBottom();
                }
                mutate.setBounds(0, 0, width, height);
                this.f10204o.setCallback(this);
                this.f10204o.setAlpha(this.f10206q);
            }
            WeakHashMap weakHashMap = z0.f15748a;
            h0.k(this);
        }
    }

    public void setContentScrimColor(int i3) {
        setContentScrim(new ColorDrawable(i3));
    }

    public void setContentScrimResource(int i3) {
        setContentScrim(a1.c.b(getContext(), i3));
    }

    public void setExpandedTitleColor(int i3) {
        setExpandedTitleTextColor(ColorStateList.valueOf(i3));
    }

    public void setExpandedTitleGravity(int i3) {
        com.google.android.material.internal.b bVar = this.f10200k;
        if (bVar.f10574k != i3) {
            bVar.f10574k = i3;
            bVar.i(false);
        }
    }

    public void setExpandedTitleMarginBottom(int i3) {
        this.f10198i = i3;
        requestLayout();
    }

    public void setExpandedTitleMarginEnd(int i3) {
        this.f10197h = i3;
        requestLayout();
    }

    public void setExpandedTitleMarginStart(int i3) {
        this.f10195f = i3;
        requestLayout();
    }

    public void setExpandedTitleMarginTop(int i3) {
        this.f10196g = i3;
        requestLayout();
    }

    public void setExpandedTitleTextAppearance(int i3) {
        this.f10200k.m(i3);
    }

    public void setExpandedTitleTextColor(ColorStateList colorStateList) {
        com.google.android.material.internal.b bVar = this.f10200k;
        if (bVar.f10578o != colorStateList) {
            bVar.f10578o = colorStateList;
            bVar.i(false);
        }
    }

    public void setExpandedTitleTypeface(Typeface typeface) {
        com.google.android.material.internal.b bVar = this.f10200k;
        bb.b bVar2 = bVar.f10588z;
        if (bVar2 != null) {
            bVar2.f3184c = true;
        }
        if (bVar.f10586x != typeface) {
            bVar.f10586x = typeface;
            bVar.i(false);
        }
    }

    public void setExtraMultilineHeightEnabled(boolean z5) {
        this.C = z5;
    }

    public void setForceApplySystemWindowInsetTop(boolean z5) {
        this.A = z5;
    }

    public void setHyphenationFrequency(int i3) {
        this.f10200k.f10570g0 = i3;
    }

    public void setLineSpacingAdd(float f2) {
        this.f10200k.f10566e0 = f2;
    }

    public void setLineSpacingMultiplier(float f2) {
        this.f10200k.f10568f0 = f2;
    }

    public void setMaxLines(int i3) {
        com.google.android.material.internal.b bVar = this.f10200k;
        if (i3 != bVar.f10565d0) {
            bVar.f10565d0 = i3;
            Bitmap bitmap = bVar.F;
            if (bitmap != null) {
                bitmap.recycle();
                bVar.F = null;
            }
            bVar.i(false);
        }
    }

    public void setRtlTextDirectionHeuristicsEnabled(boolean z5) {
        this.f10200k.E = z5;
    }

    public void setScrimAlpha(int i3) {
        ViewGroup viewGroup;
        if (i3 != this.f10206q) {
            if (this.f10204o != null && (viewGroup = this.f10193c) != null) {
                WeakHashMap weakHashMap = z0.f15748a;
                h0.k(viewGroup);
            }
            this.f10206q = i3;
            WeakHashMap weakHashMap2 = z0.f15748a;
            h0.k(this);
        }
    }

    public void setScrimAnimationDuration(long j4) {
        this.f10208t = j4;
    }

    public void setScrimVisibleHeightTrigger(int i3) {
        if (this.f10209u != i3) {
            this.f10209u = i3;
            d();
        }
    }

    public void setScrimsShown(boolean z5) {
        WeakHashMap weakHashMap = z0.f15748a;
        boolean z6 = k0.c(this) && !isInEditMode();
        if (this.r != z5) {
            if (z6) {
                int i3 = z5 ? 255 : 0;
                a();
                ValueAnimator valueAnimator = this.f10207s;
                if (valueAnimator == null) {
                    ValueAnimator valueAnimator2 = new ValueAnimator();
                    this.f10207s = valueAnimator2;
                    valueAnimator2.setDuration(this.f10208t);
                    this.f10207s.setInterpolator(i3 > this.f10206q ? ja.a.f15385c : ja.a.f15386d);
                    this.f10207s.addUpdateListener(new t(this, 6));
                } else if (valueAnimator.isRunning()) {
                    this.f10207s.cancel();
                }
                this.f10207s.setIntValues(this.f10206q, i3);
                this.f10207s.start();
            } else {
                setScrimAlpha(z5 ? 255 : 0);
            }
            this.r = z5;
        }
    }

    public void setStatusBarScrim(Drawable drawable) {
        Drawable drawable2 = this.f10205p;
        if (drawable2 != drawable) {
            if (drawable2 != null) {
                drawable2.setCallback(null);
            }
            Drawable mutate = drawable != null ? drawable.mutate() : null;
            this.f10205p = mutate;
            if (mutate != null) {
                if (mutate.isStateful()) {
                    this.f10205p.setState(getDrawableState());
                }
                Drawable drawable3 = this.f10205p;
                WeakHashMap weakHashMap = z0.f15748a;
                d1.c.b(drawable3, i0.d(this));
                this.f10205p.setVisible(getVisibility() == 0, false);
                this.f10205p.setCallback(this);
                this.f10205p.setAlpha(this.f10206q);
            }
            WeakHashMap weakHashMap2 = z0.f15748a;
            h0.k(this);
        }
    }

    public void setStatusBarScrimColor(int i3) {
        setStatusBarScrim(new ColorDrawable(i3));
    }

    public void setStatusBarScrimResource(int i3) {
        setStatusBarScrim(a1.c.b(getContext(), i3));
    }

    public void setTitle(CharSequence charSequence) {
        com.google.android.material.internal.b bVar = this.f10200k;
        if (charSequence == null || !TextUtils.equals(bVar.B, charSequence)) {
            bVar.B = charSequence;
            bVar.C = null;
            Bitmap bitmap = bVar.F;
            if (bitmap != null) {
                bitmap.recycle();
                bVar.F = null;
            }
            bVar.i(false);
        }
        setContentDescription(getTitle());
    }

    public void setTitleCollapseMode(int i3) {
        this.f10212x = i3;
        boolean z5 = i3 == 1;
        this.f10200k.f10564d = z5;
        ViewParent parent = getParent();
        if (parent instanceof AppBarLayout) {
            AppBarLayout appBarLayout = (AppBarLayout) parent;
            if (this.f10212x == 1) {
                appBarLayout.setLiftOnScroll(false);
            }
        }
        if (z5 && this.f10204o == null) {
            float dimension = getResources().getDimension(R$dimen.design_appbar_elevation);
            ua.a aVar = this.f10201l;
            setContentScrimColor(aVar.a(dimension, aVar.f19030c));
        }
    }

    public void setTitleEnabled(boolean z5) {
        if (z5 != this.f10202m) {
            this.f10202m = z5;
            setContentDescription(getTitle());
            c();
            requestLayout();
        }
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        boolean z5 = i3 == 0;
        Drawable drawable = this.f10205p;
        if (drawable != null && drawable.isVisible() != z5) {
            this.f10205p.setVisible(z5, false);
        }
        Drawable drawable2 = this.f10204o;
        if (drawable2 == null || drawable2.isVisible() == z5) {
            return;
        }
        this.f10204o.setVisible(z5, false);
    }

    @Override // android.view.View
    public final boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f10204o || drawable == this.f10205p;
    }

    public CollapsingToolbarLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.collapsingToolbarLayoutStyle);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        Context context = getContext();
        ka.d dVar = new ka.d(context, attributeSet);
        dVar.f15574a = 0;
        dVar.f15575b = 0.5f;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.CollapsingToolbarLayout_Layout);
        dVar.f15574a = obtainStyledAttributes.getInt(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseMode, 0);
        dVar.f15575b = obtainStyledAttributes.getFloat(R$styleable.CollapsingToolbarLayout_Layout_layout_collapseParallaxMultiplier, 0.5f);
        obtainStyledAttributes.recycle();
        return dVar;
    }

    public void setCollapsedTitleTextColor(ColorStateList colorStateList) {
        this.f10200k.k(colorStateList);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public CollapsingToolbarLayout(android.content.Context r10, android.util.AttributeSet r11, int r12) {
        /*
            Method dump skipped, instructions count: 361
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.CollapsingToolbarLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateDefaultLayoutParams() {
        ka.d dVar = new ka.d(-1, -1);
        dVar.f15574a = 0;
        dVar.f15575b = 0.5f;
        return dVar;
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        ka.d dVar = new ka.d(layoutParams);
        dVar.f15574a = 0;
        dVar.f15575b = 0.5f;
        return dVar;
    }
}
