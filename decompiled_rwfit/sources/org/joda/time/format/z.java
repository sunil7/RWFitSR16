package org.joda.time.format;

import java.util.Locale;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public interface z {
    int estimatePrintedLength();

    void printTo(Appendable appendable, long j4, org.joda.time.a aVar, int i3, DateTimeZone dateTimeZone, Locale locale);

    void printTo(Appendable appendable, org.joda.time.j jVar, Locale locale);
}
