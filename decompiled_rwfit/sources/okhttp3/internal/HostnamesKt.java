package okhttp3.internal;

import java.net.IDN;
import java.net.InetAddress;
import java.util.Locale;
import kotlin.jvm.internal.e;
import kotlin.text.m;
import wh.j;

/* loaded from: classes2.dex */
public final class HostnamesKt {
    private static final boolean containsInvalidHostnameAsciiCodes(String str) {
        int length = str.length();
        for (int i3 = 0; i3 < length; i3++) {
            char charAt = str.charAt(i3);
            if (e.h(charAt, 31) <= 0 || e.h(charAt, 127) >= 0 || m.i(" #%/:?@[\\]", charAt, 0, 6) != -1) {
                return true;
            }
        }
        return false;
    }

    private static final boolean decodeIpv4Suffix(String str, int i3, int i10, byte[] bArr, int i11) {
        int i12 = i11;
        while (i3 < i10) {
            if (i12 == bArr.length) {
                return false;
            }
            if (i12 != i11) {
                if (str.charAt(i3) != '.') {
                    return false;
                }
                i3++;
            }
            int i13 = i3;
            int i14 = 0;
            while (i13 < i10) {
                char charAt = str.charAt(i13);
                if (e.h(charAt, 48) < 0 || e.h(charAt, 57) > 0) {
                    break;
                }
                if ((i14 == 0 && i3 != i13) || (i14 = ((i14 * 10) + charAt) - 48) > 255) {
                    return false;
                }
                i13++;
            }
            if (i13 - i3 == 0) {
                return false;
            }
            bArr[i12] = (byte) i14;
            i12++;
            i3 = i13;
        }
        return i12 == i11 + 4;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x004d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private static final java.net.InetAddress decodeIpv6(java.lang.String r10, int r11, int r12) {
        /*
            r0 = 16
            byte[] r1 = new byte[r0]
            r2 = 0
            r3 = -1
            r4 = r2
            r5 = r3
            r6 = r5
        L9:
            if (r11 >= r12) goto L77
            if (r4 != r0) goto Lf
            goto L7b
        Lf:
            int r7 = r11 + 2
            if (r7 > r12) goto L27
            java.lang.String r8 = "::"
            boolean r8 = kotlin.text.m.w(r10, r8, r11, r2)
            if (r8 == 0) goto L27
            if (r5 == r3) goto L1f
            goto L7b
        L1f:
            int r4 = r4 + 2
            r5 = r4
            if (r7 != r12) goto L25
            goto L77
        L25:
            r6 = r7
            goto L49
        L27:
            if (r4 == 0) goto L33
            java.lang.String r7 = ":"
            boolean r7 = kotlin.text.m.w(r10, r7, r11, r2)
            if (r7 == 0) goto L35
            int r11 = r11 + 1
        L33:
            r6 = r11
            goto L49
        L35:
            java.lang.String r7 = "."
            boolean r11 = kotlin.text.m.w(r10, r7, r11, r2)
            if (r11 == 0) goto L7b
            int r11 = r4 + (-2)
            boolean r10 = decodeIpv4Suffix(r10, r6, r12, r1, r11)
            if (r10 != 0) goto L46
            goto L7b
        L46:
            int r4 = r4 + 2
            goto L77
        L49:
            r7 = r2
            r11 = r6
        L4b:
            if (r11 >= r12) goto L5e
            char r8 = r10.charAt(r11)
            int r8 = okhttp3.internal.Util.parseHexDigit(r8)
            if (r8 != r3) goto L58
            goto L5e
        L58:
            int r7 = r7 << 4
            int r7 = r7 + r8
            int r11 = r11 + 1
            goto L4b
        L5e:
            int r8 = r11 - r6
            if (r8 == 0) goto L7b
            r9 = 4
            if (r8 <= r9) goto L66
            goto L7b
        L66:
            int r8 = r4 + 1
            int r9 = r7 >>> 8
            r9 = r9 & 255(0xff, float:3.57E-43)
            byte r9 = (byte) r9
            r1[r4] = r9
            int r4 = r4 + 2
            r7 = r7 & 255(0xff, float:3.57E-43)
            byte r7 = (byte) r7
            r1[r8] = r7
            goto L9
        L77:
            if (r4 == r0) goto L8a
            if (r5 != r3) goto L7d
        L7b:
            r10 = 0
            return r10
        L7d:
            int r10 = r4 - r5
            int r11 = 16 - r10
            java.lang.System.arraycopy(r1, r5, r1, r11, r10)
            int r0 = r0 - r4
            int r0 = r0 + r5
            byte r10 = (byte) r2
            java.util.Arrays.fill(r1, r5, r0, r10)
        L8a:
            java.net.InetAddress r10 = java.net.InetAddress.getByAddress(r1)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.HostnamesKt.decodeIpv6(java.lang.String, int, int):java.net.InetAddress");
    }

    private static final String inet6AddressToAscii(byte[] bArr) {
        int i3 = -1;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        while (i11 < bArr.length) {
            int i13 = i11;
            while (i13 < 16 && bArr[i13] == 0 && bArr[i13 + 1] == 0) {
                i13 += 2;
            }
            int i14 = i13 - i11;
            if (i14 > i12 && i14 >= 4) {
                i3 = i11;
                i12 = i14;
            }
            i11 = i13 + 2;
        }
        j jVar = new j();
        while (i10 < bArr.length) {
            if (i10 == i3) {
                jVar.Z(58);
                i10 += i12;
                if (i10 == 16) {
                    jVar.Z(58);
                }
            } else {
                if (i10 > 0) {
                    jVar.Z(58);
                }
                jVar.b0((Util.and(bArr[i10], 255) << 8) | Util.and(bArr[i10 + 1], 255));
                i10 += 2;
            }
        }
        return jVar.A();
    }

    public static final String toCanonicalHost(String toCanonicalHost) {
        e.f(toCanonicalHost, "$this$toCanonicalHost");
        if (m.c(toCanonicalHost, ":", false)) {
            InetAddress decodeIpv6 = (m.x(toCanonicalHost, "[", false) && m.e(toCanonicalHost, "]")) ? decodeIpv6(toCanonicalHost, 1, toCanonicalHost.length() - 1) : decodeIpv6(toCanonicalHost, 0, toCanonicalHost.length());
            if (decodeIpv6 == null) {
                return null;
            }
            byte[] address = decodeIpv6.getAddress();
            if (address.length == 16) {
                return inet6AddressToAscii(address);
            }
            if (address.length == 4) {
                return decodeIpv6.getHostAddress();
            }
            throw new AssertionError("Invalid IPv6 address: '" + toCanonicalHost + '\'');
        }
        try {
            String ascii = IDN.toASCII(toCanonicalHost);
            e.e(ascii, "IDN.toASCII(host)");
            Locale locale = Locale.US;
            e.e(locale, "Locale.US");
            String lowerCase = ascii.toLowerCase(locale);
            e.e(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
            if (lowerCase.length() == 0) {
                return null;
            }
            if (containsInvalidHostnameAsciiCodes(lowerCase)) {
                return null;
            }
            return lowerCase;
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
