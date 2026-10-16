package com.google.zxing.oned.rss.expanded.decoders;

import dd.h;
import dd.k;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final sc.a f11252a;

    /* renamed from: b, reason: collision with root package name */
    public final a f11253b;

    /* renamed from: c, reason: collision with root package name */
    public final StringBuilder f11254c;

    public b(sc.a aVar) {
        a aVar2 = new a();
        aVar2.f11250a = 0;
        aVar2.f11251b = CurrentParsingState$State.NUMERIC;
        this.f11253b = aVar2;
        this.f11254c = new StringBuilder();
        this.f11252a = aVar;
    }

    public static int c(int i3, int i10, sc.a aVar) {
        int i11 = 0;
        for (int i12 = 0; i12 < i10; i12++) {
            if (aVar.d(i3 + i12)) {
                i11 |= 1 << ((i10 - i12) - 1);
            }
        }
        return i11;
    }

    public final String a(StringBuilder sb2, int i3) {
        String str = null;
        while (true) {
            h b3 = b(i3, str);
            String a3 = k.a(b3.f12331b);
            if (a3 != null) {
                sb2.append(a3);
            }
            String valueOf = b3.f12333d ? String.valueOf(b3.f12332c) : null;
            int i10 = b3.f2265a;
            if (i3 == i10) {
                return sb2.toString();
            }
            i3 = i10;
            str = valueOf;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:149:0x020e, code lost:
    
        if (r5 <= r7.f18220b) goto L133;
     */
    /* JADX WARN: Code restructure failed: missing block: B:150:0x0211, code lost:
    
        if (r3 >= r5) goto L230;
     */
    /* JADX WARN: Code restructure failed: missing block: B:152:0x0217, code lost:
    
        if (r7.d(r3) == false) goto L143;
     */
    /* JADX WARN: Code restructure failed: missing block: B:153:0x0235, code lost:
    
        r3 = r3 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:156:0x0238, code lost:
    
        r1.f11250a += 3;
        r1.f11251b = com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState$State.NUMERIC;
     */
    /* JADX WARN: Code restructure failed: missing block: B:157:0x0242, code lost:
    
        r3 = new com.example.test.utils.s0(1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:159:0x021f, code lost:
    
        if (d(r1.f11250a) == false) goto L145;
     */
    /* JADX WARN: Code restructure failed: missing block: B:160:0x0221, code lost:
    
        r3 = r1.f11250a;
        r5 = r3 + 5;
        r6 = r7.f18220b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:161:0x0227, code lost:
    
        if (r5 >= r6) goto L141;
     */
    /* JADX WARN: Code restructure failed: missing block: B:162:0x0229, code lost:
    
        r1.f11250a = r3 + 5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:163:0x0230, code lost:
    
        r1.f11251b = com.google.zxing.oned.rss.expanded.decoders.CurrentParsingState$State.ALPHA;
     */
    /* JADX WARN: Code restructure failed: missing block: B:164:0x022e, code lost:
    
        r1.f11250a = r6;
     */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0273  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02ee A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final dd.h b(int r17, java.lang.String r18) {
        /*
            Method dump skipped, instructions count: 902
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.oned.rss.expanded.decoders.b.b(int, java.lang.String):dd.h");
    }

    public final boolean d(int i3) {
        int i10;
        int i11 = i3 + 1;
        sc.a aVar = this.f11252a;
        if (i11 > aVar.f18220b) {
            return false;
        }
        for (int i12 = 0; i12 < 5 && (i10 = i12 + i3) < aVar.f18220b; i12++) {
            if (i12 == 2) {
                if (!aVar.d(i3 + 2)) {
                    return false;
                }
            } else if (aVar.d(i10)) {
                return false;
            }
        }
        return true;
    }
}
