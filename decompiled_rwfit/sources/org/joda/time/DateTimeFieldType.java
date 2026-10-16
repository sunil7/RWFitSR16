package org.joda.time;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.chrono.ISOChronology;

/* loaded from: classes2.dex */
public abstract class DateTimeFieldType implements Serializable {
    private static final long serialVersionUID = -42615285973990L;
    private final String iName;
    static final byte ERA = 1;

    /* renamed from: a, reason: collision with root package name */
    public static final DateTimeFieldType f16962a = new StandardDateTimeFieldType("era", ERA, DurationFieldType.eras(), null);
    static final byte YEAR_OF_ERA = 2;

    /* renamed from: b, reason: collision with root package name */
    public static final DateTimeFieldType f16963b = new StandardDateTimeFieldType("yearOfEra", YEAR_OF_ERA, DurationFieldType.years(), DurationFieldType.eras());
    static final byte CENTURY_OF_ERA = 3;

    /* renamed from: c, reason: collision with root package name */
    public static final DateTimeFieldType f16964c = new StandardDateTimeFieldType("centuryOfEra", CENTURY_OF_ERA, DurationFieldType.centuries(), DurationFieldType.eras());
    static final byte YEAR_OF_CENTURY = 4;

    /* renamed from: d, reason: collision with root package name */
    public static final DateTimeFieldType f16965d = new StandardDateTimeFieldType("yearOfCentury", YEAR_OF_CENTURY, DurationFieldType.years(), DurationFieldType.centuries());
    static final byte YEAR = 5;
    public static final DateTimeFieldType e = new StandardDateTimeFieldType("year", YEAR, DurationFieldType.years(), null);
    static final byte DAY_OF_YEAR = 6;

    /* renamed from: f, reason: collision with root package name */
    public static final DateTimeFieldType f16966f = new StandardDateTimeFieldType("dayOfYear", DAY_OF_YEAR, DurationFieldType.days(), DurationFieldType.years());
    static final byte MONTH_OF_YEAR = 7;

    /* renamed from: g, reason: collision with root package name */
    public static final DateTimeFieldType f16967g = new StandardDateTimeFieldType("monthOfYear", MONTH_OF_YEAR, DurationFieldType.months(), DurationFieldType.years());
    static final byte DAY_OF_MONTH = 8;

    /* renamed from: h, reason: collision with root package name */
    public static final DateTimeFieldType f16968h = new StandardDateTimeFieldType("dayOfMonth", DAY_OF_MONTH, DurationFieldType.days(), DurationFieldType.months());
    static final byte WEEKYEAR_OF_CENTURY = 9;

    /* renamed from: i, reason: collision with root package name */
    public static final DateTimeFieldType f16969i = new StandardDateTimeFieldType("weekyearOfCentury", WEEKYEAR_OF_CENTURY, DurationFieldType.weekyears(), DurationFieldType.centuries());
    static final byte WEEKYEAR = 10;

    /* renamed from: j, reason: collision with root package name */
    public static final DateTimeFieldType f16970j = new StandardDateTimeFieldType("weekyear", WEEKYEAR, DurationFieldType.weekyears(), null);
    static final byte WEEK_OF_WEEKYEAR = 11;

    /* renamed from: k, reason: collision with root package name */
    public static final DateTimeFieldType f16971k = new StandardDateTimeFieldType("weekOfWeekyear", WEEK_OF_WEEKYEAR, DurationFieldType.weeks(), DurationFieldType.weekyears());
    static final byte DAY_OF_WEEK = 12;

    /* renamed from: l, reason: collision with root package name */
    public static final DateTimeFieldType f16972l = new StandardDateTimeFieldType("dayOfWeek", DAY_OF_WEEK, DurationFieldType.days(), DurationFieldType.weeks());
    static final byte HALFDAY_OF_DAY = 13;

    /* renamed from: m, reason: collision with root package name */
    public static final DateTimeFieldType f16973m = new StandardDateTimeFieldType("halfdayOfDay", HALFDAY_OF_DAY, DurationFieldType.halfdays(), DurationFieldType.days());
    static final byte HOUR_OF_HALFDAY = 14;

    /* renamed from: n, reason: collision with root package name */
    public static final DateTimeFieldType f16974n = new StandardDateTimeFieldType("hourOfHalfday", HOUR_OF_HALFDAY, DurationFieldType.hours(), DurationFieldType.halfdays());
    static final byte CLOCKHOUR_OF_HALFDAY = 15;

