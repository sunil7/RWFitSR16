package ff;

import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.MeteringRectangle;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.location.Location;
import android.media.Image;
import android.media.ImageReader;
import android.os.Build;
import android.os.Handler;
import android.util.Pair;
import android.util.Range;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import androidx.camera.core.impl.y0;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_barcode.wf;
import com.google.android.gms.internal.mlkit_vision_barcode.xc;
import com.google.android.gms.internal.mlkit_vision_common.c6;
import com.otaliastudios.cameraview.CameraException;
import com.otaliastudios.cameraview.CameraView;
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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutionException;

/* loaded from: classes2.dex */
public final class n extends q implements ImageReader.OnImageAvailableListener, gf.b {

    /* renamed from: j0, reason: collision with root package name */
    public static final /* synthetic */ int f13630j0 = 0;
    public final CameraManager U;
    public String V;
    public CameraDevice W;
    public CameraCharacteristics X;
    public CameraCaptureSession Y;
    public CaptureRequest.Builder Z;

    /* renamed from: a0, reason: collision with root package name */
    public TotalCaptureResult f13631a0;

    /* renamed from: b0, reason: collision with root package name */
    public final p001if.c f13632b0;

    /* renamed from: c0, reason: collision with root package name */
    public ImageReader f13633c0;

    /* renamed from: d0, reason: collision with root package name */
    public Surface f13634d0;

    /* renamed from: e0, reason: collision with root package name */
    public Surface f13635e0;

    /* renamed from: f0, reason: collision with root package name */
    public ImageReader f13636f0;

    /* renamed from: g0, reason: collision with root package name */
    public final CopyOnWriteArrayList f13637g0;

    /* renamed from: h0, reason: collision with root package name */
    public jf.g f13638h0;
    public final com.example.test.ui.view.b i0;

    public n(ef.i iVar) {
        super(iVar);
        if (p001if.c.f14426a == null) {
            p001if.c.f14426a = new p001if.c();
        }
        this.f13632b0 = p001if.c.f14426a;
        this.f13637g0 = new CopyOnWriteArrayList();
        this.i0 = new com.example.test.ui.view.b(this, 1);
        this.U = (CameraManager) ((CameraView) this.f13647c.f12630c).getContext().getSystemService("camera");
        new gf.g().l(this);
    }

    public static CameraException c0(CameraAccessException cameraAccessException) {
        int reason = cameraAccessException.getReason();
        int i3 = 1;
        if (reason != 1) {
            if (reason == 2 || reason == 3) {
                i3 = 3;
            } else if (reason != 4 && reason != 5) {
                i3 = 0;
            }
        }
        return new CameraException(cameraAccessException, i3);
    }

    @Override // ff.q
    public final void B(float f2, float[] fArr, PointF[] pointFArr, boolean z5) {
        float f10 = this.f13663u;
        this.f13663u = f2;
        nf.e eVar = this.f13648d;
        eVar.e(20, "exposure correction");
        eVar.d("exposure correction", CameraState.ENGINE, new h(this, f10, z5, f2, fArr, pointFArr));
    }

    @Override // ff.q
    public final void C(Flash flash) {
        Flash flash2 = this.f13656m;
        this.f13656m = flash;
        this.f13648d.d("flash (" + flash + ")", CameraState.ENGINE, new e8.a(this, flash2, flash, 1, false));
    }

    @Override // ff.q
    public final void D(int i3) {
        if (this.f13654k == 0) {
            this.f13654k = 35;
        }
        String k10 = l0.k(i3, "frame processing format (", ")");
        androidx.emoji2.text.i iVar = new androidx.emoji2.text.i(i3, 4, this);
        nf.e eVar = this.f13648d;
        eVar.getClass();
        eVar.b(0L, k10, new nf.a(iVar, 0), true);
    }

    @Override // ff.q
    public final void E(boolean z5) {
        cf.b bVar = new cf.b(this, z5, 3);
        nf.e eVar = this.f13648d;
        eVar.getClass();
        eVar.b(0L, "has frame processors (" + z5 + ")", new nf.a(bVar, 0), true);
    }

