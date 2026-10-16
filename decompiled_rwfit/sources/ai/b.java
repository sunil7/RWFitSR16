package ai;

import org.joda.time.Duration;
import org.joda.time.Period;

/* loaded from: classes2.dex */
public abstract class b implements org.joda.time.g {
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof org.joda.time.g) && getMillis() == ((org.joda.time.g) obj).getMillis();
    }

    public int hashCode() {
        long millis = getMillis();
        return (int) (millis ^ (millis >>> 32));
    }

    public boolean isEqual(org.joda.time.g gVar) {
        if (gVar == null) {
            gVar = Duration.ZERO;
        }
        return compareTo(gVar) == 0;
    }

    public boolean isLongerThan(org.joda.time.g gVar) {
        if (gVar == null) {
            gVar = Duration.ZERO;
        }
        return compareTo(gVar) > 0;
    }

    public boolean isShorterThan(org.joda.time.g gVar) {
        if (gVar == null) {
            gVar = Duration.ZERO;
        }
        return compareTo(gVar) < 0;
    }

    public Duration toDuration() {
        return new Duration(getMillis());
    }

    public Period toPeriod() {
        return new Period(getMillis());
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x002a, code lost:
    
        r2.insert(3, "0");
     */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0030  */
    /* JADX WARN: Removed duplicated region for block: B:14:0x0036  */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x0032  */
    @org.joda.convert.ToString
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.String toString() {
        /*
            r9 = this;
            long r0 = r9.getMillis()
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            java.lang.String r3 = "PT"
            r2.append(r3)
            r3 = 0
            int r3 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r3 >= 0) goto L16
            r3 = 1
            goto L17
        L16:
            r3 = 0
        L17:
            int r4 = org.joda.time.format.u.f17227b
            int r4 = (int) r0
            long r5 = (long) r4
            int r5 = (r5 > r0 ? 1 : (r5 == r0 ? 0 : -1))
            if (r5 != 0) goto L23
            org.joda.time.format.u.c(r2, r4)     // Catch: java.io.IOException -> L2a
            goto L2a
        L23:
            java.lang.String r4 = java.lang.Long.toString(r0)     // Catch: java.io.IOException -> L2a
            r2.append(r4)     // Catch: java.io.IOException -> L2a
        L2a:
            int r4 = r2.length()
            if (r3 == 0) goto L32
            r5 = 7
            goto L33
        L32:
            r5 = 6
        L33:
            r6 = 3
            if (r4 >= r5) goto L40
            if (r3 == 0) goto L39
            goto L3a
        L39:
            r6 = 2
        L3a:
            java.lang.String r4 = "0"
            r2.insert(r6, r4)
            goto L2a
        L40:
            r3 = 1000(0x3e8, double:4.94E-321)
            long r7 = r0 / r3
            long r7 = r7 * r3
            int r0 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r0 != 0) goto L52
            int r0 = r2.length()
            int r0 = r0 - r6
            r2.setLength(r0)
            goto L5c
        L52:
            int r0 = r2.length()
            int r0 = r0 - r6
            java.lang.String r1 = "."
            r2.insert(r0, r1)
        L5c:
            r0 = 83
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: ai.b.toString():java.lang.String");
    }

    @Override // java.lang.Comparable
    public int compareTo(org.joda.time.g gVar) {
        long millis = getMillis();
        long millis2 = gVar.getMillis();
        if (millis < millis2) {
            return -1;
        }
        return millis > millis2 ? 1 : 0;
    }
}
