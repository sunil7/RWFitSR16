package androidx.camera.camera2.internal.compat;

import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.appcompat.app.i0;
import com.google.android.gms.internal.mlkit_vision_barcode.ve;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class f extends CameraCaptureSession.CaptureCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f1163a;

    /* renamed from: b, reason: collision with root package name */
    public Object f1164b;

    /* renamed from: c, reason: collision with root package name */
    public final Object f1165c;

    public f(int i3) {
        this.f1163a = i3;
        switch (i3) {
            case 3:
                this.f1165c = ve.a(new af.a(this, 24));
                break;
            default:
                this.f1164b = null;
                this.f1165c = new HashMap();
                break;
        }
    }

    public void a(CaptureRequest captureRequest, List list) {
        HashMap hashMap = (HashMap) this.f1165c;
        List list2 = (List) hashMap.get(captureRequest);
        if (list2 == null) {
            hashMap.put(captureRequest, list);
            return;
        }
        ArrayList arrayList = new ArrayList(list2.size() + list.size());
        arrayList.addAll(list);
        arrayList.addAll(list2);
        hashMap.put(captureRequest, arrayList);
    }

    public void b() {
        androidx.concurrent.futures.b bVar = (androidx.concurrent.futures.b) this.f1164b;
        if (bVar != null) {
            bVar.a(null);
            this.f1164b = null;
        }
    }

    public List c(CaptureRequest captureRequest) {
        List list = (List) ((HashMap) this.f1165c).get(captureRequest);
        return list != null ? list : Collections.EMPTY_LIST;
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureBufferLost(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final Surface surface, final long j4) {
        switch (this.f1163a) {
            case 0:
                ((androidx.camera.core.impl.utils.executor.b) this.f1164b).execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.d
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((CameraCaptureSession.CaptureCallback) f.this.f1165c).onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j4);
                    }
                });
                break;
            case 1:
            default:
                super.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j4);
                break;
            case 2:
                Iterator it = c(captureRequest).iterator();
                while (it.hasNext()) {
                    CameraCaptureSession cameraCaptureSession2 = cameraCaptureSession;
                    CaptureRequest captureRequest2 = captureRequest;
                    Surface surface2 = surface;
                    long j10 = j4;
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureBufferLost(cameraCaptureSession2, captureRequest2, surface2, j10);
                    cameraCaptureSession = cameraCaptureSession2;
                    captureRequest = captureRequest2;
                    surface = surface2;
                    j4 = j10;
                }
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        switch (this.f1163a) {
            case 0:
                ((androidx.camera.core.impl.utils.executor.b) this.f1164b).execute(new b(this, cameraCaptureSession, captureRequest, totalCaptureResult, 0));
                break;
            case 1:
                ((androidx.camera.core.impl.utils.executor.b) this.f1164b).execute(new i0(23, this, totalCaptureResult));
                break;
            case 2:
                Iterator it = c(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                }
                break;
            default:
                b();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        switch (this.f1163a) {
            case 0:
                ((androidx.camera.core.impl.utils.executor.b) this.f1164b).execute(new b(this, cameraCaptureSession, captureRequest, captureFailure, 2));
                break;
            case 1:
            default:
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                break;
            case 2:
                Iterator it = c(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                }
                break;
            case 3:
                b();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        switch (this.f1163a) {
            case 0:
                ((androidx.camera.core.impl.utils.executor.b) this.f1164b).execute(new b(this, cameraCaptureSession, captureRequest, captureResult, 1));
                break;
            case 1:
            default:
                super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                break;
            case 2:
                Iterator it = c(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                }
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i3) {
        switch (this.f1163a) {
            case 0:
                ((androidx.camera.core.impl.utils.executor.b) this.f1164b).execute(new e(this, cameraCaptureSession, i3, 0));
                break;
            case 1:
            default:
                super.onCaptureSequenceAborted(cameraCaptureSession, i3);
                break;
            case 2:
                Iterator it = ((HashMap) this.f1165c).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((List) it.next()).iterator();
                    while (it2.hasNext()) {
                        ((CameraCaptureSession.CaptureCallback) it2.next()).onCaptureSequenceAborted(cameraCaptureSession, i3);
                    }
                }
                androidx.camera.camera2.internal.k kVar = (androidx.camera.camera2.internal.k) this.f1164b;
                if (kVar != null) {
                    kVar.a();
                    break;
                }
                break;
            case 3:
                b();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceCompleted(final CameraCaptureSession cameraCaptureSession, final int i3, final long j4) {
        switch (this.f1163a) {
            case 0:
                ((androidx.camera.core.impl.utils.executor.b) this.f1164b).execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.c
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((CameraCaptureSession.CaptureCallback) f.this.f1165c).onCaptureSequenceCompleted(cameraCaptureSession, i3, j4);
                    }
                });
                break;
            case 1:
            default:
                super.onCaptureSequenceCompleted(cameraCaptureSession, i3, j4);
                break;
            case 2:
                Iterator it = ((HashMap) this.f1165c).values().iterator();
                while (it.hasNext()) {
                    Iterator it2 = ((List) it.next()).iterator();
                    while (it2.hasNext()) {
                        ((CameraCaptureSession.CaptureCallback) it2.next()).onCaptureSequenceCompleted(cameraCaptureSession, i3, j4);
                    }
                }
                androidx.camera.camera2.internal.k kVar = (androidx.camera.camera2.internal.k) this.f1164b;
                if (kVar != null) {
                    kVar.a();
                    break;
                }
                break;
            case 3:
                b();
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(final CameraCaptureSession cameraCaptureSession, final CaptureRequest captureRequest, final long j4, final long j10) {
        switch (this.f1163a) {
            case 0:
                ((androidx.camera.core.impl.utils.executor.b) this.f1164b).execute(new Runnable() { // from class: androidx.camera.camera2.internal.compat.a
                    @Override // java.lang.Runnable
                    public final void run() {
                        ((CameraCaptureSession.CaptureCallback) f.this.f1165c).onCaptureStarted(cameraCaptureSession, captureRequest, j4, j10);
                    }
                });
                break;
            case 1:
            default:
                super.onCaptureStarted(cameraCaptureSession, captureRequest, j4, j10);
                break;
            case 2:
                Iterator it = c(captureRequest).iterator();
                while (it.hasNext()) {
                    ((CameraCaptureSession.CaptureCallback) it.next()).onCaptureStarted(cameraCaptureSession, captureRequest, j4, j10);
                }
                break;
            case 3:
                b();
                break;
        }
    }

    public f(androidx.camera.core.impl.utils.executor.b bVar, CameraCaptureSession.CaptureCallback captureCallback) {
        this.f1163a = 0;
        this.f1164b = bVar;
        this.f1165c = captureCallback;
    }

    public f(androidx.camera.core.impl.utils.executor.b bVar) {
        this.f1163a = 1;
        this.f1165c = new HashSet();
        this.f1164b = bVar;
    }
}
