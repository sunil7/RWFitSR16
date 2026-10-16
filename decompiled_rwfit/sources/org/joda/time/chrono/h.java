package org.joda.time.chrono;

import org.joda.time.chrono.GJChronology;

/* loaded from: classes2.dex */
public final class h extends g {

    /* renamed from: i, reason: collision with root package name */
    public final /* synthetic */ GJChronology f17094i;

    public h(GJChronology gJChronology, org.joda.time.b bVar, org.joda.time.b bVar2, long j4) {
        this(gJChronology, bVar, bVar2, (org.joda.time.e) null, j4, false);
    }

    @Override // org.joda.time.chrono.g, org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, int i3) {
        long j10;
        long j11;
        GregorianChronology gregorianChronology;
        GregorianChronology gregorianChronology2;
        GregorianChronology gregorianChronology3;
        GregorianChronology gregorianChronology4;
        long j12 = this.f17090d;
        GJChronology gJChronology = this.f17094i;
        if (j4 < j12) {
            long add = this.f17088b.add(j4, i3);
            if (add < j12) {
                return add;
            }
            j10 = gJChronology.iGapDuration;
            return add - j10 >= j12 ? d(add) : add;
        }
        long add2 = this.f17089c.add(j4, i3);
        if (add2 >= j12) {
            return add2;
        }
        j11 = gJChronology.iGapDuration;
        if (j11 + add2 >= j12) {
            return add2;
        }
        if (this.e) {
            gregorianChronology3 = gJChronology.iGregorianChronology;
            if (gregorianChronology3.weekyear().get(add2) <= 0) {
                gregorianChronology4 = gJChronology.iGregorianChronology;
                add2 = gregorianChronology4.weekyear().add(add2, -1);
            }
        } else {
            gregorianChronology = gJChronology.iGregorianChronology;
            if (gregorianChronology.year().get(add2) <= 0) {
                gregorianChronology2 = gJChronology.iGregorianChronology;
                add2 = gregorianChronology2.year().add(add2, -1);
            }
        }
        return c(add2);
    }

    @Override // org.joda.time.chrono.g, org.joda.time.field.b, org.joda.time.b
    public final int getDifference(long j4, long j10) {
        long j11 = this.f17090d;
        org.joda.time.b bVar = this.f17088b;
        org.joda.time.b bVar2 = this.f17089c;
        return j4 >= j11 ? j10 >= j11 ? bVar2.getDifference(j4, j10) : bVar.getDifference(c(j4), j10) : j10 < j11 ? bVar.getDifference(j4, j10) : bVar2.getDifference(d(j4), j10);
    }

    @Override // org.joda.time.chrono.g, org.joda.time.field.b, org.joda.time.b
    public final long getDifferenceAsLong(long j4, long j10) {
        long j11 = this.f17090d;
        org.joda.time.b bVar = this.f17088b;
        org.joda.time.b bVar2 = this.f17089c;
        return j4 >= j11 ? j10 >= j11 ? bVar2.getDifferenceAsLong(j4, j10) : bVar.getDifferenceAsLong(c(j4), j10) : j10 < j11 ? bVar.getDifferenceAsLong(j4, j10) : bVar2.getDifferenceAsLong(d(j4), j10);
    }

    @Override // org.joda.time.chrono.g, org.joda.time.field.b, org.joda.time.b
    public final int getMaximumValue(long j4) {
        return j4 >= this.f17090d ? this.f17089c.getMaximumValue(j4) : this.f17088b.getMaximumValue(j4);
    }

    @Override // org.joda.time.chrono.g, org.joda.time.field.b, org.joda.time.b
    public final int getMinimumValue(long j4) {
        return j4 >= this.f17090d ? this.f17089c.getMinimumValue(j4) : this.f17088b.getMinimumValue(j4);
    }

    public h(GJChronology gJChronology, org.joda.time.b bVar, org.joda.time.b bVar2, org.joda.time.e eVar, org.joda.time.e eVar2, long j4) {
        this(gJChronology, bVar, bVar2, eVar, j4, false);
        this.f17092g = eVar2;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public h(GJChronology gJChronology, org.joda.time.b bVar, org.joda.time.b bVar2, org.joda.time.e eVar, long j4, boolean z5) {
        super(gJChronology, bVar, bVar2, null, j4, z5);
        this.f17094i = gJChronology;
        this.f17091f = eVar == null ? new GJChronology.LinkedDurationField(this.f17091f, this) : eVar;
    }

    @Override // org.joda.time.chrono.g, org.joda.time.field.b, org.joda.time.b
    public final long add(long j4, long j10) {
        long j11;
        long j12;
        GregorianChronology gregorianChronology;
        GregorianChronology gregorianChronology2;
        GregorianChronology gregorianChronology3;
        GregorianChronology gregorianChronology4;
        long j13 = this.f17090d;
        GJChronology gJChronology = this.f17094i;
        if (j4 >= j13) {
            long add = this.f17089c.add(j4, j10);
            if (add >= j13) {
                return add;
            }
            j12 = gJChronology.iGapDuration;
            if (j12 + add >= j13) {
                return add;
            }
            if (this.e) {
                gregorianChronology3 = gJChronology.iGregorianChronology;
                if (gregorianChronology3.weekyear().get(add) <= 0) {
                    gregorianChronology4 = gJChronology.iGregorianChronology;
                    add = gregorianChronology4.weekyear().add(add, -1);
                }
            } else {
                gregorianChronology = gJChronology.iGregorianChronology;
                if (gregorianChronology.year().get(add) <= 0) {
                    gregorianChronology2 = gJChronology.iGregorianChronology;
                    add = gregorianChronology2.year().add(add, -1);
                }
            }
            return c(add);
        }
        long add2 = this.f17088b.add(j4, j10);
        if (add2 < j13) {
            return add2;
        }
        j11 = gJChronology.iGapDuration;
        return add2 - j11 >= j13 ? d(add2) : add2;
    }
}
