package com.google.android.material.chip;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import com.example.test.ui.device.activity.f0;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.internal.FlowLayout;
import java.util.ArrayList;
import java.util.List;
import qa.d;
import qa.e;
import qa.f;
import qa.g;

/* loaded from: classes.dex */
public class ChipGroup extends FlowLayout {

    /* renamed from: m, reason: collision with root package name */
    public static final int f10379m = R$style.Widget_MaterialComponents_ChipGroup;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f10380f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f10381g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10382h;

    /* renamed from: i, reason: collision with root package name */
    public final d f10383i;

    /* renamed from: j, reason: collision with root package name */
    public final g f10384j;

    /* renamed from: k, reason: collision with root package name */
    public int f10385k;

    /* renamed from: l, reason: collision with root package name */
    public boolean f10386l;

    public ChipGroup(Context context) {
        this(context, null);
    }

    private int getChipCount() {
        int i3 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if (getChildAt(i10) instanceof Chip) {
                i3++;
            }
        }
        return i3;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setCheckedId(int i3) {
        this.f10385k = i3;
    }

    @Override // com.google.android.material.internal.FlowLayout
    public final boolean a() {
        return this.f10537c;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof Chip) {
            Chip chip = (Chip) view;
            if (chip.isChecked()) {
                int i10 = this.f10385k;
                if (i10 != -1 && this.f10381g) {
                    d(i10, false);
                }
                setCheckedId(chip.getId());
            }
        }
        super.addView(view, i3, layoutParams);
    }

    public final void c(int i3) {
        int i10 = this.f10385k;
        if (i3 == i10) {
            return;
        }
        if (i10 != -1 && this.f10381g) {
            d(i10, false);
        }
        if (i3 != -1) {
            d(i3, true);
        }
        setCheckedId(i3);
    }

    @Override // android.view.ViewGroup
    public final boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return super.checkLayoutParams(layoutParams) && (layoutParams instanceof e);
    }

    public final void d(int i3, boolean z5) {
        View findViewById = findViewById(i3);
        if (findViewById instanceof Chip) {
            this.f10386l = true;
            ((Chip) findViewById).setChecked(z5);
            this.f10386l = false;
        }
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new e(-2, -2);
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new e(getContext(), attributeSet);
    }

    public int getCheckedChipId() {
        if (this.f10381g) {
            return this.f10385k;
        }
        return -1;
    }

    public List<Integer> getCheckedChipIds() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            View childAt = getChildAt(i3);
            if ((childAt instanceof Chip) && ((Chip) childAt).isChecked()) {
                arrayList.add(Integer.valueOf(childAt.getId()));
                if (this.f10381g) {
                    break;
                }
            }
        }
        return arrayList;
    }

    public int getChipSpacingHorizontal() {
        return this.e;
    }

    public int getChipSpacingVertical() {
        return this.f10380f;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        super.onFinishInflate();
        int i3 = this.f10385k;
        if (i3 != -1) {
            d(i3, true);
            setCheckedId(this.f10385k);
        }
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) f0.p(getRowCount(), this.f10537c ? getChipCount() : -1, this.f10381g ? 1 : 2).f7859b);
    }

    public void setChipSpacing(int i3) {
        setChipSpacingHorizontal(i3);
        setChipSpacingVertical(i3);
    }

    public void setChipSpacingHorizontal(int i3) {
        if (this.e != i3) {
            this.e = i3;
            setItemSpacing(i3);
            requestLayout();
        }
    }

    public void setChipSpacingHorizontalResource(int i3) {
        setChipSpacingHorizontal(getResources().getDimensionPixelOffset(i3));
    }

    public void setChipSpacingResource(int i3) {
        setChipSpacing(getResources().getDimensionPixelOffset(i3));
    }

    public void setChipSpacingVertical(int i3) {
        if (this.f10380f != i3) {
            this.f10380f = i3;
            setLineSpacing(i3);
            requestLayout();
        }
    }

    public void setChipSpacingVerticalResource(int i3) {
        setChipSpacingVertical(getResources().getDimensionPixelOffset(i3));
    }

    @Deprecated
    public void setDividerDrawableHorizontal(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setDividerDrawableVertical(Drawable drawable) {
        throw new UnsupportedOperationException("Changing divider drawables have no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setFlexWrap(int i3) {
        throw new UnsupportedOperationException("Changing flex wrap not allowed. ChipGroup exposes a singleLine attribute instead.");
    }

    public void setOnCheckedChangeListener(f fVar) {
    }

    @Override // android.view.ViewGroup
    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        this.f10384j.f17890a = onHierarchyChangeListener;
    }

    public void setSelectionRequired(boolean z5) {
        this.f10382h = z5;
    }

    @Deprecated
    public void setShowDividerHorizontal(int i3) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Deprecated
    public void setShowDividerVertical(int i3) {
        throw new UnsupportedOperationException("Changing divider modes has no effect. ChipGroup do not use divider drawables as spacing.");
    }

    @Override // com.google.android.material.internal.FlowLayout
    public void setSingleLine(boolean z5) {
        super.setSingleLine(z5);
    }

    public void setSingleSelection(boolean z5) {
        if (this.f10381g != z5) {
            this.f10381g = z5;
            this.f10386l = true;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                View childAt = getChildAt(i3);
                if (childAt instanceof Chip) {
                    ((Chip) childAt).setChecked(false);
                }
            }
            this.f10386l = false;
            setCheckedId(-1);
        }
    }

    public ChipGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.chipGroupStyle);
    }

    public void setSingleLine(int i3) {
        setSingleLine(getResources().getBoolean(i3));
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public ChipGroup(android.content.Context r9, android.util.AttributeSet r10, int r11) {
        /*
            r8 = this;
            int r4 = com.google.android.material.chip.ChipGroup.f10379m
            android.content.Context r9 = ib.a.a(r9, r10, r11, r4)
            r8.<init>(r9, r10, r11)
            qa.d r9 = new qa.d
            r9.<init>(r8)
            r8.f10383i = r9
            qa.g r9 = new qa.g
            r9.<init>(r8)
            r8.f10384j = r9
            r6 = -1
            r8.f10385k = r6
            r7 = 0
            r8.f10386l = r7
            android.content.Context r0 = r8.getContext()
            int[] r2 = com.google.android.material.R$styleable.ChipGroup
            int[] r5 = new int[r7]
            r1 = r10
            r3 = r11
            android.content.res.TypedArray r10 = com.google.android.material.internal.w.d(r0, r1, r2, r3, r4, r5)
            int r11 = com.google.android.material.R$styleable.ChipGroup_chipSpacing
            int r11 = r10.getDimensionPixelOffset(r11, r7)
            int r0 = com.google.android.material.R$styleable.ChipGroup_chipSpacingHorizontal
            int r0 = r10.getDimensionPixelOffset(r0, r11)
            r8.setChipSpacingHorizontal(r0)
            int r0 = com.google.android.material.R$styleable.ChipGroup_chipSpacingVertical
            int r11 = r10.getDimensionPixelOffset(r0, r11)
            r8.setChipSpacingVertical(r11)
            int r11 = com.google.android.material.R$styleable.ChipGroup_singleLine
            boolean r11 = r10.getBoolean(r11, r7)
            r8.setSingleLine(r11)
            int r11 = com.google.android.material.R$styleable.ChipGroup_singleSelection
            boolean r11 = r10.getBoolean(r11, r7)
            r8.setSingleSelection(r11)
            int r11 = com.google.android.material.R$styleable.ChipGroup_selectionRequired
            boolean r11 = r10.getBoolean(r11, r7)
            r8.setSelectionRequired(r11)
            int r11 = com.google.android.material.R$styleable.ChipGroup_checkedChip
            int r11 = r10.getResourceId(r11, r6)
            if (r11 == r6) goto L68
            r8.f10385k = r11
        L68:
            r10.recycle()
            super.setOnHierarchyChangeListener(r9)
            java.util.WeakHashMap r9 = l1.z0.f15748a
            r9 = 1
            l1.h0.s(r8, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.chip.ChipGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    @Override // android.view.ViewGroup
    public final ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new e(layoutParams);
    }

    public void setSingleSelection(int i3) {
        setSingleSelection(getResources().getBoolean(i3));
    }
}
