package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintHelper;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import q0.f;
import w0.e;

/* loaded from: classes.dex */
public class Layer extends ConstraintHelper {

    /* renamed from: i, reason: collision with root package name */
    public float f1664i;

    /* renamed from: j, reason: collision with root package name */
    public float f1665j;

    /* renamed from: k, reason: collision with root package name */
    public float f1666k;

    /* renamed from: l, reason: collision with root package name */
    public ConstraintLayout f1667l;

    /* renamed from: m, reason: collision with root package name */
    public float f1668m;

    /* renamed from: n, reason: collision with root package name */
    public float f1669n;

    /* renamed from: o, reason: collision with root package name */
    public float f1670o;

    /* renamed from: p, reason: collision with root package name */
    public float f1671p;

    /* renamed from: q, reason: collision with root package name */
    public float f1672q;
    public float r;

    /* renamed from: s, reason: collision with root package name */
    public float f1673s;

    /* renamed from: t, reason: collision with root package name */
    public float f1674t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f1675u;

    /* renamed from: v, reason: collision with root package name */
    public View[] f1676v;

    /* renamed from: w, reason: collision with root package name */
    public float f1677w;

    /* renamed from: x, reason: collision with root package name */
    public float f1678x;

    /* renamed from: y, reason: collision with root package name */
    public boolean f1679y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f1680z;

