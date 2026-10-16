package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.RectF;
import android.util.Xml;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.widget.R$styleable;

/* loaded from: classes.dex */
public final class d {
    public static final float[][] E = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};
    public static final float[][] F = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};
    public final float A;
    public final float B;
    public final int C;
    public final int D;

    /* renamed from: a, reason: collision with root package name */
    public final int f1749a;

    /* renamed from: b, reason: collision with root package name */
    public final int f1750b;

    /* renamed from: c, reason: collision with root package name */
    public int f1751c;

    /* renamed from: d, reason: collision with root package name */
    public final int f1752d;
    public final int e;

    /* renamed from: f, reason: collision with root package name */
    public final int f1753f;

    /* renamed from: g, reason: collision with root package name */
    public float f1754g;

    /* renamed from: h, reason: collision with root package name */
    public float f1755h;

    /* renamed from: i, reason: collision with root package name */
    public final int f1756i;

    /* renamed from: j, reason: collision with root package name */
    public final boolean f1757j;

    /* renamed from: k, reason: collision with root package name */
    public float f1758k;

    /* renamed from: l, reason: collision with root package name */
    public float f1759l;

    /* renamed from: m, reason: collision with root package name */
    public boolean f1760m = false;

    /* renamed from: n, reason: collision with root package name */
    public final float[] f1761n = new float[2];

    /* renamed from: o, reason: collision with root package name */
    public final int[] f1762o = new int[2];

    /* renamed from: p, reason: collision with root package name */
    public float f1763p;

    /* renamed from: q, reason: collision with root package name */
    public float f1764q;
    public final MotionLayout r;

    /* renamed from: s, reason: collision with root package name */
    public final float f1765s;

    /* renamed from: t, reason: collision with root package name */
    public final float f1766t;

    /* renamed from: u, reason: collision with root package name */
    public final boolean f1767u;

    /* renamed from: v, reason: collision with root package name */
    public final float f1768v;

    /* renamed from: w, reason: collision with root package name */
    public final int f1769w;

    /* renamed from: x, reason: collision with root package name */
    public final float f1770x;

    /* renamed from: y, reason: collision with root package name */
    public final float f1771y;

    /* renamed from: z, reason: collision with root package name */
    public final float f1772z;

    public d(Context context, MotionLayout motionLayout, XmlResourceParser xmlResourceParser) {
        this.f1749a = 0;
        this.f1750b = 0;
        this.f1751c = 0;
        this.f1752d = -1;
        this.e = -1;
        this.f1753f = -1;
        this.f1754g = 0.5f;
        this.f1755h = 0.5f;
        this.f1756i = -1;
        this.f1757j = false;
        this.f1758k = 0.0f;
        this.f1759l = 1.0f;
        this.f1765s = 4.0f;
        this.f1766t = 1.2f;
        this.f1767u = true;
        this.f1768v = 1.0f;
        this.f1769w = 0;
        this.f1770x = 10.0f;
        this.f1771y = 10.0f;
        this.f1772z = 1.0f;
        this.A = Float.NaN;
        this.B = Float.NaN;
        this.C = 0;
        this.D = 0;
        this.r = motionLayout;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(Xml.asAttributeSet(xmlResourceParser), R$styleable.OnSwipe);
        int indexCount = obtainStyledAttributes.getIndexCount();
        for (int i3 = 0; i3 < indexCount; i3++) {
            int index = obtainStyledAttributes.getIndex(i3);
            if (index == R$styleable.OnSwipe_touchAnchorId) {
                this.f1752d = obtainStyledAttributes.getResourceId(index, this.f1752d);
            } else if (index == R$styleable.OnSwipe_touchAnchorSide) {
                int i10 = obtainStyledAttributes.getInt(index, this.f1749a);
                this.f1749a = i10;
                float[] fArr = E[i10];
                this.f1755h = fArr[0];
                this.f1754g = fArr[1];
            } else if (index == R$styleable.OnSwipe_dragDirection) {
                int i11 = obtainStyledAttributes.getInt(index, this.f1750b);
                this.f1750b = i11;
                if (i11 < 6) {
                    float[] fArr2 = F[i11];
                    this.f1758k = fArr2[0];
                    this.f1759l = fArr2[1];
                } else {
                    this.f1759l = Float.NaN;
                    this.f1758k = Float.NaN;
                    this.f1757j = true;
                }
            } else if (index == R$styleable.OnSwipe_maxVelocity) {
                this.f1765s = obtainStyledAttributes.getFloat(index, this.f1765s);
            } else if (index == R$styleable.OnSwipe_maxAcceleration) {
                this.f1766t = obtainStyledAttributes.getFloat(index, this.f1766t);
            } else if (index == R$styleable.OnSwipe_moveWhenScrollAtTop) {
                this.f1767u = obtainStyledAttributes.getBoolean(index, this.f1767u);
            } else if (index == R$styleable.OnSwipe_dragScale) {
                this.f1768v = obtainStyledAttributes.getFloat(index, this.f1768v);
            } else if (index == R$styleable.OnSwipe_dragThreshold) {
                this.f1770x = obtainStyledAttributes.getFloat(index, this.f1770x);
            } else if (index == R$styleable.OnSwipe_touchRegionId) {
                this.e = obtainStyledAttributes.getResourceId(index, this.e);
            } else if (index == R$styleable.OnSwipe_onTouchUp) {
                this.f1751c = obtainStyledAttributes.getInt(index, this.f1751c);
            } else if (index == R$styleable.OnSwipe_nestedScrollFlags) {
                this.f1769w = obtainStyledAttributes.getInteger(index, 0);
            } else if (index == R$styleable.OnSwipe_limitBoundsTo) {
                this.f1753f = obtainStyledAttributes.getResourceId(index, 0);
            } else if (index == R$styleable.OnSwipe_rotationCenterId) {
                this.f1756i = obtainStyledAttributes.getResourceId(index, this.f1756i);
            } else if (index == R$styleable.OnSwipe_springDamping) {
                this.f1771y = obtainStyledAttributes.getFloat(index, this.f1771y);
            } else if (index == R$styleable.OnSwipe_springMass) {
                this.f1772z = obtainStyledAttributes.getFloat(index, this.f1772z);
            } else if (index == R$styleable.OnSwipe_springStiffness) {
                this.A = obtainStyledAttributes.getFloat(index, this.A);
            } else if (index == R$styleable.OnSwipe_springStopThreshold) {
                this.B = obtainStyledAttributes.getFloat(index, this.B);
            } else if (index == R$styleable.OnSwipe_springBoundary) {
                this.C = obtainStyledAttributes.getInt(index, this.C);
            } else if (index == R$styleable.OnSwipe_autoCompleteMode) {
                this.D = obtainStyledAttributes.getInt(index, this.D);
            }
        }
        obtainStyledAttributes.recycle();
    }

    public final RectF a(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i3 = this.f1753f;
        if (i3 == -1 || (findViewById = viewGroup.findViewById(i3)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    public final RectF b(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i3 = this.e;
        if (i3 == -1 || (findViewById = viewGroup.findViewById(i3)) == null) {
            return null;
        }
        rectF.set(findViewById.getLeft(), findViewById.getTop(), findViewById.getRight(), findViewById.getBottom());
        return rectF;
    }

    public final void c(boolean z5) {
        float[][] fArr = E;
        float[][] fArr2 = F;
        if (z5) {
            fArr2[4] = fArr2[3];
            fArr2[5] = fArr2[2];
            fArr[5] = fArr[2];
            fArr[6] = fArr[1];
        } else {
            fArr2[4] = fArr2[2];
            fArr2[5] = fArr2[3];
            fArr[5] = fArr[1];
            fArr[6] = fArr[2];
        }
        float[] fArr3 = fArr[this.f1749a];
        this.f1755h = fArr3[0];
        this.f1754g = fArr3[1];
        int i3 = this.f1750b;
        if (i3 >= 6) {
            return;
        }
        float[] fArr4 = fArr2[i3];
        this.f1758k = fArr4[0];
        this.f1759l = fArr4[1];
    }

    public final String toString() {
        if (Float.isNaN(this.f1758k)) {
            return "rotation";
        }
        float f2 = this.f1758k;
        float f10 = this.f1759l;
        StringBuilder sb2 = new StringBuilder(33);
        sb2.append(f2);
        sb2.append(" , ");
        sb2.append(f10);
        return sb2.toString();
    }
}
