package u9;

import com.example.test.utils.y;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.j;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.internal.ApiFeatureRequest;
import com.google.android.gms.internal.mlkit_vision_barcode.xc;
import ia.m;
import java.util.Arrays;
import q9.n;

/* loaded from: classes.dex */
public final class f extends com.google.android.gms.common.api.f {

    /* renamed from: i, reason: collision with root package name */
    public static final y f19027i = new y("ModuleInstall.API", new ga.b(3), new eb.e(6));

    public final m c(j... jVarArr) {
        n.a("Please provide at least one OptionalModuleApi.", jVarArr.length > 0);
        for (j jVar : jVarArr) {
            n.f(jVar, "Requested API must not be null.");
        }
        ApiFeatureRequest h4 = ApiFeatureRequest.h(Arrays.asList(jVarArr), false);
        if (h4.b().isEmpty()) {
            return xc.c(new ModuleAvailabilityResponse(true, 0));
        }
        o9.j jVar2 = new o9.j();
        jVar2.f16864a = new Feature[]{da.b.f12312c};
        jVar2.f16866c = 27301;
        jVar2.f16865b = false;
        jVar2.f16867d = new mc.g(this, h4);
        return b(0, jVar2.a());
    }
}
