package androidx.constraintlayout.core.widgets.analyzer;

import androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour;
import r0.j;

/* loaded from: classes.dex */
public abstract class h implements r0.d {

    /* renamed from: a, reason: collision with root package name */
    public int f1631a;

    /* renamed from: b, reason: collision with root package name */
    public q0.f f1632b;

    /* renamed from: c, reason: collision with root package name */
    public r0.h f1633c;

    /* renamed from: d, reason: collision with root package name */
    public ConstraintWidget$DimensionBehaviour f1634d;
    public final b e = new b(this);

    /* renamed from: f, reason: collision with root package name */
    public int f1635f = 0;

    /* renamed from: g, reason: collision with root package name */
    public boolean f1636g = false;

    /* renamed from: h, reason: collision with root package name */
    public final a f1637h = new a(this);

    /* renamed from: i, reason: collision with root package name */
    public final a f1638i = new a(this);

    /* renamed from: j, reason: collision with root package name */
    public WidgetRun$RunType f1639j = WidgetRun$RunType.NONE;

    public h(q0.f fVar) {
        this.f1632b = fVar;
    }

    public static void b(a aVar, a aVar2, int i3) {
        aVar.f1624l.add(aVar2);
        aVar.f1618f = i3;
        aVar2.f1623k.add(aVar);
    }

    public static a h(q0.d dVar) {
        q0.d dVar2 = dVar.f17638f;
        if (dVar2 == null) {
            return null;
        }
        int i3 = j.f17984a[dVar2.e.ordinal()];
        q0.f fVar = dVar2.f17637d;
        if (i3 == 1) {
            return fVar.f17650d.f1637h;
        }
        if (i3 == 2) {
            return fVar.f17650d.f1638i;
        }
        if (i3 == 3) {
            return fVar.e.f1637h;
        }
        if (i3 == 4) {
            return fVar.e.f1629k;
        }
        if (i3 != 5) {
            return null;
        }
        return fVar.e.f1638i;
    }

    public static a i(q0.d dVar, int i3) {
        q0.d dVar2 = dVar.f17638f;
        if (dVar2 == null) {
            return null;
        }
        q0.f fVar = dVar2.f17637d;
        h hVar = i3 == 0 ? fVar.f17650d : fVar.e;
        int i10 = j.f17984a[dVar2.e.ordinal()];
        if (i10 != 1) {
            if (i10 != 2) {
                if (i10 != 3) {
                    if (i10 != 5) {
                        return null;
                    }
                }
            }
            return hVar.f1638i;
        }
        return hVar.f1637h;
    }

    public final void c(a aVar, a aVar2, int i3, b bVar) {
        aVar.f1624l.add(aVar2);
        aVar.f1624l.add(this.e);
        aVar.f1620h = i3;
        aVar.f1621i = bVar;
        aVar2.f1623k.add(aVar);
        bVar.f1623k.add(aVar);
    }

    public abstract void d();

    public abstract void e();

    public abstract void f();

    public final int g(int i3, int i10) {
        if (i10 == 0) {
            q0.f fVar = this.f1632b;
            int i11 = fVar.f17679u;
            int max = Math.max(fVar.f17678t, i3);
            if (i11 > 0) {
                max = Math.min(i11, i3);
            }
            if (max != i3) {
                return max;
            }
        } else {
            q0.f fVar2 = this.f1632b;
            int i12 = fVar2.f17682x;
            int max2 = Math.max(fVar2.f17681w, i3);
            if (i12 > 0) {
                max2 = Math.min(i12, i3);
            }
            if (max2 != i3) {
                return max2;
            }
        }
        return i3;
    }

    public long j() {
        if (this.e.f1622j) {
            return r0.f1619g;
        }
        return 0L;
    }

    public abstract boolean k();

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0053, code lost:
    
        if (r10.f1631a == 3) goto L51;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void l(q0.d r13, q0.d r14, int r15) {
        /*
            Method dump skipped, instructions count: 234
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.core.widgets.analyzer.h.l(q0.d, q0.d, int):void");
    }
}
