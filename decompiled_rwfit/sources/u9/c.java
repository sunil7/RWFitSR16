package u9;

import android.os.IInterface;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.moduleinstall.ModuleAvailabilityResponse;
import com.google.android.gms.common.moduleinstall.ModuleInstallResponse;

/* loaded from: classes.dex */
public interface c extends IInterface {
    void e(Status status, ModuleInstallResponse moduleInstallResponse);

    void f(Status status, ModuleAvailabilityResponse moduleAvailabilityResponse);
}
