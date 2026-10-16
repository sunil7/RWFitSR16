package org.joda.time;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.time.base.BasePeriod;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.a0;
import org.joda.time.format.w;

/* loaded from: classes2.dex */
public class MutablePeriod extends BasePeriod implements Cloneable, Serializable, k {
    private static final long serialVersionUID = 3436451121567212165L;

    public MutablePeriod() {
        super(0L, (PeriodType) null, (a) null);
    }

    @FromString
    public static MutablePeriod parse(String str) {
        return parse(str, w.a());
    }

    public void add(DurationFieldType durationFieldType, int i3) {
        super.addField(durationFieldType, i3);
    }

    public void addDays(int i3) {
        super.addField(DurationFieldType.days(), i3);
    }

    public void addHours(int i3) {
        super.addField(DurationFieldType.hours(), i3);
    }

    public void addMillis(int i3) {
        super.addField(DurationFieldType.millis(), i3);
    }

    public void addMinutes(int i3) {
        super.addField(DurationFieldType.minutes(), i3);
    }

    public void addMonths(int i3) {
        super.addField(DurationFieldType.months(), i3);
    }

    public void addSeconds(int i3) {
        super.addField(DurationFieldType.seconds(), i3);
    }

    public void addWeeks(int i3) {
        super.addField(DurationFieldType.weeks(), i3);
    }

    public void addYears(int i3) {
        super.addField(DurationFieldType.years(), i3);
    }

