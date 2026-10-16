package org.joda.time.format;

import java.util.Locale;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public final class m implements z, x {

    /* renamed from: a, reason: collision with root package name */
    public final String f17199a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17200b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f17201c;

    /* renamed from: d, reason: collision with root package name */
    public final int f17202d;
    public final int e;

    public m(String str, String str2, int i3, boolean z5) {
        this.f17199a = str;
        this.f17200b = str2;
        this.f17201c = z5;
        if (i3 < 2) {
            throw new IllegalArgumentException();
        }
        this.f17202d = 2;
        this.e = i3;
    }

    public static int a(int i3, int i10, String str) {
        int i11 = 0;
        for (int min = Math.min(str.length() - i3, i10); min > 0; min--) {
            char charAt = str.charAt(i3 + i11);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i11++;
        }
        return i11;
    }

    @Override // org.joda.time.format.x
    public final int estimateParsedLength() {
        return estimatePrintedLength();
    }

    @Override // org.joda.time.format.z
    public final int estimatePrintedLength() {
        int i3 = this.f17202d;
        int i10 = (i3 + 1) << 1;
        if (this.f17201c) {
            i10 += i3 - 1;
        }
        String str = this.f17199a;
        return (str == null || str.length() <= i10) ? i10 : str.length();
    }

    /* JADX WARN: Code restructure failed: missing block: B:88:0x0080, code lost:
    
        if (r9 <= '9') goto L43;
     */
    @Override // org.joda.time.format.x
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int parseInto(org.joda.time.format.s r13, java.lang.CharSequence r14, int r15) {
        /*
            Method dump skipped, instructions count: 300
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.m.parseInto(org.joda.time.format.s, java.lang.CharSequence, int):int");
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, org.joda.time.j jVar, Locale locale) {
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, long j4, org.joda.time.a aVar, int i3, DateTimeZone dateTimeZone, Locale locale) {
        String str;
        if (dateTimeZone == null) {
            return;
        }
        if (i3 == 0 && (str = this.f17199a) != null) {
            appendable.append(str);
            return;
        }
        if (i3 >= 0) {
            appendable.append('+');
        } else {
            appendable.append('-');
            i3 = -i3;
        }
        int i10 = i3 / 3600000;
        u.a(appendable, i10, 2);
        int i11 = this.e;
        if (i11 == 1) {
            return;
        }
        int i12 = i3 - (i10 * 3600000);
        int i13 = this.f17202d;
        if (i12 != 0 || i13 > 1) {
            int i14 = i12 / 60000;
            boolean z5 = this.f17201c;
            if (z5) {
                appendable.append(':');
            }
            u.a(appendable, i14, 2);
            if (i11 == 2) {
                return;
            }
            int i15 = i12 - (i14 * 60000);
            if (i15 != 0 || i13 > 2) {
                int i16 = i15 / 1000;
                if (z5) {
                    appendable.append(':');
                }
                u.a(appendable, i16, 2);
                if (i11 == 3) {
                    return;
                }
                int i17 = i15 - (i16 * 1000);
                if (i17 != 0 || i13 > 3) {
                    if (z5) {
                        appendable.append('.');
                    }
                    u.a(appendable, i17, 3);
                }
            }
        }
    }
}
