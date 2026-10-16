package com.amap.api.col.p0003sl;

import android.animation.Animator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.location.Location;
import android.os.RemoteException;
import com.amap.api.maps.model.BitmapDescriptorFactory;
import com.amap.api.maps.model.Circle;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MyLocationStyle;
import com.autonavi.amap.mapcore.AbstractCameraUpdateMessage;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* loaded from: classes.dex */
public class m3 {

    /* renamed from: a, reason: collision with root package name */
    private IAMapDelegate f4532a;

    /* renamed from: b, reason: collision with root package name */
    private Marker f4533b;

    /* renamed from: c, reason: collision with root package name */
    private Circle f4534c;
    private LatLng e;

    /* renamed from: f, reason: collision with root package name */
    private double f4536f;

    /* renamed from: g, reason: collision with root package name */
    private Context f4537g;

    /* renamed from: h, reason: collision with root package name */
    private f1 f4538h;

    /* renamed from: q, reason: collision with root package name */
    ValueAnimator f4547q;

    /* renamed from: d, reason: collision with root package name */
    private MyLocationStyle f4535d = new MyLocationStyle();

    /* renamed from: i, reason: collision with root package name */
    private int f4539i = 4;

    /* renamed from: j, reason: collision with root package name */
    private boolean f4540j = false;

    /* renamed from: k, reason: collision with root package name */
    private boolean f4541k = false;

    /* renamed from: l, reason: collision with root package name */
    private boolean f4542l = false;

    /* renamed from: m, reason: collision with root package name */
    private boolean f4543m = false;

    /* renamed from: n, reason: collision with root package name */
    private boolean f4544n = false;

    /* renamed from: o, reason: collision with root package name */
    private boolean f4545o = false;

    /* renamed from: p, reason: collision with root package name */
    c f4546p = null;
    Animator.AnimatorListener r = new a();

    /* renamed from: s, reason: collision with root package name */
    ValueAnimator.AnimatorUpdateListener f4548s = new b();

