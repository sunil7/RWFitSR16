package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.DateTimeZone;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;

/* loaded from: classes2.dex */
public final class o extends org.joda.time.field.b {

    /* renamed from: b, reason: collision with root package name */
    public final org.joda.time.b f17119b;

    /* renamed from: c, reason: collision with root package name */
    public final DateTimeZone f17120c;

    /* renamed from: d, reason: collision with root package name */
    public final org.joda.time.e f17121d;
    public final boolean e;

    /* renamed from: f, reason: collision with root package name */
    public final org.joda.time.e f17122f;

    /* renamed from: g, reason: collision with root package name */
    public final org.joda.time.e f17123g;

    public o(org.joda.time.b bVar, DateTimeZone dateTimeZone, org.joda.time.e eVar, org.joda.time.e eVar2, org.joda.time.e eVar3) {
        super(bVar.getType());
        if (!bVar.isSupported()) {
            throw new IllegalArgumentException();
        }
        this.f17119b = bVar;
        this.f17120c = dateTimeZone;
        this.f17121d = eVar;
        this.e = ZonedChronology.useTimeArithmetic(eVar);
        this.f17122f = eVar2;
        this.f17123g = eVar3;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, int i3) {
        boolean z5 = this.e;
        org.joda.time.b bVar = this.f17119b;
        if (z5) {
            long c9 = c(j4);
            return bVar.add(j4 + c9, i3) - c9;
        }
        return this.f17120c.convertLocalToUTC(bVar.add(this.f17120c.convertUTCToLocal(j4), i3), false, j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long addWrapField(long j4, int i3) {
        boolean z5 = this.e;
        org.joda.time.b bVar = this.f17119b;
        if (z5) {
            long c9 = c(j4);
            return bVar.addWrapField(j4 + c9, i3) - c9;
        }
        return this.f17120c.convertLocalToUTC(bVar.addWrapField(this.f17120c.convertUTCToLocal(j4), i3), false, j4);
    }

    public final int c(long j4) {
        int offset = this.f17120c.getOffset(j4);
        long j10 = offset;
        if (((j4 + j10) ^ j4) >= 0 || (j4 ^ j10) < 0) {
            return offset;
        }
        throw new ArithmeticException("Adding time zone offset caused overflow");
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof o) {
            o oVar = (o) obj;
            if (this.f17119b.equals(oVar.f17119b) && this.f17120c.equals(oVar.f17120c) && this.f17121d.equals(oVar.f17121d) && this.f17122f.equals(oVar.f17122f)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.joda.time.b
    public final int get(long j4) {
        return this.f17119b.get(this.f17120c.convertUTCToLocal(j4));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsShortText(long j4, Locale locale) {
        return this.f17119b.getAsShortText(this.f17120c.convertUTCToLocal(j4), locale);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsText(long j4, Locale locale) {
        return this.f17119b.getAsText(this.f17120c.convertUTCToLocal(j4), locale);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getDifference(long j4, long j10) {
        return this.f17119b.getDifference(j4 + (this.e ? r0 : c(j4)), j10 + c(j10));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long getDifferenceAsLong(long j4, long j10) {
        return this.f17119b.getDifferenceAsLong(j4 + (this.e ? r0 : c(j4)), j10 + c(j10));
    }

    @Override // org.joda.time.b
    public final org.joda.time.e getDurationField() {
        return this.f17121d;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getLeapAmount(long j4) {
        return this.f17119b.getLeapAmount(this.f17120c.convertUTCToLocal(j4));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final org.joda.time.e getLeapDurationField() {
        return this.f17123g;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumShortTextLength(Locale locale) {
        return this.f17119b.getMaximumShortTextLength(locale);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumTextLength(Locale locale) {
        return this.f17119b.getMaximumTextLength(locale);
    }

    @Override // org.joda.time.b
    public final int getMaximumValue() {
        return this.f17119b.getMaximumValue();
    }

    @Override // org.joda.time.b
    public final int getMinimumValue() {
        return this.f17119b.getMinimumValue();
    }

    @Override // org.joda.time.b
    public final org.joda.time.e getRangeDurationField() {
        return this.f17122f;
    }

    public final int hashCode() {
        return this.f17119b.hashCode() ^ this.f17120c.hashCode();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final boolean isLeap(long j4) {
        return this.f17119b.isLeap(this.f17120c.convertUTCToLocal(j4));
    }

    @Override // org.joda.time.b
    public final boolean isLenient() {
        return this.f17119b.isLenient();
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long remainder(long j4) {
        return this.f17119b.remainder(this.f17120c.convertUTCToLocal(j4));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundCeiling(long j4) {
        boolean z5 = this.e;
        org.joda.time.b bVar = this.f17119b;
        if (z5) {
            long c9 = c(j4);
            return bVar.roundCeiling(j4 + c9) - c9;
        }
        return this.f17120c.convertLocalToUTC(bVar.roundCeiling(this.f17120c.convertUTCToLocal(j4)), false, j4);
    }

    @Override // org.joda.time.b
    public final long roundFloor(long j4) {
        boolean z5 = this.e;
        org.joda.time.b bVar = this.f17119b;
        if (z5) {
            long c9 = c(j4);
            return bVar.roundFloor(j4 + c9) - c9;
        }
        return this.f17120c.convertLocalToUTC(bVar.roundFloor(this.f17120c.convertUTCToLocal(j4)), false, j4);
    }

    @Override // org.joda.time.b
    public final long set(long j4, int i3) {
        DateTimeZone dateTimeZone = this.f17120c;
        long convertUTCToLocal = dateTimeZone.convertUTCToLocal(j4);
        org.joda.time.b bVar = this.f17119b;
        long j10 = bVar.set(convertUTCToLocal, i3);
        long convertLocalToUTC = this.f17120c.convertLocalToUTC(j10, false, j4);
        if (get(convertLocalToUTC) == i3) {
            return convertLocalToUTC;
        }
        IllegalInstantException illegalInstantException = new IllegalInstantException(j10, dateTimeZone.getID());
        IllegalFieldValueException illegalFieldValueException = new IllegalFieldValueException(bVar.getType(), Integer.valueOf(i3), illegalInstantException.getMessage());
        illegalFieldValueException.initCause(illegalInstantException);
        throw illegalFieldValueException;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumValue(long j4) {
        return this.f17119b.getMaximumValue(this.f17120c.convertUTCToLocal(j4));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMinimumValue(long j4) {
        return this.f17119b.getMinimumValue(this.f17120c.convertUTCToLocal(j4));
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsShortText(int i3, Locale locale) {
        return this.f17119b.getAsShortText(i3, locale);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsText(int i3, Locale locale) {
        return this.f17119b.getAsText(i3, locale);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumValue(org.joda.time.j jVar) {
        return this.f17119b.getMaximumValue(jVar);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMinimumValue(org.joda.time.j jVar) {
        return this.f17119b.getMinimumValue(jVar);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumValue(org.joda.time.j jVar, int[] iArr) {
        return this.f17119b.getMaximumValue(jVar, iArr);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMinimumValue(org.joda.time.j jVar, int[] iArr) {
        return this.f17119b.getMinimumValue(jVar, iArr);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, long j10) {
        boolean z5 = this.e;
        org.joda.time.b bVar = this.f17119b;
        if (z5) {
            long c9 = c(j4);
            return bVar.add(j4 + c9, j10) - c9;
        }
        return this.f17120c.convertLocalToUTC(bVar.add(this.f17120c.convertUTCToLocal(j4), j10), false, j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long set(long j4, String str, Locale locale) {
        return this.f17120c.convertLocalToUTC(this.f17119b.set(this.f17120c.convertUTCToLocal(j4), str, locale), false, j4);
    }
}
