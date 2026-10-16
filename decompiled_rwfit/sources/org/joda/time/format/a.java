package org.joda.time.format;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes2.dex */
public abstract class a {

    /* renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap f17148a = new ConcurrentHashMap();

    static {
        new AtomicReferenceArray(25);
    }

    /* JADX WARN: Code restructure failed: missing block: B:104:0x018c, code lost:
    
        if (r14 <= 2) goto L91;
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x012e, code lost:
    
        if (r11 <= 2) goto L76;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static org.joda.time.format.b a(java.lang.String r16) {
        /*
            Method dump skipped, instructions count: 800
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.a.a(java.lang.String):org.joda.time.format.b");
    }

    public static String b(String str, int[] iArr) {
        StringBuilder sb2 = new StringBuilder();
        int i3 = iArr[0];
        int length = str.length();
        char charAt = str.charAt(i3);
        if ((charAt >= 'A' && charAt <= 'Z') || (charAt >= 'a' && charAt <= 'z')) {
            sb2.append(charAt);
            while (true) {
                int i10 = i3 + 1;
                if (i10 >= length || str.charAt(i10) != charAt) {
                    break;
                }
                sb2.append(charAt);
                i3 = i10;
            }
        } else {
            sb2.append('\'');
            boolean z5 = false;
            while (i3 < length) {
                char charAt2 = str.charAt(i3);
                if (charAt2 != '\'') {
                    if (!z5 && ((charAt2 >= 'A' && charAt2 <= 'Z') || (charAt2 >= 'a' && charAt2 <= 'z'))) {
                        i3--;
                        break;
                    }
                    sb2.append(charAt2);
                } else {
                    int i11 = i3 + 1;
                    if (i11 >= length || str.charAt(i11) != '\'') {
                        z5 = !z5;
                    } else {
                        sb2.append(charAt2);
                        i3 = i11;
                    }
                }
                i3++;
            }
        }
        iArr[0] = i3;
        return sb2.toString();
    }
}