    /* renamed from: o, reason: collision with root package name */
    public static final DateTimeFieldType f16975o = new StandardDateTimeFieldType("clockhourOfHalfday", CLOCKHOUR_OF_HALFDAY, DurationFieldType.hours(), DurationFieldType.halfdays());
    static final byte CLOCKHOUR_OF_DAY = 16;

    /* renamed from: p, reason: collision with root package name */
    public static final DateTimeFieldType f16976p = new StandardDateTimeFieldType("clockhourOfDay", CLOCKHOUR_OF_DAY, DurationFieldType.hours(), DurationFieldType.days());
    static final byte HOUR_OF_DAY = 17;

    /* renamed from: q, reason: collision with root package name */
    public static final DateTimeFieldType f16977q = new StandardDateTimeFieldType("hourOfDay", HOUR_OF_DAY, DurationFieldType.hours(), DurationFieldType.days());
    static final byte MINUTE_OF_DAY = 18;
    public static final DateTimeFieldType r = new StandardDateTimeFieldType("minuteOfDay", MINUTE_OF_DAY, DurationFieldType.minutes(), DurationFieldType.days());
    static final byte MINUTE_OF_HOUR = 19;

    /* renamed from: s, reason: collision with root package name */
    public static final DateTimeFieldType f16978s = new StandardDateTimeFieldType("minuteOfHour", MINUTE_OF_HOUR, DurationFieldType.minutes(), DurationFieldType.hours());
    static final byte SECOND_OF_DAY = 20;

    /* renamed from: t, reason: collision with root package name */
    public static final DateTimeFieldType f16979t = new StandardDateTimeFieldType("secondOfDay", SECOND_OF_DAY, DurationFieldType.seconds(), DurationFieldType.days());
    static final byte SECOND_OF_MINUTE = 21;

    /* renamed from: u, reason: collision with root package name */
    public static final DateTimeFieldType f16980u = new StandardDateTimeFieldType("secondOfMinute", SECOND_OF_MINUTE, DurationFieldType.seconds(), DurationFieldType.minutes());
    static final byte MILLIS_OF_DAY = 22;

    /* renamed from: v, reason: collision with root package name */
    public static final DateTimeFieldType f16981v = new StandardDateTimeFieldType("millisOfDay", MILLIS_OF_DAY, DurationFieldType.millis(), DurationFieldType.days());
    static final byte MILLIS_OF_SECOND = 23;

    /* renamed from: w, reason: collision with root package name */
    public static final DateTimeFieldType f16982w = new StandardDateTimeFieldType("millisOfSecond", MILLIS_OF_SECOND, DurationFieldType.millis(), DurationFieldType.seconds());

    public static class StandardDateTimeFieldType extends DateTimeFieldType {
        private static final long serialVersionUID = -9937958251642L;
        private final byte iOrdinal;

        /* renamed from: x, reason: collision with root package name */
        public final transient DurationFieldType f16983x;

        /* renamed from: y, reason: collision with root package name */
        public final transient DurationFieldType f16984y;

        public StandardDateTimeFieldType(String str, byte b3, DurationFieldType durationFieldType, DurationFieldType durationFieldType2) {
            super(str);
            this.iOrdinal = b3;
            this.f16983x = durationFieldType;
            this.f16984y = durationFieldType2;
        }

        private Object readResolve() {
            switch (this.iOrdinal) {
                case 1:
                    return DateTimeFieldType.f16962a;
                case 2:
                    return DateTimeFieldType.f16963b;
                case 3:
                    return DateTimeFieldType.f16964c;
                case 4:
                    return DateTimeFieldType.f16965d;
                case 5:
                    return DateTimeFieldType.e;
                case 6:
                    return DateTimeFieldType.f16966f;
                case 7:
                    return DateTimeFieldType.f16967g;
                case 8:
                    return DateTimeFieldType.f16968h;
                case 9:
                    return DateTimeFieldType.f16969i;
                case 10:
                    return DateTimeFieldType.f16970j;
                case 11:
                    return DateTimeFieldType.f16971k;
                case 12:
                    return DateTimeFieldType.f16972l;
                case 13:
                    return DateTimeFieldType.f16973m;
                case 14:
                    return DateTimeFieldType.f16974n;
                case 15:
                    return DateTimeFieldType.f16975o;
                case 16:
                    return DateTimeFieldType.f16976p;
                case 17:
                    return DateTimeFieldType.f16977q;
                case 18:
                    return DateTimeFieldType.r;
                case 19:
                    return DateTimeFieldType.f16978s;
                case 20:
                    return DateTimeFieldType.f16979t;
                case 21:
                    return DateTimeFieldType.f16980u;
                case 22:
                    return DateTimeFieldType.f16981v;
                case 23:
                    return DateTimeFieldType.f16982w;
                default:
                    return this;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StandardDateTimeFieldType) && this.iOrdinal == ((StandardDateTimeFieldType) obj).iOrdinal;
        }

