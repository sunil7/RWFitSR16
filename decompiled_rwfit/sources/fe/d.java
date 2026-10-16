package fe;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.util.Rational;
import android.view.MotionEvent;
import android.view.View;
import androidx.activity.ComponentActivity;
import androidx.camera.lifecycle.LifecycleCamera;
import androidx.camera.view.PreviewView;
import androidx.lifecycle.b0;
import com.example.test.ui.device.activity.i0;
import com.google.android.gms.internal.mlkit_vision_common.r;
import com.king.camera.scan.BaseCameraScanActivity;
import com.king.logx.LogX;
import de.o;
import h0.f;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import t.t0;
import t.u0;
import t.v;

/* loaded from: classes.dex */
public final class d {

    /* renamed from: a, reason: collision with root package name */
    public final ComponentActivity f13577a;

    /* renamed from: b, reason: collision with root package name */
    public final ComponentActivity f13578b;

    /* renamed from: c, reason: collision with root package name */
    public final PreviewView f13579c;
    public final ie.c e;

    /* renamed from: f, reason: collision with root package name */
    public x.b f13581f;

    /* renamed from: g, reason: collision with root package name */
    public LifecycleCamera f13582g;

    /* renamed from: h, reason: collision with root package name */
    public he.b f13583h;

    /* renamed from: i, reason: collision with root package name */
    public o f13584i;

    /* renamed from: k, reason: collision with root package name */
    public volatile boolean f13586k;

    /* renamed from: l, reason: collision with root package name */
    public View f13587l;

    /* renamed from: m, reason: collision with root package name */
    public final b0 f13588m;

    /* renamed from: n, reason: collision with root package name */
    public BaseCameraScanActivity f13589n;

    /* renamed from: o, reason: collision with root package name */
    public final i0 f13590o;

    /* renamed from: p, reason: collision with root package name */
    public final je.d f13591p;

    /* renamed from: q, reason: collision with root package name */
    public final je.b f13592q;
    public long r;

    /* renamed from: s, reason: collision with root package name */
    public boolean f13593s;

    /* renamed from: t, reason: collision with root package name */
    public float f13594t;

    /* renamed from: u, reason: collision with root package name */
    public float f13595u;

    /* renamed from: j, reason: collision with root package name */
    public volatile boolean f13585j = true;

    /* renamed from: d, reason: collision with root package name */
    public final ExecutorService f13580d = Executors.newSingleThreadExecutor();

