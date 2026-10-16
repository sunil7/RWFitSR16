package o0;

import androidx.constraintlayout.core.SolverVariable$Type;
import java.util.ArrayList;
import n.l;

/* loaded from: classes.dex */
public class b {

    /* renamed from: d, reason: collision with root package name */
    public final a f16649d;

    /* renamed from: a, reason: collision with root package name */
    public e f16646a = null;

    /* renamed from: b, reason: collision with root package name */
    public float f16647b = 0.0f;

    /* renamed from: c, reason: collision with root package name */
    public final ArrayList f16648c = new ArrayList();
    public boolean e = false;

    public b(l lVar) {
        this.f16649d = new a(this, lVar);
    }

    public final void a(c cVar, int i3) {
        this.f16649d.g(cVar.j(i3), 1.0f);
        this.f16649d.g(cVar.j(i3), -1.0f);
    }

    public final void b(e eVar, e eVar2, e eVar3, int i3) {
        boolean z5 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z5 = true;
            }
            this.f16647b = i3;
        }
        if (z5) {
            this.f16649d.g(eVar, 1.0f);
            this.f16649d.g(eVar2, -1.0f);
            this.f16649d.g(eVar3, -1.0f);
        } else {
            this.f16649d.g(eVar, -1.0f);
            this.f16649d.g(eVar2, 1.0f);
            this.f16649d.g(eVar3, 1.0f);
        }
    }

    public final void c(e eVar, e eVar2, e eVar3, int i3) {
        boolean z5 = false;
        if (i3 != 0) {
            if (i3 < 0) {
                i3 *= -1;
                z5 = true;
            }
            this.f16647b = i3;
        }
        if (z5) {
            this.f16649d.g(eVar, 1.0f);
            this.f16649d.g(eVar2, -1.0f);
            this.f16649d.g(eVar3, 1.0f);
        } else {
            this.f16649d.g(eVar, -1.0f);
            this.f16649d.g(eVar2, 1.0f);
            this.f16649d.g(eVar3, -1.0f);
        }
    }

    public e d(boolean[] zArr) {
        return f(zArr, null);
    }

    public boolean e() {
        return this.f16646a == null && this.f16647b == 0.0f && this.f16649d.d() == 0;
    }

    public final e f(boolean[] zArr, e eVar) {
        SolverVariable$Type solverVariable$Type;
        int d5 = this.f16649d.d();
        e eVar2 = null;
        float f2 = 0.0f;
        for (int i3 = 0; i3 < d5; i3++) {
            float f10 = this.f16649d.f(i3);
            if (f10 < 0.0f) {
                e e = this.f16649d.e(i3);
                if ((zArr == null || !zArr[e.f16671b]) && e != eVar && (((solverVariable$Type = e.f16677i) == SolverVariable$Type.SLACK || solverVariable$Type == SolverVariable$Type.ERROR) && f10 < f2)) {
                    f2 = f10;
                    eVar2 = e;
                }
            }
        }
        return eVar2;
    }

    public final void g(e eVar) {
        e eVar2 = this.f16646a;
        if (eVar2 != null) {
            this.f16649d.g(eVar2, -1.0f);
            this.f16646a.f16672c = -1;
            this.f16646a = null;
        }
        float h4 = this.f16649d.h(eVar, true) * (-1.0f);
        this.f16646a = eVar;
        if (h4 == 1.0f) {
            return;
        }
        this.f16647b /= h4;
        a aVar = this.f16649d;
        int i3 = aVar.f16643h;
        for (int i10 = 0; i3 != -1 && i10 < aVar.f16637a; i10++) {
            float[] fArr = aVar.f16642g;
            fArr[i3] = fArr[i3] / h4;
            i3 = aVar.f16641f[i3];
        }
    }

    public final void h(c cVar, e eVar, boolean z5) {
        if (eVar == null || !eVar.f16674f) {
            return;
        }
        float c9 = this.f16649d.c(eVar);
        this.f16647b = (eVar.e * c9) + this.f16647b;
        this.f16649d.h(eVar, z5);
        if (z5) {
            eVar.b(this);
        }
        if (this.f16649d.d() == 0) {
            this.e = true;
            cVar.f16652a = true;
        }
    }

    public void i(c cVar, b bVar, boolean z5) {
        a aVar = this.f16649d;
        aVar.getClass();
        float c9 = aVar.c(bVar.f16646a);
        aVar.h(bVar.f16646a, z5);
        a aVar2 = bVar.f16649d;
        int d5 = aVar2.d();
        for (int i3 = 0; i3 < d5; i3++) {
            e e = aVar2.e(i3);
            aVar.a(e, aVar2.c(e) * c9, z5);
        }
        this.f16647b = (bVar.f16647b * c9) + this.f16647b;
        if (z5) {
            bVar.f16646a.b(this);
        }
        if (this.f16646a == null || this.f16649d.d() != 0) {
            return;
        }
        this.e = true;
        cVar.f16652a = true;
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0081  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r10 = this;
            o0.e r0 = r10.f16646a
            if (r0 != 0) goto L7
            java.lang.String r0 = "0"
            goto L17
        L7:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = ""
            r0.<init>(r1)
            o0.e r1 = r10.f16646a
            r0.append(r1)
            java.lang.String r0 = r0.toString()
        L17:
            java.lang.String r1 = " = "
            java.lang.String r0 = android.support.v4.media.session.e.l(r0, r1)
            float r1 = r10.f16647b
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            r3 = 1
            r4 = 0
            if (r1 == 0) goto L35
            java.lang.StringBuilder r0 = com.google.android.gms.internal.mlkit_vision_barcode.l0.t(r0)
            float r1 = r10.f16647b
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r1 = r3
            goto L36
        L35:
            r1 = r4
        L36:
            o0.a r5 = r10.f16649d
            int r5 = r5.d()
        L3c:
            if (r4 >= r5) goto L9c
            o0.a r6 = r10.f16649d
            o0.e r6 = r6.e(r4)
            if (r6 != 0) goto L47
            goto L99
        L47:
            o0.a r7 = r10.f16649d
            float r7 = r7.f(r4)
            int r8 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r8 != 0) goto L52
            goto L99
        L52:
            java.lang.String r6 = r6.toString()
            r9 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r1 != 0) goto L66
            int r1 = (r7 > r2 ? 1 : (r7 == r2 ? 0 : -1))
            if (r1 >= 0) goto L76
            java.lang.String r1 = "- "
            java.lang.String r0 = android.support.v4.media.session.e.l(r0, r1)
        L64:
            float r7 = r7 * r9
            goto L76
        L66:
            if (r8 <= 0) goto L6f
            java.lang.String r1 = " + "
            java.lang.String r0 = android.support.v4.media.session.e.l(r0, r1)
            goto L76
        L6f:
            java.lang.String r1 = " - "
            java.lang.String r0 = android.support.v4.media.session.e.l(r0, r1)
            goto L64
        L76:
            r1 = 1065353216(0x3f800000, float:1.0)
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 != 0) goto L81
            java.lang.String r0 = android.support.v4.media.session.e.l(r0, r6)
            goto L98
        L81:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            r1.append(r7)
            java.lang.String r0 = " "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = r1.toString()
        L98:
            r1 = r3
        L99:
            int r4 = r4 + 1
            goto L3c
        L9c:
            if (r1 != 0) goto La4
            java.lang.String r1 = "0.0"
            java.lang.String r0 = android.support.v4.media.session.e.l(r0, r1)
        La4:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: o0.b.toString():java.lang.String");
    }
}
