package com.amap.api.col.p0003sl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.location.Location;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* loaded from: classes.dex */
public class f5 extends LinearLayout {

    /* renamed from: a, reason: collision with root package name */
    Bitmap f4076a;

    /* renamed from: b, reason: collision with root package name */
    Bitmap f4077b;

    /* renamed from: c, reason: collision with root package name */
    Bitmap f4078c;

    /* renamed from: d, reason: collision with root package name */
    Bitmap f4079d;
    Bitmap e;

    /* renamed from: f, reason: collision with root package name */
    Bitmap f4080f;

    /* renamed from: g, reason: collision with root package name */
    ImageView f4081g;

    /* renamed from: h, reason: collision with root package name */
    IAMapDelegate f4082h;

    /* renamed from: i, reason: collision with root package name */
    boolean f4083i;

    public class a implements View.OnTouchListener {
        public a() {
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (!f5.this.f4083i) {
                return false;
            }
            if (motionEvent.getAction() == 0) {
                f5 f5Var = f5.this;
                f5Var.f4081g.setImageBitmap(f5Var.f4077b);
            } else if (motionEvent.getAction() == 1) {
                try {
                    f5 f5Var2 = f5.this;
                    f5Var2.f4081g.setImageBitmap(f5Var2.f4076a);
                    f5.this.f4082h.setMyLocationEnabled(true);
                    Location myLocation = f5.this.f4082h.getMyLocation();
                    if (myLocation == null) {
                        return false;
                    }
                    LatLng latLng = new LatLng(myLocation.getLatitude(), myLocation.getLongitude());
                    f5.this.f4082h.showMyLocationOverlay(myLocation);
                    IAMapDelegate iAMapDelegate = f5.this.f4082h;
                    iAMapDelegate.moveCamera(x.a(CameraPosition.builder().target(latLng).zoom(iAMapDelegate.getZoomLevel()).bearing(Float.NaN).tilt(Float.NaN).build()));
                } catch (Throwable th2) {
                    ka.a(th2, "LocationView", "onTouch");
                    th2.printStackTrace();
                }
            }
            return false;
        }
    }

    @SuppressLint({"ClickableViewAccessibility"})
    public f5(Context context, IAMapDelegate iAMapDelegate) {
        super(context);
        this.f4083i = false;
        this.f4082h = iAMapDelegate;
        try {
            Bitmap a3 = v4.a(context, "location_selected.png");
            this.f4079d = a3;
            this.f4076a = v4.a(a3, v0.f5167b);
            Bitmap a10 = v4.a(context, "location_pressed.png");
            this.e = a10;
            this.f4077b = v4.a(a10, v0.f5167b);
            Bitmap a11 = v4.a(context, "location_unselected.png");
            this.f4080f = a11;
            this.f4078c = v4.a(a11, v0.f5167b);
            ImageView imageView = new ImageView(context);
            this.f4081g = imageView;
            imageView.setImageBitmap(this.f4076a);
            this.f4081g.setClickable(true);
            this.f4081g.setPadding(0, 20, 20, 0);
            this.f4081g.setOnTouchListener(new a());
            addView(this.f4081g);
        } catch (Throwable th2) {
            ka.a(th2, "LocationView", "create");
            th2.printStackTrace();
        }
    }
}
