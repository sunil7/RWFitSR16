package org.joda.time;

import com.autonavi.aps.amapapi.config.Const;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.time.base.BasePeriod;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.a0;
import org.joda.time.format.w;

/* loaded from: classes2.dex */
public final class Period extends BasePeriod implements Serializable {
    public static final Period ZERO = new Period();
    private static final long serialVersionUID = 741052353876488155L;

    public Period() {
        super(0L, (PeriodType) null, (a) null);
    }

    public static Period days(int i3) {
        return new Period(new int[]{0, 0, 0, i3, 0, 0, 0, 0}, PeriodType.standard());
    }

    public static Period fieldDifference(j jVar, j jVar2) {
        if (jVar == null || jVar2 == null) {
            throw new IllegalArgumentException("ReadablePartial objects must not be null");
        }
        if (jVar.size() != jVar2.size()) {
            throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
        }
        DurationFieldType[] durationFieldTypeArr = new DurationFieldType[jVar.size()];
        int[] iArr = new int[jVar.size()];
        int size = jVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            if (jVar.getFieldType(i3) != jVar2.getFieldType(i3)) {
                throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
            }
            DurationFieldType durationType = jVar.getFieldType(i3).getDurationType();
            durationFieldTypeArr[i3] = durationType;
            if (i3 > 0 && durationFieldTypeArr[i3 - 1] == durationType) {
                throw new IllegalArgumentException("ReadablePartial objects must not have overlapping fields");
            }
            iArr[i3] = jVar2.getValue(i3) - jVar.getValue(i3);
        }
        return new Period(iArr, PeriodType.forFields(durationFieldTypeArr));
    }

    public static Period hours(int i3) {
        return new Period(new int[]{0, 0, 0, 0, i3, 0, 0, 0}, PeriodType.standard());
    }

    public static Period millis(int i3) {
        return new Period(new int[]{0, 0, 0, 0, 0, 0, 0, i3}, PeriodType.standard());
    }

    public static Period minutes(int i3) {
        return new Period(new int[]{0, 0, 0, 0, 0, i3, 0, 0}, PeriodType.standard());
    }

    public static Period months(int i3) {
        return new Period(new int[]{0, i3, 0, 0, 0, 0, 0, 0}, PeriodType.standard());
    }

    @FromString
    public static Period parse(String str) {
        return parse(str, w.a());
    }

    public static Period seconds(int i3) {
        return new Period(new int[]{0, 0, 0, 0, 0, 0, i3, 0}, PeriodType.standard());
    }

    public static Period weeks(int i3) {
        return new Period(new int[]{0, 0, i3, 0, 0, 0, 0, 0}, PeriodType.standard());
    }

    public static Period years(int i3) {
        return new Period(new int[]{i3, 0, 0, 0, 0, 0, 0, 0}, PeriodType.standard());
    }

    public final void c(String str) {
        if (getMonths() != 0) {
            throw new UnsupportedOperationException(l0.o("Cannot convert to ", str, " as this period contains months and months vary in length"));
        }
        if (getYears() != 0) {
            throw new UnsupportedOperationException(l0.o("Cannot convert to ", str, " as this period contains years and years vary in length"));
        }
    }

    public int getDays() {
        return getPeriodType().getIndexedField(this, PeriodType.DAY_INDEX);
    }

    public int getHours() {
        return getPeriodType().getIndexedField(this, PeriodType.HOUR_INDEX);
    }

    public int getMillis() {
        return getPeriodType().getIndexedField(this, PeriodType.MILLI_INDEX);
    }

    public int getMinutes() {
        return getPeriodType().getIndexedField(this, PeriodType.MINUTE_INDEX);
    }

    public int getMonths() {
        return getPeriodType().getIndexedField(this, PeriodType.MONTH_INDEX);
    }

    public int getSeconds() {
        return getPeriodType().getIndexedField(this, PeriodType.SECOND_INDEX);
    }

    public int getWeeks() {
        return getPeriodType().getIndexedField(this, PeriodType.WEEK_INDEX);
    }

    public int getYears() {
        return getPeriodType().getIndexedField(this, PeriodType.YEAR_INDEX);
    }

    public Period minus(k kVar) {
        if (kVar == null) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, values, -kVar.get(DurationFieldType.YEARS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, values, -kVar.get(DurationFieldType.MONTHS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, values, -kVar.get(DurationFieldType.WEEKS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, values, -kVar.get(DurationFieldType.DAYS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, values, -kVar.get(DurationFieldType.HOURS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, values, -kVar.get(DurationFieldType.MINUTES_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, values, -kVar.get(DurationFieldType.SECONDS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, values, -kVar.get(DurationFieldType.MILLIS_TYPE));
        return new Period(values, getPeriodType());
    }

    public Period minusDays(int i3) {
        return plusDays(-i3);
    }

    public Period minusHours(int i3) {
        return plusHours(-i3);
    }

    public Period minusMillis(int i3) {
        return plusMillis(-i3);
    }

    public Period minusMinutes(int i3) {
        return plusMinutes(-i3);
    }

    public Period minusMonths(int i3) {
        return plusMonths(-i3);
    }

    public Period minusSeconds(int i3) {
        return plusSeconds(-i3);
    }

    public Period minusWeeks(int i3) {
        return plusWeeks(-i3);
    }

    public Period minusYears(int i3) {
        return plusYears(-i3);
    }

    public Period multipliedBy(int i3) {
        if (this == ZERO || i3 == 1) {
            return this;
        }
        int[] values = getValues();
        for (int i10 = 0; i10 < values.length; i10++) {
            values[i10] = nf.e(values[i10], i3);
        }
        return new Period(values, getPeriodType());
    }

    public Period negated() {
        return multipliedBy(-1);
    }

    public Period normalizedStandard() {
        return normalizedStandard(PeriodType.standard());
    }

    public Period plus(k kVar) {
        if (kVar == null) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, values, kVar.get(DurationFieldType.YEARS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, values, kVar.get(DurationFieldType.MONTHS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, values, kVar.get(DurationFieldType.WEEKS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, values, kVar.get(DurationFieldType.DAYS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, values, kVar.get(DurationFieldType.HOURS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, values, kVar.get(DurationFieldType.MINUTES_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, values, kVar.get(DurationFieldType.SECONDS_TYPE));
        getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, values, kVar.get(DurationFieldType.MILLIS_TYPE));
        return new Period(values, getPeriodType());
    }

    public Period plusDays(int i3) {
        if (i3 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.DAY_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period plusHours(int i3) {
        if (i3 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.HOUR_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period plusMillis(int i3) {
        if (i3 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.MILLI_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period plusMinutes(int i3) {
        if (i3 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.MINUTE_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period plusMonths(int i3) {
        if (i3 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.MONTH_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period plusSeconds(int i3) {
        if (i3 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.SECOND_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period plusWeeks(int i3) {
        if (i3 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.WEEK_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period plusYears(int i3) {
        if (i3 == 0) {
            return this;
        }
        int[] values = getValues();
        getPeriodType().addIndexedField(this, PeriodType.YEAR_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    @Override // ai.f
    public Period toPeriod() {
        return this;
    }

    public Days toStandardDays() {
        c("Days");
        return Days.days(nf.j(nf.d(nf.d(((getHours() * Const.L_WIFI_EXP) + ((getMinutes() * 60000) + ((getSeconds() * 1000) + getMillis()))) / Const.DAY_IN_MILLIS, getDays()), getWeeks() * 7)));
    }

    public Duration toStandardDuration() {
        c("Duration");
        return new Duration((getWeeks() * 604800000) + (getDays() * Const.DAY_IN_MILLIS) + (getHours() * Const.L_WIFI_EXP) + (getMinutes() * 60000) + (getSeconds() * 1000) + getMillis());
    }

    public Hours toStandardHours() {
        c("Hours");
        return Hours.hours(nf.j(nf.d(nf.d(nf.d(((getMinutes() * 60000) + ((getSeconds() * 1000) + getMillis())) / Const.L_WIFI_EXP, getHours()), getDays() * 24), getWeeks() * 168)));
    }

    public Minutes toStandardMinutes() {
        c("Minutes");
        return Minutes.minutes(nf.j(nf.d(nf.d(nf.d(nf.d(((getSeconds() * 1000) + getMillis()) / 60000, getMinutes()), getHours() * 60), getDays() * 1440), getWeeks() * 10080)));
    }

    public Seconds toStandardSeconds() {
        c("Seconds");
        return Seconds.seconds(nf.j(nf.d(nf.d(nf.d(nf.d(nf.d(getMillis() / 1000, getSeconds()), getMinutes() * 60), getHours() * 3600), getDays() * 86400), getWeeks() * 604800)));
    }

    public Weeks toStandardWeeks() {
        c("Weeks");
        return Weeks.weeks(nf.j((((getDays() * Const.DAY_IN_MILLIS) + ((getHours() * Const.L_WIFI_EXP) + ((getMinutes() * 60000) + ((getSeconds() * 1000) + getMillis())))) / 604800000) + getWeeks()));
    }

    public Period withDays(int i3) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.DAY_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period withField(DurationFieldType durationFieldType, int i3) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        }
        int[] values = getValues();
        super.setFieldInto(values, durationFieldType, i3);
        return new Period(values, getPeriodType());
    }

    public Period withFieldAdded(DurationFieldType durationFieldType, int i3) {
        if (durationFieldType == null) {
            throw new IllegalArgumentException("Field must not be null");
        }
        if (i3 == 0) {
            return this;
        }
        int[] values = getValues();
        super.addFieldInto(values, durationFieldType, i3);
        return new Period(values, getPeriodType());
    }

    public Period withFields(k kVar) {
        return kVar == null ? this : new Period(super.mergePeriodInto(getValues(), kVar), getPeriodType());
    }

    public Period withHours(int i3) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.HOUR_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period withMillis(int i3) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.MILLI_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period withMinutes(int i3) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.MINUTE_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period withMonths(int i3) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.MONTH_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period withPeriodType(PeriodType periodType) {
        AtomicReference atomicReference = c.f17022a;
        if (periodType == null) {
            periodType = PeriodType.standard();
        }
        return periodType.equals(getPeriodType()) ? this : new Period(this, periodType);
    }

    public Period withSeconds(int i3) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.SECOND_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period withWeeks(int i3) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.WEEK_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period withYears(int i3) {
        int[] values = getValues();
        getPeriodType().setIndexedField(this, PeriodType.YEAR_INDEX, values, i3);
        return new Period(values, getPeriodType());
    }

    public Period(int i3, int i10, int i11, int i12) {
        super(0, 0, 0, 0, i3, i10, i11, i12, PeriodType.standard());
    }

    public static Period parse(String str, a0 a0Var) {
        return a0Var.b(str);
    }

    public Period normalizedStandard(PeriodType periodType) {
        AtomicReference atomicReference = c.f17022a;
        if (periodType == null) {
            periodType = PeriodType.standard();
        }
        Period period = new Period((getWeeks() * 604800000) + (getDays() * Const.DAY_IN_MILLIS) + (getHours() * Const.L_WIFI_EXP) + (getMinutes() * 60000) + (getSeconds() * 1000) + getMillis(), periodType, ISOChronology.getInstanceUTC());
        int years = getYears();
        int months = getMonths();
        if (years == 0 && months == 0) {
            return period;
        }
        long j4 = (years * 12) + months;
        if (periodType.isSupported(DurationFieldType.YEARS_TYPE)) {
            period = period.withYears(nf.j(j4 / 12));
            j4 -= r1 * 12;
        }
        if (periodType.isSupported(DurationFieldType.MONTHS_TYPE)) {
            int j10 = nf.j(j4);
            period = period.withMonths(j10);
            j4 -= j10;
        }
        if (j4 == 0) {
            return period;
        }
        throw new UnsupportedOperationException("Unable to normalize as PeriodType is missing either years or months but period has a month/year amount: " + toString());
    }

    public Period(int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        super(i3, i10, i11, i12, i13, i14, i15, i16, PeriodType.standard());
    }

    public Period(int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16, PeriodType periodType) {
        super(i3, i10, i11, i12, i13, i14, i15, i16, periodType);
    }

    public Period(long j4) {
        super(j4);
    }

    public Period(long j4, PeriodType periodType) {
        super(j4, periodType, (a) null);
    }

    public Period(long j4, a aVar) {
        super(j4, (PeriodType) null, aVar);
    }

    public Period(long j4, PeriodType periodType, a aVar) {
        super(j4, periodType, aVar);
    }

    public Period(long j4, long j10) {
        super(j4, j10, null, null);
    }

    public Period(long j4, long j10, PeriodType periodType) {
        super(j4, j10, periodType, null);
    }

    public Period(long j4, long j10, a aVar) {
        super(j4, j10, null, aVar);
    }

    public Period(long j4, long j10, PeriodType periodType, a aVar) {
        super(j4, j10, periodType, aVar);
    }

    public Period(h hVar, h hVar2) {
        super(hVar, hVar2, (PeriodType) null);
    }

    public Period(h hVar, h hVar2, PeriodType periodType) {
        super(hVar, hVar2, periodType);
    }

    public Period(j jVar, j jVar2) {
        super(jVar, jVar2, (PeriodType) null);
    }

    public Period(j jVar, j jVar2, PeriodType periodType) {
        super(jVar, jVar2, periodType);
    }

    public Period(h hVar, g gVar) {
        super(hVar, gVar, (PeriodType) null);
    }

    public Period(h hVar, g gVar, PeriodType periodType) {
        super(hVar, gVar, periodType);
    }

    public Period(g gVar, h hVar) {
        super(gVar, hVar, (PeriodType) null);
    }

    public Period(g gVar, h hVar, PeriodType periodType) {
        super(gVar, hVar, periodType);
    }

    public Period(Object obj) {
        super(obj, (PeriodType) null, (a) null);
    }

    public Period(Object obj, PeriodType periodType) {
        super(obj, periodType, (a) null);
    }

    public Period(Object obj, a aVar) {
        super(obj, (PeriodType) null, aVar);
    }

    public Period(Object obj, PeriodType periodType, a aVar) {
        super(obj, periodType, aVar);
    }
}
