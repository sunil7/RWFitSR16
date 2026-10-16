package org.joda.time.base;

import ai.d;
import androidx.camera.core.impl.e;
import bi.g;
import bi.m;
import com.google.android.gms.internal.mlkit_vision_barcode.b1;
import com.google.android.gms.internal.mlkit_vision_barcode.nf;
import java.io.Serializable;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.MutableInterval;
import org.joda.time.a;
import org.joda.time.c;
import org.joda.time.chrono.ISOChronology;
import org.joda.time.h;
import org.joda.time.i;
import org.joda.time.k;

/* loaded from: classes2.dex */
public abstract class BaseInterval extends d implements Serializable {
    private static final long serialVersionUID = 576586928732749278L;
    private volatile a iChronology;
    private volatile long iEndMillis;
    private volatile long iStartMillis;

    public BaseInterval(long j4, long j10, a aVar) {
        AtomicReference atomicReference = c.f17022a;
        this.iChronology = aVar == null ? ISOChronology.getInstance() : aVar;
        checkInterval(j4, j10);
        this.iStartMillis = j4;
        this.iEndMillis = j10;
    }

    @Override // org.joda.time.i
    public a getChronology() {
        return this.iChronology;
    }

    @Override // org.joda.time.i
    public long getEndMillis() {
        return this.iEndMillis;
    }

    @Override // org.joda.time.i
    public long getStartMillis() {
        return this.iStartMillis;
    }

    public void setInterval(long j4, long j10, a aVar) {
        checkInterval(j4, j10);
        this.iStartMillis = j4;
        this.iEndMillis = j10;
        AtomicReference atomicReference = c.f17022a;
        if (aVar == null) {
            aVar = ISOChronology.getInstance();
        }
        this.iChronology = aVar;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BaseInterval(Object obj, a aVar) {
        Class<?> cls;
        e e = e.e();
        if (obj == null) {
            cls = null;
        } else {
            e.getClass();
            cls = obj.getClass();
        }
        g gVar = (g) ((bi.d) e.f1377b).b(cls);
        if (gVar != 0) {
            if (((b1) gVar) instanceof m) {
                i iVar = (i) obj;
                this.iChronology = aVar == null ? iVar.getChronology() : aVar;
                this.iStartMillis = iVar.getStartMillis();
                this.iEndMillis = iVar.getEndMillis();
            } else if (this instanceof MutableInterval) {
                gVar.g((MutableInterval) this, obj, aVar);
            } else {
                MutableInterval mutableInterval = new MutableInterval();
                gVar.g(mutableInterval, obj, aVar);
                this.iChronology = mutableInterval.getChronology();
                this.iStartMillis = mutableInterval.getStartMillis();
                this.iEndMillis = mutableInterval.getEndMillis();
            }
            checkInterval(this.iStartMillis, this.iEndMillis);
            return;
        }
        throw new IllegalArgumentException("No interval converter found for type: ".concat(obj == null ? "null" : obj.getClass().getName()));
    }

    public BaseInterval(org.joda.time.g gVar, h hVar) {
        this.iChronology = c.c(hVar);
        this.iEndMillis = c.d(hVar);
        this.iStartMillis = nf.d(this.iEndMillis, -c.b(gVar));
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    public BaseInterval(h hVar, org.joda.time.g gVar) {
        this.iChronology = c.c(hVar);
        this.iStartMillis = c.d(hVar);
        this.iEndMillis = nf.d(this.iStartMillis, c.b(gVar));
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    public BaseInterval(h hVar, h hVar2) {
        if (hVar == null && hVar2 == null) {
            AtomicReference atomicReference = c.f17022a;
            long currentTimeMillis = System.currentTimeMillis();
            this.iEndMillis = currentTimeMillis;
            this.iStartMillis = currentTimeMillis;
            this.iChronology = ISOChronology.getInstance();
            return;
        }
        this.iChronology = c.c(hVar);
        this.iStartMillis = c.d(hVar);
        this.iEndMillis = c.d(hVar2);
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    public BaseInterval(h hVar, k kVar) {
        a c9 = c.c(hVar);
        this.iChronology = c9;
        this.iStartMillis = c.d(hVar);
        if (kVar == null) {
            this.iEndMillis = this.iStartMillis;
        } else {
            this.iEndMillis = c9.add(kVar, this.iStartMillis, 1);
        }
        checkInterval(this.iStartMillis, this.iEndMillis);
    }

    public BaseInterval(k kVar, h hVar) {
        a c9 = c.c(hVar);
        this.iChronology = c9;
        this.iEndMillis = c.d(hVar);
        if (kVar == null) {
            this.iStartMillis = this.iEndMillis;
        } else {
            this.iStartMillis = c9.add(kVar, this.iEndMillis, -1);
        }
        checkInterval(this.iStartMillis, this.iEndMillis);
    }
}
