package org.joda.time.format;

import java.util.Locale;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public final class c implements z, x {

    /* renamed from: a, reason: collision with root package name */
    public final char f17159a;

    public c(char c9) {
        this.f17159a = c9;
    }

    @Override // org.joda.time.format.x
    public final int estimateParsedLength() {
        return 1;
    }

    @Override // org.joda.time.format.z
    public final int estimatePrintedLength() {
        return 1;
    }

    @Override // org.joda.time.format.x
    public final int parseInto(s sVar, CharSequence charSequence, int i3) {
        char upperCase;
        char upperCase2;
        String str = (String) charSequence;
        if (i3 >= str.length()) {
            return ~i3;
        }
        char charAt = str.charAt(i3);
        char c9 = this.f17159a;
        return (charAt == c9 || (upperCase = Character.toUpperCase(charAt)) == (upperCase2 = Character.toUpperCase(c9)) || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) ? i3 + 1 : ~i3;
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, long j4, org.joda.time.a aVar, int i3, DateTimeZone dateTimeZone, Locale locale) {
        appendable.append(this.f17159a);
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, org.joda.time.j jVar, Locale locale) {
        ((StringBuilder) appendable).append(this.f17159a);
    }
}
