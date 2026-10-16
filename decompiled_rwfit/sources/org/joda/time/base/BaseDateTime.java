package org.joda.time.base;

import ai.a;
import androidx.camera.core.impl.e;
import bi.f;
import com.google.android.exoplayer2.Format;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.DateTimeZone;
import org.joda.time.c;
import org.joda.time.chrono.ISOChronology;

/* loaded from: classes2.dex */
public abstract class BaseDateTime extends a implements Serializable {
    private static final long serialVersionUID = -6728882245981L;
    private volatile org.joda.time.a iChronology;
    private volatile long iMillis;

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseDateTime() {
        this(System.currentTimeMillis(), ISOChronology.getInstance());
        AtomicReference atomicReference = c.f17022a;
    }

    public final void a() {
        if (this.iMillis == Long.MIN_VALUE || this.iMillis == Format.OFFSET_SAMPLE_RELATIVE) {
            this.iChronology = this.iChronology.withUTC();
        }
    }

    public org.joda.time.a checkChronology(org.joda.time.a aVar) {
        AtomicReference atomicReference = c.f17022a;
        return aVar == null ? ISOChronology.getInstance() : aVar;
    }

    public long checkInstant(long j4, org.joda.time.a aVar) {
        return j4;
    }

    @Override // org.joda.time.h
    public org.joda.time.a getChronology() {
        return this.iChronology;
    }

    @Override // org.joda.time.h
    public long getMillis() {
        return this.iMillis;
    }

    public void setChronology(org.joda.time.a aVar) {
        this.iChronology = checkChronology(aVar);
    }

    public void setMillis(long j4) {
        this.iMillis = checkInstant(j4, this.iChronology);
    }

    public BaseDateTime(int i3, int i10, int i11, int i12, int i13, int i14, int i15, org.joda.time.a aVar) {
        this.iChronology = checkChronology(aVar);
        this.iMillis = checkInstant(this.iChronology.getDateTimeMillis(i3, i10, i11, i12, i13, i14, i15), this.iChronology);
        a();
    }

    public BaseDateTime(long j4, org.joda.time.a aVar) {
        this.iChronology = checkChronology(aVar);
        this.iMillis = checkInstant(j4, this.iChronology);
        a();
    }

    public BaseDateTime(Object obj, org.joda.time.a aVar) {
        f f2 = e.e().f(obj);
        this.iChronology = checkChronology(f2.a(obj, aVar));
        this.iMillis = checkInstant(f2.d(obj, aVar), this.iChronology);
        a();
    }

    public BaseDateTime(Object obj, DateTimeZone dateTimeZone) {
        f f2 = e.e().f(obj);
        org.joda.time.a checkChronology = checkChronology(f2.b(obj, dateTimeZone));
        this.iChronology = checkChronology;
        this.iMillis = checkInstant(f2.d(obj, checkChronology), checkChronology);
        a();
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseDateTime(DateTimeZone dateTimeZone) {
        this(System.currentTimeMillis(), ISOChronology.getInstance(dateTimeZone));
        AtomicReference atomicReference = c.f17022a;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BaseDateTime(org.joda.time.a aVar) {
        this(System.currentTimeMillis(), aVar);
        AtomicReference atomicReference = c.f17022a;
    }

    public BaseDateTime(long j4) {
        this(j4, ISOChronology.getInstance());
    }

    public BaseDateTime(long j4, DateTimeZone dateTimeZone) {
        this(j4, ISOChronology.getInstance(dateTimeZone));
    }

    public BaseDateTime(int i3, int i10, int i11, int i12, int i13, int i14, int i15) {
        this(i3, i10, i11, i12, i13, i14, i15, ISOChronology.getInstance());
    }

    public BaseDateTime(int i3, int i10, int i11, int i12, int i13, int i14, int i15, DateTimeZone dateTimeZone) {
        this(i3, i10, i11, i12, i13, i14, i15, ISOChronology.getInstance(dateTimeZone));
    }
}
