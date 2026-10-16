package org.joda.time;

/* loaded from: classes2.dex */
public abstract class a {
    public abstract long add(long j4, long j10, int i3);

    public abstract long add(k kVar, long j4, int i3);

    public abstract e centuries();

    public abstract b centuryOfEra();

    public abstract b clockhourOfDay();

    public abstract b clockhourOfHalfday();

    public abstract b dayOfMonth();

    public abstract b dayOfWeek();

    public abstract b dayOfYear();

    public abstract e days();

    public abstract b era();

    public abstract e eras();

    public abstract int[] get(j jVar, long j4);

    public abstract int[] get(k kVar, long j4);

    public abstract int[] get(k kVar, long j4, long j10);

    public abstract long getDateTimeMillis(int i3, int i10, int i11, int i12);

    public abstract long getDateTimeMillis(int i3, int i10, int i11, int i12, int i13, int i14, int i15);

    public abstract long getDateTimeMillis(long j4, int i3, int i10, int i11, int i12);

    public abstract DateTimeZone getZone();

    public abstract b halfdayOfDay();

    public abstract e halfdays();

    public abstract b hourOfDay();

    public abstract b hourOfHalfday();

    public abstract e hours();

    public abstract e millis();

    public abstract b millisOfDay();

    public abstract b millisOfSecond();

    public abstract b minuteOfDay();

    public abstract b minuteOfHour();

    public abstract e minutes();

    public abstract b monthOfYear();

    public abstract e months();

    public abstract b secondOfDay();

    public abstract b secondOfMinute();

    public abstract e seconds();

    public abstract long set(j jVar, long j4);

    public abstract String toString();

    public abstract void validate(j jVar, int[] iArr);

    public abstract b weekOfWeekyear();

    public abstract e weeks();

    public abstract b weekyear();

    public abstract b weekyearOfCentury();

    public abstract e weekyears();

    public abstract a withUTC();

    public abstract a withZone(DateTimeZone dateTimeZone);

    public abstract b year();

    public abstract b yearOfCentury();

    public abstract b yearOfEra();

    public abstract e years();
}
