package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.DateTimeFieldType;
import org.joda.time.Interval;

/* loaded from: classes2.dex */
public abstract class AbstractReadableInstantFieldProperty implements Serializable {
    private static final long serialVersionUID = 1971226328211649661L;

    public int compareTo(org.joda.time.h hVar) {
        if (hVar == null) {
            throw new IllegalArgumentException("The instant must not be null");
        }
        int i3 = get();
        int i10 = hVar.get(getFieldType());
        if (i3 < i10) {
            return -1;
        }
        return i3 > i10 ? 1 : 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AbstractReadableInstantFieldProperty)) {
            return false;
        }
        AbstractReadableInstantFieldProperty abstractReadableInstantFieldProperty = (AbstractReadableInstantFieldProperty) obj;
        return get() == abstractReadableInstantFieldProperty.get() && getFieldType().equals(abstractReadableInstantFieldProperty.getFieldType()) && nf.a(getChronology(), abstractReadableInstantFieldProperty.getChronology());
    }

    public int get() {
        return getField().get(getMillis());
    }

    public String getAsShortText() {
        return getAsShortText(null);
    }

    public String getAsString() {
        return Integer.toString(get());
    }

    public String getAsText() {
        return getAsText(null);
    }

    public org.joda.time.a getChronology() {
        throw new UnsupportedOperationException("The method getChronology() was added in v1.4 and needs to be implemented by subclasses of AbstractReadableInstantFieldProperty");
    }

    public int getDifference(org.joda.time.h hVar) {
        if (hVar != null) {
            return getField().getDifference(getMillis(), hVar.getMillis());
        }
        org.joda.time.b field = getField();
        long millis = getMillis();
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        return field.getDifference(millis, System.currentTimeMillis());
    }

    public long getDifferenceAsLong(org.joda.time.h hVar) {
        if (hVar != null) {
            return getField().getDifferenceAsLong(getMillis(), hVar.getMillis());
        }
        org.joda.time.b field = getField();
        long millis = getMillis();
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        return field.getDifferenceAsLong(millis, System.currentTimeMillis());
    }

    public org.joda.time.e getDurationField() {
        return getField().getDurationField();
    }

    public abstract org.joda.time.b getField();

    public DateTimeFieldType getFieldType() {
        return getField().getType();
    }

    public int getLeapAmount() {
        return getField().getLeapAmount(getMillis());
    }

    public org.joda.time.e getLeapDurationField() {
        return getField().getLeapDurationField();
    }

    public int getMaximumShortTextLength(Locale locale) {
        return getField().getMaximumShortTextLength(locale);
    }

    public int getMaximumTextLength(Locale locale) {
        return getField().getMaximumTextLength(locale);
    }

    public int getMaximumValue() {
        return getField().getMaximumValue(getMillis());
    }

    public int getMaximumValueOverall() {
        return getField().getMaximumValue();
    }

    public abstract long getMillis();

    public int getMinimumValue() {
        return getField().getMinimumValue(getMillis());
    }

    public int getMinimumValueOverall() {
        return getField().getMinimumValue();
    }

    public String getName() {
        return getField().getName();
    }

    public org.joda.time.e getRangeDurationField() {
        return getField().getRangeDurationField();
    }

    public int hashCode() {
        return getChronology().hashCode() + getFieldType().hashCode() + (get() * 17);
    }

    public boolean isLeap() {
        return getField().isLeap(getMillis());
    }

    public long remainder() {
        return getField().remainder(getMillis());
    }

    public Interval toInterval() {
        org.joda.time.b field = getField();
        long roundFloor = field.roundFloor(getMillis());
        return new Interval(roundFloor, field.add(roundFloor, 1), getChronology());
    }

    public String toString() {
        return "Property[" + getName() + "]";
    }

    public String getAsShortText(Locale locale) {
        return getField().getAsShortText(getMillis(), locale);
    }

    public String getAsText(Locale locale) {
        return getField().getAsText(getMillis(), locale);
    }

    public int compareTo(org.joda.time.j jVar) {
        if (jVar != null) {
            int i3 = get();
            int i10 = jVar.get(getFieldType());
            if (i3 < i10) {
                return -1;
            }
            return i3 > i10 ? 1 : 0;
        }
        throw new IllegalArgumentException("The partial must not be null");
    }
}
