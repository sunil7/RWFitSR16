package org.joda.time.tz;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import java.io.PrintStream;
import java.text.DateFormatSymbols;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;
import org.joda.time.Period;
import org.joda.time.PeriodType;
import org.joda.time.chrono.ISOChronology;

/* loaded from: classes2.dex */
final class DateTimeZoneBuilder$PrecalculatedZone extends DateTimeZone {
    private static final long serialVersionUID = 7811976468055766265L;
    private final String[] iNameKeys;
    private final int[] iStandardOffsets;
    private final DateTimeZoneBuilder$DSTZone iTailZone;
    private final long[] iTransitions;
    private final int[] iWallOffsets;

    public DateTimeZoneBuilder$PrecalculatedZone(String str, long[] jArr, int[] iArr, int[] iArr2, String[] strArr, DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone) {
        super(str);
        this.iTransitions = jArr;
        this.iWallOffsets = iArr;
        this.iStandardOffsets = iArr2;
        this.iNameKeys = strArr;
        this.iTailZone = dateTimeZoneBuilder$DSTZone;
    }

    public static DateTimeZoneBuilder$PrecalculatedZone create(String str, boolean z5, ArrayList<Object> arrayList, DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone) {
        DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone2;
        int[] iArr;
        int[] iArr2;
        String[] strArr;
        int i3;
        int size = arrayList.size();
        if (size == 0) {
            throw new IllegalArgumentException();
        }
        long[] jArr = new long[size];
        int[] iArr3 = new int[size];
        int[] iArr4 = new int[size];
        String[] strArr2 = new String[size];
        int i10 = 0;
        if (size > 0) {
            throw android.support.v4.media.session.e.c(0, arrayList);
        }
        String[] strArr3 = new String[5];
        for (String[] strArr4 : new DateFormatSymbols(Locale.ENGLISH).getZoneStrings()) {
            if (strArr4 != null && strArr4.length == 5) {
                if (str.equals(strArr4[0])) {
                    strArr3 = strArr4;
                }
            }
        }
        ISOChronology instanceUTC = ISOChronology.getInstanceUTC();
        while (i10 < size - 1) {
            String str2 = strArr2[i10];
            int i11 = i10 + 1;
            String str3 = strArr2[i11];
            long j4 = iArr3[i10];
            long j10 = iArr3[i11];
            int i12 = size;
            int i13 = i10;
            long j11 = iArr4[i10];
            long j12 = iArr4[i11];
            Period period = new Period(jArr[i13], jArr[i11], PeriodType.yearMonthDay(), instanceUTC);
            ISOChronology iSOChronology = instanceUTC;
            if (j4 != j10 && j11 == j12 && str2.equals(str3) && period.getYears() == 0 && period.getMonths() > 4 && period.getMonths() < 8 && str2.equals(strArr3[2]) && str2.equals(strArr3[4])) {
                if (((Boolean) i.f17278a.get()).booleanValue()) {
                    System.out.println("Fixing duplicate name key - " + str3);
                    PrintStream printStream = System.out;
                    StringBuilder sb2 = new StringBuilder("     - ");
                    iArr = iArr3;
                    iArr2 = iArr4;
                    sb2.append(new DateTime(jArr[i13], iSOChronology));
                    sb2.append(" - ");
                    strArr = strArr2;
                    sb2.append(new DateTime(jArr[i11], iSOChronology));
                    printStream.println(sb2.toString());
                } else {
                    iArr = iArr3;
                    iArr2 = iArr4;
                    strArr = strArr2;
                }
                if (j4 > j10) {
                    strArr[i13] = str2.concat("-Summer").intern();
                } else if (j4 < j10) {
                    strArr[i11] = (str3 + "-Summer").intern();
                    i3 = i11;
                    i10 = i3 + 1;
                    strArr2 = strArr;
                    instanceUTC = iSOChronology;
                    iArr3 = iArr;
                    iArr4 = iArr2;
                    size = i12;
                }
            } else {
                iArr = iArr3;
                iArr2 = iArr4;
                strArr = strArr2;
            }
            i3 = i13;
            i10 = i3 + 1;
            strArr2 = strArr;
            instanceUTC = iSOChronology;
            iArr3 = iArr;
            iArr4 = iArr2;
            size = i12;
        }
        int[] iArr5 = iArr3;
        int[] iArr6 = iArr4;
        String[] strArr5 = strArr2;
        if (dateTimeZoneBuilder$DSTZone == null || !dateTimeZoneBuilder$DSTZone.iStartRecurrence.f17273b.equals(dateTimeZoneBuilder$DSTZone.iEndRecurrence.f17273b)) {
            dateTimeZoneBuilder$DSTZone2 = dateTimeZoneBuilder$DSTZone;
        } else {
            if (((Boolean) i.f17278a.get()).booleanValue()) {
                System.out.println("Fixing duplicate recurrent name key - " + dateTimeZoneBuilder$DSTZone.iStartRecurrence.f17273b);
            }
            dateTimeZoneBuilder$DSTZone2 = dateTimeZoneBuilder$DSTZone.iStartRecurrence.f17274c > 0 ? new DateTimeZoneBuilder$DSTZone(dateTimeZoneBuilder$DSTZone.getID(), dateTimeZoneBuilder$DSTZone.iStandardOffset, dateTimeZoneBuilder$DSTZone.iStartRecurrence.d(), dateTimeZoneBuilder$DSTZone.iEndRecurrence) : new DateTimeZoneBuilder$DSTZone(dateTimeZoneBuilder$DSTZone.getID(), dateTimeZoneBuilder$DSTZone.iStandardOffset, dateTimeZoneBuilder$DSTZone.iStartRecurrence, dateTimeZoneBuilder$DSTZone.iEndRecurrence.d());
        }
        return new DateTimeZoneBuilder$PrecalculatedZone(z5 ? str : "", jArr, iArr5, iArr6, strArr5, dateTimeZoneBuilder$DSTZone2);
    }

