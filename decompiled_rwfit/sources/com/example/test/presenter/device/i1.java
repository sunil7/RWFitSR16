package com.example.test.presenter.device;

/* loaded from: classes.dex */
public final class i1 extends com.example.baselibrary.preseneter.b {
    public static void k(int i3) {
        if (y5.d.f20005b) {
            if (!r5.b.k().f18054c) {
                x5.b.I0().F0((byte) -7);
                return;
            }
            x5.c b3 = x5.c.b();
            com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "getTakePhotoCmdJL "));
            char[] cArr = y5.b.f20001a;
            b3.g((byte) -7, new byte[]{6, 1, 0, (byte) (i3 & 255)}, new boolean[0]);
            return;
        }
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) 64);
            return;
        }
        x5.d c9 = x5.d.c();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", com.google.android.gms.internal.mlkit_vision_barcode.l0.j(i3, "getTakePhotoCmd switchType "));
        char[] cArr2 = y5.b.f20001a;
        c9.j((byte) 64, new byte[]{(byte) (i3 & 255)});
    }

    @Override // com.example.baselibrary.preseneter.b
    public final void i() {
    }
}
