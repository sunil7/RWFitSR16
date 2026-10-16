package androidx.constraintlayout.helper.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.R$styleable;
import androidx.constraintlayout.widget.VirtualLayout;
import java.util.Arrays;
import java.util.HashMap;
import w0.e;

/* loaded from: classes.dex */
public class CircularFlow extends VirtualLayout {

    /* renamed from: u, reason: collision with root package name */
    public static int f1652u;

    /* renamed from: v, reason: collision with root package name */
    public static float f1653v;

    /* renamed from: k, reason: collision with root package name */
    public ConstraintLayout f1654k;

    /* renamed from: l, reason: collision with root package name */
    public int f1655l;

    /* renamed from: m, reason: collision with root package name */
    public float[] f1656m;

    /* renamed from: n, reason: collision with root package name */
    public int[] f1657n;

    /* renamed from: o, reason: collision with root package name */
    public int f1658o;

    /* renamed from: p, reason: collision with root package name */
    public int f1659p;

    /* renamed from: q, reason: collision with root package name */
    public String f1660q;
    public String r;

    /* renamed from: s, reason: collision with root package name */
    public Float f1661s;

    /* renamed from: t, reason: collision with root package name */
    public Integer f1662t;

    public CircularFlow(Context context) {
        super(context);
    }

    private void setAngles(String str) {
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f1659p = 0;
        while (true) {
            int indexOf = str.indexOf(44, i3);
            if (indexOf == -1) {
                s(str.substring(i3).trim());
                return;
            } else {
                s(str.substring(i3, indexOf).trim());
                i3 = indexOf + 1;
            }
        }
    }

    private void setRadius(String str) {
        if (str == null) {
            return;
        }
        int i3 = 0;
        this.f1658o = 0;
        while (true) {
            int indexOf = str.indexOf(44, i3);
            if (indexOf == -1) {
                t(str.substring(i3).trim());
                return;
            } else {
                t(str.substring(i3, indexOf).trim());
                i3 = indexOf + 1;
            }
        }
    }

    public float[] getAngles() {
        return Arrays.copyOf(this.f1656m, this.f1659p);
    }

    public int[] getRadius() {
        return Arrays.copyOf(this.f1657n, this.f1658o);
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper
    public final void k(AttributeSet attributeSet) {
        super.k(attributeSet);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.ConstraintLayout_Layout_circularflow_viewCenter) {
                    this.f1655l = obtainStyledAttributes.getResourceId(index, 0);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_angles) {
                    String string = obtainStyledAttributes.getString(index);
                    this.f1660q = string;
                    setAngles(string);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_radiusInDP) {
                    String string2 = obtainStyledAttributes.getString(index);
                    this.r = string2;
                    setRadius(string2);
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_defaultAngle) {
                    Float valueOf = Float.valueOf(obtainStyledAttributes.getFloat(index, f1653v));
                    this.f1661s = valueOf;
                    setDefaultAngle(valueOf.floatValue());
                } else if (index == R$styleable.ConstraintLayout_Layout_circularflow_defaultRadius) {
                    Integer valueOf2 = Integer.valueOf(obtainStyledAttributes.getDimensionPixelSize(index, f1652u));
                    this.f1662t = valueOf2;
                    setDefaultRadius(valueOf2.intValue());
                }
            }
            obtainStyledAttributes.recycle();
        }
    }

    @Override // androidx.constraintlayout.widget.VirtualLayout, androidx.constraintlayout.widget.ConstraintHelper, android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        String str = this.f1660q;
        if (str != null) {
            this.f1656m = new float[1];
            setAngles(str);
        }
        String str2 = this.r;
        if (str2 != null) {
            this.f1657n = new int[1];
            setRadius(str2);
        }
        Float f2 = this.f1661s;
        if (f2 != null) {
            setDefaultAngle(f2.floatValue());
        }
        Integer num = this.f1662t;
        if (num != null) {
            setDefaultRadius(num.intValue());
        }
        this.f1654k = (ConstraintLayout) getParent();
        for (int i3 = 0; i3 < this.f1850b; i3++) {
            View d5 = this.f1654k.d(this.f1849a[i3]);
            if (d5 != null) {
                int i10 = f1652u;
                float f10 = f1653v;
                int[] iArr = this.f1657n;
                HashMap hashMap = this.f1855h;
                if (iArr == null || i3 >= iArr.length) {
                    Integer num2 = this.f1662t;
                    if (num2 == null || num2.intValue() == -1) {
                        String valueOf = String.valueOf((String) hashMap.get(Integer.valueOf(d5.getId())));
                        Log.e("CircularFlow", valueOf.length() != 0 ? "Added radius to view with id: ".concat(valueOf) : new String("Added radius to view with id: "));
                    } else {
                        this.f1658o++;
                        if (this.f1657n == null) {
                            this.f1657n = new int[1];
                        }
                        int[] radius = getRadius();
                        this.f1657n = radius;
                        radius[this.f1658o - 1] = i10;
                    }
                } else {
                    i10 = iArr[i3];
                }
                float[] fArr = this.f1656m;
                if (fArr == null || i3 >= fArr.length) {
                    Float f11 = this.f1661s;
                    if (f11 == null || f11.floatValue() == -1.0f) {
                        String valueOf2 = String.valueOf((String) hashMap.get(Integer.valueOf(d5.getId())));
                        Log.e("CircularFlow", valueOf2.length() != 0 ? "Added angle to view with id: ".concat(valueOf2) : new String("Added angle to view with id: "));
                    } else {
                        this.f1659p++;
                        if (this.f1656m == null) {
                            this.f1656m = new float[1];
                        }
                        float[] angles = getAngles();
                        this.f1656m = angles;
                        angles[this.f1659p - 1] = f10;
                    }
                } else {
                    f10 = fArr[i3];
                }
                e eVar = (e) d5.getLayoutParams();
                eVar.f19324q = f10;
                eVar.f19320o = this.f1655l;
                eVar.f19322p = i10;
                d5.setLayoutParams(eVar);
            }
        }
        e();
    }

    public final void s(String str) {
        float[] fArr;
        if (str == null || str.length() == 0 || this.f1851c == null || (fArr = this.f1656m) == null) {
            return;
        }
        if (this.f1659p + 1 > fArr.length) {
            this.f1656m = Arrays.copyOf(fArr, fArr.length + 1);
        }
        this.f1656m[this.f1659p] = Integer.parseInt(str);
        this.f1659p++;
    }

    public void setDefaultAngle(float f2) {
        f1653v = f2;
    }

    public void setDefaultRadius(int i3) {
        f1652u = i3;
    }

    public final void t(String str) {
        Context context;
        int[] iArr;
        if (str == null || str.length() == 0 || (context = this.f1851c) == null || (iArr = this.f1657n) == null) {
            return;
        }
        if (this.f1658o + 1 > iArr.length) {
            this.f1657n = Arrays.copyOf(iArr, iArr.length + 1);
        }
        this.f1657n[this.f1658o] = (int) (Integer.parseInt(str) * context.getResources().getDisplayMetrics().density);
        this.f1658o++;
    }

    public CircularFlow(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public CircularFlow(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
    }
}
