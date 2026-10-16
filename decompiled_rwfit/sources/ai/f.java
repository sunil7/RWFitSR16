package ai;

import org.joda.convert.ToString;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.joda.time.Period;
import org.joda.time.format.a0;
import org.joda.time.format.w;
import org.joda.time.k;

/* loaded from: classes2.dex */
public abstract class f implements k {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof k)) {
            return false;
        }
        k kVar = (k) obj;
        if (size() != kVar.size()) {
            return false;
        }
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (getValue(i3) != kVar.getValue(i3) || getFieldType(i3) != kVar.getFieldType(i3)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.joda.time.k
    public int get(DurationFieldType durationFieldType) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf == -1) {
            return 0;
        }
        return getValue(indexOf);
    }

    @Override // org.joda.time.k
    public DurationFieldType getFieldType(int i3) {
        return getPeriodType().getFieldType(i3);
    }

    public DurationFieldType[] getFieldTypes() {
        int size = size();
        DurationFieldType[] durationFieldTypeArr = new DurationFieldType[size];
        for (int i3 = 0; i3 < size; i3++) {
            durationFieldTypeArr[i3] = getFieldType(i3);
        }
        return durationFieldTypeArr;
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
        int i3 = 17;
        for (int i10 = 0; i10 < size; i10++) {
            i3 = getFieldType(i10).hashCode() + ((getValue(i10) + (i3 * 27)) * 27);
        }
        return i3;
    }

    public int indexOf(DurationFieldType durationFieldType) {
        return getPeriodType().indexOf(durationFieldType);
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        return getPeriodType().isSupported(durationFieldType);
    }

    @Override // org.joda.time.k
    public int size() {
        return getPeriodType().size();
    }

    public MutablePeriod toMutablePeriod() {
        return new MutablePeriod(this);
    }

    public Period toPeriod() {
        return new Period(this);
    }

    @ToString
    public String toString() {
        return w.a().c(this);
    }

    public String toString(a0 a0Var) {
        return a0Var == null ? toString() : a0Var.c(this);
    }
}
