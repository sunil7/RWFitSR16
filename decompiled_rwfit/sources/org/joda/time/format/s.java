package org.joda.time.format;

import java.util.Arrays;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.IllegalInstantException;
import org.joda.time.chrono.ISOChronology;

/* loaded from: classes2.dex */
public final class s {

    /* renamed from: a, reason: collision with root package name */
    public final org.joda.time.a f17217a;

    /* renamed from: b, reason: collision with root package name */
    public final Locale f17218b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17219c;

    /* renamed from: d, reason: collision with root package name */
    public DateTimeZone f17220d;
    public Integer e;

    /* renamed from: f, reason: collision with root package name */
    public q[] f17221f;

    /* renamed from: g, reason: collision with root package name */
    public int f17222g;

    /* renamed from: h, reason: collision with root package name */
    public boolean f17223h;

    /* renamed from: i, reason: collision with root package name */
    public r f17224i;

    public s(org.joda.time.a aVar, Locale locale) {
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        aVar = aVar == null ? ISOChronology.getInstance() : aVar;
        DateTimeZone zone = aVar.getZone();
        this.f17217a = aVar.withUTC();
        this.f17218b = locale == null ? Locale.getDefault() : locale;
        this.f17219c = 2000;
        this.f17220d = zone;
        this.f17221f = new q[8];
    }

    public static int a(org.joda.time.e eVar, org.joda.time.e eVar2) {
        if (eVar == null || !eVar.isSupported()) {
            return (eVar2 == null || !eVar2.isSupported()) ? 0 : -1;
        }
        if (eVar2 == null || !eVar2.isSupported()) {
            return 1;
        }
        return -eVar.compareTo(eVar2);
    }

    public final long b(String str) {
        q[] qVarArr = this.f17221f;
        int i3 = this.f17222g;
        if (this.f17223h) {
            qVarArr = (q[]) qVarArr.clone();
            this.f17221f = qVarArr;
            this.f17223h = false;
        }
        if (i3 > 10) {
            Arrays.sort(qVarArr, 0, i3);
        } else {
            for (int i10 = 0; i10 < i3; i10++) {
                for (int i11 = i10; i11 > 0; i11--) {
                    int i12 = i11 - 1;
                    q qVar = qVarArr[i12];
                    q qVar2 = qVarArr[i11];
                    qVar.getClass();
                    org.joda.time.b bVar = qVar2.f17209a;
                    int a3 = a(qVar.f17209a.getRangeDurationField(), bVar.getRangeDurationField());
                    if (a3 == 0) {
                        a3 = a(qVar.f17209a.getDurationField(), bVar.getDurationField());
                    }
                    if (a3 > 0) {
                        q qVar3 = qVarArr[i11];
                        qVarArr[i11] = qVarArr[i12];
                        qVarArr[i12] = qVar3;
                    }
                }
            }
        }
        if (i3 > 0) {
            DurationFieldType months = DurationFieldType.months();
            org.joda.time.a aVar = this.f17217a;
            org.joda.time.e field = months.getField(aVar);
            org.joda.time.e field2 = DurationFieldType.days().getField(aVar);
            org.joda.time.e durationField = qVarArr[0].f17209a.getDurationField();
            if (a(durationField, field) >= 0 && a(durationField, field2) <= 0) {
                DateTimeFieldType year = DateTimeFieldType.year();
                q c9 = c();
                c9.f17209a = year.getField(aVar);
                c9.f17210b = this.f17219c;
                c9.f17211c = null;
                c9.f17212d = null;
                return b(str);
            }
        }
        long j4 = 0;
        for (int i13 = 0; i13 < i3; i13++) {
            try {
                q qVar4 = qVarArr[i13];
                String str2 = qVar4.f17211c;
                j4 = qVar4.f17209a.roundFloor(str2 == null ? qVar4.f17209a.setExtended(j4, qVar4.f17210b) : qVar4.f17209a.set(j4, str2, qVar4.f17212d));
            } catch (IllegalFieldValueException e) {
                if (str != null) {
                    e.prependMessage("Cannot parse \"" + ((Object) str) + '\"');
                }
                throw e;
            }
        }
        int i14 = 0;
        while (i14 < i3) {
            if (!qVarArr[i14].f17209a.isLenient()) {
                q qVar5 = qVarArr[i14];
                boolean z5 = i14 == i3 + (-1);
                String str3 = qVar5.f17211c;
                j4 = str3 == null ? qVar5.f17209a.setExtended(j4, qVar5.f17210b) : qVar5.f17209a.set(j4, str3, qVar5.f17212d);
                if (z5) {
                    j4 = qVar5.f17209a.roundFloor(j4);
                }
            }
            i14++;
        }
        if (this.e != null) {
            return j4 - r0.intValue();
        }
        DateTimeZone dateTimeZone = this.f17220d;
        if (dateTimeZone != null) {
            int offsetFromLocal = dateTimeZone.getOffsetFromLocal(j4);
            j4 -= offsetFromLocal;
            if (offsetFromLocal != this.f17220d.getOffset(j4)) {
                String str4 = "Illegal instant due to time zone offset transition (" + this.f17220d + ')';
                if (str != null) {
                    str4 = "Cannot parse \"" + ((Object) str) + "\": " + str4;
                }
                throw new IllegalInstantException(str4);
            }
        }
        return j4;
    }

    public final q c() {
        q[] qVarArr = this.f17221f;
        int i3 = this.f17222g;
        if (i3 == qVarArr.length || this.f17223h) {
            q[] qVarArr2 = new q[i3 == qVarArr.length ? i3 * 2 : qVarArr.length];
            System.arraycopy(qVarArr, 0, qVarArr2, 0, i3);
            this.f17221f = qVarArr2;
            this.f17223h = false;
            qVarArr = qVarArr2;
        }
        this.f17224i = null;
        q qVar = qVarArr[i3];
        if (qVar == null) {
            qVar = new q();
            qVarArr[i3] = qVar;
        }
        this.f17222g = i3 + 1;
        return qVar;
    }

    public final void d(Object obj) {
        if (obj instanceof r) {
            r rVar = (r) obj;
            if (this != rVar.e) {
                return;
            }
            this.f17220d = rVar.f17213a;
            this.e = rVar.f17214b;
            this.f17221f = rVar.f17215c;
            int i3 = this.f17222g;
            int i10 = rVar.f17216d;
            if (i10 < i3) {
                this.f17223h = true;
            }
            this.f17222g = i10;
            this.f17224i = (r) obj;
        }
    }
}
