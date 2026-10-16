package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* loaded from: classes.dex */
public class d5 extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    Bitmap f3892a;

    /* renamed from: b, reason: collision with root package name */
    Bitmap f3893b;

    /* renamed from: c, reason: collision with root package name */
    Bitmap f3894c;

    /* renamed from: d, reason: collision with root package name */
    ImageView f3895d;
    IAMapDelegate e;

    /* renamed from: f, reason: collision with root package name */
    Matrix f3896f;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
            } catch (Throwable th2) {
                ka.a(th2, "CompassView", "onTouch");
                th2.printStackTrace();
            }
            if (!d5.this.e.isMaploaded()) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                d5 d5Var = d5.this;
                d5Var.f3895d.setImageBitmap(d5Var.f3893b);
            } else if (motionEvent.getAction() == 1) {
                d5 d5Var2 = d5.this;
                d5Var2.f3895d.setImageBitmap(d5Var2.f3892a);
                CameraPosition cameraPosition = d5.this.e.getCameraPosition();
                d5.this.e.animateCamera(x.a(new CameraPosition(cameraPosition.target, cameraPosition.zoom, 0.0f, 0.0f)));
            }
            return false;
        }
    }

    public d5(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f3896f = new Matrix();
        this.e = iAMapDelegate;
        try {
            Bitmap a3 = v4.a(context, "maps_dav_compass_needle_large.png");
            this.f3894c = a3;
            this.f3893b = v4.a(a3, v0.f5167b * 0.8f);
            Bitmap a10 = v4.a(this.f3894c, v0.f5167b * 0.7f);
            this.f3894c = a10;
            Bitmap bitmap = this.f3893b;
            if (bitmap != null && a10 != null) {
                this.f3892a = Bitmap.createBitmap(bitmap.getWidth(), this.f3893b.getHeight(), Bitmap.Config.ARGB_8888);
                Canvas canvas = new Canvas(this.f3892a);
                Paint paint = new Paint();
                paint.setAntiAlias(true);
                paint.setFilterBitmap(true);
                canvas.drawBitmap(this.f3894c, (this.f3893b.getWidth() - this.f3894c.getWidth()) / 2.0f, (this.f3893b.getHeight() - this.f3894c.getHeight()) / 2.0f, paint);
                ImageView imageView = new ImageView(context);
                this.f3895d = imageView;
                imageView.setScaleType(ImageView.ScaleType.MATRIX);
                this.f3895d.setImageBitmap(this.f3892a);
                this.f3895d.setClickable(true);
                a();
                this.f3895d.setOnTouchListener(new a());
                addView(this.f3895d);
            }
        } catch (Throwable th2) {
            ka.a(th2, "CompassView", "create");
            th2.printStackTrace();
        }
    }

    public void a() {
        try {
            IAMapDelegate iAMapDelegate = this.e;
            if (iAMapDelegate == null || this.f3895d == null) {
                return;
            }
            int engineIDWithType = iAMapDelegate.getGLMapEngine() != null ? this.e.getGLMapEngine().getEngineIDWithType(1) : 0;
            float cameraDegree = this.e.getCameraDegree(engineIDWithType);
            float mapAngle = this.e.getMapAngle(engineIDWithType);
            if (this.f3896f == null) {
                this.f3896f = new Matrix();
            }
            this.f3896f.reset();
            this.f3896f.postRotate(-mapAngle, this.f3895d.getDrawable().getBounds().width() / 2.0f, this.f3895d.getDrawable().getBounds().height() / 2.0f);
            this.f3896f.postScale(1.0f, (float) Math.cos((cameraDegree * 3.141592653589793d) / 180.0d), this.f3895d.getDrawable().getBounds().width() / 2.0f, this.f3895d.getDrawable().getBounds().height() / 2.0f);
            this.f3895d.setImageMatrix(this.f3896f);
        } catch (Throwable th2) {
            ka.a(th2, "CompassView", "invalidateAngle");
            th2.printStackTrace();
        }
    }
}
