package com.google.android.material.button;

import android.content.Context;
import android.graphics.Canvas;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.LinearLayout;
import com.example.test.ui.device.activity.f0;
import com.google.android.gms.internal.mlkit_vision_barcode.gb;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.timepicker.j;
import eb.l;
import eb.m;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.WeakHashMap;
import l1.i0;
import l1.p;
import l1.z0;

/* loaded from: classes.dex */
public class MaterialButtonToggleGroup extends LinearLayout {

    /* renamed from: k, reason: collision with root package name */
    public static final int f10315k = R$style.Widget_MaterialComponents_MaterialButtonToggleGroup;

    /* renamed from: a, reason: collision with root package name */
    public final ArrayList f10316a;

    /* renamed from: b, reason: collision with root package name */
    public final g f10317b;

    /* renamed from: c, reason: collision with root package name */
    public final f0 f10318c;

    /* renamed from: d, reason: collision with root package name */
    public final LinkedHashSet f10319d;
    public final e e;

    /* renamed from: f, reason: collision with root package name */
    public Integer[] f10320f;

    /* renamed from: g, reason: collision with root package name */
    public boolean f10321g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f10322h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f10323i;

    /* renamed from: j, reason: collision with root package name */
    public int f10324j;

    public MaterialButtonToggleGroup(Context context) {
        this(context, null);
    }

