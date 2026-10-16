package com.google.android.gms.internal.mlkit_vision_barcode;

import com.google.android.exoplayer2.Format;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes.dex */
public abstract class ed {
    public static void a(AtomicLong atomicLong, long j4) {
        long j10;
        long j11;
        do {
            j10 = atomicLong.get();
            j11 = Format.OFFSET_SAMPLE_RELATIVE;
            if (j10 == Format.OFFSET_SAMPLE_RELATIVE) {
                return;
            }
            long j12 = j10 + j4;
            if (j12 >= 0) {
                j11 = j12;
            }
        } while (!atomicLong.compareAndSet(j10, j11));
    }

    public static void b(AtomicLong atomicLong, long j4) {
        long j10;
        long j11;
        do {
            j10 = atomicLong.get();
            if (j10 == Format.OFFSET_SAMPLE_RELATIVE) {
                return;
            }
            j11 = j10 - j4;
            if (j11 < 0) {
                a1.b(new IllegalStateException(l0.l(j11, "More produced than requested: ")));
                j11 = 0;
            }
        } while (!atomicLong.compareAndSet(j10, j11));
    }
}
