package com.amap.api.col.p0003sl;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* loaded from: classes.dex */
class m5 extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    private Bitmap f4555a;

    /* renamed from: b, reason: collision with root package name */
    private Bitmap f4556b;

    /* renamed from: c, reason: collision with root package name */
    private Bitmap f4557c;

    /* renamed from: d, reason: collision with root package name */
    private Bitmap f4558d;
    private Bitmap e;

    /* renamed from: f, reason: collision with root package name */
    private Bitmap f4559f;

    /* renamed from: g, reason: collision with root package name */
    private Bitmap f4560g;

    /* renamed from: h, reason: collision with root package name */
    private Bitmap f4561h;

    /* renamed from: i, reason: collision with root package name */
    private Bitmap f4562i;

    /* renamed from: j, reason: collision with root package name */
    private Bitmap f4563j;

    /* renamed from: k, reason: collision with root package name */
    private Bitmap f4564k;

    /* renamed from: l, reason: collision with root package name */
    private Bitmap f4565l;

    /* renamed from: m, reason: collision with root package name */
    private ImageView f4566m;

    /* renamed from: n, reason: collision with root package name */
    private ImageView f4567n;

    /* renamed from: o, reason: collision with root package name */
    private IAMapDelegate f4568o;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
            if (m5.this.f4568o.getZoomLevel() < m5.this.f4568o.getMaxZoomLevel() && m5.this.f4568o.isMaploaded()) {
                if (motionEvent.getAction() == 0) {
                    m5.this.f4566m.setImageBitmap(m5.this.e);
                } else if (motionEvent.getAction() == 1) {
                    m5.this.f4566m.setImageBitmap(m5.this.f4555a);
                    try {
                        IAMapDelegate iAMapDelegate = m5.this.f4568o;
                        l1 l1Var = new l1();
                        l1Var.nowType = AbstractCameraUpdateMessage.Type.zoomBy;
                        l1Var.amount = 1.0f;
                        iAMapDelegate.animateCamera(l1Var);
                    } catch (RemoteException e) {
                        ka.a(e, "ZoomControllerView", "zoomin ontouch");
                        e.printStackTrace();
                    }
                }
                return false;
            }
            return false;
        }
    }

    public class b implements View.OnTouchListener {
        public b() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            try {
            } catch (Throwable th2) {
                ka.a(th2, "ZoomControllerView", "zoomout ontouch");
                th2.printStackTrace();
            }
            if (m5.this.f4568o.getZoomLevel() > m5.this.f4568o.getMinZoomLevel() && m5.this.f4568o.isMaploaded()) {
                if (motionEvent.getAction() == 0) {
                    m5.this.f4567n.setImageBitmap(m5.this.f4559f);
                } else if (motionEvent.getAction() == 1) {
                    m5.this.f4567n.setImageBitmap(m5.this.f4557c);
                    m5.this.f4568o.animateCamera(x.a());
                }
                return false;
            }
            return false;
        }
    }

    public m5(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f4568o = iAMapDelegate;
        try {
            Bitmap a3 = v4.a(context, "zoomin_selected.png");
            this.f4560g = a3;
            this.f4555a = v4.a(a3, v0.f5167b);
            Bitmap a10 = v4.a(context, "zoomin_unselected.png");
            this.f4561h = a10;
            this.f4556b = v4.a(a10, v0.f5167b);
            Bitmap a11 = v4.a(context, "zoomout_selected.png");
            this.f4562i = a11;
            this.f4557c = v4.a(a11, v0.f5167b);
            Bitmap a12 = v4.a(context, "zoomout_unselected.png");
            this.f4563j = a12;
            this.f4558d = v4.a(a12, v0.f5167b);
            Bitmap a13 = v4.a(context, "zoomin_pressed.png");
            this.f4564k = a13;
            this.e = v4.a(a13, v0.f5167b);
            Bitmap a14 = v4.a(context, "zoomout_pressed.png");
            this.f4565l = a14;
            this.f4559f = v4.a(a14, v0.f5167b);
            ImageView imageView = new ImageView(context);
            this.f4566m = imageView;
            imageView.setImageBitmap(this.f4555a);
            this.f4566m.setClickable(true);
            ImageView imageView2 = new ImageView(context);
            this.f4567n = imageView2;
            imageView2.setImageBitmap(this.f4557c);
            this.f4567n.setClickable(true);
            this.f4566m.setOnTouchListener(new a());
            this.f4567n.setOnTouchListener(new b());
            this.f4566m.setPadding(0, 0, 20, -2);
            this.f4567n.setPadding(0, 0, 20, 20);
            setOrientation(1);
            addView(this.f4566m);
            addView(this.f4567n);
        } catch (Throwable th2) {
            ka.a(th2, "ZoomControllerView", "create");
            th2.printStackTrace();
        }
    }

    public void a() {
        try {
            removeAllViews();
            v4.a(this.f4555a);
            v4.a(this.f4556b);
            v4.a(this.f4557c);
            v4.a(this.f4558d);
            v4.a(this.e);
            v4.a(this.f4559f);
            this.f4555a = null;
            this.f4556b = null;
            this.f4557c = null;
            this.f4558d = null;
            this.e = null;
            this.f4559f = null;
            Bitmap bitmap = this.f4560g;
            if (bitmap != null) {
                v4.a(bitmap);
                this.f4560g = null;
            }
            Bitmap bitmap2 = this.f4561h;
            if (bitmap2 != null) {
                v4.a(bitmap2);
                this.f4561h = null;
            }
            Bitmap bitmap3 = this.f4562i;
            if (bitmap3 != null) {
                v4.a(bitmap3);
                this.f4562i = null;
            }
            Bitmap bitmap4 = this.f4563j;
            if (bitmap4 != null) {
                v4.a(bitmap4);
                this.f4560g = null;
            }
            Bitmap bitmap5 = this.f4564k;
            if (bitmap5 != null) {
                v4.a(bitmap5);
                this.f4564k = null;
            }
            Bitmap bitmap6 = this.f4565l;
            if (bitmap6 != null) {
                v4.a(bitmap6);
                this.f4565l = null;
            }
            this.f4566m = null;
            this.f4567n = null;
        } catch (Throwable th2) {
            ka.a(th2, "ZoomControllerView", "destory");
            th2.printStackTrace();
        }
    }

    public void a(float f2) {
        try {
            if (f2 < this.f4568o.getMaxZoomLevel() && f2 > this.f4568o.getMinZoomLevel()) {
                this.f4566m.setImageBitmap(this.f4555a);
                this.f4567n.setImageBitmap(this.f4557c);
            } else if (f2 == this.f4568o.getMinZoomLevel()) {
                this.f4567n.setImageBitmap(this.f4558d);
                this.f4566m.setImageBitmap(this.f4555a);
            } else if (f2 == this.f4568o.getMaxZoomLevel()) {
                this.f4566m.setImageBitmap(this.f4556b);
                this.f4567n.setImageBitmap(this.f4557c);
            }
        } catch (Throwable th2) {
            ka.a(th2, "ZoomControllerView", "setZoomBitmap");
            th2.printStackTrace();
        }
    }
}
