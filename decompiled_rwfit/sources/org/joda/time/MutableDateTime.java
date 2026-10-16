package org.joda.time;

import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
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
public class MutableDateTime extends BaseDateTime implements Cloneable, Serializable {
    public static final int ROUND_CEILING = 2;
    public static final int ROUND_FLOOR = 1;
    public static final int ROUND_HALF_CEILING = 4;
    public static final int ROUND_HALF_EVEN = 5;
    public static final int ROUND_HALF_FLOOR = 3;
    public static final int ROUND_NONE = 0;
    private static final long serialVersionUID = 2852608688135209575L;
    private b iRoundingField;
    private int iRoundingMode;

    public MutableDateTime() {
    }

    public static MutableDateTime now() {
        return new MutableDateTime();
    }

    public static MutableDateTime parse(String str, org.joda.time.format.b bVar) {
        return bVar.a(str).toMutableDateTime();
    }

    public void add(long j4) {
        setMillis(nf.d(getMillis(), j4));
    }

    public void addDays(int i3) {
        if (i3 != 0) {
            setMillis(getChronology().days().add(getMillis(), i3));
        }
    }

    public void addHours(int i3) {
        if (i3 != 0) {
            setMillis(getChronology().hours().add(getMillis(), i3));
        }
    }

    public void addMillis(int i3) {
        if (i3 != 0) {
            setMillis(getChronology().millis().add(getMillis(), i3));
        }
    }

    public void addMinutes(int i3) {
        if (i3 != 0) {
            setMillis(getChronology().minutes().add(getMillis(), i3));
        }
    }

    public void addMonths(int i3) {
        if (i3 != 0) {
            setMillis(getChronology().months().add(getMillis(), i3));
        }
    }

    public void addSeconds(int i3) {
        if (i3 != 0) {
            setMillis(getChronology().seconds().add(getMillis(), i3));
        }
    }

    public void addWeeks(int i3) {
        if (i3 != 0) {
            setMillis(getChronology().weeks().add(getMillis(), i3));
        }
    }

    public void addWeekyears(int i3) {
        if (i3 != 0) {
            setMillis(getChronology().weekyears().add(getMillis(), i3));
        }
    }

    public void addYears(int i3) {
        if (i3 != 0) {
            setMillis(getChronology().years().add(getMillis(), i3));
        }
    }

