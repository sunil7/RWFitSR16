package w0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public final class u {

    /* renamed from: a, reason: collision with root package name */
    public final float f19459a;

    /* renamed from: b, reason: collision with root package name */
    public final float f19460b;

    /* renamed from: c, reason: collision with root package name */
    public final float f19461c;

    /* renamed from: d, reason: collision with root package name */
    public final float f19462d;
    public final int e;

    public u(Context context, XmlResourceParser xmlResourceParser) {
        this.f19459a = Float.NaN;
        this.f19460b = Float.NaN;
        this.f19461c = Float.NaN;
        this.f19462d = Float.NaN;
        this.e = -1;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.Variant);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.Variant_constraints) {
                int resourceId = obtainStyledAttributes.getResourceId(index, this.e);
                this.e = resourceId;
                String resourceTypeName = context.getResources().getResourceTypeName(resourceId);
                context.getResources().getResourceName(resourceId);
                "layout".equals(resourceTypeName);
            } else if (index == R$styleable.Variant_region_heightLessThan) {
                this.f19462d = obtainStyledAttributes.getDimension(index, this.f19462d);
            } else if (index == R$styleable.Variant_region_heightMoreThan) {
                this.f19460b = obtainStyledAttributes.getDimension(index, this.f19460b);
            } else if (index == R$styleable.Variant_region_widthLessThan) {
                this.f19461c = obtainStyledAttributes.getDimension(index, this.f19461c);
            } else if (index == R$styleable.Variant_region_widthMoreThan) {
                this.f19459a = obtainStyledAttributes.getDimension(index, this.f19459a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final boolean a(float f2, float f10) {
        float f11 = this.f19459a;
        if (!Float.isNaN(f11) && f2 < f11) {
            return false;
        }
        float f12 = this.f19460b;
        if (!Float.isNaN(f12) && f10 < f12) {
            return false;
        }
        float f13 = this.f19461c;
        if (!Float.isNaN(f13) && f2 > f13) {
            return false;
        }
        float f14 = this.f19462d;
        return Float.isNaN(f14) || f10 <= f14;
    }
}
