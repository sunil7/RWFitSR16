package org.joda.time.tz;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
final class DateTimeZoneBuilder$DSTZone extends DateTimeZone {
    private static final long serialVersionUID = 6941492635554961361L;
    final c iEndRecurrence;
    final int iStandardOffset;
    final c iStartRecurrence;

    public DateTimeZoneBuilder$DSTZone(String str, int i3, c cVar, c cVar2) {
        super(str);
        this.iStandardOffset = i3;
        this.iStartRecurrence = cVar;
        this.iEndRecurrence = cVar2;
    }

    public static DateTimeZoneBuilder$DSTZone readFrom(DataInput dataInput, String str) throws IOException {
        return new DateTimeZoneBuilder$DSTZone(str, (int) d.b(dataInput), c.c(dataInput), c.c(dataInput));
    }

    public final c e(long j4) {
        long j10;
        int i3 = this.iStandardOffset;
        c cVar = this.iStartRecurrence;
        c cVar2 = this.iEndRecurrence;
        try {
            j10 = cVar.a(i3, cVar2.f17274c, j4);
        } catch (ArithmeticException | IllegalArgumentException unused) {
            j10 = j4;
        }
        try {
            j4 = cVar2.a(i3, cVar.f17274c, j4);
        } catch (ArithmeticException | IllegalArgumentException unused2) {
        }
        return j10 > j4 ? cVar : cVar2;
    }

    @Override // org.joda.time.DateTimeZone
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateTimeZoneBuilder$DSTZone) {
            DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = (DateTimeZoneBuilder$DSTZone) obj;
            if (getID().equals(dateTimeZoneBuilder$DSTZone.getID()) && this.iStandardOffset == dateTimeZoneBuilder$DSTZone.iStandardOffset && this.iStartRecurrence.equals(dateTimeZoneBuilder$DSTZone.iStartRecurrence) && this.iEndRecurrence.equals(dateTimeZoneBuilder$DSTZone.iEndRecurrence)) {
                return true;
            }
        }
        return false;
    }

    @Override // org.joda.time.DateTimeZone
    public String getNameKey(long j4) {
        return e(j4).f17273b;
    }

    @Override // org.joda.time.DateTimeZone
    public int getOffset(long j4) {
        return this.iStandardOffset + e(j4).f17274c;
    }

    @Override // org.joda.time.DateTimeZone
    public int getStandardOffset(long j4) {
        return this.iStandardOffset;
    }

    @Override // org.joda.time.DateTimeZone
    public boolean isFixed() {
        return false;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0014, code lost:
    
        if (r5 < 0) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:20:? A[RETURN, SYNTHETIC] */
    @Override // org.joda.time.DateTimeZone
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long nextTransition(long r9) {
        /*
            r8 = this;
            int r0 = r8.iStandardOffset
            org.joda.time.tz.c r1 = r8.iStartRecurrence
            org.joda.time.tz.c r2 = r8.iEndRecurrence
            r3 = 0
            int r5 = r2.f17274c     // Catch: java.lang.Throwable -> L16
            long r5 = r1.a(r0, r5, r9)     // Catch: java.lang.Throwable -> L16
            int r7 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r7 <= 0) goto L17
            int r7 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r7 >= 0) goto L17
        L16:
            r5 = r9
        L17:
            int r1 = r1.f17274c     // Catch: java.lang.Throwable -> L27
            long r0 = r2.a(r0, r1, r9)     // Catch: java.lang.Throwable -> L27
            int r2 = (r9 > r3 ? 1 : (r9 == r3 ? 0 : -1))
            if (r2 <= 0) goto L26
            int r2 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r2 >= 0) goto L26
            goto L27
        L26:
            r9 = r0
        L27:
            int r0 = (r5 > r9 ? 1 : (r5 == r9 ? 0 : -1))
            if (r0 <= 0) goto L2c
            r5 = r9
        L2c:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.DateTimeZoneBuilder$DSTZone.nextTransition(long):long");
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x0017, code lost:
    
        if (r7 > 0) goto L8;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x002f  */
    @Override // org.joda.time.DateTimeZone
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public long previousTransition(long r11) {
        /*
            r10 = this;
            r0 = 1
            long r11 = r11 + r0
            int r2 = r10.iStandardOffset
            org.joda.time.tz.c r3 = r10.iStartRecurrence
            org.joda.time.tz.c r4 = r10.iEndRecurrence
            r5 = 0
            int r7 = r4.f17274c     // Catch: java.lang.Throwable -> L19
            long r7 = r3.b(r2, r7, r11)     // Catch: java.lang.Throwable -> L19
            int r9 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r9 >= 0) goto L1a
            int r9 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r9 <= 0) goto L1a
        L19:
            r7 = r11
        L1a:
            int r3 = r3.f17274c     // Catch: java.lang.Throwable -> L2a
            long r2 = r4.b(r2, r3, r11)     // Catch: java.lang.Throwable -> L2a
            int r4 = (r11 > r5 ? 1 : (r11 == r5 ? 0 : -1))
            if (r4 >= 0) goto L29
            int r4 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r4 <= 0) goto L29
            goto L2a
        L29:
            r11 = r2
        L2a:
            int r2 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
            if (r2 <= 0) goto L2f
            goto L30
        L2f:
            r7 = r11
        L30:
            long r7 = r7 - r0
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.tz.DateTimeZoneBuilder$DSTZone.previousTransition(long):long");
    }

    public void writeTo(DataOutput dataOutput) throws IOException {
        d.c(dataOutput, this.iStandardOffset);
        this.iStartRecurrence.e(dataOutput);
        this.iEndRecurrence.e(dataOutput);
    }
}
