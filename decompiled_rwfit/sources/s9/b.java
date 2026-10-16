package s9;

import com.example.test.utils.y;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.f;
import com.google.android.gms.common.internal.TelemetryData;
import eb.e;
import ia.m;
import o9.j;

/* loaded from: classes.dex */
public final class b extends f {

    /* renamed from: i, reason: collision with root package name */
    public static final y f18216i = new y("ClientTelemetry.API", new ga.b(2), new e(6));

    public final m c(TelemetryData telemetryData) {
        j jVar = new j();
        jVar.f16866c = 0;
        jVar.f16864a = new Feature[]{da.b.f12310a};
        jVar.f16865b = false;
        jVar.f16867d = new n6.a(telemetryData, 14);
        return b(2, jVar.a());
    }
}
