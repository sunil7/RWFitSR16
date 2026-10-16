package sh;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public final class a extends rh.a {
    @Override // rh.a
    public final Random a() {
        ThreadLocalRandom current = ThreadLocalRandom.current();
        e.e(current, "current()");
        return current;
    }

    @Override // rh.c
    public final double nextDouble(double d5) {
        return ThreadLocalRandom.current().nextDouble(d5);
    }

    @Override // rh.c
    public final int nextInt(int i3, int i10) {
        return ThreadLocalRandom.current().nextInt(i3, i10);
    }

    @Override // rh.c
    public final long nextLong(long j4) {
        return ThreadLocalRandom.current().nextLong(j4);
    }

    @Override // rh.c
    public final long nextLong(long j4, long j10) {
        return ThreadLocalRandom.current().nextLong(j4, j10);
    }
}
