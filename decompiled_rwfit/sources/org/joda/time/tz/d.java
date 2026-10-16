package org.joda.time.tz;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public abstract class d {
    public static DateTimeZone a(DataInput dataInput, String str) {
        int readUnsignedByte = dataInput.readUnsignedByte();
        if (readUnsignedByte == 67) {
            return CachedDateTimeZone.forZone(DateTimeZoneBuilder$PrecalculatedZone.readFrom(dataInput, str));
        }
        if (readUnsignedByte != 70) {
            if (readUnsignedByte == 80) {
                return DateTimeZoneBuilder$PrecalculatedZone.readFrom(dataInput, str);
            }
            throw new IOException("Invalid encoding");
        }
        FixedDateTimeZone fixedDateTimeZone = new FixedDateTimeZone(str, dataInput.readUTF(), (int) b(dataInput), (int) b(dataInput));
        DateTimeZone dateTimeZone = DateTimeZone.UTC;
        return fixedDateTimeZone.equals(dateTimeZone) ? dateTimeZone : fixedDateTimeZone;
    }

    public static long b(DataInput dataInput) {
        long readUnsignedByte;
        long j4;
        int readUnsignedByte2 = dataInput.readUnsignedByte();
        int i3 = readUnsignedByte2 >> 6;
        if (i3 == 1) {
            readUnsignedByte = dataInput.readUnsignedByte() | ((readUnsignedByte2 << 26) >> 2) | (dataInput.readUnsignedByte() << 16) | (dataInput.readUnsignedByte() << 8);
            j4 = 60000;
        } else if (i3 == 2) {
            readUnsignedByte = ((readUnsignedByte2 << 58) >> 26) | (dataInput.readUnsignedByte() << 24) | (dataInput.readUnsignedByte() << 16) | (dataInput.readUnsignedByte() << 8) | dataInput.readUnsignedByte();
            j4 = 1000;
        } else {
            if (i3 == 3) {
                return dataInput.readLong();
            }
            readUnsignedByte = (readUnsignedByte2 << 26) >> 26;
            j4 = 1800000;
        }
        return readUnsignedByte * j4;
    }

    public static void c(DataOutput dataOutput, long j4) {
        if (j4 % 1800000 == 0) {
            long j10 = j4 / 1800000;
            if (((j10 << 58) >> 58) == j10) {
                dataOutput.writeByte((int) (j10 & 63));
                return;
            }
        }
        if (j4 % 60000 == 0) {
            long j11 = j4 / 60000;
            if (((j11 << 34) >> 34) == j11) {
                dataOutput.writeInt(((int) (1073741823 & j11)) | 1073741824);
                return;
            }
        }
        if (j4 % 1000 == 0) {
            long j12 = j4 / 1000;
            if (((j12 << 26) >> 26) == j12) {
                dataOutput.writeByte(((int) ((j12 >> 32) & 63)) | 128);
                dataOutput.writeInt((int) j12);
                return;
            }
        }
        dataOutput.writeByte(j4 < 0 ? 255 : 192);
        dataOutput.writeLong(j4);
    }
}
