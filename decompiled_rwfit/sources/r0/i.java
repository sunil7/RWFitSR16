package r0;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import q0.m;

/* loaded from: classes.dex */
public final class i {

    /* renamed from: f, reason: collision with root package name */
    public static int f17979f;

    /* renamed from: a, reason: collision with root package name */
    public ArrayList f17980a;

    /* renamed from: b, reason: collision with root package name */
    public int f17981b;

    /* renamed from: c, reason: collision with root package name */
    public int f17982c;

    /* renamed from: d, reason: collision with root package name */
    public ArrayList f17983d;
    public int e;

    public final void a(ArrayList arrayList) {
        int size = this.f17980a.size();
        if (this.e != -1 && size > 0) {
            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                i iVar = (i) arrayList.get(i3);
                if (this.e == iVar.f17981b) {
                    c(this.f17982c, iVar);
                }
            }
        }
        if (size == 0) {
            arrayList.remove(this);
        }
    }

    public final int b(o0.c cVar, int i3) {
        int n4;
        int n8;
        ArrayList arrayList = this.f17980a;
        if (arrayList.size() == 0) {
            return 0;
        }
        q0.g gVar = (q0.g) ((q0.f) arrayList.get(0)).U;
        cVar.t();
        gVar.b(cVar, false);
        for (int i10 = 0; i10 < arrayList.size(); i10++) {
            ((q0.f) arrayList.get(i10)).b(cVar, false);
        }
        if (i3 == 0 && gVar.B0 > 0) {
            m.a(gVar, cVar, arrayList, 0);
        }
        if (i3 == 1 && gVar.C0 > 0) {
            m.a(gVar, cVar, arrayList, 1);
        }
        try {
            cVar.p();
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f17983d = new ArrayList();
        for (int i11 = 0; i11 < arrayList.size(); i11++) {
            q0.f fVar = (q0.f) arrayList.get(i11);
            eb.e eVar = new eb.e(19);
            new WeakReference(fVar);
            o0.c.n(fVar.I);
            o0.c.n(fVar.J);
            o0.c.n(fVar.K);
            o0.c.n(fVar.L);
            o0.c.n(fVar.M);
            this.f17983d.add(eVar);
        }
        if (i3 == 0) {
            n4 = o0.c.n(gVar.I);
            n8 = o0.c.n(gVar.K);
            cVar.t();
        } else {
            n4 = o0.c.n(gVar.J);
            n8 = o0.c.n(gVar.L);
            cVar.t();
        }
        return n8 - n4;
    }

    public final void c(int i3, i iVar) {
        ArrayList arrayList = this.f17980a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            q0.f fVar = (q0.f) obj;
            ArrayList arrayList2 = iVar.f17980a;
            if (!arrayList2.contains(fVar)) {
                arrayList2.add(fVar);
            }
            int i11 = iVar.f17981b;
            if (i3 == 0) {
                fVar.f17675q0 = i11;
            } else {
                fVar.f17676r0 = i11;
            }
        }
        this.e = iVar.f17981b;
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        int i3 = this.f17982c;
        sb2.append(i3 == 0 ? "Horizontal" : i3 == 1 ? "Vertical" : i3 == 2 ? "Both" : "Unknown");
        sb2.append(" [");
        String e = r5.a.e(sb2, this.f17981b, "] <");
        ArrayList arrayList = this.f17980a;
        int size = arrayList.size();
        int i10 = 0;
        while (i10 < size) {
            Object obj = arrayList.get(i10);
            i10++;
            StringBuilder u10 = l0.u(e, " ");
            u10.append(((q0.f) obj).i0);
            e = u10.toString();
        }
        return android.support.v4.media.session.e.l(e, " >");
    }
}
