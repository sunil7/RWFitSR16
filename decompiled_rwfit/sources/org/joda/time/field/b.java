package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;

/* loaded from: classes2.dex */
public abstract class b extends org.joda.time.b {

    /* renamed from: a, reason: collision with root package name */
    public final DateTimeFieldType f17130a;

    public b(DateTimeFieldType dateTimeFieldType) {
        if (dateTimeFieldType == null) {
            throw new IllegalArgumentException("The type must not be null");
        }
        this.f17130a = dateTimeFieldType;
    }

    @Override // org.joda.time.b
    public long add(long j4, int i3) {
        return getDurationField().add(j4, i3);
    }

    @Override // org.joda.time.b
    public long addWrapField(long j4, int i3) {
        return set(j4, nf.b(get(j4), i3, getMinimumValue(j4), getMaximumValue(j4)));
    }

    /* JADX WARN: Code restructure failed: missing block: B:27:0x005c, code lost:
    
        if (r12 >= 0) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005e, code lost:
    
        r2 = getMinimumValue(r9, r11);
        r3 = r11[r10];
        r4 = r3 + r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006a, code lost:
    
        if (r4 < r2) goto L23;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x0070, code lost:
    
        if (r0 != null) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0072, code lost:
    
        if (r10 != 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x007f, code lost:
    
        r0 = r9.getField(r10 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0095, code lost:
    
        if (getRangeDurationField().getType() != r0.getDurationField().getType()) goto L48;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x009e, code lost:
    
        r12 = r12 - ((r2 - 1) - r11[r10]);
        r11 = r0.addWrapPartial(r9, r10 - 1, r11, -1);
        r11[r10] = getMaximumValue(r9, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:40:0x009d, code lost:
    
        throw new java.lang.IllegalArgumentException("Fields invalid for add");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0074, code lost:
    
        r12 = r12 - ((r2 - 1) - r3);
        r11[r10] = getMaximumValue(r9, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x006c, code lost:
    
        r11[r10] = (int) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:47:0x00b2, code lost:
    
        set(r9, r10, r11, r11[r10]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00b7, code lost:
    
        return r11;
     */
    @Override // org.joda.time.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int[] addWrapPartial(org.joda.time.j r9, int r10, int[] r11, int r12) {
        /*
            r8 = this;
            if (r12 != 0) goto L3
            return r11
        L3:
            r0 = 0
        L4:
            java.lang.String r1 = "Fields invalid for add"
            if (r12 <= 0) goto L5c
            int r2 = r8.getMaximumValue(r9, r11)
            r3 = r11[r10]
            int r4 = r3 + r12
            long r4 = (long) r4
            long r6 = (long) r2
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 > 0) goto L1a
            int r2 = (int) r4
            r11[r10] = r2
            goto L5c
        L1a:
            if (r0 != 0) goto L48
            if (r10 != 0) goto L29
            int r2 = r2 + 1
            int r2 = r2 - r3
            int r12 = r12 - r2
            int r1 = r8.getMinimumValue(r9, r11)
            r11[r10] = r1
            goto L4
        L29:
            int r0 = r10 + (-1)
            org.joda.time.b r0 = r9.getField(r0)
            org.joda.time.e r3 = r8.getRangeDurationField()
            org.joda.time.DurationFieldType r3 = r3.getType()
            org.joda.time.e r4 = r0.getDurationField()
            org.joda.time.DurationFieldType r4 = r4.getType()
            if (r3 != r4) goto L42
            goto L48
        L42:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r1)
            throw r9
        L48:
            int r2 = r2 + 1
            r1 = r11[r10]
            int r2 = r2 - r1
            int r12 = r12 - r2
            int r1 = r10 + (-1)
            r2 = 1
            int[] r11 = r0.addWrapPartial(r9, r1, r11, r2)
            int r1 = r8.getMinimumValue(r9, r11)
            r11[r10] = r1
            goto L4
        L5c:
            if (r12 >= 0) goto Lb2
            int r2 = r8.getMinimumValue(r9, r11)
            r3 = r11[r10]
            int r4 = r3 + r12
            long r4 = (long) r4
            long r6 = (long) r2
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 < 0) goto L70
            int r12 = (int) r4
            r11[r10] = r12
            goto Lb2
        L70:
            if (r0 != 0) goto L9e
            if (r10 != 0) goto L7f
            int r2 = r2 + (-1)
            int r2 = r2 - r3
            int r12 = r12 - r2
            int r2 = r8.getMaximumValue(r9, r11)
            r11[r10] = r2
            goto L5c
        L7f:
            int r0 = r10 + (-1)
            org.joda.time.b r0 = r9.getField(r0)
            org.joda.time.e r3 = r8.getRangeDurationField()
            org.joda.time.DurationFieldType r3 = r3.getType()
            org.joda.time.e r4 = r0.getDurationField()
            org.joda.time.DurationFieldType r4 = r4.getType()
            if (r3 != r4) goto L98
            goto L9e
        L98:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r1)
            throw r9
        L9e:
            int r2 = r2 + (-1)
            r3 = r11[r10]
            int r2 = r2 - r3
            int r12 = r12 - r2
            int r2 = r10 + (-1)
            r3 = -1
            int[] r11 = r0.addWrapPartial(r9, r2, r11, r3)
            int r2 = r8.getMaximumValue(r9, r11)
            r11[r10] = r2
            goto L5c
        Lb2:
            r12 = r11[r10]
            r8.set(r9, r10, r11, r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.field.b.addWrapPartial(org.joda.time.j, int, int[], int):int[]");
    }

    public int b(String str, Locale locale) {
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            throw new IllegalFieldValueException(this.f17130a, str);
        }
    }

    @Override // org.joda.time.b
    public String getAsShortText(long j4, Locale locale) {
        return getAsShortText(get(j4), locale);
    }

    @Override // org.joda.time.b
    public String getAsText(long j4, Locale locale) {
        return getAsText(get(j4), locale);
    }

    @Override // org.joda.time.b
    public int getDifference(long j4, long j10) {
        return getDurationField().getDifference(j4, j10);
    }

    @Override // org.joda.time.b
    public long getDifferenceAsLong(long j4, long j10) {
        return getDurationField().getDifferenceAsLong(j4, j10);
    }

    @Override // org.joda.time.b
    public int getLeapAmount(long j4) {
        return 0;
    }

    @Override // org.joda.time.b
    public org.joda.time.e getLeapDurationField() {
        return null;
    }

    @Override // org.joda.time.b
    public int getMaximumShortTextLength(Locale locale) {
        return getMaximumTextLength(locale);
    }

    @Override // org.joda.time.b
    public int getMaximumTextLength(Locale locale) {
        int maximumValue = getMaximumValue();
        if (maximumValue >= 0) {
            if (maximumValue < 10) {
                return 1;
            }
            if (maximumValue < 100) {
                return 2;
            }
            if (maximumValue < 1000) {
                return 3;
            }
        }
        return Integer.toString(maximumValue).length();
    }

    @Override // org.joda.time.b
    public int getMaximumValue(long j4) {
        return getMaximumValue();
    }

    @Override // org.joda.time.b
    public int getMinimumValue(long j4) {
        return getMinimumValue();
    }

    @Override // org.joda.time.b
    public final String getName() {
        return this.f17130a.getName();
    }

    @Override // org.joda.time.b
    public final DateTimeFieldType getType() {
        return this.f17130a;
    }

    @Override // org.joda.time.b
    public boolean isLeap(long j4) {
        return false;
    }

    @Override // org.joda.time.b
    public final boolean isSupported() {
        return true;
    }

    @Override // org.joda.time.b
    public long remainder(long j4) {
        return j4 - roundFloor(j4);
    }

    @Override // org.joda.time.b
    public long roundCeiling(long j4) {
        long roundFloor = roundFloor(j4);
        return roundFloor != j4 ? add(roundFloor, 1) : j4;
    }

    @Override // org.joda.time.b
    public long roundHalfCeiling(long j4) {
        long roundFloor = roundFloor(j4);
        long roundCeiling = roundCeiling(j4);
        return roundCeiling - j4 <= j4 - roundFloor ? roundCeiling : roundFloor;
    }

    @Override // org.joda.time.b
    public long roundHalfEven(long j4) {
        long roundFloor = roundFloor(j4);
        long roundCeiling = roundCeiling(j4);
        long j10 = j4 - roundFloor;
        long j11 = roundCeiling - j4;
        return (j10 >= j11 && (j11 < j10 || (get(roundCeiling) & 1) == 0)) ? roundCeiling : roundFloor;
    }

    @Override // org.joda.time.b
    public long roundHalfFloor(long j4) {
        long roundFloor = roundFloor(j4);
        long roundCeiling = roundCeiling(j4);
        return j4 - roundFloor <= roundCeiling - j4 ? roundFloor : roundCeiling;
    }

    @Override // org.joda.time.b
    public final int[] set(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        nf.k(this, i10, getMinimumValue(jVar, iArr), getMaximumValue(jVar, iArr));
        iArr[i3] = i10;
        while (true) {
            i3++;
            if (i3 >= jVar.size()) {
                return iArr;
            }
            org.joda.time.b field = jVar.getField(i3);
            if (iArr[i3] > field.getMaximumValue(jVar, iArr)) {
                iArr[i3] = field.getMaximumValue(jVar, iArr);
            }
            if (iArr[i3] < field.getMinimumValue(jVar, iArr)) {
                iArr[i3] = field.getMinimumValue(jVar, iArr);
            }
        }
    }

    public final String toString() {
        return "DateTimeField[" + this.f17130a.getName() + ']';
    }

    @Override // org.joda.time.b
    public long add(long j4, long j10) {
        return getDurationField().add(j4, j10);
    }

    @Override // org.joda.time.b
    public final String getAsShortText(long j4) {
        return getAsShortText(j4, (Locale) null);
    }

    @Override // org.joda.time.b
    public final String getAsText(long j4) {
        return getAsText(j4, (Locale) null);
    }

    @Override // org.joda.time.b
    public int getMaximumValue(org.joda.time.j jVar) {
        return getMaximumValue();
    }

    @Override // org.joda.time.b
    public int getMinimumValue(org.joda.time.j jVar) {
        return getMinimumValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:25:0x0058, code lost:
    
        if (r12 >= 0) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x005a, code lost:
    
        r3 = getMinimumValue(r9, r11);
        r4 = r11[r10] + r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0065, code lost:
    
        if (r4 < r3) goto L24;
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x006b, code lost:
    
        if (r0 != null) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x006d, code lost:
    
        if (r10 == 0) goto L45;
     */
    /* JADX WARN: Code restructure failed: missing block: B:30:0x006f, code lost:
    
        r0 = r9.getField(r10 - 1);
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0085, code lost:
    
        if (getRangeDurationField().getType() != r0.getDurationField().getType()) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x008d, code lost:
    
        throw new java.lang.IllegalArgumentException("Fields invalid for add");
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x0094, code lost:
    
        r12 = r12 - ((r3 - 1) - r11[r10]);
        r11 = r0.add(r9, r10 - 1, r11, -1);
        r11[r10] = getMaximumValue(r9, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x0093, code lost:
    
        throw new java.lang.IllegalArgumentException("Maximum value exceeded for add");
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x0067, code lost:
    
        r11[r10] = (int) r4;
     */
    /* JADX WARN: Code restructure failed: missing block: B:43:0x00a8, code lost:
    
        set(r9, r10, r11, r11[r10]);
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00ad, code lost:
    
        return r11;
     */
    @Override // org.joda.time.b
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public int[] add(org.joda.time.j r9, int r10, int[] r11, int r12) {
        /*
            r8 = this;
            if (r12 != 0) goto L3
            return r11
        L3:
            r0 = 0
        L4:
            java.lang.String r1 = "Fields invalid for add"
            java.lang.String r2 = "Maximum value exceeded for add"
            if (r12 <= 0) goto L58
            int r3 = r8.getMaximumValue(r9, r11)
            r4 = r11[r10]
            int r4 = r4 + r12
            long r4 = (long) r4
            long r6 = (long) r3
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 > 0) goto L1b
            int r3 = (int) r4
            r11[r10] = r3
            goto L58
        L1b:
            if (r0 != 0) goto L44
            if (r10 == 0) goto L3e
            int r0 = r10 + (-1)
            org.joda.time.b r0 = r9.getField(r0)
            org.joda.time.e r2 = r8.getRangeDurationField()
            org.joda.time.DurationFieldType r2 = r2.getType()
            org.joda.time.e r4 = r0.getDurationField()
            org.joda.time.DurationFieldType r4 = r4.getType()
            if (r2 != r4) goto L38
            goto L44
        L38:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r1)
            throw r9
        L3e:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r2)
            throw r9
        L44:
            int r3 = r3 + 1
            r1 = r11[r10]
            int r3 = r3 - r1
            int r12 = r12 - r3
            int r1 = r10 + (-1)
            r2 = 1
            int[] r11 = r0.add(r9, r1, r11, r2)
            int r1 = r8.getMinimumValue(r9, r11)
            r11[r10] = r1
            goto L4
        L58:
            if (r12 >= 0) goto La8
            int r3 = r8.getMinimumValue(r9, r11)
            r4 = r11[r10]
            int r4 = r4 + r12
            long r4 = (long) r4
            long r6 = (long) r3
            int r6 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r6 < 0) goto L6b
            int r12 = (int) r4
            r11[r10] = r12
            goto La8
        L6b:
            if (r0 != 0) goto L94
            if (r10 == 0) goto L8e
            int r0 = r10 + (-1)
            org.joda.time.b r0 = r9.getField(r0)
            org.joda.time.e r4 = r8.getRangeDurationField()
            org.joda.time.DurationFieldType r4 = r4.getType()
            org.joda.time.e r5 = r0.getDurationField()
            org.joda.time.DurationFieldType r5 = r5.getType()
            if (r4 != r5) goto L88
            goto L94
        L88:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r1)
            throw r9
        L8e:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>(r2)
            throw r9
        L94:
            int r3 = r3 + (-1)
            r4 = r11[r10]
            int r3 = r3 - r4
            int r12 = r12 - r3
            int r3 = r10 + (-1)
            r4 = -1
            int[] r11 = r0.add(r9, r3, r11, r4)
            int r3 = r8.getMaximumValue(r9, r11)
            r11[r10] = r3
            goto L58
        La8:
            r12 = r11[r10]
            r8.set(r9, r10, r11, r12)
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.field.b.add(org.joda.time.j, int, int[], int):int[]");
    }

    @Override // org.joda.time.b
    public final String getAsShortText(org.joda.time.j jVar, int i3, Locale locale) {
        return getAsShortText(i3, locale);
    }

    @Override // org.joda.time.b
    public final String getAsText(org.joda.time.j jVar, int i3, Locale locale) {
        return getAsText(i3, locale);
    }

    @Override // org.joda.time.b
    public int getMaximumValue(org.joda.time.j jVar, int[] iArr) {
        return getMaximumValue(jVar);
    }

    @Override // org.joda.time.b
    public int getMinimumValue(org.joda.time.j jVar, int[] iArr) {
        return getMinimumValue(jVar);
    }

    @Override // org.joda.time.b
    public int[] addWrapField(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        set(jVar, i3, iArr, nf.b(iArr[i3], i10, getMinimumValue(jVar), getMaximumValue(jVar)));
        return iArr;
    }

    @Override // org.joda.time.b
    public final String getAsShortText(org.joda.time.j jVar, Locale locale) {
        return getAsShortText(jVar.get(this.f17130a), locale);
    }

    @Override // org.joda.time.b
    public final String getAsText(org.joda.time.j jVar, Locale locale) {
        return getAsText(jVar.get(this.f17130a), locale);
    }

    @Override // org.joda.time.b
    public String getAsShortText(int i3, Locale locale) {
        return getAsText(i3, locale);
    }

    @Override // org.joda.time.b
    public String getAsText(int i3, Locale locale) {
        return Integer.toString(i3);
    }

    @Override // org.joda.time.b
    public long set(long j4, String str, Locale locale) {
        return set(j4, b(str, locale));
    }

    @Override // org.joda.time.b
    public final long set(long j4, String str) {
        return set(j4, str, null);
    }

    @Override // org.joda.time.b
    public final int[] set(org.joda.time.j jVar, int i3, int[] iArr, String str, Locale locale) {
        set(jVar, i3, iArr, b(str, locale));
        return iArr;
    }
}
