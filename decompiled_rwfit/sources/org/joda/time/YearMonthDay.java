package org.joda.time;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.base.BasePartial;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.v;

@Deprecated
/* loaded from: classes2.dex */
public final class YearMonthDay extends BasePartial implements Serializable {
    public static final int DAY_OF_MONTH = 2;
    public static final int MONTH_OF_YEAR = 1;
    public static final int YEAR = 0;

    /* renamed from: a, reason: collision with root package name */
    public static final DateTimeFieldType[] f17020a = {DateTimeFieldType.year(), DateTimeFieldType.monthOfYear(), DateTimeFieldType.dayOfMonth()};
    private static final long serialVersionUID = 797544782896179L;

    public YearMonthDay() {
    }

    public static YearMonthDay fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new YearMonthDay(calendar.get(1), calendar.get(2) + 1, calendar.get(5));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static YearMonthDay fromDateFields(Date date) {
        if (date != null) {
            return new YearMonthDay(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public Property dayOfMonth() {
        return new Property(this, 2);
    }

    public int getDayOfMonth() {
        return getValue(2);
    }

    @Override // ai.e
    public b getField(int i3, a aVar) {
        if (i3 == 0) {
            return aVar.year();
        }
        if (i3 == 1) {
            return aVar.monthOfYear();
        }
        if (i3 == 2) {
            return aVar.dayOfMonth();
        }
        throw new IndexOutOfBoundsException(l0.j(i3, "Invalid index: "));
    }

    @Override // ai.e, org.joda.time.j
    public DateTimeFieldType getFieldType(int i3) {
        return f17020a[i3];
    }

    @Override // ai.e
    public DateTimeFieldType[] getFieldTypes() {
        return (DateTimeFieldType[]) f17020a.clone();
    }

    public int getMonthOfYear() {
        return getValue(1);
    }

    public int getYear() {
        return getValue(0);
    }

    public YearMonthDay minus(k kVar) {
        return withPeriodAdded(kVar, -1);
    }

    public YearMonthDay minusDays(int i3) {
        return withFieldAdded(DurationFieldType.days(), nf.h(i3));
    }

    public YearMonthDay minusMonths(int i3) {
        return withFieldAdded(DurationFieldType.months(), nf.h(i3));
    }

    public YearMonthDay minusYears(int i3) {
        return withFieldAdded(DurationFieldType.years(), nf.h(i3));
    }

    public Property monthOfYear() {
        return new Property(this, 1);
    }

    public YearMonthDay plus(k kVar) {
        return withPeriodAdded(kVar, 1);
    }

    public YearMonthDay plusDays(int i3) {
        return withFieldAdded(DurationFieldType.days(), i3);
    }

    public YearMonthDay plusMonths(int i3) {
        return withFieldAdded(DurationFieldType.months(), i3);
    }

    public YearMonthDay plusYears(int i3) {
        return withFieldAdded(DurationFieldType.years(), i3);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    @Override // org.joda.time.base.BasePartial, org.joda.time.j
    public int size() {
        return 3;
    }

    public DateMidnight toDateMidnight() {
        return toDateMidnight(null);
    }

    public DateTime toDateTime(TimeOfDay timeOfDay) {
        return toDateTime(timeOfDay, null);
    }

    public DateTime toDateTimeAtCurrentTime() {
        return toDateTimeAtCurrentTime(null);
    }

    public DateTime toDateTimeAtMidnight() {
        return toDateTimeAtMidnight(null);
    }

    public Interval toInterval() {
        return toInterval(null);
    }

    public LocalDate toLocalDate() {
        return new LocalDate(getYear(), getMonthOfYear(), getDayOfMonth(), getChronology());
    }

    public String toString() {
        return v.f17248o.e(this);
    }

    public YearMonthDay withChronologyRetainFields(a aVar) {
        AtomicReference atomicReference = c.f17022a;
        if (aVar == null) {
            aVar = ISOChronology.getInstance();
        }
        a withUTC = aVar.withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        YearMonthDay yearMonthDay = new YearMonthDay(this, withUTC);
        withUTC.validate(yearMonthDay, getValues());
        return yearMonthDay;
    }

    public YearMonthDay withDayOfMonth(int i3) {
        return new YearMonthDay(this, getChronology().dayOfMonth().set(this, 2, getValues(), i3));
    }

    public YearMonthDay withField(DateTimeFieldType dateTimeFieldType, int i3) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i3 == getValue(indexOfSupported)) {
            return this;
        }
        return new YearMonthDay(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i3));
    }

    public YearMonthDay withFieldAdded(DurationFieldType durationFieldType, int i3) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i3 == 0) {
            return this;
        }
        return new YearMonthDay(this, getField(indexOfSupported).add(this, indexOfSupported, getValues(), i3));
    }

    public YearMonthDay withMonthOfYear(int i3) {
        return new YearMonthDay(this, getChronology().monthOfYear().set(this, 1, getValues(), i3));
    }

    public YearMonthDay withPeriodAdded(k kVar, int i3) {
        if (kVar == null || i3 == 0) {
            return this;
        }
        int[] values = getValues();
        for (int i10 = 0; i10 < kVar.size(); i10++) {
            int indexOf = indexOf(kVar.getFieldType(i10));
            if (indexOf >= 0) {
                values = getField(indexOf).add(this, indexOf, values, nf.e(kVar.getValue(i10), i3));
            }
        }
        return new YearMonthDay(this, values);
    }

    public YearMonthDay withYear(int i3) {
        return new YearMonthDay(this, getChronology().year().set(this, 0, getValues(), i3));
    }

    public Property year() {
        return new Property(this, 0);
    }

    public YearMonthDay(DateTimeZone dateTimeZone) {
        super(ISOChronology.getInstance(dateTimeZone));
    }

    public DateMidnight toDateMidnight(DateTimeZone dateTimeZone) {
        return new DateMidnight(getYear(), getMonthOfYear(), getDayOfMonth(), getChronology().withZone(dateTimeZone));
    }

    public DateTime toDateTime(TimeOfDay timeOfDay, DateTimeZone dateTimeZone) {
        a withZone = getChronology().withZone(dateTimeZone);
        AtomicReference atomicReference = c.f17022a;
        long j4 = withZone.set(this, System.currentTimeMillis());
        if (timeOfDay != null) {
            j4 = withZone.set(timeOfDay, j4);
        }
        return new DateTime(j4, withZone);
    }

    public DateTime toDateTimeAtCurrentTime(DateTimeZone dateTimeZone) {
        a withZone = getChronology().withZone(dateTimeZone);
        AtomicReference atomicReference = c.f17022a;
        return new DateTime(withZone.set(this, System.currentTimeMillis()), withZone);
    }

    public DateTime toDateTimeAtMidnight(DateTimeZone dateTimeZone) {
        return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), 0, 0, 0, 0, getChronology().withZone(dateTimeZone));
    }

    public Interval toInterval(DateTimeZone dateTimeZone) {
        AtomicReference atomicReference = c.f17022a;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return toDateMidnight(dateTimeZone).toInterval();
    }

    @Deprecated
    public static class Property extends org.joda.time.field.a implements Serializable {
        private static final long serialVersionUID = 5727734012190224363L;
        private final int iFieldIndex;
        private final YearMonthDay iYearMonthDay;

        public Property(YearMonthDay yearMonthDay, int i3) {
            this.iYearMonthDay = yearMonthDay;
            this.iFieldIndex = i3;
        }

        public YearMonthDay addToCopy(int i3) {
            return new YearMonthDay(this.iYearMonthDay, getField().add(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), i3));
        }

        public YearMonthDay addWrapFieldToCopy(int i3) {
            return new YearMonthDay(this.iYearMonthDay, getField().addWrapField(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), i3));
        }

        @Override // org.joda.time.field.a
        public int get() {
            return this.iYearMonthDay.getValue(this.iFieldIndex);
        }

        @Override // org.joda.time.field.a
        public b getField() {
            return this.iYearMonthDay.getField(this.iFieldIndex);
        }

        @Override // org.joda.time.field.a
        public j getReadablePartial() {
            return this.iYearMonthDay;
        }

        public YearMonthDay getYearMonthDay() {
            return this.iYearMonthDay;
        }

        public YearMonthDay setCopy(int i3) {
            return new YearMonthDay(this.iYearMonthDay, getField().set(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), i3));
        }

        public YearMonthDay withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public YearMonthDay withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public YearMonthDay setCopy(String str, Locale locale) {
            return new YearMonthDay(this.iYearMonthDay, getField().set(this.iYearMonthDay, this.iFieldIndex, this.iYearMonthDay.getValues(), str, locale));
        }

        public YearMonthDay setCopy(String str) {
            return setCopy(str, null);
        }
    }

    public YearMonthDay(a aVar) {
        super(aVar);
    }

    public YearMonthDay(long j4) {
        super(j4);
    }

    public YearMonthDay(long j4, a aVar) {
        super(j4, aVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public YearMonthDay(Object obj, a aVar) {
        super(obj, aVar == null ? ISOChronology.getInstance() : aVar, v.f17238f0);
        AtomicReference atomicReference = c.f17022a;
    }

    public YearMonthDay(int i3, int i10, int i11) {
        this(i3, i10, i11, null);
    }

    public YearMonthDay(int i3, int i10, int i11, a aVar) {
        super(new int[]{i3, i10, i11}, aVar);
    }

    public YearMonthDay(YearMonthDay yearMonthDay, int[] iArr) {
        super(yearMonthDay, iArr);
    }

    public YearMonthDay(YearMonthDay yearMonthDay, a aVar) {
        super((BasePartial) yearMonthDay, aVar);
    }

    public YearMonthDay(Object obj) {
        super(obj, null, v.f17238f0);
    }
}
