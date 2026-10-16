package org.joda.time.format;

import java.util.Locale;
import okhttp3.internal.connection.RealConnection;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.field.MillisDurationField;

/* loaded from: classes2.dex */
public final class f implements z, x {

    /* renamed from: a, reason: collision with root package name */
    public final DateTimeFieldType f17173a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17174b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17175c;

    public f(DateTimeFieldType dateTimeFieldType, int i3, int i10) {
        this.f17173a = dateTimeFieldType;
        i10 = i10 > 18 ? 18 : i10;
        this.f17174b = i3;
        this.f17175c = i10;
    }

    public final void a(Appendable appendable, long j4, org.joda.time.a aVar) {
        long j10;
        org.joda.time.b field = this.f17173a.getField(aVar);
        int i3 = this.f17174b;
        try {
            long remainder = field.remainder(j4);
            if (remainder == 0) {
                while (true) {
                    i3--;
                    if (i3 < 0) {
                        return;
                    } else {
                        appendable.append('0');
                    }
                }
            } else {
                long unitMillis = field.getDurationField().getUnitMillis();
                int i10 = this.f17175c;
                while (true) {
                    switch (i10) {
                        case 1:
                            j10 = 10;
                            break;
                        case 2:
                            j10 = 100;
                            break;
                        case 3:
                            j10 = 1000;
                            break;
                        case 4:
                            j10 = 10000;
                            break;
                        case 5:
                            j10 = 100000;
                            break;
                        case 6:
                            j10 = 1000000;
                            break;
                        case 7:
                            j10 = 10000000;
                            break;
                        case 8:
                            j10 = 100000000;
                            break;
                        case 9:
                            j10 = 1000000000;
                            break;
                        case 10:
                            j10 = RealConnection.IDLE_CONNECTION_HEALTHY_NS;
                            break;
                        case 11:
                            j10 = 100000000000L;
                            break;
                        case 12:
                            j10 = 1000000000000L;
                            break;
                        case 13:
                            j10 = 10000000000000L;
                            break;
                        case 14:
                            j10 = 100000000000000L;
                            break;
                        case 15:
                            j10 = 1000000000000000L;
                            break;
                        case 16:
                            j10 = 10000000000000000L;
                            break;
                        case 17:
                            j10 = 100000000000000000L;
                            break;
                        case 18:
                            j10 = 1000000000000000000L;
                            break;
                        default:
                            j10 = 1;
                            break;
                    }
                    if ((unitMillis * j10) / j10 == unitMillis) {
                        long[] jArr = {(remainder * j10) / unitMillis, i10};
                        long j11 = jArr[0];
                        int i11 = (int) jArr[1];
                        String num = (2147483647L & j11) == j11 ? Integer.toString((int) j11) : Long.toString(j11);
                        int length = num.length();
                        while (length < i11) {
                            appendable.append('0');
                            i3--;
                            i11--;
                        }
                        if (i3 < i11) {
                            while (i3 < i11 && length > 1 && num.charAt(length - 1) == '0') {
                                i11--;
                                length--;
                            }
                            if (length < num.length()) {
                                for (int i12 = 0; i12 < length; i12++) {
                                    appendable.append(num.charAt(i12));
                                }
                                return;
                            }
                        }
                        appendable.append(num);
                        return;
                    }
                    i10--;
                }
            }
        } catch (RuntimeException unused) {
            p.n(appendable, i3);
        }
    }

    @Override // org.joda.time.format.x
    public final int estimateParsedLength() {
        return this.f17175c;
    }

    @Override // org.joda.time.format.z
    public final int estimatePrintedLength() {
        return this.f17175c;
    }

    @Override // org.joda.time.format.x
    public final int parseInto(s sVar, CharSequence charSequence, int i3) {
        org.joda.time.b field = this.f17173a.getField(sVar.f17217a);
        String str = (String) charSequence;
        int min = Math.min(this.f17175c, str.length() - i3);
        long unitMillis = field.getDurationField().getUnitMillis() * 10;
        long j4 = 0;
        int i10 = 0;
        while (i10 < min) {
            char charAt = str.charAt(i3 + i10);
            if (charAt < '0' || charAt > '9') {
                break;
            }
            i10++;
            unitMillis /= 10;
            j4 += (charAt - '0') * unitMillis;
        }
        long j10 = j4 / 10;
        if (i10 != 0 && j10 <= 2147483647L) {
            org.joda.time.field.g gVar = new org.joda.time.field.g(DateTimeFieldType.millisOfSecond(), MillisDurationField.INSTANCE, field.getDurationField());
            q c9 = sVar.c();
            c9.f17209a = gVar;
            c9.f17210b = (int) j10;
            c9.f17211c = null;
            c9.f17212d = null;
            return i3 + i10;
        }
        return ~i3;
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, long j4, org.joda.time.a aVar, int i3, DateTimeZone dateTimeZone, Locale locale) {
        a(appendable, j4, aVar);
    }

    @Override // org.joda.time.format.z
    public final void printTo(Appendable appendable, org.joda.time.j jVar, Locale locale) {
        a(appendable, jVar.getChronology().set(jVar, 0L), jVar.getChronology());
    }
}