        @Override // org.joda.time.DateTimeFieldType
        public DurationFieldType getDurationType() {
            return this.f16983x;
        }

        @Override // org.joda.time.DateTimeFieldType
        public b getField(a aVar) {
            AtomicReference atomicReference = c.f17022a;
            if (aVar == null) {
                aVar = ISOChronology.getInstance();
            }
            switch (this.iOrdinal) {
                case 1:
                    return aVar.era();
                case 2:
                    return aVar.yearOfEra();
                case 3:
                    return aVar.centuryOfEra();
                case 4:
                    return aVar.yearOfCentury();
                case 5:
                    return aVar.year();
                case 6:
                    return aVar.dayOfYear();
                case 7:
                    return aVar.monthOfYear();
                case 8:
                    return aVar.dayOfMonth();
                case 9:
                    return aVar.weekyearOfCentury();
                case 10:
                    return aVar.weekyear();
                case 11:
                    return aVar.weekOfWeekyear();
                case 12:
                    return aVar.dayOfWeek();
                case 13:
                    return aVar.halfdayOfDay();
                case 14:
                    return aVar.hourOfHalfday();
                case 15:
                    return aVar.clockhourOfHalfday();
                case 16:
                    return aVar.clockhourOfDay();
                case 17:
                    return aVar.hourOfDay();
                case 18:
                    return aVar.minuteOfDay();
                case 19:
                    return aVar.minuteOfHour();
                case 20:
                    return aVar.secondOfDay();
                case 21:
                    return aVar.secondOfMinute();
                case 22:
                    return aVar.millisOfDay();
                case 23:
                    return aVar.millisOfSecond();
                default:
                    throw new InternalError();
            }
        }

        @Override // org.joda.time.DateTimeFieldType
        public DurationFieldType getRangeDurationType() {
            return this.f16984y;
        }

        public int hashCode() {
            return 1 << this.iOrdinal;
        }
    }

    public DateTimeFieldType(String str) {
        this.iName = str;
    }

    public static DateTimeFieldType centuryOfEra() {
        return f16964c;
    }

    public static DateTimeFieldType clockhourOfDay() {
        return f16976p;
    }

    public static DateTimeFieldType clockhourOfHalfday() {
        return f16975o;
    }

    public static DateTimeFieldType dayOfMonth() {
        return f16968h;
    }

    public static DateTimeFieldType dayOfWeek() {
        return f16972l;
    }

    public static DateTimeFieldType dayOfYear() {
        return f16966f;
    }

    public static DateTimeFieldType era() {
        return f16962a;
    }

    public static DateTimeFieldType halfdayOfDay() {
        return f16973m;
    }

    public static DateTimeFieldType hourOfDay() {
        return f16977q;
    }

    public static DateTimeFieldType hourOfHalfday() {
        return f16974n;
    }

    public static DateTimeFieldType millisOfDay() {
        return f16981v;
    }

    public static DateTimeFieldType millisOfSecond() {
        return f16982w;
    }

    public static DateTimeFieldType minuteOfDay() {
        return r;
    }

    public static DateTimeFieldType minuteOfHour() {
        return f16978s;
    }

    public static DateTimeFieldType monthOfYear() {
        return f16967g;
    }

    public static DateTimeFieldType secondOfDay() {
        return f16979t;
    }

    public static DateTimeFieldType secondOfMinute() {
        return f16980u;
    }

    public static DateTimeFieldType weekOfWeekyear() {
        return f16971k;
    }

    public static DateTimeFieldType weekyear() {
        return f16970j;
    }

    public static DateTimeFieldType weekyearOfCentury() {
        return f16969i;
    }

    public static DateTimeFieldType year() {
        return e;
    }

    public static DateTimeFieldType yearOfCentury() {
        return f16965d;
    }

    public static DateTimeFieldType yearOfEra() {
        return f16963b;
    }

    public abstract DurationFieldType getDurationType();

    public abstract b getField(a aVar);

    public String getName() {
        return this.iName;
    }

    public abstract DurationFieldType getRangeDurationType();

    public boolean isSupported(a aVar) {
        return getField(aVar).isSupported();
    }

    public String toString() {
        return getName();
    }
}
