package androidx.constraintlayout.utils.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.ViewParent;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R$styleable;
import b1.a;
import java.util.HashMap;
import p0.b;
import t0.f;
import t0.k;
import u0.n;
import u0.o;
import u0.v;

/* loaded from: classes.dex */
public class MotionTelltales extends MockView {

    /* renamed from: l, reason: collision with root package name */
    public final Paint f1839l;

    /* renamed from: m, reason: collision with root package name */
    public MotionLayout f1840m;

    /* renamed from: n, reason: collision with root package name */
    public final float[] f1841n;

    /* renamed from: o, reason: collision with root package name */
    public final Matrix f1842o;

    /* renamed from: p, reason: collision with root package name */
    public int f1843p;

    /* renamed from: q, reason: collision with root package name */
    public int f1844q;
    public float r;

    public MotionTelltales(Context context) {
        super(context);
        this.f1839l = new Paint();
        this.f1841n = new float[2];
        this.f1842o = new Matrix();
        this.f1843p = 0;
        this.f1844q = -65281;
        this.r = 0.25f;
        b(context, null);
    }

    public final void b(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.MotionTelltales);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i3 = 0; i3 < indexCount; i3++) {
                int index = obtainStyledAttributes.getIndex(i3);
                if (index == R$styleable.MotionTelltales_telltales_tailColor) {
                    this.f1844q = obtainStyledAttributes.getColor(index, this.f1844q);
                } else if (index == R$styleable.MotionTelltales_telltales_velocityMode) {
                    this.f1843p = obtainStyledAttributes.getInt(index, this.f1843p);
                } else if (index == R$styleable.MotionTelltales_telltales_tailScale) {
                    this.r = obtainStyledAttributes.getFloat(index, this.r);
                }
            }
            obtainStyledAttributes.recycle();
        }
        int i10 = this.f1844q;
        Paint paint = this.f1839l;
        paint.setColor(i10);
        paint.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // androidx.constraintlayout.utils.widget.MockView, android.view.View
    public final void onDraw(Canvas canvas) {
        char c9;
        float f2;
        int i3;
        Matrix matrix;
        int i10;
        float[] fArr;
        int i11;
        int i12;
        int i13;
        char c10;
        n nVar;
        f fVar;
        f fVar2;
        int i14;
        f fVar3;
        float f10;
        float f11;
        float[] fArr2;
        double[] dArr;
        a aVar;
        MotionTelltales motionTelltales = this;
        int i15 = 5;
        super.onDraw(canvas);
        Matrix matrix2 = motionTelltales.getMatrix();
        Matrix matrix3 = motionTelltales.f1842o;
        matrix2.invert(matrix3);
        if (motionTelltales.f1840m == null) {
            ViewParent parent = motionTelltales.getParent();
            if (parent instanceof MotionLayout) {
                motionTelltales.f1840m = (MotionLayout) parent;
                return;
            }
            return;
        }
        int width = motionTelltales.getWidth();
        int height = motionTelltales.getHeight();
        float[] fArr3 = {0.1f, 0.25f, 0.5f, 0.75f, 0.9f};
        int i16 = 0;
        while (i16 < i15) {
            float f12 = fArr3[i16];
            int i17 = 0;
            while (i17 < i15) {
                float f13 = fArr3[i17];
                MotionLayout motionLayout = motionTelltales.f1840m;
                int i18 = motionTelltales.f1843p;
                float f14 = motionLayout.f1721v;
                float f15 = motionLayout.G;
                if (motionLayout.f1719t != null) {
                    float signum = Math.signum(motionLayout.I - f15);
                    float interpolation = motionLayout.f1719t.getInterpolation(motionLayout.G + 1.0E-5f);
                    c9 = 1;
                    f15 = motionLayout.f1719t.getInterpolation(motionLayout.G);
                    f14 = (((interpolation - f15) / 1.0E-5f) * signum) / motionLayout.E;
                } else {
                    c9 = 1;
                }
                o oVar = motionLayout.f1719t;
                if (oVar != null) {
                    f14 = oVar.a();
                }
                float f16 = f14;
                n nVar2 = (n) motionLayout.C.get(motionTelltales);
                int i19 = i18 & 1;
                float f17 = f13;
                float f18 = f12;
                float[] fArr4 = motionTelltales.f1841n;
                if (i19 == 0) {
                    int width2 = motionTelltales.getWidth();
                    int height2 = motionTelltales.getHeight();
                    float[] fArr5 = nVar2.f18732v;
                    float b3 = nVar2.b(f15, fArr5);
                    c10 = 0;
                    HashMap hashMap = nVar2.f18735y;
                    f2 = f16;
                    k kVar = hashMap == null ? null : (k) hashMap.get("translationX");
                    fArr = fArr3;
                    HashMap hashMap2 = nVar2.f18735y;
                    i11 = i16;
                    k kVar2 = hashMap2 == null ? null : (k) hashMap2.get("translationY");
                    HashMap hashMap3 = nVar2.f18735y;
                    k kVar3 = hashMap3 == null ? null : (k) hashMap3.get("rotation");
                    HashMap hashMap4 = nVar2.f18735y;
                    k kVar4 = hashMap4 == null ? null : (k) hashMap4.get("scaleX");
                    i13 = i17;
                    HashMap hashMap5 = nVar2.f18735y;
                    i10 = height;
                    k kVar5 = hashMap5 == null ? null : (k) hashMap5.get("scaleY");
                    i3 = width;
                    HashMap hashMap6 = nVar2.f18736z;
                    f fVar4 = hashMap6 == null ? null : (f) hashMap6.get("translationX");
                    HashMap hashMap7 = nVar2.f18736z;
                    f fVar5 = hashMap7 == null ? null : (f) hashMap7.get("translationY");
                    HashMap hashMap8 = nVar2.f18736z;
                    f fVar6 = hashMap8 == null ? null : (f) hashMap8.get("rotation");
                    HashMap hashMap9 = nVar2.f18736z;
                    f fVar7 = hashMap9 == null ? null : (f) hashMap9.get("scaleX");
                    HashMap hashMap10 = nVar2.f18736z;
                    f fVar8 = hashMap10 != null ? (f) hashMap10.get("scaleY") : null;
                    a aVar2 = new a();
                    matrix = matrix3;
                    aVar2.e = 0.0f;
                    aVar2.f3049d = 0.0f;
                    aVar2.f3048c = 0.0f;
                    aVar2.f3047b = 0.0f;
                    aVar2.f3046a = 0.0f;
                    if (kVar3 != null) {
                        nVar = nVar2;
                        fVar = fVar5;
                        aVar2.e = (float) kVar3.f18451a.e(b3);
                        aVar2.f3050f = kVar3.a(b3);
                    } else {
                        nVar = nVar2;
                        fVar = fVar5;
                    }
                    if (kVar != null) {
                        aVar2.f3048c = (float) kVar.f18451a.e(b3);
                    }
                    if (kVar2 != null) {
                        aVar2.f3049d = (float) kVar2.f18451a.e(b3);
                    }
                    if (kVar4 != null) {
                        aVar2.f3046a = (float) kVar4.f18451a.e(b3);
                    }
                    if (kVar5 != null) {
                        aVar2.f3047b = (float) kVar5.f18451a.e(b3);
                    }
                    if (fVar6 != null) {
                        aVar2.e = fVar6.b(b3);
                    }
                    if (fVar4 != null) {
                        aVar2.f3048c = fVar4.b(b3);
                    }
                    if (fVar != null) {
                        fVar2 = fVar;
                        aVar2.f3049d = fVar2.b(b3);
                    } else {
                        fVar2 = fVar;
                    }
                    if (fVar7 != null) {
                        aVar2.f3046a = fVar7.b(b3);
                    }
                    if (fVar8 != null) {
                        aVar2.f3047b = fVar8.b(b3);
                    }
                    n nVar3 = nVar;
                    b bVar = nVar3.f18722k;
                    if (bVar != null) {
                        double[] dArr2 = nVar3.f18727p;
                        if (dArr2.length > 0) {
                            double d5 = b3;
                            bVar.c(d5, dArr2);
                            nVar3.f18722k.f(d5, nVar3.f18728q);
                            int[] iArr = nVar3.f18726o;
                            double[] dArr3 = nVar3.f18728q;
                            double[] dArr4 = nVar3.f18727p;
                            nVar3.f18717f.getClass();
                            i14 = i18;
                            v.e(f17, f18, fArr4, iArr, dArr3, dArr4);
                            fArr2 = fArr4;
                            f11 = f18;
                            f10 = f17;
                            aVar = aVar2;
                        } else {
                            i14 = i18;
                            aVar = aVar2;
                            f10 = f17;
                            f11 = f18;
                            fArr2 = fArr4;
                        }
                        aVar.a(f10, f11, width2, height2, fArr2);
                    } else {
                        i14 = i18;
                        if (nVar3.f18721j != null) {
                            double b10 = nVar3.b(b3, fArr5);
                            nVar3.f18721j[0].f(b10, nVar3.f18728q);
                            nVar3.f18721j[0].c(b10, nVar3.f18727p);
                            float f19 = fArr5[0];
                            int i20 = 0;
                            while (true) {
                                dArr = nVar3.f18728q;
                                if (i20 >= dArr.length) {
                                    break;
                                }
                                dArr[i20] = dArr[i20] * f19;
                                i20++;
                            }
                            int[] iArr2 = nVar3.f18726o;
                            double[] dArr5 = nVar3.f18727p;
                            nVar3.f18717f.getClass();
                            v.e(f17, f18, fArr4, iArr2, dArr, dArr5);
                            fArr2 = fArr4;
                            f11 = f18;
                            f10 = f17;
                            aVar2.a(f10, f11, width2, height2, fArr2);
                        } else {
                            v vVar = nVar3.f18718g;
                            float f20 = vVar.e;
                            v vVar2 = nVar3.f18717f;
                            float f21 = f20 - vVar2.e;
                            float f22 = vVar.f18768f - vVar2.f18768f;
                            float f23 = vVar.f18769g - vVar2.f18769g;
                            float f24 = f22 + (vVar.f18770h - vVar2.f18770h);
                            fArr4[0] = ((f21 + f23) * f17) + ((1.0f - f17) * f21);
                            fArr4[c9] = (f24 * f18) + ((1.0f - f18) * f22);
                            aVar2.e = 0.0f;
                            aVar2.f3049d = 0.0f;
                            aVar2.f3048c = 0.0f;
                            aVar2.f3047b = 0.0f;
                            aVar2.f3046a = 0.0f;
                            if (kVar3 != null) {
                                i12 = i14;
                                fVar3 = fVar8;
                                aVar2.e = (float) kVar3.f18451a.e(b3);
                                aVar2.f3050f = kVar3.a(b3);
                            } else {
                                i12 = i14;
                                fVar3 = fVar8;
                            }
                            if (kVar != null) {
                                aVar2.f3048c = (float) kVar.f18451a.e(b3);
                            }
                            if (kVar2 != null) {
                                aVar2.f3049d = (float) kVar2.f18451a.e(b3);
                            }
                            if (kVar4 != null) {
                                aVar2.f3046a = (float) kVar4.f18451a.e(b3);
                            }
                            if (kVar5 != null) {
                                aVar2.f3047b = (float) kVar5.f18451a.e(b3);
                            }
                            if (fVar6 != null) {
                                aVar2.e = fVar6.b(b3);
                            }
                            if (fVar4 != null) {
                                aVar2.f3048c = fVar4.b(b3);
                            }
                            if (fVar2 != null) {
                                aVar2.f3049d = fVar2.b(b3);
                            }
                            if (fVar7 != null) {
                                aVar2.f3046a = fVar7.b(b3);
                            }
                            if (fVar3 != null) {
                                aVar2.f3047b = fVar3.b(b3);
                            }
                            f10 = f17;
                            f11 = f18;
                            fArr2 = fArr4;
                            aVar2.a(f10, f11, width2, height2, fArr2);
                            f17 = f10;
                            f18 = f11;
                            fArr4 = fArr2;
                        }
                    }
                    i12 = i14;
                    f17 = f10;
                    f18 = f11;
                    fArr4 = fArr2;
                } else {
                    f2 = f16;
                    i3 = width;
                    matrix = matrix3;
                    i10 = height;
                    fArr = fArr3;
                    i11 = i16;
                    i12 = i18;
                    i13 = i17;
                    c10 = 0;
                    nVar2.d(f15, f17, f18, fArr4);
                }
                if (i12 < 2) {
                    fArr4[c10] = fArr4[c10] * f2;
                    fArr4[c9] = fArr4[c9] * f2;
                }
                motionTelltales = this;
                float[] fArr6 = motionTelltales.f1841n;
                Matrix matrix4 = matrix;
                matrix4.mapVectors(fArr6);
                width = i3;
                float f25 = width * f17;
                int i21 = i10;
                float f26 = i21 * f18;
                float f27 = fArr6[c10];
                float f28 = motionTelltales.r;
                float f29 = f26 - (fArr6[c9] * f28);
                matrix4.mapVectors(fArr6);
                canvas.drawLine(f25, f26, f25 - (f27 * f28), f29, motionTelltales.f1839l);
                i17 = i13 + 1;
                height = i21;
                f12 = f18;
                fArr3 = fArr;
                i16 = i11;
                i15 = 5;
                matrix3 = matrix4;
            }
            i16++;
            i15 = 5;
            matrix3 = matrix3;
        }
    }

    @Override // android.view.View
    public final void onLayout(boolean z5, int i3, int i10, int i11, int i12) {
        super.onLayout(z5, i3, i10, i11, i12);
        postInvalidate();
    }

    public void setText(CharSequence charSequence) {
        this.f1805f = charSequence.toString();
        requestLayout();
    }

    public MotionTelltales(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f1839l = new Paint();
        this.f1841n = new float[2];
        this.f1842o = new Matrix();
        this.f1843p = 0;
        this.f1844q = -65281;
        this.r = 0.25f;
        b(context, attributeSet);
    }

    public MotionTelltales(Context context, AttributeSet attributeSet, int i3) {
        super(context, attributeSet, i3);
        this.f1839l = new Paint();
        this.f1841n = new float[2];
        this.f1842o = new Matrix();
        this.f1843p = 0;
        this.f1844q = -65281;
        this.r = 0.25f;
        b(context, attributeSet);
    }
}
