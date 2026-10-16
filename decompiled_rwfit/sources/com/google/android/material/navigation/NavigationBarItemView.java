package com.google.android.material.navigation;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.PointerIcon;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.v2;
import androidx.appcompat.widget.y3;
import com.example.test.ui.device.activity.i0;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$string;
import h.m;
import h.y;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import l1.a0;
import l1.h0;
import l1.p0;
import l1.z0;

/* loaded from: classes.dex */
public abstract class NavigationBarItemView extends FrameLayout implements y {

    /* renamed from: q, reason: collision with root package name */
    public static final int[] f10645q = {R.attr.state_checked};

    /* renamed from: a, reason: collision with root package name */
    public final int f10646a;

    /* renamed from: b, reason: collision with root package name */
    public float f10647b;

    /* renamed from: c, reason: collision with root package name */
    public float f10648c;

    /* renamed from: d, reason: collision with root package name */
    public float f10649d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public boolean f10650f;

    /* renamed from: g, reason: collision with root package name */
    public final ImageView f10651g;

    /* renamed from: h, reason: collision with root package name */
    public final ViewGroup f10652h;

    /* renamed from: i, reason: collision with root package name */
    public final TextView f10653i;

    /* renamed from: j, reason: collision with root package name */
    public final TextView f10654j;

    /* renamed from: k, reason: collision with root package name */
    public int f10655k;

    /* renamed from: l, reason: collision with root package name */
    public m f10656l;

    /* renamed from: m, reason: collision with root package name */
    public ColorStateList f10657m;

    /* renamed from: n, reason: collision with root package name */
    public Drawable f10658n;

    /* renamed from: o, reason: collision with root package name */
    public Drawable f10659o;

    /* renamed from: p, reason: collision with root package name */
    public la.a f10660p;

    public NavigationBarItemView(Context context) {
        super(context);
        this.f10655k = -1;
        LayoutInflater.from(context).inflate(getItemLayoutResId(), (ViewGroup) this, true);
        ImageView imageView = (ImageView) findViewById(R$id.navigation_bar_item_icon_view);
        this.f10651g = imageView;
        ViewGroup viewGroup = (ViewGroup) findViewById(R$id.navigation_bar_item_labels_group);
        this.f10652h = viewGroup;
        TextView textView = (TextView) findViewById(R$id.navigation_bar_item_small_label_view);
        this.f10653i = textView;
        TextView textView2 = (TextView) findViewById(R$id.navigation_bar_item_large_label_view);
        this.f10654j = textView2;
        setBackgroundResource(getItemBackgroundResId());
        this.f10646a = getResources().getDimensionPixelSize(getItemDefaultMarginResId());
        viewGroup.setTag(R$id.mtrl_view_tag_bottom_padding, Integer.valueOf(viewGroup.getPaddingBottom()));
        WeakHashMap weakHashMap = z0.f15748a;
        h0.s(textView, 2);
        h0.s(textView2, 2);
        setFocusable(true);
        a(textView.getTextSize(), textView2.getTextSize());
        if (imageView != null) {
            imageView.addOnLayoutChangeListener(new v2(this, 1));
        }
    }

