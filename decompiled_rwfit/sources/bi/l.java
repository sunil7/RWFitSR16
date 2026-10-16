package bi;

import com.google.android.gms.internal.mlkit_vision_barcode.b1;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.MutablePeriod;
import org.joda.time.chrono.ISOChronology;

/* loaded from: classes2.dex */
public final class l extends b1 implements e, k {

    /* renamed from: b, reason: collision with root package name */
    public static final l f3273b = new l();

    @Override // bi.b
    public final Class e() {
        return org.joda.time.g.class;
    }

    @Override // bi.k
    public final void f(MutablePeriod mutablePeriod, Object obj, org.joda.time.a aVar) {
        org.joda.time.g gVar = (org.joda.time.g) obj;
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        if (aVar == null) {
            aVar = ISOChronology.getInstance();
        }
        int[] iArr = aVar.get(mutablePeriod, gVar.getMillis());
        for (int i3 = 0; i3 < iArr.length; i3++) {
            mutablePeriod.setValue(i3, iArr[i3]);
        }
    }

    @Override // bi.e
    public final long i(Object obj) {
        return ((org.joda.time.g) obj).getMillis();
    }
}
