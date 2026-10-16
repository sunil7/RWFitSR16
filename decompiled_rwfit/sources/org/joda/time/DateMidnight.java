package org.joda.time;

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

@Deprecated
/* loaded from: classes2.dex */
public final class DateMidnight extends BaseDateTime implements Serializable {
    private static final long serialVersionUID = 156371964018738L;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = 257629620;
        private b iField;
        private DateMidnight iInstant;

        public Property(DateMidnight dateMidnight, b bVar) {
            this.iInstant = dateMidnight;
            this.iField = bVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (DateMidnight) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public DateMidnight addToCopy(int i3) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.add(dateMidnight.getMillis(), i3));
        }

        public DateMidnight addWrapFieldToCopy(int i3) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.addWrapField(dateMidnight.getMillis(), i3));
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public a getChronology() {
            return this.iInstant.getChronology();
        }

        public DateMidnight getDateMidnight() {
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

        public DateMidnight roundCeilingCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundCeiling(dateMidnight.getMillis()));
        }

        public DateMidnight roundFloorCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundFloor(dateMidnight.getMillis()));
        }

        public DateMidnight roundHalfCeilingCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundHalfCeiling(dateMidnight.getMillis()));
        }

        public DateMidnight roundHalfEvenCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundHalfEven(dateMidnight.getMillis()));
        }

        public DateMidnight roundHalfFloorCopy() {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.roundHalfFloor(dateMidnight.getMillis()));
        }

        public DateMidnight setCopy(int i3) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.set(dateMidnight.getMillis(), i3));
        }

        public DateMidnight withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public DateMidnight withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public DateMidnight addToCopy(long j4) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.add(dateMidnight.getMillis(), j4));
        }

        public DateMidnight setCopy(String str, Locale locale) {
            DateMidnight dateMidnight = this.iInstant;
            return dateMidnight.withMillis(this.iField.set(dateMidnight.getMillis(), str, locale));
        }

        public DateMidnight setCopy(String str) {
            return setCopy(str, null);
        }
    }

    public DateMidnight() {
    }

    public static DateMidnight now() {
        return new DateMidnight();
    }

    public static DateMidnight parse(String str, org.joda.time.format.b bVar) {
        return bVar.a(str).toDateMidnight();
    }

    public Property centuryOfEra() {
        return new Property(this, getChronology().centuryOfEra());
    }

    @Override // org.joda.time.base.BaseDateTime
    public long checkInstant(long j4, a aVar) {
        return aVar.dayOfMonth().roundFloor(j4);
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

    public DateMidnight minus(long j4) {
        return withDurationAdded(j4, -1);
    }

    public DateMidnight minusDays(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().days().subtract(getMillis(), i3));
    }

    public DateMidnight minusMonths(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().months().subtract(getMillis(), i3));
    }

    public DateMidnight minusWeeks(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().weeks().subtract(getMillis(), i3));
    }

    public DateMidnight minusYears(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().years().subtract(getMillis(), i3));
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
    }

    public DateMidnight plus(long j4) {
        return withDurationAdded(j4, 1);
    }

    public DateMidnight plusDays(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().days().add(getMillis(), i3));
    }

    public DateMidnight plusMonths(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().months().add(getMillis(), i3));
    }

    public DateMidnight plusWeeks(int i3) {
        return i3 == 0 ? this : withMillis(getChronology().weeks().add(getMillis(), i3));
    }

    public DateMidnight plusYears(int i3) {
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

    public Interval toInterval() {
        a chronology = getChronology();
        long millis = getMillis();
        return new Interval(millis, DurationFieldType.days().getField(chronology).add(millis, 1), chronology);
    }

    public LocalDate toLocalDate() {
        return new LocalDate(getMillis(), getChronology());
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

    public DateMidnight withCenturyOfEra(int i3) {
        return withMillis(getChronology().centuryOfEra().set(getMillis(), i3));
    }

    public DateMidnight withChronology(a aVar) {
        return aVar == getChronology() ? this : new DateMidnight(getMillis(), aVar);
    }

    public DateMidnight withDayOfMonth(int i3) {
        return withMillis(getChronology().dayOfMonth().set(getMillis(), i3));
    }

    public DateMidnight withDayOfWeek(int i3) {
        return withMillis(getChronology().dayOfWeek().set(getMillis(), i3));
    }

    public DateMidnight withDayOfYear(int i3) {
        return withMillis(getChronology().dayOfYear().set(getMillis(), i3));
    }

    public DateMidnight withDurationAdded(long j4, int i3) {
        return (j4 == 0 || i3 == 0) ? this : withMillis(getChronology().add(getMillis(), j4, i3));
    }

    public DateMidnight withEra(int i3) {
        return withMillis(getChronology().era().set(getMillis(), i3));
    }

    public DateMidnight withField(DateTimeFieldType dateTimeFieldType, int i3) {
        if (dateTimeFieldType != null) {
            return withMillis(dateTimeFieldType.getField(getChronology()).set(getMillis(), i3));
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public DateMidnight withFieldAdded(DurationFieldType durationFieldType, int i3) {
        if (durationFieldType != null) {
            return i3 == 0 ? this : withMillis(durationFieldType.getField(getChronology()).add(getMillis(), i3));
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public DateMidnight withFields(j jVar) {
        return jVar == null ? this : withMillis(getChronology().set(jVar, getMillis()));
    }

    public DateMidnight withMillis(long j4) {
        a chronology = getChronology();
        long checkInstant = checkInstant(j4, chronology);
        return checkInstant == getMillis() ? this : new DateMidnight(checkInstant, chronology);
    }

    public DateMidnight withMonthOfYear(int i3) {
        return withMillis(getChronology().monthOfYear().set(getMillis(), i3));
    }

    public DateMidnight withPeriodAdded(k kVar, int i3) {
        return (kVar == null || i3 == 0) ? this : withMillis(getChronology().add(kVar, getMillis(), i3));
    }

    public DateMidnight withWeekOfWeekyear(int i3) {
        return withMillis(getChronology().weekOfWeekyear().set(getMillis(), i3));
    }

    public DateMidnight withWeekyear(int i3) {
        return withMillis(getChronology().weekyear().set(getMillis(), i3));
    }

    public DateMidnight withYear(int i3) {
        return withMillis(getChronology().year().set(getMillis(), i3));
    }

    public DateMidnight withYearOfCentury(int i3) {
        return withMillis(getChronology().yearOfCentury().set(getMillis(), i3));
    }

    public DateMidnight withYearOfEra(int i3) {
        return withMillis(getChronology().yearOfEra().set(getMillis(), i3));
    }

    public DateMidnight withZoneRetainFields(DateTimeZone dateTimeZone) {
        AtomicReference atomicReference = c.f17022a;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        DateTimeZone zone = getZone();
        if (zone == null) {
            zone = DateTimeZone.getDefault();
        }
        return dateTimeZone == zone ? this : new DateMidnight(zone.getMillisKeepLocal(dateTimeZone, getMillis()), getChronology().withZone(dateTimeZone));
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

    public DateMidnight(DateTimeZone dateTimeZone) {
        super(dateTimeZone);
    }

    public static DateMidnight now(DateTimeZone dateTimeZone) {
        if (dateTimeZone != null) {
            return new DateMidnight(dateTimeZone);
        }
        throw new NullPointerException("Zone must not be null");
    }

    @FromString
    public static DateMidnight parse(String str) {
        return parse(str, v.f17236e0.j());
    }

    public DateMidnight minus(g gVar) {
        return withDurationAdded(gVar, -1);
    }

    public DateMidnight plus(g gVar) {
        return withDurationAdded(gVar, 1);
    }

    public DateMidnight(a aVar) {
        super(aVar);
    }

    public DateMidnight minus(k kVar) {
        return withPeriodAdded(kVar, -1);
    }

    public DateMidnight plus(k kVar) {
        return withPeriodAdded(kVar, 1);
    }

    public DateMidnight withDurationAdded(g gVar, int i3) {
        return (gVar == null || i3 == 0) ? this : withDurationAdded(gVar.getMillis(), i3);
    }

    public DateMidnight(long j4) {
        super(j4);
    }

    public static DateMidnight now(a aVar) {
        if (aVar != null) {
            return new DateMidnight(aVar);
        }
        throw new NullPointerException("Chronology must not be null");
    }

    public DateMidnight(long j4, DateTimeZone dateTimeZone) {
        super(j4, dateTimeZone);
    }

    public DateMidnight(long j4, a aVar) {
        super(j4, aVar);
    }

    public DateMidnight(Object obj) {
        super(obj, (a) null);
    }

    public DateMidnight(Object obj, DateTimeZone dateTimeZone) {
        super(obj, dateTimeZone);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DateMidnight(Object obj, a aVar) {
        super(obj, aVar == null ? ISOChronology.getInstance() : aVar);
        AtomicReference atomicReference = c.f17022a;
    }

    public DateMidnight(int i3, int i10, int i11) {
        super(i3, i10, i11, 0, 0, 0, 0);
    }

    public DateMidnight(int i3, int i10, int i11, DateTimeZone dateTimeZone) {
        super(i3, i10, i11, 0, 0, 0, 0, dateTimeZone);
    }

    public DateMidnight(int i3, int i10, int i11, a aVar) {
        super(i3, i10, i11, 0, 0, 0, 0, aVar);
    }
}
