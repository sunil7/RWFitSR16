package h0;

import android.util.ArrayMap;
import androidx.camera.core.impl.n;
import androidx.camera.core.impl.u;
import b1.m;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import java.util.HashSet;
import java.util.Iterator;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;

/* loaded from: classes.dex */
public final class c extends androidx.camera.core.impl.k {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f14216a = 1;

    /* renamed from: b, reason: collision with root package name */
    public Object f14217b;

    /* renamed from: c, reason: collision with root package name */
    public Object f14218c;

    public /* synthetic */ c() {
    }

    @Override // androidx.camera.core.impl.k
    public void a(int i3) {
        switch (this.f14216a) {
            case 1:
                Iterator it = ((HashSet) this.f14217b).iterator();
                while (it.hasNext()) {
                    androidx.camera.core.impl.k kVar = (androidx.camera.core.impl.k) it.next();
                    try {
                        ((Executor) ((ArrayMap) this.f14218c).get(kVar)).execute(new m(i3, 2, kVar));
                    } catch (RejectedExecutionException e) {
                        a0.c("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCancelled.", e);
                    }
                }
                break;
        }
    }

    @Override // androidx.camera.core.impl.k
    public final void b(int i3, n nVar) {
        switch (this.f14216a) {
            case 0:
                ((androidx.concurrent.futures.b) this.f14217b).a(null);
                ((u) this.f14218c).n(this);
                break;
            default:
                Iterator it = ((HashSet) this.f14217b).iterator();
                while (it.hasNext()) {
                    androidx.camera.core.impl.k kVar = (androidx.camera.core.impl.k) it.next();
                    try {
                        ((Executor) ((ArrayMap) this.f14218c).get(kVar)).execute(new androidx.camera.camera2.internal.compat.e(kVar, i3, nVar, 3));
                    } catch (RejectedExecutionException e) {
                        a0.c("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCompleted.", e);
                    }
                }
                break;
        }
    }

    @Override // androidx.camera.core.impl.k
    public void c(int i3, n9.e eVar) {
        switch (this.f14216a) {
            case 1:
                Iterator it = ((HashSet) this.f14217b).iterator();
                while (it.hasNext()) {
                    androidx.camera.core.impl.k kVar = (androidx.camera.core.impl.k) it.next();
                    try {
                        ((Executor) ((ArrayMap) this.f14218c).get(kVar)).execute(new androidx.camera.camera2.internal.compat.e(kVar, i3, eVar, 2));
                    } catch (RejectedExecutionException e) {
                        a0.c("Camera2CameraControlImp", "Executor rejected to invoke onCaptureFailed.", e);
                    }
                }
                break;
        }
    }

    public c(androidx.concurrent.futures.b bVar, u uVar) {
        this.f14217b = bVar;
        this.f14218c = uVar;
    }
}
