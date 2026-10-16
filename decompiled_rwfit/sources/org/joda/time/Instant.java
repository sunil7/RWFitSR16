package org.joda.time;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.convert.FromString;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.format.v;

/* loaded from: classes2.dex */
public final class Instant extends ai.c implements Serializable {
    public static final Instant EPOCH = new Instant(0);
    private static final long serialVersionUID = 3299096530934209741L;
    private final long iMillis;

    public Instant() {
        AtomicReference atomicReference = c.f17022a;
        this.iMillis = System.currentTimeMillis();
    }

    public static Instant now() {
        return new Instant();
    }

    public static Instant ofEpochMilli(long j4) {
        return new Instant(j4);
    }

    public static Instant ofEpochSecond(long j4) {
        return new Instant(nf.f(1000, j4));
    }

    public static Instant parse(String str, org.joda.time.format.b bVar) {
        return bVar.a(str).toInstant();
    }

    @Override // org.joda.time.h
    public a getChronology() {
        return ISOChronology.getInstanceUTC();
    }

    @Override // org.joda.time.h
    public long getMillis() {
        return this.iMillis;
    }

    public Instant minus(long j4) {
        return withDurationAdded(j4, -1);
    }

    public Instant plus(long j4) {
        return withDurationAdded(j4, 1);
    }

    @Override // ai.c, org.joda.time.f
    public DateTime toDateTime() {
        return new DateTime(getMillis(), ISOChronology.getInstance());
    }

    @Override // ai.c
    @Deprecated
    public DateTime toDateTimeISO() {
        return toDateTime();
    }

    @Override // ai.c, org.joda.time.h
    public Instant toInstant() {
        return this;
    }

    @Override // ai.c
    public MutableDateTime toMutableDateTime() {
        return new MutableDateTime(getMillis(), ISOChronology.getInstance());
    }

    @Override // ai.c
    @Deprecated
    public MutableDateTime toMutableDateTimeISO() {
        return toMutableDateTime();
    }

    public Instant withDurationAdded(long j4, int i3) {
        return (j4 == 0 || i3 == 0) ? this : withMillis(getChronology().add(getMillis(), j4, i3));
    }

    public Instant withMillis(long j4) {
        return j4 == this.iMillis ? this : new Instant(j4);
    }

    @FromString
    public static Instant parse(String str) {
        return parse(str, v.f17236e0);
    }

    public Instant minus(g gVar) {
        return withDurationAdded(gVar, -1);
    }

    public Instant plus(g gVar) {
        return withDurationAdded(gVar, 1);
    }

    public Instant withDurationAdded(g gVar, int i3) {
        return (gVar == null || i3 == 0) ? this : withDurationAdded(gVar.getMillis(), i3);
    }

    public Instant(long j4) {
        this.iMillis = j4;
    }

    public Instant(Object obj) {
        this.iMillis = androidx.camera.core.impl.e.e().f(obj).d(obj, ISOChronology.getInstanceUTC());
    }
}
