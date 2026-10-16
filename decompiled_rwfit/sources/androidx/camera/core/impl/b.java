package androidx.camera.core.impl;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: classes.dex */
public final class b {

    /* renamed from: a, reason: collision with root package name */
    public final Executor f1348a;

    /* renamed from: b, reason: collision with root package name */
    public final Handler f1349b;

    public b(Executor executor, Handler handler) {
        if (executor == null) {
            throw new NullPointerException("Null cameraExecutor");
        }
        this.f1348a = executor;
        if (handler == null) {
            throw new NullPointerException("Null schedulerHandler");
        }
        this.f1349b = handler;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof b) {
            b bVar = (b) obj;
            if (this.f1348a.equals(bVar.f1348a) && this.f1349b.equals(bVar.f1349b)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((this.f1348a.hashCode() ^ 1000003) * 1000003) ^ this.f1349b.hashCode();
    }

    public final String toString() {
        return "CameraThreadConfig{cameraExecutor=" + this.f1348a + ", schedulerHandler=" + this.f1349b + "}";
    }
}
