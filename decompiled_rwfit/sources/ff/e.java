package ff;

import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.location.Location;
import android.view.SurfaceHolder;
import androidx.camera.core.impl.y0;
import com.google.android.gms.internal.mlkit_vision_barcode.wf;
import com.google.android.gms.internal.mlkit_vision_barcode.xc;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.offset.Axis;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.gesture.Gesture;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: classes2.dex */
public final class e extends q implements Camera.PreviewCallback, Camera.ErrorCallback {
    public final p001if.a U;
    public Camera V;
    public int W;

    public e(ef.i iVar) {
        super(iVar);
        if (p001if.a.f14421a == null) {
            p001if.a.f14421a = new p001if.a();
        }
        this.U = p001if.a.f14421a;
    }

    @Override // ff.q
    public final void B(float f2, float[] fArr, PointF[] pointFArr, boolean z5) {
        float f10 = this.f13663u;
        this.f13663u = f2;
        nf.e eVar = this.f13648d;
        eVar.e(20, "exposure correction");
        eVar.d("exposure correction", CameraState.ENGINE, new c(this, f10, z5, fArr, pointFArr));
    }

    @Override // ff.q
    public final void C(Flash flash) {
        Flash flash2 = this.f13656m;
        this.f13656m = flash;
        this.f13648d.d("flash (" + flash + ")", CameraState.ENGINE, new x.h(this, 15, flash2, false));
    }

    @Override // ff.q
    public final void D(int i3) {
        this.f13654k = 17;
    }

    @Override // ff.q
    public final void E(boolean z5) {
        this.f13655l = z5;
    }

    @Override // ff.q
    public final void F(Hdr hdr) {
        Hdr hdr2 = this.f13660q;
        this.f13660q = hdr;
        this.f13648d.d("hdr (" + hdr + ")", CameraState.ENGINE, new x.h(this, 17, hdr2, false));
    }

    @Override // ff.q
    public final void G(Location location) {
        Location location2 = this.f13661s;
        this.f13661s = location;
        this.f13648d.d("location", CameraState.ENGINE, new androidx.activity.e(this, location2));
    }

    @Override // ff.q
    public final void H(PictureFormat pictureFormat) {
        if (pictureFormat == PictureFormat.JPEG) {
            this.r = pictureFormat;
        } else {
            throw new UnsupportedOperationException("Unsupported picture format: " + pictureFormat);
        }
    }

    @Override // ff.q
    public final void I(boolean z5) {
        boolean z6 = this.f13664v;
        this.f13664v = z5;
        this.f13648d.d("play sounds (" + z5 + ")", CameraState.ENGINE, new cf.b(this, z6, 2));
    }

    @Override // ff.q
    public final void J(float f2) {
        this.f13667y = f2;
        this.f13648d.d("preview fps (" + f2 + ")", CameraState.ENGINE, new d(this, f2, 0));
    }

    @Override // ff.q
    public final void K(WhiteBalance whiteBalance) {
        WhiteBalance whiteBalance2 = this.f13657n;
        this.f13657n = whiteBalance;
        this.f13648d.d("white balance (" + whiteBalance + ")", CameraState.ENGINE, new x.h(this, 16, whiteBalance2, false));
    }

    @Override // ff.q
    public final void L(float f2, PointF[] pointFArr, boolean z5) {
        float f10 = this.f13662t;
        this.f13662t = f2;
        nf.e eVar = this.f13648d;
        eVar.e(20, "zoom");
        eVar.d("zoom", CameraState.ENGINE, new b(this, f10, z5, pointFArr));
    }

    @Override // ff.q
    public final void N(Gesture gesture, l4.c cVar, PointF pointF) {
        this.f13648d.d("auto focus", CameraState.BIND, new wf(this, cVar, gesture, pointF, 2));
    }

    public final void S(Camera.Parameters parameters) {
        parameters.setRecordingHint(this.G == Mode.VIDEO);
        T(parameters);
        V(parameters, Flash.OFF);
        X(parameters);
        a0(parameters, WhiteBalance.AUTO);
        W(parameters, Hdr.OFF);
        b0(parameters, 0.0f);
        U(parameters, 0.0f);
        Y(this.f13664v);
        Z(parameters, 0.0f);
    }