    public Property centuryOfEra() {
        return new Property(this, getChronology().centuryOfEra());
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError("Clone error");
        }
    }

    public MutableDateTime copy() {
        return (MutableDateTime) clone();
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

    public b getRoundingField() {
        return this.iRoundingField;
    }

    public int getRoundingMode() {
        return this.iRoundingMode;
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

    public Property minuteOfDay() {
        return new Property(this, getChronology().minuteOfDay());
    }

    public Property minuteOfHour() {
        return new Property(this, getChronology().minuteOfHour());
    }

    public Property monthOfYear() {
        return new Property(this, getChronology().monthOfYear());
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

    public void set(DateTimeFieldType dateTimeFieldType, int i3) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        }
        setMillis(dateTimeFieldType.getField(getChronology()).set(getMillis(), i3));
    }

    @Override // org.joda.time.base.BaseDateTime
    public void setChronology(a aVar) {
        super.setChronology(aVar);
    }

    public void setDate(long j4) {
        setMillis(getChronology().millisOfDay().set(j4, getMillisOfDay()));
    }

    public void setDateTime(int i3, int i10, int i11, int i12, int i13, int i14, int i15) {
        setMillis(getChronology().getDateTimeMillis(i3, i10, i11, i12, i13, i14, i15));
    }

    public void setDayOfMonth(int i3) {
        setMillis(getChronology().dayOfMonth().set(getMillis(), i3));
    }

    public void setDayOfWeek(int i3) {
        setMillis(getChronology().dayOfWeek().set(getMillis(), i3));
    }

    public void setDayOfYear(int i3) {
        setMillis(getChronology().dayOfYear().set(getMillis(), i3));
    }

    public void setHourOfDay(int i3) {
        setMillis(getChronology().hourOfDay().set(getMillis(), i3));
    }

    @Override // org.joda.time.base.BaseDateTime
    public void setMillis(long j4) {
        int i3 = this.iRoundingMode;
        if (i3 == 1) {
            j4 = this.iRoundingField.roundFloor(j4);
        } else if (i3 == 2) {
            j4 = this.iRoundingField.roundCeiling(j4);
        } else if (i3 == 3) {
            j4 = this.iRoundingField.roundHalfFloor(j4);
        } else if (i3 == 4) {
            j4 = this.iRoundingField.roundHalfCeiling(j4);
        } else if (i3 == 5) {
            j4 = this.iRoundingField.roundHalfEven(j4);
        }
        super.setMillis(j4);
    }

    public void setMillisOfDay(int i3) {
        setMillis(getChronology().millisOfDay().set(getMillis(), i3));
    }

    public void setMillisOfSecond(int i3) {
        setMillis(getChronology().millisOfSecond().set(getMillis(), i3));
    }

    public void setMinuteOfDay(int i3) {
        setMillis(getChronology().minuteOfDay().set(getMillis(), i3));
    }

    public void setMinuteOfHour(int i3) {
        setMillis(getChronology().minuteOfHour().set(getMillis(), i3));
    }

    public void setMonthOfYear(int i3) {
        setMillis(getChronology().monthOfYear().set(getMillis(), i3));
    }

    public void setRounding(b bVar) {
        setRounding(bVar, 1);
    }

    public void setSecondOfDay(int i3) {
        setMillis(getChronology().secondOfDay().set(getMillis(), i3));
    }

    public void setSecondOfMinute(int i3) {
        setMillis(getChronology().secondOfMinute().set(getMillis(), i3));
    }

    public void setTime(long j4) {
        setMillis(getChronology().millisOfDay().set(getMillis(), ISOChronology.getInstanceUTC().millisOfDay().get(j4)));
    }

    public void setWeekOfWeekyear(int i3) {
        setMillis(getChronology().weekOfWeekyear().set(getMillis(), i3));
    }

    public void setWeekyear(int i3) {
        setMillis(getChronology().weekyear().set(getMillis(), i3));
    }

    public void setYear(int i3) {
        setMillis(getChronology().year().set(getMillis(), i3));
    }

    public void setZone(DateTimeZone dateTimeZone) {
        AtomicReference atomicReference = c.f17022a;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        a chronology = getChronology();
        if (chronology.getZone() != dateTimeZone) {
            setChronology(chronology.withZone(dateTimeZone));
        }
    }

    public void setZoneRetainFields(DateTimeZone dateTimeZone) {
        AtomicReference atomicReference = c.f17022a;
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        DateTimeZone zone = getZone();
        if (zone == null) {
            zone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == zone) {
            return;
        }
        long millisKeepLocal = zone.getMillisKeepLocal(dateTimeZone, getMillis());
        setChronology(getChronology().withZone(dateTimeZone));
        setMillis(millisKeepLocal);
    }

    public Property weekOfWeekyear() {
        return new Property(this, getChronology().weekOfWeekyear());
    }

    public Property weekyear() {
        return new Property(this, getChronology().weekyear());
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

    public static final class Property extends AbstractReadableInstantFieldProperty {
        private static final long serialVersionUID = -4481126543819298617L;
        private b iField;
        private MutableDateTime iInstant;

        public Property(MutableDateTime mutableDateTime, b bVar) {
            this.iInstant = mutableDateTime;
            this.iField = bVar;
        }

        private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
            this.iInstant = (MutableDateTime) objectInputStream.readObject();
            this.iField = ((DateTimeFieldType) objectInputStream.readObject()).getField(this.iInstant.getChronology());
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeObject(this.iInstant);
            objectOutputStream.writeObject(this.iField.getType());
        }

        public MutableDateTime add(int i3) {
            this.iInstant.setMillis(getField().add(this.iInstant.getMillis(), i3));
            return this.iInstant;
        }

        public MutableDateTime addWrapField(int i3) {
            this.iInstant.setMillis(getField().addWrapField(this.iInstant.getMillis(), i3));
            return this.iInstant;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public a getChronology() {
            return this.iInstant.getChronology();
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public b getField() {
            return this.iField;
        }

        @Override // org.joda.time.field.AbstractReadableInstantFieldProperty
        public long getMillis() {
            return this.iInstant.getMillis();
        }

        public MutableDateTime getMutableDateTime() {
            return this.iInstant;
        }

        public MutableDateTime roundCeiling() {
            this.iInstant.setMillis(getField().roundCeiling(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime roundFloor() {
            this.iInstant.setMillis(getField().roundFloor(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime roundHalfCeiling() {
            this.iInstant.setMillis(getField().roundHalfCeiling(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime roundHalfEven() {
            this.iInstant.setMillis(getField().roundHalfEven(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime roundHalfFloor() {
            this.iInstant.setMillis(getField().roundHalfFloor(this.iInstant.getMillis()));
            return this.iInstant;
        }

        public MutableDateTime set(int i3) {
            this.iInstant.setMillis(getField().set(this.iInstant.getMillis(), i3));
            return this.iInstant;
        }

        public MutableDateTime add(long j4) {
            this.iInstant.setMillis(getField().add(this.iInstant.getMillis(), j4));
            return this.iInstant;
        }

        public MutableDateTime set(String str, Locale locale) {
            this.iInstant.setMillis(getField().set(this.iInstant.getMillis(), str, locale));
            return this.iInstant;
        }

        public MutableDateTime set(String str) {
            set(str, null);
            return this.iInstant;
        }
    }

    public MutableDateTime(DateTimeZone dateTimeZone) {
        super(dateTimeZone);
    }

    public static MutableDateTime now(DateTimeZone dateTimeZone) {
        if (dateTimeZone != null) {
            return new MutableDateTime(dateTimeZone);
        }
        throw new NullPointerException("Zone must not be null");
    }

    @FromString
    public static MutableDateTime parse(String str) {
        return parse(str, v.f17236e0.j());
    }

    public void add(g gVar) {
        add(gVar, 1);
    }

    public void setDate(h hVar) {
        long d5 = c.d(hVar);
        if (hVar instanceof f) {
            a chronology = ((f) hVar).getChronology();
            if (chronology == null) {
                chronology = ISOChronology.getInstance();
            }
            DateTimeZone zone = chronology.getZone();
            if (zone != null) {
                d5 = zone.getMillisKeepLocal(getZone(), d5);
            }
        }
        setDate(d5);
    }

    public void setRounding(b bVar, int i3) {
        if (bVar != null && (i3 < 0 || i3 > 5)) {
            throw new IllegalArgumentException(l0.j(i3, "Illegal rounding mode: "));
        }
        this.iRoundingField = i3 == 0 ? null : bVar;
        if (bVar == null) {
            i3 = 0;
        }
        this.iRoundingMode = i3;
        setMillis(getMillis());
    }

    public MutableDateTime(a aVar) {
        super(aVar);
    }

    public void add(g gVar, int i3) {
        if (gVar != null) {
            add(nf.f(i3, gVar.getMillis()));
        }
    }

    public void setTime(h hVar) {
        long d5 = c.d(hVar);
        DateTimeZone zone = c.c(hVar).getZone();
        if (zone != null) {
            d5 = zone.getMillisKeepLocal(DateTimeZone.UTC, d5);
        }
        setTime(d5);
    }

    public MutableDateTime(long j4) {
        super(j4);
    }

    public static MutableDateTime now(a aVar) {
        if (aVar != null) {
            return new MutableDateTime(aVar);
        }
        throw new NullPointerException("Chronology must not be null");
    }

    public void add(k kVar) {
        add(kVar, 1);
    }

    public MutableDateTime(long j4, DateTimeZone dateTimeZone) {
        super(j4, dateTimeZone);
    }

    public void add(k kVar, int i3) {
        if (kVar != null) {
            setMillis(getChronology().add(kVar, getMillis(), i3));
        }
    }

    public MutableDateTime(long j4, a aVar) {
        super(j4, aVar);
    }

    public void add(DurationFieldType durationFieldType, int i3) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        }
        if (i3 != 0) {
            setMillis(durationFieldType.getField(getChronology()).add(getMillis(), i3));
        }
    }

    public MutableDateTime(Object obj) {
        super(obj, (a) null);
    }

    public MutableDateTime(Object obj, DateTimeZone dateTimeZone) {
        super(obj, dateTimeZone);
    }

    public void setMillis(h hVar) {
        setMillis(c.d(hVar));
    }

    public void setTime(int i3, int i10, int i11, int i12) {
        setMillis(getChronology().getDateTimeMillis(getMillis(), i3, i10, i11, i12));
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MutableDateTime(Object obj, a aVar) {
        super(obj, aVar == null ? ISOChronology.getInstance() : aVar);
        AtomicReference atomicReference = c.f17022a;
    }

    public void setDate(int i3, int i10, int i11) {
        setDate(getChronology().getDateTimeMillis(i3, i10, i11, 0));
    }

    public MutableDateTime(int i3, int i10, int i11, int i12, int i13, int i14, int i15) {
        super(i3, i10, i11, i12, i13, i14, i15);
    }

    public MutableDateTime(int i3, int i10, int i11, int i12, int i13, int i14, int i15, DateTimeZone dateTimeZone) {
        super(i3, i10, i11, i12, i13, i14, i15, dateTimeZone);
    }

    public MutableDateTime(int i3, int i10, int i11, int i12, int i13, int i14, int i15, a aVar) {
        super(i3, i10, i11, i12, i13, i14, i15, aVar);
    }
}
