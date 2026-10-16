package com.google.android.gms.internal.mlkit_vision_barcode;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.MappedByteBuffer;

/* loaded from: classes.dex */
public abstract class r0 {
    public static s1.b a(MappedByteBuffer mappedByteBuffer) {
        long j4;
        ByteBuffer duplicate = mappedByteBuffer.duplicate();
        duplicate.order(ByteOrder.BIG_ENDIAN);
        duplicate.position(duplicate.position() + 4);
        int i3 = duplicate.getShort() & 65535;
        if (i3 > 100) {
            throw new IOException("Cannot read metadata.");
        }
        duplicate.position(duplicate.position() + 6);
        int i10 = 0;
        while (true) {
            if (i10 >= i3) {
                j4 = -1;
                break;
            }
            int i11 = duplicate.getInt();
            duplicate.position(duplicate.position() + 4);
            j4 = duplicate.getInt() & 4294967295L;
            duplicate.position(duplicate.position() + 4);
            if (1835365473 == i11) {
                break;
            }
            i10++;
        }
        if (j4 != -1) {
            duplicate.position(duplicate.position() + ((int) (j4 - duplicate.position())));
            duplicate.position(duplicate.position() + 12);
            long j10 = duplicate.getInt() & 4294967295L;
            for (int i12 = 0; i12 < j10; i12++) {
                int i13 = duplicate.getInt();
                long j11 = duplicate.getInt() & 4294967295L;
                duplicate.getInt();
                if (1164798569 == i13 || 1701669481 == i13) {
                    duplicate.position((int) (j11 + j4));
                    s1.b bVar = new s1.b();
                    duplicate.order(ByteOrder.LITTLE_ENDIAN);
                    int position = duplicate.position() + duplicate.getInt(duplicate.position());
                    bVar.f15697d = duplicate;
                    bVar.f15694a = position;
                    int i14 = position - duplicate.getInt(position);
                    bVar.f15695b = i14;
                    bVar.f15696c = ((ByteBuffer) bVar.f15697d).getShort(i14);
                    return bVar;
                }
            }
        }
        throw new IOException("Cannot read metadata.");
    }
}
