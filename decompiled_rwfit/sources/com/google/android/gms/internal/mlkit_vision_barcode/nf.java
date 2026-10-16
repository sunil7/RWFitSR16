package com.google.android.gms.internal.mlkit_vision_barcode;

import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;

/* loaded from: classes.dex */
public abstract class nf {
    public static boolean a(Object obj, Object obj2) {
        if (obj == obj2) {
            return true;
        }
        if (obj == null || obj2 == null) {
            return false;
        }
        return obj.equals(obj2);
    }

    public static int b(int i3, int i10, int i11, int i12) {
        int i13 = i3 + i10;
        if (i11 >= i12) {
            throw new IllegalArgumentException("MIN > MAX");
        }
        int i14 = (i12 - i11) + 1;
        int i15 = i13 - i11;
        if (i15 >= 0) {
            return (i15 % i14) + i11;
        }
        int i16 = (-i15) % i14;
        return i16 == 0 ? i11 : (i14 - i16) + i11;
    }

    public static int c(int i3, int i10) {
        int i11 = i3 + i10;
        if ((i3 ^ i11) >= 0 || (i3 ^ i10) < 0) {
            return i11;
        }
        throw new ArithmeticException(l0.i(i3, i10, "The calculation caused an overflow: ", " + "));
    }

    public static long d(long j4, long j10) {
        long j11 = j4 + j10;
        if ((j4 ^ j11) >= 0 || (j4 ^ j10) < 0) {
            return j11;
        }
        throw new ArithmeticException("The calculation caused an overflow: " + j4 + " + " + j10);
    }

    public static int e(int i3, int i10) {
        long j4 = i3 * i10;
        if (j4 < -2147483648L || j4 > 2147483647L) {
            throw new ArithmeticException(l0.i(i3, i10, "Multiplication overflows an int: ", " * "));
        }
        return (int) j4;
    }

    public static long f(int i3, long j4) {
        if (i3 == -1) {
            if (j4 != Long.MIN_VALUE) {
                return -j4;
            }
            throw new ArithmeticException("Multiplication overflows a long: " + j4 + " * " + i3);
        }
        if (i3 == 0) {
            return 0L;
        }
        if (i3 == 1) {
            return j4;
        }
        long j10 = i3;
        long j11 = j4 * j10;
        if (j11 / j10 == j4) {
            return j11;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j4 + " * " + i3);
    }

    public static long g(long j4, long j10) {
        if (j10 == 1) {
            return j4;
        }
        if (j4 == 1) {
            return j10;
        }
        if (j4 == 0 || j10 == 0) {
            return 0L;
        }
        long j11 = j4 * j10;
        if (j11 / j10 == j4 && ((j4 != Long.MIN_VALUE || j10 != -1) && (j10 != Long.MIN_VALUE || j4 != -1))) {
            return j11;
        }
        throw new ArithmeticException("Multiplication overflows a long: " + j4 + " * " + j10);
    }

    public static int h(int i3) {
        if (i3 != Integer.MIN_VALUE) {
            return -i3;
        }
        throw new ArithmeticException("Integer.MIN_VALUE cannot be negated");
    }

    public static long i(long j4, long j10) {
        long j11 = j4 - j10;
        if ((j4 ^ j11) >= 0 || (j4 ^ j10) >= 0) {
            return j11;
        }
        throw new ArithmeticException("The calculation caused an overflow: " + j4 + " - " + j10);
    }

    public static int j(long j4) {
        if (-2147483648L > j4 || j4 > 2147483647L) {
            throw new ArithmeticException(l0.l(j4, "Value cannot fit in an int: "));
        }
        return (int) j4;
    }

    public static void k(org.joda.time.b bVar, int i3, int i10, int i11) {
        if (i3 < i10 || i3 > i11) {
            throw new IllegalFieldValueException(bVar.getType(), Integer.valueOf(i3), Integer.valueOf(i10), Integer.valueOf(i11));
        }
    }

    public static void l(DateTimeFieldType dateTimeFieldType, int i3, int i10, int i11) {
        if (i3 < i10 || i3 > i11) {
            throw new IllegalFieldValueException(dateTimeFieldType, Integer.valueOf(i3), Integer.valueOf(i10), Integer.valueOf(i11));
        }
    }
}
