package rh;

import java.util.Random;
import kotlin.jvm.internal.e;

/* loaded from: classes2.dex */
public abstract class a extends c {
    public abstract Random a();

    @Override // rh.c
    public final int nextBits(int i3) {
        return ((-i3) >> 31) & (a().nextInt() >>> (32 - i3));
    }

    @Override // rh.c
    public final boolean nextBoolean() {
        return a().nextBoolean();
    }

    @Override // rh.c
    public final byte[] nextBytes(byte[] array) {
        e.f(array, "array");
        a().nextBytes(array);
        return array;
    }

    @Override // rh.c
    public final double nextDouble() {
        return a().nextDouble();
    }

    @Override // rh.c
    public final float nextFloat() {
        return a().nextFloat();
    }

    @Override // rh.c
    public final int nextInt() {
        return a().nextInt();
    }

    @Override // rh.c
    public final long nextLong() {
        return a().nextLong();
    }

    @Override // rh.c
    public final int nextInt(int i3) {
        return a().nextInt(i3);
    }
}