    @Override // ff.q
    public final void F(Hdr hdr) {
        Hdr hdr2 = this.f13660q;
        this.f13660q = hdr;
        this.f13648d.d("hdr (" + hdr + ")", CameraState.ENGINE, new x.h(this, 19, hdr2, false));
    }

    @Override // ff.q
    public final void G(Location location) {
        Location location2 = this.f13661s;
        this.f13661s = location;
        this.f13648d.d("location", CameraState.ENGINE, new f(this, location2));
    }

    @Override // ff.q
    public final void H(PictureFormat pictureFormat) {
        if (pictureFormat != this.r) {
            this.r = pictureFormat;
            this.f13648d.d("picture format (" + pictureFormat + ")", CameraState.ENGINE, new f(this, 1));
        }
    }

    @Override // ff.q
    public final void I(boolean z5) {
        this.f13664v = z5;
        xc.c(null);
    }

    @Override // ff.q
    public final void J(float f2) {
        float f10 = this.f13667y;
        this.f13667y = f2;
        this.f13648d.d("preview fps (" + f2 + ")", CameraState.ENGINE, new d(this, f10, 1));
    }

    @Override // ff.q
    public final void K(WhiteBalance whiteBalance) {
        WhiteBalance whiteBalance2 = this.f13657n;
        this.f13657n = whiteBalance;
        this.f13648d.d("white balance (" + whiteBalance + ")", CameraState.ENGINE, new x.h(this, 18, whiteBalance2, false));
    }

    @Override // ff.q
    public final void L(float f2, PointF[] pointFArr, boolean z5) {
        float f10 = this.f13662t;
        this.f13662t = f2;
        nf.e eVar = this.f13648d;
        eVar.e(20, "zoom");
        eVar.d("zoom", CameraState.ENGINE, new g(this, f10, z5, f2, pointFArr));
    }

    @Override // ff.q
    public final void N(Gesture gesture, l4.c cVar, PointF pointF) {
        this.f13648d.d("autofocus (" + gesture + ")", CameraState.PREVIEW, new wf(this, gesture, pointF, cVar, 3));
    }

    public final void S(CaptureRequest.Builder builder, CaptureRequest.Builder builder2) {
        q.T.b(1, "applyAllParameters:", "called for tag", builder.build().getTag());
        builder.set(CaptureRequest.CONTROL_MODE, 1);
        T(builder);
        V(builder, Flash.OFF);
        Location location = this.f13661s;
        if (location != null) {
            builder.set(CaptureRequest.JPEG_GPS_LOCATION, location);
        }
        a0(builder, WhiteBalance.AUTO);
        W(builder, Hdr.OFF);
        b0(builder, 0.0f);
        U(builder, 0.0f);
        X(builder, 0.0f);
        if (builder2 != null) {
            CaptureRequest.Key key = CaptureRequest.CONTROL_AF_REGIONS;
            builder.set(key, (MeteringRectangle[]) builder2.get(key));
            CaptureRequest.Key key2 = CaptureRequest.CONTROL_AE_REGIONS;
            builder.set(key2, (MeteringRectangle[]) builder2.get(key2));
            CaptureRequest.Key key3 = CaptureRequest.CONTROL_AWB_REGIONS;
            builder.set(key3, (MeteringRectangle[]) builder2.get(key3));
            CaptureRequest.Key key4 = CaptureRequest.CONTROL_AF_MODE;
            builder.set(key4, (Integer) builder2.get(key4));
        }
    }