    public final void T(Camera.Parameters parameters) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        if (this.G == Mode.VIDEO && supportedFocusModes.contains("continuous-video")) {
            parameters.setFocusMode("continuous-video");
            return;
        }
        if (supportedFocusModes.contains("continuous-picture")) {
            parameters.setFocusMode("continuous-picture");
        } else if (supportedFocusModes.contains("infinity")) {
            parameters.setFocusMode("infinity");
        } else if (supportedFocusModes.contains("fixed")) {
            parameters.setFocusMode("fixed");
        }
    }

    public final boolean U(Camera.Parameters parameters, float f2) {
        ef.c cVar = this.f13649f;
        if (!cVar.f12610l) {
            this.f13663u = f2;
            return false;
        }
        float f10 = cVar.f12612n;
        float f11 = cVar.f12611m;
        float f12 = this.f13663u;
        if (f12 < f11) {
            f10 = f11;
        } else if (f12 <= f10) {
            f10 = f12;
        }
        this.f13663u = f10;
        parameters.setExposureCompensation((int) (f10 / parameters.getExposureCompensationStep()));
        return true;
    }

    public final boolean V(Camera.Parameters parameters, Flash flash) {
        if (!this.f13649f.a(this.f13656m)) {
            this.f13656m = flash;
            return false;
        }
        Flash flash2 = this.f13656m;
        this.U.getClass();
        parameters.setFlashMode((String) p001if.a.f14422b.get(flash2));
        return true;
    }

    public final boolean W(Camera.Parameters parameters, Hdr hdr) {
        if (!this.f13649f.a(this.f13660q)) {
            this.f13660q = hdr;
            return false;
        }
        Hdr hdr2 = this.f13660q;
        this.U.getClass();
        parameters.setSceneMode((String) p001if.a.e.get(hdr2));
        return true;
    }

    public final void X(Camera.Parameters parameters) {
        Location location = this.f13661s;
        if (location != null) {
            parameters.setGpsLatitude(location.getLatitude());
            parameters.setGpsLongitude(this.f13661s.getLongitude());
            parameters.setGpsAltitude(this.f13661s.getAltitude());
            parameters.setGpsTimestamp(this.f13661s.getTime());
            parameters.setGpsProcessingMethod(this.f13661s.getProvider());
        }
    }

    public final boolean Y(boolean z5) {
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(this.W, cameraInfo);
        if (cameraInfo.canDisableShutterSound) {
            try {
                return this.V.enableShutterSound(this.f13664v);
            } catch (RuntimeException unused) {
                return false;
            }
        }
        if (this.f13664v) {
            return true;
        }
        this.f13664v = z5;
        return false;
    }

    public final boolean Z(Camera.Parameters parameters, float f2) {
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        if (!this.f13668z || this.f13667y == 0.0f) {
            Collections.sort(supportedPreviewFpsRange, new androidx.viewpager2.widget.a(8));
        } else {
            Collections.sort(supportedPreviewFpsRange, new androidx.viewpager2.widget.a(9));
        }
        float f10 = this.f13667y;
        if (f10 == 0.0f) {
            for (int[] iArr : supportedPreviewFpsRange) {
                int i3 = iArr[0];
                float f11 = i3 / 1000.0f;
                int i10 = iArr[1];
                float f12 = i10 / 1000.0f;
                if ((f11 <= 30.0f && 30.0f <= f12) || (f11 <= 24.0f && 24.0f <= f12)) {
                    parameters.setPreviewFpsRange(i3, i10);
                    return true;
                }
            }
        } else {
            float min = Math.min(f10, this.f13649f.f12615q);
            this.f13667y = min;
            this.f13667y = Math.max(min, this.f13649f.f12614p);
            for (int[] iArr2 : supportedPreviewFpsRange) {
                float f13 = iArr2[0] / 1000.0f;
                float f14 = iArr2[1] / 1000.0f;
                float round = Math.round(this.f13667y);
                if (f13 <= round && round <= f14) {
                    parameters.setPreviewFpsRange(iArr2[0], iArr2[1]);
                    return true;
                }
            }
        }
        this.f13667y = f2;
        return false;
    }

    public final boolean a0(Camera.Parameters parameters, WhiteBalance whiteBalance) {
        if (!this.f13649f.a(this.f13657n)) {
            this.f13657n = whiteBalance;
            return false;
        }
        WhiteBalance whiteBalance2 = this.f13657n;
        this.U.getClass();
        parameters.setWhiteBalance((String) p001if.a.f14423c.get(whiteBalance2));
        parameters.remove("auto-whitebalance-lock");
        return true;
    }

    public final boolean b0(Camera.Parameters parameters, float f2) {
        if (!this.f13649f.f12609k) {
            this.f13662t = f2;
            return false;
        }
        parameters.setZoom((int) (this.f13662t * parameters.getMaxZoom()));
        this.V.setParameters(parameters);
        return true;
    }

    @Override // ff.q
    public final boolean c(Facing facing) {
        this.U.getClass();
        Integer num = (Integer) p001if.a.f14424d.get(facing);
        int intValue = num.intValue();
        q.T.b(1, "collectCameraInfo", "Facing:", facing, "Internal:", num, "Cameras:", Integer.valueOf(Camera.getNumberOfCameras()));
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        int numberOfCameras = Camera.getNumberOfCameras();
        for (int i3 = 0; i3 < numberOfCameras; i3++) {
            Camera.getCameraInfo(i3, cameraInfo);
            if (cameraInfo.facing == intValue) {
                int i10 = cameraInfo.orientation;
                lf.b bVar = this.B;
                bVar.getClass();
                lf.b.e(i10);
                bVar.f15870a = facing;
                bVar.f15871b = i10;
                if (facing == Facing.FRONT) {
                    bVar.f15871b = lf.b.f(360 - i10);
                }
                bVar.d();
                this.W = i3;
                return true;
            }
        }
        return false;
    }

    @Override // ff.q
    public final ArrayList i() {
        ef.b bVar = q.T;
        try {
            List<Camera.Size> supportedPreviewSizes = this.V.getParameters().getSupportedPreviewSizes();
            ArrayList arrayList = new ArrayList(supportedPreviewSizes.size());
            for (Camera.Size size : supportedPreviewSizes) {
                wf.b bVar2 = new wf.b(size.width, size.height);
                if (!arrayList.contains(bVar2)) {
                    arrayList.add(bVar2);
                }
            }
            bVar.b(1, "getPreviewStreamAvailableSizes:", arrayList);
            return arrayList;
        } catch (Exception e) {
            bVar.b(3, "getPreviewStreamAvailableSizes:", "Failed to compute preview size. Camera params is empty");
            throw new CameraException(e, 2);
        }
    }

    @Override // ff.q
    public final pf.c m(int i3) {
        return new pf.a(i3, this);
    }

    @Override // android.hardware.Camera.ErrorCallback
    public final void onError(int i3, Camera camera) {
        int i10 = 3;
        RuntimeException runtimeException = new RuntimeException(q.T.b(3, "Internal Camera1 error.", Integer.valueOf(i3)));
        if (i3 != 1 && i3 != 2 && i3 != 100) {
            i10 = 0;
        }
        throw new CameraException(runtimeException, i10);
    }

    @Override // android.hardware.Camera.PreviewCallback
    public final void onPreviewFrame(byte[] bArr, Camera camera) {
        pf.b a3;
        if (bArr == null || (a3 = ((pf.a) g()).a(System.currentTimeMillis(), bArr)) == null) {
            return;
        }
        this.f13647c.o(a3);
    }

    @Override // ff.q
    public final void p() {
        q.T.b(1, "RESTART PREVIEW:", "scheduled. State:", this.f13648d.e);
        R(false);
        O();
    }

    @Override // ff.q
    public final ia.m q() {
        ef.b bVar = q.T;
        bVar.b(1, "onStartBind:", "Started");
        try {
            if (this.e.e() == SurfaceHolder.class) {
                this.V.setPreviewDisplay((SurfaceHolder) this.e.d());
            } else {
                if (this.e.e() != SurfaceTexture.class) {
                    throw new RuntimeException("Unknown CameraPreview output class.");
                }
                this.V.setPreviewTexture((SurfaceTexture) this.e.d());
            }
            this.f13651h = d(this.G);
            this.f13652i = e();
            bVar.b(1, "onStartBind:", "Returning");
            return xc.c(null);
        } catch (IOException e) {
            bVar.b(3, "onStartBind:", "Failed to bind.", e);
            throw new CameraException(e, 2);
        }
    }

    @Override // ff.q
    public final ia.m r() {
        lf.b bVar = this.B;
        ef.b bVar2 = q.T;
        try {
            Camera open = Camera.open(this.W);
            this.V = open;
            if (open == null) {
                bVar2.b(3, "onStartEngine:", "Failed to connect. Camera is null, maybe in use by another app or already released?");
                throw new CameraException(1);
            }
            open.setErrorCallback(this);
            bVar2.b(1, "onStartEngine:", "Applying default parameters.");
            try {
                Camera.Parameters parameters = this.V.getParameters();
                int i3 = this.W;
                Reference reference = Reference.SENSOR;
                Reference reference2 = Reference.VIEW;
                this.f13649f = new mf.a(parameters, i3, bVar.b(reference, reference2));
                S(parameters);
                this.V.setParameters(parameters);
                try {
                    this.V.setDisplayOrientation(bVar.c(reference, reference2, Axis.ABSOLUTE));
                    bVar2.b(1, "onStartEngine:", "Ended");
                    return xc.c(this.f13649f);
                } catch (Exception unused) {
                    bVar2.b(3, "onStartEngine:", "Failed to connect. Can't set display orientation, maybe preview already exists?");
                    throw new CameraException(1);
                }
            } catch (Exception e) {
                bVar2.b(3, "onStartEngine:", "Failed to connect. Problem with camera params");
                throw new CameraException(e, 1);
            }
        } catch (Exception e10) {
            bVar2.b(3, "onStartEngine:", "Failed to connect. Maybe in use by another app?");
            throw new CameraException(e10, 1);
        }
    }

    @Override // ff.q
    public final ia.m s() {
        ef.b bVar = q.T;
        bVar.b(1, "onStartPreview", "Dispatching onCameraPreviewStreamSizeChanged.");
        this.f13647c.E();
        wf.b j4 = j(Reference.VIEW);
        if (j4 == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.e.m(j4.f19627a, j4.f19628b);
        this.e.l(0);
        try {
            Camera.Parameters parameters = this.V.getParameters();
            parameters.setPreviewFormat(17);
            wf.b bVar2 = this.f13652i;
            parameters.setPreviewSize(bVar2.f19627a, bVar2.f19628b);
            Mode mode = this.G;
            Mode mode2 = Mode.PICTURE;
            if (mode == mode2) {
                wf.b bVar3 = this.f13651h;
                parameters.setPictureSize(bVar3.f19627a, bVar3.f19628b);
            } else {
                wf.b d5 = d(mode2);
                parameters.setPictureSize(d5.f19627a, d5.f19628b);
            }
            try {
                this.V.setParameters(parameters);
                this.V.setPreviewCallbackWithBuffer(null);
                this.V.setPreviewCallbackWithBuffer(this);
                ((pf.a) g()).d(17, this.f13652i, this.B);
                bVar.b(1, "onStartPreview", "Starting preview with startPreview().");
                try {
                    this.V.startPreview();
                    bVar.b(1, "onStartPreview", "Started preview.");
                    return xc.c(null);
                } catch (Exception e) {
                    bVar.b(3, "onStartPreview", "Failed to start preview.", e);
                    throw new CameraException(e, 2);
                }
            } catch (Exception e10) {
                bVar.b(3, "onStartPreview:", "Failed to set params for camera. Maybe incorrect parameter put in params?");
                throw new CameraException(e10, 2);
            }
        } catch (Exception e11) {
            bVar.b(3, "onStartPreview:", "Failed to get params from camera. Maybe low level problem with camera or camera has already released?");
            throw new CameraException(e11, 2);
        }
    }

    @Override // ff.q
    public final ia.m t() {
        this.f13652i = null;
        this.f13651h = null;
        try {
            if (this.e.e() == SurfaceHolder.class) {
                this.V.setPreviewDisplay(null);
            } else {
                if (this.e.e() != SurfaceTexture.class) {
                    throw new RuntimeException("Unknown CameraPreview output class.");
                }
                this.V.setPreviewTexture(null);
            }
        } catch (IOException e) {
            q.T.b(3, "onStopBind", "Could not release surface", e);
        }
        return xc.c(null);
    }

    @Override // ff.q
    public final ia.m u() {
        ef.b bVar = q.T;
        bVar.b(1, "onStopEngine:", "About to clean up.");
        nf.e eVar = this.f13648d;
        eVar.e(0, "focus reset");
        eVar.e(0, "focus end");
        if (this.V != null) {
            try {
                bVar.b(1, "onStopEngine:", "Clean up.", "Releasing camera.");
                this.V.release();
                bVar.b(1, "onStopEngine:", "Clean up.", "Released camera.");
            } catch (Exception e) {
                bVar.b(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e);
            }
            this.V = null;
            this.f13649f = null;
        }
        this.f13649f = null;
        this.V = null;
        bVar.b(2, "onStopEngine:", "Clean up.", "Returning.");
        return xc.c(null);
    }

    @Override // ff.q
    public final ia.m v() {
        ef.b bVar = q.T;
        bVar.b(1, "onStopPreview:", "Started.");
        this.f13650g = null;
        ((pf.a) g()).c();
        bVar.b(1, "onStopPreview:", "Releasing preview buffers.");
        this.V.setPreviewCallbackWithBuffer(null);
        try {
            bVar.b(1, "onStopPreview:", "Stopping preview.");
            this.V.stopPreview();
            bVar.b(1, "onStopPreview:", "Stopped preview.");
        } catch (Exception e) {
            bVar.b(3, "stopPreview", "Could not stop preview", e);
        }
        return xc.c(null);
    }

    @Override // ff.q
    public final void w(y0 y0Var, boolean z5) {
        ef.b bVar = q.T;
        bVar.b(1, "onTakePicture:", "executing.");
        Reference reference = Reference.SENSOR;
        Reference reference2 = Reference.OUTPUT;
        y0Var.f1525b = this.B.c(reference, reference2, Axis.RELATIVE_TO_SENSOR);
        y0Var.f1527d = h(reference2);
        uf.c cVar = new uf.c(y0Var, this, this.V);
        this.f13650g = cVar;
        cVar.u();
        bVar.b(1, "onTakePicture:", "executed.");
    }

    @Override // ff.q
    public final void x(y0 y0Var, wf.a aVar, boolean z5) {
        e eVar;
        ef.b bVar = q.T;
        bVar.b(1, "onTakePictureSnapshot:", "executing.");
        Reference reference = Reference.OUTPUT;
        y0Var.f1527d = l(reference);
        boolean z6 = this.e instanceof vf.g;
        lf.b bVar2 = this.B;
        if (z6) {
            y0Var.f1525b = bVar2.c(Reference.VIEW, reference, Axis.ABSOLUTE);
            eVar = this;
            eVar.f13650g = new uf.o(y0Var, eVar, (vf.g) this.e, aVar, this.S);
        } else {
            eVar = this;
            y0Var.f1525b = bVar2.c(Reference.SENSOR, reference, Axis.RELATIVE_TO_SENSOR);
            Camera camera = eVar.V;
            uf.i iVar = new uf.i(y0Var, this);
            iVar.e = eVar;
            iVar.f19081f = camera;
            iVar.f19082g = aVar;
            iVar.f19083h = camera.getParameters().getPreviewFormat();
            eVar.f13650g = iVar;
        }
        eVar.f13650g.u();
        bVar.b(1, "onTakePictureSnapshot:", "executed.");
    }
}
