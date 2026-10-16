package com.google.android.material.tabs;

import android.R;
import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.text.Layout;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.d2;
import androidx.appcompat.widget.y3;
import androidx.core.widget.p;
import androidx.viewpager.widget.ViewPager;
import com.example.test.ui.device.activity.f0;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.rb;
import com.google.android.gms.internal.mlkit_vision_barcode.t0;
import com.google.android.material.R$attr;
import com.google.android.material.R$layout;
import com.google.android.material.R$string;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.badge.BadgeDrawable$SavedState;
import com.google.android.material.internal.s;
import com.google.android.material.internal.t;
import com.google.android.material.internal.w;
import hb.g;
import hb.h;
import hb.i;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.WeakHashMap;
import k1.d;
import k1.e;
import l1.a0;
import l1.h0;
import l1.i0;
import l1.k0;
import l1.p0;
import l1.z0;
import n2.f;

@f
/* loaded from: classes.dex */
public class TabLayout extends HorizontalScrollView {
    public static final int Q = R$style.Widget_Design_TabLayout;
    public static final e R = new e(16);
    public boolean A;
    public boolean B;
    public int C;
    public boolean D;
    public a E;
    public hb.c F;
    public final ArrayList G;
    public i H;
    public ValueAnimator I;
    public ViewPager J;
    public n2.a K;
    public d2 L;
    public h M;
    public hb.b N;
    public boolean O;
    public final d P;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10781a;

    /* renamed from: b, reason: collision with root package name */
    public b f10782b;

    /* renamed from: c, reason: collision with root package name */
    public final g f10783c;

    /* renamed from: d, reason: collision with root package name */
    public final int f10784d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f10785f;

    /* renamed from: g, reason: collision with root package name */
    public final int f10786g;

    /* renamed from: h, reason: collision with root package name */
    public final int f10787h;

    /* renamed from: i, reason: collision with root package name */
    public ColorStateList f10788i;

    /* renamed from: j, reason: collision with root package name */
    public ColorStateList f10789j;

    /* renamed from: k, reason: collision with root package name */
    public ColorStateList f10790k;

    /* renamed from: l, reason: collision with root package name */
    public Drawable f10791l;

    /* renamed from: m, reason: collision with root package name */
    public int f10792m;

    /* renamed from: n, reason: collision with root package name */
    public final PorterDuff.Mode f10793n;

    /* renamed from: o, reason: collision with root package name */
    public final float f10794o;

    /* renamed from: p, reason: collision with root package name */
    public final float f10795p;

    /* renamed from: q, reason: collision with root package name */
    public final int f10796q;
    public int r;

    /* renamed from: s, reason: collision with root package name */
    public final int f10797s;

    /* renamed from: t, reason: collision with root package name */
    public final int f10798t;

    /* renamed from: u, reason: collision with root package name */
    public final int f10799u;

    /* renamed from: v, reason: collision with root package name */
    public final int f10800v;

    /* renamed from: w, reason: collision with root package name */
    public int f10801w;

    /* renamed from: x, reason: collision with root package name */
    public final int f10802x;

    /* renamed from: y, reason: collision with root package name */
    public int f10803y;

    /* renamed from: z, reason: collision with root package name */
    public int f10804z;

    public final class TabView extends LinearLayout {

        /* renamed from: l, reason: collision with root package name */
        public static final /* synthetic */ int f10805l = 0;

        /* renamed from: a, reason: collision with root package name */
        public b f10806a;

        /* renamed from: b, reason: collision with root package name */
        public TextView f10807b;

        /* renamed from: c, reason: collision with root package name */
        public ImageView f10808c;

        /* renamed from: d, reason: collision with root package name */
        public View f10809d;
        public la.a e;

        /* renamed from: f, reason: collision with root package name */
        public View f10810f;

        /* renamed from: g, reason: collision with root package name */
        public TextView f10811g;

        /* renamed from: h, reason: collision with root package name */
        public ImageView f10812h;

        /* renamed from: i, reason: collision with root package name */
        public Drawable f10813i;

        /* renamed from: j, reason: collision with root package name */
        public int f10814j;

        public TabView(Context context) {
            super(context);
            this.f10814j = 2;
            e(context);
            int i3 = TabLayout.this.f10784d;
            WeakHashMap weakHashMap = z0.f15748a;
            i0.k(this, i3, TabLayout.this.e, TabLayout.this.f10785f, TabLayout.this.f10786g);
            setGravity(17);
            setOrientation(!TabLayout.this.A ? 1 : 0);
            setClickable(true);
            p0.d(this, a0.b(getContext(), 1002));
        }

        private la.a getBadge() {
            return this.e;
        }

