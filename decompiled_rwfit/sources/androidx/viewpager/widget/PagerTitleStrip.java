package androidx.viewpager.widget;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.TextView;
import java.lang.ref.WeakReference;
import n2.c;
import n2.d;
import n2.f;
import n2.j;

@f
/* loaded from: classes.dex */
public class PagerTitleStrip extends ViewGroup {

    /* renamed from: o, reason: collision with root package name */
    public static final int[] f2903o = {R.attr.textAppearance, R.attr.textSize, R.attr.textColor, R.attr.gravity};

    /* renamed from: p, reason: collision with root package name */
    public static final int[] f2904p = {R.attr.textAllCaps};

    /* renamed from: a, reason: collision with root package name */
    public ViewPager f2905a;

    /* renamed from: b, reason: collision with root package name */
    public final TextView f2906b;

    /* renamed from: c, reason: collision with root package name */
    public final TextView f2907c;

    /* renamed from: d, reason: collision with root package name */
    public final TextView f2908d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public float f2909f;

    /* renamed from: g, reason: collision with root package name */
    public int f2910g;

    /* renamed from: h, reason: collision with root package name */
    public int f2911h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f2912i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f2913j;

    /* renamed from: k, reason: collision with root package name */
    public final c f2914k;

    /* renamed from: l, reason: collision with root package name */
    public WeakReference f2915l;

    /* renamed from: m, reason: collision with root package name */
    public int f2916m;

    /* renamed from: n, reason: collision with root package name */
    public int f2917n;

    public PagerTitleStrip(Context context) {
        this(context, null);
    }

    private static void setSingleLineAllCaps(TextView textView) {
        Context context = textView.getContext();
        d dVar = new d();
        dVar.f16366a = context.getResources().getConfiguration().locale;
        textView.setTransformationMethod(dVar);
    }

    public final void a(n2.a aVar, n2.a aVar2) {
        c cVar = this.f2914k;
        if (aVar != null) {
            aVar.f16360a.unregisterObserver(cVar);
            this.f2915l = null;
        }
        if (aVar2 != null) {
            aVar2.f16360a.registerObserver(cVar);
            this.f2915l = new WeakReference(aVar2);
        }
        ViewPager viewPager = this.f2905a;
        if (viewPager != null) {
            this.e = -1;
            this.f2909f = -1.0f;
            b(viewPager.getCurrentItem(), aVar2);
            requestLayout();
        }
    }

    public final void b(int i3, n2.a aVar) {
        int c9 = aVar != null ? aVar.c() : 0;
        this.f2912i = true;
        CharSequence charSequence = null;
        CharSequence e = (i3 < 1 || aVar == null) ? null : aVar.e(i3 - 1);
        TextView textView = this.f2906b;
        textView.setText(e);
        TextView textView2 = this.f2907c;
        textView2.setText((aVar == null || i3 >= c9) ? null : aVar.e(i3));
        int i10 = i3 + 1;
        if (i10 < c9 && aVar != null) {
            charSequence = aVar.e(i10);
        }
        TextView textView3 = this.f2908d;
        textView3.setText(charSequence);
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(Math.max(0, (int) (((getWidth() - getPaddingLeft()) - getPaddingRight()) * 0.8f)), Integer.MIN_VALUE);
        int makeMeasureSpec2 = View.MeasureSpec.makeMeasureSpec(Math.max(0, (getHeight() - getPaddingTop()) - getPaddingBottom()), Integer.MIN_VALUE);
        textView.measure(makeMeasureSpec, makeMeasureSpec2);
        textView2.measure(makeMeasureSpec, makeMeasureSpec2);
        textView3.measure(makeMeasureSpec, makeMeasureSpec2);
        this.e = i3;
        if (!this.f2913j) {
            c(i3, false, this.f2909f);
        }
        this.f2912i = false;
    }

