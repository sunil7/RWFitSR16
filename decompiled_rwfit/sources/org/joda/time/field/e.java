package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DurationFieldType;

/* loaded from: classes2.dex */
public abstract class e extends b {

    /* renamed from: b, reason: collision with root package name */
    public final long f17136b;

    /* renamed from: c, reason: collision with root package name */
    public final org.joda.time.e f17137c;

    public e(DateTimeFieldType dateTimeFieldType, long j4) {
        super(dateTimeFieldType);
        this.f17136b = j4;
        final DurationFieldType durationType = dateTimeFieldType.getDurationType();
        this.f17137c = new BaseDurationField(durationType) { // from class: org.joda.time.field.ImpreciseDateTimeField$LinkedDurationField
            private static final long serialVersionUID = -203813474600094134L;

            @Override // org.joda.time.e
            public long add(long j10, int i3) {
                return e.this.add(j10, i3);
            }

            @Override // org.joda.time.field.BaseDurationField, org.joda.time.e
            public int getDifference(long j10, long j11) {
                return e.this.getDifference(j10, j11);
            }

            @Override // org.joda.time.e
            public long getDifferenceAsLong(long j10, long j11) {
                return e.this.getDifferenceAsLong(j10, j11);
            }

            @Override // org.joda.time.e
            public long getMillis(int i3, long j10) {
                return e.this.add(j10, i3) - j10;
            }

            @Override // org.joda.time.e
            public long getUnitMillis() {
                return e.this.f17136b;
            }

            @Override // org.joda.time.field.BaseDurationField, org.joda.time.e
            public int getValue(long j10, long j11) {
                return e.this.getDifference(j10 + j11, j11);
            }

            @Override // org.joda.time.e
            public long getValueAsLong(long j10, long j11) {
                return e.this.getDifferenceAsLong(j10 + j11, j11);
            }

            @Override // org.joda.time.e
            public boolean isPrecise() {
                return false;
            }

            @Override // org.joda.time.e
            public long add(long j10, long j11) {
                return e.this.add(j10, j11);
            }

            @Override // org.joda.time.e
            public long getMillis(long j10, long j11) {
                return e.this.add(j11, j10) - j11;
            }
        };
    }

    @Override // org.joda.time.field.b, org.joda.time.b
    public final int getDifference(long j4, long j10) {
        return nf.j(getDifferenceAsLong(j4, j10));
    }

    @Override // org.joda.time.b
    public final org.joda.time.e getDurationField() {
        return this.f17137c;
    }
}
