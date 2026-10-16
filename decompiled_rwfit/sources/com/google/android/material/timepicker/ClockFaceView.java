package com.google.android.material.timepicker;

import android.R;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RadialGradient;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.TextView;
import com.example.test.ui.device.activity.f0;
import com.google.android.gms.internal.mlkit_vision_barcode.pb;
import com.google.android.gms.internal.mlkit_vision_barcode.t0;
import com.google.android.material.R$attr;
import com.google.android.material.R$color;
import com.google.android.material.R$dimen;
import com.google.android.material.R$id;
import com.google.android.material.R$layout;
import com.google.android.material.R$style;
import com.google.android.material.R$styleable;
import java.util.Arrays;
import l1.z0;

/* loaded from: classes.dex */
class ClockFaceView extends RadialViewGroup implements e {
    public final int[] A;
    public final float[] B;
    public final int C;
    public final int D;
    public final int E;
    public final int F;
    public final String[] G;
    public float H;
    public final ColorStateList I;

    /* renamed from: v, reason: collision with root package name */
    public final ClockHandView f10954v;

    /* renamed from: w, reason: collision with root package name */
    public final Rect f10955w;

    /* renamed from: x, reason: collision with root package name */
    public final RectF f10956x;

    /* renamed from: y, reason: collision with root package name */
    public final SparseArray f10957y;

    /* renamed from: z, reason: collision with root package name */
    public final c f10958z;

    public ClockFaceView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R$attr.materialClockStyle);
    }

    @Override // android.view.View
    public final void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setCollectionInfo((AccessibilityNodeInfo.CollectionInfo) f0.p(1, this.G.length, 1).f7859b);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        q();
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int max = (int) (this.F / Math.max(Math.max(this.D / displayMetrics.heightPixels, this.E / displayMetrics.widthPixels), 1.0f));
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(max, 1073741824);
        setMeasuredDimension(max, max);
        super.onMeasure(makeMeasureSpec, makeMeasureSpec);
    }

    public final void q() {
        RadialGradient radialGradient;
        RectF rectF = this.f10954v.e;
        int i3 = 0;
        while (true) {
            SparseArray sparseArray = this.f10957y;
            if (i3 >= sparseArray.size()) {
                return;
            }
            TextView textView = (TextView) sparseArray.get(i3);
            if (textView != null) {
                Rect rect = this.f10955w;
                textView.getDrawingRect(rect);
                rect.offset(textView.getPaddingLeft(), textView.getPaddingTop());
                offsetDescendantRectToMyCoords(textView, rect);
                RectF rectF2 = this.f10956x;
                rectF2.set(rect);
                if (RectF.intersects(rectF, rectF2)) {
                    radialGradient = new RadialGradient(rectF.centerX() - rectF2.left, rectF.centerY() - rectF2.top, 0.5f * rectF.width(), this.A, this.B, Shader.TileMode.CLAMP);
                } else {
                    radialGradient = null;
                }
                textView.getPaint().setShader(radialGradient);
                textView.invalidate();
            }
            i3++;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public ClockFaceView(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f10955w = new Rect();
        this.f10956x = new RectF();
        SparseArray sparseArray = new SparseArray();
        this.f10957y = sparseArray;
        this.B = new float[]{0.0f, 0.9f, 1.0f};
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ClockFaceView, i3, R$style.Widget_MaterialComponents_TimePicker_Clock);
        Resources resources = getResources();
        ColorStateList a3 = t0.a(context, obtainStyledAttributes, R$styleable.ClockFaceView_clockNumberTextColor);
        this.I = a3;
        LayoutInflater.from(context).inflate(R$layout.material_clockface_view, (ViewGroup) this, true);
        ClockHandView clockHandView = (ClockHandView) findViewById(R$id.material_clock_hand);
        this.f10954v = clockHandView;
        this.C = resources.getDimensionPixelSize(R$dimen.material_clock_hand_padding);
        int colorForState = a3.getColorForState(new int[]{R.attr.state_selected}, a3.getDefaultColor());
        this.A = new int[]{colorForState, colorForState, a3.getDefaultColor()};
        clockHandView.addOnRotateListener(this);
        int defaultColor = pb.a(context, R$color.material_timepicker_clockface).getDefaultColor();
        ColorStateList a10 = t0.a(context, obtainStyledAttributes, R$styleable.ClockFaceView_clockFaceBackgroundColor);
        setBackgroundColor(a10 != null ? a10.getDefaultColor() : defaultColor);
        getViewTreeObserver().addOnPreDrawListener(new b(this));
        setFocusable(true);
        obtainStyledAttributes.recycle();
        this.f10958z = new c(this);
        String[] strArr = new String[12];
        Arrays.fill(strArr, "");
        this.G = strArr;
        LayoutInflater from = LayoutInflater.from(getContext());
        int size = sparseArray.size();
        for (int i10 = 0; i10 < Math.max(this.G.length, size); i10++) {
            TextView textView = (TextView) sparseArray.get(i10);
            if (i10 >= this.G.length) {
                removeView(textView);
                sparseArray.remove(i10);
            } else {
                if (textView == null) {
                    textView = (TextView) from.inflate(R$layout.material_clockface_textview, (ViewGroup) this, false);
                    sparseArray.put(i10, textView);
                    addView(textView);
                }
                textView.setVisibility(0);
                textView.setText(this.G[i10]);
                textView.setTag(R$id.material_value_index, Integer.valueOf(i10));
                z0.n(textView, this.f10958z);
                textView.setTextColor(this.I);
            }
        }
        this.D = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_height);
        this.E = resources.getDimensionPixelSize(R$dimen.material_time_picker_minimum_screen_width);
        this.F = resources.getDimensionPixelSize(R$dimen.material_clock_size);
    }
}
