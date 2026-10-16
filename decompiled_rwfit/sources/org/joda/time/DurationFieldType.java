package org.joda.time;

import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.chrono.ISOChronology;

/* loaded from: classes2.dex */
public abstract class DurationFieldType implements Serializable {
    private static final long serialVersionUID = 8765135187319L;
    private final String iName;
    static final byte ERAS = 1;
    static final DurationFieldType ERAS_TYPE = new StandardDurationFieldType("eras", ERAS);
    static final byte CENTURIES = 2;
    static final DurationFieldType CENTURIES_TYPE = new StandardDurationFieldType("centuries", CENTURIES);
    static final byte WEEKYEARS = 3;
    static final DurationFieldType WEEKYEARS_TYPE = new StandardDurationFieldType("weekyears", WEEKYEARS);
    static final byte YEARS = 4;
    static final DurationFieldType YEARS_TYPE = new StandardDurationFieldType("years", YEARS);
    static final byte MONTHS = 5;
    static final DurationFieldType MONTHS_TYPE = new StandardDurationFieldType("months", MONTHS);
    static final byte WEEKS = 6;
    static final DurationFieldType WEEKS_TYPE = new StandardDurationFieldType("weeks", WEEKS);
    static final byte DAYS = 7;
    static final DurationFieldType DAYS_TYPE = new StandardDurationFieldType("days", DAYS);
    static final byte HALFDAYS = 8;
    static final DurationFieldType HALFDAYS_TYPE = new StandardDurationFieldType("halfdays", HALFDAYS);
    static final byte HOURS = 9;
    static final DurationFieldType HOURS_TYPE = new StandardDurationFieldType("hours", HOURS);
    static final byte MINUTES = 10;
    static final DurationFieldType MINUTES_TYPE = new StandardDurationFieldType("minutes", MINUTES);
    static final byte SECONDS = 11;
    static final DurationFieldType SECONDS_TYPE = new StandardDurationFieldType("seconds", SECONDS);
    static final byte MILLIS = 12;
    static final DurationFieldType MILLIS_TYPE = new StandardDurationFieldType("millis", MILLIS);

    public static class StandardDurationFieldType extends DurationFieldType {
        private static final long serialVersionUID = 31156755687123L;
        private final byte iOrdinal;

        public StandardDurationFieldType(String str, byte b3) {
            super(str);
            this.iOrdinal = b3;
        }

        private Object readResolve() {
            switch (this.iOrdinal) {
                case 1:
                    return DurationFieldType.ERAS_TYPE;
                case 2:
                    return DurationFieldType.CENTURIES_TYPE;
                case 3:
                    return DurationFieldType.WEEKYEARS_TYPE;
                case 4:
                    return DurationFieldType.YEARS_TYPE;
                case 5:
                    return DurationFieldType.MONTHS_TYPE;
                case 6:
                    return DurationFieldType.WEEKS_TYPE;
                case 7:
                    return DurationFieldType.DAYS_TYPE;
                case 8:
                    return DurationFieldType.HALFDAYS_TYPE;
                case 9:
                    return DurationFieldType.HOURS_TYPE;
                case 10:
                    return DurationFieldType.MINUTES_TYPE;
                case 11:
                    return DurationFieldType.SECONDS_TYPE;
                case 12:
                    return DurationFieldType.MILLIS_TYPE;
                default:
                    return this;
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof StandardDurationFieldType) && this.iOrdinal == ((StandardDurationFieldType) obj).iOrdinal;
        }

        @Override // org.joda.time.DurationFieldType
        public e getField(a aVar) {
            AtomicReference atomicReference = c.f17022a;
            if (aVar == null) {
                aVar = ISOChronology.getInstance();
            }
            switch (this.iOrdinal) {
                case 1:
                    return aVar.eras();
                case 2:
                    return aVar.centuries();
                case 3:
                    return aVar.weekyears();
                case 4:
                    return aVar.years();
                case 5:
                    return aVar.months();
                case 6:
                    return aVar.weeks();
                case 7:
                    return aVar.days();
                case 8:
                    return aVar.halfdays();
                case 9:
                    return aVar.hours();
                case 10:
                    return aVar.minutes();
                case 11:
                    return aVar.seconds();
                case 12:
                    return aVar.millis();
                default:
                    throw new InternalError();
            }
        }

        public int hashCode() {
            return 1 << this.iOrdinal;
        }
    }

    public DurationFieldType(String str) {
        this.iName = str;
    }

    public static DurationFieldType centuries() {
        return CENTURIES_TYPE;
    }

    public static DurationFieldType days() {
        return DAYS_TYPE;
    }

    public static DurationFieldType eras() {
        return ERAS_TYPE;
    }

    public static DurationFieldType halfdays() {
        return HALFDAYS_TYPE;
    }

    public static DurationFieldType hours() {
        return HOURS_TYPE;
    }

    public static DurationFieldType millis() {
        return MILLIS_TYPE;
    }

    public static DurationFieldType minutes() {
        return MINUTES_TYPE;
    }

    public static DurationFieldType months() {
        return MONTHS_TYPE;
    }

    public static DurationFieldType seconds() {
        return SECONDS_TYPE;
    }

    public static DurationFieldType weeks() {
        return WEEKS_TYPE;
    }

    public static DurationFieldType weekyears() {
        return WEEKYEARS_TYPE;
    }

    public static DurationFieldType years() {
        return YEARS_TYPE;
    }

    public abstract e getField(a aVar);

    public String getName() {
        return this.iName;
    }

    public boolean isSupported(a aVar) {
        return getField(aVar).isSupported();
    }

    public String toString() {
        return getName();
    }
}
