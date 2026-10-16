package org.joda.time.format;

import java.util.Locale;

/* loaded from: classes2.dex */
public final class q implements Comparable {

    /* renamed from: a, reason: collision with root package name */
    public org.joda.time.b f17209a;

    /* renamed from: b, reason: collision with root package name */
    public int f17210b;

    /* renamed from: c, reason: collision with root package name */
    public String f17211c;

    /* renamed from: d, reason: collision with root package name */
    public Locale f17212d;

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        org.joda.time.b bVar = ((q) obj).f17209a;
        int a3 = s.a(this.f17209a.getRangeDurationField(), bVar.getRangeDurationField());
        return a3 != 0 ? a3 : s.a(this.f17209a.getDurationField(), bVar.getDurationField());
    }
}
