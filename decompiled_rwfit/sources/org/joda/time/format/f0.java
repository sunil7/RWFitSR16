package org.joda.time.format;

import org.joda.time.MutablePeriod;

/* loaded from: classes2.dex */
public final class f0 implements k0, j0 {

    /* renamed from: b, reason: collision with root package name */
    public static final f0 f17176b = new f0("");

    /* renamed from: a, reason: collision with root package name */
    public final String f17177a;

    public f0(String str) {
        this.f17177a = str;
    }

    @Override // org.joda.time.format.k0
    public final int a(ai.f fVar, int i3) {
        return 0;
    }

    @Override // org.joda.time.format.k0
    public final int b(ai.f fVar) {
        return this.f17177a.length();
    }

    @Override // org.joda.time.format.j0
    public final int c(MutablePeriod mutablePeriod, String str, int i3) {
        String str2 = this.f17177a;
        return str.regionMatches(true, i3, str2, 0, str2.length()) ? str2.length() + i3 : ~i3;
    }

    @Override // org.joda.time.format.k0
    public final void d(StringBuffer stringBuffer, ai.f fVar) {
        stringBuffer.append(this.f17177a);
    }
}
