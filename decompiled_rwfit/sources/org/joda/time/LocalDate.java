package org.joda.time;

import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Locale;
import java.util.TimeZone;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractReadableInstantFieldProperty;
import org.joda.time.format.v;

/* loaded from: classes2.dex */
public final class LocalDate extends ai.g implements Serializable {

    /* renamed from: b, reason: collision with root package name */
    public static final HashSet f16991b;
    private static final long serialVersionUID = -8775358157899L;

    /* renamed from: a, reason: collision with root package name */
    public transient int f16992a;
    private final a iChronology;
    private final long iLocalMillis;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -3193829732634L;

        /* renamed from: a, reason: collision with root package name */
        public transient LocalDate f16993a;

        /* renamed from: b, reason: collision with root package name */
        public transient b f16994b;

        public Property(LocalDate localDate, b bVar) {
            this.f16993a = localDate;
            this.f16994b = bVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.f16993a = (LocalDate) objectInputStream.readObject();
            this.f16994b = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.f16993a.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.f16993a);
            objectOutputStream.writeObject(this.f16994b.getType());
        }

        public LocalDate addToCopy(int i3) {
            LocalDate localDate = this.f16993a;
            return localDate.withLocalMillis(this.f16994b.add(localDate.getLocalMillis(), i3));
        }

        public LocalDate addWrapFieldToCopy(int i3) {
            LocalDate localDate = this.f16993a;
            return localDate.withLocalMillis(this.f16994b.addWrapField(localDate.getLocalMillis(), i3));
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public a getChronology() {
            return this.f16993a.getChronology();
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public b getField() {
            return this.f16994b;
        }

        public LocalDate getLocalDate() {
            return this.f16993a;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public long getMillis() {
            return this.f16993a.getLocalMillis();
        }

        public LocalDate roundCeilingCopy() {
            LocalDate localDate = this.f16993a;
            return localDate.withLocalMillis(this.f16994b.roundCeiling(localDate.getLocalMillis()));
        }

        public LocalDate roundFloorCopy() {
            LocalDate localDate = this.f16993a;
            return localDate.withLocalMillis(this.f16994b.roundFloor(localDate.getLocalMillis()));
        }

        public LocalDate roundHalfCeilingCopy() {
            LocalDate localDate = this.f16993a;
            return localDate.withLocalMillis(this.f16994b.roundHalfCeiling(localDate.getLocalMillis()));
        }

        public LocalDate roundHalfEvenCopy() {
            LocalDate localDate = this.f16993a;
            return localDate.withLocalMillis(this.f16994b.roundHalfEven(localDate.getLocalMillis()));
        }

        public LocalDate roundHalfFloorCopy() {
            LocalDate localDate = this.f16993a;
            return localDate.withLocalMillis(this.f16994b.roundHalfFloor(localDate.getLocalMillis()));
        }

        public LocalDate setCopy(int i3) {
            LocalDate localDate = this.f16993a;
            return localDate.withLocalMillis(this.f16994b.set(localDate.getLocalMillis(), i3));
        }

        public LocalDate withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public LocalDate withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public LocalDate setCopy(String str, Locale locale) {
            LocalDate localDate = this.f16993a;
            return localDate.withLocalMillis(this.f16994b.set(localDate.getLocalMillis(), str, locale));
        }

        public LocalDate setCopy(String str) {
            return setCopy(str, null);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f16991b = hashSet;
        hashSet.add(DurationFieldType.days());
        hashSet.add(DurationFieldType.weeks());
        hashSet.add(DurationFieldType.months());
        hashSet.add(DurationFieldType.weekyears());
        hashSet.add(DurationFieldType.years());
        hashSet.add(DurationFieldType.centuries());
        hashSet.add(DurationFieldType.eras());
    }

    public LocalDate(int i3, int i10, int i11, a aVar) {
        AtomicReference atomicReference = c.f17022a;
        a withUTC = (aVar == null ? ISOChronology.getInstance() : aVar).withUTC();
        long dateTimeMillis = withUTC.getDateTimeMillis(i3, i10, i11, 0);
        this.iChronology = withUTC;
        this.iLocalMillis = dateTimeMillis;
    }

    public static LocalDate fromCalendarFields(Calendar calendar) {
        if (calendar == null) {
            throw new IllegalArgumentException("The calendar must not be null");
        }
        int i3 = calendar.get(0);
        int i10 = calendar.get(1);
        if (i3 != 1) {
            i10 = 1 - i10;
        }
        return new LocalDate(i10, calendar.get(2) + 1, calendar.get(5));
    }

    public static LocalDate fromDateFields(Date date) {
        if (date == null) {
            throw new IllegalArgumentException("The date must not be null");
        }
        if (date.getTime() >= 0) {
            return new LocalDate(date.getYear() + 1900, date.getMonth() + 1, date.getDate());
        }
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        return fromCalendarFields(gregorianCalendar);
    }

    public static LocalDate now() {
        return new LocalDate();
    }

    public static LocalDate parse(String str, org.joda.time.format.b bVar) {
        return bVar.b(str).toLocalDate();
    }

    private Object readResolve() {
        a aVar = this.iChronology;
        return aVar == null ? new LocalDate(this.iLocalMillis, ISOChronology.getInstanceUTC()) : !DateTimeZone.UTC.equals(aVar.getZone()) ? new LocalDate(this.iLocalMillis, this.iChronology.withUTC()) : this;
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
        if (obj instanceof LocalDate) {
            LocalDate localDate = (LocalDate) obj;
            if (this.iChronology.equals(localDate.iChronology)) {
                return this.iLocalMillis == localDate.iLocalMillis;
            }
        }
        return super.equals(obj);
    }

    public Property era() {
        return new Property(this, getChronology().era());
    }

    @Override // ai.e, org.joda.time.j
    public int get(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The DateTimeFieldType must not be null");
        }
        if (isSupported(dateTimeFieldType)) {
            return dateTimeFieldType.getField(getChronology()).get(getLocalMillis());
        }
        throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
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
        throw new IndexOutOfBoundsException(l0.j(i3, "Invalid index: "));
    }

    @Override // ai.g
    public long getLocalMillis() {
        return this.iLocalMillis;
    }

    public int getMonthOfYear() {
        return getChronology().monthOfYear().get(getLocalMillis());
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

    @Override // ai.e
    public int hashCode() {
        int i3 = this.f16992a;
        if (i3 != 0) {
            return i3;
        }
        int hashCode = super.hashCode();
        this.f16992a = hashCode;
        return hashCode;
    }

    @Override // ai.e, org.joda.time.j
    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            return false;
        }
        DurationFieldType durationType = dateTimeFieldType.getDurationType();
        if (f16991b.contains(durationType) || durationType.getField(getChronology()).getUnitMillis() >= getChronology().days().getUnitMillis()) {
            return dateTimeFieldType.getField(getChronology()).isSupported();
        }
        return false;
    }

    public LocalDate minus(k kVar) {
        return withPeriodAdded(kVar, -1);
    }

    public LocalDate minusDays(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().days().subtract(getLocalMillis(), i3));
    }

    public LocalDate minusMonths(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().months().subtract(getLocalMillis(), i3));
    }

    public LocalDate minusWeeks(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().weeks().subtract(getLocalMillis(), i3));
    }

    public LocalDate minusYears(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().years().subtract(getLocalMillis(), i3));
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
    }

    public LocalDate plus(k kVar) {
        return withPeriodAdded(kVar, 1);
    }

    public LocalDate plusDays(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().days().add(getLocalMillis(), i3));
    }

    public LocalDate plusMonths(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().months().add(getLocalMillis(), i3));
    }

    public LocalDate plusWeeks(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().weeks().add(getLocalMillis(), i3));
    }

    public LocalDate plusYears(int i3) {
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

    @Override // org.joda.time.j
    public int size() {
        return 3;
    }

    public Date toDate() {
        int dayOfMonth = getDayOfMonth();
        Date date = new Date(getYear() - 1900, getMonthOfYear() - 1, dayOfMonth);
        LocalDate fromDateFields = fromDateFields(date);
        if (!fromDateFields.isBefore(this)) {
            if (fromDateFields.equals(this)) {
                Date date2 = new Date(date.getTime() - TimeZone.getDefault().getDSTSavings());
                if (date2.getDate() == dayOfMonth) {
                    return date2;
                }
            }
            return date;
        }
        while (!fromDateFields.equals(this)) {
            date.setTime(date.getTime() + Const.L_WIFI_EXP);
            fromDateFields = fromDateFields(date);
        }
        while (date.getDate() == dayOfMonth) {
            date.setTime(date.getTime() - 1000);
        }
        date.setTime(date.getTime() + 1000);
        return date;
    }

    @Deprecated
    public DateMidnight toDateMidnight() {
        return toDateMidnight(null);
    }

    public DateTime toDateTime(LocalTime localTime) {
        return toDateTime(localTime, null);
    }

    public DateTime toDateTimeAtCurrentTime() {
        return toDateTimeAtCurrentTime(null);
    }

    @Deprecated
    public DateTime toDateTimeAtMidnight() {
        return toDateTimeAtMidnight(null);
    }

    public DateTime toDateTimeAtStartOfDay() {
        return toDateTimeAtStartOfDay(null);
    }

    public Interval toInterval() {
        return toInterval(null);
    }

    public LocalDateTime toLocalDateTime(LocalTime localTime) {
        if (localTime == null) {
            throw new IllegalArgumentException("The time must not be null");
        }
        if (getChronology() != localTime.getChronology()) {
            throw new IllegalArgumentException("The chronology of the time does not match");
        }
        return new LocalDateTime(localTime.getLocalMillis() + getLocalMillis(), getChronology());
    }

    @ToString
    public String toString() {
        return v.f17248o.e(this);
    }

    public Property weekOfWeekyear() {
        return new Property(this, getChronology().weekOfWeekyear());
    }

    public Property weekyear() {
        return new Property(this, getChronology().weekyear());
    }

    public LocalDate withCenturyOfEra(int i3) {
        return withLocalMillis(getChronology().centuryOfEra().set(getLocalMillis(), i3));
    }

    public LocalDate withDayOfMonth(int i3) {
        return withLocalMillis(getChronology().dayOfMonth().set(getLocalMillis(), i3));
    }

    public LocalDate withDayOfWeek(int i3) {
        return withLocalMillis(getChronology().dayOfWeek().set(getLocalMillis(), i3));
    }

    public LocalDate withDayOfYear(int i3) {
        return withLocalMillis(getChronology().dayOfYear().set(getLocalMillis(), i3));
    }

    public LocalDate withEra(int i3) {
        return withLocalMillis(getChronology().era().set(getLocalMillis(), i3));
    }

    public LocalDate withField(DateTimeFieldType dateTimeFieldType, int i3) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        }
        if (isSupported(dateTimeFieldType)) {
            return withLocalMillis(dateTimeFieldType.getField(getChronology()).set(getLocalMillis(), i3));
        }
        throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
    }

    public LocalDate withFieldAdded(DurationFieldType durationFieldType, int i3) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        }
        if (isSupported(durationFieldType)) {
            return i3 == 0 ? this : withLocalMillis(durationFieldType.getField(getChronology()).add(getLocalMillis(), i3));
        }
        throw new IllegalArgumentException("Field '" + durationFieldType + "' is not supported");
    }

    public LocalDate withFields(j jVar) {
        return jVar == null ? this : withLocalMillis(getChronology().set(jVar, getLocalMillis()));
    }

    public LocalDate withLocalMillis(long j4) {
        long roundFloor = this.iChronology.dayOfMonth().roundFloor(j4);
        return roundFloor == getLocalMillis() ? this : new LocalDate(roundFloor, getChronology());
    }

    public LocalDate withMonthOfYear(int i3) {
        return withLocalMillis(getChronology().monthOfYear().set(getLocalMillis(), i3));
    }

    public LocalDate withPeriodAdded(k kVar, int i3) {
        if (kVar == null || i3 == 0) {
            return this;
        }
        long localMillis = getLocalMillis();
        a chronology = getChronology();
        for (int i10 = 0; i10 < kVar.size(); i10++) {
            long e = nf.e(kVar.getValue(i10), i3);
            DurationFieldType fieldType = kVar.getFieldType(i10);
            if (isSupported(fieldType)) {
                localMillis = fieldType.getField(chronology).add(localMillis, e);
            }
        }
        return withLocalMillis(localMillis);
    }

    public LocalDate withWeekOfWeekyear(int i3) {
        return withLocalMillis(getChronology().weekOfWeekyear().set(getLocalMillis(), i3));
    }

    public LocalDate withWeekyear(int i3) {
        return withLocalMillis(getChronology().weekyear().set(getLocalMillis(), i3));
    }

    public LocalDate withYear(int i3) {
        return withLocalMillis(getChronology().year().set(getLocalMillis(), i3));
    }

    public LocalDate withYearOfCentury(int i3) {
        return withLocalMillis(getChronology().yearOfCentury().set(getLocalMillis(), i3));
    }

    public LocalDate withYearOfEra(int i3) {
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

    public static LocalDate now(DateTimeZone dateTimeZone) {
        if (dateTimeZone != null) {
            return new LocalDate(dateTimeZone);
        }
        throw new NullPointerException("Zone must not be null");
    }

    @Override // ai.e, java.lang.Comparable
    public int compareTo(j jVar) {
        if (this == jVar) {
            return 0;
        }
        if (jVar instanceof LocalDate) {
            LocalDate localDate = (LocalDate) jVar;
            if (this.iChronology.equals(localDate.iChronology)) {
                long j4 = this.iLocalMillis;
                long j10 = localDate.iLocalMillis;
                if (j4 < j10) {
                    return -1;
                }
                return j4 == j10 ? 0 : 1;
            }
        }
        return super.compareTo(jVar);
    }

    @Deprecated
    public DateMidnight toDateMidnight(DateTimeZone dateTimeZone) {
        AtomicReference atomicReference = c.f17022a;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return new DateMidnight(getYear(), getMonthOfYear(), getDayOfMonth(), getChronology().withZone(dateTimeZone));
    }

    public DateTime toDateTime(LocalTime localTime, DateTimeZone dateTimeZone) {
        if (localTime == null) {
            return toDateTimeAtCurrentTime(dateTimeZone);
        }
        if (getChronology() != localTime.getChronology()) {
            throw new IllegalArgumentException("The chronology of the time does not match");
        }
        return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), localTime.getHourOfDay(), localTime.getMinuteOfHour(), localTime.getSecondOfMinute(), localTime.getMillisOfSecond(), getChronology().withZone(dateTimeZone));
    }

    public DateTime toDateTimeAtCurrentTime(DateTimeZone dateTimeZone) {
        AtomicReference atomicReference = c.f17022a;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        a withZone = getChronology().withZone(dateTimeZone);
        return new DateTime(withZone.set(this, System.currentTimeMillis()), withZone);
    }

    @Deprecated
    public DateTime toDateTimeAtMidnight(DateTimeZone dateTimeZone) {
        AtomicReference atomicReference = c.f17022a;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return new DateTime(getYear(), getMonthOfYear(), getDayOfMonth(), 0, 0, 0, 0, getChronology().withZone(dateTimeZone));
    }

    public DateTime toDateTimeAtStartOfDay(DateTimeZone dateTimeZone) {
        AtomicReference atomicReference = c.f17022a;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        a withZone = getChronology().withZone(dateTimeZone);
        return new DateTime(withZone.dayOfMonth().roundFloor(dateTimeZone.convertLocalToUTC(getLocalMillis() + Const.sMaxValidTimeInQueue, false)), withZone).withEarlierOffsetAtOverlap();
    }

    public Interval toInterval(DateTimeZone dateTimeZone) {
        AtomicReference atomicReference = c.f17022a;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        return new Interval(toDateTimeAtStartOfDay(dateTimeZone), plusDays(1).toDateTimeAtStartOfDay(dateTimeZone));
    }

    @FromString
    public static LocalDate parse(String str) {
        return parse(str, v.f17231b0);
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.a(str).e(this);
    }

    public static LocalDate now(a aVar) {
        if (aVar != null) {
            return new LocalDate(aVar);
        }
        throw new NullPointerException("Chronology must not be null");
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.a(str).i(locale).e(this);
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            return false;
        }
        e field = durationFieldType.getField(getChronology());
        if (f16991b.contains(durationFieldType) || field.getUnitMillis() >= getChronology().days().getUnitMillis()) {
            return field.isSupported();
        }
        return false;
    }

    public LocalDate(long j4, a aVar) {
        AtomicReference atomicReference = c.f17022a;
        aVar = aVar == null ? ISOChronology.getInstance() : aVar;
        long millisKeepLocal = aVar.getZone().getMillisKeepLocal(DateTimeZone.UTC, j4);
        a withUTC = aVar.withUTC();
        this.iLocalMillis = withUTC.dayOfMonth().roundFloor(millisKeepLocal);
        this.iChronology = withUTC;
    }

    public LocalDate(Object obj, a aVar) {
        bi.j g10 = androidx.camera.core.impl.e.e().g(obj);
        a a3 = g10.a(obj, aVar);
        AtomicReference atomicReference = c.f17022a;
        a3 = a3 == null ? ISOChronology.getInstance() : a3;
        a withUTC = a3.withUTC();
        this.iChronology = withUTC;
        int[] c9 = g10.c(this, obj, a3, v.f17231b0);
        this.iLocalMillis = withUTC.getDateTimeMillis(c9[0], c9[1], c9[2], 0);
    }

    public LocalDate(Object obj, DateTimeZone dateTimeZone) {
        bi.j g10 = androidx.camera.core.impl.e.e().g(obj);
        a b3 = g10.b(obj, dateTimeZone);
        AtomicReference atomicReference = c.f17022a;
        b3 = b3 == null ? ISOChronology.getInstance() : b3;
        a withUTC = b3.withUTC();
        this.iChronology = withUTC;
        int[] c9 = g10.c(this, obj, b3, v.f17231b0);
        this.iLocalMillis = withUTC.getDateTimeMillis(c9[0], c9[1], c9[2], 0);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalDate() {
        this(System.currentTimeMillis(), ISOChronology.getInstance());
        AtomicReference atomicReference = c.f17022a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalDate(DateTimeZone dateTimeZone) {
        this(System.currentTimeMillis(), ISOChronology.getInstance(dateTimeZone));
        AtomicReference atomicReference = c.f17022a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalDate(a aVar) {
        this(System.currentTimeMillis(), aVar);
        AtomicReference atomicReference = c.f17022a;
    }

    public LocalDate(long j4) {
        this(j4, ISOChronology.getInstance());
    }

    public LocalDate(long j4, DateTimeZone dateTimeZone) {
        this(j4, ISOChronology.getInstance(dateTimeZone));
    }

    public LocalDate(Object obj) {
        this(obj, (a) null);
    }

    public LocalDate(int i3, int i10, int i11) {
        this(i3, i10, i11, ISOChronology.getInstanceUTC());
    }
}
