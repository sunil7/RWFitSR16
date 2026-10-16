package org.joda.time.field;

import java.io.Serializable;
import java.util.Locale;
import org.joda.time.DateTimeFieldType;

/* loaded from: classes2.dex */
public class DelegatedDateTimeField extends org.joda.time.b implements Serializable {
    private static final long serialVersionUID = -4730164440214502503L;
    private final org.joda.time.b iField;
    private final org.joda.time.e iRangeDurationField;
    private final DateTimeFieldType iType;

    public DelegatedDateTimeField(org.joda.time.b bVar, org.joda.time.e eVar, DateTimeFieldType dateTimeFieldType) {
        if (bVar == null) {
            throw new IllegalArgumentException("The field must not be null");
        }
        this.iField = bVar;
        this.iRangeDurationField = eVar;
        this.iType = dateTimeFieldType == null ? bVar.getType() : dateTimeFieldType;
    }

    @Override // org.joda.time.b
    public long add(long j4, int i3) {
        return this.iField.add(j4, i3);
    }

    @Override // org.joda.time.b
    public long addWrapField(long j4, int i3) {
        return this.iField.addWrapField(j4, i3);
    }

    @Override // org.joda.time.b
    public int[] addWrapPartial(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        return this.iField.addWrapPartial(jVar, i3, iArr, i10);
    }

    @Override // org.joda.time.b
    public int get(long j4) {
        return this.iField.get(j4);
    }

    @Override // org.joda.time.b
    public String getAsShortText(long j4, Locale locale) {
        return this.iField.getAsShortText(j4, locale);
    }

    @Override // org.joda.time.b
    public String getAsText(long j4, Locale locale) {
        return this.iField.getAsText(j4, locale);
    }

    @Override // org.joda.time.b
    public int getDifference(long j4, long j10) {
        return this.iField.getDifference(j4, j10);
    }

    @Override // org.joda.time.b
    public long getDifferenceAsLong(long j4, long j10) {
        return this.iField.getDifferenceAsLong(j4, j10);
    }

    @Override // org.joda.time.b
    public org.joda.time.e getDurationField() {
        return this.iField.getDurationField();
    }

    @Override // org.joda.time.b
    public int getLeapAmount(long j4) {
        return this.iField.getLeapAmount(j4);
    }

    @Override // org.joda.time.b
    public org.joda.time.e getLeapDurationField() {
        return this.iField.getLeapDurationField();
    }

    @Override // org.joda.time.b
    public int getMaximumShortTextLength(Locale locale) {
        return this.iField.getMaximumShortTextLength(locale);
    }

    @Override // org.joda.time.b
    public int getMaximumTextLength(Locale locale) {
        return this.iField.getMaximumTextLength(locale);
    }

    @Override // org.joda.time.b
    public int getMaximumValue() {
        return this.iField.getMaximumValue();
    }

    @Override // org.joda.time.b
    public int getMinimumValue() {
        return this.iField.getMinimumValue();
    }

    @Override // org.joda.time.b
    public String getName() {
        return this.iType.getName();
    }

    @Override // org.joda.time.b
    public org.joda.time.e getRangeDurationField() {
        org.joda.time.e eVar = this.iRangeDurationField;
        return eVar != null ? eVar : this.iField.getRangeDurationField();
    }

    @Override // org.joda.time.b
    public DateTimeFieldType getType() {
        return this.iType;
    }

    public final org.joda.time.b getWrappedField() {
        return this.iField;
    }

    @Override // org.joda.time.b
    public boolean isLeap(long j4) {
        return this.iField.isLeap(j4);
    }

    @Override // org.joda.time.b
    public boolean isLenient() {
        return this.iField.isLenient();
    }

    @Override // org.joda.time.b
    public boolean isSupported() {
        return this.iField.isSupported();
    }

    @Override // org.joda.time.b
    public long remainder(long j4) {
        return this.iField.remainder(j4);
    }

    @Override // org.joda.time.b
    public long roundCeiling(long j4) {
        return this.iField.roundCeiling(j4);
    }

    @Override // org.joda.time.b
    public long roundFloor(long j4) {
        return this.iField.roundFloor(j4);
    }

