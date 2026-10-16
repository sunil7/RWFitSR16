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
public final class TimeOfDay extends BasePartial implements Serializable {
    public static final int HOUR_OF_DAY = 0;
    public static final int MILLIS_OF_SECOND = 3;
    public static final int MINUTE_OF_HOUR = 1;
    public static final int SECOND_OF_MINUTE = 2;
    private static final long serialVersionUID = 3633353405803318660L;

    /* renamed from: a, reason: collision with root package name */
    public static final DateTimeFieldType[] f17018a = {DateTimeFieldType.hourOfDay(), DateTimeFieldType.minuteOfHour(), DateTimeFieldType.secondOfMinute(), DateTimeFieldType.millisOfSecond()};
    public static final TimeOfDay MIDNIGHT = new TimeOfDay(0, 0, 0, 0);

    public TimeOfDay() {
    }

    public static TimeOfDay fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new TimeOfDay(calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static TimeOfDay fromDateFields(Date date) {
        if (date != null) {
            return new TimeOfDay(date.getHours(), date.getMinutes(), date.getSeconds(), (((int) (date.getTime() % 1000)) + 1000) % 1000);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static TimeOfDay fromMillisOfDay(long j4) {
        return fromMillisOfDay(j4, null);
    }

    @Override // ai.e
    public b getField(int i3, a aVar) {
        if (i3 == 0) {
            return aVar.hourOfDay();
        }
        if (i3 == 1) {
            return aVar.minuteOfHour();
        }
        if (i3 == 2) {
            return aVar.secondOfMinute();
        }
        if (i3 == 3) {
            return aVar.millisOfSecond();
        }
        throw new IndexOutOfBoundsException(l0.j(i3, "Invalid index: "));
    }

    @Override // ai.e, org.joda.time.j
    public DateTimeFieldType getFieldType(int i3) {
        return f17018a[i3];
    }

    @Override // ai.e
    public DateTimeFieldType[] getFieldTypes() {
        return (DateTimeFieldType[]) f17018a.clone();
    }

    public int getHourOfDay() {
        return getValue(0);
    }

    public int getMillisOfSecond() {
        return getValue(3);
    }

    public int getMinuteOfHour() {
        return getValue(1);
    }

    public int getSecondOfMinute() {
        return getValue(2);
    }

    public Property hourOfDay() {
        return new Property(this, 0);
    }

    public Property millisOfSecond() {
        return new Property(this, 3);
    }

    public TimeOfDay minus(k kVar) {
        return withPeriodAdded(kVar, -1);
    }

    public TimeOfDay minusHours(int i3) {
        return withFieldAdded(DurationFieldType.hours(), nf.h(i3));
    }

    public TimeOfDay minusMillis(int i3) {
        return withFieldAdded(DurationFieldType.millis(), nf.h(i3));
    }

    public TimeOfDay minusMinutes(int i3) {
        return withFieldAdded(DurationFieldType.minutes(), nf.h(i3));
    }

    public TimeOfDay minusSeconds(int i3) {
        return withFieldAdded(DurationFieldType.seconds(), nf.h(i3));
    }

    public Property minuteOfHour() {
        return new Property(this, 1);
    }

    public TimeOfDay plus(k kVar) {
        return withPeriodAdded(kVar, 1);
    }

    public TimeOfDay plusHours(int i3) {
        return withFieldAdded(DurationFieldType.hours(), i3);
    }

    public TimeOfDay plusMillis(int i3) {
        return withFieldAdded(DurationFieldType.millis(), i3);
    }

    public TimeOfDay plusMinutes(int i3) {
        return withFieldAdded(DurationFieldType.minutes(), i3);
    }

    public TimeOfDay plusSeconds(int i3) {
        return withFieldAdded(DurationFieldType.seconds(), i3);
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        return new Property(this, indexOfSupported(dateTimeFieldType));
    }

    public Property secondOfMinute() {
        return new Property(this, 2);
    }

    @Override // org.joda.time.base.BasePartial, org.joda.time.j
    public int size() {
        return 4;
    }

    public DateTime toDateTimeToday() {
        return toDateTimeToday(null);
    }

    public LocalTime toLocalTime() {
        return new LocalTime(getHourOfDay(), getMinuteOfHour(), getSecondOfMinute(), getMillisOfSecond(), getChronology());
    }

    public String toString() {
        return v.C.e(this);
    }

    public TimeOfDay withChronologyRetainFields(a aVar) {
        AtomicReference atomicReference = c.f17022a;
        if (aVar == null) {
            aVar = ISOChronology.getInstance();
        }
        a withUTC = aVar.withUTC();
        if (withUTC == getChronology()) {
            return this;
        }
        TimeOfDay timeOfDay = new TimeOfDay(this, withUTC);
        withUTC.validate(timeOfDay, getValues());
        return timeOfDay;
    }

    public TimeOfDay withField(DateTimeFieldType dateTimeFieldType, int i3) {
        int indexOfSupported = indexOfSupported(dateTimeFieldType);
        if (i3 == getValue(indexOfSupported)) {
            return this;
        }
        return new TimeOfDay(this, getField(indexOfSupported).set(this, indexOfSupported, getValues(), i3));
    }

    public TimeOfDay withFieldAdded(DurationFieldType durationFieldType, int i3) {
        int indexOfSupported = indexOfSupported(durationFieldType);
        if (i3 == 0) {
            return this;
        }
        return new TimeOfDay(this, getField(indexOfSupported).addWrapPartial(this, indexOfSupported, getValues(), i3));
    }

    public TimeOfDay withHourOfDay(int i3) {
        return new TimeOfDay(this, getChronology().hourOfDay().set(this, 0, getValues(), i3));
    }

    public TimeOfDay withMillisOfSecond(int i3) {
        return new TimeOfDay(this, getChronology().millisOfSecond().set(this, 3, getValues(), i3));
    }

    public TimeOfDay withMinuteOfHour(int i3) {
        return new TimeOfDay(this, getChronology().minuteOfHour().set(this, 1, getValues(), i3));
    }

    public TimeOfDay withPeriodAdded(k kVar, int i3) {
        if (kVar == null || i3 == 0) {
            return this;
        }
        int[] values = getValues();
        for (int i10 = 0; i10 < kVar.size(); i10++) {
            int indexOf = indexOf(kVar.getFieldType(i10));
            if (indexOf >= 0) {
                values = getField(indexOf).addWrapPartial(this, indexOf, values, nf.e(kVar.getValue(i10), i3));
            }
        }
        return new TimeOfDay(this, values);
    }

    public TimeOfDay withSecondOfMinute(int i3) {
        return new TimeOfDay(this, getChronology().secondOfMinute().set(this, 2, getValues(), i3));
    }

    public TimeOfDay(DateTimeZone dateTimeZone) {
        super(ISOChronology.getInstance(dateTimeZone));
    }

    public static TimeOfDay fromMillisOfDay(long j4, a aVar) {
        AtomicReference atomicReference = c.f17022a;
        if (aVar == null) {
            aVar = ISOChronology.getInstance();
        }
        return new TimeOfDay(j4, aVar.withUTC());
    }

    public DateTime toDateTimeToday(DateTimeZone dateTimeZone) {
        a withZone = getChronology().withZone(dateTimeZone);
        AtomicReference atomicReference = c.f17022a;
        return new DateTime(withZone.set(this, System.currentTimeMillis()), withZone);
    }

    @Deprecated
    public static class Property extends org.joda.time.field.a implements Serializable {
        private static final long serialVersionUID = 5598459141741063833L;
        private final int iFieldIndex;
        private final TimeOfDay iTimeOfDay;

        public Property(TimeOfDay timeOfDay, int i3) {
            this.iTimeOfDay = timeOfDay;
            this.iFieldIndex = i3;
        }

        public TimeOfDay addNoWrapToCopy(int i3) {
            return new TimeOfDay(this.iTimeOfDay, getField().add(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i3));
        }

        public TimeOfDay addToCopy(int i3) {
            return new TimeOfDay(this.iTimeOfDay, getField().addWrapPartial(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i3));
        }

        public TimeOfDay addWrapFieldToCopy(int i3) {
            return new TimeOfDay(this.iTimeOfDay, getField().addWrapField(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i3));
        }

        @Override // org.joda.time.field.a
        public int get() {
            return this.iTimeOfDay.getValue(this.iFieldIndex);
        }

        @Override // org.joda.time.field.a
        public b getField() {
            return this.iTimeOfDay.getField(this.iFieldIndex);
        }

        @Override // org.joda.time.field.a
        public j getReadablePartial() {
            return this.iTimeOfDay;
        }

        public TimeOfDay getTimeOfDay() {
            return this.iTimeOfDay;
        }

        public TimeOfDay setCopy(int i3) {
            return new TimeOfDay(this.iTimeOfDay, getField().set(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), i3));
        }

        public TimeOfDay withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public TimeOfDay withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public TimeOfDay setCopy(String str, Locale locale) {
            return new TimeOfDay(this.iTimeOfDay, getField().set(this.iTimeOfDay, this.iFieldIndex, this.iTimeOfDay.getValues(), str, locale));
        }

        public TimeOfDay setCopy(String str) {
            return setCopy(str, null);
        }
    }

    public TimeOfDay(a aVar) {
        super(aVar);
    }

    public TimeOfDay(long j4) {
        super(j4);
    }

    public TimeOfDay(long j4, a aVar) {
        super(j4, aVar);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimeOfDay(Object obj, a aVar) {
        super(obj, aVar == null ? ISOChronology.getInstance() : aVar, v.f17233c0);
        AtomicReference atomicReference = c.f17022a;
    }

    public TimeOfDay(int i3, int i10) {
        this(i3, i10, 0, 0, null);
    }

    public TimeOfDay(int i3, int i10, a aVar) {
        this(i3, i10, 0, 0, aVar);
    }

    public TimeOfDay(int i3, int i10, int i11) {
        this(i3, i10, i11, 0, null);
    }

    public TimeOfDay(int i3, int i10, int i11, a aVar) {
        this(i3, i10, i11, 0, aVar);
    }

    public TimeOfDay(int i3, int i10, int i11, int i12) {
        this(i3, i10, i11, i12, null);
    }

    public TimeOfDay(int i3, int i10, int i11, int i12, a aVar) {
        super(new int[]{i3, i10, i11, i12}, aVar);
    }

    public TimeOfDay(TimeOfDay timeOfDay, int[] iArr) {
        super(timeOfDay, iArr);
    }

    public TimeOfDay(TimeOfDay timeOfDay, a aVar) {
        super((BasePartial) timeOfDay, aVar);
    }

    public TimeOfDay(Object obj) {
        super(obj, null, v.f17233c0);
    }
}
