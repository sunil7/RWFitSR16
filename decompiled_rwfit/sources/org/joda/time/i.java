package org.joda.time;

/* loaded from: classes2.dex */
public interface i {
    a getChronology();

    DateTime getEnd();

    long getEndMillis();

    DateTime getStart();

    long getStartMillis();

    long toDurationMillis();

    Period toPeriod(PeriodType periodType);
}
