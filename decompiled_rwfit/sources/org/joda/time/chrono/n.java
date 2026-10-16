package org.joda.time.chrono;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class n extends org.joda.time.field.c {

    /* renamed from: c, reason: collision with root package name */
    public final org.joda.time.e f17116c;

    /* renamed from: d, reason: collision with root package name */
    public final org.joda.time.e f17117d;
    public final org.joda.time.e e;

    /* renamed from: f, reason: collision with root package name */
    public final /* synthetic */ LimitChronology f17118f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public n(LimitChronology limitChronology, org.joda.time.b bVar, org.joda.time.e eVar, org.joda.time.e eVar2, org.joda.time.e eVar3) {
        super(bVar, bVar.getType());
        this.f17118f = limitChronology;
        this.f17116c = eVar;
        this.f17117d = eVar2;
        this.e = eVar3;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, int i3) {
        LimitChronology limitChronology = this.f17118f;
        limitChronology.checkLimits(j4, null);
        long add = this.f17131b.add(j4, i3);
        limitChronology.checkLimits(add, "resulting");
        return add;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long addWrapField(long j4, int i3) {
        LimitChronology limitChronology = this.f17118f;
        limitChronology.checkLimits(j4, null);
        long addWrapField = this.f17131b.addWrapField(j4, i3);
        limitChronology.checkLimits(addWrapField, "resulting");
        return addWrapField;
    }

    @Override // org.joda.time.b
    public final int get(long j4) {
        this.f17118f.checkLimits(j4, null);
        return this.f17131b.get(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsShortText(long j4, Locale locale) {
        this.f17118f.checkLimits(j4, null);
        return this.f17131b.getAsShortText(j4, locale);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsText(long j4, Locale locale) {
        this.f17118f.checkLimits(j4, null);
        return this.f17131b.getAsText(j4, locale);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getDifference(long j4, long j10) {
        LimitChronology limitChronology = this.f17118f;
        limitChronology.checkLimits(j4, "minuend");
        limitChronology.checkLimits(j10, "subtrahend");
        return this.f17131b.getDifference(j4, j10);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long getDifferenceAsLong(long j4, long j10) {
        LimitChronology limitChronology = this.f17118f;
        limitChronology.checkLimits(j4, "minuend");
        limitChronology.checkLimits(j10, "subtrahend");
        return this.f17131b.getDifferenceAsLong(j4, j10);
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final org.joda.time.e getDurationField() {
        return this.f17116c;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getLeapAmount(long j4) {
        this.f17118f.checkLimits(j4, null);
        return this.f17131b.getLeapAmount(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final org.joda.time.e getLeapDurationField() {
        return this.e;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumShortTextLength(Locale locale) {
        return this.f17131b.getMaximumShortTextLength(locale);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumTextLength(Locale locale) {
        return this.f17131b.getMaximumTextLength(locale);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumValue(long j4) {
        this.f17118f.checkLimits(j4, null);
        return this.f17131b.getMaximumValue(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMinimumValue(long j4) {
        this.f17118f.checkLimits(j4, null);
        return this.f17131b.getMinimumValue(j4);
    }

    @Override // org.joda.time.field.c, org.joda.time.b
    public final org.joda.time.e getRangeDurationField() {
        return this.f17117d;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final boolean isLeap(long j4) {
        this.f17118f.checkLimits(j4, null);
        return this.f17131b.isLeap(j4);
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long remainder(long j4) {
        LimitChronology limitChronology = this.f17118f;
        limitChronology.checkLimits(j4, null);
        long remainder = this.f17131b.remainder(j4);
        limitChronology.checkLimits(remainder, "resulting");
        return remainder;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundCeiling(long j4) {
        LimitChronology limitChronology = this.f17118f;
        limitChronology.checkLimits(j4, null);
        long roundCeiling = this.f17131b.roundCeiling(j4);
        limitChronology.checkLimits(roundCeiling, "resulting");
        return roundCeiling;
    }

    @Override // org.joda.time.b
    public final long roundFloor(long j4) {
        LimitChronology limitChronology = this.f17118f;
        limitChronology.checkLimits(j4, null);
        long roundFloor = this.f17131b.roundFloor(j4);
        limitChronology.checkLimits(roundFloor, "resulting");
        return roundFloor;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundHalfCeiling(long j4) {
        LimitChronology limitChronology = this.f17118f;
        limitChronology.checkLimits(j4, null);
        long roundHalfCeiling = this.f17131b.roundHalfCeiling(j4);
        limitChronology.checkLimits(roundHalfCeiling, "resulting");
        return roundHalfCeiling;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundHalfEven(long j4) {
        LimitChronology limitChronology = this.f17118f;
        limitChronology.checkLimits(j4, null);
        long roundHalfEven = this.f17131b.roundHalfEven(j4);
        limitChronology.checkLimits(roundHalfEven, "resulting");
        return roundHalfEven;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundHalfFloor(long j4) {
        LimitChronology limitChronology = this.f17118f;
        limitChronology.checkLimits(j4, null);
        long roundHalfFloor = this.f17131b.roundHalfFloor(j4);
        limitChronology.checkLimits(roundHalfFloor, "resulting");
        return roundHalfFloor;
    }

    @Override // org.joda.time.b
    public final long set(long j4, int i3) {
        LimitChronology limitChronology = this.f17118f;
        limitChronology.checkLimits(j4, null);
        long j10 = this.f17131b.set(j4, i3);
        limitChronology.checkLimits(j10, "resulting");
        return j10;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, long j10) {
        LimitChronology limitChronology = this.f17118f;
        limitChronology.checkLimits(j4, null);
        long add = this.f17131b.add(j4, j10);
        limitChronology.checkLimits(add, "resulting");
        return add;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long set(long j4, String str, Locale locale) {
        LimitChronology limitChronology = this.f17118f;
        limitChronology.checkLimits(j4, null);
        long j10 = this.f17131b.set(j4, str, locale);
        limitChronology.checkLimits(j10, "resulting");
        return j10;
    }
}
