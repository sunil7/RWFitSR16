package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.util.Locale;
import org.joda.time.DateTimeFieldType;

/* loaded from: classes2.dex */
public abstract class a {
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
        if (!(obj instanceof a)) {
            return false;
        }
        a aVar = (a) obj;
        return get() == aVar.get() && getFieldType() == aVar.getFieldType() && nf.a(getReadablePartial().getChronology(), aVar.getReadablePartial().getChronology());
    }

    public abstract int get();

    public String getAsShortText() {
        return getAsShortText(null);
    }

    public String getAsString() {
        return Integer.toString(get());
    }

    public String getAsText() {
        return getAsText(null);
    }

    public org.joda.time.e getDurationField() {
        return getField().getDurationField();
    }

    public abstract org.joda.time.b getField();

    public DateTimeFieldType getFieldType() {
        return getField().getType();
    }

    public int getMaximumShortTextLength(Locale locale) {
        return getField().getMaximumShortTextLength(locale);
    }

    public int getMaximumTextLength(Locale locale) {
        return getField().getMaximumTextLength(locale);
    }

    public int getMaximumValue() {
        return getField().getMaximumValue(getReadablePartial());
    }

    public int getMaximumValueOverall() {
        return getField().getMaximumValue();
    }

    public int getMinimumValue() {
        return getField().getMinimumValue(getReadablePartial());
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

    public abstract org.joda.time.j getReadablePartial();

    public int hashCode() {
        return getReadablePartial().getChronology().hashCode() + ((getFieldType().hashCode() + ((get() + 247) * 13)) * 13);
    }

    public String toString() {
        return "Property[" + getName() + "]";
    }

    public String getAsShortText(Locale locale) {
        return getField().getAsShortText(getReadablePartial(), get(), locale);
    }

    public String getAsText(Locale locale) {
        return getField().getAsText(getReadablePartial(), get(), locale);
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
        throw new IllegalArgumentException("The instant must not be null");
    }
}
