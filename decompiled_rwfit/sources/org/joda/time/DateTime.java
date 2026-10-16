package org.joda.time;

import com.autonavi.aps.amapapi.config.Const;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.time.base.BaseDateTime;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractReadableInstantFieldProperty;
import org.joda.time.format.v;

/* loaded from: classes2.dex */
public final class DateTime extends BaseDateTime implements Serializable {
    private static final long serialVersionUID = -5171125899451703815L;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -6983323811635733510L;
        private b iField;
        private DateTime iInstant;

        public Property(DateTime dateTime, b bVar) {
            this.iInstant = dateTime;
            this.iField = bVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (DateTime) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public DateTime addToCopy(int i3) {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.add(dateTime.getMillis(), i3));
        }

        public DateTime addWrapFieldToCopy(int i3) {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.addWrapField(dateTime.getMillis(), i3));
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public a getChronology() {
            return this.iInstant.getChronology();
        }

        public DateTime getDateTime() {
            return this.iInstant;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public b getField() {
            return this.iField;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public long getMillis() {
            return this.iInstant.getMillis();
        }

        public DateTime roundCeilingCopy() {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.roundCeiling(dateTime.getMillis()));
        }

        public DateTime roundFloorCopy() {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.roundFloor(dateTime.getMillis()));
        }