        private la.a getOrCreateBadge() {
            int i3;
            if (this.e == null) {
                Context context = getContext();
                la.a aVar = new la.a(context);
                int[] iArr = R$styleable.Badge;
                int i10 = la.a.r;
                int i11 = la.a.f15837q;
                w.a(context, null, i10, i11);
                w.b(context, null, iArr, i10, i11, new int[0]);
                TypedArray obtainStyledAttributes = context.obtainStyledAttributes(null, iArr, i10, i11);
                aVar.g(obtainStyledAttributes.getInt(R$styleable.Badge_maxCharacterCount, 4));
                boolean hasValue = obtainStyledAttributes.hasValue(R$styleable.Badge_number);
                s sVar = aVar.f15840c;
                BadgeDrawable$SavedState badgeDrawable$SavedState = aVar.f15844h;
                if (hasValue) {
                    int max = Math.max(0, obtainStyledAttributes.getInt(R$styleable.Badge_number, 0));
                    i3 = badgeDrawable$SavedState.number;
                    if (i3 != max) {
                        badgeDrawable$SavedState.number = max;
                        sVar.f10635d = true;
                        aVar.i();
                        aVar.invalidateSelf();
                    }
                }
                int defaultColor = t0.a(context, obtainStyledAttributes, R$styleable.Badge_backgroundColor).getDefaultColor();
                badgeDrawable$SavedState.backgroundColor = defaultColor;
                ColorStateList valueOf = ColorStateList.valueOf(defaultColor);
                eb.h hVar = aVar.f15839b;
                if (hVar.f12505a.f12490c != valueOf) {
                    hVar.l(valueOf);
                    aVar.invalidateSelf();
                }
                if (obtainStyledAttributes.hasValue(R$styleable.Badge_badgeTextColor)) {
                    int defaultColor2 = t0.a(context, obtainStyledAttributes, R$styleable.Badge_badgeTextColor).getDefaultColor();
                    badgeDrawable$SavedState.badgeTextColor = defaultColor2;
                    if (sVar.f10632a.getColor() != defaultColor2) {
                        sVar.f10632a.setColor(defaultColor2);
                        aVar.invalidateSelf();
                    }
                }
                aVar.f(obtainStyledAttributes.getInt(R$styleable.Badge_badgeGravity, 8388661));
                badgeDrawable$SavedState.horizontalOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.Badge_horizontalOffset, 0);
                aVar.i();
                badgeDrawable$SavedState.verticalOffset = obtainStyledAttributes.getDimensionPixelOffset(R$styleable.Badge_verticalOffset, 0);
                aVar.i();
                obtainStyledAttributes.recycle();
                this.e = aVar;
            }
            b();
            la.a aVar2 = this.e;
            if (aVar2 != null) {
                return aVar2;
            }
            throw new IllegalStateException("Unable to create badge");
        }

