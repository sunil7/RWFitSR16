package org.joda.time.field;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Locale;
import org.joda.time.DateTimeFieldType;

/* loaded from: classes2.dex */
public final class UnsupportedDateTimeField extends org.joda.time.b implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap f17128a = null;
    private static final long serialVersionUID = -1934618396111902255L;
    private final org.joda.time.e iDurationField;
    private final DateTimeFieldType iType;

    public UnsupportedDateTimeField(DateTimeFieldType dateTimeFieldType, org.joda.time.e eVar) {
        if (dateTimeFieldType == null || eVar == null) {
            throw new IllegalArgumentException();
        }
        this.iType = dateTimeFieldType;
        this.iDurationField = eVar;
    }

    public static synchronized UnsupportedDateTimeField getInstance(DateTimeFieldType dateTimeFieldType, org.joda.time.e eVar) {
        UnsupportedDateTimeField unsupportedDateTimeField;
        synchronized (UnsupportedDateTimeField.class) {
            try {
                HashMap hashMap = f17128a;
                unsupportedDateTimeField = null;
                if (hashMap == null) {
                    f17128a = new HashMap(7);
                } else {
                    UnsupportedDateTimeField unsupportedDateTimeField2 = (UnsupportedDateTimeField) hashMap.get(dateTimeFieldType);
                    if (unsupportedDateTimeField2 == null || unsupportedDateTimeField2.getDurationField() == eVar) {
                        unsupportedDateTimeField = unsupportedDateTimeField2;
                    }
                }
                if (unsupportedDateTimeField == null) {
                    unsupportedDateTimeField = new UnsupportedDateTimeField(dateTimeFieldType, eVar);
                    f17128a.put(dateTimeFieldType, unsupportedDateTimeField);
                }
            } finally {
            }
        }
        return unsupportedDateTimeField;
    }

    private Object readResolve() {
        return getInstance(this.iType, this.iDurationField);
    }

    @Override // org.joda.time.b
    public long add(long j4, int i3) {
        return getDurationField().add(j4, i3);
    }

    @Override // org.joda.time.b
    public long addWrapField(long j4, int i3) {
        throw b();
    }

    @Override // org.joda.time.b
    public int[] addWrapPartial(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        throw b();
    }

    public final UnsupportedOperationException b() {
        return new UnsupportedOperationException(this.iType + " field is unsupported");
    }

    @Override // org.joda.time.b
    public int get(long j4) {
        throw b();
    }

    @Override // org.joda.time.b
    public String getAsShortText(long j4, Locale locale) {
        throw b();
    }

    @Override // org.joda.time.b
    public String getAsText(long j4, Locale locale) {
        throw b();
    }

    @Override // org.joda.time.b
    public int getDifference(long j4, long j10) {
        return getDurationField().getDifference(j4, j10);
    }

    @Override // org.joda.time.b
    public long getDifferenceAsLong(long j4, long j10) {
        return getDurationField().getDifferenceAsLong(j4, j10);
    }

    @Override // org.joda.time.b
    public org.joda.time.e getDurationField() {
        return this.iDurationField;
    }

    @Override // org.joda.time.b
    public int getLeapAmount(long j4) {
        throw b();
    }

    @Override // org.joda.time.b
    public org.joda.time.e getLeapDurationField() {
        return null;
    }

    @Override // org.joda.time.b
    public int getMaximumShortTextLength(Locale locale) {
        throw b();
    }

    @Override // org.joda.time.b
    public int getMaximumTextLength(Locale locale) {
        throw b();
    }

    @Override // org.joda.time.b
    public int getMaximumValue() {
        throw b();
    }

    @Override // org.joda.time.b
    public int getMinimumValue() {
        throw b();
    }

    @Override // org.joda.time.b
    public String getName() {
        return this.iType.getName();
    }

    @Override // org.joda.time.b
    public org.joda.time.e getRangeDurationField() {
        return null;
    }

    @Override // org.joda.time.b
    public DateTimeFieldType getType() {
        return this.iType;
    }

    @Override // org.joda.time.b
    public boolean isLeap(long j4) {
        throw b();
    }

    @Override // org.joda.time.b
    public boolean isLenient() {
        return false;
    }

    @Override // org.joda.time.b
    public boolean isSupported() {
        return false;
    }

    @Override // org.joda.time.b
    public long remainder(long j4) {
        throw b();
    }

    @Override // org.joda.time.b
    public long roundCeiling(long j4) {
        throw b();
    }

    @Override // org.joda.time.b
    public long roundFloor(long j4) {
        throw b();
    }

    @Override // org.joda.time.b
    public long roundHalfCeiling(long j4) {
        throw b();
    }

    @Override // org.joda.time.b
    public long roundHalfEven(long j4) {
        throw b();
    }

    @Override // org.joda.time.b
    public long roundHalfFloor(long j4) {
        throw b();
    }

    @Override // org.joda.time.b
    public long set(long j4, int i3) {
        throw b();
    }

    public String toString() {
        return "UnsupportedDateTimeField";
    }

    @Override // org.joda.time.b
    public long add(long j4, long j10) {
        return getDurationField().add(j4, j10);
    }

    @Override // org.joda.time.b
    public int[] addWrapField(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        throw b();
    }

    @Override // org.joda.time.b
    public String getAsShortText(long j4) {
        throw b();
    }

    @Override // org.joda.time.b
    public String getAsText(long j4) {
        throw b();
    }

    @Override // org.joda.time.b
    public int getMaximumValue(long j4) {
        throw b();
    }

    @Override // org.joda.time.b
    public int getMinimumValue(long j4) {
        throw b();
    }

    @Override // org.joda.time.b
    public int[] set(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        throw b();
    }

    @Override // org.joda.time.b
    public int[] add(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        throw b();
    }

    @Override // org.joda.time.b
    public String getAsShortText(org.joda.time.j jVar, int i3, Locale locale) {
        throw b();
    }

    @Override // org.joda.time.b
    public String getAsText(org.joda.time.j jVar, int i3, Locale locale) {
        throw b();
    }

    @Override // org.joda.time.b
    public int getMaximumValue(org.joda.time.j jVar) {
        throw b();
    }

    @Override // org.joda.time.b
    public int getMinimumValue(org.joda.time.j jVar) {
        throw b();
    }

    @Override // org.joda.time.b
    public long set(long j4, String str, Locale locale) {
        throw b();
    }

    @Override // org.joda.time.b
    public String getAsShortText(org.joda.time.j jVar, Locale locale) {
        throw b();
    }

    @Override // org.joda.time.b
    public String getAsText(org.joda.time.j jVar, Locale locale) {
        throw b();
    }

    @Override // org.joda.time.b
    public int getMaximumValue(org.joda.time.j jVar, int[] iArr) {
        throw b();
    }

    @Override // org.joda.time.b
    public int getMinimumValue(org.joda.time.j jVar, int[] iArr) {
        throw b();
    }

    @Override // org.joda.time.b
    public long set(long j4, String str) {
        throw b();
    }

    @Override // org.joda.time.b
    public String getAsShortText(int i3, Locale locale) {
        throw b();
    }

    @Override // org.joda.time.b
    public String getAsText(int i3, Locale locale) {
        throw b();
    }

    @Override // org.joda.time.b
    public int[] set(org.joda.time.j jVar, int i3, int[] iArr, String str, Locale locale) {
        throw b();
    }
}