    public final void T(CaptureRequest.Builder builder) {
        int[] iArr = (int[]) f0(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (this.G == Mode.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
            return;
        }
        if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
            return;
        }
        if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (arrayList.contains(0)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 0);
            builder.set(CaptureRequest.LENS_FOCUS_DISTANCE, Float.valueOf(0.0f));
        }
    }

    public final boolean U(CaptureRequest.Builder builder, float f2) {
        if (!this.f13649f.f12610l) {
            this.f13663u = f2;
            return false;
        }
        Rational rational = (Rational) f0(CameraCharacteristics.CONTROL_AE_COMPENSATION_STEP, new Rational(1, 1));
        builder.set(CaptureRequest.CONTROL_AE_EXPOSURE_COMPENSATION, Integer.valueOf(Math.round(rational.floatValue() * this.f13663u)));
        return true;
    }

    public final boolean V(CaptureRequest.Builder builder, Flash flash) {
        if (this.f13649f.a(this.f13656m)) {
            int[] iArr = (int[]) f0(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES, new int[0]);
            ArrayList arrayList = new ArrayList();
            for (int i3 : iArr) {
                arrayList.add(Integer.valueOf(i3));
            }
            Flash flash2 = this.f13656m;
            this.f13632b0.getClass();
            ArrayList arrayList2 = new ArrayList();
            int i10 = p001if.b.f14425a[flash2.ordinal()];
            if (i10 == 1) {
                arrayList2.add(new Pair(3, 0));
            } else if (i10 == 2) {
                arrayList2.add(new Pair(2, 0));
                arrayList2.add(new Pair(4, 0));
            } else if (i10 == 3) {
                arrayList2.add(new Pair(1, 0));
                arrayList2.add(new Pair(0, 0));
            } else if (i10 == 4) {
                arrayList2.add(new Pair(1, 2));
                arrayList2.add(new Pair(0, 2));
            }
            int size = arrayList2.size();
            int i11 = 0;
            while (i11 < size) {
                Object obj = arrayList2.get(i11);
                i11++;
                Pair pair = (Pair) obj;
                if (arrayList.contains(pair.first)) {
                    Object[] objArr = {"applyFlash: setting CONTROL_AE_MODE to", pair.first};
                    ef.b bVar = q.T;
                    bVar.b(1, objArr);
                    bVar.b(1, "applyFlash: setting FLASH_MODE to", pair.second);
                    builder.set(CaptureRequest.CONTROL_AE_MODE, (Integer) pair.first);
                    builder.set(CaptureRequest.FLASH_MODE, (Integer) pair.second);
                    return true;
                }
            }
        }
        this.f13656m = flash;
        return false;
    }

    public final boolean W(CaptureRequest.Builder builder, Hdr hdr) {
        if (!this.f13649f.a(this.f13660q)) {
            this.f13660q = hdr;
            return false;
        }
        Hdr hdr2 = this.f13660q;
        this.f13632b0.getClass();
        Integer num = (Integer) p001if.c.f14429d.get(hdr2);
        num.getClass();
        builder.set(CaptureRequest.CONTROL_SCENE_MODE, num);
        return true;
    }

    public final boolean X(CaptureRequest.Builder builder, float f2) {
        Range[] rangeArr = (Range[]) f0(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES, new Range[0]);
        Arrays.sort(rangeArr, new i(this.f13668z && this.f13667y != 0.0f, 0));
        float f10 = this.f13667y;
        if (f10 == 0.0f) {
            ArrayList e02 = e0(rangeArr);
            int size = e02.size();
            int i3 = 0;
            while (i3 < size) {
                Object obj = e02.get(i3);
                i3++;
                Range range = (Range) obj;
                if (range.contains((Range) 30) || range.contains((Range) 24)) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range);
                    return true;
                }
            }
        } else {
            float min = Math.min(f10, this.f13649f.f12615q);
            this.f13667y = min;
            this.f13667y = Math.max(min, this.f13649f.f12614p);
            ArrayList e03 = e0(rangeArr);
            int size2 = e03.size();
            int i10 = 0;
            while (i10 < size2) {
                Object obj2 = e03.get(i10);
                i10++;
                Range range2 = (Range) obj2;
                if (range2.contains((Range) Integer.valueOf(Math.round(this.f13667y)))) {
                    builder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, range2);
                    return true;
                }
            }
        }
        this.f13667y = f2;
        return false;
    }

    public final void Y() {
        Z(3, true);
    }

    public final void Z(int i3, boolean z5) {
        nf.e eVar = this.f13648d;
        if ((eVar.e != CameraState.PREVIEW || n()) && z5) {
            return;
        }
        try {
            this.Y.setRepeatingRequest(this.Z.build(), this.i0, null);
        } catch (CameraAccessException e) {
            throw new CameraException(e, i3);
        } catch (IllegalStateException e10) {
            q.T.b(3, "applyRepeatingRequestBuilder: session is invalid!", e10, "checkStarted:", Boolean.valueOf(z5), "currentThread:", Thread.currentThread().getName(), "state:", eVar.e, "targetState:", eVar.f16614f);
            throw new CameraException(3);
        }
    }

    @Override // ff.q, uf.g
    public final void a(y0 y0Var, Exception exc) {
        boolean z5 = this.f13650g instanceof uf.e;
        super.a(y0Var, exc);
        if (!(z5 && this.f13665w) && (z5 || !this.f13666x)) {
            return;
        }
        this.f13648d.d("reset metering after picture", CameraState.PREVIEW, new f(this, 2));
    }

    public final boolean a0(CaptureRequest.Builder builder, WhiteBalance whiteBalance) {
        if (!this.f13649f.a(this.f13657n)) {
            this.f13657n = whiteBalance;
            return false;
        }
        WhiteBalance whiteBalance2 = this.f13657n;
        this.f13632b0.getClass();
        Integer num = (Integer) p001if.c.f14428c.get(whiteBalance2);
        num.getClass();
        builder.set(CaptureRequest.CONTROL_AWB_MODE, num);
        return true;
    }

    public final boolean b0(CaptureRequest.Builder builder, float f2) {
        if (!this.f13649f.f12609k) {
            this.f13662t = f2;
            return false;
        }
        float floatValue = ((Float) f0(CameraCharacteristics.SCALER_AVAILABLE_MAX_DIGITAL_ZOOM, Float.valueOf(1.0f))).floatValue();
        float f10 = floatValue - 1.0f;
        float f11 = (this.f13662t * f10) + 1.0f;
        Rect rect = (Rect) f0(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE, new Rect());
        int width = (int) (rect.width() / floatValue);
        int width2 = rect.width() - width;
        int height = rect.height() - ((int) (rect.height() / floatValue));
        float f12 = f11 - 1.0f;
        int i3 = (int) (((width2 * f12) / f10) / 2.0f);
        int i10 = (int) (((height * f12) / f10) / 2.0f);
        builder.set(CaptureRequest.SCALER_CROP_REGION, new Rect(i3, i10, rect.width() - i3, rect.height() - i10));
        return true;
    }

    @Override // ff.q
    public final boolean c(Facing facing) {
        CameraCharacteristics cameraCharacteristics;
        Object obj;
        CameraManager cameraManager = this.U;
        this.f13632b0.getClass();
        Integer num = (Integer) p001if.c.f14427b.get(facing);
        int intValue = num.intValue();
        try {
            String[] cameraIdList = cameraManager.getCameraIdList();
            q.T.b(1, "collectCameraInfo", "Facing:", facing, "Internal:", num, "Cameras:", Integer.valueOf(cameraIdList.length));
            for (String str : cameraIdList) {
                try {
                    cameraCharacteristics = cameraManager.getCameraCharacteristics(str);
                    obj = -99;
                    Object obj2 = cameraCharacteristics.get(CameraCharacteristics.LENS_FACING);
                    if (obj2 != null) {
                        obj = obj2;
                    }
                } catch (CameraAccessException unused) {
                }
                if (intValue == ((Integer) obj).intValue()) {
                    this.V = str;
                    Object obj3 = 0;
                    Object obj4 = cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION);
                    if (obj4 != null) {
                        obj3 = obj4;
                    }
                    int intValue2 = ((Integer) obj3).intValue();
                    lf.b bVar = this.B;
                    bVar.getClass();
                    lf.b.e(intValue2);
                    bVar.f15870a = facing;
                    bVar.f15871b = intValue2;
                    if (facing == Facing.FRONT) {
                        bVar.f15871b = lf.b.f(360 - intValue2);
                    }
                    bVar.d();
                    return true;
                }
                continue;
            }
            return false;
        } catch (CameraAccessException e) {
            throw c0(e);
        }
    }

    public final jf.g d0(l4.c cVar) {
        jf.g gVar = this.f13638h0;
        if (gVar != null) {
            gVar.a(this);
        }
        CaptureRequest.Builder builder = this.Z;
        int[] iArr = (int[]) f0(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES, new int[0]);
        ArrayList arrayList = new ArrayList();
        for (int i3 : iArr) {
            arrayList.add(Integer.valueOf(i3));
        }
        if (arrayList.contains(1)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 1);
        } else if (this.G == Mode.VIDEO && arrayList.contains(3)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 3);
        } else if (arrayList.contains(4)) {
            builder.set(CaptureRequest.CONTROL_AF_MODE, 4);
        }
        jf.g gVar2 = new jf.g(this, cVar, cVar == null);
        this.f13638h0 = gVar2;
        return gVar2;
    }

    public final ArrayList e0(Range[] rangeArr) {
        ArrayList arrayList = new ArrayList();
        int round = Math.round(this.f13649f.f12614p);
        int round2 = Math.round(this.f13649f.f12615q);
        for (Range range : rangeArr) {
            if (range.contains((Range) Integer.valueOf(round)) || range.contains((Range) Integer.valueOf(round2))) {
                ef.b bVar = qf.c.f17938a;
                String str = Build.MODEL;
                String str2 = Build.BRAND;
                String str3 = Build.MANUFACTURER;
                ef.b bVar2 = qf.c.f17938a;
                bVar2.b(1, "Build.MODEL:", str, "Build.BRAND:", str2, "Build.MANUFACTURER:", str3);
                List list = (List) qf.c.f17939b.get(str3 + " " + str);
                if (list == null || !list.contains(range)) {
                    arrayList.add(range);
                } else {
                    bVar2.b(1, "Dropping range:", range);
                }
            }
        }
        return arrayList;
    }

    public final Object f0(CameraCharacteristics.Key key, Object obj) {
        Object obj2 = this.X.get(key);
        return obj2 == null ? obj : obj2;
    }

    @Override // ff.q
    public final ArrayList i() {
        try {
            StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.U.getCameraCharacteristics(this.V).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
            if (streamConfigurationMap == null) {
                throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
            }
            Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.e.e());
            ArrayList arrayList = new ArrayList(outputSizes.length);
            for (Size size : outputSizes) {
                wf.b bVar = new wf.b(size.getWidth(), size.getHeight());
                if (!arrayList.contains(bVar)) {
                    arrayList.add(bVar);
                }
            }
            return arrayList;
        } catch (CameraAccessException e) {
            throw c0(e);
        }
    }

    @Override // ff.q
    public final pf.c m(int i3) {
        return new pf.d(Image.class, i3);
    }

    @Override // android.media.ImageReader.OnImageAvailableListener
    public final void onImageAvailable(ImageReader imageReader) {
        Image image;
        ef.b bVar = q.T;
        bVar.b(0, "onImageAvailable:", "trying to acquire Image.");
        try {
            image = imageReader.acquireLatestImage();
        } catch (Exception unused) {
            image = null;
        }
        if (image == null) {
            bVar.b(2, "onImageAvailable:", "failed to acquire Image!");
            return;
        }
        if (this.f13648d.e != CameraState.PREVIEW || n()) {
            bVar.b(1, "onImageAvailable:", "Image acquired in wrong state. Closing it now.");
            image.close();
            return;
        }
        pf.b a3 = g().a(System.currentTimeMillis(), image);
        if (a3 == null) {
            bVar.b(1, "onImageAvailable:", "Image acquired, but no free frames. DROPPING.");
        } else {
            bVar.b(0, "onImageAvailable:", "Image acquired, dispatching.");
            this.f13647c.o(a3);
        }
    }

    @Override // ff.q
    public final void p() {
        q.T.b(1, "onPreviewStreamSizeChanged:", "Calling restartBind().");
        A();
    }

    @Override // ff.q
    public final ia.m q() {
        Handler handler;
        int i3;
        byte b3 = 0;
        ef.b bVar = q.T;
        bVar.b(1, "onStartBind:", "Started");
        ia.g gVar = new ia.g();
        this.f13651h = d(this.G);
        this.f13652i = e();
        ArrayList arrayList = new ArrayList();
        Class e = this.e.e();
        Object d5 = this.e.d();
        if (e == SurfaceHolder.class) {
            try {
                bVar.b(1, "onStartBind:", "Waiting on UI thread...");
                xc.a(xc.b(new l(this, d5)));
                this.f13635e0 = ((SurfaceHolder) d5).getSurface();
            } catch (InterruptedException | ExecutionException e10) {
                throw new CameraException(e10, 1);
            }
        } else {
            if (e != SurfaceTexture.class) {
                throw new RuntimeException("Unknown CameraPreview output class.");
            }
            SurfaceTexture surfaceTexture = (SurfaceTexture) d5;
            wf.b bVar2 = this.f13652i;
            surfaceTexture.setDefaultBufferSize(bVar2.f19627a, bVar2.f19628b);
            this.f13635e0 = new Surface(surfaceTexture);
        }
        arrayList.add(this.f13635e0);
        if (this.G == Mode.PICTURE) {
            int i10 = k.f13623a[this.r.ordinal()];
            if (i10 == 1) {
                i3 = 256;
            } else {
                if (i10 != 2) {
                    throw new IllegalArgumentException("Unknown format:" + this.r);
                }
                i3 = 32;
            }
            wf.b bVar3 = this.f13651h;
            ImageReader newInstance = ImageReader.newInstance(bVar3.f19627a, bVar3.f19628b, i3, 2);
            this.f13636f0 = newInstance;
            arrayList.add(newInstance.getSurface());
        }
        if (this.f13655l) {
            try {
                StreamConfigurationMap streamConfigurationMap = (StreamConfigurationMap) this.U.getCameraCharacteristics(this.V).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
                if (streamConfigurationMap == null) {
                    throw new RuntimeException("StreamConfigurationMap is null. Should not happen.");
                }
                Size[] outputSizes = streamConfigurationMap.getOutputSizes(this.f13654k);
                ArrayList arrayList2 = new ArrayList(outputSizes.length);
                for (Size size : outputSizes) {
                    wf.b bVar4 = new wf.b(size.getWidth(), size.getHeight());
                    if (!arrayList2.contains(bVar4)) {
                        arrayList2.add(bVar4);
                    }
                }
                boolean b10 = this.B.b(Reference.SENSOR, Reference.VIEW);
                ArrayList arrayList3 = new ArrayList(arrayList2.size());
                int size2 = arrayList2.size();
                int i11 = 0;
                while (i11 < size2) {
                    Object obj = arrayList2.get(i11);
                    i11++;
                    wf.b bVar5 = (wf.b) obj;
                    if (b10) {
                        bVar5 = bVar5.a();
                    }
                    arrayList3.add(bVar5);
                }
                wf.b bVar6 = this.f13652i;
                wf.a a3 = wf.a.a(bVar6.f19627a, bVar6.f19628b);
                if (b10) {
                    a3 = wf.a.a(a3.f19626b, a3.f19625a);
                }
                int i12 = this.P;
                int i13 = this.Q;
                if (i12 <= 0 || i12 == Integer.MAX_VALUE) {
                    i12 = 640;
                }
                if (i13 <= 0 || i13 == Integer.MAX_VALUE) {
                    i13 = 640;
                }
                bVar.b(1, "computeFrameProcessingSize:", "targetRatio:", a3, "targetMaxSize:", new wf.b(i12, i13));
                wf.f b11 = c6.b(new wf.d(a3.c()));
                wf.f a10 = c6.a(c6.b(new o2.m(b3, i13, 10)), c6.b(new o2.m(b3, i12, 8)), new wf.e(0));
                wf.c[] cVarArr = {c6.a(b11, a10), a10, new wf.e(1)};
                List list = null;
                for (wf.c cVar : cVarArr) {
                    list = cVar.a(arrayList3);
                    if (!list.isEmpty()) {
                        break;
                    }
                }
                if (list == null) {
                    list = new ArrayList();
                }
                wf.b bVar7 = (wf.b) list.get(0);
                if (!arrayList3.contains(bVar7)) {
                    throw new RuntimeException("SizeSelectors must not return Sizes other than those in the input list.");
                }
                if (b10) {
                    bVar7 = bVar7.a();
                }
                bVar.b(1, "computeFrameProcessingSize:", "result:", bVar7, "flip:", Boolean.valueOf(b10));
                this.f13653j = bVar7;
                ImageReader newInstance2 = ImageReader.newInstance(bVar7.f19627a, bVar7.f19628b, this.f13654k, this.R + 1);
                this.f13633c0 = newInstance2;
                newInstance2.setOnImageAvailableListener(this, null);
                Surface surface = this.f13633c0.getSurface();
                this.f13634d0 = surface;
                arrayList.add(surface);
                handler = null;
            } catch (CameraAccessException e11) {
                throw c0(e11);
            }
        } else {
            handler = null;
            this.f13633c0 = null;
            this.f13653j = null;
            this.f13634d0 = null;
        }
        try {
            this.W.createCaptureSession(arrayList, new androidx.camera.camera2.internal.compat.i(this, gVar), handler);
            return gVar.f14382a;
        } catch (CameraAccessException e12) {
            throw c0(e12);
        }
    }

    @Override // ff.q
    public final ia.m r() {
        ia.g gVar = new ia.g();
        try {
            this.U.openCamera(this.V, new androidx.camera.camera2.internal.compat.p(1, this, gVar), (Handler) null);
            return gVar.f14382a;
        } catch (CameraAccessException e) {
            throw c0(e);
        }
    }

    @Override // ff.q
    public final ia.m s() {
        ef.b bVar = q.T;
        bVar.b(1, "onStartPreview:", "Dispatching onCameraPreviewStreamSizeChanged.");
        this.f13647c.E();
        Reference reference = Reference.VIEW;
        wf.b j4 = j(reference);
        if (j4 == null) {
            throw new IllegalStateException("previewStreamSize should not be null at this point.");
        }
        this.e.m(j4.f19627a, j4.f19628b);
        vf.a aVar = this.e;
        Reference reference2 = Reference.BASE;
        Axis axis = Axis.ABSOLUTE;
        lf.b bVar2 = this.B;
        aVar.l(bVar2.c(reference2, reference, axis));
        if (this.f13655l) {
            g().d(this.f13654k, this.f13653j, bVar2);
        }
        bVar.b(1, "onStartPreview:", "Starting preview.");
        Surface[] surfaceArr = new Surface[0];
        this.Z.addTarget(this.f13635e0);
        Surface surface = this.f13634d0;
        if (surface != null) {
            this.Z.addTarget(surface);
        }
        for (Surface surface2 : surfaceArr) {
            if (surface2 == null) {
                throw new IllegalArgumentException("Should not add a null surface.");
            }
            this.Z.addTarget(surface2);
        }
        Z(2, false);
        bVar.b(1, "onStartPreview:", "Started preview.");
        ia.g gVar = new ia.g();
        new j(gVar, 1).l(this);
        return gVar.f14382a;
    }

    @Override // ff.q
    public final ia.m t() {
        ef.b bVar = q.T;
        bVar.b(1, "onStopBind:", "About to clean up.");
        this.f13634d0 = null;
        this.f13635e0 = null;
        this.f13652i = null;
        this.f13651h = null;
        this.f13653j = null;
        ImageReader imageReader = this.f13633c0;
        if (imageReader != null) {
            imageReader.close();
            this.f13633c0 = null;
        }
        ImageReader imageReader2 = this.f13636f0;
        if (imageReader2 != null) {
            imageReader2.close();
            this.f13636f0 = null;
        }
        this.Y.close();
        this.Y = null;
        bVar.b(1, "onStopBind:", "Returning.");
        return xc.c(null);
    }

    @Override // ff.q
    public final ia.m u() {
        ef.b bVar = q.T;
        try {
            bVar.b(1, "onStopEngine:", "Clean up.", "Releasing camera.");
            this.W.close();
            bVar.b(1, "onStopEngine:", "Clean up.", "Released camera.");
        } catch (Exception e) {
            bVar.b(2, "onStopEngine:", "Clean up.", "Exception while releasing camera.", e);
        }
        this.W = null;
        bVar.b(1, "onStopEngine:", "Aborting actions.");
        Iterator it = this.f13637g0.iterator();
        while (it.hasNext()) {
            ((gf.e) it.next()).a(this);
        }
        this.X = null;
        this.f13649f = null;
        this.Z = null;
        bVar.b(2, "onStopEngine:", "Returning.");
        return xc.c(null);
    }

    @Override // ff.q
    public final ia.m v() {
        ef.b bVar = q.T;
        bVar.b(1, "onStopPreview:", "Started.");
        this.f13650g = null;
        if (this.f13655l) {
            g().c();
        }
        this.Z.removeTarget(this.f13635e0);
        Surface surface = this.f13634d0;
        if (surface != null) {
            this.Z.removeTarget(surface);
        }
        this.f13631a0 = null;
        bVar.b(1, "onStopPreview:", "Returning.");
        return xc.c(null);
    }

    @Override // ff.q
    public final void w(y0 y0Var, boolean z5) {
        ef.b bVar = q.T;
        if (z5) {
            bVar.b(1, "onTakePicture:", "doMetering is true. Delaying.");
            jf.g d02 = d0(null);
            gf.i iVar = new gf.i(0);
            iVar.f14063g = 2500L;
            iVar.f14064h = d02;
            iVar.b(new m(1, this, y0Var));
            iVar.l(this);
            return;
        }
        bVar.b(1, "onTakePicture:", "doMetering is false. Performing.");
        Reference reference = Reference.SENSOR;
        Reference reference2 = Reference.OUTPUT;
        y0Var.f1525b = this.B.c(reference, reference2, Axis.RELATIVE_TO_SENSOR);
        y0Var.f1527d = h(reference2);
        try {
            CaptureRequest.Builder createCaptureRequest = this.W.createCaptureRequest(2);
            S(createCaptureRequest, this.Z);
            uf.e eVar = new uf.e(y0Var, this, createCaptureRequest, this.f13636f0);
            this.f13650g = eVar;
            eVar.u();
        } catch (CameraAccessException e) {
            throw c0(e);
        }
    }

    @Override // ff.q
    public final void x(y0 y0Var, wf.a aVar, boolean z5) {
        ef.b bVar = q.T;
        if (z5) {
            bVar.b(1, "onTakePictureSnapshot:", "doMetering is true. Delaying.");
            jf.g d02 = d0(null);
            gf.i iVar = new gf.i(0);
            iVar.f14063g = 2500L;
            iVar.f14064h = d02;
            iVar.b(new m(0, this, y0Var));
            iVar.l(this);
            return;
        }
        bVar.b(1, "onTakePictureSnapshot:", "doMetering is false. Performing.");
        if (!(this.e instanceof vf.g)) {
            throw new RuntimeException("takePictureSnapshot with Camera2 is only supported with Preview.GL_SURFACE");
        }
        Reference reference = Reference.OUTPUT;
        y0Var.f1527d = l(reference);
        y0Var.f1525b = this.B.c(Reference.VIEW, reference, Axis.ABSOLUTE);
        uf.l lVar = new uf.l(y0Var, this, (vf.g) this.e, aVar);
        this.f13650g = lVar;
        lVar.u();
    }
}
