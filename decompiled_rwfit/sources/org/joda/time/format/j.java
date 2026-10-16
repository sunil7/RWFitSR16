package org.joda.time.format;

import java.util.Locale;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public final class j implements z, x {

    /* renamed from: a, reason: collision with root package name */
    public final String f17194a;

    public j(String str) {
        this.f17194a = str;
    }

    @Override // org.joda.time.format.x
    public final int estimateParsedLength() {
        return this.f17194a.length();
    }

    @Override // org.joda.time.format.z
    public final int estimatePrintedLength() {
        return this.f17194a.length();
    }

    @Override // org.joda.time.format.x
    public final int parseInto(s sVar, CharSequence charSequence, int i3) {
        String str = this.f17194a;
        return p.p(i3, (String) charSequence, str) ? str.length() + i3 : ~i3;
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, long j4, org.joda.time.a aVar, int i3, DateTimeZone dateTimeZone, Locale locale) {
        appendable.append(this.f17194a);
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, org.joda.time.j jVar, Locale locale) {
        ((StringBuilder) appendable).append((CharSequence) this.f17194a);
    }
}
