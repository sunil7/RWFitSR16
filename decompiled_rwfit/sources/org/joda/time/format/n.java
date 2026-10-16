package org.joda.time.format;

import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public final class n implements z, x {

    /* renamed from: a, reason: collision with root package name */
    public final DateTimeFieldType f17203a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17204b;

    /* renamed from: c, reason: collision with root package name */
    public final boolean f17205c;

    public n(DateTimeFieldType dateTimeFieldType, int i3, boolean z5) {
        this.f17203a = dateTimeFieldType;
        this.f17204b = i3;
        this.f17205c = z5;
    }

    @Override // org.joda.time.format.x
    public final int estimateParsedLength() {
        return this.f17205c ? 4 : 2;
    }

    @Override // org.joda.time.format.z
    public final int estimatePrintedLength() {
        return 2;
    }

    @Override // org.joda.time.format.x
    public final int parseInto(s sVar, CharSequence charSequence, int i3) {
        int i10;
        int i11;
        int i12 = i3;
        String str = (String) charSequence;
        int length = str.length() - i12;
        org.joda.time.a aVar = sVar.f17217a;
        boolean z5 = this.f17205c;
        DateTimeFieldType dateTimeFieldType = this.f17203a;
        if (z5) {
            int i13 = 0;
            boolean z6 = false;
            boolean z8 = false;
            while (i13 < length) {
                char charAt = str.charAt(i12 + i13);
                if (i13 != 0 || (charAt != '-' && charAt != '+')) {
                    if (charAt < '0' || charAt > '9') {
                        break;
                    }
                    i13++;
                } else {
                    z8 = charAt == '-';
                    if (z8) {
                        i13++;
                    } else {
                        i12++;
                        length--;
                    }
                    z6 = true;
                }
            }
            if (i13 == 0) {
                return ~i12;
            }
            if (z6 || i13 != 2) {
                if (i13 >= 9) {
                    i10 = i13 + i12;
                    i11 = Integer.parseInt(str.subSequence(i12, i10).toString());
                } else {
                    int i14 = z8 ? i12 + 1 : i12;
                    int i15 = i14 + 1;
                    try {
                        int charAt2 = str.charAt(i14) - '0';
                        i10 = i13 + i12;
                        while (true) {
                            i11 = charAt2;
                            if (i15 >= i10) {
                                break;
                            }
                            charAt2 = (str.charAt(i15) + ((i11 << 3) + (i11 << 1))) - 48;
                            i15++;
                        }
                        if (z8) {
                            i11 = -i11;
                        }
                    } catch (StringIndexOutOfBoundsException unused) {
                        return ~i12;
                    }
                }
                q c9 = sVar.c();
                c9.f17209a = dateTimeFieldType.getField(aVar);
                c9.f17210b = i11;
                c9.f17211c = null;
                c9.f17212d = null;
                return i10;
            }
        } else if (Math.min(2, length) < 2) {
            return ~i12;
        }
        char charAt3 = str.charAt(i12);
        if (charAt3 < '0' || charAt3 > '9') {
            return ~i12;
        }
        int i16 = charAt3 - '0';
        char charAt4 = str.charAt(i12 + 1);
        if (charAt4 < '0' || charAt4 > '9') {
            return ~i12;
        }
        int i17 = (((i16 << 3) + (i16 << 1)) + charAt4) - 48;
        int i18 = this.f17204b;
        int i19 = i18 - 50;
        int i20 = i19 >= 0 ? i19 % 100 : ((i18 - 49) % 100) + 99;
        int i21 = ((i19 + (i17 < i20 ? 100 : 0)) - i20) + i17;
        q c10 = sVar.c();
        c10.f17209a = dateTimeFieldType.getField(aVar);
        c10.f17210b = i21;
        c10.f17211c = null;
        c10.f17212d = null;
        return i12 + 2;
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, long j4, org.joda.time.a aVar, int i3, DateTimeZone dateTimeZone, Locale locale) {
        int i10;
        try {
            int i11 = this.f17203a.getField(aVar).get(j4);
            if (i11 < 0) {
                i11 = -i11;
            }
            i10 = i11 % 100;
        } catch (RuntimeException unused) {
            i10 = -1;
        }
        if (i10 >= 0) {
            u.a(appendable, i10, 2);
        } else {
            appendable.append((char) 65533);
            appendable.append((char) 65533);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:5:0x0015  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0021  */
    @Override // org.joda.time.format.z
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void printTo(java.lang.Appendable r2, org.joda.time.j r3, java.util.Locale r4) {
        /*
            r1 = this;
            org.joda.time.DateTimeFieldType r4 = r1.f17203a
            boolean r0 = r3.isSupported(r4)
            if (r0 == 0) goto L12
            int r3 = r3.get(r4)     // Catch: java.lang.RuntimeException -> L12
            if (r3 >= 0) goto Lf
            int r3 = -r3
        Lf:
            int r3 = r3 % 100
            goto L13
        L12:
            r3 = -1
        L13:
            if (r3 >= 0) goto L21
            java.lang.StringBuilder r2 = (java.lang.StringBuilder) r2
            r3 = 65533(0xfffd, float:9.1831E-41)
            r2.append(r3)
            r2.append(r3)
            goto L25
        L21:
            r4 = 2
            org.joda.time.format.u.a(r2, r3, r4)
        L25:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.n.printTo(java.lang.Appendable, org.joda.time.j, java.util.Locale):void");
    }
}
