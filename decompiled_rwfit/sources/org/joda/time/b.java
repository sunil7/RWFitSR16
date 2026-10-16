package org.joda.time;

import java.util.Locale;

/* loaded from: classes2.dex */
public abstract class b {
    public int a(long j4, int i3) {
        return getMaximumValue(j4);
    }

    public abstract long add(long j4, int i3);

    public abstract long add(long j4, long j10);

    public abstract int[] add(j jVar, int i3, int[] iArr, int i10);

    public abstract long addWrapField(long j4, int i3);

    public abstract int[] addWrapField(j jVar, int i3, int[] iArr, int i10);

    public abstract int[] addWrapPartial(j jVar, int i3, int[] iArr, int i10);

    public abstract int get(long j4);

    public abstract String getAsShortText(int i3, Locale locale);

    public abstract String getAsShortText(long j4);

    public abstract String getAsShortText(long j4, Locale locale);

    public abstract String getAsShortText(j jVar, int i3, Locale locale);

    public abstract String getAsShortText(j jVar, Locale locale);

    public abstract String getAsText(int i3, Locale locale);

    public abstract String getAsText(long j4);

    public abstract String getAsText(long j4, Locale locale);

    public abstract String getAsText(j jVar, int i3, Locale locale);

    public abstract String getAsText(j jVar, Locale locale);

    public abstract int getDifference(long j4, long j10);

    public abstract long getDifferenceAsLong(long j4, long j10);

    public abstract e getDurationField();

    public abstract int getLeapAmount(long j4);

    public abstract e getLeapDurationField();

    public abstract int getMaximumShortTextLength(Locale locale);

    public abstract int getMaximumTextLength(Locale locale);

    public abstract int getMaximumValue();

    public abstract int getMaximumValue(long j4);

    public abstract int getMaximumValue(j jVar);

    public abstract int getMaximumValue(j jVar, int[] iArr);

    public abstract int getMinimumValue();

    public abstract int getMinimumValue(long j4);

    public abstract int getMinimumValue(j jVar);

    public abstract int getMinimumValue(j jVar, int[] iArr);

    public abstract String getName();

    public abstract e getRangeDurationField();

    public abstract DateTimeFieldType getType();

    public abstract boolean isLeap(long j4);

    public abstract boolean isLenient();

    public abstract boolean isSupported();

    public abstract long remainder(long j4);

    public abstract long roundCeiling(long j4);

    public abstract long roundFloor(long j4);

    public abstract long roundHalfCeiling(long j4);

    public abstract long roundHalfEven(long j4);

    public abstract long roundHalfFloor(long j4);

    public abstract long set(long j4, int i3);

    public abstract long set(long j4, String str);

    public abstract long set(long j4, String str, Locale locale);

    public abstract int[] set(j jVar, int i3, int[] iArr, int i10);

    public abstract int[] set(j jVar, int i3, int[] iArr, String str, Locale locale);

    public long setExtended(long j4, int i3) {
        return set(j4, i3);
    }
}
