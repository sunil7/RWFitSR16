package com.google.android.material.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityManager;
import android.widget.Filterable;
import android.widget.ListAdapter;
import androidx.appcompat.widget.AppCompatAutoCompleteTextView;
import androidx.appcompat.widget.ListPopupWindow;
import androidx.appcompat.widget.m0;
import com.google.android.material.R$attr;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.w;
import java.util.Locale;

/* loaded from: classes.dex */
public class MaterialAutoCompleteTextView extends AppCompatAutoCompleteTextView {
    public final ListPopupWindow e;

    /* renamed from: f, reason: collision with root package name */
    public final AccessibilityManager f10824f;

    /* renamed from: g, reason: collision with root package name */
    public final Rect f10825g;

    public MaterialAutoCompleteTextView(Context context) {
        this(context, null);
    }

    public static void a(MaterialAutoCompleteTextView materialAutoCompleteTextView, Object obj) {
        materialAutoCompleteTextView.setText(materialAutoCompleteTextView.convertSelectionToString(obj), false);
    }

    public final TextInputLayout b() {
        for (ViewParent parent = getParent(); parent != null; parent = parent.getParent()) {
            if (parent instanceof TextInputLayout) {
                return (TextInputLayout) parent;
            }
        }
        return null;
    }

    @Override // android.widget.TextView
    public CharSequence getHint() {
        TextInputLayout b3 = b();
        return (b3 == null || !b3.C) ? super.getHint() : b3.getHint();
    }

    @Override // android.widget.AutoCompleteTextView, android.widget.TextView, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        TextInputLayout b3 = b();
        if (b3 != null && b3.C && super.getHint() == null && Build.MANUFACTURER.toLowerCase(Locale.ENGLISH).equals("meizu")) {
            setHint("");
        }
    }

    @Override // android.widget.TextView, android.view.View
    public final void onMeasure(int i3, int i10) {
        super.onMeasure(i3, i10);
        if (View.MeasureSpec.getMode(i3) == Integer.MIN_VALUE) {
            int measuredWidth = getMeasuredWidth();
            ListAdapter adapter = getAdapter();
            TextInputLayout b3 = b();
            int i11 = 0;
            if (adapter != null && b3 != null) {
                int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), 0);
                int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), 0);
                ListPopupWindow listPopupWindow = this.e;
                int min = Math.min(adapter.getCount(), Math.max(0, !listPopupWindow.f779z.isShowing() ? -1 : listPopupWindow.f758c.getSelectedItemPosition()) + 15);
                View view = null;
                int i12 = 0;
                for (int max = Math.max(0, min - 15); max < min; max++) {
                    int itemViewType = adapter.getItemViewType(max);
                    if (itemViewType != i11) {
                        view = null;
                        i11 = itemViewType;
                    }
                    view = adapter.getView(max, view, b3);
                    if (view.getLayoutParams() == null) {
                        view.setLayoutParams(new ViewGroup.LayoutParams(-2, -2));
                    }
                    view.measure(makeMeasureSpec, makeMeasureSpec2);
                    i12 = Math.max(i12, view.getMeasuredWidth());
                }
                Drawable background = listPopupWindow.f779z.getBackground();
                if (background != null) {
                    Rect rect = this.f10825g;
                    background.getPadding(rect);
                    i12 += rect.left + rect.right;
                }
                i11 = b3.getEndIconView().getMeasuredWidth() + i12;
            }
            setMeasuredDimension(Math.min(Math.max(measuredWidth, i11), View.MeasureSpec.getSize(i3)), getMeasuredHeight());
        }
    }

    @Override // android.widget.AutoCompleteTextView
    public <T extends ListAdapter & Filterable> void setAdapter(T t8) {
        super.setAdapter(t8);
        this.e.p(getAdapter());
    }

    @Override // android.widget.AutoCompleteTextView
    public final void showDropDown() {
        AccessibilityManager accessibilityManager = this.f10824f;
        if (accessibilityManager == null || !accessibilityManager.isTouchExplorationEnabled()) {
            super.showDropDown();
        } else {
            this.e.d();
        }
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.autoCompleteTextViewStyle);
    }

    public MaterialAutoCompleteTextView(Context context, AttributeSet attributeSet, int i3) {
        super(ib.a.a(context, attributeSet, i3, 0), attributeSet, i3);
        this.f10825g = new Rect();
        Context context2 = getContext();
        TypedArray d5 = w.d(context2, attributeSet, R$styleable.MaterialAutoCompleteTextView, i3, R$style.Widget_AppCompat_AutoCompleteTextView, new int[0]);
        if (d5.hasValue(R$styleable.MaterialAutoCompleteTextView_android_inputType) && d5.getInt(R$styleable.MaterialAutoCompleteTextView_android_inputType, 0) == 0) {
            setKeyListener(null);
        }
        this.f10824f = (AccessibilityManager) context2.getSystemService("accessibility");
        ListPopupWindow listPopupWindow = new ListPopupWindow(context2);
        this.e = listPopupWindow;
        listPopupWindow.f778y = true;
        listPopupWindow.f779z.setFocusable(true);
        listPopupWindow.f769o = this;
        listPopupWindow.f779z.setInputMethodMode(2);
        listPopupWindow.p(getAdapter());
        listPopupWindow.setOnItemClickListener(new m0(this, 2));
        d5.recycle();
    }
}
