package org.joda.time;

import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.base.BaseInterval;

/* loaded from: classes2.dex */
public class MutableInterval extends BaseInterval implements Cloneable, Serializable {
    private static final long serialVersionUID = -5982824024992428470L;

    public MutableInterval() {
        super(0L, 0L, null);
    }

    public static MutableInterval parse(String str) {
        return new MutableInterval(str);
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException unused) {
            throw new InternalError("Clone error");
        }
    }

    public MutableInterval copy() {
        return (MutableInterval) clone();
    }

    public void setChronology(a aVar) {
        super.setInterval(getStartMillis(), getEndMillis(), aVar);
    }

    public void setDurationAfterStart(long j4) {
        setEndMillis(nf.d(getStartMillis(), j4));
    }

    public void setDurationBeforeEnd(long j4) {
        setStartMillis(nf.d(getEndMillis(), -j4));
    }

    public void setEnd(h hVar) {
        super.setInterval(getStartMillis(), c.d(hVar), getChronology());
    }

    public void setEndMillis(long j4) {
        super.setInterval(getStartMillis(), j4, getChronology());
    }

    public void setInterval(long j4, long j10) {
        super.setInterval(j4, j10, getChronology());
    }

    public void setPeriodAfterStart(k kVar) {
        if (kVar == null) {
            setEndMillis(getStartMillis());
        } else {
            setEndMillis(getChronology().add(kVar, getStartMillis(), 1));
        }
    }

    public void setPeriodBeforeEnd(k kVar) {
        if (kVar == null) {
            setStartMillis(getEndMillis());
        } else {
            setStartMillis(getChronology().add(kVar, getEndMillis(), -1));
        }
    }

    public void setStart(h hVar) {
        super.setInterval(c.d(hVar), getEndMillis(), getChronology());
    }

    public void setStartMillis(long j4) {
        super.setInterval(j4, getEndMillis(), getChronology());
    }

    public MutableInterval(long j4, long j10) {
        super(j4, j10, null);
    }

    public void setDurationAfterStart(g gVar) {
        setEndMillis(nf.d(getStartMillis(), c.b(gVar)));
    }

    public void setDurationBeforeEnd(g gVar) {
        setStartMillis(nf.d(getEndMillis(), -c.b(gVar)));
    }

    public void setInterval(i iVar) {
        if (iVar == null) {
            throw new IllegalArgumentException("Interval must not be null");
        }
        super.setInterval(iVar.getStartMillis(), iVar.getEndMillis(), iVar.getChronology());
    }

    public MutableInterval(long j4, long j10, a aVar) {
        super(j4, j10, aVar);
    }

    public MutableInterval(h hVar, h hVar2) {
        super(hVar, hVar2);
    }

    public MutableInterval(h hVar, g gVar) {
        super(hVar, gVar);
    }

    public MutableInterval(g gVar, h hVar) {
        super(gVar, hVar);
    }

    public MutableInterval(h hVar, k kVar) {
        super(hVar, kVar);
    }

    public void setInterval(h hVar, h hVar2) {
        if (hVar == null && hVar2 == null) {
            AtomicReference atomicReference = c.f17022a;
            long currentTimeMillis = System.currentTimeMillis();
            setInterval(currentTimeMillis, currentTimeMillis);
            return;
        }
        super.setInterval(c.d(hVar), c.d(hVar2), c.c(hVar));
    }

    public MutableInterval(k kVar, h hVar) {
        super(kVar, hVar);
    }

    public MutableInterval(Object obj) {
        super(obj, (a) null);
    }

    public MutableInterval(Object obj, a aVar) {
        super(obj, aVar);
    }
}
