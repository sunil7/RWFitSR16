package w0;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.Log;
import android.util.Xml;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public final class h {

    /* renamed from: a, reason: collision with root package name */
    public final float f19344a;

    /* renamed from: b, reason: collision with root package name */
    public final float f19345b;

    /* renamed from: c, reason: collision with root package name */
    public final float f19346c;

    /* renamed from: d, reason: collision with root package name */
    public final float f19347d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final o f19348f;

    public h(Context context, XmlResourceParser xmlResourceParser) {
        this.f19344a = Float.NaN;
        this.f19345b = Float.NaN;
        this.f19346c = Float.NaN;
        this.f19347d = Float.NaN;
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
                if ("layout".equals(resourceTypeName)) {
                    o oVar = new o();
                    this.f19348f = oVar;
                    oVar.e((ConstraintLayout) LayoutInflater.from(context).inflate(resourceId, (ViewGroup) null));
                }
            } else if (index == R$styleable.Variant_region_heightLessThan) {
                this.f19347d = obtainStyledAttributes.getDimension(index, this.f19347d);
            } else if (index == R$styleable.Variant_region_heightMoreThan) {
                this.f19345b = obtainStyledAttributes.getDimension(index, this.f19345b);
            } else if (index == R$styleable.Variant_region_widthLessThan) {
                this.f19346c = obtainStyledAttributes.getDimension(index, this.f19346c);
            } else if (index == R$styleable.Variant_region_widthMoreThan) {
                this.f19344a = obtainStyledAttributes.getDimension(index, this.f19344a);
            } else {
                Log.v("ConstraintLayoutStates", "Unknown tag");
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final boolean a(float f2, float f10) {
        float f11 = this.f19344a;
        if (!Float.isNaN(f11) && f2 < f11) {
            return false;
        }
        float f12 = this.f19345b;
        if (!Float.isNaN(f12) && f10 < f12) {
            return false;
        }
        float f13 = this.f19346c;
        if (!Float.isNaN(f13) && f2 > f13) {
            return false;
        }
        float f14 = this.f19347d;
        return Float.isNaN(f14) || f10 <= f14;
    }
}
