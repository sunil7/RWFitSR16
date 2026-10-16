package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.mlkit.common.MlKitException;
import java.nio.ByteBuffer;

/* loaded from: classes.dex */
public abstract class mf {
    public static ByteBuffer a(nc.a aVar) {
        int i3;
        int i10 = aVar.e;
        if (i10 == -1) {
            q9.n.e(null);
            throw null;
        }
        if (i10 == 17) {
            ByteBuffer byteBuffer = aVar.f16459a;
            q9.n.e(byteBuffer);
            return byteBuffer;
        }
        if (i10 == 35) {
            q9.n.e(null);
            throw null;
        }
        if (i10 != 842094169) {
            throw new MlKitException("Unsupported image format", 13);
        }
        ByteBuffer byteBuffer2 = aVar.f16459a;
        q9.n.e(byteBuffer2);
        byteBuffer2.rewind();
        int limit = byteBuffer2.limit();
        int i11 = limit / 6;
        ByteBuffer allocateDirect = ByteBuffer.allocateDirect(limit);
        int i12 = 0;
        while (true) {
            i3 = i11 * 4;
            if (i12 >= i3) {
                break;
            }
            allocateDirect.put(i12, byteBuffer2.get(i12));
            i12++;
        }
        for (int i13 = 0; i13 < i11 + i11; i13++) {
            allocateDirect.put(i3 + i13, byteBuffer2.get((i13 / 2) + ((i13 % 2) * i11) + i3));
        }
        return allocateDirect;
    }
}
