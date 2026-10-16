package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.IllegalFieldValueException;

/* loaded from: classes2.dex */
public class g extends org.joda.time.field.b {

    /* renamed from: b, reason: collision with root package name */
    public final org.joda.time.b f17088b;

    /* renamed from: c, reason: collision with root package name */
    public final org.joda.time.b f17089c;

    /* renamed from: d, reason: collision with root package name */
    public final long f17090d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public org.joda.time.e f17091f;

    /* renamed from: g, reason: collision with root package name */
    public org.joda.time.e f17092g;

    /* renamed from: h, reason: collision with root package name */
    public final /* synthetic */ GJChronology f17093h;

    public g(GJChronology gJChronology, org.joda.time.b bVar, org.joda.time.b bVar2, long j4) {
        this(gJChronology, bVar, bVar2, null, j4, false);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long add(long j4, int i3) {
        return this.f17089c.add(j4, i3);
    }

    public final long c(long j4) {
        boolean z5 = this.e;
        GJChronology gJChronology = this.f17093h;
        return z5 ? gJChronology.gregorianToJulianByWeekyear(j4) : gJChronology.gregorianToJulianByYear(j4);
    }

    public final long d(long j4) {
        boolean z5 = this.e;
        GJChronology gJChronology = this.f17093h;
        return z5 ? gJChronology.julianToGregorianByWeekyear(j4) : gJChronology.julianToGregorianByYear(j4);
    }

    @Override // org.joda.time.b
    public final int get(long j4) {
        return j4 >= this.f17090d ? this.f17089c.get(j4) : this.f17088b.get(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsShortText(long j4, Locale locale) {
        return j4 >= this.f17090d ? this.f17089c.getAsShortText(j4, locale) : this.f17088b.getAsShortText(j4, locale);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsText(long j4, Locale locale) {
        return j4 >= this.f17090d ? this.f17089c.getAsText(j4, locale) : this.f17088b.getAsText(j4, locale);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getDifference(long j4, long j10) {
        return this.f17089c.getDifference(j4, j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long getDifferenceAsLong(long j4, long j10) {
        return this.f17089c.getDifferenceAsLong(j4, j10);
    }

    @Override // org.joda.time.b
    public final org.joda.time.e getDurationField() {
        return this.f17091f;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getLeapAmount(long j4) {
        return j4 >= this.f17090d ? this.f17089c.getLeapAmount(j4) : this.f17088b.getLeapAmount(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final org.joda.time.e getLeapDurationField() {
        return this.f17089c.getLeapDurationField();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumShortTextLength(Locale locale) {
        return Math.max(this.f17088b.getMaximumShortTextLength(locale), this.f17089c.getMaximumShortTextLength(locale));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumTextLength(Locale locale) {
        return Math.max(this.f17088b.getMaximumTextLength(locale), this.f17089c.getMaximumTextLength(locale));
    }

    @Override // org.joda.time.b
    public final int getMaximumValue() {
        return this.f17089c.getMaximumValue();
    }

    @Override // org.joda.time.b
    public final int getMinimumValue() {
        return this.f17088b.getMinimumValue();
    }

    @Override // org.joda.time.b
    public final org.joda.time.e getRangeDurationField() {
        return this.f17092g;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final boolean isLeap(long j4) {
        return j4 >= this.f17090d ? this.f17089c.isLeap(j4) : this.f17088b.isLeap(j4);
    }

    @Override // org.joda.time.b
    public final boolean isLenient() {
        return false;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundCeiling(long j4) {
        long j10;
        long j11 = this.f17090d;
        if (j4 >= j11) {
            return this.f17089c.roundCeiling(j4);
        }
        long roundCeiling = this.f17088b.roundCeiling(j4);
        if (roundCeiling < j11) {
            return roundCeiling;
        }
        j10 = this.f17093h.iGapDuration;
        return roundCeiling - j10 >= j11 ? d(roundCeiling) : roundCeiling;
    }

    @Override // org.joda.time.b
    public final long roundFloor(long j4) {
        long j10;
        long j11 = this.f17090d;
        if (j4 < j11) {
            return this.f17088b.roundFloor(j4);
        }
        long roundFloor = this.f17089c.roundFloor(j4);
        if (roundFloor >= j11) {
            return roundFloor;
        }
        j10 = this.f17093h.iGapDuration;
        return j10 + roundFloor < j11 ? c(roundFloor) : roundFloor;
    }

    @Override // org.joda.time.b
    public final long set(long j4, int i3) {
        long j10;
        long j11;
        long j12 = this.f17090d;
        GJChronology gJChronology = this.f17093h;
        if (j4 >= j12) {
            org.joda.time.b bVar = this.f17089c;
            long j13 = bVar.set(j4, i3);
            if (j13 >= j12) {
                return j13;
            }
            j11 = gJChronology.iGapDuration;
            if (j11 + j13 < j12) {
                j13 = c(j13);
            }
            if (get(j13) == i3) {
                return j13;
            }
            throw new IllegalFieldValueException(bVar.getType(), Integer.valueOf(i3), (Number) null, (Number) null);
        }
        org.joda.time.b bVar2 = this.f17088b;
        long j14 = bVar2.set(j4, i3);
        if (j14 < j12) {
            return j14;
        }
        j10 = gJChronology.iGapDuration;
        if (j14 - j10 >= j12) {
            j14 = d(j14);
        }
        if (get(j14) == i3) {
            return j14;
        }
        throw new IllegalFieldValueException(bVar2.getType(), Integer.valueOf(i3), (Number) null, (Number) null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public g(GJChronology gJChronology, org.joda.time.b bVar, org.joda.time.b bVar2, org.joda.time.e eVar, long j4, boolean z5) {
        super(bVar2.getType());
        this.f17093h = gJChronology;
        this.f17088b = bVar;
        this.f17089c = bVar2;
        this.f17090d = j4;
        this.e = z5;
        this.f17091f = bVar2.getDurationField();
        if (eVar == null && (eVar = bVar2.getRangeDurationField()) == null) {
            eVar = bVar.getRangeDurationField();
        }
        this.f17092g = eVar;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public long add(long j4, long j10) {
        return this.f17089c.add(j4, j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMaximumValue(long j4) {
        long j10 = this.f17090d;
        if (j4 >= j10) {
            return this.f17089c.getMaximumValue(j4);
        }
        org.joda.time.b bVar = this.f17088b;
        int maximumValue = bVar.getMaximumValue(j4);
        return bVar.set(j4, maximumValue) >= j10 ? bVar.get(bVar.add(j10, -1)) : maximumValue;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMinimumValue(org.joda.time.j jVar) {
        return this.f17088b.getMinimumValue(jVar);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int[] add(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        if (i10 == 0) {
            return iArr;
        }
        if (org.joda.time.c.e(jVar)) {
            int size = jVar.size();
            long j4 = 0;
            int i11 = 0;
            while (true) {
                GJChronology gJChronology = this.f17093h;
                if (i11 < size) {
                    j4 = jVar.getFieldType(i11).getField(gJChronology).set(j4, iArr[i11]);
                    i11++;
                } else {
                    return gJChronology.get(jVar, add(j4, i10));
                }
            }
        } else {
            return super.add(jVar, i3, iArr, i10);
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMinimumValue(org.joda.time.j jVar, int[] iArr) {
        return this.f17088b.getMinimumValue(jVar, iArr);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsShortText(int i3, Locale locale) {
        return this.f17089c.getAsShortText(i3, locale);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsText(int i3, Locale locale) {
        return this.f17089c.getAsText(i3, locale);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public int getMinimumValue(long j4) {
        long j10 = this.f17090d;
        if (j4 < j10) {
            return this.f17088b.getMinimumValue(j4);
        }
        org.joda.time.b bVar = this.f17089c;
        int minimumValue = bVar.getMinimumValue(j4);
        return bVar.set(j4, minimumValue) < j10 ? bVar.get(j10) : minimumValue;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumValue(org.joda.time.j jVar) {
        return getMaximumValue(GJChronology.getInstanceUTC().set(jVar, 0L));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumValue(org.joda.time.j jVar, int[] iArr) {
        GJChronology instanceUTC = GJChronology.getInstanceUTC();
        int size = jVar.size();
        long j4 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            org.joda.time.b field = jVar.getFieldType(i3).getField(instanceUTC);
            if (iArr[i3] <= field.getMaximumValue(j4)) {
                j4 = field.set(j4, iArr[i3]);
            }
        }
        return getMaximumValue(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long set(long j4, String str, Locale locale) {
        long j10;
        long j11;
        long j12 = this.f17090d;
        GJChronology gJChronology = this.f17093h;
        if (j4 >= j12) {
            long j13 = this.f17089c.set(j4, str, locale);
            if (j13 >= j12) {
                return j13;
            }
            j11 = gJChronology.iGapDuration;
            return j11 + j13 < j12 ? c(j13) : j13;
        }
        long j14 = this.f17088b.set(j4, str, locale);
        if (j14 < j12) {
            return j14;
        }
        j10 = gJChronology.iGapDuration;
        return j14 - j10 >= j12 ? d(j14) : j14;
    }
}
