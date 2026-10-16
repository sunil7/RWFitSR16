package com.google.android.exoplayer2.video.spherical;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLSurfaceView;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.View;
import android.view.WindowManager;
import androidx.activity.b;
import j9.e;
import java.util.concurrent.CopyOnWriteArrayList;
import k9.a;
import k9.c;
import k9.g;
import k9.h;
import k9.i;

/* loaded from: classes.dex */
public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f9055l = 0;

    /* renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList f9056a;

    /* renamed from: b, reason: collision with root package name */
    public final SensorManager f9057b;

    /* renamed from: c, reason: collision with root package name */
    public final Sensor f9058c;

    /* renamed from: d, reason: collision with root package name */
    public final c f9059d;
    public final Handler e;

    /* renamed from: f, reason: collision with root package name */
    public final g f9060f;

    /* renamed from: g, reason: collision with root package name */
    public SurfaceTexture f9061g;

    /* renamed from: h, reason: collision with root package name */
    public Surface f9062h;

    /* renamed from: i, reason: collision with root package name */
    public boolean f9063i;

    /* renamed from: j, reason: collision with root package name */
    public boolean f9064j;

    /* renamed from: k, reason: collision with root package name */
    public boolean f9065k;

    public SphericalGLSurfaceView(Context context) {
        this(context, null);
    }

    public final void a() {
        boolean z5 = this.f9063i && this.f9064j;
        Sensor sensor = this.f9058c;
        if (sensor == null || z5 == this.f9065k) {
            return;
        }
        c cVar = this.f9059d;
        SensorManager sensorManager = this.f9057b;
        if (z5) {
            sensorManager.registerListener(cVar, sensor, 0);
        } else {
            sensorManager.unregisterListener(cVar);
        }
        this.f9065k = z5;
    }

    public a getCameraMotionListener() {
        return this.f9060f;
    }

    public e getVideoFrameMetadataListener() {
        return this.f9060f;
    }

    public Surface getVideoSurface() {
        return this.f9062h;
    }

    @Override // android.opengl.GLSurfaceView, android.view.SurfaceView, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.e.post(new b(this, 29));
    }

    @Override // android.opengl.GLSurfaceView
    public final void onPause() {
        this.f9064j = false;
        a();
        super.onPause();
    }

    @Override // android.opengl.GLSurfaceView
    public final void onResume() {
        super.onResume();
        this.f9064j = true;
        a();
    }

    public void setDefaultStereoMode(int i3) {
        this.f9060f.getClass();
    }

    public void setUseSensorRotation(boolean z5) {
        this.f9063i = z5;
        a();
    }

    public SphericalGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f9056a = new CopyOnWriteArrayList();
        this.e = new Handler(Looper.getMainLooper());
        Object systemService = context.getSystemService("sensor");
        systemService.getClass();
        SensorManager sensorManager = (SensorManager) systemService;
        this.f9057b = sensorManager;
        Sensor defaultSensor = i9.g.f14378a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f9058c = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        g gVar = new g(0);
        this.f9060f = gVar;
        h hVar = new h(this, gVar);
        View.OnTouchListener iVar = new i(context, hVar);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        windowManager.getClass();
        this.f9059d = new c(windowManager.getDefaultDisplay(), iVar, hVar);
        this.f9063i = true;
        setEGLContextClientVersion(2);
        setRenderer(hVar);
        setOnTouchListener(iVar);
    }
}