    public void c(int i3, boolean z5, float f2) {
        int i10;
        int i11;
        int i12;
        int i13;
        if (i3 != this.e) {
            b(i3, this.f2905a.getAdapter());
        } else if (!z5 && f2 == this.f2909f) {
            return;
        }
        this.f2913j = true;
        TextView textView = this.f2906b;
        int measuredWidth = textView.getMeasuredWidth();
        TextView textView2 = this.f2907c;
        int measuredWidth2 = textView2.getMeasuredWidth();
        TextView textView3 = this.f2908d;
        int measuredWidth3 = textView3.getMeasuredWidth();
        int i14 = measuredWidth2 / 2;
        int width = getWidth();
        int height = getHeight();
        int paddingLeft = getPaddingLeft();
        int paddingRight = getPaddingRight();
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i15 = paddingRight + i14;
        int i16 = (width - (paddingLeft + i14)) - i15;
        float f10 = f2 + 0.5f;
        if (f10 > 1.0f) {
            f10 -= 1.0f;
        }
        int i17 = ((width - i15) - ((int) (i16 * f10))) - i14;
        int i18 = measuredWidth2 + i17;
        int baseline = textView.getBaseline();
        int baseline2 = textView2.getBaseline();
        int baseline3 = textView3.getBaseline();
        int max = Math.max(Math.max(baseline, baseline2), baseline3);
        int i19 = max - baseline;
        int i20 = max - baseline2;
        int i21 = max - baseline3;
        int max2 = Math.max(Math.max(textView.getMeasuredHeight() + i19, textView2.getMeasuredHeight() + i20), textView3.getMeasuredHeight() + i21);
        int i22 = this.f2911h & 112;
        if (i22 == 16) {
            i10 = (((height - paddingTop) - paddingBottom) - max2) / 2;
        } else {
            if (i22 != 80) {
                i11 = i19 + paddingTop;
                i12 = paddingTop + i20;
                i13 = paddingTop + i21;
                textView2.layout(i17, i12, i18, textView2.getMeasuredHeight() + i12);
                int min = Math.min(paddingLeft, (i17 - this.f2910g) - measuredWidth);
                textView.layout(min, i11, min + measuredWidth, textView.getMeasuredHeight() + i11);
                int max3 = Math.max((width - paddingRight) - measuredWidth3, i18 + this.f2910g);
                textView3.layout(max3, i13, max3 + measuredWidth3, textView3.getMeasuredHeight() + i13);
                this.f2909f = f2;
                this.f2913j = false;
            }
            i10 = (height - paddingBottom) - max2;
        }
        i11 = i19 + i10;
        i12 = i10 + i20;
        i13 = i10 + i21;
        textView2.layout(i17, i12, i18, textView2.getMeasuredHeight() + i12);
        int min2 = Math.min(paddingLeft, (i17 - this.f2910g) - measuredWidth);
        textView.layout(min2, i11, min2 + measuredWidth, textView.getMeasuredHeight() + i11);
        int max32 = Math.max((width - paddingRight) - measuredWidth3, i18 + this.f2910g);
        textView3.layout(max32, i13, max32 + measuredWidth3, textView3.getMeasuredHeight() + i13);
        this.f2909f = f2;
        this.f2913j = false;
    }

    public int getMinHeight() {
        Drawable background = getBackground();
        if (background != null) {
            return background.getIntrinsicHeight();
        }
        return 0;
    }

    public int getTextSpacing() {
        return this.f2910g;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewParent parent = getParent();
        if (!(parent instanceof ViewPager)) {
            throw new IllegalStateException("PagerTitleStrip must be a direct child of a ViewPager.");
        }
        ViewPager viewPager = (ViewPager) parent;
        n2.a adapter = viewPager.getAdapter();
        c cVar = this.f2914k;
        viewPager.S = cVar;
        viewPager.addOnAdapterChangeListener(cVar);
        this.f2905a = viewPager;
        WeakReference weakReference = this.f2915l;
        a(weakReference != null ? (n2.a) weakReference.get() : null, adapter);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ViewPager viewPager = this.f2905a;
        if (viewPager != null) {
            a(viewPager.getAdapter(), null);
            ViewPager viewPager2 = this.f2905a;
            j jVar = viewPager2.S;
            viewPager2.S = null;
            viewPager2.removeOnAdapterChangeListener(this.f2914k);
            this.f2905a = null;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        if (this.f2905a != null) {
            float f2 = this.f2909f;
            if (f2 < 0.0f) {
                f2 = 0.0f;
            }
            c(this.e, true, f2);
        }
    }

    @Override // android.view.View
    public final void onMeasure(int i3, int i10) {
        int max;
        if (View.MeasureSpec.getMode(i3) != 1073741824) {
            throw new IllegalStateException("Must measure with an exact width");
        }
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        int childMeasureSpec = ViewGroup.getChildMeasureSpec(i10, paddingBottom, -2);
        int size = View.MeasureSpec.getSize(i3);
        int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i3, (int) (size * 0.2f), -2);
        this.f2906b.measure(childMeasureSpec2, childMeasureSpec);
        TextView textView = this.f2907c;
        textView.measure(childMeasureSpec2, childMeasureSpec);
        this.f2908d.measure(childMeasureSpec2, childMeasureSpec);
        if (View.MeasureSpec.getMode(i10) == 1073741824) {
            max = View.MeasureSpec.getSize(i10);
        } else {
            max = Math.max(getMinHeight(), textView.getMeasuredHeight() + paddingBottom);
        }
        setMeasuredDimension(size, View.resolveSizeAndState(max, i10, textView.getMeasuredState() << 16));
    }

