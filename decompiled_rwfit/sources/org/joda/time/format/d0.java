package org.joda.time.format;

import com.google.android.exoplayer2.Format;
import java.io.IOException;
import org.joda.time.DurationFieldType;
import org.joda.time.MutablePeriod;
import org.joda.time.PeriodType;

/* loaded from: classes2.dex */
public final class d0 implements k0, j0 {

    /* renamed from: a, reason: collision with root package name */
    public final int f17167a;

    /* renamed from: b, reason: collision with root package name */
    public final int f17168b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17169c;

    /* renamed from: d, reason: collision with root package name */
    public final int f17170d;
    public final d0[] e;

    /* renamed from: f, reason: collision with root package name */
    public final e0 f17171f;

    public d0(int i3, d0[] d0VarArr) {
        this.f17167a = 1;
        this.f17168b = 2;
        this.f17169c = 10;
        this.f17170d = i3;
        this.e = d0VarArr;
        this.f17171f = null;
    }

    public static boolean f(PeriodType periodType, int i3) {
        switch (i3) {
            case 0:
                return periodType.isSupported(DurationFieldType.years());
            case 1:
                return periodType.isSupported(DurationFieldType.months());
            case 2:
                return periodType.isSupported(DurationFieldType.weeks());
            case 3:
                return periodType.isSupported(DurationFieldType.days());
            case 4:
                return periodType.isSupported(DurationFieldType.hours());
            case 5:
                return periodType.isSupported(DurationFieldType.minutes());
            case 6:
                return periodType.isSupported(DurationFieldType.seconds());
            case 7:
                return periodType.isSupported(DurationFieldType.millis());
            case 8:
            case 9:
                return periodType.isSupported(DurationFieldType.seconds()) || periodType.isSupported(DurationFieldType.millis());
            default:
                return false;
        }
    }

    public static int g(int i3, int i10, String str) {
        if (i10 >= 10) {
            return Integer.parseInt(str.substring(i3, i10 + i3));
        }
        boolean z5 = false;
        if (i10 > 0) {
            int i11 = i3 + 1;
            char charAt = str.charAt(i3);
            int i12 = i10 - 1;
            if (charAt == '-') {
                i12 = i10 - 2;
                if (i12 >= 0) {
                    charAt = str.charAt(i11);
                    z5 = true;
                    i11 = i3 + 2;
                }
            }
            int i13 = charAt - '0';
            while (true) {
                int i14 = i12 - 1;
                if (i12 <= 0) {
                    break;
                }
                int charAt2 = (str.charAt(i11) + ((i13 << 3) + (i13 << 1))) - 48;
                i12 = i14;
                i11++;
                i13 = charAt2;
            }
            return z5 ? -i13 : i13;
        }
        return 0;
    }

    public static void h(MutablePeriod mutablePeriod, int i3, int i10) {
        switch (i3) {
            case 0:
                mutablePeriod.setYears(i10);
                break;
            case 1:
                mutablePeriod.setMonths(i10);
                break;
            case 2:
                mutablePeriod.setWeeks(i10);
                break;
            case 3:
                mutablePeriod.setDays(i10);
                break;
            case 4:
                mutablePeriod.setHours(i10);
                break;
            case 5:
                mutablePeriod.setMinutes(i10);
                break;
            case 6:
                mutablePeriod.setSeconds(i10);
                break;
            case 7:
                mutablePeriod.setMillis(i10);
                break;
        }
    }

    @Override // org.joda.time.format.k0
    public final int a(ai.f fVar, int i3) {
        if (i3 <= 0) {
            return 0;
        }
        return (this.f17168b == 4 || e(fVar) != Format.OFFSET_SAMPLE_RELATIVE) ? 1 : 0;
    }

    @Override // org.joda.time.format.k0
    public final int b(ai.f fVar) {
        long e = e(fVar);
        if (e == Format.OFFSET_SAMPLE_RELATIVE) {
            return 0;
        }
        int max = Math.max(u.d(e), this.f17167a);
        int i3 = this.f17170d;
        if (i3 >= 8) {
            int max2 = Math.max(max, e < 0 ? 5 : 4);
            max = (i3 == 9 && Math.abs(e) % 1000 == 0) ? max2 - 3 : max2 + 1;
            e /= 1000;
        }
        int i10 = (int) e;
        e0 e0Var = this.f17171f;
        return e0Var != null ? e0Var.a(i10) + max : max;
    }

