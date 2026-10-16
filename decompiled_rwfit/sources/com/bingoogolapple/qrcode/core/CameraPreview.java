package com.bingoogolapple.qrcode.core;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.hardware.Camera;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import com.google.android.gms.internal.mlkit_vision_common.c0;
import java.util.Collections;
import java.util.Iterator;
import mc.g;
import n.l;
import t3.a;

/* loaded from: classes.dex */
public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: h, reason: collision with root package name */
    public static final /* synthetic */ int f6852h = 0;

    /* renamed from: a, reason: collision with root package name */
    public Camera f6853a;

    /* renamed from: b, reason: collision with root package name */
    public boolean f6854b;

    /* renamed from: c, reason: collision with root package name */
    public boolean f6855c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f6856d;
    public float e;

    /* renamed from: f, reason: collision with root package name */
    public l f6857f;

    /* renamed from: g, reason: collision with root package name */
    public a f6858g;

    public CameraPreview(Context context) {
        super(context);
        this.f6854b = false;
        this.f6855c = false;
        this.f6856d = false;
        this.e = 1.0f;
        getHolder().addCallback(this);
    }

    public static void b(boolean z5, Camera camera) {
        try {
            Camera.Parameters parameters = camera.getParameters();
            if (parameters.isZoomSupported()) {
                int zoom = parameters.getZoom();
                if (z5 && zoom < parameters.getMaxZoom()) {
                    zoom++;
                } else if (!z5 && zoom > 0) {
                    zoom--;
                }
                parameters.setZoom(zoom);
                camera.setParameters(parameters);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void a(float f2, float f10, int i3, int i10) {
        boolean z5;
        try {
            Camera.Parameters parameters = this.f6853a.getParameters();
            Camera.Size previewSize = parameters.getPreviewSize();
            boolean z6 = true;
            if (parameters.getMaxNumFocusAreas() > 0) {
                Rect c9 = c0.c(1.0f, f2, f10, i3, i10, previewSize.width, previewSize.height);
                c0.j(c9);
                parameters.setFocusAreas(Collections.singletonList(new Camera.Area(c9, 1000)));
                parameters.setFocusMode("macro");
                z5 = true;
            } else {
                z5 = false;
            }
            if (parameters.getMaxNumMeteringAreas() > 0) {
                Rect c10 = c0.c(1.5f, f2, f10, i3, i10, previewSize.width, previewSize.height);
                c0.j(c10);
                parameters.setMeteringAreas(Collections.singletonList(new Camera.Area(c10, 1000)));
            } else {
                z6 = z5;
            }
            if (!z6) {
                this.f6856d = false;
                return;
            }
            this.f6853a.cancelAutoFocus();
            this.f6853a.setParameters(parameters);
            this.f6853a.autoFocus(new ff.a(this, 1));
        } catch (Exception e) {
            e.printStackTrace();
            e.getMessage();
            e();
        }
    }

    public final boolean c() {
        return this.f6853a != null && this.f6854b && this.f6855c;
    }

    public final void d() {
        if (this.f6853a != null) {
            try {
                this.f6854b = true;
                SurfaceHolder holder = getHolder();
                holder.setKeepScreenOn(true);
                this.f6853a.setPreviewDisplay(holder);
                this.f6857f.s(this.f6853a);
                this.f6853a.startPreview();
                a aVar = this.f6858g;
                if (aVar != null) {
                    long[] jArr = QRCodeView.f6859o;
                    QRCodeView qRCodeView = (QRCodeView) ((g) aVar).f16022b;
                    if (qRCodeView.e && qRCodeView.f6861b.c()) {
                        try {
                            qRCodeView.f6860a.setOneShotPreviewCallback(qRCodeView);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
                e();
            } catch (Exception e10) {
                e10.printStackTrace();
            }
        }
    }

    public final void e() {
        this.f6856d = false;
        Camera camera = this.f6853a;
        if (camera == null) {
            return;
        }
        try {
            Camera.Parameters parameters = camera.getParameters();
            parameters.setFocusMode("continuous-picture");
            this.f6853a.setParameters(parameters);
            this.f6853a.cancelAutoFocus();
        } catch (Exception unused) {
        }
    }

    public final void f() {
        Camera camera = this.f6853a;
        if (camera != null) {
            try {
                this.f6854b = false;
                camera.cancelAutoFocus();
                this.f6853a.setOneShotPreviewCallback(null);
                this.f6853a.stopPreview();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override // android.view.SurfaceView, android.view.View
    public final void onMeasure(int i3, int i10) {
        Point point;
        int defaultSize = View.getDefaultSize(getSuggestedMinimumWidth(), i3);
        int defaultSize2 = View.getDefaultSize(getSuggestedMinimumHeight(), i10);
        l lVar = this.f6857f;
        if (lVar != null && (point = (Point) lVar.f16246c) != null) {
            float f2 = defaultSize;
            float f10 = defaultSize2;
            float f11 = (f2 * 1.0f) / f10;
            float f12 = point.x;
            float f13 = point.y;
            float f14 = (f12 * 1.0f) / f13;
            if (f11 < f14) {
                defaultSize = (int) ((f10 / ((f13 * 1.0f) / f12)) + 0.5f);
            } else {
                defaultSize2 = (int) ((f2 / f14) + 0.5f);
            }
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(defaultSize, 1073741824), View.MeasureSpec.makeMeasureSpec(defaultSize2, 1073741824));
    }

    @Override // android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!c()) {
            return super.onTouchEvent(motionEvent);
        }
        if (motionEvent.getPointerCount() == 1 && (motionEvent.getAction() & 255) == 1) {
            if (!this.f6856d) {
                this.f6856d = true;
                float x10 = motionEvent.getX();
                float y4 = motionEvent.getY();
                if (c0.h(getContext())) {
                    y4 = x10;
                    x10 = y4;
                }
                int d5 = c0.d(getContext(), 120.0f);
                a(x10, y4, d5, d5);
            }
            return true;
        }
        if (motionEvent.getPointerCount() == 2) {
            int action = motionEvent.getAction() & 255;
            if (action == 2) {
                float b3 = c0.b(motionEvent);
                float f2 = this.e;
                if (b3 > f2) {
                    b(true, this.f6853a);
                    return true;
                }
                if (b3 < f2) {
                    b(false, this.f6853a);
                }
            } else if (action == 5) {
                this.e = c0.b(motionEvent);
                return true;
            }
        }
        return true;
    }

    public void setCamera(Camera camera) {
        this.f6853a = camera;
        if (camera != null) {
            Context context = getContext();
            l lVar = new l(context);
            this.f6857f = lVar;
            Camera camera2 = this.f6853a;
            Point f2 = c0.f(context);
            Point point = new Point();
            point.x = f2.x;
            point.y = f2.y;
            if (c0.h(context)) {
                point.x = f2.y;
                point.y = f2.x;
            }
            Iterator<Camera.Size> it = camera2.getParameters().getSupportedPreviewSizes().iterator();
            int i3 = 0;
            int i10 = Integer.MAX_VALUE;
            int i11 = 0;
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Camera.Size next = it.next();
                int i12 = next.width;
                int i13 = next.height;
                int abs = Math.abs(i13 - point.y) + Math.abs(i12 - point.x);
                if (abs == 0) {
                    i11 = i13;
                    i3 = i12;
                    break;
                } else if (abs < i10) {
                    i11 = i13;
                    i3 = i12;
                    i10 = abs;
                }
            }
            Point point2 = (i3 <= 0 || i11 <= 0) ? null : new Point(i3, i11);
            if (point2 == null) {
                point2 = new Point((point.x >> 3) << 3, (point.y >> 3) << 3);
            }
            lVar.f16247d = point2;
            if (c0.h(context)) {
                Point point3 = (Point) lVar.f16247d;
                lVar.f16246c = new Point(point3.y, point3.x);
            } else {
                lVar.f16246c = (Point) lVar.f16247d;
            }
            if (this.f6854b) {
                requestLayout();
            } else {
                d();
            }
        }
    }

    public void setDelegate(a aVar) {
        this.f6858g = aVar;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i10, int i11) {
        if (surfaceHolder.getSurface() == null) {
            return;
        }
        f();
        d();
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        this.f6855c = true;
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f6855c = false;
        f();
    }
}
