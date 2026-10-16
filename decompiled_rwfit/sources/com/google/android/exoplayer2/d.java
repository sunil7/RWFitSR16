package com.google.android.exoplayer2;

import com.google.android.gms.internal.mlkit_vision_barcode.ia;

/* loaded from: classes.dex */
public final class d implements c {
    public final void a(p pVar) {
        int a3;
        int a10;
        r rVar = (r) pVar;
        if (rVar.x().g() || rVar.b()) {
            return;
        }
        ia x10 = rVar.x();
        if (x10.g()) {
            a3 = -1;
        } else {
            int D = rVar.D();
            int v6 = rVar.v();
            if (v6 == 1) {
                v6 = 0;
            }
            a3 = x10.a(D, v6, rVar.A());
        }
        if (!(a3 != -1)) {
            if (rVar.L()) {
                ia x11 = rVar.x();
                if (x11.g()) {
                    return;
                }
                x11.d(rVar.D(), null, 0L).getClass();
                return;
            }
            return;
        }
        ia x12 = rVar.x();
        if (x12.g()) {
            a10 = -1;
        } else {
            int D2 = rVar.D();
            int v9 = rVar.v();
            a10 = x12.a(D2, v9 != 1 ? v9 : 0, rVar.A());
        }
        if (a10 != -1) {
            rVar.f(a10, -9223372036854775807L);
        }
    }

    public final void b(p pVar) {
        int c9;
        int c10;
        int c11;
        r rVar = (r) pVar;
        if (rVar.x().g() || rVar.b()) {
            return;
        }
        ia x10 = rVar.x();
        if (x10.g()) {
            c9 = -1;
        } else {
            int D = rVar.D();
            int v6 = rVar.v();
            if (v6 == 1) {
                v6 = 0;
            }
            c9 = x10.c(D, v6, rVar.A());
        }
        boolean z5 = c9 != -1;
        if (rVar.L() && !rVar.M()) {
            if (z5) {
                ia x11 = rVar.x();
                if (x11.g()) {
                    c11 = -1;
                } else {
                    int D2 = rVar.D();
                    int v9 = rVar.v();
                    c11 = x11.c(D2, v9 != 1 ? v9 : 0, rVar.A());
                }
                if (c11 != -1) {
                    rVar.f(c11, -9223372036854775807L);
                    return;
                }
                return;
            }
            return;
        }
        if (z5) {
            long H = rVar.H();
            rVar.j();
            if (H <= 3000) {
                ia x12 = rVar.x();
                if (x12.g()) {
                    c10 = -1;
                } else {
                    int D3 = rVar.D();
                    int v10 = rVar.v();
                    c10 = x12.c(D3, v10 != 1 ? v10 : 0, rVar.A());
                }
                if (c10 != -1) {
                    rVar.f(c10, -9223372036854775807L);
                    return;
                }
                return;
            }
        }
        rVar.f(rVar.D(), 0L);
    }
}
