package com.otaliastudios.cameraview;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.pm.PackageManager;
import android.content.res.TypedArray;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.hardware.display.DisplayManager;
import android.location.Location;
import android.media.MediaActionSound;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.camera.core.impl.y0;
import androidx.lifecycle.Lifecycle$Event;
import androidx.lifecycle.d0;
import androidx.lifecycle.n;
import androidx.lifecycle.r;
import androidx.lifecycle.s;
import com.google.android.gms.internal.mlkit_vision_barcode.l0;
import com.google.android.gms.internal.mlkit_vision_common.c6;
import com.otaliastudios.cameraview.controls.Audio;
import com.otaliastudios.cameraview.controls.AudioCodec;
import com.otaliastudios.cameraview.controls.Engine;
import com.otaliastudios.cameraview.controls.Facing;
import com.otaliastudios.cameraview.controls.Flash;
import com.otaliastudios.cameraview.controls.Grid;
import com.otaliastudios.cameraview.controls.Hdr;
import com.otaliastudios.cameraview.controls.Mode;
import com.otaliastudios.cameraview.controls.PictureFormat;
import com.otaliastudios.cameraview.controls.Preview;
import com.otaliastudios.cameraview.controls.VideoCodec;
import com.otaliastudios.cameraview.controls.WhiteBalance;
import com.otaliastudios.cameraview.engine.offset.Reference;
import com.otaliastudios.cameraview.engine.orchestrator.CameraState;
import com.otaliastudios.cameraview.gesture.Gesture;
import com.otaliastudios.cameraview.gesture.GestureAction;
import com.otaliastudios.cameraview.gesture.d;
import com.otaliastudios.cameraview.gesture.f;
import com.otaliastudios.cameraview.internal.GridLinesLayout;
import com.otaliastudios.cameraview.markers.MarkerLayout;
import com.otaliastudios.cameraview.overlay.OverlayLayout;
import ef.b;
import ef.i;
import ff.e;
import ff.o;
import ff.p;
import ff.q;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import o2.m;
import of.a;
import qf.g;
import vf.j;
import wf.c;

/* loaded from: classes2.dex */
public class CameraView extends FrameLayout implements r {
    public static final b C = b.a("CameraView");
    public boolean A;
    public OverlayLayout B;

    /* renamed from: a, reason: collision with root package name */
    public boolean f11542a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f11543b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f11544c;

    /* renamed from: d, reason: collision with root package name */
    public final HashMap f11545d;
    public Preview e;

    /* renamed from: f, reason: collision with root package name */
    public Engine f11546f;

    /* renamed from: g, reason: collision with root package name */
    public a f11547g;

    /* renamed from: h, reason: collision with root package name */
    public int f11548h;

    /* renamed from: i, reason: collision with root package name */
    public int f11549i;

    /* renamed from: j, reason: collision with root package name */
    public Handler f11550j;

    /* renamed from: k, reason: collision with root package name */
    public ThreadPoolExecutor f11551k;

    /* renamed from: l, reason: collision with root package name */
    public i f11552l;

    /* renamed from: m, reason: collision with root package name */
    public vf.a f11553m;

    /* renamed from: n, reason: collision with root package name */
    public g f11554n;

    /* renamed from: o, reason: collision with root package name */
    public q f11555o;

    /* renamed from: p, reason: collision with root package name */
    public wf.b f11556p;

    /* renamed from: q, reason: collision with root package name */
    public MediaActionSound f11557q;
    public final CopyOnWriteArrayList r;

    /* renamed from: s, reason: collision with root package name */
    public final CopyOnWriteArrayList f11558s;

    /* renamed from: t, reason: collision with root package name */
    public n f11559t;

    /* renamed from: u, reason: collision with root package name */
    public d f11560u;

    /* renamed from: v, reason: collision with root package name */
    public com.otaliastudios.cameraview.gesture.g f11561v;

    /* renamed from: w, reason: collision with root package name */
    public f f11562w;

    /* renamed from: x, reason: collision with root package name */
    public GridLinesLayout f11563x;

    /* renamed from: y, reason: collision with root package name */
    public MarkerLayout f11564y;

    /* renamed from: z, reason: collision with root package name */
    public boolean f11565z;

    public CameraView(Context context) {
        super(context, null);
        this.f11545d = new HashMap(4);
        this.r = new CopyOnWriteArrayList();
        this.f11558s = new CopyOnWriteArrayList();
        d(context, null);
    }

    public final boolean a(Audio audio) {
        if (audio == Audio.ON || audio == Audio.MONO || audio == Audio.STEREO) {
            try {
                for (String str : getContext().getPackageManager().getPackageInfo(getContext().getPackageName(), 4096).requestedPermissions) {
                    if (!str.equals("android.permission.RECORD_AUDIO")) {
                    }
                }
                throw new IllegalStateException(C.b(3, "Permission error: when audio is enabled (Audio.ON) the RECORD_AUDIO permission should be added to the app manifest file."));
            } catch (PackageManager.NameNotFoundException unused) {
            }
        }
        Context context = getContext();
        boolean z5 = audio == Audio.ON || audio == Audio.MONO || audio == Audio.STEREO;
        boolean z6 = context.checkSelfPermission("android.permission.CAMERA") != 0;
        boolean z8 = z5 && context.checkSelfPermission("android.permission.RECORD_AUDIO") != 0;
        if (!z6 && !z8) {
            return true;
        }
        if (this.f11544c) {
            Activity activity = null;
            for (Context context2 = getContext(); context2 instanceof ContextWrapper; context2 = ((ContextWrapper) context2).getBaseContext()) {
                if (context2 instanceof Activity) {
                    activity = (Activity) context2;
                }
            }
            ArrayList arrayList = new ArrayList();
            if (z6) {
                arrayList.add("android.permission.CAMERA");
            }
            if (z8) {
                arrayList.add("android.permission.RECORD_AUDIO");
            }
            if (activity != null) {
                activity.requestPermissions((String[]) arrayList.toArray(new String[0]), 16);
            }
        }
        return false;
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i3, ViewGroup.LayoutParams layoutParams) {
        if (!this.A) {
            this.B.getClass();
            if (layoutParams instanceof tf.d) {
                this.B.addView(view, layoutParams);
                return;
            }
        }
        super.addView(view, i3, layoutParams);
    }

