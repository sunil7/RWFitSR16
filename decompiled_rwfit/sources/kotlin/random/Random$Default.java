package kotlin.random;

import java.io.Serializable;
import kotlin.jvm.internal.e;
import rh.c;

/* loaded from: classes2.dex */
public final class Random$Default extends c implements Serializable {

    public static final class Serialized implements Serializable {
        public static final Serialized INSTANCE = new Serialized();
        private static final long serialVersionUID = 0;

        private Serialized() {
        }

        private final Object readResolve() {
            return c.Default;
        }
    }

    public /* synthetic */ Random$Default(kotlin.jvm.internal.c cVar) {
        this();
    }

    private final Object writeReplace() {
        return Serialized.INSTANCE;
    }

    @Override // rh.c
    public int nextBits(int i3) {
        c cVar;
        cVar = c.f18144a;
        return cVar.nextBits(i3);
    }

    @Override // rh.c
    public boolean nextBoolean() {
        c cVar;
        cVar = c.f18144a;
        return cVar.nextBoolean();
    }

    @Override // rh.c
    public byte[] nextBytes(byte[] array) {
        c cVar;
        e.f(array, "array");
        cVar = c.f18144a;
        return cVar.nextBytes(array);
    }

    @Override // rh.c
    public double nextDouble() {
        c cVar;
        cVar = c.f18144a;
        return cVar.nextDouble();
    }

    @Override // rh.c
    public float nextFloat() {
        c cVar;
        cVar = c.f18144a;
        return cVar.nextFloat();
    }

    @Override // rh.c
    public int nextInt() {
        c cVar;
        cVar = c.f18144a;
        return cVar.nextInt();
    }

    @Override // rh.c
    public long nextLong() {
        c cVar;
        cVar = c.f18144a;
        return cVar.nextLong();
    }

    private Random$Default() {
    }

    @Override // rh.c
    public byte[] nextBytes(int i3) {
        c cVar;
        cVar = c.f18144a;
        return cVar.nextBytes(i3);
    }

    @Override // rh.c
    public double nextDouble(double d5) {
        c cVar;
        cVar = c.f18144a;
        return cVar.nextDouble(d5);
    }

    @Override // rh.c
    public int nextInt(int i3) {
        c cVar;
        cVar = c.f18144a;
        return cVar.nextInt(i3);
    }

    @Override // rh.c
    public long nextLong(long j4) {
        c cVar;
        cVar = c.f18144a;
        return cVar.nextLong(j4);
    }

    @Override // rh.c
    public byte[] nextBytes(byte[] array, int i3, int i10) {
        c cVar;
        e.f(array, "array");
        cVar = c.f18144a;
        return cVar.nextBytes(array, i3, i10);
    }

    @Override // rh.c
    public double nextDouble(double d5, double d8) {
        c cVar;
        cVar = c.f18144a;
        return cVar.nextDouble(d5, d8);
    }

    @Override // rh.c
    public int nextInt(int i3, int i10) {
        c cVar;
        cVar = c.f18144a;
        return cVar.nextInt(i3, i10);
    }

    @Override // rh.c
    public long nextLong(long j4, long j10) {
        c cVar;
        cVar = c.f18144a;
        return cVar.nextLong(j4, j10);
    }
}
