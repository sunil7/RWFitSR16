package org.joda.time;

/* loaded from: classes2.dex */
public interface h extends Comparable {
    int get(DateTimeFieldType dateTimeFieldType);

    a getChronology();

    long getMillis();

    boolean isBefore(h hVar);

    Instant toInstant();
}
