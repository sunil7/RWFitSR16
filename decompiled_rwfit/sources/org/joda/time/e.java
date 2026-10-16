package org.joda.time;

/* loaded from: classes2.dex */
public abstract class e implements Comparable {
    public abstract long add(long j4, int i3);

    public abstract long add(long j4, long j10);

    public abstract int getDifference(long j4, long j10);

    public abstract long getDifferenceAsLong(long j4, long j10);

    public abstract long getMillis(int i3, long j4);

    public abstract long getMillis(long j4);

    public abstract long getMillis(long j4, long j10);

    public abstract String getName();

    public abstract DurationFieldType getType();

    public abstract long getUnitMillis();

    public abstract int getValue(long j4);

    public abstract int getValue(long j4, long j10);

    public abstract long getValueAsLong(long j4);

    public abstract long getValueAsLong(long j4, long j10);

    public abstract boolean isPrecise();

    public abstract boolean isSupported();

    public long subtract(long j4, int i3) {
        return i3 == Integer.MIN_VALUE ? subtract(j4, i3) : add(j4, -i3);
    }

    public long subtract(long j4, long j10) {
        if (j10 != Long.MIN_VALUE) {
            return add(j4, -j10);
        }
        throw new ArithmeticException("Long.MIN_VALUE cannot be negated");
    }
}