    public static void b(View view, int i3, int i10) {
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) view.getLayoutParams();
        layoutParams.topMargin = i3;
        layoutParams.gravity = i10;
        view.setLayoutParams(layoutParams);
    }

    public static void c(View view, float f2, float f10, int i3) {
        view.setScaleX(f2);
        view.setScaleY(f10);
        view.setVisibility(i3);
    }

    public static void e(int i3, View view) {
        view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), i3);
    }

    private int getItemVisiblePosition() {
        ViewGroup viewGroup = (ViewGroup) getParent();
        int indexOfChild = viewGroup.indexOfChild(this);
        int i3 = 0;
        for (int i10 = 0; i10 < indexOfChild; i10++) {
            View childAt = viewGroup.getChildAt(i10);
            if ((childAt instanceof NavigationBarItemView) && childAt.getVisibility() == 0) {
                i3++;
            }
        }
        return i3;
    }

    private int getSuggestedIconHeight() {
        la.a aVar = this.f10660p;
        int minimumHeight = aVar != null ? aVar.getMinimumHeight() / 2 : 0;
        ImageView imageView = this.f10651g;
        return imageView.getMeasuredWidth() + Math.max(minimumHeight, ((FrameLayout.LayoutParams) imageView.getLayoutParams()).topMargin) + minimumHeight;
    }

    private int getSuggestedIconWidth() {
        int i3;
        int i10;
        la.a aVar = this.f10660p;
        if (aVar == null) {
            i10 = 0;
        } else {
            int minimumWidth = aVar.getMinimumWidth();
            i3 = this.f10660p.f15844h.horizontalOffset;
            i10 = minimumWidth - i3;
        }
        ImageView imageView = this.f10651g;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        return Math.max(i10, layoutParams.rightMargin) + imageView.getMeasuredWidth() + Math.max(i10, layoutParams.leftMargin);
    }

    public final void a(float f2, float f10) {
        this.f10647b = f2 - f10;
        this.f10648c = (f10 * 1.0f) / f2;
        this.f10649d = (f2 * 1.0f) / f10;
    }

    @Override // h.y
    public final void d(m mVar) {
        this.f10656l = mVar;
        setCheckable(mVar.isCheckable());
        setChecked(mVar.isChecked());
        setEnabled(mVar.isEnabled());
        setIcon(mVar.getIcon());
        setTitle(mVar.e);
        setId(mVar.f14169a);
        if (!TextUtils.isEmpty(mVar.f14184q)) {
            setContentDescription(mVar.f14184q);
        }
        y3.a(this, !TextUtils.isEmpty(mVar.r) ? mVar.r : mVar.e);
        setVisibility(mVar.isVisible() ? 0 : 8);
    }

    public la.a getBadge() {
        return this.f10660p;
    }

    public int getItemBackgroundResId() {
        return R$drawable.mtrl_navigation_bar_item_background;
    }

    @Override // h.y
    public m getItemData() {
        return this.f10656l;
    }

    public int getItemDefaultMarginResId() {
        return R$dimen.mtrl_navigation_bar_item_default_margin;
    }

    public abstract int getItemLayoutResId();

    public int getItemPosition() {
        return this.f10655k;
    }

    @Override // android.view.View
    public int getSuggestedMinimumHeight() {
        ViewGroup viewGroup = this.f10652h;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return viewGroup.getMeasuredHeight() + getSuggestedIconHeight() + layoutParams.topMargin + layoutParams.bottomMargin;
    }

    @Override // android.view.View
    public int getSuggestedMinimumWidth() {
        ViewGroup viewGroup = this.f10652h;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) viewGroup.getLayoutParams();
        return Math.max(getSuggestedIconWidth(), viewGroup.getMeasuredWidth() + layoutParams.leftMargin + layoutParams.rightMargin);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        m mVar = this.f10656l;
        if (mVar != null && mVar.isCheckable() && this.f10656l.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, f10645q);
        }
        return onCreateDrawableState;
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        la.a aVar = this.f10660p;
        if (aVar != null && aVar.isVisible()) {
            m mVar = this.f10656l;
            CharSequence charSequence = mVar.e;
            if (!TextUtils.isEmpty(mVar.f14184q)) {
                charSequence = this.f10656l.f14184q;
            }
            accessibilityNodeInfo.setContentDescription(((Object) charSequence) + ", " + ((Object) this.f10660p.c()));
        }
        accessibilityNodeInfo.setCollectionItemInfo((AccessibilityNodeInfo.CollectionItemInfo) i0.o(0, 1, getItemVisiblePosition(), 1, isSelected()).f7866b);
        if (isSelected()) {
            accessibilityNodeInfo.setClickable(false);
            accessibilityNodeInfo.removeAction((AccessibilityNodeInfo.AccessibilityAction) m1.c.f15925g.f15934a);
        }
        accessibilityNodeInfo.getExtras().putCharSequence("AccessibilityNodeInfo.roleDescription", getResources().getString(R$string.item_view_role_description));
    }

    public void setBadge(la.a aVar) {
        this.f10660p = aVar;
        ImageView imageView = this.f10651g;
        if (imageView == null || aVar == null) {
            return;
        }
        setClipChildren(false);
        setClipToPadding(false);
        la.a aVar2 = this.f10660p;
        Rect rect = new Rect();
        imageView.getDrawingRect(rect);
        aVar2.setBounds(rect);
        aVar2.h(imageView, null);
        WeakReference weakReference = aVar2.f15852p;
        if ((weakReference != null ? (FrameLayout) weakReference.get() : null) == null) {
            imageView.getOverlay().add(aVar2);
        } else {
            WeakReference weakReference2 = aVar2.f15852p;
            (weakReference2 != null ? (FrameLayout) weakReference2.get() : null).setForeground(aVar2);
        }
    }

    public void setCheckable(boolean z5) {
        refreshDrawableState();
    }

    public void setChecked(boolean z5) {
        TextView textView = this.f10654j;
        textView.setPivotX(textView.getWidth() / 2);
        textView.setPivotY(textView.getBaseline());
        TextView textView2 = this.f10653i;
        textView2.setPivotX(textView2.getWidth() / 2);
        textView2.setPivotY(textView2.getBaseline());
        int i3 = this.e;
        ViewGroup viewGroup = this.f10652h;
        int i10 = this.f10646a;
        ImageView imageView = this.f10651g;
        if (i3 != -1) {
            if (i3 == 0) {
                if (z5) {
                    b(imageView, i10, 49);
                    e(((Integer) viewGroup.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue(), viewGroup);
                    textView.setVisibility(0);
                } else {
                    b(imageView, i10, 17);
                    e(0, viewGroup);
                    textView.setVisibility(4);
                }
                textView2.setVisibility(4);
            } else if (i3 == 1) {
                e(((Integer) viewGroup.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue(), viewGroup);
                if (z5) {
                    b(imageView, (int) (i10 + this.f10647b), 49);
                    c(textView, 1.0f, 1.0f, 0);
                    float f2 = this.f10648c;
                    c(textView2, f2, f2, 4);
                } else {
                    b(imageView, i10, 49);
                    float f10 = this.f10649d;
                    c(textView, f10, f10, 4);
                    c(textView2, 1.0f, 1.0f, 0);
                }
            } else if (i3 == 2) {
                b(imageView, i10, 17);
                textView.setVisibility(8);
                textView2.setVisibility(8);
            }
        } else if (this.f10650f) {
            if (z5) {
                b(imageView, i10, 49);
                e(((Integer) viewGroup.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue(), viewGroup);
                textView.setVisibility(0);
            } else {
                b(imageView, i10, 17);
                e(0, viewGroup);
                textView.setVisibility(4);
            }
            textView2.setVisibility(4);
        } else {
            e(((Integer) viewGroup.getTag(R$id.mtrl_view_tag_bottom_padding)).intValue(), viewGroup);
            if (z5) {
                b(imageView, (int) (i10 + this.f10647b), 49);
                c(textView, 1.0f, 1.0f, 0);
                float f11 = this.f10648c;
                c(textView2, f11, f11, 4);
            } else {
                b(imageView, i10, 49);
                float f12 = this.f10649d;
                c(textView, f12, f12, 4);
                c(textView2, 1.0f, 1.0f, 0);
            }
        }
        refreshDrawableState();
        setSelected(z5);
    }

    @Override // android.view.View
    public void setEnabled(boolean z5) {
        super.setEnabled(z5);
        this.f10653i.setEnabled(z5);
        this.f10654j.setEnabled(z5);
        this.f10651g.setEnabled(z5);
        if (!z5) {
            WeakHashMap weakHashMap = z0.f15748a;
            p0.d(this, null);
        } else {
            PointerIcon b3 = a0.b(getContext(), 1002);
            WeakHashMap weakHashMap2 = z0.f15748a;
            p0.d(this, b3);
        }
    }

    public void setIcon(Drawable drawable) {
        if (drawable == this.f10658n) {
            return;
        }
        this.f10658n = drawable;
        if (drawable != null) {
            Drawable.ConstantState constantState = drawable.getConstantState();
            if (constantState != null) {
                drawable = constantState.newDrawable();
            }
            drawable = drawable.mutate();
            this.f10659o = drawable;
            ColorStateList colorStateList = this.f10657m;
            if (colorStateList != null) {
                d1.b.h(drawable, colorStateList);
            }
        }
        this.f10651g.setImageDrawable(drawable);
    }

    public void setIconSize(int i3) {
        ImageView imageView = this.f10651g;
        FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) imageView.getLayoutParams();
        layoutParams.width = i3;
        layoutParams.height = i3;
        imageView.setLayoutParams(layoutParams);
    }

    public void setIconTintList(ColorStateList colorStateList) {
        Drawable drawable;
        this.f10657m = colorStateList;
        if (this.f10656l == null || (drawable = this.f10659o) == null) {
            return;
        }
        d1.b.h(drawable, colorStateList);
        this.f10659o.invalidateSelf();
    }

    public void setItemBackground(int i3) {
        setItemBackground(i3 == 0 ? null : a1.c.b(getContext(), i3));
    }

    public void setItemPosition(int i3) {
        this.f10655k = i3;
    }

    public void setLabelVisibilityMode(int i3) {
        if (this.e != i3) {
            this.e = i3;
            m mVar = this.f10656l;
            if (mVar != null) {
                setChecked(mVar.isChecked());
            }
        }
    }

    public void setShifting(boolean z5) {
        if (this.f10650f != z5) {
            this.f10650f = z5;
            m mVar = this.f10656l;
            if (mVar != null) {
                setChecked(mVar.isChecked());
            }
        }
    }

    public void setTextAppearanceActive(int i3) {
        TextView textView = this.f10654j;
        textView.setTextAppearance(i3);
        a(this.f10653i.getTextSize(), textView.getTextSize());
    }

    public void setTextAppearanceInactive(int i3) {
        TextView textView = this.f10653i;
        textView.setTextAppearance(i3);
        a(textView.getTextSize(), this.f10654j.getTextSize());
    }

    public void setTextColor(ColorStateList colorStateList) {
        if (colorStateList != null) {
            this.f10653i.setTextColor(colorStateList);
            this.f10654j.setTextColor(colorStateList);
        }
    }

    public void setTitle(CharSequence charSequence) {
        this.f10653i.setText(charSequence);
        this.f10654j.setText(charSequence);
        m mVar = this.f10656l;
        if (mVar == null || TextUtils.isEmpty(mVar.f14184q)) {
            setContentDescription(charSequence);
        }
        m mVar2 = this.f10656l;
        if (mVar2 != null && !TextUtils.isEmpty(mVar2.r)) {
            charSequence = this.f10656l.r;
        }
        y3.a(this, charSequence);
    }

    public void setItemBackground(Drawable drawable) {
        if (drawable != null && drawable.getConstantState() != null) {
            drawable = drawable.getConstantState().newDrawable().mutate();
        }
        WeakHashMap weakHashMap = z0.f15748a;
        h0.q(this, drawable);
    }
}
