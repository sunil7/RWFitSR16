package ai;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import org.joda.time.DateTime;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.j;

/* loaded from: classes2.dex */
public abstract class e implements j, Comparable {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        j jVar = (j) obj;
        if (size() != jVar.size()) {
            return false;
        }
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (getValue(i3) != jVar.getValue(i3) || getFieldType(i3) != jVar.getFieldType(i3)) {
                return false;
            }
        }
        return nf.a(getChronology(), jVar.getChronology());
    }

    @Override // org.joda.time.j
    public int get(DateTimeFieldType dateTimeFieldType) {
        return getValue(indexOfSupported(dateTimeFieldType));
    }

    @Override // org.joda.time.j
    public org.joda.time.b getField(int i3) {
        return getField(i3, getChronology());
    }

    public abstract org.joda.time.b getField(int i3, org.joda.time.a aVar);

    @Override // org.joda.time.j
    public DateTimeFieldType getFieldType(int i3) {
        return getField(i3, getChronology()).getType();
    }

    public DateTimeFieldType[] getFieldTypes() {
        int size = size();
        DateTimeFieldType[] dateTimeFieldTypeArr = new DateTimeFieldType[size];
        for (int i3 = 0; i3 < size; i3++) {
            dateTimeFieldTypeArr[i3] = getFieldType(i3);
        }
        return dateTimeFieldTypeArr;
    }

    public org.joda.time.b[] getFields() {
        int size = size();
        org.joda.time.b[] bVarArr = new org.joda.time.b[size];
        for (int i3 = 0; i3 < size; i3++) {
            bVarArr[i3] = getField(i3);
        }
        return bVarArr;
    }

    public int[] getValues() {
        int size = size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = getValue(i3);
        }
        return iArr;
    }

    public int hashCode() {
        int size = size();
        int i3 = 157;
        for (int i10 = 0; i10 < size; i10++) {
            i3 = getFieldType(i10).hashCode() + ((getValue(i10) + (i3 * 23)) * 23);
        }
        return getChronology().hashCode() + i3;
    }

    public int indexOf(DateTimeFieldType dateTimeFieldType) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (getFieldType(i3) == dateTimeFieldType) {
                return i3;
            }
        }
        return -1;
    }

    public int indexOfSupported(DateTimeFieldType dateTimeFieldType) {
        int indexOf = indexOf(dateTimeFieldType);
        if (indexOf != -1) {
            return indexOf;
        }
        throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
    }

    public boolean isAfter(j jVar) {
        if (jVar != null) {
            return compareTo(jVar) > 0;
        }
        throw new IllegalArgumentException("Partial cannot be null");
    }

    public boolean isBefore(j jVar) {
        if (jVar != null) {
            return compareTo(jVar) < 0;
        }
        throw new IllegalArgumentException("Partial cannot be null");
    }

    public boolean isEqual(j jVar) {
        if (jVar != null) {
            return compareTo(jVar) == 0;
        }
        throw new IllegalArgumentException("Partial cannot be null");
    }

    @Override // org.joda.time.j
    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        return indexOf(dateTimeFieldType) != -1;
    }

    public DateTime toDateTime(org.joda.time.h hVar) {
        org.joda.time.a c9 = org.joda.time.c.c(hVar);
        return new DateTime(c9.set(this, org.joda.time.c.d(hVar)), c9);
    }

    public String toString(org.joda.time.format.b bVar) {
        return bVar == null ? toString() : bVar.e(this);
    }

    @Override // java.lang.Comparable
    public int compareTo(j jVar) {
        if (this == jVar) {
            return 0;
        }
        if (size() != jVar.size()) {
            throw new ClassCastException("ReadablePartial objects must have matching field types");
        }
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (getFieldType(i3) != jVar.getFieldType(i3)) {
                throw new ClassCastException("ReadablePartial objects must have matching field types");
            }
        }
        int size2 = size();
        for (int i10 = 0; i10 < size2; i10++) {
            if (getValue(i10) > jVar.getValue(i10)) {
                return 1;
            }
            if (getValue(i10) < jVar.getValue(i10)) {
                return -1;
            }
        }
        return 0;
    }

    public int indexOf(DurationFieldType durationFieldType) {
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (getFieldType(i3).getDurationType() == durationFieldType) {
                return i3;
            }
        }
        return -1;
    }

    public int indexOfSupported(DurationFieldType durationFieldType) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf != -1) {
            return indexOf;
        }
        throw new IllegalArgumentException("Field '" + durationFieldType + "' is not supported");
    }
}
