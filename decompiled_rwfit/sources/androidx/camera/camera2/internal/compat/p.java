package androidx.camera.camera2.internal.compat;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.os.Handler;
import android.util.ArrayMap;
import android.view.Surface;
import androidx.appcompat.app.i0;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.d1;
import androidx.camera.core.impl.i1;
import androidx.camera.core.impl.s0;
import androidx.camera.core.impl.s1;
import androidx.camera.core.impl.w1;
import androidx.camera.core.impl.x0;
import androidx.camera.core.impl.z0;
import com.autonavi.amap.mapcore.tools.GlMapUtil;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import com.google.android.gms.internal.mlkit_vision_common.a6;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.engine.offset.Reference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Objects;
import n.g0;
import n.n0;

/* loaded from: classes.dex */
public final class p extends CameraDevice.StateCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1184a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f1185b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1186c;

    public /* synthetic */ p(int i3, Object obj, Object obj2) {
        this.f1184a = i3;
        this.f1186c = obj;
        this.f1185b = obj2;
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public void onClosed(CameraDevice cameraDevice) {
        switch (this.f1184a) {
            case 0:
                ((androidx.camera.core.impl.utils.executor.b) this.f1186c).execute(new o(this, cameraDevice, 0));
                break;
            case 1:
            default:
                super.onClosed(cameraDevice);
                break;
            case 2:
                ((androidx.camera.camera2.internal.i) this.f1186c).s("openCameraConfigAndClose camera closed", null);
                ((androidx.concurrent.futures.b) this.f1185b).a(null);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onDisconnected(CameraDevice cameraDevice) {
        switch (this.f1184a) {
            case 0:
                ((androidx.camera.core.impl.utils.executor.b) this.f1186c).execute(new o(this, cameraDevice, 1));
                return;
            case 1:
                CameraException cameraException = new CameraException(3);
                ia.g gVar = (ia.g) this.f1185b;
                if (gVar.f14382a.e()) {
                    ff.q.T.b(1, "CameraDevice.StateCallback reported disconnection.");
                    throw cameraException;
                }
                gVar.b(cameraException);
                return;
            default:
                ((androidx.camera.camera2.internal.i) this.f1186c).s("openCameraConfigAndClose camera disconnected", null);
                ((androidx.concurrent.futures.b) this.f1185b).a(null);
                return;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onError(CameraDevice cameraDevice, int i3) {
        switch (this.f1184a) {
            case 0:
                ((androidx.camera.core.impl.utils.executor.b) this.f1186c).execute(new e(this, cameraDevice, i3, 1));
                return;
            case 1:
                ia.g gVar = (ia.g) this.f1185b;
                if (gVar.f14382a.e()) {
                    ff.q.T.b(3, "CameraDevice.StateCallback reported an error:", Integer.valueOf(i3));
                    throw new CameraException(3);
                }
                ((ff.n) this.f1186c).getClass();
                int i10 = 1;
                if (i3 != 1 && i3 != 2 && i3 != 3 && i3 != 4 && i3 != 5) {
                    i10 = 0;
                }
                gVar.b(new CameraException(i10));
                return;
            default:
                ((androidx.camera.camera2.internal.i) this.f1186c).s("openCameraConfigAndClose camera error " + i3, null);
                ((androidx.concurrent.futures.b) this.f1185b).a(null);
                return;
        }
    }

    @Override // android.hardware.camera2.CameraDevice.StateCallback
    public final void onOpened(CameraDevice cameraDevice) {
        int i3;
        Object obj = this.f1186c;
        switch (this.f1184a) {
            case 0:
                ((androidx.camera.core.impl.utils.executor.b) obj).execute(new o(this, cameraDevice, 2));
                return;
            case 1:
                ia.g gVar = (ia.g) this.f1185b;
                ff.n nVar = (ff.n) obj;
                nVar.W = cameraDevice;
                CameraManager cameraManager = nVar.U;
                try {
                    ff.q.T.b(1, "onStartEngine:", "Opened camera device.");
                    nVar.X = cameraManager.getCameraCharacteristics(nVar.V);
                    boolean b3 = nVar.B.b(Reference.SENSOR, Reference.VIEW);
                    int i10 = ff.k.f13623a[nVar.r.ordinal()];
                    if (i10 == 1) {
                        i3 = 256;
                    } else {
                        if (i10 != 2) {
                            throw new IllegalArgumentException("Unknown format:" + nVar.r);
                        }
                        i3 = 32;
                    }
                    nVar.f13649f = new mf.a(cameraManager, nVar.V, b3, i3);
                    CaptureRequest.Builder builder = nVar.Z;
                    CaptureRequest.Builder createCaptureRequest = nVar.W.createCaptureRequest(1);
                    nVar.Z = createCaptureRequest;
                    createCaptureRequest.setTag(1);
                    nVar.S(nVar.Z, builder);
                    CaptureRequest.Builder builder2 = nVar.Z;
                    gVar.f14382a.j(nVar.f13649f);
                    return;
                } catch (CameraAccessException e) {
                    gVar.b(ff.n.c0(e));
                    return;
                }
            default:
                androidx.camera.camera2.internal.i iVar = (androidx.camera.camera2.internal.i) obj;
                iVar.s("openCameraConfigAndClose camera opened", null);
                androidx.camera.camera2.internal.m mVar = new androidx.camera.camera2.internal.m(iVar.F, new i1(Collections.EMPTY_LIST), false);
                SurfaceTexture surfaceTexture = new SurfaceTexture(0);
                surfaceTexture.setDefaultBufferSize(GlMapUtil.DEVICE_DISPLAY_DPI_XXHIGH, GlMapUtil.DEVICE_DISPLAY_DPI_XHIGH);
                Surface surface = new Surface(surfaceTexture);
                s0 s0Var = new s0(surface);
                x.i.d(s0Var.e).a(new i0(25, surface, surfaceTexture), a6.a());
                LinkedHashSet linkedHashSet = new LinkedHashSet();
                HashSet hashSet = new HashSet();
                x0 f2 = x0.f();
                ArrayList arrayList = new ArrayList();
                z0 a3 = z0.a();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                ArrayList arrayList4 = new ArrayList();
                t.t tVar = t.t.f18406d;
                androidx.camera.core.impl.e a10 = androidx.camera.core.impl.f.a(s0Var);
                a10.f1377b = tVar;
                linkedHashSet.add(a10.a());
                iVar.s("Start configAndClose.", null);
                ArrayList arrayList5 = new ArrayList(linkedHashSet);
                ArrayList arrayList6 = new ArrayList(arrayList2);
                ArrayList arrayList7 = new ArrayList(arrayList3);
                ArrayList arrayList8 = new ArrayList(arrayList4);
                ArrayList arrayList9 = new ArrayList(hashSet);
                d1 a11 = d1.a(f2);
                ArrayList arrayList10 = new ArrayList(arrayList);
                w1 w1Var = w1.f1513b;
                ArrayMap arrayMap = new ArrayMap();
                ArrayMap arrayMap2 = a3.f1514a;
                for (String str : arrayMap2.keySet()) {
                    arrayMap.put(str, arrayMap2.get(str));
                }
                s1 s1Var = new s1(arrayList5, arrayList6, arrayList7, arrayList8, new d0(arrayList9, a11, 1, arrayList10, false, new w1(arrayMap), null), null, null, null);
                g0 g0Var = iVar.f1261z;
                w.c cVar = (w.c) g0Var.f16175b;
                x.d b10 = x.d.b(ve.a(new x.g(mVar.k(s1Var, cameraDevice, new n0((i1) g0Var.e, (i1) g0Var.f16178f, (g0) g0Var.f16177d, (androidx.camera.core.impl.utils.executor.b) g0Var.f16174a, cVar, (Handler) g0Var.f16176c)), 0)));
                c0.b bVar = new c0.b(12, mVar, s0Var);
                b10.getClass();
                androidx.camera.core.impl.utils.executor.b bVar2 = iVar.f1240c;
                x.b f10 = x.i.f(b10, bVar, bVar2);
                Objects.requireNonNull(cameraDevice);
                f10.a(new m5.a(cameraDevice, 2), bVar2);
                return;
        }
    }

    public p(androidx.camera.core.impl.utils.executor.b bVar, CameraDevice.StateCallback stateCallback) {
        this.f1184a = 0;
        this.f1186c = bVar;
        this.f1185b = stateCallback;
    }
}