    public void clear() {
        super.setValues(new int[size()]);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError("Clone error");
        }
    }

    public MutablePeriod copy() {
        return (MutablePeriod) clone();
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

    @Override // org.joda.time.base.BasePeriod
    public void mergePeriod(k kVar) {
        super.mergePeriod(kVar);
    }

    public void set(DurationFieldType durationFieldType, int i3) {
        super.setField(durationFieldType, i3);
    }

    public void setDays(int i3) {
        super.setField(DurationFieldType.days(), i3);
    }

    public void setHours(int i3) {
        super.setField(DurationFieldType.hours(), i3);
    }

    public void setMillis(int i3) {
        super.setField(DurationFieldType.millis(), i3);
    }

    public void setMinutes(int i3) {
        super.setField(DurationFieldType.minutes(), i3);
    }

    public void setMonths(int i3) {
        super.setField(DurationFieldType.months(), i3);
    }

    @Override // org.joda.time.base.BasePeriod
    public void setPeriod(k kVar) {
        super.setPeriod(kVar);
    }

    public void setSeconds(int i3) {
        super.setField(DurationFieldType.seconds(), i3);
    }

    @Override // org.joda.time.base.BasePeriod
    public void setValue(int i3, int i10) {
        super.setValue(i3, i10);
    }

    public void setWeeks(int i3) {
        super.setField(DurationFieldType.weeks(), i3);
    }

    public void setYears(int i3) {
        super.setField(DurationFieldType.years(), i3);
    }

    public MutablePeriod(PeriodType periodType) {
        super(0L, periodType, (a) null);
    }

    public static MutablePeriod parse(String str, a0 a0Var) {
        return a0Var.b(str).toMutablePeriod();
    }

    public void add(k kVar) {
        super.addPeriod(kVar);
    }

    @Override // org.joda.time.base.BasePeriod
    public void setPeriod(int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        super.setPeriod(i3, i10, i11, i12, i13, i14, i15, i16);
    }

    public MutablePeriod(int i3, int i10, int i11, int i12) {
        super(0, 0, 0, 0, i3, i10, i11, i12, PeriodType.standard());
    }

    public void add(int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        setPeriod(nf.c(getYears(), i3), nf.c(getMonths(), i10), nf.c(getWeeks(), i11), nf.c(getDays(), i12), nf.c(getHours(), i13), nf.c(getMinutes(), i14), nf.c(getSeconds(), i15), nf.c(getMillis(), i16));
    }

    public void setPeriod(i iVar) {
        if (iVar == null) {
            setPeriod(0L);
            return;
        }
        a chronology = iVar.getChronology();
        AtomicReference atomicReference = c.f17022a;
        if (chronology == null) {
            chronology = ISOChronology.getInstance();
        }
        setPeriod(iVar.getStartMillis(), iVar.getEndMillis(), chronology);
    }

    public MutablePeriod(int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        super(i3, i10, i11, i12, i13, i14, i15, i16, PeriodType.standard());
    }

    public MutablePeriod(int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16, PeriodType periodType) {
        super(i3, i10, i11, i12, i13, i14, i15, i16, periodType);
    }

    public MutablePeriod(long j4) {
        super(j4);
    }

    public MutablePeriod(long j4, PeriodType periodType) {
        super(j4, periodType, (a) null);
    }

    public void setPeriod(h hVar, h hVar2) {
        a chronology;
        if (hVar == hVar2) {
            setPeriod(0L);
            return;
        }
        long d5 = c.d(hVar);
        long d8 = c.d(hVar2);
        if (hVar != null) {
            chronology = hVar.getChronology();
        } else {
            chronology = hVar2 != null ? hVar2.getChronology() : null;
        }
        if (chronology == null) {
            chronology = ISOChronology.getInstance();
        }
        setPeriod(d5, d8, chronology);
    }

    public MutablePeriod(long j4, a aVar) {
        super(j4, (PeriodType) null, aVar);
    }

    public MutablePeriod(long j4, PeriodType periodType, a aVar) {
        super(j4, periodType, aVar);
    }

    public MutablePeriod(long j4, long j10) {
        super(j4, j10, null, null);
    }

    public MutablePeriod(long j4, long j10, PeriodType periodType) {
        super(j4, j10, periodType, null);
    }

    public MutablePeriod(long j4, long j10, a aVar) {
        super(j4, j10, null, aVar);
    }

    public void add(i iVar) {
        if (iVar != null) {
            add(iVar.toPeriod(getPeriodType()));
        }
    }

    public MutablePeriod(long j4, long j10, PeriodType periodType, a aVar) {
        super(j4, j10, periodType, aVar);
    }

    public void add(g gVar) {
        if (gVar != null) {
            add(new Period(gVar.getMillis(), getPeriodType()));
        }
    }

    public MutablePeriod(h hVar, h hVar2) {
        super(hVar, hVar2, (PeriodType) null);
    }

    public void add(long j4) {
        add(new Period(j4, getPeriodType()));
    }

    public void setPeriod(long j4, long j10) {
        setPeriod(j4, j10, null);
    }

    public MutablePeriod(h hVar, h hVar2, PeriodType periodType) {
        super(hVar, hVar2, periodType);
    }

    public void add(long j4, a aVar) {
        add(new Period(j4, getPeriodType(), aVar));
    }

    public void setPeriod(long j4, long j10, a aVar) {
        AtomicReference atomicReference = c.f17022a;
        if (aVar == null) {
            aVar = ISOChronology.getInstance();
        }
        setValues(aVar.get(this, j4, j10));
    }

    public MutablePeriod(h hVar, g gVar) {
        super(hVar, gVar, (PeriodType) null);
    }

    public MutablePeriod(h hVar, g gVar, PeriodType periodType) {
        super(hVar, gVar, periodType);
    }

    public MutablePeriod(g gVar, h hVar) {
        super(gVar, hVar, (PeriodType) null);
    }

    public void setPeriod(g gVar) {
        setPeriod(gVar, (a) null);
    }

    public MutablePeriod(g gVar, h hVar, PeriodType periodType) {
        super(gVar, hVar, periodType);
    }

    public void setPeriod(g gVar, a aVar) {
        setPeriod(c.b(gVar), aVar);
    }

    public MutablePeriod(Object obj) {
        super(obj, (PeriodType) null, (a) null);
    }

    public MutablePeriod(Object obj, PeriodType periodType) {
        super(obj, periodType, (a) null);
    }

    public void setPeriod(long j4) {
        setPeriod(j4, (a) null);
    }

    public MutablePeriod(Object obj, a aVar) {
        super(obj, (PeriodType) null, aVar);
    }

    public void setPeriod(long j4, a aVar) {
        AtomicReference atomicReference = c.f17022a;
        if (aVar == null) {
            aVar = ISOChronology.getInstance();
        }
        setValues(aVar.get(this, j4));
    }

    public MutablePeriod(Object obj, PeriodType periodType, a aVar) {
        super(obj, periodType, aVar);
    }
}
