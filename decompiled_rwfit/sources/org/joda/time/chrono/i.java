package org.joda.time.chrono;

import com.google.android.exoplayer2.Format;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import java.util.Locale;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;
import org.joda.time.IllegalFieldValueException;
import org.joda.time.field.UnsupportedDurationField;

/* loaded from: classes2.dex */
public final class i extends org.joda.time.field.b {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f17095b = 1;

    /* renamed from: c, reason: collision with root package name */
    public final Serializable f17096c;

    public i(BasicChronology basicChronology) {
        super(DateTimeFieldType.era());
        this.f17096c = basicChronology;
    }

    @Override // org.joda.time.b
    public final int get(long j4) {
        switch (this.f17095b) {
            case 0:
                if (((BasicChronology) this.f17096c).getYear(j4) <= 0) {
                }
                break;
        }
        return 1;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final String getAsText(int i3, Locale locale) {
        switch (this.f17095b) {
            case 0:
                return j.b(locale).f17098a[i3];
            default:
                return (String) this.f17096c;
        }
    }

    @Override // org.joda.time.b
    public final org.joda.time.e getDurationField() {
        switch (this.f17095b) {
        }
        return UnsupportedDurationField.getInstance(DurationFieldType.eras());
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getMaximumTextLength(Locale locale) {
        switch (this.f17095b) {
            case 0:
                return j.b(locale).f17106j;
            default:
                return ((String) this.f17096c).length();
        }
    }

    @Override // org.joda.time.b
    public final int getMaximumValue() {
        switch (this.f17095b) {
        }
        return 1;
    }

    @Override // org.joda.time.b
    public final int getMinimumValue() {
        switch (this.f17095b) {
            case 0:
                return 0;
            default:
                return 1;
        }
    }

    @Override // org.joda.time.b
    public final org.joda.time.e getRangeDurationField() {
        switch (this.f17095b) {
        }
        return null;
    }

    @Override // org.joda.time.b
    public final boolean isLenient() {
        switch (this.f17095b) {
        }
        return false;
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundCeiling(long j4) {
        switch (this.f17095b) {
            case 0:
                return get(j4) == 0 ? ((BasicChronology) this.f17096c).setYear(0L, 1) : Format.OFFSET_SAMPLE_RELATIVE;
            default:
                return Format.OFFSET_SAMPLE_RELATIVE;
        }
    }

    @Override // org.joda.time.b
    public final long roundFloor(long j4) {
        switch (this.f17095b) {
            case 0:
                if (get(j4) == 1) {
                    return ((BasicChronology) this.f17096c).setYear(0L, 1);
                }
                return Long.MIN_VALUE;
            default:
                return Long.MIN_VALUE;
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundHalfCeiling(long j4) {
        switch (this.f17095b) {
            case 0:
                return roundFloor(j4);
            default:
                return Long.MIN_VALUE;
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundHalfEven(long j4) {
        switch (this.f17095b) {
            case 0:
                return roundFloor(j4);
            default:
                return Long.MIN_VALUE;
        }
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long roundHalfFloor(long j4) {
        switch (this.f17095b) {
            case 0:
                return roundFloor(j4);
            default:
                return Long.MIN_VALUE;
        }
    }

    @Override // org.joda.time.b
    public final long set(long j4, int i3) {
        switch (this.f17095b) {
            case 0:
                nf.k(this, i3, 0, 1);
                if (get(j4) == i3) {
                    return j4;
                }
                BasicChronology basicChronology = (BasicChronology) this.f17096c;
                return basicChronology.setYear(j4, -basicChronology.getYear(j4));
            default:
                nf.k(this, i3, 1, 1);
                return j4;
        }
    }

    public i() {
        super(DateTimeFieldType.era());
        this.f17096c = "BE";
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final long set(long j4, String str, Locale locale) {
        switch (this.f17095b) {
            case 0:
                Integer num = (Integer) j.b(locale).f17103g.get(str);
                if (num != null) {
                    return set(j4, num.intValue());
                }
                throw new IllegalFieldValueException(DateTimeFieldType.era(), str);
            default:
                if (((String) this.f17096c).equals(str) || "1".equals(str)) {
                    return j4;
                }
                throw new IllegalFieldValueException(DateTimeFieldType.era(), str);
        }
    }
}
