package j2;

import android.util.AndroidRuntimeException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class j0 extends f0 {

    /* renamed from: z, reason: collision with root package name */
    public int f15242z;

    /* renamed from: x, reason: collision with root package name */
    public ArrayList f15240x = new ArrayList();

    /* renamed from: y, reason: collision with root package name */
    public boolean f15241y = true;
    public boolean A = false;
    public int B = 0;

    @Override // j2.f0
    public final void B(r rVar) {
        this.f15222s = rVar;
        this.B |= 8;
        int size = this.f15240x.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((f0) this.f15240x.get(i3)).B(rVar);
        }
    }

    @Override // j2.f0
    public final void D(hc.a aVar) {
        super.D(aVar);
        this.B |= 4;
        if (this.f15240x != null) {
            for (int i3 = 0; i3 < this.f15240x.size(); i3++) {
                ((f0) this.f15240x.get(i3)).D(aVar);
            }
        }
    }

    @Override // j2.f0
    public final void E() {
        this.B |= 2;
        int size = this.f15240x.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((f0) this.f15240x.get(i3)).E();
        }
    }

    @Override // j2.f0
    public final void F(long j4) {
        this.f15207b = j4;
    }

    @Override // j2.f0
    public final String H(String str) {
        String H = super.H(str);
        for (int i3 = 0; i3 < this.f15240x.size(); i3++) {
            StringBuilder u10 = com.google.android.gms.internal.mlkit_vision_barcode.l0.u(H, "\n");
            u10.append(((f0) this.f15240x.get(i3)).H(str + "  "));
            H = u10.toString();
        }
        return H;
    }

    public final void I(f0 f0Var) {
        this.f15240x.add(f0Var);
        f0Var.f15213i = this;
        long j4 = this.f15208c;
        if (j4 >= 0) {
            f0Var.A(j4);
        }
        if ((this.B & 1) != 0) {
            f0Var.C(this.f15209d);
        }
        if ((this.B & 2) != 0) {
            f0Var.E();
        }
        if ((this.B & 4) != 0) {
            f0Var.D(this.f15223t);
        }
        if ((this.B & 8) != 0) {
            f0Var.B(this.f15222s);
        }
    }

    @Override // j2.f0
    /* renamed from: J, reason: merged with bridge method [inline-methods] */
    public final void A(long j4) {
        ArrayList arrayList;
        this.f15208c = j4;
        if (j4 < 0 || (arrayList = this.f15240x) == null) {
            return;
        }
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((f0) this.f15240x.get(i3)).A(j4);
        }
    }

    @Override // j2.f0
    /* renamed from: K, reason: merged with bridge method [inline-methods] */
    public final void C(Interpolator interpolator) {
        this.B |= 1;
        ArrayList arrayList = this.f15240x;
        if (arrayList != null) {
            int size = arrayList.size();
            for (int i3 = 0; i3 < size; i3++) {
                ((f0) this.f15240x.get(i3)).C(interpolator);
            }
        }
        this.f15209d = interpolator;
    }

    public final void L(int i3) {
        if (i3 == 0) {
            this.f15241y = true;
        } else {
            if (i3 != 1) {
                throw new AndroidRuntimeException(com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "Invalid parameter for TransitionSet ordering: "));
            }
            this.f15241y = false;
        }
    }

    @Override // j2.f0
    public final void b(View view) {
        for (int i3 = 0; i3 < this.f15240x.size(); i3++) {
            ((f0) this.f15240x.get(i3)).b(view);
        }
        this.f15210f.add(view);
    }

    @Override // j2.f0
    public final void cancel() {
        super.cancel();
        int size = this.f15240x.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((f0) this.f15240x.get(i3)).cancel();
        }
    }

    @Override // j2.f0
    public final void d(m0 m0Var) {
        if (t(m0Var.f15264b)) {
            ArrayList arrayList = this.f15240x;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                f0 f0Var = (f0) obj;
                if (f0Var.t(m0Var.f15264b)) {
                    f0Var.d(m0Var);
                    m0Var.f15265c.add(f0Var);
                }
            }
        }
    }

    @Override // j2.f0
    public final void f(m0 m0Var) {
        int size = this.f15240x.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((f0) this.f15240x.get(i3)).f(m0Var);
        }
    }

    @Override // j2.f0
    public final void g(m0 m0Var) {
        if (t(m0Var.f15264b)) {
            ArrayList arrayList = this.f15240x;
            int size = arrayList.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = arrayList.get(i3);
                i3++;
                f0 f0Var = (f0) obj;
                if (f0Var.t(m0Var.f15264b)) {
                    f0Var.g(m0Var);
                    m0Var.f15265c.add(f0Var);
                }
            }
        }
    }

    @Override // j2.f0
    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final f0 clone() {
        j0 j0Var = (j0) super.clone();
        j0Var.f15240x = new ArrayList();
        int size = this.f15240x.size();
        for (int i3 = 0; i3 < size; i3++) {
            f0 clone = ((f0) this.f15240x.get(i3)).clone();
            j0Var.f15240x.add(clone);
            clone.f15213i = j0Var;
        }
        return j0Var;
    }

    @Override // j2.f0
    public final void l(ViewGroup viewGroup, v2.h hVar, v2.h hVar2, ArrayList arrayList, ArrayList arrayList2) {
        long j4 = this.f15207b;
        int size = this.f15240x.size();
        for (int i3 = 0; i3 < size; i3++) {
            f0 f0Var = (f0) this.f15240x.get(i3);
            if (j4 > 0 && (this.f15241y || i3 == 0)) {
                long j10 = f0Var.f15207b;
                if (j10 > 0) {
                    f0Var.F(j10 + j4);
                } else {
                    f0Var.F(j4);
                }
            }
            f0Var.l(viewGroup, hVar, hVar2, arrayList, arrayList2);
        }
    }

    @Override // j2.f0
    public final void n(ViewGroup viewGroup) {
        super.n(viewGroup);
        int size = this.f15240x.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((f0) this.f15240x.get(i3)).n(viewGroup);
        }
    }

    @Override // j2.f0
    public final void v(ViewGroup viewGroup) {
        super.v(viewGroup);
        int size = this.f15240x.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((f0) this.f15240x.get(i3)).v(viewGroup);
        }
    }

    @Override // j2.f0
    public final void x(View view) {
        for (int i3 = 0; i3 < this.f15240x.size(); i3++) {
            ((f0) this.f15240x.get(i3)).x(view);
        }
        this.f15210f.remove(view);
    }

    @Override // j2.f0
    public final void y(View view) {
        super.y(view);
        int size = this.f15240x.size();
        for (int i3 = 0; i3 < size; i3++) {
            ((f0) this.f15240x.get(i3)).y(view);
        }
    }

    @Override // j2.f0
    public final void z() {
        if (this.f15240x.isEmpty()) {
            G();
            m();
            return;
        }
        com.dh.imagepick.preview.utils.c cVar = new com.dh.imagepick.preview.utils.c();
        cVar.f7151b = this;
        ArrayList arrayList = this.f15240x;
        int size = arrayList.size();
        int i3 = 0;
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            ((f0) obj).a(cVar);
        }
        this.f15242z = this.f15240x.size();
        if (this.f15241y) {
            ArrayList arrayList2 = this.f15240x;
            int size2 = arrayList2.size();
            while (i3 < size2) {
                Object obj2 = arrayList2.get(i3);
                i3++;
                ((f0) obj2).z();
            }
            return;
        }
        for (int i11 = 1; i11 < this.f15240x.size(); i11++) {
            ((f0) this.f15240x.get(i11 - 1)).a(new com.dh.imagepick.preview.utils.c((f0) this.f15240x.get(i11), 2));
        }
        f0 f0Var = (f0) this.f15240x.get(0);
        if (f0Var != null) {
            f0Var.z();
        }
    }
}
