package org.joda.time.base;

import ai.e;
import bi.j;
import java.io.Serializable;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.a;
import org.joda.time.c;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.b;

/* loaded from: classes2.dex */
public abstract class BasePartial extends e implements Serializable {
    private static final long serialVersionUID = 2353678632973660L;
    private final a iChronology;
    private final int[] iValues;

    public BasePartial(long j4, a aVar) {
        AtomicReference atomicReference = c.f17022a;
        aVar = aVar == null ? ISOChronology.getInstance() : aVar;
        this.iChronology = aVar.withUTC();
        this.iValues = aVar.get(this, j4);
    }

    @Override // org.joda.time.j
    public a getChronology() {
        return this.iChronology;
    }

    @Override // org.joda.time.j
    public int getValue(int i3) {
        return this.iValues[i3];
    }

    @Override // ai.e
    public int[] getValues() {
        return (int[]) this.iValues.clone();
    }

    public void setValue(int i3, int i10) {
        int[] iArr = getField(i3).set(this, i3, this.iValues, i10);
        int[] iArr2 = this.iValues;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
    }

    public void setValues(int[] iArr) {
        getChronology().validate(this, iArr);
        int[] iArr2 = this.iValues;
        System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
    }

    @Override // org.joda.time.j
    public abstract /* synthetic */ int size();

    public String toString(String str) {
        return str == null ? toString() : org.joda.time.format.a.a(str).e(this);
    }

    public String toString(String str, Locale locale) throws IllegalArgumentException {
        if (str == null) {
            return toString();
        }
        return org.joda.time.format.a.a(str).i(locale).e(this);
    }

    public BasePartial(Object obj, a aVar) {
        j g10 = androidx.camera.core.impl.e.e().g(obj);
        a a3 = g10.a(obj, aVar);
        AtomicReference atomicReference = c.f17022a;
        a3 = a3 == null ? ISOChronology.getInstance() : a3;
        this.iChronology = a3.withUTC();
        this.iValues = g10.j(this, obj, a3);
    }

    public BasePartial(Object obj, a aVar, b bVar) {
        j g10 = androidx.camera.core.impl.e.e().g(obj);
        a a3 = g10.a(obj, aVar);
        AtomicReference atomicReference = c.f17022a;
        a3 = a3 == null ? ISOChronology.getInstance() : a3;
        this.iChronology = a3.withUTC();
        this.iValues = g10.c(this, obj, a3, bVar);
    }

    public BasePartial(BasePartial basePartial, a aVar) {
        this.iChronology = aVar.withUTC();
        this.iValues = basePartial.iValues;
    }

    public BasePartial(BasePartial basePartial, int[] iArr) {
        this.iChronology = basePartial.iChronology;
        this.iValues = iArr;
    }

    public BasePartial(int[] iArr, a aVar) {
        AtomicReference atomicReference = c.f17022a;
        aVar = aVar == null ? ISOChronology.getInstance() : aVar;
        this.iChronology = aVar.withUTC();
        aVar.validate(this, iArr);
        this.iValues = iArr;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BasePartial() {
        this(System.currentTimeMillis(), (a) null);
        AtomicReference atomicReference = c.f17022a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BasePartial(a aVar) {
        this(System.currentTimeMillis(), aVar);
        AtomicReference atomicReference = c.f17022a;
    }

    public BasePartial(long j4) {
        this(j4, (a) null);
    }
}
