package bi;

import com.google.android.gms.internal.mlkit_vision_barcode.b1;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.MutableInterval;
import org.joda.time.MutablePeriod;
import org.joda.time.chrono.ISOChronology;

/* loaded from: classes2.dex */
public final class m extends b1 implements g, e, k {

    /* renamed from: b, reason: collision with root package name */
    public static final m f3274b = new m();

    @Override // bi.b
    public final Class e() {
        return org.joda.time.i.class;
    }

    @Override // bi.k
    public final void f(MutablePeriod mutablePeriod, Object obj, org.joda.time.a aVar) {
        org.joda.time.i iVar = (org.joda.time.i) obj;
        if (aVar == null) {
            AtomicReference atomicReference = org.joda.time.c.f17022a;
            if (iVar == null) {
                aVar = ISOChronology.getInstance();
            } else {
                aVar = iVar.getChronology();
                if (aVar == null) {
                    aVar = ISOChronology.getInstance();
                }
            }
        }
        int[] iArr = aVar.get(mutablePeriod, iVar.getStartMillis(), iVar.getEndMillis());
        for (int i3 = 0; i3 < iArr.length; i3++) {
            mutablePeriod.setValue(i3, iArr[i3]);
        }
    }

    @Override // bi.g
    public final void g(MutableInterval mutableInterval, Object obj, org.joda.time.a aVar) {
        org.joda.time.i iVar = (org.joda.time.i) obj;
        mutableInterval.setInterval(iVar);
        if (aVar != null) {
            mutableInterval.setChronology(aVar);
        } else {
            mutableInterval.setChronology(iVar.getChronology());
        }
    }

    @Override // bi.e
    public final long i(Object obj) {
        return ((org.joda.time.i) obj).toDurationMillis();
    }
}
