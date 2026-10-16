package g0;

import androidx.camera.core.impl.CameraCaptureMetaData$AeState;
import androidx.camera.core.impl.CameraCaptureMetaData$AfState;
import androidx.camera.core.impl.CameraCaptureMetaData$AwbState;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.w1;

/* loaded from: classes.dex */
public final class i implements n {

    /* renamed from: a, reason: collision with root package name */
    public final n f13784a;

    /* renamed from: b, reason: collision with root package name */
    public final w1 f13785b;

    /* renamed from: c, reason: collision with root package name */
    public final long f13786c;

    public i(n nVar, w1 w1Var, long j4) {
        this.f13784a = nVar;
        this.f13785b = w1Var;
        this.f13786c = j4;
    }

    @Override // androidx.camera.core.impl.n
    public final w1 a() {
        return this.f13785b;
    }

    @Override // androidx.camera.core.impl.n
    public final long d() {
        n nVar = this.f13784a;
        if (nVar != null) {
            return nVar.d();
        }
        long j4 = this.f13786c;
        if (j4 != -1) {
            return j4;
        }
        throw new IllegalStateException("No timestamp is available.");
    }

    @Override // androidx.camera.core.impl.n
    public final CameraCaptureMetaData$AeState g() {
        n nVar = this.f13784a;
        return nVar != null ? nVar.g() : CameraCaptureMetaData$AeState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.n
    public final CameraCaptureMetaData$AwbState h() {
        n nVar = this.f13784a;
        return nVar != null ? nVar.h() : CameraCaptureMetaData$AwbState.UNKNOWN;
    }

    @Override // androidx.camera.core.impl.n
    public final CameraCaptureMetaData$AfState k() {
        n nVar = this.f13784a;
        return nVar != null ? nVar.k() : CameraCaptureMetaData$AfState.UNKNOWN;
    }
}
