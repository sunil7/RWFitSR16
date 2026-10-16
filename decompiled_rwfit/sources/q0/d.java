package q0;

import androidx.constraintlayout.core.SolverVariable$Type;
import androidx.constraintlayout.core.widgets.ConstraintAnchor$Type;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: b, reason: collision with root package name */
    public int f17635b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f17636c;

    /* renamed from: d, reason: collision with root package name */
    public final f f17637d;
    public final ConstraintAnchor$Type e;

    /* renamed from: f, reason: collision with root package name */
    public d f17638f;

    /* renamed from: i, reason: collision with root package name */
    public o0.e f17641i;

    /* renamed from: a, reason: collision with root package name */
    public HashSet f17634a = null;

    /* renamed from: g, reason: collision with root package name */
    public int f17639g = 0;

    /* renamed from: h, reason: collision with root package name */
    public int f17640h = Integer.MIN_VALUE;

    public d(f fVar, ConstraintAnchor$Type constraintAnchor$Type) {
        this.f17637d = fVar;
        this.e = constraintAnchor$Type;
    }

    public final void a(d dVar, int i3) {
        b(dVar, i3, Integer.MIN_VALUE, false);
    }

    public final boolean b(d dVar, int i3, int i10, boolean z5) {
        if (dVar == null) {
            j();
            return true;
        }
        if (!z5 && !i(dVar)) {
            return false;
        }
        this.f17638f = dVar;
        if (dVar.f17634a == null) {
            dVar.f17634a = new HashSet();
        }
        HashSet hashSet = this.f17638f.f17634a;
        if (hashSet != null) {
            hashSet.add(this);
        }
        this.f17639g = i3;
        this.f17640h = i10;
        return true;
    }

    public final void c(int i3, ArrayList arrayList, r0.i iVar) {
        HashSet hashSet = this.f17634a;
        if (hashSet != null) {
            Iterator it = hashSet.iterator();
            while (it.hasNext()) {
                r0.f.b(((d) it.next()).f17637d, i3, arrayList, iVar);
            }
        }
    }

    public final int d() {
        if (this.f17636c) {
            return this.f17635b;
        }
        return 0;
    }

    public final int e() {
        d dVar;
        if (this.f17637d.f17658h0 == 8) {
            return 0;
        }
        int i3 = this.f17640h;
        return (i3 == Integer.MIN_VALUE || (dVar = this.f17638f) == null || dVar.f17637d.f17658h0 != 8) ? this.f17639g : i3;
    }

    public final d f() {
        int[] iArr = c.f17633a;
        ConstraintAnchor$Type constraintAnchor$Type = this.e;
        int i3 = iArr[constraintAnchor$Type.ordinal()];
        f fVar = this.f17637d;
        switch (i3) {
            case 1:
            case 6:
            case 7:
            case 8:
            case 9:
                return null;
            case 2:
                return fVar.K;
            case 3:
                return fVar.I;
            case 4:
                return fVar.L;
            case 5:
                return fVar.J;
            default:
                throw new AssertionError(constraintAnchor$Type.name());
        }
    }

    public final boolean g() {
        HashSet hashSet = this.f17634a;
        if (hashSet == null) {
            return false;
        }
        Iterator it = hashSet.iterator();
        while (it.hasNext()) {
            if (((d) it.next()).f().h()) {
                return true;
            }
        }
        return false;
    }

    public final boolean h() {
        return this.f17638f != null;
    }

    public final boolean i(d dVar) {
        if (dVar == null) {
            return false;
        }
        ConstraintAnchor$Type constraintAnchor$Type = this.e;
        f fVar = dVar.f17637d;
        ConstraintAnchor$Type constraintAnchor$Type2 = dVar.e;
        if (constraintAnchor$Type2 == constraintAnchor$Type) {
            return constraintAnchor$Type != ConstraintAnchor$Type.BASELINE || (fVar.D && this.f17637d.D);
        }
        switch (c.f17633a[constraintAnchor$Type.ordinal()]) {
            case 1:
                return (constraintAnchor$Type2 == ConstraintAnchor$Type.BASELINE || constraintAnchor$Type2 == ConstraintAnchor$Type.CENTER_X || constraintAnchor$Type2 == ConstraintAnchor$Type.CENTER_Y) ? false : true;
            case 2:
            case 3:
                boolean z5 = constraintAnchor$Type2 == ConstraintAnchor$Type.LEFT || constraintAnchor$Type2 == ConstraintAnchor$Type.RIGHT;
                return fVar instanceof k ? z5 || constraintAnchor$Type2 == ConstraintAnchor$Type.CENTER_X : z5;
            case 4:
            case 5:
                boolean z6 = constraintAnchor$Type2 == ConstraintAnchor$Type.TOP || constraintAnchor$Type2 == ConstraintAnchor$Type.BOTTOM;
                return fVar instanceof k ? z6 || constraintAnchor$Type2 == ConstraintAnchor$Type.CENTER_Y : z6;
            case 6:
                return (constraintAnchor$Type2 == ConstraintAnchor$Type.LEFT || constraintAnchor$Type2 == ConstraintAnchor$Type.RIGHT) ? false : true;
            case 7:
            case 8:
            case 9:
                return false;
            default:
                throw new AssertionError(constraintAnchor$Type.name());
        }
    }

    public final void j() {
        HashSet hashSet;
        d dVar = this.f17638f;
        if (dVar != null && (hashSet = dVar.f17634a) != null) {
            hashSet.remove(this);
            if (this.f17638f.f17634a.size() == 0) {
                this.f17638f.f17634a = null;
            }
        }
        this.f17634a = null;
        this.f17638f = null;
        this.f17639g = 0;
        this.f17640h = Integer.MIN_VALUE;
        this.f17636c = false;
        this.f17635b = 0;
    }

    public final void k() {
        o0.e eVar = this.f17641i;
        if (eVar == null) {
            this.f17641i = new o0.e(SolverVariable$Type.UNRESTRICTED);
        } else {
            eVar.c();
        }
    }

    public final void l(int i3) {
        this.f17635b = i3;
        this.f17636c = true;
    }

    public final String toString() {
        return this.f17637d.i0 + ":" + this.e.toString();
    }
}