    @Override // org.joda.time.b
    public long roundHalfCeiling(long j4) {
        return this.iField.roundHalfCeiling(j4);
    }

    @Override // org.joda.time.b
    public long roundHalfEven(long j4) {
        return this.iField.roundHalfEven(j4);
    }

    @Override // org.joda.time.b
    public long roundHalfFloor(long j4) {
        return this.iField.roundHalfFloor(j4);
    }

    @Override // org.joda.time.b
    public long set(long j4, int i3) {
        return this.iField.set(j4, i3);
    }

    public String toString() {
        return "DateTimeField[" + getName() + ']';
    }

    @Override // org.joda.time.b
    public long add(long j4, long j10) {
        return this.iField.add(j4, j10);
    }

    @Override // org.joda.time.b
    public int[] addWrapField(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        return this.iField.addWrapField(jVar, i3, iArr, i10);
    }

    @Override // org.joda.time.b
    public String getAsShortText(long j4) {
        return this.iField.getAsShortText(j4);
    }

    @Override // org.joda.time.b
    public String getAsText(long j4) {
        return this.iField.getAsText(j4);
    }

    @Override // org.joda.time.b
    public int getMaximumValue(long j4) {
        return this.iField.getMaximumValue(j4);
    }

    @Override // org.joda.time.b
    public int getMinimumValue(long j4) {
        return this.iField.getMinimumValue(j4);
    }

    @Override // org.joda.time.b
    public long set(long j4, String str, Locale locale) {
        return this.iField.set(j4, str, locale);
    }

    @Override // org.joda.time.b
    public int[] add(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        return this.iField.add(jVar, i3, iArr, i10);
    }

    @Override // org.joda.time.b
    public String getAsShortText(org.joda.time.j jVar, int i3, Locale locale) {
        return this.iField.getAsShortText(jVar, i3, locale);
    }

    @Override // org.joda.time.b
    public String getAsText(org.joda.time.j jVar, int i3, Locale locale) {
        return this.iField.getAsText(jVar, i3, locale);
    }

    @Override // org.joda.time.b
    public int getMaximumValue(org.joda.time.j jVar) {
        return this.iField.getMaximumValue(jVar);
    }

    @Override // org.joda.time.b
    public int getMinimumValue(org.joda.time.j jVar) {
        return this.iField.getMinimumValue(jVar);
    }

    @Override // org.joda.time.b
    public long set(long j4, String str) {
        return this.iField.set(j4, str);
    }

    @Override // org.joda.time.b
    public String getAsShortText(org.joda.time.j jVar, Locale locale) {
        return this.iField.getAsShortText(jVar, locale);
    }

    @Override // org.joda.time.b
    public String getAsText(org.joda.time.j jVar, Locale locale) {
        return this.iField.getAsText(jVar, locale);
    }

    @Override // org.joda.time.b
    public int getMaximumValue(org.joda.time.j jVar, int[] iArr) {
        return this.iField.getMaximumValue(jVar, iArr);
    }

    @Override // org.joda.time.b
    public int getMinimumValue(org.joda.time.j jVar, int[] iArr) {
        return this.iField.getMinimumValue(jVar, iArr);
    }

    @Override // org.joda.time.b
    public int[] set(org.joda.time.j jVar, int i3, int[] iArr, int i10) {
        return this.iField.set(jVar, i3, iArr, i10);
    }

    @Override // org.joda.time.b
    public String getAsShortText(int i3, Locale locale) {
        return this.iField.getAsShortText(i3, locale);
    }

    @Override // org.joda.time.b
    public String getAsText(int i3, Locale locale) {
        return this.iField.getAsText(i3, locale);
    }

    @Override // org.joda.time.b
    public int[] set(org.joda.time.j jVar, int i3, int[] iArr, String str, Locale locale) {
        return this.iField.set(jVar, i3, iArr, str, locale);
    }

    public DelegatedDateTimeField(org.joda.time.b bVar) {
        this(bVar, null);
    }

    public DelegatedDateTimeField(org.joda.time.b bVar, DateTimeFieldType dateTimeFieldType) {
        this(bVar, null, dateTimeFieldType);
    }
}
