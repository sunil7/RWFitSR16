package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.CheckedTextView;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.R$attr;
import androidx.appcompat.widget.y1;
import androidx.appcompat.widget.y3;
import com.google.android.material.R$dimen;
import com.google.android.material.R$drawable;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import java.util.WeakHashMap;
import l1.h0;
import l1.z0;

/* loaded from: classes.dex */
public class NavigationMenuItemView extends ForegroundLinearLayout implements h.y {
    public static final int[] F = {R.attr.state_checked};
    public h.m A;
    public ColorStateList B;
    public boolean C;
    public Drawable D;
    public final com.google.android.material.button.f E;

    /* renamed from: v, reason: collision with root package name */
    public int f10544v;

    /* renamed from: w, reason: collision with root package name */
    public boolean f10545w;

    /* renamed from: x, reason: collision with root package name */
    public boolean f10546x;

    /* renamed from: y, reason: collision with root package name */
    public final CheckedTextView f10547y;

    /* renamed from: z, reason: collision with root package name */
    public FrameLayout f10548z;

    public NavigationMenuItemView(Context context) {
        this(context, null);
    }

    private void setActionView(View view) {
        if (view != null) {
            if (this.f10548z == null) {
                this.f10548z = (FrameLayout) ((ViewStub) findViewById(R$id.design_menu_item_action_area_stub)).inflate();
            }
            this.f10548z.removeAllViews();
            this.f10548z.addView(view);
        }
    }

    @Override // h.y
    public final void d(h.m mVar) {
        StateListDrawable stateListDrawable;
        this.A = mVar;
        int i3 = mVar.f14169a;
        if (i3 > 0) {
            setId(i3);
        }
        setVisibility(mVar.isVisible() ? 0 : 8);
        if (getBackground() == null) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R$attr.colorControlHighlight, typedValue, true)) {
                stateListDrawable = new StateListDrawable();
                stateListDrawable.addState(F, new ColorDrawable(typedValue.data));
                stateListDrawable.addState(ViewGroup.EMPTY_STATE_SET, new ColorDrawable(0));
            } else {
                stateListDrawable = null;
            }
            WeakHashMap weakHashMap = z0.f15748a;
            h0.q(this, stateListDrawable);
        }
        setCheckable(mVar.isCheckable());
        setChecked(mVar.isChecked());
        setEnabled(mVar.isEnabled());
        setTitle(mVar.e);
        setIcon(mVar.getIcon());
        setActionView(mVar.getActionView());
        setContentDescription(mVar.f14184q);
        y3.a(this, mVar.r);
        h.m mVar2 = this.A;
        CharSequence charSequence = mVar2.e;
        CheckedTextView checkedTextView = this.f10547y;
        if (charSequence == null && mVar2.getIcon() == null && this.A.getActionView() != null) {
            checkedTextView.setVisibility(8);
            FrameLayout frameLayout = this.f10548z;
            if (frameLayout != null) {
                y1 y1Var = (y1) frameLayout.getLayoutParams();
                ((LinearLayout.LayoutParams) y1Var).width = -1;
                this.f10548z.setLayoutParams(y1Var);
                return;
            }
            return;
        }
        checkedTextView.setVisibility(0);
        FrameLayout frameLayout2 = this.f10548z;
        if (frameLayout2 != null) {
            y1 y1Var2 = (y1) frameLayout2.getLayoutParams();
            ((LinearLayout.LayoutParams) y1Var2).width = -2;
            this.f10548z.setLayoutParams(y1Var2);
        }
    }

    @Override // h.y
    public h.m getItemData() {
        return this.A;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final int[] onCreateDrawableState(int i3) {
        int[] onCreateDrawableState = super.onCreateDrawableState(i3 + 1);
        h.m mVar = this.A;
        if (mVar != null && mVar.isCheckable() && this.A.isChecked()) {
            View.mergeDrawableStates(onCreateDrawableState, F);
        }
        return onCreateDrawableState;
    }

    public void setCheckable(boolean z5) {
        refreshDrawableState();
        if (this.f10546x != z5) {
            this.f10546x = z5;
            this.E.h(this.f10547y, 2048);
        }
    }

    public void setChecked(boolean z5) {
        refreshDrawableState();
        this.f10547y.setChecked(z5);
    }

    public void setHorizontalPadding(int i3) {
        setPadding(i3, 0, i3, 0);
    }

    public void setIcon(Drawable drawable) {
        if (drawable != null) {
            if (this.C) {
                Drawable.ConstantState constantState = drawable.getConstantState();
                if (constantState != null) {
                    drawable = constantState.newDrawable();
                }
                drawable = drawable.mutate();
                d1.b.h(drawable, this.B);
            }
            int i3 = this.f10544v;
            drawable.setBounds(0, 0, i3, i3);
        } else if (this.f10545w) {
            if (this.D == null) {
                Resources resources = getResources();
                int i10 = R$drawable.navigation_empty_icon;
                Resources.Theme theme = getContext().getTheme();
                ThreadLocal threadLocal = b1.o.f3076a;
                Drawable a3 = b1.i.a(resources, i10, theme);
                this.D = a3;
                if (a3 != null) {
                    int i11 = this.f10544v;
                    a3.setBounds(0, 0, i11, i11);
                }
            }
            drawable = this.D;
        }
        androidx.core.widget.q.e(this.f10547y, drawable, null, null, null);
    }

    public void setIconPadding(int i3) {
        this.f10547y.setCompoundDrawablePadding(i3);
    }

    public void setIconSize(int i3) {
        this.f10544v = i3;
    }

    public void setIconTintList(ColorStateList colorStateList) {
        this.B = colorStateList;
        this.C = colorStateList != null;
        h.m mVar = this.A;
        if (mVar != null) {
            setIcon(mVar.getIcon());
        }
    }

    public void setMaxLines(int i3) {
        this.f10547y.setMaxLines(i3);
    }

    public void setNeedsEmptyIcon(boolean z5) {
        this.f10545w = z5;
    }

    public void setTextAppearance(int i3) {
        this.f10547y.setTextAppearance(i3);
    }

    public void setTextColor(ColorStateList colorStateList) {
        this.f10547y.setTextColor(colorStateList);
    }

    public void setTitle(CharSequence charSequence) {
        this.f10547y.setText(charSequence);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public NavigationMenuItemView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        com.google.android.material.button.f fVar = new com.google.android.material.button.f(this, 3);
        this.E = fVar;
        setOrientation(0);
        LayoutInflater.from(context).inflate(R$layout.design_navigation_menu_item, (ViewGroup) this, true);
        setIconSize(context.getResources().getDimensionPixelSize(R$dimen.design_navigation_icon_size));
        CheckedTextView checkedTextView = (CheckedTextView) findViewById(R$id.design_menu_item_text);
        this.f10547y = checkedTextView;
        checkedTextView.setDuplicateParentStateEnabled(true);
        z0.n(checkedTextView, fVar);
    }
}
