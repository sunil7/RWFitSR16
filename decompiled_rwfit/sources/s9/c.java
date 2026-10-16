package s9;

import android.content.Context;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.h;
import n.g0;
import o9.n;
import q9.f;

/* loaded from: classes.dex */
public final class c extends com.google.android.gms.common.internal.a {

    /* renamed from: y, reason: collision with root package name */
    public final f f18217y;

    public c(Context context, Looper looper, g0 g0Var, f fVar, n nVar, h hVar) {
        super(context, looper, SubsamplingScaleImageView.ORIENTATION_270, g0Var, nVar, hVar);
        this.f18217y = fVar;
    }

    @Override // com.google.android.gms.common.internal.a
    public final IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.service.IClientTelemetryService");
        return queryLocalInterface instanceof a ? (a) queryLocalInterface : new a(iBinder, "com.google.android.gms.common.internal.service.IClientTelemetryService", 1);
    }

    @Override // com.google.android.gms.common.api.c
    public final int g() {
        return 203400000;
    }

    @Override // com.google.android.gms.common.internal.a
    public final Feature[] o() {
        return da.b.f12311b;
    }

    @Override // com.google.android.gms.common.internal.a
    public final Bundle p() {
        f fVar = this.f18217y;
        fVar.getClass();
        Bundle bundle = new Bundle();
        String str = fVar.f17816a;
        if (str != null) {
            bundle.putString("api", str);
        }
        return bundle;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String r() {
        return "com.google.android.gms.common.internal.service.IClientTelemetryService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String s() {
        return "com.google.android.gms.common.telemetry.service.START";
    }

    @Override // com.google.android.gms.common.internal.a
    public final boolean t() {
        return true;
    }
}