    public final void b() {
        q eVar;
        Object[] objArr = {"doInstantiateEngine:", "instantiating. engine:", this.f11546f};
        b bVar = C;
        bVar.b(2, objArr);
        Engine engine = this.f11546f;
        i iVar = this.f11552l;
        if (this.f11565z && engine == Engine.CAMERA2) {
            eVar = new ff.n(iVar);
        } else {
            this.f11546f = Engine.CAMERA1;
            eVar = new e(iVar);
        }
        this.f11555o = eVar;
        bVar.b(2, "doInstantiateEngine:", "instantiated. engine:", eVar.getClass().getSimpleName());
        this.f11555o.S = this.B;
    }

    @d0(Lifecycle$Event.ON_PAUSE)
    public void close() {
        if (this.A) {
            return;
        }
        g gVar = this.f11554n;
        if (gVar.f17952h) {
            gVar.f17952h = false;
            gVar.f17949d.disable();
            ((DisplayManager) gVar.f17947b.getSystemService("display")).unregisterDisplayListener(gVar.f17950f);
            gVar.f17951g = -1;
            gVar.e = -1;
        }
        this.f11555o.P(false);
        vf.a aVar = this.f11553m;
        if (aVar != null) {
            aVar.j();
        }
    }

    public final void d(Context context, AttributeSet attributeSet) {
        long j4;
        int i3;
        boolean z5;
        a bVar;
        boolean isInEditMode = isInEditMode();
        this.A = isInEditMode;
        if (isInEditMode) {
            return;
        }
        setWillNotDraw(false);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R$styleable.CameraView, 0, 0);
        com.otaliastudios.cameraview.controls.b bVar2 = new com.otaliastudios.cameraview.controls.b(context, obtainStyledAttributes);
        boolean z6 = obtainStyledAttributes.getBoolean(R$styleable.CameraView_cameraPlaySounds, true);
        boolean z8 = obtainStyledAttributes.getBoolean(R$styleable.CameraView_cameraUseDeviceOrientation, true);
        this.f11565z = obtainStyledAttributes.getBoolean(R$styleable.CameraView_cameraExperimental, false);
        this.f11544c = obtainStyledAttributes.getBoolean(R$styleable.CameraView_cameraRequestPermissions, true);
        this.e = Preview.fromValue(bVar2.f11578a);
        this.f11546f = Engine.fromValue(bVar2.f11587k);
        int color = obtainStyledAttributes.getColor(R$styleable.CameraView_cameraGridColor, GridLinesLayout.f11611f);
        long j10 = (long) obtainStyledAttributes.getFloat(R$styleable.CameraView_cameraVideoMaxSize, 0.0f);
        int integer = obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraVideoMaxDuration, 0);
        int integer2 = obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraVideoBitRate, 0);
        int integer3 = obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraAudioBitRate, 0);
        float f2 = obtainStyledAttributes.getFloat(R$styleable.CameraView_cameraPreviewFrameRate, 0.0f);
        boolean z10 = obtainStyledAttributes.getBoolean(R$styleable.CameraView_cameraPreviewFrameRateExact, false);
        long integer4 = obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraAutoFocusResetDelay, 3000);
        boolean z11 = obtainStyledAttributes.getBoolean(R$styleable.CameraView_cameraPictureMetering, true);
        boolean z12 = obtainStyledAttributes.getBoolean(R$styleable.CameraView_cameraPictureSnapshotMetering, false);
        int integer5 = obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraSnapshotMaxWidth, 0);
        int integer6 = obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraSnapshotMaxHeight, 0);
        int integer7 = obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraFrameProcessingMaxWidth, 0);
        int integer8 = obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraFrameProcessingMaxHeight, 0);
        int integer9 = obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraFrameProcessingFormat, 0);
        int integer10 = obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraFrameProcessingPoolSize, 2);
        int integer11 = obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraFrameProcessingExecutors, 1);
        boolean z13 = obtainStyledAttributes.getBoolean(R$styleable.CameraView_cameraDrawHardwareOverlays, false);
        ArrayList arrayList = new ArrayList(3);
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraPictureSizeMinWidth)) {
            i3 = integer2;
            j4 = j10;
            arrayList.add(c6.b(new m((byte) 0, obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraPictureSizeMinWidth, 0), 9)));
        } else {
            j4 = j10;
            i3 = integer2;
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraPictureSizeMaxWidth)) {
            arrayList.add(c6.b(new m((byte) 0, obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraPictureSizeMaxWidth, 0), 8)));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraPictureSizeMinHeight)) {
            arrayList.add(c6.b(new m((byte) 0, obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraPictureSizeMinHeight, 0), 11)));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraPictureSizeMaxHeight)) {
            arrayList.add(c6.b(new m((byte) 0, obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraPictureSizeMaxHeight, 0), 10)));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraPictureSizeMinArea)) {
            arrayList.add(c6.b(new m((byte) 0, obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraPictureSizeMinArea, 0), 13)));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraPictureSizeMaxArea)) {
            arrayList.add(c6.b(new m((byte) 0, obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraPictureSizeMaxArea, 0), 12)));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraPictureSizeAspectRatio)) {
            arrayList.add(c6.b(new wf.d(wf.a.b(obtainStyledAttributes.getString(R$styleable.CameraView_cameraPictureSizeAspectRatio)).c())));
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.CameraView_cameraPictureSizeSmallest, false)) {
            arrayList.add(new wf.e(1));
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.CameraView_cameraPictureSizeBiggest, false)) {
            arrayList.add(new wf.e(0));
        }
        c a3 = !arrayList.isEmpty() ? c6.a((c[]) arrayList.toArray(new c[0])) : new wf.e(0);
        ArrayList arrayList2 = new ArrayList(3);
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraVideoSizeMinWidth)) {
            z5 = z12;
            arrayList2.add(c6.b(new m((byte) 0, obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraVideoSizeMinWidth, 0), 9)));
        } else {
            z5 = z12;
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraVideoSizeMaxWidth)) {
            arrayList2.add(c6.b(new m((byte) 0, obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraVideoSizeMaxWidth, 0), 8)));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraVideoSizeMinHeight)) {
            arrayList2.add(c6.b(new m((byte) 0, obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraVideoSizeMinHeight, 0), 11)));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraVideoSizeMaxHeight)) {
            arrayList2.add(c6.b(new m((byte) 0, obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraVideoSizeMaxHeight, 0), 10)));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraVideoSizeMinArea)) {
            arrayList2.add(c6.b(new m((byte) 0, obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraVideoSizeMinArea, 0), 13)));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraVideoSizeMaxArea)) {
            arrayList2.add(c6.b(new m((byte) 0, obtainStyledAttributes.getInteger(R$styleable.CameraView_cameraVideoSizeMaxArea, 0), 12)));
        }
        if (obtainStyledAttributes.hasValue(R$styleable.CameraView_cameraVideoSizeAspectRatio)) {
            arrayList2.add(c6.b(new wf.d(wf.a.b(obtainStyledAttributes.getString(R$styleable.CameraView_cameraVideoSizeAspectRatio)).c())));
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.CameraView_cameraVideoSizeSmallest, false)) {
            arrayList2.add(new wf.e(1));
        }
        if (obtainStyledAttributes.getBoolean(R$styleable.CameraView_cameraVideoSizeBiggest, false)) {
            arrayList2.add(new wf.e(0));
        }
        c a10 = !arrayList2.isEmpty() ? c6.a((c[]) arrayList2.toArray(new c[0])) : new wf.e(0);
        com.otaliastudios.cameraview.gesture.b bVar3 = new com.otaliastudios.cameraview.gesture.b(obtainStyledAttributes);
        String string = obtainStyledAttributes.getString(R$styleable.CameraView_cameraAutoFocusMarker);
        if (string != null) {
            try {
                if (Class.forName(string).newInstance() != null) {
                    throw new ClassCastException();
                }
            } catch (Exception unused) {
            }
        }
        try {
            bVar = (a) Class.forName(obtainStyledAttributes.getString(R$styleable.CameraView_cameraFilter)).newInstance();
        } catch (Exception unused2) {
            bVar = new of.b();
        }
        obtainStyledAttributes.recycle();
        this.f11552l = new i(this);
        this.f11550j = new Handler(Looper.getMainLooper());
        i iVar = this.f11552l;
        d dVar = new d(2);
        dVar.f11604f = 0.0f;
        Gesture gesture = Gesture.PINCH;
        dVar.f11596b = gesture;
        a aVar = bVar;
        ScaleGestureDetector scaleGestureDetector = new ScaleGestureDetector(((CameraView) iVar.f12630c).getContext(), new com.otaliastudios.cameraview.gesture.c(dVar));
        dVar.f11603d = scaleGestureDetector;
        scaleGestureDetector.setQuickScaleEnabled(false);
        this.f11560u = dVar;
        i iVar2 = this.f11552l;
        com.otaliastudios.cameraview.gesture.g gVar = new com.otaliastudios.cameraview.gesture.g(1);
        GestureDetector gestureDetector = new GestureDetector(((CameraView) iVar2.f12630c).getContext(), new com.dh.imagepick.preview.widgets.video.c(gVar, 1));
        gVar.f11610d = gestureDetector;
        gestureDetector.setIsLongpressEnabled(true);
        this.f11561v = gVar;
        i iVar3 = this.f11552l;
        f fVar = new f(2);
        GestureDetector gestureDetector2 = new GestureDetector(((CameraView) iVar3.f12630c).getContext(), new com.otaliastudios.cameraview.gesture.e(fVar, iVar3));
        fVar.f11608d = gestureDetector2;
        gestureDetector2.setIsLongpressEnabled(false);
        this.f11562w = fVar;
        this.f11563x = new GridLinesLayout(context);
        this.B = new OverlayLayout(context);
        this.f11564y = new MarkerLayout(context);
        addView(this.f11563x);
        addView(this.f11564y);
        addView(this.B);
        b();
        setPlaySounds(z6);
        setUseDeviceOrientation(z8);
        setGrid(Grid.fromValue(bVar2.f11581d));
        setGridColor(color);
        setDrawHardwareOverlays(z13);
        setFacing(Facing.fromValue(bVar2.f11579b));
        setFlash(Flash.fromValue(bVar2.f11580c));
        setMode(Mode.fromValue(bVar2.f11582f));
        setWhiteBalance(WhiteBalance.fromValue(bVar2.e));
        setHdr(Hdr.fromValue(bVar2.f11583g));
        setAudio(Audio.fromValue(bVar2.f11584h));
        setAudioBitRate(integer3);
        setAudioCodec(AudioCodec.fromValue(bVar2.f11586j));
        setPictureSize(a3);
        setPictureMetering(z11);
        setPictureSnapshotMetering(z5);
        setPictureFormat(PictureFormat.fromValue(bVar2.f11588l));
        setVideoSize(a10);
        setVideoCodec(VideoCodec.fromValue(bVar2.f11585i));
        setVideoMaxSize(j4);
        setVideoMaxDuration(integer);
        setVideoBitRate(i3);
        setAutoFocusResetDelay(integer4);
        setPreviewFrameRateExact(z10);
        setPreviewFrameRate(f2);
        setSnapshotMaxWidth(integer5);
        setSnapshotMaxHeight(integer6);
        setFrameProcessingMaxWidth(integer7);
        setFrameProcessingMaxHeight(integer8);
        setFrameProcessingFormat(integer9);
        setFrameProcessingPoolSize(integer10);
        setFrameProcessingExecutors(integer11);
        f(Gesture.TAP, GestureAction.fromValue(bVar3.f11598a));
        f(Gesture.LONG_TAP, GestureAction.fromValue(bVar3.f11599b));
        f(gesture, GestureAction.fromValue(bVar3.f11600c));
        f(Gesture.SCROLL_HORIZONTAL, GestureAction.fromValue(bVar3.f11601d));
        f(Gesture.SCROLL_VERTICAL, GestureAction.fromValue(bVar3.e));
        setAutoFocusMarker(null);
        setFilter(aVar);
        this.f11554n = new g(context, this.f11552l);
    }

    @d0(Lifecycle$Event.ON_DESTROY)
    public void destroy() {
        if (this.A) {
            return;
        }
        this.r.clear();
        CopyOnWriteArrayList copyOnWriteArrayList = this.f11558s;
        boolean z5 = copyOnWriteArrayList.size() > 0;
        copyOnWriteArrayList.clear();
        if (z5) {
            this.f11555o.E(false);
        }
        this.f11555o.f(0, true);
        vf.a aVar = this.f11553m;
        if (aVar != null) {
            aVar.i();
        }
    }

    public final boolean e() {
        CameraState cameraState = this.f11555o.f13648d.e;
        CameraState cameraState2 = CameraState.ENGINE;
        return cameraState.isAtLeast(cameraState2) && this.f11555o.f13648d.f16614f.isAtLeast(cameraState2);
    }

    public final void f(Gesture gesture, GestureAction gestureAction) {
        GestureAction gestureAction2 = GestureAction.NONE;
        if (!gesture.isAssignableTo(gestureAction)) {
            f(gesture, gestureAction2);
            return;
        }
        HashMap hashMap = this.f11545d;
        hashMap.put(gesture, gestureAction);
        int i3 = ef.f.f12619b[gesture.ordinal()];
        if (i3 == 1) {
            this.f11560u.f11595a = hashMap.get(Gesture.PINCH) != gestureAction2;
        } else if (i3 == 2 || i3 == 3) {
            this.f11561v.f11595a = (hashMap.get(Gesture.TAP) == gestureAction2 && hashMap.get(Gesture.LONG_TAP) == gestureAction2) ? false : true;
        } else if (i3 == 4 || i3 == 5) {
            this.f11562w.f11595a = (hashMap.get(Gesture.SCROLL_HORIZONTAL) == gestureAction2 && hashMap.get(Gesture.SCROLL_VERTICAL) == gestureAction2) ? false : true;
        }
        this.f11549i = 0;
        Iterator it = hashMap.values().iterator();
        while (it.hasNext()) {
            this.f11549i += ((GestureAction) it.next()) == GestureAction.NONE ? 0 : 1;
        }
    }

    public final void g(com.otaliastudios.cameraview.gesture.a aVar, ef.c cVar) {
        int i3 = 0;
        int i10 = 1;
        Gesture gesture = aVar.f11596b;
        int i11 = ef.f.f12620c[((GestureAction) this.f11545d.get(gesture)).ordinal()];
        PointF[] pointFArr = aVar.f11597c;
        float f2 = 0.0f;
        switch (i11) {
            case 1:
                y0 y0Var = new y0();
                q qVar = this.f11555o;
                qVar.f13648d.d("take picture snapshot", CameraState.BIND, new p(qVar, y0Var, qVar.f13666x, i10));
                break;
            case 2:
                y0 y0Var2 = new y0();
                q qVar2 = this.f11555o;
                qVar2.f13648d.d("take picture", CameraState.BIND, new p(qVar2, y0Var2, qVar2.f13665w, i3));
                break;
            case 3:
                int width = getWidth();
                int height = getHeight();
                PointF pointF = pointFArr[0];
                float f10 = width;
                float f11 = height;
                float f12 = pointF.x;
                float f13 = (f10 * 0.05f) / 2.0f;
                float f14 = pointF.y;
                float f15 = (0.05f * f11) / 2.0f;
                RectF rectF = new RectF(f12 - f13, f14 - f15, f12 + f13, f14 + f15);
                ArrayList arrayList = new ArrayList();
                PointF pointF2 = new PointF(rectF.centerX(), rectF.centerY());
                float width2 = rectF.width();
                float height2 = rectF.height();
                arrayList.add(new sf.a(rectF, 1000));
                float f16 = pointF2.x;
                float f17 = (width2 * 1.5f) / 2.0f;
                float f18 = pointF2.y;
                float f19 = (height2 * 1.5f) / 2.0f;
                arrayList.add(new sf.a(new RectF(f16 - f17, f18 - f19, f16 + f17, f18 + f19), Math.round(1000 * 0.1f)));
                ArrayList arrayList2 = new ArrayList();
                int size = arrayList.size();
                int i12 = 0;
                while (i12 < size) {
                    Object obj = arrayList.get(i12);
                    i12++;
                    sf.a aVar2 = (sf.a) obj;
                    aVar2.getClass();
                    RectF rectF2 = new RectF(f2, f2, f10, f11);
                    RectF rectF3 = new RectF();
                    float f20 = rectF2.left;
                    RectF rectF4 = aVar2.f18257a;
                    rectF3.set(Math.max(f20, rectF4.left), Math.max(rectF2.top, rectF4.top), Math.min(rectF2.right, rectF4.right), Math.min(rectF2.bottom, rectF4.bottom));
                    arrayList2.add(new sf.a(rectF3, aVar2.f18258b));
                    f10 = f10;
                    i3 = i3;
                    f2 = 0.0f;
                }
                this.f11555o.N(gesture, new l4.c(arrayList2), pointFArr[i3]);
                break;
            case 4:
                float f21 = this.f11555o.f13662t;
                float a3 = aVar.a(f21, 0.0f, 1.0f);
                if (a3 != f21) {
                    this.f11555o.L(a3, pointFArr, true);
                    break;
                }
                break;
            case 5:
                float f22 = this.f11555o.f13663u;
                float f23 = cVar.f12611m;
                float f24 = cVar.f12612n;
                float a10 = aVar.a(f22, f23, f24);
                if (a10 != f22) {
                    this.f11555o.B(a10, new float[]{f23, f24}, pointFArr, true);
                    break;
                }
                break;
            case 6:
                getFilter();
                break;
            case 7:
                getFilter();
                break;
        }
    }

    public Audio getAudio() {
        return this.f11555o.H;
    }

    public int getAudioBitRate() {
        return this.f11555o.L;
    }

    public AudioCodec getAudioCodec() {
        return this.f11555o.f13659p;
    }

    public long getAutoFocusResetDelay() {
        return this.f11555o.M;
    }

    public ef.c getCameraOptions() {
        return this.f11555o.f13649f;
    }

    public boolean getDrawHardwareOverlays() {
        return this.B.getHardwareCanvasEnabled();
    }

    public Engine getEngine() {
        return this.f11546f;
    }

    public float getExposureCorrection() {
        return this.f11555o.f13663u;
    }

    public Facing getFacing() {
        return this.f11555o.F;
    }

    public a getFilter() {
        Object obj = this.f11553m;
        if (obj == null) {
            return this.f11547g;
        }
        if (obj instanceof vf.b) {
            return ((vf.f) ((vf.b) obj)).f19255q;
        }
        throw new RuntimeException("Filters are only supported by the GL_SURFACE preview. Current:" + this.e);
    }

    public Flash getFlash() {
        return this.f11555o.f13656m;
    }

    public int getFrameProcessingExecutors() {
        return this.f11548h;
    }

    public int getFrameProcessingFormat() {
        return this.f11555o.f13654k;
    }

    public int getFrameProcessingMaxHeight() {
        return this.f11555o.Q;
    }

    public int getFrameProcessingMaxWidth() {
        return this.f11555o.P;
    }

    public int getFrameProcessingPoolSize() {
        return this.f11555o.R;
    }

    public Grid getGrid() {
        return this.f11563x.getGridMode();
    }

    public int getGridColor() {
        return this.f11563x.getGridColor();
    }

    public Hdr getHdr() {
        return this.f11555o.f13660q;
    }

    public Location getLocation() {
        return this.f11555o.f13661s;
    }

    public Mode getMode() {
        return this.f11555o.G;
    }

    public PictureFormat getPictureFormat() {
        return this.f11555o.r;
    }

    public boolean getPictureMetering() {
        return this.f11555o.f13665w;
    }

    public wf.b getPictureSize() {
        return this.f11555o.h(Reference.OUTPUT);
    }

    public boolean getPictureSnapshotMetering() {
        return this.f11555o.f13666x;
    }

    public boolean getPlaySounds() {
        return this.f11542a;
    }

    public Preview getPreview() {
        return this.e;
    }

    public float getPreviewFrameRate() {
        return this.f11555o.f13667y;
    }

    public boolean getPreviewFrameRateExact() {
        return this.f11555o.f13668z;
    }

    public int getSnapshotMaxHeight() {
        return this.f11555o.O;
    }

    public int getSnapshotMaxWidth() {
        return this.f11555o.N;
    }

    public wf.b getSnapshotSize() {
        wf.b bVar = null;
        if (getWidth() != 0 && getHeight() != 0) {
            q qVar = this.f11555o;
            Reference reference = Reference.VIEW;
            wf.b l3 = qVar.l(reference);
            if (l3 == null) {
                return null;
            }
            Rect a3 = com.google.android.gms.internal.mlkit_vision_common.q.a(l3, wf.a.a(getWidth(), getHeight()));
            bVar = new wf.b(a3.width(), a3.height());
            if (this.f11555o.B.b(reference, Reference.OUTPUT)) {
                return bVar.a();
            }
        }
        return bVar;
    }

    public boolean getUseDeviceOrientation() {
        return this.f11543b;
    }

    public int getVideoBitRate() {
        return this.f11555o.K;
    }

    public VideoCodec getVideoCodec() {
        return this.f11555o.f13658o;
    }

    public int getVideoMaxDuration() {
        return this.f11555o.J;
    }

    public long getVideoMaxSize() {
        return this.f11555o.I;
    }

    public wf.b getVideoSize() {
        q qVar = this.f11555o;
        Reference reference = Reference.OUTPUT;
        wf.b bVar = qVar.f13651h;
        if (bVar == null || qVar.G == Mode.PICTURE) {
            return null;
        }
        return qVar.B.b(Reference.SENSOR, reference) ? bVar.a() : bVar;
    }

    public WhiteBalance getWhiteBalance() {
        return this.f11555o.f13657n;
    }

    public float getZoom() {
        return this.f11555o.f13662t;
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onAttachedToWindow() {
        vf.a iVar;
        super.onAttachedToWindow();
        if (!this.A && this.f11553m == null) {
            Object[] objArr = {"doInstantiateEngine:", "instantiating. preview:", this.e};
            b bVar = C;
            bVar.b(2, objArr);
            Preview preview = this.e;
            Context context = getContext();
            int i3 = ef.f.f12618a[preview.ordinal()];
            if (i3 == 1) {
                iVar = new vf.i(context, this);
            } else if (i3 == 2 && isHardwareAccelerated()) {
                iVar = new j(context, this);
            } else {
                this.e = Preview.GL_SURFACE;
                iVar = new vf.f(context, this);
            }
            this.f11553m = iVar;
            bVar.b(2, "doInstantiateEngine:", "instantiated. preview:", iVar.getClass().getSimpleName());
            q qVar = this.f11555o;
            vf.a aVar = this.f11553m;
            vf.a aVar2 = qVar.e;
            if (aVar2 != null) {
                aVar2.n(null);
            }
            qVar.e = aVar;
            aVar.n(qVar);
            a aVar3 = this.f11547g;
            if (aVar3 != null) {
                setFilter(aVar3);
                this.f11547g = null;
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        this.f11556p = null;
        super.onDetachedFromWindow();
    }

    @Override // android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return this.f11549i > 0;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public final void onMeasure(int i3, int i10) {
        if (this.A) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3), 1073741824), View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i10), 1073741824));
            return;
        }
        wf.b j4 = this.f11555o.j(Reference.VIEW);
        this.f11556p = j4;
        b bVar = C;
        if (j4 == null) {
            bVar.b(2, "onMeasure:", "surface is not ready. Calling default behavior.");
            super.onMeasure(i3, i10);
            return;
        }
        int mode = View.MeasureSpec.getMode(i3);
        int mode2 = View.MeasureSpec.getMode(i10);
        int size = View.MeasureSpec.getSize(i3);
        int size2 = View.MeasureSpec.getSize(i10);
        wf.b bVar2 = this.f11556p;
        float f2 = bVar2.f19627a;
        float f10 = bVar2.f19628b;
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (this.f11553m.o()) {
            if (mode == Integer.MIN_VALUE && layoutParams.width == -1) {
                mode = 1073741824;
            }
            if (mode2 == Integer.MIN_VALUE && layoutParams.height == -1) {
                mode2 = 1073741824;
            }
        } else {
            if (mode == 1073741824) {
                mode = Integer.MIN_VALUE;
            }
            if (mode2 == 1073741824) {
                mode2 = Integer.MIN_VALUE;
            }
        }
        StringBuilder q5 = android.support.v4.media.session.e.q(size, "requested dimensions are (", "[");
        q5.append(mode != Integer.MIN_VALUE ? mode != 0 ? mode != 1073741824 ? null : "EXACTLY" : "UNSPECIFIED" : "AT_MOST");
        q5.append("]x");
        q5.append(size2);
        q5.append("[");
        bVar.b(1, "onMeasure:", r5.a.f(q5, mode2 != Integer.MIN_VALUE ? mode2 != 0 ? mode2 != 1073741824 ? null : "EXACTLY" : "UNSPECIFIED" : "AT_MOST", "])"));
        bVar.b(1, "onMeasure:", "previewSize is", "(" + f2 + "x" + f10 + ")");
        if (mode == 1073741824 && mode2 == 1073741824) {
            bVar.b(1, "onMeasure:", "both are MATCH_PARENT or fixed value. We adapt.", "This means CROP_CENTER.", android.support.v4.media.session.e.g(size, "(", size2, "x", ")"));
            super.onMeasure(i3, i10);
            return;
        }
        if (mode == 0 && mode2 == 0) {
            bVar.b(1, "onMeasure:", "both are completely free.", "We respect that and extend to the whole preview size.", "(" + f2 + "x" + f10 + ")");
            super.onMeasure(View.MeasureSpec.makeMeasureSpec((int) f2, 1073741824), View.MeasureSpec.makeMeasureSpec((int) f10, 1073741824));
            return;
        }
        float f11 = f10 / f2;
        if (mode == 0 || mode2 == 0) {
            if (mode == 0) {
                size = Math.round(size2 / f11);
            } else {
                size2 = Math.round(size * f11);
            }
            bVar.b(1, "onMeasure:", "one dimension was free, we adapted it to fit the ratio.", android.support.v4.media.session.e.g(size, "(", size2, "x", ")"));
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            return;
        }
        if (mode == 1073741824 || mode2 == 1073741824) {
            if (mode == Integer.MIN_VALUE) {
                size = Math.min(Math.round(size2 / f11), size);
            } else {
                size2 = Math.min(Math.round(size * f11), size2);
            }
            bVar.b(1, "onMeasure:", "one dimension was EXACTLY, another AT_MOST.", "We have TRIED to fit the aspect ratio, but it's not guaranteed.", android.support.v4.media.session.e.g(size, "(", size2, "x", ")"));
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
            return;
        }
        float f12 = size2;
        float f13 = size;
        if (f12 / f13 >= f11) {
            size2 = Math.round(f13 * f11);
        } else {
            size = Math.round(f12 / f11);
        }
        bVar.b(1, "onMeasure:", "both dimension were AT_MOST.", "We fit the preview aspect ratio.", android.support.v4.media.session.e.g(size, "(", size2, "x", ")"));
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(size, 1073741824), View.MeasureSpec.makeMeasureSpec(size2, 1073741824));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        boolean z5;
        boolean z6;
        if (e()) {
            ef.c cVar = this.f11555o.f13649f;
            if (cVar == null) {
                throw new IllegalStateException("Options should not be null here.");
            }
            d dVar = this.f11560u;
            boolean z8 = false;
            if (dVar.f11595a) {
                dVar.getClass();
                z5 = false;
                if (motionEvent.getAction() == 0) {
                    dVar.e = false;
                }
                dVar.f11603d.onTouchEvent(motionEvent);
                if (dVar.e) {
                    PointF[] pointFArr = dVar.f11597c;
                    pointFArr[0].x = motionEvent.getX(0);
                    pointFArr[0].y = motionEvent.getY(0);
                    z5 = true;
                    if (motionEvent.getPointerCount() > 1) {
                        pointFArr[1].x = motionEvent.getX(1);
                        pointFArr[1].y = motionEvent.getY(1);
                    }
                }
            } else {
                z5 = false;
            }
            b bVar = C;
            if (z5) {
                bVar.b(1, "onTouchEvent", "pinch!");
                g(this.f11560u, cVar);
                return true;
            }
            f fVar = this.f11562w;
            if (fVar.f11595a) {
                fVar.getClass();
                if (motionEvent.getAction() == 0) {
                    fVar.e = false;
                }
                fVar.f11608d.onTouchEvent(motionEvent);
                if (fVar.e) {
                    f.f11607g.b(1, "Notifying a gesture of type", fVar.f11596b.name());
                }
                z6 = fVar.e;
            } else {
                z6 = false;
            }
            if (z6) {
                bVar.b(1, "onTouchEvent", "scroll!");
                g(this.f11562w, cVar);
                return true;
            }
            com.otaliastudios.cameraview.gesture.g gVar = this.f11561v;
            if (gVar.f11595a) {
                gVar.getClass();
                if (motionEvent.getAction() == 0) {
                    gVar.e = false;
                }
                gVar.f11610d.onTouchEvent(motionEvent);
                if (gVar.e) {
                    PointF[] pointFArr2 = gVar.f11597c;
                    pointFArr2[0].x = motionEvent.getX();
                    pointFArr2[0].y = motionEvent.getY();
                    z8 = true;
                } else {
                    z8 = false;
                }
            }
            if (z8) {
                bVar.b(1, "onTouchEvent", "tap!");
                g(this.f11561v, cVar);
            }
        }
        return true;
    }

    @d0(Lifecycle$Event.ON_RESUME)
    public void open() {
        if (this.A) {
            return;
        }
        vf.a aVar = this.f11553m;
        if (aVar != null) {
            aVar.k();
        }
        if (a(getAudio())) {
            g gVar = this.f11554n;
            if (!gVar.f17952h) {
                gVar.f17952h = true;
                gVar.f17951g = gVar.a();
                ((DisplayManager) gVar.f17947b.getSystemService("display")).registerDisplayListener(gVar.f17950f, gVar.f17946a);
                gVar.f17949d.enable();
            }
            lf.b bVar = this.f11555o.B;
            int i3 = this.f11554n.f17951g;
            bVar.getClass();
            lf.b.e(i3);
            bVar.f15872c = i3;
            bVar.d();
            this.f11555o.M();
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (!this.A && layoutParams != null) {
            this.B.getClass();
            if (layoutParams instanceof tf.d) {
                this.B.removeView(view);
                return;
            }
        }
        super.removeView(view);
    }

    public void set(com.otaliastudios.cameraview.controls.a aVar) {
        if (aVar instanceof Audio) {
            setAudio((Audio) aVar);
            return;
        }
        if (aVar instanceof Facing) {
            setFacing((Facing) aVar);
            return;
        }
        if (aVar instanceof Flash) {
            setFlash((Flash) aVar);
            return;
        }
        if (aVar instanceof Grid) {
            setGrid((Grid) aVar);
            return;
        }
        if (aVar instanceof Hdr) {
            setHdr((Hdr) aVar);
            return;
        }
        if (aVar instanceof Mode) {
            setMode((Mode) aVar);
            return;
        }
        if (aVar instanceof WhiteBalance) {
            setWhiteBalance((WhiteBalance) aVar);
            return;
        }
        if (aVar instanceof VideoCodec) {
            setVideoCodec((VideoCodec) aVar);
            return;
        }
        if (aVar instanceof AudioCodec) {
            setAudioCodec((AudioCodec) aVar);
            return;
        }
        if (aVar instanceof Preview) {
            setPreview((Preview) aVar);
        } else if (aVar instanceof Engine) {
            setEngine((Engine) aVar);
        } else if (aVar instanceof PictureFormat) {
            setPictureFormat((PictureFormat) aVar);
        }
    }

    public void setAudio(Audio audio) {
        if (audio != getAudio()) {
            q qVar = this.f11555o;
            if (qVar.f13648d.e != CameraState.OFF || qVar.n()) {
                if (!a(audio)) {
                    close();
                    return;
                }
                q qVar2 = this.f11555o;
                if (qVar2.H != audio) {
                    qVar2.H = audio;
                    return;
                }
                return;
            }
        }
        q qVar3 = this.f11555o;
        if (qVar3.H != audio) {
            qVar3.H = audio;
        }
    }

    public void setAudioBitRate(int i3) {
        this.f11555o.L = i3;
    }

    public void setAudioCodec(AudioCodec audioCodec) {
        this.f11555o.f13659p = audioCodec;
    }

    public void setAutoFocusMarker(rf.a aVar) {
        MarkerLayout markerLayout = this.f11564y;
        HashMap hashMap = markerLayout.f11616a;
        View view = (View) hashMap.get(1);
        if (view != null) {
            markerLayout.removeView(view);
        }
        if (aVar == null) {
            return;
        }
        markerLayout.getContext();
        View a3 = aVar.a();
        if (a3 != null) {
            hashMap.put(1, a3);
            markerLayout.addView(a3);
        }
    }

    public void setAutoFocusResetDelay(long j4) {
        this.f11555o.M = j4;
    }

    public void setDrawHardwareOverlays(boolean z5) {
        this.B.setHardwareCanvasEnabled(z5);
    }

    public void setEngine(Engine engine) {
        q qVar = this.f11555o;
        if (qVar.f13648d.e != CameraState.OFF || qVar.n()) {
            return;
        }
        this.f11546f = engine;
        q qVar2 = this.f11555o;
        b();
        vf.a aVar = this.f11553m;
        if (aVar != null) {
            q qVar3 = this.f11555o;
            vf.a aVar2 = qVar3.e;
            if (aVar2 != null) {
                aVar2.n(null);
            }
            qVar3.e = aVar;
            aVar.n(qVar3);
        }
        setFacing(qVar2.F);
        setFlash(qVar2.f13656m);
        setMode(qVar2.G);
        setWhiteBalance(qVar2.f13657n);
        setHdr(qVar2.f13660q);
        setAudio(qVar2.H);
        setAudioBitRate(qVar2.L);
        setAudioCodec(qVar2.f13659p);
        setPictureSize(qVar2.D);
        setPictureFormat(qVar2.r);
        setVideoSize(qVar2.E);
        setVideoCodec(qVar2.f13658o);
        setVideoMaxSize(qVar2.I);
        setVideoMaxDuration(qVar2.J);
        setVideoBitRate(qVar2.K);
        setAutoFocusResetDelay(qVar2.M);
        setPreviewFrameRate(qVar2.f13667y);
        setPreviewFrameRateExact(qVar2.f13668z);
        setSnapshotMaxWidth(qVar2.N);
        setSnapshotMaxHeight(qVar2.O);
        setFrameProcessingMaxWidth(qVar2.P);
        setFrameProcessingMaxHeight(qVar2.Q);
        setFrameProcessingFormat(0);
        setFrameProcessingPoolSize(qVar2.R);
        this.f11555o.E(!this.f11558s.isEmpty());
    }

    public void setExperimental(boolean z5) {
        this.f11565z = z5;
    }

    public void setExposureCorrection(float f2) {
        ef.c cameraOptions = getCameraOptions();
        if (cameraOptions != null) {
            float f10 = cameraOptions.f12611m;
            float f11 = cameraOptions.f12612n;
            if (f2 < f10) {
                f2 = f10;
            }
            if (f2 > f11) {
                f2 = f11;
            }
            this.f11555o.B(f2, new float[]{f10, f11}, null, false);
        }
    }

    public void setFacing(Facing facing) {
        q qVar = this.f11555o;
        Facing facing2 = qVar.F;
        if (facing != facing2) {
            qVar.F = facing;
            qVar.f13648d.d("facing", CameraState.ENGINE, new e8.a(qVar, facing, facing2, 2, false));
        }
    }

    public void setFilter(a aVar) {
        Object obj = this.f11553m;
        if (obj == null) {
            this.f11547g = aVar;
            return;
        }
        boolean z5 = obj instanceof vf.b;
        if (!(aVar instanceof of.b) && !z5) {
            throw new RuntimeException("Filters are only supported by the GL_SURFACE preview. Current preview:" + this.e);
        }
        if (z5) {
            vf.f fVar = (vf.f) ((vf.b) obj);
            fVar.f19255q = aVar;
            if (fVar.g()) {
                int i3 = fVar.f19239d;
                int i10 = fVar.e;
                of.b bVar = (of.b) aVar;
                bVar.getClass();
                bVar.f16926c = new wf.b(i3, i10);
            }
            ((GLSurfaceView) fVar.f19237b).queueEvent(new ia.j(22, fVar, aVar));
        }
    }

    public void setFlash(Flash flash) {
        this.f11555o.C(flash);
    }

    public void setFrameProcessingExecutors(int i3) {
        if (i3 < 1) {
            throw new IllegalArgumentException(l0.j(i3, "Need at least 1 executor, got "));
        }
        this.f11548h = i3;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i3, i3, 4L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ef.e(0));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.f11551k = threadPoolExecutor;
    }

    public void setFrameProcessingFormat(int i3) {
        this.f11555o.D(i3);
    }

    public void setFrameProcessingMaxHeight(int i3) {
        this.f11555o.Q = i3;
    }

    public void setFrameProcessingMaxWidth(int i3) {
        this.f11555o.P = i3;
    }

    public void setFrameProcessingPoolSize(int i3) {
        this.f11555o.R = i3;
    }

    public void setGrid(Grid grid) {
        this.f11563x.setGridMode(grid);
    }

    public void setGridColor(int i3) {
        this.f11563x.setGridColor(i3);
    }

    public void setHdr(Hdr hdr) {
        this.f11555o.F(hdr);
    }

    public void setLifecycleOwner(s sVar) {
        if (sVar == null) {
            n nVar = this.f11559t;
            if (nVar != null) {
                nVar.b(this);
                this.f11559t = null;
                return;
            }
            return;
        }
        n nVar2 = this.f11559t;
        if (nVar2 != null) {
            nVar2.b(this);
            this.f11559t = null;
        }
        n lifecycle = sVar.getLifecycle();
        this.f11559t = lifecycle;
        lifecycle.a(this);
    }

    public void setLocation(Location location) {
        this.f11555o.G(location);
    }

    public void setMode(Mode mode) {
        q qVar = this.f11555o;
        if (mode != qVar.G) {
            qVar.G = mode;
            qVar.f13648d.d("mode", CameraState.ENGINE, new o(qVar, 0));
        }
    }

    public void setPictureFormat(PictureFormat pictureFormat) {
        this.f11555o.H(pictureFormat);
    }

    public void setPictureMetering(boolean z5) {
        this.f11555o.f13665w = z5;
    }

    public void setPictureSize(c cVar) {
        this.f11555o.D = cVar;
    }

    public void setPictureSnapshotMetering(boolean z5) {
        this.f11555o.f13666x = z5;
    }

    public void setPlaySounds(boolean z5) {
        this.f11542a = z5;
        this.f11555o.I(z5);
    }

    public void setPreview(Preview preview) {
        vf.a aVar;
        if (preview != this.e) {
            this.e = preview;
            if (getWindowToken() == null && (aVar = this.f11553m) != null) {
                aVar.i();
                this.f11553m = null;
            }
        }
    }

    public void setPreviewFrameRate(float f2) {
        this.f11555o.J(f2);
    }

    public void setPreviewFrameRateExact(boolean z5) {
        this.f11555o.f13668z = z5;
    }

    public void setPreviewStreamSize(c cVar) {
        this.f11555o.C = cVar;
    }

    public void setRequestPermissions(boolean z5) {
        this.f11544c = z5;
    }

    public void setSnapshotMaxHeight(int i3) {
        this.f11555o.O = i3;
    }

    public void setSnapshotMaxWidth(int i3) {
        this.f11555o.N = i3;
    }

    public void setUseDeviceOrientation(boolean z5) {
        this.f11543b = z5;
    }

    public void setVideoBitRate(int i3) {
        this.f11555o.K = i3;
    }

    public void setVideoCodec(VideoCodec videoCodec) {
        this.f11555o.f13658o = videoCodec;
    }

    public void setVideoMaxDuration(int i3) {
        this.f11555o.J = i3;
    }

    public void setVideoMaxSize(long j4) {
        this.f11555o.I = j4;
    }

    public void setVideoSize(c cVar) {
        this.f11555o.E = cVar;
    }

    public void setWhiteBalance(WhiteBalance whiteBalance) {
        this.f11555o.K(whiteBalance);
    }

    public void setZoom(float f2) {
        if (f2 < 0.0f) {
            f2 = 0.0f;
        }
        if (f2 > 1.0f) {
            f2 = 1.0f;
        }
        this.f11555o.L(f2, null, false);
    }

    @Override // android.widget.FrameLayout, android.view.ViewGroup
    public final FrameLayout.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        if (!this.A) {
            OverlayLayout overlayLayout = this.B;
            if (attributeSet == null) {
                overlayLayout.getClass();
            } else {
                TypedArray obtainStyledAttributes = overlayLayout.getContext().obtainStyledAttributes(attributeSet, R$styleable.CameraView_Layout);
                r1 = obtainStyledAttributes.hasValue(R$styleable.CameraView_Layout_layout_drawOnPreview) || obtainStyledAttributes.hasValue(R$styleable.CameraView_Layout_layout_drawOnPictureSnapshot) || obtainStyledAttributes.hasValue(R$styleable.CameraView_Layout_layout_drawOnVideoSnapshot);
                obtainStyledAttributes.recycle();
            }
            if (r1) {
                return this.B.generateLayoutParams(attributeSet);
            }
        }
        return super.generateLayoutParams(attributeSet);
    }

    public CameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f11545d = new HashMap(4);
        this.r = new CopyOnWriteArrayList();
        this.f11558s = new CopyOnWriteArrayList();
        d(context, attributeSet);
    }
}
