package u0;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.constraintlayout.utils.widget.MotionLabel;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.pf;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class n {

    /* renamed from: b, reason: collision with root package name */
    public final View f18714b;

    /* renamed from: c, reason: collision with root package name */
    public final int f18715c;

    /* renamed from: j, reason: collision with root package name */
    public pf[] f18721j;

    /* renamed from: k, reason: collision with root package name */
    public p0.b f18722k;

    /* renamed from: o, reason: collision with root package name */
    public int[] f18726o;

    /* renamed from: p, reason: collision with root package name */
    public double[] f18727p;

    /* renamed from: q, reason: collision with root package name */
    public double[] f18728q;
    public String[] r;

    /* renamed from: s, reason: collision with root package name */
    public int[] f18729s;

    /* renamed from: x, reason: collision with root package name */
    public HashMap f18734x;

    /* renamed from: y, reason: collision with root package name */
    public HashMap f18735y;

    /* renamed from: z, reason: collision with root package name */
    public HashMap f18736z;

    /* renamed from: a, reason: collision with root package name */
    public final Rect f18713a = new Rect();

    /* renamed from: d, reason: collision with root package name */
    public boolean f18716d = false;
    public int e = -1;

    /* renamed from: f, reason: collision with root package name */
    public final v f18717f = new v();

    /* renamed from: g, reason: collision with root package name */
    public final v f18718g = new v();

    /* renamed from: h, reason: collision with root package name */
    public final l f18719h = new l();

    /* renamed from: i, reason: collision with root package name */
    public final l f18720i = new l();

    /* renamed from: l, reason: collision with root package name */
    public float f18723l = Float.NaN;

    /* renamed from: m, reason: collision with root package name */
    public float f18724m = 0.0f;

    /* renamed from: n, reason: collision with root package name */
    public float f18725n = 1.0f;

    /* renamed from: t, reason: collision with root package name */
    public final float[] f18730t = new float[4];

    /* renamed from: u, reason: collision with root package name */
    public final ArrayList f18731u = new ArrayList();

    /* renamed from: v, reason: collision with root package name */
    public final float[] f18732v = new float[1];

    /* renamed from: w, reason: collision with root package name */
    public final ArrayList f18733w = new ArrayList();
    public int A = -1;
    public int B = -1;
    public View C = null;
    public int D = -1;
    public float E = Float.NaN;
    public Interpolator F = null;
    public boolean G = false;

    public n(View view) {
        this.f18714b = view;
        this.f18715c = view.getId();
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams instanceof w0.e) {
            ((w0.e) layoutParams).getClass();
        }
    }

    public static void g(Rect rect, Rect rect2, int i3, int i10, int i11) {
        if (i3 == 1) {
            int i12 = rect.left + rect.right;
            rect2.left = ((rect.top + rect.bottom) - rect.width()) / 2;
            rect2.top = i11 - ((rect.height() + i12) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i3 == 2) {
            int i13 = rect.left + rect.right;
            rect2.left = i10 - ((rect.width() + (rect.top + rect.bottom)) / 2);
            rect2.top = (i13 - rect.height()) / 2;
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i3 == 3) {
            int i14 = rect.left + rect.right;
            rect2.left = ((rect.height() / 2) + rect.top) - (i14 / 2);
            rect2.top = i11 - ((rect.height() + i14) / 2);
            rect2.right = rect.width() + rect2.left;
            rect2.bottom = rect.height() + rect2.top;
            return;
        }
        if (i3 != 4) {
            return;
        }
        int i15 = rect.left + rect.right;
        rect2.left = i10 - ((rect.width() + (rect.bottom + rect.top)) / 2);
        rect2.top = (i15 - rect.height()) / 2;
        rect2.right = rect.width() + rect2.left;
        rect2.bottom = rect.height() + rect2.top;
    }

    public final void a(c cVar) {
        this.f18733w.add(cVar);
    }

    public final float b(float f2, float[] fArr) {
        float f10 = 0.0f;
        if (fArr != null) {
            fArr[0] = 1.0f;
        } else {
            float f11 = this.f18725n;
            if (f11 != 1.0d) {
                float f12 = this.f18724m;
                if (f2 < f12) {
                    f2 = 0.0f;
                }
                if (f2 > f12 && f2 < 1.0d) {
                    f2 = Math.min((f2 - f12) * f11, 1.0f);
                }
            }
        }
        p0.e eVar = this.f18717f.f18764a;
        ArrayList arrayList = this.f18731u;
        int size = arrayList.size();
        float f13 = Float.NaN;
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            v vVar = (v) obj;
            p0.e eVar2 = vVar.f18764a;
            if (eVar2 != null) {
                float f14 = vVar.f18766c;
                if (f14 < f2) {
                    eVar = eVar2;
                    f10 = f14;
                } else if (Float.isNaN(f13)) {
                    f13 = vVar.f18766c;
                }
            }
        }
        if (eVar != null) {
            float f15 = (Float.isNaN(f13) ? 1.0f : f13) - f10;
            double d5 = (f2 - f10) / f15;
            f2 = (((float) eVar.a(d5)) * f15) + f10;
            if (fArr != null) {
                fArr[0] = (float) eVar.b(d5);
            }
        }
        return f2;
    }

    public final void c(double d5, float[] fArr, float[] fArr2) {
        float f2;
        double[] dArr = new double[4];
        double[] dArr2 = new double[4];
        this.f18721j[0].c(d5, dArr);
        this.f18721j[0].f(d5, dArr2);
        float f10 = 0.0f;
        Arrays.fill(fArr2, 0.0f);
        int[] iArr = this.f18726o;
        v vVar = this.f18717f;
        float f11 = vVar.e;
        float f12 = vVar.f18768f;
        float f13 = vVar.f18769g;
        float f14 = vVar.f18770h;
        float f15 = 0.0f;
        float f16 = 0.0f;
        float f17 = 0.0f;
        for (int i3 = 0; i3 < iArr.length; i3++) {
            float f18 = (float) dArr[i3];
            float f19 = (float) dArr2[i3];
            int i10 = iArr[i3];
            if (i10 == 1) {
                f11 = f18;
                f10 = f19;
            } else if (i10 == 2) {
                f12 = f18;
                f17 = f19;
            } else if (i10 == 3) {
                f13 = f18;
                f15 = f19;
            } else if (i10 == 4) {
                f14 = f18;
                f16 = f19;
            }
        }
        float f20 = (f15 / 2.0f) + f10;
        float f21 = (f16 / 2.0f) + f17;
        n nVar = vVar.f18775m;
        if (nVar != null) {
            float[] fArr3 = new float[2];
            float[] fArr4 = new float[2];
            nVar.c(d5, fArr3, fArr4);
            float f22 = fArr3[0];
            float f23 = fArr3[1];
            float f24 = fArr4[0];
            float f25 = fArr4[1];
            double d8 = f11;
            double d10 = f12;
            float sin = (float) (((Math.sin(d10) * d8) + f22) - (f13 / 2.0f));
            float cos = (float) ((f23 - (Math.cos(d10) * d8)) - (f14 / 2.0f));
            double d11 = f10;
            f2 = 2.0f;
            double d12 = f17;
            float cos2 = (float) ((Math.cos(d10) * d12) + (Math.sin(d10) * d11) + f24);
            f21 = (float) ((Math.sin(d10) * d12) + (f25 - (Math.cos(d10) * d11)));
            f12 = cos;
            f11 = sin;
            f20 = cos2;
        } else {
            f2 = 2.0f;
        }
        fArr[0] = (f13 / f2) + f11 + 0.0f;
        fArr[1] = (f14 / f2) + f12 + 0.0f;
        fArr2[0] = f20;
        fArr2[1] = f21;
    }

    public final void d(float f2, float f10, float f11, float[] fArr) {
        double[] dArr;
        float[] fArr2 = this.f18732v;
        float b3 = b(f2, fArr2);
        pf[] pfVarArr = this.f18721j;
        int i3 = 0;
        if (pfVarArr == null) {
            v vVar = this.f18718g;
            float f12 = vVar.e;
            v vVar2 = this.f18717f;
            float f13 = f12 - vVar2.e;
            float f14 = vVar.f18768f - vVar2.f18768f;
            float f15 = vVar.f18769g - vVar2.f18769g;
            float f16 = (vVar.f18770h - vVar2.f18770h) + f14;
            fArr[0] = ((f15 + f13) * f10) + ((1.0f - f10) * f13);
            fArr[1] = (f16 * f11) + ((1.0f - f11) * f14);
            return;
        }
        double d5 = b3;
        pfVarArr[0].f(d5, this.f18728q);
        this.f18721j[0].c(d5, this.f18727p);
        float f17 = fArr2[0];
        while (true) {
            dArr = this.f18728q;
            if (i3 >= dArr.length) {
                break;
            }
            dArr[i3] = dArr[i3] * f17;
            i3++;
        }
        p0.b bVar = this.f18722k;
        if (bVar == null) {
            int[] iArr = this.f18726o;
            double[] dArr2 = this.f18727p;
            this.f18717f.getClass();
            v.e(f10, f11, fArr, iArr, dArr, dArr2);
            return;
        }
        double[] dArr3 = this.f18727p;
        if (dArr3.length > 0) {
            bVar.c(d5, dArr3);
            this.f18722k.f(d5, this.f18728q);
            int[] iArr2 = this.f18726o;
            double[] dArr4 = this.f18728q;
            double[] dArr5 = this.f18727p;
            this.f18717f.getClass();
            v.e(f10, f11, fArr, iArr2, dArr4, dArr5);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean e(float f2, long j4, View view, p0.e eVar) {
        boolean z5;
        boolean z6;
        float f10;
        t0.n nVar;
        boolean z8;
        double d5;
        float f11;
        float f12;
        float f13;
        float f14;
        float f15;
        t0.n nVar2 = null;
        float b3 = b(f2, null);
        int i3 = this.D;
        if (i3 != -1) {
            float f16 = 1.0f / i3;
            float floor = ((float) Math.floor(b3 / f16)) * f16;
            float f17 = (b3 % f16) / f16;
            if (!Float.isNaN(this.E)) {
                f17 = (f17 + this.E) % 1.0f;
            }
            Interpolator interpolator = this.F;
            b3 = ((interpolator != null ? interpolator.getInterpolation(f17) : ((double) f17) > 0.5d ? 1.0f : 0.0f) * f16) + floor;
        }
        HashMap hashMap = this.f18735y;
        if (hashMap != null) {
            Iterator it = hashMap.values().iterator();
            while (it.hasNext()) {
                ((t0.k) it.next()).c(view, b3);
            }
        }
        HashMap hashMap2 = this.f18734x;
        if (hashMap2 != null) {
            t0.n nVar3 = null;
            z5 = false;
            for (t0.p pVar : hashMap2.values()) {
                if (pVar instanceof t0.n) {
                    nVar3 = (t0.n) pVar;
                } else {
                    z5 |= pVar.b(b3, j4, view, eVar);
                }
            }
            nVar2 = nVar3;
        } else {
            z5 = false;
        }
        pf[] pfVarArr = this.f18721j;
        v vVar = this.f18717f;
        if (pfVarArr != null) {
            double d8 = b3;
            pfVarArr[0].c(d8, this.f18727p);
            this.f18721j[0].f(d8, this.f18728q);
            p0.b bVar = this.f18722k;
            if (bVar != null) {
                double[] dArr = this.f18727p;
                f10 = 1.0f;
                if (dArr.length > 0) {
                    bVar.c(d8, dArr);
                    this.f18722k.f(d8, this.f18728q);
                }
            } else {
                f10 = 1.0f;
            }
            if (this.G) {
                nVar = nVar2;
                z8 = z5;
                d5 = d8;
                f11 = 2.0f;
            } else {
                int[] iArr = this.f18726o;
                double[] dArr2 = this.f18727p;
                f11 = 2.0f;
                double[] dArr3 = this.f18728q;
                boolean z10 = this.f18716d;
                float f18 = vVar.e;
                float f19 = vVar.f18768f;
                float f20 = vVar.f18769g;
                int i10 = 1;
                float f21 = vVar.f18770h;
                nVar = nVar2;
                if (iArr.length != 0) {
                    f12 = f19;
                    if (vVar.f18778p.length <= iArr[iArr.length - 1]) {
                        int i11 = iArr[iArr.length - 1] + 1;
                        vVar.f18778p = new double[i11];
                        vVar.f18779q = new double[i11];
                    }
                } else {
                    f12 = f19;
                }
                Arrays.fill(vVar.f18778p, Double.NaN);
                for (int i12 = 0; i12 < iArr.length; i12++) {
                    double[] dArr4 = vVar.f18778p;
                    int i13 = iArr[i12];
                    dArr4[i13] = dArr2[i12];
                    vVar.f18779q[i13] = dArr3[i12];
                }
                float f22 = Float.NaN;
                int i14 = 0;
                float f23 = f12;
                float f24 = f20;
                float f25 = 0.0f;
                float f26 = 0.0f;
                float f27 = 0.0f;
                float f28 = 0.0f;
                while (true) {
                    double[] dArr5 = vVar.f18778p;
                    f13 = f21;
                    if (i14 >= dArr5.length) {
                        break;
                    }
                    if (Double.isNaN(dArr5[i14])) {
                        f15 = f18;
                    } else {
                        f15 = f18;
                        float f29 = (float) (Double.isNaN(vVar.f18778p[i14]) ? 0.0d : vVar.f18778p[i14] + 0.0d);
                        float f30 = (float) vVar.f18779q[i14];
                        if (i14 == i10) {
                            f26 = f30;
                            f21 = f13;
                            f18 = f29;
                        } else if (i14 == 2) {
                            f25 = f30;
                            f18 = f15;
                            f21 = f13;
                            f23 = f29;
                        } else if (i14 == 3) {
                            f27 = f30;
                            f18 = f15;
                            f21 = f13;
                            f24 = f29;
                        } else if (i14 == 4) {
                            f28 = f30;
                            f18 = f15;
                            f21 = f29;
                        } else if (i14 == 5) {
                            f18 = f15;
                            f21 = f13;
                            f22 = f29;
                        }
                        i14++;
                        i10 = 1;
                    }
                    f18 = f15;
                    f21 = f13;
                    i14++;
                    i10 = 1;
                }
                float f31 = f18;
                n nVar4 = vVar.f18775m;
                if (nVar4 != null) {
                    float[] fArr = new float[2];
                    float[] fArr2 = new float[2];
                    nVar4.c(d8, fArr, fArr2);
                    float f32 = fArr[0];
                    float f33 = fArr[1];
                    float f34 = fArr2[0];
                    float f35 = fArr2[1];
                    z8 = z5;
                    d5 = d8;
                    double d10 = f32;
                    double d11 = f31;
                    double d12 = f23;
                    float sin = (float) (((Math.sin(d12) * d11) + d10) - (f24 / 2.0f));
                    float cos = (float) ((f33 - (Math.cos(d12) * d11)) - (f13 / 2.0f));
                    double d13 = f26;
                    double sin2 = Math.sin(d12) * d13;
                    double cos2 = Math.cos(d12) * d11;
                    double d14 = f25;
                    float f36 = (float) ((cos2 * d14) + sin2 + f34);
                    float sin3 = (float) ((Math.sin(d12) * d11 * d14) + (f35 - (Math.cos(d12) * d13)));
                    if (dArr3.length >= 2) {
                        dArr3[0] = f36;
                        dArr3[1] = sin3;
                    }
                    if (!Float.isNaN(f22)) {
                        view.setRotation((float) (Math.toDegrees(Math.atan2(sin3, f36)) + f22));
                    }
                    f14 = sin;
                    f23 = cos;
                } else {
                    z8 = z5;
                    d5 = d8;
                    if (!Float.isNaN(f22)) {
                        view.setRotation((float) (Math.toDegrees(Math.atan2((f28 / 2.0f) + f25, (f27 / 2.0f) + f26)) + f22 + 0.0f));
                    }
                    f14 = f31;
                }
                if (view instanceof b) {
                    ((MotionLabel) ((b) view)).c(f14, f23, f14 + f24, f23 + f13);
                } else {
                    float f37 = f14 + 0.5f;
                    int i15 = (int) f37;
                    float f38 = f23 + 0.5f;
                    int i16 = (int) f38;
                    int i17 = (int) (f37 + f24);
                    int i18 = (int) (f38 + f13);
                    int i19 = i17 - i15;
                    int i20 = i18 - i16;
                    if (i19 != view.getMeasuredWidth() || i20 != view.getMeasuredHeight() || z10) {
                        view.measure(View.MeasureSpec.makeMeasureSpec(i19, 1073741824), View.MeasureSpec.makeMeasureSpec(i20, 1073741824));
                    }
                    view.layout(i15, i16, i17, i18);
                }
                this.f18716d = false;
            }
            if (this.B != -1) {
                if (this.C == null) {
                    this.C = ((View) view.getParent()).findViewById(this.B);
                }
                if (this.C != null) {
                    float bottom = (this.C.getBottom() + r1.getTop()) / f11;
                    float right = (this.C.getRight() + this.C.getLeft()) / f11;
                    if (view.getRight() - view.getLeft() > 0 && view.getBottom() - view.getTop() > 0) {
                        view.setPivotX(right - view.getLeft());
                        view.setPivotY(bottom - view.getTop());
                    }
                }
            }
            HashMap hashMap3 = this.f18735y;
            if (hashMap3 != null) {
                for (t0.k kVar : hashMap3.values()) {
                    if (kVar instanceof t0.i) {
                        double[] dArr6 = this.f18728q;
                        if (dArr6.length > 1) {
                            view.setRotation(((t0.i) kVar).a(b3) + ((float) Math.toDegrees(Math.atan2(dArr6[1], dArr6[0]))));
                        }
                    }
                }
            }
            if (nVar != null) {
                double[] dArr7 = this.f18728q;
                double d15 = dArr7[0];
                double d16 = dArr7[1];
                t0.n nVar5 = nVar;
                view.setRotation(nVar5.a(b3, j4, view, eVar) + ((float) Math.toDegrees(Math.atan2(d16, d15))));
                z6 = z8 | nVar5.f18465d;
            } else {
                z6 = z8;
            }
            int i21 = 1;
            while (true) {
                pf[] pfVarArr2 = this.f18721j;
                if (i21 >= pfVarArr2.length) {
                    break;
                }
                pf pfVar = pfVarArr2[i21];
                float[] fArr3 = this.f18730t;
                pfVar.d(d5, fArr3);
                ((w0.b) vVar.f18776n.get(this.r[i21 - 1])).g(view, fArr3);
                i21++;
            }
            l lVar = this.f18719h;
            if (lVar.f18696b == 0) {
                if (b3 <= 0.0f) {
                    view.setVisibility(lVar.f18697c);
                } else {
                    l lVar2 = this.f18720i;
                    if (b3 >= f10) {
                        view.setVisibility(lVar2.f18697c);
                    } else if (lVar2.f18697c != lVar.f18697c) {
                        view.setVisibility(0);
                    }
                }
            }
        } else {
            boolean z11 = z5;
            float f39 = vVar.e;
            v vVar2 = this.f18718g;
            float a3 = l0.a(vVar2.e, f39, b3, f39);
            float f40 = vVar.f18768f;
            float a10 = l0.a(vVar2.f18768f, f40, b3, f40);
            float f41 = vVar.f18769g;
            float f42 = vVar2.f18769g;
            float a11 = l0.a(f42, f41, b3, f41);
            float f43 = vVar.f18770h;
            float f44 = vVar2.f18770h;
            float f45 = a3 + 0.5f;
            int i22 = (int) f45;
            float f46 = a10 + 0.5f;
            int i23 = (int) f46;
            int i24 = (int) (f45 + a11);
            int a12 = (int) (f46 + l0.a(f44, f43, b3, f43));
            int i25 = i24 - i22;
            int i26 = a12 - i23;
            if (f42 != f41 || f44 != f43 || this.f18716d) {
                view.measure(View.MeasureSpec.makeMeasureSpec(i25, 1073741824), View.MeasureSpec.makeMeasureSpec(i26, 1073741824));
                this.f18716d = false;
            }
            view.layout(i22, i23, i24, a12);
            z6 = z11;
        }
        HashMap hashMap4 = this.f18736z;
        if (hashMap4 != null) {
            for (t0.f fVar : hashMap4.values()) {
                if (fVar instanceof t0.d) {
                    double[] dArr8 = this.f18728q;
                    view.setRotation(((t0.d) fVar).a(b3) + ((float) Math.toDegrees(Math.atan2(dArr8[1], dArr8[0]))));
                } else {
                    fVar.c(view, b3);
                }
            }
        }
        return z6;
    }

    public final void f(v vVar) {
        vVar.d((int) this.f18714b.getX(), (int) this.f18714b.getY(), this.f18714b.getWidth(), this.f18714b.getHeight());
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to find 'out' block for switch in B:352:0x0b05. Please report as an issue. */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:347:0x0b95  */
    /* JADX WARN: Removed duplicated region for block: B:573:0x1200  */
    /* JADX WARN: Removed duplicated region for block: B:576:0x11ef A[SYNTHETIC] */
    /* JADX WARN: Type inference failed for: r12v112, types: [t0.j, t0.k] */
    /* JADX WARN: Type inference failed for: r12v120, types: [t0.k] */
    /* JADX WARN: Type inference failed for: r12v24, types: [t0.e, t0.f] */
    /* JADX WARN: Type inference failed for: r12v30, types: [t0.f] */
    /* JADX WARN: Type inference failed for: r2v84, types: [t0.m, t0.p] */
    /* JADX WARN: Type inference failed for: r3v46, types: [t0.h, t0.k] */
    /* JADX WARN: Type inference failed for: r4v58, types: [t0.c, t0.f] */
    /* JADX WARN: Type inference failed for: r6v77, types: [t0.o, t0.p] */
    /* JADX WARN: Type inference failed for: r6v82, types: [t0.p] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void h(int r52, int r53, long r54) {
        /*
            Method dump skipped, instructions count: 4936
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: u0.n.h(int, int, long):void");
    }

    public final String toString() {
        v vVar = this.f18717f;
        float f2 = vVar.e;
        float f10 = vVar.f18768f;
        v vVar2 = this.f18718g;
        float f11 = vVar2.e;
        float f12 = vVar2.f18768f;
        StringBuilder sb2 = new StringBuilder(88);
        sb2.append(" start: x: ");
        sb2.append(f2);
        sb2.append(" y: ");
        sb2.append(f10);
        sb2.append(" end: x: ");
        sb2.append(f11);
        sb2.append(" y: ");
        sb2.append(f12);
        return sb2.toString();
    }
}
