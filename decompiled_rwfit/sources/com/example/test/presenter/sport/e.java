package com.example.test.presenter.sport;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;

/* loaded from: classes.dex */
public final class e extends com.example.baselibrary.preseneter.b {
    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }

    public final void k(int i3) {
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 57);
            return;
        }
        x5.c b3 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", l0.j(i3, "进入多运动 "));
        char[] cArr = y5.b.f20001a;
        b3.g((byte) 57, new byte[]{2, 116, 0, (byte) (i3 & 255)}, new boolean[0]);
    }
}
