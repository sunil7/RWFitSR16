package org.joda.time.format;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public final class o extends h {
    @Override // org.joda.time.format.z
    public final int estimatePrintedLength() {
        return this.f17186b;
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, long j4, org.joda.time.a aVar, int i3, DateTimeZone dateTimeZone, Locale locale) {
        try {
            u.c(appendable, this.f17185a.getField(aVar).get(j4));
        } catch (RuntimeException unused) {
            appendable.append((char) 65533);
        }
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, org.joda.time.j jVar, Locale locale) {
        DateTimeFieldType dateTimeFieldType = this.f17185a;
        if (jVar.isSupported(dateTimeFieldType)) {
            try {
                u.c(appendable, jVar.get(dateTimeFieldType));
                return;
            } catch (RuntimeException unused) {
                ((StringBuilder) appendable).append((char) 65533);
                return;
            }
        }
        ((StringBuilder) appendable).append((char) 65533);
    }
}