    public static DateTimeZoneBuilder$PrecalculatedZone readFrom(DataInput dataInput, String str) throws IOException {
        int readUnsignedByte;
        int readUnsignedShort = dataInput.readUnsignedShort();
        String[] strArr = new String[readUnsignedShort];
        for (int i3 = 0; i3 < readUnsignedShort; i3++) {
            strArr[i3] = dataInput.readUTF();
        }
        int readInt = dataInput.readInt();
        long[] jArr = new long[readInt];
        int[] iArr = new int[readInt];
        int[] iArr2 = new int[readInt];
        String[] strArr2 = new String[readInt];
        for (int i10 = 0; i10 < readInt; i10++) {
            jArr[i10] = d.b(dataInput);
            iArr[i10] = (int) d.b(dataInput);
            iArr2[i10] = (int) d.b(dataInput);
            if (readUnsignedShort < 256) {
                try {
                    readUnsignedByte = dataInput.readUnsignedByte();
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw new IOException("Invalid encoding");
                }
            } else {
                readUnsignedByte = dataInput.readUnsignedShort();
            }
            strArr2[i10] = strArr[readUnsignedByte];
        }
        return new DateTimeZoneBuilder$PrecalculatedZone(str, jArr, iArr, iArr2, strArr2, dataInput.readBoolean() ? DateTimeZoneBuilder$DSTZone.readFrom(dataInput, str) : null);
    }

