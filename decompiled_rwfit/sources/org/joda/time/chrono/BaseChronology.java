package org.joda.time.chrono;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.UnsupportedDateTimeField;
import org.joda.time.field.UnsupportedDurationField;

/* loaded from: classes2.dex */
public abstract class BaseChronology extends org.joda.time.a implements Serializable {
    private static final long serialVersionUID = -7310865996721419676L;

    @Override // org.joda.time.a
    public long add(org.joda.time.k kVar, long j4, int i3) {
        if (i3 != 0 && kVar != null) {
            int size = kVar.size();
            for (int i10 = 0; i10 < size; i10++) {
                long value = kVar.getValue(i10);
                if (value != 0) {
                    j4 = kVar.getFieldType(i10).getField(this).add(j4, value * i3);
                }
            }
        }
        return j4;
    }

    @Override // org.joda.time.a
    public org.joda.time.e centuries() {
        return UnsupportedDurationField.getInstance(DurationFieldType.centuries());
    }

    @Override // org.joda.time.a
    public org.joda.time.b centuryOfEra() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.centuryOfEra(), centuries());
    }

    @Override // org.joda.time.a
    public org.joda.time.b clockhourOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.clockhourOfDay(), hours());
    }

    @Override // org.joda.time.a
    public org.joda.time.b clockhourOfHalfday() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.clockhourOfHalfday(), hours());
    }

    @Override // org.joda.time.a
    public org.joda.time.b dayOfMonth() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfMonth(), days());
    }

    @Override // org.joda.time.a
    public org.joda.time.b dayOfWeek() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfWeek(), days());
    }

    @Override // org.joda.time.a
    public org.joda.time.b dayOfYear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.dayOfYear(), days());
    }

    @Override // org.joda.time.a
    public org.joda.time.e days() {
        return UnsupportedDurationField.getInstance(DurationFieldType.days());
    }

    @Override // org.joda.time.a
    public org.joda.time.b era() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.era(), eras());
    }

    @Override // org.joda.time.a
    public org.joda.time.e eras() {
        return UnsupportedDurationField.getInstance(DurationFieldType.eras());
    }

    @Override // org.joda.time.a
    public int[] get(org.joda.time.j jVar, long j4) {
        int size = jVar.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = jVar.getFieldType(i3).getField(this).get(j4);
        }
        return iArr;
    }

    @Override // org.joda.time.a
    public long getDateTimeMillis(int i3, int i10, int i11, int i12) throws IllegalArgumentException {
        return millisOfDay().set(dayOfMonth().set(monthOfYear().set(year().set(0L, i3), i10), i11), i12);
    }

    @Override // org.joda.time.a
    public abstract DateTimeZone getZone();

    @Override // org.joda.time.a
    public org.joda.time.b halfdayOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.halfdayOfDay(), halfdays());
    }

    @Override // org.joda.time.a
    public org.joda.time.e halfdays() {
        return UnsupportedDurationField.getInstance(DurationFieldType.halfdays());
    }

    @Override // org.joda.time.a
    public org.joda.time.b hourOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.hourOfDay(), hours());
    }

    @Override // org.joda.time.a
    public org.joda.time.b hourOfHalfday() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.hourOfHalfday(), hours());
    }

    @Override // org.joda.time.a
    public org.joda.time.e hours() {
        return UnsupportedDurationField.getInstance(DurationFieldType.hours());
    }

    @Override // org.joda.time.a
    public org.joda.time.e millis() {
        return UnsupportedDurationField.getInstance(DurationFieldType.millis());
    }

    @Override // org.joda.time.a
    public org.joda.time.b millisOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.millisOfDay(), millis());
    }

    @Override // org.joda.time.a
    public org.joda.time.b millisOfSecond() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.millisOfSecond(), millis());
    }

    @Override // org.joda.time.a
    public org.joda.time.b minuteOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.minuteOfDay(), minutes());
    }

    @Override // org.joda.time.a
    public org.joda.time.b minuteOfHour() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.minuteOfHour(), minutes());
    }

    @Override // org.joda.time.a
    public org.joda.time.e minutes() {
        return UnsupportedDurationField.getInstance(DurationFieldType.minutes());
    }

    @Override // org.joda.time.a
    public org.joda.time.b monthOfYear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.monthOfYear(), months());
    }

    @Override // org.joda.time.a
    public org.joda.time.e months() {
        return UnsupportedDurationField.getInstance(DurationFieldType.months());
    }

    @Override // org.joda.time.a
    public org.joda.time.b secondOfDay() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.secondOfDay(), seconds());
    }

    @Override // org.joda.time.a
    public org.joda.time.b secondOfMinute() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.secondOfMinute(), seconds());
    }

    @Override // org.joda.time.a
    public org.joda.time.e seconds() {
        return UnsupportedDurationField.getInstance(DurationFieldType.seconds());
    }

    @Override // org.joda.time.a
    public long set(org.joda.time.j jVar, long j4) {
        int size = jVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            j4 = jVar.getFieldType(i3).getField(this).set(j4, jVar.getValue(i3));
        }
        return j4;
    }

    @Override // org.joda.time.a
    public abstract String toString();

    @Override // org.joda.time.a
    public void validate(org.joda.time.j jVar, int[] iArr) {
        int size = jVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            int i10 = iArr[i3];
            org.joda.time.b field = jVar.getField(i3);
            if (i10 < field.getMinimumValue()) {
                throw new IllegalFieldValueException(field.getType(), Integer.valueOf(i10), Integer.valueOf(field.getMinimumValue()), (Number) null);
            }
            if (i10 > field.getMaximumValue()) {
                throw new IllegalFieldValueException(field.getType(), Integer.valueOf(i10), (Number) null, Integer.valueOf(field.getMaximumValue()));
            }
        }
        for (int i11 = 0; i11 < size; i11++) {
            int i12 = iArr[i11];
            org.joda.time.b field2 = jVar.getField(i11);
            if (i12 < field2.getMinimumValue(jVar, iArr)) {
                throw new IllegalFieldValueException(field2.getType(), Integer.valueOf(i12), Integer.valueOf(field2.getMinimumValue(jVar, iArr)), (Number) null);
            }
            if (i12 > field2.getMaximumValue(jVar, iArr)) {
                throw new IllegalFieldValueException(field2.getType(), Integer.valueOf(i12), (Number) null, Integer.valueOf(field2.getMaximumValue(jVar, iArr)));
            }
        }
    }

    @Override // org.joda.time.a
    public org.joda.time.b weekOfWeekyear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekOfWeekyear(), weeks());
    }

    @Override // org.joda.time.a
    public org.joda.time.e weeks() {
        return UnsupportedDurationField.getInstance(DurationFieldType.weeks());
    }

    @Override // org.joda.time.a
    public org.joda.time.b weekyear() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekyear(), weekyears());
    }

    @Override // org.joda.time.a
    public org.joda.time.b weekyearOfCentury() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.weekyearOfCentury(), weekyears());
    }

    @Override // org.joda.time.a
    public org.joda.time.e weekyears() {
        return UnsupportedDurationField.getInstance(DurationFieldType.weekyears());
    }

    @Override // org.joda.time.a
    public abstract org.joda.time.a withUTC();

    @Override // org.joda.time.a
    public abstract org.joda.time.a withZone(DateTimeZone dateTimeZone);

    @Override // org.joda.time.a
    public org.joda.time.b year() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.year(), years());
    }

    @Override // org.joda.time.a
    public org.joda.time.b yearOfCentury() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.yearOfCentury(), years());
    }

    @Override // org.joda.time.a
    public org.joda.time.b yearOfEra() {
        return UnsupportedDateTimeField.getInstance(DateTimeFieldType.yearOfEra(), years());
    }

    @Override // org.joda.time.a
    public org.joda.time.e years() {
        return UnsupportedDurationField.getInstance(DurationFieldType.years());
    }

    @Override // org.joda.time.a
    public long add(long j4, long j10, int i3) {
        return (j10 == 0 || i3 == 0) ? j4 : nf.d(j4, nf.f(i3, j10));
    }

    @Override // org.joda.time.a
    public int[] get(org.joda.time.k kVar, long j4, long j10) {
        int size = kVar.size();
        int[] iArr = new int[size];
        if (j4 != j10) {
            for (int i3 = 0; i3 < size; i3++) {
                org.joda.time.e field = kVar.getFieldType(i3).getField(this);
                int difference = field.getDifference(j10, j4);
                if (difference != 0) {
                    j4 = field.add(j4, difference);
                }
                iArr[i3] = difference;
            }
        }
        return iArr;
    }

    @Override // org.joda.time.a
    public long getDateTimeMillis(int i3, int i10, int i11, int i12, int i13, int i14, int i15) throws IllegalArgumentException {
        return millisOfSecond().set(secondOfMinute().set(minuteOfHour().set(hourOfDay().set(dayOfMonth().set(monthOfYear().set(year().set(0L, i3), i10), i11), i12), i13), i14), i15);
    }

    @Override // org.joda.time.a
    public int[] get(org.joda.time.k kVar, long j4) {
        int size = kVar.size();
        int[] iArr = new int[size];
        long j10 = 0;
        if (j4 != 0) {
            for (int i3 = 0; i3 < size; i3++) {
                org.joda.time.e field = kVar.getFieldType(i3).getField(this);
                if (field.isPrecise()) {
                    int difference = field.getDifference(j4, j10);
                    j10 = field.add(j10, difference);
                    iArr[i3] = difference;
                }
            }
        }
        return iArr;
    }

    @Override // org.joda.time.a
    public long getDateTimeMillis(long j4, int i3, int i10, int i11, int i12) throws IllegalArgumentException {
        return millisOfSecond().set(secondOfMinute().set(minuteOfHour().set(hourOfDay().set(j4, i3), i10), i11), i12);
    }
}
