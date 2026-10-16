package com.example.test.ui.view;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import android.view.Surface;
import androidx.camera.core.impl.CameraCaptureFailure$Reason;
import androidx.camera.core.impl.d0;
import androidx.camera.core.impl.s1;
import androidx.camera.core.impl.w1;
import com.example.test.utils.w0;
import com.example.test.utils.y;
import com.google.android.gms.internal.mlkit_vision_barcode.pd;
import com.google.android.gms.internal.mlkit_vision_common.a0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class b extends CameraCaptureSession.CaptureCallback {

    /* renamed from: a, reason: collision with root package name */
    public final /* synthetic */ int f8673a;

    /* renamed from: b, reason: collision with root package name */
    public final Object f8674b;

    public /* synthetic */ b(Object obj, int i3) {
        this.f8673a = i3;
        this.f8674b = obj;
    }

    public static int a(CaptureRequest captureRequest) {
        Integer num;
        if ((captureRequest.getTag() instanceof w1) && (num = (Integer) ((w1) captureRequest.getTag()).f1514a.get("CAPTURE_CONFIG_ID_KEY")) != null) {
            return num.intValue();
        }
        return -1;
    }

    public void b(CaptureResult captureResult) {
        CameraPreview cameraPreview = (CameraPreview) this.f8674b;
        int i3 = cameraPreview.f8348a;
        if (i3 != 1) {
            if (i3 == 2) {
                Integer num = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
                if (num == null || num.intValue() == 5 || num.intValue() == 4) {
                    cameraPreview.f8348a = 3;
                    return;
                }
                return;
            }
            if (i3 != 3) {
                return;
            }
            Integer num2 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
            if (num2 == null || num2.intValue() != 5) {
                cameraPreview.f8348a = 4;
                return;
            }
            return;
        }
        Integer num3 = (Integer) captureResult.get(CaptureResult.CONTROL_AF_STATE);
        if (num3 == null) {
            return;
        }
        if (4 == num3.intValue() || 5 == num3.intValue()) {
            Integer num4 = (Integer) captureResult.get(CaptureResult.CONTROL_AE_STATE);
            if (num4 == null || num4.intValue() == 2) {
                cameraPreview.f8348a = 4;
                return;
            }
            try {
                CaptureRequest.Key key = CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER;
                throw null;
            } catch (CameraAccessException e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureBufferLost(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, Surface surface, long j4) {
        switch (this.f8673a) {
            case 2:
                ArrayList arrayList = (ArrayList) this.f8674b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    int i10 = i3 + 1;
                    CaptureRequest captureRequest2 = captureRequest;
                    Surface surface2 = surface;
                    long j10 = j4;
                    ((CameraCaptureSession.CaptureCallback) arrayList.get(i3)).onCaptureBufferLost(cameraCaptureSession, captureRequest2, surface2, j10);
                    captureRequest = captureRequest2;
                    surface = surface2;
                    j4 = j10;
                    i3 = i10;
                }
                break;
            default:
                super.onCaptureBufferLost(cameraCaptureSession, captureRequest, surface, j4);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public final void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        w1 w1Var;
        switch (this.f8673a) {
            case 0:
                b(totalCaptureResult);
                return;
            case 1:
                ff.n nVar = (ff.n) this.f8674b;
                nVar.f13631a0 = totalCaptureResult;
                Iterator it = nVar.f13637g0.iterator();
                while (it.hasNext()) {
                    ((gf.e) it.next()).e(nVar, captureRequest, totalCaptureResult);
                }
                return;
            case 2:
                ArrayList arrayList = (ArrayList) this.f8674b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraCaptureSession.CaptureCallback) obj).onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                }
                return;
            case 3:
                super.onCaptureCompleted(cameraCaptureSession, captureRequest, totalCaptureResult);
                Object tag = captureRequest.getTag();
                if (tag != null) {
                    pd.a("The tagBundle object from the CaptureResult is not a TagBundle object.", tag instanceof w1);
                    w1Var = (w1) tag;
                } else {
                    w1Var = w1.f1513b;
                }
                ((androidx.camera.core.impl.k) this.f8674b).b(a(captureRequest), new y(w1Var, 26, totalCaptureResult, false));
                return;
            default:
                synchronized (((androidx.camera.camera2.internal.m) this.f8674b).f1267a) {
                    try {
                        s1 s1Var = ((androidx.camera.camera2.internal.m) this.f8674b).f1271f;
                        if (s1Var == null) {
                            return;
                        }
                        d0 d0Var = s1Var.f1490g;
                        a0.a("CaptureSession", "Submit FLASH_MODE_OFF request");
                        androidx.camera.camera2.internal.m mVar = (androidx.camera.camera2.internal.m) this.f8674b;
                        mVar.f1279n.getClass();
                        mVar.i(Collections.singletonList(w0.a(d0Var)));
                        return;
                    } finally {
                    }
                }
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureFailed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureFailure captureFailure) {
        switch (this.f8673a) {
            case 2:
                ArrayList arrayList = (ArrayList) this.f8674b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraCaptureSession.CaptureCallback) obj).onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                }
                break;
            case 3:
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                ((androidx.camera.core.impl.k) this.f8674b).c(a(captureRequest), new n9.e(CameraCaptureFailure$Reason.ERROR));
                break;
            default:
                super.onCaptureFailed(cameraCaptureSession, captureRequest, captureFailure);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureProgressed(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, CaptureResult captureResult) {
        switch (this.f8673a) {
            case 0:
                b(captureResult);
                break;
            case 1:
                ff.n nVar = (ff.n) this.f8674b;
                Iterator it = nVar.f13637g0.iterator();
                while (it.hasNext()) {
                    ((gf.e) it.next()).f(nVar, captureRequest, captureResult);
                }
                break;
            case 2:
                ArrayList arrayList = (ArrayList) this.f8674b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraCaptureSession.CaptureCallback) obj).onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                }
                break;
            default:
                super.onCaptureProgressed(cameraCaptureSession, captureRequest, captureResult);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceAborted(CameraCaptureSession cameraCaptureSession, int i3) {
        switch (this.f8673a) {
            case 2:
                ArrayList arrayList = (ArrayList) this.f8674b;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((CameraCaptureSession.CaptureCallback) obj).onCaptureSequenceAborted(cameraCaptureSession, i3);
                }
                break;
            default:
                super.onCaptureSequenceAborted(cameraCaptureSession, i3);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureSequenceCompleted(CameraCaptureSession cameraCaptureSession, int i3, long j4) {
        switch (this.f8673a) {
            case 2:
                ArrayList arrayList = (ArrayList) this.f8674b;
                int size = arrayList.size();
                int i10 = 0;
                while (i10 < size) {
                    Object obj = arrayList.get(i10);
                    i10++;
                    ((CameraCaptureSession.CaptureCallback) obj).onCaptureSequenceCompleted(cameraCaptureSession, i3, j4);
                }
                break;
            default:
                super.onCaptureSequenceCompleted(cameraCaptureSession, i3, j4);
                break;
        }
    }

    @Override // android.hardware.camera2.CameraCaptureSession.CaptureCallback
    public void onCaptureStarted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, long j4, long j10) {
        switch (this.f8673a) {
            case 1:
                ff.n nVar = (ff.n) this.f8674b;
                Iterator it = nVar.f13637g0.iterator();
                while (it.hasNext()) {
                    ((gf.e) it.next()).g(nVar, captureRequest);
                }
                break;
            case 2:
                ArrayList arrayList = (ArrayList) this.f8674b;
                int size = arrayList.size();
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayList.get(i3);
                    i3++;
                    ((CameraCaptureSession.CaptureCallback) obj).onCaptureStarted(cameraCaptureSession, captureRequest, j4, j10);
                }
                break;
            case 3:
                super.onCaptureStarted(cameraCaptureSession, captureRequest, j4, j10);
                ((androidx.camera.core.impl.k) this.f8674b).d(a(captureRequest));
                break;
            default:
                super.onCaptureStarted(cameraCaptureSession, captureRequest, j4, j10);
                break;
        }
    }

    public b(androidx.camera.core.impl.k kVar) {
        this.f8673a = 3;
        if (kVar == null) {
            throw new NullPointerException("cameraCaptureCallback is null");
        }
        this.f8674b = kVar;
    }

    public b(List list) {
        this.f8673a = 2;
        this.f8674b = new ArrayList();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            CameraCaptureSession.CaptureCallback captureCallback = (CameraCaptureSession.CaptureCallback) it.next();
            if (!(captureCallback instanceof n.p)) {
                ((ArrayList) this.f8674b).add(captureCallback);
            }
        }
    }
}
