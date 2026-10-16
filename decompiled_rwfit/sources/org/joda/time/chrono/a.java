package org.joda.time.chrono;

/* loaded from: classes2.dex */
public final class a {
    public org.joda.time.b A;
    public org.joda.time.b B;
    public org.joda.time.b C;
    public org.joda.time.b D;
    public org.joda.time.b E;
    public org.joda.time.b F;
    public org.joda.time.b G;
    public org.joda.time.b H;
    public org.joda.time.b I;

    /* renamed from: a, reason: collision with root package name */
    public org.joda.time.e f17057a;

    /* renamed from: b, reason: collision with root package name */
    public org.joda.time.e f17058b;

    /* renamed from: c, reason: collision with root package name */
    public org.joda.time.e f17059c;

    /* renamed from: d, reason: collision with root package name */
    public org.joda.time.e f17060d;
    public org.joda.time.e e;

    /* renamed from: f, reason: collision with root package name */
    public org.joda.time.e f17061f;

    /* renamed from: g, reason: collision with root package name */
    public org.joda.time.e f17062g;

    /* renamed from: h, reason: collision with root package name */
    public org.joda.time.e f17063h;

    /* renamed from: i, reason: collision with root package name */
    public org.joda.time.e f17064i;

    /* renamed from: j, reason: collision with root package name */
    public org.joda.time.e f17065j;

    /* renamed from: k, reason: collision with root package name */
    public org.joda.time.e f17066k;

    /* renamed from: l, reason: collision with root package name */
    public org.joda.time.e f17067l;

    /* renamed from: m, reason: collision with root package name */
    public org.joda.time.b f17068m;

    /* renamed from: n, reason: collision with root package name */
    public org.joda.time.b f17069n;

    /* renamed from: o, reason: collision with root package name */
    public org.joda.time.b f17070o;

    /* renamed from: p, reason: collision with root package name */
    public org.joda.time.b f17071p;

    /* renamed from: q, reason: collision with root package name */
    public org.joda.time.b f17072q;
    public org.joda.time.b r;

    /* renamed from: s, reason: collision with root package name */
    public org.joda.time.b f17073s;

    /* renamed from: t, reason: collision with root package name */
    public org.joda.time.b f17074t;

    /* renamed from: u, reason: collision with root package name */
    public org.joda.time.b f17075u;

    /* renamed from: v, reason: collision with root package name */
    public org.joda.time.b f17076v;

    /* renamed from: w, reason: collision with root package name */
    public org.joda.time.b f17077w;

    /* renamed from: x, reason: collision with root package name */
    public org.joda.time.b f17078x;

    /* renamed from: y, reason: collision with root package name */
    public org.joda.time.b f17079y;

    /* renamed from: z, reason: collision with root package name */
    public org.joda.time.b f17080z;

    public static boolean b(org.joda.time.b bVar) {
        if (bVar == null) {
            return false;
        }
        return bVar.isSupported();
    }

    public static boolean c(org.joda.time.e eVar) {
        if (eVar == null) {
            return false;
        }
        return eVar.isSupported();
    }