    @Override // android.view.View, android.view.ViewParent
    public final void requestLayout() {
        if (this.f2912i) {
            return;
        }
        super.requestLayout();
    }

    public void setGravity(int i3) {
        this.f2911h = i3;
        requestLayout();
    }

    public void setNonPrimaryAlpha(float f2) {
        int i3 = ((int) (f2 * 255.0f)) & 255;
        this.f2916m = i3;
        int i10 = (i3 << 24) | (this.f2917n & 16777215);
        this.f2906b.setTextColor(i10);
        this.f2908d.setTextColor(i10);
    }

    public void setTextColor(int i3) {
        this.f2917n = i3;
        this.f2907c.setTextColor(i3);
        int i10 = (this.f2916m << 24) | (this.f2917n & 16777215);
        this.f2906b.setTextColor(i10);
        this.f2908d.setTextColor(i10);
    }

    public void setTextSpacing(int i3) {
        this.f2910g = i3;
        requestLayout();
    }

    public PagerTitleStrip(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.e = -1;
        this.f2909f = -1.0f;
        this.f2914k = new c(this);
        TextView textView = new TextView(context);
        this.f2906b = textView;
        addView(textView);
        TextView textView2 = new TextView(context);
        this.f2907c = textView2;
        addView(textView2);
        TextView textView3 = new TextView(context);
        this.f2908d = textView3;
        addView(textView3);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f2903o);
        boolean z5 = false;
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        if (resourceId != 0) {
            textView.setTextAppearance(resourceId);
            textView2.setTextAppearance(resourceId);
            textView3.setTextAppearance(resourceId);
        }
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(1, 0);
        if (dimensionPixelSize != 0) {
            float f2 = dimensionPixelSize;
            textView.setTextSize(0, f2);
            textView2.setTextSize(0, f2);
            textView3.setTextSize(0, f2);
        }
        if (obtainStyledAttributes.hasValue(2)) {
            int color = obtainStyledAttributes.getColor(2, 0);
            textView.setTextColor(color);
            textView2.setTextColor(color);
            textView3.setTextColor(color);
        }
        this.f2911h = obtainStyledAttributes.getInteger(3, 80);
        obtainStyledAttributes.recycle();
        this.f2917n = textView2.getTextColors().getDefaultColor();
        setNonPrimaryAlpha(0.6f);
        TextUtils.TruncateAt truncateAt = TextUtils.TruncateAt.END;
        textView.setEllipsize(truncateAt);
        textView2.setEllipsize(truncateAt);
        textView3.setEllipsize(truncateAt);
        if (resourceId != 0) {
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(resourceId, f2904p);
            z5 = obtainStyledAttributes2.getBoolean(0, false);
            obtainStyledAttributes2.recycle();
        }
        if (z5) {
            setSingleLineAllCaps(textView);
            setSingleLineAllCaps(textView2);
            setSingleLineAllCaps(textView3);
        } else {
            textView.setSingleLine();
            textView2.setSingleLine();
            textView3.setSingleLine();
        }
        this.f2910g = (int) (context.getResources().getDisplayMetrics().density * 16.0f);
    }
}
