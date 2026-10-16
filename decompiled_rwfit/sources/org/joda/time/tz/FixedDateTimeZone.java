package org.joda.time.tz;

import java.util.SimpleTimeZone;
import java.util.TimeZone;
import org.joda.time.DateTimeZone;

/* loaded from: classes2.dex */
public final class FixedDateTimeZone extends DateTimeZone {
    private static final long serialVersionUID = -3513011772763289092L;
    private final String iNameKey;
    private final int iStandardOffset;
    private final int iWallOffset;

    public FixedDateTimeZone(String str, String str2, int i3, int i10) {
        super(str);
        this.iNameKey = str2;
        this.iWallOffset = i3;
        this.iStandardOffset = i10;
    }

    @Override // org.joda.time.DateTimeZone
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof FixedDateTimeZone) {
            FixedDateTimeZone fixedDateTimeZone = (FixedDateTimeZone) obj;
            if (getID().equals(fixedDateTimeZone.getID()) && this.iStandardOffset == fixedDateTimeZone.iStandardOffset && this.iWallOffset == fixedDateTimeZone.iWallOffset) {
                return true;
            }
        }
        return false;
    }

    @Override // org.joda.time.DateTimeZone
    public String getNameKey(long j4) {
        return this.iNameKey;
    }

    @Override // org.joda.time.DateTimeZone
    public int getOffset(long j4) {
        return this.iWallOffset;
    }

    @Override // org.joda.time.DateTimeZone
    public int getOffsetFromLocal(long j4) {
        return this.iWallOffset;
    }

    @Override // org.joda.time.DateTimeZone
    public int getStandardOffset(long j4) {
        return this.iStandardOffset;
    }

    @Override // org.joda.time.DateTimeZone
    public int hashCode() {
        return (this.iWallOffset * 31) + (this.iStandardOffset * 37) + getID().hashCode();
    }

    @Override // org.joda.time.DateTimeZone
    public boolean isFixed() {
        return true;
    }

    @Override // org.joda.time.DateTimeZone
    public long nextTransition(long j4) {
        return j4;
    }

    @Override // org.joda.time.DateTimeZone
    public long previousTransition(long j4) {
        return j4;
    }

    @Override // org.joda.time.DateTimeZone
    public TimeZone toTimeZone() {
        String id2 = getID();
        if (id2.length() != 6 || (!id2.startsWith("+") && !id2.startsWith("-"))) {
            return new SimpleTimeZone(this.iWallOffset, getID());
        }
        return TimeZone.getTimeZone("GMT" + getID());
    }
}
