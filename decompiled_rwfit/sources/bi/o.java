package bi;

import com.google.android.gms.internal.mlkit_vision_barcode.b1;
import org.joda.time.MutablePeriod;
import org.joda.time.PeriodType;

/* loaded from: classes2.dex */
public final class o extends b1 implements k {

    /* renamed from: b, reason: collision with root package name */
    public static final o f3276b = new o();

    @Override // bi.b
    public final Class e() {
        return org.joda.time.k.class;
    }

    @Override // bi.k
    public final void f(MutablePeriod mutablePeriod, Object obj, org.joda.time.a aVar) {
        mutablePeriod.setPeriod((org.joda.time.k) obj);
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b1, bi.k
    public final PeriodType h(Object obj) {
        return ((org.joda.time.k) obj).getPeriodType();
    }
}