        public final void a() {
            if (this.e != null) {
                setClipChildren(true);
                setClipToPadding(true);
                ViewGroup viewGroup = (ViewGroup) getParent();
                if (viewGroup != null) {
                    viewGroup.setClipChildren(true);
                    viewGroup.setClipToPadding(true);
                }
                View view = this.f10809d;
                if (view != null) {
                    la.a aVar = this.e;
                    if (aVar != null) {
                        WeakReference weakReference = aVar.f15852p;
                        if ((weakReference != null ? (FrameLayout) weakReference.get() : null) != null) {
                            WeakReference weakReference2 = aVar.f15852p;
                            (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(null);
                        } else {
                            view.getOverlay().remove(aVar);
                        }
                    }
                    this.f10809d = null;
                }
            }
        }

        public final void b() {
            b bVar;
            if (this.e != null) {
                if (this.f10810f != null) {
                    a();
                    return;
                }
                ImageView imageView = this.f10808c;
                if (imageView != null && (bVar = this.f10806a) != null && bVar.f10816a != null) {
                    if (this.f10809d == imageView) {
                        c(imageView);
                        return;
                    }
                    a();
                    ImageView imageView2 = this.f10808c;
                    if (this.e == null || imageView2 == null) {
                        return;
                    }
                    setClipChildren(false);
                    setClipToPadding(false);
                    ViewGroup viewGroup = (ViewGroup) getParent();
                    if (viewGroup != null) {
                        viewGroup.setClipChildren(false);
                        viewGroup.setClipToPadding(false);
                    }
                    la.a aVar = this.e;
                    Rect rect = new Rect();
                    imageView2.getDrawingRect(rect);
                    aVar.setBounds(rect);
                    aVar.h(imageView2, null);
                    WeakReference weakReference = aVar.f15852p;
                    if ((weakReference != null ? (FrameLayout) weakReference.get() : null) != null) {
                        WeakReference weakReference2 = aVar.f15852p;
                        (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(aVar);
                    } else {
                        imageView2.getOverlay().add(aVar);
                    }
                    this.f10809d = imageView2;
                    return;
                }
                TextView textView = this.f10807b;
                if (textView == null || this.f10806a == null) {
                    a();
                    return;
                }
                if (this.f10809d == textView) {
                    c(textView);
                    return;
                }
                a();
                TextView textView2 = this.f10807b;
                if (this.e == null || textView2 == null) {
                    return;
                }
                setClipChildren(false);
                setClipToPadding(false);
                ViewGroup viewGroup2 = (ViewGroup) getParent();
                if (viewGroup2 != null) {
                    viewGroup2.setClipChildren(false);
                    viewGroup2.setClipToPadding(false);
                }
                la.a aVar2 = this.e;
                Rect rect2 = new Rect();
                textView2.getDrawingRect(rect2);
                aVar2.setBounds(rect2);
                aVar2.h(textView2, null);
                WeakReference weakReference3 = aVar2.f15852p;
                if ((weakReference3 != null ? (FrameLayout) weakReference3.get() : null) != null) {
                    WeakReference weakReference4 = aVar2.f15852p;
                    (weakReference4 != null ? (FrameLayout) weakReference4.get() : null).setForeground(aVar2);
                } else {
                    textView2.getOverlay().add(aVar2);
                }
                this.f10809d = textView2;
            }
        }

        public final void c(View view) {
            la.a aVar = this.e;
            if (aVar == null || view != this.f10809d) {
                return;
            }
            Rect rect = new Rect();
            view.getDrawingRect(rect);
            aVar.setBounds(rect);
            aVar.h(view, null);
        }

        public final void d() {
            Drawable drawable;
            b bVar = this.f10806a;
            Drawable drawable2 = null;
            View view = bVar != null ? bVar.e : null;
            if (view != null) {
                ViewParent parent = view.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(view);
                    }
                    addView(view);
                }
                this.f10810f = view;
                TextView textView = this.f10807b;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f10808c;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f10808c.setImageDrawable(null);
                }
                TextView textView2 = (TextView) view.findViewById(R.id.text1);
                this.f10811g = textView2;
                if (textView2 != null) {
                    this.f10814j = p.b(textView2);
                }
                this.f10812h = (ImageView) view.findViewById(R.id.icon);
            } else {
                View view2 = this.f10810f;
                if (view2 != null) {
                    removeView(view2);
                    this.f10810f = null;
                }
                this.f10811g = null;
                this.f10812h = null;
            }
            boolean z5 = false;
            if (this.f10810f == null) {
                if (this.f10808c == null) {
                    ImageView imageView2 = (ImageView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_icon, (ViewGroup) this, false);
                    this.f10808c = imageView2;
                    addView(imageView2, 0);
                }
                if (bVar != null && (drawable = bVar.f10816a) != null) {
                    drawable2 = drawable.mutate();
                }
                TabLayout tabLayout = TabLayout.this;
                if (drawable2 != null) {
                    d1.b.h(drawable2, tabLayout.f10789j);
                    PorterDuff.Mode mode = tabLayout.f10793n;
                    if (mode != null) {
                        d1.b.i(drawable2, mode);
                    }
                }
                if (this.f10807b == null) {
                    TextView textView3 = (TextView) LayoutInflater.from(getContext()).inflate(R$layout.design_layout_tab_text, (ViewGroup) this, false);
                    this.f10807b = textView3;
                    addView(textView3);
                    this.f10814j = p.b(this.f10807b);
                }
                this.f10807b.setTextAppearance(tabLayout.f10787h);
                ColorStateList colorStateList = tabLayout.f10788i;
                if (colorStateList != null) {
                    this.f10807b.setTextColor(colorStateList);
                }
                f(this.f10807b, this.f10808c);
                b();
                ImageView imageView3 = this.f10808c;
                if (imageView3 != null) {
                    imageView3.addOnLayoutChangeListener(new c(this, imageView3));
                }
                TextView textView4 = this.f10807b;
                if (textView4 != null) {
                    textView4.addOnLayoutChangeListener(new c(this, textView4));
                }
            } else {
                TextView textView5 = this.f10811g;
                if (textView5 != null || this.f10812h != null) {
                    f(textView5, this.f10812h);
                }
            }
            if (bVar != null && !TextUtils.isEmpty(bVar.f10818c)) {
                setContentDescription(bVar.f10818c);
            }
            if (bVar != null) {
                TabLayout tabLayout2 = bVar.f10820f;
                if (tabLayout2 == null) {
                    throw new IllegalArgumentException("Tab not attached to a TabLayout");
                }
                if (tabLayout2.getSelectedTabPosition() == bVar.f10819d) {
                    z5 = true;
                }
            }
            setSelected(z5);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void drawableStateChanged() {
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            Drawable drawable = this.f10813i;
            if ((drawable == null || !drawable.isStateful()) ? false : this.f10813i.setState(drawableState)) {
                invalidate();
                TabLayout.this.invalidate();
            }
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r4v0, types: [android.graphics.drawable.RippleDrawable] */
        public final void e(Context context) {
            TabLayout tabLayout = TabLayout.this;
            int i3 = tabLayout.f10796q;
            if (i3 != 0) {
                Drawable b3 = pb.b(context, i3);
                this.f10813i = b3;
                if (b3 != null && b3.isStateful()) {
                    this.f10813i.setState(getDrawableState());
                }
            } else {
                this.f10813i = null;
            }
            GradientDrawable gradientDrawable = new GradientDrawable();
            gradientDrawable.setColor(0);
            if (tabLayout.f10790k != null) {
                GradientDrawable gradientDrawable2 = new GradientDrawable();
                gradientDrawable2.setCornerRadius(1.0E-5f);
                gradientDrawable2.setColor(-1);
                ColorStateList a3 = cb.a.a(tabLayout.f10790k);
                boolean z5 = tabLayout.D;
                if (z5) {
                    gradientDrawable = null;
                }
                gradientDrawable = new RippleDrawable(a3, gradientDrawable, z5 ? null : gradientDrawable2);
            }
            WeakHashMap weakHashMap = z0.f15748a;
            h0.q(this, gradientDrawable);
            tabLayout.invalidate();
        }

        public final void f(TextView textView, ImageView imageView) {
            Drawable drawable;
            b bVar = this.f10806a;
            Drawable mutate = (bVar == null || (drawable = bVar.f10816a) == null) ? null : drawable.mutate();
            b bVar2 = this.f10806a;
            CharSequence charSequence = bVar2 != null ? bVar2.f10817b : null;
            if (imageView != null) {
                if (mutate != null) {
                    imageView.setImageDrawable(mutate);
                    imageView.setVisibility(0);
                    setVisibility(0);
                } else {
                    imageView.setVisibility(8);
                    imageView.setImageDrawable(null);
                }
            }
            boolean isEmpty = TextUtils.isEmpty(charSequence);
            if (textView != null) {
                if (isEmpty) {
                    textView.setVisibility(8);
                    textView.setText((CharSequence) null);
                } else {
                    textView.setText(charSequence);
                    this.f10806a.getClass();
                    textView.setVisibility(0);
                    setVisibility(0);
                }
            }
            if (imageView != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) imageView.getLayoutParams();
                int b3 = (isEmpty || imageView.getVisibility() != 0) ? 0 : (int) gb.b(getContext(), 8);
                if (TabLayout.this.A) {
                    if (b3 != l1.p.b(marginLayoutParams)) {
                        l1.p.g(marginLayoutParams, b3);
                        marginLayoutParams.bottomMargin = 0;
                        imageView.setLayoutParams(marginLayoutParams);
                        imageView.requestLayout();
                    }
                } else if (b3 != marginLayoutParams.bottomMargin) {
                    marginLayoutParams.bottomMargin = b3;
                    l1.p.g(marginLayoutParams, 0);
                    imageView.setLayoutParams(marginLayoutParams);
                    imageView.requestLayout();
                }
            }
            b bVar3 = this.f10806a;
            CharSequence charSequence2 = bVar3 != null ? bVar3.f10818c : null;
            if (isEmpty) {
                charSequence = charSequence2;
            }
            y3.a(this, charSequence);
        }

