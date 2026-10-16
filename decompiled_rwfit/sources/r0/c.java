package r0;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.util.ArrayList;

/* loaded from: classes.dex */
public final class c extends androidx.constraintlayout.core.widgets.analyzer.h {

    /* renamed from: k, reason: collision with root package name */
    public final ArrayList f17967k;

    /* renamed from: l, reason: collision with root package name */
    public int f17968l;

    public c(q0.f fVar, int i3) {
        super(fVar);
        q0.f fVar2;
        this.f17967k = new ArrayList();
        this.f1635f = i3;
        q0.f fVar3 = this.f1632b;
        q0.f n4 = fVar3.n(i3);
        while (true) {
            q0.f fVar4 = n4;
            fVar2 = fVar3;
            fVar3 = fVar4;
            if (fVar3 == null) {
                break;
            } else {
                n4 = fVar3.n(this.f1635f);
            }
        }
        this.f1632b = fVar2;
        int i10 = this.f1635f;
        d dVar = i10 == 0 ? fVar2.f17650d : i10 == 1 ? fVar2.e : null;
        ArrayList arrayList = this.f17967k;
        arrayList.add(dVar);
        q0.f m10 = fVar2.m(this.f1635f);
        while (m10 != null) {
            int i11 = this.f1635f;
            arrayList.add(i11 == 0 ? m10.f17650d : i11 == 1 ? m10.e : null);
            m10 = m10.m(this.f1635f);
        }
        int size = arrayList.size();
        int i12 = 0;
        while (i12 < size) {
            Object obj = arrayList.get(i12);
            i12++;
            androidx.constraintlayout.core.widgets.analyzer.h hVar = (androidx.constraintlayout.core.widgets.analyzer.h) obj;
            int i13 = this.f1635f;
            if (i13 == 0) {
                hVar.f1632b.f17646b = this;
            } else if (i13 == 1) {
                hVar.f1632b.f17648c = this;
            }
        }
        if (this.f1635f == 0 && ((q0.g) this.f1632b.U).f17690x0 && arrayList.size() > 1) {
            this.f1632b = ((androidx.constraintlayout.core.widgets.analyzer.h) l0.h(1, arrayList)).f1632b;
        }
        this.f17968l = this.f1635f == 0 ? this.f1632b.f17661j0 : this.f1632b.f17663k0;
    }

    /* JADX WARN: Code restructure failed: missing block: B:289:0x03a1, code lost:
    
        r2 = r2 - r12;
     */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00de  */
    @Override // r0.d
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(r0.d r27) {
        /*
            Method dump skipped, instructions count: 960
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: r0.c.a(r0.d):void");
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void d() {
        ArrayList arrayList = this.f17967k;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((androidx.constraintlayout.core.widgets.analyzer.h) obj).d();
        }
        int size2 = arrayList.size();
        if (size2 < 1) {
            return;
        }
        q0.f fVar = ((androidx.constraintlayout.core.widgets.analyzer.h) arrayList.get(0)).f1632b;
        q0.f fVar2 = ((androidx.constraintlayout.core.widgets.analyzer.h) arrayList.get(size2 - 1)).f1632b;
        int i10 = this.f1635f;
        androidx.constraintlayout.core.widgets.analyzer.a aVar = this.f1638i;
        androidx.constraintlayout.core.widgets.analyzer.a aVar2 = this.f1637h;
        if (i10 == 0) {
            q0.d dVar = fVar.I;
            q0.d dVar2 = fVar2.K;
            androidx.constraintlayout.core.widgets.analyzer.a i11 = androidx.constraintlayout.core.widgets.analyzer.h.i(dVar, 0);
            int e = dVar.e();
            q0.f m10 = m();
            if (m10 != null) {
                e = m10.I.e();
            }
            if (i11 != null) {
                androidx.constraintlayout.core.widgets.analyzer.h.b(aVar2, i11, e);
            }
            androidx.constraintlayout.core.widgets.analyzer.a i12 = androidx.constraintlayout.core.widgets.analyzer.h.i(dVar2, 0);
            int e10 = dVar2.e();
            q0.f n4 = n();
            if (n4 != null) {
                e10 = n4.K.e();
            }
            if (i12 != null) {
                androidx.constraintlayout.core.widgets.analyzer.h.b(aVar, i12, -e10);
            }
        } else {
            q0.d dVar3 = fVar.J;
            q0.d dVar4 = fVar2.L;
            androidx.constraintlayout.core.widgets.analyzer.a i13 = androidx.constraintlayout.core.widgets.analyzer.h.i(dVar3, 1);
            int e11 = dVar3.e();
            q0.f m11 = m();
            if (m11 != null) {
                e11 = m11.J.e();
            }
            if (i13 != null) {
                androidx.constraintlayout.core.widgets.analyzer.h.b(aVar2, i13, e11);
            }
            androidx.constraintlayout.core.widgets.analyzer.a i14 = androidx.constraintlayout.core.widgets.analyzer.h.i(dVar4, 1);
            int e12 = dVar4.e();
            q0.f n8 = n();
            if (n8 != null) {
                e12 = n8.L.e();
            }
            if (i14 != null) {
                androidx.constraintlayout.core.widgets.analyzer.h.b(aVar, i14, -e12);
            }
        }
        aVar2.f1614a = this;
        aVar.f1614a = this;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void e() {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f17967k;
            if (i3 >= arrayList.size()) {
                return;
            }
            ((androidx.constraintlayout.core.widgets.analyzer.h) arrayList.get(i3)).e();
            i3++;
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final void f() {
        this.f1633c = null;
        ArrayList arrayList = this.f17967k;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            ((androidx.constraintlayout.core.widgets.analyzer.h) obj).f();
        }
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final long j() {
        ArrayList arrayList = this.f17967k;
        int size = arrayList.size();
        long j4 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            j4 = r5.f1638i.f1618f + ((androidx.constraintlayout.core.widgets.analyzer.h) arrayList.get(i3)).j() + j4 + r5.f1637h.f1618f;
        }
        return j4;
    }

    @Override // androidx.constraintlayout.core.widgets.analyzer.h
    public final boolean k() {
        ArrayList arrayList = this.f17967k;
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!((androidx.constraintlayout.core.widgets.analyzer.h) arrayList.get(i3)).k()) {
                return false;
            }
        }
        return true;
    }

    public final q0.f m() {
        int i3 = 0;
        while (true) {
            ArrayList arrayList = this.f17967k;
            if (i3 >= arrayList.size()) {
                return null;
            }
            q0.f fVar = ((androidx.constraintlayout.core.widgets.analyzer.h) arrayList.get(i3)).f1632b;
            if (fVar.f17658h0 != 8) {
                return fVar;
            }
            i3++;
        }
    }

    public final q0.f n() {
        ArrayList arrayList = this.f17967k;
        for (int size = arrayList.size() - 1; size >= 0; size--) {
            q0.f fVar = ((androidx.constraintlayout.core.widgets.analyzer.h) arrayList.get(size)).f1632b;
            if (fVar.f17658h0 != 8) {
                return fVar;
            }
        }
        return null;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder("ChainRun ");
        sb2.append(this.f1635f == 0 ? "horizontal : " : "vertical : ");
        ArrayList arrayList = this.f17967k;
        int size = arrayList.size();
        int i3 = 0;
        while (i3 < size) {
            Object obj = arrayList.get(i3);
            i3++;
            sb2.append("<");
            sb2.append((androidx.constraintlayout.core.widgets.analyzer.h) obj);
            sb2.append("> ");
        }
        return sb2.toString();
    }
}
