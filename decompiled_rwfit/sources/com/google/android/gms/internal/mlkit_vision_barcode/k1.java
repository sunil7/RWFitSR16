package com.google.android.gms.internal.mlkit_vision_barcode;

/* loaded from: classes.dex */
public abstract class k1 {
    public static final void a(byte b3, int i3) {
        char[] cArr = y5.b.f20001a;
        byte b10 = (byte) (i3 & 255);
        if (!r5.b.k().f18054c) {
            x5.b.I0().F0((byte) -78);
            return;
        }
        x5.c b11 = x5.c.b();
        com.example.baselibrary.utils.b.o(com.example.baselibrary.utils.b.f7266d, "CmdHelper", "getControlSportCmdJL " + ((int) b10) + ' ' + ((int) b3));
        b11.g((byte) -78, new byte[]{6, 4, 0, b10, b3}, new boolean[0]);
    }
}
