package o;

import android.hardware.camera2.params.DynamicRangeProfiles;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import java.util.Collections;
import java.util.Set;
import n.m0;
import t.t;

/* loaded from: classes.dex */
public final class d implements b {

    /* renamed from: a, reason: collision with root package name */
    public static final m0 f16619a = new m0(new d(), 3);

    /* renamed from: b, reason: collision with root package name */
    public static final Set f16620b = Collections.singleton(t.f18406d);

    @Override // o.b
    public final DynamicRangeProfiles a() {
        return null;
    }

    @Override // o.b
    public final Set b() {
        return f16620b;
    }

    @Override // o.b
    public final Set c(t tVar) {
        pd.a("DynamicRange is not supported: " + tVar, t.f18406d.equals(tVar));
        return f16620b;
    }
}