    public final void a(org.joda.time.a aVar) {
        org.joda.time.e millis = aVar.millis();
        if (c(millis)) {
            this.f17057a = millis;
        }
        org.joda.time.e seconds = aVar.seconds();
        if (c(seconds)) {
            this.f17058b = seconds;
        }
        org.joda.time.e minutes = aVar.minutes();
        if (c(minutes)) {
            this.f17059c = minutes;
        }
        org.joda.time.e hours = aVar.hours();
        if (c(hours)) {
            this.f17060d = hours;
        }
        org.joda.time.e halfdays = aVar.halfdays();
        if (c(halfdays)) {
            this.e = halfdays;
        }
        org.joda.time.e days = aVar.days();
        if (c(days)) {
            this.f17061f = days;
        }
        org.joda.time.e weeks = aVar.weeks();
        if (c(weeks)) {
            this.f17062g = weeks;
        }
        org.joda.time.e weekyears = aVar.weekyears();
        if (c(weekyears)) {
            this.f17063h = weekyears;
        }
        org.joda.time.e months = aVar.months();
        if (c(months)) {
            this.f17064i = months;
        }
        org.joda.time.e years = aVar.years();
        if (c(years)) {
            this.f17065j = years;
        }
        org.joda.time.e centuries = aVar.centuries();
        if (c(centuries)) {
            this.f17066k = centuries;
        }
        org.joda.time.e eras = aVar.eras();
        if (c(eras)) {
            this.f17067l = eras;
        }
        org.joda.time.b millisOfSecond = aVar.millisOfSecond();
        if (b(millisOfSecond)) {
            this.f17068m = millisOfSecond;
        }
        org.joda.time.b millisOfDay = aVar.millisOfDay();
        if (b(millisOfDay)) {
            this.f17069n = millisOfDay;
        }
        org.joda.time.b secondOfMinute = aVar.secondOfMinute();
        if (b(secondOfMinute)) {
            this.f17070o = secondOfMinute;
        }
        org.joda.time.b secondOfDay = aVar.secondOfDay();
        if (b(secondOfDay)) {
            this.f17071p = secondOfDay;
        }
        org.joda.time.b minuteOfHour = aVar.minuteOfHour();
        if (b(minuteOfHour)) {
            this.f17072q = minuteOfHour;
        }
        org.joda.time.b minuteOfDay = aVar.minuteOfDay();
        if (b(minuteOfDay)) {
            this.r = minuteOfDay;
        }
        org.joda.time.b hourOfDay = aVar.hourOfDay();
        if (b(hourOfDay)) {
            this.f17073s = hourOfDay;
        }
        org.joda.time.b clockhourOfDay = aVar.clockhourOfDay();
        if (b(clockhourOfDay)) {
            this.f17074t = clockhourOfDay;
        }
        org.joda.time.b hourOfHalfday = aVar.hourOfHalfday();
        if (b(hourOfHalfday)) {
            this.f17075u = hourOfHalfday;
        }
        org.joda.time.b clockhourOfHalfday = aVar.clockhourOfHalfday();
        if (b(clockhourOfHalfday)) {
            this.f17076v = clockhourOfHalfday;
        }
        org.joda.time.b halfdayOfDay = aVar.halfdayOfDay();
        if (b(halfdayOfDay)) {
            this.f17077w = halfdayOfDay;
        }
        org.joda.time.b dayOfWeek = aVar.dayOfWeek();
        if (b(dayOfWeek)) {
            this.f17078x = dayOfWeek;
        }
        org.joda.time.b dayOfMonth = aVar.dayOfMonth();
        if (b(dayOfMonth)) {
            this.f17079y = dayOfMonth;
        }
        org.joda.time.b dayOfYear = aVar.dayOfYear();
        if (b(dayOfYear)) {
            this.f17080z = dayOfYear;
        }
        org.joda.time.b weekOfWeekyear = aVar.weekOfWeekyear();
        if (b(weekOfWeekyear)) {
            this.A = weekOfWeekyear;
        }
        org.joda.time.b weekyear = aVar.weekyear();
        if (b(weekyear)) {
            this.B = weekyear;
        }
        org.joda.time.b weekyearOfCentury = aVar.weekyearOfCentury();
        if (b(weekyearOfCentury)) {
            this.C = weekyearOfCentury;
        }
        org.joda.time.b monthOfYear = aVar.monthOfYear();
        if (b(monthOfYear)) {
            this.D = monthOfYear;
        }
        org.joda.time.b year = aVar.year();
        if (b(year)) {
            this.E = year;
        }
        org.joda.time.b yearOfEra = aVar.yearOfEra();
        if (b(yearOfEra)) {
            this.F = yearOfEra;
        }
        org.joda.time.b yearOfCentury = aVar.yearOfCentury();
        if (b(yearOfCentury)) {
            this.G = yearOfCentury;
        }
        org.joda.time.b centuryOfEra = aVar.centuryOfEra();
        if (b(centuryOfEra)) {
            this.H = centuryOfEra;
        }
        org.joda.time.b era = aVar.era();
        if (b(era)) {
            this.I = era;
        }
    }
}
