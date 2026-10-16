package u9;

import android.os.Parcel;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;
import com.google.android.gms.internal.mlkit_vision_barcode.kf;

/* loaded from: classes.dex */
public final class e extends com.google.android.gms.internal.mlkit_vision_barcode.g implements c {

    /* renamed from: b, reason: collision with root package name */
    public final /* synthetic */ int f19025b;

    /* renamed from: c, reason: collision with root package name */
    public final /* synthetic */ ia.g f19026c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e(ia.g gVar, int i3) {
        super("com.google.android.gms.common.moduleinstall.internal.IModuleInstallCallbacks", 1);
        this.f19025b = i3;
        this.f19026c = gVar;
    }

    @Override // u9.c
    public void e(Status status, ModuleInstallResponse moduleInstallResponse) {
        switch (this.f19025b) {
            case 1:
                kf.a(status, moduleInstallResponse, this.f19026c);
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // u9.c
    public void f(Status status, ModuleAvailabilityResponse moduleAvailabilityResponse) {
        switch (this.f19025b) {
            case 0:
                kf.a(status, moduleAvailabilityResponse, this.f19026c);
                return;
            default:
                throw new UnsupportedOperationException();
        }
    }

    @Override // com.google.android.gms.internal.mlkit_vision_barcode.g
    public final boolean y(int i3, Parcel parcel, Parcel parcel2) {
        if (i3 == 1) {
            Status status = (Status) da.a.a(parcel, Status.CREATOR);
            ModuleAvailabilityResponse moduleAvailabilityResponse = (ModuleAvailabilityResponse) da.a.a(parcel, ModuleAvailabilityResponse.CREATOR);
            da.a.b(parcel);
            f(status, moduleAvailabilityResponse);
            return true;
        }
        if (i3 == 2) {
            Status status2 = (Status) da.a.a(parcel, Status.CREATOR);
            ModuleInstallResponse moduleInstallResponse = (ModuleInstallResponse) da.a.a(parcel, ModuleInstallResponse.CREATOR);
            da.a.b(parcel);
            e(status2, moduleInstallResponse);
            return true;
        }
        if (i3 == 3) {
            da.a.b(parcel);
            throw new UnsupportedOperationException();
        }
        if (i3 != 4) {
            return false;
        }
        da.a.b(parcel);
        throw new UnsupportedOperationException();
    }
}
