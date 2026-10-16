package org.joda.time;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractReadableInstantFieldProperty;
import org.joda.time.format.v;

/* loaded from: classes2.dex */
public final class LocalDateTime extends ai.g implements Serializable {
    private static final long serialVersionUID = -268716875315837168L;
    private final a iChronology;
    private final long iLocalMillis;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -358138762846288L;

        /* renamed from: a, reason: collision with root package name */
        public transient LocalDateTime f16995a;

        /* renamed from: b, reason: collision with root package name */
        public transient b f16996b;

        public Property(LocalDateTime localDateTime, b bVar) {
            this.f16995a = localDateTime;
            this.f16996b = bVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.f16995a = (LocalDateTime) objectInputStream.readObject();
            this.f16996b = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.f16995a.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.f16995a);
            objectOutputStream.writeObject(this.f16996b.getType());
        }

        public LocalDateTime addToCopy(int i3) {
            LocalDateTime localDateTime = this.f16995a;
            return localDateTime.withLocalMillis(this.f16996b.add(localDateTime.getLocalMillis(), i3));
        }

        public LocalDateTime addWrapFieldToCopy(int i3) {
            LocalDateTime localDateTime = this.f16995a;
            return localDateTime.withLocalMillis(this.f16996b.addWrapField(localDateTime.getLocalMillis(), i3));
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public a getChronology() {
            return this.f16995a.getChronology();
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public b getField() {
            return this.f16996b;
        }

        public LocalDateTime getLocalDateTime() {
            return this.f16995a;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public long getMillis() {
            return this.f16995a.getLocalMillis();
        }

        public LocalDateTime roundCeilingCopy() {
            LocalDateTime localDateTime = this.f16995a;
            return localDateTime.withLocalMillis(this.f16996b.roundCeiling(localDateTime.getLocalMillis()));
        }

        public LocalDateTime roundFloorCopy() {
            LocalDateTime localDateTime = this.f16995a;
            return localDateTime.withLocalMillis(this.f16996b.roundFloor(localDateTime.getLocalMillis()));
        }

        public LocalDateTime roundHalfCeilingCopy() {
            LocalDateTime localDateTime = this.f16995a;
            return localDateTime.withLocalMillis(this.f16996b.roundHalfCeiling(localDateTime.getLocalMillis()));
        }

        public LocalDateTime roundHalfEvenCopy() {
            LocalDateTime localDateTime = this.f16995a;
            return localDateTime.withLocalMillis(this.f16996b.roundHalfEven(localDateTime.getLocalMillis()));
        }

        public LocalDateTime roundHalfFloorCopy() {
            LocalDateTime localDateTime = this.f16995a;
            return localDateTime.withLocalMillis(this.f16996b.roundHalfFloor(localDateTime.getLocalMillis()));
        }

        public LocalDateTime setCopy(int i3) {
            LocalDateTime localDateTime = this.f16995a;
            return localDateTime.withLocalMillis(this.f16996b.set(localDateTime.getLocalMillis(), i3));
        }

        public LocalDateTime withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public LocalDateTime withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public LocalDateTime addToCopy(long j4) {
            LocalDateTime localDateTime = this.f16995a;
            return localDateTime.withLocalMillis(this.f16996b.add(localDateTime.getLocalMillis(), j4));
        }

        public LocalDateTime setCopy(String str, Locale locale) {
            LocalDateTime localDateTime = this.f16995a;
            return localDateTime.withLocalMillis(this.f16996b.set(localDateTime.getLocalMillis(), str, locale));
        }

        public LocalDateTime setCopy(String str) {
            return setCopy(str, null);
        }
    }

    public LocalDateTime(int i3, int i10, int i11, int i12, int i13, int i14, int i15, a aVar) {
        AtomicReference atomicReference = c.f17022a;
        a withUTC = (aVar == null ? ISOChronology.getInstance() : aVar).withUTC();
        long dateTimeMillis = withUTC.getDateTimeMillis(i3, i10, i11, i12, i13, i14, i15);
        this.iChronology = withUTC;
        this.iLocalMillis = dateTimeMillis;
    }

    public static LocalDateTime fromCalendarFields(Calendar calendar) {
        if (calendar == null) {
            throw new IllegalArgumentException("The calendar must not be null");
        }
        int i3 = calendar.get(0);
        int i10 = calendar.get(1);
        if (i3 != 1) {
            i10 = 1 - i10;
        }
        return new LocalDateTime(i10, calendar.get(2) + 1, calendar.get(5), calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14));
    }

    public static LocalDateTime fromDateFields(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        if (date.getTime() >= 0) {
            return new LocalDateTime(date.getYear() + 1900, date.getMonth() + 1, date.getDate(), date.getHours(), date.getMinutes(), date.getSeconds(), (((int) (date.getTime() % 1000)) + 1000) % 1000);
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return fromCalendarFields(gregorianCalendar);
    }

    public static LocalDateTime now() {
        return new LocalDateTime();
    }

    public static LocalDateTime parse(String str, org.joda.time.format.b bVar) {
        return bVar.b(str);
    }

    private Object readResolve() {
        a aVar = this.iChronology;
        return aVar == null ? new LocalDateTime(this.iLocalMillis, ISOChronology.getInstanceUTC()) : !DateTimeZone.UTC.equals(aVar.getZone()) ? new LocalDateTime(this.iLocalMillis, this.iChronology.withUTC()) : this;
    }

    public final Date a(Date date, TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.setTime(date);
        LocalDateTime fromCalendarFields = fromCalendarFields(calendar);
        if (fromCalendarFields.isBefore(this)) {
            while (fromCalendarFields.isBefore(this)) {
                calendar.setTimeInMillis(calendar.getTimeInMillis() + 60000);
                fromCalendarFields = fromCalendarFields(calendar);
            }
            while (!fromCalendarFields.isBefore(this)) {
                calendar.setTimeInMillis(calendar.getTimeInMillis() - 1000);
                fromCalendarFields = fromCalendarFields(calendar);
            }
            calendar.setTimeInMillis(calendar.getTimeInMillis() + 1000);
        } else if (fromCalendarFields.equals(this)) {
            Calendar calendar2 = Calendar.getInstance(timeZone);
            calendar2.setTimeInMillis(calendar.getTimeInMillis() - timeZone.getDSTSavings());
            if (fromCalendarFields(calendar2).equals(this)) {
                calendar = calendar2;
            }
        }
        return calendar.getTime();
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

    @Override // ai.e
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) obj;
            if (this.iChronology.equals(localDateTime.iChronology)) {
                return this.iLocalMillis == localDateTime.iLocalMillis;
            }
        }
        return super.equals(obj);
    }

    public Property era() {
        return new Property(this, getChronology().era());
    }

    @Override // ai.e, org.joda.time.j
    public int get(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType != null) {
            return dateTimeFieldType.getField(getChronology()).get(getLocalMillis());
        }
        throw new IllegalArgumentException("The DateTimeFieldType must not be null");
    }

    public int getCenturyOfEra() {
        return getChronology().centuryOfEra().get(getLocalMillis());
    }

    @Override // org.joda.time.j
    public a getChronology() {
        return this.iChronology;
    }

    public int getDayOfMonth() {
        return getChronology().dayOfMonth().get(getLocalMillis());
    }

    public int getDayOfWeek() {
        return getChronology().dayOfWeek().get(getLocalMillis());
    }

    public int getDayOfYear() {
        return getChronology().dayOfYear().get(getLocalMillis());
    }

    public int getEra() {
        return getChronology().era().get(getLocalMillis());
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
        if (i3 == 3) {
            return aVar.millisOfDay();
        }
        throw new IndexOutOfBoundsException(l0.j(i3, "Invalid index: "));
    }

    public int getHourOfDay() {
        return getChronology().hourOfDay().get(getLocalMillis());
    }

    @Override // ai.g
    public long getLocalMillis() {
        return this.iLocalMillis;
    }

    public int getMillisOfDay() {
        return getChronology().millisOfDay().get(getLocalMillis());
    }

    public int getMillisOfSecond() {
        return getChronology().millisOfSecond().get(getLocalMillis());
    }

    public int getMinuteOfHour() {
        return getChronology().minuteOfHour().get(getLocalMillis());
    }

    public int getMonthOfYear() {
        return getChronology().monthOfYear().get(getLocalMillis());
    }

    public int getSecondOfMinute() {
        return getChronology().secondOfMinute().get(getLocalMillis());
    }

    @Override // org.joda.time.j
    public int getValue(int i3) {
        if (i3 == 0) {
            return getChronology().year().get(getLocalMillis());
        }
        if (i3 == 1) {
            return getChronology().monthOfYear().get(getLocalMillis());
        }
        if (i3 == 2) {
            return getChronology().dayOfMonth().get(getLocalMillis());
        }
        if (i3 == 3) {
            return getChronology().millisOfDay().get(getLocalMillis());
        }
        throw new IndexOutOfBoundsException(l0.j(i3, "Invalid index: "));
    }

    public int getWeekOfWeekyear() {
        return getChronology().weekOfWeekyear().get(getLocalMillis());
    }

    public int getWeekyear() {
        return getChronology().weekyear().get(getLocalMillis());
    }

    public int getYear() {
        return getChronology().year().get(getLocalMillis());
    }

    public int getYearOfCentury() {
        return getChronology().yearOfCentury().get(getLocalMillis());
    }

    public int getYearOfEra() {
        return getChronology().yearOfEra().get(getLocalMillis());
    }

    public Property hourOfDay() {
        return new Property(this, getChronology().hourOfDay());
    }

    @Override // ai.e, org.joda.time.j
    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            return false;
        }
        return dateTimeFieldType.getField(getChronology()).isSupported();
    }

    public Property millisOfDay() {
        return new Property(this, getChronology().millisOfDay());
    }

    public Property millisOfSecond() {
        return new Property(this, getChronology().millisOfSecond());
    }

    public LocalDateTime minus(g gVar) {
        return withDurationAdded(gVar, -1);
    }

    public LocalDateTime minusDays(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().days().subtract(getLocalMillis(), i3));
    }

    public LocalDateTime minusHours(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().hours().subtract(getLocalMillis(), i3));
    }

    public LocalDateTime minusMillis(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().millis().subtract(getLocalMillis(), i3));
    }

    public LocalDateTime minusMinutes(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().minutes().subtract(getLocalMillis(), i3));
    }

    public LocalDateTime minusMonths(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().months().subtract(getLocalMillis(), i3));
    }

    public LocalDateTime minusSeconds(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().seconds().subtract(getLocalMillis(), i3));
    }

    public LocalDateTime minusWeeks(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().weeks().subtract(getLocalMillis(), i3));
    }

    public LocalDateTime minusYears(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().years().subtract(getLocalMillis(), i3));
    }

    public Property minuteOfHour() {
        return new Property(this, getChronology().minuteOfHour());
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
    }

    public LocalDateTime plus(g gVar) {
        return withDurationAdded(gVar, 1);
    }

    public LocalDateTime plusDays(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().days().add(getLocalMillis(), i3));
    }

    public LocalDateTime plusHours(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().hours().add(getLocalMillis(), i3));
    }

    public LocalDateTime plusMillis(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().millis().add(getLocalMillis(), i3));
    }

    public LocalDateTime plusMinutes(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().minutes().add(getLocalMillis(), i3));
    }

    public LocalDateTime plusMonths(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().months().add(getLocalMillis(), i3));
    }

    public LocalDateTime plusSeconds(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().seconds().add(getLocalMillis(), i3));
    }

    public LocalDateTime plusWeeks(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().weeks().add(getLocalMillis(), i3));
    }

    public LocalDateTime plusYears(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().years().add(getLocalMillis(), i3));
    }

    public Property property(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        }
        if (isSupported(dateTimeFieldType)) {
            return new Property(this, dateTimeFieldType.getField(getChronology()));
        }
        throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
    }

    public Property secondOfMinute() {
        return new Property(this, getChronology().secondOfMinute());
    }

    @Override // org.joda.time.j
    public int size() {
        return 4;
    }

    public Date toDate() {
        Date date = new Date(getYear() - 1900, getMonthOfYear() - 1, getDayOfMonth(), getHourOfDay(), getMinuteOfHour(), getSecondOfMinute());
        date.setTime(date.getTime() + getMillisOfSecond());
        return a(date, TimeZone.getDefault());
    }

    public DateTime toDateTime() {
        return toDateTime((DateTimeZone) null);
    }

    public LocalDate toLocalDate() {
        return new LocalDate(getLocalMillis(), getChronology());
    }

    public LocalTime toLocalTime() {
        return new LocalTime(getLocalMillis(), getChronology());
    }

    @ToString
    public String toString() {
        return v.E.e(this);
    }

    public Property weekOfWeekyear() {
        return new Property(this, getChronology().weekOfWeekyear());
    }

    public Property weekyear() {
        return new Property(this, getChronology().weekyear());
    }

    public LocalDateTime withCenturyOfEra(int i3) {
        return withLocalMillis(getChronology().centuryOfEra().set(getLocalMillis(), i3));
    }

    public LocalDateTime withDate(int i3, int i10, int i11) {
        a chronology = getChronology();
        return withLocalMillis(chronology.dayOfMonth().set(chronology.monthOfYear().set(chronology.year().set(getLocalMillis(), i3), i10), i11));
    }

    public LocalDateTime withDayOfMonth(int i3) {
        return withLocalMillis(getChronology().dayOfMonth().set(getLocalMillis(), i3));
    }

    public LocalDateTime withDayOfWeek(int i3) {
        return withLocalMillis(getChronology().dayOfWeek().set(getLocalMillis(), i3));
    }

    public LocalDateTime withDayOfYear(int i3) {
        return withLocalMillis(getChronology().dayOfYear().set(getLocalMillis(), i3));
    }

    public LocalDateTime withDurationAdded(g gVar, int i3) {
        return (gVar == null || i3 == 0) ? this : withLocalMillis(getChronology().add(getLocalMillis(), gVar.getMillis(), i3));
    }

    public LocalDateTime withEra(int i3) {
        return withLocalMillis(getChronology().era().set(getLocalMillis(), i3));
    }

    public LocalDateTime withField(DateTimeFieldType dateTimeFieldType, int i3) {
        if (dateTimeFieldType != null) {
            return withLocalMillis(dateTimeFieldType.getField(getChronology()).set(getLocalMillis(), i3));
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public LocalDateTime withFieldAdded(DurationFieldType durationFieldType, int i3) {
        if (durationFieldType != null) {
            return i3 == 0 ? this : withLocalMillis(durationFieldType.getField(getChronology()).add(getLocalMillis(), i3));
        }
        throw new IllegalArgumentException("Field must not be null");
    }

    public LocalDateTime withFields(j jVar) {
        return jVar == null ? this : withLocalMillis(getChronology().set(jVar, getLocalMillis()));
    }

    public LocalDateTime withHourOfDay(int i3) {
        return withLocalMillis(getChronology().hourOfDay().set(getLocalMillis(), i3));
    }

    public LocalDateTime withLocalMillis(long j4) {
        return j4 == getLocalMillis() ? this : new LocalDateTime(j4, getChronology());
    }

    public LocalDateTime withMillisOfDay(int i3) {
        return withLocalMillis(getChronology().millisOfDay().set(getLocalMillis(), i3));
    }

    public LocalDateTime withMillisOfSecond(int i3) {
        return withLocalMillis(getChronology().millisOfSecond().set(getLocalMillis(), i3));
    }

    public LocalDateTime withMinuteOfHour(int i3) {
        return withLocalMillis(getChronology().minuteOfHour().set(getLocalMillis(), i3));
    }

    public LocalDateTime withMonthOfYear(int i3) {
        return withLocalMillis(getChronology().monthOfYear().set(getLocalMillis(), i3));
    }

    public LocalDateTime withPeriodAdded(k kVar, int i3) {
        return (kVar == null || i3 == 0) ? this : withLocalMillis(getChronology().add(kVar, getLocalMillis(), i3));
    }

    public LocalDateTime withSecondOfMinute(int i3) {
        return withLocalMillis(getChronology().secondOfMinute().set(getLocalMillis(), i3));
    }

    public LocalDateTime withTime(int i3, int i10, int i11, int i12) {
        a chronology = getChronology();
        return withLocalMillis(chronology.millisOfSecond().set(chronology.secondOfMinute().set(chronology.minuteOfHour().set(chronology.hourOfDay().set(getLocalMillis(), i3), i10), i11), i12));
    }

    public LocalDateTime withWeekOfWeekyear(int i3) {
        return withLocalMillis(getChronology().weekOfWeekyear().set(getLocalMillis(), i3));
    }

    public LocalDateTime withWeekyear(int i3) {
        return withLocalMillis(getChronology().weekyear().set(getLocalMillis(), i3));
    }

    public LocalDateTime withYear(int i3) {
        return withLocalMillis(getChronology().year().set(getLocalMillis(), i3));
    }

    public LocalDateTime withYearOfCentury(int i3) {
        return withLocalMillis(getChronology().yearOfCentury().set(getLocalMillis(), i3));
    }

    public LocalDateTime withYearOfEra(int i3) {
        return withLocalMillis(getChronology().yearOfEra().set(getLocalMillis(), i3));
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

    public static LocalDateTime now(DateTimeZone dateTimeZone) {
        if (dateTimeZone != null) {
            return new LocalDateTime(dateTimeZone);
        }
        throw new NullPointerException("Zone must not be null");
    }

    @FromString
    public static LocalDateTime parse(String str) {
        return parse(str, v.f17240g0);
    }

    @Override // ai.e, java.lang.Comparable
    public int compareTo(j jVar) {
        if (this == jVar) {
            return 0;
        }
        if (jVar instanceof LocalDateTime) {
            LocalDateTime localDateTime = (LocalDateTime) jVar;
            if (this.iChronology.equals(localDateTime.iChronology)) {
                long j4 = this.iLocalMillis;
                long j10 = localDateTime.iLocalMillis;
                if (j4 < j10) {
                    return -1;
                }
                return j4 == j10 ? 0 : 1;
            }
        }
        return super.compareTo(jVar);
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            return false;
        }
        return durationFieldType.getField(getChronology()).isSupported();
    }

    public LocalDateTime minus(k kVar) {
        return withPeriodAdded(kVar, -1);
    }

    public LocalDateTime plus(k kVar) {
        return withPeriodAdded(kVar, 1);
    }

    public DateTime toDateTime(DateTimeZone dateTimeZone) {
        AtomicReference atomicReference = c.f17022a;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), getHourOfDay(), getMinuteOfHour(), getSecondOfMinute(), getMillisOfSecond(), this.iChronology.withZone(dateTimeZone));
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.a(str).e(this);
    }

    public static LocalDateTime now(a aVar) {
        if (aVar != null) {
            return new LocalDateTime(aVar);
        }
        throw new NullPointerException("Chronology must not be null");
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.a(str).i(locale).e(this);
    }

    public Date toDate(TimeZone timeZone) {
        Calendar calendar = Calendar.getInstance(timeZone);
        calendar.clear();
        calendar.set(getYear(), getMonthOfYear() - 1, getDayOfMonth(), getHourOfDay(), getMinuteOfHour(), getSecondOfMinute());
        Date time = calendar.getTime();
        time.setTime(time.getTime() + getMillisOfSecond());
        return a(time, timeZone);
    }

    public LocalDateTime(long j4, a aVar) {
        AtomicReference atomicReference = c.f17022a;
        aVar = aVar == null ? ISOChronology.getInstance() : aVar;
        this.iLocalMillis = aVar.getZone().getMillisKeepLocal(DateTimeZone.UTC, j4);
        this.iChronology = aVar.withUTC();
    }

    public LocalDateTime(Object obj, a aVar) {
        bi.j g10 = androidx.camera.core.impl.e.e().g(obj);
        a a3 = g10.a(obj, aVar);
        AtomicReference atomicReference = c.f17022a;
        a3 = a3 == null ? ISOChronology.getInstance() : a3;
        a withUTC = a3.withUTC();
        this.iChronology = withUTC;
        int[] c9 = g10.c(this, obj, a3, v.f17240g0);
        this.iLocalMillis = withUTC.getDateTimeMillis(c9[0], c9[1], c9[2], c9[3]);
    }

    public LocalDateTime(Object obj, DateTimeZone dateTimeZone) {
        bi.j g10 = androidx.camera.core.impl.e.e().g(obj);
        a b3 = g10.b(obj, dateTimeZone);
        AtomicReference atomicReference = c.f17022a;
        b3 = b3 == null ? ISOChronology.getInstance() : b3;
        a withUTC = b3.withUTC();
        this.iChronology = withUTC;
        int[] c9 = g10.c(this, obj, b3, v.f17240g0);
        this.iLocalMillis = withUTC.getDateTimeMillis(c9[0], c9[1], c9[2], c9[3]);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalDateTime() {
        this(System.currentTimeMillis(), ISOChronology.getInstance());
        AtomicReference atomicReference = c.f17022a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalDateTime(DateTimeZone dateTimeZone) {
        this(System.currentTimeMillis(), ISOChronology.getInstance(dateTimeZone));
        AtomicReference atomicReference = c.f17022a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalDateTime(a aVar) {
        this(System.currentTimeMillis(), aVar);
        AtomicReference atomicReference = c.f17022a;
    }

    public LocalDateTime(long j4) {
        this(j4, ISOChronology.getInstance());
    }

    public LocalDateTime(long j4, DateTimeZone dateTimeZone) {
        this(j4, ISOChronology.getInstance(dateTimeZone));
    }

    public LocalDateTime(Object obj) {
        this(obj, (a) null);
    }

    public LocalDateTime(int i3, int i10, int i11, int i12, int i13) {
        this(i3, i10, i11, i12, i13, 0, 0, ISOChronology.getInstanceUTC());
    }

    public LocalDateTime(int i3, int i10, int i11, int i12, int i13, int i14) {
        this(i3, i10, i11, i12, i13, i14, 0, ISOChronology.getInstanceUTC());
    }

    public LocalDateTime(int i3, int i10, int i11, int i12, int i13, int i14, int i15) {
        this(i3, i10, i11, i12, i13, i14, i15, ISOChronology.getInstanceUTC());
    }
}
