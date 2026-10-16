package org.joda.time.field;

import java.io.Serializable;
import java.util.HashMap;
import org.joda.time.DurationFieldType;

/* loaded from: classes2.dex */
public final class UnsupportedDurationField extends org.joda.time.e implements Serializable {

    /* renamed from: a, reason: collision with root package name */
    public static HashMap f17129a = null;
    private static final long serialVersionUID = -6390301302770925357L;
    private final DurationFieldType iType;

    public UnsupportedDurationField(DurationFieldType durationFieldType) {
        this.iType = durationFieldType;
    }

    public static synchronized UnsupportedDurationField getInstance(DurationFieldType durationFieldType) {
        UnsupportedDurationField unsupportedDurationField;
        synchronized (UnsupportedDurationField.class) {
            try {
                HashMap hashMap = f17129a;
                if (hashMap == null) {
                    f17129a = new HashMap(7);
                    unsupportedDurationField = null;
                } else {
                    unsupportedDurationField = (UnsupportedDurationField) hashMap.get(durationFieldType);
                }
                if (unsupportedDurationField == null) {
                    unsupportedDurationField = new UnsupportedDurationField(durationFieldType);
                    f17129a.put(durationFieldType, unsupportedDurationField);
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return unsupportedDurationField;
    }

    private Object readResolve() {
        return getInstance(this.iType);
    }

    public final UnsupportedOperationException a() {
        return new UnsupportedOperationException(this.iType + " field is unsupported");
    }

    @Override // org.joda.time.e
    public long add(long j4, int i3) {
        throw a();
    }

    @Override // java.lang.Comparable
    public int compareTo(org.joda.time.e eVar) {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof UnsupportedDurationField)) {
            return false;
        }
        UnsupportedDurationField unsupportedDurationField = (UnsupportedDurationField) obj;
        return unsupportedDurationField.getName() == null ? getName() == null : unsupportedDurationField.getName().equals(getName());
    }

    @Override // org.joda.time.e
    public int getDifference(long j4, long j10) {
        throw a();
    }

    @Override // org.joda.time.e
    public long getDifferenceAsLong(long j4, long j10) {
        throw a();
    }

    public long getMillis(int i3) {
        throw a();
    }

    @Override // org.joda.time.e
    public String getName() {
        return this.iType.getName();
    }

    @Override // org.joda.time.e
    public final DurationFieldType getType() {
        return this.iType;
    }

    @Override // org.joda.time.e
    public long getUnitMillis() {
        return 0L;
    }

    @Override // org.joda.time.e
    public int getValue(long j4) {
        throw a();
    }

    @Override // org.joda.time.e
    public long getValueAsLong(long j4) {
        throw a();
    }

    public int hashCode() {
        return getName().hashCode();
    }

    @Override // org.joda.time.e
    public boolean isPrecise() {
        return true;
    }

    @Override // org.joda.time.e
    public boolean isSupported() {
        return false;
    }

    public String toString() {
        return "UnsupportedDurationField[" + getName() + ']';
    }

    @Override // org.joda.time.e
    public long add(long j4, long j10) {
        throw a();
    }

    @Override // org.joda.time.e
    public long getMillis(long j4) {
        throw a();
    }

    @Override // org.joda.time.e
    public int getValue(long j4, long j10) {
        throw a();
    }

    @Override // org.joda.time.e
    public long getValueAsLong(long j4, long j10) {
        throw a();
    }

    @Override // org.joda.time.e
    public long getMillis(int i3, long j4) {
        throw a();
    }

    @Override // org.joda.time.e
    public long getMillis(long j4, long j10) {
        throw a();
    }
}
