package de;

import androidx.recyclerview.widget.x;

/* loaded from: classes.dex */
public final class r extends a2.h implements rd.d {
    @Override // rd.d
    public final void a(x xVar) {
        if (xVar == null) {
            return;
        }
        u(new d(1, xVar));
    }

    @Override // rd.d
    public final void d() {
        u(new b9.a(26));
    }

    @Override // rd.d
    public final void f(final float f2, final int i3) {
        u(new l() { // from class: de.q
            @Override // de.l
            public final void k(Object obj) {
                ((rd.d) obj).f(f2, i3);
            }
        });
    }

    @Override // rd.d
    public final void h() {
        u(new b9.a(25));
    }

    @Override // rd.d
    public final void s() {
        u(new b9.a(27));
    }

    @Override // rd.d
    public final void t(String str, boolean z5) {
        u(new p(str, z5));
    }
}