    public Layer(Context context) {
        super(context);
        this.f1664i = Float.NaN;
        this.f1665j = Float.NaN;
        this.f1666k = Float.NaN;
        this.f1668m = 1.0f;
        this.f1669n = 1.0f;
        this.f1670o = Float.NaN;
        this.f1671p = Float.NaN;
        this.f1672q = Float.NaN;
        this.r = Float.NaN;
        this.f1673s = Float.NaN;
        this.f1674t = Float.NaN;
        this.f1675u = true;
        this.f1676v = null;
        this.f1677w = 0.0f;
        this.f1678x = 0.0f;
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void g(ConstraintLayout constraintLayout) {
        f(constraintLayout);
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.ConstraintLayout_Layout_android_visibility) {
                    this.f1679y = true;
                } else if (index == R$styleable.ConstraintLayout_Layout_android_elevation) {
                    this.f1680z = true;
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void n() {
        s();
        this.f1670o = Float.NaN;
        this.f1671p = Float.NaN;
        f fVar = ((e) getLayoutParams()).f19323p0;
        fVar.K(0);
        fVar.H(0);
        r();
        layout(((int) this.f1673s) - getPaddingLeft(), ((int) this.f1674t) - getPaddingTop(), getPaddingRight() + ((int) this.f1672q), getPaddingBottom() + ((int) this.r));
        t();
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper
    public final void o(ConstraintLayout constraintLayout) {
        this.f1667l = constraintLayout;
        float rotation = getRotation();
        if (rotation != 0.0f) {
            this.f1666k = rotation;
        } else {
            if (Float.isNaN(this.f1666k)) {
                return;
            }
            this.f1666k = rotation;
        }
    }

    @Override // androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f1667l = (ConstraintLayout) getParent();
        if (this.f1679y || this.f1680z) {
            int visibility = getVisibility();
            float elevation = getElevation();
            for (int i3 = 0; i3 < this.f1850b; i3++) {
                View d5 = this.f1667l.d(this.f1849a[i3]);
                if (d5 != null) {
                    if (this.f1679y) {
                        d5.setVisibility(visibility);
                    }
                    if (this.f1680z && elevation > 0.0f) {
                        d5.setTranslationZ(d5.getTranslationZ() + elevation);
                    }
                }
            }
        }
    }

    public final void r() {
        if (this.f1667l == null) {
            return;
        }
        if (this.f1675u || Float.isNaN(this.f1670o) || Float.isNaN(this.f1671p)) {
            if (!Float.isNaN(this.f1664i) && !Float.isNaN(this.f1665j)) {
                this.f1671p = this.f1665j;
                this.f1670o = this.f1664i;
                return;
            }
            View[] j4 = j(this.f1667l);
            int left = j4[0].getLeft();
            int top = j4[0].getTop();
            int right = j4[0].getRight();
            int bottom = j4[0].getBottom();
            for (int i3 = 0; i3 < this.f1850b; i3++) {
                View view = j4[i3];
                left = Math.min(left, view.getLeft());
                top = Math.min(top, view.getTop());
                right = Math.max(right, view.getRight());
                bottom = Math.max(bottom, view.getBottom());
            }
            this.f1672q = right;
            this.r = bottom;
            this.f1673s = left;
            this.f1674t = top;
            if (Float.isNaN(this.f1664i)) {
                this.f1670o = (left + right) / 2;
            } else {
                this.f1670o = this.f1664i;
            }
            if (Float.isNaN(this.f1665j)) {
                this.f1671p = (top + bottom) / 2;
            } else {
                this.f1671p = this.f1665j;
            }
        }
    }

    public final void s() {
        int i3;
        if (this.f1667l == null || (i3 = this.f1850b) == 0) {
            return;
        }
        View[] viewArr = this.f1676v;
        if (viewArr == null || viewArr.length != i3) {
            this.f1676v = new View[i3];
        }
        for (int i10 = 0; i10 < this.f1850b; i10++) {
            this.f1676v[i10] = this.f1667l.d(this.f1849a[i10]);
        }
    }

    @Override // android.view.View
    public void setElevation(float f2) {
        super.setElevation(f2);
        e();
    }

    @Override // android.view.View
    public void setPivotX(float f2) {
        this.f1664i = f2;
        t();
    }

    @Override // android.view.View
    public void setPivotY(float f2) {
        this.f1665j = f2;
        t();
    }

    @Override // android.view.View
    public void setRotation(float f2) {
        this.f1666k = f2;
        t();
    }

    @Override // android.view.View
    public void setScaleX(float f2) {
        this.f1668m = f2;
        t();
    }

    @Override // android.view.View
    public void setScaleY(float f2) {
        this.f1669n = f2;
        t();
    }

    @Override // android.view.View
    public void setTranslationX(float f2) {
        this.f1677w = f2;
        t();
    }

    @Override // android.view.View
    public void setTranslationY(float f2) {
        this.f1678x = f2;
        t();
    }

    @Override // android.view.View
    public void setVisibility(int i3) {
        super.setVisibility(i3);
        e();
    }

    public final void t() {
        if (this.f1667l == null) {
            return;
        }
        if (this.f1676v == null) {
            s();
        }
        r();
        double radians = Float.isNaN(this.f1666k) ? 0.0d : Math.toRadians(this.f1666k);
        float sin = (float) Math.sin(radians);
        float cos = (float) Math.cos(radians);
        float f2 = this.f1668m;
        float f10 = f2 * cos;
        float f11 = this.f1669n;
        float f12 = (-f11) * sin;
        float f13 = f2 * sin;
        float f14 = f11 * cos;
        for (int i3 = 0; i3 < this.f1850b; i3++) {
            View view = this.f1676v[i3];
            int right = (view.getRight() + view.getLeft()) / 2;
            int bottom = (view.getBottom() + view.getTop()) / 2;
            float f15 = right - this.f1670o;
            float f16 = bottom - this.f1671p;
            float f17 = (((f12 * f16) + (f10 * f15)) - f15) + this.f1677w;
            float f18 = (((f14 * f16) + (f15 * f13)) - f16) + this.f1678x;
            view.setTranslationX(f17);
            view.setTranslationY(f18);
            view.setScaleY(this.f1669n);
            view.setScaleX(this.f1668m);
            if (!Float.isNaN(this.f1666k)) {
                view.setRotation(this.f1666k);
            }
        }
    }

    public Layer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1664i = Float.NaN;
        this.f1665j = Float.NaN;
        this.f1666k = Float.NaN;
        this.f1668m = 1.0f;
        this.f1669n = 1.0f;
        this.f1670o = Float.NaN;
        this.f1671p = Float.NaN;
        this.f1672q = Float.NaN;
        this.r = Float.NaN;
        this.f1673s = Float.NaN;
        this.f1674t = Float.NaN;
        this.f1675u = true;
        this.f1676v = null;
        this.f1677w = 0.0f;
        this.f1678x = 0.0f;
    }

    public Layer(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1664i = Float.NaN;
        this.f1665j = Float.NaN;
        this.f1666k = Float.NaN;
        this.f1668m = 1.0f;
        this.f1669n = 1.0f;
        this.f1670o = Float.NaN;
        this.f1671p = Float.NaN;
        this.f1672q = Float.NaN;
        this.r = Float.NaN;
        this.f1673s = Float.NaN;
        this.f1674t = Float.NaN;
        this.f1675u = true;
        this.f1676v = null;
        this.f1677w = 0.0f;
        this.f1678x = 0.0f;
    }
}
