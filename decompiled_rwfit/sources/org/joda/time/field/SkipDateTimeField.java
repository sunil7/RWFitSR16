package org.joda.time.field;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import org.joda.time.DateTimeFieldType;
import org.joda.time.IllegalFieldValueException;

/* loaded from: classes2.dex */
public final class SkipDateTimeField extends DelegatedDateTimeField {
    private static final long serialVersionUID = -8869148464118507846L;

    /* renamed from: a, reason: collision with root package name */
    public final transient int f17126a;
    private final org.joda.time.a iChronology;
    private final int iSkip;

    public SkipDateTimeField(org.joda.time.a aVar, org.joda.time.b bVar) {
        this(aVar, bVar, 0);
    }

    private Object readResolve() {
        return getType().getField(this.iChronology);
    }

    @Override // org.joda.time.field.DelegatedDateTimeField, org.joda.time.b
    public int get(long j4) {
        int i3 = super.get(j4);
        return i3 <= this.iSkip ? i3 - 1 : i3;
    }

    @Override // org.joda.time.field.DelegatedDateTimeField, org.joda.time.b
    public int getMinimumValue() {
        return this.f17126a;
    }

    @Override // org.joda.time.field.DelegatedDateTimeField, org.joda.time.b
    public long set(long j4, int i3) {
        nf.k(this, i3, this.f17126a, getMaximumValue());
        int i10 = this.iSkip;
        if (i3 <= i10) {
            if (i3 == i10) {
                throw new IllegalFieldValueException(DateTimeFieldType.year(), Integer.valueOf(i3), (Number) null, (Number) null);
            }
            i3++;
        }
        return super.set(j4, i3);
    }

    public SkipDateTimeField(org.joda.time.a aVar, org.joda.time.b bVar, int i3) {
        super(bVar);
        this.iChronology = aVar;
        int minimumValue = super.getMinimumValue();
        if (minimumValue < i3) {
            this.f17126a = minimumValue - 1;
        } else if (minimumValue == i3) {
            this.f17126a = i3 + 1;
        } else {
            this.f17126a = minimumValue;
        }
        this.iSkip = i3;
    }
}