    @Override // org.joda.time.DateTimeZone
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof DateTimeZoneBuilder$PrecalculatedZone) {
            DateTimeZoneBuilder$PrecalculatedZone dateTimeZoneBuilder$PrecalculatedZone = (DateTimeZoneBuilder$PrecalculatedZone) obj;
            if (getID().equals(dateTimeZoneBuilder$PrecalculatedZone.getID()) && Arrays.equals(this.iTransitions, dateTimeZoneBuilder$PrecalculatedZone.iTransitions) && Arrays.equals(this.iNameKeys, dateTimeZoneBuilder$PrecalculatedZone.iNameKeys) && Arrays.equals(this.iWallOffsets, dateTimeZoneBuilder$PrecalculatedZone.iWallOffsets) && Arrays.equals(this.iStandardOffsets, dateTimeZoneBuilder$PrecalculatedZone.iStandardOffsets)) {
                DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = this.iTailZone;
                DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone2 = dateTimeZoneBuilder$PrecalculatedZone.iTailZone;
                if (dateTimeZoneBuilder$DSTZone != null ? dateTimeZoneBuilder$DSTZone.equals(dateTimeZoneBuilder$DSTZone2) : dateTimeZoneBuilder$DSTZone2 == null) {
                    return true;
                }
            }
        }
        return false;
    }

    @Override // org.joda.time.DateTimeZone
    public String getNameKey(long j4) {
        long[] jArr = this.iTransitions;
        int binarySearch = Arrays.binarySearch(jArr, j4);
        if (binarySearch >= 0) {
            return this.iNameKeys[binarySearch];
        }
        int i3 = ~binarySearch;
        if (i3 < jArr.length) {
            return i3 > 0 ? this.iNameKeys[i3 - 1] : "UTC";
        }
        DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = this.iTailZone;
        return dateTimeZoneBuilder$DSTZone == null ? this.iNameKeys[i3 - 1] : dateTimeZoneBuilder$DSTZone.getNameKey(j4);
    }

    @Override // org.joda.time.DateTimeZone
    public int getOffset(long j4) {
        long[] jArr = this.iTransitions;
        int binarySearch = Arrays.binarySearch(jArr, j4);
        if (binarySearch >= 0) {
            return this.iWallOffsets[binarySearch];
        }
        int i3 = ~binarySearch;
        if (i3 >= jArr.length) {
            DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = this.iTailZone;
            return dateTimeZoneBuilder$DSTZone == null ? this.iWallOffsets[i3 - 1] : dateTimeZoneBuilder$DSTZone.getOffset(j4);
        }
        if (i3 > 0) {
            return this.iWallOffsets[i3 - 1];
        }
        return 0;
    }

    @Override // org.joda.time.DateTimeZone
    public int getStandardOffset(long j4) {
        long[] jArr = this.iTransitions;
        int binarySearch = Arrays.binarySearch(jArr, j4);
        if (binarySearch >= 0) {
            return this.iStandardOffsets[binarySearch];
        }
        int i3 = ~binarySearch;
        if (i3 >= jArr.length) {
            DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = this.iTailZone;
            return dateTimeZoneBuilder$DSTZone == null ? this.iStandardOffsets[i3 - 1] : dateTimeZoneBuilder$DSTZone.getStandardOffset(j4);
        }
        if (i3 > 0) {
            return this.iStandardOffsets[i3 - 1];
        }
        return 0;
    }

    public boolean isCachable() {
        if (this.iTailZone != null) {
            return true;
        }
        long[] jArr = this.iTransitions;
        if (jArr.length <= 1) {
            return false;
        }
        double d5 = 0.0d;
        int i3 = 0;
        for (int i10 = 1; i10 < jArr.length; i10++) {
            long j4 = jArr[i10] - jArr[i10 - 1];
            if (j4 < 63158400000L) {
                d5 += j4;
                i3++;
            }
        }
        return i3 > 0 && (d5 / ((double) i3)) / 8.64E7d >= 25.0d;
    }

    @Override // org.joda.time.DateTimeZone
    public boolean isFixed() {
        return false;
    }

    @Override // org.joda.time.DateTimeZone
    public long nextTransition(long j4) {
        long[] jArr = this.iTransitions;
        int binarySearch = Arrays.binarySearch(jArr, j4);
        int i3 = binarySearch >= 0 ? binarySearch + 1 : ~binarySearch;
        if (i3 < jArr.length) {
            return jArr[i3];
        }
        DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = this.iTailZone;
        if (dateTimeZoneBuilder$DSTZone == null) {
            return j4;
        }
        long j10 = jArr[jArr.length - 1];
        if (j4 < j10) {
            j4 = j10;
        }
        return dateTimeZoneBuilder$DSTZone.nextTransition(j4);
    }

    @Override // org.joda.time.DateTimeZone
    public long previousTransition(long j4) {
        long[] jArr = this.iTransitions;
        int binarySearch = Arrays.binarySearch(jArr, j4);
        if (binarySearch < 0) {
            int i3 = ~binarySearch;
            if (i3 >= jArr.length) {
                DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = this.iTailZone;
                if (dateTimeZoneBuilder$DSTZone != null) {
                    long previousTransition = dateTimeZoneBuilder$DSTZone.previousTransition(j4);
                    if (previousTransition < j4) {
                        return previousTransition;
                    }
                }
                long j10 = jArr[i3 - 1];
                if (j10 > Long.MIN_VALUE) {
                    return j10 - 1;
                }
            } else if (i3 > 0) {
                long j11 = jArr[i3 - 1];
                if (j11 > Long.MIN_VALUE) {
                    return j11 - 1;
                }
            }
        } else if (j4 > Long.MIN_VALUE) {
            return j4 - 1;
        }
        return j4;
    }

    public void writeTo(DataOutput dataOutput) throws IOException {
        int length = this.iTransitions.length;
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < length; i3++) {
            hashSet.add(this.iNameKeys[i3]);
        }
        int size = hashSet.size();
        if (size > 65535) {
            throw new UnsupportedOperationException("String pool is too large");
        }
        String[] strArr = new String[size];
        Iterator it = hashSet.iterator();
        int i10 = 0;
        while (it.hasNext()) {
            strArr[i10] = (String) it.next();
            i10++;
        }
        dataOutput.writeShort(size);
        for (int i11 = 0; i11 < size; i11++) {
            dataOutput.writeUTF(strArr[i11]);
        }
        dataOutput.writeInt(length);
        for (int i12 = 0; i12 < length; i12++) {
            d.c(dataOutput, this.iTransitions[i12]);
            d.c(dataOutput, this.iWallOffsets[i12]);
            d.c(dataOutput, this.iStandardOffsets[i12]);
            String str = this.iNameKeys[i12];
            int i13 = 0;
            while (true) {
                if (i13 >= size) {
                    break;
                }
                if (!strArr[i13].equals(str)) {
                    i13++;
                } else if (size < 256) {
                    dataOutput.writeByte(i13);
                } else {
                    dataOutput.writeShort(i13);
                }
            }
        }
        dataOutput.writeBoolean(this.iTailZone != null);
        DateTimeZoneBuilder$DSTZone dateTimeZoneBuilder$DSTZone = this.iTailZone;
        if (dateTimeZoneBuilder$DSTZone != null) {
            dateTimeZoneBuilder$DSTZone.writeTo(dataOutput);
        }
    }
}
