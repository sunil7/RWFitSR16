package org.joda.time;

/* loaded from: classes2.dex */
public interface j extends Comparable {
    int get(DateTimeFieldType dateTimeFieldType);

    a getChronology();

    b getField(int i3);

    DateTimeFieldType getFieldType(int i3);

    int getValue(int i3);

    boolean isSupported(DateTimeFieldType dateTimeFieldType);

    int size();
}
