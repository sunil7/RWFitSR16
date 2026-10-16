package org.joda.time.chrono;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;

/* loaded from: classes2.dex */
public final class b extends org.joda.time.field.g {
    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsText(int i3, Locale locale) {
        return j.b(locale).f17102f[i3];
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumTextLength(Locale locale) {
        return j.b(locale).f17111o;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long set(long j4, String str, Locale locale) {
        String[] strArr = j.b(locale).f17102f;
        int length = strArr.length;
        do {
            length--;
            if (length < 0) {
                throw new IllegalFieldValueException(DateTimeFieldType.halfdayOfDay(), str);
            }
        } while (!strArr[length].equalsIgnoreCase(str));
        return set(j4, length);
    }
}
