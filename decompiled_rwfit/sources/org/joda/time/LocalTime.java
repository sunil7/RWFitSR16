package org.joda.time;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.convert.ToString;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.field.AbstractReadableInstantFieldProperty;
import org.joda.time.format.v;

/* loaded from: classes2.dex */
public final class LocalTime extends ai.g implements Serializable {
    public static final LocalTime MIDNIGHT = new LocalTime(0, 0, 0, 0);

    /* renamed from: a, reason: collision with root package name */
    public static final HashSet f16997a;
    private static final long serialVersionUID = -12873158713873L;
    private final a iChronology;
    private final long iLocalMillis;

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -325842547277223L;

        /* renamed from: a, reason: collision with root package name */
        public transient LocalTime f16998a;

        /* renamed from: b, reason: collision with root package name */
        public transient b f16999b;

        public Property(LocalTime localTime, b bVar) {
            this.f16998a = localTime;
            this.f16999b = bVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.f16998a = (LocalTime) objectInputStream.readObject();
            this.f16999b = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.f16998a.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.f16998a);
            objectOutputStream.writeObject(this.f16999b.getType());
        }

        public LocalTime addCopy(int i3) {
            LocalTime localTime = this.f16998a;
            return localTime.withLocalMillis(this.f16999b.add(localTime.getLocalMillis(), i3));
        }

        public LocalTime addNoWrapToCopy(int i3) {
            long add = this.f16999b.add(this.f16998a.getLocalMillis(), i3);
            if (this.f16998a.getChronology().millisOfDay().get(add) == add) {
                return this.f16998a.withLocalMillis(add);
            }
            throw new IllegalArgumentException("The addition exceeded the boundaries of LocalTime");
        }

        public LocalTime addWrapFieldToCopy(int i3) {
            LocalTime localTime = this.f16998a;
            return localTime.withLocalMillis(this.f16999b.addWrapField(localTime.getLocalMillis(), i3));
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public a getChronology() {
            return this.f16998a.getChronology();
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public b getField() {
            return this.f16999b;
        }

        public LocalTime getLocalTime() {
            return this.f16998a;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public long getMillis() {
            return this.f16998a.getLocalMillis();
        }

        public LocalTime roundCeilingCopy() {
            LocalTime localTime = this.f16998a;
            return localTime.withLocalMillis(this.f16999b.roundCeiling(localTime.getLocalMillis()));
        }

        public LocalTime roundFloorCopy() {
            LocalTime localTime = this.f16998a;
            return localTime.withLocalMillis(this.f16999b.roundFloor(localTime.getLocalMillis()));
        }

        public LocalTime roundHalfCeilingCopy() {
            LocalTime localTime = this.f16998a;
            return localTime.withLocalMillis(this.f16999b.roundHalfCeiling(localTime.getLocalMillis()));
        }

        public LocalTime roundHalfEvenCopy() {
            LocalTime localTime = this.f16998a;
            return localTime.withLocalMillis(this.f16999b.roundHalfEven(localTime.getLocalMillis()));
        }

        public LocalTime roundHalfFloorCopy() {
            LocalTime localTime = this.f16998a;
            return localTime.withLocalMillis(this.f16999b.roundHalfFloor(localTime.getLocalMillis()));
        }

        public LocalTime setCopy(int i3) {
            LocalTime localTime = this.f16998a;
            return localTime.withLocalMillis(this.f16999b.set(localTime.getLocalMillis(), i3));
        }

        public LocalTime withMaximumValue() {
            return setCopy(getMaximumValue());
        }

        public LocalTime withMinimumValue() {
            return setCopy(getMinimumValue());
        }

        public LocalTime addCopy(long j4) {
            LocalTime localTime = this.f16998a;
            return localTime.withLocalMillis(this.f16999b.add(localTime.getLocalMillis(), j4));
        }

        public LocalTime setCopy(String str, Locale locale) {
            LocalTime localTime = this.f16998a;
            return localTime.withLocalMillis(this.f16999b.set(localTime.getLocalMillis(), str, locale));
        }

        public LocalTime setCopy(String str) {
            return setCopy(str, null);
        }
    }

    static {
        HashSet hashSet = new HashSet();
        f16997a = hashSet;
        hashSet.add(DurationFieldType.millis());
        hashSet.add(DurationFieldType.seconds());
        hashSet.add(DurationFieldType.minutes());
        hashSet.add(DurationFieldType.hours());
    }

    public LocalTime(int i3, int i10, int i11, int i12, a aVar) {
        AtomicReference atomicReference = c.f17022a;
        a withUTC = (aVar == null ? ISOChronology.getInstance() : aVar).withUTC();
        long dateTimeMillis = withUTC.getDateTimeMillis(0L, i3, i10, i11, i12);
        this.iChronology = withUTC;
        this.iLocalMillis = dateTimeMillis;
    }

    public static LocalTime fromCalendarFields(Calendar calendar) {
        if (calendar != null) {
            return new LocalTime(calendar.get(11), calendar.get(12), calendar.get(13), calendar.get(14));
        }
        throw new IllegalArgumentException("The calendar must not be null");
    }

    public static LocalTime fromDateFields(Date date) {
        if (date != null) {
            return new LocalTime(date.getHours(), date.getMinutes(), date.getSeconds(), (((int) (date.getTime() % 1000)) + 1000) % 1000);
        }
        throw new IllegalArgumentException("The date must not be null");
    }

    public static LocalTime fromMillisOfDay(long j4) {
        return fromMillisOfDay(j4, null);
    }

    public static LocalTime now() {
        return new LocalTime();
    }

    public static LocalTime parse(String str, org.joda.time.format.b bVar) {
        return bVar.b(str).toLocalTime();
    }

    private Object readResolve() {
        a aVar = this.iChronology;
        return aVar == null ? new LocalTime(this.iLocalMillis, ISOChronology.getInstanceUTC()) : !DateTimeZone.UTC.equals(aVar.getZone()) ? new LocalTime(this.iLocalMillis, this.iChronology.withUTC()) : this;
    }

    @Override // ai.e
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof LocalTime) {
            LocalTime localTime = (LocalTime) obj;
            if (this.iChronology.equals(localTime.iChronology)) {
                return this.iLocalMillis == localTime.iLocalMillis;
            }
        }
        return super.equals(obj);
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

    @Override // org.joda.time.j
    public a getChronology() {
        return this.iChronology;
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

    public int getSecondOfMinute() {
        return getChronology().secondOfMinute().get(getLocalMillis());
    }

    @Override // org.joda.time.j
    public int getValue(int i3) {
        if (i3 == 0) {
            return getChronology().hourOfDay().get(getLocalMillis());
        }
        if (i3 == 1) {
            return getChronology().minuteOfHour().get(getLocalMillis());
        }
        if (i3 == 2) {
            return getChronology().secondOfMinute().get(getLocalMillis());
        }
        if (i3 == 3) {
            return getChronology().millisOfSecond().get(getLocalMillis());
        }
        throw new IndexOutOfBoundsException(l0.j(i3, "Invalid index: "));
    }

    public Property hourOfDay() {
        return new Property(this, getChronology().hourOfDay());
    }

    @Override // ai.e, org.joda.time.j
    public boolean isSupported(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null || !isSupported(dateTimeFieldType.getDurationType())) {
            return false;
        }
        DurationFieldType rangeDurationType = dateTimeFieldType.getRangeDurationType();
        return isSupported(rangeDurationType) || rangeDurationType == DurationFieldType.days();
    }

    public Property millisOfDay() {
        return new Property(this, getChronology().millisOfDay());
    }

    public Property millisOfSecond() {
        return new Property(this, getChronology().millisOfSecond());
    }

    public LocalTime minus(k kVar) {
        return withPeriodAdded(kVar, -1);
    }

    public LocalTime minusHours(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().hours().subtract(getLocalMillis(), i3));
    }

    public LocalTime minusMillis(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().millis().subtract(getLocalMillis(), i3));
    }

    public LocalTime minusMinutes(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().minutes().subtract(getLocalMillis(), i3));
    }

    public LocalTime minusSeconds(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().seconds().subtract(getLocalMillis(), i3));
    }

    public Property minuteOfHour() {
        return new Property(this, getChronology().minuteOfHour());
    }

    public LocalTime plus(k kVar) {
        return withPeriodAdded(kVar, 1);
    }

    public LocalTime plusHours(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().hours().add(getLocalMillis(), i3));
    }

    public LocalTime plusMillis(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().millis().add(getLocalMillis(), i3));
    }

    public LocalTime plusMinutes(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().minutes().add(getLocalMillis(), i3));
    }

    public LocalTime plusSeconds(int i3) {
        return i3 == 0 ? this : withLocalMillis(getChronology().seconds().add(getLocalMillis(), i3));
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

    public DateTime toDateTimeToday() {
        return toDateTimeToday(null);
    }

    @ToString
    public String toString() {
        return v.A.e(this);
    }

    public LocalTime withField(DateTimeFieldType dateTimeFieldType, int i3) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        }
        if (isSupported(dateTimeFieldType)) {
            return withLocalMillis(dateTimeFieldType.getField(getChronology()).set(getLocalMillis(), i3));
        }
        throw new IllegalArgumentException("Field '" + dateTimeFieldType + "' is not supported");
    }

    public LocalTime withFieldAdded(DurationFieldType durationFieldType, int i3) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        }
        if (isSupported(durationFieldType)) {
            return i3 == 0 ? this : withLocalMillis(durationFieldType.getField(getChronology()).add(getLocalMillis(), i3));
        }
        throw new IllegalArgumentException("Field '" + durationFieldType + "' is not supported");
    }

    public LocalTime withFields(j jVar) {
        return jVar == null ? this : withLocalMillis(getChronology().set(jVar, getLocalMillis()));
    }

    public LocalTime withHourOfDay(int i3) {
        return withLocalMillis(getChronology().hourOfDay().set(getLocalMillis(), i3));
    }

    public LocalTime withLocalMillis(long j4) {
        return j4 == getLocalMillis() ? this : new LocalTime(j4, getChronology());
    }

    public LocalTime withMillisOfDay(int i3) {
        return withLocalMillis(getChronology().millisOfDay().set(getLocalMillis(), i3));
    }

    public LocalTime withMillisOfSecond(int i3) {
        return withLocalMillis(getChronology().millisOfSecond().set(getLocalMillis(), i3));
    }

    public LocalTime withMinuteOfHour(int i3) {
        return withLocalMillis(getChronology().minuteOfHour().set(getLocalMillis(), i3));
    }

    public LocalTime withPeriodAdded(k kVar, int i3) {
        return (kVar == null || i3 == 0) ? this : withLocalMillis(getChronology().add(kVar, getLocalMillis(), i3));
    }

    public LocalTime withSecondOfMinute(int i3) {
        return withLocalMillis(getChronology().secondOfMinute().set(getLocalMillis(), i3));
    }

    public static LocalTime fromMillisOfDay(long j4, a aVar) {
        AtomicReference atomicReference = c.f17022a;
        if (aVar == null) {
            aVar = ISOChronology.getInstance();
        }
        return new LocalTime(j4, aVar.withUTC());
    }

    public static LocalTime now(DateTimeZone dateTimeZone) {
        if (dateTimeZone != null) {
            return new LocalTime(dateTimeZone);
        }
        throw new NullPointerException("Zone must not be null");
    }

    @Override // ai.e, java.lang.Comparable
    public int compareTo(j jVar) {
        if (this == jVar) {
            return 0;
        }
        if (jVar instanceof LocalTime) {
            LocalTime localTime = (LocalTime) jVar;
            if (this.iChronology.equals(localTime.iChronology)) {
                long j4 = this.iLocalMillis;
                long j10 = localTime.iLocalMillis;
                if (j4 < j10) {
                    return -1;
                }
                return j4 == j10 ? 0 : 1;
            }
        }
        return super.compareTo(jVar);
    }

    public DateTime toDateTimeToday(DateTimeZone dateTimeZone) {
        a withZone = getChronology().withZone(dateTimeZone);
        AtomicReference atomicReference = c.f17022a;
        return new DateTime(withZone.set(this, System.currentTimeMillis()), withZone);
    }

    @FromString
    public static LocalTime parse(String str) {
        return parse(str, v.f17235d0);
    }

    public String toString(String str) {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.a(str).e(this);
    }

    public static LocalTime now(a aVar) {
        if (aVar != null) {
            return new LocalTime(aVar);
        }
        throw new NullPointerException("Chronology must not be null");
    }

    public boolean isSupported(DurationFieldType durationFieldType) {
        if (durationFieldType == null) {
            return false;
        }
        e field = durationFieldType.getField(getChronology());
        if (f16997a.contains(durationFieldType) || field.getUnitMillis() < getChronology().days().getUnitMillis()) {
            return field.isSupported();
        }
        return false;
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.a(str).i(locale).e(this);
    }

    public LocalTime(long j4, a aVar) {
        AtomicReference atomicReference = c.f17022a;
        aVar = aVar == null ? ISOChronology.getInstance() : aVar;
        long millisKeepLocal = aVar.getZone().getMillisKeepLocal(DateTimeZone.UTC, j4);
        a withUTC = aVar.withUTC();
        this.iLocalMillis = withUTC.millisOfDay().get(millisKeepLocal);
        this.iChronology = withUTC;
    }

    public LocalTime(Object obj, a aVar) {
        bi.j g10 = androidx.camera.core.impl.e.e().g(obj);
        a a3 = g10.a(obj, aVar);
        AtomicReference atomicReference = c.f17022a;
        a3 = a3 == null ? ISOChronology.getInstance() : a3;
        a withUTC = a3.withUTC();
        this.iChronology = withUTC;
        int[] c9 = g10.c(this, obj, a3, v.f17235d0);
        this.iLocalMillis = withUTC.getDateTimeMillis(0L, c9[0], c9[1], c9[2], c9[3]);
    }

    public LocalTime(Object obj, DateTimeZone dateTimeZone) {
        bi.j g10 = androidx.camera.core.impl.e.e().g(obj);
        a b3 = g10.b(obj, dateTimeZone);
        AtomicReference atomicReference = c.f17022a;
        b3 = b3 == null ? ISOChronology.getInstance() : b3;
        a withUTC = b3.withUTC();
        this.iChronology = withUTC;
        int[] c9 = g10.c(this, obj, b3, v.f17235d0);
        this.iLocalMillis = withUTC.getDateTimeMillis(0L, c9[0], c9[1], c9[2], c9[3]);
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalTime() {
        this(System.currentTimeMillis(), ISOChronology.getInstance());
        AtomicReference atomicReference = c.f17022a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalTime(DateTimeZone dateTimeZone) {
        this(System.currentTimeMillis(), ISOChronology.getInstance(dateTimeZone));
        AtomicReference atomicReference = c.f17022a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public LocalTime(a aVar) {
        this(System.currentTimeMillis(), aVar);
        AtomicReference atomicReference = c.f17022a;
    }

    public LocalTime(long j4) {
        this(j4, ISOChronology.getInstance());
    }

    public LocalTime(long j4, DateTimeZone dateTimeZone) {
        this(j4, ISOChronology.getInstance(dateTimeZone));
    }

    public LocalTime(Object obj) {
        this(obj, (a) null);
    }

    public LocalTime(int i3, int i10) {
        this(i3, i10, 0, 0, ISOChronology.getInstanceUTC());
    }

    public LocalTime(int i3, int i10, int i11) {
        this(i3, i10, i11, 0, ISOChronology.getInstanceUTC());
    }

    public LocalTime(int i3, int i10, int i11, int i12) {
        this(i3, i10, i11, i12, ISOChronology.getInstanceUTC());
    }
}