    public class a implements Animator.AnimatorListener {
        public a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            m3.this.e();
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            try {
                if (m3.this.f4534c != null) {
                    LatLng latLng = (LatLng) valueAnimator.getAnimatedValue();
                    m3.this.f4534c.setCenter(latLng);
                    m3.this.f4533b.setPosition(latLng);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public static class c implements TypeEvaluator {
        @Override // android.animation.TypeEvaluator
        public Object evaluate(float f2, Object obj, Object obj2) {
            LatLng latLng = (LatLng) obj;
            LatLng latLng2 = (LatLng) obj2;
            double d5 = latLng.latitude;
            double d8 = f2;
            double d10 = ((latLng2.latitude - d5) * d8) + d5;
            double d11 = latLng.longitude;
            return new LatLng(d10, ((latLng2.longitude - d11) * d8) + d11);
        }
    }

    public m3(IAMapDelegate iAMapDelegate, Context context) {
        Context applicationContext = context.getApplicationContext();
        this.f4537g = applicationContext;
        this.f4532a = iAMapDelegate;
        this.f4538h = new f1(applicationContext, iAMapDelegate);
        a(4, true);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e() {
        if (this.e != null && this.f4541k) {
            if (this.f4542l && this.f4540j) {
                return;
            }
            this.f4540j = true;
            try {
                IPoint obtain = IPoint.obtain();
                LatLng latLng = this.e;
                GLMapState.lonlat2Geo(latLng.longitude, latLng.latitude, obtain);
                this.f4532a.animateCamera(x.a(obtain));
            } catch (Throwable th2) {
                ka.a(th2, "MyLocationOverlay", "moveMapToLocation");
                th2.printStackTrace();
            }
        }
    }

    private void i() {
        MyLocationStyle myLocationStyle = this.f4535d;
        if (myLocationStyle == null) {
            MyLocationStyle myLocationStyle2 = new MyLocationStyle();
            this.f4535d = myLocationStyle2;
            myLocationStyle2.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
            a();
            return;
        }
        if (myLocationStyle.getMyLocationIcon() == null || this.f4535d.getMyLocationIcon().getBitmap() == null) {
            this.f4535d.myLocationIcon(BitmapDescriptorFactory.fromAsset("location_map_gps_locked.png"));
        }
        a();
    }

    public MyLocationStyle d() {
        return this.f4535d;
    }

    public void f() {
        f1 f1Var;
        if (this.f4539i != 3 || (f1Var = this.f4538h) == null) {
            return;
        }
        f1Var.b();
    }

    public void g() throws RemoteException {
        Circle circle = this.f4534c;
        if (circle != null) {
            try {
                this.f4532a.removeGLOverlay(circle.getId());
            } catch (Throwable th2) {
                ka.a(th2, "MyLocationOverlay", "locationIconRemove");
                th2.printStackTrace();
            }
            this.f4534c = null;
        }
        Marker marker = this.f4533b;
        if (marker != null) {
            marker.remove();
            this.f4533b = null;
            this.f4538h.a((Marker) null);
        }
        f1 f1Var = this.f4538h;
        if (f1Var != null) {
            f1Var.c();
            this.f4538h = null;
        }
    }

    public void h() {
        this.f4534c = null;
        this.f4533b = null;
    }

    public void a(int i3) {
        this.f4538h.a(i3);
    }

    public void b(float f2) {
        Marker marker = this.f4533b;
        if (marker != null) {
            marker.setRotateAngle(f2);
        }
    }

    public String c() {
        Marker marker = this.f4533b;
        if (marker != null) {
            return marker.getId();
        }
        return null;
    }

    public void a(MyLocationStyle myLocationStyle) {
        try {
            this.f4535d = myLocationStyle;
            a(myLocationStyle.isMyLocationShowing());
            if (!this.f4535d.isMyLocationShowing()) {
                this.f4538h.a(false);
                this.f4539i = this.f4535d.getMyLocationType();
                return;
            }
            i();
            Marker marker = this.f4533b;
            if (marker == null && this.f4534c == null) {
                return;
            }
            this.f4538h.a(marker);
            a(this.f4535d.getMyLocationType(), false);
        } catch (Throwable th2) {
            ka.a(th2, "MyLocationOverlay", "setMyLocationStyle");
            th2.printStackTrace();
        }
    }

    public String b() throws RemoteException {
        Circle circle = this.f4534c;
        if (circle != null) {
            return circle.getId();
        }
        return null;
    }

    private void a(int i3, boolean z5) {
        this.f4539i = i3;
        this.f4540j = false;
        this.f4542l = false;
        this.f4541k = false;
        this.f4544n = false;
        this.f4545o = false;
        if (i3 == 1) {
            this.f4541k = true;
            this.f4542l = true;
            this.f4543m = true;
        } else if (i3 == 2) {
            this.f4541k = true;
            this.f4543m = true;
        } else if (i3 == 3) {
            this.f4541k = true;
            this.f4545o = true;
        } else if (i3 == 4) {
            this.f4541k = true;
            this.f4544n = true;
            this.f4543m = false;
        } else if (i3 == 5) {
            this.f4544n = true;
            this.f4543m = false;
        } else if (i3 == 7) {
            this.f4545o = true;
        }
        if (!this.f4544n && !this.f4545o) {
            Marker marker = this.f4533b;
            if (marker != null) {
                marker.setFlat(false);
            }
            IAMapDelegate iAMapDelegate = this.f4532a;
            if (iAMapDelegate != null) {
                try {
                    iAMapDelegate.moveCamera(x.a(0.0f));
                } catch (Throwable th2) {
                    th2.printStackTrace();
                }
            }
            a(0.0f);
            this.f4538h.c();
            return;
        }
        if (this.f4545o) {
            this.f4538h.a(true);
            if (!z5) {
                try {
                    IAMapDelegate iAMapDelegate2 = this.f4532a;
                    j1 j1Var = new j1();
                    j1Var.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
                    j1Var.zoom = 17.0f;
                    iAMapDelegate2.moveCamera(j1Var);
                } catch (Throwable th3) {
                    th3.printStackTrace();
                }
            }
            a(45.0f);
        } else {
            this.f4538h.a(false);
        }
        this.f4538h.b();
        Marker marker2 = this.f4533b;
        if (marker2 != null) {
            marker2.setFlat(true);
        }
    }

    private void a(float f2) {
        IAMapDelegate iAMapDelegate = this.f4532a;
        if (iAMapDelegate == null) {
            return;
        }
        try {
            j1 j1Var = new j1();
            j1Var.nowType = AbstractCameraUpdateMessage.Type.newCameraPosition;
            j1Var.tilt = f2;
            iAMapDelegate.moveCamera(j1Var);
        } catch (Throwable th2) {
            th2.printStackTrace();
        }
    }

    public void a(Location location) {
        a(this.f4535d.isMyLocationShowing());
        if (this.f4535d.isMyLocationShowing()) {
            this.e = new LatLng(location.getLatitude(), location.getLongitude());
            this.f4536f = location.getAccuracy();
            if (this.f4533b == null && this.f4534c == null) {
                i();
            }
            Circle circle = this.f4534c;
            if (circle != null) {
                try {
                    double d5 = this.f4536f;
                    if (d5 != -1.0d) {
                        circle.setRadius(d5);
                    }
                } catch (Throwable th2) {
                    ka.a(th2, "MyLocationOverlay", "setCentAndRadius");
                    th2.printStackTrace();
                }
            }
            float bearing = location.getBearing();
            if (this.f4543m) {
                float f2 = bearing % 360.0f;
                if (f2 > 180.0f) {
                    f2 -= 360.0f;
                } else if (f2 < -180.0f) {
                    f2 += 360.0f;
                }
                Marker marker = this.f4533b;
                if (marker != null) {
                    marker.setRotateAngle(-f2);
                }
            }
            if (!this.e.equals(this.f4533b.getPosition())) {
                LatLng latLng = this.e;
                LatLng position = this.f4533b.getPosition();
                if (position == null) {
                    position = new LatLng(0.0d, 0.0d);
                }
                if (this.f4546p == null) {
                    this.f4546p = new c();
                }
                ValueAnimator valueAnimator = this.f4547q;
                if (valueAnimator == null) {
                    ValueAnimator ofObject = ValueAnimator.ofObject(new c(), position, latLng);
                    this.f4547q = ofObject;
                    ofObject.addListener(this.r);
                    this.f4547q.addUpdateListener(this.f4548s);
                } else {
                    valueAnimator.setObjectValues(position, latLng);
                    this.f4547q.setEvaluator(this.f4546p);
                }
                if (position.latitude == 0.0d && position.longitude == 0.0d) {
                    this.f4547q.setDuration(1L);
                } else {
                    this.f4547q.setDuration(1000L);
                }
                this.f4547q.start();
                return;
            }
            e();
        }
    }

    public void a(boolean z5) {
        Circle circle = this.f4534c;
        if (circle != null && circle.isVisible() != z5) {
            this.f4534c.setVisible(z5);
        }
        Marker marker = this.f4533b;
        if (marker == null || marker.isVisible() == z5) {
            return;
        }
        this.f4533b.setVisible(z5);
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x0125 A[Catch: all -> 0x0018, TryCatch #0 {all -> 0x0018, blocks: (B:2:0x0000, B:4:0x0004, B:5:0x001b, B:7:0x0020, B:9:0x002e, B:10:0x0039, B:12:0x0047, B:13:0x0052, B:15:0x0060, B:16:0x006b, B:18:0x006f, B:19:0x0074, B:20:0x008c, B:22:0x0091, B:23:0x00a2, B:25:0x00a6, B:27:0x00b4, B:29:0x00d5, B:31:0x00dd, B:34:0x00ea, B:36:0x00f2, B:38:0x010a, B:39:0x0121, B:41:0x0125, B:42:0x012f, B:43:0x0116, B:44:0x00c4, B:45:0x013b), top: B:1:0x0000 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private void a() {
        /*
            Method dump skipped, instructions count: 337
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.col.p0003sl.m3.a():void");
    }
}
