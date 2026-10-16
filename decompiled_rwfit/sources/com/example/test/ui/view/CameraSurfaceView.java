package com.example.test.ui.view;

import android.content.Context;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.WindowManager;
import android.widget.RelativeLayout;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public class CameraSurfaceView extends SurfaceView implements SurfaceHolder.Callback, Camera.AutoFocusCallback {

    /* renamed from: a, reason: collision with root package name */
    public Camera f8351a;

    /* renamed from: b, reason: collision with root package name */
    public final int f8352b;

    /* renamed from: c, reason: collision with root package name */
    public final int f8353c;

    /* renamed from: d, reason: collision with root package name */
    public boolean f8354d;

    public CameraSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        this.f8352b = displayMetrics.widthPixels;
        this.f8353c = displayMetrics.heightPixels;
        SurfaceHolder holder = getHolder();
        holder.addCallback(this);
        holder.setType(3);
    }

    public static Camera.Size a(List list, float f2) {
        Camera.Size size;
        Iterator it = list.iterator();
        while (true) {
            if (!it.hasNext()) {
                size = null;
                break;
            }
            size = (Camera.Size) it.next();
            if ((size.width / size.height) - f2 == 0.0f) {
                break;
            }
        }
        if (size == null) {
            Iterator it2 = list.iterator();
            while (it2.hasNext()) {
                Camera.Size size2 = (Camera.Size) it2.next();
                if (size2.width / size2.height == 1.3333334f) {
                    return size2;
                }
            }
        }
        return size;
    }

    @Override // android.hardware.Camera.AutoFocusCallback
    public final void onAutoFocus(boolean z5, Camera camera) {
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceChanged(SurfaceHolder surfaceHolder, int i3, int i10, int i11) {
        Camera camera = this.f8351a;
        if (camera != null) {
            int i12 = this.f8352b;
            int i13 = this.f8353c;
            Camera.Parameters parameters = camera.getParameters();
            float f2 = i13;
            float f10 = f2 / i12;
            Camera.Size a3 = a(parameters.getSupportedPictureSizes(), f10);
            if (a3 == null) {
                a3 = parameters.getPictureSize();
            }
            int i14 = a3.width;
            int i15 = a3.height;
            parameters.setPictureSize(i14, i15);
            setLayoutParams(new RelativeLayout.LayoutParams((int) ((i15 / i14) * f2), i13));
            Camera.Size a10 = a(parameters.getSupportedPreviewSizes(), f10);
            if (a10 != null) {
                parameters.setPreviewSize(a10.width, a10.height);
            }
            parameters.setJpegQuality(100);
            if (parameters.getSupportedFocusModes().contains("continuous-picture")) {
                parameters.setFocusMode("continuous-picture");
            }
            this.f8351a.setDisplayOrientation(90);
            this.f8351a.setParameters(parameters);
            this.f8351a.startPreview();
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceCreated(SurfaceHolder surfaceHolder) {
        if (getContext().getPackageManager().hasSystemFeature("android.hardware.camera")) {
            Camera camera = this.f8351a;
            if (camera == null) {
                boolean z5 = false;
                if (camera != null) {
                    try {
                        camera.stopPreview();
                        this.f8351a.release();
                        this.f8351a = null;
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                Camera open = Camera.open(0);
                this.f8351a = open;
                if (open != null) {
                    z5 = true;
                }
                this.f8354d = z5;
            }
            if (this.f8354d) {
                this.f8351a.setDisplayOrientation(90);
                try {
                    this.f8351a.setPreviewDisplay(surfaceHolder);
                } catch (IOException e10) {
                    e10.printStackTrace();
                }
            }
        }
    }

    @Override // android.view.SurfaceHolder.Callback
    public final void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        Camera camera = this.f8351a;
        if (camera != null) {
            camera.stopPreview();
            this.f8351a.release();
            this.f8351a = null;
        }
    }
}
