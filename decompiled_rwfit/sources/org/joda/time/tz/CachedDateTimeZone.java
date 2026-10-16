package org.joda.time.tz;

import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public class CachedDateTimeZone extends DateTimeZone {
    public static final int e;
    private static final long serialVersionUID = 5472298452022250685L;

    /* renamed from: d, reason: collision with root package name */
    public final transient a[] f17261d;
    private final DateTimeZone iZone;

    static {
        Integer num;
        int i3;
        try {
            num = Integer.getInteger("org.joda.time.tz.CachedDateTimeZone.size");
        } catch (SecurityException unused) {
            num = null;
        }
        if (num == null) {
            i3 = 512;
        } else {
            int i10 = 0;
            for (int intValue = num.intValue() - 1; intValue > 0; intValue >>= 1) {
                i10++;
            }
            i3 = 1 << i10;
        }
        e = i3 - 1;
    }

    public CachedDateTimeZone(DateTimeZone dateTimeZone) {
        super(dateTimeZone.getID());
        this.f17261d = new a[e + 1];
        this.iZone = dateTimeZone;
    }

    public static CachedDateTimeZone forZone(DateTimeZone dateTimeZone) {
        return dateTimeZone instanceof CachedDateTimeZone ? (CachedDateTimeZone) dateTimeZone : new CachedDateTimeZone(dateTimeZone);
    }

    public final a e(long j4) {
        int i3 = (int) (j4 >> 32);
        int i10 = e & i3;
        a[] aVarArr = this.f17261d;
        a aVar = aVarArr[i10];
        if (aVar != null && ((int) (aVar.f17262a >> 32)) == i3) {
            return aVar;
        }
        long j10 = j4 & (-4294967296L);
        a aVar2 = new a(this.iZone, j10);
        long j11 = 4294967295L | j10;
        a aVar3 = aVar2;
        while (true) {
            long nextTransition = this.iZone.nextTransition(j10);
            if (nextTransition == j10 || nextTransition > j11) {
                break;
            }
            a aVar4 = new a(this.iZone, nextTransition);
            aVar3.f17264c = aVar4;
            aVar3 = aVar4;
            j10 = nextTransition;
        }
        aVarArr[i10] = aVar2;
        return aVar2;
    }

    @Override // org.joda.time.DateTimeZone
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof CachedDateTimeZone) {
            return this.iZone.equals(((CachedDateTimeZone) obj).iZone);
        }
        return false;
    }

    @Override // org.joda.time.DateTimeZone
    public String getNameKey(long j4) {
        return e(j4).a(j4);
    }

    @Override // org.joda.time.DateTimeZone
    public int getOffset(long j4) {
        return e(j4).b(j4);
    }

    @Override // org.joda.time.DateTimeZone
    public int getStandardOffset(long j4) {
        return e(j4).c(j4);
    }

    public DateTimeZone getUncachedZone() {
        return this.iZone;
    }

    @Override // org.joda.time.DateTimeZone
    public int hashCode() {
        return this.iZone.hashCode();
    }

    @Override // org.joda.time.DateTimeZone
    public boolean isFixed() {
        return this.iZone.isFixed();
    }

    @Override // org.joda.time.DateTimeZone
    public long nextTransition(long j4) {
        return this.iZone.nextTransition(j4);
    }

    @Override // org.joda.time.DateTimeZone
    public long previousTransition(long j4) {
        return this.iZone.previousTransition(j4);
    }
}
