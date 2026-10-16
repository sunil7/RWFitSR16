package o;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.OutputConfiguration;
import android.hardware.camera2.params.SessionConfiguration;
import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.Executor;
import n.t;

/* loaded from: classes.dex */
public final class n implements p {

    /* renamed from: a, reason: collision with root package name */
    public final SessionConfiguration f16630a;

    /* renamed from: b, reason: collision with root package name */
    public final List f16631b;

    public n(ArrayList arrayList, androidx.camera.core.impl.utils.executor.b bVar, t tVar) {
        h hVar;
        SessionConfiguration sessionConfiguration = new SessionConfiguration(0, q.a(arrayList), bVar, tVar);
        this.f16630a = sessionConfiguration;
        List<OutputConfiguration> outputConfigurations = sessionConfiguration.getOutputConfigurations();
        ArrayList arrayList2 = new ArrayList(outputConfigurations.size());
        for (OutputConfiguration outputConfiguration : outputConfigurations) {
            if (outputConfiguration == null) {
                hVar = null;
            } else {
                int i3 = Build.VERSION.SDK_INT;
                hVar = new h(i3 >= 33 ? new m(outputConfiguration) : i3 >= 28 ? new l(new k(outputConfiguration)) : new j(new i(outputConfiguration)));
            }
            arrayList2.add(hVar);
        }
        this.f16631b = Collections.unmodifiableList(arrayList2);
    }

    @Override // o.p
    public final Object a() {
        return this.f16630a;
    }

    @Override // o.p
    public final void b(g gVar) {
        this.f16630a.setInputConfiguration(gVar.f16622a.f16621a);
    }

    @Override // o.p
    public final int c() {
        return this.f16630a.getSessionType();
    }

    @Override // o.p
    public final CameraCaptureSession.StateCallback d() {
        return this.f16630a.getStateCallback();
    }

    @Override // o.p
    public final List e() {
        return this.f16631b;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof n) {
            return Objects.equals(this.f16630a, ((n) obj).f16630a);
        }
        return false;
    }

    @Override // o.p
    public final g f() {
        return g.a(this.f16630a.getInputConfiguration());
    }

    @Override // o.p
    public final Executor g() {
        return this.f16630a.getExecutor();
    }

    @Override // o.p
    public final void h(CaptureRequest captureRequest) {
        this.f16630a.setSessionParameters(captureRequest);
    }

    public final int hashCode() {
        return this.f16630a.hashCode();
    }
}
