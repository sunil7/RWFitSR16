package org.joda.time.base;

import ai.f;
import ai.h;
import androidx.camera.core.impl.e;
import bi.d;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.Duration;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.joda.time.PeriodType;
import org.joda.time.a;
import org.joda.time.c;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.g;
import org.joda.time.j;
import org.joda.time.k;

/* loaded from: classes2.dex */
public abstract class BasePeriod extends f implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static final h f17021a = new h();
    private static final long serialVersionUID = -2110953284060001145L;
    private final PeriodType iType;
    private final int[] iValues;

    public BasePeriod(int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16, PeriodType periodType) {
        this.iType = checkPeriodType(periodType);
        this.iValues = b(i3, i10, i11, i12, i13, i14, i15, i16);
    }

    public final void a(int[] iArr, DurationFieldType durationFieldType, int i3) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf != -1) {
            iArr[indexOf] = i3;
        } else {
            if (i3 == 0) {
                return;
            }
            throw new IllegalArgumentException("Period does not support field '" + durationFieldType.getName() + "'");
        }
    }

    public void addField(DurationFieldType durationFieldType, int i3) {
        addFieldInto(this.iValues, durationFieldType, i3);
    }

    public void addFieldInto(int[] iArr, DurationFieldType durationFieldType, int i3) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf != -1) {
            iArr[indexOf] = nf.c(iArr[indexOf], i3);
        } else if (i3 != 0 || durationFieldType == null) {
            throw new IllegalArgumentException("Period does not support field '" + durationFieldType + "'");
        }
    }

    public void addPeriod(k kVar) {
        if (kVar != null) {
            setValues(addPeriodInto(getValues(), kVar));
        }
    }

    public int[] addPeriodInto(int[] iArr, k kVar) {
        int size = kVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            DurationFieldType fieldType = kVar.getFieldType(i3);
            int value = kVar.getValue(i3);
            if (value != 0) {
                int indexOf = indexOf(fieldType);
                if (indexOf == -1) {
                    throw new IllegalArgumentException("Period does not support field '" + fieldType.getName() + "'");
                }
                iArr[indexOf] = nf.c(getValue(indexOf), value);
            }
        }
        return iArr;
    }

    public final int[] b(int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        int[] iArr = new int[size()];
        a(iArr, DurationFieldType.years(), i3);
        a(iArr, DurationFieldType.months(), i10);
        a(iArr, DurationFieldType.weeks(), i11);
        a(iArr, DurationFieldType.days(), i12);
        a(iArr, DurationFieldType.hours(), i13);
        a(iArr, DurationFieldType.minutes(), i14);
        a(iArr, DurationFieldType.seconds(), i15);
        a(iArr, DurationFieldType.millis(), i16);
        return iArr;
    }

    public PeriodType checkPeriodType(PeriodType periodType) {
        AtomicReference atomicReference = c.f17022a;
        return periodType == null ? PeriodType.standard() : periodType;
    }

    @Override // org.joda.time.k
    public PeriodType getPeriodType() {
        return this.iType;
    }

    @Override // org.joda.time.k
    public int getValue(int i3) {
        return this.iValues[i3];
    }

    public void mergePeriod(k kVar) {
        if (kVar != null) {
            setValues(mergePeriodInto(getValues(), kVar));
        }
    }

    public int[] mergePeriodInto(int[] iArr, k kVar) {
        int size = kVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            a(iArr, kVar.getFieldType(i3), kVar.getValue(i3));
        }
        return iArr;
    }

    public void setField(DurationFieldType durationFieldType, int i3) {
        setFieldInto(this.iValues, durationFieldType, i3);
    }

    public void setFieldInto(int[] iArr, DurationFieldType durationFieldType, int i3) {
        int indexOf = indexOf(durationFieldType);
        if (indexOf != -1) {
            iArr[indexOf] = i3;
        } else if (i3 != 0 || durationFieldType == null) {
            throw new IllegalArgumentException("Period does not support field '" + durationFieldType + "'");
        }
    }

    public void setPeriod(k kVar) {
        if (kVar == null) {
            setValues(new int[size()]);
            return;
        }
        int[] iArr = new int[size()];
        int size = kVar.size();
        for (int i3 = 0; i3 < size; i3++) {
            a(iArr, kVar.getFieldType(i3), kVar.getValue(i3));
        }
        setValues(iArr);
    }

    public void setValue(int i3, int i10) {
        this.iValues[i3] = i10;
    }

    public void setValues(int[] iArr) {
        int[] iArr2 = this.iValues;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
    }

    public Duration toDurationFrom(org.joda.time.h hVar) {
        long d5 = c.d(hVar);
        return new Duration(d5, c.c(hVar).add(this, d5, 1));
    }

    public Duration toDurationTo(org.joda.time.h hVar) {
        long d5 = c.d(hVar);
        return new Duration(c.c(hVar).add(this, d5, -1), d5);
    }

    public BasePeriod(long j4) {
        this.iType = PeriodType.standard();
        int[] iArr = ISOChronology.getInstanceUTC().get(f17021a, j4);
        int[] iArr2 = new int[8];
        this.iValues = iArr2;
        System.arraycopy(iArr, 0, iArr2, 4, 4);
    }

    public void setPeriod(int i3, int i10, int i11, int i12, int i13, int i14, int i15, int i16) {
        setValues(b(i3, i10, i11, i12, i13, i14, i15, i16));
    }

    public BasePeriod(long j4, long j10, PeriodType periodType, a aVar) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        AtomicReference atomicReference = c.f17022a;
        aVar = aVar == null ? ISOChronology.getInstance() : aVar;
        this.iType = checkPeriodType;
        this.iValues = aVar.get(this, j4, j10);
    }

    public BasePeriod(long j4, PeriodType periodType, a aVar) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        AtomicReference atomicReference = c.f17022a;
        aVar = aVar == null ? ISOChronology.getInstance() : aVar;
        this.iType = checkPeriodType;
        this.iValues = aVar.get(this, j4);
    }

    public BasePeriod(Object obj, PeriodType periodType, a aVar) {
        Class<?> cls;
        e e = e.e();
        if (obj == null) {
            cls = null;
        } else {
            e.getClass();
            cls = obj.getClass();
        }
        bi.k kVar = (bi.k) ((d) e.f1380f).b(cls);
        if (kVar != null) {
            PeriodType checkPeriodType = checkPeriodType(periodType == null ? kVar.h(obj) : periodType);
            this.iType = checkPeriodType;
            if (this instanceof MutablePeriod) {
                this.iValues = new int[size()];
                AtomicReference atomicReference = c.f17022a;
                kVar.f((MutablePeriod) this, obj, aVar == null ? ISOChronology.getInstance() : aVar);
                return;
            }
            this.iValues = new MutablePeriod(obj, checkPeriodType, aVar).getValues();
            return;
        }
        throw new IllegalArgumentException("No period converter found for type: ".concat(obj == null ? "null" : obj.getClass().getName()));
    }

    public BasePeriod(g gVar, org.joda.time.h hVar, PeriodType periodType) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        long b3 = c.b(gVar);
        long d5 = c.d(hVar);
        long i3 = nf.i(d5, b3);
        a c9 = c.c(hVar);
        this.iType = checkPeriodType;
        this.iValues = c9.get(this, i3, d5);
    }

    public BasePeriod(org.joda.time.h hVar, g gVar, PeriodType periodType) {
        PeriodType checkPeriodType = checkPeriodType(periodType);
        long d5 = c.d(hVar);
        long d8 = nf.d(d5, c.b(gVar));
        a c9 = c.c(hVar);
        this.iType = checkPeriodType;
        this.iValues = c9.get(this, d5, d8);
    }

    public BasePeriod(org.joda.time.h hVar, org.joda.time.h hVar2, PeriodType periodType) {
        a chronology;
        PeriodType checkPeriodType = checkPeriodType(periodType);
        if (hVar == null && hVar2 == null) {
            this.iType = checkPeriodType;
            this.iValues = new int[size()];
            return;
        }
        long d5 = c.d(hVar);
        long d8 = c.d(hVar2);
        if (hVar != null) {
            chronology = hVar.getChronology();
        } else {
            chronology = hVar2 != null ? hVar2.getChronology() : null;
        }
        chronology = chronology == null ? ISOChronology.getInstance() : chronology;
        this.iType = checkPeriodType;
        this.iValues = chronology.get(this, d5, d8);
    }

    public BasePeriod(j jVar, j jVar2, PeriodType periodType) {
        if (jVar != null && jVar2 != null) {
            if ((jVar instanceof ai.g) && (jVar2 instanceof ai.g) && jVar.getClass() == jVar2.getClass()) {
                PeriodType checkPeriodType = checkPeriodType(periodType);
                long localMillis = ((ai.g) jVar).getLocalMillis();
                long localMillis2 = ((ai.g) jVar2).getLocalMillis();
                a chronology = jVar.getChronology();
                AtomicReference atomicReference = c.f17022a;
                chronology = chronology == null ? ISOChronology.getInstance() : chronology;
                this.iType = checkPeriodType;
                this.iValues = chronology.get(this, localMillis, localMillis2);
                return;
            }
            if (jVar.size() == jVar2.size()) {
                int size = jVar.size();
                for (int i3 = 0; i3 < size; i3++) {
                    if (jVar.getFieldType(i3) != jVar2.getFieldType(i3)) {
                        throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
                    }
                }
                if (c.e(jVar)) {
                    this.iType = checkPeriodType(periodType);
                    a chronology2 = jVar.getChronology();
                    a withUTC = (chronology2 == null ? ISOChronology.getInstance() : chronology2).withUTC();
                    this.iValues = withUTC.get(this, withUTC.set(jVar, 0L), withUTC.set(jVar2, 0L));
                    return;
                }
                throw new IllegalArgumentException("ReadablePartial objects must be contiguous");
            }
            throw new IllegalArgumentException("ReadablePartial objects must have the same set of fields");
        }
        throw new IllegalArgumentException("ReadablePartial objects must not be null");
    }

    public BasePeriod(int[] iArr, PeriodType periodType) {
        this.iType = periodType;
        this.iValues = iArr;
    }
}