    private int getFirstVisibleChildIndex() {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            if (c(i3)) {
                return i3;
            }
        }
        return -1;
    }

    private int getLastVisibleChildIndex() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            if (c(childCount)) {
                return childCount;
            }
        }
        return -1;
    }

    private int getVisibleButtonCount() {
        int i3 = 0;
        for (int i10 = 0; i10 < getChildCount(); i10++) {
            if ((getChildAt(i10) instanceof MaterialButton) && c(i10)) {
                i3++;
            }
        }
        return i3;
    }

    private void setCheckedId(int i3) {
        this.f10324j = i3;
        b(i3, true);
    }

    private void setGeneratedIdIfNeeded(MaterialButton materialButton) {
        if (materialButton.getId() == -1) {
            WeakHashMap weakHashMap = z0.f15748a;
            materialButton.setId(i0.a());
        }
    }

    private void setupButtonChild(MaterialButton materialButton) {
        materialButton.setMaxLines(1);
        materialButton.setEllipsize(TextUtils.TruncateAt.END);
        materialButton.setCheckable(true);
        materialButton.addOnCheckedChangeListener(this.f10317b);
        materialButton.setOnPressedChangeListenerInternal(this.f10318c);
        materialButton.setShouldDrawSurfaceColorStroke(true);
    }

    public final void a() {
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        if (firstVisibleChildIndex == -1) {
            return;
        }
        for (int i3 = firstVisibleChildIndex + 1; i3 < getChildCount(); i3++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i3);
            int min = Math.min(materialButton.getStrokeWidth(), ((MaterialButton) getChildAt(i3 - 1)).getStrokeWidth());
            ViewGroup.LayoutParams layoutParams = materialButton.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = layoutParams instanceof LinearLayout.LayoutParams ? (LinearLayout.LayoutParams) layoutParams : new LinearLayout.LayoutParams(layoutParams.width, layoutParams.height);
            if (getOrientation() == 0) {
                p.g(layoutParams2, 0);
                p.h(layoutParams2, -min);
                layoutParams2.topMargin = 0;
            } else {
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = -min;
                p.h(layoutParams2, 0);
            }
            materialButton.setLayoutParams(layoutParams2);
        }
        if (getChildCount() == 0 || firstVisibleChildIndex == -1) {
            return;
        }
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) ((MaterialButton) getChildAt(firstVisibleChildIndex)).getLayoutParams();
        if (getOrientation() == 1) {
            layoutParams3.topMargin = 0;
            layoutParams3.bottomMargin = 0;
        } else {
            p.g(layoutParams3, 0);
            p.h(layoutParams3, 0);
            layoutParams3.leftMargin = 0;
            layoutParams3.rightMargin = 0;
        }
    }

    public void addOnButtonCheckedListener(i iVar) {
        this.f10319d.add(iVar);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!(view instanceof MaterialButton)) {
            Log.e("MaterialButtonToggleGroup", "Child views must be of type MaterialButton.");
            return;
        }
        super.addView(view, i3, layoutParams);
        MaterialButton materialButton = (MaterialButton) view;
        setGeneratedIdIfNeeded(materialButton);
        setupButtonChild(materialButton);
        if (materialButton.f10311n) {
            d(materialButton.getId(), true);
            setCheckedId(materialButton.getId());
        }
        m shapeAppearanceModel = materialButton.getShapeAppearanceModel();
        this.f10316a.add(new h(shapeAppearanceModel.e, shapeAppearanceModel.f12546h, shapeAppearanceModel.f12544f, shapeAppearanceModel.f12545g));
        z0.n(materialButton, new f(this, 0));
    }

    public final void b(int i3, boolean z5) {
        Iterator it = this.f10319d.iterator();
        while (it.hasNext()) {
            ((j) ((i) it.next())).a();
        }
    }

    public final boolean c(int i3) {
        return getChildAt(i3).getVisibility() != 8;
    }

    public final boolean d(int i3, boolean z5) {
        List<Integer> checkedButtonIds = getCheckedButtonIds();
        if (this.f10323i && checkedButtonIds.isEmpty()) {
            View findViewById = findViewById(i3);
            if (findViewById instanceof MaterialButton) {
                this.f10321g = true;
                ((MaterialButton) findViewById).setChecked(true);
                this.f10321g = false;
            }
            this.f10324j = i3;
            return false;
        }
        if (z5 && this.f10322h) {
            checkedButtonIds.remove(Integer.valueOf(i3));
            Iterator<Integer> it = checkedButtonIds.iterator();
            while (it.hasNext()) {
                int intValue = it.next().intValue();
                View findViewById2 = findViewById(intValue);
                if (findViewById2 instanceof MaterialButton) {
                    this.f10321g = true;
                    ((MaterialButton) findViewById2).setChecked(false);
                    this.f10321g = false;
                }
                b(intValue, false);
            }
        }
        return true;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void dispatchDraw(Canvas canvas) {
        TreeMap treeMap = new TreeMap(this.e);
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            treeMap.put((MaterialButton) getChildAt(i3), Integer.valueOf(i3));
        }
        this.f10320f = (Integer[]) treeMap.values().toArray(new Integer[0]);
        super.dispatchDraw(canvas);
    }

    public final void e() {
        h hVar;
        int childCount = getChildCount();
        int firstVisibleChildIndex = getFirstVisibleChildIndex();
        int lastVisibleChildIndex = getLastVisibleChildIndex();
        for (int i3 = 0; i3 < childCount; i3++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i3);
            if (materialButton.getVisibility() != 8) {
                l f2 = materialButton.getShapeAppearanceModel().f();
                h hVar2 = (h) this.f10316a.get(i3);
                if (firstVisibleChildIndex != lastVisibleChildIndex) {
                    boolean z5 = getOrientation() == 0;
                    eb.a aVar = h.e;
                    if (i3 == firstVisibleChildIndex) {
                        hVar = z5 ? gb.d(this) ? new h(aVar, aVar, hVar2.f10347b, hVar2.f10348c) : new h(hVar2.f10346a, hVar2.f10349d, aVar, aVar) : new h(hVar2.f10346a, aVar, hVar2.f10347b, aVar);
                    } else if (i3 == lastVisibleChildIndex) {
                        hVar = z5 ? gb.d(this) ? new h(hVar2.f10346a, hVar2.f10349d, aVar, aVar) : new h(aVar, aVar, hVar2.f10347b, hVar2.f10348c) : new h(aVar, hVar2.f10349d, aVar, hVar2.f10348c);
                    } else {
                        hVar2 = null;
                    }
                    hVar2 = hVar;
                }
                if (hVar2 == null) {
                    f2.c(0.0f);
                } else {
                    f2.e = hVar2.f10346a;
                    f2.f12534h = hVar2.f10349d;
                    f2.f12532f = hVar2.f10347b;
                    f2.f12533g = hVar2.f10348c;
                }
                materialButton.setShapeAppearanceModel(f2.a());
            }
        }
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public CharSequence getAccessibilityClassName() {
        return MaterialButtonToggleGroup.class.getName();
    }

    public int getCheckedButtonId() {
        if (this.f10322h) {
            return this.f10324j;
        }
        return -1;
    }

    public List<Integer> getCheckedButtonIds() {
        ArrayList arrayList = new ArrayList();
        for (int i3 = 0; i3 < getChildCount(); i3++) {
            MaterialButton materialButton = (MaterialButton) getChildAt(i3);
            if (materialButton.f10311n) {
                arrayList.add(Integer.valueOf(materialButton.getId()));
            }
        }
        return arrayList;
    }

    @Override // android.view.ViewGroup
    public final int getChildDrawingOrder(int i3, int i10) {
        Integer[] numArr = this.f10320f;
        if (numArr != null && i10 < numArr.length) {
            return numArr[i10].intValue();
        }
        Log.w("MaterialButtonToggleGroup", "Child order wasn't updated");
        return i10;
    }

    @Override // android.view.View
    public final void onFinishInflate() {
        MaterialButton materialButton;
        super.onFinishInflate();
        int i3 = this.f10324j;
        if (i3 == -1 || (materialButton = (MaterialButton) findViewById(i3)) == null) {
            return;
        }
        materialButton.setChecked(true);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) f0.p(1, getVisibleButtonCount(), this.f10322h ? 1 : 2).f7859b);
    }

    @Override // android.widget.LinearLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        e();
        a();
        super.onMeasure(i3, i10);
    }

    @Override // android.view.ViewGroup
    public final void onViewRemoved(View view) {
        super.onViewRemoved(view);
        if (view instanceof MaterialButton) {
            MaterialButton materialButton = (MaterialButton) view;
            materialButton.removeOnCheckedChangeListener(this.f10317b);
            materialButton.setOnPressedChangeListenerInternal(null);
        }
        int indexOfChild = indexOfChild(view);
        if (indexOfChild >= 0) {
            this.f10316a.remove(indexOfChild);
        }
        e();
        a();
    }

    public void removeOnButtonCheckedListener(i iVar) {
        this.f10319d.remove(iVar);
    }

    public void setSelectionRequired(boolean z5) {
        this.f10323i = z5;
    }

    public void setSingleSelection(boolean z5) {
        if (this.f10322h != z5) {
            this.f10322h = z5;
            this.f10321g = true;
            for (int i3 = 0; i3 < getChildCount(); i3++) {
                MaterialButton materialButton = (MaterialButton) getChildAt(i3);
                materialButton.setChecked(false);
                b(materialButton.getId(), false);
            }
            this.f10321g = false;
            setCheckedId(-1);
        }
    }

    public MaterialButtonToggleGroup(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialButtonToggleGroupStyle);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public MaterialButtonToggleGroup(android.content.Context r8, android.util.AttributeSet r9, int r10) {
        /*
            r7 = this;
            int r4 = com.google.android.material.button.MaterialButtonToggleGroup.f10315k
            android.content.Context r8 = ib.a.a(r8, r9, r10, r4)
            r7.<init>(r8, r9, r10)
            java.util.ArrayList r8 = new java.util.ArrayList
            r8.<init>()
            r7.f10316a = r8
            com.google.android.material.button.g r8 = new com.google.android.material.button.g
            r8.<init>(r7)
            r7.f10317b = r8
            com.example.test.ui.device.activity.f0 r8 = new com.example.test.ui.device.activity.f0
            r0 = 7
            r8.<init>(r7, r0)
            r7.f10318c = r8
            java.util.LinkedHashSet r8 = new java.util.LinkedHashSet
            r8.<init>()
            r7.f10319d = r8
            com.google.android.material.button.e r8 = new com.google.android.material.button.e
            r6 = 0
            r8.<init>(r7, r6)
            r7.e = r8
            r7.f10321g = r6
            android.content.Context r0 = r7.getContext()
            int[] r2 = com.google.android.material.R$styleable.MaterialButtonToggleGroup
            int[] r5 = new int[r6]
            r1 = r9
            r3 = r10
            android.content.res.TypedArray r8 = com.google.android.material.internal.w.d(r0, r1, r2, r3, r4, r5)
            int r9 = com.google.android.material.R$styleable.MaterialButtonToggleGroup_singleSelection
            boolean r9 = r8.getBoolean(r9, r6)
            r7.setSingleSelection(r9)
            int r9 = com.google.android.material.R$styleable.MaterialButtonToggleGroup_checkedButton
            r10 = -1
            int r9 = r8.getResourceId(r9, r10)
            r7.f10324j = r9
            int r9 = com.google.android.material.R$styleable.MaterialButtonToggleGroup_selectionRequired
            boolean r9 = r8.getBoolean(r9, r6)
            r7.f10323i = r9
            r9 = 1
            r7.setChildrenDrawingOrderEnabled(r9)
            r8.recycle()
            java.util.WeakHashMap r8 = l1.z0.f15748a
            l1.h0.s(r7, r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.button.MaterialButtonToggleGroup.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    public void setSingleSelection(int i3) {
        setSingleSelection(getResources().getBoolean(i3));
    }
}
