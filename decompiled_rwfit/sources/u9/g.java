package u9;

import android.os.IBinder;
import android.os.IInterface;
import com.google.android.gms.common.Feature;

/* loaded from: classes.dex */
public final class g extends com.google.android.gms.common.internal.a {
    @Override // com.google.android.gms.common.internal.a
    public final IInterface a(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.moduleinstall.internal.IModuleInstallService");
        return queryLocalInterface instanceof d ? (d) queryLocalInterface : new d(iBinder, "com.google.android.gms.common.moduleinstall.internal.IModuleInstallService", 1);
    }

    @Override // com.google.android.gms.common.api.c
    public final int g() {
        return 17895000;
    }

    @Override // com.google.android.gms.common.internal.a
    public final Feature[] o() {
        return da.b.f12313d;
    }

    @Override // com.google.android.gms.common.internal.a
    public final String r() {
        return "com.google.android.gms.common.moduleinstall.internal.IModuleInstallService";
    }

    @Override // com.google.android.gms.common.internal.a
    public final String s() {
        return "com.google.android.gms.chimera.container.moduleinstall.ModuleInstallService.START";
    }

    @Override // com.google.android.gms.common.internal.a
    public final boolean t() {
        return true;
    }
}
