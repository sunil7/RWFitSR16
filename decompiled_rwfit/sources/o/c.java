package o;

import android.hardware.camera2.params.DynamicRangeProfiles;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import t.t;

/* loaded from: classes.dex */
public final class c implements b {

    /* renamed from: a, reason: collision with root package name */
    public final DynamicRangeProfiles f16618a;

    public c(Object obj) {
        this.f16618a = (DynamicRangeProfiles) obj;
    }

    public static Set d(Set set) {
        if (set.isEmpty()) {
            return Collections.EMPTY_SET;
        }
        HashSet hashSet = new HashSet(set.size());
        Iterator it = set.iterator();
        while (it.hasNext()) {
            Long l3 = (Long) it.next();
            long longValue = l3.longValue();
            t tVar = (t) a.f16616a.get(l3);
            pd.e(tVar, "Dynamic range profile cannot be converted to a DynamicRange object: " + longValue);
            hashSet.add(tVar);
        }
        return Collections.unmodifiableSet(hashSet);
    }

    @Override // o.b
    public final DynamicRangeProfiles a() {
        return this.f16618a;
    }

    @Override // o.b
    public final Set b() {
        return d(this.f16618a.getSupportedProfiles());
    }

    @Override // o.b
    public final Set c(t tVar) {
        Long a3 = a.a(tVar, this.f16618a);
        pd.a("DynamicRange is not supported: " + tVar, a3 != null);
        return d(this.f16618a.getProfileCaptureRequestConstraints(a3.longValue()));
    }
}
