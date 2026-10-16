package rh;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.w;
import kotlin.jvm.internal.e;
import kotlin.random.Random$Default;

/* loaded from: classes2.dex */
public abstract class c {
    public static final Random$Default Default = new Random$Default(null);

    /* renamed from: a, reason: collision with root package name */
    public static final a f18144a;

    static {
        Integer num = lh.a.f15874a;
        f18144a = (num == null || num.intValue() >= 34) ? new sh.a() : new b();
    }

    public static /* synthetic */ byte[] nextBytes$default(c cVar, byte[] bArr, int i3, int i10, int i11, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: nextBytes");
        }
        if ((i11 & 2) != 0) {
            i3 = 0;
        }
        if ((i11 & 4) != 0) {
            i10 = bArr.length;
        }
        return cVar.nextBytes(bArr, i3, i10);
    }

    public abstract int nextBits(int i3);

    public abstract boolean nextBoolean();

    public abstract byte[] nextBytes(byte[] bArr);

    public byte[] nextBytes(byte[] array, int i3, int i10) {
        e.f(array, "array");
        if (!new th.c(0, array.length, 1).a(i3) || !new th.c(0, array.length, 1).a(i10)) {
            throw new IllegalArgumentException(android.support.v4.media.session.e.m(l0.s(i3, "fromIndex (", i10, ") or toIndex (", ") are out of range: 0.."), array.length, '.').toString());
        }
        if (i3 > i10) {
            throw new IllegalArgumentException(android.support.v4.media.session.e.g(i3, "fromIndex (", i10, ") must be not greater than toIndex (", ").").toString());
        }
        int i11 = (i10 - i3) / 4;
        for (int i12 = 0; i12 < i11; i12++) {
            int nextInt = nextInt();
            array[i3] = (byte) nextInt;
            array[i3 + 1] = (byte) (nextInt >>> 8);
            array[i3 + 2] = (byte) (nextInt >>> 16);
            array[i3 + 3] = (byte) (nextInt >>> 24);
            i3 += 4;
        }
        int i13 = i10 - i3;
        int nextBits = nextBits(i13 * 8);
        for (int i14 = 0; i14 < i13; i14++) {
            array[i3 + i14] = (byte) (nextBits >>> (i14 * 8));
        }
        return array;
    }

    public abstract double nextDouble();

    public double nextDouble(double d5) {
        return nextDouble(0.0d, d5);
    }

    public abstract float nextFloat();

    public abstract int nextInt();

    public abstract int nextInt(int i3);

    public int nextInt(int i3, int i10) {
        int nextInt;
        int i11;
        int i12;
        if (i10 <= i3) {
            throw new IllegalArgumentException(w.a(Integer.valueOf(i3), Integer.valueOf(i10)).toString());
        }
        int i13 = i10 - i3;
        if (i13 > 0 || i13 == Integer.MIN_VALUE) {
            if (((-i13) & i13) == i13) {
                i12 = nextBits(31 - Integer.numberOfLeadingZeros(i13));
            } else {
                do {
                    nextInt = nextInt() >>> 1;
                    i11 = nextInt % i13;
                } while ((i13 - 1) + (nextInt - i11) < 0);
                i12 = i11;
            }
            return i3 + i12;
        }
        while (true) {
            int nextInt2 = nextInt();
            if (i3 <= nextInt2 && nextInt2 < i10) {
                return nextInt2;
            }
        }
    }

    public abstract long nextLong();

    public long nextLong(long j4) {
        return nextLong(0L, j4);
    }

    public double nextDouble(double d5, double d8) {
        double nextDouble;
        if (d8 <= d5) {
            throw new IllegalArgumentException(w.a(Double.valueOf(d5), Double.valueOf(d8)).toString());
        }
        double d10 = d8 - d5;
        if (!Double.isInfinite(d10) || Double.isInfinite(d5) || Double.isNaN(d5) || Double.isInfinite(d8) || Double.isNaN(d8)) {
            nextDouble = d5 + (nextDouble() * d10);
        } else {
            double d11 = 2;
            double nextDouble2 = ((d8 / d11) - (d5 / d11)) * nextDouble();
            nextDouble = d5 + nextDouble2 + nextDouble2;
        }
        return nextDouble >= d8 ? Math.nextAfter(d8, Double.NEGATIVE_INFINITY) : nextDouble;
    }

    public long nextLong(long j4, long j10) {
        long nextLong;
        long j11;
        long j12;
        int nextInt;
        if (j10 <= j4) {
            throw new IllegalArgumentException(w.a(Long.valueOf(j4), Long.valueOf(j10)).toString());
        }
        long j13 = j10 - j4;
        if (j13 > 0) {
            if (((-j13) & j13) == j13) {
                int i3 = (int) j13;
                int i10 = (int) (j13 >>> 32);
                if (i3 != 0) {
                    nextInt = nextBits(31 - Integer.numberOfLeadingZeros(i3));
                } else if (i10 == 1) {
                    nextInt = nextInt();
                } else {
                    j12 = (nextBits(31 - Integer.numberOfLeadingZeros(i10)) << 32) + (nextInt() & 4294967295L);
                }
                j12 = nextInt & 4294967295L;
            } else {
                do {
                    nextLong = nextLong() >>> 1;
                    j11 = nextLong % j13;
                } while ((j13 - 1) + (nextLong - j11) < 0);
                j12 = j11;
            }
            return j4 + j12;
        }
        while (true) {
            long nextLong2 = nextLong();
            if (j4 <= nextLong2 && nextLong2 < j10) {
                return nextLong2;
            }
        }
    }

    public byte[] nextBytes(int i3) {
        return nextBytes(new byte[i3]);
    }
}