    public d(BaseCameraScanActivity baseCameraScanActivity, PreviewView previewView) {
        Sensor sensor;
        this.f13577a = baseCameraScanActivity;
        this.f13578b = baseCameraScanActivity;
        this.f13579c = previewView;
        b0 b0Var = new b0();
        this.f13588m = b0Var;
        b0Var.e(baseCameraScanActivity, new b(this));
        this.f13590o = new i0(this, 16);
        this.e = new ie.c(baseCameraScanActivity, new b(this));
        previewView.setOnTouchListener(new View.OnTouchListener() { // from class: fe.c
            @Override // android.view.View.OnTouchListener
            public final boolean onTouch(View view, MotionEvent motionEvent) {
                float f2;
                float f10;
                PointF pointF;
                d dVar = d.this;
                dVar.getClass();
                if (motionEvent.getPointerCount() == 1) {
                    int action = motionEvent.getAction();
                    if (action == 0) {
                        dVar.f13593s = true;
                        dVar.f13594t = motionEvent.getX();
                        dVar.f13595u = motionEvent.getY();
                        dVar.r = System.currentTimeMillis();
                    } else if (action != 1) {
                        if (action == 2) {
                            float f11 = dVar.f13594t;
                            float f12 = dVar.f13595u;
                            float x10 = f11 - motionEvent.getX();
                            float y4 = f12 - motionEvent.getY();
                            dVar.f13593s = ((float) Math.sqrt((double) ((y4 * y4) + (x10 * x10)))) < 20.0f;
                        }
                    } else if (dVar.f13593s && dVar.r + 150 > System.currentTimeMillis()) {
                        float x11 = motionEvent.getX();
                        float y10 = motionEvent.getY();
                        if (dVar.f13582g != null) {
                            u0 meteringPointFactory = dVar.f13579c.getMeteringPointFactory();
                            meteringPointFactory.getClass();
                            f fVar = (f) meteringPointFactory;
                            float[] fArr = {x11, y10};
                            synchronized (fVar) {
                                try {
                                    Matrix matrix = fVar.f14227d;
                                    if (matrix == null) {
                                        pointF = f.e;
                                    } else {
                                        matrix.mapPoints(fArr);
                                        pointF = new PointF(fArr[0], fArr[1]);
                                    }
                                } finally {
                                }
                            }
                            float f13 = pointF.x;
                            float f14 = pointF.y;
                            Rational rational = meteringPointFactory.f18416a;
                            t0 t0Var = new t0();
                            t0Var.f18413a = f13;
                            t0Var.f18414b = f14;
                            t0Var.f18415c = rational;
                            v vVar = new v(new v(t0Var));
                            if (dVar.f13582g.f1546c.f19853q.f1433b.m(vVar)) {
                                dVar.f13582g.f1546c.f19852p.b(vVar);
                                LogX.d("startFocusAndMetering: %f, %f", Float.valueOf(x11), Float.valueOf(y10));
                            }
                        }
                    }
                }
                ie.c cVar = dVar.e;
                cVar.getClass();
                motionEvent.getEventTime();
                int actionMasked = motionEvent.getActionMasked();
                if (cVar.f14411c) {
                    cVar.f14419l.onTouchEvent(motionEvent);
                }
                int pointerCount = motionEvent.getPointerCount();
                boolean z5 = (motionEvent.getButtonState() & 32) != 0;
                boolean z6 = cVar.f14418k == 2 && !z5;
                boolean z8 = actionMasked == 1 || actionMasked == 3 || z6;
                b bVar = cVar.f14410b;
                float f15 = 0.0f;
                if (actionMasked == 0 || z8) {
                    if (cVar.f14414g) {
                        cVar.a();
                        bVar.b(new ie.a());
                        cVar.f14414g = false;
                        cVar.f14415h = 0.0f;
                        cVar.f14418k = 0;
                    } else if (cVar.b() && z8) {
                        cVar.f14414g = false;
                        cVar.f14415h = 0.0f;
                        cVar.f14418k = 0;
                    }
                    if (z8) {
                        return true;
                    }
                }
                if (!cVar.f14414g && cVar.f14412d && !cVar.b() && !z8 && z5) {
                    cVar.f14416i = motionEvent.getX();
                    cVar.f14417j = motionEvent.getY();
                    cVar.f14418k = 2;
                    cVar.f14415h = 0.0f;
                }
                boolean z10 = actionMasked == 0 || actionMasked == 6 || actionMasked == 5 || z6;
                boolean z11 = actionMasked == 6;
                int actionIndex = z11 ? motionEvent.getActionIndex() : -1;
                int i3 = z11 ? pointerCount - 1 : pointerCount;
                if (cVar.b()) {
                    f10 = cVar.f14416i;
                    f2 = cVar.f14417j;
                    cVar.f14420m = motionEvent.getY() < f2;
                } else {
                    float f16 = 0.0f;
                    float f17 = 0.0f;
                    for (int i10 = 0; i10 < pointerCount; i10++) {
                        if (actionIndex != i10) {
                            f16 = motionEvent.getX(i10) + f16;
                            f17 = motionEvent.getY(i10) + f17;
                        }
                    }
                    float f18 = i3;
                    float f19 = f16 / f18;
                    f2 = f17 / f18;
                    f10 = f19;
                }
                float f20 = 0.0f;
                for (int i11 = 0; i11 < pointerCount; i11++) {
                    if (actionIndex != i11) {
                        float abs = Math.abs(motionEvent.getX(i11) - f10) + f15;
                        f20 = Math.abs(motionEvent.getY(i11) - f2) + f20;
                        f15 = abs;
                    }
                }
                float f21 = i3;
                float f22 = f15 / f21;
                float f23 = f20 / f21;
                float f24 = 2;
                float f25 = f22 * f24;
                float f26 = f23 * f24;
                if (!cVar.b()) {
                    f26 = (float) Math.hypot(f25, f26);
                }
                boolean z12 = cVar.f14414g;
                r.a(f10);
                r.a(f2);
                if (!cVar.b() && cVar.f14414g && (f26 < 0 || z10)) {
                    cVar.a();
                    bVar.b(new ie.a());
                    cVar.f14414g = false;
                    cVar.f14415h = f26;
                }
                if (z10) {
                    cVar.e = f26;
                    cVar.f14413f = f26;
                    cVar.f14415h = f26;
                }
                boolean b3 = cVar.b();
                int i12 = cVar.f14409a;
                int i13 = b3 ? i12 : 0;
                if (!cVar.f14414g && f26 >= i13 && (z12 || Math.abs(f26 - cVar.f14415h) > i12)) {
                    cVar.e = f26;
                    cVar.f14413f = f26;
                    bVar.b(new ie.a());
                    cVar.f14414g = true;
                }
                if (actionMasked != 2) {
                    return true;
                }
                cVar.e = f26;
                if (cVar.f14414g) {
                    bVar.b(new ie.b(cVar.a()));
                }
                cVar.f14413f = cVar.e;
                return true;
            }
        });
        this.f13591p = new je.d(baseCameraScanActivity.getApplicationContext());
        je.b bVar = new je.b(baseCameraScanActivity.getApplicationContext());
        this.f13592q = bVar;
        SensorManager sensorManager = bVar.f15416a;
        if (sensorManager != null && (sensor = bVar.f15417b) != null) {
            sensorManager.registerListener(bVar, sensor, 3);
        }
        this.f13592q.setOnLightSensorEventListener(new b(this));
    }

    public final boolean a() {
        Integer num;
        LifecycleCamera lifecycleCamera = this.f13582g;
        return (lifecycleCamera == null || (num = (Integer) lifecycleCamera.f1546c.f19853q.f1433b.e().d()) == null || num.intValue() != 1) ? false : true;
    }
}
