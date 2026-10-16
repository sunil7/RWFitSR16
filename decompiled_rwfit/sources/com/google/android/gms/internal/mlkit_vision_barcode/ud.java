package com.google.android.gms.internal.mlkit_vision_barcode;

import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class ud {
    public static void a(t.a1 a1Var, byte[] bArr) {
        int i3;
        int i10;
        t.p0 p0Var = a1Var.f18423b;
        n6.a aVar = p0Var.o()[0];
        n6.a aVar2 = p0Var.o()[1];
        n6.a aVar3 = p0Var.o()[2];
        ByteBuffer S = aVar.S();
        ByteBuffer S2 = aVar2.S();
        ByteBuffer S3 = aVar3.S();
        S.rewind();
        S2.rewind();
        S3.rewind();
        int remaining = S.remaining();
        int i11 = 0;
        int i12 = 0;
        while (true) {
            i3 = a1Var.f18263f;
            i10 = a1Var.f18264g;
            if (i11 >= i10) {
                break;
            }
            S.get(bArr, i12, i3);
            i12 += i3;
            S.position(Math.min(remaining, aVar.U() + (S.position() - i3)));
            i11++;
        }
        int i13 = i10 / 2;
        int i14 = i3 / 2;
        int U = aVar3.U();
        int U2 = aVar2.U();
        int T = aVar3.T();
        int T2 = aVar2.T();
        byte[] bArr2 = new byte[U];
        byte[] bArr3 = new byte[U2];
        for (int i15 = 0; i15 < i13; i15++) {
            S3.get(bArr2, 0, Math.min(U, S3.remaining()));
            S2.get(bArr3, 0, Math.min(U2, S2.remaining()));
            int i16 = 0;
            int i17 = 0;
            for (int i18 = 0; i18 < i14; i18++) {
                int i19 = i12 + 1;
                bArr[i12] = bArr2[i16];
                i12 += 2;
                bArr[i19] = bArr3[i17];
                i16 += T;
                i17 += T2;
            }
        }
    }
}
