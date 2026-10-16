package bi;

import com.google.android.gms.internal.mlkit_vision_barcode.b1;
import java.util.concurrent.atomic.AtomicReference;
import org.joda.time.DateTimeZone;
import org.joda.time.chrono.ISOChronology;

/* loaded from: classes2.dex */
public final class n extends b1 implements j {

    /* renamed from: b, reason: collision with root package name */
    public static final n f3275b = new n();

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b1, bi.f, bi.j
    public final org.joda.time.a a(Object obj, org.joda.time.a aVar) {
        if (aVar != null) {
            return aVar;
        }
        org.joda.time.a chronology = ((org.joda.time.j) obj).getChronology();
        AtomicReference atomicReference = org.joda.time.c.f17022a;
        return chronology == null ? ISOChronology.getInstance() : chronology;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b1, bi.f, bi.j
    public final org.joda.time.a b(Object obj, DateTimeZone dateTimeZone) {
        return a(obj, null).withZone(dateTimeZone);
    }

    @Override // bi.b
    public final Class e() {
        return org.joda.time.j.class;
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.b1, bi.j
    public final int[] j(ai.e eVar, Object obj, org.joda.time.a aVar) {
        org.joda.time.j jVar = (org.joda.time.j) obj;
        int size = eVar.size();
        int[] iArr = new int[size];
        for (int i3 = 0; i3 < size; i3++) {
            iArr[i3] = jVar.get(eVar.getFieldType(i3));
        }
        aVar.validate(eVar, iArr);
        return iArr;
    }
}