        public DateTime roundHalfCeilingCopy() {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.roundHalfCeiling(dateTime.getMillis()));
        }

        public DateTime roundHalfEvenCopy() {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.roundHalfEven(dateTime.getMillis()));
        }

        public DateTime roundHalfFloorCopy() {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.roundHalfFloor(dateTime.getMillis()));
        }

        public DateTime setCopy(int i3) {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.set(dateTime.getMillis(), i3));
        }

        public DateTime withMaximumValue() {
            try {
                return setCopy(getMaximumValue());
            } catch (RuntimeException e) {
                if (IllegalInstantException.isIllegalInstant(e)) {
                    return new DateTime(getChronology().getZone().previousTransition(getMillis() + Const.DAY_IN_MILLIS), getChronology());
                }
                throw e;
            }
        }

        public DateTime withMinimumValue() {
            try {
                return setCopy(getMinimumValue());
            } catch (RuntimeException e) {
                if (IllegalInstantException.isIllegalInstant(e)) {
                    return new DateTime(getChronology().getZone().nextTransition(getMillis() - Const.DAY_IN_MILLIS), getChronology());
                }
                throw e;
            }
        }

        public DateTime addToCopy(long j4) {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.add(dateTime.getMillis(), j4));
        }

        public DateTime setCopy(String str, Locale locale) {
            DateTime dateTime = this.iInstant;
            return dateTime.withMillis(this.iField.set(dateTime.getMillis(), str, locale));
        }

        public DateTime setCopy(String str) {
            return setCopy(str, null);
        }
    }

    public DateTime() {
    }

    public static DateTime now() {
        return new DateTime();
    }

    public static DateTime parse(String str, org.joda.time.format.b bVar) {
        return bVar.a(str);
    }

    public Property centuryOfEra() {
        return new Property(this, getChronology().centuryOfEra());
    }

    public Property dayOfMonth() {
        return new Property(this, getChronology().dayOfMonth());
    }

    public Property dayOfWeek() {
        return new Property(this, getChronology().dayOfWeek());
    }

    public Property dayOfYear() {
        return new Property(this, getChronology().dayOfYear());
    }

    public Property era() {
        return new Property(this, getChronology().era());
    }

    public Property hourOfDay() {
        return new Property(this, getChronology().hourOfDay());
    }

    public Property millisOfDay() {
        return new Property(this, getChronology().millisOfDay());
    }

    public Property millisOfSecond() {
        return new Property(this, getChronology().millisOfSecond());
    }

    public DateTime minus(long j4) {
        return withDurationAdded(j4, -1);
    }

    public DateTime minusDays(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().days().subtract(getMillis(), i3));
    }

    public DateTime minusHours(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().hours().subtract(getMillis(), i3));
    }

    public DateTime minusMillis(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().millis().subtract(getMillis(), i3));
    }

    public DateTime minusMinutes(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().minutes().subtract(getMillis(), i3));
    }

    public DateTime minusMonths(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().months().subtract(getMillis(), i3));
    }

    public DateTime minusSeconds(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().seconds().subtract(getMillis(), i3));
    }

    public DateTime minusWeeks(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().weeks().subtract(getMillis(), i3));
    }

    public DateTime minusYears(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().years().subtract(getMillis(), i3));
    }

    public Property minuteOfDay() {
        return new Property(this, getChronology().minuteOfDay());
    }

    public Property minuteOfHour() {
        return new Property(this, getChronology().minuteOfHour());
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
    }

    public DateTime plus(long j4) {
        return withDurationAdded(j4, 1);
    }

    public DateTime plusDays(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().days().add(getMillis(), i3));
    }

    public DateTime plusHours(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().hours().add(getMillis(), i3));
    }

    public DateTime plusMillis(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().millis().add(getMillis(), i3));
    }

    public DateTime plusMinutes(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().minutes().add(getMillis(), i3));
    }

    public DateTime plusMonths(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().months().add(getMillis(), i3));
    }

    public DateTime plusSeconds(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().seconds().add(getMillis(), i3));
    }

    public DateTime plusWeeks(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().weeks().add(getMillis(), i3));
    }

    public DateTime plusYears(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().years().add(getMillis(), i3));
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        }
        b field = dateTimeFieldType.getField(getChronology());
        if (field.isSupported()) {
            return new Property(this, field);
        }
        throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
    }

    public Property secondOfDay() {
        return new Property(this, getChronology().secondOfDay());
    }

    public Property secondOfMinute() {
        return new Property(this, getChronology().secondOfMinute());
    }

    @Deprecated
    public DateMidnight toDateMidnight() {
        return new DateMidnight(getMillis(), getChronology());
    }

    @Override // ai.c, org.joda.time.f
    public DateTime toDateTime() {
        return this;
    }

    @Override // ai.c
    public DateTime toDateTimeISO() {
        return getChronology() == ISOChronology.getInstance() ? this : super.toDateTimeISO();
    }

    public LocalDate toLocalDate() {
        return new LocalDate(getMillis(), getChronology());
    }

    public LocalDateTime toLocalDateTime() {
        return new LocalDateTime(getMillis(), getChronology());
    }

    public LocalTime toLocalTime() {
        return new LocalTime(getMillis(), getChronology());
    }

    @Deprecated
    public TimeOfDay toTimeOfDay() {
        return new TimeOfDay(getMillis(), getChronology());
    }

    @Deprecated
    public YearMonthDay toYearMonthDay() {
        return new YearMonthDay(getMillis(), getChronology());
    }

    public Property weekOfWeekyear() {
        return new Property(this, getChronology().weekOfWeekyear());
    }

    public Property weekyear() {
        return new Property(this, getChronology().weekyear());
    }

    public DateTime withCenturyOfEra(int i3) {
        return withMillis(getChronology().centuryOfEra().set(getMillis(), i3));
    }

    public DateTime withChronology(a aVar) {
        AtomicReference atomicReference = c.f17022a;
        if (aVar == null) {
            aVar = ISOChronology.getInstance();
        }
        return aVar == getChronology() ? this : new DateTime(getMillis(), aVar);
    }

    public DateTime withDate(int i3, int i10, int i11) {
        a chronology = getChronology();
        return withMillis(chronology.getZone().convertLocalToUTC(chronology.withUTC().getDateTimeMillis(i3, i10, i11, getMillisOfDay()), false, getMillis()));
    }

    public DateTime withDayOfMonth(int i3) {
        return withMillis(getChronology().dayOfMonth().set(getMillis(), i3));
    }

    public DateTime withDayOfWeek(int i3) {
        return withMillis(getChronology().dayOfWeek().set(getMillis(), i3));
    }

    public DateTime withDayOfYear(int i3) {
        return withMillis(getChronology().dayOfYear().set(getMillis(), i3));
    }

    public DateTime withDurationAdded(long j4, int i3) {
        return (j4 == 0 || i3 == 0) ? this : withMillis(getChronology().add(getMillis(), j4, i3));
    }

    public DateTime withEarlierOffsetAtOverlap() {
        return withMillis(getZone().adjustOffset(getMillis(), false));
    }

    public DateTime withEra(int i3) {
        return withMillis(getChronology().era().set(getMillis(), i3));
    }

    public DateTime withField(DateTimeFieldType dateTimeFieldType, int i3) {
        if (dateTimeFieldType != null) {
            return withMillis(dateTimeFieldType.getField(getChronology()).set(getMillis(), i3));
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public DateTime withFieldAdded(DurationFieldType durationFieldType, int i3) {
        if (durationFieldType != null) {
            return i3 == 0 ? this : withMillis(durationFieldType.getField(getChronology()).add(getMillis(), i3));
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public DateTime withFields(j jVar) {
        return jVar == null ? this : withMillis(getChronology().set(jVar, getMillis()));
    }

    public DateTime withHourOfDay(int i3) {
        return withMillis(getChronology().hourOfDay().set(getMillis(), i3));
    }

    public DateTime withLaterOffsetAtOverlap() {
        return withMillis(getZone().adjustOffset(getMillis(), true));
    }

    public DateTime withMillis(long j4) {
        return j4 == getMillis() ? this : new DateTime(j4, getChronology());
    }

    public DateTime withMillisOfDay(int i3) {
        return withMillis(getChronology().millisOfDay().set(getMillis(), i3));
    }

    public DateTime withMillisOfSecond(int i3) {
        return withMillis(getChronology().millisOfSecond().set(getMillis(), i3));
    }

    public DateTime withMinuteOfHour(int i3) {
        return withMillis(getChronology().minuteOfHour().set(getMillis(), i3));
    }

    public DateTime withMonthOfYear(int i3) {
        return withMillis(getChronology().monthOfYear().set(getMillis(), i3));
    }

    public DateTime withPeriodAdded(k kVar, int i3) {
        return (kVar == null || i3 == 0) ? this : withMillis(getChronology().add(kVar, getMillis(), i3));
    }

    public DateTime withSecondOfMinute(int i3) {
        return withMillis(getChronology().secondOfMinute().set(getMillis(), i3));
    }

    public DateTime withTime(int i3, int i10, int i11, int i12) {
        a chronology = getChronology();
        return withMillis(chronology.getZone().convertLocalToUTC(chronology.withUTC().getDateTimeMillis(getYear(), getMonthOfYear(), getDayOfMonth(), i3, i10, i11, i12), false, getMillis()));
    }

    public DateTime withTimeAtStartOfDay() {
        return toLocalDate().toDateTimeAtStartOfDay(getZone());
    }

    public DateTime withWeekOfWeekyear(int i3) {
        return withMillis(getChronology().weekOfWeekyear().set(getMillis(), i3));
    }

    public DateTime withWeekyear(int i3) {
        return withMillis(getChronology().weekyear().set(getMillis(), i3));
    }

    public DateTime withYear(int i3) {
        return withMillis(getChronology().year().set(getMillis(), i3));
    }

    public DateTime withYearOfCentury(int i3) {
        return withMillis(getChronology().yearOfCentury().set(getMillis(), i3));
    }

    public DateTime withYearOfEra(int i3) {
        return withMillis(getChronology().yearOfEra().set(getMillis(), i3));
    }

    public DateTime withZone(DateTimeZone dateTimeZone) {
        return withChronology(getChronology().withZone(dateTimeZone));
    }

    public DateTime withZoneRetainFields(DateTimeZone dateTimeZone) {
        AtomicReference atomicReference = c.f17022a;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        DateTimeZone zone = getZone();
        if (zone == null) {
            zone = DateTimeZone.getDefault();
        }
        return dateTimeZone == zone ? this : new DateTime(zone.getMillisKeepLocal(dateTimeZone, getMillis()), getChronology().withZone(dateTimeZone));
    }

    public Property year() {
        return new Property(this, getChronology().year());
    }

    public Property yearOfCentury() {
        return new Property(this, getChronology().yearOfCentury());
    }

    public Property yearOfEra() {
        return new Property(this, getChronology().yearOfEra());
    }

    public DateTime(DateTimeZone dateTimeZone) {
        super(dateTimeZone);
    }

    public static DateTime now(DateTimeZone dateTimeZone) {
        if (dateTimeZone != null) {
            return new DateTime(dateTimeZone);
        }
        throw new NullPointerException("Zone must not be null");
    }

    @FromString
    public static DateTime parse(String str) {
        return parse(str, v.f17236e0.j());
    }

    public DateTime minus(g gVar) {
        return withDurationAdded(gVar, -1);
    }

    public DateTime plus(g gVar) {
        return withDurationAdded(gVar, 1);
    }

    @Override // ai.c
    public DateTime toDateTime(DateTimeZone dateTimeZone) {
        AtomicReference atomicReference = c.f17022a;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return getZone() == dateTimeZone ? this : super.toDateTime(dateTimeZone);
    }

    public DateTime(a aVar) {
        super(aVar);
    }

    public DateTime minus(k kVar) {
        return withPeriodAdded(kVar, -1);
    }

    public DateTime plus(k kVar) {
        return withPeriodAdded(kVar, 1);
    }

    public DateTime withDurationAdded(g gVar, int i3) {
        return (gVar == null || i3 == 0) ? this : withDurationAdded(gVar.getMillis(), i3);
    }

    public DateTime(long j4) {
        super(j4);
    }

    public static DateTime now(a aVar) {
        if (aVar != null) {
            return new DateTime(aVar);
        }
        throw new NullPointerException("Chronology must not be null");
    }

    public DateTime withDate(LocalDate localDate) {
        return withDate(localDate.getYear(), localDate.getMonthOfYear(), localDate.getDayOfMonth());
    }

    public DateTime(long j4, DateTimeZone dateTimeZone) {
        super(j4, dateTimeZone);
    }

    public DateTime(long j4, a aVar) {
        super(j4, aVar);
    }

    @Override // ai.c
    public DateTime toDateTime(a aVar) {
        AtomicReference atomicReference = c.f17022a;
        if (aVar == null) {
            aVar = ISOChronology.getInstance();
        }
        return getChronology() == aVar ? this : super.toDateTime(aVar);
    }

    public DateTime withTime(LocalTime localTime) {
        return withTime(localTime.getHourOfDay(), localTime.getMinuteOfHour(), localTime.getSecondOfMinute(), localTime.getMillisOfSecond());
    }

    public DateTime(Object obj) {
        super(obj, (a) null);
    }

    public DateTime(Object obj, DateTimeZone dateTimeZone) {
        super(obj, dateTimeZone);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateTime(Object obj, a aVar) {
        super(obj, aVar == null ? ISOChronology.getInstance() : aVar);
        AtomicReference atomicReference = c.f17022a;
    }

    public DateTime(int i3, int i10, int i11, int i12, int i13) {
        super(i3, i10, i11, i12, i13, 0, 0);
    }

    public DateTime(int i3, int i10, int i11, int i12, int i13, DateTimeZone dateTimeZone) {
        super(i3, i10, i11, i12, i13, 0, 0, dateTimeZone);
    }

    public DateTime(int i3, int i10, int i11, int i12, int i13, a aVar) {
        super(i3, i10, i11, i12, i13, 0, 0, aVar);
    }

    public DateTime(int i3, int i10, int i11, int i12, int i13, int i14) {
        super(i3, i10, i11, i12, i13, i14, 0);
    }

    public DateTime(int i3, int i10, int i11, int i12, int i13, int i14, DateTimeZone dateTimeZone) {
        super(i3, i10, i11, i12, i13, i14, 0, dateTimeZone);
    }

    public DateTime(int i3, int i10, int i11, int i12, int i13, int i14, a aVar) {
        super(i3, i10, i11, i12, i13, i14, 0, aVar);
    }

    public DateTime(int i3, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(i3, i10, i11, i12, i13, i14, i15);
    }

    public DateTime(int i3, int i10, int i11, int i12, int i13, int i14, int i15, DateTimeZone dateTimeZone) {
        super(i3, i10, i11, i12, i13, i14, i15, dateTimeZone);
    }

    public DateTime(int i3, int i10, int i11, int i12, int i13, int i14, int i15, a aVar) {
        super(i3, i10, i11, i12, i13, i14, i15, aVar);
    }
}
