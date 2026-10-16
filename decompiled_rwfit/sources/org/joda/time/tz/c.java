package org.joda.time.tz;

import java.io.DataInput;
import java.io.DataOutput;
import org.joda.time.chrono.ISOChronology;

/* loaded from: classes2.dex */
public final class c {

    /* renamed from: a, reason: collision with root package name */
    public final b f17272a;

    /* renamed from: b, reason: collision with root package name */
    public final String f17273b;

    /* renamed from: c, reason: collision with root package name */
    public final int f17274c;

    public c(b bVar, String str, int i3) {
        this.f17272a = bVar;
        this.f17273b = str;
        this.f17274c = i3;
    }

    public static c c(DataInput dataInput) {
        return new c(new b((char) dataInput.readUnsignedByte(), dataInput.readUnsignedByte(), dataInput.readByte(), dataInput.readUnsignedByte(), dataInput.readBoolean(), (int) d.b(dataInput)), dataInput.readUTF(), (int) d.b(dataInput));
    }

    public final long a(int i3, int i10, long j4) {
        b bVar = this.f17272a;
        char c9 = bVar.f17267a;
        if (c9 == 'w') {
            i3 += i10;
        } else if (c9 != 's') {
            i3 = 0;
        }
        long j10 = i3;
        long j11 = j4 + j10;
        ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
        org.joda.time.b monthOfYear = instanceUTC.monthOfYear();
        int i11 = bVar.f17268b;
        long j12 = instanceUTC.millisOfDay().set(monthOfYear.set(j11, i11), 0);
        org.joda.time.b millisOfDay = instanceUTC.millisOfDay();
        int i12 = bVar.f17271f;
        long b3 = bVar.b(instanceUTC, millisOfDay.add(j12, i12));
        if (bVar.f17270d != 0) {
            b3 = bVar.d(instanceUTC, b3);
            if (b3 <= j11) {
                b3 = bVar.d(instanceUTC, bVar.b(instanceUTC, instanceUTC.monthOfYear().set(instanceUTC.year().add(b3, 1), i11)));
            }
        } else if (b3 <= j11) {
            b3 = bVar.b(instanceUTC, instanceUTC.year().add(b3, 1));
        }
        return instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(b3, 0), i12) - j10;
    }

    public final long b(int i3, int i10, long j4) {
        b bVar = this.f17272a;
        char c9 = bVar.f17267a;
        if (c9 == 'w') {
            i3 += i10;
        } else if (c9 != 's') {
            i3 = 0;
        }
        long j10 = i3;
        long j11 = j4 + j10;
        ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
        org.joda.time.b monthOfYear = instanceUTC.monthOfYear();
        int i11 = bVar.f17268b;
        long j12 = instanceUTC.millisOfDay().set(monthOfYear.set(j11, i11), 0);
        org.joda.time.b millisOfDay = instanceUTC.millisOfDay();
        int i12 = bVar.f17271f;
        long c10 = bVar.c(instanceUTC, millisOfDay.add(j12, i12));
        if (bVar.f17270d != 0) {
            c10 = bVar.d(instanceUTC, c10);
            if (c10 >= j11) {
                c10 = bVar.d(instanceUTC, bVar.c(instanceUTC, instanceUTC.monthOfYear().set(instanceUTC.year().add(c10, -1), i11)));
            }
        } else if (c10 >= j11) {
            c10 = bVar.c(instanceUTC, instanceUTC.year().add(c10, -1));
        }
        return instanceUTC.millisOfDay().add(instanceUTC.millisOfDay().set(c10, 0), i12) - j10;
    }

    public final c d() {
        return new c(this.f17272a, (this.f17273b + "-Summer").intern(), this.f17274c);
    }

    public final void e(DataOutput dataOutput) {
        b bVar = this.f17272a;
        dataOutput.writeByte(bVar.f17267a);
        dataOutput.writeByte(bVar.f17268b);
        dataOutput.writeByte(bVar.f17269c);
        dataOutput.writeByte(bVar.f17270d);
        dataOutput.writeBoolean(bVar.e);
        d.c(dataOutput, bVar.f17271f);
        dataOutput.writeUTF(this.f17273b);
        d.c(dataOutput, this.f17274c);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof c) {
            c cVar = (c) obj;
            if (this.f17274c == cVar.f17274c && this.f17273b.equals(cVar.f17273b) && this.f17272a.equals(cVar.f17272a)) {
                return true;
            }
        }
        return false;
    }

    public final String toString() {
        return this.f17272a + " named " + this.f17273b + " at " + this.f17274c;
    }
}
