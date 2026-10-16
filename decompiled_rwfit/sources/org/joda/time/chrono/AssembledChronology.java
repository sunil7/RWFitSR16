package org.joda.time.chrono;

import java.io.IOException;
import java.io.ObjectInputStream;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public abstract class AssembledChronology extends BaseChronology {
    private static final long serialVersionUID = -6728465968995518215L;
    public transient org.joda.time.b A;
    public transient org.joda.time.b B;
    public transient org.joda.time.b C;
    public transient org.joda.time.b D;
    public transient org.joda.time.b E;
    public transient org.joda.time.b F;
    public transient org.joda.time.b G;
    public transient org.joda.time.b H;
    public transient org.joda.time.b I;
    public transient int J;

    /* renamed from: a, reason: collision with root package name */
    public transient org.joda.time.e f17023a;

    /* renamed from: b, reason: collision with root package name */
    public transient org.joda.time.e f17024b;

    /* renamed from: c, reason: collision with root package name */
    public transient org.joda.time.e f17025c;

    /* renamed from: d, reason: collision with root package name */
    public transient org.joda.time.e f17026d;
    public transient org.joda.time.e e;

    /* renamed from: f, reason: collision with root package name */
    public transient org.joda.time.e f17027f;

    /* renamed from: g, reason: collision with root package name */
    public transient org.joda.time.e f17028g;

    /* renamed from: h, reason: collision with root package name */
    public transient org.joda.time.e f17029h;

    /* renamed from: i, reason: collision with root package name */
    public transient org.joda.time.e f17030i;
    private final org.joda.time.a iBase;
    private final Object iParam;

    /* renamed from: j, reason: collision with root package name */
    public transient org.joda.time.e f17031j;

    /* renamed from: k, reason: collision with root package name */
    public transient org.joda.time.e f17032k;

    /* renamed from: l, reason: collision with root package name */
    public transient org.joda.time.e f17033l;

    /* renamed from: m, reason: collision with root package name */
    public transient org.joda.time.b f17034m;

    /* renamed from: n, reason: collision with root package name */
    public transient org.joda.time.b f17035n;

    /* renamed from: o, reason: collision with root package name */
    public transient org.joda.time.b f17036o;

    /* renamed from: p, reason: collision with root package name */
    public transient org.joda.time.b f17037p;

    /* renamed from: q, reason: collision with root package name */
    public transient org.joda.time.b f17038q;
    public transient org.joda.time.b r;

    /* renamed from: s, reason: collision with root package name */
    public transient org.joda.time.b f17039s;

    /* renamed from: t, reason: collision with root package name */
    public transient org.joda.time.b f17040t;

    /* renamed from: u, reason: collision with root package name */
    public transient org.joda.time.b f17041u;

    /* renamed from: v, reason: collision with root package name */
    public transient org.joda.time.b f17042v;

    /* renamed from: w, reason: collision with root package name */
    public transient org.joda.time.b f17043w;

    /* renamed from: x, reason: collision with root package name */
    public transient org.joda.time.b f17044x;

    /* renamed from: y, reason: collision with root package name */
    public transient org.joda.time.b f17045y;

    /* renamed from: z, reason: collision with root package name */
    public transient org.joda.time.b f17046z;

    public AssembledChronology(org.joda.time.a aVar, Object obj) {
        this.iBase = aVar;
        this.iParam = obj;
        a();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        a();
    }

    public final void a() {
        a aVar = new a();
        org.joda.time.a aVar2 = this.iBase;
        if (aVar2 != null) {
            aVar.a(aVar2);
        }
        assemble(aVar);
        org.joda.time.e eVar = aVar.f17057a;
        if (eVar == null) {
            eVar = super.millis();
        }
        this.f17023a = eVar;
        org.joda.time.e eVar2 = aVar.f17058b;
        if (eVar2 == null) {
            eVar2 = super.seconds();
        }
        this.f17024b = eVar2;
        org.joda.time.e eVar3 = aVar.f17059c;
        if (eVar3 == null) {
            eVar3 = super.minutes();
        }
        this.f17025c = eVar3;
        org.joda.time.e eVar4 = aVar.f17060d;
        if (eVar4 == null) {
            eVar4 = super.hours();
        }
        this.f17026d = eVar4;
        org.joda.time.e eVar5 = aVar.e;
        if (eVar5 == null) {
            eVar5 = super.halfdays();
        }
        this.e = eVar5;
        org.joda.time.e eVar6 = aVar.f17061f;
        if (eVar6 == null) {
            eVar6 = super.days();
        }
        this.f17027f = eVar6;
        org.joda.time.e eVar7 = aVar.f17062g;
        if (eVar7 == null) {
            eVar7 = super.weeks();
        }
        this.f17028g = eVar7;
        org.joda.time.e eVar8 = aVar.f17063h;
        if (eVar8 == null) {
            eVar8 = super.weekyears();
        }
        this.f17029h = eVar8;
        org.joda.time.e eVar9 = aVar.f17064i;
        if (eVar9 == null) {
            eVar9 = super.months();
        }
        this.f17030i = eVar9;
        org.joda.time.e eVar10 = aVar.f17065j;
        if (eVar10 == null) {
            eVar10 = super.years();
        }
        this.f17031j = eVar10;
        org.joda.time.e eVar11 = aVar.f17066k;
        if (eVar11 == null) {
            eVar11 = super.centuries();
        }
        this.f17032k = eVar11;
        org.joda.time.e eVar12 = aVar.f17067l;
        if (eVar12 == null) {
            eVar12 = super.eras();
        }
        this.f17033l = eVar12;
        org.joda.time.b bVar = aVar.f17068m;
        if (bVar == null) {
            bVar = super.millisOfSecond();
        }
        this.f17034m = bVar;
        org.joda.time.b bVar2 = aVar.f17069n;
        if (bVar2 == null) {
            bVar2 = super.millisOfDay();
        }
        this.f17035n = bVar2;
        org.joda.time.b bVar3 = aVar.f17070o;
        if (bVar3 == null) {
            bVar3 = super.secondOfMinute();
        }
        this.f17036o = bVar3;
        org.joda.time.b bVar4 = aVar.f17071p;
        if (bVar4 == null) {
            bVar4 = super.secondOfDay();
        }
        this.f17037p = bVar4;
        org.joda.time.b bVar5 = aVar.f17072q;
        if (bVar5 == null) {
            bVar5 = super.minuteOfHour();
        }
        this.f17038q = bVar5;
        org.joda.time.b bVar6 = aVar.r;
        if (bVar6 == null) {
            bVar6 = super.minuteOfDay();
        }
        this.r = bVar6;
        org.joda.time.b bVar7 = aVar.f17073s;
        if (bVar7 == null) {
            bVar7 = super.hourOfDay();
        }
        this.f17039s = bVar7;
        org.joda.time.b bVar8 = aVar.f17074t;
        if (bVar8 == null) {
            bVar8 = super.clockhourOfDay();
        }
        this.f17040t = bVar8;
        org.joda.time.b bVar9 = aVar.f17075u;
        if (bVar9 == null) {
            bVar9 = super.hourOfHalfday();
        }
        this.f17041u = bVar9;
        org.joda.time.b bVar10 = aVar.f17076v;
        if (bVar10 == null) {
            bVar10 = super.clockhourOfHalfday();
        }
        this.f17042v = bVar10;
        org.joda.time.b bVar11 = aVar.f17077w;
        if (bVar11 == null) {
            bVar11 = super.halfdayOfDay();
        }
        this.f17043w = bVar11;
        org.joda.time.b bVar12 = aVar.f17078x;
        if (bVar12 == null) {
            bVar12 = super.dayOfWeek();
        }
        this.f17044x = bVar12;
        org.joda.time.b bVar13 = aVar.f17079y;
        if (bVar13 == null) {
            bVar13 = super.dayOfMonth();
        }
        this.f17045y = bVar13;
        org.joda.time.b bVar14 = aVar.f17080z;
        if (bVar14 == null) {
            bVar14 = super.dayOfYear();
        }
        this.f17046z = bVar14;
        org.joda.time.b bVar15 = aVar.A;
        if (bVar15 == null) {
            bVar15 = super.weekOfWeekyear();
        }
        this.A = bVar15;
        org.joda.time.b bVar16 = aVar.B;
        if (bVar16 == null) {
            bVar16 = super.weekyear();
        }
        this.B = bVar16;
        org.joda.time.b bVar17 = aVar.C;
        if (bVar17 == null) {
            bVar17 = super.weekyearOfCentury();
        }
        this.C = bVar17;
        org.joda.time.b bVar18 = aVar.D;
        if (bVar18 == null) {
            bVar18 = super.monthOfYear();
        }
        this.D = bVar18;
        org.joda.time.b bVar19 = aVar.E;
        if (bVar19 == null) {
            bVar19 = super.year();
        }
        this.E = bVar19;
        org.joda.time.b bVar20 = aVar.F;
        if (bVar20 == null) {
            bVar20 = super.yearOfEra();
        }
        this.F = bVar20;
        org.joda.time.b bVar21 = aVar.G;
        if (bVar21 == null) {
            bVar21 = super.yearOfCentury();
        }
        this.G = bVar21;
        org.joda.time.b bVar22 = aVar.H;
        if (bVar22 == null) {
            bVar22 = super.centuryOfEra();
        }
        this.H = bVar22;
        org.joda.time.b bVar23 = aVar.I;
        if (bVar23 == null) {
            bVar23 = super.era();
        }
        this.I = bVar23;
        org.joda.time.a aVar3 = this.iBase;
        int i3 = 0;
        if (aVar3 != null) {
            int i10 = ((this.f17039s == aVar3.hourOfDay() && this.f17038q == this.iBase.minuteOfHour() && this.f17036o == this.iBase.secondOfMinute() && this.f17034m == this.iBase.millisOfSecond()) ? 1 : 0) | (this.f17035n == this.iBase.millisOfDay() ? 2 : 0);
            if (this.E == this.iBase.year() && this.D == this.iBase.monthOfYear() && this.f17045y == this.iBase.dayOfMonth()) {
                i3 = 4;
            }
            i3 |= i10;
        }
        this.J = i3;
    }

    public abstract void assemble(a aVar);

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.e centuries() {
        return this.f17032k;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b centuryOfEra() {
        return this.H;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b clockhourOfDay() {
        return this.f17040t;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b clockhourOfHalfday() {
        return this.f17042v;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b dayOfMonth() {
        return this.f17045y;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b dayOfWeek() {
        return this.f17044x;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b dayOfYear() {
        return this.f17046z;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.e days() {
        return this.f17027f;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b era() {
        return this.I;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.e eras() {
        return this.f17033l;
    }

    public final org.joda.time.a getBase() {
        return this.iBase;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i3, int i10, int i11, int i12) throws IllegalArgumentException {
        org.joda.time.a aVar = this.iBase;
        return (aVar == null || (this.J & 6) != 6) ? super.getDateTimeMillis(i3, i10, i11, i12) : aVar.getDateTimeMillis(i3, i10, i11, i12);
    }

    public final Object getParam() {
        return this.iParam;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public DateTimeZone getZone() {
        org.joda.time.a aVar = this.iBase;
        if (aVar != null) {
            return aVar.getZone();
        }
        return null;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b halfdayOfDay() {
        return this.f17043w;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.e halfdays() {
        return this.e;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b hourOfDay() {
        return this.f17039s;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b hourOfHalfday() {
        return this.f17041u;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.e hours() {
        return this.f17026d;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.e millis() {
        return this.f17023a;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b millisOfDay() {
        return this.f17035n;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b millisOfSecond() {
        return this.f17034m;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b minuteOfDay() {
        return this.r;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b minuteOfHour() {
        return this.f17038q;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.e minutes() {
        return this.f17025c;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b monthOfYear() {
        return this.D;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.e months() {
        return this.f17030i;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b secondOfDay() {
        return this.f17037p;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b secondOfMinute() {
        return this.f17036o;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.e seconds() {
        return this.f17024b;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b weekOfWeekyear() {
        return this.A;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.e weeks() {
        return this.f17028g;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b weekyear() {
        return this.B;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b weekyearOfCentury() {
        return this.C;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.e weekyears() {
        return this.f17029h;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b year() {
        return this.E;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b yearOfCentury() {
        return this.G;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.b yearOfEra() {
        return this.F;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public final org.joda.time.e years() {
        return this.f17031j;
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(int i3, int i10, int i11, int i12, int i13, int i14, int i15) throws IllegalArgumentException {
        org.joda.time.a aVar = this.iBase;
        if (aVar != null && (this.J & 5) == 5) {
            return aVar.getDateTimeMillis(i3, i10, i11, i12, i13, i14, i15);
        }
        return super.getDateTimeMillis(i3, i10, i11, i12, i13, i14, i15);
    }

    @Override // org.joda.time.chrono.BaseChronology, org.joda.time.a
    public long getDateTimeMillis(long j4, int i3, int i10, int i11, int i12) throws IllegalArgumentException {
        org.joda.time.a aVar = this.iBase;
        if (aVar != null && (this.J & 1) == 1) {
            return aVar.getDateTimeMillis(j4, i3, i10, i11, i12);
        }
        return super.getDateTimeMillis(j4, i3, i10, i11, i12);
    }
}