    /* JADX WARN: Code restructure failed: missing block: B:49:0x00c8, code lost:
    
        return ~r3;
     */
    @Override // org.joda.time.format.j0
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final int c(org.joda.time.MutablePeriod r18, java.lang.String r19, int r20) {
        /*
            Method dump skipped, instructions count: 301
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.d0.c(org.joda.time.MutablePeriod, java.lang.String, int):int");
    }

    @Override // org.joda.time.format.k0
    public final void d(StringBuffer stringBuffer, ai.f fVar) {
        long e = e(fVar);
        if (e == Format.OFFSET_SAMPLE_RELATIVE) {
            return;
        }
        int i3 = (int) e;
        int i10 = this.f17170d;
        if (i10 >= 8) {
            i3 = (int) (e / 1000);
        }
        int length = stringBuffer.length();
        int i11 = this.f17167a;
        if (i11 <= 1) {
            try {
                u.c(stringBuffer, i3);
            } catch (IOException unused) {
            }
        } else {
            u.b(stringBuffer, i3, i11);
        }
        if (i10 >= 8) {
            int abs = (int) (Math.abs(e) % 1000);
            if (i10 == 8 || abs > 0) {
                if (e < 0 && e > -1000) {
                    stringBuffer.insert(length, '-');
                }
                stringBuffer.append('.');
                u.b(stringBuffer, abs, 3);
            }
        }
        e0 e0Var = this.f17171f;
        if (e0Var != null) {
            e0Var.e(stringBuffer, i3);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final long e(ai.f r11) {
        /*
            r10 = this;
            r0 = 4
            int r1 = r10.f17168b
            if (r1 != r0) goto L7
            r0 = 0
            goto Lb
        L7:
            org.joda.time.PeriodType r0 = r11.getPeriodType()
        Lb:
            int r2 = r10.f17170d
            if (r0 == 0) goto L17
            boolean r3 = f(r0, r2)
            if (r3 != 0) goto L17
            goto Le0
        L17:
            switch(r2) {
                case 0: goto L73;
                case 1: goto L6a;
                case 2: goto L61;
                case 3: goto L58;
                case 4: goto L4f;
                case 5: goto L46;
                case 6: goto L3d;
                case 7: goto L33;
                case 8: goto L1c;
                case 9: goto L1c;
                default: goto L1a;
            }
        L1a:
            goto Le0
        L1c:
            org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.seconds()
            int r3 = r11.get(r3)
            org.joda.time.DurationFieldType r4 = org.joda.time.DurationFieldType.millis()
            int r4 = r11.get(r4)
            long r5 = (long) r3
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = r5 * r7
            long r3 = (long) r4
            long r5 = r5 + r3
            goto L7c
        L33:
            org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.millis()
            int r3 = r11.get(r3)
        L3b:
            long r5 = (long) r3
            goto L7c
        L3d:
            org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.seconds()
            int r3 = r11.get(r3)
            goto L3b
        L46:
            org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.minutes()
            int r3 = r11.get(r3)
            goto L3b
        L4f:
            org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.hours()
            int r3 = r11.get(r3)
            goto L3b
        L58:
            org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.days()
            int r3 = r11.get(r3)
            goto L3b
        L61:
            org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.weeks()
            int r3 = r11.get(r3)
            goto L3b
        L6a:
            org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.months()
            int r3 = r11.get(r3)
            goto L3b
        L73:
            org.joda.time.DurationFieldType r3 = org.joda.time.DurationFieldType.years()
            int r3 = r11.get(r3)
            goto L3b
        L7c:
            r3 = 0
            int r3 = (r5 > r3 ? 1 : (r5 == r3 ? 0 : -1))
            if (r3 != 0) goto Le6
            r3 = 0
            r4 = 1
            r7 = 9
            org.joda.time.format.d0[] r8 = r10.e
            if (r1 == r4) goto Lb6
            r9 = 2
            if (r1 == r9) goto L91
            r11 = 5
            if (r1 == r11) goto Le0
            goto Le6
        L91:
            int r1 = r11.size()
        L95:
            if (r3 >= r1) goto La1
            int r9 = r11.getValue(r3)
            if (r9 == 0) goto L9e
            goto Le0
        L9e:
            int r3 = r3 + 1
            goto L95
        La1:
            r11 = r8[r2]
            if (r11 != r10) goto Le0
            int r2 = r2 + r4
        La6:
            if (r2 > r7) goto Le6
            boolean r11 = f(r0, r2)
            if (r11 == 0) goto Lb3
            r11 = r8[r2]
            if (r11 == 0) goto Lb3
            goto Le0
        Lb3:
            int r2 = r2 + 1
            goto La6
        Lb6:
            int r1 = r11.size()
        Lba:
            if (r3 >= r1) goto Lc6
            int r4 = r11.getValue(r3)
            if (r4 == 0) goto Lc3
            goto Le0
        Lc3:
            int r3 = r3 + 1
            goto Lba
        Lc6:
            r11 = r8[r2]
            if (r11 != r10) goto Le0
            r11 = 8
            int r11 = java.lang.Math.min(r2, r11)
        Ld0:
            int r11 = r11 + (-1)
            if (r11 < 0) goto Le6
            if (r11 > r7) goto Le6
            boolean r1 = f(r0, r11)
            if (r1 == 0) goto Ld0
            r1 = r8[r11]
            if (r1 == 0) goto Ld0
        Le0:
            r0 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            return r0
        Le6:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.joda.time.format.d0.e(ai.f):long");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v5, types: [org.joda.time.format.c0] */
    public d0(d0 d0Var, h0 h0Var) {
        this.f17167a = d0Var.f17167a;
        this.f17168b = d0Var.f17168b;
        this.f17169c = d0Var.f17169c;
        this.f17170d = d0Var.f17170d;
        this.e = d0Var.e;
        e0 e0Var = d0Var.f17171f;
        this.f17171f = e0Var != null ? new c0(e0Var, h0Var) : h0Var;
    }
}