        public int getContentHeight() {
            View[] viewArr = {this.f10807b, this.f10808c, this.f10810f};
            int i3 = 0;
            int i10 = 0;
            boolean z5 = false;
            for (int i11 = 0; i11 < 3; i11++) {
                View view = viewArr[i11];
                if (view != null && view.getVisibility() == 0) {
                    i10 = z5 ? Math.min(i10, view.getTop()) : view.getTop();
                    i3 = z5 ? Math.max(i3, view.getBottom()) : view.getBottom();
                    z5 = true;
                }
            }
            return i3 - i10;
        }

        public int getContentWidth() {
            View[] viewArr = {this.f10807b, this.f10808c, this.f10810f};
            int i3 = 0;
            int i10 = 0;
            boolean z5 = false;
            for (int i11 = 0; i11 < 3; i11++) {
                View view = viewArr[i11];
                if (view != null && view.getVisibility() == 0) {
                    i10 = z5 ? Math.min(i10, view.getLeft()) : view.getLeft();
                    i3 = z5 ? Math.max(i3, view.getRight()) : view.getRight();
                    z5 = true;
                }
            }
            return i3 - i10;
        }

        public b getTab() {
            return this.f10806a;
        }

        @Override // android.view.View
        public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            la.a aVar = this.e;
            if (aVar != null && aVar.isVisible()) {
                accessibilityNodeInfo.setContentDescription(((Object) getContentDescription()) + ", " + ((Object) this.e.c()));
            }
            accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) com.example.test.ui.device.activity.i0.o(0, 1, this.f10806a.f10819d, 1, isSelected()).f7866b);
            if (isSelected()) {
                accessibilityNodeInfo.setClickable(false);
                accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) m1.c.f15925g.f15934a);
            }
            accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R$string.item_view_role_description));
        }

        @Override // android.widget.LinearLayout, android.view.View
        public final void onMeasure(int i3, int i10) {
            int size = View.MeasureSpec.getSize(i3);
            int mode = View.MeasureSpec.getMode(i3);
            TabLayout tabLayout = TabLayout.this;
            int tabMaxWidth = tabLayout.getTabMaxWidth();
            if (tabMaxWidth > 0 && (mode == 0 || size > tabMaxWidth)) {
                i3 = View.MeasureSpec.makeMeasureSpec(tabLayout.r, Integer.MIN_VALUE);
            }
            super.onMeasure(i3, i10);
            if (this.f10807b != null) {
                float f2 = tabLayout.f10794o;
                int i11 = this.f10814j;
                ImageView imageView = this.f10808c;
                if (imageView == null || imageView.getVisibility() != 0) {
                    TextView textView = this.f10807b;
                    if (textView != null && textView.getLineCount() > 1) {
                        f2 = tabLayout.f10795p;
                    }
                } else {
                    i11 = 1;
                }
                float textSize = this.f10807b.getTextSize();
                int lineCount = this.f10807b.getLineCount();
                int b3 = p.b(this.f10807b);
                if (f2 != textSize || (b3 >= 0 && i11 != b3)) {
                    if (tabLayout.f10804z == 1 && f2 > textSize && lineCount == 1) {
                        Layout layout = this.f10807b.getLayout();
                        if (layout == null) {
                            return;
                        }
                        if ((f2 / layout.getPaint().getTextSize()) * layout.getLineWidth(0) > (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight()) {
                            return;
                        }
                    }
                    this.f10807b.setTextSize(0, f2);
                    this.f10807b.setMaxLines(i11);
                    super.onMeasure(i3, i10);
                }
            }
        }

        @Override // android.view.View
        public final boolean performClick() {
            boolean performClick = super.performClick();
            if (this.f10806a == null) {
                return performClick;
            }
            if (!performClick) {
                playSoundEffect(0);
            }
            b bVar = this.f10806a;
            TabLayout tabLayout = bVar.f10820f;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.j(bVar, true);
            return true;
        }

        @Override // android.view.View
        public void setSelected(boolean z5) {
            isSelected();
            super.setSelected(z5);
            TextView textView = this.f10807b;
            if (textView != null) {
                textView.setSelected(z5);
            }
            ImageView imageView = this.f10808c;
            if (imageView != null) {
                imageView.setSelected(z5);
            }
            View view = this.f10810f;
            if (view != null) {
                view.setSelected(z5);
            }
        }

        public void setTab(b bVar) {
            if (bVar != this.f10806a) {
                this.f10806a = bVar;
                d();
            }
        }
    }

    public TabLayout(Context context) {
        this(context, null);
    }

    private int getDefaultHeight() {
        ArrayList arrayList = this.f10781a;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            b bVar = (b) arrayList.get(i3);
            if (bVar != null && bVar.f10816a != null && !TextUtils.isEmpty(bVar.f10817b)) {
                return !this.A ? 72 : 48;
            }
        }
        return 48;
    }

    private int getTabMinWidth() {
        int i3 = this.f10797s;
        if (i3 != -1) {
            return i3;
        }
        int i10 = this.f10804z;
        if (i10 == 0 || i10 == 2) {
            return this.f10799u;
        }
        return 0;
    }

    private int getTabScrollRange() {
        return Math.max(0, ((this.f10783c.getWidth() - getWidth()) - getPaddingLeft()) - getPaddingRight());
    }

    private void setSelectedTabView(int i3) {
        g gVar = this.f10783c;
        int childCount = gVar.getChildCount();
        if (i3 < childCount) {
            int i10 = 0;
            while (i10 < childCount) {
                View childAt = gVar.getChildAt(i10);
                boolean z5 = true;
                childAt.setSelected(i10 == i3);
                if (i10 != i3) {
                    z5 = false;
                }
                childAt.setActivated(z5);
                i10++;
            }
        }
    }

    public final void a(b bVar, boolean z5) {
        ArrayList arrayList = this.f10781a;
        int size = arrayList.size();
        if (bVar.f10820f != this) {
            throw new IllegalArgumentException("Tab belongs to a different TabLayout.");
        }
        bVar.f10819d = size;
        arrayList.add(size, bVar);
        int size2 = arrayList.size();
        for (int i3 = size + 1; i3 < size2; i3++) {
            ((b) arrayList.get(i3)).f10819d = i3;
        }
        TabView tabView = bVar.f10821g;
        tabView.setSelected(false);
        tabView.setActivated(false);
        int i10 = bVar.f10819d;
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -1);
        if (this.f10804z == 1 && this.f10801w == 0) {
            layoutParams.width = 0;
            layoutParams.weight = 1.0f;
        } else {
            layoutParams.width = -2;
            layoutParams.weight = 0.0f;
        }
        this.f10783c.addView(tabView, i10, layoutParams);
        if (z5) {
            TabLayout tabLayout = bVar.f10820f;
            if (tabLayout == null) {
                throw new IllegalArgumentException("Tab not attached to a TabLayout");
            }
            tabLayout.j(bVar, true);
        }
    }

    public void addOnTabSelectedListener(hb.d dVar) {
        addOnTabSelectedListener((hb.c) dVar);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view) {
        b(view);
    }

    public final void b(View view) {
        if (!(view instanceof TabItem)) {
            throw new IllegalArgumentException("Only TabItem instances can be added to TabLayout");
        }
        TabItem tabItem = (TabItem) view;
        b h4 = h();
        CharSequence charSequence = tabItem.f10778a;
        if (charSequence != null) {
            if (TextUtils.isEmpty(h4.f10818c) && !TextUtils.isEmpty(charSequence)) {
                h4.f10821g.setContentDescription(charSequence);
            }
            h4.f10817b = charSequence;
            TabView tabView = h4.f10821g;
            if (tabView != null) {
                tabView.d();
            }
        }
        Drawable drawable = tabItem.f10779b;
        if (drawable != null) {
            h4.f10816a = drawable;
            TabLayout tabLayout = h4.f10820f;
            if (tabLayout.f10801w == 1 || tabLayout.f10804z == 2) {
                tabLayout.n(true);
            }
            TabView tabView2 = h4.f10821g;
            if (tabView2 != null) {
                tabView2.d();
            }
        }
        int i3 = tabItem.f10780c;
        if (i3 != 0) {
            h4.e = LayoutInflater.from(h4.f10821g.getContext()).inflate(i3, (ViewGroup) h4.f10821g, false);
            TabView tabView3 = h4.f10821g;
            if (tabView3 != null) {
                tabView3.d();
            }
        }
        if (!TextUtils.isEmpty(tabItem.getContentDescription())) {
            h4.f10818c = tabItem.getContentDescription();
            TabView tabView4 = h4.f10821g;
            if (tabView4 != null) {
                tabView4.d();
            }
        }
        a(h4, this.f10781a.isEmpty());
    }

    public final void c(int i3) {
        if (i3 == -1) {
            return;
        }
        if (getWindowToken() != null) {
            WeakHashMap weakHashMap = z0.f15748a;
            if (k0.c(this)) {
                g gVar = this.f10783c;
                int childCount = gVar.getChildCount();
                for (int i10 = 0; i10 < childCount; i10++) {
                    if (gVar.getChildAt(i10).getWidth() > 0) {
                    }
                }
                int scrollX = getScrollX();
                int e = e(0.0f, i3);
                if (scrollX != e) {
                    f();
                    this.I.setIntValues(scrollX, e);
                    this.I.start();
                }
                ValueAnimator valueAnimator = gVar.f14299a;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    gVar.f14299a.cancel();
                }
                gVar.c(i3, this.f10802x, true);
                return;
            }
        }
        l(i3, 0.0f, true, true);
    }

    /* JADX WARN: Code restructure failed: missing block: B:19:0x003a, code lost:
    
        if (r0 != 2) goto L25;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void d() {
        /*
            r5 = this;
            int r0 = r5.f10804z
            r1 = 2
            r2 = 0
            if (r0 == 0) goto Lb
            if (r0 != r1) goto L9
            goto Lb
        L9:
            r0 = r2
            goto L14
        Lb:
            int r0 = r5.f10800v
            int r3 = r5.f10784d
            int r0 = r0 - r3
            int r0 = java.lang.Math.max(r2, r0)
        L14:
            java.util.WeakHashMap r3 = l1.z0.f15748a
            hb.g r3 = r5.f10783c
            l1.i0.k(r3, r0, r2, r2, r2)
            int r0 = r5.f10804z
            java.lang.String r2 = "TabLayout"
            r4 = 1
            if (r0 == 0) goto L34
            if (r0 == r4) goto L27
            if (r0 == r1) goto L27
            goto L4c
        L27:
            int r0 = r5.f10801w
            if (r0 != r1) goto L30
            java.lang.String r0 = "GRAVITY_START is not supported with the current tab mode, GRAVITY_CENTER will be used instead"
            android.util.Log.w(r2, r0)
        L30:
            r3.setGravity(r4)
            goto L4c
        L34:
            int r0 = r5.f10801w
            if (r0 == 0) goto L41
            if (r0 == r4) goto L3d
            if (r0 == r1) goto L46
            goto L4c
        L3d:
            r3.setGravity(r4)
            goto L4c
        L41:
            java.lang.String r0 = "MODE_SCROLLABLE + GRAVITY_FILL is not supported, GRAVITY_START will be used instead"
            android.util.Log.w(r2, r0)
        L46:
            r0 = 8388611(0x800003, float:1.1754948E-38)
            r3.setGravity(r0)
        L4c:
            r5.n(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.d():void");
    }

    public final int e(float f2, int i3) {
        int i10 = this.f10804z;
        if (i10 != 0 && i10 != 2) {
            return 0;
        }
        g gVar = this.f10783c;
        View childAt = gVar.getChildAt(i3);
        int i11 = i3 + 1;
        View childAt2 = i11 < gVar.getChildCount() ? gVar.getChildAt(i11) : null;
        int width = childAt != null ? childAt.getWidth() : 0;
        int width2 = childAt2 != null ? childAt2.getWidth() : 0;
        int left = ((width / 2) + childAt.getLeft()) - (getWidth() / 2);
        int i12 = (int) ((width + width2) * 0.5f * f2);
        WeakHashMap weakHashMap = z0.f15748a;
        return i0.d(this) == 0 ? left + i12 : left - i12;
    }

    public final void f() {
        if (this.I == null) {
            ValueAnimator valueAnimator = new ValueAnimator();
            this.I = valueAnimator;
            valueAnimator.setInterpolator(ja.a.f15384b);
            this.I.setDuration(this.f10802x);
            this.I.addUpdateListener(new t(this, 4));
        }
    }

    public final b g(int i3) {
        if (i3 < 0 || i3 >= getTabCount()) {
            return null;
        }
        return (b) this.f10781a.get(i3);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    public int getSelectedTabPosition() {
        b bVar = this.f10782b;
        if (bVar != null) {
            return bVar.f10819d;
        }
        return -1;
    }

    public int getTabCount() {
        return this.f10781a.size();
    }

    public int getTabGravity() {
        return this.f10801w;
    }

    public ColorStateList getTabIconTint() {
        return this.f10789j;
    }

    public int getTabIndicatorAnimationMode() {
        return this.C;
    }

    public int getTabIndicatorGravity() {
        return this.f10803y;
    }

    public int getTabMaxWidth() {
        return this.r;
    }

    public int getTabMode() {
        return this.f10804z;
    }

    public ColorStateList getTabRippleColor() {
        return this.f10790k;
    }

    public Drawable getTabSelectedIndicator() {
        return this.f10791l;
    }

    public ColorStateList getTabTextColors() {
        return this.f10788i;
    }

    public final b h() {
        b bVar = (b) R.a();
        if (bVar == null) {
            bVar = new b();
            bVar.f10819d = -1;
        }
        bVar.f10820f = this;
        d dVar = this.P;
        TabView tabView = dVar != null ? (TabView) dVar.a() : null;
        if (tabView == null) {
            tabView = new TabView(getContext());
        }
        tabView.setTab(bVar);
        tabView.setFocusable(true);
        tabView.setMinimumWidth(getTabMinWidth());
        if (TextUtils.isEmpty(bVar.f10818c)) {
            tabView.setContentDescription(bVar.f10817b);
        } else {
            tabView.setContentDescription(bVar.f10818c);
        }
        bVar.f10821g = tabView;
        return bVar;
    }

    public final void i() {
        int currentItem;
        g gVar = this.f10783c;
        for (int childCount = gVar.getChildCount() - 1; childCount >= 0; childCount--) {
            TabView tabView = (TabView) gVar.getChildAt(childCount);
            gVar.removeViewAt(childCount);
            if (tabView != null) {
                tabView.setTab(null);
                tabView.setSelected(false);
                this.P.c(tabView);
            }
            requestLayout();
        }
        Iterator it = this.f10781a.iterator();
        while (it.hasNext()) {
            b bVar = (b) it.next();
            it.remove();
            bVar.f10820f = null;
            bVar.f10821g = null;
            bVar.f10816a = null;
            bVar.f10817b = null;
            bVar.f10818c = null;
            bVar.f10819d = -1;
            bVar.e = null;
            R.c(bVar);
        }
        this.f10782b = null;
        n2.a aVar = this.K;
        if (aVar != null) {
            int c9 = aVar.c();
            for (int i3 = 0; i3 < c9; i3++) {
                b h4 = h();
                CharSequence e = this.K.e(i3);
                if (TextUtils.isEmpty(h4.f10818c) && !TextUtils.isEmpty(e)) {
                    h4.f10821g.setContentDescription(e);
                }
                h4.f10817b = e;
                TabView tabView2 = h4.f10821g;
                if (tabView2 != null) {
                    tabView2.d();
                }
                a(h4, false);
            }
            ViewPager viewPager = this.J;
            if (viewPager == null || c9 <= 0 || (currentItem = viewPager.getCurrentItem()) == getSelectedTabPosition() || currentItem >= getTabCount()) {
                return;
            }
            j(g(currentItem), true);
        }
    }

    public final void j(b bVar, boolean z5) {
        b bVar2 = this.f10782b;
        ArrayList arrayList = this.G;
        if (bVar2 == bVar) {
            if (bVar2 != null) {
                for (int size = arrayList.size() - 1; size >= 0; size--) {
                    ((hb.c) arrayList.get(size)).getClass();
                }
                c(bVar.f10819d);
                return;
            }
            return;
        }
        int i3 = bVar != null ? bVar.f10819d : -1;
        if (z5) {
            if ((bVar2 == null || bVar2.f10819d == -1) && i3 != -1) {
                l(i3, 0.0f, true, true);
            } else {
                c(i3);
            }
            if (i3 != -1) {
                setSelectedTabView(i3);
            }
        }
        this.f10782b = bVar;
        if (bVar2 != null) {
            for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                ((hb.c) arrayList.get(size2)).getClass();
            }
        }
        if (bVar != null) {
            for (int size3 = arrayList.size() - 1; size3 >= 0; size3--) {
                i iVar = (i) ((hb.c) arrayList.get(size3));
                iVar.getClass();
                iVar.f14306a.setCurrentItem(bVar.f10819d);
            }
        }
    }

    public final void k(n2.a aVar, boolean z5) {
        d2 d2Var;
        n2.a aVar2 = this.K;
        if (aVar2 != null && (d2Var = this.L) != null) {
            aVar2.f16360a.unregisterObserver(d2Var);
        }
        this.K = aVar;
        if (z5 && aVar != null) {
            if (this.L == null) {
                this.L = new d2(this, 1);
            }
            aVar.f16360a.registerObserver(this.L);
        }
        i();
    }

    public final void l(int i3, float f2, boolean z5, boolean z6) {
        int round = Math.round(i3 + f2);
        if (round >= 0) {
            g gVar = this.f10783c;
            if (round >= gVar.getChildCount()) {
                return;
            }
            if (z6) {
                ValueAnimator valueAnimator = gVar.f14299a;
                if (valueAnimator != null && valueAnimator.isRunning()) {
                    gVar.f14299a.cancel();
                }
                gVar.f14300b = i3;
                gVar.f14301c = f2;
                gVar.b(gVar.getChildAt(i3), gVar.getChildAt(gVar.f14300b + 1), gVar.f14301c);
            }
            ValueAnimator valueAnimator2 = this.I;
            if (valueAnimator2 != null && valueAnimator2.isRunning()) {
                this.I.cancel();
            }
            scrollTo(e(f2, i3), 0);
            if (z5) {
                setSelectedTabView(round);
            }
        }
    }

    public final void m(ViewPager viewPager, boolean z5) {
        ViewPager viewPager2 = this.J;
        if (viewPager2 != null) {
            h hVar = this.M;
            if (hVar != null) {
                viewPager2.removeOnPageChangeListener(hVar);
            }
            hb.b bVar = this.N;
            if (bVar != null) {
                this.J.removeOnAdapterChangeListener(bVar);
            }
        }
        hb.c cVar = this.H;
        if (cVar != null) {
            removeOnTabSelectedListener(cVar);
            this.H = null;
        }
        if (viewPager != null) {
            this.J = viewPager;
            if (this.M == null) {
                this.M = new h(this);
            }
            h hVar2 = this.M;
            hVar2.f14305c = 0;
            hVar2.f14304b = 0;
            viewPager.addOnPageChangeListener(hVar2);
            i iVar = new i(viewPager);
            this.H = iVar;
            addOnTabSelectedListener((hb.c) iVar);
            n2.a adapter = viewPager.getAdapter();
            if (adapter != null) {
                k(adapter, true);
            }
            if (this.N == null) {
                this.N = new hb.b(this);
            }
            hb.b bVar2 = this.N;
            bVar2.f14292a = true;
            viewPager.addOnAdapterChangeListener(bVar2);
            l(viewPager.getCurrentItem(), 0.0f, true, true);
        } else {
            this.J = null;
            k(null, false);
        }
        this.O = z5;
    }

    public final void n(boolean z5) {
        int i3 = 0;
        while (true) {
            g gVar = this.f10783c;
            if (i3 >= gVar.getChildCount()) {
                return;
            }
            View childAt = gVar.getChildAt(i3);
            childAt.setMinimumWidth(getTabMinWidth());
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) childAt.getLayoutParams();
            if (this.f10804z == 1 && this.f10801w == 0) {
                layoutParams.width = 0;
                layoutParams.weight = 1.0f;
            } else {
                layoutParams.width = -2;
                layoutParams.weight = 0.0f;
            }
            if (z5) {
                childAt.requestLayout();
            }
            i3++;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        rb.d(this);
        if (this.J == null) {
            ViewParent parent = getParent();
            if (parent instanceof ViewPager) {
                m((ViewPager) parent, true);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        if (this.O) {
            setupWithViewPager(null);
            this.O = false;
        }
    }

    @Override // android.view.View
    public final void onDraw(Canvas canvas) {
        TabView tabView;
        Drawable drawable;
        int i3 = 0;
        while (true) {
            g gVar = this.f10783c;
            if (i3 >= gVar.getChildCount()) {
                super.onDraw(canvas);
                return;
            }
            View childAt = gVar.getChildAt(i3);
            if ((childAt instanceof TabView) && (drawable = (tabView = (TabView) childAt).f10813i) != null) {
                drawable.setBounds(tabView.getLeft(), tabView.getTop(), tabView.getRight(), tabView.getBottom());
                tabView.f10813i.draw(canvas);
            }
            i3++;
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) f0.p(1, getTabCount(), 1).f7859b);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        int round = Math.round(gb.b(getContext(), getDefaultHeight()));
        int mode = View.MeasureSpec.getMode(i10);
        if (mode != Integer.MIN_VALUE) {
            if (mode == 0) {
                i10 = View.MeasureSpec.makeMeasureSpec(getPaddingBottom() + getPaddingTop() + round, 1073741824);
            }
        } else if (getChildCount() == 1 && View.MeasureSpec.getSize(i10) >= round) {
            getChildAt(0).setMinimumHeight(round);
        }
        int size = View.MeasureSpec.getSize(i3);
        if (View.MeasureSpec.getMode(i3) != 0) {
            int i11 = this.f10798t;
            if (i11 <= 0) {
                i11 = (int) (size - gb.b(getContext(), 56));
            }
            this.r = i11;
        }
        super.onMeasure(i3, i10);
        if (getChildCount() == 1) {
            View childAt = getChildAt(0);
            int i12 = this.f10804z;
            if (i12 != 0) {
                if (i12 == 1) {
                    if (childAt.getMeasuredWidth() == getMeasuredWidth()) {
                        return;
                    }
                    childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i10, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
                }
                if (i12 != 2) {
                    return;
                }
            }
            if (childAt.getMeasuredWidth() >= getMeasuredWidth()) {
                return;
            }
            childAt.measure(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 1073741824), ViewGroup.getChildMeasureSpec(i10, getPaddingBottom() + getPaddingTop(), childAt.getLayoutParams().height));
        }
    }

    public void removeOnTabSelectedListener(hb.d dVar) {
        removeOnTabSelectedListener((hb.c) dVar);
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        rb.b(this, f2);
    }

    public void setInlineLabel(boolean z5) {
        if (this.A == z5) {
            return;
        }
        this.A = z5;
        int i3 = 0;
        while (true) {
            g gVar = this.f10783c;
            if (i3 >= gVar.getChildCount()) {
                d();
                return;
            }
            View childAt = gVar.getChildAt(i3);
            if (childAt instanceof TabView) {
                TabView tabView = (TabView) childAt;
                tabView.setOrientation(!TabLayout.this.A ? 1 : 0);
                TextView textView = tabView.f10811g;
                if (textView == null && tabView.f10812h == null) {
                    tabView.f(tabView.f10807b, tabView.f10808c);
                } else {
                    tabView.f(textView, tabView.f10812h);
                }
            }
            i3++;
        }
    }

    public void setInlineLabelResource(int i3) {
        setInlineLabel(getResources().getBoolean(i3));
    }

    @Deprecated
    public void setOnTabSelectedListener(hb.d dVar) {
        setOnTabSelectedListener((hb.c) dVar);
    }

    public void setScrollAnimatorListener(Animator.AnimatorListener animatorListener) {
        f();
        this.I.addListener(animatorListener);
    }

    public void setSelectedTabIndicator(Drawable drawable) {
        if (this.f10791l != drawable) {
            if (drawable == null) {
                drawable = new GradientDrawable();
            }
            this.f10791l = drawable;
        }
    }

    public void setSelectedTabIndicatorColor(int i3) {
        this.f10792m = i3;
    }

    public void setSelectedTabIndicatorGravity(int i3) {
        if (this.f10803y != i3) {
            this.f10803y = i3;
            WeakHashMap weakHashMap = z0.f15748a;
            h0.k(this.f10783c);
        }
    }

    @Deprecated
    public void setSelectedTabIndicatorHeight(int i3) {
        g gVar = this.f10783c;
        TabLayout tabLayout = gVar.f14302d;
        Rect bounds = tabLayout.f10791l.getBounds();
        tabLayout.f10791l.setBounds(bounds.left, 0, bounds.right, i3);
        gVar.requestLayout();
    }

    public void setTabGravity(int i3) {
        if (this.f10801w != i3) {
            this.f10801w = i3;
            d();
        }
    }

    public void setTabIconTint(ColorStateList colorStateList) {
        if (this.f10789j != colorStateList) {
            this.f10789j = colorStateList;
            ArrayList arrayList = this.f10781a;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                TabView tabView = ((b) arrayList.get(i3)).f10821g;
                if (tabView != null) {
                    tabView.d();
                }
            }
        }
    }

    public void setTabIconTintResource(int i3) {
        setTabIconTint(pb.a(getContext(), i3));
    }

    public void setTabIndicatorAnimationMode(int i3) {
        this.C = i3;
        if (i3 == 0) {
            this.E = new a();
        } else {
            if (i3 == 1) {
                this.E = new hb.a();
                return;
            }
            throw new IllegalArgumentException(i3 + " is not a valid TabIndicatorAnimationMode");
        }
    }

    public void setTabIndicatorFullWidth(boolean z5) {
        this.B = z5;
        WeakHashMap weakHashMap = z0.f15748a;
        h0.k(this.f10783c);
    }

    public void setTabMode(int i3) {
        if (i3 != this.f10804z) {
            this.f10804z = i3;
            d();
        }
    }

    public void setTabRippleColor(ColorStateList colorStateList) {
        if (this.f10790k == colorStateList) {
            return;
        }
        this.f10790k = colorStateList;
        int i3 = 0;
        while (true) {
            g gVar = this.f10783c;
            if (i3 >= gVar.getChildCount()) {
                return;
            }
            View childAt = gVar.getChildAt(i3);
            if (childAt instanceof TabView) {
                Context context = getContext();
                int i10 = TabView.f10805l;
                ((TabView) childAt).e(context);
            }
            i3++;
        }
    }

    public void setTabRippleColorResource(int i3) {
        setTabRippleColor(pb.a(getContext(), i3));
    }

    public void setTabTextColors(ColorStateList colorStateList) {
        if (this.f10788i != colorStateList) {
            this.f10788i = colorStateList;
            ArrayList arrayList = this.f10781a;
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                TabView tabView = ((b) arrayList.get(i3)).f10821g;
                if (tabView != null) {
                    tabView.d();
                }
            }
        }
    }

    @Deprecated
    public void setTabsFromPagerAdapter(n2.a aVar) {
        k(aVar, false);
    }

    public void setUnboundedRipple(boolean z5) {
        if (this.D == z5) {
            return;
        }
        this.D = z5;
        int i3 = 0;
        while (true) {
            g gVar = this.f10783c;
            if (i3 >= gVar.getChildCount()) {
                return;
            }
            View childAt = gVar.getChildAt(i3);
            if (childAt instanceof TabView) {
                Context context = getContext();
                int i10 = TabView.f10805l;
                ((TabView) childAt).e(context);
            }
            i3++;
        }
    }

    public void setUnboundedRippleResource(int i3) {
        setUnboundedRipple(getResources().getBoolean(i3));
    }

    public void setupWithViewPager(ViewPager viewPager) {
        m(viewPager, false);
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup
    public final boolean shouldDelayChildPressedState() {
        return getTabScrollRange() > 0;
    }

    public TabLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.tabStyle);
    }

    @Deprecated
    public void addOnTabSelectedListener(hb.c cVar) {
        ArrayList arrayList = this.G;
        if (arrayList.contains(cVar)) {
            return;
        }
        arrayList.add(cVar);
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i3) {
        b(view);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return generateDefaultLayoutParams();
    }

    @Deprecated
    public void removeOnTabSelectedListener(hb.c cVar) {
        this.G.remove(cVar);
    }

    @Deprecated
    public void setOnTabSelectedListener(hb.c cVar) {
        hb.c cVar2 = this.F;
        if (cVar2 != null) {
            removeOnTabSelectedListener(cVar2);
        }
        this.F = cVar;
        if (cVar != null) {
            addOnTabSelectedListener(cVar);
        }
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public TabLayout(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            Method dump skipped, instructions count: 474
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.tabs.TabLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup, android.view.ViewManager
    public final void addView(View view, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }

    public void setSelectedTabIndicator(int i3) {
        if (i3 != 0) {
            setSelectedTabIndicator(pb.b(getContext(), i3));
        } else {
            setSelectedTabIndicator((Drawable) null);
        }
    }

    @Override // android.widget.HorizontalScrollView, android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        b(view);
    }
}
