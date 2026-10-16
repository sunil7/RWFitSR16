package ab;

import android.R;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.google.android.gms.internal.mlkit_vision_barcode.s0;
import com.google.android.gms.internal.mlkit_vision_barcode.t0;
import com.google.android.gms.internal.mlkit_vision_common.x;
import com.google.android.material.R$attr;
import com.google.android.material.R$dimen;
import com.google.android.material.R$styleable;
import com.google.android.material.internal.w;

/* loaded from: classes.dex */
public abstract class d {

    /* renamed from: a, reason: collision with root package name */
    public int f151a;

    /* renamed from: b, reason: collision with root package name */
    public int f152b;

    /* renamed from: c, reason: collision with root package name */
    public int[] f153c;

    /* renamed from: d, reason: collision with root package name */
    public int f154d;
    public int e;

    /* renamed from: f, reason: collision with root package name */
    public int f155f;

    public d(Context context, AttributeSet attributeSet, int i3, int i10) {
        this.f153c = new int[0];
        int dimensionPixelSize = context.getResources().getDimensionPixelSize(R$dimen.mtrl_progress_track_thickness);
        int[] iArr = R$styleable.BaseProgressIndicator;
        w.a(context, attributeSet, i3, i10);
        w.b(context, attributeSet, iArr, i3, i10, new int[0]);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr, i3, i10);
        this.f151a = t0.c(context, obtainStyledAttributes, R$styleable.BaseProgressIndicator_trackThickness, dimensionPixelSize);
        this.f152b = Math.min(t0.c(context, obtainStyledAttributes, R$styleable.BaseProgressIndicator_trackCornerRadius, 0), this.f151a / 2);
        this.e = obtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_showAnimationBehavior, 0);
        this.f155f = obtainStyledAttributes.getInt(R$styleable.BaseProgressIndicator_hideAnimationBehavior, 0);
        if (!obtainStyledAttributes.hasValue(R$styleable.BaseProgressIndicator_indicatorColor)) {
            TypedValue a3 = s0.a(context, R$attr.colorPrimary);
            this.f153c = new int[]{a3 != null ? a3.data : -1};
        } else if (obtainStyledAttributes.peekValue(R$styleable.BaseProgressIndicator_indicatorColor).type != 1) {
            this.f153c = new int[]{obtainStyledAttributes.getColor(R$styleable.BaseProgressIndicator_indicatorColor, -1)};
        } else {
            int[] intArray = context.getResources().getIntArray(obtainStyledAttributes.getResourceId(R$styleable.BaseProgressIndicator_indicatorColor, -1));
            this.f153c = intArray;
            if (intArray.length == 0) {
                throw new IllegalArgumentException("indicatorColors cannot be empty when indicatorColor is not used.");
            }
        }
        if (obtainStyledAttributes.hasValue(R$styleable.BaseProgressIndicator_trackColor)) {
            this.f154d = obtainStyledAttributes.getColor(R$styleable.BaseProgressIndicator_trackColor, -1);
        } else {
            this.f154d = this.f153c[0];
            TypedArray obtainStyledAttributes2 = context.getTheme().obtainStyledAttributes(new int[]{R.attr.disabledAlpha});
            float f2 = obtainStyledAttributes2.getFloat(0, 0.2f);
            obtainStyledAttributes2.recycle();
            this.f154d = x.a(this.f154d, (int) (f2 * 255.0f));
        }
        obtainStyledAttributes.recycle();
    }

    public abstract void a();
}
